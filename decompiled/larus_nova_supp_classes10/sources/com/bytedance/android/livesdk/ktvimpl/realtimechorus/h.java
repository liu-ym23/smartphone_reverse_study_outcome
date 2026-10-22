package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ RTChorusMusicInfoView a;

    public h(RTChorusMusicInfoView r1) {
        this.a = r1;
    }

    public final void accept(Object r14) {
        com.bytedance.android.live.ktv.common.model.bean.a r15 = (com.bytedance.android.live.ktv.common.model.bean.a) r14;
        if (r15 == null) goto L92;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r0 = this.a.o;
        if (r0 == null) goto L90;
        KtvRoomLyricsStateMachineConfig.d r1 = r0.getCurState();
        if (r1 == null) goto L93;
        boolean r2 = false;
        if ((r1 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L20;
        this.a.getClass();
        RealTimeChorusBusinessContext.a r3 = RealTimeChorusBusinessContext.Companion;
        if (r3.b() != 1) goto L15;
    L17:
        boolean r4 = false;
    L18:
        if (r4 == false) goto L20;
        r2 = true;
        goto L20
    L15:
        if (r3.b() == 2) goto L17;
        r4 = true;
    L20:
        RealTimeChorusBusinessContext.a r5 = RealTimeChorusBusinessContext.Companion;
        if (r5.j() == false) goto L66;
        RTChorusMusicInfoView r6 = this.a;
        r6.getClass();
        RealTimeChorusBusinessContext r7 = r5.getContext();
        if (r7 == null) goto L29;
        com.bytedance.live.datacontext.j<fd2.s> r8 = r7.m454getService();
        if (r8 == null) goto L29;
        fd2.s r9 = (fd2.s) r8.getValue();
        if (r9 == null) goto L29;
        long r10 = r9.u7();
    L30:
        Pair r11 = (Pair) r6.p.getValue();
        if (r11 == null) goto L35;
        com.bytedance.android.live.ktv.common.model.bean.a r12 = (com.bytedance.android.live.ktv.common.model.bean.a) r11.getSecond();
        if (r12 == null) goto L35;
        long r13 = r12.a;
    L36:
        Pair r16 = (Pair) r6.p.getValue();
        if (r16 == null) goto L41;
        com.bytedance.android.live.ktv.common.model.bean.a r17 = (com.bytedance.android.live.ktv.common.model.bean.a) r16.getSecond();
        if (r17 == null) goto L41;
        long r18 = r17.b;
    L42:
        long r19 = r13 - r18;
        if (r10 > 1000) goto L46;
        r10 = r19;
    L46:
        MusicPanel r20 = r1.b();
        if (r20 == null) goto L51;
        KtvMusic r21 = r20.a;
        if (r21 == null) goto L51;
        long r22 = r21.getMDuration();
    L53:
        if ((r22 * 1000) != 0) goto L60;
        Pair r23 = (Pair) r6.p.getValue();
        if (r23 == null) goto L59;
        com.bytedance.android.live.ktv.common.model.bean.a r24 = (com.bytedance.android.live.ktv.common.model.bean.a) r23.getSecond();
        if (r24 == null) goto L59;
        long r25 = r24.a;
    L65:
        Pair r26 = new Pair(Long.valueOf(r10), Long.valueOf(r25 * ((long) 1000.0f)));
        long r27 = ((Number) r26.component1()).longValue();
        long r28 = ((Number) r26.component2()).longValue();
        this.a.p.setValue(new Pair(Boolean.valueOf(r2), new com.bytedance.android.live.ktv.common.model.bean.a(r28, r28 - r27)));
    L67:
        if (r2 == false) goto L69;
    L72:
        Pair r110 = (Pair) this.a.p.getValue();
        if (r110 == null) goto L77;
        com.bytedance.android.live.ktv.common.model.bean.a r111 = (com.bytedance.android.live.ktv.common.model.bean.a) r110.getSecond();
        if (r111 == null) goto L77;
        long r29 = r111.b;
    L79:
        if (r29 != 0) goto L81;
    L83:
        RTChorusMusicInfoView r112 = this.a;
        Disposable r30 = r112.m;
        if (r30 == null) goto L88;
        Intrinsics.checkNotNull(r30);
        if (r30.isDisposed() == true) goto L88;
        return;
    L88:
        r112.R5();
        r112.m = du2.a.d(1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(r112, new WeakReference(r112)));
        return;
    L81:
        if (Math.abs(r29 - this.a.k) <= ((Number) KtvSettingHelper.Q.getValue()).longValue()) goto L83;
        ALogger.i("RTChorusMusicInfoView", "should check timer leftTime:" + r29 + " lastLeftTimeMs:" + this.a.k);
        this.a.R5();
    L77:
        r29 = 0;
        goto L79
    L69:
        if (r5.j() == true) goto L72;
        this.a.R5();
        this.a.U5(r15.b);
        return;
    L59:
        r25 = 0;
        goto L65
    L60:
        KtvMusic.a r31 = KtvMusic.Companion;
        MusicPanel r32 = r1.b();
        if (r32 == null) goto L63;
        KtvMusic r33 = r32.a;
    L64:
        r31.getClass();
        r25 = KtvMusic.a.a(r33);
        goto L65
    L63:
        r33 = null;
    L51:
        r22 = 0;
    L41:
        r18 = 0;
    L35:
        r13 = 0;
    L29:
        r10 = 0;
        goto L30
    L66:
        this.a.p.setValue(new Pair(Boolean.valueOf(r2), r15));
        goto L67
    L93:
        return;
    L90:
        return;
    }
}
