package com.bytedance.ee.bear.middleground.comment.input;

import android.view.KeyEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p1 implements TextView.OnEditorActionListener {
    public final /* synthetic */ InputComment a;

    public p1(InputComment r1) {
        this.a = r1;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r2, int r3, KeyEvent r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if (r4.getKeyCode() == 66) goto L7;
        return false;
    L7:
        if (r4.isShiftPressed() == false) goto L9;
        return false;
    L9:
        if (r4.isAltPressed() == false) goto L11;
        return false;
    L11:
        if (this.a.s.isEnabled() == false) goto L18;
        this.a.Q(false, null);
        return true;
    L18:
        return false;
    }
}
