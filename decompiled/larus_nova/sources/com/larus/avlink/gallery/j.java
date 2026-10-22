package com.larus.avlink.gallery;

import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f292609a = 0;

    static {
    }

    public static boolean a(String r100) {
        return StringsKt.contains$default(d(r100), "image", false, 2, null);
    }

    public static boolean b(String r100) {
        return StringsKt.contains$default(d(r100), "pack", false, 2, null);
    }

    public static boolean c(String r100) {
        return StringsKt.contains$default(d(r100), "video", false, 2, null);
    }

    public static String d(String r100) {
        if (r100 == null) goto L6;
        String r101 = StringsKt.trim(r100).toString();
        if (r101 == null) goto L6;
        String r102 = r101.toLowerCase(Locale.ROOT);
    L7:
        if (r102 != null) goto L10;
        return "";
    L10:
        return r102;
    L6:
        r102 = null;
        goto L7
    }

    public static String e(String r100) {
        if (Intrinsics.areEqual(d(r100), "live_photo") == false) goto L6;
    L7:
        return "image";
    L6:
        if (a(r100) == true) goto L7;
        if (c(r100) == false) goto L12;
    L13:
        return "video";
    L12:
        if (Intrinsics.areEqual(d(r100), "video_mp4") == true) goto L13;
        return "unknown";
    }
}
