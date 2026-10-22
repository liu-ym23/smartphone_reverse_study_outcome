package com.ss.android.lark.biz.im.extension.panel.drag;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class o implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f410557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f410558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f410559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f410560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f410561e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f410562f;

    public o() {
        p r100 = new p(0.4f);
        h r101 = new h(0.75f);
        Intrinsics.checkNotNullParameter(r100, "middleHeight");
        Intrinsics.checkNotNullParameter(r101, "endHeight");
        this.f410557a = r100;
        this.f410558b = r101;
        this.f410559c = 0.0f;
        this.f410560d = 0.0f;
        this.f410561e = 0.0f;
        this.f410562f = 0;
    }

    @Override // com.ss.android.lark.biz.im.extension.panel.drag.m
    public final int a() {
        return this.f410562f;
    }

    @Override // com.ss.android.lark.biz.im.extension.panel.drag.m
    public final float b() {
        return this.f410561e;
    }

    @Override // com.ss.android.lark.biz.im.extension.panel.drag.m
    public final a c() {
        return this.f410558b;
    }

    @Override // com.ss.android.lark.biz.im.extension.panel.drag.m
    public final float d() {
        return this.f410559c;
    }
}
