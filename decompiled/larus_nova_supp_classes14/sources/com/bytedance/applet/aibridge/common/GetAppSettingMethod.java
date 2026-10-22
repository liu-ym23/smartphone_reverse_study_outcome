package com.bytedance.applet.aibridge.common;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/applet/aibridge/common/GetAppSettingMethod;", "Lcom/bytedance/applet/aibridge/common/AbsGetAppSettingMethodIDL;", "<init>", "()V", "TAG", "", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/common/AbsGetAppSettingMethodIDL$GetAppSettingParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/common/AbsGetAppSettingMethodIDL$GetAppSettingResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetAppSettingMethod extends AbsGetAppSettingMethodIDL {
    public final String a;

    public GetAppSettingMethod() {
        this.a = "GetAppSettingMethod";
    }

    public final void handle(d r7, ParamModel r8, h r9) {
        AbsGetAppSettingMethodIDL.a r10 = (AbsGetAppSettingMethodIDL.a) r8;
        Intrinsics.checkNotNullParameter(r7, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r9, "callback");
        String r11 = r10.getKey();
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L5
        Object r13 = Result.constructor-impl(z2.a.P1(r11));     // Catch: Throwable -> L5
    L7:
        Throwable r0 = Result.exceptionOrNull-impl(r13);
        if (r0 != null) goto L12;
        if (r13 != null) goto L11;
        FLogger.a.w(this.a, "setting value is null, key=" + r11);
        h.a.a(r9, "setting value is null", null, null, 14);
        return;
    L11:
        FLogger.a.i(this.a, "key: " + r11 + " settings: " + r13);
        Intrinsics.checkNotNullParameter(AbsGetAppSettingMethodIDL.b.class, "<this>");
        AbsGetAppSettingMethodIDL.b r14 = c.a(AbsGetAppSettingMethodIDL.b.class);
        r14.setValue(r13);
        r9.b(r14, "");
        return;
    L12:
        FLogger.a.e(this.a, "get setting failed, key=" + r11, r0);
        String r15 = r0.getMessage();
        if (r15 != null) goto L15;
        r15 = "get setting failed";
    L15:
        h.a.a(r9, r15, null, null, 14);
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
