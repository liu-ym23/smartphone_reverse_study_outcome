package com.facebook.soloader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class ElfZipFileChannel implements ElfByteChannel {

    @Nullable
    private InputStream mIs;
    private final long mLength;
    private boolean mOpened;
    private long mPos;
    private final ZipEntry mZipEntry;
    private final ZipFile mZipFile;

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream r100 = this.mIs;
        if (r100 == null) goto L6;
        r100.close();
        this.mOpened = false;
        return;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.mOpened;
    }

    @Override // com.facebook.soloader.ElfByteChannel
    public long position() throws IOException {
        return this.mPos;
    }

    @Override // com.facebook.soloader.ElfByteChannel
    public long size() throws IOException {
        return this.mLength;
    }

    @Override // com.facebook.soloader.ElfByteChannel
    public ElfByteChannel position(long r100) throws IOException {
        InputStream r101 = this.mIs;
        if (r101 == null) goto L21;
        long r102 = this.mPos;
        if (r100 != r102) goto L7;
        return this;
    L7:
        long r103 = this.mLength;
        if (r100 <= r103) goto L11;
        r100 = r103;
    L11:
        if (r100 < r102) goto L13;
        r101.skip(r100 - r102);
    L16:
        this.mPos = r100;
        return this;
    L13:
        r101.close();
        InputStream r104 = this.mZipFile.getInputStream(this.mZipEntry);
        this.mIs = r104;
        if (r104 == null) goto L19;
        r104.skip(r100);
        goto L16
    L19:
        throw new IOException(this.mZipEntry.getName() + "'s InputStream is null");
    L21:
        throw new IOException(this.mZipEntry.getName() + "'s InputStream is null");
    }

    @Override // com.facebook.soloader.ElfByteChannel, java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer r100) throws IOException {
        return read(r100, this.mPos);
    }

    @Override // com.facebook.soloader.ElfByteChannel
    public ElfByteChannel truncate(long r100) throws IOException {
        throw new UnsupportedOperationException("ElfZipFileChannel doesn't support truncate");
    }

    @Override // com.facebook.soloader.ElfByteChannel, java.nio.channels.WritableByteChannel
    public int write(ByteBuffer r100) throws IOException {
        throw new UnsupportedOperationException("ElfZipFileChannel doesn't support write");
    }

    public ElfZipFileChannel(ZipFile r100, ZipEntry r101) throws IOException {
        this.mZipFile = r100;
        this.mZipEntry = r101;
        this.mOpened = true;
        this.mPos = 0;
        this.mLength = r101.getSize();
        InputStream r102 = r100.getInputStream(r101);
        this.mIs = r102;
        if (r102 == null) goto L6;
        return;
    L6:
        throw new IOException(r101.getName() + "'s InputStream is null");
    }

    @Override // com.facebook.soloader.ElfByteChannel
    public int read(ByteBuffer r100, long r101) throws IOException {
        if (this.mIs == null) goto L18;
        int r102 = r100.remaining();
        long r103 = this.mLength - r101;
        if (r103 > 0) goto L8;
        return -1;
    L8:
        int r104 = (int) r103;
        if (r102 <= r104) goto L11;
        r102 = r104;
    L11:
        position(r101);
        if (r100.hasArray() == false) goto L14;
        this.mIs.read(r100.array(), 0, r102);
        r100.position(r100.position() + r102);
    L15:
        this.mPos += (long) r102;
        return r102;
    L14:
        byte[] r105 = new byte[r102];
        this.mIs.read(r105, 0, r102);
        r100.put(r105, 0, r102);
        goto L15
    L18:
        throw new IOException("InputStream is null");
    }
}
