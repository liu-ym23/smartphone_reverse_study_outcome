package com.ss.android.lark.todo.impl.features.setting.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import com.bytedance.crash.d;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.ui.BaseDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.todo.impl.features.detail.time.f;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.h;
import com.ss.android.lark.todo.impl.utils.m;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002\u0011\u0012B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\tJ\b\u0010\u0010\u001a\u00020\u000bH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/setting/widget/TodoReminderPickerMenu;", "Lcom/larksuite/framework/ui/BaseDialog;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "themeResId", "", "<init>", "(Landroid/content/Context;I)V", "mActionListener", "Lcom/ss/android/lark/todo/impl/features/setting/widget/TodoReminderPickerMenu$ActionListener;", "initView", "", "setOriginalIndex", "index", "setActionListener", "actionListener", "onBackPressed", "ActionListener", "NormalReminderAdapter", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TodoReminderPickerMenu extends BaseDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f444002a;

    public interface a {
        void a(int r100);
    }

    public static final class b implements e18.a<h> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Integer> f444003a;

        @Override // e18.a
        public final int getItemsCount() {
            return this.f444003a.size();
        }

        public b() {
            ArrayList<Integer> r100 = f.f443555a;
            this.f444003a = f.f443555a;
        }

        @Override // e18.a
        public final int a(Object r100) {
            return e18.a.C5729a.a(this, r100);
        }

        @Override // e18.a
        public final h getItem(int r100) {
            return new h(r100, ((Number) ListProtector.get(this.f444003a, r100)).intValue());
        }

        @Override // e18.a
        public final int indexOf(h r100) {
            h r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "reminderItem");
            return r101.f443858a;
        }
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        a9c.b.f2313a.q();
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L12:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r101 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r101 == null) goto L16;
        d.d(r101, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
    }

    public TodoReminderPickerMenu(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, R.style.Dialog_SettingReminderPicker);
        setContentView(R.layout.todo_dialog_reminder_picker);
        setCanceledOnTouchOutside(true);
        ((TextView) findViewById(R.id.reminder_cancel)).setOnClickListener(new t8c.a(this));
        ((TextView) findViewById(R.id.reminder_confirm)).setOnClickListener(new com.ss.android.lark.todo.impl.features.setting.widget.a(this));
        ((WheelView) findViewById(R.id.reminder_wheel_normal)).setCyclic(false);
        ((WheelView) findViewById(R.id.reminder_wheel_normal)).setAdapter(new b());
        ((WheelView) findViewById(R.id.reminder_wheel_normal)).setTextSize(m.b(17.0f));
        ((WheelView) findViewById(R.id.reminder_wheel_normal)).setTextSizeOuter(m.b(14.0f));
    }
}
