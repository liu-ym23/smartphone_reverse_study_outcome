package z25;

import android.text.TextUtils;
import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.document.offline.sync.CommonRNPreloadStrategy;
import com.bytedance.ee.bear.document.offline.sync.PreloadType;
import com.bytedance.ee.bear.document.offline.sync.p;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
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

/* JADX INFO: loaded from: classes16.dex */
public abstract class b extends CommonRNPreloadStrategy {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f569782w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public PreloadType f569783x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Map<String, PreloadType> f569784y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public AccountService$Account f569785z;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f569786a = null;

        static {
            int[] r100 = new int[PreloadType.values().length];
            r100[PreloadType.CLIENTVAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[PreloadType.SSR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[PreloadType.ALL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f569786a = r100;
        }
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.CommonRNPreloadStrategy
    public final boolean v() {
        String r100 = ((z25.a) this).A;
        if (r100 == null) goto L22;
        int r101 = r100.hashCode();
        if (r101 == (-899647262)) goto L19;
        if (r101 == 3088960) goto L16;
        if (r101 != 109403487) goto L22;
        if (r100.equals(DocumentType.SHEET_NAME) == false) goto L22;
        Integer r102 = Integer.valueOf(e.f541297h.f541317b);
    L23:
        String r103 = CommonRNPreloadStrategy.a.a(r102);
        if (r103 != null) goto L28;
        return false;
    L28:
        return c.a.f206237a.g(r103);
    L16:
        if (r100.equals(DocumentType.DOCX_NAME) == false) goto L22;
        r102 = Integer.valueOf(e.f541304o.f541317b);
        goto L23
    L19:
        if (r100.equals("slides") == false) goto L22;
        r102 = Integer.valueOf(e.f541302m.f541317b);
    L22:
        r102 = null;
        goto L23
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.CommonRNPreloadStrategy
    public final String u() {
        return "biz." + ((z25.a) this).A + ".loadComplete";
    }

    public b() {
        this.f569783x = PreloadType.ALL;
        this.f569784y = new ConcurrentHashMap();
        this.f220573a = "SsrPreloadStrategy";
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.f, com.bytedance.ee.bear.document.offline.sync.q
    public final boolean c(OfflineDoc r100) {
        Intrinsics.checkNotNullParameter(r100, "offlineDoc");
        if (super.c(r100) == true) goto L15;
        String r101 = r100.getObj_token();
        Intrinsics.checkNotNullParameter(r101, "objToken");
        PreloadType r102 = (PreloadType) ((ConcurrentHashMap) this.f569784y).get(r101);
        if (r102 != null) goto L7;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == true) goto L16;
        return false;
    L16:
        return true;
    L7:
        if (r102 != PreloadType.NONE) goto L10;
        r103 = false;
        goto L11
    L15:
        return true;
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.CommonRNPreloadStrategy, com.bytedance.ee.bear.document.offline.sync.q
    public final void f(AccountService$Account r100) {
        Intrinsics.checkNotNullParameter(r100, "account");
        super.f(r100);
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f569785z = r100;
        z25.a r101 = (z25.a) this;
        String r102 = r101.A.toUpperCase(Locale.ROOT);
        this.f220578f = r100.tenantId + '_' + r100.uid + '_' + r102 + "_RES_KEY";
        this.f569782w = n35.a.a(r100, r101.A);
        this.f220579g = r102;
        this.f220582j = new v25.e();
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.f
    public final void q(String r100) {
        Intrinsics.checkNotNullParameter(r100, "objToken");
        PreloadType r101 = PreloadType.ALL;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f569783x = r101;
        ((ConcurrentHashMap) this.f569784y).put(r100, r101);
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.CommonRNPreloadStrategy
    public final void s(String r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L5
        String r102 = r101.optString(((z25.a) this).A + CancelRetainContactInfoFunctions.Token);     // Catch: JSONException -> L5
        int r103 = r101.optInt("code");     // Catch: JSONException -> L5
        tt5.a.h(this.f220573a, "executeRNLoadCompletedData()... objToken = " + du5.b.g(r102) + ", code = " + r103);     // Catch: JSONException -> L5
        t(r102, r103);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.e(this.f220573a, "executeRNLoadCompletedData()... error = ", e, false);
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.f, com.bytedance.ee.bear.document.offline.sync.q
    public final m0 g(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "objToken");
        Intrinsics.checkNotNullParameter(r101, "queries");
        m0 r102 = e0.m().s(this.f220578f, r100);
        e0 r103 = e0.m();
        Intrinsics.checkNotNullParameter(r101, "queries");
        AccountService$Account r104 = this.f569785z;
        if (r104 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("account");
        r104 = null;
    L6:
        m0 r105 = r103.s(n35.a.b(r104, ((z25.a) this).A, r101), r100);
        m0 r106 = e0.m().s(this.f569782w, r100);
        if (r102 != null) goto L9;
    L22:
        if (r105 != null) goto L24;
    L27:
        PreloadType r107 = PreloadType.ALL;
    L28:
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        this.f569783x = r107;
        ((ConcurrentHashMap) this.f569784y).put(r100, r107);
        return r106;
    L24:
        if (TextUtils.isEmpty(r105.f501542c) == true) goto L27;
        r107 = PreloadType.CLIENTVAR;
        goto L28
    L9:
        if (TextUtils.equals(r102.f501542c, "true") == false) goto L22;
        p r108 = this.f220586n;
        if (r108 == null) goto L16;
        if (r106 == null) goto L14;
        Long r109 = r106.f501544e;
    L15:
        Intrinsics.checkNotNull(r109);
        r25.e.a r110 = (r25.e.a) r108;
        r110.a(r100, r109.longValue());
        goto L16
    L14:
        r109 = r102.f501544e;
    L16:
        if (r105 != null) goto L18;
    L21:
        r107 = PreloadType.SSR;
        goto L28
    L18:
        if (TextUtils.isEmpty(r105.f501542c) == true) goto L21;
        r107 = PreloadType.NONE;
        goto L28
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.f
    public final com.alibaba.fastjson.JSONObject l(String r100, Map<String, String> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "objToken");
        Intrinsics.checkNotNullParameter(r101, "queries");
        com.alibaba.fastjson.JSONObject r103 = new com.alibaba.fastjson.JSONObject();
        StringBuilder r104 = new StringBuilder();
        z25.a r105 = (z25.a) this;
        r104.append(r105.A);
        r104.append(".fetchData");
        r103.put(WikiFolderPushPlugin.OPT, r104.toString());
        com.alibaba.fastjson.JSONObject r106 = new com.alibaba.fastjson.JSONObject();
        JSONArray r107 = new JSONArray();
        r106.put(r105.A + CancelRetainContactInfoFunctions.Token, r100);
        if (r102 == false) goto L5;
        tt5.a.h(this.f220573a, "isManualOffline is true");
        r107.put("clientVars");
        r106.put("fetchType", r107.toString());
    L18:
        if (c.a.f206237a.g("ccm.sheet.mobile.sub_block_set_limit_enable") == false) goto L23;
        if (r102 == false) goto L21;
        String r108 = OperationName.OPERATION_OFFLINE_AVAILABLE;
    L22:
        r106.put("eventType", r108);
        goto L23
    L21:
        r108 = "preload";
    L23:
        tt5.a.b(this.f220573a, "get preload type is " + this.f569783x);
        r103.put(ContainerPosition.BODY, r106);
        return r103;
    L5:
        PreloadType r109 = this.f569783x;
        if (r109 == PreloadType.NONE) goto L18;
        int r110 = a.f569786a[r109.ordinal()];
        if (r110 != 1) goto L10;
        r107.put("clientVars");
        r106.put("fetchType", r107.toString());
        goto L18
    L10:
        if (r110 != 2) goto L12;
        r107.put("ssr");
        r106.put("fetchType", r107.toString());
        goto L18
    L12:
        if (r110 != 3) goto L18;
        r107.put("clientVars").put("ssr");
        r106.put("fetchType", r107.toString());
        goto L18
    }
}
