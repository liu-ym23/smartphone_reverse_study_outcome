package com.bytedance.ies.argus.api.params;

import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.util.CommonUtils;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class c extends m<d> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f245726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f245727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f245728d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f245729e;

    @Override // com.bytedance.ies.argus.api.params.BaseAspectParams
    public final com.bytedance.ies.argus.strategy.a f() {
        return new d();
    }

    @Override // com.bytedance.ies.argus.strategy.b
    public final JSONObject c(ArgusVerifyAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return d(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ies.argus.strategy.b
    public final JSONObject d(ArgusVerifyAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        JSONObject r101 = new JSONObject();
        String r102 = this.f245729e;
        if (r102 != null) goto L5;
        r102 = "unparseable";
    L5:
        JSONUtilsKt.d(r101, "host", r102);
        int r103 = CommonUtils.f246248a;
        JSONUtilsKt.d(r101, "invoke_url", CommonUtils.k(this.f245728d));
        JSONUtilsKt.d(r101, "invoke_url_full", StringsKt.take(this.f245728d, 200));
        d r104 = (d) e();
        if (r104 == null) goto L8;
        List<String> r105 = r104.f245733b;
    L9:
        JSONUtilsKt.d(r101, "filtered_fields", r105);
        JSONUtilsKt.d(r101, "bridge_name", this.f245726b);
        return r101;
    L8:
        r105 = null;
        goto L9
    }

    public c(String r100, String r101, String r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        Intrinsics.checkNotNullParameter(r101, "feId");
        Intrinsics.checkNotNullParameter(r102, "url");
        Intrinsics.checkNotNullParameter(r103, "data");
        this.f245726b = r100;
        this.f245727c = r101;
        this.f245728d = r102;
        int r104 = com.bytedance.ies.argus.util.e.f246255a;
        this.f245729e = com.bytedance.ies.argus.util.e.a(UriProtector.parse(r102));
    }
}
