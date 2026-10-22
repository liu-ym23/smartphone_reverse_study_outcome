package com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.PermissionAnalytic;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteMemberParams;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class s extends BasePresenter<com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.a, com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.b, com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.b.a> implements dh5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f233582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InviteMemberParams f233583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f233584c;

    public static final class a {
    }

    public final class b implements com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f233585a;

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.b.a
        public final void onLoadMore() {
            s r100 = this.f233585a;
            r100.getClass();
            tt5.a.h("SearchUserResultPresenter", "loadMore()...");
            r100.I8();
            r100.f233584c = r100.getModel().a().subscribe(new t(r100), new u(r100));
        }

        public b(s r100) {
            this.f233585a = r100;
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.b.a
        public final void F8(UserInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "userInfo");
            this.f233585a.getModel().l(r100);
            InviteMemberParams r101 = this.f233585a.f233583b;
            PermissionAnalytic.k(r101.f233166a, r101.getType(), r100);
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.b.a
        public final void P(UserInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "userInfo");
            Locale r101 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).c();
            Context r102 = this.f233585a.f233582a.getContext();
            if (r102 == null) goto L15;
            s r103 = this.f233585a;
            Intrinsics.checkNotNull(r101);
            InviteMemberParams r104 = r103.f233583b;
            String r105 = r104.f233166a;
            String r106 = r104.f233170e;
            int r107 = ui5.a.f550206a;
            Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r100, "userInfo");
            Intrinsics.checkNotNullParameter(r101, "locale");
            int r108 = r100.getBlockStatus();
            if (r108 != 1) goto L7;
            Toast.showFailureText(r102, r102.getString(R.string.LarkCCM_BlockSettings_UnableToInvite_Toast));
            String r109 = "blocked";
        L14:
            PermissionAnalytic.j(r109, r105, r106, "invited_collaborate");
            goto L15
        L7:
            if (r108 != 2) goto L9;
            Toast.showFailureText(r102, xo5.a.c(r102, R.string.Doc_Permission_BlockUnableInviteCollaboratorToast, "userName", r100.getDisplayName(r101)));
            r109 = "block";
            goto L14
        L9:
            if (r108 == 3) goto L11;
            r109 = "others";
            goto L14
        L11:
            Toast.showFailureText(r102, xo5.a.c(r102, R.string.Doc_Permission_SettingInviteCollaboratorShareToast, "userName", r100.getDisplayName(r101)));
            r109 = "privacy_setting";
        L15:
            InviteMemberParams r110 = this.f233585a.f233583b;
            PermissionAnalytic.k(r110.f233166a, r110.getType(), r100);
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.b.a
        public final void w8(UserInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "userInfo");
            this.f233585a.getModel().i(r100);
            InviteMemberParams r101 = this.f233585a.f233583b;
            PermissionAnalytic.k(r101.f233166a, r101.getType(), r100);
        }
    }

    static {
    }

    public final void I8() {
        Disposable r100 = this.f233584c;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == false) goto L12;
        Disposable r102 = this.f233584c;
        if (r102 == null) goto L13;
        r102.dispose();
        return;
    L13:
        return;
    L12:
        return;
    L5:
        if (r100.isDisposed() == true) goto L7;
        r101 = true;
        goto L7
    }

    @Override // com.larksuite.framework.mvp.BasePresenter
    public final IView.IViewDelegate createViewDelegate() {
        return new b(this);
    }

    @Override // com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        super.create();
        tt5.a.h("SearchUserResultPresenter", "create()...");
        getModel().registerChangeListener(this);
        getView().v4(getModel().e());
        getView().showLoading();
    }

    @Override // com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        super.destroy();
        getModel().unregisterChangeListener(this);
        I8();
    }

    public static final /* synthetic */ com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.b H8(s r100) {
        return r100.getView();
    }

    @Override // dh5.c
    public final void W1(UserInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "userInfo");
        getView().i(r100);
    }

    @Override // dh5.c
    public final void g8(UserInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "userInfo");
        getView().l(r100);
    }

    public s(m r100, y r101, Fragment r102, InviteMemberParams r103) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r103, "params");
        super(r100, r101);
        this.f233582a = r102;
        this.f233583b = r103;
    }
}
