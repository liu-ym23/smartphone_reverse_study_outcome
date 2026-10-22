package com.bytedance.ee.bear.middleground.comment.input;

import android.view.KeyEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h0 implements TextView.OnEditorActionListener {
    public long a;
    public final /* synthetic */ BaseInputComment b;

    public h0(BaseInputComment r1) {
        this.b = r1;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r6, int r7, KeyEvent r8) {
        if (r8 != null) goto L5;
        return false;
    L5:
        if (r8.getKeyCode() == 66) goto L7;
        return false;
    L7:
        if (r8.isShiftPressed() == false) goto L9;
        return false;
    L9:
        if (r8.isAltPressed() == false) goto L11;
        return false;
    L11:
        if (this.b.p.isEnabled() == true) goto L13;
        return false;
    L13:
        if (this.b.X.f == false) goto L15;
        return false;
    L15:
        long r9 = System.currentTimeMillis();
        if ((r9 - this.a) >= 500) goto L18;
        return false;
    L18:
        this.a = r9;
        tt5.a.h(this.b.L(), "onEditorAction: send comment");
        this.b.j0(false, null);
        return true;
    }
}
