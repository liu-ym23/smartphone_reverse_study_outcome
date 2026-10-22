package ql5;

import android.widget.CompoundButton;
import com.bytedance.ee.bear.reminder.ReminderFragment;
import com.bytedance.ee.bear.reminder.calendar.ReminderMonthView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class w implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ ReminderFragment a;

    public w(ReminderFragment r1) {
        this.a = r1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r3, boolean r4) {
        if (r4 == false) goto L5;
        this.a.R.onSetAllDay();
        this.a.ta0();
        ReminderFragment r5 = this.a;
        r5.T.a = true;
        r5.o.setVisibility(0);
        this.a.na0(false);
        this.a.ja0(false);
        this.a.la0(false);
        this.a.pa0(true);
        this.a.sa0(System.currentTimeMillis());
        return;
    L5:
        this.a.R.onCancelAllDay();
        this.a.ta0();
        ReminderFragment r6 = this.a;
        r6.T.a = false;
        r6.o.setVisibility(8);
        this.a.na0(false);
        this.a.ja0(false);
        this.a.la0(false);
        this.a.pa0(true);
        ReminderMonthView.updateExpireTime(23, 59);
    }
}
