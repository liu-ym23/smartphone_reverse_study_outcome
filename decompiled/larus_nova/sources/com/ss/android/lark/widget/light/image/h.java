package com.ss.android.lark.widget.light.image;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f446121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f446122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f446123c;

    public final String toString() {
        return "result:" + this.f446121a + ",preloadingDuration:" + this.f446122b + ",scene:" + this.f446123c;
    }

    public final void setResult(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f446121a = r100;
    }

    public h(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Intrinsics.checkNotNullParameter(r102, "scene");
        this.f446121a = r100;
        this.f446122b = r101;
        this.f446123c = r102;
    }
}
