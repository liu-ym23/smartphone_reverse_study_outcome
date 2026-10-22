package ql5;

import com.bytedance.ee.bear.reminder.ReminderFragment;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t implements CalendarView.e {
    public final /* synthetic */ ReminderFragment a;

    public t(ReminderFragment r1) {
        this.a = r1;
    }

    public final void a(Calendar r12, boolean r13) {
        if (r13 == false) goto L4;
        this.a.R.onCalendarSelect();
    L4:
        ReminderFragment r14 = this.a;
        com.bytedance.ee.bear.reminder.model.a r0 = r14.T;
        if (r0 != null) goto L7;
    L29:
        this.a.ra0(r12.getTimeInMillis());
        return;
    L7:
        if (r0.f == false) goto L29;
        java.util.Calendar r1 = java.util.Calendar.getInstance();
        r1.setTimeInMillis(System.currentTimeMillis());
        int r2 = r12.compareTo(f0.a(System.currentTimeMillis()));
        if (r2 > 0) goto L17;
        if (r2 == 0) goto L12;
    L16:
        boolean r7 = false;
    L18:
        r14.k.setEnabled(r7);
        r14.k.setClickable(r7);
        r14.ka0(!r7);
        r14.na0(r7);
        r14.o.setClickable(r7);
        r14.o.setEnabled(r7);
        r14.y.setEnabled(r7);
        r14.D.setEnabled(r7);
        if (r2 != 0) goto L28;
        if (r7 == false) goto L28;
        if (r14.fa0(r14.z.getSelectedCalendar()) > System.currentTimeMillis()) goto L28;
        if (r1.get(12) >= 30) goto L26;
        r1.set(12, 30);
    L27:
        r14.sa0(r1.getTimeInMillis());
        goto L28
    L26:
        r1.add(11, 1);
        r1.set(12, 0);
    L28:
        r14.ca0(r14.fa0(r14.z.getSelectedCalendar()));
        goto L29
    L12:
        if (r1.get(11) < 23) goto L17;
        if (r1.get(12) >= 30) goto L16;
    L17:
        r7 = true;
        goto L18
    }
}
