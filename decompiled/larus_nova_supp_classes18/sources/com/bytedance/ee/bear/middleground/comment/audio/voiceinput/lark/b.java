package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.lark;

import androidx.lifecycle.Observer;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase.VoiceKeyboardFunctionEditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        if (((Boolean) r5).booleanValue() != true) goto L19;
        a r6 = this.a;
        int r0 = r6.z;
        VoiceKeyboardFunctionEditText r1 = r6.g;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r6.y.c(r0, r1, r6.a.c.c()) == false) goto L10;
        d r2 = r6.A;
        if (r2 == null) goto L17;
        r6.r.removeCallbacks(r2);
    L17:
        d r3 = new d(r6, r0, r1);
        r6.A = r3;
        r6.r.post(r3);
        return;
    L10:
        if (r6.y.b(r0, r1) == true) goto L12;
        return;
    L12:
        if (r6.y.a(r6.a.c.c()) == false) goto L21;
        r6.g();
        return;
    L21:
        return;
    }
}
