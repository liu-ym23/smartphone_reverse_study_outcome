package com.larksuite.component.ignition.widget.setting_group;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import h18.d;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\"\u0010&\u001a\u00020'2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J(\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\nH\u0014J\n\u0010-\u001a\u0004\u0018\u00010.H\u0002J\n\u0010/\u001a\u0004\u0018\u00010.H\u0002J\u0010\u00100\u001a\u00020'2\u0006\u00101\u001a\u00020.H\u0002J\b\u00102\u001a\u00020'H\u0002J\b\u00103\u001a\u00020'H\u0002R&\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u0014@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R&\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R&\u0010\u001d\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R&\u0010!\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020 8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u00064"}, d2 = {"Lcom/larksuite/component/ignition/widget/setting_group/SettingGroupLayout;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "value", "itemBackgroundColor", "getItemBackgroundColor", "()I", "setItemBackgroundColor", "(I)V", "", "hasDivider", "getHasDivider", "()Z", "setHasDivider", "(Z)V", "dividerBackgroundColor", "getDividerBackgroundColor", "setDividerBackgroundColor", "dividerPaddingLeft", "getDividerPaddingLeft", "setDividerPaddingLeft", "", "itemCornerRadius", "getItemCornerRadius", "()F", "setItemCornerRadius", "(F)V", "applyAttrs", "", "onSizeChanged", "w", "h", "oldw", "oldh", "getFirstVisibleChild", "Landroid/view/View;", "getLastVisibleChild", "adjustBackground", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "setItemBackground", "setupDivider", "ignition-widget-settinggroup_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SettingGroupLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f284016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f284017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f284018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f284019d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f284020e;

    public final void b() {
        if (this.f284017b == false) goto L7;
        SettingGroupDividerDrawable r100 = new SettingGroupDividerDrawable(getContext());
        r100.f284010c = UIUtils.getColor(getContext(), this.f284018c);
        r100.invalidateSelf();
        setDividerDrawable(r100);
        setShowDividers(2);
        int r101 = this.f284019d;
        if (r101 < 0) goto L9;
        r100.f284009b = r101;
        r100.invalidateSelf();
        return;
    L9:
        return;
    L7:
        setDividerDrawable(null);
        setShowDividers(0);
    }

    private final View getFirstVisibleChild() {
        Iterator<Integer> r100 = RangesKt.until(0, getChildCount()).iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Integer r101 = r100.next();
        if (getChildAt(r101.intValue()).getVisibility() != 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L12:
        Integer r103 = r101;
        if (r103 != null) goto L15;
        return null;
    L15:
        return getChildAt(r103.intValue());
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L12
    }

    private final View getLastVisibleChild() {
        Iterator<Integer> r100 = RangesKt.downTo(getChildCount() - 1, 0).iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Integer r101 = r100.next();
        if (getChildAt(r101.intValue()).getVisibility() != 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L12:
        Integer r103 = r101;
        if (r103 != null) goto L15;
        return null;
    L15:
        return getChildAt(r103.intValue());
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L12
    }

    public final void a() {
        if (getChildCount() > 0) goto L5;
        return;
    L5:
        int r100 = getChildCount();
        int r101 = 0;
    L6:
        if (r101 >= r100) goto L14;
        View r102 = getChildAt(r101);
        Drawable r103 = r102.getBackground();
        if ((r103 instanceof GradientDrawable) == false) goto L10;
        GradientDrawable r104 = (GradientDrawable) r103;
    L11:
        if (r104 != null) goto L13;
        r104 = new GradientDrawable();
        r104.setColor(UIUtils.getColorStateList(getContext(), this.f284016a));
    L13:
        View r105 = getFirstVisibleChild();
        View r106 = getLastVisibleChild();
        int r107 = b.f284022a;
        b.a(r104, getContext(), Intrinsics.areEqual(r105, r102), Intrinsics.areEqual(r106, r102), this.f284020e);
        r102.setBackground(r104);
        r101 = r101 + 1;
        goto L6
    L10:
        r104 = null;
        goto L11
    }

    public final int getDividerBackgroundColor() {
        return this.f284018c;
    }

    public final int getDividerPaddingLeft() {
        return this.f284019d;
    }

    public final boolean getHasDivider() {
        return this.f284017b;
    }

    public final int getItemBackgroundColor() {
        return this.f284016a;
    }

    public final float getItemCornerRadius() {
        return this.f284020e;
    }

    public SettingGroupLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setDividerBackgroundColor(int r100) {
        if (this.f284018c != r100) goto L5;
        return;
    L5:
        this.f284018c = r100;
        b();
    }

    public final void setDividerPaddingLeft(int r100) {
        if (this.f284019d != r100) goto L5;
        return;
    L5:
        this.f284019d = r100;
        b();
    }

    public final void setHasDivider(boolean r100) {
        if (this.f284017b != r100) goto L5;
        return;
    L5:
        this.f284017b = r100;
        b();
    }

    public final void setItemBackgroundColor(int r100) {
        if (this.f284016a != r100) goto L5;
        return;
    L5:
        this.f284016a = r100;
        a();
    }

    public final void setItemCornerRadius(float r100) {
        if (this.f284020e != r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        this.f284020e = r100;
        a();
        return;
    L5:
        r101 = false;
        goto L6
    }

    public SettingGroupLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public SettingGroupLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, R.style.IgnitionSettingGroupLayout);
    }

    public SettingGroupLayout(Context r100, AttributeSet r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, r103);
        this.f284016a = R.color.bg_setting_group_item;
        this.f284018c = R.color.bg_body;
        this.f284019d = -1;
        this.f284020e = d.b(getContext(), 10);
        setOrientation(1);
        TypedArray r104 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.dividerBackgroundColor, R.attr.dividerPaddingLeft, R.attr.hasDivider, R.attr.itemBackgroundColor}, r102, r103);
        setHasDivider(r104.getBoolean(2, this.f284017b));
        setItemBackgroundColor(r104.getResourceId(3, R.color.bg_setting_group_item));
        setDividerBackgroundColor(r104.getResourceId(0, R.color.bg_body));
        setDividerPaddingLeft(r104.getDimensionPixelSize(1, this.f284019d));
        r104.recycle();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        a();
    }
}
