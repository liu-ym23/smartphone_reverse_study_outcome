package com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.PermissionAnalytic;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteMemberParams;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import io.reactivex.disposables.Disposable;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s extends BasePresenter<com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.a, com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.b, com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.b.a> implements dh5.c {
    public final Fragment a;
    public final InviteMemberParams b;
    public Disposable c;

    public static final class a {
    }

    public final class b implements com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.b.a {
        public final /* synthetic */ s a;

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.b.a
        public final void onLoadMore() {
            s r0 = this.a;
            r0.getClass();
            tt5.a.h("SearchUserResultPresenter", "loadMore()...");
            r0.I8();
            r0.c = ((com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.a) r0.getModel()).a().subscribe(new t(r0), new u(r0));
        }

        public b(s r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.b.a
        public final void F8(UserInfo r3) {
            Intrinsics.checkNotNullParameter(r3, "userInfo");
            ((com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.a) this.a.getModel()).l(r3);
            InviteMemberParams r0 = this.a.b;
            PermissionAnalytic.k(r0.a, r0.getType(), r3);
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.b.a
        public final void P(UserInfo r8) {
            Intrinsics.checkNotNullParameter(r8, "userInfo");
            Locale r1 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).c();
            Context r2 = this.a.a.getContext();
            if (r2 == null) goto L15;
            s r3 = this.a;
            Intrinsics.checkNotNull(r1);
            InviteMemberParams r4 = r3.b;
            String r5 = r4.a;
            String r6 = r4.e;
            int r7 = ui5.a.a;
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r8, "userInfo");
            Intrinsics.checkNotNullParameter(r1, "locale");
            int r0 = r8.getBlockStatus();
            if (r0 != 1) goto L7;
            Toast.showFailureText(r2, r2.getString(2131888737));
            String r9 = "blocked";
        L14:
            PermissionAnalytic.j(r9, r5, r6, "invited_collaborate");
            goto L15
        L7:
            if (r0 != 2) goto L9;
            Toast.showFailureText(r2, xo5.a.c(r2, 2131888078, "userName", r8.getDisplayName(r1)));
            r9 = "block";
            goto L14
        L9:
            if (r0 == 3) goto L11;
            r9 = "others";
            goto L14
        L11:
            Toast.showFailureText(r2, xo5.a.c(r2, 2131888127, "userName", r8.getDisplayName(r1)));
            r9 = "privacy_setting";
        L15:
            InviteMemberParams r10 = this.a.b;
            PermissionAnalytic.k(r10.a, r10.getType(), r8);
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.b.a
        public final void w8(UserInfo r3) {
            Intrinsics.checkNotNullParameter(r3, "userInfo");
            ((com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.a) this.a.getModel()).i(r3);
            InviteMemberParams r0 = this.a.b;
            PermissionAnalytic.k(r0.a, r0.getType(), r3);
        }
    }

    static {
    }

    public final void I8() {
        Disposable r0 = this.c;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L12;
        Disposable r2 = this.c;
        if (r2 == null) goto L13;
        r2.dispose();
        return;
    L13:
        return;
    L12:
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        r1 = true;
        goto L7
    }

    public final IView.IViewDelegate createViewDelegate() {
        return new b(this);
    }

    public final void create() {
        super.create();
        tt5.a.h("SearchUserResultPresenter", "create()...");
        ((com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.a) getModel()).registerChangeListener(this);
        ((com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.b) getView()).v4(((com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.a) getModel()).e());
        ((com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.b) getView()).showLoading();
    }

    public final void destroy() {
        super.destroy();
        ((com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.a) getModel()).unregisterChangeListener(this);
        I8();
    }

    public static final /* synthetic */ com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.b H8(s r0) {
        return (com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.b) r0.getView();
    }

    @Override // dh5.c
    public final void W1(UserInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "userInfo");
        ((com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.b) getView()).i(r2);
    }

    @Override // dh5.c
    public final void g8(UserInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "userInfo");
        ((com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.b) getView()).l(r2);
    }

    public s(m r2, y r3, Fragment r4, InviteMemberParams r5) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Intrinsics.checkNotNullParameter(r5, "params");
        super(r2, r3);
        this.a = r4;
        this.b = r5;
    }
}
