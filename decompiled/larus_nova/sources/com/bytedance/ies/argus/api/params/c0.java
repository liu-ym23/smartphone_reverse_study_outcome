package com.bytedance.ies.argus.api.params;

import android.webkit.WebResourceResponse;
import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class c0 extends com.bytedance.ies.argus.strategy.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WebResourceResponse f245730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f245731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f245732d;

    public c0() {
        this(0);
    }

    public c0(int r100) {
        this.f245730b = null;
        this.f245731c = null;
        this.f245732d = LazyKt.lazy(new ShouldInterceptResponseRewritePayload$printObj$2(this));
    }

    @Override // com.bytedance.ies.argus.strategy.b
    public final JSONObject d(ArgusVerifyAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return (JSONObject) this.f245732d.getValue();
    }
}
