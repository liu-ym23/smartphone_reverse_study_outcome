package com.bytedance.applet.aibridge;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentPublishScene;
import com.larus.audioplayer.api.news.NewsUrlAudioManagerDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/AIBridgeResumeAudioMethod;", "Lcom/bytedance/applet/aibridge/AbsAIBridgeResumeAudioMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/AbsAIBridgeResumeAudioMethodIDL$ResumeAudioParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/AbsAIBridgeResumeAudioMethodIDL$ResumeAudioResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIBridgeResumeAudioMethod extends AbsAIBridgeResumeAudioMethodIDL {
    public AIBridgeResumeAudioMethod() {
    }

    public final void handle(e3.d r17, ParamModel r18, f3.h r19) {
        AbsAIBridgeResumeAudioMethodIDL.a r2 = (AbsAIBridgeResumeAudioMethodIDL.a) r18;
        Intrinsics.checkNotNullParameter(r17, "bridgeContext");
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r19, "callback");
        WidgetContainer r0 = (WidgetContainer) r17.d(WidgetContainer.class);
        if (r0 == null) goto L8;
        String r4 = r0.getAppletId();
        if (r4 == null) goto L8;
        String r6 = r4;
    L9:
        String r8 = r2.getUrl();
        int r7 = r2.getSourceType();
        String r9 = r2.getVideoModel();
        String r10 = r2.getUrl();
        if (r0 == null) goto L15;
        String r3 = r0.getBotId();
        if (r3 == null) goto L15;
        String r11 = r3;
    L17:
        if (r0 == null) goto L19;
        String r13 = r0.b;
    L20:
        if (r0 == null) goto L22;
        String r14 = r0.l();
    L23:
        if (r0 == null) goto L25;
        String r15 = r0.getAppletId();
    L26:
        NewsUrlAudioManagerDelegate.b.i(new b88.d(r6, r7, r8, r9, r10, r11, null, r13, r14, r15), a.a);
        Intrinsics.checkNotNullParameter(AbsAIBridgeResumeAudioMethodIDL.b.class, "<this>");
        r19.b(k3.c.a(AbsAIBridgeResumeAudioMethodIDL.b.class), "");
        return;
    L25:
        r15 = null;
        goto L26
    L22:
        r14 = null;
        goto L23
    L19:
        r13 = null;
    L15:
        r11 = CommentPublishScene.UNKNOWN;
    L8:
        r6 = CommentPublishScene.UNKNOWN;
        goto L9
    }
}
