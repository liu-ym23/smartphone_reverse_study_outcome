package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallBatchReportJsb extends qf3.e {
    public final Lazy d;
    public final String e;
    public final CompositeDisposable f;

    public static final class a {
    }

    public static final class b implements ttc.b {
        public final /* synthetic */ Ref.IntRef a;
        public final /* synthetic */ List b;

        public b(Ref.IntRef r1, List r2) {
            this.a = r1;
            this.b = r2;
        }

        public final boolean getAsBoolean() {
            if (this.a.element < this.b.size()) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ List a;
        public final /* synthetic */ Ref.IntRef b;
        public final /* synthetic */ qf3.d c;
        public final /* synthetic */ Ref.ObjectRef d;

        public c(List r1, Ref.IntRef r2, qf3.d r3, Ref.ObjectRef r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            int r7 = this.a.size();
            int r0 = this.b.element;
            if (r0 < 0) goto L11;
            if (r7 <= r0) goto L11;
            Map r8 = (Map) CollectionsKt.getOrNull(this.a, r0);
            if (r8 == null) goto L11;
            Map r9 = MapsKt.toMutableMap(r8);
            if (r9 == null) goto L11;
            int r1 = ECMallReportJsb.f;
            ECMallReportJsb.a.a(r9, this.c);
            k93.g.a.a(this.c.b.j0, r9, (Map) this.d.element, null, 12);
        L11:
            this.b.element++;
        }
    }

    static {
    }

    @Override // qf3.e
    public final void release() {
        this.f.dispose();
    }

    public final String getName() {
        return this.e;
    }

    public ECMallBatchReportJsb(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
        this.d = LazyKt.lazy(ECMallBatchReportJsb$optFpsSetting$2.INSTANCE);
        this.e = "ec.mallBatchReport";
        this.f = new CompositeDisposable();
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r6, IBDXBridgeContext r7, Map<String, ? extends Object> r8, Map<String, Object> r9) {
        Intrinsics.checkNotNullParameter(r6, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r7, "bridgeContext");
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r9, "result");
        if (r6.b.A1.isAttached() == false) goto L45;
        if (r8.isEmpty() == true) goto L45;
        if (r8.get("list") == null) goto L45;
        Ref.ObjectRef r10 = new Ref.ObjectRef();
        r10.element = null;
        if (((Boolean) this.d.getValue()).booleanValue() == true) goto L12;
    L14:
        Object r11 = r8.get("list");
        if ((r11 instanceof List) == true) goto L17;
        r11 = null;
    L17:
        List r12 = (List) r11;
        if (r12 != null) goto L20;
        r12 = CollectionsKt.emptyList();
    L20:
        int r13 = s93.c.a;
        Object r1 = 0;
        IHybridHostService r2 = com.bytedance.android.ec.hybrid.a.h();
        if (r2 == null) goto L28;
        yj.g r3 = r2.getHostAB();
        if (r3 == null) goto L28;
        Object r4 = r3.a("mall_tab_opt_async_or_disperse", r1);
        if (r4 == null) goto L28;
        r1 = r4;
    L28:
        Lazy r5 = ECMallLogUtil.a;
        com.bytedance.android.ec.hybrid.log.mall.c.a r14 = com.bytedance.android.ec.hybrid.log.mall.c.a.b;
        ECMallLogUtil.c(r14, "Key : mall_tab_opt_async_or_disperse, Value: " + r1);
        if (((Number) r1).intValue() != 1) goto L39;
        Object r0 = 20L;
        IHybridHostService r15 = com.bytedance.android.ec.hybrid.a.h();
        if (r15 == null) goto L38;
        yj.g r16 = r15.getHostAB();
        if (r16 == null) goto L38;
        Object r17 = r16.a("mall_tab_opt_interval_time", r0);
        if (r17 == null) goto L38;
        r0 = r17;
    L38:
        ECMallLogUtil.c(r14, "Key : mall_tab_opt_interval_time, Value: " + r0);
        long r18 = ((Number) r0).longValue();
        Ref.IntRef r19 = new Ref.IntRef();
        r19.element = 0;
        this.f.add(Observable.timer(r18, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).repeatUntil(new b(r19, r12)).subscribe(new c(r12, r19, r6, r10)));
    L47:
        return qf3.e.f(this);
    L39:
        Iterator r20 = r12.iterator();
    L41:
        if (r20.hasNext() == false) goto L47;
        Map r21 = MapsKt.toMutableMap((Map) r20.next());
        int r22 = ECMallReportJsb.f;
        ECMallReportJsb.a.a(r21, r6);
        k93.g.a.a(r6.b.j0, r21, (Map) r10.element, null, 12);
        goto L41
    L12:
        if (r8.get("list") == null) goto L14;
        r10.element = r6.b.j0.c();
    L45:
        return qf3.e.c("container is not attached or params is empty or list is null");
    }
}
