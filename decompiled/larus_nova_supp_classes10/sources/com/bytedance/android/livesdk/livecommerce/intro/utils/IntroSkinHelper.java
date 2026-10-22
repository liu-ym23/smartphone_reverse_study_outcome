package com.bytedance.android.livesdk.livecommerce.intro.utils;

import android.widget.TextView;
import com.bytedance.android.ec.core.utils.c0;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.skin.PromotionCardStyleHelper;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinPriceUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinTextElement;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class IntroSkinHelper {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(TextView r3, ECLiveSkinTextElement r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$applySkinConfig");
        Intrinsics.checkNotNullParameter(r4, "config");
        int r0 = r4.component1();
        List<String> r1 = r4.component2();
        int r5 = r4.component3();
        if (r0 <= 0) goto L5;
        r3.setTextSize(2, r0);
    L5:
        if (r1 == null) goto L7;
        List r2 = PromotionCardStyleHelper.ButtonHelper.a(r1);
    L9:
        if (r2 != null) goto L11;
    L14:
        boolean r6 = true;
    L15:
        if (r6 == false) goto L17;
    L22:
        if (r5 <= 0) goto L25;
        c0.b(r3, r5);
        return;
    L25:
        return;
    L17:
        if (r2.size() != 1) goto L22;
        Integer r7 = (Integer) CollectionsKt.firstOrNull(r2);
        if (r7 == null) goto L22;
        r3.setTextColor(r7.intValue());
        goto L22
    L11:
        if (r2.isEmpty() == true) goto L14;
        r6 = false;
        goto L15
    L7:
        r2 = null;
        goto L9
    }

    public static void b(final PriceView r8, ECLiveSkinPriceUIConfig r9) {
        if (r8 != null) goto L4;
        return;
    L4:
        final int r4 = r9.component1();
        final int r2 = r9.component2();
        final int r5 = r9.component3();
        final int r6 = r9.component4();
        final int r7 = r9.component5();
        final List<String> r3 = r9.component6();
        r8.C(new IntroSkinHelper$applySkinConfig$1(r8, r2, r3, r4, r5, r6, r7));
    }
}
