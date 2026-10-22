package com.bytedance.android.shopping.buynow.controller;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.event.core.YataEventCenter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BuyNowElevatorGuideController {
    public boolean a;
    public final View b;
    public final BuyNowViewModel c;
    public final AndroidYaTaInstance d;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/buynow/controller/BuyNowElevatorGuideController$StrategyAppear;", "", "", "strategy", "Ljava/lang/String;", "getStrategy", "()Ljava/lang/String;", "TARGET_INVISIBLE", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum StrategyAppear extends Enum<StrategyAppear> {
        public static final StrategyAppear TARGET_INVISIBLE = null;
        public static final /* synthetic */ StrategyAppear[] a = null;
        private final String strategy;

        static {
            StrategyAppear r1 = new StrategyAppear();
            TARGET_INVISIBLE = r1;
            a = new StrategyAppear[]{r1};
        }

        public static StrategyAppear valueOf(String r1) {
            return (StrategyAppear) r27.a.a(StrategyAppear.class, r1);
        }

        public static StrategyAppear[] values() {
            return (StrategyAppear[]) a.clone();
        }

        public StrategyAppear() {
            super("TARGET_INVISIBLE", 0);
            this.strategy = "target_invisible";
        }

        public final String getStrategy() {
            return this.strategy;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/buynow/controller/BuyNowElevatorGuideController$StrategyDisappear;", "", "", "strategy", "Ljava/lang/String;", "getStrategy", "()Ljava/lang/String;", "SCROLL", "TARGET_SHOW", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum StrategyDisappear extends Enum<StrategyDisappear> {
        public static final StrategyDisappear SCROLL = null;
        public static final StrategyDisappear TARGET_SHOW = null;
        public static final /* synthetic */ StrategyDisappear[] a = null;
        private final String strategy;

        static {
            StrategyDisappear r1 = new StrategyDisappear("SCROLL", 0, "scroll");
            SCROLL = r1;
            StrategyDisappear r2 = new StrategyDisappear("TARGET_SHOW", 1, "target_show");
            TARGET_SHOW = r2;
            a = new StrategyDisappear[]{r1, r2};
        }

        public static StrategyDisappear valueOf(String r1) {
            return (StrategyDisappear) r27.a.a(StrategyDisappear.class, r1);
        }

        public static StrategyDisappear[] values() {
            return (StrategyDisappear[]) a.clone();
        }

        public final String getStrategy() {
            return this.strategy;
        }

        public StrategyDisappear(String r1, int r2, String r3) {
            super(r1, r2);
            this.strategy = r3;
        }
    }

    public static final class a {
    }

    static {
    }

    public final com.bytedance.kmp.ec.yata.store.node.c b() {
        AndroidYaTaInstance r0 = this.c.getYataInstance();
        if (r0 == null) goto L5;
        Object r1 = r0.i("guide_elevator");
    L7:
        if ((r1 instanceof Map) == true) goto L9;
        r1 = null;
    L9:
        Map r2 = (Map) r1;
        if (r2 == null) goto L12;
        Object r3 = r2.get("target_component_name");
    L14:
        if ((r3 instanceof String) == true) goto L16;
        r3 = null;
    L16:
        String r4 = (String) r3;
        if (r2 == null) goto L19;
        Object r5 = r2.get("target_yata_key");
    L21:
        if ((r5 instanceof String) == true) goto L23;
        r5 = null;
    L23:
        String r6 = (String) r5;
        boolean r7 = true;
        if (r2 != null) goto L26;
    L29:
        boolean r8 = true;
    L30:
        if (r8 == true) goto L49;
        if (r4 != null) goto L33;
    L36:
        boolean r9 = true;
    L37:
        if (r9 == true) goto L49;
        if (r6 != null) goto L40;
    L43:
        if (r7 == true) goto L49;
        com.bytedance.kmp.ec.yata.store.node.c r10 = com.bytedance.android.shopping.buynow.utils.h.a(this.c.getYataInstance(), r4, r6);
        if (r10 != null) goto L48;
        com.bytedance.android.shopping.buynow.monitor.error.a.b(this.c.getTracker(), "yata_error", "elevator_render_object is null");
    L48:
        return r10;
    L40:
        if (r6.length() == 0) goto L43;
        r7 = false;
        goto L43
    L33:
        if (r4.length() == 0) goto L36;
        r9 = false;
    L49:
        return null;
    L26:
        if (r2.isEmpty() == true) goto L29;
        r8 = false;
        goto L30
    L19:
        r5 = null;
        goto L21
    L12:
        r3 = null;
        goto L14
    L5:
        r1 = null;
        goto L7
    }

    public static double a(RecyclerView r7, View r8) {
        if (r8 != null) goto L5;
        return 0.0d;
    L5:
        if (r8.getVisibility() != 0) goto L22;
        Rect r2 = new Rect();
        if (r7.getGlobalVisibleRect(r2) == true) goto L10;
        return 0.0d;
    L10:
        Rect r9 = new Rect();
        if (r8.getGlobalVisibleRect(r9) == true) goto L13;
        return 0.0d;
    L13:
        Rect r3 = new Rect();
        if (r3.setIntersect(r2, r9) == true) goto L16;
        return 0.0d;
    L16:
        double r4 = r3.height();
        double r10 = r8.getHeight();
        if (r10 > 0) goto L19;
        return 0.0d;
    L19:
        return r4 / r10;
    L22:
        return 0.0d;
    }

    public BuyNowElevatorGuideController(View r2, BuyNowViewModel r3, AndroidYaTaInstance r4) {
        Intrinsics.checkNotNullParameter(r2, "elevatorGuideContainer");
        Intrinsics.checkNotNullParameter(r3, "buyNowViewModel");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.a = true;
    }

    public final void c(com.bytedance.kmp.ec.yata.store.node.c r8, String r9, String r10) {
        String r3 = r8.getKey();
        if (r3 != null) goto L6;
        return;
    L6:
        if (StringsKt.isBlank(r3) == false) goto L8;
        return;
    L8:
        com.bytedance.kmp.ec.yata.common.protocol.data.p r11 = r8.b.b;
        Object r0 = null;
        if (r11 == null) goto L12;
        Object r12 = com.bytedance.kmp.ec.yata.common.protocol.data.q.b(r11, Reflection.getOrCreateKotlinClass(Object.class), r9);
        if ((r12 instanceof Object) == false) goto L12;
    L13:
        if (r12 != null) goto L16;
        return;
    L16:
        if ((r12 instanceof String) == false) goto L19;
        r0 = r12;
    L19:
        String r4 = (String) r0;
        if (r4 != null) goto L23;
        return;
    L23:
        if (StringsKt.isBlank(r4) == false) goto L25;
        return;
    L25:
        AndroidYaTaInstance r13 = this.d;
        if (r13 == null) goto L31;
        YataEventCenter r14 = r13.k();
        if (r14 == null) goto L32;
        r14.d(com.bytedance.kmp.ec.yata.event.common.e.a.a(this.d, null, r3, r4, null, r10));
        return;
    L32:
        return;
    L31:
        return;
    L12:
        r12 = null;
        goto L13
    }
}
