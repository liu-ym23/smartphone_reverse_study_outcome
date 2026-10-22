package oh2;

import com.bytedance.android.livesdk.livecommerce.intro.event.IntroCardEventCenter;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IntroCardEventCenter f523252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.intro.event.a f523253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.room.model.e f523254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f523255d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<ql.a, com.bytedance.android.ec.common.api.jump.model.g> f523256e;

    /* JADX WARN: Multi-variable type inference failed */
    public e(com.bytedance.android.livesdk.livecommerce.intro.event.a r100, com.bytedance.android.livesdk.livecommerce.room.model.e r101, d r102, com.bytedance.android.livesdk.livecommerce.promotion.card.e r103, il.a r104, Function1<? super ql.a, com.bytedance.android.ec.common.api.jump.model.g> r105) {
        Intrinsics.checkNotNullParameter(r101, "liveRoomInfo");
        Intrinsics.checkNotNullParameter(r102, "containerHandler");
        Intrinsics.checkNotNullParameter(r104, "historyMap");
        Intrinsics.checkNotNullParameter(r105, "getEventPromotionParams");
        this.f523253b = r100;
        this.f523254c = r101;
        this.f523255d = r102;
        this.f523256e = r105;
        this.f523252a = new IntroCardEventCenter(r100, r103, r104, r105);
    }
}
