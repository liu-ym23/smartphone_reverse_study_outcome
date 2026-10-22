package com.bytedance.applet.aibridge.timer;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.audioplayer.api.manager.AudioStopTimerManagerDelegate;
import com.larus.utils.logger.FLogger;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/aibridge/timer/GetAudioStopTimerInfoMethod;", "Lcom/bytedance/applet/aibridge/timer/AbsGetAudioStopTimerInfoMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/timer/AbsGetAudioStopTimerInfoMethodIDL$GetAudioStopTimerInfoMethodParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/timer/AbsGetAudioStopTimerInfoMethodIDL$GetAudioStopTimerInfoMethodResultModel;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetAudioStopTimerInfoMethod extends AbsGetAudioStopTimerInfoMethodIDL {

    public static final class a {
    }

    static {
    }

    public GetAudioStopTimerInfoMethod() {
    }

    public final void handle(d r8, ParamModel r9, h r10) {
        AbsGetAudioStopTimerInfoMethodIDL.a r11 = (AbsGetAudioStopTimerInfoMethodIDL.a) r9;
        Intrinsics.checkNotNullParameter(r8, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r10, "callback");
        String r12 = r11.getScene();
        Intrinsics.checkNotNullParameter(AbsGetAudioStopTimerInfoMethodIDL.b.class, "<this>");
        AbsGetAudioStopTimerInfoMethodIDL.b r13 = c.a(AbsGetAudioStopTimerInfoMethodIDL.b.class);
        AudioStopTimerManagerDelegate r0 = AudioStopTimerManagerDelegate.b;
        if (r0.a().contains(r12) == true) goto L5;
        FLogger.a.i("GetAudioStopTimerInfoMethod", "wrong scene: " + r12);
        r10.b(r13, "");
        return;
    L5:
        Long r1 = r0.b(r12);
        if (r1 == null) goto L8;
        boolean r2 = true;
    L9:
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("get timer info of ");
        r5.append(r12);
        r5.append(" with switch ");
        r5.append(r2);
        r5.append(", stopTime: ");
        if (r1 != null) goto L12;
        Object r14 = "disabled";
    L13:
        r5.append(r14);
        r4.i("GetAudioStopTimerInfoMethod", r5.toString());
        r13.setSwitch(r2);
        r13.setStopTime(r1);
        r10.b(r13, "");
        return;
    L12:
        r14 = r1;
        goto L13
    L8:
        r2 = false;
        goto L9
    }
}
