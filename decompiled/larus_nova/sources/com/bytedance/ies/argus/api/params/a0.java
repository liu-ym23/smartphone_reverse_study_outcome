package com.bytedance.ies.argus.api.params;

import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class a0 extends n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f245718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f245719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f245720d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PrefetchType f245721e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f245722f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f245723g;

    public final PrefetchType getType() {
        return this.f245721e;
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
        String r102 = this.f245723g;
        String r103 = "";
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        JSONUtilsKt.d(r101, "real_url", r102);
        JSONUtilsKt.d(r101, "url", this.f245718b);
        JSONUtilsKt.d(r101, "channel", this.f245719c);
        JSONUtilsKt.d(r101, "bundle", this.f245720d);
        String r104 = this.f245722f;
        if (r104 == null) goto L9;
        r103 = r104;
    L9:
        JSONUtilsKt.d(r101, "host", r103);
        JSONUtilsKt.d(r101, "type", this.f245721e.name());
        return r101;
    }

    public a0(String r100, String r101, String r102, PrefetchType r103) {
        Intrinsics.checkNotNullParameter(r103, "type");
        this.f245718b = r100;
        this.f245719c = r101;
        this.f245720d = r102;
        this.f245721e = r103;
    }
}
