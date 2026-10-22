package com.larus.account.saas.runtime.internal.delegate;

import d48.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class SaasTracking implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SaasTracking f286464a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f286465b = null;

    public SaasTracking() {
    }

    static {
        f286464a = new SaasTracking();
        f286465b = LazyKt.lazy(SaasTracking$impl$2.INSTANCE);
    }

    @Override // d48.g
    public final void reportEvent(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        a.f286466a.d("FlowAccountSaasTrackingDelegate", "reportEvent " + r100 + ": " + r101);
        r101.put("params_for_special", "doubao_account");
        ((g) f286465b.getValue()).reportEvent(r100, r101);
    }
}
