package com.ss.android.socialbase.downloader.utils;

import com.ss.android.socialbase.downloader.md5.IRandomAccess;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes38.dex */
public class DownloadFileRandomAccess implements IRandomAccess {
    private static final int BUFFER_SIZE = 8192;
    private final FileChannel accessFile;
    private final ByteBuffer byteBuffer;
    private final FileInputStream inputStream;

    @Override // com.ss.android.socialbase.downloader.md5.IRandomAccess
    public void close() throws IOException {
        DownloadUtils.safeClose(new Closeable[]{this.accessFile, this.inputStream});
    }

    @Override // com.ss.android.socialbase.downloader.md5.IRandomAccess
    public long length() throws IOException {
        return this.accessFile.size();
    }

    public DownloadFileRandomAccess(FileInputStream r100) throws FileNotFoundException {
        this.inputStream = r100;
        this.accessFile = r100.getChannel();
        this.byteBuffer = ByteBuffer.allocate(8192);
    }

    @Override // com.ss.android.socialbase.downloader.md5.IRandomAccess
    public void seek(long r100, long r101) throws IOException {
        this.accessFile.position(r100);
    }

    @Override // com.ss.android.socialbase.downloader.md5.IRandomAccess
    public int read(byte[] r100, int r101, int r102) throws IOException {
        int r103 = this.accessFile.read(this.byteBuffer);
        if (r103 == (-1)) goto L5;
        this.byteBuffer.flip();
        this.byteBuffer.get(r100, 0, r103);
        this.byteBuffer.clear();
    L5:
        return r103;
    }
}
