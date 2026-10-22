package com.facebook.battery.metrics.cpu;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes22.dex */
class ProcFileReader {
    private final byte[] mBuffer;
    private int mBufferSize;
    private char mChar;
    private RandomAccessFile mFile;
    private boolean mIsValid;
    private final String mPath;
    private int mPosition;
    private char mPrev;
    private boolean mRewound;

    public static class ParseException extends RuntimeException {
        public ParseException(String r100) {
            super(r100);
        }
    }

    public ProcFileReader reset() {
        this.mIsValid = true;
        RandomAccessFile r100 = this.mFile;
        if (r100 == null) goto L9;
        r100.seek(0);     // Catch: IOException -> L7
    L7:
        close();
    L9:
        if (this.mFile != null) goto L14;
        this.mFile = new RandomAccessFile(this.mPath, "r");     // Catch: IOException -> L12
    L12:
        this.mIsValid = false;
        close();
    L14:
        if (this.mIsValid == false) goto L16;
        this.mPosition = -1;
        this.mBufferSize = 0;
        this.mChar = 0;
        this.mPrev = 0;
        this.mRewound = false;
    L16:
        return this;
    }

    private void rewind() {
        if (this.mRewound == true) goto L7;
        this.mPosition--;
        this.mChar = this.mPrev;
        this.mRewound = true;
        return;
    L7:
        throw new ParseException("Can only rewind one step!");
    }

    public void close() {
        RandomAccessFile r100 = this.mFile;
        if (r100 != null) goto L13;
        return;
    L13:
        r100.close();     // Catch: Throwable -> L7 IOException -> L12
    L7:
        th = move-exception;
        this.mFile = null;
        throw th;
    L10:
        this.mFile = null;
    }

    public boolean hasNext() {
        if (this.mIsValid == false) goto L17;
        RandomAccessFile r100 = this.mFile;
        if (r100 == null) goto L17;
        int r101 = this.mPosition;
        int r102 = this.mBufferSize;
        if (r101 > (r102 - 1)) goto L17;
        if (r101 >= (r102 - 1)) goto L18;
        return true;
    L18:
        this.mBufferSize = r100.read(this.mBuffer);     // Catch: IOException -> L14
        this.mPosition = -1;     // Catch: IOException -> L14
    L16:
        return hasNext();
    L14:
        this.mIsValid = false;
        close();
    L17:
        return false;
    }

    public boolean hasReachedEOF() {
        if (this.mBufferSize != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public long readNumber() {
        long r100 = 0;
        boolean r101 = true;
    L4:
        if (hasNext() == false) goto L12;
        next();
        if (Character.isDigit(this.mChar) == false) goto L8;
        r100 = (r100 * 10) + ((long) (this.mChar - '0'));
        r101 = false;
        goto L4
    L8:
        if (r101 == true) goto L11;
        rewind();
        goto L12
    L11:
        throw new ParseException("Couldn't read number!");
    L12:
        return r100;
    }

    public void skipLines() {
        skipPast('\n');
    }

    public void skipSpaces() {
        skipPast(' ');
    }

    private void next() {
        if (hasNext() == false) goto L7;
        int r100 = this.mPosition + 1;
        this.mPosition = r100;
        this.mPrev = this.mChar;
        this.mChar = (char) this.mBuffer[r100];
        this.mRewound = false;
        return;
    L7:
        throw new NoSuchElementException();
    }

    public ProcFileReader start() {
        return reset();
    }

    public boolean isValid() {
        return this.mIsValid;
    }

    public ProcFileReader(String r100) {
        this(r100, 512);
    }

    public void skipPast(char r100) {
        boolean r101 = false;
    L4:
        if (hasNext() == false) goto L18;
        next();
        if (this.mChar == r100) goto L7;
        if (r101 == false) goto L4;
        rewind();
        return;
    L7:
        r101 = true;
        goto L4
    }

    public ProcFileReader(String r100, int r101) {
        this.mPosition = -1;
        this.mIsValid = true;
        this.mRewound = false;
        this.mPath = r100;
        this.mBuffer = new byte[r101];
    }
}
