package com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup;

import android.content.Context;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends BasePresenter<hh5.b, com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.a, com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.a.InterfaceC0104a> implements dh5.c {
    public final a a;
    public final Context b;

    public interface a {
        void v1();
    }

    public final IView.IViewDelegate createViewDelegate() {
        return new d(this);
    }

    public final void H8() {
        int r0 = ((hh5.b) getModel()).e().size();
        com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.a r1 = (com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.a) getView();
        if (r0 <= 0) goto L5;
        boolean r2 = true;
    L6:
        r1.t(r2);
        String r3 = xo5.a.c(this.b, 2131888045, "count", String.valueOf(r0));
        com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.a r4 = (com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.a) getView();
        Intrinsics.checkNotNull(r3);
        r4.A(r3);
        return;
    L5:
        r2 = false;
        goto L6
    }

    public final void create() {
        super.create();
        ((hh5.b) getModel()).registerChangeListener(this);
        H8();
    }

    public final void destroy() {
        super.destroy();
        ((hh5.b) getModel()).unregisterChangeListener(this);
    }

    @Override // dh5.c
    public final void W1(UserInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "userInfo");
        H8();
        if (((hh5.b) getModel()).e().size() != 0) goto L6;
        ((com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.a) getView()).B();
        return;
    }

    @Override // dh5.c
    public final void g8(UserInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "userInfo");
        H8();
        if (((hh5.b) getModel()).e().size() != 1) goto L6;
        ((com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.a) getView()).v();
        return;
    }

    public c(hh5.d r2, e r3, a r4, Context r5) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "dependency");
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r2, r3);
        this.a = r4;
        this.b = r5;
    }
}
