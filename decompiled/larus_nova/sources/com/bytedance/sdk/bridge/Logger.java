package com.bytedance.sdk.bridge;

import com.bytedance.sdk.bridge.api.BridgeService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes22.dex */
public final class Logger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f269561a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f269562b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f269563c = null;

    static {
        f269561a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Logger.class), "bridgeService", "getBridgeService()Lcom/bytedance/sdk/bridge/api/BridgeService;"))};
        f269563c = new Logger();
        f269562b = LazyKt.lazy(Logger$bridgeService$2.INSTANCE);
    }

    public Logger() {
    }

    public static void a() {
        BridgeConfig r100 = BridgeManager.INSTANCE.getBridgeConfig();
        if (r100 == null) goto L5;
        Boolean r101 = r100.isDebug();
    L7:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == true) goto L9;
        return;
    L9:
        return;
    L5:
        r101 = null;
        goto L7
    }

    public static void b() {
        BridgeConfig r100 = BridgeManager.INSTANCE.getBridgeConfig();
        if (r100 == null) goto L5;
        Boolean r101 = r100.isDebug();
    L7:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == true) goto L9;
        return;
    L9:
        return;
    L5:
        r101 = null;
        goto L7
    }

    public static void c(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L12
        f269563c.getClass();     // Catch: Throwable -> L12
        Lazy r102 = f269562b;     // Catch: Throwable -> L12
        KProperty r103 = f269561a[0];     // Catch: Throwable -> L12
        BridgeService r104 = (BridgeService) r102.getValue();     // Catch: Throwable -> L12
        if (r104 != null) goto L5;
        Unit r105 = null;
    L10:
        Result.m9449constructorimpl(r105);     // Catch: Throwable -> L12
        return;
    L5:
        if (r100 != null) goto L8;
        r100 = "";
    L8:
        r104.reportErrorInfo("BridgeReport_BridgeRegistry", r100);     // Catch: Throwable -> L12
        r105 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
