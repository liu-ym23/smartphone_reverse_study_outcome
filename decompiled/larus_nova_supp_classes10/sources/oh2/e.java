package oh2;

import com.bytedance.android.livesdk.livecommerce.intro.event.IntroCardEventCenter;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e {
    public final IntroCardEventCenter a;
    public final com.bytedance.android.livesdk.livecommerce.intro.event.a b;
    public final com.bytedance.android.livesdk.livecommerce.room.model.e c;
    public final d d;
    public final Function1<ql.a, com.bytedance.android.ec.common.api.jump.model.g> e;

    public e(com.bytedance.android.livesdk.livecommerce.intro.event.a r2, com.bytedance.android.livesdk.livecommerce.room.model.e r3, d r4, com.bytedance.android.livesdk.livecommerce.promotion.card.e r5, il.a r6, Function1<? super ql.a, com.bytedance.android.ec.common.api.jump.model.g> r7) {
        Intrinsics.checkNotNullParameter(r3, "liveRoomInfo");
        Intrinsics.checkNotNullParameter(r4, "containerHandler");
        Intrinsics.checkNotNullParameter(r6, "historyMap");
        Intrinsics.checkNotNullParameter(r7, "getEventPromotionParams");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r7;
        this.a = new IntroCardEventCenter(r2, r5, r6, r7);
    }
}
