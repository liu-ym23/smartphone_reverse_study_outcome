package z25;

import android.text.TextUtils;
import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.document.offline.sync.CommonRNPreloadStrategy;
import com.bytedance.ee.bear.document.offline.sync.PreloadType;
import com.bytedance.ee.bear.document.offline.sync.p;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import k25.e0;
import k25.m0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class b extends CommonRNPreloadStrategy {
    public String w;
    public PreloadType x;
    public final Map<String, PreloadType> y;
    public AccountService$Account z;

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

    @Override // com.bytedance.ee.bear.document.offline.sync.CommonRNPreloadStrategy
    public final boolean v() {
        String r0 = ((z25.a) this).A;
        if (r0 == null) goto L22;
        int r1 = r0.hashCode();
        if (r1 == (-899647262)) goto L19;
        if (r1 == 3088960) goto L16;
        if (r1 != 109403487) goto L22;
        if (r0.equals("sheet") == false) goto L22;
        Integer r2 = Integer.valueOf(e.h.b);
    L23:
        String r3 = CommonRNPreloadStrategy.a.a(r2);
        if (r3 != null) goto L28;
        return false;
    L28:
        return c.a.a.g(r3);
    L16:
        if (r0.equals("docx") == false) goto L22;
        r2 = Integer.valueOf(e.o.b);
        goto L23
    L19:
        if (r0.equals("slides") == false) goto L22;
        r2 = Integer.valueOf(e.m.b);
    L22:
        r2 = null;
        goto L23
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.CommonRNPreloadStrategy
    public final String u() {
        return "biz." + ((z25.a) this).A + ".loadComplete";
    }

    public b() {
        this.x = PreloadType.ALL;
        this.y = new ConcurrentHashMap();
        this.a = "SsrPreloadStrategy";
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.f, com.bytedance.ee.bear.document.offline.sync.q
    public final boolean c(OfflineDoc r4) {
        Intrinsics.checkNotNullParameter(r4, "offlineDoc");
        if (super.c(r4) == true) goto L15;
        String r5 = r4.getObj_token();
        Intrinsics.checkNotNullParameter(r5, "objToken");
        PreloadType r6 = (PreloadType) ((ConcurrentHashMap) this.y).get(r5);
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

    @Override // com.bytedance.ee.bear.document.offline.sync.CommonRNPreloadStrategy, com.bytedance.ee.bear.document.offline.sync.q
    public final void f(AccountService$Account r6) {
        Intrinsics.checkNotNullParameter(r6, "account");
        super.f(r6);
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        this.z = r6;
        z25.a r0 = (z25.a) this;
        String r1 = r0.A.toUpperCase(Locale.ROOT);
        this.f = r6.tenantId + '_' + r6.uid + '_' + r1 + "_RES_KEY";
        this.w = n35.a.a(r6, r0.A);
        this.g = r1;
        this.j = new v25.e();
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.f
    public final void q(String r3) {
        Intrinsics.checkNotNullParameter(r3, "objToken");
        PreloadType r0 = PreloadType.ALL;
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.x = r0;
        ((ConcurrentHashMap) this.y).put(r3, r0);
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.CommonRNPreloadStrategy
    public final void s(String r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        JSONObject r1 = new JSONObject(r5);     // Catch: JSONException -> L5
        String r6 = r1.optString(((z25.a) this).A + "Token");     // Catch: JSONException -> L5
        int r2 = r1.optInt("code");     // Catch: JSONException -> L5
        tt5.a.h(this.a, "executeRNLoadCompletedData()... objToken = " + du5.b.g(r6) + ", code = " + r2);     // Catch: JSONException -> L5
        t(r6, r2);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.e(this.a, "executeRNLoadCompletedData()... error = ", e, false);
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.f, com.bytedance.ee.bear.document.offline.sync.q
    public final m0 g(String r6, Map<String, String> r7) {
        Intrinsics.checkNotNullParameter(r6, "objToken");
        Intrinsics.checkNotNullParameter(r7, "queries");
        m0 r1 = e0.m().s(this.f, r6);
        e0 r2 = e0.m();
        Intrinsics.checkNotNullParameter(r7, "queries");
        AccountService$Account r0 = this.z;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("account");
        r0 = null;
    L6:
        m0 r8 = r2.s(n35.a.b(r0, ((z25.a) this).A, r7), r6);
        m0 r3 = e0.m().s(this.w, r6);
        if (r1 != null) goto L9;
    L22:
        if (r8 != null) goto L24;
    L27:
        PreloadType r9 = PreloadType.ALL;
    L28:
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        this.x = r9;
        ((ConcurrentHashMap) this.y).put(r6, r9);
        return r3;
    L24:
        if (TextUtils.isEmpty(r8.c) == true) goto L27;
        r9 = PreloadType.CLIENTVAR;
        goto L28
    L9:
        if (TextUtils.equals(r1.c, "true") == false) goto L22;
        p r4 = this.n;
        if (r4 == null) goto L16;
        if (r3 == null) goto L14;
        Long r5 = r3.e;
    L15:
        Intrinsics.checkNotNull(r5);
        r25.e.a r10 = (r25.e.a) r4;
        r10.a(r6, r5.longValue());
        goto L16
    L14:
        r5 = r1.e;
    L16:
        if (r8 != null) goto L18;
    L21:
        r9 = PreloadType.SSR;
        goto L28
    L18:
        if (TextUtils.isEmpty(r8.c) == true) goto L21;
        r9 = PreloadType.NONE;
        goto L28
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.f
    public final com.alibaba.fastjson.JSONObject l(String r7, Map<String, String> r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r7, "objToken");
        Intrinsics.checkNotNullParameter(r8, "queries");
        com.alibaba.fastjson.JSONObject r10 = new com.alibaba.fastjson.JSONObject();
        StringBuilder r0 = new StringBuilder();
        z25.a r1 = (z25.a) this;
        r0.append(r1.A);
        r0.append(".fetchData");
        r10.put("operation", r0.toString());
        com.alibaba.fastjson.JSONObject r2 = new com.alibaba.fastjson.JSONObject();
        JSONArray r3 = new JSONArray();
        r2.put(r1.A + "Token", r7);
        if (r9 == false) goto L5;
        tt5.a.h(this.a, "isManualOffline is true");
        r3.put("clientVars");
        r2.put("fetchType", r3.toString());
    L18:
        if (c.a.a.g("ccm.sheet.mobile.sub_block_set_limit_enable") == false) goto L23;
        if (r9 == false) goto L21;
        String r11 = "offline";
    L22:
        r2.put("eventType", r11);
        goto L23
    L21:
        r11 = "preload";
    L23:
        tt5.a.b(this.a, "get preload type is " + this.x);
        r10.put("body", r2);
        return r10;
    L5:
        PreloadType r4 = this.x;
        if (r4 == PreloadType.NONE) goto L18;
        int r5 = a.a[r4.ordinal()];
        if (r5 != 1) goto L10;
        r3.put("clientVars");
        r2.put("fetchType", r3.toString());
        goto L18
    L10:
        if (r5 != 2) goto L12;
        r3.put("ssr");
        r2.put("fetchType", r3.toString());
        goto L18
    L12:
        if (r5 != 3) goto L18;
        r3.put("clientVars").put("ssr");
        r2.put("fetchType", r3.toString());
        goto L18
    }
}
