package com.bytedance.ies.argus.api.params;

import android.webkit.WebResourceResponse;
import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class l extends com.bytedance.ies.argus.strategy.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f245765e = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WebResourceResponse f245766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f245767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f245768d;

    public l() {
        this(0);
    }

    public final Boolean e() {
        Object r100 = ((LinkedHashMap) this.f246155a).get("use_origin_network");
        if ((r100 instanceof Boolean) == true) goto L7;
        return null;
    L7:
        return (Boolean) r100;
    }

    public l(int r100) {
        this.f245766b = null;
        this.f245767c = null;
        this.f245768d = LazyKt.lazy(new ArgusWebResourceRequestRewritePayload$printObj$2(this));
    }

    @Override // com.bytedance.ies.argus.strategy.b
    public final JSONObject d(ArgusVerifyAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return (JSONObject) this.f245768d.getValue();
    }
}
