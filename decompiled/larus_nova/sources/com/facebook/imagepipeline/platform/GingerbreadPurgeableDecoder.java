package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.MemoryFile;
import com.facebook.common.internal.ByteStreams;
import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.streams.LimitedInputStream;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class GingerbreadPurgeableDecoder extends DalvikPurgeableDecoder {
    private static Method sGetFileDescriptorMethod;

    @Nullable
    private final WebpBitmapFactory mWebpBitmapFactory;

    private synchronized Method getFileDescriptorMethod() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (sGetFileDescriptorMethod == null) goto L16;
    L10:
        Method r100 = sGetFileDescriptorMethod;     // Catch: Throwable -> L13
        monitor-exit(this);
        return r100;
    L16:
        sGetFileDescriptorMethod = MemoryFile.class.getDeclaredMethod("getFileDescriptor", new Class[0]);     // Catch: Exception -> L7 Throwable -> L13
    L7:
        e = move-exception;
        throw Throwables.propagate(e);     // Catch: Throwable -> L13
    }

    public GingerbreadPurgeableDecoder() {
        this.mWebpBitmapFactory = WebpSupportStatus.loadWebpBitmapFactoryIfExists();
    }

    private FileDescriptor getMemoryFileDescriptor(MemoryFile r100) {
        return (FileDescriptor) getFileDescriptorMethod().invoke(r100, new Object[0]);
    L4:
        e = move-exception;
        throw Throwables.propagate(e);
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    public Bitmap decodeByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> r100, BitmapFactory.Options r101) {
        return decodeFileDescriptorAsPurgeable(r100, r100.get().size(), null, r101);
    }

    private static MemoryFile copyToMemoryFile(CloseableReference<PooledByteBuffer> r100, int r101, @Nullable byte[] r102) throws IOException {
        if (r102 != null) goto L5;
        int r103 = 0;
    L6:
        PooledByteBufferInputStream r104 = null;
        OutputStream r105 = null;
        MemoryFile r106 = new MemoryFile(null, r103 + r101);
        r106.allowPurging(false);
        PooledByteBufferInputStream r107 = new PooledByteBufferInputStream(r100.get());     // Catch: Throwable -> L19
        LimitedInputStream r108 = new LimitedInputStream(r107, r101);     // Catch: Throwable -> L16
        r105 = r106.getOutputStream();     // Catch: Throwable -> L14
        ByteStreams.copy(r108, r105);     // Catch: Throwable -> L14
        if (r102 == null) goto L12;
        r106.writeBytes(r102, 0, r101, r102.length);     // Catch: Throwable -> L14
    L12:
        CloseableReference.closeSafely(r100);
        Closeables.closeQuietly(r107);
        Closeables.closeQuietly(r108);
        Closeables.close(r105, true);
        return r106;
    L14:
        th = th;
        OutputStream r109 = r105;
    L18:
        r104 = r107;
    L21:
        CloseableReference.closeSafely(r100);
        Closeables.closeQuietly(r104);
        Closeables.closeQuietly(r108);
        Closeables.close(r109, true);
        throw th;
    L16:
        th = th;
        r109 = null;
        r108 = null;
    L19:
        th = th;
        r109 = null;
        r108 = null;
        goto L21
    L5:
        r103 = r102.length;
        goto L6
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    public Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> r100, int r101, BitmapFactory.Options r102) {
        if (DalvikPurgeableDecoder.endsWithEOI(r100, r101) == false) goto L5;
        byte[] r103 = null;
    L7:
        return decodeFileDescriptorAsPurgeable(r100, r101, r103, r102);
    L5:
        r103 = DalvikPurgeableDecoder.EOI;
        goto L7
    }

    private Bitmap decodeFileDescriptorAsPurgeable(CloseableReference<PooledByteBuffer> r100, int r101, byte[] r102, BitmapFactory.Options r103) {
        MemoryFile r104 = null;
        MemoryFile r105 = copyToMemoryFile(r100, r101, r102);     // Catch: Throwable -> L16 IOException -> L18
        FileDescriptor r106 = getMemoryFileDescriptor(r105);     // Catch: Throwable -> L12 IOException -> L14
        WebpBitmapFactory r107 = this.mWebpBitmapFactory;     // Catch: Throwable -> L12 IOException -> L14
        if (r107 == null) goto L11;
        Bitmap r108 = (Bitmap) Preconditions.checkNotNull(r107.decodeFileDescriptor(r106, null, r103), "BitmapFactory returned null");     // Catch: Throwable -> L12 IOException -> L14
        if (r105 == null) goto L9;
        r105.close();
    L9:
        return r108;
    L11:
        throw new IllegalStateException("WebpBitmapFactory is null");     // Catch: Throwable -> L12 IOException -> L14
    L14:
        e = e;
        r104 = r105;
    L20:
        throw Throwables.propagate(e);     // Catch: Throwable -> L16
    L12:
        th = th;
        r104 = r105;
    L21:
        if (r104 == null) goto L23;
        r104.close();
    L23:
        throw th;
    L18:
        e = e;
    L16:
        th = th;
        goto L21
    }
}
