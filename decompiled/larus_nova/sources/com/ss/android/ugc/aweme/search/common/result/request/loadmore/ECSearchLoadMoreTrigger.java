package com.ss.android.ugc.aweme.search.common.result.request.loadmore;

import com.ss.android.ugc.aweme.search.common.ILoadMoreFunction;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import com.ss.android.ugc.aweme.search.common.list.ESSaasCommonListAdapter;
import com.ss.android.ugc.aweme.search.common.list.base.RecyclerHeaderViewAdapter;
import com.ss.android.ugc.aweme.search.common.saas.result.aichat.AIRefreshController;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/result/request/loadmore/ECSearchLoadMoreTrigger;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchLoadMoreTrigger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f451878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f451879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f451880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ILoadMoreFunction f451881d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RecyclerHeaderViewAdapter<?> f451882e;

    public ECSearchLoadMoreTrigger(ILoadMoreFunction r100, ESSaasCommonListAdapter r101) {
        this.f451881d = r100;
        this.f451882e = r101;
        this.f451879b = 1;
        this.f451880c = Integer.MIN_VALUE;
        this.f451878a = 2;
    }

    public final void a(int r100, int r101) {
        if (r100 <= this.f451880c) goto L41;
        this.f451880c = r100;
        AIRefreshController.f452149f.getClass();
        if (AIRefreshController.f452145b == true) goto L39;
        RecyclerHeaderViewAdapter<?> r102 = this.f451882e;
        boolean r103 = true;
        boolean r104 = false;
        if (r102 != null) goto L9;
    L15:
        boolean r105 = false;
    L17:
        if (r105 == true) goto L20;
        Logger.b("LoadMoreDebug", "shouldLoadMore return, isAdapterCanLoadMore");
    L35:
        if (r104 == false) goto L42;
        Logger.a("LoadMoreDebug", "trigger load more by onBindViewHolder position = " + r100 + ", count = " + r101);
        ILoadMoreFunction r106 = this.f451881d;
        if (r106 == null) goto L43;
        r106.a();
        return;
    L43:
        return;
    L42:
        return;
    L20:
        if (this.f451878a > 0) goto L22;
        Logger.b("LoadMoreDebug", "shouldLoadMore return, ifRemainsReal(" + this.f451878a + ") <= 0");
        goto L35
    L22:
        RecyclerHeaderViewAdapter<?> r107 = this.f451882e;
        if (r107 != null) goto L25;
    L27:
        boolean r108 = false;
    L28:
        if (r108 == false) goto L30;
        Logger.b("LoadMoreDebug", "shouldLoadMore return, isLoading");
        goto L35
    L30:
        int r109 = (r101 - r100) - 1;
        Logger.a("LoadMoreDebug", "shouldLoadMore count = " + r101 + " , remain = " + r109 + ", ifRemainsReal = " + this.f451878a);
        if (r109 <= this.f451878a) goto L34;
        r103 = false;
    L34:
        r104 = r103;
        goto L35
    L25:
        if (r107.f451671b != 0) goto L27;
        r108 = true;
        goto L28
    L9:
        if (r102.f451687a != true) goto L15;
        int r110 = r102.f451671b;
        if (r110 != (-1)) goto L13;
    L14:
        r105 = true;
        goto L17
    L13:
        if (Integer.valueOf(r110).intValue() != 0) goto L15;
    L39:
        Logger.a("AIChatDebug", "isInStreamMode, forbid auto load more");
        return;
    }
}
