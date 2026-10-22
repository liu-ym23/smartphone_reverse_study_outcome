package com.bytedance.android.livesdk.livecommerce.playback.tip;

import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.ec.core.widget.d;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import fi2.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends d {
    public final /* synthetic */ ExplainPlaybackTipPresenter g;
    public final /* synthetic */ ECRitTag h;

    public final void a(View r5) {
        Intrinsics.checkNotNullParameter(r5, "v");
        bj2.a.b("ExplainPlaybackTipPresenter", "click ProtectTipForLive");
        String r0 = this.h.getUrlDoc();
        if (r0 != null) goto L5;
        return;
    L5:
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_JUMP_DISPATCHER_DISPOSABLE_SCOPE_FIX() == false) goto L7;
        bk2.b r1 = this.g.g;
    L8:
        jf.d.b.e(c.b(r1, null, 6), this.g.Y().c(), r0, BtmUtilsKt.e("a1.b3390.c044287.d688456", PageFinder.via(r5)));
        return;
    L7:
        r1 = new bk2.b();
        goto L8
    }

    public a(ExplainPlaybackTipPresenter r1, ECRitTag r2) {
        this.g = r1;
        this.h = r2;
        super(null, null, 3);
    }
}
