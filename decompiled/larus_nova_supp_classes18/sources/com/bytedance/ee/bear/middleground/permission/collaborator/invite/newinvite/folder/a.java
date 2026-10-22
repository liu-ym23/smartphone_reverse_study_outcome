package com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.folder;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.FolderPermSetInfo;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import tg5.o;
import tg5.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends BasePresenter<o, p, p.a> {
    public final FragmentActivity a;
    public final o b;
    public final p c;
    public final b d;
    public final FolderPermSetInfo e;
    public final String f;
    public final boolean g;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.folder.a$a, reason: collision with other inner class name */
    public static final class C0093a {
    }

    public interface b {
        void back();

        void finish();
    }

    public final class c implements p.a {
        public final /* synthetic */ a a;

        @Override // tg5.p.a
        public final void W2() {
            a r0 = this.a;
            ArrayList<UserInfo> r1 = r0.b.e();
            if (r0.c.getNotes().length() <= 0) goto L5;
            boolean r2 = true;
        L6:
            com.bytedance.ee.bear.middleground.permission.c.T(r1, r2, r0.c.b8(), true);
            r0.c.showLoading();
            r0.b.c7(r0.c.b8(), r0.c.u6(), r0.c.getNotes(), new xg5.b(r0));
            return;
        L5:
            r2 = false;
            goto L6
        }

        @Override // tg5.p.a
        public final ArrayList<UserInfo> e() {
            return this.a.b.e();
        }

        @Override // tg5.p.a
        public final void onBack() {
            b r0 = this.a.d;
            if (r0 == null) goto L5;
            r0.back();
        L5:
            com.bytedance.ee.bear.middleground.permission.c.S();
        }

        @Override // tg5.p.a
        public final boolean r0() {
            return this.a.b.r0();
        }

        public c(a r1) {
            this.a = r1;
        }

        @Override // tg5.p.a
        public final void D0(String r2) {
            Intrinsics.checkNotNullParameter(r2, "notificationId");
            this.a.b.F1(r2);
        }

        @Override // tg5.p.a
        public final void N(boolean r2) {
            this.a.b.N(r2);
        }

        @Override // tg5.p.a
        public final void W(UserInfo r2) {
            Intrinsics.checkNotNullParameter(r2, "userInfo");
            this.a.b.m7(r2);
            this.a.c.A8();
            if (this.a.b.e().size() != 0) goto L8;
            b r3 = this.a.d;
            if (r3 == null) goto L9;
            r3.back();
            return;
        L9:
            return;
        }
    }

    static {
    }

    public final IView.IViewDelegate createViewDelegate() {
        return new c(this);
    }

    public final void create() {
        super.create();
        this.c.F(this.b.e());
        this.c.A8();
        com.bytedance.ee.bear.middleground.permission.c.U(this.b.e());
    }

    public a(FragmentActivity r2, xg5.a r3, xg5.c r4, b r5, FolderPermSetInfo r6, String r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "model");
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r6, "permSetInfo");
        Intrinsics.checkNotNullParameter(r7, "module");
        super(r3, r4);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
