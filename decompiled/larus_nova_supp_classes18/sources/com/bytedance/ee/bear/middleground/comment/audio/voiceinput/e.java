package com.bytedance.ee.bear.middleground.comment.audio.voiceinput;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.middleground.comment.export.CommentVoiceHostPolicy;
import com.ss.android.lark.audio.voiceinput.VoiceInputScene;
import com.ss.android.lark.audio.voiceinput.VoiceInputSpeechScene;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static VoiceInputSpeechScene a(com.bytedance.ee.bear.middleground.comment.uitls.p r3) {
        Intrinsics.checkNotNullParameter(r3, "config");
        String r0 = r3.i;
        if ((!StringsKt.isBlank(r0)) == true) goto L6;
        r0 = null;
    L6:
        if (r0 != null) goto L8;
        return null;
    L8:
        int r1 = VoiceInputSpeechScene.b;
        return VoiceInputSpeechScene.Companion.a(r3.k.b + '_' + r0);
    }

    public static CommentImmersiveVoiceTouchDelegate b(com.bytedance.ee.bear.middleground.comment.uitls.p r14) {
        Intrinsics.checkNotNullParameter(r14, "config");
        final Fragment r3 = r14.b;
        if (r3 != null) goto L5;
        return null;
    L5:
        boolean r4 = false;
        if (com.bytedance.ee.bear.middleground.comment.export.e.c() != CommentVoiceHostPolicy.Route.LARK_IM) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        return null;
    L11:
        int r0 = CommentImmersiveVoiceTouchDelegate.w;
        String r2 = r14.i;
        final FragmentActivity r5 = r14.getActivity();
        final com.bytedance.ee.bear.middleground.comment.uitls.h r7 = r14.d0;
        final String r8 = du5.b.g(r14.i);
        final String r9 = r14.k.getType();
        final VoiceInputSpeechScene r10 = a(r14);
        final boolean r15 = true;
        final VoiceInputScene r6 = VoiceInputScene.CcmComment;
        final String r11 = "LARK-PSDA-messenger_record_audio";
        Intrinsics.checkNotNullParameter(r2, "documentToken");
        Intrinsics.checkNotNullParameter(r5, "hostActivity");
        Intrinsics.checkNotNullParameter(r3, "hostFragment");
        Intrinsics.checkNotNullParameter(r6, "voiceInputScene");
        Intrinsics.checkNotNullParameter("LARK-PSDA-messenger_record_audio", "psdaToken");
        Intrinsics.checkNotNullParameter(r8, "fileId");
        Intrinsics.checkNotNullParameter(r9, "fileType");
        tt5.a.h("CommentImmersiveVoiceTouchDelegate", "getOrCreate hostActivity: " + r5 + " hostFragment: " + r3);
        if (r2.length() != 0) goto L14;
        r4 = true;
    L14:
        if (r4 == false) goto L16;
        r2 = r3.getClass().getName();
    L16:
        CommentImmersiveVoiceTouchDelegateStore r12 = (CommentImmersiveVoiceTouchDelegateStore) new ViewModelProvider(r3).get(CommentImmersiveVoiceTouchDelegateStore.class);
        Intrinsics.checkNotNull(r2);
        return r12.getOrCreate(r2, new CommentImmersiveVoiceTouchDelegate$Companion$getOrCreate$1(r5, r3, r15, r6, r11, r7, r8, r9, r10));
    L8:
        r1 = false;
        goto L9
    }
}
