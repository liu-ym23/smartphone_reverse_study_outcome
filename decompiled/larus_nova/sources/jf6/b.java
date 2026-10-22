package jf6;

import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatCheckerUtils;

/* JADX INFO: loaded from: classes20.dex */
public final class b implements ImageFormat.FormatChecker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ImageFormat f498898a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f498899b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f498900c = null;

    public b() {
    }

    static {
        f498898a = new ImageFormat("DNG", "dng");
        f498899b = new byte[]{73, 73, 42, 0};
        f498900c = new byte[]{77, 77, 0, 42};
    }

    @Override // com.facebook.imageformat.ImageFormat.FormatChecker
    public final int getHeaderSize() {
        return f498899b.length;
    }

    @Override // com.facebook.imageformat.ImageFormat.FormatChecker
    public final ImageFormat determineFormat(byte[] r100, int r101) {
        byte[] r102 = f498899b;
        if (r101 >= r102.length) goto L6;
        return null;
    L6:
        if (ImageFormatCheckerUtils.startsWithPattern(r100, r102) == true) goto L12;
        if (ImageFormatCheckerUtils.startsWithPattern(r100, f498900c) == true) goto L12;
        return null;
    L12:
        return f498898a;
    }
}
