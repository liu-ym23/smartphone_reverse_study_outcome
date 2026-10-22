package com.ss.android.vesdk;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes40.dex */
class TECryptStream extends InputStream {
    private long cryptor;
    private FileInputStream fileInputStream;
    private long fileSize;
    private int pos;

    private static native long nativeCreateCryptor(String r100);

    private static native int nativeDecrypt(long r100, byte[] r101, int r102, long r103);

    private static native void nativeDestroyCryptor(long r100);

    private static native int nativeGetBdveTagSize(long r100, long r101);

    private static native int nativeMatch(long r100, byte[] r101, int r102);

    @Override // java.io.InputStream
    public int available() throws IOException {
        return (int) (this.fileSize - ((long) this.pos));
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        FileInputStream r100 = this.fileInputStream;
        if (r100 == null) goto L5;
        r100.close();
    L5:
        long r101 = this.cryptor;
        if (r101 == 0) goto L8;
        nativeDestroyCryptor(r101);
    L8:
        this.cryptor = 0;
        this.pos = 0;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if ((this.pos + 1) < this.fileSize) goto L5;
        return -1;
    L5:
        int r100 = this.fileInputStream.read();
        long r101 = this.cryptor;
        if (r101 == 0) goto L10;
        if (r100 == (-1)) goto L10;
        byte[] r102 = {(byte) r100};
        nativeDecrypt(r101, r102, 1, this.pos);
        this.pos++;
        return r102[0];
    L10:
        return r100;
    }

    @Override // java.io.InputStream
    public int read(byte[] r100) throws IOException {
        return read(r100, 0, r100.length);
    }

    public TECryptStream(String r100, String r101) throws IOException, TECryptException {
        this.cryptor = 0;
        this.pos = 0;
        this.fileSize = 0;
        init(new RandomAccessFile(r100, "r").getFD(), r101);
    }

    private void init(FileDescriptor r100, String r110) throws IOException, TECryptException {
        PolarisFileInputStreamWrapper r101 = new PolarisFileInputStreamWrapper(r100);
        this.fileInputStream = r101;
        this.fileSize = r101.available();
        long r102 = nativeCreateCryptor(r110);
        this.cryptor = r102;
        if (r102 <= 0) goto L11;
        int r103 = nativeGetBdveTagSize(r102, this.fileSize);
        if (r103 <= 0) goto L12;
        FileChannel r111 = this.fileInputStream.getChannel();
        long r104 = r111.position();
        long r105 = r103;
        r111.position(this.fileSize - r105);
        ByteBuffer r106 = ByteBuffer.allocate(r103);
        r111.read(r106);
        if (nativeMatch(this.cryptor, r106.array(), r103) != 0) goto L9;
        r111.position(r104);
        this.fileSize -= r105;
        return;
    L9:
        close();
        throw new TECryptException("Crypt not match!!!");
    L12:
        return;
    }

    public TECryptStream(FileDescriptor r100, String r101) throws IOException, TECryptException {
        this.cryptor = 0;
        this.pos = 0;
        this.fileSize = 0;
        init(r100, r101);
    }

    @Override // java.io.InputStream
    public int read(byte[] r100, int r101, int r110) throws IOException {
        int r102 = this.pos;
        long r103 = r102 + r110;
        long r104 = this.fileSize;
        if (r103 < r104) goto L8;
        r110 = (int) (r104 - ((long) r102));
        if (r110 > 0) goto L8;
        return -1;
    L8:
        int r105 = this.fileInputStream.read(r100, r101, r110);
        if (r105 <= 0) goto L14;
        int r106 = this.pos;
        this.pos = r106 + r105;
        long r107 = this.cryptor;
        if (r107 != 0) goto L13;
        return r105;
    L13:
        return nativeDecrypt(r107, r100, r105, r106);
    L14:
        return r105;
    }
}
