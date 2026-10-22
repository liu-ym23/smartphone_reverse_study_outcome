package com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteMemberParams;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.EmailInfoResult;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.SearchUserResult;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.ss.android.lark.search.dto.Scene;
import com.ss.android.lark.search.dto.service.SearchContext;
import com.ss.android.lark.search.dto.service.Union;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class m implements com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f233564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dh5.b f233565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InviteMemberParams f233566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<UserInfo> f233567d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f233568e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f233569f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f233570g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f233571h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f233572i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public z3c.a f233573j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f233574k;

    public static final class a {
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<T, R> f233575a = null;

        static {
            f233575a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            EmailInfoResult r101 = (EmailInfoResult) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return (String) r101.data;
        }
    }

    public static final class c<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T, R> f233576a = null;

        static {
            f233576a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Throwable r101 = (Throwable) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            tt5.a.d("SearchUserResultModel", "getEmailInfo()...error = " + r101);
            return "";
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.a
    public final Flowable<SearchUserResult> a() {
        tt5.a.h("SearchUserResultModel", "loadMore()...");
        this.f233569f += 10;
        return k(true);
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        InviteMemberParams r100 = this.f233566c;
        this.f233570g = r100.f233171f ? 1 : 0;
        this.f233571h = r100.f233172g ? 1 : 0;
        AccountService$Account r101 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        if (r101 == null) goto L5;
        boolean r102 = r101.isConsumer();
    L6:
        this.f233572i = r102;
        this.f233573j = ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).getSearchLifecycleObserver();
        tt5.a.h("SearchUserResultModel", "isConsumer = " + this.f233572i);
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        tt5.a.h("SearchUserResultModel", "destroy()...");
        tt5.a.h("SearchUserResultModel", "cancelRequest()...");
        tt5.a.h("SearchUserResultModel", "cancelInitCountryCode()... isDisposed = null");
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.a
    public final ArrayList<UserInfo> e() {
        return this.f233565b.getSelected();
    }

    public final boolean o() {
        if (sbb.g.a(this.f233566c.getType()) == false) goto L5;
    L9:
        return false;
    L5:
        if (this.f233566c.getType() == 125) goto L9;
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.ai.collaborator_search_bot") == false) goto L9;
        return true;
    }

    public static final SearchContext h(m r100) {
        boolean r101 = r100.o();
        SearchContext r102 = new SearchContext();
        String r103 = r100.f233568e;
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r102.f440173b = r103;
        r102.a(Scene.Type.SEARCH_DOC_COLLABORATOR);
        boolean r104 = false;
        if (r100.f233570g != 1) goto L5;
        boolean r105 = true;
    L6:
        r102.f440182k = r105;
        r102.f440183l = true;
        r102.f440181j = true;
        r102.f440178g = true;
        r102.f440188q = r101;
        r102.f440189r = r101;
        Union r106 = Union.ALL;
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r102.f440186o = r106;
        r102.f440185n = false;
        if (r100.f233571h != 1) goto L9;
        r104 = true;
    L9:
        r102.f440191t = r104;
        return r102;
    L5:
        r105 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.a
    public final Flowable<SearchUserResult> R1(String r100) {
        Intrinsics.checkNotNullParameter(r100, "keyword");
        this.f233569f = 0;
        this.f233568e = r100;
        return k(false);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.a
    public final Flowable<String> Z5(String r100) {
        Intrinsics.checkNotNullParameter(r100, "email");
        if (TextUtils.isEmpty(r100) == true) goto L5;
        NetService.f r101 = new NetService.f("/space/api/user/email_info/generate/");
        JSONObject r102 = new JSONObject();
        r102.put("obj_type", this.f233566c.getType());
        r102.put("token", this.f233566c.f233166a);
        JSONArray r103 = new JSONArray();
        r103.put(r100);
        r102.put("emails", r103);
        r101.f216906c = 1;
        r101.f216913j = r102.toString();
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new bh5.a(r100)).a(r101).map(b.f233575a).onErrorReturn(c.f233576a);
    L5:
        return Flowable.just("");
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.a
    public final void i(UserInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "userInfo");
        this.f233565b.removeUser(r100);
    }

    public final Flowable<SearchUserResult> k(final boolean r100) {
        tt5.a.h("SearchUserResultModel", "doSearch()...");
        tt5.a.h("SearchUserResultModel", "cancelRequest()...");
        tt5.a.h("SearchUserResultModel", "doSearchByWord()....isUseNewSearchApi = true");
        if (TextUtils.isEmpty(this.f233568e) == false) goto L5;
        Flowable r101 = Flowable.create(new SearchUserResultModel$doFeedPull$1(this), BackpressureStrategy.BUFFER);
    L7:
        return r101.observeOn(fo5.d.d()).map(new n(this)).flatMap(new o(this)).map(new p(this));
    L5:
        r101 = Flowable.create(new SearchUserResultModel$doUniversalSearch$1(this, r100), BackpressureStrategy.BUFFER);
        goto L7
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.a
    public final void l(UserInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "userInfo");
        this.f233565b.addUser(r100);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.a
    public final void registerChangeListener(dh5.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f233565b.registerChangeListener(r100);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.a
    public final void unregisterChangeListener(dh5.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f233565b.unregisterChangeListener(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(Context r100, dh5.b r101, InviteMemberParams r102, List<? extends UserInfo> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "selectedUserModel");
        Intrinsics.checkNotNullParameter(r102, "params");
        this.f233564a = r100;
        this.f233565b = r101;
        this.f233566c = r102;
        this.f233567d = r103;
        this.f233568e = "";
        this.f233574k = "";
    }
}
