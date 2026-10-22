package com.lynx.component.svg.parser;

/* JADX INFO: loaded from: classes32.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SVG.b f381198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f381199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f381200c;

    public c(c r100) {
        this.f381198a = null;
        this.f381199b = 14.0f;
        this.f381200c = 14.0f;
        if (r100 != null) goto L5;
        return;
    L5:
        this.f381198a = r100.f381198a;
        this.f381199b = r100.f381199b;
        this.f381200c = r100.f381200c;
    }

    public c(float r100, float r101) {
        this.f381198a = null;
        this.f381199b = 14.0f;
        this.f381200c = 14.0f;
        this.f381199b = r100;
        this.f381200c = r101;
    }
}
