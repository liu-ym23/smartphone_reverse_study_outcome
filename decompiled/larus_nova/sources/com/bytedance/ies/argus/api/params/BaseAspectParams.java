package com.bytedance.ies.argus.api.params;

import com.bytedance.ies.argus.strategy.a;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes19.dex */
public class BaseAspectParams<REWRITE_PAYLOAD extends com.bytedance.ies.argus.strategy.a> extends com.bytedance.ies.argus.strategy.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f245664a;

    public REWRITE_PAYLOAD f() {
        throw null;
    }

    public final REWRITE_PAYLOAD e() {
        return (REWRITE_PAYLOAD) this.f245664a.getValue();
    }

    public BaseAspectParams() {
        this.f245664a = LazyKt.lazy(new BaseAspectParams$rewritePayload$2(this));
    }
}
