package com.bytedance.ee.bear.middleground.comment.extension.addins;

import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.sharepermissiondialog.BottomPopupData;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBottomPopupData;
import com.bytedance.ee.bear.middleground.comment.share.SharePermissionViewModel;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l0 extends com.bytedance.ee.bear.middleground.comment.extension.addins.b {
    public uv4.c b;
    public SharePermissionViewModel c;

    public static final class a {
    }

    public final class b extends ff5.a<ef5.h0> {
        public final /* synthetic */ l0 a;

        public b(l0 r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r14) {
            ef5.h0 r15 = (ef5.h0) r14;
            Intrinsics.checkNotNullParameter(r15, "event");
            if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mention.optimizing_authorizaiton") == true) goto L17;
            l0 r3 = this.a;
            m0 r0 = new m0(r3, this, r15);
            if (r3.b != null) goto L11;
            r3.b = new uv4.c(this.a.b().a().getConfig().getActivity());
            zo5.b r4 = (zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6);
            uv4.c r5 = this.a.b;
            if (r5 == null) goto L9;
            View r6 = r5.f;
            Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.widget.FrameLayout");
            FrameLayout r7 = (FrameLayout) r6;
        L10:
            r4.p(r7);
            goto L11
        L9:
            r7 = null;
        L11:
            uv4.c r8 = this.a.b;
            if (r8 == null) goto L14;
            Intrinsics.checkNotNullParameter(r0, "clickCallback");
            r8.k = r0;
        L14:
            uv4.c r1 = this.a.b;
            if (r1 == null) goto L27;
            BottomPopupData r9 = new BottomPopupData();
            r9.setConfirmBtnText(r15.a.getConfirmBtnText());
            r9.setTitle(r15.a.getTitle());
            r9.setSendLarkText(r15.a.getSendLarkText());
            r9.setDes(r15.a.getDes());
            r1.d(r9);
        L27:
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).j0();
            jg5.k.a.a.c();
            return;
        L17:
            r15.b.c();
            com.bytedance.ee.bear.middleground.comment.uitls.p r2 = this.a.b().a().getConfig();
            CommentBottomPopupData r10 = r15.a;
            o0 r12 = new o0(this.a, r10, this, r15);
            if (ForsetiHelper.s(r2.b) == false) goto L23;
            com.bytedance.ee.bear.lark.dependency.c0 r16 = (com.bytedance.ee.bear.lark.dependency.c0) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.c0.class, null, null, 6);
            Fragment r11 = r2.b;
            UserSession r13 = PassportcConvention.a(LarkContext.getApplication());
            String r17 = r10.getUserId();
            if (r17 != null) goto L22;
            r17 = "";
        L22:
            r16.D1(r11, r13, r17, r10.getTitle(), r2.getActivity().getString(2131889121), r2.getActivity().getString(2131889561), r12);
            goto L27
        L23:
            com.bytedance.ee.bear.lark.dependency.c0 r18 = (com.bytedance.ee.bear.lark.dependency.c0) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.c0.class, null, null, 6);
            FragmentActivity r19 = r2.getActivity();
            FragmentManager r20 = r2.g;
            UserSession r21 = PassportcConvention.a(LarkContext.getApplication());
            String r110 = r10.getUserId();
            if (r110 != null) goto L26;
            r110 = "";
        L26:
            r18.Wb(r19, r20, r21, r110, r10.getTitle(), r2.getActivity().getString(2131889121), r2.getActivity().getString(2131889561), r12);
            goto L27
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.extension.addins.b, gf5.b
    public final void onDestroy() {
        SharePermissionViewModel r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("sharePermissionViewModel");
        r0 = null;
    L5:
        r0.d();
    }

    public l0() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.extension.addins.b, gf5.b
    public final void a(cf5.a r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        Intrinsics.checkNotNullParameter(r3, "host");
        this.a = r3;
        r3.b(ef5.h0.class, new b(this));
        this.c = new SharePermissionViewModel(b().a().getConfig());
    }
}
