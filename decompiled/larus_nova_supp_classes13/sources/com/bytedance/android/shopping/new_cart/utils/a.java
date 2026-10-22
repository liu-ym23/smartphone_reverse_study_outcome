package com.bytedance.android.shopping.new_cart.utils;

import android.graphics.Rect;
import android.os.Looper;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.AccessibilityUtil;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final bg3.a a = null;
    public static final d b = null;
    public static final a c = null;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.new_cart.utils.a$a, reason: collision with other inner class name */
    public static final class C0129a implements com.bytedance.android.ec.core.utils.a.a {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;

        public final void a(AccessibilityNodeInfoCompat r2) {
            if (r2 == null) goto L4;
            r2.setClassName(this.a);
        L4:
            if (r2 == null) goto L6;
            r2.setContentDescription(this.b);
        L6:
            if (r2 == null) goto L9;
            r2.setHeading(this.c);
            return;
        }

        public C0129a(String r1, String r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public a() {
    }

    static {
        c = new a();
        a = new bg3.a();
        b = new d(Looper.getMainLooper());
        new Rect();
    }

    public static void f(Runnable r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        if (Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) == false) goto L5;
        r2.run();
        return;
    L5:
        b.post(r2);
    }

    public static void b(String r6, String r7) {
        Map<? extends String, ? extends Object> r0 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r6, "result");
        Intrinsics.checkNotNullParameter(r7, "newSourceType");
        Intrinsics.checkNotNullParameter(r0, "extra");
        bg3.a r2 = a;
        Map<String, ? extends Object> r8 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("operate_type", "write"), TuplesKt.to("result", r6), TuplesKt.to("new_source_type", r7), TuplesKt.to("EVENT_ORIGIN_FEATURE", "TEMAI")});
        r8.putAll(r0);
        Unit r9 = Unit.INSTANCE;
        r2.a("cart_cache_operate", r8, null, null);
    }

    @Deprecated(message = "会内存泄露，不要用了")
    public static void e(long r3, Runnable r5) {
        Intrinsics.checkNotNullParameter(r5, "action");
        if (Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) == true) goto L5;
    L7:
        b.postDelayed(r5, r3);
        return;
    L5:
        if (r3 != 0) goto L7;
        r5.run();
    }

    public final void d(String r2, Runnable r3) {
        Intrinsics.checkNotNullParameter(r2, "errorType");
        Intrinsics.checkNotNullParameter(r3, "task");
        c(null, r2, r3, null);
    }

    public static void a(String r6, String r7, String r8) {
        Map<? extends String, ? extends Object> r0 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r6, "result");
        Intrinsics.checkNotNullParameter(r7, "renderNewSourceType");
        Intrinsics.checkNotNullParameter(r8, "cachedNewSourceType");
        Intrinsics.checkNotNullParameter(r0, "extra");
        bg3.a r2 = a;
        Map<String, ? extends Object> r9 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("operate_type", "read"), TuplesKt.to("result", r6), TuplesKt.to("reader_new_source_type", r7), TuplesKt.to("cached_new_source_type", r8), TuplesKt.to("EVENT_ORIGIN_FEATURE", "TEMAI")});
        r9.putAll(r0);
        Unit r10 = Unit.INSTANCE;
        r2.a("cart_cache_operate", r9, null, null);
    }

    public static void c(CartViewModel r1, String r2, Runnable r3, Runnable r4) {
        Intrinsics.checkNotNullParameter(r2, "errorType");
        Intrinsics.checkNotNullParameter(r3, "task");
        r3.run();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        if (r4 == null) goto L8;
        r4.run();
    L8:
        if (r1 == null) goto L10;
        g(r1, r2, th.getMessage(), MapsKt.emptyMap());
        return;
    L10:
        String r5 = th.getMessage();
        if (r5 != null) goto L13;
        r5 = "";
    L13:
        j(r2, r5, null, 4);
    }

    public static void g(CartViewModel r7, String r8, String r9, Map r10) {
        Intrinsics.checkNotNullParameter(r7, "cartVM");
        Intrinsics.checkNotNullParameter(r10, "params");
        Map r3 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("error_type", r8), TuplesKt.to("error_message", r9)});
        r3.putAll(r10);
        Unit r11 = Unit.INSTANCE;
        CartViewModel.doEventAction$default(r7, "yata_cart_monitor", r3, null, 4, null);
    }

    public static void h(View r1, @AccessibilityType String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "$this$setAccessibilityInfo");
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "content");
        C0129a r0 = new C0129a(com.bytedance.android.ec.core.utils.a.b(r2), r3, r4);
        if (r1 == null) goto L7;
        ViewCompat.setAccessibilityDelegate(r1, new AccessibilityUtil.setAccessibilityDelegate.1(r0));
        return;
    }

    public static void i(String r3, String r4, Map r5, PageFinder r6) {
        Intrinsics.checkNotNullParameter(r4, "errorMessage");
        Intrinsics.checkNotNullParameter(r5, "extra");
        bg3.a r0 = a;
        Map<String, ? extends Object> r7 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("error_type", r3), TuplesKt.to("error_message", r4)});
        r7.putAll(r5);
        Unit r8 = Unit.INSTANCE;
        r0.a("yata_cart_monitor", r7, r6, null);
    }

    public static /* synthetic */ void j(String r2, String r3, PageFinder r4, int r5) {
        if ((r5 & 4) == 0) goto L5;
        Map r0 = MapsKt.emptyMap();
    L7:
        if ((r5 & 8) == 0) goto L9;
        r4 = null;
    L9:
        i(r2, r3, r0, r4);
        return;
    L5:
        r0 = null;
        goto L7
    }
}
