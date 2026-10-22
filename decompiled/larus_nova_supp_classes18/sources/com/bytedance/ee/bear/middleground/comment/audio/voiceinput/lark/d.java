package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.lark;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase.VoiceKeyboardFunctionEditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements Runnable {
    public final /* synthetic */ a a;
    public final /* synthetic */ int b;
    public final /* synthetic */ VoiceKeyboardFunctionEditText c;

    public d(a r1, int r2, VoiceKeyboardFunctionEditText r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        a r0 = this.a;
        if (r0.y.c(this.b, this.c, r0.a.c.c()) == false) goto L5;
        a.a(this.a, true, this.b, this.c);
        this.a.g();
        return;
    L5:
        if (this.a.y.b(this.b, this.c) == false) goto L12;
        a r1 = this.a;
        if (r1.y.a(r1.a.c.c()) == false) goto L13;
        this.a.g();
        return;
    L13:
        return;
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
