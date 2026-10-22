package com.bytedance.ee.bear.document.offline.sync;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.bytedance.ee.bear.bitable.preload.BitableRustPreloadStrategy;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.document.offline.sync.preloadexecutor.infocheck.DocumentVersionInfo;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.PreviewStatus;
import com.bytedance.ee.eenet.util.ComplexConnect;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class f implements q {
    public String a;
    public final NetService b;
    public final com.bytedance.ee.bear.contract.b0 c;
    public final com.bytedance.ee.bear.contract.d d;
    public final com.bytedance.ee.bear.contract.j e;
    public String f;
    public String g;
    public int h;
    public final String i;
    public v25.a j;
    public String k;
    public String l;
    public final List<String> m;
    public p n;

    @Override // com.bytedance.ee.bear.document.offline.sync.q
    public void d(String r1, String r2, String r3) {
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.q
    public abstract k25.m0 g(String r1, Map<String, String> r2);

    @Override // com.bytedance.ee.bear.document.offline.sync.q
    public OfflineDoc h(OfflineDoc r1) {
        return r1;
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.q
    public boolean i() {
        return !(this instanceof BitableRustPreloadStrategy);
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.q
    public final void k() {
    }

    public abstract JSONObject l(String r1, Map<String, String> r2, boolean r3);

    public abstract boolean n(org.json.JSONObject r1);

    public abstract void o(String r1, String r2);

    public abstract Response p(OfflineDoc r1);

    public void q(String r1) {
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.q
    public final long a() {
        return h0.l.getUpdate_clientvar_frequency();
    }

    public f() {
        this.a = "AbsPreloadStrategy";
        this.h = -1;
        this.m = new ArrayList();
        NetService r0 = (NetService) org.koin.java.a.a(NetService.class);
        this.b = r0;
        this.c = (com.bytedance.ee.bear.contract.b0) org.koin.java.a.a(com.bytedance.ee.bear.contract.b0.class);
        this.d = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        this.e = com.bytedance.ee.bear.contract.j.a.a;
        f35.a.b.a.bindService(r0);
        this.i = "https://" + s45.p.u + PreloadConfigModel.GET_DOCUMENT_VERSION;
    }

    public static Map m(OfflineDoc r2) {
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.sheet_ssr_cache_by_sheet_id") == false) goto L10;
        if (r2 == null) goto L10;
        Map<String, String> r3 = ((t45.c) e0c.k.a(LarkContext.getApplication(), t45.c.class)).Z(r2.getUrl()).d;
        if (r3 == null) goto L8;
        return r3;
    L8:
        return new HashMap();
    L10:
        return new HashMap();
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.q
    public boolean c(OfflineDoc r9) {
        k25.m0 r0 = g(r9.getObj_token(), m(r9));
        boolean r1 = true;
        if (r0 != null) goto L5;
    L56:
        tt5.a.h(this.a, "This doc need to preload because of empty local cache.");
        q(r9.getObj_token());
        return true;
    L5:
        if (TextUtils.isEmpty(r0.c) == true) goto L56;
        if (r0.b() == false) goto L12;
        tt5.a.h(this.a, "Do not need to preload because has paged.");
        return false;
    L12:
        if ((System.currentTimeMillis() - r0.e.longValue()) < a()) goto L52;
        JSONObject r4 = new JSONObject();
        r4.put("type", this.g);
        r4.put("token", r9.getObj_token());
        if (this.g != PreloadConfigModel.VERSION_CHECK_TYPE_DOCX) goto L16;
        r4.put("resource_type", "structure");
    L16:
        JSONObject r5 = new JSONObject();
        JSONArray r6 = new JSONArray();
        r6.add(r4);
        r5.put("obj_list", r6);
        Response r7 = this.b.g6(new Request.Builder().url(this.i).addHeader("EENet-Request-Enable-Complex-Connect", ComplexConnect.TRUE.toString()).post(RequestBody.create(MediaType.parse("application/json"), r5.toJSONString())).build());     // Catch: Exception -> L46
        if (r7 != null) goto L20;
    L48:
        if (r1 == false) goto L50;
        q(r9.getObj_token());
    L50:
        return r1;
    L20:
        if (r7.isSuccessful() == false) goto L48;
        DocumentVersionInfo r8 = (DocumentVersionInfo) JSON.parseObject(r7.body().string(), new e(), new Feature[0]);     // Catch: Exception -> L46
        if (r8.getCode() != 0) goto L44;
        DocumentVersionInfo.Data r2 = r8.getData();     // Catch: Exception -> L46
        if (r2 != null) goto L26;
        List<DocumentVersionInfo.Data.ObjVersion> r10 = null;
    L27:
        if (r2 == null) goto L43;
        if (r10 == null) goto L43;
        if (r10.size() == 0) goto L43;
        int r3 = ((DocumentVersionInfo.Data.ObjVersion) ListProtector.get(r10, 0)).getVersion();     // Catch: Exception -> L46
        v25.a r11 = this.j;     // Catch: Exception -> L46
        r11.getClass();     // Catch: Exception -> L46
    L38:
        e = move-exception;
        tt5.a.l(r11.a, "getVersionInternal failed, ", e);     // Catch: Exception -> L46
    L40:
        int r12 = -1;
    L41:
        if (r3 > r12) goto L48;
        tt5.a.h(this.a, du5.b.g(r9.getObj_token()) + " not need to preload，because of remote version is not over local version.");     // Catch: Exception -> L46
        r1 = false;
        goto L48
    L34:
        if (r0.b() == true) goto L40;
        r12 = r11.a(r0.c);     // Catch: Exception -> L38
    L43:
        tt5.a.h(this.a, du5.b.g(r9.getObj_token()) + " need to preload，because of empty data.");     // Catch: Exception -> L46
        goto L48
    L26:
        r10 = r2.getObj_version();     // Catch: Exception -> L46
        goto L27
    L44:
        tt5.a.k(this.a, "Failed to get remote clientVars version, code= " + r8.getCode() + ", msg=" + r8.getMsg());     // Catch: Exception -> L46
    L46:
        e = move-exception;
        tt5.a.l(this.a, "Failed to get remote version, ", e);
        goto L48
    L52:
        if (((com.bytedance.ee.bear.middleground.feed.export.bean.h) org.koin.java.a.a(com.bytedance.ee.bear.middleground.feed.export.bean.h.class)).e(r9.getFrom_source()) == false) goto L55;
        r9.setOnlyPreLoadFeed(true);
        tt5.a.h(this.a, du5.b.g(r9.getObj_token()) + " only preload feed.");
        return true;
    L55:
        return false;
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.q
    public final void j(r25.e.a r1) {
        this.n = r1;
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.q
    public void b(final OfflineDoc r34, com.bytedance.ee.bear.contract.n.b r36) {
    L8:
        e = move-exception;
        if (r36 == null) goto L76;
        r36.onPreloadFail(r34.getObj_token());
    L76:
        iu5.d.a("CLIENT_VAR_EXCEPTION", new Throwable("failed to preload clientvar: " + sbb.e.f(r34.getType()), e));
        return;
    L4:
        if (TextUtils.isEmpty(this.f) == false) goto L11;
        tt5.a.k(this.a, "consumeDoc()... mKey null ");     // Catch: Exception -> L8
        if (r36 == null) goto L10;
        r36.onPreloadFail(r34.getObj_token());     // Catch: Exception -> L8
        return;
    L10:
        return;
    L11:
        long r17 = System.currentTimeMillis();     // Catch: Exception -> L8
        Response r28 = p(r34);     // Catch: Exception -> L8
        if (r28 == null) goto L49;
        if (r28.isSuccessful() == false) goto L49;
        String r14 = r28.body().string();     // Catch: Exception -> L8
        int r16 = h0.l.getSingle_doc_max_length();     // Catch: Exception -> L8
        if (TextUtils.isEmpty(r14) == true) goto L26;
        if (r14.length() <= r16) goto L26;
        if ("tab_manual_offline".equals(r34.getFrom_source()) == false) goto L23;
        iu5.d.a(this.a, new Throwable("manual offline responseStr.size =  " + r14.length() + " and doc max length = " + r16));     // Catch: Exception -> L8
        goto L26
    L23:
        ((r25.e.a) this.n).a(r34.getObj_token(), System.currentTimeMillis());     // Catch: Exception -> L8
        e25.b.b(new e25.c(r34.getType(), "clientvar", r34.getFrom_source(), r34.getSubFrom(), "native", r34.getPreload_priority(), 1, PreviewStatus.UNEXPECTED_COMPRESS_FORMAT, "exceed limit", r17, r34.getTriggerTime(), r34.getTaskManagerEnqueueTime(), r34.getPreloadManagerEnqueueTime(), r14.length(), 0, null));     // Catch: Exception -> L8
        iu5.d.a(this.a, new Throwable("consumeDoc()...  MAX_LENGTH responseStr.size =  " + r14.length() + " and doc max length = " + r16));     // Catch: Exception -> L8
        return;
    L26:
        if (TextUtils.isEmpty(r14) == true) goto L28;
        String r18 = r14;
        org.json.JSONObject r0 = new org.json.JSONObject(r18);     // Catch: Exception -> L8
    L30:
        if (n(r0) == false) goto L41;
        k25.m0 r5 = new k25.m0();     // Catch: Exception -> L8
        r5.b = this.f;     // Catch: Exception -> L8
        String r1 = r0.toString();     // Catch: Exception -> L8
        r5.c = r1;     // Catch: Exception -> L8
        r5.k = r34.getObj_token();     // Catch: Exception -> L8
        r5.n = UriProtector.parse(r34.getUrl()).getPath();     // Catch: Exception -> L8
        r5.e = Long.valueOf(System.currentTimeMillis());     // Catch: Exception -> L8
        r5.v = 1;     // Catch: Exception -> L8
        r5.i = sbb.e.f(r34.getType());     // Catch: Exception -> L8
        r5.s = "native";     // Catch: Exception -> L8
        tt5.a.b(this.a, "consumeDoc save key = " + this.f + ",var = " + r5.c.length());     // Catch: Exception -> L8
        k25.e0.m().w(r5);     // Catch: Exception -> L8
        int r6 = r34.getType();     // Catch: Exception -> L8
        String r9 = r34.getFrom_source();     // Catch: Exception -> L8
        String r10 = r34.getSubFrom();     // Catch: Exception -> L8
        int r12 = r34.getPreload_priority();     // Catch: Exception -> L8
        long r19 = r34.getTriggerTime();     // Catch: Exception -> L8
        long r21 = r34.getTaskManagerEnqueueTime();     // Catch: Exception -> L8
        long r26 = r34.getPreloadManagerEnqueueTime();     // Catch: Exception -> L8
        int r2 = yu5.c.c(r1);     // Catch: Exception -> L8
        if (((ArrayList) this.m).contains(r34.getObj_token()) == false) goto L34;
        int r23 = 1;
    L35:
        e25.b.b(new e25.c(r6, "clientvar", r9, r10, "native", r12, 0, 0, "", r17, r19, r21, r26, r2, r23, null));     // Catch: Exception -> L8
        o(r18, r34.getObj_token());     // Catch: Exception -> L8
        if (lbb.a.a(r34.getObj_token()) == true) goto L38;
        ((rc5.a) org.koin.java.a.a(rc5.a.class)).j(r34.getObj_token());     // Catch: Exception -> L8
    L38:
        if (r36 == null) goto L40;
        r36.d(r34.getObj_token());     // Catch: Exception -> L8
    L40:
        tt5.a.b(this.a, "consumeDoc()... token111 =  ");     // Catch: Exception -> L8
        return;
    L34:
        r23 = 0;
        goto L35
    L41:
        if (r36 == null) goto L43;
        r36.onPreloadFail(r34.getObj_token());     // Catch: Exception -> L8
    L43:
        int r7 = r34.getType();     // Catch: Exception -> L8
        String r11 = r34.getFrom_source();     // Catch: Exception -> L8
        String r13 = r34.getSubFrom();     // Catch: Exception -> L8
        int r110 = r34.getPreload_priority();     // Catch: Exception -> L8
        int r111 = this.h;     // Catch: Exception -> L8
        long r112 = r34.getTriggerTime();     // Catch: Exception -> L8
        long r22 = r34.getTaskManagerEnqueueTime();     // Catch: Exception -> L8
        long r24 = r34.getPreloadManagerEnqueueTime();     // Catch: Exception -> L8
        if (((ArrayList) this.m).contains(r34.getObj_token()) == false) goto L46;
        int r29 = 1;
    L47:
        e25.b.b(new e25.c(r7, "clientvar", r11, r13, "native", r110, 1, r111, "failure", r17, r112, r22, r24, -1, r29, null));     // Catch: Exception -> L8
        tt5.a.k(this.a, "consumeDoc()... token333 =  " + r28.body().string());     // Catch: Exception -> L8
        return;
    L46:
        r29 = 0;
        goto L47
    L28:
        r18 = r14;
        r0 = null;
    L49:
        ResponseBody r8 = "";
        if (((ArrayList) this.m).contains(r34.getObj_token()) == true) goto L59;
        tt5.a.k(this.a, "consumeDoc()... token444 retryDoc =  " + r34);     // Catch: Exception -> L8
        int r20 = r34.getType();     // Catch: Exception -> L8
        String r113 = r34.getFrom_source();     // Catch: Exception -> L8
        String r114 = r34.getSubFrom();     // Catch: Exception -> L8
        int r115 = r34.getPreload_priority();     // Catch: Exception -> L8
        if (r28 != null) goto L54;
        int r116 = PreviewStatus.OVER_MUCH_NODES_IN_TOTAL;
    L55:
        if (r28 != null) goto L57;
        String r117 = "response empty";
    L58:
        e25.b.b(new e25.c(r20, "clientvar", r113, r114, "native", r115, 1, r116, r117, r17, r34.getTriggerTime(), r34.getTaskManagerEnqueueTime(), r34.getPreloadManagerEnqueueTime(), -1, 0, null));     // Catch: Exception -> L8
        ((ArrayList) this.m).add(r34.getObj_token());     // Catch: Exception -> L8
        Flowable.just("").subscribeOn(fo5.d.b()).map(new a()).map(new b(r34)).subscribe(new c(this), new d(this));     // Catch: Exception -> L8
    L69:
        String r3 = this.a;     // Catch: Exception -> L8
        StringBuilder r4 = new StringBuilder("consumeDoc()... token555 =  ");     // Catch: Exception -> L8
        if (r28 == null) goto L72;
        r8 = r28.body();     // Catch: Exception -> L8
    L72:
        r4.append(r8);     // Catch: Exception -> L8
        tt5.a.k(r3, r4.toString());     // Catch: Exception -> L8
        return;
    L57:
        r117 = r28.message();     // Catch: Exception -> L8
        goto L58
    L54:
        r116 = r28.code();     // Catch: Exception -> L8
        goto L55
    L59:
        if (r36 == null) goto L61;
        r36.onPreloadFail(r34.getObj_token());     // Catch: Exception -> L8
    L61:
        int r27 = r34.getType();     // Catch: Exception -> L8
        String r118 = r34.getFrom_source();     // Catch: Exception -> L8
        String r119 = r34.getSubFrom();     // Catch: Exception -> L8
        int r120 = r34.getPreload_priority();     // Catch: Exception -> L8
        if (r28 != null) goto L64;
        int r121 = PreviewStatus.OVER_MUCH_NODES_IN_TOTAL;
    L65:
        if (r28 != null) goto L67;
        String r122 = "response empty";
    L68:
        e25.b.b(new e25.c(r27, "clientvar", r118, r119, "native", r120, 1, r121, r122, r17, r34.getTriggerTime(), r34.getTaskManagerEnqueueTime(), r34.getPreloadManagerEnqueueTime(), -1, 1, null));     // Catch: Exception -> L8
        goto L69
    L67:
        r122 = r28.message();     // Catch: Exception -> L8
        goto L68
    L64:
        r121 = r28.code();     // Catch: Exception -> L8
        goto L65
    }
}
