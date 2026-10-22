package com.bytedance.ies.argus.api.params;

import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class h extends m<i> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f245746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f245747c;

    @Override // com.bytedance.ies.argus.strategy.b
    public final JSONObject c(ArgusVerifyAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return null;
    }

    @Override // com.bytedance.ies.argus.strategy.b
    public final JSONObject d(ArgusVerifyAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return null;
    }

    @Override // com.bytedance.ies.argus.api.params.BaseAspectParams
    public final com.bytedance.ies.argus.strategy.a f() {
        return new i(0);
    }

    public h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "originUserAgent");
        Intrinsics.checkNotNullParameter("anniex", "enterFrom");
        this.f245746b = r100;
        this.f245747c = "anniex";
    }
}
