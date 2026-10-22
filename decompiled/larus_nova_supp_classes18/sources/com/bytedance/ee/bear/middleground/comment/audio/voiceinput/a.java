package com.bytedance.ee.bear.middleground.comment.audio.voiceinput;

import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.s;
import com.ss.android.lark.widget.richtext.RichText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements s {
    public final /* synthetic */ CommentImmersiveVoiceTouchDelegate a;

    public a(CommentImmersiveVoiceTouchDelegate r1) {
        this.a = r1;
    }

    public final void c(com.ss.android.lark.audio.voiceinput.s r2) {
        Intrinsics.checkNotNullParameter(r2, "voiceRecordEntity");
        s r0 = this.a.n;
        if (r0 == null) goto L6;
        r0.c(r2);
        return;
    }

    public final void a(com.ss.android.lark.audio.voiceinput.s r2, String r3, RichText r4) {
        Intrinsics.checkNotNullParameter(r2, "voiceRecordEntity");
        Intrinsics.checkNotNullParameter(r3, "content");
        Intrinsics.checkNotNullParameter(r4, "richText");
        s r0 = this.a.n;
        if (r0 == null) goto L6;
        r0.a(r2, r3, r4);
        return;
    }

    public final void b(com.ss.android.lark.audio.voiceinput.s r2, String r3, RichText r4) {
        Intrinsics.checkNotNullParameter(r2, "voiceRecordEntity");
        Intrinsics.checkNotNullParameter(r3, "content");
        Intrinsics.checkNotNullParameter(r4, "richText");
        s r0 = this.a.n;
        if (r0 == null) goto L6;
        r0.b(r2, r3, r4);
        return;
    }
}
