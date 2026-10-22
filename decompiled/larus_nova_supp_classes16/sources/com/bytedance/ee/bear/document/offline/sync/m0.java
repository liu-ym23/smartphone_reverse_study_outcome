package com.bytedance.ee.bear.document.offline.sync;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.offline.OfflineCacheConfig;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class m0 extends CommonRNPreloadStrategy {
    public String w;
    public final boolean x;
    public final Map<String, Pair<String, String>> y;
    public OfflineCacheConfig z;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ String b;
        public final /* synthetic */ m0 c;

        public b(JSONObject r1, String r2, m0 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.sheet_ssr_cache_by_sheet_id") == true) goto L30;
        L28:
            m0 r0 = this.c;
            String r1 = this.b;
            Intrinsics.checkNotNull(r1);
            r0.A(r1);
            return;
        L30:
            JSONArray r2 = this.a.optJSONArray("fetchType");     // Catch: Exception -> L26
            if (r2 == null) goto L13;
            int r3 = r2.length();     // Catch: Exception -> L26
            int r4 = 0;
        L8:
            if (r4 >= r3) goto L13;
            if (TextUtils.equals(r2.optString(r4), "ssr") == true) goto L11;
            r4 = r4 + 1;     // Catch: Exception -> L26
            goto L8
        L11:
            boolean r5 = true;
        L14:
            if (r5 == false) goto L28;
            k25.e0 r6 = k25.e0.m();     // Catch: Exception -> L26
            String r7 = this.b;     // Catch: Exception -> L26
            int r8 = this.c.z.getSheetSsrMaxCount();     // Catch: Exception -> L26
            r6.getClass();     // Catch: Exception -> L26
            int r9 = r6.q().e().p(r7, r8);     // Catch: Exception -> L21
            tt5.a.h("OfflineDataManager", "lruShrinkCacheByTokenAnd, result: " + r9);     // Catch: Exception -> L19
        L24:
            tt5.a.h(this.c.a, "shrink ssr cache, size is " + r9);     // Catch: Exception -> L26
        L19:
            Exception e = e;
        L23:
            tt5.a.e("OfflineDataManager", "lruShrinkCacheByTokenAnd, err", e, false);     // Catch: Exception -> L26
        L21:
            e = move-exception;
            e = e;
            r9 = 0;
        L13:
            r5 = false;
        L26:
            e = move-exception;
            tt5.a.e(this.c.a, "shrink ssr cache error", e, false);
            goto L28
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

    public static final class c implements Runnable {
        public final /* synthetic */ m0 a;
        public final /* synthetic */ String b;

        public c(m0 r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.A(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.CommonRNPreloadStrategy
    public final String u() {
        return "biz.sheet.loadComplete";
    }

    public com.alibaba.fastjson.JSONObject z(String r1, String r2, Map<String, String> r3, boolean r4) {
        throw null;
    }

    public m0() {
        this.x = true;
        this.y = new ConcurrentHashMap();
        this.z = new OfflineCacheConfig();
        this.a = "SheetPreloadStrategy";
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.CommonRNPreloadStrategy
    public final boolean v() {
        return this.x;
    }

    public final void A(String r4) {
        Intrinsics.checkNotNullParameter(r4, "sheetToken");
        if (((ConcurrentHashMap) this.y).containsKey(r4) == false) goto L11;
        Pair r0 = (Pair) ((ConcurrentHashMap) this.y).get(r4);
        if (r0 == null) goto L12;
        k25.m0 r1 = k25.e0.m().n((String) r0.second, (String) r0.first);
        x25.f r2 = r1.u;
        if (r2 == null) goto L9;
        r2.c(192);
        k25.e0.m().I(r1);
    L9:
        Pair r5 = (Pair) ((ConcurrentHashMap) this.y).remove(r4);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.f, com.bytedance.ee.bear.document.offline.sync.q
    public boolean c(OfflineDoc r2) {
        Intrinsics.checkNotNullParameter(r2, "offlineDoc");
        if (super.c(r2) == false) goto L5;
    L10:
        return true;
    L5:
        if (TextUtils.equals("tab_manual_offline", r2.getFrom_source()) == true) goto L7;
    L9:
        return false;
    L7:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.sheet.mobile.sub_block_set_limit_enable") == false) goto L9;
        goto L9
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.CommonRNPreloadStrategy, com.bytedance.ee.bear.document.offline.sync.q
    public void f(AccountService$Account r4) {
        Intrinsics.checkNotNullParameter(r4, "account");
        super.f(r4);
        this.f = r4.tenantId + '_' + r4.uid + "_SHEET_DATA_COMPLETE";
        this.w = r4.tenantId + '_' + r4.uid + "_SHEET_CLIENT_VARS";
        this.g = PreloadConfigModel.VERSION_CHECK_TYPE_SHEET;
        this.j = new v25.e();
        this.z = (OfflineCacheConfig) com.bytedance.ee.bear.appsetting.c.a.a.d("sheet_preload_config", new OfflineCacheConfig());
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.CommonRNPreloadStrategy
    public final void s(String r6) {
        Intrinsics.checkNotNullParameter(r6, "data");
        JSONObject r1 = new JSONObject(r6);     // Catch: JSONException -> L5
        String r7 = r1.optString("sheetToken");     // Catch: JSONException -> L5
        int r2 = r1.optInt("code");     // Catch: JSONException -> L5
        tt5.a.h(this.a, "executeRNLoadCompletedData()... sheetToken = " + du5.b.g(r7) + ", code = " + r2);     // Catch: JSONException -> L5
        t(r7, r2);     // Catch: JSONException -> L5
        Intrinsics.checkNotNull(fo5.d.b().scheduleDirect(new b(r1, r7, this)));     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.e(this.a, "executeRNLoadCompletedData()... error = ", e, false);
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.f, com.bytedance.ee.bear.document.offline.sync.q
    public final void d(String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "sheetToken");
        Intrinsics.checkNotNullParameter(r5, "docToken");
        Intrinsics.checkNotNullParameter(r6, "docResKey");
        tt5.a.h(this.a, "preload()... sheetToken = " + du5.b.g(r4) + ", docToken = " + du5.b.g(r5));
        ((ConcurrentHashMap) this.y).put(r4, new Pair(r5, r6));
        OfflineDoc r7 = new OfflineDoc(r4, "", sbb.e.h.b, "from_parent_document");
        ((ConcurrentHashMap) this.t).put(r4, r7);
        r(r7, z(r4, r5, new HashMap(), false).toJSONString());
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.f
    public final com.alibaba.fastjson.JSONObject l(String r2, Map<String, String> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "sheetToken");
        Intrinsics.checkNotNullParameter(r3, "queries");
        return z(r2, "", r3, r4);
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.CommonRNPreloadStrategy
    public final void w(String r5, String r6, int r7) {
        if (r6 != null) goto L4;
        String r0 = "";
    L5:
        int r1 = com.bytedance.ee.bear.document.offline.sync.rust.b.a;
        boolean r2 = false;
        if (Intrinsics.areEqual(r5, "SHEETS_DATA_COMPLETE") == true) goto L8;
    L15:
        super.w(r5, r6, r7);
        if (r2 == false) goto L20;
        if (r7 != 0) goto L21;
        fo5.d.b().scheduleDirect(new c(this, r0));
        return;
    L21:
        return;
    L20:
        return;
    L8:
        if (r0.length() <= 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L15;
        if (((ConcurrentHashMap) this.y).containsKey(r0) == false) goto L15;
        r2 = true;
        goto L15
    L10:
        r3 = false;
        goto L11
    L4:
        r0 = r6;
        goto L5
    }
}
