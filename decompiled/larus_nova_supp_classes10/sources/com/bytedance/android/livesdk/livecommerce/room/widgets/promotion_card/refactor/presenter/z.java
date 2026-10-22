package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import android.view.View;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ss.android.ugc.aweme.kiwi.util.Query;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class z extends com.bytedance.android.ec.core.utils.rotation.a<List<? extends ECRitTag>> {
    public final /* synthetic */ x k;
    public final /* synthetic */ Query l;
    public final /* synthetic */ Query m;
    public final /* synthetic */ List n;

    public final View f(int r1) {
        if (r1 != 0) goto L4;
        Query r2 = this.l;
    L6:
        return r2.f();
    L4:
        r2 = this.m;
        goto L6
    }

    public final void i(int r2, Object r3) {
        List<ECRitTag> r4 = (List) r3;
        Intrinsics.checkNotNullParameter(r4, "data");
        x r0 = this.k;
        if (r2 != 0) goto L5;
        Query r5 = this.l;
    L6:
        r0.E(r5, r4);
        oh.a.c(LocationMonitorConst.INFO, new y(this, r4));
        return;
    L5:
        r5 = this.m;
        goto L6
    }

    public z(x r9, Query r10, Query r11, List r12, List r13, long r14, long r16) {
        this.k = r9;
        this.l = r10;
        this.m = r11;
        this.n = r12;
        super(r13, r14, r16, false);
    }
}
