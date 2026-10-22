package com.bytedance.ies.argus.api.params;

import android.net.Uri;
import android.os.Bundle;
import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class o extends n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f245769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArgusContainerCreateType f245770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f245771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bundle f245772e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f245773f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f245774g;

    @Override // com.bytedance.ies.argus.strategy.b
    public final JSONObject c(ArgusVerifyAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        JSONObject r101 = new JSONObject();
        JSONUtilsKt.d(r101, "schema", String.valueOf(this.f245769b));
        JSONUtilsKt.d(r101, "anniex_bid", this.f245771d);
        return r101;
    }

    @Override // com.bytedance.ies.argus.strategy.b
    public final JSONObject d(ArgusVerifyAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        JSONObject r101 = new JSONObject();
        JSONUtilsKt.d(r101, "schema", String.valueOf(this.f245769b));
        JSONUtilsKt.d(r101, "container_create_type", this.f245770c.getStrValue());
        JSONUtilsKt.d(r101, "anniex_bid", this.f245771d);
        return r101;
    }

    public o(Uri r100, ArgusContainerCreateType r101, String r102, Bundle r103) {
        Intrinsics.checkNotNullParameter(r101, "createType");
        this.f245769b = r100;
        this.f245770c = r101;
        this.f245771d = r102;
        this.f245772e = r103;
    }

    public /* synthetic */ o(Uri r100, ArgusContainerCreateType r101, String r102, int r103) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102, null);
    }
}
