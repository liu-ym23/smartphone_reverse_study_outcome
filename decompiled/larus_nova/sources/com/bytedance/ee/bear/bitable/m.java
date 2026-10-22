package com.bytedance.ee.bear.bitable;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.UIHelper;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class m {
    public static final <T> void i(MutableLiveData<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setValue(r100.getValue());
    }

    public static final void a(ViewGroup r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "view");
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 != null) goto L5;
        r102 = new ViewGroup.LayoutParams(-1, -1);
    L6:
        r101.setLayoutParams(r102);
        r100.addView(r101);
        return;
    L5:
        r102.width = -1;
        r102.height = -1;
        goto L6
    }

    public static void b(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ValueAnimator r102 = ValueAnimator.ofInt(new int[]{r100.getHeight(), r101});
        r102.setDuration(300);
        r102.addUpdateListener(new g(r100));
        r102.start();
    }

    public static final ViewGroup.LayoutParams d(boolean r100, boolean r101) {
        int r102 = -2;
        if (r100 == false) goto L5;
        int r103 = -2;
    L6:
        if (r101 == true) goto L10;
        r102 = -1;
    L10:
        return new ViewGroup.MarginLayoutParams(r103, r102);
    L5:
        r103 = -1;
        goto L6
    }

    public static final void e(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 == null) goto L5;
        r102.height = r101;
    L6:
        r100.setLayoutParams(r102);
        return;
    L5:
        r102 = new ViewGroup.LayoutParams(-2, r101);
        goto L6
    }

    public static final void f(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 == null) goto L5;
        r102.width = r101;
    L6:
        r100.setLayoutParams(r102);
        return;
    L5:
        r102 = new ViewGroup.LayoutParams(r101, -2);
        goto L6
    }

    public static final void h(HashSet r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "filter");
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        if (((Boolean) r101.invoke(r102.next())).booleanValue() == false) goto L4;
        r102.remove();
        goto L4
    }

    public static final void k(View r100, Runnable r101) {
        Intrinsics.checkNotNullParameter(r101, "action");
        if (r100 == null) goto L5;
        r100.addOnAttachStateChangeListener(new j(r101));
    L5:
        if (r100 == null) goto L8;
        r100.post(r101);
        return;
    }

    public static final int l(int r100, float r101) {
        int r102 = (int) (r101 * 255);
        if (r102 < Color.alpha(r100)) goto L6;
        return r100;
    L6:
        return Color.argb(r102, Color.red(r100), Color.green(r100), Color.blue(r100));
    }

    public static final void m(TextView r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == false) goto L5;
        r100.setTypeface(r100.getTypeface(), 1);
        return;
    L5:
        r100.setTypeface(r100.getTypeface(), 0);
    }

    public static final void n(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewGroup r102 = (ViewGroup) r100;
        int r103 = r102.getChildCount();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        o(r102.getChildAt(r104), r101);
        r104 = r104 + 1;
        goto L3
    }

    public static final void o(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setEnabled(r101);
        if ((r100 instanceof ViewGroup) == false) goto L7;
        ViewGroup r102 = (ViewGroup) r100;
        int r103 = r102.getChildCount();
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L9;
        o(r102.getChildAt(r104), r101);
        r104 = r104 + 1;
        goto L5
    L9:
        return;
    }

    public static final void r(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L8;
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
        if (r101 == r103.bottomMargin) goto L13;
        r103.setMargins(r103.leftMargin, r103.topMargin, r103.rightMargin, r101);
        return;
    L13:
        return;
    L8:
        if (r100.getLayoutParams() != null) goto L10;
        ViewGroup.MarginLayoutParams r104 = new ViewGroup.MarginLayoutParams(-2, -2);
    L11:
        r104.setMargins(r104.leftMargin, r104.topMargin, r104.rightMargin, r101);
        r100.setLayoutParams(r104);
        return;
    L10:
        r104 = new ViewGroup.MarginLayoutParams(r100.getLayoutParams());
        goto L11
    }

    public static final void t(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L8;
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
        if (r101 == r103.rightMargin) goto L13;
        r103.setMargins(r103.leftMargin, r103.topMargin, r101, r103.bottomMargin);
        return;
    L13:
        return;
    L8:
        if (r100.getLayoutParams() != null) goto L10;
        ViewGroup.MarginLayoutParams r104 = new ViewGroup.MarginLayoutParams(-2, -2);
    L11:
        r104.setMargins(r104.leftMargin, r104.topMargin, r101, r104.bottomMargin);
        r100.setLayoutParams(r104);
        return;
    L10:
        r104 = new ViewGroup.MarginLayoutParams(r100.getLayoutParams());
        goto L11
    }

    public static final void v(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setPadding(r100.getPaddingLeft(), r101, r100.getPaddingRight(), r100.getPaddingBottom());
    }

    public static final void x(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setSelected(r101);
        if ((r100 instanceof ViewGroup) == false) goto L7;
        ViewGroup r102 = (ViewGroup) r100;
        int r103 = r102.getChildCount();
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L9;
        x(r102.getChildAt(r104), r101);
        r104 = r104 + 1;
        goto L5
    L9:
        return;
    }

    public static final void y(View[] r100, View[] r101) {
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        z(r100[r103], true);
        r103 = r103 + 1;
        goto L3
    L5:
        int r104 = r101.length;
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L8;
        z(r101[r105], false);
        r105 = r105 + 1;
        goto L6
    }

    public static final void z(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == false) goto L5;
        int r102 = 0;
    L6:
        r100.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public static void A(View r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == false) goto L11;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getVisibility() == 0) goto L22;
        r100.clearAnimation();
        r100.setVisibility(0);
        if (r102 == true) goto L10;
        r100.setAlpha(1.0f);
        return;
    L10:
        r100.setAlpha(0.0f);
        r100.animate().alpha(1.0f).setListener(new l()).setDuration(300).start();
        return;
    L22:
        return;
    L11:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getVisibility() == 8) goto L23;
        r100.clearAnimation();
        if (r102 == true) goto L17;
        r100.setVisibility(8);
        return;
    L17:
        r100.animate().alpha(0.0f).setListener(new i(r100)).setDuration(300).start();
        return;
    }

    public static final void B(View r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        if (r101 == r103.width) goto L8;
        r100.getLayoutParams().width = r101;
        if (r102 == false) goto L9;
        r100.requestLayout();
        return;
    L9:
        return;
    }

    public static final void g(View r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        if (r103 == null) goto L5;
        r103.height = r102;
        r103.width = r101;
    L6:
        r100.setLayoutParams(r103);
        return;
    L5:
        r103 = new ViewGroup.LayoutParams(r101, r102);
        goto L6
    }

    public static final <T> T j(List<? extends T> r100, int r101, T r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.isEmpty() == false) goto L5;
        return r102;
    L5:
        if (r101 >= 0) goto L7;
        return r102;
    L7:
        if (r101 < r100.size()) goto L10;
        return r102;
    L10:
        return (T) ListProtector.get(r100, r101);
    }

    public static final void p(View r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        if (r101 == r103.height) goto L8;
        r100.getLayoutParams().height = r101;
        if (r102 == false) goto L9;
        r100.requestLayout();
        return;
    L9:
        return;
    }

    public static final void s(View r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L10;
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r103;
        if (r101 == r104.leftMargin) goto L18;
        r104.setMargins(r101, r104.topMargin, r104.rightMargin, r104.bottomMargin);
        if (r102 == false) goto L19;
        r100.requestLayout();
        return;
    L19:
        return;
    L18:
        return;
    L10:
        if (r100.getLayoutParams() != null) goto L12;
        ViewGroup.MarginLayoutParams r105 = new ViewGroup.MarginLayoutParams(-2, -2);
    L13:
        r105.setMargins(r101, r105.topMargin, r105.rightMargin, r105.bottomMargin);
        if (r102 == false) goto L16;
        r100.requestLayout();
    L16:
        r100.setLayoutParams(r105);
        return;
    L12:
        r105 = new ViewGroup.MarginLayoutParams(r100.getLayoutParams());
        goto L13
    }

    public static final void u(View r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L10;
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r103;
        if (r101 == r104.topMargin) goto L11;
        r104.setMargins(r104.leftMargin, r101, r104.rightMargin, r104.bottomMargin);
        if (r102 == false) goto L12;
        r100.requestLayout();
        return;
    L12:
        return;
    L11:
        return;
    }

    public static final void w(View r100, float r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Float r103 = Float.valueOf(r101);
        Float r104 = Float.valueOf(r101);
        Float r105 = Float.valueOf(r101);
        Float r106 = Float.valueOf(r101);
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r103 == null) goto L5;
        int r107 = UIHelper.dp2px(r103.floatValue());
    L6:
        float r108 = r107;
        if (r104 == null) goto L9;
        int r109 = UIHelper.dp2px(r104.floatValue());
    L10:
        float r110 = r109;
        if (r105 == null) goto L13;
        int r111 = UIHelper.dp2px(r105.floatValue());
    L14:
        float r112 = r111;
        if (r106 == null) goto L17;
        int r113 = UIHelper.dp2px(r106.floatValue());
    L18:
        float r114 = r113;
        GradientDrawable r115 = new GradientDrawable();
        r115.setCornerRadii(new float[]{r108, r108, r110, r110, r114, r114, r112, r112});
        r115.setColor(UIHelper.getColor(r102));
        r100.setBackground(r115);
        return;
    L17:
        r113 = 0;
        goto L18
    L13:
        r111 = 0;
        goto L14
    L9:
        r109 = 0;
        goto L10
    L5:
        r107 = 0;
        goto L6
    }

    public static final void c(View r100, ActionPayload r101, gv4.a r102, Function0 r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setOnClickListener(new h(r101, r103, r102));
    }

    public static final void q(View r100, Integer r101, Integer r102, Integer r103, Integer r104) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L19;
        ViewGroup.LayoutParams r105 = r100.getLayoutParams();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
        if (r101 == null) goto L7;
        int r107 = r101.intValue();
    L8:
        if (r102 == null) goto L10;
        int r108 = r102.intValue();
    L11:
        if (r103 == null) goto L13;
        int r109 = r103.intValue();
    L14:
        if (r104 == null) goto L16;
        int r110 = r104.intValue();
    L17:
        r106.setMargins(r107, r108, r109, r110);
        return;
    L16:
        r110 = r106.bottomMargin;
        goto L17
    L13:
        r109 = r106.rightMargin;
        goto L14
    L10:
        r108 = r106.topMargin;
        goto L11
    L7:
        r107 = r106.leftMargin;
        goto L8
    L19:
        if (r100.getLayoutParams() != null) goto L21;
        ViewGroup.MarginLayoutParams r111 = new ViewGroup.MarginLayoutParams(-2, -2);
    L22:
        if (r101 == null) goto L24;
        int r112 = r101.intValue();
    L25:
        if (r102 == null) goto L27;
        int r113 = r102.intValue();
    L28:
        if (r103 == null) goto L30;
        int r114 = r103.intValue();
    L31:
        if (r104 == null) goto L33;
        int r115 = r104.intValue();
    L34:
        r111.setMargins(r112, r113, r114, r115);
        r100.setLayoutParams(r111);
        return;
    L33:
        r115 = r111.bottomMargin;
        goto L34
    L30:
        r114 = r111.rightMargin;
        goto L31
    L27:
        r113 = r111.topMargin;
        goto L28
    L24:
        r112 = r111.leftMargin;
        goto L25
    L21:
        r111 = new ViewGroup.MarginLayoutParams(r100.getLayoutParams());
        goto L22
    }
}
