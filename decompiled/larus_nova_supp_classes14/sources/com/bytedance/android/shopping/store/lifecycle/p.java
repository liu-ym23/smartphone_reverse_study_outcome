package com.bytedance.android.shopping.store.lifecycle;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import com.bytedance.android.ec.hybrid.list.ECHybridListAdapter;
import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.ec.store.utils.taskmanager.ECTaskManager;
import com.bytedance.android.ec.store.utils.taskmanager.TaskPriority;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.entity.ECShopHeadInfoBlock;
import com.bytedance.android.shopping.store.home.entity.ECStoreHomeTabResponseTabkit;
import com.bytedance.android.shopping.store.home.entity.ECStoreTabAreaVO;
import com.bytedance.android.shopping.store.home.preload.resource.PageType;
import com.bytedance.android.shopping.store.hybrid.StoreTabConfig;
import com.bytedance.android.shopping.store.hybrid.entity.ECStorePreloadInfoResponse;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class p implements com.bytedance.android.shopping.store.lifecycle.c {
    public final Handler a;
    public final long b;

    public static final class a implements Runnable {
        public final /* synthetic */ p a;

        public a(p r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Lazy r0 = ECTaskManager.b;     // Catch: Throwable -> L4
            ECTaskManager.a.a().c(this.a.b, TaskPriority.DO_EVERYTHING);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ p a;

        public b(p r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Lazy r0 = ECTaskManager.b;     // Catch: Throwable -> L4
            ECTaskManager.a.a().c(this.a.b, TaskPriority.AFTER_FIRST_SCREEN);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements MessageQueue.IdleHandler {
        public final /* synthetic */ p a;

        public c(p r1) {
            this.a = r1;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            Lazy r0 = ECTaskManager.b;
            ECTaskManager.a.a().c(this.a.b, TaskPriority.AFTER_FIRST_SCREEN_IDLE);
            return false;
        }
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void C() {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void D(StoreTabConfig r1, int r2, int r3, Integer r4, Integer r5, String r6, String r7, String r8) {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void F(uj3.j r1, long r2) {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void H() {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void K() {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void M(int r1, int r2) {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void N(StoreTabConfig r1) {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void O() {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void R(StoreTabConfig r1) {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void T() {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void a() {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void b() {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void d(Throwable r1, CommerceBaseResponse r2) {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void e(StoreTabConfig r1) {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void f() {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void g() {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void i(StoreTabConfig r1) {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void k(StoreTabConfig r1) {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void l() {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void n() {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void onPause() {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void r(int r1, int r2) {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void s(StoreTabConfig r1) {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void t() {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void v() {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void w() {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void x(StoreTabConfig r1) {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void y() {
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void j() {
        this.a.postDelayed(new a(this), 1500);
    }

    public p(long r1) {
        this.b = r1;
        this.a = new Handler(Looper.getMainLooper());
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void A(ECStoreParam r2) {
        Intrinsics.checkNotNullParameter(r2, "storeParam");
        Intrinsics.checkNotNullParameter(r2, "storeParam");
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void L(f r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r2, "item");
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void Q(ECStoreParam r2) {
        Intrinsics.checkNotNullParameter(r2, "storeParam");
        Intrinsics.checkNotNullParameter(r2, "storeParam");
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void c(StoreTabConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "tabConfig");
        Intrinsics.checkNotNullParameter(r2, "tabConfig");
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void h(ECStorePreloadInfoResponse r2) {
        Intrinsics.checkNotNullParameter(r2, "preloadInfo");
        Intrinsics.checkNotNullParameter(r2, "preloadInfo");
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void m(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "preContext");
        Intrinsics.checkNotNullParameter(r2, "preContext");
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void o(ECShopHeadInfoBlock r2) {
        Intrinsics.checkNotNullParameter(r2, "response");
        Intrinsics.checkNotNullParameter(r2, "response");
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void onResume(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void z(ECStorePreloadInfoResponse r2) {
        Intrinsics.checkNotNullParameter(r2, "preloadInfo");
        Intrinsics.checkNotNullParameter(r2, "preloadInfo");
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void I(StoreTabConfig r2, Map<String, Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "tabConfig");
        Intrinsics.checkNotNullParameter(r3, "metaInfo");
        com.bytedance.android.shopping.store.lifecycle.c.a.b(r2, r3);
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void S(int r1, ECHybridListAdapter r2) {
        Intrinsics.checkNotNullParameter(r2, "listAdapter");
        Intrinsics.checkNotNullParameter(r2, "listAdapter");
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void q(Context r2, ECStoreParam r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "storeParam");
        com.bytedance.android.shopping.store.lifecycle.c.a.i(r2, r3);
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void G(ECStoreParam r2, ECStoreTabAreaVO r3, ECStoreHomeTabResponseTabkit r4) {
        Intrinsics.checkNotNullParameter(r2, "storeParam");
        Intrinsics.checkNotNullParameter(r3, "tabData");
        Intrinsics.checkNotNullParameter(r4, "response");
        com.bytedance.android.shopping.store.lifecycle.c.a.j(r2, r3, r4);
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void J(ECStoreViewModel r1, ECStoreParam r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "viewModel");
        Intrinsics.checkNotNullParameter(r2, "storeParam");
        com.bytedance.android.shopping.store.lifecycle.c.a.e(r1, r2);
        Lazy r4 = ECTaskManager.b;
        ECTaskManager r5 = ECTaskManager.a.a();
        long r6 = this.b;
        Map r7 = r5.a;
        LinkedHashMap r8 = (LinkedHashMap) r7;
        com.bytedance.android.ec.store.utils.taskmanager.b r9 = (com.bytedance.android.ec.store.utils.taskmanager.b) r8.get(Long.valueOf(r6));
        if (r9 == null) goto L6;
        ((LinkedHashMap) r9.a).clear();
        return;
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void P(String r1, Map<String, ? extends Object> r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r1, "eventName");
        Intrinsics.checkNotNullParameter(r1, "eventName");
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void p(StoreTabConfig r1, JSONObject r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "filterParams");
        Intrinsics.checkNotNullParameter(r2, "filterParams");
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void u(ECStoreParam r2, com.bytedance.android.shopping.store.home.entity.n r3, CommerceBaseResponse r4) {
        Intrinsics.checkNotNullParameter(r2, "storeParam");
        Intrinsics.checkNotNullParameter(r3, "infoData");
        Intrinsics.checkNotNullParameter(r4, "response");
        com.bytedance.android.shopping.store.lifecycle.c.a.c(r2, r3, r4);
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void B(Context r1, ECStoreParam r2, JSONObject r3, PageType r4) {
        Intrinsics.checkNotNullParameter(r2, "storeParam");
        Intrinsics.checkNotNullParameter(r4, "pageType");
        com.bytedance.android.shopping.store.lifecycle.c.a.f(r2, r4);
    }

    @Override // com.bytedance.android.shopping.store.lifecycle.c
    public final void E(ECStoreViewModel r1, StoreTabConfig r2, ECStoreParam r3, JSONObject r4, JSONObject r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r1, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "storeParam");
        com.bytedance.android.shopping.store.lifecycle.c.a.g(r1, r3);
        this.a.post(new b(this));
        Looper.myQueue().addIdleHandler(new c(this));
    }
}
