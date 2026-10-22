package com.bytedance.applet.aibridge;

import aw3.g0;
import aw3.q0;
import aw3.w;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.applet.audio.background.AppletBackgroundAudioMediaSessionService;
import com.bytedance.applet.audio.background.BackgroundAudioEventName;
import com.bytedance.applet.audio.background.BackgroundAudioPlaybackState;
import com.larus.audioplayer.api.music.MusicPlayManagerDelegate;
import com.larus.utils.logger.FLogger;
import d3.a0;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/AIBridgePlayMusicMethod;", "Lcom/bytedance/applet/aibridge/AbsAIBridgePlayMusicMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/AbsAIBridgePlayMusicMethodIDL$PlayMusicParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/AbsAIBridgePlayMusicMethodIDL$PlayMusicResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIBridgePlayMusicMethod extends AbsAIBridgePlayMusicMethodIDL {
    public AIBridgePlayMusicMethod() {
    }

    public final void handle(e3.d r28, ParamModel r29, f3.h r30) {
        AbsAIBridgePlayMusicMethodIDL.a r2 = (AbsAIBridgePlayMusicMethodIDL.a) r29;
        Intrinsics.checkNotNullParameter(r28, "bridgeContext");
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r30, "callback");
        String r5 = r2.getMusicId();
        String r6 = r2.getVideoModel();
        if (StringsKt.isBlank(r5) == false) goto L5;
    L72:
        f3.h.a.a(r30, "Failed to play music : musicId or videoModel is Empty, musicId = " + r5 + ", videoModel = " + r6, null, null, 14);
        return;
    L5:
        if (StringsKt.isBlank(r6) == true) goto L72;
        if (Intrinsics.areEqual(r2.getTriggerType(), "command") == false) goto L12;
        JSONObject r3 = r2.getTraceInfo();
        if (r3 == null) goto L12;
        i.d.put(r5, r3);
    L12:
        WidgetContainer r4 = (WidgetContainer) r28.d(WidgetContainer.class);
        String r7 = r2.getCallId();
        if (r7 != null) goto L15;
        String r13 = "";
    L16:
        String r8 = r2.getTitle();
        if (r8 != null) goto L19;
        r8 = "";
    L19:
        String r9 = r2.getArtist();
        if (r9 != null) goto L22;
        r9 = "";
    L22:
        Boolean r10 = r2.getDisableFavorite();
        if (r10 == null) goto L25;
        boolean r11 = r10.booleanValue();
    L26:
        Boolean r12 = r2.isFavorite();
        if (r12 == null) goto L29;
        boolean r14 = r12.booleanValue();
    L30:
        Boolean r15 = r2.getEnableHidingSkip();
        if (r15 == null) goto L33;
        boolean r16 = r15.booleanValue();
    L34:
        String r17 = r2.getAlbumArtUrl();
        if (r17 != null) goto L37;
        r17 = "";
    L37:
        if (r4 == null) goto L40;
        String r18 = r4.b;
        if (r18 == null) goto L40;
    L41:
        if (r4 == null) goto L44;
        String r19 = r4.l();
        if (r19 == null) goto L44;
    L45:
        a0 r0 = r28.getContainerContext();
        if (r0 == null) goto L48;
        String r110 = r0.getAppletId();
    L49:
        a88.e r20 = new a88.e(r5, r6, r8, r9, r11, r14, r16, r17, r13, r18, r19, r110, 16);
        w r21 = w.a;
        w.H("stopForAppletMusicTakeover");
        String r22 = w.k;
        if (r22 != null) goto L53;
    L56:
        String r23 = r2.getResolution();
        if (r23 != null) goto L59;
        r23 = "medium";
    L59:
        i r24 = i.a;
        String r25 = r24.k(r23);
        MusicPlayManagerDelegate r111 = MusicPlayManagerDelegate.b;
        String r26 = r2.getMusicId();
        Boolean r27 = r2.getHasPrevious();
        if (r27 == null) goto L62;
        boolean r31 = r27.booleanValue();
    L63:
        Boolean r32 = r2.getHasNext();
        if (r32 == null) goto L66;
        boolean r33 = r32.booleanValue();
    L67:
        j r34 = new j(r26, r33, r31);
        Boolean r35 = r2.getAutoplay();
        if (r35 == null) goto L70;
        boolean r210 = r35.booleanValue();
    L71:
        r111.g(r20, r24, r34, r210, r25);
        Intrinsics.checkNotNullParameter(AbsAIBridgePlayMusicMethodIDL.b.class, "<this>");
        r30.b(k3.c.a(AbsAIBridgePlayMusicMethodIDL.b.class), "");
        return;
    L70:
        r210 = false;
        goto L71
    L66:
        r33 = false;
        goto L67
    L62:
        r31 = false;
        goto L63
    L53:
        if (w.B(r22, w.b) == true) goto L55;
        FLogger.a.i("AppletBackgroundAudioManager", "applet music takeover skipped. owner: " + r22 + ", reason: no active player");
        goto L56
    L55:
        FLogger.a.i("AppletBackgroundAudioManager", "applet music takeover stops background audio. owner: ".concat(r22));
        w.D();
        w.b.e(BackgroundAudioPlaybackState.STOPPED);
        w.b.d(0.0d);
        CopyOnWriteArrayList<Function1<AppletBackgroundAudioMediaSessionService, Unit>> r36 = g0.a;
        g0.c(q0.a(w.b));
        q0 r37 = q0.a(w.b);
        com.bytedance.applet.task.b.a.getClass();
        com.bytedance.applet.task.b.b(r37, r22);
        w.s(r21, BackgroundAudioEventName.STOP, q0.a(w.b), null, r22, 4);
        goto L56
    L48:
        r110 = null;
    L44:
        r19 = "";
    L40:
        r18 = "";
        goto L41
    L33:
        r16 = false;
        goto L34
    L29:
        r14 = false;
        goto L30
    L25:
        r11 = false;
        goto L26
    L15:
        r13 = r7;
        goto L16
    }
}
