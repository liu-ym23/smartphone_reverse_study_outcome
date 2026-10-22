package com.bytedance.ies.stark.framework.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alipay.sdk.m.x.d;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tb2.c;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0003;<=B\u0011\b\u0016\u0012\u0006\u00103\u001a\u000202¢\u0006\u0004\b4\u00105B\u001b\b\u0016\u0012\u0006\u00103\u001a\u000202\u0012\b\u00107\u001a\u0004\u0018\u000106¢\u0006\u0004\b4\u00108B#\b\u0016\u0012\u0006\u00103\u001a\u000202\u0012\b\u00107\u001a\u0004\u0018\u000106\u0012\u0006\u00109\u001a\u00020\u0007¢\u0006\u0004\b4\u0010:J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007J\u0010\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0007J\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0003J\u000e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u001a\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0007J\u000e\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u0010 \u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u0010!\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012J\u0010\u0010$\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\"J\u0010\u0010'\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010%J\u000e\u0010(\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0007J\u000e\u0010*\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0007J\u000e\u0010,\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0007J\u0010\u0010.\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010\u0002R\u0011\u00101\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b/\u00100¨\u0006>"}, d2 = {"Lcom/bytedance/ies/stark/framework/ui/TitleBar;", "Landroid/view/ViewGroup;", "Landroid/view/View$OnClickListener;", "", "immersive", "", "setImmersive", "", "height", "setHeight", "resId", "setLeftImageResource", "l", "setLeftClickListener", "", "title", "setLeftText", "resid", "", "size", "setLeftTextSize", "color", "setLeftTextColor", "visible", "setLeftVisible", d.f25925o, "setCenterClickListener", "setTitleColor", "setTitleSize", "typeface", "setTitleTypeface", "setTitleBackground", "setSubTitleColor", "setSubTitleSize", "Landroid/view/View;", "titleView", "setCustomTitle", "Landroid/graphics/drawable/Drawable;", "drawable", "setDivider", "setDividerColor", "dividerHeight", "setDividerHeight", "colorResId", "setActionTextColor", "listener", "setOnTitleClickListener", "getActionCount", "()I", "actionCount", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ActionList", "b", "stark-api_release"}, k = 1, mv = {1, 7, 1})
public final class TitleBar extends ViewGroup implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f248652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f248653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f248654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f248655d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f248656e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f248657f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f248658g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f248659h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f248660i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f248661j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f248662k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f248663l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f248664m;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/stark/framework/ui/TitleBar$ActionList;", "Ljava/util/LinkedList;", "Lcom/bytedance/ies/stark/framework/ui/TitleBar$a;", "<init>", "()V", "stark-api_release"}, k = 1, mv = {1, 7, 1})
    public static final class ActionList extends LinkedList<a> {
        public /* bridge */ int getSize() {
            return super.size();
        }

        @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
        public final /* bridge */ int size() {
            return getSize();
        }

        public ActionList() {
        }

        @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
        public final /* bridge */ boolean contains(Object r100) {
            if (r100 != null) goto L4;
            boolean r101 = true;
        L5:
            if (r101 == true) goto L9;
            return false;
        L9:
            return contains((a) r100);
        L4:
            r101 = r100 instanceof a;
            goto L5
        }

        @Override // java.util.LinkedList, java.util.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object r100) {
            if (r100 != null) goto L4;
            boolean r101 = true;
        L5:
            if (r101 == true) goto L9;
            return -1;
        L9:
            return indexOf((a) r100);
        L4:
            r101 = r100 instanceof a;
            goto L5
        }

        @Override // java.util.LinkedList, java.util.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object r100) {
            if (r100 != null) goto L4;
            boolean r101 = true;
        L5:
            if (r101 == true) goto L9;
            return -1;
        L9:
            return lastIndexOf((a) r100);
        L4:
            r101 = r100 instanceof a;
            goto L5
        }

        @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
        public final /* bridge */ boolean remove(Object r100) {
            if (r100 != null) goto L4;
            boolean r101 = true;
        L5:
            if (r101 == true) goto L9;
            return false;
        L9:
            return remove((a) r100);
        L4:
            r101 = r100 instanceof a;
            goto L5
        }

        public /* bridge */ a removeAt(int r100) {
            return remove(r100);
        }

        public /* bridge */ boolean contains(a r100) {
            return super.contains(r100);
        }

        public /* bridge */ int indexOf(a r100) {
            return super.indexOf(r100);
        }

        public /* bridge */ int lastIndexOf(a r100) {
            return super.lastIndexOf(r100);
        }

        @Override // java.util.LinkedList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public final /* bridge */ a remove(int r100) {
            return removeAt(r100);
        }

        public /* bridge */ boolean remove(a r100) {
            return super.remove(r100);
        }
    }

    public interface a {
        void performAction();
    }

    public static final class b {
        public static int a(int r100) {
            Resources r101 = Resources.getSystem();
            return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
        }
    }

    static {
    }

    public final void setActionTextColor(int r100) {
    }

    public final int getActionCount() {
        LinearLayout r100 = this.f248653b;
        Intrinsics.checkNotNull(r100);
        return r100.getChildCount();
    }

    public TitleBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100);
        a(r100);
    }

    public final void a(Context r100) {
        if (this.f248659h == false) goto L9;
        Resources r101 = Resources.getSystem();
        int r102 = r101.getIdentifier("status_bar_height", "dimen", "android");
        if (r102 <= 0) goto L7;
        int r103 = r101.getDimensionPixelSize(r102);
    L8:
        this.f248661j = r103;
        goto L9
    L7:
        r103 = 0;
    L9:
        this.f248662k = b.a(5);
        this.f248663l = b.a(5);
        this.f248664m = b.a(48);
        this.f248652a = new TextView(r100);
        this.f248654c = new LinearLayout(r100);
        this.f248653b = new LinearLayout(r100);
        this.f248658g = new View(r100);
        ViewGroup.LayoutParams r104 = new ViewGroup.LayoutParams(-2, -1);
        TextView r105 = this.f248652a;
        Intrinsics.checkNotNull(r105);
        r105.setTextSize(15.0f);
        TextView r106 = this.f248652a;
        Intrinsics.checkNotNull(r106);
        r106.setSingleLine();
        TextView r107 = this.f248652a;
        Intrinsics.checkNotNull(r107);
        r107.setGravity(16);
        TextView r108 = this.f248652a;
        Intrinsics.checkNotNull(r108);
        int r109 = this.f248663l;
        r108.setPadding(this.f248662k + r109, 0, r109, 0);
        this.f248655d = new TextView(r100);
        this.f248656e = new TextView(r100);
        LinearLayout r110 = this.f248654c;
        Intrinsics.checkNotNull(r110);
        r110.addView(this.f248655d);
        LinearLayout r111 = this.f248654c;
        Intrinsics.checkNotNull(r111);
        r111.addView(this.f248656e);
        LinearLayout r112 = this.f248654c;
        Intrinsics.checkNotNull(r112);
        r112.setGravity(17);
        TextView r113 = this.f248655d;
        Intrinsics.checkNotNull(r113);
        r113.setTextSize(18.0f);
        TextView r114 = this.f248655d;
        Intrinsics.checkNotNull(r114);
        r114.setSingleLine();
        TextView r115 = this.f248655d;
        Intrinsics.checkNotNull(r115);
        r115.setGravity(17);
        TextView r116 = this.f248655d;
        Intrinsics.checkNotNull(r116);
        r116.getPaint().setFakeBoldText(true);
        TextView r117 = this.f248655d;
        Intrinsics.checkNotNull(r117);
        r117.setEllipsize(TextUtils.TruncateAt.END);
        TextView r118 = this.f248656e;
        Intrinsics.checkNotNull(r118);
        r118.setTextSize(12.0f);
        TextView r119 = this.f248656e;
        Intrinsics.checkNotNull(r119);
        r119.setSingleLine();
        TextView r120 = this.f248656e;
        Intrinsics.checkNotNull(r120);
        r120.setGravity(17);
        TextView r121 = this.f248656e;
        Intrinsics.checkNotNull(r121);
        r121.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout r122 = this.f248653b;
        Intrinsics.checkNotNull(r122);
        int r123 = this.f248663l;
        r122.setPadding(r123, 0, r123, 0);
        addView(this.f248652a, r104);
        addView(this.f248654c);
        addView(this.f248653b, r104);
        addView(this.f248658g, new ViewGroup.LayoutParams(-1, 1));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Object r101 = r100.getTag();
        if ((r101 instanceof a) == false) goto L6;
        ((a) r101).performAction();
        return;
    }

    public final void setCenterClickListener(View.OnClickListener r100) {
        LinearLayout r101 = this.f248654c;
        Intrinsics.checkNotNull(r101);
        r101.setOnClickListener(r100);
    }

    public final void setCustomTitle(View r100) {
        if (r100 != null) goto L7;
        TextView r101 = this.f248655d;
        Intrinsics.checkNotNull(r101);
        r101.setVisibility(0);
        if (this.f248657f == null) goto L11;
        LinearLayout r102 = this.f248654c;
        Intrinsics.checkNotNull(r102);
        r102.removeView(this.f248657f);
        return;
    L11:
        return;
    L7:
        if (this.f248657f == null) goto L9;
        LinearLayout r103 = this.f248654c;
        Intrinsics.checkNotNull(r103);
        r103.removeView(this.f248657f);
    L9:
        ViewGroup.LayoutParams r104 = new ViewGroup.LayoutParams(-1, -1);
        this.f248657f = r100;
        LinearLayout r105 = this.f248654c;
        Intrinsics.checkNotNull(r105);
        r105.addView(r100, r104);
        TextView r106 = this.f248655d;
        Intrinsics.checkNotNull(r106);
        r106.setVisibility(8);
    }

    public final void setDivider(Drawable r100) {
        View r101 = this.f248658g;
        Intrinsics.checkNotNull(r101);
        r101.setBackgroundDrawable(r100);
    }

    public final void setDividerColor(int r100) {
        View r101 = this.f248658g;
        Intrinsics.checkNotNull(r101);
        r101.setBackgroundColor(r100);
    }

    public final void setDividerHeight(int r100) {
        View r101 = this.f248658g;
        Intrinsics.checkNotNull(r101);
        r101.getLayoutParams().height = r100;
    }

    public final void setHeight(int r100) {
        this.f248664m = r100;
        setMeasuredDimension(getMeasuredWidth(), this.f248664m);
    }

    public final void setImmersive(boolean r100) {
        this.f248659h = r100;
        int r101 = 0;
        if (r100 == false) goto L7;
        Resources r102 = Resources.getSystem();
        int r103 = r102.getIdentifier("status_bar_height", "dimen", "android");
        if (r103 <= 0) goto L7;
        r101 = r102.getDimensionPixelSize(r103);
    L7:
        this.f248661j = r101;
    }

    public final void setLeftClickListener(View.OnClickListener r100) {
        TextView r101 = this.f248652a;
        Intrinsics.checkNotNull(r101);
        r101.setOnClickListener(r100);
    }

    public final void setLeftImageResource(int r100) {
        TextView r101 = this.f248652a;
        Intrinsics.checkNotNull(r101);
        r101.setCompoundDrawablesWithIntrinsicBounds(r100, 0, 0, 0);
    }

    public final void setLeftText(int r100) {
        TextView r101 = this.f248652a;
        Intrinsics.checkNotNull(r101);
        r101.setText(r100);
    }

    public final void setLeftTextColor(int r100) {
        TextView r101 = this.f248652a;
        Intrinsics.checkNotNull(r101);
        r101.setTextColor(r100);
    }

    public final void setLeftTextSize(float r100) {
        TextView r101 = this.f248652a;
        Intrinsics.checkNotNull(r101);
        r101.setTextSize(r100);
    }

    public final void setLeftVisible(boolean r100) {
        TextView r101 = this.f248652a;
        Intrinsics.checkNotNull(r101);
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void setOnTitleClickListener(View.OnClickListener r100) {
        TextView r101 = this.f248655d;
        Intrinsics.checkNotNull(r101);
        r101.setOnClickListener(r100);
    }

    public final void setSubTitleColor(int r100) {
        TextView r101 = this.f248656e;
        Intrinsics.checkNotNull(r101);
        r101.setTextColor(r100);
    }

    public final void setSubTitleSize(float r100) {
        TextView r101 = this.f248656e;
        Intrinsics.checkNotNull(r101);
        r101.setTextSize(r100);
    }

    public final void setTitle(CharSequence r110) {
        Intrinsics.checkNotNullParameter(r110, "title");
        int r100 = StringsKt.indexOf$default(r110.toString(), "\n", 0, false, 6, null);
        if (r100 <= 0) goto L5;
        b(r110.subSequence(0, r100), r110.subSequence(r100 + 1, r110.length()), 1);
        return;
    L5:
        int r101 = StringsKt.indexOf$default(r110.toString(), "\t", 0, false, 6, null);
        if (r101 <= 0) goto L8;
        b(r110.subSequence(0, r101), c.DEFAULT_TEXT + r110.subSequence(r101 + 1, r110.length()), 0);
        return;
    L8:
        TextView r102 = this.f248655d;
        Intrinsics.checkNotNull(r102);
        r102.setText(r110);
        TextView r111 = this.f248656e;
        Intrinsics.checkNotNull(r111);
        r111.setVisibility(8);
    }

    public final void setTitleBackground(int r100) {
        TextView r101 = this.f248655d;
        Intrinsics.checkNotNull(r101);
        r101.setBackgroundResource(r100);
    }

    public final void setTitleColor(int r100) {
        TextView r101 = this.f248655d;
        Intrinsics.checkNotNull(r101);
        r101.setTextColor(r100);
    }

    public final void setTitleSize(float r100) {
        TextView r101 = this.f248655d;
        Intrinsics.checkNotNull(r101);
        r101.setTextSize(r100);
    }

    public final void setTitleTypeface(int r100) {
        TextView r101 = this.f248655d;
        Intrinsics.checkNotNull(r101);
        r101.setTypeface(Typeface.defaultFromStyle(r100));
    }

    public final void setLeftText(CharSequence r100) {
        TextView r101 = this.f248652a;
        Intrinsics.checkNotNull(r101);
        r101.setText(r100);
    }

    public final void setTitle(int r100) {
        setTitle(getResources().getString(r100));
    }

    public TitleBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101);
        a(r100);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        if (View.MeasureSpec.getMode(r101) == 1073741824) goto L5;
        int r102 = this.f248664m;
        int r103 = this.f248661j + r102;
        r101 = View.MeasureSpec.makeMeasureSpec(r102, 1073741824);
    L6:
        this.f248660i = View.MeasureSpec.getSize(r100);
        measureChild(this.f248652a, r100, r101);
        measureChild(this.f248653b, r100, r101);
        TextView r104 = this.f248652a;
        Intrinsics.checkNotNull(r104);
        int r105 = r104.getMeasuredWidth();
        LinearLayout r106 = this.f248653b;
        Intrinsics.checkNotNull(r106);
        if (r105 <= r106.getMeasuredWidth()) goto L9;
        LinearLayout r107 = this.f248654c;
        Intrinsics.checkNotNull(r107);
        int r108 = this.f248660i;
        TextView r109 = this.f248652a;
        Intrinsics.checkNotNull(r109);
        r107.measure(View.MeasureSpec.makeMeasureSpec(r108 - (r109.getMeasuredWidth() * 2), 1073741824), r101);
    L10:
        measureChild(this.f248658g, r100, r101);
        setMeasuredDimension(View.MeasureSpec.getSize(r100), r103);
        return;
    L9:
        LinearLayout r110 = this.f248654c;
        Intrinsics.checkNotNull(r110);
        int r111 = this.f248660i;
        LinearLayout r112 = this.f248653b;
        Intrinsics.checkNotNull(r112);
        r110.measure(View.MeasureSpec.makeMeasureSpec(r111 - (r112.getMeasuredWidth() * 2), 1073741824), r101);
        goto L10
    L5:
        r103 = View.MeasureSpec.getSize(r101) + this.f248661j;
        goto L6
    }

    public TitleBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101, r102);
        a(r100);
    }

    public final void b(CharSequence r100, CharSequence r101, int r102) {
        LinearLayout r103 = this.f248654c;
        Intrinsics.checkNotNull(r103);
        r103.setOrientation(r102);
        TextView r104 = this.f248655d;
        Intrinsics.checkNotNull(r104);
        r104.setText(r100);
        TextView r105 = this.f248656e;
        Intrinsics.checkNotNull(r105);
        r105.setText(r101);
        TextView r106 = this.f248656e;
        Intrinsics.checkNotNull(r106);
        r106.setVisibility(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        TextView r105 = this.f248652a;
        Intrinsics.checkNotNull(r105);
        int r106 = this.f248661j;
        TextView r107 = this.f248652a;
        Intrinsics.checkNotNull(r107);
        int r108 = r107.getMeasuredWidth();
        TextView r109 = this.f248652a;
        Intrinsics.checkNotNull(r109);
        r105.layout(0, r106, r108, r109.getMeasuredHeight() + this.f248661j);
        LinearLayout r110 = this.f248653b;
        Intrinsics.checkNotNull(r110);
        int r111 = this.f248660i;
        LinearLayout r112 = this.f248653b;
        Intrinsics.checkNotNull(r112);
        int r113 = r111 - r112.getMeasuredWidth();
        int r114 = this.f248661j;
        int r115 = this.f248660i;
        LinearLayout r116 = this.f248653b;
        Intrinsics.checkNotNull(r116);
        r110.layout(r113, r114, r115, r116.getMeasuredHeight() + this.f248661j);
        TextView r117 = this.f248652a;
        Intrinsics.checkNotNull(r117);
        int r118 = r117.getMeasuredWidth();
        LinearLayout r119 = this.f248653b;
        Intrinsics.checkNotNull(r119);
        if (r118 <= r119.getMeasuredWidth()) goto L5;
        LinearLayout r120 = this.f248654c;
        Intrinsics.checkNotNull(r120);
        TextView r121 = this.f248652a;
        Intrinsics.checkNotNull(r121);
        int r122 = r121.getMeasuredWidth();
        int r123 = this.f248661j;
        int r124 = this.f248660i;
        TextView r125 = this.f248652a;
        Intrinsics.checkNotNull(r125);
        r120.layout(r122, r123, r124 - r125.getMeasuredWidth(), getMeasuredHeight());
    L6:
        View r126 = this.f248658g;
        Intrinsics.checkNotNull(r126);
        int r127 = getMeasuredHeight();
        View r128 = this.f248658g;
        Intrinsics.checkNotNull(r128);
        r126.layout(0, r127 - r128.getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight());
        return;
    L5:
        LinearLayout r129 = this.f248654c;
        Intrinsics.checkNotNull(r129);
        LinearLayout r130 = this.f248653b;
        Intrinsics.checkNotNull(r130);
        int r131 = r130.getMeasuredWidth();
        int r132 = this.f248661j;
        int r133 = this.f248660i;
        LinearLayout r134 = this.f248653b;
        Intrinsics.checkNotNull(r134);
        r129.layout(r131, r132, r133 - r134.getMeasuredWidth(), getMeasuredHeight());
        goto L6
    }
}
