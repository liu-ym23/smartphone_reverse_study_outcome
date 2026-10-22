package g43;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.android.shopping.abscontainer.arch.core.starter.QueryMethod;
import com.bytedance.android.shopping.abscontainer.arch.platform.net.PlatformHttpRequestAPI;
import com.bytedance.android.shopping.orderlist.common.repo.OrderCommonApi;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.google.gson.Gson;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ma3.l;

/* JADX INFO: loaded from: classes12.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PlatformHttpRequestAPI f479991a = null;

    public static final class a<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Class f479992a;

        public a(Class r100) {
            this.f479992a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r110) {
            SsResponse r111 = (SsResponse) r110;
            Intrinsics.checkNotNullParameter(r111, "retrofitResponse");
            long r100 = System.currentTimeMillis();
            Gson r101 = u0.c();
            Object r102 = r111.body();
            if (r102 == null) goto L10;
            Object r103 = GsonProtectorUtils.fromJson(r101, (String) r102, this.f479992a);
            String r104 = l.a(r111);
            Object r112 = r111.raw().getExtraInfo();
            if ((r112 instanceof HttpRequestInfo) == true) goto L8;
            r112 = null;
        L8:
            return new g(r103, r104, (HttpRequestInfo) r112, Long.valueOf(r100), Long.valueOf(System.currentTimeMillis()));
        L10:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f479993a;

        public b(Function1 r100) {
            this.f479993a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f479993a.invoke(Result.m9448boximpl(Result.m9449constructorimpl((g) r100)));
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f479994a;

        public c(Function1 r100) {
            this.f479994a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Function1 r101 = this.f479994a;
            Result.Companion r102 = Result.Companion;
            r101.invoke(Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure((Throwable) r100))));
        }
    }

    static {
        f479991a = (PlatformHttpRequestAPI) n.f48128a.create(OrderCommonApi.API_HOST, PlatformHttpRequestAPI.class, new g43.a(new Gson()), null);
    }

    public static void a(QueryMethod r100, String r101, Map r102, Class r103, Function1 r104) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r101, "path");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r104, "completion");
        int r105 = h.f479990a[r100.ordinal()];
        if (r105 != 1) goto L5;
        Observable<SsResponse<String>> r106 = f479991a.get(r101, r102);
    L10:
        Observable<R> r107 = r106.subscribeOn(Schedulers.newThread()).map(new a(r103));
        d.f479975c.getClass();
        com.bytedance.android.ec.core.async.a.b(r107.observeOn(d.f479974b).subscribe(new b(r104), new c(r104)));
        return;
    L5:
        if (r105 != 2) goto L8;
        r106 = f479991a.post(r101, r102);
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }
}
