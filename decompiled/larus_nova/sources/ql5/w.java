package ql5;

import android.widget.CompoundButton;
import com.bytedance.ee.bear.reminder.ReminderFragment;
import com.bytedance.ee.bear.reminder.calendar.ReminderMonthView;

/* JADX INFO: loaded from: classes18.dex */
public final class w implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReminderFragment f533809a;

    public w(ReminderFragment r100) {
        this.f533809a = r100;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r100, boolean r101) {
        if (r101 == false) goto L5;
        this.f533809a.R.onSetAllDay();
        this.f533809a.ta0();
        ReminderFragment r102 = this.f533809a;
        r102.T.f236475a = true;
        r102.f236455o.setVisibility(0);
        this.f533809a.na0(false);
        this.f533809a.ja0(false);
        this.f533809a.la0(false);
        this.f533809a.pa0(true);
        this.f533809a.sa0(System.currentTimeMillis());
        return;
    L5:
        this.f533809a.R.onCancelAllDay();
        this.f533809a.ta0();
        ReminderFragment r103 = this.f533809a;
        r103.T.f236475a = false;
        r103.f236455o.setVisibility(8);
        this.f533809a.na0(false);
        this.f533809a.ja0(false);
        this.f533809a.la0(false);
        this.f533809a.pa0(true);
        ReminderMonthView.updateExpireTime(23, 59);
    }
}
