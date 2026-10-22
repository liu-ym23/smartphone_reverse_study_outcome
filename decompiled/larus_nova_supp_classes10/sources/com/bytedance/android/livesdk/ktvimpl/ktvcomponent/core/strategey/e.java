package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.KtvComponentOrderSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.api.KtvComponentApi;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e implements qh0.d<rh0.a> {
    public final /* synthetic */ KtvComponentSingleBroadcastStrategy a;
    public final /* synthetic */ KtvMusic b;

    public final void b(BaseCheckException r12) {
        Intrinsics.checkNotNullParameter(r12, "exception");
        ALogger.w("KtvComponent_MergeMode", "KtvComponentSingleBroadcastStrategy: doPermissionCheck, failed");
        KtvMusic r3 = this.b;
        if (r3 == null) goto L7;
        KtvComponentOrderSongDataContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r0 = KtvComponentOrderSongDataContext.Companion.a();
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d.a.b(r0, new MusicPanel(r3, 0, null, false, null, null, null, 1073741822), null, 4);
    L7:
        InteractLinkFullLinkMonitor.e(OperateType.PRE_APPLY.ordinal(), 2, r12);
    }

    public final void onResult(Object r8) {
        rh0.a r9 = (rh0.a) r8;
        ALogger.w("KtvComponent_MergeMode", "KtvComponentSingleBroadcastStrategy: doPermissionCheck, success");
        KtvComponentSingleBroadcastStrategy r10 = this.a;
        KtvMusic r0 = this.b;
        r10.getClass();
        long r1 = com.bytedance.android.live.ktv.common.util.a.c().getId();
        long r3 = System.currentTimeMillis();
        RxUtilKt.c(((KtvComponentApi) com.bytedance.android.live.network.c.b().e(KtvComponentApi.class)).addSongPrepareApply(r1, 0).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(r10, r3), new d(r10, r3, r0)), r10.a);
        InteractLinkFullLinkMonitor.f(OperateType.PRE_APPLY.ordinal(), 2);
    }

    public e(KtvComponentSingleBroadcastStrategy r1, KtvMusic r2) {
        this.a = r1;
        this.b = r2;
    }
}
