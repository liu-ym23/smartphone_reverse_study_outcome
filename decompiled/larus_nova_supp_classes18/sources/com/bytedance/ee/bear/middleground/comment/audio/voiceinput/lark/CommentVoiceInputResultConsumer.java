package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.lark;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentVoiceLog;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.richtext.CommentVoiceEditTextBridge;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.s;
import com.ss.android.lark.widget.richtext.RichText;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class CommentVoiceInputResultConsumer implements s {
    public final CommentVoiceEditTextBridge a;
    public final Context b;
    public final Function1<CharSequence, Unit> c;
    public final boolean d;
    public final Function0<Unit> e;

    public CommentVoiceInputResultConsumer() {
        this(null, null, null, null, 31);
    }

    public final void c(com.ss.android.lark.audio.voiceinput.s r2) {
        Intrinsics.checkNotNullParameter(r2, "voiceRecordEntity");
    }

    public final void a(com.ss.android.lark.audio.voiceinput.s r4, String r5, RichText r6) {
        Intrinsics.checkNotNullParameter(r4, "voiceRecordEntity");
        Intrinsics.checkNotNullParameter(r5, "content");
        Intrinsics.checkNotNullParameter(r6, "richText");
        StringBuilder r0 = new StringBuilder("[consumer] onlyText result writeBack=");
        r0.append(this.d);
        r0.append(", ");
        CommentVoiceLog.a.getClass();
        r0.append(CommentVoiceLog.i("content", r5));
        r0.append(", ");
        r0.append(CommentVoiceLog.f(r6));
        tt5.a.h("CommentVoice", r0.toString());
        Function1<CharSequence, Unit> r7 = this.c;
        if (r7 != null) goto L5;
        boolean r8 = false;
    L6:
        if (r8 == false) goto L9;
        return;
    L9:
        if (this.d == true) goto L11;
        return;
    L11:
        d(r5, r6, new CommentVoiceInputResultConsumer$consumeWithOnlyText$1(this));
        return;
    L5:
        d(r5, r6, new CommentVoiceInputResultConsumer$sendDirectly$1(r7));
        r8 = true;
        goto L6
    }

    public final void b(com.ss.android.lark.audio.voiceinput.s r3, String r4, RichText r5) {
        Intrinsics.checkNotNullParameter(r3, "voiceRecordEntity");
        Intrinsics.checkNotNullParameter(r4, "content");
        Intrinsics.checkNotNullParameter(r5, "richText");
        StringBuilder r0 = new StringBuilder("[consumer] voiceAndText result, ");
        CommentVoiceLog.a.getClass();
        r0.append(CommentVoiceLog.i("content", r4));
        r0.append(", ");
        r0.append(CommentVoiceLog.f(r5));
        tt5.a.h("CommentVoice", r0.toString());
        Function1<CharSequence, Unit> r6 = this.c;
        if (r6 == null) goto L7;
        d(r4, r5, new CommentVoiceInputResultConsumer$sendDirectly$1(r6));
        return;
    }

    public final void d(String r4, RichText r5, Function1<? super CharSequence, Unit> r6) {
        CommentVoiceEditTextBridge r0 = this.a;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNullParameter(r4, "content");
        Intrinsics.checkNotNullParameter(r5, "richText");
        SpannableStringBuilder r7 = CommentVoiceEditTextBridge.a.a(r0.a.getContext(), r4, r5);
    L9:
        if (r7 != null) goto L11;
        StringBuilder r8 = new StringBuilder("[consumer] use plain ASR content; edit bridge unavailable, ");
        CommentVoiceLog.a.getClass();
        r8.append(CommentVoiceLog.i("content", r4));
        tt5.a.k("CommentVoice", r8.toString());
        r6.invoke(r4);
        return;
    L11:
        r6.invoke(r7);
        return;
    L5:
        Context r1 = this.b;
        if (r1 == null) goto L8;
        int r2 = CommentVoiceEditTextBridge.i;
        r7 = CommentVoiceEditTextBridge.a.a(r1, r4, r5);
        goto L9
    L8:
        r7 = null;
        goto L9
    }

    public CommentVoiceInputResultConsumer(CommentVoiceEditTextBridge r3, Context r4, Function1 r5, Function0 r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r7 & 8) == 0) goto L14;
        boolean r0 = true;
    L16:
        if ((r7 & 16) == 0) goto L18;
        r6 = null;
    L18:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r0;
        this.e = r6;
        return;
    L14:
        r0 = false;
        goto L16
    }
}
