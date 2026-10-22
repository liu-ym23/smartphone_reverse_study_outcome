package com.bytedance.ug.sdk.luckydog.task.newTimer;

import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ug.sdk.luckydog.task.newTimer.network.LuckyTimerReportWrapper;
import com.bytedance.ug.sdk.luckyhost.api.api.timer.LuckyTimerStatus;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import java.util.Iterator;
import kotlin.TypeCastException;
import ym7.h;
import zm7.q;

/* JADX INFO: loaded from: classes22.dex */
public final class g implements zm7.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f272046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LuckyTimerReportWrapper f272047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ dm7.a f272048c;

    @Override // zm7.f
    public final void a(float r100) {
        LuckyTimerReportWrapper r101 = this.f272047b;
        float r102 = 0.0f;
        if (r100 != 0.0f) goto L5;
    L42:
        float r103 = r101.f272052d;
    L43:
        com.bytedance.ug.sdk.luckydog.task.newTimer.pendant.d r104 = this.f272046a.f272041b;
        if (r104 == null) goto L51;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyPendantHelper", "updateTimerProgress() 更新计时进度，1秒调用一次; progressS " + r103);
        if (r104.f272130g == false) goto L48;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyPendantHelper", "updateTimerProgress() 已经销毁释放了");
        goto L51
    L48:
        h r105 = r104.f272124a;
        if (r105 == null) goto L51;
        r105.c(r103);
    L51:
        ((zm7.d) wm7.g.a(zm7.d.class)).b(r100);
        Iterator<zm7.g> r106 = this.f272048c.f469222b.iterator();
    L53:
        if (r106.hasNext() == false) goto L55;
        r106.next().a();
        goto L53
    L55:
        return;
    L5:
        if (r101.f272065q.d() == null) goto L42;
        r101.f272050b += r100;
        r101.f272059k += r100;
        q r107 = r101.f272065q.d();
        if (r107 == null) goto L41;
        if (r107.f() == (-1)) goto L16;
        if (r101.f272052d < r107.f()) goto L14;
        r101.f272054f = true;
    L20:
        if (r101.f272059k < r107.e()) goto L23;
        r101.f272059k = 0.0f;
        LuckyTimerReportWrapper.o(r101, r101.f272050b, false, VideoThumbInfo.KEY_INTERVAL);
    L23:
        if (r101.f272053e.peek() == null) goto L31;
        float r108 = r101.f272052d;
        Integer r109 = r101.f272053e.peek();
        if (r109 == null) goto L28;
        r102 = r109.intValue();
    L28:
        if (r108 < r102) goto L31;
        LuckyTimerReportWrapper.o(r101, r101.f272050b, false, "millsTsReport");
        r101.f272053e.poll();
    L31:
        if (r101.f272055g == false) goto L33;
    L56:
        r101.n(r100);     // Catch: Throwable -> L37
    L39:
        r103 = r101.f272052d;
    L37:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b(r101.f272049a, "incrTsCache error: " + th);
        goto L39
    L33:
        if (r101.f272054f == false) goto L56;
        LuckyTimerReportWrapper.o(r101, r101.f272050b, true, BitableAnalytic.SelectSceneClickType.COMPLETE);
        r101.f272055g = true;
        goto L56
    L14:
        r101.f272054f = false;
        r101.f272052d += r100;
        goto L20
    L16:
        if (r101.f272065q.a() == false) goto L18;
        r101.f272054f = true;
        goto L20
    L18:
        r101.f272052d += r100;
        goto L20
    L41:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.ug.sdk.luckyhost.api.api.timer.TimerConfig");
    }

    @Override // zm7.f
    public final void b(LuckyTimerStatus r100) {
        com.bytedance.ug.sdk.luckydog.task.newTimer.pendant.d r101 = this.f272046a.f272041b;
        if (r101 == null) goto L5;
        r101.c(r100);
    L5:
        this.f272048c.c(r100);
    }

    public g(f r100, LuckyTimerReportWrapper r101, dm7.a r102) {
        this.f272046a = r100;
        this.f272047b = r101;
        this.f272048c = r102;
    }
}
