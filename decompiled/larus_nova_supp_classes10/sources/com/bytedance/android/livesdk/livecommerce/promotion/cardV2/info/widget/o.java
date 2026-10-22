package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.view.View;
import com.bytedance.android.ec.model.response.ECSalePointDataV2;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o extends com.bytedance.android.ec.core.utils.rotation.a<ECSalePointDataV2> {
    public final /* synthetic */ m k;
    public final /* synthetic */ ECSalePointViewV2 l;
    public final /* synthetic */ ECSalePointViewV2 m;
    public final /* synthetic */ List n;

    public final View f(int r1) {
        if (r1 != 0) goto L5;
        return this.l;
    L5:
        return this.m;
    }

    public final void i(int r2, Object r3) {
        ECSalePointDataV2 r4 = (ECSalePointDataV2) r3;
        Intrinsics.checkNotNullParameter(r4, "data");
        if (r2 != 0) goto L5;
        ECSalePointViewV2 r5 = this.l;
    L6:
        StringBuilder r0 = this.k.l;
        if (r0 == null) goto L9;
        StringsKt.clear(r0);
    L9:
        this.k.b(r5, r4);
        return;
    L5:
        r5 = this.m;
        goto L6
    }

    public o(m r9, ECSalePointViewV2 r10, ECSalePointViewV2 r11, List r12, List r13, long r14, long r16, boolean r18) {
        this.k = r9;
        this.l = r10;
        this.m = r11;
        this.n = r12;
        super(r13, r14, r16, r18);
    }
}
