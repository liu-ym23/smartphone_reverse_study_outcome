package com.ss.android.lark.integrator.ccm.dependency.di;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.officesdk.api.IUserManager;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.lark.officesdk.internal.OfficeSDKProvider;
import com.ss.android.lark.search.dto.SearchResponse;
import com.ss.android.lark.search.dto.service.SearchContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class u0 implements z3c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z3c.a f427867a;

    public static final class a {
    }

    static {
    }

    public u0() {
    }

    public final z3c.a b() {
        z3c.a r100 = this.f427867a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        IUserManager r101 = OfficeSDKProvider.INSTANCE.getInstance().getUserManager();
        if (r101 == null) goto L14;
        OfficeSDKUserApi r102 = r101.getUserApi();
        if (r102 == null) goto L14;
        p3c.a r103 = (p3c.a) r102.getService(p3c.a.class);
        if (r103 == null) goto L14;
        com.ss.android.lark.search.doubao.a r104 = r103.O2();
        if (r104 == null) goto L14;
        this.f427867a = r104;
        return r104;
    L14:
        return null;
    }

    public static ErrorResult a(String r100, String r101) {
        tt5.a.d("OfficeDocCollaboratorSearch", r100 + " failed, IOfficeDocCollaboratorSearchAPI unavailable, requestId=" + r101);
        return new ErrorResult("IOfficeDocCollaboratorSearchAPI unavailable");
    }

    @Override // z3c.a
    public final void onLoadMore(String r100, SearchContext r101) {
        Intrinsics.checkNotNullParameter(r100, "requestId");
        z3c.a r102 = b();
        if (r102 != null) goto L6;
        tt5.a.d("OfficeDocCollaboratorSearch", "onLoadMore ignored, IOfficeDocCollaboratorSearchAPI unavailable, requestId=" + r100);
        return;
    L6:
        r102.onLoadMore(r100, null);
    }

    @Override // z3c.a
    public final void onLoadMore(String r100, SearchContext r101, IGetDataCallback<SearchResponse> r102) {
        Intrinsics.checkNotNullParameter(r100, "requestId");
        Intrinsics.checkNotNullParameter(r102, "callback");
        z3c.a r103 = b();
        if (r103 == null) goto L5;
        r103.onLoadMore(r100, r101, r102);
        return;
    L5:
        r102.onError(a("onLoadMore", r100));
    }

    @Override // z3c.a
    public final void onSearch(String r100, SearchContext r101, IGetDataCallback<SearchResponse> r102) {
        Intrinsics.checkNotNullParameter(r100, "requestId");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "callback");
        z3c.a r103 = b();
        if (r103 == null) goto L5;
        r103.onSearch(r100, r101, r102);
        return;
    L5:
        r102.onError(a("onSearch", r100));
    }
}
