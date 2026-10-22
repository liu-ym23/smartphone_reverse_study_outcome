package ql5;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.reminder.ReminderFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s implements ocb.a {
    public final /* synthetic */ long a;
    public final /* synthetic */ ReminderFragment b;

    public s(ReminderFragment r1, long r2) {
        this.b = r1;
        this.a = r2;
    }

    public final void onKeyboardHeightChanged(pcb.a r5, int r6, int r7) {
        long r0 = System.currentTimeMillis() - this.a;
        tt5.a.h("ReminderFragment", "onKeyboardHeightChanged duration: " + r0 + ", keyboardHeight: " + r6);
        FragmentActivity r8 = this.b.getActivity();
        if (com.bytedance.ee.util.ui.b.a(r8) == false) goto L10;
        if (r6 > 0) goto L6;
    L8:
        pcb.a.a.b(r8).a(this);
        return;
    L6:
        if (r0 >= 1000) goto L8;
        rcb.c.c(r8);
        goto L8
    }
}
