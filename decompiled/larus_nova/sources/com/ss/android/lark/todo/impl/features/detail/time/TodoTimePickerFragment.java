package com.ss.android.lark.todo.impl.features.detail.time;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larksuite.component.universe_design.datepicker.UDDatePicker;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.timepicker.UDTimePicker;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.component.universe_design.timepicker.impl.data.PickerModel;
import com.larus.nova.R;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.time.format.entity.LengthType;
import com.ss.android.lark.todo.databinding.TodoDetailTimeFragmentBinding;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.TimeBean;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.ui.CommonTitleBarConstants;
import com.ss.android.lark.ui.IActionTitlebar$TextAction;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.bytertc.engine.type.ErrorCode;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 `2\u00020\u0001:\u0001`B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u001a\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u0002032\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010=\u001a\u00020;H\u0002J\b\u0010>\u001a\u00020;H\u0002J\u0006\u0010?\u001a\u00020;J\u0006\u0010@\u001a\u00020;J\b\u0010A\u001a\u00020;H\u0002J\b\u0010B\u001a\u00020;H\u0002J\b\u0010C\u001a\u00020;H\u0002J\b\u0010D\u001a\u00020;H\u0002J\b\u0010E\u001a\u00020;H\u0002J\b\u0010F\u001a\u00020;H\u0002J\b\u0010G\u001a\u00020;H\u0002J\u0010\u0010H\u001a\u00020;2\u0006\u0010I\u001a\u00020\rH\u0002J\b\u0010J\u001a\u00020;H\u0002J\b\u0010K\u001a\u00020;H\u0002J\b\u0010L\u001a\u00020;H\u0002J\b\u0010M\u001a\u00020;H\u0002J\b\u0010N\u001a\u00020;H\u0002J\b\u0010O\u001a\u00020;H\u0002J\b\u0010P\u001a\u00020;H\u0002J\u0012\u0010Q\u001a\u00020;2\b\b\u0002\u0010R\u001a\u00020\rH\u0002J\u0018\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020T2\u0006\u0010V\u001a\u00020TH\u0002J\b\u0010W\u001a\u00020;H\u0002J\u0010\u0010X\u001a\u00020;2\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J\b\u0010Y\u001a\u00020;H\u0002J\b\u0010Z\u001a\u00020\rH\u0002J\"\u0010[\u001a\u00020;2\u0006\u0010\\\u001a\u00020\u00072\u0006\u0010]\u001a\u00020\u00072\b\u0010^\u001a\u0004\u0018\u00010_H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u001b\u0010#\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\"\u001a\u0004\b$\u0010 R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\"\u001a\u0004\b(\u0010)R\u001b\u0010+\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\"\u001a\u0004\b,\u0010)R\u001b\u0010.\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\"\u001a\u0004\b/\u0010)R\u000e\u00101\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006a"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/time/TodoTimePickerFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "binding", "Lcom/ss/android/lark/todo/databinding/TodoDetailTimeFragmentBinding;", "startYear", "", "startMonth", "startDayOfMonth", "startHourOfDay", "startMinute", "hasStartTime", "", "endYear", "endMonth", "endDayOfMonth", "endHourOfDay", "endMinute", "hasEndTime", "isSelectStart", "isAllDay", "rrule", "", "rruleText", "isTwentyFourHour", "isTodoReminderOptimize", "isUserRemoveAllDayAlert", "reminderRelative", "normalReminderAdapter", "Lcom/ss/android/lark/todo/impl/features/detail/time/ReminderAdapterV2;", "getNormalReminderAdapter", "()Lcom/ss/android/lark/todo/impl/features/detail/time/ReminderAdapterV2;", "normalReminderAdapter$delegate", "Lkotlin/Lazy;", "allDayReminderAdapter", "getAllDayReminderAdapter", "allDayReminderAdapter$delegate", "dateCustomReminderAdapter", "Lcom/ss/android/lark/todo/impl/features/detail/time/CustomReminderAdapter;", "getDateCustomReminderAdapter", "()Lcom/ss/android/lark/todo/impl/features/detail/time/CustomReminderAdapter;", "dateCustomReminderAdapter$delegate", "hourCustomReminderAdapter", "getHourCustomReminderAdapter", "hourCustomReminderAdapter$delegate", "minuteCustomReminderAdapter", "getMinuteCustomReminderAdapter", "minuteCustomReminderAdapter$delegate", "taskGuid", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initView", "initViewData", "initViewState", "initViewAction", "initSelectTaskTimeContainerAction", "hideAllDayReminderContainer", "initMonthPickerAction", "setDefaultTimeHourDate", "initTimeHourContainerAction", "initTimePickerAction", "initReminderTextContainerAction", "setUserRemoveAllDayAlert", "userRemoveAllDayAlert", "updateReminderByFirstIndex", "generateCustomReminderTime", "initReminderPickerAction", "initRruleAction", "initSelectTaskTimeContainerDate", "initStartMonthPickerDate", "initEndMonthPickerDate", "initTimeHourContainerAndTimePickerDate", "isFirstSetTime", "getTodayDueTimeHours", "Ljava/util/GregorianCalendar;", "currentDate", "comparedDate", "initReminderContainerAndPickerDate", "calculateInsertCustomReminder", "initRruleContainerDate", "hasReminder", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class TodoTimePickerFragment extends BaseFragment {
    public static final int E = 0;
    public static final int F = 0;
    public static final int G = 0;
    public static final int H = 0;
    public static final int I = 0;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final int f443520J = 0;
    public static final int K = 0;
    public static final int L = 0;
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public String D;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TodoDetailTimeFragmentBinding f443521d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f443522e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f443523f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f443524g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f443525h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f443526i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f443527j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f443528k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f443529l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f443530m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f443531n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f443532o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f443533p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f443534q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f443535r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f443536s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f443537t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f443538u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f443539v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f443540w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f443541x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f443542y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f443543z;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TodoTimePickerFragment f443544a;

        public b(TodoTimePickerFragment r100) {
            this.f443544a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            zab.a.a(this.f443544a);
        }
    }

    public static final class c extends IActionTitlebar$TextAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TodoTimePickerFragment f443545a;

        @Override // com.ss.android.lark.ui.IActionTitlebar$BaseAction, com.ss.android.lark.ui.IActionTitlebar$Action
        public final void performAction(View r110) {
            TodoTimePickerFragment r111 = this.f443545a;
            if (r111.f443527j == true) goto L6;
            long r112 = 0;
        L10:
            TodoTimePickerFragment r113 = this.f443545a;
            if (r113.f443533p == true) goto L14;
            long r100 = 0;
        L19:
            if (r100 <= 0) goto L21;
            int r101 = this.f443545a.f443541x;
        L22:
            TodoTimePickerFragment r102 = this.f443545a;
            TimeBean r103 = new TimeBean(r100, r102.f443535r, r101, r102.f443536s, r102.f443537t, r112);
            a9c.b r104 = a9c.b.f2313a;
            TodoTimePickerFragment r105 = this.f443545a;
            String r106 = r105.D;
            boolean r107 = r105.f443533p;
            boolean r108 = r105.f443527j;
            if (r107 == false) goto L25;
            boolean r109 = r105.Y90();
        L26:
            a9c.b.i(r106, r107, r108, r109, !TextUtils.isEmpty(this.f443545a.f443536s), this.f443545a.f443535r);
            Bundle r114 = new Bundle();
            r114.putSerializable("todo_due_time_chosen_data", r103);
            zab.a.b(this.f443545a, -1, r114);
            return;
        L25:
            r109 = false;
            goto L26
        L21:
            r101 = -1;
            goto L22
        L14:
            if (r113.f443535r == true) goto L16;
            int r115 = k8c.a.f502137a;
            long r116 = k8c.a.b(r113.f443528k, r113.f443529l, r113.f443530m, r113.f443531n, r113.f443532o, 96).getTimeInMillis();
        L17:
            r100 = r116;
            goto L19
        L16:
            int r117 = k8c.a.f502137a;
            r116 = k8c.a.a(r113.f443528k, r113.f443529l, r113.f443530m).getTimeInMillis();
            goto L17
        L6:
            if (r111.f443535r == true) goto L8;
            int r118 = k8c.a.f502137a;
            long r119 = k8c.a.b(r111.f443522e, r111.f443523f, r111.f443524g, r111.f443525h, r111.f443526i, 96).getTimeInMillis();
        L9:
            r112 = r119;
            goto L10
        L8:
            int r120 = k8c.a.f502137a;
            r119 = k8c.a.a(r111.f443522e, r111.f443523f, r111.f443524g).getTimeInMillis();
            goto L9
        }

        public c(TodoTimePickerFragment r100, String r101) {
            this.f443545a = r100;
            super(r101, R.color.primary_pri_500, 16);
        }
    }

    static {
        GregorianCalendar r100 = new GregorianCalendar();
        E = r100.get(1);
        F = r100.get(2);
        G = r100.get(5);
        H = 9;
        GregorianCalendar r101 = new GregorianCalendar();
        r101.add(5, 1);
        I = r101.get(1);
        f443520J = r101.get(2);
        K = r101.get(5);
        L = 18;
    }

    public final void V90() {
        if (this.f443539v == true) goto L5;
        return;
    L5:
        TodoDetailTimeFragmentBinding r100 = this.f443521d;
        TodoDetailTimeFragmentBinding r101 = null;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r100 = null;
    L8:
        int r102 = r100.f441337b.getCurrentItem();
        TodoDetailTimeFragmentBinding r103 = this.f443521d;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r103 = null;
    L11:
        int r104 = 0;
        int r105 = CastIntegerProtector.parseInt(((CustomReminderAdapter) this.B.getValue()).b(r103.f441338c.getCurrentItem()));     // Catch: Throwable -> L14
    L16:
        TodoDetailTimeFragmentBinding r106 = this.f443521d;
        if (r106 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L32:
        r104 = CastIntegerProtector.parseInt(((CustomReminderAdapter) this.C.getValue()).b(r101.f441339d.getCurrentItem()));     // Catch: Throwable -> L23
    L25:
        if (r102 != 0) goto L27;
        int r107 = -((r105 * 60) + r104);
    L28:
        this.f443541x = r107;
        return;
    L27:
        r107 = (60 - r104) + ((((r102 - 1) * 24) * 60) + ((23 - r105) * 60));
    L23:
        th = move-exception;
        Log.e("TodoTimePickerFragment", "minute custom reminder cast error: " + th);
        goto L25
    L19:
        r101 = r106;
    L14:
        th = move-exception;
        Log.e("TodoTimePickerFragment", "hour custom reminder cast error: " + th);
        r105 = 0;
        goto L16
    }

    public final com.ss.android.lark.todo.impl.features.detail.time.a W90() {
        return (com.ss.android.lark.todo.impl.features.detail.time.a) this.f443543z.getValue();
    }

    public final com.ss.android.lark.todo.impl.features.detail.time.a X90() {
        return (com.ss.android.lark.todo.impl.features.detail.time.a) this.f443542y.getValue();
    }

    public final boolean Y90() {
        boolean r100 = this.f443535r;
        if (r100 == true) goto L5;
    L6:
        if (r100 == false) goto L8;
    L10:
        return false;
    L8:
        if (this.f443541x == (-1)) goto L10;
    L9:
        return true;
    L5:
        if (this.f443541x != (-1)) goto L9;
        goto L6
    }

    public final void Z90() {
        TodoDetailTimeFragmentBinding r100 = this.f443521d;
        TodoDetailTimeFragmentBinding r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r100 = null;
    L5:
        UDDatePicker r102 = r100.f441340e;
        int r103 = k8c.a.f502137a;
        r102.setSelectedCalendar(k8c.a.b(this.f443528k, this.f443529l, this.f443530m, 0, 0, 120));
        if (this.f443533p == true) goto L13;
        TodoDetailTimeFragmentBinding r104 = this.f443521d;
        if (r104 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L11:
        r101.f441340e.setSelected(false);
        return;
    L10:
        r101 = r104;
        goto L11
    }

    public final void aa0() {
        TodoDetailTimeFragmentBinding r100 = this.f443521d;
        TodoDetailTimeFragmentBinding r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r100 = null;
    L5:
        TextView r102 = r100.f441347l;
        com.ss.android.lark.todo.impl.utils.i r103 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        r102.setText(r103.g(R.string.Todo_Task_AlertTimeNoAlert));
        TodoDetailTimeFragmentBinding r104 = this.f443521d;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r104 = null;
    L8:
        r104.f441345j.setImageResource(R.drawable.ud_icon_right_outlined);
        boolean r105 = false;
        if (this.f443533p == false) goto L23;
        TodoDetailTimeFragmentBinding r106 = this.f443521d;
        if (r106 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r106 = null;
    L13:
        AppCompatImageView r107 = r106.f441344i;
        TodoDetailTimeFragmentBinding r108 = this.f443521d;
        if (r108 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r108 = null;
    L16:
        r107.setImageDrawable(UDIconUtils.getIconDrawable(r108.f441344i.getContext(), R.drawable.ud_icon_bell_outlined, r103.a(R.color.icon_n3)));
        TodoDetailTimeFragmentBinding r109 = this.f443521d;
        if (r109 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r109 = null;
    L19:
        r109.f441347l.setTextColor(r103.a(R.color.text_title));
        TodoDetailTimeFragmentBinding r110 = this.f443521d;
        if (r110 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r110 = null;
    L22:
        r110.f441345j.setVisibility(0);
    L37:
        if (Y90() == false) goto L106;
        TodoDetailTimeFragmentBinding r111 = this.f443521d;
        if (r111 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r111 = null;
    L41:
        TextView r112 = r111.f441347l;
        ArrayList<Integer> r113 = g.f443558a;
        r112.setText(g.b(this.f443541x, this.f443535r));
        if (this.f443535r == true) goto L44;
        X90().b(this.f443541x);
        TodoDetailTimeFragmentBinding r114 = this.f443521d;
        if (r114 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r114 = null;
    L77:
        r114.f441351p.setCurrentItem(X90().f443548c.indexOf(Integer.valueOf(this.f443541x)));
    L78:
        TodoDetailTimeFragmentBinding r115 = this.f443521d;
        if (r115 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r115 = null;
    L82:
        if (r115.f441349n.getVisibility() != 0) goto L84;
        boolean r116 = true;
    L85:
        if (r116 == true) goto L99;
        TodoDetailTimeFragmentBinding r117 = this.f443521d;
        if (r117 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r117 = null;
    L90:
        if (r117.f441352q.getVisibility() != 0) goto L92;
        r105 = true;
    L92:
        if (r105 == true) goto L99;
        TodoDetailTimeFragmentBinding r118 = this.f443521d;
        if (r118 != null) goto L97;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L98:
        r101.f441345j.setImageResource(R.drawable.ud_icon_close_outlined);
        return;
    L97:
        r101 = r118;
    L99:
        TodoDetailTimeFragmentBinding r119 = this.f443521d;
        if (r119 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L103:
        r101.f441345j.setImageResource(R.drawable.ud_icon_up_outlined);
        return;
    L102:
        r101 = r119;
        goto L103
    L84:
        r116 = false;
        goto L85
    L44:
        if (this.f443539v == false) goto L70;
        int r120 = this.f443541x;
        int r121 = 0;
    L47:
        if (r120 < 1440) goto L49;
        r120 = r120 - 1440;
        r121 = r121 + 1;
        goto L47
    L49:
        if (r120 >= 0) goto L51;
        int r122 = -r120;
    L54:
        Lazy<ArrayList<String>> r123 = CustomReminderAdapter.f443485c;
        String r124 = CustomReminderAdapter.a.b((r122 / 60) % 24);
        String r125 = CustomReminderAdapter.a.b(r122 % 60);
        CustomReminderAdapter r126 = (CustomReminderAdapter) this.B.getValue();
        r126.getClass();
        Intrinsics.checkNotNullParameter(r124, "value");
        r126.f443488a = r124;
        if (r126.f443489b.contains(r124) == true) goto L57;
        r126.f443489b.add(r126.f443488a);
    L57:
        CustomReminderAdapter r127 = (CustomReminderAdapter) this.C.getValue();
        r127.getClass();
        Intrinsics.checkNotNullParameter(r125, "value");
        r127.f443488a = r125;
        if (r127.f443489b.contains(r125) == true) goto L60;
        r127.f443489b.add(r127.f443488a);
    L60:
        TodoDetailTimeFragmentBinding r128 = this.f443521d;
        if (r128 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r128 = null;
    L63:
        r128.f441337b.setCurrentItem(r121);
        TodoDetailTimeFragmentBinding r129 = this.f443521d;
        if (r129 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r129 = null;
    L66:
        r129.f441338c.setCurrentItem(((CustomReminderAdapter) this.B.getValue()).f443489b.indexOf(r124));
        TodoDetailTimeFragmentBinding r130 = this.f443521d;
        if (r130 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r130 = null;
    L69:
        r130.f441339d.setCurrentItem(((CustomReminderAdapter) this.C.getValue()).f443489b.indexOf(r125));
        goto L78
    L51:
        if (r120 != 0) goto L53;
        r122 = 0;
        goto L54
    L53:
        r121 = r121 + 1;
        r122 = 1440 - r120;
        goto L54
    L70:
        W90().b(this.f443541x);
        TodoDetailTimeFragmentBinding r131 = this.f443521d;
        if (r131 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r131 = null;
    L73:
        r131.f441348m.setCurrentItem(W90().f443548c.indexOf(Integer.valueOf(this.f443541x)));
        goto L78
    L106:
        return;
    L23:
        TodoDetailTimeFragmentBinding r132 = this.f443521d;
        if (r132 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r132 = null;
    L26:
        AppCompatImageView r133 = r132.f441344i;
        TodoDetailTimeFragmentBinding r134 = this.f443521d;
        if (r134 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r134 = null;
    L29:
        r133.setImageDrawable(UDIconUtils.getIconDrawable(r134.f441344i.getContext(), R.drawable.ud_icon_bell_outlined, r103.a(R.color.icon_disable)));
        TodoDetailTimeFragmentBinding r135 = this.f443521d;
        if (r135 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r135 = null;
    L32:
        r135.f441347l.setTextColor(r103.a(R.color.text_link_disable));
        TodoDetailTimeFragmentBinding r136 = this.f443521d;
        if (r136 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r136 = null;
    L35:
        r136.f441345j.setVisibility(8);
        goto L37
    }

    public final void ba0() {
        TodoDetailTimeFragmentBinding r100 = this.f443521d;
        TodoDetailTimeFragmentBinding r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r100 = null;
    L5:
        TextView r102 = r100.f441355t;
        com.ss.android.lark.todo.impl.utils.i r103 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        r102.setText(r103.g(R.string.Calendar_Detail_NoRepeat));
        TodoDetailTimeFragmentBinding r104 = this.f443521d;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r104 = null;
    L8:
        r104.f441355t.setTextColor(r103.a(R.color.text_title));
        TodoDetailTimeFragmentBinding r105 = this.f443521d;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r105 = null;
    L11:
        AppCompatImageView r106 = r105.f441353r;
        TodoDetailTimeFragmentBinding r107 = this.f443521d;
        if (r107 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r107 = null;
    L14:
        r106.setImageDrawable(UDIconUtils.getIconDrawable(r107.f441353r.getContext(), R.drawable.ud_icon_repeat_outlined, r103.a(R.color.icon_n3)));
        TodoDetailTimeFragmentBinding r108 = this.f443521d;
        if (r108 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r108 = null;
    L17:
        r108.f441354s.setVisibility(0);
        TodoDetailTimeFragmentBinding r109 = this.f443521d;
        if (r109 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r109 = null;
    L20:
        AppCompatImageView r110 = r109.f441354s;
        TodoDetailTimeFragmentBinding r111 = this.f443521d;
        if (r111 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r111 = null;
    L23:
        r110.setImageDrawable(UDIconUtils.getIconDrawable(r111.f441353r.getContext(), R.drawable.ud_icon_right_outlined, r103.a(R.color.icon_n3)));
        boolean r112 = this.f443533p;
        if (r112 == true) goto L40;
        TodoDetailTimeFragmentBinding r113 = this.f443521d;
        if (r113 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r113 = null;
    L28:
        r113.f441355t.setTextColor(r103.a(R.color.text_link_disable));
        TodoDetailTimeFragmentBinding r114 = this.f443521d;
        if (r114 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r114 = null;
    L31:
        AppCompatImageView r115 = r114.f441353r;
        TodoDetailTimeFragmentBinding r116 = this.f443521d;
        if (r116 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r116 = null;
    L34:
        r115.setImageDrawable(UDIconUtils.getIconDrawable(r116.f441353r.getContext(), R.drawable.ud_icon_repeat_outlined, r103.a(R.color.icon_disable)));
        TodoDetailTimeFragmentBinding r117 = this.f443521d;
        if (r117 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L38:
        r101.f441354s.setVisibility(8);
        return;
    L37:
        r101 = r117;
        goto L38
    L40:
        if (r112 == true) goto L42;
        return;
    L42:
        if (TextUtils.isEmpty(this.f443536s) == true) goto L56;
        TodoDetailTimeFragmentBinding r118 = this.f443521d;
        if (r118 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r118 = null;
    L46:
        r118.f441355t.setText(this.f443537t);
        TodoDetailTimeFragmentBinding r119 = this.f443521d;
        if (r119 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r119 = null;
    L49:
        AppCompatImageView r120 = r119.f441354s;
        TodoDetailTimeFragmentBinding r121 = this.f443521d;
        if (r121 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L53:
        r120.setImageDrawable(UDIconUtils.getIconDrawable(r101.f441353r.getContext(), R.drawable.ud_icon_close_outlined, r103.a(R.color.icon_n3)));
        return;
    L52:
        r101 = r121;
        goto L53
    }

    public final void ca0() {
        TodoDetailTimeFragmentBinding r100 = this.f443521d;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r100 = null;
    L5:
        TaskTimeContainer r101 = r100.f441359x;
        boolean r102 = this.f443534q;
        if (this.f443527j == false) goto L8;
        int r103 = k8c.a.f502137a;
        long r104 = k8c.a.b(this.f443522e, this.f443523f, this.f443524g, this.f443525h, this.f443526i, 96).getTimeInMillis();
    L10:
        if (this.f443533p == false) goto L12;
        int r105 = k8c.a.f502137a;
        long r106 = k8c.a.b(this.f443528k, this.f443529l, this.f443530m, this.f443531n, this.f443532o, 96).getTimeInMillis();
    L13:
        boolean r107 = this.f443535r;
        r101.f443507o = r102;
        LinearLayout r108 = r101.getStartHaveTimeContainerFromXml();
        if (r104 == 0) goto L16;
        boolean r110 = true;
    L17:
        com.larksuite.framework.section.utils.a.d(r108, r110);
        LinearLayout r109 = r101.getStartNoTimeContainerFromXml();
        if (r104 != 0) goto L20;
        boolean r111 = true;
    L21:
        com.larksuite.framework.section.utils.a.d(r109, r111);
        com.ss.android.lark.todo.impl.utils.i r112 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        Application r113 = LarkContext.getApplication();
        if (r113 == null) goto L28;
        if (r104 == 0) goto L28;
        TextView r114 = r101.getStartTimeDateTxtFromXml();
        StringBuilder r115 = new StringBuilder();
        Date r116 = new Date(r104);
        String r117 = TimeZone.getDefault().getID();
        LengthType r310 = LengthType.SHORT;
        r115.append(c7c.b.a(r113, r116, new c7c.a(r117, null, r310, null, null, false, false, false, false, 2042)));
        r115.append(' ');
        r115.append(c7c.b.l(r113, new Date(r104), new c7c.a(TimeZone.getDefault().getID(), null, r310, null, null, false, false, false, false, 2042)));
        r114.setText(r115.toString());
        com.larksuite.framework.section.utils.a.d(r101.getStartTimeSpecificTxtFromXml(), !r107);
        if (r107 == true) goto L28;
        r101.getStartTimeSpecificTxtFromXml().setText(c7c.b.i(r113, new Date(r104), new c7c.a(TimeZone.getDefault().getID(), null, null, null, null, false, r101.A, false, false, 1662)));
    L28:
        LinearLayout r118 = r101.getEndHaveTimeContainerFromXml();
        if (r106 == 0) goto L31;
        boolean r119 = true;
    L32:
        com.larksuite.framework.section.utils.a.d(r118, r119);
        LinearLayout r120 = r101.getEndNoTimeContainerFromXml();
        if (r106 != 0) goto L35;
        boolean r121 = true;
    L36:
        com.larksuite.framework.section.utils.a.d(r120, r121);
        Application r122 = LarkContext.getApplication();
        if (r122 == null) goto L43;
        if (r106 == 0) goto L43;
        TextView r123 = r101.getEndTimeDateTxtFromXml();
        StringBuilder r124 = new StringBuilder();
        Date r125 = new Date(r106);
        String r126 = TimeZone.getDefault().getID();
        LengthType r127 = LengthType.SHORT;
        r124.append(c7c.b.a(r122, r125, new c7c.a(r126, null, r127, null, null, false, false, false, false, 2042)));
        r124.append(' ');
        r124.append(c7c.b.l(r122, new Date(r106), new c7c.a(TimeZone.getDefault().getID(), null, r127, null, null, false, false, false, false, 2042)));
        r123.setText(r124.toString());
        com.larksuite.framework.section.utils.a.d(r101.getEndTimeSpecificTxtFromXml(), !r107);
        if (r107 == true) goto L43;
        r101.getEndTimeSpecificTxtFromXml().setText(c7c.b.i(r122, new Date(r106), new c7c.a(TimeZone.getDefault().getID(), null, null, null, null, false, r101.A, false, false, 1662)));
    L43:
        r101.invalidate();
        return;
    L35:
        r121 = false;
        goto L36
    L31:
        r119 = false;
        goto L32
    L20:
        r111 = false;
        goto L21
    L16:
        r110 = false;
        goto L17
    L12:
        r106 = 0;
        goto L13
    L8:
        r104 = 0;
        goto L10
    }

    public final void da0() {
        TodoDetailTimeFragmentBinding r100 = this.f443521d;
        TodoDetailTimeFragmentBinding r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r100 = null;
    L5:
        UDDatePicker r102 = r100.f441357v;
        int r103 = k8c.a.f502137a;
        r102.setSelectedCalendar(k8c.a.b(this.f443522e, this.f443523f, this.f443524g, 0, 0, 120));
        if (this.f443527j == true) goto L13;
        TodoDetailTimeFragmentBinding r104 = this.f443521d;
        if (r104 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L11:
        r101.f441357v.setSelected(false);
        return;
    L10:
        r101 = r104;
        goto L11
    }

    public TodoTimePickerFragment() {
        this.f443522e = E;
        this.f443523f = F;
        this.f443524g = G;
        this.f443525h = H;
        this.f443526i = 0;
        this.f443528k = I;
        this.f443529l = f443520J;
        this.f443530m = K;
        this.f443531n = L;
        this.f443532o = 0;
        this.f443533p = true;
        this.f443535r = true;
        this.f443536s = "";
        this.f443537t = "";
        this.f443538u = TodoDependencyHolder.a().timeFormatDependency().c();
        this.f443539v = TodoDependencyHolder.b().f2210a.a("todo.task_reminder_optimize", false);
        this.f443541x = ErrorCode.ERROR_CODE_OVER_STREAM_PUBLISH_LIMIT;
        this.f443542y = LazyKt.lazy(TodoTimePickerFragment$normalReminderAdapter$2.INSTANCE);
        this.f443543z = LazyKt.lazy(TodoTimePickerFragment$allDayReminderAdapter$2.INSTANCE);
        this.A = LazyKt.lazy(TodoTimePickerFragment$dateCustomReminderAdapter$2.INSTANCE);
        this.B = LazyKt.lazy(TodoTimePickerFragment$hourCustomReminderAdapter$2.INSTANCE);
        this.C = LazyKt.lazy(TodoTimePickerFragment$minuteCustomReminderAdapter$2.INSTANCE);
        this.D = "";
    }

    public static final void S90(TodoTimePickerFragment r100) {
        TodoDetailTimeFragmentBinding r101 = null;
        if (r100.f443539v == false) goto L9;
        TodoDetailTimeFragmentBinding r102 = r100.f443521d;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L8:
        r101.f441350o.setVisibility(8);
        return;
    L7:
        r101 = r102;
        goto L8
    L9:
        TodoDetailTimeFragmentBinding r103 = r100.f443521d;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L13:
        r101.f441349n.setVisibility(8);
        return;
    L12:
        r101 = r103;
        goto L13
    }

    public static final void T90(TodoTimePickerFragment r110) {
        if (r110.f443534q == false) goto L20;
        if (r110.f443527j == true) goto L10;
        int r100 = k8c.a.f502137a;
        int r101 = E;
        int r102 = F;
        int r111 = G;
        if (k8c.a.b(r101, r102, r111, 0, 0, 120).compareTo(k8c.a.b(r110.f443528k, r110.f443529l, r110.f443530m, 0, 0, 120)) <= 0) goto L9;
        r110.f443522e = r110.f443528k;
        r110.f443523f = r110.f443529l;
        r110.f443524g = r110.f443530m;
        goto L10
    L9:
        r110.f443522e = r101;
        r110.f443523f = r102;
        r110.f443524g = r111;
    L10:
        r110.f443525h = H;
        r110.f443526i = 0;
        if (r110.f443533p == true) goto L13;
    L18:
        r110.f443527j = true;
        goto L20
    L13:
        if (r110.f443535r == false) goto L15;
        r110.f443531n = L;
        r110.f443532o = 0;
        goto L18
    L15:
        int r103 = k8c.a.f502137a;
        if (k8c.a.b(r110.f443528k, r110.f443529l, r110.f443530m, r110.f443531n, r110.f443532o, 96).compareTo(k8c.a.b(r110.f443522e, r110.f443523f, r110.f443524g, r110.f443525h, r110.f443526i, 96)) >= 0) goto L18;
        r110.f443525h = r110.f443531n;
        r110.f443526i = r110.f443532o;
    L20:
        if (r110.f443534q == false) goto L22;
        return;
    L22:
        if (r110.f443533p == true) goto L27;
        int r104 = k8c.a.f502137a;
        GregorianCalendar r105 = k8c.a.b(r110.f443522e, r110.f443523f, r110.f443524g, 0, 0, 120);
        int r106 = I;
        int r107 = f443520J;
        int r108 = K;
        if (r105.compareTo(k8c.a.b(r106, r107, r108, 0, 0, 120)) <= 0) goto L26;
        r110.f443528k = r110.f443522e;
        r110.f443529l = r110.f443523f;
        r110.f443530m = r110.f443524g;
        goto L27
    L26:
        r110.f443528k = r106;
        r110.f443529l = r107;
        r110.f443530m = r108;
    L27:
        int r109 = L;
        r110.f443531n = r109;
        r110.f443532o = 0;
        if (r110.f443527j == true) goto L30;
    L35:
        r110.f443533p = true;
        return;
    L30:
        if (r110.f443535r == false) goto L32;
        r110.f443525h = H;
        r110.f443526i = 0;
        goto L35
    L32:
        int r112 = k8c.a.f502137a;
        if (k8c.a.b(r110.f443528k, r110.f443529l, r110.f443530m, r109, 0, 96).compareTo(k8c.a.b(r110.f443522e, r110.f443523f, r110.f443524g, r110.f443525h, r110.f443526i, 96)) >= 0) goto L35;
        r110.f443531n = r110.f443525h;
        r110.f443532o = r110.f443526i;
        goto L35
    }

    public static final void U90(TodoTimePickerFragment r100) {
        boolean r101 = r100.f443535r;
        int r102 = ErrorCode.ERROR_CODE_OVER_STREAM_PUBLISH_LIMIT;
        TodoDetailTimeFragmentBinding r103 = null;
        if (r101 == true) goto L5;
        if (r101 == true) goto L34;
        if (r100.X90().f443548c.size() <= 0) goto L34;
        TodoDetailTimeFragmentBinding r104 = r100.f443521d;
        if (r104 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L32:
        r103.f441351p.setCurrentItem(0);
        r100.f443541x = ((Number) ListProtector.get(r100.X90().f443548c, 0)).intValue();
        return;
    L31:
        r103 = r104;
    L34:
        if (r100.f443535r == true) goto L37;
        int r105 = s8c.a.f541021a;
        r102 = s8c.a.f541021a;
    L37:
        r100.f443541x = r102;
        return;
    L5:
        if (r100.f443539v == false) goto L18;
        TodoDetailTimeFragmentBinding r106 = r100.f443521d;
        if (r106 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r106 = null;
    L9:
        r106.f441337b.setCurrentItem(0);
        TodoDetailTimeFragmentBinding r107 = r100.f443521d;
        if (r107 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r107 = null;
    L12:
        r107.f441338c.setCurrentItem(18);
        TodoDetailTimeFragmentBinding r108 = r100.f443521d;
        if (r108 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L16:
        r103.f441339d.setCurrentItem(0);
        r100.V90();
        return;
    L15:
        r103 = r108;
        goto L16
    L18:
        if (r100.W90().f443548c.size() <= 0) goto L24;
        TodoDetailTimeFragmentBinding r109 = r100.f443521d;
        if (r109 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L23:
        r103.f441348m.setCurrentItem(0);
        r100.f443541x = ((Number) ListProtector.get(r100.W90().f443548c, 0)).intValue();
        return;
    L22:
        r103 = r109;
        goto L23
    L24:
        r100.f443541x = ErrorCode.ERROR_CODE_OVER_STREAM_PUBLISH_LIMIT;
    }

    public final void ea0(boolean r210) {
        TodoDetailTimeFragmentBinding r100 = this.f443521d;
        TodoDetailTimeFragmentBinding r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r100 = null;
    L5:
        r100.f441342g.setImageResource(R.drawable.ud_icon_right_outlined);
        TodoDetailTimeFragmentBinding r102 = this.f443521d;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r102 = null;
    L8:
        r102.f441343h.setText(com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_TaskStartTime_SetTime_Button));
        if (this.f443535r == false) goto L11;
        return;
    L11:
        boolean r103 = this.f443534q;
        if (r103 == true) goto L14;
    L15:
        if (r103 == false) goto L17;
        return;
    L17:
        if (this.f443533p == false) goto L83;
    L18:
        GregorianCalendar r104 = new GregorianCalendar();
        GregorianCalendar r105 = new GregorianCalendar();
        boolean r106 = true;
        r105.set(1, this.f443528k);
        r105.set(2, this.f443529l);
        r105.set(5, this.f443530m);
        if (r210 == false) goto L33;
        int r107 = com.ss.android.lark.todo.impl.utils.c.f444278a;
        Intrinsics.checkNotNullParameter(r104, "firstGC");
        Intrinsics.checkNotNullParameter(r105, "secondGC");
        if (com.ss.android.lark.todo.impl.utils.c.a(r104, r105) != 0) goto L23;
        boolean r108 = true;
    L24:
        if (r108 == false) goto L33;
        r105.set(11, 17);
        r105.set(12, 0);
        r105.set(13, 0);
        if (r104.getTimeInMillis() >= r105.getTimeInMillis()) goto L29;
        r105.set(11, 18);
    L28:
        r104 = r105;
    L32:
        this.f443531n = r104.get(11);
        this.f443532o = r104.get(12);
    L54:
        TodoDetailTimeFragmentBinding r109 = this.f443521d;
        if (r109 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r109 = null;
    L57:
        TextView r110 = r109.f441343h;
        TodoDetailTimeFragmentBinding r111 = this.f443521d;
        if (r111 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r111 = null;
    L60:
        r110.setText(c7c.b.i(r111.f441342g.getContext(), new Date(r104.getTimeInMillis()), new c7c.a(TimeZone.getDefault().getID(), null, null, null, null, false, !this.f443538u, false, false, 1662)));
        TodoDetailTimeFragmentBinding r112 = this.f443521d;
        if (r112 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r112 = null;
    L63:
        r112.f441358w.setSelectedCalendar(r104);
        TodoDetailTimeFragmentBinding r113 = this.f443521d;
        if (r113 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r113 = null;
    L67:
        if (r113.f441358w.getVisibility() == 0) goto L70;
        r106 = false;
    L70:
        if (r106 == true) goto L76;
        TodoDetailTimeFragmentBinding r114 = this.f443521d;
        if (r114 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L75:
        r101.f441342g.setImageResource(R.drawable.ud_icon_close_outlined);
        return;
    L74:
        r101 = r114;
        goto L75
    L76:
        TodoDetailTimeFragmentBinding r115 = this.f443521d;
        if (r115 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L80:
        r101.f441342g.setImageResource(R.drawable.ud_icon_up_outlined);
        return;
    L79:
        r101 = r115;
        goto L80
    L29:
        r104.add(11, 2);
        r104.set(12, 0);
        r104.set(13, 0);
        r105 = new GregorianCalendar();
        r105.set(11, 23);
        r105.set(12, 45);
        r105.set(13, 0);
        if (r104.getTimeInMillis() <= r105.getTimeInMillis()) goto L32;
    L23:
        r108 = false;
    L33:
        boolean r116 = this.f443534q;
        if (r116 == false) goto L36;
        int r117 = this.f443522e;
    L37:
        int r118 = r117;
        if (r116 == false) goto L40;
        int r119 = this.f443523f;
    L41:
        int r120 = r119;
        if (r116 == false) goto L44;
        int r121 = this.f443524g;
    L45:
        int r122 = r121;
        if (r116 == false) goto L48;
        int r123 = this.f443525h;
    L49:
        int r124 = r123;
        if (r116 == false) goto L52;
        int r125 = this.f443526i;
    L53:
        r104 = k8c.a.b(r118, r120, r122, r124, r125, 96);
        goto L54
    L52:
        r125 = this.f443532o;
        goto L53
    L48:
        r123 = this.f443531n;
        goto L49
    L44:
        r121 = this.f443530m;
        goto L45
    L40:
        r119 = this.f443529l;
        goto L41
    L36:
        r117 = this.f443528k;
        goto L37
    L83:
        return;
    L14:
        if (this.f443527j == true) goto L18;
        goto L15
    }

    public final void fa0(boolean r100) {
        if (this.f443535r == false) goto L6;
        this.f443540w = r100;
        return;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onCreate(r111);
        TodoDetailTimeFragmentBinding r100 = this.f443521d;
        TodoDetailTimeFragmentBinding r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r100 = null;
    L5:
        r100.f441358w.setVisibility(8);
        if (this.f443538u == false) goto L11;
        TodoDetailTimeFragmentBinding r102 = this.f443521d;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r102 = null;
    L10:
        r102.f441358w.setPickerMode(PickerModel.HOUR_MINUTE_24H);
    L16:
        if (this.f443539v == false) goto L27;
        TodoDetailTimeFragmentBinding r103 = this.f443521d;
        if (r103 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r103 = null;
    L20:
        WheelView r104 = r103.f441337b;
        r104.setAdapter((CustomReminderAdapter) this.A.getValue());
        r104.setCyclic(false);
        r104.setTextSize(com.ss.android.lark.todo.impl.utils.m.b(16.0f));
        r104.setTextSizeOuter(com.ss.android.lark.todo.impl.utils.m.b(14.0f));
        TodoDetailTimeFragmentBinding r105 = this.f443521d;
        if (r105 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r105 = null;
    L23:
        WheelView r106 = r105.f441338c;
        r106.setAdapter((CustomReminderAdapter) this.B.getValue());
        r106.setCyclic(false);
        r106.setTextSize(com.ss.android.lark.todo.impl.utils.m.b(16.0f));
        r106.setTextSizeOuter(com.ss.android.lark.todo.impl.utils.m.b(14.0f));
        TodoDetailTimeFragmentBinding r107 = this.f443521d;
        if (r107 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r107 = null;
    L26:
        WheelView r108 = r107.f441339d;
        r108.setAdapter((CustomReminderAdapter) this.C.getValue());
        r108.setCyclic(false);
        r108.setTextSize(com.ss.android.lark.todo.impl.utils.m.b(16.0f));
        r108.setTextSizeOuter(com.ss.android.lark.todo.impl.utils.m.b(14.0f));
        Intrinsics.checkNotNull(r108);
    L40:
        TodoDetailTimeFragmentBinding r109 = this.f443521d;
        if (r109 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r109 = null;
    L43:
        r109.f441351p.setAdapter(X90());
        TodoDetailTimeFragmentBinding r112 = this.f443521d;
        if (r112 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r112 = null;
    L46:
        r112.f441351p.setCyclic(false);
        TodoDetailTimeFragmentBinding r113 = this.f443521d;
        if (r113 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r113 = null;
    L49:
        r113.f441351p.setTextSize(com.ss.android.lark.todo.impl.utils.m.b(16.0f));
        TodoDetailTimeFragmentBinding r114 = this.f443521d;
        if (r114 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r114 = null;
    L52:
        r114.f441351p.setTextSizeOuter(com.ss.android.lark.todo.impl.utils.m.b(14.0f));
        TodoDetailTimeFragmentBinding r115 = this.f443521d;
        if (r115 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r115 = null;
    L55:
        CommonTitleBar r116 = r115.f441360y;
        r116.setLeftText(CommonTitleBarConstants.TEXT_CANCEL);
        r116.setLeftImageDrawable(null);
        r116.setLeftClickListener(new b(this));
        r116.addAction(new c(this, UIHelper.getString(R.string.Todo_common_Save)));
        Bundle r117 = getArguments();
        if (r117 == null) goto L95;
        Serializable r118 = r117.getSerializable("todo_due_time_chosen_data");
        if ((r118 instanceof TimeBean) == false) goto L60;
        TimeBean r119 = (TimeBean) r118;
    L61:
        this.D = r117.getString("todo_due_time_task_id", "");
        if (r119 == null) goto L95;
        if (r119.getStartTimeMillis() == 0) goto L67;
    L69:
        this.f443535r = r119.isAllDay();
        this.f443536s = r119.getRRule();
        this.f443537t = r119.getRRuleText();
        if (r119.getStartTimeMillis() == 0) goto L78;
        this.f443527j = true;
        GregorianCalendar r120 = new GregorianCalendar();
        r120.setTimeInMillis(r119.getStartTimeMillis());
        if (this.f443535r == false) goto L74;
        r120.setTimeZone(TimeZone.getTimeZone("UTC"));
    L74:
        this.f443522e = r120.get(1);
        this.f443523f = r120.get(2);
        this.f443524g = r120.get(5);
        if (this.f443535r == false) goto L77;
        int r121 = H;
        this.f443525h = r121;
        this.f443526i = r121;
    L80:
        if (r119.getDueTimeMillis() == 0) goto L88;
        this.f443533p = true;
        GregorianCalendar r122 = new GregorianCalendar();
        r122.setTimeInMillis(r119.getDueTimeMillis());
        if (this.f443535r == false) goto L84;
        r122.setTimeZone(TimeZone.getTimeZone("UTC"));
    L84:
        this.f443528k = r122.get(1);
        this.f443529l = r122.get(2);
        this.f443530m = r122.get(5);
        if (this.f443535r == false) goto L87;
        int r123 = L;
        this.f443531n = r123;
        this.f443532o = r123;
    L89:
        this.f443541x = r119.getReminderRelativeTime();
        if (r119.isAllDay() == true) goto L92;
    L94:
        this.f443536s = r119.getRRule();
        this.f443537t = r119.getRRuleText();
        goto L95
    L92:
        if (this.f443541x != (-1)) goto L94;
        fa0(true);
        goto L94
    L87:
        this.f443531n = r122.get(11);
        this.f443532o = r122.get(12);
        goto L89
    L88:
        this.f443533p = false;
        goto L89
    L77:
        this.f443525h = r120.get(11);
        this.f443526i = r120.get(12);
        goto L80
    L78:
        this.f443527j = false;
        goto L80
    L67:
        if (r119.getDueTimeMillis() != 0) goto L69;
    L60:
        r119 = null;
    L95:
        a9c.b r124 = a9c.b.f2313a;
        String r125 = this.D;
        Intrinsics.checkNotNullParameter(r125, DBDefinition.TASK_ID);
        a9c.b.a("todo_date_select_view", new JSONObject(), r125);
        ca0();
        da0();
        Z90();
        ea0(false);
        aa0();
        ba0();
        TodoDetailTimeFragmentBinding r126 = this.f443521d;
        if (r126 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r126 = null;
    L98:
        r126.f441359x.setOnTimeChosenListener(new s(this));
        TodoDetailTimeFragmentBinding r127 = this.f443521d;
        if (r127 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r127 = null;
    L101:
        r127.f441357v.setMonthPickerListener(new h(this));
        TodoDetailTimeFragmentBinding r128 = this.f443521d;
        if (r128 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r128 = null;
    L104:
        r128.f441340e.setMonthPickerListener(new i(this));
        TodoDetailTimeFragmentBinding r129 = this.f443521d;
        if (r129 != null) goto L107;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r129 = null;
    L107:
        r129.f441341f.setOnClickListener(new t(this));
        TodoDetailTimeFragmentBinding r130 = this.f443521d;
        if (r130 != null) goto L110;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r130 = null;
    L110:
        r130.f441342g.setOnClickListener(new u(this));
        TodoDetailTimeFragmentBinding r131 = this.f443521d;
        if (r131 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r131 = null;
    L113:
        r131.f441358w.setDatePickerListener(new v(this));
        TodoDetailTimeFragmentBinding r132 = this.f443521d;
        if (r132 != null) goto L116;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r132 = null;
    L116:
        r132.f441346k.setOnClickListener(new o(this));
        TodoDetailTimeFragmentBinding r133 = this.f443521d;
        if (r133 != null) goto L119;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r133 = null;
    L119:
        r133.f441345j.setOnClickListener(new p(this));
        TodoDetailTimeFragmentBinding r134 = this.f443521d;
        if (r134 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r134 = null;
    L122:
        r134.f441348m.setOnItemSelectedListener(new j(this));
        TodoDetailTimeFragmentBinding r135 = this.f443521d;
        if (r135 != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r135 = null;
    L125:
        r135.f441337b.setOnItemSelectedListener(new k(this));
        TodoDetailTimeFragmentBinding r136 = this.f443521d;
        if (r136 != null) goto L128;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r136 = null;
    L128:
        r136.f441338c.setOnItemSelectedListener(new l(this));
        TodoDetailTimeFragmentBinding r137 = this.f443521d;
        if (r137 != null) goto L131;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r137 = null;
    L131:
        r137.f441339d.setOnItemSelectedListener(new m(this));
        TodoDetailTimeFragmentBinding r138 = this.f443521d;
        if (r138 != null) goto L134;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r138 = null;
    L134:
        r138.f441351p.setOnItemSelectedListener(new n(this));
        TodoDetailTimeFragmentBinding r139 = this.f443521d;
        if (r139 != null) goto L137;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r139 = null;
    L137:
        r139.f441356u.setOnClickListener(new q(this));
        TodoDetailTimeFragmentBinding r140 = this.f443521d;
        if (r140 != null) goto L140;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L141:
        r101.f441354s.setOnClickListener(new r(this));
        return;
    L140:
        r101 = r140;
        goto L141
    L27:
        TodoDetailTimeFragmentBinding r141 = this.f443521d;
        if (r141 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r141 = null;
    L30:
        r141.f441348m.setAdapter(W90());
        TodoDetailTimeFragmentBinding r142 = this.f443521d;
        if (r142 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r142 = null;
    L33:
        r142.f441348m.setCyclic(false);
        TodoDetailTimeFragmentBinding r143 = this.f443521d;
        if (r143 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r143 = null;
    L36:
        r143.f441348m.setTextSize(com.ss.android.lark.todo.impl.utils.m.b(16.0f));
        TodoDetailTimeFragmentBinding r144 = this.f443521d;
        if (r144 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r144 = null;
    L39:
        r144.f441348m.setTextSizeOuter(com.ss.android.lark.todo.impl.utils.m.b(14.0f));
        goto L40
    L11:
        TodoDetailTimeFragmentBinding r145 = this.f443521d;
        if (r145 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r145 = null;
    L14:
        r145.f441358w.setPickerMode(PickerModel.HOUR_MINUTE_12H);
        goto L16
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        if (r100 == 256) goto L5;
        return;
    L5:
        if (r101 != (-1)) goto L20;
        String r103 = "";
        if (r102 == null) goto L10;
        String r104 = r102.getStringExtra("custom_repeat_result_rrule");
        if (r104 == null) goto L10;
    L11:
        this.f443536s = r104;
        if (r102 == null) goto L17;
        String r105 = r102.getStringExtra("custom_repeat_result_display_text");
        if (r105 == null) goto L17;
        r103 = r105;
    L17:
        this.f443537t = r103;
        Log.i("TodoTimePickerFragment", "choose custom:" + this.f443536s + ", display result:" + this.f443537t);
        ba0();
        return;
    L10:
        r104 = "";
        goto L11
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r310, ViewGroup r311, Bundle r312) {
        Intrinsics.checkNotNullParameter(r310, "inflater");
        View r100 = r310.inflate(R.layout.todo_detail_time_fragment, r311, false);
        int r101 = R.id.custom_reminder_date;
        WheelView r102 = (WheelView) ViewBindings.findChildViewById(r100, R.id.custom_reminder_date);
        if (r102 == null) goto L53;
        r101 = R.id.custom_reminder_hour;
        WheelView r103 = (WheelView) ViewBindings.findChildViewById(r100, R.id.custom_reminder_hour);
        if (r103 == null) goto L53;
        r101 = R.id.custom_reminder_minute;
        WheelView r104 = (WheelView) ViewBindings.findChildViewById(r100, R.id.custom_reminder_minute);
        if (r104 == null) goto L53;
        r101 = R.id.end_month_picker;
        UDDatePicker r105 = (UDDatePicker) ViewBindings.findChildViewById(r100, R.id.end_month_picker);
        if (r105 == null) goto L53;
        r101 = R.id.hour_time_container;
        LinearLayout r106 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.hour_time_container);
        if (r106 == null) goto L53;
        r101 = R.id.hour_time_icon;
        AppCompatImageView r110 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.hour_time_icon);
        if (r110 == null) goto L53;
        r101 = R.id.hour_time_txt;
        TextView r111 = (TextView) ViewBindings.findChildViewById(r100, R.id.hour_time_txt);
        if (r111 == null) goto L53;
        r101 = R.id.reminder_icon;
        AppCompatImageView r112 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.reminder_icon);
        if (r112 == null) goto L53;
        r101 = R.id.reminder_icon_right;
        AppCompatImageView r113 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.reminder_icon_right);
        if (r113 == null) goto L53;
        r101 = R.id.reminder_text_container;
        LinearLayout r114 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.reminder_text_container);
        if (r114 == null) goto L53;
        r101 = R.id.reminder_txt;
        TextView r115 = (TextView) ViewBindings.findChildViewById(r100, R.id.reminder_txt);
        if (r115 == null) goto L53;
        r101 = R.id.reminder_wheel_all_day;
        WheelView r116 = (WheelView) ViewBindings.findChildViewById(r100, R.id.reminder_wheel_all_day);
        if (r116 == null) goto L53;
        r101 = R.id.reminder_wheel_all_day_container;
        TaskScrollChildLinearLayout r117 = (TaskScrollChildLinearLayout) ViewBindings.findChildViewById(r100, R.id.reminder_wheel_all_day_container);
        if (r117 == null) goto L53;
        r101 = R.id.reminder_wheel_all_day_custom_reminder_container;
        TaskScrollChildLinearLayout r118 = (TaskScrollChildLinearLayout) ViewBindings.findChildViewById(r100, R.id.reminder_wheel_all_day_custom_reminder_container);
        if (r118 == null) goto L53;
        r101 = R.id.reminder_wheel_normal;
        WheelView r119 = (WheelView) ViewBindings.findChildViewById(r100, R.id.reminder_wheel_normal);
        if (r119 == null) goto L53;
        r101 = R.id.reminder_wheel_normal_container;
        TaskScrollChildLinearLayout r210 = (TaskScrollChildLinearLayout) ViewBindings.findChildViewById(r100, R.id.reminder_wheel_normal_container);
        if (r210 == null) goto L53;
        r101 = R.id.repeat_rrule_icon;
        AppCompatImageView r211 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.repeat_rrule_icon);
        if (r211 == null) goto L53;
        r101 = R.id.repeat_rrule_right_icon;
        AppCompatImageView r212 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.repeat_rrule_right_icon);
        if (r212 == null) goto L53;
        r101 = R.id.repeat_rrule_text;
        TextView r213 = (TextView) ViewBindings.findChildViewById(r100, R.id.repeat_rrule_text);
        if (r213 == null) goto L53;
        r101 = R.id.repeat_rrule_text_container;
        LinearLayout r214 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.repeat_rrule_text_container);
        if (r214 == null) goto L53;
        r101 = R.id.start_month_picker;
        UDDatePicker r215 = (UDDatePicker) ViewBindings.findChildViewById(r100, R.id.start_month_picker);
        if (r215 == null) goto L53;
        r101 = R.id.time_picker;
        UDTimePicker r216 = (UDTimePicker) ViewBindings.findChildViewById(r100, R.id.time_picker);
        if (r216 == null) goto L53;
        r101 = R.id.time_select_container;
        TaskTimeContainer r217 = (TaskTimeContainer) ViewBindings.findChildViewById(r100, R.id.time_select_container);
        if (r217 == null) goto L53;
        r101 = R.id.title_bar;
        CommonTitleBar r218 = (CommonTitleBar) ViewBindings.findChildViewById(r100, R.id.title_bar);
        if (r218 == null) goto L53;
        TodoDetailTimeFragmentBinding r107 = new TodoDetailTimeFragmentBinding((LinearLayout) r100, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218);
        this.f443521d = r107;
        return r107.f441336a;
    L53:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }
}
