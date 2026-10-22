package com.ss.android.lark.widget.light.layout;

import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes38.dex */
public final class TextLayoutViewHelperKt {
    public static final void a(final View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Object r102 = r100.getTag(R.id.tag_text_layout_build_coordinator);
        if ((r102 instanceof d) == false) goto L5;
        d r103 = (d) r102;
    L7:
        if (r100.isLayoutRequested() == true) goto L9;
        return;
    L9:
        long r104 = System.nanoTime();
        final Ref.IntRef r105 = new Ref.IntRef();
        if (r103 == null) goto L14;
        TextLayoutBuilder.a r106 = r103.f446154a;
        if (r106 == null) goto L14;
        int r107 = r106.f446133b;
    L15:
        r105.element = r107;
        int r108 = 536870912;
        if (r107 != 0) goto L18;
        r105.element = 536870912;
    L19:
        int r109 = r100.getLayoutParams().width;
        if (r109 >= (-2)) goto L23;
        r109 = -2;
    L23:
        if (r105.element > 0) goto L26;
        if (r109 != (-1)) goto L26;
        r109 = -2;
    L26:
        int r110 = r100.getHeight();
        if (r110 == 0) goto L30;
        r108 = r110;
    L30:
        final int r111 = View.MeasureSpec.makeMeasureSpec(r108, Integer.MIN_VALUE);
        Function0<Unit> r112 = new TextLayoutViewHelperKt$defaultMeasureViewOnBuildLayout$measureWrapContent$1(r105, r100, r111);
        if (r109 != (-2)) goto L33;
        r112.invoke();
    L37:
        Log.d("SpanViewCoordinator", "performMeasure, end, cost: " + (System.nanoTime() - r104) + " nanos,viewWidth is " + r100.getMeasuredWidth() + " , viewHeight is " + r100.getMeasuredHeight());
        return;
    L33:
        if (r109 == (-1)) goto L35;
        r100.measure(View.MeasureSpec.makeMeasureSpec(Math.min(r109, r105.element), 1073741824), r111);
        goto L37
    L35:
        r100.measure(View.MeasureSpec.makeMeasureSpec(r105.element, 1073741824), r111);
        goto L37
    L18:
        r105.element = r107 - r101;
    L14:
        r107 = 0;
        goto L15
    L5:
        r103 = null;
        goto L7
    }
}
