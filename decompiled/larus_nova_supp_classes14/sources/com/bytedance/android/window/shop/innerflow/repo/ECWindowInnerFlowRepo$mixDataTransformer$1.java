package com.bytedance.android.window.shop.innerflow.repo;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import up3.f;
import wp3.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "Lvp3/b;", "invoke", "(Ljava/lang/Object;)Lvp3/b;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ECWindowInnerFlowRepo$mixDataTransformer$1 extends FunctionReferenceImpl implements Function1<Object, vp3.b> {
    public ECWindowInnerFlowRepo$mixDataTransformer$1(a r8) {
        super(1, r8, a.class, "videoDto2Vo", "videoDto2Vo(Ljava/lang/Object;)Lcom/bytedance/android/window/shop/innerflow/entity/vo/ECWindowInnerFlowItemVO;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final vp3.b m857invoke(Object r7) {
        Intrinsics.checkNotNullParameter(r7, "p1");
        ((a) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r7, "item");
        f r8 = (f) r7;
        int r0 = r8.getType();
        boolean r1 = false;
        wp3.f r3 = null;
        g r4 = null;
        wp3.f r5 = null;
        r5 = null;
        r3 = null;
        if (r0 == 0) goto L37;
        if (r0 != 1) goto L6;
    L21:
        int r2 = vp3.f.k;
        Intrinsics.checkNotNullParameter(r8, "dto");
        vp3.f r6 = new vp3.f();
        int r9 = wp3.a.b;
        r6.h = wp3.a.b.a(r8.b());
        int r10 = g.f;
        g r11 = g.a.a(r8.l(), r8.k());
        if (r11 != null) goto L24;
        r11 = null;
    L28:
        r6.e = r11;
        int r12 = wp3.e.c;
        r6.f = wp3.e.a.a(r8);
        int r13 = wp3.b.d;
        r6.i = wp3.b.a.a(r8.c(), r8.g());
        int r14 = wp3.f.b;
        List<String> r15 = r8.h();
        if (r15 != null) goto L31;
    L36:
        r6.j = r5;
        int r16 = wp3.d.d;
        r6.g = wp3.d.a.a(r8);
        vp3.b r17 = r6;
    L54:
        return r17;
    L31:
        if ((true ^ r15.isEmpty()) == true) goto L34;
        r15 = null;
    L34:
        if (r15 == null) goto L36;
        r5 = new wp3.f(r15);
        goto L36
    L24:
        if (r6.h == null) goto L26;
        r1 = true;
    L26:
        r11.a = r1;
        Unit r18 = Unit.INSTANCE;
        goto L28
    L6:
        if (r0 != 2) goto L8;
    L14:
        int r19 = vp3.e.i;
        Intrinsics.checkNotNullParameter(r8, "dto");
        vp3.e r20 = new vp3.e();
        int r21 = wp3.a.b;
        r20.h = wp3.a.b.a(r8.b());
        int r22 = g.f;
        g r23 = g.a.a(r8.l(), r8.k());
        if (r23 != null) goto L17;
    L20:
        r20.e = r4;
        int r24 = wp3.e.c;
        r20.f = wp3.e.a.a(r8);
        int r25 = wp3.d.d;
        r20.g = wp3.d.a.a(r8);
        r17 = r20;
        goto L54
    L17:
        if (r20.h == null) goto L19;
        r1 = true;
    L19:
        r23.a = r1;
        Unit r26 = Unit.INSTANCE;
        r4 = r23;
        goto L20
    L8:
        if (r0 == 3) goto L37;
        if (r0 == 4) goto L21;
        if (r0 == 5) goto L14;
        return new com.bytedance.android.window.shop.innerflow.holder.a();
    L37:
        int r27 = vp3.c.k;
        Intrinsics.checkNotNullParameter(r8, "dto");
        vp3.c r28 = new vp3.c();
        int r29 = wp3.a.b;
        r28.h = wp3.a.b.a(r8.b());
        int r30 = g.f;
        g r31 = g.a.a(r8.l(), r8.k());
        if (r31 != null) goto L40;
        r31 = null;
    L44:
        r28.e = r31;
        int r32 = wp3.e.c;
        r28.f = wp3.e.a.a(r8);
        int r33 = wp3.b.d;
        r28.i = wp3.b.a.a(r8.c(), r8.g());
        int r34 = wp3.f.b;
        List<String> r35 = r8.h();
        if (r35 != null) goto L47;
    L52:
        r28.j = r3;
        int r36 = wp3.d.d;
        r28.g = wp3.d.a.a(r8);
        r17 = r28;
        goto L54
    L47:
        if ((true ^ r35.isEmpty()) == true) goto L50;
        r35 = null;
    L50:
        if (r35 == null) goto L52;
        r3 = new wp3.f(r35);
        goto L52
    L40:
        if (r28.h == null) goto L42;
        r1 = true;
    L42:
        r31.a = r1;
        Unit r37 = Unit.INSTANCE;
        goto L44
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return m857invoke(r1);
    }
}
