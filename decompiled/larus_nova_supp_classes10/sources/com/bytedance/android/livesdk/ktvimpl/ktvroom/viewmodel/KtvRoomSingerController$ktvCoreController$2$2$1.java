package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lfd2/a;", "p1", "", "invoke", "(Lfd2/a;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class KtvRoomSingerController$ktvCoreController$2$2$1 extends FunctionReferenceImpl implements Function1<fd2.a, Unit> {
    public KtvRoomSingerController$ktvCoreController$2$2$1(KtvRoomSingerController r8) {
        super(1, r8, KtvRoomSingerController.class, "handleAudioProgressEvent", "handleAudioProgressEvent(Lcom/bytedance/android/livesdk/ktvapi/AudioProgressEvent;)V", 0);
    }

    public final void invoke(fd2.a r12) {
        Intrinsics.checkNotNullParameter(r12, "p1");
        KtvRoomSingerController r0 = (KtvRoomSingerController) ((CallableReference) this).receiver;
        int r1 = KtvRoomSingerController.H;
        r0.getClass();
        if ((r12 instanceof fd2.a.c) == false) goto L16;
        r0.k = false;
        BaseCoreViewModel r13 = r0.o();
        if (r13 == null) goto L14;
        KtvRoomLyricsStateMachineConfig.d r14 = r13.getCurState();
        if (r14 == null) goto L14;
        if (r14.b() == null) goto L14;
        BaseCoreViewModel r15 = r0.o();
        if (r15 == null) goto L13;
        r15.sendEvent(new KtvRoomLyricsStateMachineConfig.a.e(null, null, 10), "KtvRoomSingerController");
    L13:
        r0.r(3);
    L14:
        ALogger.i(bb0.b.b(), "AudioProgressEvent.OnStart, invoke class :".concat(KtvRoomSingerController.class.getSimpleName()));
        r0.s = false;
        return;
    L16:
        if ((r12 instanceof fd2.a.d) == false) goto L27;
        ALogger.i(bb0.b.b(), "AudioProgressEvent.OnStop, invoke class :".concat(KtvRoomSingerController.class.getSimpleName()));
        if (r0.s == true) goto L60;
        r0.k = true;
        r0.s = true;
        r0.l = "normal";
        KtvContext.Companion.getClass();
        KtvContext r16 = KtvContext.a.g();
        if (r16 == null) goto L25;
        com.bytedance.live.datacontext.k<com.bytedance.android.live.ktv.common.model.bean.a> r17 = r16.getCountDownEvent();
        if (r17 == null) goto L25;
        r17.post(com.bytedance.android.live.ktv.common.model.bean.a.c);
    L25:
        r0.t = 0;
        KtvRoomSingerController.n(r0);
        return;
    L60:
        return;
    L27:
        if ((r12 instanceof fd2.a.b) == false) goto L54;
        fd2.a.b r18 = (fd2.a.b) r12;
        if ((System.currentTimeMillis() - r0.t) <= r0.u) goto L33;
        r0.t = System.currentTimeMillis();
        Long r2 = r0.p().f();
        if (r2 == null) goto L33;
        long r5 = r2.longValue() - r0.p().b();
        KtvContext.Companion.getClass();
        KtvContext.a.g().getCountDownEvent().post(new com.bytedance.android.live.ktv.common.model.bean.a(r2.longValue(), r5));
    L33:
        BaseCoreViewModel r3 = r0.o();
        if (r3 == null) goto L55;
        KtvRoomLyricsStateMachineConfig.d r4 = r3.getCurState();
        if (r4 == null) goto L56;
        MusicPanel r6 = r4.b();
        if (r6 == null) goto L57;
        BaseCoreViewModel r7 = r0.o();
        if (r7 == null) goto L42;
        KtvRoomLyricsStateMachineConfig.d r8 = r7.getCurState();
    L44:
        if ((r8 instanceof KtvRoomLyricsStateMachineConfig.d.f) == true) goto L46;
        return;
    L46:
        if (r0.v.isCurrentUserIsSinger() == false) goto L59;
        BaseCoreViewModel r9 = r0.o();
        if (r9 == null) goto L50;
        r9.sendEvent(new KtvRoomLyricsStateMachineConfig.a.e(null, null, (long) (r18.a + (r6.a.getMPreviewStartTime() * 1000))), "KtvRoomSingerController");
    L50:
        r0.r(0);
        return;
    L59:
        return;
    L42:
        r8 = null;
        goto L44
    L57:
        return;
    L56:
        return;
    L55:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((fd2.a) r1);
        return Unit.INSTANCE;
    }
}
