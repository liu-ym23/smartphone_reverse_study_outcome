package com.bytedance.android.shopping.mall.homepage.component;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.common.utility.Logger;
import com.lynx.tasm.LynxView;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMFTopBarComponent$preloadTopBar$builder$1 extends rj.a {
    public final /* synthetic */ ECMFTopBarComponent d;
    public final /* synthetic */ ViewGroup e;

    public static final class a implements View.OnLayoutChangeListener {
        public final /* synthetic */ ECMFTopBarComponent$preloadTopBar$builder$1 a;

        public a(ECMFTopBarComponent$preloadTopBar$builder$1 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            Integer r10 = Integer.valueOf(this.a.e.getHeight());
            if (r10.intValue() <= 0) goto L5;
            boolean r11 = true;
        L6:
            if (r11 == true) goto L9;
            r10 = null;
        L9:
            if (r10 == null) goto L17;
            int r12 = r10.intValue();
            Integer r13 = (Integer) this.a.d.p().j.getValue();
            if (r13 != null) goto L14;
        L15:
            this.a.d.p().j.setValue(Integer.valueOf(r12));
            return;
        L14:
            if (r13.intValue() != r12) goto L15;
            return;
        L17:
            return;
        L5:
            r11 = false;
            goto L6
        }
    }

    public final void onFirstScreen() {
        boolean r1 = false;
        View r0 = this.e.getChildAt(0);
        Integer r3 = null;
        if ((r0 instanceof LynxView) == true) goto L5;
        r0 = null;
    L5:
        LynxView r2 = (LynxView) r0;
        if (r2 == null) goto L8;
        View r4 = r2.findViewByName("search_card");
    L9:
        if (r4 == null) goto L18;
        Integer r5 = Integer.valueOf(r4.getHeight());
        if (r5.intValue() <= 0) goto L13;
        r1 = true;
    L13:
        if (r1 == false) goto L15;
        r3 = r5;
    L15:
        if (r3 == null) goto L19;
        r3.intValue();
        ECFMiddleware r6 = this.d.p();
        return;
    L19:
        return;
    L18:
        return;
    L8:
        r4 = null;
        goto L9
    }

    public final void onLoadSuccess() {
        super.onLoadSuccess();
        ECHybridExtensionsKt.f(new ECMFTopBarComponent$preloadTopBar$builder$1$onLoadSuccess$1(this));
    }

    public final void createViewDuration(long r2) {
        this.d.l = r2;
    }

    public final void onTimingSetup(Map<String, ? extends Object> r49) {
        super.onTimingSetup(r49);
        Lazy r1 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.d.b, "topbar onTimingSetup");
        this.d.d = true;
        Logger.d("ECMFTopBarComponent", "onTimingSetup, renderFinished=true, visible=" + this.d.f + " ,firstScreened=" + this.d.c);
        this.d.u(true);
        Integer r22 = null;
        if (r49 == null) goto L5;
        Object r2 = r49.get("setup_timing");
    L7:
        if ((r2 instanceof Map) == true) goto L9;
        r2 = null;
    L9:
        Map r11 = (Map) r2;
        if (r11 != null) goto L12;
        return;
    L12:
        Object r3 = r49.get("ec_session");
        if ((r3 instanceof xj.a) == true) goto L15;
        r3 = null;
    L15:
        xj.a r4 = (xj.a) r3;
        if (r4 == null) goto L18;
        r4.c.getClass();
        Long r16 = Long.valueOf(r4.a);
    L19:
        ECMFTopBarComponent r14 = this.d;
        y93.d r5 = r14.k;
        Object r7 = r11.get("draw_end");
        if ((r7 instanceof Long) == true) goto L22;
        r7 = null;
    L22:
        Long r8 = (Long) r7;
        Object r9 = r11.get("load_template_start");
        if ((r9 instanceof Long) == true) goto L25;
        r9 = null;
    L25:
        r14.k = y93.d.a(r5, null, null, 1, null, null, (Long) r9, r8, null, r49, r11, null, null, null, null, r16, null, null, 0, false, 7502235);
        this.d.p().n(this.d.k);
        ECMFTopBarComponent r6 = this.d;
        r6.k = y93.d.a(r6.k, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, true, 4194303);
        Integer r10 = Integer.valueOf(this.e.getHeight());
        if (r10.intValue() <= 0) goto L28;
        boolean r15 = true;
    L29:
        if (r15 == false) goto L31;
        r22 = r10;
    L31:
        if (r22 == null) goto L33;
        this.d.p().j.setValue(Integer.valueOf(r22.intValue()));
    L33:
        ECMFTopBarComponent r12 = this.d;
        a r13 = new a(this);
        r12.o = r13;
        this.e.addOnLayoutChangeListener(r13);
        return;
    L28:
        r15 = false;
        goto L29
    L18:
        r16 = null;
        goto L19
    L5:
        r2 = null;
        goto L7
    }

    public ECMFTopBarComponent$preloadTopBar$builder$1(ECMFTopBarComponent r1, ViewGroup r2, ECLynxCard r3) {
        this.d = r1;
        this.e = r2;
        super(r3, "TopBar");
    }

    public final void onLoadFailed(ECLynxCardErrorType r24, Integer r25, String r26) {
        Intrinsics.checkNotNullParameter(r24, "type");
        super.onLoadFailed(r24, r25, r26);
        ECHybridExtensionsKt.f(new ECMFTopBarComponent$preloadTopBar$builder$1$onLoadFailed$1(this));
        ECMFTopBarComponent r15 = this.d;
        r15.k = y93.d.a(r15.k, null, null, 0, r25, r26, null, null, null, null, null, null, null, null, null, null, null, null, 0, false, 8388579);
        this.d.p().n(this.d.k);
        ECMFTopBarComponent r1 = this.d;
        r1.k = y93.d.a(r1.k, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, true, 4194303);
    }
}
