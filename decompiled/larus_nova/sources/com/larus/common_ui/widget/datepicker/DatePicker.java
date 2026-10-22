package com.larus.common_ui.widget.datepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0016\u0018\u0000 U2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002TUB\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020&H\u0002J\u000e\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020*J\u0010\u0010+\u001a\u00020\u00002\b\u0010,\u001a\u0004\u0018\u00010-J\"\u0010.\u001a\u00020&2\b\u0010/\u001a\u0004\u0018\u00010\u000b2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000201H\u0016J\u0010\u00103\u001a\u00020\u00002\b\u00104\u001a\u0004\u0018\u00010 J\u0010\u00105\u001a\u00020&2\u0006\u00106\u001a\u000201H\u0002J\u0006\u00107\u001a\u000208J\u000e\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020BJ\u000e\u0010C\u001a\u00020\u00002\u0006\u0010D\u001a\u000201J\u000e\u0010E\u001a\u00020\u00002\u0006\u0010D\u001a\u000201J\u0010\u0010F\u001a\u00020&2\b\u0010G\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010H\u001a\u00020&2\b\u0010I\u001a\u0004\u0018\u00010\u001cJ$\u0010J\u001a\u00020&2\b\b\u0002\u0010K\u001a\u00020*2\b\b\u0002\u0010L\u001a\u00020*2\b\b\u0002\u0010M\u001a\u00020*J\u000e\u0010N\u001a\u00020&2\u0006\u0010O\u001a\u00020PJ\u001a\u0010Q\u001a\u00020&2\b\b\u0001\u0010R\u001a\u00020-2\b\u0010G\u001a\u0004\u0018\u00010\u001cJ\b\u0010S\u001a\u00020&H\u0002R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u00109\u001a\u0002018F¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0011\u0010<\u001a\u0002018F¢\u0006\u0006\u001a\u0004\b=\u0010;R\u0011\u0010>\u001a\u0002018F¢\u0006\u0006\u001a\u0004\b?\u0010;¨\u0006V"}, d2 = {"Lcom/larus/common_ui/widget/datepicker/DatePicker;", "Landroid/widget/LinearLayout;", "Lcom/larus/common_ui/widget/datepicker/NumberPicker$OnValueChangeListener;", "Lcom/larus/common_ui/widget/datepicker/IPickerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "yearPicker", "Lcom/larus/common_ui/widget/datepicker/NumberPicker;", "getYearPicker", "()Lcom/larus/common_ui/widget/datepicker/NumberPicker;", "setYearPicker", "(Lcom/larus/common_ui/widget/datepicker/NumberPicker;)V", "monthPicker", "getMonthPicker", "setMonthPicker", "dayOfMonthPicker", "getDayOfMonthPicker", "setDayOfMonthPicker", KtvSubElement.CONTAINER, "getContainer", "()Landroid/widget/LinearLayout;", "setContainer", "(Landroid/widget/LinearLayout;)V", "dpCalendar", "Ljava/util/Calendar;", "dpUpperBoundDate", "dpLowerBoundDate", "dpOnDateChangedListener", "Lcom/larus/common_ui/widget/datepicker/DatePicker$OnDateChangedListener;", "layoutInflater", "Landroid/view/LayoutInflater;", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "inflateViewAndInitialize", "", "init", "setNonRecurrentForYear", "isNonRecurrent", "", "setDate", "date", "Ljava/util/Date;", "onValueChange", "picker", "oldVal", "", "newVal", "setOnDateChangedListener", "l", "notifyDateChanged", "which", "getTimestamp", "", BdpGameHostBaseUIService.DATE_PICKER_TYPE_YEAR, "getYear", "()I", BdpGameHostBaseUIService.DATE_PICKER_TYPE_MONTH, "getMonth", "dayOfMonth", "getDayOfMonth", "setTextSize", "textSize", "", "setTextColor", "color", "setBackground", "setUpperBoundDate", "upperBoundDate", "setLowerBoundDate", "lowerBoundDate", "setPickerVisible", "yearVisible", "monthVisible", "dayVisible", "setPickerOrder", "pattern", "", "initDate", "defaultTime", "updateContentDescription", "OnDateChangedListener", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DatePicker extends LinearLayout implements NumberPicker.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f328586j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NumberPicker f328587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public NumberPicker f328588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public NumberPicker f328589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinearLayout f328590d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Calendar f328591e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Calendar f328592f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Calendar f328593g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f328594h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LayoutInflater f328595i;

    public static final class a {
    }

    public interface b {
        void a();
    }

    static {
    }

    public final int getDayOfMonth() {
        return this.f328591e.get(5);
    }

    public final int getMonth() {
        return this.f328591e.get(2) + 1;
    }

    public final long getTimestamp() {
        return new Date(this.f328591e.getTime().getYear(), this.f328591e.getTime().getMonth(), this.f328591e.getTime().getDate(), 0, 0).getTime();
    }

    public final int getYear() {
        return this.f328591e.get(1);
    }

    public final LinearLayout getContainer() {
        return this.f328590d;
    }

    public final NumberPicker getDayOfMonthPicker() {
        return this.f328589c;
    }

    public final LayoutInflater getLayoutInflater() {
        return this.f328595i;
    }

    public final NumberPicker getMonthPicker() {
        return this.f328588b;
    }

    public final NumberPicker getYearPicker() {
        return this.f328587a;
    }

    public DatePicker(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void c(Date r100) {
        this.f328591e.setTime(r100);
        NumberPicker r101 = this.f328589c;
        if (r101 == null) goto L5;
        r101.d(this.f328591e.getActualMaximum(5));
    L5:
        NumberPicker r102 = this.f328587a;
        if (r102 == null) goto L8;
        r102.f328615q = this.f328591e.get(1);
        r102.f();
        r102.c();
        r102.invalidate();
    L8:
        NumberPicker r103 = this.f328588b;
        if (r103 == null) goto L11;
        r103.f328615q = this.f328591e.get(2) + 1;
        r103.f();
        r103.c();
        r103.invalidate();
    L11:
        NumberPicker r104 = this.f328589c;
        if (r104 == null) goto L15;
        r104.f328615q = this.f328591e.get(5);
        r104.f();
        r104.c();
        r104.invalidate();
        return;
    }

    public final void setContainer(LinearLayout r100) {
        this.f328590d = r100;
    }

    public final void setDayOfMonthPicker(NumberPicker r100) {
        this.f328589c = r100;
    }

    public final void setLowerBoundDate(Calendar r100) {
        if (r100 == null) goto L17;
        this.f328593g = r100;
        NumberPicker r101 = this.f328587a;
        if (r101 == null) goto L7;
        r101.e(r100.get(1));
    L7:
        if (this.f328591e.get(1) != r100.get(1)) goto L18;
        NumberPicker r102 = this.f328588b;
        if (r102 == null) goto L12;
        r102.e(r100.get(2) + 1);
    L12:
        if (this.f328591e.get(2) != r100.get(2)) goto L19;
        NumberPicker r103 = this.f328589c;
        if (r103 == null) goto L20;
        r103.e(r100.get(5));
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    }

    public final void setMonthPicker(NumberPicker r100) {
        this.f328588b = r100;
    }

    public final void setNonRecurrentForYear(boolean r100) {
        NumberPicker r101 = this.f328587a;
        if (r101 == null) goto L6;
        r101.setNonRecurrent(r100);
        return;
    }

    public final void setPickerOrder(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pattern");
        if (r100.length() == 3) goto L5;
        return;
    L5:
        LinearLayout r101 = this.f328590d;
        if (r101 == null) goto L8;
        r101.removeView(this.f328587a);
        r101.removeView(this.f328588b);
        r101.removeView(this.f328589c);
    L8:
        int r102 = 0;
    L10:
        if (r102 >= r100.length()) goto L34;
        char r103 = r100.charAt(r102);
        if (r103 != 'D') goto L14;
    L30:
        LinearLayout r104 = this.f328590d;
        if (r104 == null) goto L33;
        r104.addView(this.f328589c);
    L33:
        r102 = r102 + 1;
        goto L10
    L14:
        if (r103 != 'M') goto L16;
    L27:
        LinearLayout r105 = this.f328590d;
        if (r105 == null) goto L33;
        r105.addView(this.f328588b);
        goto L33
    L16:
        if (r103 != 'Y') goto L18;
    L24:
        LinearLayout r106 = this.f328590d;
        if (r106 == null) goto L33;
        r106.addView(this.f328587a);
        goto L33
    L18:
        if (r103 == 'd') goto L30;
        if (r103 == 'm') goto L27;
        if (r103 == 'y') goto L24;
    L34:
        requestLayout();
    }

    public final void setUpperBoundDate(Calendar r100) {
        if (r100 != null) goto L4;
        Calendar r101 = Calendar.getInstance();
    L5:
        this.f328592f = r101;
        if (r100 == null) goto L21;
        NumberPicker r102 = this.f328587a;
        if (r102 == null) goto L11;
        r102.d(r101.get(1));
    L11:
        if (this.f328591e.get(1) != this.f328592f.get(1)) goto L22;
        NumberPicker r103 = this.f328588b;
        if (r103 == null) goto L16;
        r103.d(this.f328592f.get(2) + 1);
    L16:
        if (this.f328591e.get(2) != this.f328592f.get(2)) goto L23;
        NumberPicker r104 = this.f328589c;
        if (r104 == null) goto L24;
        r104.d(this.f328592f.get(5));
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L4:
        r101 = r100;
        goto L5
    }

    public final void setYearPicker(NumberPicker r100) {
        this.f328587a = r100;
    }

    public DatePicker(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f328591e = Calendar.getInstance();
        this.f328592f = Calendar.getInstance();
        Object r102 = r100.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.view.LayoutInflater");
        LayoutInflater r103 = (LayoutInflater) r102;
        this.f328595i = r103;
        r103.inflate(R.layout.larus_age_gate_date_picker, this, true);
        this.f328590d = (LinearLayout) findViewById(R.id.parent_container);
        this.f328587a = (NumberPicker) findViewById(R.id.year_picker);
        this.f328588b = (NumberPicker) findViewById(R.id.month_picker);
        NumberPicker r104 = (NumberPicker) findViewById(R.id.day_picker);
        this.f328589c = r104;
        NumberPicker r105 = this.f328587a;
        if (r105 == null) goto L5;
        r105.O = this;
    L5:
        NumberPicker r106 = this.f328588b;
        if (r106 == null) goto L8;
        r106.O = this;
    L8:
        if (r104 == null) goto L10;
        r104.O = this;
    L10:
        if (r105 == null) goto L15;
        Integer r107 = 1;
        if (r107 == null) goto L15;
        r105.G = ViewConfiguration.get(r105.getContext()).getScaledMaximumFlingVelocity() / r107.intValue();
        r105.V = true;
    L15:
        String[] r108 = getResources().getStringArray(R.array.larus_month_name);
        NumberPicker r109 = this.f328588b;
        if (r109 == null) goto L18;
        r109.S = r108;
        r109.f();
        r109.invalidate();
    L18:
        Calendar r110 = Calendar.getInstance();
        this.f328591e = r110;
        c(r110.getTime());
        NumberPicker r111 = this.f328587a;
        if (r111 == null) goto L21;
        r111.d(this.f328591e.get(1));
    L21:
        NumberPicker r112 = this.f328587a;
        if (r112 == null) goto L24;
        r112.setContentDescription(BdpGameHostBaseUIService.DATE_PICKER_TYPE_YEAR);
    L24:
        NumberPicker r113 = this.f328588b;
        if (r113 == null) goto L27;
        r113.setContentDescription(BdpGameHostBaseUIService.DATE_PICKER_TYPE_MONTH);
    L27:
        NumberPicker r114 = this.f328589c;
        if (r114 == null) goto L31;
        r114.setContentDescription(BdpGameHostBaseUIService.DATE_PICKER_TYPE_DAY);
        return;
    }

    @Override // com.larus.common_ui.widget.datepicker.NumberPicker.c
    public final void a(NumberPicker r110, int r111) {
        boolean r100 = false;
        if (Intrinsics.areEqual(r110, this.f328587a) == false) goto L76;
        Calendar r112 = this.f328593g;
        if (r112 != null) goto L7;
    L50:
        int r113 = this.f328591e.get(5);
        int r101 = this.f328591e.get(2);
        Calendar r102 = this.f328592f;
        if (r102 != null) goto L53;
    L60:
        NumberPicker r103 = this.f328588b;
        if (r103 == null) goto L63;
        r103.d(this.f328591e.getActualMaximum(2) + 1);
    L63:
        this.f328591e.set(r111, r101, 1);
        int r104 = this.f328591e.getActualMaximum(5);
        Calendar r105 = this.f328592f;
        if (r105 != null) goto L66;
    L70:
        if (r113 <= r104) goto L72;
        r113 = r104;
    L72:
        this.f328591e.set(5, r113);
        NumberPicker r114 = this.f328589c;
        if (r114 == null) goto L120;
        r114.d(r104);
    L120:
        b r115 = this.f328594h;
        if (r115 == null) goto L124;
        getYear();
        getMonth();
        getDayOfMonth();
        r115.a();
        return;
    L124:
        return;
    L66:
        if (r111 != r105.get(1)) goto L70;
        if (r101 != this.f328592f.get(2)) goto L70;
        r104 = this.f328592f.get(5);
        goto L70
    L53:
        if (r111 != r102.get(1)) goto L60;
        if (r101 <= this.f328592f.get(2)) goto L57;
        r101 = this.f328592f.get(2);
    L57:
        NumberPicker r106 = this.f328588b;
        if (r106 == null) goto L63;
        r106.d(this.f328592f.get(2) + 1);
        goto L63
    L7:
        if (r111 != r112.get(1)) goto L9;
        boolean r107 = true;
    L10:
        NumberPicker r108 = this.f328588b;
        if (r108 == null) goto L18;
        if (r107 == true) goto L14;
    L16:
        boolean r109 = false;
    L17:
        r108.setNonRecurrent(r109);
        goto L18
    L14:
        if (r112.get(2) == 0) goto L16;
        r109 = true;
    L18:
        NumberPicker r116 = this.f328588b;
        if (r116 == null) goto L24;
        if (r107 == false) goto L22;
        int r117 = r112.get(2) + 1;
    L23:
        r116.e(r117);
        goto L24
    L22:
        r117 = 1;
    L24:
        if (r107 == true) goto L26;
    L28:
        if (r107 == true) goto L30;
    L32:
        boolean r118 = false;
    L33:
        NumberPicker r119 = this.f328589c;
        if (r119 == null) goto L40;
        if (r118 == true) goto L37;
    L39:
        r119.setNonRecurrent(r100);
        goto L40
    L37:
        if (r112.get(5) <= 20) goto L39;
        r100 = true;
    L40:
        NumberPicker r120 = this.f328589c;
        if (r120 == null) goto L46;
        if (r118 == false) goto L44;
        int r121 = r112.get(5);
    L45:
        r120.e(r121);
        goto L46
    L44:
        r121 = 1;
    L46:
        if (r118 == false) goto L50;
        if (this.f328591e.get(5) >= r112.get(5)) goto L50;
        this.f328591e.set(5, r112.get(5));
        goto L50
    L30:
        if (this.f328591e.get(2) != r112.get(2)) goto L32;
        r118 = true;
        goto L33
    L26:
        if (this.f328591e.get(2) >= r112.get(2)) goto L28;
        int r122 = this.f328591e.get(5);
        this.f328591e.set(5, 1);
        this.f328591e.set(2, r112.get(2));
        this.f328591e.set(5, Math.min(r122, this.f328591e.getActualMaximum(5)));
        goto L28
    L9:
        r107 = false;
        goto L10
    L76:
        if (Intrinsics.areEqual(r110, this.f328588b) == false) goto L118;
        Calendar r123 = this.f328593g;
        if (r123 != null) goto L80;
    L105:
        int r124 = this.f328591e.get(5);
        Calendar r125 = this.f328591e;
        int r126 = r111 - 1;
        r125.set(r125.get(1), r126, 1);
        int r127 = this.f328591e.getActualMaximum(5);
        if (this.f328592f != null) goto L108;
    L112:
        if (r124 <= r127) goto L114;
        r124 = r127;
    L114:
        this.f328591e.set(5, r124);
        NumberPicker r128 = this.f328589c;
        if (r128 == null) goto L120;
        r128.d(r127);
        goto L120
    L108:
        if (this.f328591e.get(1) != this.f328592f.get(1)) goto L112;
        if (r126 != this.f328592f.get(2)) goto L112;
        r127 = this.f328592f.get(5);
        goto L112
    L80:
        if (this.f328591e.get(1) != r123.get(1)) goto L82;
        boolean r129 = true;
    L83:
        if (r129 == true) goto L85;
    L87:
        boolean r130 = false;
    L88:
        NumberPicker r131 = this.f328589c;
        if (r131 == null) goto L95;
        if (r130 == true) goto L92;
    L94:
        r131.setNonRecurrent(r100);
        goto L95
    L92:
        if (r123.get(5) <= 20) goto L94;
        r100 = true;
    L95:
        NumberPicker r132 = this.f328589c;
        if (r132 == null) goto L101;
        if (r130 == false) goto L99;
        int r133 = r123.get(5);
    L100:
        r132.e(r133);
        goto L101
    L99:
        r133 = 1;
    L101:
        if (r130 == false) goto L105;
        if (this.f328591e.get(5) >= r123.get(5)) goto L105;
        this.f328591e.set(5, r123.get(5));
        goto L105
    L85:
        if ((r111 - 1) != r123.get(2)) goto L87;
        r130 = true;
        goto L88
    L82:
        r129 = false;
        goto L83
    L118:
        if (Intrinsics.areEqual(r110, this.f328589c) == false) goto L120;
        this.f328591e.set(5, r111);
        goto L120
    }

    public final void b(Date r100, Calendar r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultTime");
        setNonRecurrentForYear(true);
        c(r100);
        setUpperBoundDate(r101);
    }
}
