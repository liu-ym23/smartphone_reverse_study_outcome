package com.obric.oui.common.debug;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pla.b;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\bB\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/obric/oui/common/debug/DebugFrameLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class DebugFrameLayout extends FrameLayout {

    public static final class a {
    }

    static {
    }

    public DebugFrameLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public DebugFrameLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r110, int r111) {
        super.onMeasure(r110, r111);
        int r100 = View.MeasureSpec.getMode(r110);
        int r112 = View.MeasureSpec.getSize(r110);
        int r101 = View.MeasureSpec.getMode(r111);
        int r113 = View.MeasureSpec.getSize(r111);
        int r102 = getMeasuredWidth();
        int r103 = getMeasuredHeight();
        String r104 = "UNKNOWN";
        if (r100 == Integer.MIN_VALUE) goto L9;
        if (r100 == 0) goto L8;
        if (r100 == 1073741824) goto L7;
        String r105 = "UNKNOWN";
    L10:
        if (r101 == Integer.MIN_VALUE) goto L16;
        if (r101 == 0) goto L15;
        if (r101 != 1073741824) goto L17;
        r104 = "EXACTLY";
    L17:
        int r106 = b.f529795a;
        b.a("DebugFrameLayout onMeasure", "Width mode: " + r105 + ", width size: " + r112 + ", measured width: " + r102);
        b.a("DebugFrameLayout onMeasure", "Height mode: " + r104 + ", height size: " + r113 + ", measured height: " + r103);
        return;
    L15:
        r104 = "UNSPECIFIED";
        goto L17
    L16:
        r104 = "AT_MOST";
        goto L17
    L7:
        r105 = "EXACTLY";
        goto L10
    L8:
        r105 = "UNSPECIFIED";
        goto L10
    L9:
        r105 = "AT_MOST";
        goto L10
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        int r105 = r103 - r101;
        int r106 = b.f529795a;
        b.a("DebugFrameLayout onLayout", "Layout left: " + r101 + ", top: " + r102 + ", right: " + r103 + ", bottom: " + r104);
        StringBuilder r107 = new StringBuilder("Layout width: ");
        r107.append(r105);
        r107.append(", height: ");
        r107.append(r104 - r102);
        b.a("DebugFrameLayout onLayout", r107.toString());
    }
}
