package com.bytedance.ee.bear.document.at;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.atfinder.AtFinderResult;
import com.bytedance.ee.bear.atfinder.MentionModel;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.document.at.search.SearchDataLoader;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public final class e implements com.bytedance.ee.bear.atfinder.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NetService.f f219102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NetService.d<AtFinderNetServiceResult> f219103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ww4.a f219104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f219105d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, String> f219106e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f219107f;

    public static e c(Context r100) {
        return new e((NetService) org.koin.java.a.a(NetService.class), (i0) org.koin.java.a.a(i0.class), (ww4.a) org.koin.java.a.a(ww4.a.class), r100);
    }

    public static String b(MentionModel r100, String r101) {
        if (r101 != null) goto L6;
        return r100 + "";
    L6:
        return r100 + r101;
    }

    @Override // com.bytedance.ee.bear.atfinder.f
    public final Disposable a(final MentionModel r110, final String r111, final com.bytedance.ee.bear.atfinder.g r112) {
        boolean r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mention.owner_recommend_optimize.mobile");
        StringBuilder r101 = new StringBuilder("search()... keyword length=");
        int r102 = 0;
        if (r110.getKeyword() == null) goto L5;
        int r103 = r110.getKeyword().length();
    L6:
        r101.append(r103);
        r101.append(", searchType=");
        r101.append(r111);
        r101.append(", optimizeEnable=");
        r101.append(r100);
        r101.append(", customHeader size=");
        Map<String, String> r104 = this.f219106e;
        if (r104 == null) goto L10;
        r102 = r104.size();
    L10:
        r101.append(r102);
        tt5.a.h("AtFinderRepository", r101.toString());
        r112.a();
        String r105 = "";
        if (TextUtils.isEmpty(r110.getKeyword()) == false) goto L19;
        Map<String, String> r106 = this.f219107f;
        HashMap r107 = (HashMap) r106;
        String r108 = (String) r107.get(b(r110, r111));
        if (TextUtils.isEmpty(r108) == true) goto L19;
        tt5.a.h("AtFinderRepository", "search key is empty, find cache in mEmptySearchResultMap");
        AtFinderNetServiceResult r109 = new f(eu5.b.f474075a, (i0) org.koin.java.a.a(i0.class)).c(r108);
        r109.keyword = r110.getKeyword();
        final AtFinderResult r113 = AtFinderNetServiceResult.convertTo(r109);
        if (hu5.a.f(r113.list) == false) goto L19;
        return Flowable.just("").subscribe(new b(r112, r113));
    L19:
        if (TextUtils.isEmpty(r110.getKeyword()) == true) goto L26;
        if (r100 == false) goto L26;
        if (hu5.a.g(this.f219106e) == true) goto L26;
        tt5.a.h("AtFinderRepository", "searchBySearchBackend: ");
        int r114 = SearchDataLoader.f219122a;
        return SearchDataLoader.c(r110, r111, r112);
    L26:
        tt5.a.h("AtFinderRepository", "searchByCcmBackend: ");
        String r115 = r110.getToken();
        String r116 = r110.getKeyword();
        int r117 = r110.getSource();
        String r118 = r110.getChatId();
        if (r117 != 24) goto L29;
    L34:
        String r119 = "0";
    L35:
        HashMap r120 = new HashMap();
        if (r115 != null) goto L38;
        r115 = "";
    L38:
        r120.put("token", r115);
        if (TextUtils.isEmpty(r116) == false) goto L41;
        r116 = "";
    L41:
        r120.put("content", r116);
        if (r119 == null) goto L45;
        r105 = r119;
    L45:
        r120.put("type", r105);
        r120.put("source", Integer.toString(r117));
        if (TextUtils.isEmpty(r118) == true) goto L48;
        r120.put("chat_id", r118);
    L48:
        r120.put("user_type", this.f219105d);
        if (this.f219104c.a().c().f217118a == true) goto L51;
        r120.put("config_source", Integer.toString(1));
    L51:
        NetService.f r121 = new NetService.f("/api/mention/recommend.v2/");
        this.f219102a = r121;
        r121.d(r120);
        Map<String, String> r122 = this.f219106e;
        if (r122 != null) goto L54;
    L56:
        this.f219102a.f216906c = 1;
        final String r123 = r110.getKeyword();
        return this.f219103b.a(this.f219102a).observeOn(fo5.d.d()).subscribe(new c(this, r111, r123, r112, r110), new d(r123, r112));
    L54:
        if (r122.isEmpty() == true) goto L56;
        this.f219102a.c(this.f219106e);
        goto L56
    L29:
        if (r117 == 29) goto L31;
    L33:
        r119 = r111;
        goto L35
    L31:
        if (TextUtils.isEmpty(r116) == false) goto L33;
    L5:
        r103 = 0;
        goto L6
    }

    public e(NetService r100, i0 r101, ww4.a r102, Context r103) {
        this.f219107f = new HashMap();
        this.f219103b = r100.Vc(new f(r103, r101));
        this.f219104c = r102;
        this.f219105d = "0";
    }
}
