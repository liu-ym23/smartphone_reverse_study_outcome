package com.bytedance.live.artist.render;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RenderEntity f254850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f254851b;

    public void d() {
    }

    public abstract void e();

    public abstract void f();

    public final RenderEntity c() {
        RenderEntity r100 = this.f254850a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("entity");
    L5:
        return r100;
    }

    public e() {
        this.f254851b = new f();
    }
}
