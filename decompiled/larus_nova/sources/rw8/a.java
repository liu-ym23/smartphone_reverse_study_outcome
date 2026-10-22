package rw8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f539729a = 0;

    static {
    }

    public static String a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        if (r101 > 0) goto L6;
        return "";
    L6:
        int r102 = r100.length();
        int r103 = 0;
        int r104 = 0;
    L7:
        if (r103 >= r102) goto L15;
        if (r100.charAt(r103) != '\n') goto L14;
        r104 = r104 + 1;
        if (r104 != r101) goto L14;
        return r100.substring(0, r103);
    L14:
        r103 = r103 + 1;
        goto L7
    L15:
        return r100;
    }

    public static String b(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        if (r101 > 0) goto L6;
        return "";
    L6:
        int r102 = r100.length() - 1;
        int r103 = 0;
    L7:
        if (r102 < 0) goto L15;
        if (r100.charAt(r102) != '\n') goto L14;
        r103 = r103 + 1;
        if (r103 != r101) goto L14;
        return r100.substring(r102 + 1);
    L14:
        r102 = r102 - 1;
        goto L7
    L15:
        return r100;
    }
}
