package com.larus.im.internal.delegate;

import com.larus.im.FlowRuntime;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class p0 implements gd9.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p0 f348255a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final gd9.w f348256b = null;

    static {
        f348255a = new p0();
        f348256b = FlowRuntime.b().f();
    }

    public p0() {
        FlowRuntime.b().f();
    }

    @Override // gd9.w
    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "step");
        f348256b.a(r100, r101);
    }
}
