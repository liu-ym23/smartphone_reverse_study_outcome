package com.bytedance.android.livesdk.livecommerce.utils;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.android.ec.core.monitor.process.ProcessDomain;
import com.bytedance.android.livesdk.livecommerce.model.ECV2PopupInfo;
import com.bytedance.android.livesdk.livecommerce.network.response.ECFlashPermissionInfoResponse;
import com.bytedance.android.livesdk.livecommerce.network.response.FlashPermissionStatus;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k0 implements vi2.v0<ECFlashPermissionInfoResponse> {
    public final /* synthetic */ Context a;
    public final /* synthetic */ long b;
    public final /* synthetic */ Function0 c;

    @Override // vi2.v0
    public final void onError(Throwable r1) {
        this.c.invoke();
    }

    @Override // vi2.v0
    public final void onSuccess(ECFlashPermissionInfoResponse r9) {
        ECFlashPermissionInfoResponse r10 = r9;
        Object r0 = null;
        if (r10 == null) goto L5;
        ECV2PopupInfo r1 = r10.getPopupInfo();
    L6:
        if (r1 == null) goto L34;
        Integer r2 = r10.getStatus();
        int r3 = FlashPermissionStatus.NOT_OPEN_YET.getStatus();
        if (r2 != null) goto L11;
    L12:
        Integer r4 = r10.getStatus();
        int r5 = FlashPermissionStatus.OFF.getStatus();
        if (r4 != null) goto L16;
    L17:
        Integer r6 = r10.getStatus();
        int r7 = FlashPermissionStatus.PAUSED.getStatus();
        if (r6 == null) goto L34;
        if (r6.intValue() != r7) goto L34;
    L22:
        Context r8 = this.a;
        if (r8 == null) goto L36;
        int r11 = com.bytedance.android.livesdk.livecommerce.room.widgets.shortcut.b.a;
        com.bytedance.android.livesdk.livecommerce.room.widgets.shortcut.b.a(r8, r10.getPopupInfo());
    L36:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L27
        Object r13 = Result.constructor-impl(new JSONObject().put("log_id", r10.getRequestId()));     // Catch: Throwable -> L27
    L30:
        if (Result.isFailure-impl(r13) == true) goto L33;
        r0 = r13;
    L33:
        int r14 = lh.b.a;
        lh.b.d(ProcessDomain.LIVE, "闪购点击被拦截", SystemClock.elapsedRealtime() - this.b, (JSONObject) r0, 16);
        return;
    L27:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    L16:
        if (r4.intValue() == r5) goto L22;
    L11:
        if (r2.intValue() == r3) goto L22;
    L34:
        this.c.invoke();
        return;
    L5:
        r1 = null;
        goto L6
    }

    public k0(Context r1, long r2, Function0 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }
}
