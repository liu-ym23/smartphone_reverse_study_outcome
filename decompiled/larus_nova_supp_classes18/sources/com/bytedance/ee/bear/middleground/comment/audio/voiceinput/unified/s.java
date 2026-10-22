package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentVoiceExtraAnalyticParams;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.ss.android.lark.voiceinput.api.data.context.VoiceScene;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s implements c {
    public static final s a = null;

    static {
        a = new s();
    }

    public s() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.c
    public final r a(e r10) {
        Intrinsics.checkNotNullParameter(r10, "request");
        com.ss.android.lark.voiceinput.api.provider.a.a r1 = com.ss.android.lark.voiceinput.api.provider.a.U1;
        Intrinsics.checkNotNullParameter(r10, "request");
        CommentVoiceExtraAnalyticParams r0 = CommentVoiceExtraAnalyticParams.a;
        CommentVoiceExtraAnalyticParams.b(r10.a, r10.c, r10.d);
        tac.a r2 = new tac.a(new wac.a(r10.b, 959), new uac.a(new vac.a(r10.f, 30), 47));
        Fragment r3 = r10.a;
        dbc.c r4 = r10.g;
        xac.a r5 = new xac.a();
        r5.c("conversation_id", r10.c);
        r5.c("trace_id", r10.e);
        r5.c("voice_scene", VoiceScene.DOC);
        r5.c("enter_from", "ccm_comment");
        r5.c("extra_analytic_params", CommentVoiceExtraAnalyticParams.a(r10.a));
        com.ss.android.lark.voiceinput.api.provider.c.a r6 = new com.ss.android.lark.voiceinput.api.provider.c.a(r2, r3, r4, r5);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "presentation");
        com.ss.android.lark.voiceinput.api.provider.a r7 = ((com.ss.android.lark.voiceinput.api.provider.b) ClaymoreServiceLoader.loadFirst(com.ss.android.lark.voiceinput.api.provider.b.class)).createVoiceComponent(r6);
        LifecycleCoroutineScope r8 = LifecycleOwnerKt.getLifecycleScope(r10.a);
        i1 r9 = r7.getResults();
        d1 r11 = r7.getEvents();
        i1 r12 = r7.k();
        DefaultCommentUnifiedVoiceComponentAdvancedProviderFactory$create$observerJob$1 r13 = new DefaultCommentUnifiedVoiceComponentAdvancedProviderFactory$create$observerJob$1(r7);
        b r14 = r10.h;
        return new r(r7, j.a(r8, r9, r11, r12, r13, new h(r14.a, r14.b, r14.c)));
    }
}
