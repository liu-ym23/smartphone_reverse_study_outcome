package com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.TableDataModel;
import com.bytedance.ee.bear.bitable.n;
import com.bytedance.ee.util.ui.j;
import com.bytedance.locallife.cube.PrefetchTiming;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import vv4.k;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f209054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<nq4.c<nq4.d>> f209055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f209056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f209057d;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async.a$a, reason: collision with other inner class name */
    public static final class C3012a {
    }

    public static final class b extends com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async.emit.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f209058b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ nq4.c<T> f209059c;

        @Override // io.reactivex.functions.Action
        public final void run() {
            a r100 = this.f209058b;
            nq4.c<T> r101 = this.f209059c;
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async.AsyncFetchTask<com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async.IAsyncModel>");
            r100.getClass();
            FlowableEmitter<AsyncFetchResult<T>> r102 = r101.f520125b;
            nq4.b<T> r103 = r101.f520124a;
            String r104 = r103.f520121a;
            JSONObject r105 = r103.f520122b;
            nq4.a<T> r106 = r103.f520123c;
            if (r102.isCancelled() == false) goto L5;
            tt5.a.k("AsyncFetchManager", "tryAsyncFetch, emitter is cancelled, ignore event");
            return;
        L5:
            tt5.a.h("AsyncFetchManager", "tryAsyncFetch, task " + r101 + " start request");
            r100.f209054a.a(r104, r105, new com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async.c(r106, r102, r101, r100));
        }

        public b(JSONObject r100, a r101, nq4.c<T> r102) {
            this.f209058b = r101;
            this.f209059c = r102;
            super(r100);
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f209060a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f209061b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ nq4.c<T> f209062c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ FlowableEmitter<AsyncFetchResult<T>> f209063d;

        public c(String r100, a r101, nq4.c<T> r102, FlowableEmitter<AsyncFetchResult<T>> r103) {
            this.f209060a = r100;
            this.f209061b = r101;
            this.f209062c = r102;
            this.f209063d = r103;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final void a() {
            tt5.a.h("AsyncFetchManager", "request, funcName = " + this.f209060a + " timeout, remove task");
            CopyOnWriteArrayList<nq4.c<nq4.d>> r100 = this.f209061b.f209055b;
            nq4.c<T> r101 = this.f209062c;
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async.AsyncFetchTask<com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async.IAsyncModel>");
            if (r100.remove(r101) == false) goto L8;
            a r102 = this.f209061b;
            nq4.c<T> r103 = this.f209062c;
            r102.getClass();
            a.c(r103);
            if (this.f209063d.isCancelled() == true) goto L9;
            this.f209063d.onNext((AsyncFetchResult<T>) new AsyncFetchResult(null, AsyncFetchResult.EResultState.TIMEOUT));
            this.f209063d.onComplete();
            return;
        L9:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f209064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FlowableEmitter<AsyncFetchResult<T>> f209065b;

        public d(String r100, FlowableEmitter<AsyncFetchResult<T>> r101) {
            this.f209064a = r100;
            this.f209065b = r101;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final void a() {
            tt5.a.h("AsyncFetchManager", "emit loading event, funcName = " + this.f209064a);
            if (this.f209065b.isCancelled() == true) goto L6;
            this.f209065b.onNext((AsyncFetchResult<T>) new AsyncFetchResult(null, AsyncFetchResult.EResultState.LOADING));
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e<T> implements FlowableOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f209066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f209067b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ nq4.a<T> f209068c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JSONObject f209069d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ k f209070e;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async.a$e$a, reason: collision with other inner class name */
        public static final class C3013a<T> implements ValueCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f209071a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f209072b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ nq4.a<T> f209073c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ JSONObject f209074d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ FlowableEmitter<AsyncFetchResult<T>> f209075e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ Ref.ObjectRef<nq4.c<nq4.d>> f209076f;

            /* JADX WARN: Multi-variable type inference failed */
            public C3013a(String r100, a r101, nq4.a<? extends T> r102, JSONObject r103, FlowableEmitter<AsyncFetchResult<T>> r104, Ref.ObjectRef<nq4.c<nq4.d>> r105) {
                this.f209071a = r100;
                this.f209072b = r101;
                this.f209073c = r102;
                this.f209074d = r103;
                this.f209075e = r104;
                this.f209076f = r105;
            }

            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object r110) {
                String r111 = (String) r110;
                tt5.a.h("AsyncFetchManager", "request(), localWeb.execJS(), funcName = " + this.f209071a + ", mIsFetchDataParseAsyncEnable = " + this.f209072b.f209056c);
                if (this.f209072b.f209056c == false) goto L5;
                fo5.d.a().scheduleDirect(new com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async.b(this.f209072b, this.f209073c, r111, this.f209071a, this.f209074d, this.f209075e, this.f209076f));
                return;
            L5:
                a r100 = this.f209072b;
                nq4.a<T> r101 = this.f209073c;
                Intrinsics.checkNotNull(r111);
                String r102 = this.f209071a;
                JSONObject r103 = this.f209074d;
                FlowableEmitter<AsyncFetchResult<T>> r104 = this.f209075e;
                Intrinsics.checkNotNull(r104);
                a.a(r100, r101, r111, r102, r103, r104, this.f209076f.element);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public e(a r100, String r101, nq4.a<? extends T> r102, JSONObject r103, k r104) {
            this.f209066a = r100;
            this.f209067b = r101;
            this.f209068c = r102;
            this.f209069d = r103;
            this.f209070e = r104;
        }

        @Override // io.reactivex.FlowableOnSubscribe
        public final void subscribe(FlowableEmitter<AsyncFetchResult<T>> r110) {
            Intrinsics.checkNotNullParameter(r110, "emitter");
            if (this.f209066a.f209057d == false) goto L5;
        L7:
            boolean r100 = false;
        L8:
            tt5.a.h("AsyncFetchManager", "request(), needPreAddTask: " + r100 + ", funcName = " + this.f209067b);
            a r101 = this.f209066a;
            String r102 = this.f209067b;
            r101.getClass();
            tt5.a.h("AsyncFetchManager", "removePreTask(), funcName = " + r102);
            int r103 = com.bytedance.ee.bear.bitable.c.f207079a;
            int r104 = n.f214744a;
            if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.get_link_record_fetch_optimize_enable") == true) goto L12;
            tt5.a.h("AsyncFetchManager", "removePreTask() fg disable ,, funcName = " + r102);
        L22:
            Ref.ObjectRef r111 = new Ref.ObjectRef();
            if (r100 == false) goto L25;
            r111.element = (T) this.f209066a.b(this.f209068c, this.f209067b, this.f209069d, r110);
        L25:
            k r105 = this.f209070e;
            String r106 = this.f209067b;
            JSONObject r107 = this.f209069d;
            r105.a(r106, r107, new C3013a(r106, this.f209066a, this.f209068c, r107, r110, r111));
            return;
        L12:
            if (Intrinsics.areEqual(r102, "javascript:window.lark.biz.bitable.getLinkCardList") == true) goto L14;
            tt5.a.h("AsyncFetchManager", "removePreTask() not getLinkCardList, , funcName = " + r102);
            goto L22
        L14:
            Iterator<nq4.c<nq4.d>> r108 = r101.f209055b.iterator();
        L16:
            if (r108.hasNext() == false) goto L22;
            nq4.c<nq4.d> r109 = r108.next();
            if (Intrinsics.areEqual(r109.f520124a.f520121a, r102) == false) goto L16;
            if (r101.f209055b.remove(r109) == false) goto L16;
            Intrinsics.checkNotNull(r109);
            a.c(r109);
            goto L16
        L5:
            if (TextUtils.equals(this.f209067b, "javascript:window.lark.biz.bitable.getLinkCardList") == false) goto L7;
            r100 = true;
            goto L8
        }
    }

    static {
    }

    public a(k r100) {
        Intrinsics.checkNotNullParameter(r100, "web");
        this.f209054a = r100;
        this.f209055b = new CopyOnWriteArrayList();
        this.f209056c = com.bytedance.ee.bear.appsetting.c.a.f206237a.h("base.record.fetchlist.result_async.enable");
        int r101 = com.bytedance.ee.bear.bitable.core.usercomponent.d.f210603a;
        Intrinsics.checkNotNullParameter("base.fix.link.loaded.timeout.disable", "key");
        this.f209057d = com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.fix.link.loaded.timeout.disable");
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public static void c(nq4.c r100) {
        tt5.a.h("AsyncFetchManager", "onRemoveTask(), funcName = " + r100.f520124a.f520121a);
        String r101 = r100.f520124a.f520121a;
        int r102 = StringsKt.lastIndexOf$default(r101, ".", 0, false, 6, null) + 1;
        if (r102 >= r101.length()) goto L5;
        r101 = r101.substring(r102, r101.length());
    L5:
        ConcurrentHashMap<Pair<String, String>, CopyOnWriteArrayList<WeakReference<com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async.emit.a>>> r103 = com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async.emit.b.f209089a;
        com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async.emit.a r104 = r100.f520126c;
        Runnable r105 = null;
        if (r104 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("action");
        r104 = null;
    L9:
        Intrinsics.checkNotNullParameter("dataLoaded", "event");
        Intrinsics.checkNotNullParameter(r101, PrefetchTiming.ROUTER);
        Intrinsics.checkNotNullParameter(r104, "action");
        tt5.a.b("JsEventEmitter", "off: event = dataLoaded, router = " + r101);
        Pair<String, String> r106 = new Pair("dataLoaded", r101);
        CopyOnWriteArrayList<WeakReference<com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async.emit.a>> r107 = com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async.emit.b.f209089a.get(r106);
        if (r107 == null) goto L21;
        CopyOnWriteArrayList r108 = new CopyOnWriteArrayList();
        Iterator<T> r109 = r107.iterator();
    L13:
        if (r109.hasNext() == false) goto L18;
        Object r110 = r109.next();
        if ((!Intrinsics.areEqual(((WeakReference) r110).get(), r104)) == false) goto L13;
        r108.add(r110);
        goto L13
    L18:
        if (r108.isEmpty() == false) goto L20;
        com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async.emit.b.f209089a.remove(r106);
        goto L21
    L20:
        com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async.emit.b.f209089a.put(r106, (CopyOnWriteArrayList<WeakReference<com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async.emit.a>>) r108);
    L21:
        Runnable r111 = r100.f520127d;
        if (r111 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("timeoutCallback");
        r111 = null;
    L25:
        j.e(r111);
        Runnable r112 = r100.f520128e;
        if (r112 == null) goto L28;
        r105 = r112;
    L29:
        j.e(r105);
        return;
    L28:
        Intrinsics.throwUninitializedPropertyAccessException("loadingCallback");
        goto L29
    }

    public final <T extends nq4.d> Flowable<AsyncFetchResult<T>> d(String r100, JSONObject r101, nq4.a<? extends T> r110) {
        Intrinsics.checkNotNullParameter(r100, "funcName");
        Intrinsics.checkNotNullParameter(r101, "funcParams");
        Intrinsics.checkNotNullParameter(r110, "parser");
        return Flowable.create(new e(this, r100, r110, r101, this.f209054a), BackpressureStrategy.BUFFER).subscribeOn(fo5.d.a());
    }

    public final <T extends nq4.d> nq4.c<nq4.d> b(nq4.a<? extends T> r100, String r110, JSONObject r111, FlowableEmitter<AsyncFetchResult<T>> r112) {
        tt5.a.h("AsyncFetchManager", "addRequestTask(),  funcName = " + r110);
        nq4.c<nq4.d> r101 = new nq4.c(new nq4.b(r110, r111, r100), r112);
        b r102 = new b(r111, this, r101);
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f520126c = r102;
        c r103 = new c(r110, this, r101, r112);
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r101.f520127d = r103;
        d r104 = new d(r110, r112);
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r101.f520128e = r104;
        tt5.a.h("AsyncFetchManager", "request, loading, add task " + r101);
        this.f209055b.add(r101);
        ConcurrentHashMap<Pair<String, String>, CopyOnWriteArrayList<WeakReference<com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async.emit.a>>> r113 = com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async.emit.b.f209089a;
        boolean r114 = true;
        int r115 = StringsKt.lastIndexOf$default(r110, ".", 0, false, 6, null) + 1;
        if (r115 >= r110.length()) goto L5;
        String r116 = r110.substring(r115, r110.length());
    L6:
        com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async.emit.a r105 = r101.f520126c;
        Runnable r106 = null;
        if (r105 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("action");
        r105 = null;
    L10:
        Intrinsics.checkNotNullParameter("dataLoaded", "event");
        Intrinsics.checkNotNullParameter(r116, PrefetchTiming.ROUTER);
        Intrinsics.checkNotNullParameter(r105, "action");
        tt5.a.b("JsEventEmitter", "on: event = dataLoaded, router = " + r116);
        Pair<String, String> r107 = new Pair("dataLoaded", r116);
        ConcurrentHashMap<Pair<String, String>, CopyOnWriteArrayList<WeakReference<com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async.emit.a>>> r117 = com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async.emit.b.f209089a;
        CopyOnWriteArrayList<WeakReference<com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async.emit.a>> r108 = r117.get(r107);
        if (r108 != null) goto L13;
        r108 = new CopyOnWriteArrayList();
        r117.put(r107, r108);
    L13:
        Iterator<T> r118 = r108.iterator();
    L15:
        if (r118.hasNext() == false) goto L19;
        if (Intrinsics.areEqual(((WeakReference) r118.next()).get(), r105) == false) goto L15;
        r114 = false;
    L19:
        if (r114 == true) goto L22;
        r108 = null;
    L22:
        if (r108 == null) goto L24;
        r108.add(new WeakReference(r105));
    L24:
        int r119 = com.bytedance.ee.bear.bitable.c.f207079a;
        int r120 = n.f214744a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.get_link_record_fetch_optimize_enable") == false) goto L27;
        long r121 = 20000;
    L28:
        tt5.a.h("AsyncFetchManager", "addRequestTask(), funcName = " + r110 + ", timeOutLimit = " + r121);
        Runnable r122 = r101.f520127d;
        if (r122 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("timeoutCallback");
        r122 = null;
    L32:
        j.d(r122, r121);
        Runnable r123 = r101.f520128e;
        if (r123 == null) goto L35;
        r106 = r123;
    L36:
        j.d(r106, 200);
        return r101;
    L35:
        Intrinsics.throwUninitializedPropertyAccessException("loadingCallback");
        goto L36
    L27:
        r121 = 10000;
        goto L28
    L5:
        r116 = r110;
        goto L6
    }

    public static final void a(a r100, nq4.a r101, String r110, String r111, JSONObject r112, FlowableEmitter r113, nq4.c r114) {
        r100.getClass();
        TableDataModel r115 = r101.parse(r110);     // Catch: Exception -> L24
        if (r115 == null) goto L23;
        boolean r102 = r115.isLoading();     // Catch: Exception -> L24
        tt5.a.h("AsyncFetchManager", "handleValue(), isLoading: " + r102 + ", funcName = " + r111);     // Catch: Exception -> L24
        if (r102 == false) goto L9;
        if (r114 != null) goto L30;
        r100.b(r101, r111, r112, r113);     // Catch: Exception -> L24
        return;
    L30:
        return;
    L9:
        StringBuilder r103 = new StringBuilder("request, loaded,, funcName = ");     // Catch: Exception -> L24
        r103.append(r111);     // Catch: Exception -> L24
        r103.append(" preTask !=null ");     // Catch: Exception -> L24
        if (r114 == null) goto L12;
        boolean r116 = true;
    L13:
        r103.append(r116);     // Catch: Exception -> L24
        tt5.a.h("AsyncFetchManager", r103.toString());     // Catch: Exception -> L24
        if (r114 == null) goto L19;
        if (r100.f209055b.remove(r114) == false) goto L19;
        c(r114);     // Catch: Exception -> L24
    L19:
        if (r113.isCancelled() == true) goto L21;
        tt5.a.h("AsyncFetchManager", "request, handleValue(),emitter is not Cancelled, emitter.onNext(),funcName = " + r111);     // Catch: Exception -> L24
        r113.onNext(new AsyncFetchResult(r115, AsyncFetchResult.EResultState.LOADED));     // Catch: Exception -> L24
        r113.onComplete();     // Catch: Exception -> L24
        return;
    L21:
        tt5.a.h("AsyncFetchManager", "request, handleValue(), emitter is cancelled, funcName = " + r111);     // Catch: Exception -> L24
        return;
    L12:
        r116 = false;
        goto L13
    L23:
        throw new IllegalArgumentException("value is null!");     // Catch: Exception -> L24
    L24:
        e = move-exception;
        tt5.a.e("AsyncFetchManager", "request,  funcName = " + r111 + " parse failed", e, false);
        if (r113.isCancelled() == true) goto L34;
        r113.onError(e);
        return;
    }
}
