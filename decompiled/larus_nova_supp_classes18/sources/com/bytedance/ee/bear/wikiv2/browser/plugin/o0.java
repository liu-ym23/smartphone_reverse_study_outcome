package com.bytedance.ee.bear.wikiv2.browser.plugin;

import android.net.Uri;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.offline.DocWikiInfo;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o0 extends com.bytedance.ee.bear.document.offline.sync.g implements com.bytedance.ee.bear.document.offline.sync.o {

    public class a implements com.bytedance.ee.bear.contract.n.b {
        public final /* synthetic */ com.bytedance.ee.bear.contract.n.b a;
        public final /* synthetic */ String b;
        public final /* synthetic */ o0 c;

        public final void d(String r3) {
            com.bytedance.ee.bear.contract.n.b r0 = this.a;
            if (r0 == null) goto L5;
            r0.d(r3);
        L5:
            tt5.a.b(((com.bytedance.ee.bear.document.offline.sync.f) this.c).a, "WikiPreload.preload, preload success. doc: " + du5.b.i(this.b));
            if (lbb.a.a(this.b) == true) goto L9;
            ((rc5.a) org.koin.java.a.a(rc5.a.class)).j(this.b);
            return;
        }

        public final void onPreloadFail(String r2) {
            com.bytedance.ee.bear.contract.n.b r0 = this.a;
            if (r0 == null) goto L6;
            r0.onPreloadFail(r2);
            return;
        }

        public final void onPreloadStart(String r2) {
            com.bytedance.ee.bear.contract.n.b r0 = this.a;
            if (r0 == null) goto L6;
            r0.onPreloadStart(r2);
            return;
        }

        public a(o0 r1, com.bytedance.ee.bear.contract.n.b r2, String r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public final JSONObject l(String r1, Map<String, String> r2, boolean r3) {
        return null;
    }

    public final void o(String r1, String r2) {
    }

    public o0() {
        ((com.bytedance.ee.bear.document.offline.sync.f) this).a = "WikiPreloadStrategy";
    }

    public final boolean c(OfflineDoc r2) {
        OfflineDoc r0 = e(r2);
        if (r2 == null) goto L7;
        WikiInfo r3 = s(r2.getObj_token());
        if (r3 == null) goto L7;
        com.bytedance.ee.bear.document.offline.sync.q r4 = com.bytedance.ee.bear.document.offline.sync.l0.a(r3.getObjType());
    L8:
        if (r0 == null) goto L13;
        if (r4 == null) goto L13;
        if (r4.c(r0) == false) goto L13;
        return true;
    L13:
        return false;
    L7:
        r4 = null;
        goto L8
    }

    public final OfflineDoc e(OfflineDoc r9) {
        if (r9 == null) goto L22;
        WikiInfo r0 = s(r9.getObj_token());
        if (r0 == null) goto L22;
        int r1 = r0.getObjType();
        String r2 = r0.getObjToken();
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.sheet_ssr_cache_by_sheet_id") == false) goto L8;
        Map r3 = com.bytedance.ee.bear.document.offline.sync.f.m(r9);
        r3.put("from", r9.getFrom_source());
        String r4 = s45.p.a().Le(sbb.e.f(r1), r2, r3);
    L10:
        if (r1 == sbb.e.i.b) goto L24;
    L21:
        OfflineDoc r5 = new OfflineDoc(r2, r4, r1, r9.getFrom_source());
        r5.setSubFrom(r9.getSubFrom());
        r5.setTriggerTime(r9.getTriggerTime());
        r5.setTaskManagerEnqueueTime(r9.getTaskManagerEnqueueTime());
        r5.setPreloadManagerEnqueueTime(r9.getPreloadManagerEnqueueTime());
        r5.setReqId(r9.getReqId());
        r5.setCanPreloadIfFileOpen(r9.isCanPreloadIfFileOpen());
        r5.setDownloadStatus(r9.getDownloadStatus());
        r5.setIsWiki(true);
        DocWikiInfo r6 = new DocWikiInfo();
        r6.setWiki_token(r9.getObj_token());
        r6.setObj_token(r2);
        r6.setObj_type(r1);
        r5.setWikiInfo(r6);
        return r5;
    L24:
        Uri r7 = UriProtector.parse(r9.getUrl());     // Catch: Throwable -> L19
        Uri.Builder r8 = UriProtector.parse(r4).buildUpon();     // Catch: Throwable -> L19
        Set r10 = UriProtector.getQueryParameterNames(r7);     // Catch: Throwable -> L19
        if (hu5.a.d(r10) == true) goto L17;
        Iterator r11 = r10.iterator();     // Catch: Throwable -> L19
    L15:
        if (r11.hasNext() == false) goto L17;
        String r12 = (String) r11.next();     // Catch: Throwable -> L19
        r8.appendQueryParameter(r12, UriProtector.getQueryParameter(r7, r12));     // Catch: Throwable -> L19
    L17:
        r4 = r8.toString();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        tt5.a.e(((com.bytedance.ee.bear.document.offline.sync.f) this).a, "WikiPreload.preload, set query error", th, false);
        goto L21
    L8:
        r4 = s45.p.a().ua(sbb.e.f(r1), r2, r9.getFrom_source());
    L22:
        return null;
    }

    public final void f(AccountService.Account r1) {
        super.f(r1);
    }

    public final WikiInfo s(String r4) {
        return (WikiInfo) p0.i(new ce5.a(), r4).blockingSingle();
    L4:
        th = move-exception;
        tt5.a.e(((com.bytedance.ee.bear.document.offline.sync.f) this).a, "WikiPreload.preload, getWikiInfo err. ", th, false);
        return null;
    }

    public final void b(OfflineDoc r5, com.bytedance.ee.bear.contract.n.b r6) {
        String r0 = r5.getObj_token();
        tt5.a.b(((com.bytedance.ee.bear.document.offline.sync.f) this).a, "WikiPreload.preload, preload start. doc: " + du5.b.i(r0));
        OfflineDoc r1 = e(r5);
        WikiInfo r7 = s(r5.getObj_token());
        if (r7 == null) goto L5;
        com.bytedance.ee.bear.document.offline.sync.q r8 = com.bytedance.ee.bear.document.offline.sync.l0.a(r7.getObjType());
    L6:
        if (r1 == null) goto L11;
        if (r8 == null) goto L11;
        r8.b(r1, new a(this, r6, r0));
        return;
    L11:
        tt5.a.k(((com.bytedance.ee.bear.document.offline.sync.f) this).a, "WikiPreload.preload, strategy=null.");
        return;
    L5:
        r8 = null;
        goto L6
    }

    public final k25.m0 g(String r2, Map<String, String> r3) {
        WikiInfo r4 = s(r2);
        if (r4 == null) goto L7;
        com.bytedance.ee.bear.document.offline.sync.q r0 = com.bytedance.ee.bear.document.offline.sync.l0.a(r4.getObjType());
        if (r0 == null) goto L7;
        return r0.g(r4.getObjToken(), r3);
    L7:
        return null;
    }
}
