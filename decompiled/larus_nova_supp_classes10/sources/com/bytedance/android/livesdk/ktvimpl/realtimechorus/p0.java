package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.live.ktv.common.music.download.KtvMusicManager;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class p0<T> implements Consumer {
    public final /* synthetic */ RealTimeChorusMainViewWidget a;

    public p0(RealTimeChorusMainViewWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r8) {
        Long r9 = (Long) r8;
        RealTimeChorusMainViewWidget r10 = this.a;
        int r0 = RealTimeChorusMainViewWidget.Q2;
        Disposable r11 = r10.Z;
        if (r11 != null) goto L5;
    L7:
        RealTimeChorusMainViewWidget r12 = this.a;
        MusicPanel r1 = r12.M1;
        if (r1 != null) goto L10;
    L18:
        this.a.lr();
        this.a.L1 = false;
        return;
    L10:
        if (r1.a.isOrderedBy(jc1.k.n(IMiddlewareUserService.class).user().n().toString()) == false) goto L18;
        w.a("RealTimeChorusMainViewWidget", "sendSingerBeginSing, music=" + r1.a.getMTitle());
        if (((Boolean) KtvSettingHelper.U0.getValue()).booleanValue() == true) goto L14;
        r12.dr(r1);
        goto L18
    L14:
        if (KtvUtilsKt.m(r1) == false) goto L16;
        r12.dr(r1);
        goto L18
    L16:
        KtvMusicManager.e(KtvMusicManager.m, r1, new t0(r12, r1), false, null, false, 28);
        goto L18
    L5:
        if (r11.isDisposed() == true) goto L7;
        r11.dispose();
        goto L7
    }
}
