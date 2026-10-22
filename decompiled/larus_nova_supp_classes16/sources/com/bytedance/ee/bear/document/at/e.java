package com.bytedance.ee.bear.document.at;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.atfinder.AtFinderResult;
import com.bytedance.ee.bear.atfinder.MentionModel;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.document.at.search.SearchDataLoader;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements com.bytedance.ee.bear.atfinder.f {
    public NetService.f a;
    public final NetService.d<AtFinderNetServiceResult> b;
    public final ww4.a c;
    public final String d;
    public Map<String, String> e;
    public final Map<String, String> f;

    public static e c(Context r4) {
        return new e((NetService) org.koin.java.a.a(NetService.class), (i0) org.koin.java.a.a(i0.class), (ww4.a) org.koin.java.a.a(ww4.a.class), r4);
    }

    public static String b(MentionModel r1, String r2) {
        if (r2 != null) goto L6;
        return r1 + "";
    L6:
        return r1 + r2;
    }

    public final Disposable a(final MentionModel r10, final String r11, final com.bytedance.ee.bear.atfinder.g r12) {
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mention.owner_recommend_optimize.mobile");
        StringBuilder r1 = new StringBuilder("search()... keyword length=");
        int r3 = 0;
        if (r10.getKeyword() == null) goto L5;
        int r2 = r10.getKeyword().length();
    L6:
        r1.append(r2);
        r1.append(", searchType=");
        r1.append(r11);
        r1.append(", optimizeEnable=");
        r1.append(r0);
        r1.append(", customHeader size=");
        Map<String, String> r4 = this.e;
        if (r4 == null) goto L10;
        r3 = r4.size();
    L10:
        r1.append(r3);
        tt5.a.h("AtFinderRepository", r1.toString());
        r12.a();
        String r5 = "";
        if (TextUtils.isEmpty(r10.getKeyword()) == false) goto L19;
        Map<String, String> r6 = this.f;
        HashMap r7 = (HashMap) r6;
        String r8 = (String) r7.get(b(r10, r11));
        if (TextUtils.isEmpty(r8) == true) goto L19;
        tt5.a.h("AtFinderRepository", "search key is empty, find cache in mEmptySearchResultMap");
        AtFinderNetServiceResult r9 = new f(eu5.b.a, (i0) org.koin.java.a.a(i0.class)).c(r8);
        r9.keyword = r10.getKeyword();
        final AtFinderResult r13 = AtFinderNetServiceResult.convertTo(r9);
        if (hu5.a.f(r13.list) == false) goto L19;
        return Flowable.just("").subscribe(new b(r12, r13));
    L19:
        if (TextUtils.isEmpty(r10.getKeyword()) == true) goto L26;
        if (r0 == false) goto L26;
        if (hu5.a.g(this.e) == true) goto L26;
        tt5.a.h("AtFinderRepository", "searchBySearchBackend: ");
        int r14 = SearchDataLoader.a;
        return SearchDataLoader.c(r10, r11, r12);
    L26:
        tt5.a.h("AtFinderRepository", "searchByCcmBackend: ");
        String r16 = r10.getToken();
        String r17 = r10.getKeyword();
        int r18 = r10.getSource();
        String r19 = r10.getChatId();
        if (r18 != 24) goto L29;
    L34:
        String r20 = DiagramData$RESULT.FAIL;
    L35:
        HashMap r21 = new HashMap();
        if (r16 != null) goto L38;
        r16 = "";
    L38:
        r21.put("token", r16);
        if (TextUtils.isEmpty(r17) == false) goto L41;
        r17 = "";
    L41:
        r21.put("content", r17);
        if (r20 == null) goto L45;
        r5 = r20;
    L45:
        r21.put("type", r5);
        r21.put("source", Integer.toString(r18));
        if (TextUtils.isEmpty(r19) == true) goto L48;
        r21.put("chat_id", r19);
    L48:
        r21.put("user_type", this.d);
        if (this.c.a().c().a == true) goto L51;
        r21.put("config_source", Integer.toString(1));
    L51:
        NetService.f r22 = new NetService.f("/api/mention/recommend.v2/");
        this.a = r22;
        r22.d(r21);
        Map<String, String> r23 = this.e;
        if (r23 != null) goto L54;
    L56:
        this.a.c = 1;
        final String r24 = r10.getKeyword();
        return this.b.a(this.a).observeOn(fo5.d.d()).subscribe(new c(this, r11, r24, r12, r10), new d(r24, r12));
    L54:
        if (r23.isEmpty() == true) goto L56;
        this.a.c(this.e);
        goto L56
    L29:
        if (r18 == 29) goto L31;
    L33:
        r20 = r11;
        goto L35
    L31:
        if (TextUtils.isEmpty(r17) == false) goto L33;
    L5:
        r2 = 0;
        goto L6
    }

    public e(NetService r2, i0 r3, ww4.a r4, Context r5) {
        this.f = new HashMap();
        this.b = r2.Vc(new f(r5, r3));
        this.c = r4;
        this.d = DiagramData$RESULT.FAIL;
    }
}
