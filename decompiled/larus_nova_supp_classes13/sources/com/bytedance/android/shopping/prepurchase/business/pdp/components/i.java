package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import com.bytedance.android.shopping.anchorv3.compat.CompatFrameLayout;
import com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.Lifecycle;
import com.bytedance.android.shopping.service.ECAnchorV3Service;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i implements com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.d {
    public final /* synthetic */ LastPageVideoZoomer a;
    public final /* synthetic */ CompatFrameLayout b;

    public i(LastPageVideoZoomer r1, CompatFrameLayout r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.d
    public final void h0(com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e r2, Lifecycle.Event r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "event");
        switch(f.a[r3.ordinal()]) {
            case 1: goto L43;
            case 2: goto L40;
            case 3: goto L26;
            case 4: goto L23;
            case 5: goto L14;
            case 6: goto L5;
            default: goto L74;
        };
    L5:
        cf.p r4 = this.a.c();
        if (r4 == null) goto L8;
        r4.onDestroy();
    L8:
        this.a.e(this.b);
        String r5 = LastPageVideoZoomer.a(this.a);
        if (r5 == null) goto L66;
        Iterator<Function1<String, Unit>> r6 = ECAnchorV3Service.f.iterator();
    L12:
        if (r6.hasNext() == false) goto L75;
        r6.next().invoke(r5);
        goto L12
    L75:
        return;
    L66:
        return;
    L14:
        cf.p r7 = this.a.c();
        if (r7 == null) goto L17;
        r7.onStop();
    L17:
        String r8 = LastPageVideoZoomer.a(this.a);
        if (r8 == null) goto L67;
        Iterator<Function1<String, Unit>> r9 = ECAnchorV3Service.e.iterator();
    L21:
        if (r9.hasNext() == false) goto L76;
        r9.next().invoke(r8);
        goto L21
    L76:
        return;
    L67:
        return;
    L23:
        cf.p r10 = this.a.c();
        if (r10 == null) goto L68;
        r10.onPause();
        return;
    L68:
        return;
    L26:
        cf.p r11 = this.a.c();
        if (r11 == null) goto L29;
        r11.onResume();
    L29:
        LastPageVideoZoomer r12 = this.a;
        CompatFrameLayout r13 = this.b;
        if (r12.a == false) goto L32;
    L34:
        String r14 = LastPageVideoZoomer.a(this.a);
        if (r14 == null) goto L70;
        Iterator<Function1<String, Unit>> r15 = ECAnchorV3Service.d.iterator();
    L38:
        if (r15.hasNext() == false) goto L77;
        r15.next().invoke(r14);
        goto L38
    L77:
        return;
    L70:
        return;
    L32:
        if (r12.e == true) goto L34;
        r12.a = true;
        r13.post(new l(r12, r13));
        goto L34
    L40:
        cf.p r16 = this.a.c();
        if (r16 == null) goto L71;
        r16.onStart();
        return;
    L71:
        return;
    L43:
        String r17 = LastPageVideoZoomer.a(this.a);
        if (r17 == null) goto L49;
        Iterator<Function1<String, Unit>> r18 = ECAnchorV3Service.g.iterator();
    L47:
        if (r18.hasNext() == false) goto L49;
        r18.next().invoke(r17);
    L49:
        LastPageVideoZoomer r19 = this.a;
        if (r19.e == true) goto L57;
        String r20 = LastPageVideoZoomer.a(r19);
        if (r20 == null) goto L57;
        Iterator<Function1<String, Unit>> r21 = ECAnchorV3Service.c.iterator();
    L55:
        if (r21.hasNext() == false) goto L57;
        r21.next().invoke(r20);
    L57:
        cf.p r22 = this.a.c();
        if (r22 == null) goto L73;
        r22.onCreate();
        return;
    L73:
        return;
    }
}
