package com.bytedance.android.shopping.collect.repo;

import com.bytedance.android.shopping.collect.container.CollectYataQueryFrom;
import com.bytedance.android.shopping.collect.container.CollectYataSkeletonLoadingStatus;
import com.bytedance.android.shopping.collect.container.CollectYataViewModel;
import com.bytedance.android.shopping.collect.container.d;
import com.bytedance.android.shopping.collect.monitor.duration.CollectYataFirstScreenDurationMonitor;
import com.bytedance.android.shopping.collect.monitor.duration.CollectYataFirstScreenPoint;
import com.bytedance.android.shopping.collect.repo.model.CollectParams;
import com.bytedance.android.shopping.collect.util.CollectCommonLog;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.common.init.PackYataSdkConfig;
import com.bytedance.kmp.ec.yata.common.protocol.data.e;
import com.bytedance.kmp.ec.yata.common.protocol.data.f;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CollectYataQueryFetcher {
    public final Lazy a;
    public final Lazy b;
    public Function1<? super com.bytedance.android.shopping.collect.repo.a, Unit> c;
    public Disposable d;
    public Function0<AndroidYaTaInstance> e;
    public boolean f;
    public volatile com.bytedance.android.shopping.collect.repo.a g;
    public final CollectParams h;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ CollectYataQueryFetcher a;
        public final /* synthetic */ CollectYataQueryFrom b;
        public final /* synthetic */ CollectYataViewModel c;

        public a(CollectYataQueryFetcher r1, CollectYataQueryFrom r2, CollectYataViewModel r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r10) {
            int r1 = 0;
            this.a.f = false;
            e r11 = (e) ((Pair) r10).getFirst();
            if (f.d(r11) == false) goto L27;
            pb3.a r0 = this.a.a();
            if (r0 == null) goto L21;
            String r3 = f.b(r11);
            if (r3 != null) goto L9;
        L12:
            boolean r4 = true;
        L13:
            if (r4 == true) goto L21;
            r0.e = r0.f;
            r0.f = r3;
            JSONObject r5 = new JSONObject();
            r5.put("pre_log_id", r0.e);
            r5.put("cur_log_id", r0.f);
            com.bytedance.android.shopping.collect.monitor.error.a r2 = r0.c;
            if (r2 == null) goto L21;
            Intrinsics.checkNotNullParameter(r5, "params");
            Iterator<String> r6 = r5.keys();
        L19:
            if (r6.hasNext() == false) goto L21;
            String r7 = r6.next();
            r2.a.put(r7, r5.opt(r7));
            goto L19
        L9:
            if (StringsKt.isBlank(r3) == true) goto L12;
            r4 = false;
        L21:
            Lazy r8 = CollectCommonLog.a;
            CollectCommonLog.c("CollectYataQueryFetcher", this.b.getValue() + ":接口请求成功  logId:" + f.b(r11));
            pb3.a r9 = this.a.a();
            if (r9 == null) goto L26;
            CollectYataFirstScreenDurationMonitor r12 = r9.b;
            if (r12 == null) goto L26;
            CollectYataFirstScreenDurationMonitor.a(r12, CollectYataFirstScreenPoint.REQUEST_END);
        L26:
            CollectYataQueryFetcher r13 = this.a;
            CollectYataQueryFrom r14 = this.b;
            r13.c(new com.bytedance.android.shopping.collect.repo.a(r14, new d(r14, r11), new com.bytedance.android.shopping.collect.container.a(this.b, CollectYataSkeletonLoadingStatus.SUCCESS, 0)));
            return;
        L27:
            Lazy r15 = CollectCommonLog.a;
            StringBuilder r16 = new StringBuilder();
            r16.append(this.b.getValue() + ":接口请求失败  statusCode:" + r11.a() + "  statusmsg:" + r11.b() + "  logId:" + f.b(r11));
            Unit r17 = Unit.INSTANCE;
            CollectCommonLog.b("CollectYataQueryFetcher", r16.toString());
            CollectYataQueryFetcher r18 = this.a;
            CollectYataQueryFrom r19 = this.b;
            d r20 = new d(r19, r11);
            CollectYataQueryFrom r21 = this.b;
            CollectYataSkeletonLoadingStatus r22 = CollectYataSkeletonLoadingStatus.ERROR;
            Integer r23 = r11.a();
            if (r23 == null) goto L30;
            r1 = r23.intValue();
        L30:
            r18.c(new com.bytedance.android.shopping.collect.repo.a(r19, r20, new com.bytedance.android.shopping.collect.container.a(r21, r22, r1)));
            if (this.b != CollectYataQueryFrom.FIRST_ENTER) goto L39;
            int r24 = tb3.a.a;
            LinkedHashMap r25 = new LinkedHashMap();
            r25.put("error_code", String.valueOf(r11.a()));
            String r26 = r11.b();
            if (r26 != null) goto L35;
            r26 = "";
        L35:
            r25.put("error_msg", r26);
            r25.put("log_id", f.b(r11));
            tb3.a.a("res_fail", r25, this.c);
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ CollectYataQueryFetcher a;
        public final /* synthetic */ CollectYataQueryFrom b;
        public final /* synthetic */ CollectYataViewModel c;

        public b(CollectYataQueryFetcher r1, CollectYataQueryFrom r2, CollectYataViewModel r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r6) {
            Throwable r7 = (Throwable) r6;
            this.a.f = false;
            Lazy r0 = CollectCommonLog.a;
            CollectCommonLog.b("CollectYataQueryFetcher", this.b.getValue() + ":接口请求网络异常  " + r7);
            if (this.b != CollectYataQueryFrom.FIRST_ENTER) goto L5;
            int r1 = tb3.a.a;
            tb3.a.a("net_fail", MapsKt.mapOf(TuplesKt.to("msg", r7.toString())), this.c);
        L5:
            CollectYataQueryFetcher r8 = this.a;
            CollectYataQueryFrom r2 = this.b;
            r8.c(new com.bytedance.android.shopping.collect.repo.a(r2, null, new com.bytedance.android.shopping.collect.container.a(r2, CollectYataSkeletonLoadingStatus.ERROR, 0)));
        }
    }

    public final pb3.a a() {
        return (pb3.a) this.b.getValue();
    }

    public CollectYataQueryFetcher(CollectParams r2) {
        Intrinsics.checkNotNullParameter(r2, "collectParams");
        this.h = r2;
        this.a = LazyKt.lazy(CollectYataQueryFetcher$repository$2.INSTANCE);
        this.b = LazyKt.lazy(new CollectYataQueryFetcher$monitorManager$2(this));
    }

    public final void c(com.bytedance.android.shopping.collect.repo.a r2) {
        this.g = r2;
        Function1<? super com.bytedance.android.shopping.collect.repo.a, Unit> r0 = this.c;
        if (r0 == null) goto L6;
        Unit r3 = (Unit) r0.invoke(r2);
        return;
    }

    public final void b(CollectYataQueryFrom r7, CollectYataViewModel r8) {
        Intrinsics.checkNotNullParameter(r7, "queryFrom");
        Intrinsics.checkNotNullParameter(r8, "viewModel");
        if (this.f == false) goto L6;
        CollectCommonLog.c("CollectYataQueryFetcher", "hasStartQuery so return");
        return;
    L6:
        this.f = true;
        String r3 = null;
        c(new com.bytedance.android.shopping.collect.repo.a(r7, null, new com.bytedance.android.shopping.collect.container.a(r7, CollectYataSkeletonLoadingStatus.LOADING, 0)));
        Lazy r0 = CollectCommonLog.a;
        CollectCommonLog.c("CollectYataQueryFetcher", r7.getValue() + ":开始请求接口");
        pb3.a r1 = a();
        if (r1 == null) goto L11;
        CollectYataFirstScreenDurationMonitor r2 = r1.b;
        if (r2 == null) goto L11;
        CollectYataFirstScreenDurationMonitor.a(r2, CollectYataFirstScreenPoint.REQUEST_START);
    L11:
        Map<String, Object> r4 = new qb3.a(r7.getValue(), this.h).a();
        PackYataSdkConfig r5 = com.bytedance.kmp.ec.yata.common.init.b.a;
        Function0<AndroidYaTaInstance> r6 = this.e;
        if (r6 == null) goto L17;
        AndroidYaTaInstance r9 = (AndroidYaTaInstance) r6.invoke();
        if (r9 == null) goto L17;
        String r10 = r9.m();
        if (r10 == null) goto L17;
    L18:
        Function0<AndroidYaTaInstance> r11 = this.e;
        if (r11 == null) goto L23;
        AndroidYaTaInstance r12 = (AndroidYaTaInstance) r11.invoke();
        if (r12 == null) goto L23;
        r3 = ea6.b.a(ea6.b.b(r12, null), r12, null, null);
    L23:
        qb3.b r13 = new qb3.b(r4, r10, "1.23.7", r3);
        pb3.a r14 = a();
        if (r14 == null) goto L28;
        CollectYataFirstScreenDurationMonitor r15 = r14.b;
        if (r15 == null) goto L28;
        CollectYataFirstScreenDurationMonitor.a(r15, CollectYataFirstScreenPoint.QUERY_NET_START);
    L28:
        Disposable r16 = this.d;
        if (r16 == null) goto L31;
        r16.dispose();
    L31:
        this.d = ((com.bytedance.android.shopping.collect.repo.b) this.a.getValue()).query(r13, new CollectYataQueryFetcher$requestQuery$1(this), new CollectYataQueryFetcher$requestQuery$2(this)).subscribeOn(Schedulers.computation()).subscribe(new a(this, r7, r8), new b(this, r7, r8));
        return;
    L17:
        r10 = "";
        goto L18
    }
}
