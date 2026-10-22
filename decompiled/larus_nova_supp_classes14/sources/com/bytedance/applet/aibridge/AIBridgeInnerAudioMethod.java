package com.bytedance.applet.aibridge;

import android.os.Looper;
import bw3.h0;
import bw3.w;
import bw3.x;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.google.gson.JsonObject;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 /2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J&\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J8\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u00102\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J.\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00102\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J.\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00102\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\f\u0010\u0019\u001a\u00020\u001a*\u00020\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u001d\u001a\u00020\fH\u0002J\u0016\u0010\u001e\u001a\u00020\f*\u00020\u001f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010H\u0002J\u000e\u0010 \u001a\u0004\u0018\u00010\u0010*\u00020\u0007H\u0002J\u000e\u0010!\u001a\u00020\"*\u0004\u0018\u00010#H\u0002J\u0016\u0010$\u001a\u0004\u0018\u00010\u0010*\u00020#2\u0006\u0010%\u001a\u00020\u0010H\u0002J\u001b\u0010&\u001a\u0004\u0018\u00010'*\u00020#2\u0006\u0010%\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010(J\u001b\u0010)\u001a\u0004\u0018\u00010\u001c*\u00020#2\u0006\u0010%\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010*J\u0014\u0010+\u001a\u00020,*\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\u0016\u0010-\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050.H\u0002¨\u00060"}, d2 = {"Lcom/bytedance/applet/aibridge/AIBridgeInnerAudioMethod;", "Lcom/bytedance/applet/aibridge/AbsAIBridgeInnerAudioMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/AbsAIBridgeInnerAudioMethodIDL$InnerAudioParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/AbsAIBridgeInnerAudioMethodIDL$InnerAudioResultModel;", "handleOnMainThread", "callbackWithStateResult", "action", "", "result", "Lcom/bytedance/applet/audio/inner/InnerAudioCommandResult;", "audioId", "appletId", "callbackWithCommandResult", "callbackFailure", "error", "Lcom/bytedance/applet/audio/inner/InnerAudioError;", "toApiErr", "Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;", "requiresAppletId", "", "emptyResultModel", "toResultModel", "Lcom/bytedance/applet/audio/inner/InnerAudioState;", "resolveAppletId", "toStateUpdate", "Lcom/bytedance/applet/audio/inner/InnerAudioStateUpdate;", "Lorg/json/JSONObject;", "stringOrNull", "key", "doubleOrNull", "", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Double;", "booleanOrNull", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Boolean;", "toErrorData", "Lcom/google/gson/JsonObject;", "runOnMainThread", "Lkotlin/Function0;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIBridgeInnerAudioMethod extends AbsAIBridgeInnerAudioMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ContainerType.values().length];
            r0[ContainerType.WORKER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[ContainerType.WIDGET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[ContainerType.PAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[ContainerType.EMBED_WEB_VIEW.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[ContainerType.NONE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    static {
    }

    public AIBridgeInnerAudioMethod() {
    }

    public static AbsAIBridgeInnerAudioMethodIDL.b e(h0 r3, String r4) {
        Intrinsics.checkNotNullParameter(AbsAIBridgeInnerAudioMethodIDL.b.class, "<this>");
        AbsAIBridgeInnerAudioMethodIDL.b r0 = k3.c.a(AbsAIBridgeInnerAudioMethodIDL.b.class);
        r0.setAudioId(r3.a);
        r0.setSrc(r3.b);
        r0.setStartTime(Double.valueOf(r3.f));
        r0.setAutoplay(Boolean.valueOf(r3.c));
        r0.setLoop(Boolean.valueOf(r3.d));
        r0.setVolume(Double.valueOf(r3.k));
        r0.setPlaybackRate(Double.valueOf(r3.l));
        r0.setCurrentTime(Double.valueOf(r3.g));
        r0.setDuration(Double.valueOf(r3.h));
        r0.setPaused(Boolean.valueOf(r3.i));
        r0.setBuffered(Double.valueOf(r3.j));
        r0.setAppletId(r4);
        return r0;
    }

    public final Double d(JSONObject r3, String r4) {
        if (r3.has(r4) == true) goto L5;
    L15:
        return null;
    L5:
        if (r3.isNull(r4) == true) goto L15;
        Double r5 = Double.valueOf(r3.optDouble(r4));
        double r0 = r5.doubleValue();
        if (Double.isInfinite(r0) == false) goto L10;
    L12:
        boolean r6 = false;
    L13:
        if (r6 == false) goto L15;
        return r5;
    L10:
        if (Double.isNaN(r0) == true) goto L12;
        r6 = true;
        goto L13
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.applet.aibridge.e] */
    public final void handle(final e3.d r2, ParamModel r3, final f3.h r4) {
        final AbsAIBridgeInnerAudioMethodIDL.a r5 = (AbsAIBridgeInnerAudioMethodIDL.a) r3;
        Intrinsics.checkNotNullParameter(r2, "bridgeContext");
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        final ?? r0 = new e(this, r2, r5, r4);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r0.invoke();
        return;
    L5:
        y.c(new f(r0));
    }

    public static void b(String r4, x r5, String r6, f3.h r7) {
        int r0 = r5.a;
        if (r0 != x.i.a) goto L5;
    L17:
        f3.a r1 = f3.a.h;
    L18:
        FLogger.a.e("AIBridgeInnerAudioMethod", "call failed, errNo=" + r1.a + ", bizErrNo=" + r5.a + ", action=" + r4 + ", audioId=" + r6 + ", msg=" + r5.b);
        String r8 = r5.b;
        JsonObject r2 = new JsonObject();
        r2.addProperty("audioId", r6);
        r2.addProperty("errCode", Integer.valueOf(r5.a));
        r2.addProperty("errMsg", r5.b);
        f3.h.a.a(r7, r8, r1, r2, 2);
        return;
    L5:
        if (r0 == x.e.a) goto L17;
        if (r0 == x.f.a) goto L17;
        if (r0 == x.j.a) goto L17;
        if (r0 == x.k.a) goto L17;
        if (r0 != x.d.a) goto L16;
        r1 = f3.a.q;
        goto L18
    L16:
        r1 = f3.a.f;
        goto L18
    }

    public static void c(String r2, w r3, String r4, f3.h r5) {
        if (r3.a() == false) goto L6;
        FLogger.a.i("AIBridgeInnerAudioMethod", "call success, action=" + r2 + ", audioId=" + r4);
        Intrinsics.checkNotNullParameter(AbsAIBridgeInnerAudioMethodIDL.b.class, "<this>");
        r5.b(k3.c.a(AbsAIBridgeInnerAudioMethodIDL.b.class), "");
        return;
    L6:
        x r6 = r3.b;
        if (r6 != null) goto L9;
        r6 = x.g;
    L9:
        b(r2, r6, r4, r5);
    }
}
