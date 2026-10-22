package io.ktor.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f491970a = false;

    public o() {
    }

    static {
        o r100 = new o();
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (Platform.Jvm != Platform.Browser) goto L5;
        boolean r101 = true;
    L6:
        f491970a = r101;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r102 = System.getProperty("io.ktor.development");
        if (r102 == null) goto L9;
        Boolean.parseBoolean(r102);
    L9:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return;
    L5:
        r101 = false;
        goto L6
    }
}
