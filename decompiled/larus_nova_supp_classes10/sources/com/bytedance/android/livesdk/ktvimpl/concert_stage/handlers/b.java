package com.bytedance.android.livesdk.ktvimpl.concert_stage.handlers;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.livesdk.ktvapi.concert_stage.models.DynamicConcertStatusChangeEventType;
import com.bytedance.android.livesdk.ktvimpl.concert_stage.biz.ConcertStageDataContext;
import com.bytedance.android.livesdk.ktvimpl.concert_stage.biz.w;
import com.google.gson.JsonObject;
import gd2.f;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import qh0.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements d<rh0.a> {
    public final /* synthetic */ String a;

    public b(String r1) {
        this.a = r1;
    }

    public final void b(BaseCheckException r6) {
        Intrinsics.checkNotNullParameter(r6, "exception");
        w.a("LinkServiceHandler", "checkPermission onFailed");
        f r0 = ConcertStageDataContext.Companion.a();
        if (r0 == null) goto L5;
        DynamicConcertStatusChangeEventType r1 = DynamicConcertStatusChangeEventType.onCheckPermissionFinished;
        JsonObject r2 = new JsonObject();
        r2.addProperty("sub_type", "chorus");
        r2.addProperty("success", Boolean.FALSE);
        Unit r3 = Unit.INSTANCE;
        r0.e(new hd2.b(r1, r2));
    L5:
        int r4 = xe2.a.a;
        xe2.a.a(false, this.a);
        InteractLinkFullLinkMonitor.e(OperateType.APPLY.ordinal(), 2, r6);
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.U(r6);
        x.K(r6);
    }

    public final void onResult(Object r5) {
        rh0.a r6 = (rh0.a) r5;
        w.a("LinkServiceHandler", "checkPermission onSuccess");
        f r7 = ConcertStageDataContext.Companion.a();
        if (r7 == null) goto L5;
        DynamicConcertStatusChangeEventType r0 = DynamicConcertStatusChangeEventType.onCheckPermissionFinished;
        JsonObject r1 = new JsonObject();
        r1.addProperty("sub_type", "chorus");
        r1.addProperty("success", Boolean.TRUE);
        Unit r2 = Unit.INSTANCE;
        r7.e(new hd2.b(r0, r1));
    L5:
        int r8 = xe2.a.a;
        xe2.a.a(true, this.a);
        InteractLinkFullLinkMonitor.f(OperateType.APPLY.ordinal(), 2);
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.V();
        x.L();
    }
}
