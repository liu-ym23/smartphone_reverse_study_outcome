package sd2;

import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.soloktv.model.JumpRealTimeChorusRoomParams;
import com.bytedance.android.livesdk.ktvimpl.base.api.KtvRoomApi;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: sd2.a$a, reason: collision with other inner class name */
    public static final class C0170a {
    }

    public static final class b {
        public static final a a = null;

        static {
            a = new a();
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ Function1 b;

        public c(long r1, Function1 r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r7) {
            com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
            mb0.c.a.b(pd2.d.n, LinkMonitorData.ApiJumpRealTimeChorusRoom, System.currentTimeMillis() - this.a, ((ExtraResponse) r8).logId);
            this.b.invoke(r8);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ Function1 b;

        public d(long r1, Function1 r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r7) {
            Throwable r8 = (Throwable) r7;
            mb0.c.a.a(pd2.d.n, LinkMonitorData.ApiJumpRealTimeChorusRoom, System.currentTimeMillis() - this.a, r8);
            ExceptionUtils.handleException(s1.getContext(), r8);
            this.b.invoke(r8);
        }
    }

    static {
    }

    public a() {
    }

    public final Disposable a(long r4, JumpRealTimeChorusRoomParams r6, Function1<? super com.bytedance.android.live.network.response.e<com.bytedance.android.live.soloktv.model.e>, Unit> r7, Function1<? super Throwable, Unit> r8) {
        Intrinsics.checkNotNullParameter(r6, "data");
        Intrinsics.checkNotNullParameter(r7, "successCallback");
        Intrinsics.checkNotNullParameter(r8, "failCallback");
        return ((KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class)).jumpRealTimeChorusRoom(r6.getJumpScene(), r6.getJumpRooms()).retryWhen(RxUtil.rxRetryHelper(3, 1000)).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(r4, r7), new d(r4, r8));
    }
}
