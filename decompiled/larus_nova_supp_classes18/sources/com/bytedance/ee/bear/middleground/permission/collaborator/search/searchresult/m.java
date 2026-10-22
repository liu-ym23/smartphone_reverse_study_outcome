package com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteMemberParams;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.EmailInfoResult;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.SearchUserResult;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.search.dto.Scene;
import com.ss.android.lark.search.dto.service.SearchContext;
import com.ss.android.lark.search.dto.service.Union;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m implements com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.a {
    public final Context a;
    public final dh5.b b;
    public final InviteMemberParams c;
    public final List<UserInfo> d;
    public String e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public z3c.a j;
    public String k;

    public static final class a {
    }

    public static final class b<T, R> implements Function {
        public static final b<T, R> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r2) {
            EmailInfoResult r3 = (EmailInfoResult) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return (String) ((Result) r3).data;
        }
    }

    public static final class c<T, R> implements Function {
        public static final c<T, R> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Object apply(Object r3) {
            Throwable r4 = (Throwable) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            tt5.a.d("SearchUserResultModel", "getEmailInfo()...error = " + r4);
            return "";
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.a
    public final Flowable<SearchUserResult> a() {
        tt5.a.h("SearchUserResultModel", "loadMore()...");
        this.f += 10;
        return k(true);
    }

    public final void create() {
        InviteMemberParams r0 = this.c;
        this.g = r0.f ? 1 : 0;
        this.h = r0.g ? 1 : 0;
        AccountService.Account r1 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        if (r1 == null) goto L5;
        boolean r2 = r1.isConsumer();
    L6:
        this.i = r2;
        this.j = ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).getSearchLifecycleObserver();
        tt5.a.h("SearchUserResultModel", "isConsumer = " + this.i);
        return;
    L5:
        r2 = false;
        goto L6
    }

    public final void destroy() {
        tt5.a.h("SearchUserResultModel", "destroy()...");
        tt5.a.h("SearchUserResultModel", "cancelRequest()...");
        tt5.a.h("SearchUserResultModel", "cancelInitCountryCode()... isDisposed = null");
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.a
    public final ArrayList<UserInfo> e() {
        return this.b.getSelected();
    }

    public final boolean o() {
        if (sbb.g.a(this.c.getType()) == false) goto L5;
    L9:
        return false;
    L5:
        if (this.c.getType() == 125) goto L9;
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.ai.collaborator_search_bot") == false) goto L9;
        return true;
    }

    public static final SearchContext h(m r6) {
        boolean r0 = r6.o();
        SearchContext r1 = new SearchContext();
        String r2 = r6.e;
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r1.b = r2;
        r1.a(Scene.Type.SEARCH_DOC_COLLABORATOR);
        boolean r4 = false;
        if (r6.g != 1) goto L5;
        boolean r3 = true;
    L6:
        r1.k = r3;
        r1.l = true;
        r1.j = true;
        r1.g = true;
        r1.q = r0;
        r1.r = r0;
        Union r5 = Union.ALL;
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r1.o = r5;
        r1.n = false;
        if (r6.h != 1) goto L9;
        r4 = true;
    L9:
        r1.t = r4;
        return r1;
    L5:
        r3 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.a
    public final Flowable<SearchUserResult> R1(String r2) {
        Intrinsics.checkNotNullParameter(r2, "keyword");
        this.f = 0;
        this.e = r2;
        return k(false);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.a
    public final Flowable<String> Z5(String r5) {
        Intrinsics.checkNotNullParameter(r5, "email");
        if (TextUtils.isEmpty(r5) == true) goto L5;
        NetService.f r0 = new NetService.f("/space/api/user/email_info/generate/");
        JSONObject r1 = new JSONObject();
        r1.put("obj_type", this.c.getType());
        r1.put(ResourceData.KEY_TOKEN, this.c.a);
        JSONArray r2 = new JSONArray();
        r2.put(r5);
        r1.put("emails", r2);
        ((NetService.e) r0).c = 1;
        ((NetService.e) r0).j = r1.toString();
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new bh5.a(r5)).a(r0).map(b.a).onErrorReturn(c.a);
    L5:
        return Flowable.just("");
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.a
    public final void i(UserInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "userInfo");
        this.b.removeUser(r2);
    }

    public final Flowable<SearchUserResult> k(final boolean r3) {
        tt5.a.h("SearchUserResultModel", "doSearch()...");
        tt5.a.h("SearchUserResultModel", "cancelRequest()...");
        tt5.a.h("SearchUserResultModel", "doSearchByWord()....isUseNewSearchApi = true");
        if (TextUtils.isEmpty(this.e) == false) goto L5;
        Flowable r4 = Flowable.create(new SearchUserResultModel$doFeedPull$1(this), BackpressureStrategy.BUFFER);
    L7:
        return r4.observeOn(fo5.d.d()).map(new n(this)).flatMap(new o(this)).map(new p(this));
    L5:
        r4 = Flowable.create(new SearchUserResultModel$doUniversalSearch$1(this, r3), BackpressureStrategy.BUFFER);
        goto L7
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.a
    public final void l(UserInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "userInfo");
        this.b.addUser(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.a
    public final void registerChangeListener(dh5.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.b.registerChangeListener(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.a
    public final void unregisterChangeListener(dh5.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.b.unregisterChangeListener(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(Context r2, dh5.b r3, InviteMemberParams r4, List<? extends UserInfo> r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "selectedUserModel");
        Intrinsics.checkNotNullParameter(r4, "params");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = "";
        this.k = "";
    }
}
