package com.bytedance.android.shopping.orderlist.common.controller;

import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.android.shopping.orderlist.list.container.OrderListFragment;
import com.bytedance.android.shopping.orderlist.list.widget.linkedlist.OrderListLinkedScrollView;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.event.core.YataEventCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderBottomBarHandler {
    public static final /* synthetic */ int i = 0;
    public Disposable a;
    public boolean b;
    public boolean c;
    public gg3.b d;
    public final OrderListFragment e;
    public final AndroidYaTaInstance f;
    public final OrderListLinkedScrollView g;
    public final LinearLayout h;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ OrderBottomBarHandler a;
        public final /* synthetic */ boolean b;

        public b(OrderBottomBarHandler r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            if (this.b == false) goto L5;
            this.a.h.animate().setInterpolator(new LinearInterpolator()).setDuration(250).translationY(-this.a.h.getHeight()).start();
            return;
        L5:
            this.a.h.animate().translationY(0.0f).setDuration(250).setInterpolator(new LinearInterpolator()).start();
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void b() {
        if (this.b == true) goto L5;
        return;
    L5:
        AndroidYaTaInstance r0 = this.f;
        gg3.b r1 = null;
        if (r0 == null) goto L8;
        List r2 = r0.q(OrderBottomBarHandler$handleProtocolReload$targetNode$1.INSTANCE);
    L9:
        if (r2 == null) goto L19;
        Iterator r3 = r2.iterator();
    L12:
        if (r3.hasNext() == false) goto L19;
        com.bytedance.kmp.ec.yata.store.node.c r4 = (com.bytedance.kmp.ec.yata.store.node.c) r3.next();
        AndroidYaTaInstance r5 = this.f;
        if (r5 == null) goto L12;
        YataEventCenter r6 = r5.k();
        if (r6 == null) goto L12;
        r6.d(com.bytedance.kmp.ec.yata.event.common.e.a.a(this.f, null, r4.getKey(), "showBottomBar", null, "handleProtocolReload"));
    L19:
        if (this.d != null) goto L39;
        AndroidYaTaInstance r7 = this.f;
        if (r7 == null) goto L23;
        Object r8 = r7.i("mall_banner_show_config");
    L25:
        if ((r8 instanceof Map) == true) goto L27;
        r8 = null;
    L27:
        Map r9 = (Map) r8;
        if (r9 == null) goto L30;
        Intrinsics.checkNotNullParameter(r9, "$this$toBarShowConfig");
        r1 = new gg3.b(com.bytedance.android.shopping.extensions.k.r(String.valueOf(r9.get("not_click_times_for_shield")), 3), com.bytedance.android.shopping.extensions.k.r(String.valueOf(r9.get("shield_num_of_days")), 604800), com.bytedance.android.shopping.extensions.k.r(String.valueOf(r9.get("top_residence_size")), 500), com.bytedance.android.shopping.extensions.k.r(String.valueOf(r9.get("top_residence_time")), 3));
    L30:
        this.d = r1;
        return;
    L23:
        r8 = null;
        goto L25
    L39:
        return;
    L8:
        r2 = null;
        goto L9
    }

    public final void c() {
        OrderCommonErrorMonitorKt.c(this.e.Y90().getTracker(), "OrderBottomBarController-init", new OrderBottomBarHandler$init$1(this));
    }

    public final void a(boolean r3) {
        this.h.post(new b(this, r3));
    }

    public OrderBottomBarHandler(OrderListFragment r2, AndroidYaTaInstance r3, OrderListLinkedScrollView r4, LinearLayout r5) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r4, "listLinkedScrollView");
        Intrinsics.checkNotNullParameter(r5, "barContainer");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.c = true;
    }
}
