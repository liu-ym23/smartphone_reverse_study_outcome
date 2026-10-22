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
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.core.text.TextUtilsCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0002\"#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0002J\u0014\u0010\u0012\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u001b\u0010\u0012\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013¢\u0006\u0004\b\u0012\u0010\u0014J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0014\u0010\u0017\u001a\u00020\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fJ\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fJ\u0010\u0010\u001b\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\u0010\u0010\u001d\u001a\u00020\t2\b\b\u0001\u0010\u001c\u001a\u00020\u0002J\u000e\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0002J\u000e\u0010!\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0002¨\u0006$"}, d2 = {"Lcom/obric/oui/calendar/OMonthPickerView;", "Landroid/view/ViewGroup;", "", "getRowCount", "getFullRowWidth", "getContentHeight", "getDayCount", "Lcom/obric/oui/calendar/PickerSelectionMode;", "mode", "", "setSelectionMode", "getSelectionMode", "count", "setColumnCount", "getColumnCount", "", "", "newLabels", "setLabels", "", "([Ljava/lang/String;)V", "getLabels", "days", "setSelectedDays", "getSelectedDays", "Lcom/obric/oui/calendar/OMonthPickerView$b;", "listener", "setOnDaysChangedListener", "resourceId", "setDayTextAppearance", "itemDiameterDp", "setItemDiameterDp", "itemPaddingDp", "setItemPaddingDp", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OMonthPickerView extends ViewGroup {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f399251o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f399252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f399253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PickerSelectionMode f399254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f399255d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<String> f399256e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f399257f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f399258g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f399259h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f399260i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f399261j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f399262k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f399263l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f399264m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<a> f399265n;

    public static final class a extends AppCompatCheckedTextView {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f399266a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f399267b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f399268c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f399269d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f399270e;

        public final void b() {
            StateListDrawable r100 = new StateListDrawable();
            r100.addState(new int[]{R.attr.state_checked}, a(this.f399268c));
            r100.addState(new int[]{R.attr.state_pressed}, a(this.f399268c));
            r100.addState(new int[0], a(this.f399269d));
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
            int r102 = this.f399266a;
        L12:
            vma.f.a(this, r102);
            return;
        L11:
            r102 = this.f399267b;
            goto L12
        L5:
            r101 = false;
            goto L6
        }

        @Override // android.widget.TextView, android.view.View
        public final void onMeasure(int r100, int r101) {
            super.onMeasure(r100, r101);
            setMeasuredDimension(CheckedTextView.resolveSize(this.f399270e, r100), CheckedTextView.resolveSize(this.f399270e, r101));
        }

        public a(Context r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100);
            this.f399266a = r101;
            this.f399267b = r102;
        }
    }

    public interface b {
    }

    public OMonthPickerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14);
    }

    public OMonthPickerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public OMonthPickerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    public final void setOnDaysChangedListener(b r100) {
    }

    private final int getDayCount() {
        return this.f399256e.size();
    }

    private final int getFullRowWidth() {
        int r100 = this.f399255d;
        return (this.f399262k * r100) + ((r100 - 1) * this.f399263l);
    }

    public final List<String> getLabels() {
        return CollectionsKt.toList(this.f399256e);
    }

    public final List<Integer> getSelectedDays() {
        List<a> r100 = this.f399265n;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L15;
        Object r104 = r102.next();
        int r105 = r103 + 1;
        if (r103 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((a) r104).isChecked() == false) goto L11;
        Integer r106 = Integer.valueOf(r103);
    L12:
        if (r106 == null) goto L14;
        r101.add(r106);
    L14:
        r103 = r105;
        goto L4
    L11:
        r106 = null;
        goto L12
    L15:
        return r101;
    }

    private final int getContentHeight() {
        return (getRowCount() * this.f399262k) + ((getRowCount() - 1) * this.f399264m);
    }

    private final int getRowCount() {
        int r100 = getDayCount();
        int r101 = this.f399255d;
        return ((r100 + r101) - 1) / r101;
    }

    public final void a() {
        removeAllViews();
        ((ArrayList) this.f399265n).clear();
        Iterator<T> r100 = this.f399256e.iterator();
    L4:
        if (r100.hasNext() == false) goto L13;
        String r101 = (String) r100.next();
        final a r102 = new a(getContext(), this.f399259h, this.f399260i);
        r102.setText(r101);
        r102.setGravity(17);
        if (this.f399261j == 0) goto L9;
        r102.setTextAppearance(getContext(), this.f399261j);
    L9:
        if (r102.isChecked() == false) goto L11;
        int r103 = r102.f399266a;
    L12:
        vma.f.a(r102, r103);
        r102.setIncludeFontPadding(false);
        r102.setSingleLine(true);
        r102.setTextAlignment(4);
        r102.setClickable(true);
        r102.setFocusable(true);
        r102.f399270e = this.f399262k;
        r102.requestLayout();
        r102.b();
        int r104 = this.f399257f;
        int r105 = this.f399258g;
        r102.f399268c = r104;
        r102.f399269d = r105;
        r102.b();
        r102.setOnClickListener(new t(this, r102));
        int r106 = this.f399262k;
        addView(r102, new ViewGroup.LayoutParams(r106, r106));
        ((ArrayList) this.f399265n).add(r102);
        goto L4
    L11:
        r103 = r102.f399267b;
        goto L12
    }

    public final int getColumnCount() {
        return this.f399255d;
    }

    public final PickerSelectionMode getSelectionMode() {
        return this.f399254c;
    }

    public final void setColumnCount(int r100) {
        int r101 = RangesKt.coerceAtLeast(r100, 1);
        if (this.f399255d != r101) goto L5;
        return;
    L5:
        this.f399255d = r101;
        requestLayout();
    }

    public final void setDayTextAppearance(int r100) {
        if (r100 != 0) goto L4;
        return;
    L4:
        this.f399261j = r100;
        Iterator r101 = ((ArrayList) this.f399265n).iterator();
    L6:
        if (r101.hasNext() == false) goto L15;
        a r102 = (a) r101.next();
        if (this.f399261j == 0) goto L11;
        r102.setTextAppearance(getContext(), this.f399261j);
    L11:
        if (r102.isChecked() == false) goto L13;
        int r103 = r102.f399266a;
    L14:
        vma.f.a(r102, r103);
        r102.setIncludeFontPadding(false);
        goto L6
    L13:
        r103 = r102.f399267b;
        goto L14
    }

    public final void setItemDiameterDp(int r100) {
        this.f399262k = pla.d.n(this, r100);
        Iterator r101 = ((ArrayList) this.f399265n).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        a r102 = (a) r101.next();
        r102.f399270e = this.f399262k;
        r102.requestLayout();
        r102.b();
        goto L4
    L6:
        requestLayout();
    }

    public final void setItemPaddingDp(int r100) {
        this.f399263l = pla.d.n(this, r100);
        this.f399264m = pla.d.n(this, r100);
        requestLayout();
    }

    public final void setLabels(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "newLabels");
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        List<Integer> r101 = getSelectedDays();
        if (r100.size() == getChildCount()) goto L8;
        boolean r102 = true;
    L9:
        this.f399256e = CollectionsKt.toList(r100);
        if (r102 == false) goto L12;
        a();
    L19:
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r101.iterator();
    L21:
        if (r104.hasNext() == false) goto L30;
        Object r105 = r104.next();
        int r106 = ((Number) r105).intValue();
        if (r106 >= 0) goto L25;
    L27:
        boolean r107 = false;
    L28:
        if (r107 == false) goto L21;
        r103.add(r105);
        goto L21
    L25:
        if (r106 >= this.f399256e.size()) goto L27;
        r107 = true;
        goto L28
    L30:
        setSelectedDays(r103);
        requestLayout();
        return;
    L12:
        Iterator r108 = ((ArrayList) this.f399265n).iterator();
        int r109 = 0;
    L14:
        if (r108.hasNext() == false) goto L19;
        Object r110 = r108.next();
        int r111 = r109 + 1;
        if (r109 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        ((a) r110).setText((CharSequence) ListProtector.get(this.f399256e, r109));
        r109 = r111;
        goto L14
    L8:
        r102 = false;
        goto L9
    }

    public final void setSelectedDays(List<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "days");
        int r101 = 0;
        if (this.f399254c != PickerSelectionMode.SINGLE) goto L18;
        Integer r102 = (Integer) CollectionsKt.firstOrNull(r100);
        Iterator<T> r103 = this.f399265n.iterator();
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
        goto L17
    L25:
        return;
    L18:
        Set r109 = CollectionsKt.toSet(r100);
        Iterator<T> r110 = this.f399265n.iterator();
    L20:
        if (r110.hasNext() == false) goto L32;
        Object r111 = r110.next();
        int r112 = r101 + 1;
        if (r101 >= 0) goto L24;
        CollectionsKt.throwIndexOverflow();
    L24:
        ((a) r111).setChecked(r109.contains(Integer.valueOf(r101)));
        r101 = r112;
        goto L20
    }

    public final void setSelectionMode(PickerSelectionMode r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        this.f399254c = r100;
        if (r100 != PickerSelectionMode.SINGLE) goto L24;
        Iterator r101 = ((ArrayList) this.f399265n).iterator();
        int r102 = 0;
    L6:
        if (r101.hasNext() == false) goto L11;
        if (((a) r101.next()).isChecked() == true) goto L12;
        r102 = r102 + 1;
    L12:
        Iterator<T> r103 = this.f399265n.iterator();
        int r104 = 0;
    L14:
        if (r103.hasNext() == false) goto L30;
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
    L30:
        return;
    L11:
        r102 = -1;
        goto L12
    }

    public final void setLabels(String[] r100) {
        Intrinsics.checkNotNullParameter(r100, "newLabels");
        setLabels(ArraysKt.toList(r100));
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r100);
        int r103 = 0;
        if (View.MeasureSpec.getMode(r100) == 0) goto L14;
        if (r102 <= 0) goto L14;
        int r104 = (r102 - getPaddingLeft()) - getPaddingRight();
        int r105 = this.f399255d;
        int r106 = this.f399262k;
        if (((r105 * r106) + ((r105 - 1) * this.f399263l)) <= r104) goto L14;
        int r107 = r104 - (r106 * r105);
        if (r107 > 0) goto L10;
    L12:
        int r108 = 0;
    L13:
        this.f399263l = r108;
        goto L14
    L10:
        if (r105 <= 1) goto L12;
        r108 = r107 / (r105 - 1);
    L14:
        setMeasuredDimension(ViewGroup.resolveSize((getPaddingLeft() + getFullRowWidth()) + getPaddingRight(), r100), ViewGroup.resolveSize((getPaddingTop() + getContentHeight()) + getPaddingBottom(), r101));
        int r109 = View.MeasureSpec.makeMeasureSpec(this.f399262k, 1073741824);
        int r110 = getChildCount();
    L15:
        if (r103 >= r110) goto L17;
        getChildAt(r103).measure(r109, r109);
        r103 = r103 + 1;
        goto L15
    }

    public OMonthPickerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L9;
        r102 = com.larus.nova.R.attr.omonthPickerViewStyle;
    L9:
        if ((r103 & 8) == 0) goto L11;
        int r104 = com.larus.nova.R.style.OStyleV2_OMonthPickerView_DayNight;
    L12:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f399252a = r102;
        this.f399253b = r104;
        this.f399254c = PickerSelectionMode.MULTIPLE;
        this.f399255d = 1;
        ArrayList r105 = new ArrayList(31);
        int r106 = 0;
    L13:
        if (r106 >= 31) goto L15;
        r106 = r106 + 1;
        r105.add(String.valueOf(r106));
        goto L13
    L15:
        this.f399256e = r105;
        this.f399259h = getResources().getInteger(com.larus.nova.R.integer.oui_font_weight_bold);
        this.f399260i = getResources().getInteger(com.larus.nova.R.integer.oui_font_weight_regular);
        this.f399265n = new ArrayList();
        TypedArray r107 = r100.obtainStyledAttributes(r101, new int[]{com.larus.nova.R.attr.o_mpv_columnCount, com.larus.nova.R.attr.o_pv_dayTextAppearance, com.larus.nova.R.attr.o_pv_itemHPadding, com.larus.nova.R.attr.o_pv_itemSize, com.larus.nova.R.attr.o_pv_itemVPadding, com.larus.nova.R.attr.o_pv_selectedBackgroundColor, com.larus.nova.R.attr.o_pv_selectionMode, com.larus.nova.R.attr.o_pv_unSelectedBackgroundColor}, this.f399252a, this.f399253b);
    L46:
        th = move-exception;
        r107.recycle();
        throw th;
    L17:
        if (r107.hasValue(5) == false) goto L20;
        this.f399257f = r107.getColor(5, this.f399257f);     // Catch: Throwable -> L46
    L20:
        if (r107.hasValue(7) == false) goto L23;
        this.f399258g = r107.getColor(7, this.f399258g);     // Catch: Throwable -> L46
    L23:
        if (r107.hasValue(1) == false) goto L26;
        this.f399261j = r107.getResourceId(1, this.f399261j);     // Catch: Throwable -> L46
    L26:
        if (r107.hasValue(6) == false) goto L33;
        int r108 = r107.getInt(6, this.f399254c.ordinal());     // Catch: Throwable -> L46
        PickerSelectionMode r109 = PickerSelectionMode.SINGLE;     // Catch: Throwable -> L46
        if (r108 == r109.ordinal()) goto L31;
        r109 = PickerSelectionMode.MULTIPLE;     // Catch: Throwable -> L46
    L31:
        this.f399254c = r109;     // Catch: Throwable -> L46
    L33:
        if (r107.hasValue(0) == false) goto L36;
        this.f399255d = RangesKt.coerceAtLeast(r107.getInt(0, this.f399255d), 1);     // Catch: Throwable -> L46
    L36:
        if (r107.hasValue(3) == false) goto L39;
        this.f399262k = r107.getDimensionPixelSize(3, this.f399262k);     // Catch: Throwable -> L46
    L39:
        if (r107.hasValue(2) == false) goto L42;
        this.f399263l = r107.getDimensionPixelSize(2, this.f399263l);     // Catch: Throwable -> L46
    L42:
        if (r107.hasValue(4) == false) goto L44;
        this.f399264m = r107.getDimensionPixelSize(4, this.f399264m);     // Catch: Throwable -> L46
    L44:
        r107.recycle();
        setClipChildren(false);
        setClipToPadding(false);
        a();
        return;
    L11:
        r104 = 0;
        goto L12
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r110, int r111, int r112) {
        int r113 = r111 - r101;
        int r102 = (r113 - getPaddingLeft()) - getPaddingRight();
        int r103 = getFullRowWidth();
        int r104 = (r102 - r103) / 2;
        int r114 = getPaddingLeft() + RangesKt.coerceAtLeast(r104, 0);
        int r115 = (r113 - getPaddingRight()) - RangesKt.coerceAtLeast(r104, 0);
        int r105 = getChildCount();
        int r116 = 0;
    L3:
        if (r116 >= r105) goto L12;
        int r106 = r116 + 1;
        View r107 = getChildAt(r116);
        int r108 = this.f399255d;
        int r109 = r116 / r108;
        int r117 = r116 % r108;
        int r118 = getPaddingTop() + (r109 * (this.f399262k + this.f399264m));
        boolean r119 = true;
        if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) goto L8;
        r119 = false;
    L8:
        if (r119 == false) goto L10;
        int r120 = this.f399262k;
        int r121 = r115 - (r117 * (this.f399263l + r120));
        int r122 = r121 - r120;
    L11:
        r107.layout(r122, r118, r121, this.f399262k + r118);
        r116 = r106;
        goto L3
    L10:
        int r123 = this.f399262k;
        int r124 = (r117 * (this.f399263l + r123)) + r114;
        int r125 = r123 + r124;
        r122 = r124;
        r121 = r125;
        goto L11
    }
}
