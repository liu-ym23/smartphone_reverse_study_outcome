package com.ss.android.lark.flow.passport.ui.widget.common;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Application;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import uzb.l;

/* JADX INFO: loaded from: classes36.dex */
public final class h extends GradientDrawable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final float f423849e = 0.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f423850f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Map<g, Integer> f423851g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f423852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f423853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f423854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<g, Integer> f423855d;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f423856a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f423857b;

        public b(h r100, int r101) {
            this.f423856a = r100;
            this.f423857b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            h r101 = this.f423856a;
            int r102 = this.f423857b;
            Object r103 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Int");
            r101.setStroke(r102, ((Integer) r103).intValue());
        }
    }

    static {
        if (com.ss.android.lark.passport.a.b() == false) goto L5;
        float r100 = 30.0f;
    L6:
        f423849e = r100;
        f423850f = R.color.udtoken_component_outlined_bg;
        int r101 = 0;
        g[] r102 = {g.f423843a, g.f423844b, g.f423845c};
        LinkedHashMap r103 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(3), 16));
    L7:
        if (r101 >= 3) goto L9;
        g r104 = r102[r101];
        r103.put(r104, Integer.valueOf(r104.a()));
        r101 = r101 + 1;
        goto L7
    L9:
        f423851g = r103;
        return;
    L5:
        r100 = 6.0f;
        goto L6
    }

    public final ValueAnimator c(g r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Map<g, Integer> r101 = this.f423855d;
        Integer r102 = r101.get(r100);
        if (r102 != null) goto L5;
        r102 = Integer.valueOf(UDColorUtils.getColor(this.f423852a, r100.a()));
        r101.put(r100, r102);
    L5:
        int r103 = r102.intValue();
        ValueAnimator r104 = b(l.a(LarkContext.getApplication(), 1.0f), r103);
        this.f423853b = r100;
        return r104;
    }

    public final void a(g r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Integer r102 = Integer.valueOf(r101);
        this.f423855d.put(r100, r102);
    }

    public final ValueAnimator b(int r100, int r101) {
        Map<g, Integer> r102 = this.f423855d;
        g r103 = this.f423853b;
        Integer r104 = r102.get(r103);
        if (r104 != null) goto L5;
        r104 = Integer.valueOf(UDColorUtils.getColor(this.f423852a, this.f423853b.a()));
        r102.put(r103, r104);
    L5:
        int r105 = r104.intValue();
        ValueAnimator r106 = this.f423854c;
        if (r106 != null) goto L19;
    L17:
        ValueAnimator r107 = ValueAnimator.ofInt(new int[]{r105, r101});
        r107.setDuration(300);
        r107.setInterpolator(PathInterpolatorCompat.create(0.32f, 0.94f, 0.6f, 1.0f));
        r107.setEvaluator(new ArgbEvaluator());
        r107.addUpdateListener(new b(this, r100));
        r107.start();
        this.f423854c = r107;
        Intrinsics.checkNotNull(r107);
        return r107;
    L19:
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L10
        Object r109 = r106.getAnimatedValue();     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type kotlin.Int");     // Catch: Throwable -> L10
        Object r110 = Result.m9449constructorimpl(Integer.valueOf(((Integer) r109).intValue()));     // Catch: Throwable -> L10
    L13:
        if (Result.m9452exceptionOrNullimpl(r110) == null) goto L16;
        r110 = Integer.valueOf(r105);
    L16:
        r105 = ((Number) r110).intValue();
    L10:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public h(Context r100, float r101, int r102) {
        if ((r102 & 2) == 0) goto L6;
        r101 = f423849e;
    L6:
        if ((r102 & 4) == 0) goto L8;
        g.c r103 = g.f423843a;
    L9:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "initState");
        this.f423852a = r100;
        this.f423853b = r103;
        Map<g, Integer> r104 = f423851g;
        LinkedHashMap r105 = new LinkedHashMap(MapsKt.mapCapacity(r104.size()));
        Iterator r106 = ((LinkedHashMap) r104).entrySet().iterator();
    L11:
        if (r106.hasNext() == false) goto L13;
        Map.Entry r107 = (Map.Entry) r106.next();
        r105.put(r107.getKey(), Integer.valueOf(UDColorUtils.getColor(this.f423852a, ((Number) r107.getValue()).intValue())));
        goto L11
    L13:
        Map<g, Integer> r108 = MapsKt.toMutableMap(r105);
        this.f423855d = r108;
        Context r109 = this.f423852a;
        if ((r109 instanceof Application) == false) goto L18;
        int r110 = com.ss.android.lark.officesdk.utils.di.e.f437221a;
        if (com.ss.android.lark.officesdk.utils.di.e.a.b(r109) == false) goto L18;
        UDToast.show(this.f423852a, "InputBgUtils.setStrokeColor(), don't use application context");
    L18:
        Integer r111 = r108.get(r103);
        if (r111 != null) goto L21;
        r111 = Integer.valueOf(UDColorUtils.getColor(this.f423852a, r103.f423848d));
        r108.put(r103, r111);
    L21:
        setStroke(l.a(this.f423852a, 1.0f), r111.intValue());
        setColor(UDColorUtils.getColor(this.f423852a, f423850f));
        setCornerRadius(l.a(this.f423852a, r101));
        return;
    L8:
        r103 = null;
        goto L9
    }
}
