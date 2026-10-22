package ql5;

import android.widget.CompoundButton;
import com.bytedance.ee.bear.reminder.ReminderFragment;
import com.bytedance.ee.bear.reminder.model.ReminderModel;

/* JADX INFO: loaded from: classes18.dex */
public final class x implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReminderFragment f533810a;

    public x(ReminderFragment r100) {
        this.f533810a = r100;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r100, boolean r101) {
        ReminderModel.CreateTaskSwitchBean r102 = this.f533810a.T.f236486l;
        if (r102 == null) goto L5;
        r102.setValue(r101);
        return;
    L5:
        tt5.a.d("ReminderFragment", "OnCheckedChange getCreateTaskSwitchBean null!");
    }
}
