package com.larksuite.component.universe_design.timepicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.bytedance.ee.bear.document.bitable.TimeZoneItemV2;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.component.universe_design.timepicker.impl.data.PanelStyleData;
import com.larksuite.component.universe_design.timepicker.impl.data.PickerBuilder;
import com.larksuite.component.universe_design.timepicker.impl.data.PickerModel;
import com.larksuite.component.universe_design.timepicker.impl.helper.TimePickerHelper;
import com.larksuite.component.universe_design.timepicker.impl.helper.UtcDates;
import com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController;
import com.larksuite.component.universe_design.timepicker.impl.panel.f;
import com.larksuite.component.universe_design.util.CalendarDate;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import h18.d;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001%\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fB+\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\u000eJ\"\u0010'\u001a\u00020(2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010*\u001a\u00020(H\u0002J\b\u0010+\u001a\u00020(H\u0002J\u0010\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020\u0010H\u0016J\u001d\u0010.\u001a\u00020(2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0000¢\u0006\u0002\b/J\u0010\u00100\u001a\u00020(2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u00101\u001a\u00020(2\u0006\u00102\u001a\u00020\u0018H\u0016J\u0010\u00103\u001a\u00020(2\u0006\u00104\u001a\u00020\u000bH\u0016J\u0010\u00105\u001a\u00020(2\u0006\u00106\u001a\u00020\u001aH\u0016J\b\u00107\u001a\u00020\u001aH\u0016J\u0010\u00108\u001a\u00020(2\u0006\u00109\u001a\u00020\u000bH\u0016J\b\u0010:\u001a\u00020(H\u0016J\b\u0010;\u001a\u00020(H\u0016J\u0010\u0010<\u001a\u00020(2\u0006\u0010=\u001a\u00020#H\u0016J\u0012\u0010>\u001a\u00020#2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J(\u0010A\u001a\u00020(2\u0006\u0010B\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020\u000b2\u0006\u0010D\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020\u000bH\u0014J\u0010\u0010F\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020\u000bH\u0002R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0004\n\u0002\u0010&¨\u0006G"}, d2 = {"Lcom/larksuite/component/universe_design/timepicker/UDTimePicker;", "Landroid/widget/LinearLayout;", "Lcom/larksuite/component/universe_design/timepicker/api/ITimePickerDelegate;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "baseController", "Lcom/larksuite/component/universe_design/timepicker/impl/panel/BaseTimePickerController;", "getBaseController", "()Lcom/larksuite/component/universe_design/timepicker/impl/panel/BaseTimePickerController;", "setBaseController", "(Lcom/larksuite/component/universe_design/timepicker/impl/panel/BaseTimePickerController;)V", "pickerModel", "Lcom/larksuite/component/universe_design/timepicker/impl/data/PickerModel;", "timePickerListener", "Lcom/larksuite/component/universe_design/timepicker/api/ITimePickerDelegate$TimePickerListener;", "selectedCalendar", "Ljava/util/Calendar;", "selectedTimeZone", "Ljava/util/TimeZone;", "panelStyleData", "Lcom/larksuite/component/universe_design/timepicker/impl/data/PanelStyleData;", "beginDate", "Lcom/larksuite/component/universe_design/util/CalendarDate;", com.heytap.mcssdk.constant.b.f276370t, "autoAdjustVisibleNum", "", "pickerPanelListener", "com/larksuite/component/universe_design/timepicker/UDTimePicker$pickerPanelListener$1", "Lcom/larksuite/component/universe_design/timepicker/UDTimePicker$pickerPanelListener$1;", "init", "", "defStyle", "initController", "createView", "setPanelController", "panelController", "setPickerDateRange", "setPickerDateRange$universe_ui_datepicker_release", "setPickerMode", "setDatePickerListener", "listener", "setItemVisibleNum", "visibleItemNum", "setSelectedCalendar", "calendarDate", "getSelectedCalendar", "setMinuteInterval", "minuteInterval", "showItemDivider", "hideItemDivider", "setAutoAdjustItemNum", "autoAdjust", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onSizeChanged", "width", "height", "oldw", "oldh", "getAdjustVisibleItem", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class UDTimePicker extends LinearLayout {
    private boolean autoAdjustVisibleNum;
    private BaseTimePickerController baseController;
    private CalendarDate beginDate;
    private CalendarDate endDate;
    private PanelStyleData panelStyleData;
    private PickerModel pickerModel;
    private b pickerPanelListener;
    private Calendar selectedCalendar;
    private TimeZone selectedTimeZone;
    private c18.a timePickerListener;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UDTimePicker f285359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f285360b;

        public a(UDTimePicker r100, int r101) {
            this.f285359a = r100;
            this.f285360b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f285359a.setItemVisibleNum(this.f285360b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements BaseTimePickerController.PickerPanelDependency {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UDTimePicker f285361a;

        @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController.PickerPanelDependency
        public final PanelStyleData getPanelStyleData() {
            return UDTimePicker.access$getPanelStyleData$p(this.f285361a);
        }

        @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController.PickerPanelDependency
        public final Calendar getSelectedDate() {
            return UDTimePicker.access$getSelectedCalendar$p(this.f285361a);
        }

        public b(UDTimePicker r100) {
            this.f285361a = r100;
        }

        @Override // com.larksuite.component.universe_design.timepicker.impl.panel.BaseTimePickerController.PickerPanelDependency
        public final void onSelected(Calendar r100) {
            Intrinsics.checkNotNullParameter(r100, "selectedDate");
            UDTimePicker.access$setSelectedCalendar$p(this.f285361a, r100);
            CalendarDate r101 = new CalendarDate(r100);
            c18.a r102 = UDTimePicker.access$getTimePickerListener$p(this.f285361a);
            if (r102 == null) goto L6;
            r102.a(r101.getYear(), r101.getMonth() - 1, r101.getMonthDay(), r101.getHour(), r101.getMinute());
            return;
        }
    }

    private final void initController() {
        PickerModel r100 = this.pickerModel;
        if (r100 == null) goto L11;
        CalendarDate r101 = this.beginDate;
        CalendarDate r102 = this.endDate;
        if (r100 != PickerModel.YEAR_MONTH_DAY) goto L9;
        if (r101 == null) goto L9;
        if (r102 == null) goto L9;
        int r103 = f.f285415j;
        setPanelController(f.a.a(getContext(), this.pickerPanelListener, r101, r102));
        return;
    L9:
        setPanelController(TimePickerHelper.INSTANCE.getPanelController(getContext(), r100, this.pickerPanelListener, this.panelStyleData));
        return;
    }

    public Calendar getSelectedCalendar() {
        int[] r100 = com.larksuite.component.universe_design.util.a.f285486a;
        Calendar r101 = this.selectedCalendar;
        TimeZone r102 = this.selectedTimeZone;
        Intrinsics.checkNotNullParameter(r101, "calendar");
        Intrinsics.checkNotNullParameter(r102, TimeZoneItemV2.TIME_ZONE);
        return new CalendarDate(new CalendarDate(r101), r102).getCalendar();
    }

    public void hideItemDivider() {
        this.panelStyleData.setItemDividerVisibility(false);
        BaseTimePickerController r100 = this.baseController;
        if (r100 == null) goto L5;
        r100.setItemDividerVisibility(false);
    L5:
        invalidate();
    }

    public void showItemDivider() {
        this.panelStyleData.setItemDividerVisibility(true);
        BaseTimePickerController r100 = this.baseController;
        if (r100 == null) goto L5;
        r100.setItemDividerVisibility(true);
    L5:
        invalidate();
    }

    private final void createView() {
        if (getBackground() == null) goto L5;
        setBackgroundColor(UDColorUtils.getColor(getContext(), R.color.bg_body));
    L5:
        initController();
    }

    public final BaseTimePickerController getBaseController() {
        return this.baseController;
    }

    public UDTimePicker(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public static final /* synthetic */ PanelStyleData access$getPanelStyleData$p(UDTimePicker r100) {
        return r100.panelStyleData;
    }

    public static final /* synthetic */ Calendar access$getSelectedCalendar$p(UDTimePicker r100) {
        return r100.selectedCalendar;
    }

    public static final /* synthetic */ c18.a access$getTimePickerListener$p(UDTimePicker r100) {
        return r100.timePickerListener;
    }

    private final int getAdjustVisibleItem(int r100) {
        return TimePickerHelper.INSTANCE.getValidWheelItemNum((int) (r100 / d.b(getContext(), 48)));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r100) {
        ViewParent r101 = getParent();
        if (r101 == null) goto L6;
        r101.requestDisallowInterceptTouchEvent(true);
    L6:
        return super.dispatchTouchEvent(r100);
    }

    public void setAutoAdjustItemNum(boolean r100) {
        if (this.autoAdjustVisibleNum != r100) goto L5;
        return;
    L5:
        this.autoAdjustVisibleNum = r100;
        requestLayout();
    }

    public final void setBaseController(BaseTimePickerController r100) {
        this.baseController = r100;
    }

    public void setDatePickerListener(c18.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.timePickerListener = r100;
    }

    public void setItemVisibleNum(int r100) {
        this.panelStyleData.setVisibleItemNum(TimePickerHelper.INSTANCE.getValidWheelItemNum(r100));
        BaseTimePickerController r101 = this.baseController;
        if (r101 == null) goto L6;
        r101.setItemVisibleNum(r100);
        return;
    }

    public void setMinuteInterval(int r100) {
        this.panelStyleData.setMinuteInterval(r100);
        BaseTimePickerController r101 = this.baseController;
        if (r101 == null) goto L5;
        r101.setMinuteWheelInterval(r100);
    L5:
        invalidate();
    }

    public void setPanelController(BaseTimePickerController r100) {
        Intrinsics.checkNotNullParameter(r100, "panelController");
        removeAllViews();
        this.baseController = r100;
        if (r100 == null) goto L5;
        List<PickerBuilder> r101 = r100.getPickerBuilderList();
    L6:
        List<PickerBuilder> r102 = r101;
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == true) goto L17;
        BaseTimePickerController r104 = this.baseController;
        if (r104 == null) goto L17;
        r104.create(getContext(), r101);
    L17:
        BaseTimePickerController r105 = this.baseController;
        if (r105 == null) goto L28;
        List<WheelView> r106 = r105.getPickerViewList();
        if (r106 == null) goto L28;
        Iterator<T> r107 = r106.iterator();
    L23:
        if (r107.hasNext() == false) goto L28;
        WheelView r108 = (WheelView) r107.next();
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        if (r109 != null) goto L27;
        r109 = TimePickerHelper.INSTANCE.generalDefaultLayoutParam();
    L27:
        addView(r108, r109);
    L28:
        BaseTimePickerController r110 = this.baseController;
        if (r110 == null) goto L35;
        r110.setCurrentDate(this.selectedCalendar);
        return;
    L35:
        return;
    L9:
        if (r102.isEmpty() == true) goto L12;
        r103 = false;
        goto L13
    L5:
        r101 = null;
        goto L6
    }

    public void setPickerMode(PickerModel r100) {
        Intrinsics.checkNotNullParameter(r100, "pickerModel");
        this.pickerModel = r100;
        initController();
    }

    public void setSelectedCalendar(Calendar r100) {
        Intrinsics.checkNotNullParameter(r100, "calendarDate");
        this.selectedTimeZone = r100.getTimeZone();
        Calendar r101 = UtcDates.INSTANCE.getUTCCalendarOf(r100);
        this.selectedCalendar = r101;
        BaseTimePickerController r102 = this.baseController;
        if (r102 == null) goto L6;
        r102.setCurrentDate(r101);
        return;
    }

    public UDTimePicker(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public static final /* synthetic */ void access$setSelectedCalendar$p(UDTimePicker r100, Calendar r101) {
        r100.selectedCalendar = r101;
    }

    public final void setPickerDateRange$universe_ui_datepicker_release(CalendarDate r100, CalendarDate r101) {
        Intrinsics.checkNotNullParameter(r100, "beginDate");
        Intrinsics.checkNotNullParameter(r101, com.heytap.mcssdk.constant.b.f276370t);
        this.beginDate = r100;
        this.endDate = r101;
        initController();
    }

    public UDTimePicker(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 0);
    }

    private final void init(AttributeSet r100, int r101, int r102) {
        setOrientation(0);
        setGravity(16);
        TypedArray r103 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.ud_timePicker_autoAdjustVisibleNum, R.attr.ud_timePicker_datePickerMode, R.attr.ud_timePicker_itemDividerVisibility, R.attr.ud_timePicker_itemVisibleNum, R.attr.ud_timePicker_minuteInternal, R.attr.ud_timePicker_showDayInfo}, r101, r102);
        int r104 = r103.getInt(1, 3);
        PickerModel.Companion.getClass();
        if (r104 == 0) goto L15;
        if (r104 == 1) goto L14;
        if (r104 == 2) goto L13;
        if (r104 == 3) goto L12;
        if (r104 == 4) goto L11;
        if (r104 == 5) goto L10;
        PickerModel r105 = null;
    L16:
        this.pickerModel = r105;
        this.panelStyleData.setMinuteInterval(r103.getInt(4, 1));
        this.panelStyleData.setItemDividerVisibility(r103.getBoolean(2, true));
        this.panelStyleData.setShowDayInfo(r103.getBoolean(5, true));
        boolean r106 = r103.getBoolean(0, false);
        this.autoAdjustVisibleNum = r106;
        if (r106 == true) goto L19;
        this.panelStyleData.setVisibleItemNum(TimePickerHelper.INSTANCE.getValidWheelItemNum(r103.getInt(3, 3)));
    L19:
        r103.recycle();
        return;
    L10:
        r105 = PickerModel.MONTH_DAY;
        goto L16
    L11:
        r105 = PickerModel.YEAR_MONTH_DAY;
        goto L16
    L12:
        r105 = PickerModel.HOUR_MINUTE_24H;
        goto L16
    L13:
        r105 = PickerModel.HOUR_MINUTE_12H;
        goto L16
    L14:
        r105 = PickerModel.MONTHDAY_HOUR_MINUTE_24H;
        goto L16
    L15:
        r105 = PickerModel.MONTHDAY_HOUR_MINUTE_12H;
        goto L16
    }

    public UDTimePicker(Context r100, AttributeSet r101, int r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r110, r111);
        this.selectedCalendar = UtcDates.INSTANCE.getTodayCalendar();
        this.selectedTimeZone = TimeZone.getDefault();
        this.panelStyleData = new PanelStyleData(0, 0, false, false, 15, null);
        this.pickerPanelListener = new b(this);
        init(r101, r110, r111);
        createView();
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (this.autoAdjustVisibleNum == true) goto L5;
        return;
    L5:
        if (getLayoutParams().height != (-2)) goto L7;
        int r104 = 3;
    L8:
        post(new a(this, r104));
        return;
    L7:
        r104 = getAdjustVisibleItem(r101);
        goto L8
    }
}
