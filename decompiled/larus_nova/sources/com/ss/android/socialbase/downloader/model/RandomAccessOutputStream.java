package com.ss.android.socialbase.downloader.model;

import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes38.dex */
public class RandomAccessOutputStream implements Closeable {
    private static final int MAX_FLUSH_BUFFER_SIZE = 131072;
    private static final int MIN_FLUSH_BUFFER_SIZE = 8192;
    private RandomOutputStream randomAccess;

    public class BufferRandomAccessOutputStream implements RandomOutputStream {

        /* JADX INFO: renamed from: fd, reason: collision with root package name */
        private FileDescriptor f449583fd;
        private BufferedOutputStream outputStream;
        private RandomAccessFile randomAccess;
        final /* synthetic */ RandomAccessOutputStream this$0;

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void close() throws IOException {
            DownloadUtils.safeClose(new Closeable[]{this.outputStream, this.randomAccess});
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void flush() throws IOException {
            BufferedOutputStream r100 = this.outputStream;
            if (r100 == null) goto L6;
            r100.flush();
            return;
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void flushAndSync() throws IOException {
            BufferedOutputStream r100 = this.outputStream;
            if (r100 == null) goto L5;
            r100.flush();
        L5:
            FileDescriptor r101 = this.f449583fd;
            if (r101 == null) goto L9;
            r101.sync();
            return;
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void sync() throws IOException {
            FileDescriptor r100 = this.f449583fd;
            if (r100 == null) goto L6;
            r100.sync();
            return;
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void seek(long r100) throws IOException {
            this.randomAccess.seek(r100);
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void setLength(long r100) throws IOException {
            this.randomAccess.setLength(r100);
        }

        public BufferRandomAccessOutputStream(RandomAccessOutputStream r100, File r101, int r102) throws BaseException {
            this.this$0 = r100;
            RandomAccessFile r103 = new RandomAccessFile(r101, "rw");     // Catch: IOException -> L14
            this.randomAccess = r103;     // Catch: IOException -> L14
            this.f449583fd = r103.getFD();     // Catch: IOException -> L14
            if (r102 > 0) goto L6;
            this.outputStream = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(this.randomAccess.getFD()));     // Catch: IOException -> L14
            return;
        L6:
            if (r102 >= 8192) goto L9;
            r102 = 8192;
        L11:
            this.outputStream = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(this.randomAccess.getFD()), r102);     // Catch: IOException -> L14
            return;
        L9:
            if (r102 <= 131072) goto L11;
            r102 = 131072;
        L14:
            e = move-exception;
            throw new BaseException(1039, e);
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void write(byte[] r100, int r101, int r102) throws IOException {
            this.outputStream.write(r100, r101, r102);
        }
    }

    public class ChannelRandomAccessOutputStream implements RandomOutputStream {
        private ByteBuffer byteBuffer;
        private FileChannel fileChannel;
        private RandomAccessFile randomAccess;
        final /* synthetic */ RandomAccessOutputStream this$0;

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void close() throws IOException {
            DownloadUtils.safeClose(new Closeable[]{this.fileChannel, this.randomAccess});
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void sync() throws IOException {
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void flush() throws IOException {
            this.fileChannel.force(true);
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void flushAndSync() throws IOException {
            flush();
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void seek(long r100) throws IOException {
            this.fileChannel.position(r100);
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void setLength(long r100) throws IOException {
            this.randomAccess.setLength(r100);
        }

        public ChannelRandomAccessOutputStream(RandomAccessOutputStream r100, File r101) throws BaseException {
            this.this$0 = r100;
            RandomAccessFile r102 = new RandomAccessFile(r101, "rw");     // Catch: IOException -> L5
            this.randomAccess = r102;     // Catch: IOException -> L5
            this.fileChannel = r102.getChannel();     // Catch: IOException -> L5
            this.byteBuffer = ByteBuffer.allocateDirect(DownloadConstants.TTNET_DEFAULT_BUFFER_SIZE);     // Catch: IOException -> L5
            return;
        L5:
            e = move-exception;
            throw new BaseException(1039, e);
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void write(byte[] r100, int r101, int r102) throws IOException {
            this.byteBuffer.clear();
            this.byteBuffer.put(r100, r101, r102);
            this.byteBuffer.flip();
        L4:
            if (this.byteBuffer.hasRemaining() == false) goto L6;
            this.fileChannel.write(this.byteBuffer);
            goto L4
        }
    }

    public interface RandomOutputStream {
        void close() throws IOException;

        void flush() throws IOException;

        void flushAndSync() throws IOException;

        void seek(long r100) throws IOException;

        void setLength(long r100) throws IOException;

        void sync() throws IOException;

        void write(byte[] r100, int r101, int r102) throws IOException;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.randomAccess.close();
    }

    public void flush() throws IOException {
        this.randomAccess.flush();
    }

    public void flushAndSync() throws IOException {
        this.randomAccess.flushAndSync();
    }

    public void sync() throws IOException {
        this.randomAccess.sync();
    }

    public void seek(long r100) throws IOException {
        this.randomAccess.seek(r100);
    }

    public void setLength(long r100) throws IOException {
        this.randomAccess.setLength(r100);
    }

    public RandomAccessOutputStream(File r100, int r101) throws BaseException {
        this(r100, r101, false);
    }

    public RandomAccessOutputStream(File r100, int r101, boolean r102) throws BaseException {
        if (r102 == false) goto L5;
        this.randomAccess = new ChannelRandomAccessOutputStream(this, r100);
        return;
    L5:
        this.randomAccess = new BufferRandomAccessOutputStream(this, r100, r101);
    }

    public void write(byte[] r100, int r101, int r102) throws IOException {
        this.randomAccess.write(r100, r101, r102);
    }
}
