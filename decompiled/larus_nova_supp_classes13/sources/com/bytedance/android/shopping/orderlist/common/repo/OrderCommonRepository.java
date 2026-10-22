package com.bytedance.android.shopping.orderlist.common.repo;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.utils.n;
import com.bytedance.kmp.ec.yata.common.protocol.data.e;
import com.bytedance.kmp.ec.yata.common.protocol.data.f;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v96.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderCommonRepository {
    public static final /* synthetic */ int a = 0;

    public static final class a<T> implements Consumer {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void accept(Object r2) {
            SsResponse r3 = (SsResponse) r2;
            Lazy r4 = OrderCommonLog.a;
            OrderCommonLog.c("OrderCommonRepository", OrderCommonRepository$firstQuery$1$1.INSTANCE);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ com.bytedance.android.shopping.orderlist.common.monitor.error.a a;

        public b(com.bytedance.android.shopping.orderlist.common.monitor.error.a r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            final Throwable r4 = (Throwable) r3;
            String r0 = "OrderCommonRepository-firstQuery: " + r4.getMessage();
            Lazy r1 = OrderCommonLog.a;
            OrderCommonLog.c("OrderCommonRepository", new OrderCommonRepository$firstQuery$3$1(r4));
            OrderCommonErrorMonitorKt.b(this.a, "API_NET_ERROR", r0);
            n.a("网络异常", false, false);
        }
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ Function0 a;
        public final /* synthetic */ com.bytedance.android.shopping.orderlist.common.monitor.error.a b;
        public final /* synthetic */ Function1 c;

        public c(Function0 r1, com.bytedance.android.shopping.orderlist.common.monitor.error.a r2, Function1 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object apply(Object r7) {
            SsResponse r8 = (SsResponse) r7;
            Intrinsics.checkNotNullParameter(r8, "it");
            Function0 r0 = this.a;
            if (r0 == null) goto L5;
            Unit r1 = (Unit) r0.invoke();
        L5:
            final e r2 = (e) GsonProtectorUtils.fromJson(u0.c(), (String) r8.body(), e.class);
            List r3 = r8.headers();
            ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
            Iterator<T> r5 = r3.iterator();
        L7:
            if (r5.hasNext() == false) goto L9;
            Header r6 = (Header) r5.next();
            r4.add(new k(r6.getName(), r6.getValue()));
            goto L7
        L9:
            ((com.bytedance.kmp.ec.yata.common.protocol.data.a) r2).a = r4;
            Lazy r9 = OrderCommonLog.a;
            OrderCommonLog.c("OrderCommonRepository", new OrderCommonRepository$mapQueryResponse$1$1(r2));
            if (f.c(r2) == false) goto L12;
            OrderCommonErrorMonitorKt.a(this.b, "API_ERROR", "OrderCommonRepository-mapQueryResponse: code:" + r2.a() + " msg:" + r2.b(), MapsKt.mapOf(TuplesKt.to("log_id", f.b(r2))));
        L12:
            Function1 r10 = this.c;
            if (r10 == null) goto L15;
            Unit r11 = (Unit) r10.invoke(r8);
        L15:
            return r2;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r2) {
            e r3 = (e) r2;
            if (f.c(r3) == false) goto L6;
            int r0 = n.a;
            n.a(r3.b(), false, false);
            return;
        }
    }

    static {
    }

    public static Observable a(com.bytedance.android.shopping.orderlist.common.monitor.error.a r3, OrderCommonYataRequest r4) {
        Intrinsics.checkNotNullParameter(r4, "req");
        OrderCommonApi.Companion.getClass();
        return ((OrderCommonApi) com.bytedance.android.ec.sdk.helper.n.a.create(OrderCommonApi.API_HOST, OrderCommonApi.class)).getQuery(r4).doOnNext(a.a).doOnComplete(OrderCommonRepository$firstQuery$2.a).doOnError(new b(r3));
    }

    public static Observable b(Observable r1, com.bytedance.android.shopping.orderlist.common.monitor.error.a r2, Function0 r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r1, "$this$mapQueryResponse");
        return r1.map(new c(r3, r2, r4)).doOnNext(d.a);
    }
}
