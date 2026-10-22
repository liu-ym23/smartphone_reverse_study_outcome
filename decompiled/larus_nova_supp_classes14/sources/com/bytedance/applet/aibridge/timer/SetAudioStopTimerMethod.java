package com.bytedance.applet.aibridge.timer;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.google.gson.JsonObject;
import com.larus.audioplayer.api.manager.AudioStopTimerManagerDelegate;
import com.larus.utils.logger.FLogger;
import f3.h;
import k3.c;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import l3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/applet/aibridge/timer/SetAudioStopTimerMethod;", "Lcom/bytedance/applet/aibridge/timer/AbsSetAudioStopTimerMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/timer/AbsSetAudioStopTimerMethodIDL$SetAudioStopTimerMethodParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/timer/AbsSetAudioStopTimerMethodIDL$SetAudioStopTimerMethodResultModel;", "Companion", "AudioStopTimerCallbackImpl", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SetAudioStopTimerMethod extends AbsSetAudioStopTimerMethodIDL {

    public static final class a implements z78.a {
        public a() {
        }

        public final void a(String r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "scene");
            Lazy r1 = d.a;
            JsonObject r2 = new JsonObject();
            r2.addProperty("scene", r3);
            r2.addProperty("timerResult", Integer.valueOf(r4));
            Unit r5 = Unit.INSTANCE;
            d.c(new l3.a("flow.audioStopTimerOver", r2, 4));
        }
    }

    public static final class b {
    }

    static {
    }

    public SetAudioStopTimerMethod() {
    }

    public final void handle(e3.d r10, ParamModel r11, h r12) {
        AbsSetAudioStopTimerMethodIDL.a r13 = (AbsSetAudioStopTimerMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        String r14 = r13.getScene();
        Intrinsics.checkNotNullParameter(AbsSetAudioStopTimerMethodIDL.b.class, "<this>");
        AbsSetAudioStopTimerMethodIDL.b r0 = c.a(AbsSetAudioStopTimerMethodIDL.b.class);
        AudioStopTimerManagerDelegate r1 = AudioStopTimerManagerDelegate.b;
        if (r1.a().contains(r14) == true) goto L6;
        FLogger.a.i("SetAudioStopTimerMethod", "wrong scene: " + r14);
        r12.b(r0, "");
        return;
    L6:
        if (r1.c(r14) == false) goto L9;
        FLogger.a.i("SetAudioStopTimerMethod", "disable timer for " + r14 + ", switch: " + r13.getSwitch());
    L9:
        if (r13.getSwitch() == true) goto L11;
        r0.setResult(true);
        r12.b(r0, "");
        return;
    L11:
        Long r15 = r13.getDuration();
        if (r15 == null) goto L14;
        long r6 = r15.longValue();
        r1.d(r14, r6, new a());
        Long r16 = r1.b(r14);
        FLogger.a.i("SetAudioStopTimerMethod", "enable timer for " + r14 + " with duration " + r6 + ", stopTime: " + r16);
        r0.setResult(true);
        r0.setStopTime(r16);
        r12.b(r0, "");
        return;
    L14:
        FLogger.a.i("SetAudioStopTimerMethod", "param duration is null");
        r12.b(r0, "");
    }
}
