package com.bytedance.ee.bear.reminder;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0013\b\u0016\u0018\u00002\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0017\u001a\u00020\u0012J\u0010\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u001a\u001a\u00020\u0012J\u0006\u0010\u001b\u001a\u00020\u0012J\u0006\u0010\u001c\u001a\u00020\u0012J\u0006\u0010\u001d\u001a\u00020\u0012J\u0006\u0010\u001e\u001a\u00020\u0012J\u0006\u0010\u001f\u001a\u00020\u0012J\u0006\u0010 \u001a\u00020\u0012J\u0006\u0010!\u001a\u00020\u0012J\u0006\u0010\"\u001a\u00020\u0012J\u0006\u0010#\u001a\u00020\u0012R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\n¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/reminder/ReminderViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "mDelegate", "Lcom/bytedance/ee/bear/reminder/ReminderViewModel$IReminderDelegate;", "originReminderSettings", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/reminder/model/ReminderSettings;", "getOriginReminderSettings", "()Landroidx/lifecycle/MutableLiveData;", "active", "", "getActive", "bearUrl", "Lcom/bytedance/ee/bear/domain/BearUrl;", "getBearUrl", "setOriginReminderSettings", "", "setActive", "setBearUrl", "setDelegate", "delegate", "closeReminder", "saveReminder", BenefitStore.FROM_SETTINGS, "onSetAllDay", "onCancelAllDay", "onCalendarSelect", "onMonthChange", "onClickContinueEdit", "onClickConfirmQuit", "onClickNoReminder", "onSelectReminderTime", "onSelectTime", "onShowReminderPersonCountLimitToast", "IReminderDelegate", "features-reminder_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ReminderViewModel extends ViewModel {
    private final MutableLiveData<Boolean> active;
    private final MutableLiveData<BearUrl> bearUrl;
    private a mDelegate;
    private final MutableLiveData<com.bytedance.ee.bear.reminder.model.a> originReminderSettings;

    public interface a {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();

        void g();

        void h();

        void i(com.bytedance.ee.bear.reminder.model.a r1);

        void j();

        void k();

        void onClose();
    }

    public final void closeReminder() {
        a r0 = this.mDelegate;
        if (r0 == null) goto L6;
        r0.onClose();
        return;
    }

    public final void onCalendarSelect() {
        a r0 = this.mDelegate;
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    public final void onCancelAllDay() {
        a r0 = this.mDelegate;
        if (r0 == null) goto L6;
        r0.k();
        return;
    }

    public final void onClickConfirmQuit() {
        a r0 = this.mDelegate;
        if (r0 == null) goto L6;
        r0.e();
        return;
    }

    public final void onClickContinueEdit() {
        a r0 = this.mDelegate;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    public final void onClickNoReminder() {
        a r0 = this.mDelegate;
        if (r0 == null) goto L6;
        r0.g();
        return;
    }

    public final void onMonthChange() {
        a r0 = this.mDelegate;
        if (r0 == null) goto L6;
        r0.f();
        return;
    }

    public final void onSelectReminderTime() {
        a r0 = this.mDelegate;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public final void onSelectTime() {
        a r0 = this.mDelegate;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    public final void onSetAllDay() {
        a r0 = this.mDelegate;
        if (r0 == null) goto L6;
        r0.j();
        return;
    }

    public final void onShowReminderPersonCountLimitToast() {
        a r0 = this.mDelegate;
        if (r0 == null) goto L6;
        r0.h();
        return;
    }

    public ReminderViewModel() {
        this.originReminderSettings = new MutableLiveData();
        this.active = new MutableLiveData();
        this.bearUrl = new MutableLiveData();
    }

    public final MutableLiveData<Boolean> getActive() {
        return this.active;
    }

    public final MutableLiveData<BearUrl> getBearUrl() {
        return this.bearUrl;
    }

    public final MutableLiveData<com.bytedance.ee.bear.reminder.model.a> getOriginReminderSettings() {
        return this.originReminderSettings;
    }

    public final void saveReminder(com.bytedance.ee.bear.reminder.model.a r2) {
        a r0 = this.mDelegate;
        if (r0 == null) goto L6;
        r0.i(r2);
        return;
    }

    public final void setActive(boolean r2) {
        this.active.setValue(Boolean.valueOf(r2));
    }

    public final void setBearUrl(BearUrl r2) {
        Intrinsics.checkNotNullParameter(r2, "bearUrl");
        this.bearUrl.setValue(r2);
    }

    public final void setDelegate(a r1) {
        this.mDelegate = r1;
    }

    public final void setOriginReminderSettings(com.bytedance.ee.bear.reminder.model.a r2) {
        Intrinsics.checkNotNullParameter(r2, "originReminderSettings");
        this.originReminderSettings.setValue(r2);
    }
}
