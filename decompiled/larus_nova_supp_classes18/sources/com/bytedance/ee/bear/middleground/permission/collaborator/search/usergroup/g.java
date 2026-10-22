package com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup;

import android.content.Context;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import hh5.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g extends BasePresenter<hh5.c, com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.b, com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.b.a> implements dh5.c {
    public final hh5.c a;
    public final com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.b b;
    public final Context c;

    public final class a implements com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.b.a {
        public final /* synthetic */ g a;

        public a(g r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.b.a
        public final void S1(UserGroup r2) {
            Intrinsics.checkNotNullParameter(r2, "userGroup");
            hh5.c r0 = this.a.a;
            r0.l(r0.t2(r2));
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.b.a
        public final void z8(UserGroup r2) {
            Intrinsics.checkNotNullParameter(r2, "userGroup");
            hh5.c r0 = this.a.a;
            r0.i(r0.t2(r2));
        }
    }

    public interface b {
    }

    public final IView.IViewDelegate createViewDelegate() {
        return new a(this);
    }

    public final void create() {
        super.create();
        this.b.n3(this.a.m0(), this.a.I5());
        this.a.registerChangeListener(this);
        this.b.showLoading();
        this.a.o5(new k(this));
    }

    public final void destroy() {
        super.destroy();
        this.a.unregisterChangeListener(this);
    }

    @Override // dh5.c
    public final void W1(UserInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "userInfo");
        if (r3.getOwnerType() != 22) goto L5;
    L6:
        this.b.E0(this.a.A0(r3));
        return;
    L5:
        if (r3.getOwnerType() == 30) goto L6;
    }

    @Override // dh5.c
    public final void g8(UserInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "userInfo");
        if (r3.getOwnerType() != 22) goto L5;
    L6:
        this.b.a1(this.a.A0(r3));
        return;
    L5:
        if (r3.getOwnerType() == 30) goto L6;
    }

    public g(hh5.e r2, UserGroupView r3, b r4, Context r5) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "dependency");
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r2, r3);
        this.a = r2;
        this.b = r3;
        this.c = r5;
    }
}
