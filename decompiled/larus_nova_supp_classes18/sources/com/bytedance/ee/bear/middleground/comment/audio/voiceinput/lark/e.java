package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.lark;

import android.text.Editable;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentVoiceLog;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase.VoiceKeyboardFunctionEditText;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements Runnable {
    public final /* synthetic */ a a;
    public final /* synthetic */ int b;
    public final /* synthetic */ VoiceKeyboardFunctionEditText c;

    public e(a r1, int r2, VoiceKeyboardFunctionEditText r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        a r0 = this.a;
        if (r0.y.c(this.b, this.c, r0.a.c.c()) == true) goto L6;
        this.a.g();
        return;
    L6:
        Editable r1 = this.c.getText();
        if (r1 != null) goto L9;
    L12:
        boolean r2 = true;
    L13:
        boolean r3 = !r2;
        StringBuilder r4 = new StringBuilder("[advanced] final timeout sessionId=");
        r4.append(this.b);
        r4.append(", hasHiddenVoiceText=");
        r4.append(r3);
        r4.append(", hasVoiceText=");
        r4.append(this.a.y.e);
        r4.append(", ");
        CommentVoiceLog r5 = CommentVoiceLog.a;
        Editable r6 = this.c.getText();
        r5.getClass();
        r4.append(CommentVoiceLog.i("hiddenEditor", r6));
        tt5.a.k("CommentAdvancedAsrInputViewAdapter", r4.toString());
        if (r3 == false) goto L16;
    L17:
        a.a(this.a, true, this.b, this.c);
    L18:
        this.a.g();
        return;
    L16:
        if (this.a.y.e == false) goto L18;
    L9:
        if (StringsKt.isBlank(r1) == true) goto L12;
        r2 = false;
        goto L13
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
