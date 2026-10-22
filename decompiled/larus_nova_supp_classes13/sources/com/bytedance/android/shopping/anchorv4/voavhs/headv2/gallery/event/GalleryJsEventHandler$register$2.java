package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.event;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class GalleryJsEventHandler$register$2 implements j {
    public final /* synthetic */ c a;

    public GalleryJsEventHandler$register$2(c r1) {
        this.a = r1;
    }

    public final void a(final JSONObject r6) {
        Intrinsics.checkNotNullParameter(r6, "params");
        dm.a.a("JsEventHandler").i("handlePlayerEvent: PDPPlayerControl, params: " + r6);
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        Function0<Unit> r3 = new GalleryJsEventHandler$register$2$onReceiveJsEvent$$inlined$runCatching$lambda$1(this, r6);     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r6, "params");     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r3, "block");     // Catch: Throwable -> L8
        if (Intrinsics.areEqual(r6.optString("scene"), "pdp_gallery") == false) goto L6;
        r3.invoke();     // Catch: Throwable -> L8
    L6:
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L16;
        dm.a.a("JsEventHandler").b("handlePlayerEvent failed: PDPPlayerControl", r8);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }
}
