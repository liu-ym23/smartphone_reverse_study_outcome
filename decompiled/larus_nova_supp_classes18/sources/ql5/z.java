package ql5;

import androidx.core.widget.NestedScrollView;
import com.bytedance.ee.bear.reminder.ReminderFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class z implements NestedScrollView.OnScrollChangeListener {
    public final /* synthetic */ ReminderFragment a;

    public z(ReminderFragment r1) {
        this.a = r1;
    }

    public final void onScrollChange(NestedScrollView r1, int r2, int r3, int r4, int r5) {
        if (r3 != 0) goto L4;
        this.a.v.setVisibility(4);
        return;
    L4:
        this.a.v.setVisibility(0);
    }
}
