package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.view.View;
import com.bytedance.android.ec.model.response.ECCarouselData;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n extends com.bytedance.android.ec.core.utils.rotation.a<ECCarouselData> {
    public final /* synthetic */ m k;
    public final /* synthetic */ List l;

    public final View f(int r2) {
        if (r2 != 0) goto L6;
        ECSalePointView r3 = this.k.g;
        if (r3 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout1");
    L9:
        return r3;
    L6:
        r3 = this.k.h;
        if (r3 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout2");
        goto L9
    }

    public final void i(int r4, Object r5) {
        ECCarouselData r6 = (ECCarouselData) r5;
        Intrinsics.checkNotNullParameter(r6, "data");
        if (r4 != 0) goto L7;
        ECSalePointView r7 = this.k.g;
        if (r7 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout1");
    L10:
        StringBuilder r0 = this.k.l;
        if (r0 == null) goto L13;
        StringsKt.clear(r0);
    L13:
        r7.a(r6, this.k.e);
        StringBuilder r8 = this.k.l;
        if (r8 == null) goto L16;
        StringsKt.append(r8, new String[]{r6.getBefore(), r6.getContent()});
    L16:
        this.k.c(r6);
        return;
    L7:
        r7 = this.k.h;
        if (r7 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout2");
        goto L10
    }

    public n(m r8, List r9, List r10, long r11, long r13, boolean r15) {
        this.k = r8;
        this.l = r9;
        super(r10, r11, r13, r15);
    }
}
