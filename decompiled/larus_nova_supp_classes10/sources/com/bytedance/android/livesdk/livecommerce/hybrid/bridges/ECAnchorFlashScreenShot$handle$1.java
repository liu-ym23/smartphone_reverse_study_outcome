package com.bytedance.android.livesdk.livecommerce.hybrid.bridges;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.FlashController;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "filePath", "", "errorReason", "invoke"}, k = 3, mv = {1, 4, 3})
public final class ECAnchorFlashScreenShot$handle$1 extends Lambda implements Function2<String, String, Unit> {
    final /* synthetic */ FlashController $controller;
    final /* synthetic */ ECBaseBridgeMethod.a $iReturn;
    final /* synthetic */ ECAnchorFlashScreenShot this$0;

    public ECAnchorFlashScreenShot$handle$1(ECAnchorFlashScreenShot r1, FlashController r2, ECBaseBridgeMethod.a r3) {
        this.this$0 = r1;
        this.$controller = r2;
        this.$iReturn = r3;
        super(2);
    }

    public final void invoke(String r9, String r10) {
        dm.a.a("ECAnchorFlashScreenShot").a("filePath = " + r9 + " errorReason = " + r10);
        if (r9 != null) goto L5;
    L8:
        boolean r11 = true;
    L9:
        if (r11 == false) goto L19;
        return;
    L19:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        Object r12 = Result.constructor-impl(BuildersKt.launch$default(this.$controller.a, null, null, new ECAnchorFlashScreenShot$handle$1$$special$$inlined$runCatching$lambda$1(null, this, r9), 3, null));     // Catch: Throwable -> L13
    L16:
        if (Result.exceptionOrNull-impl(r12) == null) goto L22;
        dm.a.a("ECAnchorFlashScreenShot").b("error", null);
        return;
    L22:
        return;
    L13:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L5:
        if (r9.length() == 0) goto L8;
        r11 = false;
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((String) r1, (String) r2);
        return Unit.INSTANCE;
    }
}
