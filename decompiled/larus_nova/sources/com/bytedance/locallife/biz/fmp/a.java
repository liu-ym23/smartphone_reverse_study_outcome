package com.bytedance.locallife.biz.fmp;

import android.os.SystemClock;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.ies.ugc.aweme.fmp.core.FmpCalculator;
import com.bytedance.ies.ugc.aweme.fmp.core.FmpCalculator$onLayoutListener$1;
import com.bytedance.ies.ugc.aweme.fmp.core.FmpCallback;
import com.bytedance.ies.ugc.aweme.fmp.core.diff.DiffCalMode;
import com.bytedance.locallife.biz.experiment.FmpWindowCallbackExperiment;
import com.larus.nova.R;
import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f256694b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FmpCalculator f256695a;

    /* JADX INFO: renamed from: com.bytedance.locallife.biz.fmp.a$a, reason: collision with other inner class name */
    public static final class C3645a {
    }

    static {
        Lazy<Field> r100 = FmpCalculator.Z;
        f256694b = R.id.fmp_invalid_view_mark;
    }

    public final void a() {
        final FmpCalculator r100 = this.f256695a;
        r100.f248865q = true;
        r100.f248860l = true;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        r100.j(true);     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L8:
        if (Result.m9452exceptionOrNullimpl(r102) == null) goto L14;
        FmpCalculator.a(r100.f248850b).post(new com.bytedance.ies.ugc.aweme.fmp.core.c(r100));
        return;
    L14:
        return;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final void c() {
        FmpCalculator r100 = this.f256695a;
        FmpCalculator.e r101 = r100.T;
        r100.Q.add(r101);
        ViewTreeObserver r102 = r100.f248849a.getViewTreeObserver();
        if (r102 == null) goto L10;
        FmpCalculator$onLayoutListener$1 r103 = r100.U;
        monitor-enter(r103);
        r102.removeOnGlobalLayoutListener(r100.U);     // Catch: Throwable -> L22
        r102.addOnGlobalLayoutListener(r100.U);     // Catch: Throwable -> L22
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r103);
    L22:
        th = move-exception;
        throw th;
    L10:
        if (r100.f248858j == false) goto L16;
        Window r105 = r100.f248850b;
        SparseArray<FmpCalculator.c> r106 = FmpCalculator.f248847b0;
        FmpCalculator.c r107 = r106.get(r105.hashCode());
        if (r107 != null) goto L15;
        r107 = new FmpCalculator.c(r105.hashCode(), r105.getCallback());
        r106.put(r105.hashCode(), r107);
        r105.setCallback(r107);
    L15:
        Intrinsics.checkNotNullParameter(r100, "fmpCalculator");
        r107.f248880c.add(r100);
        r100.f248861m = r107;
    L20:
        r100.N = true;
        return;
    L16:
        Window.Callback r108 = r100.f248850b.getCallback();
        if (Intrinsics.areEqual(r108, r100.f248861m) == true) goto L20;
        FmpCalculator.c r109 = new FmpCalculator.c(r100.f248850b.hashCode(), r108);
        Intrinsics.checkNotNullParameter(r100, "fmpCalculator");
        r109.f248880c.add(r100);
        r100.f248861m = r109;
        r100.f248850b.setCallback(r109);
        goto L20
    }

    public final void d() {
        this.f256695a.t();
    }

    public final void b(FmpCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "fmpCallback");
        FmpCalculator r101 = this.f256695a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "fmpCallback");
        r101.f248868t = r100;
    }

    public a(String r210, View r211, Window r212, long r213, float r214, boolean r215, DiffCalMode r216, boolean r217, com.bytedance.ies.ugc.aweme.fmp.core.b r218, int r310) {
        if ((r310 & 8) == 0) goto L5;
        long r100 = SystemClock.elapsedRealtime();
    L7:
        if ((r310 & 16) == 0) goto L9;
        int r101 = 50;
    L11:
        if ((r310 & 32) == 0) goto L13;
        float r110 = 1.0f;
    L15:
        if ((r310 & 64) == 0) goto L17;
        long r102 = KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL;
    L18:
        long r111 = r102;
        if ((r310 & 128) == 0) goto L21;
        boolean r112 = false;
    L23:
        if ((r310 & 256) == 0) goto L25;
        int r113 = 800;
    L27:
        if ((r310 & 512) == 0) goto L29;
        DiffCalMode r103 = DiffCalMode.CLOSE;
    L31:
        if ((r310 & 1024) == 0) goto L33;
        boolean r114 = false;
    L35:
        if ((r310 & 2048) == 0) goto L37;
        com.bytedance.ies.ugc.aweme.fmp.core.b r115 = null;
    L38:
        Intrinsics.checkNotNullParameter(r210, "page");
        Intrinsics.checkNotNullParameter(r211, "mLayout");
        Intrinsics.checkNotNullParameter(r212, LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNullParameter(r103, "calDiffMode");
        this.f256695a = new FmpCalculator(r210, r211, r212, r100, r101, r110, r111, r112, r113, r114, r103, ((Boolean) FmpWindowCallbackExperiment.f256642a.getValue()).booleanValue(), r115);
        return;
    L37:
        r115 = r218;
        goto L38
    L33:
        r114 = r217;
        goto L35
    L29:
        r103 = r216;
        goto L31
    L25:
        r113 = 0;
        goto L27
    L21:
        r112 = r215;
        goto L23
    L17:
        r102 = 0;
        goto L18
    L13:
        r110 = r214;
        goto L15
    L9:
        r101 = 0;
        goto L11
    L5:
        r100 = r213;
        goto L7
    }
}
