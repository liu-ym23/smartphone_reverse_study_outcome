package com.bytedance.ee.bear.document.offline.sync;

import android.os.Handler;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.offline.OfflineCacheConfig;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h0 {
    public static final Long j = null;
    public static final Long k = null;
    public static OfflineCacheConfig l;
    public static Boolean m;
    public static Boolean n;
    public static final boolean o = false;
    public com.bytedance.ee.bear.contract.j a;
    public LiveData<ConnectionService.NetworkState> b;
    public q25.a c;
    public b0 d;
    public u25.j e;
    public x25.d f;
    public final boolean g;
    public final Map<String, WeakReference<q25.f>> h;
    public final a i;

    public class a implements Observer<ConnectionService.NetworkState> {
        public final /* synthetic */ h0 a;

        public a(h0 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            final ConnectionService.NetworkState r6 = (ConnectionService.NetworkState) r5;
            h0 r0 = this.a;
            r0.getClass();
            if (r6 != null) goto L5;
            return;
        L5:
            if (r6.a() == false) goto L23;
            q25.a r1 = r0.c;
            if (r1 == null) goto L11;
            final r25.e r2 = r1.c;
            r2.getClass();
            if (r6.a() == false) goto L11;
            Flowable.just(Boolean.TRUE).observeOn(fo5.d.a()).subscribe(new r25.a(r2, r6), new r25.b());
        L11:
            final u25.j r3 = r0.e;
            if (r3 != null) goto L14;
        L16:
            x25.d r4 = r0.f;
            if (r4 != null) goto L19;
            return;
        L19:
            if (r6.a() == false) goto L25;
            r4.i();
            return;
        L25:
            return;
        L14:
            if (r6.a() == false) goto L16;
            Flowable.just(Boolean.TRUE).observeOn(fo5.d.a()).subscribe(new u25.g(r3, r6), new u25.h());
            goto L16
        }
    }

    public static class b {
        public static final h0 a = null;

        static {
            a = new h0();
        }
    }

    static {
        j = 20L;
        k = 60L;
        l = new OfflineCacheConfig();
        m = Boolean.valueOf(idb.f.a().isCurrentEnable("ccm.mobile.docx.offline_preload_subblocks_enable"));
        n = Boolean.valueOf(idb.f.a().isCurrentEnable("ccm.sheet.mobile.sub_block_set_limit_enable"));
        o = com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.mobile.docx.enable_offline_preload_subblocks_opt");
    }

    public final void a() {
        tt5.a.h("PreloadManager", "clearData()...");
        m = Boolean.valueOf(idb.f.a().isCurrentEnable("ccm.mobile.docx.offline_preload_subblocks_enable"));
        n = Boolean.valueOf(idb.f.a().isCurrentEnable("ccm.sheet.mobile.sub_block_set_limit_enable"));
        q25.a r0 = this.c;
        if (r0 == null) goto L8;
        r25.e r2 = r0.c;
        r2.getClass();
        tt5.a.h("PreloadClientVarExecutor", "clearData()...");
        r2.d.clear();
        ((LinkedBlockingQueue) r2.e).clear();
        ((HashMap) r2.f).clear();
        q25.i r3 = r0.d;
        if (r3 == null) goto L7;
        r3.d.clear();
    L7:
        ((ConcurrentHashMap) r0.g).clear();
    L8:
        b0 r1 = this.d;
        if (r1 == null) goto L11;
        tt5.a.h("PreloadIntervalExecutor", "clearData()...");
        ((CopyOnWriteArrayList) r1.a).clear();
    L11:
        u25.j r4 = this.e;
        if (r4 == null) goto L17;
        tt5.a.h("PreloadImageExecutor", "clearData()...");
        ((LinkedBlockingQueue) r4.d).clear();
        ((LinkedBlockingQueue) r4.f).clear();
        r4.g.clear();
        ConcurrentHashMap<String, u25.a> r5 = r4.h.a;
        if (r5 == null) goto L17;
        r5.clear();
    L17:
        x25.d r6 = this.f;
        if (r6 == null) goto L21;
        tt5.a.h("PreloadSubBlockExecutor", "clearData()...");
        ((LinkedBlockingQueue) r6.d).clear();
        return;
    }

    public h0() {
        this.g = ((Boolean) new ml5.b("debug_config").a("disable_preload_document", Boolean.FALSE)).booleanValue();
        this.h = new ConcurrentHashMap();
        this.i = new a(this);
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        l = (OfflineCacheConfig) r0.c("offline_cache_config", OfflineCacheConfig.class, new OfflineCacheConfig());
        this.c = new q25.a(new r25.e());
        this.d = new b0();
        this.e = new u25.j(l.isPreload_image_only_wifi());
        this.f = new x25.d();
        d(((com.bytedance.ee.bear.contract.h0) org.koin.java.a.a(com.bytedance.ee.bear.contract.h0.class)).G2());
        ((com.bytedance.ee.bear.contract.h0) org.koin.java.a.a(com.bytedance.ee.bear.contract.h0.class)).Pe(new f0(this));
        this.c.d();
        u25.j r1 = this.e;
        r1.getClass();
        r1.i = new u25.j.a(r1);
        PthreadHandlerThreadV2 r2 = new PthreadHandlerThreadV2("Docs_Image_Preload");
        r1.j = r2;
        ThreadMethodProxy.start(r2);
        new Handler(r1.j.getLooper()).post(r1.i);
        x25.d r3 = this.f;
        r3.getClass();
        r3.e = new x25.d.a(r3);
        ThreadMethodProxy.start(new PthreadThreadV2(r3.e, "Docs_SubBlock_Preload"));
        int r4 = CommonRNPreloadStrategy.v;
        if (r0.g("ccm.mobile.preload_docx_by_rust") == false) goto L5;
    L10:
        boolean r5 = true;
    L11:
        if (r5 == false) goto L13;
        com.bytedance.ee.bear.document.offline.sync.rust.c.a();
    L13:
        com.bytedance.ee.bear.contract.j r6 = com.bytedance.ee.bear.contract.j.a.a;
        this.a = r6;
        this.b = r6.a();
        com.bytedance.ee.util.ui.m.a(new e0(this));
        q25.a r7 = this.c;
        r7.f = new g0(this);
        return;
    L5:
        if (r0.g("ccm.mobile.preload_sheet_by_rust") == true) goto L10;
        if (r0.g("ccm.mobile.preload_slides_by_rust") == true) goto L10;
        r5 = false;
        goto L11
    }

    public final void c(final SubBlockModel... r4) {
        final x25.d r0 = this.f;
        if (r0 == null) goto L6;
        Flowable.just(Boolean.TRUE).subscribeOn(fo5.d.a()).subscribe(new x25.a(r0, r4), new x25.b());
        return;
    }

    public final void d(AccountService$Account r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.hasLogin() == false) goto L18;
        Iterator<q> r0 = ((i) org.koin.java.a.a(i.class)).a().values().iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        r0.next().f(r5);
        goto L7
    L9:
        u25.j r1 = this.e;
        if (r1 == null) goto L12;
        r1.l = r5;
    L12:
        x25.d r2 = this.f;
        if (r2 == null) goto L19;
        r2.g = r5.tenantId + OfflineDoc.DASH_DELIMITER + r5.uid + "_COMMENTS_DATA_COMPLETE";
        r2.h = r5.tenantId + OfflineDoc.DASH_DELIMITER + r5.uid + "_POLL_DATA_COMPLETE";
        return;
    L19:
        return;
    }

    public final void b(String r8, String r9, int r10, List<SubBlockModel> r11, final boolean r12, Function1<u25.a, Unit> r13) {
        if (this.e == null) goto L9;
        final u25.a r0 = new u25.a(r8, r9, r11, r10, r13);
        final u25.j r14 = this.e;
        r14.getClass();
        if (r11 == null) goto L10;
        tt5.a.h("PreloadImageExecutor", "preloadImages(): original job img size = " + r11.size());
        Flowable.just(Boolean.TRUE).subscribeOn(fo5.d.a()).subscribe(new u25.e(r14, r12, r0), new u25.f());
        return;
    L10:
        return;
    }
}
