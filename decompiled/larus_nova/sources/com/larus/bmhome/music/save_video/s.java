package com.larus.bmhome.music.save_video;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f313144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Exception f313145b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f313144a, r101.f313144a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f313145b, r101.f313145b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f313144a.hashCode() * 31) + this.f313145b.hashCode();
    }

    public final String toString() {
        return "MuxingError(message=" + this.f313144a + ", exception=" + this.f313145b + ')';
    }

    public s(Exception r100) {
        Intrinsics.checkNotNullParameter("Start encoder failed", "message");
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        this.f313144a = "Start encoder failed";
        this.f313145b = r100;
    }
}
