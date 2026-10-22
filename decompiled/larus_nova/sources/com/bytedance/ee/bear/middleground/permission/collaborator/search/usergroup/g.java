package com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup;

import android.content.Context;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import hh5.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g extends BasePresenter<hh5.c, com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.b, com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.b.a> implements dh5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hh5.c f233672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.b f233673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f233674c;

    public final class a implements com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f233675a;

        public a(g r100) {
            this.f233675a = r100;
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.b.a
        public final void S1(UserGroup r100) {
            Intrinsics.checkNotNullParameter(r100, "userGroup");
            hh5.c r101 = this.f233675a.f233672a;
            r101.l(r101.t2(r100));
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.b.a
        public final void z8(UserGroup r100) {
            Intrinsics.checkNotNullParameter(r100, "userGroup");
            hh5.c r101 = this.f233675a.f233672a;
            r101.i(r101.t2(r100));
        }
    }

    public interface b {
    }

    @Override // com.larksuite.framework.mvp.BasePresenter
    public final IView.IViewDelegate createViewDelegate() {
        return new a(this);
    }

    @Override // com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        super.create();
        this.f233673b.n3(this.f233672a.m0(), this.f233672a.I5());
        this.f233672a.registerChangeListener(this);
        this.f233673b.showLoading();
        this.f233672a.o5(new k(this));
    }

    @Override // com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        super.destroy();
        this.f233672a.unregisterChangeListener(this);
    }

    @Override // dh5.c
    public final void W1(UserInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "userInfo");
        if (r100.getOwnerType() != 22) goto L5;
    L6:
        this.f233673b.E0(this.f233672a.A0(r100));
        return;
    L5:
        if (r100.getOwnerType() == 30) goto L6;
    }

    @Override // dh5.c
    public final void g8(UserInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "userInfo");
        if (r100.getOwnerType() != 22) goto L5;
    L6:
        this.f233673b.a1(this.f233672a.A0(r100));
        return;
    L5:
        if (r100.getOwnerType() == 30) goto L6;
    }

    public g(hh5.e r100, UserGroupView r101, b r102, Context r103) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "dependency");
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f233672a = r100;
        this.f233673b = r101;
        this.f233674c = r103;
    }
}
