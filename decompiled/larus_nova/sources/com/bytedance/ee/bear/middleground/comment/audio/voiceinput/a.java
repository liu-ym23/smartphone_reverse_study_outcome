package com.bytedance.ee.bear.middleground.comment.audio.voiceinput;

import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.s;
import com.ss.android.lark.widget.richtext.RichText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentImmersiveVoiceTouchDelegate f230391a;

    public a(CommentImmersiveVoiceTouchDelegate r100) {
        this.f230391a = r100;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.s
    public final void c(com.ss.android.lark.audio.voiceinput.s r100) {
        Intrinsics.checkNotNullParameter(r100, "voiceRecordEntity");
        s r101 = this.f230391a.f230358n;
        if (r101 == null) goto L6;
        r101.c(r100);
        return;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.s
    public final void a(com.ss.android.lark.audio.voiceinput.s r100, String r101, RichText r102) {
        Intrinsics.checkNotNullParameter(r100, "voiceRecordEntity");
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r102, "richText");
        s r103 = this.f230391a.f230358n;
        if (r103 == null) goto L6;
        r103.a(r100, r101, r102);
        return;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.s
    public final void b(com.ss.android.lark.audio.voiceinput.s r100, String r101, RichText r102) {
        Intrinsics.checkNotNullParameter(r100, "voiceRecordEntity");
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r102, "richText");
        s r103 = this.f230391a.f230358n;
        if (r103 == null) goto L6;
        r103.b(r100, r101, r102);
        return;
    }
}
