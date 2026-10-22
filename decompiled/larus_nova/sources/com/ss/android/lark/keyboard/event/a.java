package com.ss.android.lark.keyboard.event;

import android.animation.TimeInterpolator;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f429293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f429294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f429295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TimeInterpolator f429296d;

    @Override // com.ss.android.lark.keyboard.event.c
    public final String getTag() {
        return "AnimateHeightChange: {from:" + this.f429293a + ", to:" + this.f429294b + ", dur: " + this.f429295c + '}';
    }

    public final String toString() {
        return getTag();
    }

    public a(int r100, int r101, long r102, TimeInterpolator r103) {
        this.f429293a = r100;
        this.f429294b = r101;
        this.f429295c = r102;
        this.f429296d = r103;
    }
}
