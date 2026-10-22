package com.bytedance.ee.bear.middleground.comment.input;

import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentImmersiveVoiceTouchDelegate;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements sa5.d {
    public final /* synthetic */ AsideInputComment a;

    public e(AsideInputComment r1) {
        this.a = r1;
    }

    public final boolean onBackPressed() {
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g r0 = this.a.W();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        return true;
    L10:
        CommentImmersiveVoiceTouchDelegate r2 = this.a.V();
        if (r2 != null) goto L13;
    L15:
        boolean r3 = false;
    L16:
        if (r3 == false) goto L20;
        r2.a();
        return true;
    L20:
        if (this.a.G0() == false) goto L22;
    L25:
        return true;
    L22:
        if (this.a.x(false) == true) goto L25;
        if (this.a.H0() == true) goto L25;
        return false;
    L13:
        if (r2.k != true) goto L15;
        r3 = true;
        goto L16
    L5:
        if (r0.a() != true) goto L7;
        r1 = true;
        goto L8
    }
}
