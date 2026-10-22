package com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.route;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f433577b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f433578a;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.route.a$a, reason: collision with other inner class name */
    public static final class C5156a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f433578a, ((a) r100).f433578a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f433578a.hashCode();
    }

    public final String toString() {
        return "MmEndWindowRouteRequest(dataKey=" + this.f433578a + ')';
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "dataKey");
        this.f433578a = r100;
    }
}
