package com.bytedance.ee.bear.bitable.share.view.memberview;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.share.BitableSharePermSetInfo;
import com.bytedance.ee.bear.bitable.share.invitemember.BitableShareInviteMemberFragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.middleground_permission_export.model.i;
import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import com.bytedance.ee.bear.share.EShareType;
import com.bytedance.ee.bear.share.IShareMeta;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import ih5.e;
import java.util.ArrayList;
import java.util.Iterator;
import jg5.j;
import kotlin.jvm.internal.Intrinsics;
import mu4.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements ih5.d, i {
    public final FragmentActivity a;
    public final Fragment b;
    public final int c;
    public final String d;
    public final e e;
    public final com.bytedance.ee.bear.bitable.share.view.memberview.a f;
    public ShareUserInfoResult g;
    public BitableSharePermSetInfo h;
    public boolean i;

    public static final class a {
    }

    static {
    }

    public final void c() {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().getClass();
        ((ArrayList) j.b).remove(this);
        this.i = true;
        this.f.c.dispose();
    }

    public final UserInfo d() {
        ShareUserInfoResult r0 = this.g;
        if (r0 == null) goto L6;
        ArrayList r1 = r0.getUserInfoList();
        if (r1 == null) goto L6;
    L7:
        Iterator r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L13;
        UserInfo r3 = (UserInfo) r2.next();
        if (r3.isOwner() == false) goto L9;
        return r3;
    L13:
        return null;
    L6:
        r1 = new ArrayList();
        goto L7
    }

    public final BitableSharePermSetInfo e() {
        BitableSharePermSetInfo r0 = this.h;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new BitableSharePermSetInfo(this.c, this.d, 57);
    }

    public final void f() {
        boolean r1 = false;
        if (this.h != null) goto L5;
        this.e.setCollaborateEnable(false);
        return;
    L5:
        g(this);
        BitableSharePermSetInfo r0 = this.h;
        if (r0 == null) goto L10;
        IShareMeta r2 = r0.d;
        if (r2 == null) goto L10;
        boolean r3 = r2.isOpen();
    L11:
        BitableSharePermSetInfo r4 = this.h;
        if (r4 == null) goto L14;
        boolean r5 = r4.e.a.canShare();
    L15:
        e r6 = this.e;
        if (r3 == false) goto L19;
        if (r5 == false) goto L19;
        r1 = true;
    L19:
        r6.setCollaborateEnable(r1);
        return;
    L14:
        r5 = false;
    L10:
        r3 = false;
        goto L11
    }

    public final void onAttachedToWindow() {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().m(this);
        if (this.i == false) goto L6;
        this.i = false;
        this.f.a(new BitableShareMemberPresenter$requestMember$1(this));
        return;
    }

    public final void sB() {
        tt5.a.h("ShareMemberPresenter", "onMemberChange()...");
        this.f.a(new BitableShareMemberPresenter$onMemberChange$1(this));
    }

    public final void b() {
        if (com.bytedance.ee.bear.bitable.c.j() == true) goto L5;
    L7:
        Fragment r0 = null;
    L8:
        int r1 = BitableShareInviteMemberFragment.p;
        FragmentActivity r2 = this.a;
        BitableSharePermSetInfo r3 = e();
        ShareUserInfoResult r4 = this.g;
        if (r4 == null) goto L12;
        ArrayList r5 = r4.getUserInfoList();
        if (r5 == null) goto L12;
    L13:
        BitableShareInviteMemberFragment.a.a(r2, r0, r3, r5, true);
        int r6 = f.a;
        EShareType r7 = e().d.getShareType();
        Intrinsics.checkNotNullParameter(r7, "shareType");
        f.c("invite_collaborator", "ccm_permission_add_collaborator_view", r7);
        return;
    L12:
        r5 = new ArrayList();
        goto L13
    L5:
        if (ForsetiHelper.s(this.b) == false) goto L7;
        r0 = this.b;
        goto L8
    }

    public static void g(b r12) {
        if (r12.h != null) goto L5;
        return;
    L5:
        if (r12.g == null) goto L26;
        com.bytedance.ee.bear.contract.d r0 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        Long r3 = (Long) r0.f("analytics_open_time_tag", "t2End");
        Integer r4 = (Integer) r0.f("analytics_open_time_tag", "t1");
        Integer r5 = (Integer) r0.f("analytics_open_time_tag", "t2");
        Integer r7 = (Integer) r0.f("analytics_open_time_tag", "source");
        Boolean r8 = (Boolean) r0.f("analytics_open_time_tag", "is_minutes");
        Boolean r6 = (Boolean) r0.f("analytics_open_time_tag", "is_retry");
        if (r3 == null) goto L22;
        if (r4 == null) goto L23;
        if (r5 == null) goto L24;
        if (r7 == null) goto L25;
        if (r8 == null) goto L27;
        r0.m("analytics_open_time_tag").clear();
        long r1 = System.currentTimeMillis();
        View r13 = r12.a.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L19;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r2 = ThreadMethodProxy.currentThread();
        if (r2 == com.larus.home.impl.utils.c.a) goto L19;
        com.larus.home.impl.utils.c.a(r2, "getDecorView");
    L19:
        r13.post(new c(r1, r3, r4, r5, r6, r7, r8, false));
        return;
    L27:
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    }

    public b(FragmentActivity r2, Fragment r3, int r4, String r5, String r6, e r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r5, "token");
        Intrinsics.checkNotNullParameter(r6, "shareToken");
        Intrinsics.checkNotNullParameter(r7, "view");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
        this.f = new com.bytedance.ee.bear.bitable.share.view.memberview.a(r5, r6);
    }
}
