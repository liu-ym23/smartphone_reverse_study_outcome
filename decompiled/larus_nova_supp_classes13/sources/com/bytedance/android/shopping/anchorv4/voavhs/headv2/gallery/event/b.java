package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.event;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements j {
    public final /* synthetic */ c a;

    public b(c r1) {
        this.a = r1;
    }

    public final void a(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        dm.a.a("JsEventHandler").i("handlePlayerEvent: PDPGalleryChangeVideoListFoldStatus, params: " + r5);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        Intrinsics.areEqual(r5.optString("status"), "show");     // Catch: Throwable -> L9
        d r6 = this.a.c;     // Catch: Throwable -> L9
        if (r6 == null) goto L6;
        r6.b();     // Catch: Throwable -> L9
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L9
    L11:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L17;
        dm.a.a("JsEventHandler").b("handlePlayerEvent failed: PDPPlayerControl", r9);
        return;
    L17:
        return;
    L6:
        r7 = null;
    L9:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }
}
