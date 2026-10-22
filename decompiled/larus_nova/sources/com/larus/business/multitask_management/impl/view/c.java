package com.larus.business.multitask_management.impl.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.animation.DecelerateInterpolator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f321176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f321177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f321178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f321179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedHashSet<b0> f321180e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ValueAnimator f321181f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ValueAnimator f321182g;

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f321183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f321184b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            c r101 = this.f321183a;
            String r102 = this.f321184b;
            Lazy r103 = TaskProgressMockCache.f321164a;
            r101.e(r102, TaskProgressMockCache.a(r102));
        }

        public b(c r100, String r101) {
            this.f321183a = r100;
            this.f321184b = r101;
        }
    }

    static {
    }

    public c() {
        this.f321176a = 470;
        this.f321177b = 600;
        this.f321180e = new LinkedHashSet();
    }

    public final void a(t r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (this.f321180e.contains(r100) == true) goto L6;
        this.f321180e.add(r100);
        return;
    }

    public final void d(t r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f321180e.remove(r100);
    }

    public final void e(String r100, int r101) {
        int r102 = RangesKt.coerceIn(r101, 0, 500);
        Lazy r103 = TaskProgressMockCache.f321164a;
        TaskProgressMockCache.d(r100, r102);
        if (this.f321180e.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r104 = CollectionsKt.toList(this.f321180e).iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        ((b0) r104.next()).onProgress(r102);
        goto L7
    }

    public final void b(final String r110, int r111, Long r112) {
        Intrinsics.checkNotNullParameter(r110, DBDefinition.TASK_ID);
        int r113 = RangesKt.coerceIn(r111 * 5, 0, 500);
        Lazy r100 = TaskProgressMockCache.f321164a;
        int r101 = TaskProgressMockCache.a(r110);
        int r102 = Math.max(r113, r101);
        if (r101 > 0) goto L5;
        int r103 = r102;
    L6:
        e(r110, r103);
        long r104 = 0;
        if (500 <= r113) goto L12;
        if (r112 == null) goto L11;
        r104 = r112.longValue();
    L11:
        r104 = (r104 * ((long) (500 - r102))) / ((long) (500 - r113));
    L12:
        FLogger r105 = FLogger.f375446a;
        r105.d("multitask-CappedRemainingSecondsProgressStrategy", "bind " + r110 + ", progress " + r113 + ", remainingSeconds " + r112 + ", portioned remainingSeconds " + r104 + ", cached " + r101 + ", baseline " + r102 + ", current " + r103);
        Integer r114 = this.f321178c;
        if (r114 != null) goto L16;
    L23:
        this.f321178c = Integer.valueOf(r113);
        this.f321179d = Long.valueOf(r104);
        int r115 = c(r113, Long.valueOf(r104), r102);
        ValueAnimator r116 = this.f321182g;
        if (r116 == null) goto L26;
        r116.cancel();
    L26:
        this.f321182g = null;
        if (r103 >= r102) goto L32;
        r105.d("multitask-CappedRemainingSecondsProgressStrategy", "startTransition " + r110 + ", from " + r103 + ", to " + r102);
        ValueAnimator r117 = this.f321181f;
        if (r117 == null) goto L31;
        r117.cancel();
    L31:
        ValueAnimator r118 = ValueAnimator.ofInt(new int[]{r103, r102});
        r118.setDuration(((long) RangesKt.coerceIn(Math.abs(r102 - r103), 1, 20)) * 100);
        r118.setInterpolator(new DecelerateInterpolator());
        r118.addUpdateListener(new com.larus.business.multitask_management.impl.view.a(this, r110));
        r118.addListener(new d(r110, r102, this));
        this.f321181f = r118;
        r118.start();
        return;
    L32:
        ValueAnimator r106 = this.f321181f;
        if (r106 == null) goto L35;
        r106.cancel();
    L35:
        this.f321181f = null;
        f(r110, r102, r115, Long.valueOf(r104));
        return;
    L16:
        if (r113 != r114.intValue()) goto L23;
        Long r119 = this.f321179d;
        if (r119 == null) goto L23;
        if (r104 != r119.longValue()) goto L23;
        return;
    L5:
        r103 = RangesKt.coerceIn(r101, 0, 500);
        goto L6
    }

    public final int c(int r100, Long r101, int r102) {
        if (r100 < 500) goto L5;
        return 500;
    L5:
        if (r101 != null) goto L7;
    L11:
        return r102;
    L7:
        if (r101.longValue() <= 0) goto L11;
        return Math.max(r102, RangesKt.coerceIn(this.f321176a, 0, 470));
    }

    public final void f(final String r100, int r110, int r111, Long r112) {
        FLogger.f375446a.d("multitask-CappedRemainingSecondsProgressStrategy", "startMockIfNeeded " + r100 + ", from " + r110 + ", to " + r111 + ", remainingSeconds " + r112);
        if (r110 < r111) goto L6;
        return;
    L6:
        if (r112 != null) goto L8;
    L11:
        long r101 = 0;
    L13:
        if (r101 > 0) goto L15;
        return;
    L15:
        ValueAnimator r113 = this.f321182g;
        if (r113 == null) goto L18;
        r113.cancel();
    L18:
        ValueAnimator r114 = ValueAnimator.ofInt(new int[]{r110, r111});
        r114.setDuration(r101);
        r114.setInterpolator(new DecelerateInterpolator());
        r114.addUpdateListener(new com.larus.business.multitask_management.impl.view.b(this, r100));
        r114.addListener(new b(this, r100));
        this.f321182g = r114;
        r114.start();
        return;
    L8:
        if (r112.longValue() <= 0) goto L11;
        double r102 = r112.longValue();
        r101 = RangesKt.coerceAtLeast(MathKt.roundToLong(Math.min(1.2d * r102, r102 + 10.0d) * 1000.0d), this.f321177b);
        goto L13
    }
}
