package com.bytedance.android.livesdk.livecommerce.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class UtilityKotlinExtentionsKt {
    public static final Lazy a = null;
    public static final Handler b = null;

    public static final class a implements com.bytedance.android.ec.opt.asynctask.w {
        public final /* synthetic */ Function0 a;

        public final com.bytedance.android.ec.opt.asynctask.k r() {
            com.bytedance.android.ec.opt.asynctask.r r0 = new com.bytedance.android.ec.opt.asynctask.r();
            r0.b = true;
            return r0.f;
        }

        public final void run() {
            this.a.invoke();
        }

        public a(Function0 r1) {
            this.a = r1;
        }
    }

    static {
        a = LazyKt.lazy(UtilityKotlinExtentionsKt$CACHE_DENSITY$2.INSTANCE);
        b = new Handler(Looper.getMainLooper());
    }

    public static final int b(Number r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$ceilDp");
        return (int) Math.ceil(c(r2));
    }

    public static final float c(Number r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$dp");
        com.bytedance.android.ec.core.opt.ab.d.a();
        if (ECLiveABUtils.INSTANCE.getLIST_FPS_OPT_CONFIG().getEnableCacheDensity() == false) goto L5;
        float r0 = ((Number) a.getValue()).floatValue();
    L7:
        return (r0 * r2.floatValue()) + 0.5f;
    L5:
        Resources r1 = Resources.getSystem();
        r0 = WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).density;
        goto L7
    }

    public static final int d(Number r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$dpInt");
        return (int) c(r1);
    }

    public static final boolean e(TextView r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$isTextEllipsis");
        Layout r4 = r3.getLayout();
        if (r4 != null) goto L6;
        return false;
    L6:
        if (r4.getLineCount() > 0) goto L9;
        return false;
    L9:
        if (r4.getEllipsisCount(r4.getLineCount() - 1) <= 0) goto L12;
        return true;
    L12:
        return false;
    }

    public static final void i(Function0<Unit> r1) {
        Intrinsics.checkNotNullParameter(r1, "action");
        com.bytedance.android.ec.opt.asynctask.t.b(new a(r1));
    }

    public static final void h(Object r1, Function0 r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        if (r1 != null) goto L6;
        r2.invoke();
        return;
    }

    public static final float a(int r1, Context r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Resources r4 = r2.getResources();
        DisplayMetrics r5 = WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics());
        com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        com.bytedance.android.ec.core.opt.ab.d.a();
        int r6 = r5.widthPixels;
        float r7 = r5.density;
        if (r7 <= 0) goto L5;
        float r8 = r6 / r7;
    L7:
        return c(Float.valueOf(r1 * (r8 / 375.0f)));
    L5:
        r8 = 0.0f;
        goto L7
    }

    public static final <T1, T2, R> R f(T1 r1, T2 r2, Function2<? super T1, ? super T2, ? extends R> r3) {
        Intrinsics.checkNotNullParameter(r3, "block");
        if (r1 == null) goto L6;
        if (r2 == null) goto L6;
        return (R) r3.invoke(r1, r2);
    L6:
        return null;
    }

    public static void j(long r2, Function0 r4, int r5) {
        if ((r5 & 1) == 0) goto L5;
        r2 = 0;
    L5:
        Intrinsics.checkNotNullParameter(r4, "action");
        if (r2 <= 0) goto L8;
        b.postDelayed(new c1(r4), r2);
        return;
    L8:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L10;
        r4.invoke();
        return;
    L10:
        b.post(new c1(r4));
    }

    public static final void g(Object r1, Object r2, Object r3, Function3 r4) {
        Intrinsics.checkNotNullParameter(r4, "block");
        if (r1 == null) goto L8;
        if (r2 == null) goto L9;
        if (r3 == null) goto L10;
        r4.invoke(r1, r2, r3);
        return;
    L10:
        return;
    L9:
        return;
    }
}
