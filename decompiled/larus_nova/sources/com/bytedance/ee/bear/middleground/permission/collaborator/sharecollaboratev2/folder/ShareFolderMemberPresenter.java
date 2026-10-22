package com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.FolderPermSetInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larus.utils.logger.FLogger;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import jg5.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class ShareFolderMemberPresenter implements com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder.a, com.bytedance.ee.bear.middleground_permission_export.model.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f233736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f233737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f233738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f233739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FolderVersion f233740e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f233741f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f233742g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ih5.e f233743h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f233744i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FolderPermSetInfo f233745j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ShareUserInfoResult f233746k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f233747l;

    public static final class a {
    }

    static {
    }

    @Override // ih5.d
    public final void b() {
        pg5.b.d(this.f233736a, d(), this.f233746k, this.f233742g, true);
    }

    @Override // ih5.d
    public final void c() {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().getClass();
        ((ArrayList) j.f499008b).remove(this);
        this.f233747l = true;
        b r100 = this.f233744i;
        r100.getClass();
        tt5.a.h("ShareFolderMemberModel", MapMonitorConst.EVENT_DESTROY);
        r100.f233751d.clear();
    }

    public final FolderPermSetInfo d() {
        FolderPermSetInfo r100 = this.f233745j;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new FolderPermSetInfo(this.f233737b, this.f233738c, this.f233739d, 7162);
    }

    public final void e() {
        boolean r100 = false;
        if (this.f233745j != null) goto L5;
        this.f233743h.setCollaborateEnable(false);
        return;
    L5:
        UserInfo r110 = null;
        if (this.f233746k == null) goto L21;
        com.bytedance.ee.bear.contract.d r101 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        Long r102 = (Long) r101.f("analytics_open_time_tag", "t2End");
        Integer r103 = (Integer) r101.f("analytics_open_time_tag", "t1");
        Integer r104 = (Integer) r101.f("analytics_open_time_tag", "t2");
        Integer r105 = (Integer) r101.f("analytics_open_time_tag", "source");
        Boolean r111 = (Boolean) r101.f("analytics_open_time_tag", "is_minutes");
        Boolean r106 = (Boolean) r101.f("analytics_open_time_tag", "is_retry");
        if (r102 == null) goto L21;
        if (r103 == null) goto L21;
        if (r104 == null) goto L21;
        if (r105 == null) goto L21;
        if (r111 == null) goto L21;
        r101.m("analytics_open_time_tag").clear();
        long r107 = System.currentTimeMillis();
        View r108 = this.f233736a.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L20;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r109 = ThreadMethodProxy.currentThread();
        if (r109 == com.larus.home.impl.utils.c.f346341a) goto L20;
        com.larus.home.impl.utils.c.a(r109, "getDecorView");
    L20:
        r108.post(new e(r107, r102, r103, r104, r106, r105, r111, false));
    L21:
        ih5.e r112 = this.f233743h;
        if (this.f233740e.isFolderV1() == true) goto L24;
        FolderPermSetInfo r113 = this.f233745j;
        if (r113 == null) goto L50;
        r100 = r113.f234447j.f234425a.canManagerCollaborator();
    L50:
        r112.setCollaborateEnable(r100);
        return;
    L24:
        if (this.f233740e.isPersonalFolder() == true) goto L46;
        ShareUserInfoResult r114 = this.f233746k;
        if (r114 == null) goto L30;
        ArrayList<UserInfo> r115 = r114.getUserInfoList();
        if (r115 == null) goto L30;
    L31:
        Iterator<UserInfo> r116 = r115.iterator();
    L33:
        if (r116.hasNext() == false) goto L37;
        UserInfo r117 = r116.next();
        if (r117.isOwner() == false) goto L33;
        r110 = r117;
    L37:
        if (r110 == null) goto L39;
        boolean r118 = r110.isExternal();
    L40:
        if (r118 == true) goto L50;
        FolderPermSetInfo r119 = this.f233745j;
        if (r119 == null) goto L44;
        boolean r120 = r119.f234447j.f234425a.canManagerCollaborator();
    L45:
        if (r120 == false) goto L50;
    L44:
        r120 = this.f233741f;
        goto L45
    L39:
        r118 = false;
    L30:
        r115 = new ArrayList();
    L46:
        r100 = true;
        goto L50
    }

    @Override // ih5.d
    public final void onAttachedToWindow() {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().m(this);
        this.f233747l = false;
        this.f233744i.a(new AnonymousClass1(this));
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.i
    public final void sB() {
        tt5.a.h("ShareFolderMemberPresenter", "onMemberChange()...");
        this.f233744i.a(new ShareFolderMemberPresenter$onMemberChange$1(this));
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder.ShareFolderMemberPresenter$unlock$1, java.lang.Object] */
    @Override // ih5.d
    public final void unlock() {
        tt5.a.h("ShareFolderMemberPresenter", "unlock()...");
        b r100 = this.f233744i;
        ?? r101 = new C105371(this);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "callback");
        xh5.a r102 = xh5.a.f563873a;
        String r103 = r100.f233749b;
        NetService.f r104 = new NetService.f("/space/api/suite/permission/space/unlock/");
        JSONObject r105 = new JSONObject();
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        r105.put("token", r103);
        r104.f216913j = r105.toJSONString();
        r104.f216906c = 1;
        Disposable r106 = ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new ax4.f()).a(r104).flatMap(xh5.b.f563876a).subscribe(new c(r101), new d(r101));
        r100.f233751d.add(r106);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder.a
    public final void a(FolderPermSetInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "permSetInfo");
        this.f233745j = r100;
        e();
    }

    public ShareFolderMemberPresenter(FragmentActivity r100, int r101, String r102, String r103, FolderVersion r104, boolean r105, String r106, ih5.e r107) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r102, "token");
        Intrinsics.checkNotNullParameter(r103, "spaceId");
        Intrinsics.checkNotNullParameter(r104, "version");
        Intrinsics.checkNotNullParameter(r106, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r107, "view");
        this.f233736a = r100;
        this.f233737b = r101;
        this.f233738c = r102;
        this.f233739d = r103;
        this.f233740e = r104;
        this.f233741f = r105;
        this.f233742g = r106;
        this.f233743h = r107;
        this.f233744i = new b(r104, r102, r103);
    }
}
