package com.facebook.soloader;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes23.dex */
public class ElfFileChannel implements ElfByteChannel {
    private FileChannel mFc;
    private File mFile;
    private FileInputStream mIs;

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mIs.close();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.mFc.isOpen();
    }

    public void openChannel() throws IOException {
        PolarisFileInputStreamWrapper r100 = new PolarisFileInputStreamWrapper(this.mFile);
        this.mIs = r100;
        this.mFc = r100.getChannel();
    }

    @Override // com.facebook.soloader.ElfByteChannel
    public long position() throws IOException {
        return this.mFc.position();
    }

    @Override // com.facebook.soloader.ElfByteChannel
    public long size() throws IOException {
        return this.mFc.size();
    }

    public ElfFileChannel(File r100) throws IOException {
        this.mFile = r100;
        openChannel();
    }

    @Override // com.facebook.soloader.ElfByteChannel
    public ElfByteChannel position(long r100) throws IOException {
        this.mFc.position(r100);
        return this;
    }

    @Override // com.facebook.soloader.ElfByteChannel, java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer r100) throws IOException {
        return this.mFc.read(r100);
    }

    @Override // com.facebook.soloader.ElfByteChannel
    public ElfByteChannel truncate(long r100) throws IOException {
        this.mFc.truncate(r100);
        return this;
    }

    @Override // com.facebook.soloader.ElfByteChannel, java.nio.channels.WritableByteChannel
    public int write(ByteBuffer r100) throws IOException {
        return this.mFc.write(r100);
    }

    @Override // com.facebook.soloader.ElfByteChannel
    public int read(ByteBuffer r100, long r101) throws IOException {
        return this.mFc.read(r100, r101);
    }
}
