package com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.GetUserGroupResult;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends BasePresenter<fh5.a, com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a, com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a.InterfaceC0098a> implements dh5.c {
    public final InterfaceC0099b a;
    public final FragmentActivity b;
    public final boolean c;
    public final Boolean d;
    public final CompositeDisposable e;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.b$b, reason: collision with other inner class name */
    public interface InterfaceC0099b {
        void Az();

        void bk();

        void v1();
    }

    public final class c implements com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a.InterfaceC0098a {
        public final /* synthetic */ b a;

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a.InterfaceC0098a
        public final void g4() {
            this.a.a.bk();
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a.InterfaceC0098a
        public final void j2() {
            this.a.a.Az();
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a.InterfaceC0098a
        public final void s() {
            this.a.a.v1();
        }

        public c(b r1) {
            this.a = r1;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ b a;

        public d(b r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            tt5.a.h("NewSearchUserPresenter", "getUserGroups()...success");
            if (hu5.a.f(((GetUserGroupResult) r3).getVisibleGroups()) == false) goto L6;
            ((com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a) this.a.getView()).f2();
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public static final e<T> a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r3) {
            tt5.a.d("NewSearchUserPresenter", "getUserGroups()...error = " + ((Throwable) r3));
        }
    }

    static {
    }

    public final IView.IViewDelegate createViewDelegate() {
        return new c(this);
    }

    public final void H8() {
        int r0 = ((fh5.a) getModel()).e().size();
        com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a r1 = (com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a) getView();
        if (r0 <= 0) goto L5;
        boolean r2 = true;
    L6:
        r1.t(r2);
        String r3 = xo5.a.c(this.b, 2131888045, "count", String.valueOf(r0));
        com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a r4 = (com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a) getView();
        Intrinsics.checkNotNull(r3);
        r4.A(r3);
        return;
    L5:
        r2 = false;
        goto L6
    }

    public final void create() {
        super.create();
        ((fh5.a) getModel()).registerChangeListener(this);
        tt5.a.h("NewSearchUserPresenter", "inviteUserGroupEnable = " + this.c);
        if (this.c == true) goto L5;
    L7:
        H8();
        return;
    L5:
        if (Intrinsics.areEqual(this.d, Boolean.TRUE) == true) goto L7;
        this.e.add(((fh5.a) getModel()).g7().subscribe(new d(this), e.a));
        goto L7
    }

    public final void destroy() {
        super.destroy();
        if (this.e.isDisposed() == true) goto L6;
        this.e.clear();
        return;
    }

    @Override // dh5.c
    public final void W1(UserInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "userInfo");
        H8();
        if (((fh5.a) getModel()).e().size() != 0) goto L6;
        ((com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a) getView()).B();
        return;
    }

    @Override // dh5.c
    public final void g8(UserInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "userInfo");
        H8();
        if (((fh5.a) getModel()).e().size() != 1) goto L6;
        ((com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a) getView()).v();
        return;
    }

    public b(fh5.b r2, com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.c r3, InterfaceC0099b r4, FragmentActivity r5, boolean r6, Boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "dependency");
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r2, r3);
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = new CompositeDisposable();
    }
}
