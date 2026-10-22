package com.ss.android.lark.passport.flow.mfa;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, FlowMfaFlowSession> f437909a = null;

    static {
        f437909a = new ConcurrentHashMap();
    }

    public static FlowMfaFlowSession a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "flowId");
        return f437909a.get(r100);
    }
}
