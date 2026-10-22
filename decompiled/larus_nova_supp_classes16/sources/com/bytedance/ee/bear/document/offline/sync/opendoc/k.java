package com.bytedance.ee.bear.document.offline.sync.opendoc;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.bytedance.ee.bear.domain.BearUrl;
import com.ss.android.lark.monitor.callback.DevicePerfManager;
import com.ss.android.lark.utils.CarUtils;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.Flowable;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import java.util.HashMap;
import java.util.Map;
import k25.e0;
import k25.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k {
    public static final FetchClientVarExecutor a = null;

    static {
        a = new FetchClientVarExecutor((NetService) org.koin.java.a.a(NetService.class));
    }

    public static boolean a() {
        int r0 = im5.b.a;
        boolean r1 = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.docx_mobile_native_prefetch_clientvar");
        Boolean r2 = ((xm4.a.a) org.koin.java.a.c(xm4.a.a.class, null, null, 6)).a(im5.a.class.getName());
        if (r2 == null) goto L5;
        boolean r3 = r2.booleanValue();
    L6:
        tt5.a.h("PreFetchClientvarSettings", "fg is " + r1 + " , abTest is " + r3);
        if (r1 == false) goto L11;
        if (r3 == false) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    L5:
        r3 = false;
        goto L6
    }

    public static boolean b(BearUrl r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        boolean r1 = TextUtils.equals(r3.a, sbb.e.o.getType());
        boolean r2 = z05.i.d(r3.e);
        if (r1 == true) goto L8;
        return false;
    L8:
        if (fx4.a.f(r3.e) == true) goto L13;
        if (r2 == true) goto L14;
        return true;
    L14:
        return false;
    L13:
        return false;
    }

    public static void e(final BearUrl r5) {
        final AccountService$Account r0 = ((h0) org.koin.java.a.a(h0.class)).G2();
        d25.d.i();
        if (r0 != null) goto L5;
        return;
    L5:
        Flowable.just(Boolean.valueOf(im5.d.a())).filter(new a(r5)).observeOn(fo5.d.e()).subscribe(new b(r0, r5), new c());
        Flowable r1 = Flowable.just(r5).filter(new d());
        LarkContext.getApplication();
        new f25.i(com.bytedance.ee.bear.contract.j.a.a).b();
        r1.observeOn(new ExecutorScheduler(f25.i.e, false)).subscribe(new e(r5, r0), new f());
    }

    public static m0 c(AccountService$Account r1, String r2, String r3) {
        return e0.m().A(n35.a.a(r1, r3), r2, 0);
    }

    public static boolean f(String r2, String r3, boolean r4) {
        if (TextUtils.equals(r3, sbb.e.o.getType()) == true) goto L6;
        return false;
    L6:
        if (TextUtils.equals(r2, "501") == false) goto L8;
    L23:
        tt5.a.h("OpenDocsPreloadDataLoader", "docAppId is " + r2);
        return false;
    L8:
        if (TextUtils.equals(r2, "601") == true) goto L23;
        if (r4 == true) goto L12;
    L15:
        String[] r5 = CarUtils.a;
        if (DocOpenConfig.f().enable_low_device == true) goto L22;
        if (DevicePerfManager.b.a.e.h == false) goto L22;
        tt5.a.h("OpenDocsPreloadDataLoader", "isLowDevice = true");
        return false;
    L22:
        return com.bytedance.ee.bear.document.ssrrender.b.a();
    L12:
        if (idb.f.a().isCurrentEnable("ccm.mobile.wiki_pre_fetch_docx_ssr") == true) goto L15;
        tt5.a.h("OpenDocsPreloadDataLoader", "type is wiki and fg is false");
        return false;
    }

    public static m0 d(AccountService$Account r5, String r6, String r7, Map<String, String> r8) {
        m0 r0 = e0.m().n(n35.a.b(r5, r6, r8), r7);
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.sheet_ssr_cache_by_sheet_id") == true) goto L6;
        return r0;
    L6:
        if (TextUtils.equals(r6, sbb.e.h.getType()) == true) goto L8;
        return r0;
    L8:
        if (r8.containsKey("sheet") == true) goto L10;
        return r0;
    L10:
        if (TextUtils.isEmpty(r0.c) == true) goto L12;
        return r0;
    L12:
        if (TextUtils.equals(e0.m().n(r5.tenantId + OfflineDoc.DASH_DELIMITER + r5.uid + "_default_sheet_id", r7).c, r8.get("sheet")) == true) goto L14;
        return r0;
    L14:
        return e0.m().n(n35.a.b(r5, r6, new HashMap()), r7);
    }
}
