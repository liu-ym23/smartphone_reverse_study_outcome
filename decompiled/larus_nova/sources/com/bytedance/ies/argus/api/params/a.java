package com.bytedance.ies.argus.api.params;

import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.util.CommonUtils;
import com.bytedance.pia.core.utils.GsonUtils;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f245716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f245717c;

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "ssrUrl");
        this.f245716b = r100;
        this.f245717c = "";
    }

    @Override // com.bytedance.ies.argus.strategy.b
    public final JSONObject c(ArgusVerifyAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return d(r100);
    }

    @Override // com.bytedance.ies.argus.strategy.b
    public final JSONObject d(ArgusVerifyAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        JSONObject r101 = new JSONObject();
        Lazy r102 = GsonUtils.f266370a;
        int r103 = CommonUtils.f246248a;
        GsonUtils.e(r101, "ssr_url", CommonUtils.k(this.f245716b));
        String r104 = this.f245716b;
        if (r104 == null) goto L7;
        GsonUtils.e(r101, "origin_ssr_url", r104.substring(0, 150));
        GsonUtils.e(r101, "host", this.f245717c);
        return r101;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }
}
