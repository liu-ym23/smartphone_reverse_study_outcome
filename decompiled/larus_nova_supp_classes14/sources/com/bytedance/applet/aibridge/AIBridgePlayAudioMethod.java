package com.bytedance.applet.aibridge;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentPublishScene;
import com.larus.audioplayer.api.news.NewsUrlAudioManagerDelegate;
import d3.a0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/aibridge/AIBridgePlayAudioMethod;", "Lcom/bytedance/applet/aibridge/AbsAIBridgePlayAudioMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/AbsAIBridgePlayAudioMethodIDL$PlayAudioParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/AbsAIBridgePlayAudioMethodIDL$PlayAudioResultModel;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIBridgePlayAudioMethod extends AbsAIBridgePlayAudioMethodIDL {

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ContainerType.values().length];
            r0[ContainerType.WORKER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ContainerType.WIDGET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ContainerType.PAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public AIBridgePlayAudioMethod() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v19, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v30 */
    public final void handle(e3.d r22, ParamModel r23, f3.h r24) {
        AbsAIBridgePlayAudioMethodIDL.a r2 = (AbsAIBridgePlayAudioMethodIDL.a) r23;
        Intrinsics.checkNotNullParameter(r22, "bridgeContext");
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r24, "callback");
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L44
        a0 r7 = r22.getContainerContext();     // Catch: Throwable -> L44
        if (r7 == null) goto L6;
        ContainerType r8 = r7.getContainerType();     // Catch: Throwable -> L44
    L7:
        if (r8 != null) goto L9;
        ?? r9 = -1;
    L85:
        if (r9 != 1) goto L12;
        AppletRuntime r0 = (AppletRuntime) r22.d(AppletRuntime.class);     // Catch: Throwable -> L44
        if (r0 == null) goto L37;
        String r10 = r0.h.K;     // Catch: Throwable -> L44
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L35
        String r11 = r10;
    L39:
        String r12 = null;
        String r13 = null;
        r9 = r11;
    L40:
        Result.constructor-impl(r1);     // Catch: Throwable -> L42
        ?? r14 = r9;
    L48:
        ?? r19 = r14;
        String r17 = r12;
        String r18 = r13;
        String r3 = r2.getScene();     // Catch: JSONException -> L72
        if (r3 != null) goto L51;
        r3 = CommentPublishScene.UNKNOWN;
    L51:
        String r15 = r3;
        String r16 = r2.getUrl();     // Catch: JSONException -> L72
        int r110 = r2.getSourceType();     // Catch: JSONException -> L72
        String r111 = r2.getVideoModel();     // Catch: JSONException -> L72
        String r112 = r2.getTitle();     // Catch: JSONException -> L72
        String r113 = r2.getArtist();     // Catch: JSONException -> L72
        String r4 = r2.getAlbumArtUrl();     // Catch: JSONException -> L72
        if (r4 != null) goto L54;
    L57:
        boolean r5 = true;
    L58:
        if (r5 == false) goto L60;
        String r114 = null;
    L61:
        b88.d r20 = new b88.d(r15, r110, r16, r111, r112, r113, r114, r17, r18, r19, r2.getExtra());     // Catch: JSONException -> L72
        com.bytedance.ai.utils.g r21 = com.bytedance.ai.utils.g.a;     // Catch: JSONException -> L72
        r21.e(this.a, "url play, url=" + r2.getUrl());     // Catch: JSONException -> L75
        if ((!StringsKt.isBlank(r2.getUrl())) == true) goto L66;
    L70:
        NewsUrlAudioManagerDelegate.b.i(r20, com.bytedance.applet.aibridge.a.a);     // Catch: JSONException -> L75
        Intrinsics.checkNotNullParameter(AbsAIBridgePlayAudioMethodIDL.b.class, "<this>");     // Catch: JSONException -> L75
        r24.b(k3.c.a(AbsAIBridgePlayAudioMethodIDL.b.class), "");     // Catch: JSONException -> L75
        return;
    L66:
        if (Intrinsics.areEqual("news", r2.getScene()) == false) goto L70;
        JSONObject r25 = r2.getTraceInfo();     // Catch: JSONException -> L75
        if (r25 == null) goto L70;
        com.bytedance.applet.aibridge.a.b.put(r2.getUrl(), r25);     // Catch: JSONException -> L75
    L73:
        f3.h.a.a(r24, "Invalid extra params", null, null, 14);
        return;
    L60:
        r114 = r2.getAlbumArtUrl();     // Catch: JSONException -> L72
        goto L61
    L54:
        if (StringsKt.isBlank(r4) == true) goto L57;
        r5 = false;
    L42:
        th = th;
    L76:
        Result.Companion r26 = Result.Companion;     // Catch: JSONException -> L72
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: JSONException -> L72
        r14 = r9;
    L37:
        r1 = null;
    L38:
        r11 = null;
        goto L39
    L12:
        if (r9 != 2) goto L14;
        WidgetContainer r27 = (WidgetContainer) r22.d(WidgetContainer.class);     // Catch: Throwable -> L44
        if (r27 == null) goto L37;
        r9 = r27.getAppletId();     // Catch: Throwable -> L44
        r12 = r27.b;     // Catch: Throwable -> L35
        r13 = r27.l();     // Catch: Throwable -> L28
        r1 = Unit.INSTANCE;     // Catch: Throwable -> L42
        r9 = r9;
    L28:
        th = th;
        r13 = null;
        goto L76
    L14:
        if (r9 == 3) goto L16;
        r1 = Unit.INSTANCE;     // Catch: Throwable -> L44
        goto L38
    L16:
        k2.j r28 = (k2.j) r22.d(k2.j.class);     // Catch: Throwable -> L44
        if (r28 == null) goto L37;
        String r29 = r28.getAppletId();     // Catch: Throwable -> L44
        r1 = Unit.INSTANCE;     // Catch: Throwable -> L35
        r11 = r29;
    L35:
        th = th;
    L46:
        r12 = null;
        r13 = null;
        goto L76
    L9:
        r9 = b.a[r8.ordinal()];     // Catch: Throwable -> L44
        goto L85
    L6:
        r8 = null;
    L44:
        th = th;
        r9 = 0;
        goto L46
    }
}
