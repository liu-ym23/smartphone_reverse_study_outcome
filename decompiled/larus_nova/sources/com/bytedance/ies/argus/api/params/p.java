package com.bytedance.ies.argus.api.params;

import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.lynx.tasm.TemplateData;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class p extends BaseAspectParams<q> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<? extends Object, Object> f245775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f245776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f245777d;

    @Override // com.bytedance.ies.argus.api.params.BaseAspectParams
    public final com.bytedance.ies.argus.strategy.a f() {
        return new q(null);
    }

    public p(TemplateData r100) {
        if (r100 == null) goto L6;
        Map<? extends Object, Object> r101 = r100.toMap();
        if (r101 == null) goto L6;
    L7:
        this.f245775b = r101;
        this.f245776c = !r101.isEmpty();
        this.f245777d = LazyKt.lazy(new GlobalPropsParams$printObject$2(this));
        return;
    L6:
        r101 = MapsKt.emptyMap();
        goto L7
    }

    @Override // com.bytedance.ies.argus.strategy.b
    public final JSONObject c(ArgusVerifyAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return (JSONObject) this.f245777d.getValue();
    }

    @Override // com.bytedance.ies.argus.strategy.b
    public final JSONObject d(ArgusVerifyAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return (JSONObject) this.f245777d.getValue();
    }
}
