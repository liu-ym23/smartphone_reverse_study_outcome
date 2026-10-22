package com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.bridge;

import com.bytedance.caijing.sdk.infra.base.api.container.IBulletService;
import com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.IXPayBaseMethod;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class j0 implements IBulletService.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ XPayPreRenderMethod.ActionType f202648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f202649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ IXPayBaseMethod.b f202650c;

    @Override // com.bytedance.caijing.sdk.infra.base.api.container.IBulletService.a
    public final void onSuccess() {
        if (this.f202648a != XPayPreRenderMethod.ActionType.PRERENDER_AND_OPEN) goto L5;
        this.f202649b.invoke();
    L5:
        this.f202650c.success(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("render_result", "1")}));
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.container.IBulletService.a
    public final void onFail(String r100) {
        Intrinsics.checkNotNullParameter(r100, "errorMsg");
        if (this.f202648a != XPayPreRenderMethod.ActionType.PRERENDER_AND_OPEN) goto L5;
        this.f202649b.invoke();
    L5:
        this.f202650c.a(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("render_result", "0"), TuplesKt.to("render_error_msg", r100)}), r100);
    }

    public j0(XPayPreRenderMethod.ActionType r100, Function0 r101, IXPayBaseMethod.c r102) {
        this.f202648a = r100;
        this.f202649b = r101;
        this.f202650c = r102;
    }
}
