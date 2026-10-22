package xd2;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.ktvimpl.base.api.KtvProfitApi;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements xd2.a {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // xd2.a
    public final Disposable a(long r3, long r5, Function1 r7, Function1 r8) {
        Intrinsics.checkNotNullParameter(r7, "successCallback");
        Intrinsics.checkNotNullParameter(r8, "failCallback");
        return ((KtvProfitApi) com.bytedance.android.live.network.c.b().e(KtvProfitApi.class)).wearMidiSkin(r3, r5).compose(RxUtil.rxSchedulerHelper()).subscribe(new g(r7), new h(r8));
    }

    @Override // xd2.a
    public final Disposable b(long r8, int r10, int r11, boolean r12, Function1 r13, Function1 r14) {
        Intrinsics.checkNotNullParameter(r13, "successCallback");
        Intrinsics.checkNotNullParameter(r14, "failCallback");
        return ((KtvProfitApi) com.bytedance.android.live.network.c.b().e(KtvProfitApi.class)).getDressPageList(r8, r10, r11, r12).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(r13), new f(r14));
    }

    @Override // xd2.a
    public final Disposable c(long r15, int r17, String r18, String r19, int r20, boolean r21, long r22, int r24, Function1 r25, Function1 r26) {
        Intrinsics.checkNotNullParameter(r18, "fromDressId");
        Intrinsics.checkNotNullParameter(r19, "toDressId");
        Intrinsics.checkNotNullParameter(r25, "successCallback");
        Intrinsics.checkNotNullParameter(r26, "failCallback");
        return ((KtvProfitApi) com.bytedance.android.live.network.c.b().e(KtvProfitApi.class)).changeDress(r15, r17, r18, r19, r20, r21, r22, r24).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(r25), new d(r26));
    }
}
