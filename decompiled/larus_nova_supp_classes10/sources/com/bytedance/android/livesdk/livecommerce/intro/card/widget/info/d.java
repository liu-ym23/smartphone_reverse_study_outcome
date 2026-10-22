package com.bytedance.android.livesdk.livecommerce.intro.card.widget.info;

import android.view.View;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroElasticMultiElementTitle;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d extends com.bytedance.android.ec.core.utils.rotation.a<IntroElasticMultiElementTitle> {
    public final /* synthetic */ IntroInfoElasticTitleWidget k;
    public final /* synthetic */ IntroInfoSalePointView l;
    public final /* synthetic */ IntroInfoSalePointView m;
    public final /* synthetic */ List n;

    public final View f(int r1) {
        if (r1 != 0) goto L5;
        return this.l;
    L5:
        return this.m;
    }

    public final void i(int r2, Object r3) {
        IntroElasticMultiElementTitle r4 = (IntroElasticMultiElementTitle) r3;
        Intrinsics.checkNotNullParameter(r4, "data");
        if (r2 != 0) goto L5;
        IntroInfoSalePointView r5 = this.l;
    L6:
        StringBuilder r0 = this.k.d;
        if (r0 == null) goto L9;
        StringsKt.clear(r0);
    L9:
        IntroInfoElasticTitleWidget.a(this.k, r5, r4);
        return;
    L5:
        r5 = this.m;
        goto L6
    }

    public d(IntroInfoElasticTitleWidget r9, IntroInfoSalePointView r10, IntroInfoSalePointView r11, List r12, List r13, long r14, long r16) {
        this.k = r9;
        this.l = r10;
        this.m = r11;
        this.n = r12;
        super(r13, r14, r16, false);
    }
}
