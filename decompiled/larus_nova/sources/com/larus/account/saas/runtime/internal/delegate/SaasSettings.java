package com.larus.account.saas.runtime.internal.delegate;

import d48.e;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class SaasSettings implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SaasSettings f286462a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f286463b = null;

    public SaasSettings() {
    }

    static {
        f286462a = new SaasSettings();
        f286463b = LazyKt.lazy(SaasSettings$impl$2.INSTANCE);
    }

    @Override // d48.e
    public final JSONObject a(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defValue");
        Lazy r102 = f286463b;
        JSONObject r103 = ((e) r102.getValue()).a("sdk_key_flow_account", new JSONObject());
        if (r103.has(r100) == false) goto L9;
        JSONObject r104 = r103.optJSONObject(r100);
        if (r104 != null) goto L10;
        return r101;
    L10:
        return r104;
    L9:
        return ((e) r102.getValue()).a(r100, r101);
    }
}
