package com.bytedance.applet.aibridge;

import android.os.Looper;
import aw3.l0;
import aw3.m0;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.google.gson.JsonObject;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J&\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J&\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J&\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\f\u0010\u0016\u001a\u00020\u0017*\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u001a\u001a\u00020\fH\u0002J\u0016\u0010\u001b\u001a\u00020\f*\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0010H\u0002J\u000e\u0010\u001e\u001a\u0004\u0018\u00010\u0010*\u00020\u0007H\u0002J\u000e\u0010\u001f\u001a\u00020 *\u0004\u0018\u00010!H\u0002J\u0016\u0010\"\u001a\u0004\u0018\u00010\u0010*\u00020!2\u0006\u0010#\u001a\u00020\u0010H\u0002J\u001b\u0010$\u001a\u0004\u0018\u00010%*\u00020!2\u0006\u0010#\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010&J\f\u0010'\u001a\u00020(*\u00020\u0015H\u0002J\u0016\u0010)\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050*H\u0002¨\u0006,"}, d2 = {"Lcom/bytedance/applet/aibridge/AIBridgeBackgroundAudioMethod;", "Lcom/bytedance/applet/aibridge/AbsAIBridgeBackgroundAudioMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/AbsAIBridgeBackgroundAudioMethodIDL$BackgroundAudioParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/AbsAIBridgeBackgroundAudioMethodIDL$BackgroundAudioResultModel;", "handleOnMainThread", "callbackWithCommandResult", "action", "", "result", "Lcom/bytedance/applet/audio/background/BackgroundAudioCommandResult;", "callbackFailure", "error", "Lcom/bytedance/applet/audio/background/BackgroundAudioError;", "toApiErr", "Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;", "requiresAppletId", "", "emptyResultModel", "toResultModel", "Lcom/bytedance/applet/audio/background/BackgroundAudioState;", "appletId", "resolveAppletId", "toStateUpdate", "Lcom/bytedance/applet/audio/background/BackgroundAudioStateUpdate;", "Lorg/json/JSONObject;", "stringOrNull", "key", "doubleOrNull", "", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Double;", "toErrorData", "Lcom/google/gson/JsonObject;", "runOnMainThread", "Lkotlin/Function0;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIBridgeBackgroundAudioMethod extends AbsAIBridgeBackgroundAudioMethodIDL {
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

    public AIBridgeBackgroundAudioMethod() {
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

    public final String e(JSONObject r2, String r3) {
        if (r2.has(r3) == true) goto L5;
    L7:
        return null;
    L5:
        if (r2.isNull(r3) == true) goto L7;
        return r2.optString(r3);
    }

    public static void b(String r4, m0 r5, f3.h r6) {
        int r0 = r5.a;
        if (r0 != (-1007)) goto L5;
    L9:
        f3.a r1 = f3.a.h;
    L10:
        FLogger.a.e("AIBridgeBackgroundAudioMethod", "call failed, errNo=" + r1.a + ", bizErrNo=" + r5.a + ", action=" + r4 + ", msg=" + r5.b);
        String r7 = r5.b;
        JsonObject r2 = new JsonObject();
        r2.addProperty("errCode", Integer.valueOf(r5.a));
        r2.addProperty("errMsg", r5.b);
        f3.h.a.a(r6, r7, r1, r2, 2);
        return;
    L5:
        if (r0 == (-1006)) goto L9;
        if (r0 == (-1001)) goto L9;
        r1 = f3.a.f;
        goto L10
    }

    public static void c(String r1, l0 r2, f3.h r3) {
        m0 r4 = r2.b;
        if (r4 != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        FLogger.a.i("AIBridgeBackgroundAudioMethod", "call success, action=".concat(r1));
        Intrinsics.checkNotNullParameter(AbsAIBridgeBackgroundAudioMethodIDL.b.class, "<this>");
        r3.b(k3.c.a(AbsAIBridgeBackgroundAudioMethodIDL.b.class), "");
        return;
    L9:
        if (r4 != null) goto L11;
        r4 = m0.f;
    L11:
        b(r1, r4, r3);
        return;
    L5:
        r0 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.applet.aibridge.c] */
    public final void handle(final e3.d r2, ParamModel r3, final f3.h r4) {
        final AbsAIBridgeBackgroundAudioMethodIDL.a r5 = (AbsAIBridgeBackgroundAudioMethodIDL.a) r3;
        Intrinsics.checkNotNullParameter(r2, "bridgeContext");
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        final ?? r0 = new c(this, r2, r5, r4);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r0.invoke();
        return;
    L5:
        y.c(new d(r0));
    }
}
