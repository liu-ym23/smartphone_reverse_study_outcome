package com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.i;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.DocPermSetInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.callback.IRequestCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import jg5.j;
import kotlin.jvm.internal.Intrinsics;
import li5.l;

/* JADX INFO: loaded from: classes18.dex */
public final class ShareDocMemberPresenter implements ih5.d, i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f233676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f233677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f233678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f233679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f233680e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f233681f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ih5.e f233682g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc.a f233683h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ShareUserInfoResult f233684i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public DocPermSetInfo f233685j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public IDocPublicPermission f233686k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f233687l;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f233688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Long f233689b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Integer f233690c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Integer f233691d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Boolean f233692e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Integer f233693f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Boolean f233694g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ boolean f233695h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ int f233696i;

        public b(long r100, Long r101, Integer r102, Integer r103, Boolean r104, Integer r105, Boolean r106, boolean r107, int r110) {
            this.f233688a = r100;
            this.f233689b = r101;
            this.f233690c = r102;
            this.f233691d = r103;
            this.f233692e = r104;
            this.f233693f = r105;
            this.f233694g = r106;
            this.f233695h = r107;
            this.f233696i = r110;
        }

        public final void a() {
            long r100 = System.currentTimeMillis();
            int r101 = (int) (this.f233688a - this.f233689b.longValue());
            int r102 = (int) (r100 - this.f233688a);
            int r103 = this.f233690c.intValue();
            int r104 = this.f233691d.intValue();
            int r105 = this.f233690c.intValue() + this.f233691d.intValue();
            int r106 = ((this.f233690c.intValue() + this.f233691d.intValue()) + r101) + r102;
            Boolean r107 = this.f233692e;
            if (r107 == null) goto L5;
            boolean r110 = r107.booleanValue();
        L6:
            com.bytedance.ee.bear.middleground.permission.c.C(r103, r104, r101, r102, r105, r106, "doc", r110, this.f233693f.intValue(), this.f233694g.booleanValue());
            boolean r108 = !this.f233695h;
            Boolean r109 = this.f233692e;
            if (r109 == null) goto L9;
            boolean r111 = r109.booleanValue();
        L10:
            com.bytedance.ee.bear.middleground.permission.c.B(r108, "doc", r111, this.f233693f.intValue(), this.f233694g.booleanValue(), this.f233696i);
            return;
        L9:
            r111 = false;
            goto L10
        L5:
            r110 = false;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // ih5.d
    public final void b() {
        FragmentActivity r100 = this.f233676a;
        Fragment r101 = this.f233677b;
        DocPermSetInfo r102 = f();
        ShareUserInfoResult r103 = this.f233684i;
        if (r103 == null) goto L6;
        ArrayList<UserInfo> r104 = r103.getUserInfoList();
        if (r104 == null) goto L6;
    L7:
        DocPermSetInfo r105 = this.f233685j;
        if (r105 != null) goto L10;
    L12:
        boolean r106 = false;
    L13:
        if (r106 == false) goto L38;
        Iterator<UserInfo> r107 = r104.iterator();
        String r108 = null;
        UserInfo r109 = null;
    L16:
        if (r107.hasNext() == false) goto L20;
        UserInfo r110 = r107.next();
        if (r110.isOwner() == false) goto L16;
        r109 = r110;
        goto L16
    L20:
        if (r109 != null) goto L38;
        DocPermSetInfo r111 = this.f233685j;
        if (r111 == null) goto L24;
        DocMetaInfo r112 = r111.f234431e;
    L25:
        if (r112 == null) goto L38;
        UserInfo r113 = new UserInfo();
        DocPermSetInfo r114 = this.f233685j;
        if (r114 == null) goto L29;
        DocMetaInfo r115 = r114.f234431e;
    L30:
        r113.setOwner(true);
        if (r115 == null) goto L33;
        String r116 = r115.getOwnerName();
    L34:
        r113.setName(r116);
        if (r115 == null) goto L37;
        r108 = r115.getOwnerUid();
    L37:
        r113.setId(r108);
        r104.add(r113);
        goto L38
    L33:
        r116 = null;
        goto L34
    L29:
        r115 = null;
        goto L30
    L24:
        r112 = null;
    L38:
        pg5.b.c(r100, r101, r102, r104, this.f233680e, true, this.f233681f);
        return;
    L10:
        if (r105.getType() != 44) goto L12;
        r106 = true;
    L6:
        r104 = new ArrayList();
        goto L7
    }

    @Override // ih5.d
    public final void c() {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().getClass();
        ((ArrayList) j.f499008b).remove(this);
        this.f233687l = true;
        this.f233683h.f233699c.clear();
    }

    public final DocPermSetInfo f() {
        DocPermSetInfo r100 = this.f233685j;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new DocPermSetInfo(null, this.f233678c, this.f233679d, false, null, null, null, false, false, false, 2041);
    }

    @Override // ih5.d
    public final void onAttachedToWindow() {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().m(this);
        this.f233687l = false;
        if (this.f233678c != 44) goto L5;
        this.f233683h.b(new ShareDocMemberPresenter$requestSyncedBlockMember$1(this));
        return;
    L5:
        com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc.a r100 = this.f233683h;
        ShareDocMemberPresenter$requestMember$1 r101 = new ShareDocMemberPresenter$requestMember$1(this);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "callback");
        Disposable r102 = li5.c.c(r100.f233697a, r100.f233698b, new com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc.b(r100, r101), null);
        r100.f233699c.add(r102);
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.i
    public final void sB() {
        tt5.a.h("ShareDocMemberPresenter", "onMemberChange()...");
        if (this.f233678c != 44) goto L6;
        this.f233683h.b(new ShareDocMemberPresenter$onMemberChange$1(this));
        return;
    L6:
        com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc.a r100 = this.f233683h;
        IRequestCallback<ShareUserInfoResult, Throwable> r101 = new ShareDocMemberPresenter$onMemberChange$2(this);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "callback");
        Disposable r102 = li5.c.c(r100.f233697a, r100.f233698b, new com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc.b(r100, r101), null);
        r100.f233699c.add(r102);
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc.ShareDocMemberPresenter$unlock$1, java.lang.Object] */
    @Override // ih5.d
    public final void unlock() {
        tt5.a.h("ShareDocMemberPresenter", "unlock()...");
        DocPermSetInfo r100 = this.f233685j;
        if (r100 != null) goto L5;
    L15:
        tt5.a.k("ShareDocMemberPresenter", "unlock()... permSetInfo == null");
        return;
    L5:
        if (r100.getType() != 44) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L15;
        com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc.a r102 = this.f233683h;
        ?? r103 = new AnonymousClass1(this);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "callback");
        int r104 = r102.f233697a;
        String r105 = r102.f233698b;
        int r106 = li5.c.f509359a;
        tt5.a.h("DocPermissionManager", "unlock()...");
        JSONObject r107 = new JSONObject();
        r107.put("type", Integer.valueOf(r104));
        if (r105 != null) goto L13;
        r105 = "";
    L13:
        r107.put("token", r105);
        NetService r108 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        NetService.f r109 = new NetService.f("/space/api/suite/permission/unlock/");
        r109.f216913j = r107.toJSONString();
        Disposable r110 = r108.Vc(new ax4.f()).a(r109).flatMap(l.f509369a).subscribe(new c(r103), new d(r103));
        r102.f233699c.add(r110);
        return;
    L7:
        r101 = false;
        goto L8
    }

    public static final void d(ShareDocMemberPresenter r100, Throwable r101) {
        r100.getClass();
        tt5.a.e("ShareDocMemberPresenter", "fetchCollaborates()...failed, e=", r101, false);
        if (r100.f233687l == false) goto L5;
        tt5.a.d("ShareDocMemberPresenter", "fetchCollaborates failed and isDetach");
        return;
    L5:
        r100.f233682g.a();
        r100.f233682g.c(r101);
    }

    public static final void e(ShareDocMemberPresenter r100, ShareUserInfoResult r101) {
        r100.getClass();
        tt5.a.h("ShareDocMemberPresenter", "fetchCollaborates()...succeed");
        if (r100.f233687l == false) goto L5;
        tt5.a.d("ShareDocMemberPresenter", "fetchCollaborates succeed but isDetach");
        return;
    L5:
        r100.f233684i = r101;
        boolean r102 = false;
        r100.g(false, 0);
        r100.f233682g.a();
        r100.f233682g.d(r101.getUserInfoList(), r101.getTotalNum());
        if (r100.f233685j == null) goto L15;
        r100.g(false, 0);
        ih5.e r103 = r100.f233682g;
        DocPermSetInfo r104 = r100.f233685j;
        if (r104 != null) goto L10;
    L12:
        r103.setCollaborateEnable(r102);
        return;
    L10:
        if (r104.f234432f.f234419a.canManageCollaborator() != true) goto L12;
        r102 = true;
        goto L12
    }

    public final void g(boolean r110, int r111) {
        if (r110 == false) goto L5;
    L9:
        com.bytedance.ee.bear.contract.d r100 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        Long r101 = (Long) r100.f("analytics_open_time_tag", "t2End");
        Integer r102 = (Integer) r100.f("analytics_open_time_tag", "t1");
        Integer r103 = (Integer) r100.f("analytics_open_time_tag", "t2");
        Integer r104 = (Integer) r100.f("analytics_open_time_tag", "source");
        Boolean r105 = (Boolean) r100.f("analytics_open_time_tag", "is_minutes");
        Boolean r106 = (Boolean) r100.f("analytics_open_time_tag", "is_retry");
        if (r101 == null) goto L24;
        if (r102 == null) goto L25;
        if (r103 == null) goto L26;
        if (r104 == null) goto L27;
        if (r105 == null) goto L28;
        r100.m("analytics_open_time_tag").clear();
        long r107 = System.currentTimeMillis();
        View r112 = this.f233676a.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L21;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r108 = ThreadMethodProxy.currentThread();
        if (r108 == com.larus.home.impl.utils.c.f346341a) goto L21;
        com.larus.home.impl.utils.c.a(r108, "getDecorView");
    L21:
        r112.post(new b(r107, r101, r102, r103, r106, r104, r105, r110, r111));
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L5:
        if (this.f233685j != null) goto L7;
        return;
    L7:
        if (this.f233684i != null) goto L9;
    }

    public ShareDocMemberPresenter(FragmentActivity r100, Fragment r101, int r102, String r103, String r104, boolean r105, ih5.e r106) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "token");
        Intrinsics.checkNotNullParameter(r104, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r106, "view");
        this.f233676a = r100;
        this.f233677b = r101;
        this.f233678c = r102;
        this.f233679d = r103;
        this.f233680e = r104;
        this.f233681f = r105;
        this.f233682g = r106;
        this.f233683h = new com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc.a(r102, r103);
    }
}
