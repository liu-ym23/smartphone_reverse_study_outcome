package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.anchor;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ KtvComponentAnchorLogicWidget a;
    public final /* synthetic */ long b;

    public a(KtvComponentAnchorLogicWidget r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        final com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
        mb0.c.a.b(pd2.d.n, LinkMonitorData.APIGetKtvComponentSetting, System.currentTimeMillis() - this.b, ((ExtraResponse) r8).logId);
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r0 = KtvComponentContext.Companion.a();
        if (r0 == null) goto L5;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r0, new KtvComponentAnchorLogicWidget$fetchKtvComponentSetting$1$1(r8));
    L5:
        KtvComponentAnchorLogicWidget.Eq(this.a, "room_continue", ((com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.g) ((ExtraResponse) r8).data).a());
        StringBuilder r1 = new StringBuilder("KtvComponentAnchorLogicWidget: fetchKtvComponentSetting, success, audienceSingEnable=");
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.g r2 = (com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.g) ((ExtraResponse) r8).data;
        if (r2 == null) goto L8;
        Boolean r3 = r2.a();
    L9:
        r1.append(r3);
        r1.append(", logId=");
        r1.append(((ExtraResponse) r8).logId);
        ALogger.w("KtvComponent_MergeMode", r1.toString());
        return;
    L8:
        r3 = null;
        goto L9
    }
}
