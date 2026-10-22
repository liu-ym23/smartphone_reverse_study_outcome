package com.bytedance.android.shopping.yata.biz.popup;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.shopping.yata.biz.popup.behavior.SheetBaseBehavior;
import com.bytedance.android.shopping.yata.biz.popup.component.c;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import com.bytedance.android.ui.base.widget.round.RoundFrameLayout;
import hl3.d;
import hl3.e;
import hl3.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements hl3.a {
    public f a;
    public e b;
    public final ArrayList<hl3.b> c;
    public final c d;
    public final il3.a e;
    public final String f;
    public Function1<? super hl3.a, Unit> g;

    public a() {
        throw null;
    }

    public final d a() {
        c r0 = this.d;
        hl3.c r1 = null;
        if (r0 == null) goto L5;
        hl3.c r2 = r0.b;
    L7:
        if ((r2 instanceof d) == false) goto L11;
        r1 = r2;
    L11:
        return (d) r1;
    L5:
        r2 = null;
        goto L7
    }

    public final View b() {
        c r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e;
    }

    @Override // hl3.a
    public final void dismiss() {
        c r0 = this.d;
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    public final int hashCode() {
        return this.f.hashCode();
    }

    @Override // hl3.a
    public final void init() {
        e r0 = this.b;
        if (r0 == null) goto L5;
        r0.e(this.e);
    L5:
        Iterator<hl3.b> r1 = this.c.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        r1.next().e(this.e);
        goto L7
    L9:
        c r2 = this.d;
        if (r2 == null) goto L113;
        r2.a = this;
        r2.b = new com.bytedance.android.shopping.yata.biz.popup.component.e(r2.getContext(), (String) r2.c("schema", ""), r2.a);
        Drawable r3 = null;
        View r4 = View.inflate(r2.getContext(), 2131568287, null);
        r2.e = r4;
        if (r4 == null) goto L96;
        RoundFrameLayout r5 = (RoundFrameLayout) r4.findViewById(2131367491);
        if (r5 == null) goto L96;
        int r6 = SheetBaseBehavior.g;
        Intrinsics.checkNotNull(r5);
        CoordinatorLayout.LayoutParams r7 = r5.getLayoutParams();
        if ((r7 instanceof CoordinatorLayout.LayoutParams) == false) goto L95;
        CoordinatorLayout.Behavior r8 = r7.getBehavior();
        if ((r8 instanceof SheetBaseBehavior) == false) goto L93;
        SheetBaseBehavior<?> r9 = (SheetBaseBehavior) r8;
        Boolean r10 = Boolean.TRUE;
        r9.a = ((Boolean) r2.c("hide_able", r10)).booleanValue();
        if (((Boolean) r2.c("enable_pull_up", Boolean.FALSE)).booleanValue() == false) goto L23;
        r9.setPeekHeight((int) ((Number) r2.c("collapsed_height", Float.valueOf(0.0f))).floatValue());
        boolean r11 = false;
    L24:
        r9.c = r11;
        r9.d = ((Boolean) r2.c("disable_drag_down", r10)).booleanValue();
        r9.b = r2;
        Unit r12 = Unit.INSTANCE;
        r2.g = r9;
        int r13 = (int) ((Number) r2.c("height", Float.valueOf(-1.0f))).floatValue();
        int r14 = -1;
        if (r13 != (-1)) goto L27;
        r13 = (int) (k1.j(r2.getContext()) * 0.73f);
    L27:
        ViewGroup.LayoutParams r15 = r5.getLayoutParams();
        r15.height = r13;
        r5.setLayoutParams(r15);
        View r16 = r2.e;
        if (r16 == null) goto L30;
        FrameLayout r17 = (FrameLayout) r16.findViewById(2131375318);
    L31:
        if (r17 == null) goto L33;
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
    L35:
        if ((r18 instanceof ViewGroup.MarginLayoutParams) == true) goto L37;
        r18 = null;
    L37:
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r18;
        if (r19 == null) goto L40;
        r19.bottomMargin = ((Number) r2.c("bottom_offset", 0)).intValue();
        r17.setLayoutParams(r19);
    L40:
        hl3.c r20 = r2.b;
        if (r20 == null) goto L96;
        View r21 = r20.getView();
        if (r21 == null) goto L96;
        r5.addView(r21);
        Iterable r22 = (Iterable) r2.c("radius", CollectionsKt.listOf(new Integer[]{20, 20, 0, 0}));
        ArrayList r23 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10));
        Iterator r24 = r22.iterator();
    L47:
        if (r24.hasNext() == false) goto L124;
        Object r110 = r24.next();
        if ((r110 instanceof Number) == true) goto L51;
        r110 = null;
    L51:
        Number r111 = (Number) r110;
        if (r111 == null) goto L54;
        float r112 = r111.floatValue();
    L55:
        r23.add(Float.valueOf(r112));
        goto L47
    L54:
        r112 = 0.0f;
        goto L55
    L124:
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L58
        int r26 = s.a;     // Catch: Throwable -> L58
        Object r27 = Result.constructor-impl(s.b((String) r2.c("bg_color", "#FFFFFF")));     // Catch: Throwable -> L58
    L61:
        if (Result.isFailure-impl(r27) == false) goto L63;
        r27 = null;
    L63:
        Integer r28 = (Integer) r27;
        if (r28 == null) goto L66;
        r14 = r28.intValue();
    L66:
        Drawable r29 = r5.getBackground();
        if ((r29 instanceof BackgroundDrawable) == false) goto L70;
        r3 = r29;
    L70:
        BackgroundDrawable r30 = (BackgroundDrawable) r3;
        if (r30 == null) goto L89;
        r30.setBgColor(r14);
        Float r31 = (Float) CollectionsKt.getOrNull(r23, 0);
        float r32 = 20.0f;
        if (r31 == null) goto L75;
        float r33 = r31.floatValue();
    L76:
        r30.setCornerRadiusTL(com.bytedance.android.shopping.extensions.b.b(Float.valueOf(r33)));
        Float r34 = (Float) CollectionsKt.getOrNull(r23, 1);
        if (r34 == null) goto L79;
        r32 = r34.floatValue();
    L79:
        r30.setCornerRadiusTR(com.bytedance.android.shopping.extensions.b.b(Float.valueOf(r32)));
        Float r35 = (Float) CollectionsKt.getOrNull(r23, 2);
        if (r35 == null) goto L82;
        float r36 = r35.floatValue();
    L83:
        r30.setCornerRadiusBR(com.bytedance.android.shopping.extensions.b.b(Float.valueOf(r36)));
        Float r37 = (Float) CollectionsKt.getOrNull(r23, 3);
        if (r37 == null) goto L86;
        float r38 = r37.floatValue();
    L87:
        r30.setCornerRadiusBL(com.bytedance.android.shopping.extensions.b.b(Float.valueOf(r38)));
        r30.invalidate();
        goto L89
    L86:
        r38 = 0.0f;
        goto L87
    L82:
        r36 = 0.0f;
        goto L83
    L75:
        r33 = 20.0f;
    L89:
        if (((Boolean) r2.c("render_safe_area", Boolean.TRUE)).booleanValue() == false) goto L91;
        r5.setPadding(0, 0, 0, com.bytedance.android.shopping.extensions.b.b(20));
        goto L96
    L91:
        r5.setPadding(0, 0, 0, 0);
    L58:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r27 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L61
    L33:
        r18 = null;
        goto L35
    L30:
        r17 = null;
        goto L31
    L23:
        r11 = true;
        goto L24
    L93:
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    L95:
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    L96:
        Boolean r39 = Boolean.FALSE;
        boolean r40 = ((Boolean) r2.c("has_mask", r39)).booleanValue();
        r2.i = r40;
        if (r40 == false) goto L113;
        View r41 = r2.e;
        if (r41 == null) goto L113;
        View r42 = r41.findViewById(2131367534);
        if (r42 == null) goto L113;
        r2.f = r42;
        r2.j = ((Boolean) r2.c("allow_close_by_touch_mask", r39)).booleanValue();
        View r43 = r2.f;
        if (r43 == null) goto L107;
        r43.setOnClickListener(r2);
    L107:
        int r44 = ((Number) r2.c("mask_color", 0)).intValue();
        View r45 = r2.f;
        if (r45 == null) goto L110;
        r45.setBackgroundColor(r44);
    L110:
        View r46 = r2.f;
        if (r46 == null) goto L113;
        r46.setAlpha(0.0f);
    L113:
        Function1<? super hl3.a, Unit> r47 = this.g;
        if (r47 == null) goto L116;
        Unit r48 = (Unit) r47.invoke(this);
    L116:
        e r49 = this.b;
        if (r49 == null) goto L119;
        r49.c(this);
    L119:
        Iterator<hl3.b> r50 = this.c.iterator();
    L121:
        if (r50.hasNext() == false) goto L123;
        r50.next().c(this);
        goto L121
    }

    @Override // hl3.a
    public final void show() {
        c r0 = this.d;
        if (r0 == null) goto L8;
        hl3.c r1 = r0.b;
        if (r1 == null) goto L9;
        r1.b(r0.d, new com.bytedance.android.shopping.yata.biz.popup.component.b(r0));
        return;
    L9:
        return;
    }

    @Override // hl3.a
    public final String getId() {
        return this.f;
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 == null) goto L8;
        Class<?> r2 = r4.getClass();
    L10:
        if ((!Intrinsics.areEqual(a.class, r2)) == false) goto L12;
        return false;
    L12:
        if (r4 == null) goto L18;
        if ((!Intrinsics.areEqual(this.f, ((a) r4).f)) == false) goto L16;
        return false;
    L16:
        return true;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.yata.biz.popup.PopupCard");
    L8:
        r2 = null;
        goto L10
    }

    public a(WeakReference r3, il3.a r4) {
        String r0 = r4.b();
        Intrinsics.checkNotNullParameter(r3, "contextRef");
        Intrinsics.checkNotNullParameter(r4, "config");
        Intrinsics.checkNotNullParameter(r0, "id");
        this.e = r4;
        this.f = r0;
        c r1 = null;
        this.g = null;
        this.c = new ArrayList();
        Context r5 = (Context) r3.get();
        if (r5 == null) goto L5;
        r1 = new c(r5, r4);
    L5:
        this.d = r1;
    }
}
