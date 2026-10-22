package com.ss.android.lark.keyboard.ime;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f429384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f429385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f429386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f429387d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f429388e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f429389f;

    public f() {
    }

    public final String toString() {
        return "ImeInsetsHolder {from: " + this.f429384a + ", to: " + this.f429385b + ", systemBarHeight: " + this.f429386c + ", isVisibleChange: " + this.f429387d + ", decorFitSystemWindow: " + this.f429389f + ", isVisible: " + this.f429388e + '}';
    }

    public final void a(f r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        this.f429384a = r100.f429384a;
        this.f429385b = r100.f429385b;
        this.f429386c = r100.f429386c;
        this.f429387d = r100.f429387d;
        this.f429388e = r100.f429388e;
        this.f429389f = r100.f429389f;
    }
}
