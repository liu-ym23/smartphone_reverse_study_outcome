package com.ss.android.lark.widget.timepicker;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.time.format.entity.DataRepresentation;
import com.ss.android.lark.time.format.entity.DatePreciseness;
import com.ss.android.lark.time.format.entity.DisplayPattern;
import com.ss.android.lark.time.format.entity.LengthType;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.widget.timepicker.monthview.MonthCalendarViewAdapter;
import com.ss.android.lark.widget.timepicker.monthview.MonthViewContainer;
import com.ss.android.lark.widget.timepicker.monthview.MonthViewPager;
import com.ss.android.lark.widget.timepicker.monthview.constants.MonthViewAttr$SelectTimeType;
import com.ss.android.lark.widget.timepicker.monthview.data.CalendarDate;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 {2\u00020\u00012\u00020\u0002:\u0003{|}B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106H\u0016J&\u00107\u001a\u0004\u0018\u00010\u00122\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u001a\u0010<\u001a\u0002042\u0006\u0010=\u001a\u00020\u00122\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0010\u0010>\u001a\u0002042\u0006\u0010=\u001a\u00020\u0012H\u0002J\u0010\u0010?\u001a\u0002042\u0006\u0010=\u001a\u00020\u0012H\u0002J\b\u0010@\u001a\u000204H\u0002J\u0014\u0010A\u001a\u0004\u0018\u00010&2\b\u0010B\u001a\u0004\u0018\u00010&H\u0002J\u0014\u0010C\u001a\u0004\u0018\u00010&2\b\u0010D\u001a\u0004\u0018\u00010&H\u0002J\u0010\u0010E\u001a\u00020#2\u0006\u0010F\u001a\u00020&H\u0002J\u0010\u0010G\u001a\u00020#2\u0006\u0010F\u001a\u00020&H\u0002J\b\u0010H\u001a\u000204H\u0002J\b\u0010I\u001a\u000204H\u0002J\u0012\u0010J\u001a\u00020K2\b\u0010F\u001a\u0004\u0018\u00010&H\u0002J\u0010\u0010L\u001a\u0002042\u0006\u0010F\u001a\u00020&H\u0002J\b\u0010L\u001a\u000204H\u0002J\b\u0010M\u001a\u000204H\u0002J\u0010\u0010N\u001a\u0002042\b\b\u0001\u0010O\u001a\u00020-J\u0010\u0010P\u001a\u0002042\b\u0010Q\u001a\u0004\u0018\u00010RJ\u001a\u0010S\u001a\u0002042\b\u0010=\u001a\u0004\u0018\u00010\u00122\u0006\u0010T\u001a\u00020-H\u0002J\b\u0010U\u001a\u000204H\u0002J\b\u0010V\u001a\u000204H\u0002J\u0018\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020ZH\u0002J\b\u0010\\\u001a\u000204H\u0002J\b\u0010]\u001a\u000204H\u0002J\u0010\u0010^\u001a\u0002042\u0006\u0010_\u001a\u00020&H\u0002J\u0010\u0010`\u001a\u0002042\u0006\u0010_\u001a\u00020&H\u0002J\u0012\u0010a\u001a\u0002042\b\u0010B\u001a\u0004\u0018\u00010&H\u0002J\u0012\u0010b\u001a\u0002042\b\u0010D\u001a\u0004\u0018\u00010&H\u0002J\b\u0010c\u001a\u000204H\u0002J\u0012\u0010d\u001a\u0002042\b\u0010e\u001a\u0004\u0018\u00010&H\u0002J\b\u0010f\u001a\u000204H\u0002J&\u0010g\u001a\u0002042\b\u0010h\u001a\u0004\u0018\u00010&2\b\u0010B\u001a\u0004\u0018\u00010&2\b\u0010D\u001a\u0004\u0018\u00010&H\u0002J\u001c\u0010i\u001a\u00020\u00042\b\u0010B\u001a\u0004\u0018\u00010&2\b\u0010D\u001a\u0004\u0018\u00010&H\u0002J\b\u0010j\u001a\u000204H\u0002J\b\u0010k\u001a\u000204H\u0002J\b\u0010l\u001a\u000204H\u0002J\b\u0010m\u001a\u000204H\u0002J\b\u0010n\u001a\u000204H\u0002J\b\u0010o\u001a\u000204H\u0002J\u0012\u0010p\u001a\u00020#2\b\u0010F\u001a\u0004\u0018\u00010&H\u0002J\b\u0010q\u001a\u000204H\u0002J\u0012\u0010r\u001a\u00020\u00042\b\u0010F\u001a\u0004\u0018\u00010&H\u0002J\u001e\u0010s\u001a\u0002042\u0016\u0010t\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010&\u0012\u0006\u0012\u0004\u0018\u00010&0uJ\u0010\u0010v\u001a\u0002042\b\u0010w\u001a\u0004\u0018\u00010)J\u000e\u0010x\u001a\u0002042\u0006\u0010y\u001a\u00020+J\b\u0010z\u001a\u000204H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b.\u0010/R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006~"}, d2 = {"Lcom/ss/android/lark/widget/timepicker/TimeSelectFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/ss/android/lark/widget/timepicker/ITimeSelectInterface;", "noLimit", "", "<init>", "(Z)V", "mTitleBar", "Lcom/ss/android/lark/ui/CommonTitleBar;", "mStartTimeLayout", "Landroid/widget/LinearLayout;", "mStartTimeTV", "Landroid/widget/TextView;", "mStartTimeLabelTV", "mEndTimeLayout", "mEndTimeTV", "mEndTimeLabelTV", "yearMonthSelectView", "Landroid/view/View;", "backToDaysTv", "Landroid/widget/ImageView;", "mCurrentMonthTV", "mLastMonthBtnIV", "mNextMonthBtnIV", "mTimeSelectNoLimitRL", "Landroid/widget/RelativeLayout;", "mTimeSelectNoLimitCB", "Landroid/widget/CheckBox;", "mMonthViewContainer", "Lcom/ss/android/lark/widget/timepicker/monthview/MonthViewContainer;", "yearMonthPicker", "Lcom/ss/android/lark/widget/timepicker/YearMonthPicker;", "daysModeGroup", "Landroidx/constraintlayout/widget/Group;", "mTodayDate", "Lcom/ss/android/lark/widget/timepicker/monthview/data/CalendarDate;", "mCurrentSelectedDate", "mCurrSelectedStartTime", "Ljava/util/Date;", "mCurrSelectedEndTime", "mSelectListener", "Lcom/ss/android/lark/widget/timepicker/TimeSelectDialog$ITimeSelectListener;", "mSelectCallback", "Lcom/ss/android/lark/widget/timepicker/TimeSelectDialog$ITimeSelectCallback;", "mCurrSelectedTimeType", "", "getMCurrSelectedTimeType$annotations", "()V", "mCheckedChangeListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "mWindowStyle", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "init", "initViews", "initTitleBar", "getFinalSelectedStartTime", DyPayConstant.KEY_START_TIME, "getFinalSelectedEndTime", "endTime", "moveToDayStart", "date", "moveToDayEnd", "initStartTimeLabel", "initEndTimeLabel", "getSelectedDate", "", "updateCurrentMonth", "initMonthView", "setWindowStyle", "style", com.alipay.sdk.m.x.d.f25925o, "title", "", "setupLayoutParamHeight", "heightDp", "updatePickerView", "initListeners", "createAnimation", "Landroid/view/animation/TranslateAnimation;", "fromXValue", "", "toXValue", "showStartTimeNoLimitView", "showStartTimeLimitView", "updateCurrentTime", "selectDate", "updateTimeView", "updateStartTimeView", "updateEndTimeView", "setStartAnyTimeText", "setStartTimeText", com.heytap.mcssdk.constant.b.f276369s, "setEndAnyTimeText", "setEndTimeText", com.heytap.mcssdk.constant.b.f276370t, "startTimeOverEndTime", "showStartTimeSelectedView", "showTimeSelectNoLimitCheckBox", "showEndTimeSelectedView", "setStartTimeSelectedTextColor", "setEndTimeSelectedTextColor", "updateMonthOptionalView", "getTargetCalendarDate", "willShow", "isTimeNoLimit", "setSelectedTime", "timePair", "Landroid/util/Pair;", "setTimeSelectListener", "selectListener", "setTimeSelectCallback", "selectCallback", "closeTimeSelect", "Companion", "TimeType", "WindowStyle", "widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TimeSelectFragment extends DialogFragment {
    public static final /* synthetic */ int B = 0;
    public i A;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f448959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CommonTitleBar f448960e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearLayout f448961f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f448962g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f448963h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f448964i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f448965j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f448966k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f448967l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ImageView f448968m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f448969n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ImageView f448970o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ImageView f448971p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public RelativeLayout f448972q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CheckBox f448973r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public MonthViewContainer f448974s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public YearMonthPicker f448975t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Group f448976u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public CalendarDate f448977v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public CalendarDate f448978w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Date f448979x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Date f448980y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f448981z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0083\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/widget/timepicker/TimeSelectFragment$TimeType;", "", "Companion", "widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface TimeType {
        public static final a Companion = null;
        public static final int END_TIME = 2;
        public static final int START_TIME = 1;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f448982a = null;

            static {
                f448982a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f448982a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/widget/timepicker/TimeSelectFragment$WindowStyle;", "", "Companion", "widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface WindowStyle {
        public static final int BOTTOM = 1;
        public static final int CENTER = 2;
        public static final a Companion = null;
        public static final int NONE = 0;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f448983a = null;

            static {
                f448983a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f448983a;
        }
    }

    public static final class a {
    }

    static {
    }

    public final void aa0() {
        if (this.f448959d == false) goto L29;
        RelativeLayout r100 = this.f448972q;
        if (r100 == null) goto L7;
        r100.setVisibility(0);
    L7:
        CheckBox r101 = this.f448973r;
        if (r101 != null) goto L10;
        return;
    L10:
        if (this.f448981z != 1) goto L21;
        if (this.f448979x != null) goto L16;
        if (r101.isChecked() == true) goto L16;
    L19:
        r101.toggle();
        return;
    L16:
        if (this.f448979x != null) goto L18;
        return;
    L18:
        if (r101.isChecked() == true) goto L19;
        return;
    L21:
        if (this.f448980y != null) goto L25;
        if (r101.isChecked() == true) goto L25;
    L28:
        r101.toggle();
        return;
    L25:
        if (this.f448980y != null) goto L27;
        return;
    L27:
        if (r101.isChecked() == true) goto L28;
        return;
    L29:
        RelativeLayout r102 = this.f448972q;
        if (r102 != null) goto L32;
        return;
    L32:
        if (this.f448981z != 1) goto L34;
        r102.setVisibility(0);
        return;
    L34:
        r102.setVisibility(8);
    }

    public final void ca0() {
        MonthViewContainer r100 = this.f448974s;
        if (r100 == null) goto L5;
        CalendarDate r101 = r100.getCurrShownDate();
    L6:
        if (r101 == null) goto L9;
        da0(r101.getDate());
        return;
    L9:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void ea0() {
        CalendarDate r100 = this.f448978w;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f448959d == false) goto L9;
        MonthViewContainer r101 = this.f448974s;
        if (r101 == null) goto L14;
        r101.d(V90(this.f448979x), W90(this.f448979x), V90(this.f448980y), W90(this.f448980y), r100, MonthViewAttr$SelectTimeType.forNumber(this.f448981z));
        return;
    L14:
        return;
    L9:
        MonthViewContainer r102 = this.f448974s;
        if (r102 == null) goto L16;
        r102.d(V90(this.f448979x), this.f448959d, V90(this.f448980y), this.f448959d, r100, MonthViewAttr$SelectTimeType.forNumber(this.f448981z));
        return;
    }

    public TimeSelectFragment() {
        this.f448959d = false;
        this.f448981z = 1;
    }

    public final void T90() {
        if (com.suite.lark.component.navroute.forseti.f.b(this) == null) goto L14;
        com.suite.lark.component.navroute.forseti.g r100 = com.suite.lark.component.navroute.forseti.f.b(this);
        if (r100 == null) goto L16;
        r100.g(null);
        return;
    L16:
        return;
    L14:
        dismiss();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L18;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void X90() {
        String r100 = UIUtils.getString(requireContext(), R.string.Lark_Search_AnyTime);
        TextView r101 = this.f448965j;
        if (r101 == null) goto L5;
        TextPaint r102 = r101.getPaint();
    L6:
        if (r102 == null) goto L8;
        r102.setFlags(0);
    L8:
        TextView r103 = this.f448965j;
        if (r103 == null) goto L12;
        r103.setText(r100);
        return;
    L12:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void Z90() {
        String r100 = UIUtils.getString(requireContext(), R.string.Lark_Search_AnyTime);
        TextView r101 = this.f448962g;
        if (r101 == null) goto L5;
        r101.setText(r100);
    L5:
        Date r102 = this.f448980y;
        if (r102 != null) goto L8;
        X90();
        return;
    L8:
        Y90(r102, null, null);
    }

    public static final void S90(TimeSelectFragment r100) {
        YearMonthPicker r101 = r100.f448975t;
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L23;
        YearMonthPicker r103 = r100.f448975t;
        if (r103 == null) goto L12;
        r103.setVisibility(8);
    L12:
        Group r104 = r100.f448976u;
        if (r104 == null) goto L15;
        r104.setVisibility(0);
    L15:
        r100.aa0();
        ImageView r105 = r100.f448968m;
        if (r105 == null) goto L18;
        r105.setVisibility(8);
    L18:
        TextView r106 = r100.f448969n;
        if (r106 == null) goto L21;
        r106.setTextColor(UIUtils.getColor(r100.requireContext(), R.color.text_title));
    L21:
        r100.ca0();
        return;
    L23:
        return;
    L5:
        if (r101.getVisibility() != 0) goto L7;
        r102 = true;
        goto L8
    }

    public static CalendarDate V90(Date r100) {
        if (r100 != null) goto L5;
        return new CalendarDate(new Date(0));
    L5:
        return new CalendarDate(r100);
    }

    public static boolean W90(Date r100) {
        if (r100 != null) goto L5;
    L6:
        return true;
    L5:
        if (r100.getTime() == 0) goto L6;
        return false;
    }

    public final String U90(Date r110) {
        if (r110 != null) goto L5;
        return "";
    L5:
        c7c.a r111 = new c7c.a(null, null, null, null, null, false, false, false, false, 2047);
        r111.b(DisplayPattern.ABSOLUTE);
        r111.a(DatePreciseness.DAY);
        r111.c(LengthType.LONG);
        DataRepresentation r100 = DataRepresentation.ISO;
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r111.f22682f = r100;
        return c7c.b.a(requireContext(), r110, r111);
    }

    public final void da0(Date r110) {
        c7c.a r111 = new c7c.a(null, null, null, null, null, false, false, false, false, 2047);
        r111.b(DisplayPattern.ABSOLUTE);
        r111.a(DatePreciseness.MONTH);
        r111.c(LengthType.LONG);
        TextView r100 = this.f448969n;
        if (r100 == null) goto L6;
        r100.setText(c7c.b.a(requireContext(), r110, r111));
        return;
    }

    public final void fa0(Date r100) {
        if (W90(r100) == false) goto L5;
        Z90();
        return;
    L5:
        String r101 = U90(r100);
        TextView r102 = this.f448962g;
        if (r102 == null) goto L8;
        r102.setText(r101);
    L8:
        Date r103 = this.f448980y;
        if (r103 != null) goto L11;
        X90();
        return;
    L11:
        Y90(r103, this.f448979x, r103);
    }

    public final void ga0(Date r100) {
        if (this.f448981z != 1) goto L5;
        this.f448979x = r100;
        fa0(r100);
        return;
    L5:
        this.f448980y = r100;
        if (W90(r100) == false) goto L8;
        X90();
        return;
    L8:
        Y90(r100, this.f448979x, r100);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        CalendarDate r101 = new CalendarDate();
        this.f448977v = r101;
        this.f448978w = r101;
        if (this.f448959d == true) goto L6;
        this.f448980y = r101.getDate();
        return;
    }

    public static boolean ba0(Date r100, Date r101) {
        if (r100 == null) goto L20;
        if (r101 == null) goto L20;
        if ((r100.getYear() - r101.getYear()) < 0) goto L20;
        if ((r100.getYear() - r101.getYear()) <= 0) goto L12;
    L19:
        return true;
    L12:
        if ((r100.getMonth() - r101.getMonth()) < 0) goto L20;
        if ((r100.getMonth() - r101.getMonth()) > 0) goto L19;
        if ((r100.getDate() - r101.getDate()) > 0) goto L19;
    L20:
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        int r102 = WindowInsetsUtils.f427723a;
        Intrinsics.checkNotNullParameter(this, WidgetService.PARAM_FRAGMENT);
        com.ss.android.lark.insets.f r103 = WindowInsetsUtils.b(this);
        r103.f(true);
        r103.o(true);
        r103.c(true);
        this.f448960e = (CommonTitleBar) r100.findViewById(R.id.title_bar);
        this.f448961f = (LinearLayout) r100.findViewById(R.id.start_time_ll);
        this.f448962g = (TextView) r100.findViewById(R.id.start_time_tv);
        this.f448963h = (TextView) r100.findViewById(R.id.start_time_label_tv);
        this.f448964i = (LinearLayout) r100.findViewById(R.id.end_time_ll);
        this.f448965j = (TextView) r100.findViewById(R.id.end_time_tv);
        this.f448966k = (TextView) r100.findViewById(R.id.end_time_label_tv);
        this.f448967l = r100.findViewById(R.id.year_month_select_cl);
        this.f448968m = (ImageView) r100.findViewById(R.id.back_to_days_mode);
        this.f448969n = (TextView) r100.findViewById(R.id.current_month_label_tv);
        this.f448970o = (ImageView) r100.findViewById(R.id.last_month_btn_iv);
        this.f448971p = (ImageView) r100.findViewById(R.id.next_month_btn_iv);
        this.f448972q = (RelativeLayout) r100.findViewById(R.id.time_select_no_limit_rl);
        this.f448973r = (CheckBox) r100.findViewById(R.id.time_select_no_limit_cb);
        this.f448974s = (MonthViewContainer) r100.findViewById(R.id.days_picker);
        this.f448975t = (YearMonthPicker) r100.findViewById(R.id.year_month_picker);
        this.f448976u = (Group) r100.findViewById(R.id.days_mode_group);
        TextView r104 = this.f448962g;
        if (r104 == null) goto L5;
        w08.a.b(r104, 0);
    L5:
        TextView r105 = this.f448965j;
        if (r105 == null) goto L8;
        w08.a.b(r105, 0);
    L8:
        ImageView r106 = this.f448968m;
        if (r106 == null) goto L11;
        r106.setImageDrawable(UDIconUtils.getIconDrawable(requireContext(), R.drawable.ud_icon_left_outlined, UDColorUtils.getColor(requireContext(), R.color.icon_n2)));
    L11:
        ImageView r107 = this.f448970o;
        if (r107 == null) goto L14;
        r107.setImageDrawable(UDIconUtils.getIconDrawable(requireContext(), R.drawable.ud_icon_left_outlined, UDColorUtils.getColor(requireContext(), R.color.icon_n2)));
    L14:
        ImageView r108 = this.f448971p;
        if (r108 == null) goto L17;
        r108.setImageDrawable(UDIconUtils.getIconDrawable(requireContext(), R.drawable.ud_icon_right_outlined, UDColorUtils.getColor(requireContext(), R.color.icon_n2)));
    L17:
        CommonTitleBar r109 = this.f448960e;
        if (r109 == null) goto L20;
        r109.setTitle(UIUtils.getString(requireContext(), R.string.Lark_Search_SelectStartTime));
    L20:
        CommonTitleBar r110 = this.f448960e;
        if (r110 == null) goto L23;
        r110.setLeftClickListener(new l(this));
    L23:
        CommonTitleBar r111 = this.f448960e;
        if (r111 == null) goto L26;
        r111.addAction(new m(this, UIUtils.getString(requireContext(), R.string.Lark_Legacy_Completed)));
    L26:
        Z90();
        MonthCalendarViewAdapter r112 = null;
        if (this.f448959d == false) goto L29;
        X90();
    L37:
        ca0();
        MonthViewContainer r113 = this.f448974s;
        if (r113 == null) goto L44;
        boolean r114 = this.f448959d;
        int r115 = UIUtils.dp2px(r113.getContext(), 243.0f);
        r113.f449028e = r115;
        r113.f449029f = r115 / 6;
        r113.getLookMonthLayoutFromXml().setMMonthViewListener(new vec.h(r113));
        new ValueAnimator().addUpdateListener(new vec.i(r113));
        Ref.IntRef r116 = new Ref.IntRef();
        r116.element = r113.f449031h.getWeeklyDayIndex();
        r113.getLookWeekIndicatorFromXml().a(r116.element, true);
        MonthCalendarViewAdapter r117 = new MonthCalendarViewAdapter(r113.getContext(), new vec.j(r113), r114);
        r113.f449034k = r117;
        r117.f449022h = new com.ss.android.lark.widget.timepicker.monthview.a(r113, r116);
        MonthViewPager r118 = r113.getLookMonthViewPagerFromXml();
        MonthCalendarViewAdapter r119 = r113.f449034k;
        if (r119 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("mMonthViewAdapter");
    L43:
        r118.setAdapter(r112);
        r113.getLookMonthViewPagerFromXml().setViewPageListener(new com.ss.android.lark.widget.timepicker.monthview.b(r113, r116));
        int r120 = r113.getLookMonthViewPagerFromXml().getRowNum() * r113.f449029f;
        ViewGroup.LayoutParams r121 = r113.getLookMonthLayoutFromXml().getLayoutParams();
        Intrinsics.checkNotNull(r121, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r122 = (LinearLayout.LayoutParams) r121;
        r122.height = r120 + UIUtils.dp2px(r113.getContext(), 32.0f);
        r113.getLookMonthLayoutFromXml().setLayoutParams(r122);
        goto L44
    L42:
        r112 = r119;
    L44:
        LinearLayout r123 = this.f448961f;
        if (r123 == null) goto L47;
        r123.setOnClickListener(new c(this));
    L47:
        LinearLayout r124 = this.f448964i;
        if (r124 == null) goto L50;
        r124.setOnClickListener(new d(this));
    L50:
        ImageView r125 = this.f448970o;
        if (r125 == null) goto L53;
        r125.setOnClickListener(new e(this));
    L53:
        ImageView r126 = this.f448971p;
        if (r126 == null) goto L56;
        r126.setOnClickListener(new f(this));
    L56:
        MonthViewContainer r127 = this.f448974s;
        if (r127 == null) goto L59;
        r127.setChangeListener(new g(this));
    L59:
        RelativeLayout r128 = this.f448972q;
        if (r128 == null) goto L62;
        r128.setOnClickListener(new h(this));
    L62:
        this.A = new i(this);
        View r129 = this.f448967l;
        if (r129 == null) goto L65;
        r129.setOnClickListener(new j(this));
    L65:
        YearMonthPicker r130 = this.f448975t;
        if (r130 == null) goto L68;
        r130.setYearMonthChange(new k(this));
    L68:
        fa0(this.f448979x);
        Date r131 = this.f448980y;
        if (W90(r131) == false) goto L71;
        X90();
    L72:
        CheckBox r132 = this.f448973r;
        if (r132 == null) goto L75;
        r132.setChecked(W90(this.f448979x));
    L75:
        CheckBox r133 = this.f448973r;
        if (r133 == null) goto L78;
        r133.setOnCheckedChangeListener(this.A);
    L78:
        ea0();
        return;
    L71:
        Y90(r131, this.f448979x, r131);
        goto L72
    L29:
        MonthViewContainer r134 = this.f448974s;
        if (r134 == null) goto L32;
        CalendarDate r135 = r134.getCurrSelectedDate();
    L33:
        if (r135 == null) goto L35;
        Date r136 = r135.getDate();
    L36:
        Y90(r136, null, null);
        goto L37
    L35:
        r136 = null;
        goto L36
    L32:
        r135 = null;
        goto L33
    }

    public final void Y90(Date r100, Date r101, Date r102) {
        String r103 = U90(r100);
        TextPaint r104 = null;
        if (r101 == null) goto L15;
        if (r102 == null) goto L15;
        if (ba0(r101, r102) == false) goto L15;
        TextView r105 = this.f448965j;
        if (r105 == null) goto L10;
        r104 = r105.getPaint();
    L10:
        if (r104 == null) goto L12;
        r104.setFlags(17);
    L12:
        TextView r106 = this.f448965j;
        if (r106 == null) goto L24;
        r106.setText(r103);
        return;
    L24:
        return;
    L15:
        TextView r107 = this.f448965j;
        if (r107 == null) goto L18;
        r104 = r107.getPaint();
    L18:
        if (r104 == null) goto L20;
        r104.setFlags(0);
    L20:
        TextView r108 = this.f448965j;
        if (r108 == null) goto L26;
        r108.setText(r103);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.dialog_time_select_layout, r101, false);
    }
}
