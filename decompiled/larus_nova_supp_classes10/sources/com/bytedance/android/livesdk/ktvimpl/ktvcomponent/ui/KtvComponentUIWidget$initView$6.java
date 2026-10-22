package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import android.view.View;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.bpea.cert.token.TokenCert;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class KtvComponentUIWidget$initView$6 extends FunctionReferenceImpl implements Function1<View, Unit> {
    public KtvComponentUIWidget$initView$6(KtvComponentUIWidget r8) {
        super(1, r8, KtvComponentUIWidget.class, "onFloatBallIconClick", "onFloatBallIconClick(Landroid/view/View;)V", 0);
    }

    public final void invoke(View r4) {
        Intrinsics.checkNotNullParameter(r4, "p1");
        KtvComponentUIWidget r5 = (KtvComponentUIWidget) ((CallableReference) this).receiver;
        TokenCert r0 = KtvComponentUIWidget.y1;
        r5.getClass();
        pd2.d.n.getClass();
        Intrinsics.checkNotNullParameter("ktv_component", "source");
        JSONObject r1 = new JSONObject().put("source", "ktv_component");
        pd2.d.w(LinkMonitorData.BusinessFloatBallButtonClick, r1);
        com.bytedance.android.livesdk.chatroom.u r2 = com.bytedance.android.live.liveinteract.api.utils.m.e(r5);
        if (r2 == null) goto L5;
        r2.B();
    L5:
        r5.nr("sing_song", null, null);
        a r6 = r5.t;
        if (r6 == null) goto L9;
        r6.g();
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((View) r1);
        return Unit.INSTANCE;
    }
}
