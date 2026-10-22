package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KtvStageWidget$loadMvWidget$mvRunContext$1 implements com.bytedance.android.livesdk.ktvimpl.mv.c {
    public final /* synthetic */ KtvStageWidget a;

    public static final class a<T> implements Observer {
        public final /* synthetic */ com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b a;

        public a(com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r3 = (StateMachine.c.b) r2;
            if (r3 == null) goto L7;
            this.a.handleStateChange(r3);
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.mv.c
    public final boolean a() {
        return this.a.y.isCurrentUserIsSinger();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.mv.c
    public final KtvContext b() {
        return this.a.y;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.mv.c
    public final List<MusicPanel> f() {
        List<MusicPanel> r0 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.c(this.a.y);
        if (r0 != null) goto L7;
        return null;
    L7:
        return CollectionsKt.toMutableList(r0);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.mv.c
    public final DataCenter getDataCenter() {
        return ((Widget) this.a).dataCenter;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.mv.c
    public final long getRoomId() {
        return this.a.z.b().getRoomId();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.mv.c
    public final lb0.b k() {
        return this.a.y.getKtvMvBackRound();
    }

    public KtvStageWidget$loadMvWidget$mvRunContext$1(KtvStageWidget r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.mv.c
    public final void d(com.bytedance.android.livesdk.ktvimpl.mv.m r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        com.bytedance.android.live.ktv.common.util.g.d(String.valueOf(r5));
        Integer r1 = r5.a;
        if (r1 != null) goto L6;
    L11:
        Integer r2 = r5.a;
        if (r2 != null) goto L15;
        return;
    L15:
        if (r2.intValue() != 2) goto L22;
        pd2.d.n.getClass();
        Intrinsics.checkNotNullParameter(r5, "event");
        JSONObject r0 = new JSONObject();
        r0.put("vId", r5.f);
        r0.put("des", r5.d);
        Integer r6 = r5.e;
        if (r6 == null) goto L19;
        r0.put("code", r6.intValue());
    L19:
        pd2.d.w(LinkMonitorData.BusinessMvplayError, r0);
        return;
    L22:
        return;
    L6:
        if (r1.intValue() != 0) goto L11;
        pd2.d.n.getClass();
        Intrinsics.checkNotNullParameter(r5, "event");
        JSONObject r3 = new JSONObject();
        r3.put("vId", r5.f);
        Long r7 = r5.c;
        if (r7 == null) goto L10;
        r3.put("gap", r7.longValue());
    L10:
        pd2.d.w(LinkMonitorData.BusinessMvplayGap, r3);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.mv.c
    public final void l(String r2) {
        this.a.y.getCurrentMvVid().setValue(r2);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.mv.c
    public final void n(com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b r5) {
        Intrinsics.checkNotNullParameter(r5, "receiver");
        final a r0 = new a(r5);
        LifecycleOwner r1 = this.a;
        BaseCoreViewModel r2 = r1.p;
        if (r2 == null) goto L5;
        r2.observeState(r1, r0, r1.z.b().isAnchor());
    L5:
        r5.notifyClear(new KtvStageWidget$loadMvWidget$mvRunContext$1$onGetDataReceiver$1(this, r0));
        KtvRoomViewModel r3 = (KtvRoomViewModel) this.a.d;
        if (r3 == null) goto L8;
        r3.setMvDataReceiver(r5);
    L8:
        this.a.w = r5;
    }
}
