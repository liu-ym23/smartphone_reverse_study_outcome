package ql5;

import androidx.core.widget.NestedScrollView;
import com.bytedance.ee.bear.reminder.ReminderFragment;

/* JADX INFO: loaded from: classes18.dex */
public final class z implements NestedScrollView.OnScrollChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReminderFragment f533812a;

    public z(ReminderFragment r100) {
        this.f533812a = r100;
    }

    @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
    public final void onScrollChange(NestedScrollView r100, int r101, int r102, int r103, int r104) {
        if (r102 != 0) goto L4;
        this.f533812a.f236463v.setVisibility(4);
        return;
    L4:
        this.f533812a.f236463v.setVisibility(0);
    }
}
