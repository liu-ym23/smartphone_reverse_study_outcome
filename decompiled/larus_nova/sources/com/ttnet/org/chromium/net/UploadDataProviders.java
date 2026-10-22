package com.ttnet.org.chromium.net;

import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes41.dex */
public final class UploadDataProviders {

    public static final class ByteBufferUploadProvider extends UploadDataProvider {
        private final ByteBuffer mUploadBuffer;

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public long getLength() {
            return this.mUploadBuffer.limit();
        }

        private ByteBufferUploadProvider(ByteBuffer r100) {
            this.mUploadBuffer = r100;
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void rewind(UploadDataSink r100) {
            this.mUploadBuffer.position(0);
            r100.onRewindSucceeded();
        }

        public /* synthetic */ ByteBufferUploadProvider(ByteBuffer r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void read(UploadDataSink r100, ByteBuffer r101) {
            if (r101.hasRemaining() == false) goto L11;
            if (r101.remaining() < this.mUploadBuffer.remaining()) goto L7;
            r101.put(this.mUploadBuffer);
        L8:
            r100.onReadSucceeded(false);
            return;
        L7:
            int r102 = this.mUploadBuffer.limit();
            ByteBuffer r103 = this.mUploadBuffer;
            r103.limit(r103.position() + r101.remaining());
            r101.put(this.mUploadBuffer);
            this.mUploadBuffer.limit(r102);
            goto L8
        L11:
            throw new IllegalStateException("Cronet passed a buffer with no bytes remaining");
        }
    }

    public interface FileChannelProvider {
        FileChannel getChannel() throws IOException;
    }

    public static final class FileUploadProvider extends UploadDataProvider {
        private volatile FileChannel mChannel;
        private final Object mLock;
        private final FileChannelProvider mProvider;

        private FileChannel getChannel() throws IOException {
            if (this.mChannel != null) goto L15;
            Object r100 = this.mLock;
            monitor-enter(r100);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (this.mChannel != null) goto L9;
            this.mChannel = this.mProvider.getChannel();     // Catch: Throwable -> L11
        L9:
            monitor-exit(r100);     // Catch: Throwable -> L11
        L15:
            return this.mChannel;
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            FileChannel r100 = this.mChannel;
            if (r100 == null) goto L6;
            r100.close();
            return;
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public long getLength() throws IOException {
            return getChannel().size();
        }

        private FileUploadProvider(FileChannelProvider r100) {
            this.mLock = new Object();
            this.mProvider = r100;
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void rewind(UploadDataSink r100) throws IOException {
            getChannel().position(0);
            r100.onRewindSucceeded();
        }

        public /* synthetic */ FileUploadProvider(FileChannelProvider r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void read(UploadDataSink r100, ByteBuffer r101) throws IOException {
            if (r101.hasRemaining() == false) goto L13;
            FileChannel r102 = getChannel();
            int r103 = 0;
        L5:
            if (r103 != 0) goto L10;
            int r104 = r102.read(r101);
            if (r104 == (-1)) goto L10;
            r103 = r103 + r104;
        L10:
            r100.onReadSucceeded(false);
            return;
        L13:
            throw new IllegalStateException("Cronet passed a buffer with no bytes remaining");
        }
    }

    private UploadDataProviders() {
    }

    public static UploadDataProvider create(final ParcelFileDescriptor r100) {
        return new FileUploadProvider(new AnonymousClass2(r100), null);
    }

    public static UploadDataProvider create(final File r100) {
        return new FileUploadProvider(new AnonymousClass1(r100), null);
    }

    public static UploadDataProvider create(ByteBuffer r100) {
        return new ByteBufferUploadProvider(r100.slice(), null);
    }

    public static UploadDataProvider create(byte[] r100) {
        return create(r100, 0, r100.length);
    }

    public static UploadDataProvider create(byte[] r100, int r101, int r102) {
        return new ByteBufferUploadProvider(ByteBuffer.wrap(r100, r101, r102).slice(), null);
    }
}
