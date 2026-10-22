package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.utils.a2;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n extends FrameLayout {
    public static final int e = 0;
    public static final int f = 0;
    public static final int g = 0;
    public static final int h = 0;
    public static final int i = 0;
    public a0 a;
    public w b;
    public w c;
    public final t d;

    public static final class a {
    }

    static {
        int r0 = com.bytedance.android.shopping.extensions.b.a(144);
        int r1 = com.bytedance.android.shopping.extensions.b.a(80);
        e = r0;
        f = r1;
        g = com.bytedance.android.shopping.extensions.b.a(12);
        int r2 = com.bytedance.android.shopping.extensions.b.a(8);
        h = r2;
        i = r0 + (r2 * 2);
    }

    public final void a() {
        if (this.d.b() == false) goto L8;
        w r0 = this.c;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("ivAudio");
    L7:
        r0.setImageResource(2131231262);
        return;
    L8:
        w r1 = this.c;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("ivAudio");
    L11:
        r1.setImageResource(2131231263);
    }

    public final void b() {
        a0 r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("videoWrapper");
    L5:
        gj.b r1 = this.d.e();
        if (r1 == null) goto L10;
        boolean r3 = true;
        if (r1.isPlaying() != true) goto L10;
    L11:
        r0.h = !r3;
        if (r3 == false) goto L17;
        View r2 = r0.e;
        if (r2 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("ivPause");
    L16:
        r2.setVisibility(8);
    L21:
        View r4 = r0.i;
        if (r4 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("shadowView");
    L24:
        r4.invalidate();
        return;
    L17:
        View r5 = r0.e;
        if (r5 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("ivPause");
    L20:
        r5.setVisibility(0);
    L10:
        r3 = false;
        goto L11
    }

    public final ViewGroup getVideoContainer() {
        a0 r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("videoWrapper");
    L6:
        return r0.getVideoContainer();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.View, com.bytedance.android.ec.core.widget.RoundedFrameLayout, com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.a0] */
    public n(Context r9, c r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "ability");
        super(r9);
        this.d = r10;
        y r11 = r10.d.j.d;
        ?? r0 = new a0(getContext(), r10);
        r0.setRadius(com.bytedance.android.shopping.extensions.b.a(12));
        this.a = r0;
        Unit r1 = Unit.INSTANCE;
        Pair<Integer, Integer> r2 = r11.g;
        if (r2 == null) goto L7;
        Integer r3 = (Integer) r2.getFirst();
        if (r3 == null) goto L7;
        int r4 = com.bytedance.android.shopping.extensions.b.a(r3);
    L8:
        Pair<Integer, Integer> r12 = r11.g;
        if (r12 == null) goto L13;
        Integer r13 = (Integer) r12.getSecond();
        if (r13 == null) goto L13;
        int r14 = com.bytedance.android.shopping.extensions.b.a(r13);
    L14:
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(r4, r14);
        int r15 = g;
        r5.leftMargin = r15;
        r5.rightMargin = r15;
        int r16 = h;
        r5.topMargin = r16;
        r5.bottomMargin = r16;
        addView(r0, r5);
        w r17 = new w(getContext());
        this.b = r17;
        int r6 = com.bytedance.android.shopping.extensions.b.a(24);
        int r7 = com.bytedance.android.shopping.extensions.b.a(24);
        int r8 = com.bytedance.android.shopping.extensions.b.a(2);
        int r18 = com.bytedance.android.shopping.extensions.b.a(10);
        ViewGroup.LayoutParams r19 = r17.a.getLayoutParams();
        ViewGroup.LayoutParams r20 = null;
        if ((r19 instanceof FrameLayout.LayoutParams) == true) goto L17;
        r19 = null;
    L17:
        FrameLayout.LayoutParams r21 = (FrameLayout.LayoutParams) r19;
        if (r21 == null) goto L20;
        r21.width = r6;
        r21.height = r7;
        r21.leftMargin = r8;
        r21.topMargin = r18;
    L20:
        FrameLayout.LayoutParams r22 = new FrameLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.a(40), com.bytedance.android.shopping.extensions.b.a(40));
        r22.gravity = 53;
        addView(r17, r22);
        w r23 = new w(getContext());
        this.c = r23;
        int r24 = com.bytedance.android.shopping.extensions.b.a(24);
        int r25 = com.bytedance.android.shopping.extensions.b.a(24);
        int r26 = com.bytedance.android.shopping.extensions.b.a(6);
        int r27 = com.bytedance.android.shopping.extensions.b.a(9);
        ViewGroup.LayoutParams r28 = r23.a.getLayoutParams();
        if ((r28 instanceof FrameLayout.LayoutParams) == false) goto L24;
        r20 = r28;
    L24:
        FrameLayout.LayoutParams r29 = (FrameLayout.LayoutParams) r20;
        if (r29 == null) goto L27;
        r29.width = r24;
        r29.height = r25;
        r29.leftMargin = r26;
        r29.topMargin = r27;
    L27:
        FrameLayout.LayoutParams r30 = new FrameLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.a(44), com.bytedance.android.shopping.extensions.b.a(44));
        r30.gravity = 85;
        addView(r23, r30);
        setOnClickListener(new o(this));
        w r31 = this.c;
        if (r31 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("ivAudio");
    L30:
        r31.setOnClickListener(new p(this));
        w r32 = this.b;
        if (r32 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("ivClose");
    L33:
        r32.setImageResource(2131231264);
        w r33 = this.b;
        if (r33 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("ivClose");
    L36:
        r33.setOnClickListener(new q(this));
        a();
        String r34 = a2.d(r10.d.j.d.d);
        if (r34 == null) goto L43;
        a0 r110 = this.a;
        if (r110 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("videoWrapper");
    L41:
        r110.getTvBottomLeft().setText(r34);
        return;
    L43:
        return;
    L13:
        r14 = e;
    L7:
        r4 = f;
        goto L8
    }
}
