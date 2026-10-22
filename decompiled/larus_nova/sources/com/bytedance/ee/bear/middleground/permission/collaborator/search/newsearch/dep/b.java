package com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.dep;

import android.content.Context;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b extends BasePresenter<eh5.a, com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.dep.a, com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.dep.a.InterfaceC3344a> implements dh5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f233484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f233485b;

    public interface a {
        void v1();
    }

    @Override // com.larksuite.framework.mvp.BasePresenter
    public final IView.IViewDelegate createViewDelegate() {
        return new c(this);
    }

    public final void H8() {
        int r100 = getModel().e().size();
        com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.dep.a r101 = getView();
        if (r100 <= 0) goto L5;
        boolean r102 = true;
    L6:
        r101.t(r102);
        String r103 = xo5.a.c(this.f233485b, R.string.Doc_Permission_AddUserSelectedTips, "count", String.valueOf(r100));
        com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.dep.a r104 = getView();
        Intrinsics.checkNotNull(r103);
        r104.A(r103);
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        super.create();
        getModel().registerChangeListener(this);
        H8();
    }

    @Override // com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        super.destroy();
        getModel().unregisterChangeListener(this);
    }

    @Override // dh5.c
    public final void W1(UserInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "userInfo");
        H8();
        if (getModel().e().size() != 0) goto L6;
        getView().B();
        return;
    }

    @Override // dh5.c
    public final void g8(UserInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "userInfo");
        H8();
        if (getModel().e().size() != 1) goto L6;
        getView().v();
        return;
    }

    public b(eh5.b r100, d r101, a r102, Context r103) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "dependency");
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f233484a = r102;
        this.f233485b = r103;
    }
}
