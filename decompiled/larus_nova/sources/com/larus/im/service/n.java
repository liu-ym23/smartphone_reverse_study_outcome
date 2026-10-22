package com.larus.im.service;

import com.ss.bytertc.engine.data.EngineConfig;
import com.ss.bytertc.engine.handler.IRTCEngineEventHandler;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f350883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EngineConfig f350884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IRTCEngineEventHandler f350885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<e, Unit> f350886d;

    public final String toString() {
        return "FlowRTCEngineRequest(bizId=" + this.f350883a + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n(String r100, EngineConfig r101, IRTCEngineEventHandler r102, Function1<? super e, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "bizId");
        Intrinsics.checkNotNullParameter(r101, "engineConfig");
        this.f350883a = r100;
        this.f350884b = r101;
        this.f350885c = r102;
        this.f350886d = r103;
        if (f.a(r100) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(("Invalid bizId: " + r100 + ", only support " + f.b()).toString());
    }
}
