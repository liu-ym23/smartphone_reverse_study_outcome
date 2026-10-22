package com.bytedance.ee.bear.middleground.comment.card;

import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentImmersiveVoiceTouchDelegate;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h0 implements sa5.d {
    public final /* synthetic */ HalfScreenCardComment a;

    public h0(HalfScreenCardComment r1) {
        this.a = r1;
    }

    public final boolean onBackPressed() {
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g r0 = this.a.h();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L10;
        return true;
    L10:
        CommentImmersiveVoiceTouchDelegate r3 = this.a.g();
        if (r3 != null) goto L13;
    L15:
        if (r1 == false) goto L18;
        r3.a();
        return true;
    L18:
        this.a.Ni(true);
        return true;
    L13:
        if (r3.k != true) goto L15;
        r1 = true;
        goto L15
    L5:
        if (r0.a() != true) goto L7;
        r2 = true;
        goto L8
    }
}
