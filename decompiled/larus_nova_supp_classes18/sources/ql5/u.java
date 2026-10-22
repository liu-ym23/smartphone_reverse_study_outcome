package ql5;

import com.bytedance.ee.bear.reminder.ReminderFragment;
import com.bytedance.ee.bear.reminder.calendar.ReminderMonthView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u implements c18.a {
    public final /* synthetic */ ReminderFragment a;

    public u(ReminderFragment r1) {
        this.a = r1;
    }

    public final void a(int r2, int r3, int r4, int r5, int r6) {
        ReminderFragment r7 = this.a;
        long r8 = r7.fa0(r7.z.getSelectedCalendar());
        ReminderFragment r9 = this.a;
        r9.D.setText(zu5.a.d(r9.getContext(), r8));
        ReminderMonthView.updateExpireTime(r5, r6);
        this.a.ca0(r8);
    }
}
