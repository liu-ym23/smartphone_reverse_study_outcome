package com.suite.lark.platform.component.cta.newstyle.widgets;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byted.cast.common.CastMonitor;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0014J0\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0014J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/suite/lark/platform/component/cta/newstyle/widgets/CustomButtonGroup;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "horizontalSpacing", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "", "l", "t", "r", "b", "isTextTruncated", "view", "Landroid/view/View;", "cta_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomButtonGroup extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f460568a;

    public CustomButtonGroup(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CustomButtonGroup(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public static boolean a(View r100) {
        if ((r100 instanceof TextView) == false) goto L9;
        Layout r101 = ((TextView) r100).getLayout();
        if (r101 == null) goto L9;
        if (r101.getEllipsisCount(r101.getLineCount() - 1) <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r110, int r111) {
        int r100 = View.MeasureSpec.getMode(r110);
        int r101 = View.MeasureSpec.getSize(r110);
        int r102 = View.MeasureSpec.getMode(r111);
        int r112 = View.MeasureSpec.getSize(r111);
        int r103 = getChildCount();
        int r104 = 0;
        if (r103 != 0) goto L6;
        setMeasuredDimension(0, 0);
        return;
    L6:
        boolean r105 = true;
        if (r103 != 1) goto L9;
        View r113 = getChildAt(0);
        measureChildWithMargins(r113, r110, 0, r111, 0);
        int r106 = r113.getMeasuredWidth();
        int r107 = r113.getMeasuredHeight();
    L28:
        if (r100 == 1073741824) goto L31;
        r101 = r106;
    L31:
        if (r102 == 1073741824) goto L34;
        r112 = r107;
    L34:
        setMeasuredDimension(r101, r112);
        return;
    L9:
        if (r103 == 2) goto L16;
        r106 = 0;
        r107 = 0;
    L11:
        if (r104 >= r103) goto L28;
        View r114 = getChildAt(r104);
        measureChild(r114, r110, r111);
        r106 = Math.max(r106, r114.getMeasuredWidth());
        r107 = r107 + r114.getMeasuredHeight();
        if (r104 >= (r103 - 1)) goto L15;
        r107 = r107 + this.f460568a;
    L15:
        r104 = r104 + 1;
        goto L11
    L16:
        View r108 = getChildAt(0);
        View r115 = getChildAt(1);
        measureChild(r108, View.MeasureSpec.makeMeasureSpec(r101, Integer.MIN_VALUE), r111);
        measureChild(r115, View.MeasureSpec.makeMeasureSpec(r101, Integer.MIN_VALUE), r111);
        if (((r108.getMeasuredWidth() + r115.getMeasuredWidth()) + this.f460568a) > r101) goto L23;
        Intrinsics.checkNotNull(r108);
        if (a(r108) == true) goto L23;
        Intrinsics.checkNotNull(r115);
        if (a(r115) == true) goto L23;
    L24:
        if (r105 == false) goto L26;
        int r109 = View.MeasureSpec.makeMeasureSpec((r101 - this.f460568a) / 2, 1073741824);
        int r116 = View.MeasureSpec.makeMeasureSpec(0, 0);
        measureChild(r108, r109, r116);
        measureChild(r115, r109, r116);
        r107 = Math.max(r108.getMeasuredHeight(), r115.getMeasuredHeight());
        r106 = r101;
        goto L28
    L26:
        measureChild(r108, r110, r111);
        measureChild(r115, r110, r111);
        r106 = Math.max(r108.getMeasuredWidth(), r115.getMeasuredWidth());
        r107 = (r108.getMeasuredHeight() + this.f460568a) + r115.getMeasuredHeight();
    L23:
        r105 = false;
        goto L24
    }

    public CustomButtonGroup(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f460568a = UIUtils.dp2px(r100, 10.0f);
    }

    public /* synthetic */ CustomButtonGroup(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = getChildCount();
        if (r105 != 0) goto L5;
        return;
    L5:
        boolean r106 = true;
        if (r105 != 1) goto L8;
        View r107 = getChildAt(0);
        r107.layout(0, 0, r107.getMeasuredWidth(), r107.getMeasuredHeight());
        return;
    L8:
        if (r105 == 2) goto L12;
        int r108 = 0;
        int r109 = 0;
    L10:
        if (r108 >= r105) goto L28;
        View r110 = getChildAt(r108);
        int r111 = r110.getMeasuredHeight();
        r110.layout(0, r109, getWidth(), r109 + r111);
        r109 = r109 + (r111 + this.f460568a);
        r108 = r108 + 1;
        goto L10
    L28:
        return;
    L12:
        View r112 = getChildAt(0);
        View r113 = getChildAt(1);
        int r114 = getWidth();
        if (((r112.getMeasuredWidth() + r113.getMeasuredWidth()) + this.f460568a) > r114) goto L19;
        Intrinsics.checkNotNull(r112);
        if (a(r112) == true) goto L19;
        Intrinsics.checkNotNull(r113);
        if (a(r113) == true) goto L19;
    L20:
        if (r106 == false) goto L22;
        int r115 = (r114 - this.f460568a) / 2;
        int r116 = Math.max(r112.getMeasuredHeight(), r113.getMeasuredHeight());
        r112.layout(0, 0, r115, r116);
        r113.layout(r115 + this.f460568a, 0, r114, r116);
        return;
    L22:
        int r117 = r112.getMeasuredHeight();
        r112.layout(0, 0, r114, r117);
        int r118 = r117 + this.f460568a;
        r113.layout(0, r118, r114, r113.getMeasuredHeight() + r118);
        return;
    L19:
        r106 = false;
        goto L20
    }
}
