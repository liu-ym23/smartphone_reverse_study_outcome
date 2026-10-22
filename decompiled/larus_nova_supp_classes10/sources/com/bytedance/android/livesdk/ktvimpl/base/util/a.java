package com.bytedance.android.livesdk.ktvimpl.base.util;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.livesdk.ktvimpl.base.controlnode.AddMusicControlNode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements qh0.d<rh0.a> {
    public final /* synthetic */ rj0.b a;

    public a(AddMusicControlNode.d r1) {
        this.a = r1;
    }

    public final void b(BaseCheckException r3) {
        Intrinsics.checkNotNullParameter(r3, "exception");
        this.a.onFailed(r3);
        InteractLinkFullLinkMonitor.e(OperateType.APPLY.ordinal(), 2, r3);
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.U(r3);
        x.K(r3);
    }

    public final void onResult(Object r2) {
        rh0.a r3 = (rh0.a) r2;
        this.a.onSuccess();
        InteractLinkFullLinkMonitor.f(OperateType.APPLY.ordinal(), 2);
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.V();
        x.L();
    }
}
