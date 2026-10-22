package com.larksuite.component.universe_design.button;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.larus.nova.R;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f284623a = null;

    public static final class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            a r101 = e.f284623a;
            if (r100.getTag(R.id.drawable_view_data) == null) goto L15;
            Object r102 = r100.getTag(R.id.drawable_view_data);
            if ((r102 instanceof c) == false) goto L7;
            c r103 = (c) r102;
        L8:
            if (r103 == null) goto L16;
            Object r104 = r103.f284594a;
            if (r104 != null) goto L12;
            return;
        L12:
            if ((r104 instanceof Animatable) == false) goto L18;
            ((Animatable) r104).start();
            return;
        L18:
            return;
        L16:
            return;
        L7:
            r103 = null;
            goto L8
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            a r101 = e.f284623a;
            if (r100.getTag(R.id.drawable_view_data) == null) goto L15;
            Object r102 = r100.getTag(R.id.drawable_view_data);
            if ((r102 instanceof c) == false) goto L7;
            c r103 = (c) r102;
        L8:
            if (r103 == null) goto L16;
            Object r104 = r103.f284594a;
            if (r104 != null) goto L12;
            return;
        L12:
            if ((r104 instanceof Animatable) == false) goto L18;
            ((Animatable) r104).stop();
            return;
        L18:
            return;
        L16:
            return;
        L7:
            r103 = null;
            goto L8
        }
    }

    static {
        f284623a = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(UDButton r100) {
        if (r100.getTag(R.id.drawable_view_data) == null) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L20;
        Object r102 = r100.getTag(R.id.drawable_view_data);
        if ((r102 instanceof c) == false) goto L10;
        c r103 = (c) r102;
    L11:
        if (r103 == null) goto L18;
        Drawable r104 = r103.f284594a;
        if (r104 == 0) goto L18;
        if ((r104 instanceof Animatable) == false) goto L17;
        ((Animatable) r104).stop();
    L17:
        r104.setCallback(null);
    L18:
        r100.setTag(R.id.drawable_view_data, null);
        return;
    L10:
        r103 = null;
        goto L11
    L20:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public static /* synthetic */ void i(UDButton r100) {
        h(r100, UDButtonExtensionsKt$showProgress$1.INSTANCE);
    }

    public static final void b(UDButton r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        a(r100);
        r100.setText(r101);
    }

    public static final void c(UDButton r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        b(r100, r100.getContext().getString(r101));
    }

    public static /* synthetic */ void f(UDButton r100, Drawable r101) {
        e(r100, r101, UDButtonExtensionsKt$showDrawable$1.INSTANCE);
    }

    public static final void g(UDButton r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "params");
        Resources r102 = r100.getContext().getResources();
        Integer r103 = r101.f284619h;
        if (r103 == null) goto L5;
        int r104 = r102.getDimensionPixelSize(r103.intValue());
    L6:
        Integer r105 = r101.f284617f;
        if (r105 == null) goto L9;
        int r106 = r102.getDimensionPixelSize(r105.intValue());
    L11:
        if (r101.f284622k == null) goto L13;
        Context r107 = r100.getContext();
        Integer r108 = r101.f284622k;
        Intrinsics.checkNotNull(r108);
        int[] r109 = {ContextCompat.getColor(r107, r108.intValue())};
    L17:
        CircularProgressDrawable r110 = new CircularProgressDrawable(r100.getContext());
        r110.setStyle(1);
        if (r109.length != 0) goto L20;
        boolean r111 = true;
    L22:
        if ((true ^ r111) == false) goto L25;
        r110.setColorSchemeColors(Arrays.copyOf(r109, r109.length));
    L25:
        if (r106 == (-1)) goto L27;
        r110.setCenterRadius(r106);
    L27:
        if (r104 == (-1)) goto L29;
        r110.setStrokeWidth(r104);
    L29:
        r110.setStrokeCap(Paint.Cap.ROUND);
        int r112 = ((int) (r110.getCenterRadius() + r110.getStrokeWidth())) * 2;
        r110.setBounds(0, 0, r112, r112);
        d(r100, r110, r101);
        return;
    L20:
        r111 = false;
        goto L22
    L13:
        Integer r113 = r101.f284621j;
        if (r113 == null) goto L16;
        Intrinsics.checkNotNull(r113);
        r109 = new int[]{r113.intValue()};
        goto L17
    L16:
        r109 = new int[0];
        goto L17
    L9:
        r106 = r101.f284618g;
        goto L11
    L5:
        r104 = r101.f284620i;
        goto L6
    }

    public static final void h(UDButton r100, Function1<? super d, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "params");
        d r102 = new d();
        r101.invoke(r102);
        g(r100, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void d(UDButton r100, Drawable r110, com.larksuite.component.universe_design.button.a r111) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r110, "drawable");
        Intrinsics.checkNotNullParameter(r111, "paramValues");
        Resources r101 = r100.getContext().getResources();
        Integer r102 = r111.f284587a;
        if (r102 == null) goto L7;
        int r103 = r102.intValue();
        Object r104 = r100.getContext().getString(r103);
        if (r104 == null) goto L7;
    L8:
        Integer r105 = r111.f284590d;
        if (r105 == null) goto L11;
        int r106 = r101.getDimensionPixelSize(r105.intValue());
    L12:
        int r112 = r111.f284589c;
        if (r100.getTag(R.id.drawable_view_data) == null) goto L15;
        boolean r107 = true;
    L16:
        if (r107 == false) goto L19;
        a(r100);
    L19:
        if (r106 != (-1)) goto L21;
        r106 = (int) h18.d.a(r100.getContext(), 4.0f);
    L21:
        b r108 = new b(r110);
        if (r112 == 0) goto L33;
        if (r112 != 1) goto L25;
        r108.f284592a = r106;
        StringBuilder r109 = new StringBuilder();
        if (r104 != null) goto L32;
        r104 = "";
    L32:
        r109.append(r104);
        r109.append(' ');
        SpannableString r113 = new SpannableString(r109.toString());
        r113.setSpan(r108, r113.length() - 1, r113.length(), 33);
    L37:
        r100.setText(r113);
        r100.addOnAttachStateChangeListener(f284623a);
        f r114 = new f(r100);
        r100.setTag(R.id.drawable_view_data, new c(r110, r114));
        r110.setCallback(r114);
        boolean r115 = r110 instanceof Animatable;
        if (r115 == false) goto L40;
        ((Animatable) r110).start();
    L40:
        if (r115 == false) goto L43;
        ((Animatable) r110).start();
        return;
    L43:
        return;
    L25:
        if (r112 != 2) goto L28;
        r113 = new SpannableString(" ");
        r113.setSpan(r108, 0, 1, 33);
        goto L37
    L28:
        throw new IllegalArgumentException("Please set the correct gravity");
    L33:
        r108.f284593b = r106;
        StringBuilder r116 = new StringBuilder(" ");
        if (r104 != null) goto L36;
        r104 = "";
    L36:
        r116.append(r104);
        r113 = new SpannableString(r116.toString());
        r113.setSpan(r108, 0, 1, 33);
        goto L37
    L15:
        r107 = false;
        goto L16
    L11:
        r106 = r111.f284591e;
    L7:
        r104 = r111.f284588b;
        goto L8
    }

    public static final void e(UDButton r100, Drawable r101, Function1<? super com.larksuite.component.universe_design.button.a, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "drawable");
        Intrinsics.checkNotNullParameter(r102, "params");
        com.larksuite.component.universe_design.button.a r103 = new com.larksuite.component.universe_design.button.a();
        r102.invoke(r103);
        d(r100, r101, r103);
    }
}
