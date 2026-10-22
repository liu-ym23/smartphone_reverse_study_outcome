package com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right;

import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ BottomRightWidgetV2.b.a a;

    public f(BottomRightWidgetV2.b.a r1) {
        this.a = r1;
    }

    public final void accept(Object r10) {
        Long r11 = (Long) r10;
        dm.a.a("BottomRightWidgetV2").i("bottomcard retry startAction");
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_ENABLE_API_ERROR_REPORT() == false) goto L5;
        sk2.a r12 = new sk2.a(this.a.a.a.i);
    L6:
        BottomRightWidgetV2.b.a r0 = this.a;
        BottomRightWidgetV2 r1 = r0.a.a;
        bg4.b.b(r1.d.a(r1.b, false, true, r0.d, null, r0.e, r0.f, r12)).subscribe(new d(this, r12), new e(this, r12));
        return;
    L5:
        r12 = null;
        goto L6
    }
}
