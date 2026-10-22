package com.larus.platform.service;

import android.content.Context;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class h1 implements com.larus.platform.api.q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h1 f365744a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365745b = null;

    public h1() {
    }

    static {
        f365744a = new h1();
        f365745b = LazyKt.lazy(new g1());
    }

    @Override // com.larus.platform.api.q0
    public final void M(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.larus.platform.api.q0 r101 = (com.larus.platform.api.q0) f365745b.getValue();
        if (r101 == null) goto L6;
        r101.M(r100);
        return;
    }

    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        IFlowSdkDepend r101 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r101 == null) goto L9;
        com.larus.office.base.host.o r102 = r101.u();
        if (r102 == null) goto L9;
        if (r102.a(r100) != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.larus.platform.api.q0
    public final boolean L(String r100, Context r101) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.larus.platform.api.q0 r102 = (com.larus.platform.api.q0) f365745b.getValue();
        if (r102 != null) goto L5;
    L7:
        return false;
    L5:
        if (r102.L(r100, r101) != true) goto L7;
        return true;
    }

    @Override // com.larus.platform.api.q0
    public final boolean N(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "redirectUri");
        com.larus.platform.api.q0 r102 = (com.larus.platform.api.q0) f365745b.getValue();
        if (r102 != null) goto L5;
    L7:
        return false;
    L5:
        if (r102.N(r100, r101) != true) goto L7;
        return true;
    }
}
