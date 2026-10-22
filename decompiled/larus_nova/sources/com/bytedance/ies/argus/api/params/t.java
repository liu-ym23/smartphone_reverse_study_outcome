package com.bytedance.ies.argus.api.params;

import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class t extends n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f245779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f245780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f245781d;

    @Override // com.bytedance.ies.argus.strategy.b
    public final JSONObject c(ArgusVerifyAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return d(r100);
    }

    @Override // com.bytedance.ies.argus.strategy.b
    public final JSONObject d(ArgusVerifyAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        JSONObject r101 = new JSONObject();
        JSONUtilsKt.d(r101, EventConstant.Key.MODULE, this.f245779b);
        JSONUtilsKt.d(r101, com.alipay.sdk.m.p.e.f25671s, this.f245780c);
        return r101;
    }

    public t(String r100, String r101, Object r102) {
        this.f245779b = r100;
        this.f245780c = r101;
        this.f245781d = r102;
    }
}
