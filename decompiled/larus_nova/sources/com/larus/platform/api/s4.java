package com.larus.platform.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class s4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OpenPushReminderScene f365270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t4 f365271b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s4) == true) goto L8;
        return false;
    L8:
        s4 r101 = (s4) r100;
        if (this.f365270a == r101.f365270a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f365271b, r101.f365271b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f365270a.hashCode() * 31;
        t4 r101 = this.f365271b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "OpenPushReminderData(scene=" + this.f365270a + ", bizInfo=" + this.f365271b + ')';
    }

    public s4(OpenPushReminderScene r100, t4 r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f365270a = r100;
        this.f365271b = r101;
    }
}
