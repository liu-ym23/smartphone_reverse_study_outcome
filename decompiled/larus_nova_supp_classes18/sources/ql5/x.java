package ql5;

import android.widget.CompoundButton;
import com.bytedance.ee.bear.reminder.ReminderFragment;
import com.bytedance.ee.bear.reminder.model.ReminderModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class x implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ ReminderFragment a;

    public x(ReminderFragment r1) {
        this.a = r1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r1, boolean r2) {
        ReminderModel.CreateTaskSwitchBean r3 = this.a.T.l;
        if (r3 == null) goto L5;
        r3.setValue(r2);
        return;
    L5:
        tt5.a.d("ReminderFragment", "OnCheckedChange getCreateTaskSwitchBean null!");
    }
}
