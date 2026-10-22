package com.bytedance.ies.argus.api.params;

import android.net.Uri;
import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class e extends n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f245734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f245735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f245736d;

    public e(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "originUrl");
        this.f245734b = r100;
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
        JSONUtilsKt.d(r101, "origin_url", this.f245734b.toString());
        String r102 = this.f245735c;
        String r103 = "";
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        JSONUtilsKt.d(r101, "cdn_url", r102);
        String r104 = this.f245736d;
        if (r104 == null) goto L9;
        r103 = r104;
    L9:
        JSONUtilsKt.d(r101, "host", r103);
        return r101;
    }
}
