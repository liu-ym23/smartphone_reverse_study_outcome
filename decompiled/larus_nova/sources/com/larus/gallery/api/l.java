package com.larus.gallery.api;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class l {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f343864a = null;

        static {
            int[] r100 = new int[GalleryType.values().length];
            r100[GalleryType.Image.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[GalleryType.Video.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[GalleryType.Custom.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f343864a = r100;
        }
    }

    public static final String a(k r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        GalleryType r101 = r100.getType();
        int r102 = a.f343864a[r101.ordinal()];
        String r103 = "null";
        if (r102 != 1) goto L5;
        m r104 = r100.f343860b;
        if (r104 == null) goto L30;
        String r105 = r104.f343865a;
        if (r105 == null) goto L30;
        r103 = r105;
    L37:
        return "image:".concat(r103);
    L30:
        if (r104 == null) goto L32;
        String r106 = r104.f343866b;
    L33:
        if (r106 == null) goto L37;
        r103 = r106;
        goto L37
    L32:
        r106 = null;
        goto L33
    L5:
        if (r102 != 2) goto L7;
        q r107 = r100.f343861c;
        if (r107 == null) goto L39;
        String r108 = r107.f343889a;
        if (r108 == null) goto L39;
        r103 = r108;
    L39:
        return "video:".concat(r103);
    L7:
        if (r102 != 3) goto L16;
        h r109 = r100.f343862d;
        if (r109 == null) goto L38;
        String r110 = r109.f343855a;
        if (r110 == null) goto L38;
        r103 = r110;
    L38:
        return "custom:".concat(r103);
    L16:
        throw new NoWhenBranchMatchedException();
    }
}
