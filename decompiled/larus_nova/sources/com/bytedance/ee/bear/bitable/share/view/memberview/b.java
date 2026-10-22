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
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import ih5.e;
import java.util.ArrayList;
import java.util.Iterator;
import jg5.j;
import kotlin.jvm.internal.Intrinsics;
import mu4.f;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements ih5.d, i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f215514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f215515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f215516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f215517d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f215518e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.share.view.memberview.a f215519f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ShareUserInfoResult f215520g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BitableSharePermSetInfo f215521h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f215522i;

    public static final class a {
    }

    static {
    }

    @Override // ih5.d
    public final void c() {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().getClass();
        ((ArrayList) j.f499008b).remove(this);
        this.f215522i = true;
        this.f215519f.f215511c.dispose();
    }

    public final UserInfo d() {
        ShareUserInfoResult r100 = this.f215520g;
        if (r100 == null) goto L6;
        ArrayList<UserInfo> r101 = r100.getUserInfoList();
        if (r101 == null) goto L6;
    L7:
        Iterator<UserInfo> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L13;
        UserInfo r103 = r102.next();
        if (r103.isOwner() == false) goto L9;
        return r103;
    L13:
        return null;
    L6:
        r101 = new ArrayList();
        goto L7
    }

    public final BitableSharePermSetInfo e() {
        BitableSharePermSetInfo r100 = this.f215521h;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new BitableSharePermSetInfo(this.f215516c, this.f215517d, 57);
    }

    public final void f() {
        boolean r100 = false;
        if (this.f215521h != null) goto L5;
        this.f215518e.setCollaborateEnable(false);
        return;
    L5:
        g(this);
        BitableSharePermSetInfo r101 = this.f215521h;
        if (r101 == null) goto L10;
        IShareMeta r102 = r101.f215308d;
        if (r102 == null) goto L10;
        boolean r103 = r102.isOpen();
    L11:
        BitableSharePermSetInfo r104 = this.f215521h;
        if (r104 == null) goto L14;
        boolean r105 = r104.f215309e.f215332a.canShare();
    L15:
        e r106 = this.f215518e;
        if (r103 == false) goto L19;
        if (r105 == false) goto L19;
        r100 = true;
    L19:
        r106.setCollaborateEnable(r100);
        return;
    L14:
        r105 = false;
    L10:
        r103 = false;
        goto L11
    }

    @Override // ih5.d
    public final void onAttachedToWindow() {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().m(this);
        if (this.f215522i == false) goto L6;
        this.f215522i = false;
        this.f215519f.a(new BitableShareMemberPresenter$requestMember$1(this));
        return;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.i
    public final void sB() {
        tt5.a.h("ShareMemberPresenter", "onMemberChange()...");
        this.f215519f.a(new BitableShareMemberPresenter$onMemberChange$1(this));
    }

    @Override // ih5.d
    public final void b() {
        if (com.bytedance.ee.bear.bitable.c.j() == true) goto L5;
    L7:
        Fragment r100 = null;
    L8:
        int r101 = BitableShareInviteMemberFragment.f215311p;
        FragmentActivity r102 = this.f215514a;
        BitableSharePermSetInfo r103 = e();
        ShareUserInfoResult r104 = this.f215520g;
        if (r104 == null) goto L12;
        ArrayList<UserInfo> r105 = r104.getUserInfoList();
        if (r105 == null) goto L12;
    L13:
        BitableShareInviteMemberFragment.a.a(r102, r100, r103, r105, true);
        int r106 = f.f515752a;
        EShareType r107 = e().f215308d.getShareType();
        Intrinsics.checkNotNullParameter(r107, "shareType");
        f.c("invite_collaborator", "ccm_permission_add_collaborator_view", r107);
        return;
    L12:
        r105 = new ArrayList();
        goto L13
    L5:
        if (ForsetiHelper.s(this.f215515b) == false) goto L7;
        r100 = this.f215515b;
        goto L8
    }

    public static void g(b r110) {
        if (r110.f215521h != null) goto L5;
        return;
    L5:
        if (r110.f215520g == null) goto L26;
        com.bytedance.ee.bear.contract.d r100 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        Long r101 = (Long) r100.f("analytics_open_time_tag", "t2End");
        Integer r102 = (Integer) r100.f("analytics_open_time_tag", "t1");
        Integer r103 = (Integer) r100.f("analytics_open_time_tag", "t2");
        Integer r104 = (Integer) r100.f("analytics_open_time_tag", "source");
        Boolean r105 = (Boolean) r100.f("analytics_open_time_tag", "is_minutes");
        Boolean r106 = (Boolean) r100.f("analytics_open_time_tag", "is_retry");
        if (r101 == null) goto L22;
        if (r102 == null) goto L23;
        if (r103 == null) goto L24;
        if (r104 == null) goto L25;
        if (r105 == null) goto L27;
        r100.m("analytics_open_time_tag").clear();
        long r107 = System.currentTimeMillis();
        View r111 = r110.f215514a.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L19;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r108 = ThreadMethodProxy.currentThread();
        if (r108 == com.larus.home.impl.utils.c.f346341a) goto L19;
        com.larus.home.impl.utils.c.a(r108, "getDecorView");
    L19:
        r111.post(new c(r107, r101, r102, r103, r106, r104, r105, false));
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

    public b(FragmentActivity r100, Fragment r101, int r102, String r103, String r104, e r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "token");
        Intrinsics.checkNotNullParameter(r104, "shareToken");
        Intrinsics.checkNotNullParameter(r105, "view");
        this.f215514a = r100;
        this.f215515b = r101;
        this.f215516c = r102;
        this.f215517d = r103;
        this.f215518e = r105;
        this.f215519f = new com.bytedance.ee.bear.bitable.share.view.memberview.a(r103, r104);
    }
}
