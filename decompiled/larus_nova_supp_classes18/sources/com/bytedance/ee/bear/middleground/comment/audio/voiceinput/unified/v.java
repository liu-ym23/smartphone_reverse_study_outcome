package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentVoiceExtraAnalyticParams;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.ss.android.lark.voiceinput.api.data.config.asr.resultConfig.VoiceAsrMode;
import com.ss.android.lark.voiceinput.api.data.context.VoiceScene;
import com.ss.android.lark.voiceinput.api.provider.DefaultVoiceComponentProvider;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v implements n {
    public static final v a = null;

    static {
        a = new v();
    }

    public v() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.n
    public final u a(p r11) {
        Intrinsics.checkNotNullParameter(r11, "request");
        com.ss.android.lark.voiceinput.api.provider.a.a r1 = com.ss.android.lark.voiceinput.api.provider.a.U1;
        Intrinsics.checkNotNullParameter(r11, "request");
        CommentVoiceExtraAnalyticParams r0 = CommentVoiceExtraAnalyticParams.a;
        CommentVoiceExtraAnalyticParams.b(r11.a, r11.c, r11.d);
        tac.a r2 = new tac.a(new wac.a(r11.b, 959), new uac.a(new vac.a(VoiceAsrMode.FinalOnly, 30), 47));
        Fragment r3 = r11.a;
        xac.a r4 = new xac.a();
        r4.c("conversation_id", r11.c);
        r4.c("trace_id", r11.e);
        r4.c("voice_scene", VoiceScene.DOC);
        r4.c("enter_from", "ccm_comment");
        r4.c("extra_analytic_params", CommentVoiceExtraAnalyticParams.a(r11.a));
        com.ss.android.lark.voiceinput.api.provider.c.b r5 = new com.ss.android.lark.voiceinput.api.provider.c.b(r2, r3, r4);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "presentation");
        com.ss.android.lark.voiceinput.api.provider.a r6 = ((com.ss.android.lark.voiceinput.api.provider.b) ClaymoreServiceLoader.loadFirst(com.ss.android.lark.voiceinput.api.provider.b.class)).createVoiceComponent(r5);
        DefaultVoiceComponentProvider.touchListener.1 r7 = r6.i();
        LifecycleCoroutineScope r8 = LifecycleOwnerKt.getLifecycleScope(r11.a);
        i1 r9 = r6.getResults();
        d1 r10 = r6.getEvents();
        i1 r12 = r6.k();
        DefaultCommentUnifiedVoiceComponentSimpleProviderFactory$create$observerJob$1 r13 = new DefaultCommentUnifiedVoiceComponentSimpleProviderFactory$create$observerJob$1(r6);
        m r14 = r11.f;
        return new u(r6, r7, j.a(r8, r9, r10, r12, r13, new h(r14.a, r14.b, r14.c)));
    }
}
