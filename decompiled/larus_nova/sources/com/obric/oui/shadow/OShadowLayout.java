package com.obric.oui.shadow;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.common.style.q;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/shadow/OShadowLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OShadowLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f402797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q f402798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f402799c;

    public static final class a {
    }

    static {
    }

    public OShadowLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OShadowLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        Path r100 = new Path();
        int r101 = getChildCount();
        int r102 = Integer.MAX_VALUE;
        int r103 = Integer.MAX_VALUE;
        int r104 = Integer.MIN_VALUE;
        int r105 = Integer.MIN_VALUE;
        int r106 = 0;
    L3:
        if (r106 >= r101) goto L9;
        int r107 = r106 + 1;
        View r108 = getChildAt(r106);
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        if (r109 == null) goto L8;
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) r109;
        r102 = Math.min(r102, r108.getLeft() - r111.leftMargin);
        r103 = Math.min(r103, r108.getTop() - r111.topMargin);
        r104 = Math.max(r104, r108.getRight() + r111.rightMargin);
        r105 = Math.max(r105, r108.getBottom() + r111.bottomMargin);
        r106 = r107;
        goto L3
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L9:
        RectF r112 = new RectF(r102, r103, r104, r105);
        float r113 = this.f402799c;
        r100.addRoundRect(r112, r113, r113, Path.Direction.CW);
        RectF r114 = new RectF();
        r100.computeBounds(r114, true);
        a(r110, r100, r114, this.f402797a);
        a(r110, r100, r114, this.f402798b);
    }

    public OShadowLayout(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        q r100 = q.f399591h;
        q r101 = r100.a();
        this.f402797a = r101;
        q r102 = r100.a();
        this.f402798b = r102;
        TypedArray r113 = r110.obtainStyledAttributes(r111, new int[]{R.attr.oui_firstOffsetX, R.attr.oui_firstOffsetY, R.attr.oui_firstShadowColor, R.attr.oui_firstShadowRadius, R.attr.oui_firstShadowSpread, R.attr.oui_secondOffsetX, R.attr.oui_secondOffsetY, R.attr.oui_secondShadowColor, R.attr.oui_secondShadowRadius, R.attr.oui_secondShadowSpread, R.attr.oui_shadow, R.attr.oui_shadowCornerRadius}, r112, 0);
        b[] r114 = ShadowTokenCore.parse(r113.getString(10));
        Resources r115 = r110.getResources();
        float r116 = WindowDisplayMetricsOverride.apply(r115, r115.getDisplayMetrics()).density;
        if (r114 != null) goto L5;
        int r117 = com.obric.oui.shadow.a.f402800g;
        r101.c(com.obric.oui.shadow.a.C4679a.a(r113, 2, 3, 0, 1, 4));
        r102.c(com.obric.oui.shadow.a.C4679a.a(r113, 7, 8, 5, 6, 9));
    L15:
        this.f402799c = r113.getDimension(11, 0.0f);
        r113.recycle();
        setWillNotDraw(false);
        Math.max(Math.abs(r101.f399594c) + Math.abs(r101.f399593b), Math.abs(r102.f399594c) + Math.abs(r102.f399593b));
        Math.max(Math.abs(r101.f399595d) + Math.abs(r101.f399593b), Math.abs(r102.f399595d) + Math.abs(r102.f399593b));
        return;
    L5:
        if (r114.length != 0) goto L7;
        boolean r103 = true;
    L9:
        if ((!r103) == false) goto L12;
        r101.d(r114[0], r116);
    L12:
        if (r114.length <= 1) goto L15;
        r102.d(r114[1], r116);
        goto L15
    L7:
        r103 = false;
        goto L9
    }

    public /* synthetic */ OShadowLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void a(Canvas r100, Path r101, RectF r102, q r103) {
        int r104 = r100.save();
        RectF r105 = new RectF(r102);
        r105.offset(r103.f399594c, r103.f399595d);
        float r106 = -r103.f399596e;
        r105.inset(r106, r106);
        r100.clipOutPath(r101);
        float r107 = this.f402799c;
        r100.drawRoundRect(r105, r107, r107, r103.f399597f);
        r100.restoreToCount(r104);
    }
}
