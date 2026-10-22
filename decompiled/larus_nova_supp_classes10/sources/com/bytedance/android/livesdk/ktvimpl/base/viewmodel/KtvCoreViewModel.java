package com.bytedance.android.livesdk.ktvimpl.base.viewmodel;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.liveinteract.plantform.utils.c0;
import com.bytedance.android.live.liveinteract.plantform.utils.d0;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.sei.f;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.k;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.s;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\"\u0010\u000b\u001a\u00020\u00042\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0006H\u0014J\b\u0010\f\u001a\u00020\u0004H\u0014J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/KtvCoreViewModel;", "Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/BaseCoreViewModel;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/c;", "getListenerController", "", "onCleared", "Lcom/bytedance/android/live/core/utils/StateMachine$c$b;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$d;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$a;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$b;", "valid", "tryNotifyProgress", "useSeiDataOfFeedForwardLoadLyric", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/k;", "initAnchorController", "Loe2/b;", "ktvRoomProvider", "Lsb0/b;", "dataEntity", "Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;", "ktvContext", "<init>", "(Loe2/b;Lsb0/b;Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvCoreViewModel extends BaseCoreViewModel {
    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel
    public void useSeiDataOfFeedForwardLoadLyric() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel
    public com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.c getListenerController() {
        return new s(getKtvContext(), this, getDataEntity(), new AnonymousClass1(this));
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel
    public k initAnchorController() {
        c0 r1 = null;
        if (isAnchor() == false) goto L14;
        k r0 = new k(getKtvRoomProvider(), getDataEntity(), getStateMachine(), new KtvCoreViewModel$initAnchorController$anchorController$1(this));
        StateMachine<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> r2 = getStateMachine();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r0.w = r2;
        com.bytedance.android.live.pushstream.d r3 = getKtvRoomProvider().g();
        if (r3 == null) goto L13;
        d0 r4 = getLiveStreamInfoSenderManager();
        if (r4 == null) goto L12;
        KtvContext.Companion.getClass();
        if (KtvContext.a.k() == false) goto L11;
        AtomicInteger r5 = c0.c;
        r1 = c0.a.b(r4);
        goto L12
    L11:
        AtomicInteger r6 = c0.c;
        r1 = c0.a.a(r4);
    L12:
        r0.a = new f(r3, r1);
        Unit r7 = Unit.INSTANCE;
    L13:
        return r0;
    L14:
        return null;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel
    public void onCleared() {
        super.onCleared();
        sendEvent(KtvRoomLyricsStateMachineConfig.a.C0031a.c, BaseCoreViewModel.TAG);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel
    public void tryNotifyProgress(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r4) {
        Intrinsics.checkNotNullParameter(r4, "valid");
        Object r0 = r4.c;
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.f) == true) goto L5;
        return;
    L5:
        if (r0 == null) goto L14;
        if (((KtvRoomLyricsStateMachineConfig.d.f) r0).b.a.isSinger(getCurrentUserId()) == false) goto L16;
        Object r5 = r4.c;
        if (r5 == null) goto L12;
        notifyProgressChange(((KtvRoomLyricsStateMachineConfig.d.f) r5).d.a);
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig.State.Singing");
    L16:
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig.State.Singing");
    }

    public KtvCoreViewModel(oe2.b r2, sb0.b r3, KtvContext r4) {
        Intrinsics.checkNotNullParameter(r2, "ktvRoomProvider");
        Intrinsics.checkNotNullParameter(r3, "dataEntity");
        Intrinsics.checkNotNullParameter(r4, "ktvContext");
        super(r2, r3, r4);
        ALogger.i("coreVm排查", "core init");
    }
}
