package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.audience;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.n;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ KtvComponentAudienceLogicWidget a;
    public final /* synthetic */ long b;

    public a(KtvComponentAudienceLogicWidget r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        final com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
        this.a.d = false;
        mb0.c.a.b(pd2.d.n, LinkMonitorData.APIGetKtvComponentSetting, System.currentTimeMillis() - this.b, ((ExtraResponse) r8).logId);
        u r0 = m.e(this.a);
        if (r0 == null) goto L9;
        j r1 = r0.J();
        if (r1 == null) goto L9;
        LivePlayModeLogContext r2 = (LivePlayModeLogContext) r1.getValue();
        if (r2 == null) goto L9;
        r2.addPlayMode(21);
    L9:
        KtvComponentContext r3 = this.a.f;
        Boolean r4 = null;
        if (r3 == null) goto L18;
        n<Integer> r5 = r3.getOpenSource();
        if (r5 == null) goto L18;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.g r6 = (com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.g) ((ExtraResponse) r8).data;
        if (r6 == null) goto L16;
        Integer r9 = r6.d();
    L17:
        r5.setValue(r9);
        goto L18
    L16:
        r9 = null;
    L18:
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r10 = KtvComponentContext.Companion.a();
        if (r10 == null) goto L21;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r10, new KtvComponentAudienceLogicWidget$fetchKtvComponentSetting$1$1(r8));
    L21:
        KtvComponentAudienceLogicWidget.wq(this.a, ((com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.g) ((ExtraResponse) r8).data).a());
        StringBuilder r11 = new StringBuilder("KtvComponentAudienceLogicWidget: fetchKtvComponentSetting, success, audienceSingEnable=");
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.g r12 = (com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.g) ((ExtraResponse) r8).data;
        if (r12 == null) goto L24;
        r4 = r12.a();
    L24:
        r11.append(r4);
        r11.append(", logId=");
        r11.append(((ExtraResponse) r8).logId);
        ALogger.w("KtvComponent_MergeMode", r11.toString());
    }
}
