package com.bytedance.ee.bear.document.offline.sync;

import android.os.Handler;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.offline.OfflineCacheConfig;
import com.bytedance.ee.bear.document.offline.sync.preloadexecutor.subblock.SubBlockModel;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import io.reactivex.Flowable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes16.dex */
public final class h0 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Long f220589j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Long f220590k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static OfflineCacheConfig f220591l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static Boolean f220592m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static Boolean f220593n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final boolean f220594o = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.ee.bear.contract.j f220595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LiveData<ConnectionService.NetworkState> f220596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public q25.a f220597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b0 f220598d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public u25.j f220599e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public x25.d f220600f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f220601g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, WeakReference<q25.f>> f220602h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f220603i;

    public class a implements Observer<ConnectionService.NetworkState> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h0 f220604a;

        public a(h0 r100) {
            this.f220604a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(ConnectionService.NetworkState r100) {
            final ConnectionService.NetworkState r101 = r100;
            h0 r102 = this.f220604a;
            r102.getClass();
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.a() == false) goto L23;
            q25.a r103 = r102.f220597c;
            if (r103 == null) goto L11;
            final r25.e r104 = r103.f531411c;
            r104.getClass();
            if (r101.a() == false) goto L11;
            Flowable.just(Boolean.TRUE).observeOn(fo5.d.a()).subscribe(new r25.a(r104, r101), new r25.b());
        L11:
            final u25.j r105 = r102.f220599e;
            if (r105 != null) goto L14;
        L16:
            x25.d r106 = r102.f220600f;
            if (r106 != null) goto L19;
            return;
        L19:
            if (r101.a() == false) goto L25;
            r106.i();
            return;
        L25:
            return;
        L14:
            if (r101.a() == false) goto L16;
            Flowable.just(Boolean.TRUE).observeOn(fo5.d.a()).subscribe(new u25.g(r105, r101), new u25.h());
            goto L16
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h0 f220605a = null;

        static {
            f220605a = new h0();
        }
    }

    static {
        f220589j = 20L;
        f220590k = 60L;
        f220591l = new OfflineCacheConfig();
        f220592m = Boolean.valueOf(idb.f.a().isCurrentEnable("ccm.mobile.docx.offline_preload_subblocks_enable"));
        f220593n = Boolean.valueOf(idb.f.a().isCurrentEnable("ccm.sheet.mobile.sub_block_set_limit_enable"));
        f220594o = com.bytedance.ee.bear.appsetting.c.a.f206237a.h("ccm.mobile.docx.enable_offline_preload_subblocks_opt");
    }

    public final void a() {
        tt5.a.h("PreloadManager", "clearData()...");
        f220592m = Boolean.valueOf(idb.f.a().isCurrentEnable("ccm.mobile.docx.offline_preload_subblocks_enable"));
        f220593n = Boolean.valueOf(idb.f.a().isCurrentEnable("ccm.sheet.mobile.sub_block_set_limit_enable"));
        q25.a r100 = this.f220597c;
        if (r100 == null) goto L8;
        r25.e r101 = r100.f531411c;
        r101.getClass();
        tt5.a.h("PreloadClientVarExecutor", "clearData()...");
        r101.f535769d.clear();
        ((LinkedBlockingQueue) r101.f535770e).clear();
        ((HashMap) r101.f535771f).clear();
        q25.i r102 = r100.f531412d;
        if (r102 == null) goto L7;
        r102.f531428d.clear();
    L7:
        ((ConcurrentHashMap) r100.f531415g).clear();
    L8:
        b0 r103 = this.f220598d;
        if (r103 == null) goto L11;
        tt5.a.h("PreloadIntervalExecutor", "clearData()...");
        ((CopyOnWriteArrayList) r103.f220563a).clear();
    L11:
        u25.j r104 = this.f220599e;
        if (r104 == null) goto L17;
        tt5.a.h("PreloadImageExecutor", "clearData()...");
        ((LinkedBlockingQueue) r104.f548473d).clear();
        ((LinkedBlockingQueue) r104.f548475f).clear();
        r104.f548476g.clear();
        ConcurrentHashMap<String, u25.a> r105 = r104.f548477h.f548467a;
        if (r105 == null) goto L17;
        r105.clear();
    L17:
        x25.d r106 = this.f220600f;
        if (r106 == null) goto L21;
        tt5.a.h("PreloadSubBlockExecutor", "clearData()...");
        ((LinkedBlockingQueue) r106.f562241d).clear();
        return;
    }

    public h0() {
        this.f220601g = ((Boolean) new ml5.b("debug_config").a("disable_preload_document", Boolean.FALSE)).booleanValue();
        this.f220602h = new ConcurrentHashMap();
        this.f220603i = new a(this);
        com.bytedance.ee.bear.appsetting.c r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        f220591l = (OfflineCacheConfig) r100.c("offline_cache_config", OfflineCacheConfig.class, new OfflineCacheConfig());
        this.f220597c = new q25.a(new r25.e());
        this.f220598d = new b0();
        this.f220599e = new u25.j(f220591l.isPreload_image_only_wifi());
        this.f220600f = new x25.d();
        d(((com.bytedance.ee.bear.contract.h0) org.koin.java.a.a(com.bytedance.ee.bear.contract.h0.class)).G2());
        ((com.bytedance.ee.bear.contract.h0) org.koin.java.a.a(com.bytedance.ee.bear.contract.h0.class)).Pe(new f0(this));
        this.f220597c.d();
        u25.j r101 = this.f220599e;
        r101.getClass();
        r101.f548478i = new u25.j.a(r101);
        PthreadHandlerThreadV2 r102 = new PthreadHandlerThreadV2("Docs_Image_Preload");
        r101.f548479j = r102;
        ThreadMethodProxy.start(r102);
        new Handler(r101.f548479j.getLooper()).post(r101.f548478i);
        x25.d r103 = this.f220600f;
        r103.getClass();
        r103.f562242e = new x25.d.a(r103);
        ThreadMethodProxy.start(new PthreadThreadV2(r103.f562242e, "Docs_SubBlock_Preload"));
        int r104 = CommonRNPreloadStrategy.f220497v;
        if (r100.g("ccm.mobile.preload_docx_by_rust") == false) goto L5;
    L10:
        boolean r105 = true;
    L11:
        if (r105 == false) goto L13;
        com.bytedance.ee.bear.document.offline.sync.rust.c.a();
    L13:
        com.bytedance.ee.bear.contract.j r106 = com.bytedance.ee.bear.contract.j.a.f217090a;
        this.f220595a = r106;
        this.f220596b = r106.a();
        com.bytedance.ee.util.ui.m.a(new e0(this));
        q25.a r107 = this.f220597c;
        r107.f531414f = new g0(this);
        return;
    L5:
        if (r100.g("ccm.mobile.preload_sheet_by_rust") == true) goto L10;
        if (r100.g("ccm.mobile.preload_slides_by_rust") == true) goto L10;
        r105 = false;
        goto L11
    }

    public final void c(final SubBlockModel... r100) {
        final x25.d r101 = this.f220600f;
        if (r101 == null) goto L6;
        Flowable.just(Boolean.TRUE).subscribeOn(fo5.d.a()).subscribe(new x25.a(r101, r100), new x25.b());
        return;
    }

    public final void d(AccountService$Account r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.hasLogin() == false) goto L18;
        Iterator<q> r101 = ((i) org.koin.java.a.a(i.class)).a().values().iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        r101.next().f(r100);
        goto L7
    L9:
        u25.j r102 = this.f220599e;
        if (r102 == null) goto L12;
        r102.f548481l = r100;
    L12:
        x25.d r103 = this.f220600f;
        if (r103 == null) goto L19;
        r103.f562244g = r100.tenantId + "_" + r100.uid + "_COMMENTS_DATA_COMPLETE";
        r103.f562245h = r100.tenantId + "_" + r100.uid + "_POLL_DATA_COMPLETE";
        return;
    L19:
        return;
    }

    public final void b(String r100, String r101, int r110, List<SubBlockModel> r111, final boolean r112, Function1<u25.a, Unit> r113) {
        if (this.f220599e == null) goto L9;
        final u25.a r102 = new u25.a(r100, r101, r111, r110, r113);
        final u25.j r103 = this.f220599e;
        r103.getClass();
        if (r111 == null) goto L10;
        tt5.a.h("PreloadImageExecutor", "preloadImages(): original job img size = " + r111.size());
        Flowable.just(Boolean.TRUE).subscribeOn(fo5.d.a()).subscribe(new u25.e(r103, r112, r102), new u25.f());
        return;
    L10:
        return;
    }
}
