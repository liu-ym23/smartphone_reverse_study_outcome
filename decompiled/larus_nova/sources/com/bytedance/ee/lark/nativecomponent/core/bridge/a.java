package com.bytedance.ee.lark.nativecomponent.core.bridge;

import com.bytedance.ee.lark.nativecomponent.core.debug.BridgeDebug;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ks5.c f242819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BridgeDebug f242820b;

    /* JADX INFO: renamed from: com.bytedance.ee.lark.nativecomponent.core.bridge.a$a, reason: collision with other inner class name */
    public static final class C3480a {
    }

    static {
    }

    public final void a(String r100) {
        NativeComponentHandler r101 = new NativeComponentHandler(r100, this.f242819a, this.f242820b);
        this.f242819a.f505934b.getBridge().a(r100, r101);
    }

    public a(ks5.c r100, BridgeDebug r101) {
        Intrinsics.checkNotNullParameter(r100, "mNativeComponentWebViewContext");
        Intrinsics.checkNotNullParameter(r101, "mBridgeDebug");
        this.f242819a = r100;
        this.f242820b = r101;
    }
}
