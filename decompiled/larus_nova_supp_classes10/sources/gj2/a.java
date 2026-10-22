package gj2;

import com.bytedance.android.ec.common.api.jump.model.g;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import jf.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import w83.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements c {
    public final d a;
    public final Function0<g> b;

    public a(il.a r2, d r3, Function0<g> r4, ILivePromotionCardContainerHandler r5) {
        Intrinsics.checkNotNullParameter(r2, "ecEventHistoryMap");
        Intrinsics.checkNotNullParameter(r3, "jumpDispatcher");
        Intrinsics.checkNotNullParameter(r4, "getPromotionParams");
        Intrinsics.checkNotNullParameter(r5, "containerHandler");
        this.a = r3;
        this.b = r4;
    }
}
