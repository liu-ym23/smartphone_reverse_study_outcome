package com.bytedance.ee.bear.document.offline.sync;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.document.offline.sync.opendoc.FetchClientVarExecutor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class n0 extends m0 {
    public PreloadType A;
    public final Map<String, PreloadType> B;
    public AccountService$Account C;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PreloadType.values().length];
            r0[PreloadType.CLIENTVAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[PreloadType.SSR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[PreloadType.ALL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.f, com.bytedance.ee.bear.document.offline.sync.q
    public final boolean i() {
        return !com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.sheet_ssr_cache_by_sheet_id");
    }

    public n0() {
        this.a = "SheetWithSSRPreloadStrategy";
        this.A = PreloadType.ALL;
        this.B = new ConcurrentHashMap();
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.m0, com.bytedance.ee.bear.document.offline.sync.f, com.bytedance.ee.bear.document.offline.sync.q
    public final boolean c(OfflineDoc r4) {
        Intrinsics.checkNotNullParameter(r4, "offlineDoc");
        if (super.c(r4) == true) goto L15;
        String r5 = r4.getObj_token();
        Intrinsics.checkNotNullParameter(r5, "objToken");
        PreloadType r6 = (PreloadType) ((ConcurrentHashMap) this.B).get(r5);
        if (r6 != null) goto L7;
    L10:
        boolean r7 = true;
    L11:
        if (r7 == true) goto L16;
        return false;
    L16:
        return true;
    L7:
        if (r6 != PreloadType.NONE) goto L10;
        r7 = false;
        goto L11
    L15:
        return true;
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.m0, com.bytedance.ee.bear.document.offline.sync.CommonRNPreloadStrategy, com.bytedance.ee.bear.document.offline.sync.q
    public final void f(AccountService$Account r2) {
        Intrinsics.checkNotNullParameter(r2, "account");
        super.f(r2);
        this.C = r2;
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.f
    public final void q(String r3) {
        Intrinsics.checkNotNullParameter(r3, "objToken");
        PreloadType r0 = PreloadType.ALL;
        this.A = r0;
        ((ConcurrentHashMap) this.B).put(r3, r0);
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.f, com.bytedance.ee.bear.document.offline.sync.q
    public final k25.m0 g(String r6, Map<String, String> r7) {
        Intrinsics.checkNotNullParameter(r6, "objToken");
        Intrinsics.checkNotNullParameter(r7, "queries");
        k25.m0 r0 = k25.e0.m().s(this.f, r6);
        AccountService$Account r1 = this.C;
        if (r1 != null) goto L5;
        String r8 = "";
    L6:
        k25.m0 r9 = k25.e0.m().s(r8, r6);
        k25.m0 r2 = k25.e0.m().s(this.w, r6);
        if (r0 != null) goto L9;
    L22:
        if (r9 != null) goto L24;
    L27:
        this.A = PreloadType.ALL;
    L28:
        Map<String, PreloadType> r10 = this.B;
        ConcurrentHashMap r11 = (ConcurrentHashMap) r10;
        r11.put(r6, this.A);
        return r2;
    L24:
        if (TextUtils.isEmpty(r9.c) == true) goto L27;
        this.A = PreloadType.CLIENTVAR;
        goto L28
    L9:
        if (TextUtils.equals(r0.c, "true") == false) goto L22;
        p r3 = this.n;
        if (r3 == null) goto L16;
        if (r2 == null) goto L14;
        Long r4 = r2.e;
    L15:
        Intrinsics.checkNotNull(r4);
        r25.e.a r5 = (r25.e.a) r3;
        r5.a(r6, r4.longValue());
        goto L16
    L14:
        r4 = r0.e;
    L16:
        if (r9 != null) goto L18;
    L21:
        this.A = PreloadType.SSR;
        goto L28
    L18:
        if (TextUtils.isEmpty(r9.c) == true) goto L21;
        this.A = PreloadType.NONE;
        goto L28
    L5:
        String r12 = sbb.e.h.getType();
        FetchClientVarExecutor r13 = com.bytedance.ee.bear.document.offline.sync.opendoc.k.a;
        r8 = n35.a.b(r1, r12, r7);
        goto L6
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.m0
    public final JSONObject z(String r7, String r8, Map<String, String> r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r7, "sheetToken");
        Intrinsics.checkNotNullParameter(r8, "docToken");
        Intrinsics.checkNotNullParameter(r9, "queries");
        JSONObject r2 = new JSONObject();
        r2.put("operation", "sheet.fetchData");
        JSONObject r3 = new JSONObject();
        JSONArray r4 = new JSONArray();
        r3.put("sheetToken", r7);
        r3.put("docToken", r8);
        com.bytedance.ee.bear.appsetting.c r11 = com.bytedance.ee.bear.appsetting.c.a.a;
        if (r11.g("ccm.mobile.sheet_ssr_cache_by_sheet_id") == false) goto L8;
        if (r9.containsKey("sheet") == false) goto L8;
        r3.put("sheetID", r9.get("sheet"));
    L8:
        if (r10 == false) goto L10;
        tt5.a.h(this.a, "isManualOffline is true");
        r4.put("clientVars");
        r3.put("fetchType", r4.toString());
    L23:
        if (r11.g("ccm.sheet.mobile.sub_block_set_limit_enable") == false) goto L28;
        if (r10 == false) goto L26;
        String r12 = "offline";
    L27:
        r3.put("eventType", r12);
        goto L28
    L26:
        r12 = "preload";
    L28:
        tt5.a.b(this.a, "get preload type is " + this.A);
        r2.put("body", r3);
        return r2;
    L10:
        PreloadType r0 = this.A;
        if (r0 == PreloadType.NONE) goto L23;
        int r1 = a.a[r0.ordinal()];
        if (r1 != 1) goto L15;
        r4.put("clientVars");
        r3.put("fetchType", r4.toString());
        goto L23
    L15:
        if (r1 != 2) goto L17;
        r4.put("ssr");
        r3.put("fetchType", r4.toString());
        goto L23
    L17:
        if (r1 == 3) goto L19;
        Unit r13 = Unit.INSTANCE;
        goto L23
    L19:
        r4.put("clientVars").put("ssr");
        r3.put("fetchType", r4.toString());
        goto L23
    }
}
