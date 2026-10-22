package com.bytedance.ee.bear.office.common.screenmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements fk5.b {

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function1<fk5.a, Unit> a;
        public final /* synthetic */ fk5.a b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super fk5.a, Unit> r1, fk5.a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.invoke(this.b);
        }
    }

    public f() {
    }

    public static void e(View r9, e r10) {
        TextView r0 = (TextView) r9.findViewById(2131379929);
        TextView r1 = (TextView) r9.findViewById(2131379927);
        FrameLayout r2 = (FrameLayout) r9.findViewById(2131379914);
        ImageView r3 = (ImageView) r9.findViewById(2131379912);
        FrameLayout r4 = (FrameLayout) r9.findViewById(2131379911);
        ImageView r5 = (ImageView) r9.findViewById(2131379910);
        Intrinsics.checkNotNull(r2);
        Intrinsics.checkNotNull(r3);
        c(r2, r3, r10.o);
        Intrinsics.checkNotNull(r4);
        Intrinsics.checkNotNull(r5);
        c(r4, r5, r10.o);
        Integer r6 = r10.p;
        if (r6 == null) goto L9;
        int r7 = r6.intValue();
        Intrinsics.checkNotNull(r0);
        ViewGroup.LayoutParams r8 = r0.getLayoutParams();
        if (r8 == null) goto L8;
        ConstraintLayout.LayoutParams r11 = (ConstraintLayout.LayoutParams) r8;
        r11.setMarginStart(r7);
        r0.setLayoutParams(r11);
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L9:
        String r12 = r10.b;
        String r13 = "";
        if (r12 != null) goto L12;
        r12 = "";
    L12:
        r0.setText(r12);
        Integer r14 = r10.d;
        if (r14 == null) goto L15;
        int r15 = r14.intValue();
    L16:
        r0.setTextColor(r15);
        Intrinsics.checkNotNull(r1);
        if (r10.c == null) goto L19;
        boolean r16 = true;
    L20:
        if (r16 == false) goto L22;
        int r17 = 0;
    L23:
        r1.setVisibility(r17);
        String r18 = r10.c;
        if (r18 == null) goto L27;
        r13 = r18;
    L27:
        r1.setText(r13);
        if (r10.f == false) goto L30;
        Integer r19 = null;
    L31:
        d(r2, r3, r19, r10, r10.g);
        if (r10.f == false) goto L34;
        Integer r20 = r10.e;
    L35:
        d(r4, r5, r20, r10, false);
        r9.setSelected(r10.i);
        if (r10.n == false) goto L38;
        float r21 = 0.5f;
    L39:
        r9.setAlpha(r21);
        r9.setEnabled(r10.m);
        return;
    L38:
        r21 = 1.0f;
        goto L39
    L34:
        r20 = r10.h;
        goto L35
    L30:
        r19 = r10.e;
        goto L31
    L22:
        r17 = 8;
        goto L23
    L19:
        r16 = false;
        goto L20
    L15:
        r15 = ContextCompat.getColor(r9.getContext(), 2131103933);
        goto L16
    }

    @Override // fk5.b
    public void update(fk5.a r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "item");
        if ((r2 instanceof e) == false) goto L8;
        if (r3 == null) goto L9;
        e(r3, (e) r2);
        return;
    L9:
        return;
    }

    public static void c(View r3, View r4, Integer r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if (r0 == null) goto L13;
        r0.width = r5.intValue();
        r0.height = r5.intValue();
        r3.setLayoutParams(r0);
        ViewGroup.LayoutParams r6 = r4.getLayoutParams();
        if (r6 == null) goto L11;
        r6.width = r5.intValue();
        r6.height = r5.intValue();
        r4.setLayoutParams(r6);
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @Override // fk5.b
    public final void a(CommonMenu r2, fk5.a r3, View r4, Function1<? super fk5.a, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r5, "listener");
        if (r4 == null) goto L6;
        r4.setOnClickListener(new a(r5, r3));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // fk5.b
    public final View b(CommonMenu r6, int r7, int r8, fk5.a r9) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r9, "item");
        if ((r9 instanceof e) == true) goto L6;
        return null;
    L6:
        FrameLayout r0 = new FrameLayout(r6.getContext());
        e r10 = (e) r9;
        if (r10.c == null) goto L9;
        Context r2 = r0.getContext();
        int r3 = 64;
    L10:
        r0.setLayoutParams(new LinearLayoutCompat.LayoutParams(-1, k.a(r2, r3)));
        int r1 = r10.l;
        if (r1 > 0) goto L14;
        r1 = k.a(r0.getContext(), 16);
    L14:
        int r4 = k.a(r0.getContext(), 20);
        r0.setPadding(r1, r0.getPaddingTop(), r4, r0.getPaddingBottom());
        if (r8 != 1) goto L17;
        int r11 = 2131244658;
    L23:
        r0.setBackgroundResource(r11);
        LayoutInflater.from(r6.getContext()).inflate(2131564067, r0, true);
        e(r0, r10);
        return r0;
    L17:
        if (r7 != 0) goto L20;
        r11 = 2131244649;
        goto L23
    L20:
        if (r7 != (r8 - 1)) goto L22;
        r11 = 2131244652;
        goto L23
    L22:
        r11 = 2131244655;
        goto L23
    L9:
        r2 = r0.getContext();
        r3 = 48;
        goto L10
    }

    public static void d(View r2, ImageView r3, Integer r4, e r5, boolean r6) {
        int r0 = 0;
        if (r4 != null) goto L7;
        if (r6 == true) goto L7;
        int r7 = 8;
    L8:
        r2.setVisibility(r7);
        if (r4 == null) goto L11;
        boolean r8 = true;
    L12:
        if (r8 == true) goto L15;
        r0 = 8;
    L15:
        r3.setVisibility(r0);
        if (r4 == null) goto L25;
        r3.setImageResource(r4.intValue());
        if (r5.i == true) goto L24;
        Integer r9 = r5.d;
        if (r9 == null) goto L22;
        int r10 = r9.intValue();
    L23:
        r3.setColorFilter(r10);
        return;
    L22:
        r10 = ContextCompat.getColor(r3.getContext(), 2131103933);
        goto L23
    L24:
        r3.clearColorFilter();
        return;
    L25:
        r3.setImageDrawable(null);
        return;
    L11:
        r8 = false;
    L7:
        r7 = 0;
        goto L8
    }
}
