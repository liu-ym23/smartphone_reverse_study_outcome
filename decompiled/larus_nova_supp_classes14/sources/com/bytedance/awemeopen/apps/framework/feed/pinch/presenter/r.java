package com.bytedance.awemeopen.apps.framework.feed.pinch.presenter;

import android.view.View;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class r implements com.bytedance.awemeopen.apps.framework.feed.pinch.utils.b.a {
    public final /* synthetic */ u a;

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.utils.b.a
    public final void a() {
        this.a.a.a();
        u.a(this.a);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.utils.b.a
    public final void b() {
        this.a.a.b();
        u r0 = this.a;
        if (r0.u == false) goto L7;
        View r1 = r0.c;
        if (r1 == null) goto L7;
        r0.c(r1);
    L7:
        u r2 = this.a;
        r2.w = r2.o;
        View r3 = r2.c;
        float r4 = 0.0f;
        if (r3 == null) goto L10;
        float r5 = r3.getPivotX();
    L11:
        r2.x = r5;
        u r6 = this.a;
        View r7 = r6.c;
        if (r7 == null) goto L14;
        r4 = r7.getPivotY();
    L14:
        r6.y = r4;
        return;
    L10:
        r5 = 0.0f;
        goto L11
    }

    public r(u r1) {
        this.a = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.utils.b.a
    public final boolean c(com.bytedance.awemeopen.apps.framework.feed.pinch.utils.b r11) {
        u r0 = this.a;
        if (r0.c == null) goto L44;
        float r1 = r0.p;
        int r5 = 0;
        if (r11.a() == false) goto L21;
        boolean r3 = r11.p;
        if (r3 == true) goto L9;
    L10:
        if (r3 == false) goto L12;
    L14:
        boolean r4 = false;
    L15:
        float r8 = Math.abs(1.0f - (r11.f / r11.g)) * 0.5f;
        if (r11.g <= 0.0f) goto L24;
        if (r4 == false) goto L20;
        float r9 = r8 + 1.0f;
    L25:
        float r2 = r1 * r9;
        r0.p = r2;
        if (r2 >= 0.5f) goto L28;
        r2 = (((r2 * r2) * 0.5f) + (r2 * 0.15f)) + 0.3f;
    L28:
        r0.o = r2;
        float r6 = Math.min(r2, 999.0f);
        r0.o = r6;
        float r7 = Math.max(r6, 0.3f);
        r0.o = r7;
        r0.q = Math.max(r0.q, r7);
        r0.r = Math.min(r0.r, r0.o);
        float r10 = r11.b;
        float r12 = r11.c;
        View r13 = r0.c;
        if (r13 == null) goto L43;
        r13.setScaleX(r0.o);
        r13.setScaleY(r0.o);
        if (r0.u == true) goto L33;
    L35:
        r13.setPivotX(((r10 - r13.getTranslationX()) + r0.h) - r13.getLeft());
        float r14 = ((r12 - r13.getTranslationY()) + r0.i) - r13.getTop();
        Function0<Integer> r15 = r0.v;
        if (r15 == null) goto L38;
        Integer r16 = (Integer) r15.invoke();
    L39:
        if (r16 == null) goto L42;
        r5 = r16.intValue();
    L42:
        r13.setPivotY(r14 + r5);
        goto L43
    L38:
        r16 = null;
        goto L39
    L33:
        if (r0.o <= 1.0f) goto L35;
        float r17 = 1;
        r13.setPivotX(((((((((r0.x * (r0.w - r17)) + r10) - r13.getTranslationX()) - r13.getLeft()) * (r0.o / r0.w)) - r10) + r13.getTranslationX()) + r13.getLeft()) / (r0.o - r17));
        r13.setPivotY(((((((((r0.y * (r0.w - r17)) + r12) - r13.getTranslationY()) - r13.getTop()) * (r0.o / r0.w)) - r12) + r13.getTranslationY()) + r13.getTop()) / (r0.o - r17));
        r0.w = r0.o;
        r0.x = r13.getPivotX();
        r0.y = r13.getPivotY();
    L43:
        r0.a.m();
        goto L44
    L20:
        r9 = 1.0f - r8;
    L24:
        r9 = 1.0f;
        goto L25
    L12:
        if (r11.f <= r11.g) goto L14;
    L13:
        r4 = true;
        goto L15
    L9:
        if (r11.f < r11.g) goto L13;
    L21:
        float r18 = r11.g;
        if (r18 <= 0.0f) goto L24;
        r9 = r11.f / r18;
    L44:
        return true;
    }
}
