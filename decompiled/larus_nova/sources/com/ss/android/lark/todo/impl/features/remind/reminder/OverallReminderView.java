package com.ss.android.lark.todo.impl.features.remind.reminder;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larksuite.component.universe_design.button.UDButton;
import com.larus.nova.R;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.todo.impl.features.remind.reminder.entity.OverallReminderData;
import com.ss.android.lark.todo.impl.utils.i;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 '2\u00020\u0001:\u0002&'B)\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010 \u001a\u00020!H\u0002J\u000e\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001fJ\u0010\u0010$\u001a\u00020!2\b\u0010%\u001a\u0004\u0018\u00010\u001dR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00148FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00148FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/ss/android/lark/todo/impl/features/remind/reminder/OverallReminderView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tvCloseReminderFromXml", "Lcom/larksuite/component/universe_design/button/UDButton;", "getTvCloseReminderFromXml", "()Lcom/larksuite/component/universe_design/button/UDButton;", "setTvCloseReminderFromXml", "(Lcom/larksuite/component/universe_design/button/UDButton;)V", "tvReminderDetailFromXml", "getTvReminderDetailFromXml", "setTvReminderDetailFromXml", "tvReminderTitleFromXml", "Landroid/widget/TextView;", "getTvReminderTitleFromXml", "()Landroid/widget/TextView;", "setTvReminderTitleFromXml", "(Landroid/widget/TextView;)V", "tvReminderTimeFromXml", "getTvReminderTimeFromXml", "setTvReminderTimeFromXml", "mClickedListener", "Lcom/ss/android/lark/todo/impl/features/remind/reminder/OverallReminderView$OnReminderClickedListener;", "mReminderData", "Lcom/ss/android/lark/todo/impl/features/remind/reminder/entity/OverallReminderData;", "initListener", "", "setReminderData", "reminderData", "setReminderClickListener", "clickListener", "OnReminderClickedListener", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OverallReminderView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public UDButton f443935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UDButton f443936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f443937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f443938d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f443939e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OverallReminderData f443940f;

    public static final class a {
    }

    public interface b {
        void a(OverallReminderData r100);

        void b(OverallReminderData r100);
    }

    static {
    }

    public OverallReminderView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OverallReminderView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final UDButton getTvCloseReminderFromXml() {
        KeyEvent.Callback r100 = this.f443935a;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.tvCloseReminder);
        this.f443935a = (UDButton) r100;
    L6:
        return (UDButton) r100;
    }

    public final UDButton getTvReminderDetailFromXml() {
        KeyEvent.Callback r100 = this.f443936b;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.tvReminderDetail);
        this.f443936b = (UDButton) r100;
    L6:
        return (UDButton) r100;
    }

    public final TextView getTvReminderTimeFromXml() {
        KeyEvent.Callback r100 = this.f443938d;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.tvReminderTime);
        this.f443938d = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public final TextView getTvReminderTitleFromXml() {
        KeyEvent.Callback r100 = this.f443937c;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.tvReminderTitle);
        this.f443937c = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public final void setReminderClickListener(b r100) {
        this.f443939e = r100;
    }

    public final void setReminderData(OverallReminderData r100) {
        Intrinsics.checkNotNullParameter(r100, "reminderData");
        this.f443940f = r100;
        if (TextUtils.isEmpty(r100.getTodoReminder().summary) == false) goto L5;
        String r101 = i.f444291a.g(R.string.Todo_Task_NoTitlePlaceholder);
    L6:
        TextView r102 = getTvReminderTitleFromXml();
        i r103 = i.f444291a;
        Intrinsics.checkNotNull(r101);
        r102.setText(i.d(R.string.Todo_Task_TaskIs, "task", r101));
        int r104 = com.ss.android.lark.todo.impl.features.common.helper.b.f442448a;
        getTvReminderTimeFromXml().setText(i.d(R.string.Todo_Task_DueAt2, "time", com.ss.android.lark.todo.impl.features.common.helper.b.b(getContext(), 1000 * r100.getTodoReminder().due_time.longValue(), r100.getTodoReminder().is_all_day.booleanValue(), TodoDependencyHolder.a().timeFormatDependency().c()).getEndTimeStr()));
        return;
    L5:
        r101 = r100.getTodoReminder().summary;
        goto L6
    }

    public final void setTvCloseReminderFromXml(UDButton r100) {
        this.f443935a = r100;
    }

    public final void setTvReminderDetailFromXml(UDButton r100) {
        this.f443936b = r100;
    }

    public final void setTvReminderTimeFromXml(TextView r100) {
        this.f443938d = r100;
    }

    public final void setTvReminderTitleFromXml(TextView r100) {
        this.f443937c = r100;
    }

    public OverallReminderView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.todo_overall_reminder, this);
        getTvCloseReminderFromXml().setOnClickListener(new e(this));
        getTvReminderDetailFromXml().setOnClickListener(new f(this));
    }

    public /* synthetic */ OverallReminderView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
