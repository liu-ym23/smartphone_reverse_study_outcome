package com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.FolderPermSetInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import jg5.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class ShareFolderMemberPresenter implements com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder.a, com.bytedance.ee.bear.middleground_permission_export.model.i {
    public final FragmentActivity a;
    public final int b;
    public final String c;
    public final String d;
    public final FolderVersion e;
    public final boolean f;
    public final String g;
    public final ih5.e h;
    public final b i;
    public FolderPermSetInfo j;
    public ShareUserInfoResult k;
    public boolean l;

    public static final class a {
    }

    static {
    }

    @Override // ih5.d
    public final void b() {
        pg5.b.d(this.a, d(), this.k, this.g, true);
    }

    @Override // ih5.d
    public final void c() {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().getClass();
        ((ArrayList) j.b).remove(this);
        this.l = true;
        b r0 = this.i;
        r0.getClass();
        tt5.a.h("ShareFolderMemberModel", "destroy");
        r0.d.clear();
    }

    public final FolderPermSetInfo d() {
        FolderPermSetInfo r0 = this.j;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new FolderPermSetInfo(this.b, this.c, this.d, 7162);
    }

    public final void e() {
        boolean r1 = false;
        if (this.j != null) goto L5;
        this.h.setCollaborateEnable(false);
        return;
    L5:
        UserInfo r12 = null;
        if (this.k == null) goto L21;
        com.bytedance.ee.bear.contract.d r0 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        Long r5 = (Long) r0.f("analytics_open_time_tag", "t2End");
        Integer r6 = (Integer) r0.f("analytics_open_time_tag", "t1");
        Integer r7 = (Integer) r0.f("analytics_open_time_tag", "t2");
        Integer r9 = (Integer) r0.f("analytics_open_time_tag", "source");
        Boolean r10 = (Boolean) r0.f("analytics_open_time_tag", "is_minutes");
        Boolean r8 = (Boolean) r0.f("analytics_open_time_tag", "is_retry");
        if (r5 == null) goto L21;
        if (r6 == null) goto L21;
        if (r7 == null) goto L21;
        if (r9 == null) goto L21;
        if (r10 == null) goto L21;
        r0.m("analytics_open_time_tag").clear();
        long r3 = System.currentTimeMillis();
        View r2 = this.a.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L20;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r4 = ThreadMethodProxy.currentThread();
        if (r4 == com.larus.home.impl.utils.c.a) goto L20;
        com.larus.home.impl.utils.c.a(r4, "getDecorView");
    L20:
        r2.post(new e(r3, r5, r6, r7, r8, r9, r10, false));
    L21:
        ih5.e r11 = this.h;
        if (this.e.isFolderV1() == true) goto L24;
        FolderPermSetInfo r13 = this.j;
        if (r13 == null) goto L50;
        r1 = r13.j.a.canManagerCollaborator();
    L50:
        r11.setCollaborateEnable(r1);
        return;
    L24:
        if (this.e.isPersonalFolder() == true) goto L46;
        ShareUserInfoResult r14 = this.k;
        if (r14 == null) goto L30;
        ArrayList<UserInfo> r15 = r14.getUserInfoList();
        if (r15 == null) goto L30;
    L31:
        Iterator<UserInfo> r16 = r15.iterator();
    L33:
        if (r16.hasNext() == false) goto L37;
        UserInfo r17 = r16.next();
        if (r17.isOwner() == false) goto L33;
        r12 = r17;
    L37:
        if (r12 == null) goto L39;
        boolean r18 = r12.isExternal();
    L40:
        if (r18 == true) goto L50;
        FolderPermSetInfo r19 = this.j;
        if (r19 == null) goto L44;
        boolean r20 = r19.j.a.canManagerCollaborator();
    L45:
        if (r20 == false) goto L50;
    L44:
        r20 = this.f;
        goto L45
    L39:
        r18 = false;
    L30:
        r15 = new ArrayList();
    L46:
        r1 = true;
        goto L50
    }

    @Override // ih5.d
    public final void onAttachedToWindow() {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().m(this);
        this.l = false;
        this.i.a(new AnonymousClass1(this));
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.i
    public final void sB() {
        tt5.a.h("ShareFolderMemberPresenter", "onMemberChange()...");
        this.i.a(new ShareFolderMemberPresenter$onMemberChange$1(this));
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder.ShareFolderMemberPresenter$unlock$1, java.lang.Object] */
    @Override // ih5.d
    public final void unlock() {
        tt5.a.h("ShareFolderMemberPresenter", "unlock()...");
        b r0 = this.i;
        ?? r1 = new C03531(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "callback");
        xh5.a r2 = xh5.a.a;
        String r3 = r0.b;
        NetService.f r4 = new NetService.f("/space/api/suite/permission/space/unlock/");
        JSONObject r5 = new JSONObject();
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r5.put(ResourceData.KEY_TOKEN, r3);
        ((NetService.e) r4).j = r5.toJSONString();
        ((NetService.e) r4).c = 1;
        Disposable r6 = ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new ax4.f()).a(r4).flatMap(xh5.b.a).subscribe(new c(r1), new d(r1));
        r0.d.add(r6);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder.a
    public final void a(FolderPermSetInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "permSetInfo");
        this.j = r2;
        e();
    }

    public ShareFolderMemberPresenter(FragmentActivity r2, int r3, String r4, String r5, FolderVersion r6, boolean r7, String r8, ih5.e r9) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r5, "spaceId");
        Intrinsics.checkNotNullParameter(r6, "version");
        Intrinsics.checkNotNullParameter(r8, "module");
        Intrinsics.checkNotNullParameter(r9, "view");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = new b(r6, r4, r5);
    }
}
