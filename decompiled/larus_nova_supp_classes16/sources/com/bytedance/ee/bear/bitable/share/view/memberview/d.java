package com.bytedance.ee.bear.bitable.share.view.memberview;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.share.BitableSharePermSetInfo;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.widgets.t;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d extends ih5.a<com.bytedance.ee.bear.bitable.share.view.memberview.b> implements mu4.d {
    public final FragmentActivity h;
    public final Fragment i;
    public final int j;
    public TextView k;
    public TextView l;
    public LinearLayout m;
    public LinearLayout n;
    public TextView o;
    public LinearLayout p;
    public TextView q;
    public Function0<Unit> r;
    public boolean s;

    public static final class a extends t {
        public final /* synthetic */ d c;

        public a(d r1) {
            this.c = r1;
        }

        public final void a(View r2) {
            FragmentActivity r3 = this.c.h;
            Toast.showFailureText(r3, r3.getString(2131888342));
        }
    }

    public static final class b extends t {
        public final /* synthetic */ d c;

        public b(d r1) {
            this.c = r1;
        }

        public final void a(View r2) {
            FragmentActivity r3 = this.c.h;
            Toast.showFailureText(r3, r3.getString(2131888342));
        }
    }

    public static final class c extends t {
        public final /* synthetic */ d c;

        public c(d r1) {
            this.c = r1;
        }

        public final void a(View r1) {
            d.f(this.c).b();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.share.view.memberview.d$d, reason: collision with other inner class name */
    public static final class C0022d extends t {
        public final /* synthetic */ d c;

        public C0022d(d r1) {
            this.c = r1;
        }

        public final void a(View r5) {
            int r6 = ou4.d.a;
            d r7 = this.c;
            FragmentActivity r0 = r7.h;
            Fragment r1 = r7.i;
            BitableSharePermSetInfo r8 = ((com.bytedance.ee.bear.bitable.share.view.memberview.b) r7.getPresenter()).e();
            ShareUserInfoResult r2 = d.f(this.c).g;
            if (r2 != null) goto L5;
            r2 = new ShareUserInfoResult();
        L5:
            ou4.d.a(r0, r1, r8, r2, d.f(this.c).d());
        }
    }

    public static final class e implements ih5.c.a {
        public final /* synthetic */ d a;

        public e(d r1) {
            this.a = r1;
        }

        public final void a(UserInfo r5) {
            Intrinsics.checkNotNullParameter(r5, "userInfo");
            int r6 = ou4.d.a;
            d r7 = this.a;
            FragmentActivity r0 = r7.h;
            Fragment r1 = r7.i;
            BitableSharePermSetInfo r8 = ((com.bytedance.ee.bear.bitable.share.view.memberview.b) r7.getPresenter()).e();
            ShareUserInfoResult r2 = d.f(this.a).g;
            if (r2 != null) goto L5;
            r2 = new ShareUserInfoResult();
        L5:
            ou4.d.a(r0, r1, r8, r2, d.f(this.a).d());
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ d a;

        public f(d r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            Function0<Unit> r2 = this.a.r;
            if (r2 == null) goto L6;
            r2.invoke();
            return;
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ d a;

        public g(d r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            Function0<Unit> r2 = this.a.r;
            if (r2 == null) goto L6;
            r2.invoke();
            return;
        }
    }

    public static final class h implements ih5.c.a {
        public final /* synthetic */ d a;

        public h(d r1) {
            this.a = r1;
        }

        public final void a(UserInfo r2) {
            Intrinsics.checkNotNullParameter(r2, "userInfo");
            Toast.showText(this.a.h, 2131886525);
        }
    }

    @Override // mu4.d
    public final void s() {
        if (this.s == false) goto L5;
        return;
    L5:
        LinearLayout r0 = this.m;
        LinearLayout r1 = null;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("inputLayout");
        r0 = null;
    L8:
        r0.setOnClickListener(new a(this));
        LinearLayout r2 = this.n;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("memberListLayout");
    L12:
        r1.setOnClickListener(new b(this));
        return;
    L11:
        r1 = r2;
        goto L12
    }

    public int getType() {
        return this.j;
    }

    public static final /* synthetic */ com.bytedance.ee.bear.bitable.share.view.memberview.b f(d r0) {
        return (com.bytedance.ee.bear.bitable.share.view.memberview.b) r0.getPresenter();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.e(r2);
        this.k = (TextView) findViewById(2131375593);
        this.l = (TextView) findViewById(2131379513);
        this.m = (LinearLayout) findViewById(2131375329);
        this.n = (LinearLayout) findViewById(2131379840);
        this.o = (TextView) findViewById(2131367115);
        this.p = (LinearLayout) findViewById(2131385896);
        this.q = (TextView) findViewById(2131385897);
    }

    @Override // mu4.d
    public void setBitableSharePermSetInfo(BitableSharePermSetInfo r4) {
        Intrinsics.checkNotNullParameter(r4, "bitableSharePermSetInfo");
        this.s = true;
        com.bytedance.ee.bear.bitable.share.view.memberview.b r1 = (com.bytedance.ee.bear.bitable.share.view.memberview.b) getPresenter();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "bitableSharePermSetInfo");
        r1.h = r4;
        com.bytedance.ee.bear.bitable.share.view.memberview.a r0 = r1.f;
        String r5 = r4.d.getShareToken();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r0.b = r5;
        r1.sB();
        r1.f();
    }

    public void setCollaborateEnable(boolean r8) {
        if (this.s == true) goto L5;
        return;
    L5:
        ih5.c r0 = getAdapter();
        r0.b = Boolean.valueOf(r8);
        r0.a();
        LinearLayout r1 = this.m;
        LinearLayout r2 = null;
        LinearLayout r3 = null;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("inputLayout");
        r1 = null;
    L8:
        float r4 = 0.3f;
        if (r8 == false) goto L11;
        float r5 = 1.0f;
    L12:
        r1.setAlpha(r5);
        LinearLayout r6 = this.n;
        if (r6 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("memberListLayout");
        r6 = null;
    L15:
        if (r8 == false) goto L17;
        float r7 = 1.0f;
    L18:
        r6.setAlpha(r7);
        LinearLayout r9 = this.p;
        if (r9 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("sendNotificationLayout");
        r9 = null;
    L21:
        if (r8 == false) goto L23;
        r4 = 1.0f;
    L23:
        r9.setAlpha(r4);
        if (r8 == false) goto L36;
        LinearLayout r10 = this.m;
        LinearLayout r11 = r10;
        if (r10 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("inputLayout");
        r11 = null;
    L28:
        r11.setOnClickListener(new c(this));
        LinearLayout r12 = this.n;
        if (r12 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("memberListLayout");
        r12 = null;
    L31:
        r12.setEnabled(true);
        LinearLayout r13 = this.n;
        if (r13 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("memberListLayout");
    L35:
        r3.setOnClickListener(new C0022d(this));
        getAdapter().a = new e(this);
        return;
    L34:
        r3 = r13;
        goto L35
    L36:
        LinearLayout r14 = this.m;
        if (r14 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("inputLayout");
        r14 = null;
    L39:
        r14.setOnClickListener(new f(this));
        LinearLayout r16 = this.n;
        if (r16 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("memberListLayout");
    L43:
        r2.setOnClickListener(new g(this));
        getAdapter().a = new h(this);
        return;
    L42:
        r2 = r16;
        goto L43
    L17:
        r7 = 0.3f;
        goto L18
    L11:
        r5 = 0.3f;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setCollaborateViewTitle(int r5) {
        TextView r0 = this.o;
        TextView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("collaboratorTitleTv");
        r0 = null;
    L5:
        r0.setText(getResources().getString(r5));
        TextView r6 = this.o;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("collaboratorTitleTv");
    L9:
        r1.setVisibility(0);
        return;
    L8:
        r1 = r6;
        goto L9
    }

    @Override // mu4.d
    public void setEnable(boolean r1) {
        setCollaborateEnable(r1);
    }

    public final void setInviteMemberTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "inviteTitle");
        TextView r0 = this.k;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("inviteMemberTitle");
        r0 = null;
    L5:
        r0.setText(r2);
    }

    public final void setManageMemberTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "managerTitle");
        TextView r0 = this.l;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("manageMemberTitle");
        r0 = null;
    L5:
        r0.setText(r2);
    }

    public final void setSendNotificationClickListener(View.OnClickListener r2) {
        if (r2 == null) goto L8;
        LinearLayout r0 = this.p;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("sendNotificationLayout");
        r0 = null;
    L6:
        r0.setOnClickListener(r2);
        return;
    }

    public final void setSendNotificationEnable(boolean r2) {
        LinearLayout r0 = this.p;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("sendNotificationLayout");
        r0 = null;
    L5:
        if (r2 == false) goto L7;
        int r3 = 0;
    L8:
        r0.setVisibility(r3);
        return;
    L7:
        r3 = 8;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setSendNotificationTitle(int r5) {
        TextView r0 = this.q;
        TextView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("sendNotificationTitle");
        r0 = null;
    L5:
        r0.setText(getResources().getString(r5));
        TextView r6 = this.q;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("sendNotificationTitle");
    L9:
        r1.setVisibility(0);
        return;
    L8:
        r1 = r6;
        goto L9
    }

    public final void setUnableClickListener(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "unableClickListener");
        this.r = r2;
    }

    public final void setInviteMemberTitle(int r2) {
        TextView r0 = this.k;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("inviteMemberTitle");
        r0 = null;
    L5:
        r0.setText(r2);
    }

    public final void setManageMemberTitle(int r2) {
        TextView r0 = this.l;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("manageMemberTitle");
        r0 = null;
    L5:
        r0.setText(r2);
    }

    public d(FragmentActivity r9, Fragment r10, int r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r12, "token");
        Intrinsics.checkNotNullParameter(r13, "shareToken");
        super(r9, r11);
        this.h = r9;
        this.i = r10;
        this.j = r11;
        setPresenter(new com.bytedance.ee.bear.bitable.share.view.memberview.b(r9, r10, getType(), r12, r13, this));
        com.bytedance.ee.bear.bitable.share.view.memberview.b r14 = (com.bytedance.ee.bear.bitable.share.view.memberview.b) getPresenter();
        r14.f.a(new BitableShareMemberPresenter$requestMember$1(r14));
    }
}
