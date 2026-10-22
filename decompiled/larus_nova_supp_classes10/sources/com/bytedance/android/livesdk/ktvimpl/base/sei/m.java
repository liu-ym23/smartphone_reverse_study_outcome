package com.bytedance.android.livesdk.ktvimpl.base.sei;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonSyntaxException;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m implements com.bytedance.android.livesdk.ktvimpl.base.sei.d, com.bytedance.android.livesdk.ktvimpl.base.sei.b, com.bytedance.android.live.liveinteract.plantform.utils.p {
    public String a;
    public Disposable b;
    public final List<Pair<com.bytedance.android.livesdk.ktvimpl.base.sei.c, Float>> c;
    public final Scheduler d;
    public final int e;
    public final ArrayBlockingQueue<u> f;
    public final Function1<String, String> g;
    public FunctionReferenceImpl h;
    public boolean i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public int m;
    public final l n;

    public static final class a {
    }

    public static final class b<T> implements Comparator<T> {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues((Float) ((Pair) r1).getSecond(), (Float) ((Pair) r2).getSecond());
        }
    }

    public static final class c implements ThreadFactory {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r3) {
            PthreadThreadV2 r0 = new PthreadThreadV2(r3, "ktv_sei_process_thread");
            ThreadMethodProxy.setPriority(r0, 10);
            return r0;
        }
    }

    public static final class d<T> implements ObservableOnSubscribe {
        public final /* synthetic */ m a;

        public d(m r1) {
            this.a = r1;
        }

        public final void subscribe(ObservableEmitter<w> r12) {
            Intrinsics.checkNotNullParameter(r12, "it");
            u r0 = this.a.f.poll();
            if (r0 != null) goto L5;
            return;
        L5:
            String r3 = r0.a;
            LiveSeiUtil.i.getClass();     // Catch: JSONException -> L22 JsonSyntaxException -> L24
            JSONObject r1 = LiveSeiUtil.c(r3);     // Catch: JSONException -> L22 JsonSyntaxException -> L24
            l r2 = this.a.n;     // Catch: JSONException -> L22 JsonSyntaxException -> L24
            r2.getClass();     // Catch: JSONException -> L22 JsonSyntaxException -> L24
            int r5 = 0;
            boolean r6 = false;
        L8:
            if (r5 >= ((ArrayList) r2.a).size()) goto L10;
            boolean r7 = true;
        L11:
            if (r7 == false) goto L19;
            int r9 = r5 + 1;     // Catch: JSONException -> L22 JsonSyntaxException -> L24
            Pair r8 = (Pair) ListProtector.get(r2.a, r5);     // Catch: JSONException -> L22 JsonSyntaxException -> L24
            String r10 = (String) r8.component1();     // Catch: JSONException -> L22 JsonSyntaxException -> L24
            Class r11 = (Class) r8.component2();     // Catch: JSONException -> L22 JsonSyntaxException -> L24
            String r13 = r1.optString(r10);     // Catch: JSONException -> L22 JsonSyntaxException -> L24
            if (r13.length() <= 0) goto L15;
            boolean r14 = true;
        L16:
            if (r14 == false) goto L18;
            r12.onNext(new w(r13, (com.bytedance.android.livesdk.ktvimpl.base.sei.a) GsonProtectorUtils.fromJson(GsonHelper.get(), r13, r11)));     // Catch: JSONException -> L22 JsonSyntaxException -> L24
            r6 = true;
        L18:
            r5 = r9;
            goto L8
        L15:
            r14 = false;
            goto L16
        L19:
            if (r6 == true) goto L32;
            r12.onError(new Exception("No sei model available: " + r3));     // Catch: JSONException -> L22 JsonSyntaxException -> L24
        L34:
            return;
        L32:
            return;
        L10:
            r7 = false;
        L24:
            e = move-exception;
            pd2.d.J(pd2.d.n, "parse_fail", r3, Long.valueOf(System.currentTimeMillis() - r0.b), this.a.f, 16);
            r12.onError(e);
            return;
        L22:
            e = move-exception;
            pd2.d.J(pd2.d.n, "parse_fail", r3, Long.valueOf(System.currentTimeMillis() - r0.b), this.a.f, 16);
            r12.onError(e);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ m a;

        public e(m r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            w r6 = (w) r5;
            this.a.f();
            if (this.a.a != null) goto L5;
        L7:
            Iterator r0 = ((ArrayList) this.a.c).iterator();
        L9:
            if (r0.hasNext() == false) goto L19;
            com.bytedance.android.livesdk.ktvimpl.base.sei.c r1 = (com.bytedance.android.livesdk.ktvimpl.base.sei.c) ((Pair) r0.next()).component1();
            com.bytedance.android.livesdk.ktvimpl.base.util.j r2 = com.bytedance.android.livesdk.ktvimpl.base.util.j.l;
            com.bytedance.android.livesdk.ktvimpl.base.sei.a r3 = r6.b;
            r2.getClass();
            com.bytedance.android.livesdk.ktvimpl.base.util.j.k(r3);
            if (r1.accept(r6) == false) goto L9;
            r1.onSeiResult(r6);
            goto L9
        L19:
            return;
        L5:
            if (Intrinsics.areEqual(r6.b.a(), this.a.a) == false) goto L7;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ m a;

        public f(m r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            this.a.f();
            pd2.d.J(pd2.d.n, "processor_fail", ((Throwable) r8).getMessage(), null, null, 28);
        }
    }

    static {
    }

    public final void e() {
        ALogger.i("logKtvMainPath", "releaseAll, invoke class :".concat(m.class.getSimpleName()));
        this.i = true;
        this.f.clear();
        this.b.dispose();
        this.d.shutdown();
        ((ArrayList) this.n.a).clear();
        ((ArrayList) this.c).clear();
    }

    public final void f() {
        if (this.f.isEmpty() == false) goto L5;
        return;
    L5:
        this.b = RxUtilKt.h(Observable.create(new d(this)).subscribeOn(this.d)).subscribe(new e(this), new f(this));
    }

    public m(l r4) {
        Intrinsics.checkNotNullParameter(r4, "modelRepo");
        this.n = r4;
        this.b = Disposables.disposed();
        this.c = new ArrayList();
        ReadOnlyProperty r5 = vm2.h.K3;
        KProperty[] r0 = vm2.h.a;
        if (((Boolean) r5.getValue(null, r0[243(0xf3, float:3.4E-43)])).booleanValue() == true) goto L5;
        io.reactivex.internal.schedulers.j r6 = new io.reactivex.internal.schedulers.j(c.a);
    L6:
        this.d = r6;
        int r7 = ((Number) vm2.h.x3.getValue(null, r0[230(0xe6, float:3.22E-43)])).intValue();
        this.e = r7;
        this.f = new ArrayBlockingQueue(r7);
        s r8 = s.a;
        r8.getClass();
        this.g = new SeiDataInterceptor$ktvRoomInstance$1(r8);
        this.h = new SeiDataInterceptor$instance$1(r8);
        this.j = ((Boolean) vm2.h.J3.getValue(null, r0[242(0xf2, float:3.39E-43)])).booleanValue();
        this.k = com.bytedance.android.live.core.utils.v.a();
        this.l = ((Boolean) vm2.h.F3.getValue(null, r0[238(0xee, float:3.34E-43)])).booleanValue();
        return;
    L5:
        r6 = Schedulers.computation();
        goto L6
    }

    public final Pair<String, Integer> a(JSONObject r8) {
        Intrinsics.checkNotNullParameter(r8, LocationMonitorConst.INFO);
        l r2 = this.n;     // Catch: Exception -> L17
        r2.getClass();     // Catch: Exception -> L17
        int r4 = 0;
    L5:
        if (r4 >= ((ArrayList) r2.a).size()) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == false) goto L20;
        int r6 = r4 + 1;     // Catch: Exception -> L17
        Pair r7 = (Pair) ListProtector.get(r2.a, r4);     // Catch: Exception -> L17
        String r9 = (String) r7.component1();     // Catch: Exception -> L17
        Class r10 = (Class) r7.component2();     // Catch: Exception -> L17
        JSONObject r11 = r8.optJSONObject(r9);     // Catch: Exception -> L17
        if (r11 != null) goto L11;
        r4 = r6;
        goto L5
    L11:
        String r3 = r9 + '_' + r11.optString("cmd") + '_' + r11.optString(BaseCoreViewModel.CORE_TAG_STATE);     // Catch: Exception -> L17
        int r12 = r11.optInt("sync_index", -1);     // Catch: Exception -> L17
        if (r12 != (-1)) goto L14;
        return null;
    L14:
        return new Pair(r3, Integer.valueOf(r12));
    L20:
        return null;
    L7:
        r5 = false;
    L17:
        int r13 = this.m + 1;
        this.m = r13;
        if (r13 >= 5) goto L20;
        ALogger.e("getStreamInfoParam", r8.toString());
        goto L20
    }

    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.INFO);
        d(this, r2);
    }

    public final void g(com.bytedance.android.livesdk.ktvimpl.base.sei.c r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        ALogger.i("logKtvMainPath", ("registerByPriority:" + r4) + ", invoke class :" + m.class.getSimpleName());
        Iterator r0 = ((ArrayList) this.c).iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        Pair r1 = (Pair) r0.next();
        if (Intrinsics.areEqual((com.bytedance.android.livesdk.ktvimpl.base.sei.c) r1.getFirst(), r4) == false) goto L4;
        ((ArrayList) this.c).remove(r1);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.d
    public final void c(com.bytedance.android.livesdk.ktvimpl.base.sei.c r3, float r4) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        ALogger.i("logKtvMainPath", ("registerByPriority:" + r3) + ", invoke class :" + m.class.getSimpleName());
        ((ArrayList) this.c).add(TuplesKt.to(r3, Float.valueOf(r4)));
        ArrayList r5 = (ArrayList) this.c;
        if (r5.size() <= 1) goto L6;
        CollectionsKt.sortWith(r5, new b());
        return;
    }

    public final void d(com.bytedance.android.livesdk.ktvimpl.base.sei.b r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "source");
        Intrinsics.checkNotNullParameter(r9, "seiData");
        String r10 = (String) this.h.invoke(r9);
        if (r10 != null) goto L6;
        return;
    L6:
        if (this.k == false) goto L11;
        if (this.l == false) goto L11;
        ALogger.i("rawSei", r9);
    L11:
        if (this.j == false) goto L17;
        if (this.i == false) goto L17;
        ALogger.i("ktvseiprocessor", "has release");
        return;
    L17:
        if (this.f.size() < this.e) goto L19;
        pd2.d.J(pd2.d.n, "cache_full", null, null, this.f, 22);
        ALogger.i(bb0.b.b(), "addRawSeiData over size, invoke class :".concat(m.class.getSimpleName()));
        this.f.clear();
    L19:
        this.f.offer(new u(r10, System.currentTimeMillis()));
        f();
    }
}
