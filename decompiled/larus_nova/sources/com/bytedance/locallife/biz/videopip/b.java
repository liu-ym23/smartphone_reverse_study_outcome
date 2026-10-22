package com.bytedance.locallife.biz.videopip;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f257013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public VIDEO_PIP_SESSION_STATE f257014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f257015c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f257013a, r101.f257013a) == true) goto L12;
        return false;
    L12:
        if (this.f257014b == r101.f257014b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f257015c, r101.f257015c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f257013a.hashCode() * 31) + this.f257014b.hashCode()) * 31) + this.f257015c.hashCode();
    }

    public final String toString() {
        return "LifeVideoPipSession(awemeId=" + this.f257013a + ", state=" + this.f257014b + ", enterFrom=" + this.f257015c + ')';
    }

    public b(String r100, String r101) {
        VIDEO_PIP_SESSION_STATE r102 = VIDEO_PIP_SESSION_STATE.NOT_INITIAL;
        Intrinsics.checkNotNullParameter(r100, "awemeId");
        Intrinsics.checkNotNullParameter(r102, "state");
        Intrinsics.checkNotNullParameter(r101, "enterFrom");
        this.f257013a = r100;
        this.f257014b = r102;
        this.f257015c = r101;
    }
}
