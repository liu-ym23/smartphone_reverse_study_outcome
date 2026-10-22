package com.obric.oui.calendar;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u001a\u001bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006J\u0010\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006J\u0014\u0010\u0014\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012J\u0014\u0010\u0017\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012J\u001b\u0010\u0017\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0018¢\u0006\u0004\b\u0017\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/obric/oui/calendar/OWeekPickerView;", "Landroid/widget/LinearLayout;", "Lcom/obric/oui/calendar/PickerSelectionMode;", "mode", "", "setSelectionMode", "", "resourceId", "setDayTextAppearance", "itemDiameterDp", "setItemSizeDp", "itemPaddingDp", "setItemHorizontalPaddingDp", "Lcom/obric/oui/calendar/OWeekPickerView$b;", "listener", "setOnDaysChangedListener", SoloKtvContext.SOLO_PAGE_FIRST, "setFirstDayOfWeek", "", "days", "setSelectedDays", "", "newLabels", "setLabels", "", "([Ljava/lang/String;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OWeekPickerView extends LinearLayout {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f399271n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PickerSelectionMode f399272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f399273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f399274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f399275d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f399276e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f399277f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f399278g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f399279h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f399280i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f399281j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String[] f399282k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<a> f399283l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<Boolean> f399284m;

    public static final class a extends AppCompatCheckedTextView {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f399285a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f399286b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f399287c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f399288d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f399289e;

        public final void b() {
            StateListDrawable r100 = new StateListDrawable();
            r100.addState(new int[]{R.attr.state_checked}, a(this.f399287c));
            r100.addState(new int[]{R.attr.state_pressed}, a(this.f399287c));
            r100.addState(new int[0], a(this.f399288d));
            setBackground(r100);
        }

        public final ShapeDrawable a(int r100) {
            ShapeDrawable r101 = new ShapeDrawable(new OvalShape());
            r101.getPaint().setColor(r100);
            return r101;
        }

        @Override // android.widget.CheckedTextView, android.widget.Checkable
        public final void setChecked(boolean r100) {
            if (isChecked() == r100) goto L5;
            boolean r101 = true;
        L6:
            super.setChecked(r100);
            if (r101 == true) goto L9;
            return;
        L9:
            if (isChecked() == false) goto L11;
            int r102 = this.f399285a;
        L12:
            vma.f.a(this, r102);
            return;
        L11:
            r102 = this.f399286b;
            goto L12
        L5:
            r101 = false;
            goto L6
        }

        @Override // android.widget.TextView, android.view.View
        public final void onMeasure(int r100, int r101) {
            super.onMeasure(r100, r101);
            int r102 = this.f399289e;
            setMeasuredDimension(CheckedTextView.resolveSize(r102, r100), CheckedTextView.resolveSize(r102, r101));
        }

        public a(Context r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100);
            this.f399285a = r101;
            this.f399286b = r102;
        }
    }

    public interface b {
        void onChanged(List<Integer> r100);
    }

    public OWeekPickerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14);
    }

    public OWeekPickerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public OWeekPickerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    public final void b() {
        ArrayList r100 = new ArrayList();
        Iterator<T> r101 = this.f399283l.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L12;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((a) r103).isChecked() == false) goto L11;
        r100.add(Integer.valueOf(r102));
    L11:
        r102 = r104;
        goto L4
    L12:
        b r105 = this.f399280i;
        if (r105 == null) goto L20;
        r105.onChanged(r100);
        return;
    }

    public final void a() {
        removeAllViews();
        ((ArrayList) this.f399283l).clear();
        int r100 = this.f399282k.length;
        final int r101 = 0;
    L3:
        if (r101 >= r100) goto L23;
        int r102 = r101 + 1;
        final a r103 = new a(getContext(), this.f399275d, this.f399276e);
        r103.setText(this.f399282k[r101]);
        r103.setGravity(17);
        if (this.f399277f == 0) goto L8;
        r103.setTextAppearance(getContext(), this.f399277f);
    L8:
        if (r103.isChecked() == false) goto L10;
        int r104 = r103.f399285a;
    L11:
        vma.f.a(r103, r104);
        r103.setSingleLine(true);
        r103.setTextAlignment(4);
        r103.setClickable(true);
        r103.setFocusable(true);
        if (((Boolean) ListProtector.get(this.f399284m, r101)).booleanValue() == false) goto L14;
        float r105 = 1.0f;
    L15:
        r103.setAlpha(r105);
        r103.f399289e = this.f399278g;
        r103.requestLayout();
        r103.b();
        int r106 = this.f399273b;
        int r107 = this.f399274c;
        r103.f399287c = r106;
        r103.f399288d = r107;
        r103.b();
        r103.setChecked(false);
        r103.setOnClickListener(new u(this, r101, r103));
        LinearLayout.LayoutParams r108 = new LinearLayout.LayoutParams(-2, -2);
        int r109 = this.f399279h / 2;
        if (r101 != 0) goto L18;
        int r110 = 0;
    L20:
        if (r101 != ArraysKt.getLastIndex(this.f399282k)) goto L22;
        r109 = 0;
    L22:
        r108.setMargins(r110, 0, r109, 0);
        r108.gravity = 17;
        addView(r103, r108);
        ((ArrayList) this.f399283l).add(r103);
        r101 = r102;
        goto L3
    L18:
        r110 = r109;
        goto L20
    L14:
        r105 = 0.45f;
        goto L15
    L10:
        r104 = r103.f399286b;
        goto L11
    }

    public final void d(int r100) {
        int r101 = r100 / 2;
        int r102 = getChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L21;
        int r104 = r103 + 1;
        View r105 = getChildAt(r103);
        if (r105 == null) goto L18;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if (r106 == null) goto L20;
        LinearLayout.LayoutParams r107 = (LinearLayout.LayoutParams) r106;
        if (r103 != 0) goto L12;
        int r108 = 0;
    L14:
        if (r103 != (getChildCount() - 1)) goto L16;
        int r109 = 0;
    L17:
        r107.setMargins(r108, 0, r109, 0);
        r105.setLayoutParams(r107);
        goto L18
    L16:
        r109 = r101;
        goto L17
    L12:
        r108 = r101;
        goto L14
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L18:
        r103 = r104;
        goto L3
    }

    public final void e(String[] r100) {
        List<a> r101 = this.f399283l;
        ArrayList r102 = new ArrayList();
        Iterator r103 = ((ArrayList) r101).iterator();
        int r104 = 0;
    L4:
        if (r103.hasNext() == false) goto L16;
        Object r105 = r103.next();
        int r106 = r104 + 1;
        if (r104 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((a) r105).isChecked() == false) goto L11;
        Integer r107 = Integer.valueOf(r104);
    L12:
        if (r107 == null) goto L14;
        r102.add(r107);
    L14:
        r104 = r106;
        goto L4
    L11:
        r107 = null;
        goto L12
    L16:
        if (r100.length == getChildCount()) goto L18;
        boolean r108 = true;
    L19:
        String[] r109 = (String[]) Arrays.copyOf(r100, r100.length);
        this.f399282k = r109;
        if (r108 == false) goto L29;
        int r110 = r109.length;
        List r111 = CollectionsKt.toList(this.f399284m);
        ((ArrayList) this.f399284m).clear();
        int r112 = 0;
    L22:
        if (r112 >= r110) goto L28;
        List<Boolean> r113 = this.f399284m;
        Boolean r114 = (Boolean) CollectionsKt.getOrNull(r111, r112);
        if (r114 != null) goto L26;
        boolean r115 = true;
    L27:
        ArrayList r116 = (ArrayList) r113;
        r116.add(Boolean.valueOf(r115));
        r112 = r112 + 1;
        goto L22
    L26:
        r115 = r114.booleanValue();
        goto L27
    L28:
        a();
    L36:
        ArrayList r117 = new ArrayList();
        Iterator r118 = r102.iterator();
    L38:
        if (r118.hasNext() == false) goto L47;
        Object r119 = r118.next();
        int r120 = ((Number) r119).intValue();
        if (r120 >= 0) goto L42;
    L44:
        boolean r121 = false;
    L45:
        if (r121 == false) goto L38;
        r117.add(r119);
        goto L38
    L42:
        if (r120 >= this.f399282k.length) goto L44;
        r121 = true;
        goto L45
    L47:
        setSelectedDays(r117);
        requestLayout();
        return;
    L29:
        Iterator r122 = ((ArrayList) this.f399283l).iterator();
        int r123 = 0;
    L31:
        if (r122.hasNext() == false) goto L36;
        Object r124 = r122.next();
        int r125 = r123 + 1;
        if (r123 >= 0) goto L35;
        CollectionsKt.throwIndexOverflow();
    L35:
        ((a) r124).setText(this.f399282k[r123]);
        r123 = r125;
        goto L31
    L18:
        r108 = false;
        goto L19
    }

    public final void setDayTextAppearance(int r100) {
        if (r100 != 0) goto L4;
        return;
    L4:
        this.f399277f = r100;
        Iterator r101 = ((ArrayList) this.f399283l).iterator();
    L6:
        if (r101.hasNext() == false) goto L15;
        a r102 = (a) r101.next();
        if (this.f399277f == 0) goto L11;
        r102.setTextAppearance(getContext(), this.f399277f);
    L11:
        if (r102.isChecked() == false) goto L13;
        int r103 = r102.f399285a;
    L14:
        vma.f.a(r102, r103);
        goto L6
    L13:
        r103 = r102.f399286b;
        goto L14
    }

    public final void setFirstDayOfWeek(int r100) {
        this.f399281j = r100;
        e(c(getContext(), this.f399281j));
    }

    public final void setItemHorizontalPaddingDp(int r100) {
        int r101 = pla.d.n(this, r100);
        this.f399279h = r101;
        d(r101);
    }

    public final void setItemSizeDp(int r100) {
        this.f399278g = pla.d.n(this, r100);
        Iterator r101 = ((ArrayList) this.f399283l).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        a r102 = (a) r101.next();
        r102.f399289e = this.f399278g;
        r102.requestLayout();
        r102.b();
        goto L4
    L6:
        requestLayout();
    }

    public final void setLabels(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "newLabels");
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        Object[] r101 = r100.toArray(new String[0]);
        if (r101 == null) goto L10;
        e((String[]) r101);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public final void setOnDaysChangedListener(b r100) {
        this.f399280i = r100;
    }

    public final void setSelectedDays(List<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "days");
        int r101 = 0;
        if (this.f399272a != PickerSelectionMode.SINGLE) goto L18;
        Integer r102 = (Integer) CollectionsKt.firstOrNull(r100);
        Iterator<T> r103 = this.f399283l.iterator();
        int r104 = 0;
    L6:
        if (r103.hasNext() == false) goto L25;
        Object r105 = r103.next();
        int r106 = r104 + 1;
        if (r104 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        a r107 = (a) r105;
        if (r102 != null) goto L14;
    L16:
        boolean r108 = false;
    L17:
        r107.setChecked(r108);
        r104 = r106;
        goto L6
    L14:
        if (r104 != r102.intValue()) goto L16;
        r108 = true;
    L25:
        b();
        return;
    L18:
        Iterator<T> r109 = this.f399283l.iterator();
    L20:
        if (r109.hasNext() == false) goto L25;
        Object r110 = r109.next();
        int r111 = r101 + 1;
        if (r101 >= 0) goto L24;
        CollectionsKt.throwIndexOverflow();
    L24:
        ((a) r110).setChecked(r100.contains(Integer.valueOf(r101)));
        r101 = r111;
        goto L20
    }

    public final void setSelectionMode(PickerSelectionMode r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        this.f399272a = r100;
        if (r100 != PickerSelectionMode.SINGLE) goto L31;
        Iterator r101 = ((ArrayList) this.f399283l).iterator();
        int r102 = 0;
    L6:
        if (r101.hasNext() == false) goto L11;
        if (((a) r101.next()).isChecked() == true) goto L12;
        r102 = r102 + 1;
    L12:
        Iterator<T> r103 = this.f399283l.iterator();
        int r104 = 0;
    L14:
        if (r103.hasNext() == false) goto L24;
        Object r105 = r103.next();
        int r106 = r104 + 1;
        if (r104 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        a r107 = (a) r105;
        if (r104 != r102) goto L22;
        if (r102 < 0) goto L22;
        boolean r108 = true;
    L23:
        r107.setChecked(r108);
        r104 = r106;
    L22:
        r108 = false;
        goto L23
    L24:
        b();
        return;
    L11:
        r102 = -1;
        goto L12
    }

    public final void setLabels(String[] r100) {
        Intrinsics.checkNotNullParameter(r100, "newLabels");
        setLabels(ArraysKt.toList(r100));
    }

    public static String[] c(Context r100, int r101) {
        String[] r102 = new String[7];
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r104 >= 7) goto L6;
        r102[r104] = "";
        r104 = r104 + 1;
    L6:
        if (r103 >= 7) goto L28;
        int r105 = r103 + 1;
        switch(r101) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            default: goto L9;
        };
    L9:
        String r106 = "";
    L18:
        if (vma.h.b(r100.getResources().getConfiguration().fontScale) == false) goto L27;
        Character r107 = StringsKt.firstOrNull(r106);
        if (r107 == null) goto L27;
        String r108 = Character.valueOf(Character.toUpperCase(r107.charValue())).toString();
        if (r108 == null) goto L27;
        r106 = r108;
    L27:
        r102[r103] = r106;
        r101 = (r101 % 7) + 1;
        r103 = r105;
        goto L6
    L10:
        r106 = r100.getString(com.larus.nova.R.string.oui_calendar_day_of_week_sat);
        goto L18
    L11:
        r106 = r100.getString(com.larus.nova.R.string.oui_calendar_day_of_week_fri);
        goto L18
    L12:
        r106 = r100.getString(com.larus.nova.R.string.oui_calendar_day_of_week_thu);
        goto L18
    L13:
        r106 = r100.getString(com.larus.nova.R.string.oui_calendar_day_of_week_wed);
        goto L18
    L14:
        r106 = r100.getString(com.larus.nova.R.string.oui_calendar_day_of_week_tue);
        goto L18
    L15:
        r106 = r100.getString(com.larus.nova.R.string.oui_calendar_day_of_week_mon);
        goto L18
    L16:
        r106 = r100.getString(com.larus.nova.R.string.oui_calendar_day_of_week_sun);
        goto L18
    L28:
        return r102;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r110) {
        int r101 = View.MeasureSpec.getSize(r100);
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = this.f399279h;
        if (r102 == 0) goto L12;
        if (r101 <= 0) goto L12;
        int r104 = (r101 - getPaddingLeft()) - getPaddingRight();
        int r105 = getChildCount();
        int r106 = RangesKt.coerceAtLeast(r105 - 1, 0);
        int r107 = this.f399278g;
        if (((r105 * r107) + (this.f399279h * r106)) <= r104) goto L12;
        int r108 = r104 - (r105 * r107);
        if (r108 <= 0) goto L11;
        if (r106 <= 0) goto L11;
        r103 = r108 / r106;
    L11:
        r103 = 0;
    L12:
        d(r103);
        super.onMeasure(r100, r110);
    }

    public OWeekPickerView(Context r100, AttributeSet r101, int r102, int r110) {
        if ((r110 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r110 & 4) == 0) goto L9;
        r102 = com.larus.nova.R.attr.oweekPickerViewStyle;
    L9:
        if ((r110 & 8) == 0) goto L11;
        int r111 = com.larus.nova.R.style.OStyleV2_OWeekPickerView_DayNight;
    L12:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        PickerSelectionMode r103 = PickerSelectionMode.MULTIPLE;
        this.f399272a = r103;
        this.f399275d = getResources().getInteger(com.larus.nova.R.integer.oui_font_weight_bold);
        this.f399276e = getResources().getInteger(com.larus.nova.R.integer.oui_font_weight_regular);
        this.f399281j = 2;
        this.f399282k = c(r100, 2);
        this.f399283l = new ArrayList();
        ArrayList r104 = new ArrayList();
        this.f399284m = r104;
        TypedArray r105 = r100.obtainStyledAttributes(r101, new int[]{com.larus.nova.R.attr.o_pv_dayTextAppearance, com.larus.nova.R.attr.o_pv_itemHPadding, com.larus.nova.R.attr.o_pv_itemSize, com.larus.nova.R.attr.o_pv_selectedBackgroundColor, com.larus.nova.R.attr.o_pv_selectionMode, com.larus.nova.R.attr.o_pv_unSelectedBackgroundColor, com.larus.nova.R.attr.o_wpv_firstDayOfWeek}, r102, r111);
    L42:
        th = move-exception;
        r105.recycle();
        throw th;
    L14:
        if (r105.hasValue(3) == false) goto L17;
        this.f399273b = r105.getColor(3, this.f399273b);     // Catch: Throwable -> L42
    L17:
        if (r105.hasValue(5) == false) goto L20;
        this.f399274c = r105.getColor(5, this.f399274c);     // Catch: Throwable -> L42
    L20:
        if (r105.hasValue(0) == false) goto L23;
        this.f399277f = r105.getResourceId(0, this.f399277f);     // Catch: Throwable -> L42
    L23:
        if (r105.hasValue(4) == false) goto L29;
        int r106 = r105.getInt(4, this.f399272a.ordinal());     // Catch: Throwable -> L42
        PickerSelectionMode r112 = PickerSelectionMode.SINGLE;     // Catch: Throwable -> L42
        if (r106 != r112.ordinal()) goto L27;
        r103 = r112;
    L27:
        this.f399272a = r103;     // Catch: Throwable -> L42
    L29:
        if (r105.hasValue(2) == false) goto L32;
        this.f399278g = r105.getDimensionPixelSize(2, this.f399278g);     // Catch: Throwable -> L42
    L32:
        if (r105.hasValue(1) == false) goto L35;
        this.f399279h = r105.getDimensionPixelSize(1, this.f399279h);     // Catch: Throwable -> L42
    L35:
        if (r105.hasValue(6) == false) goto L37;
        this.f399281j = r105.getInt(6, this.f399281j);     // Catch: Throwable -> L42
    L37:
        r105.recycle();
        this.f399282k = c(r100, this.f399281j);
        r104.clear();
        int r107 = 0;
    L38:
        if (r107 >= 7) goto L40;
        List<Boolean> r108 = this.f399284m;
        ArrayList r109 = (ArrayList) r108;
        r109.add(Boolean.TRUE);
        r107 = r107 + 1;
        goto L38
    L40:
        setOrientation(0);
        setGravity(17);
        a();
        return;
    L11:
        r111 = 0;
        goto L12
    }
}
