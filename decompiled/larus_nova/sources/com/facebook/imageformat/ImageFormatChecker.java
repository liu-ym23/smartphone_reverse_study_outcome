package com.facebook.imageformat;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.facebook.common.internal.ByteStreams;
import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class ImageFormatChecker {
    private static ImageFormatChecker sInstance;

    @Nullable
    private List<ImageFormat.FormatChecker> mCustomImageFormatCheckers;
    private final ImageFormat.FormatChecker mDefaultFormatChecker;
    private int mMaxHeaderLength;

    public static synchronized ImageFormatChecker getInstance() {
        monitor-enter(ImageFormatChecker.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new ImageFormatChecker();     // Catch: Throwable -> L10
    L7:
        ImageFormatChecker r100 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(ImageFormatChecker.class);
        return r100;
    }

    private void updateMaxHeaderLength() {
        this.mMaxHeaderLength = this.mDefaultFormatChecker.getHeaderSize();
        List<ImageFormat.FormatChecker> r100 = this.mCustomImageFormatCheckers;
        if (r100 == null) goto L8;
        Iterator<ImageFormat.FormatChecker> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        ImageFormat.FormatChecker r102 = r101.next();
        this.mMaxHeaderLength = Math.max(this.mMaxHeaderLength, r102.getHeaderSize());
        goto L6
    L10:
        return;
    }

    private ImageFormatChecker() {
        this.mDefaultFormatChecker = new DefaultImageFormatChecker();
        updateMaxHeaderLength();
    }

    public int getMaxHeaderLength() {
        return this.mMaxHeaderLength;
    }

    public static ImageFormat getImageFormat(String r100) {
        PolarisFileInputStreamWrapper r101 = null;
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L10 IOException -> L17
        ImageFormat r103 = getImageFormat(r102);     // Catch: Throwable -> L7 IOException -> L9
        Closeables.closeQuietly(r102);
        return r103;
    L9:
        r101 = r102;
    L7:
        th = th;
        r101 = r102;
    L15:
        Closeables.closeQuietly(r101);
        throw th;
    L10:
        th = th;
    L12:
        ImageFormat r104 = ImageFormat.UNKNOWN;     // Catch: Throwable -> L10
        Closeables.closeQuietly(r101);
        return r104;
    }

    public static ImageFormat getImageFormat_WrapIOException(InputStream r100) {
        return getImageFormat(r100);
    L4:
        e = move-exception;
        throw Throwables.propagate(e);
    }

    public ImageFormat determineImageFormat(InputStream r100) throws IOException {
        Preconditions.checkNotNull(r100);
        int r101 = this.mMaxHeaderLength;
        byte[] r102 = new byte[r101];
        int r103 = readHeaderFromStream(r101, r100, r102);
        List<ImageFormat.FormatChecker> r104 = this.mCustomImageFormatCheckers;
        if (r104 == null) goto L12;
        Iterator<ImageFormat.FormatChecker> r105 = r104.iterator();
    L6:
        if (r105.hasNext() == false) goto L12;
        ImageFormat r106 = r105.next().determineFormat(r102, r103);
        if (r106 == null) goto L6;
        if (r106 == ImageFormat.UNKNOWN) goto L6;
        return r106;
    L12:
        ImageFormat r107 = this.mDefaultFormatChecker.determineFormat(r102, r103);
        if (r107 == null) goto L18;
        if (r107 == ImageFormat.UNKNOWN) goto L18;
        return r107;
    L18:
        return ImageFormat.UNKNOWN;
    }

    public void setCustomImageFormatCheckers(@Nullable List<ImageFormat.FormatChecker> r100) {
        this.mCustomImageFormatCheckers = r100;
        updateMaxHeaderLength();
    }

    public static ImageFormat getImageFormat(InputStream r100) throws IOException {
        return getInstance().determineImageFormat(r100);
    }

    private static int readHeaderFromStream(int r100, InputStream r101, byte[] r102) throws IOException {
        Preconditions.checkNotNull(r101);
        Preconditions.checkNotNull(r102);
        if (r102.length < r100) goto L5;
        boolean r103 = true;
    L6:
        Preconditions.checkArgument(r103);
        if (r101.markSupported() == false) goto L15;
        r101.mark(r100);     // Catch: Throwable -> L11
        int r104 = ByteStreams.read(r101, r102, 0, r100);     // Catch: Throwable -> L11
        r101.reset();
        return r104;
    L11:
        th = move-exception;
        r101.reset();
        throw th;
    L15:
        return ByteStreams.read(r101, r102, 0, r100);
    L5:
        r103 = false;
        goto L6
    }
}
