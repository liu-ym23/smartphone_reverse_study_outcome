package com.bytedance.android.livesdk.ktvimpl.mv;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.Surface;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.message.model.ed;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ss.ttvideoengine.PreloaderVidItem;
import com.ss.ttvideoengine.TTVideoEngine;
import fd2.c0;
import fd2.d0;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class MvServiceImpl implements fd2.p {
    public static final /* synthetic */ int k = 0;
    public String a;
    public final KtvMvPlayer b;
    public final KtvMvModel c;
    public final lb0.b d;
    public final MvPlayController e;
    public final com.bytedance.android.live.ktv.common.music.download.s f;
    public PreloaderVidItem g;
    public final boolean h;
    public Long i;
    public final CompositeDisposable j;

    public static final class a {
    }

    static {
    }

    public final void a() {
        KtvMvModel r0 = this.c;
        if (r0 == null) goto L6;
        r0.e();
        return;
    }

    public final int getPlayState() {
        return this.e.b;
    }

    public final void release() {
        this.c.e();
        this.j.dispose();
        MvPlayController r0 = this.e;
        r0.l.release();
        r0.b = 0;
        b r1 = r0.n;
        ValueAnimator r2 = r1.c;
        if (r2 == null) goto L5;
        r2.end();
    L5:
        ValueAnimator r3 = r1.d;
        if (r3 == null) goto L9;
        r3.end();
        return;
    }

    public final lb0.b b() {
        return this.d;
    }

    public final void c(Surface r2) {
        this.b.setSurface(r2);
    }

    public final c0 d(d0 r10) {
        Intrinsics.checkNotNullParameter(r10, "param");
        l r11 = this.c.b(new y(r10.a, r10.b, r10.c, r10.d, Integer.valueOf(r10.e)));
        if (r11 != null) goto L6;
        return null;
    L6:
        String r0 = this.a;
        if (r0 == null) goto L10;
        int r1 = com.bytedance.android.live.ktv.common.music.download.s.a;
        String r2 = com.bytedance.android.live.ktv.common.music.download.s.a.a(r11.d, r0);
        if (r2 == null) goto L10;
    L11:
        String r4 = r2;
        String r3 = r11.d;
        List<ed> r5 = r11.h;
        Integer r12 = r11.a;
        if (r12 == null) goto L14;
        long r6 = r12.intValue();
    L16:
        return new c0(r3, r5, r4, r6);
    L14:
        r6 = 0;
    L10:
        r2 = r11.b;
        goto L11
    }

    public final void e(int r3) {
        ALogger.i("MvServiceImpl", "sendPlayCmd:" + r3);
        if (r3 != 0) goto L5;
        this.e.c();
        return;
    L5:
        if (r3 != 1) goto L7;
        MvPlayController r4 = this.e;
        if (r4.a == false) goto L22;
        r4.l.r();
        r4.b = 1;
        return;
    L22:
        return;
    L7:
        if (r3 != 2) goto L24;
        MvPlayController r5 = this.e;
        r5.l.stop();
        r5.b = 0;
        b r6 = r5.n;
        ValueAnimator r0 = r6.c;
        if (r0 == null) goto L12;
        r0.end();
    L12:
        ValueAnimator r7 = r6.d;
        if (r7 == null) goto L20;
        r7.end();
        return;
    L20:
        return;
    }

    public final void f(d0 r10) {
        Intrinsics.checkNotNullParameter(r10, "param");
        ALogger.i("MvServiceImpl", "fetchPlay:" + r10);
        l r0 = this.c.b(new y(r10.a, r10.b, r10.c, r10.d, Integer.valueOf(r10.e)));
        if (r0 == null) goto L15;
        String r1 = r0.c;
        if (r10.e != 2) goto L14;
        if (r1 != null) goto L8;
    L11:
        boolean r11 = true;
    L12:
        if (r11 == true) goto L14;
        MvPlayController r12 = this.e;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r1, "url");
        r12.l.q(new t(r1, null, null, 14));
        r12.b = 1;
        return;
    L8:
        if (r1.length() == 0) goto L11;
        r11 = false;
    L14:
        MvPlayController r13 = this.e;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r0, LocationMonitorConst.INFO);
        MvPlayController.e(r13, r0, true, null, 2);
        return;
    L15:
        MvPlayController r2 = this.e;
        y r8 = new y(r10.a, r10.b, r10.c, r10.d, Integer.valueOf(r10.e));
        r2.getClass();
        Intrinsics.checkNotNullParameter(r8, "songMvParam");
        if (r8.f != null) goto L18;
        r8.f = r2.o;
    L18:
        r2.m.c(r8, new MvPlayController$fetchAndPlay$1(r2));
    }

    public MvServiceImpl(Long r8, int r9) {
        Context r0 = jc1.a.b();
        if (r0 != null) goto L7;
        r0 = com.bytedance.android.live.core.utils.a.d();
        if (r0 != null) goto L7;
        r0 = jc1.a.b();
    L7:
        KtvMvPlayer r1 = new KtvMvPlayer(r0, null);
        this.b = r1;
        KtvMvModel r2 = new KtvMvModel(r8, null);
        this.c = r2;
        lb0.b r10 = new lb0.b();
        this.d = r10;
        this.e = new MvPlayController(r1, r2, new b(r10), Integer.valueOf(r9), null);
        this.f = new com.bytedance.android.live.ktv.common.music.download.s();
        this.h = ((Boolean) vm2.h.p3.getValue(null, vm2.h.a[222(0xde, float:3.11E-43)])).booleanValue();
        this.j = new CompositeDisposable();
    }

    public final void g(d0 r10, Long r11, fd2.o r12) {
        Intrinsics.checkNotNullParameter(r10, "param");
        PreloaderVidItem r0 = this.g;
        if (r0 == null) goto L5;
        String r1 = r0.mVideoId;
    L6:
        if (r1 == null) goto L8;
        this.b.getClass();
        Intrinsics.checkNotNullParameter(r1, "vId");
        TTVideoEngine.cancelPreloadTaskByVideoId(r1);
    L8:
        com.bytedance.android.live.ktv.common.util.g.d("prefechMvInfo:" + r10);
        this.c.c(new y(r10.a, r10.b, r10.c, r10.d, Integer.valueOf(r10.e)), new MvServiceImpl$prefechMvInfo$1(this, r12, r10, r11));
        return;
    L5:
        r1 = null;
        goto L6
    }
}
