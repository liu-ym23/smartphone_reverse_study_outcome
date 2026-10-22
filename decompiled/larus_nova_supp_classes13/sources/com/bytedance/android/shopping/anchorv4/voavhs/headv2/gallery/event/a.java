package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.event;

import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements j {
    public final /* synthetic */ c a;

    public a(c r1) {
        this.a = r1;
    }

    public final void a(JSONObject r11) {
        Intrinsics.checkNotNullParameter(r11, "params");
        if (r11.optBoolean("is_from_gallery") == false) goto L18;
        this.a.getClass();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        int r1 = t0.a;     // Catch: Throwable -> L7
        Object r12 = Result.constructor-impl((IAction) t0.a.a.fromJson(r11.optString("action"), IAction.class));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r12) == false) goto L12;
        r12 = null;
    L12:
        IAction r5 = (IAction) r12;
        if (r5 == null) goto L19;
        int r13 = com.bytedance.android.shopping.anchorv4.event_chain.c.a;
        com.bytedance.android.shopping.anchorv4.event_chain.c.a(null, null, this.a.b, r5, null, null, null, new com.bytedance.android.ecom.arch.slice.action.c(null, null));
        return;
    L19:
        return;
    L7:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }
}
