package com.bytedance.ee.bear.document.offline.sync;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.document.offline.sync.preloadexecutor.subblock.SubBlockModel;
import com.bytedance.ee.bear.document.offline.sync.preloadexecutor.subblock.SubBlockType;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h extends g {
    public h() {
        this.a = "DocPreloadStrategy";
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.g, com.bytedance.ee.bear.document.offline.sync.q
    public final void f(AccountService$Account r3) {
        super.f(r3);
        this.f = r3.tenantId + OfflineDoc.DASH_DELIMITER + r3.uid + "_CLIENT_VARS";
        this.g = PreloadConfigModel.VERSION_CHECK_TYPE_DOC;
        this.j = new v25.b();
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.f, com.bytedance.ee.bear.document.offline.sync.q
    public final k25.m0 g(String r12, Map<String, String> r13) {
        if (TextUtils.isEmpty(this.f) == true) goto L5;
        k25.m0 r14 = k25.e0.m().s(this.f, r12);
        if (r14 != null) goto L9;
        return r14;
    L9:
        if (r14.c == null) goto L59;
        x25.f r0 = r14.u;
        if (r0 == null) goto L56;
        SubBlockType r1 = SubBlockType.IMAGE_DATA;
        boolean r3 = true;
        boolean r4 = false;
        if (r0.a(r1) == true) goto L15;
    L18:
        boolean r2 = true;
    L19:
        SubBlockType r5 = SubBlockType.POLL_DATA;
        if (r0.a(r5) == false) goto L26;
        if (r2 == true) goto L23;
    L25:
        r2 = false;
        goto L26
    L23:
        if (r0.b(r5) == false) goto L25;
        r2 = true;
    L26:
        SubBlockType r6 = SubBlockType.COMMENTS_DATA;
        if (r0.a(r6) == false) goto L33;
        if (r2 == true) goto L30;
    L32:
        r2 = false;
        goto L33
    L30:
        if (r0.b(r6) == false) goto L32;
        r2 = true;
    L33:
        SubBlockType r7 = SubBlockType.INNER_SHEET;
        if (r0.a(r7) == false) goto L40;
        if (r2 == true) goto L37;
    L39:
        r2 = false;
        goto L40
    L37:
        if (r0.b(r7) == false) goto L39;
        r2 = true;
    L40:
        if (r2 == true) goto L56;
        tt5.a.b(this.a, "doOfflineDocValidation... for :" + r14.k);
        f35.a.C0225a r8 = f35.a.b.a.a(r14.k, sbb.e.g(r14.getType()), 900, true);
        if (r8 != null) goto L45;
    L49:
        if (r4 == false) goto L56;
        if (r14.a() == false) goto L56;
        tt5.a.h(this.a, "need preload subblocks : " + du5.b.g(r12) + " current statucode=" + r14.o);
        JSONObject r9 = d25.d.e(r14.c);
        if (r9 == null) goto L55;
        s(r9, r12, r14);
        return r14;
    L55:
        return null;
    L45:
        if (r8.a == 0) goto L48;
        r3 = false;
    L48:
        r4 = r3;
        goto L49
    L15:
        if (r0.b(r1) == true) goto L18;
        r2 = false;
    L56:
        tt5.a.h(this.a, "no need for preloading ObjToken = " + du5.b.g(r12));
        return r14;
    L59:
        return r14;
    L5:
        return new k25.m0();
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.f
    public final void o(String r3, String r4) {
        JSONObject r5 = d25.d.e(r3);
        k25.m0 r0 = k25.e0.m().n(this.f, r4);
        if (r5 == null) goto L6;
        s(r5, r4, r0);
        return;
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.f
    public final com.alibaba.fastjson.JSONObject l(String r1, Map<String, String> r2, boolean r3) {
        return r(new k0(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, new r(this.l, r1)));
    }

    public final void s(JSONObject r14, String r16, k25.m0 r17) {
    L43:
        e = move-exception;
        tt5.a.d(this.a, "preloadSubBlock()... e = " + e);
        return;
    L4:
        int r7 = 0;
        if (r14.optJSONArray("sheets") != null) goto L7;
        r17.u.c(64);     // Catch: Exception -> L43
    L11:
        if (r14.optJSONArray("comments") == null) goto L15;
        x25.f r4 = r17.u;     // Catch: Exception -> L43
        SubBlockType r11 = SubBlockType.COMMENTS_DATA;     // Catch: Exception -> L43
        if (r4.b(r11) == true) goto L17;
        SubBlockModel r5 = new SubBlockModel(r16, sbb.e.g.b, r11);     // Catch: Exception -> L43
        r5.setOwnerResKey(this.f);     // Catch: Exception -> L43
        Long r12 = h0.j;     // Catch: Exception -> L43
        h0.b.a.c(new SubBlockModel[]{r5});     // Catch: Exception -> L43
    L17:
        if (r14.optJSONArray("polls") != null) goto L19;
        r17.u.c(4);     // Catch: Exception -> L43
    L26:
        if (r14.optJSONArray("images") != null) goto L28;
        r17.u.c(1);     // Catch: Exception -> L43
    L38:
        p r0 = this.n;     // Catch: Exception -> L43
        if (r0 == null) goto L41;
        ((r25.e.a) r0).a(r16, System.currentTimeMillis());     // Catch: Exception -> L43
    L41:
        k25.e0.m().I(r17);     // Catch: Exception -> L43
        return;
    L28:
        if (r17.u.b(SubBlockType.IMAGE_DATA) == true) goto L38;
        JSONArray r1 = r14.optJSONArray("images");     // Catch: Exception -> L43
        if (r1 == null) goto L38;
        if (r1.length() <= 0) goto L38;
        ArrayList r6 = new ArrayList();     // Catch: Exception -> L43
        int r2 = Math.min(r1.length(), 10);     // Catch: Exception -> L43
    L34:
        if (r7 >= r2) goto L36;
        r6.add(new SubBlockModel(r16, sbb.e.g.b, SubBlockType.IMAGE_DATA, URLDecoder.decode(((JSONObject) r1.get(r7)).optString("src"), "UTF-8")));     // Catch: Exception -> L43
        r7 = r7 + 1;     // Catch: Exception -> L43
        goto L34
    L36:
        Long r3 = h0.j;     // Catch: Exception -> L43
        h0.b.a.b(this.f, r16, sbb.e.g.b, r6, false, null);     // Catch: Exception -> L43
        goto L38
    L19:
        if (r17.u.b(SubBlockType.POLL_DATA) == true) goto L26;
        JSONArray r8 = r14.optJSONArray("polls");     // Catch: Exception -> L43
        tt5.a.h(this.a, "preload polls data, objToken = " + du5.b.g(r16) + ", polls size = " + r8.length());     // Catch: Exception -> L43
        ArrayList r9 = new ArrayList();     // Catch: Exception -> L43
        int r10 = Math.min(r8.length(), 5);     // Catch: Exception -> L43
        int r13 = 0;
    L21:
        if (r13 >= r10) goto L23;
        r9.add(((JSONObject) r8.get(r13)).optString("token"));     // Catch: Exception -> L43
        r13 = r13 + 1;     // Catch: Exception -> L43
        goto L21
    L23:
        SubBlockModel r18 = new SubBlockModel(r16, sbb.e.g.b, SubBlockType.POLL_DATA, r9);     // Catch: Exception -> L43
        r18.setOwnerResKey(this.f);     // Catch: Exception -> L43
        Long r19 = h0.j;     // Catch: Exception -> L43
        h0.b.a.c(new SubBlockModel[]{r18});     // Catch: Exception -> L43
        goto L26
    L15:
        r17.u.c(16);     // Catch: Exception -> L43
        goto L17
    L7:
        if (r17.u.b(SubBlockType.INNER_SHEET) == true) goto L11;
        l0.a(sbb.e.h.b).d(((JSONObject) r14.optJSONArray("sheets").get(0)).optString("token"), r16, this.f);     // Catch: Exception -> L43
        goto L11
    }
}
