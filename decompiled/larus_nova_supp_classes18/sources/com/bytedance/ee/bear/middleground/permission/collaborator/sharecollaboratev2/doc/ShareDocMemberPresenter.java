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
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.framework.callback.IRequestCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import jg5.j;
import kotlin.jvm.internal.Intrinsics;
import li5.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class ShareDocMemberPresenter implements ih5.d, i {
    public final FragmentActivity a;
    public final Fragment b;
    public final int c;
    public final String d;
    public final String e;
    public final boolean f;
    public final ih5.e g;
    public final com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc.a h;
    public ShareUserInfoResult i;
    public DocPermSetInfo j;
    public IDocPublicPermission k;
    public boolean l;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ long a;
        public final /* synthetic */ Long b;
        public final /* synthetic */ Integer c;
        public final /* synthetic */ Integer d;
        public final /* synthetic */ Boolean e;
        public final /* synthetic */ Integer f;
        public final /* synthetic */ Boolean g;
        public final /* synthetic */ boolean h;
        public final /* synthetic */ int i;

        public b(long r1, Long r3, Integer r4, Integer r5, Boolean r6, Integer r7, Boolean r8, boolean r9, int r10) {
            this.a = r1;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
        }

        public final void a() {
            long r0 = System.currentTimeMillis();
            int r6 = (int) (this.a - this.b.longValue());
            int r7 = (int) (r0 - this.a);
            int r4 = this.c.intValue();
            int r5 = this.d.intValue();
            int r8 = this.c.intValue() + this.d.intValue();
            int r9 = ((this.c.intValue() + this.d.intValue()) + r6) + r7;
            Boolean r1 = this.e;
            if (r1 == null) goto L5;
            boolean r11 = r1.booleanValue();
        L6:
            com.bytedance.ee.bear.middleground.permission.c.C(r4, r5, r6, r7, r8, r9, DocumentType.DOC_NAME, r11, this.f.intValue(), this.g.booleanValue());
            boolean r2 = !this.h;
            Boolean r3 = this.e;
            if (r3 == null) goto L9;
            boolean r10 = r3.booleanValue();
        L10:
            com.bytedance.ee.bear.middleground.permission.c.B(r2, DocumentType.DOC_NAME, r10, this.f.intValue(), this.g.booleanValue(), this.i);
            return;
        L9:
            r10 = false;
            goto L10
        L5:
            r11 = false;
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
        FragmentActivity r0 = this.a;
        Fragment r1 = this.b;
        DocPermSetInfo r2 = f();
        ShareUserInfoResult r3 = this.i;
        if (r3 == null) goto L6;
        ArrayList<UserInfo> r4 = r3.getUserInfoList();
        if (r4 == null) goto L6;
    L7:
        DocPermSetInfo r5 = this.j;
        if (r5 != null) goto L10;
    L12:
        boolean r6 = false;
    L13:
        if (r6 == false) goto L38;
        Iterator<UserInfo> r7 = r4.iterator();
        String r8 = null;
        UserInfo r9 = null;
    L16:
        if (r7.hasNext() == false) goto L20;
        UserInfo r10 = r7.next();
        if (r10.isOwner() == false) goto L16;
        r9 = r10;
        goto L16
    L20:
        if (r9 != null) goto L38;
        DocPermSetInfo r11 = this.j;
        if (r11 == null) goto L24;
        DocMetaInfo r12 = r11.e;
    L25:
        if (r12 == null) goto L38;
        UserInfo r13 = new UserInfo();
        DocPermSetInfo r14 = this.j;
        if (r14 == null) goto L29;
        DocMetaInfo r15 = r14.e;
    L30:
        r13.setOwner(true);
        if (r15 == null) goto L33;
        String r16 = r15.getOwnerName();
    L34:
        r13.setName(r16);
        if (r15 == null) goto L37;
        r8 = r15.getOwnerUid();
    L37:
        r13.setId(r8);
        r4.add(r13);
        goto L38
    L33:
        r16 = null;
        goto L34
    L29:
        r15 = null;
        goto L30
    L24:
        r12 = null;
    L38:
        pg5.b.c(r0, r1, r2, r4, this.e, true, this.f);
        return;
    L10:
        if (r5.getType() != 44) goto L12;
        r6 = true;
    L6:
        r4 = new ArrayList();
        goto L7
    }

    @Override // ih5.d
    public final void c() {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().getClass();
        ((ArrayList) j.b).remove(this);
        this.l = true;
        this.h.c.clear();
    }

    public final DocPermSetInfo f() {
        DocPermSetInfo r0 = this.j;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new DocPermSetInfo(null, this.c, this.d, false, null, null, null, false, false, false, 2041);
    }

    @Override // ih5.d
    public final void onAttachedToWindow() {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().m(this);
        this.l = false;
        if (this.c != 44) goto L5;
        this.h.b(new ShareDocMemberPresenter$requestSyncedBlockMember$1(this));
        return;
    L5:
        com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc.a r0 = this.h;
        ShareDocMemberPresenter$requestMember$1 r1 = new ShareDocMemberPresenter$requestMember$1(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "callback");
        Disposable r2 = li5.c.c(r0.a, r0.b, new com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc.b(r0, r1), null);
        r0.c.add(r2);
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.i
    public final void sB() {
        tt5.a.h("ShareDocMemberPresenter", "onMemberChange()...");
        if (this.c != 44) goto L6;
        this.h.b(new ShareDocMemberPresenter$onMemberChange$1(this));
        return;
    L6:
        com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc.a r0 = this.h;
        IRequestCallback<ShareUserInfoResult, Throwable> r1 = new ShareDocMemberPresenter$onMemberChange$2(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "callback");
        Disposable r2 = li5.c.c(r0.a, r0.b, new com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc.b(r0, r1), null);
        r0.c.add(r2);
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc.ShareDocMemberPresenter$unlock$1, java.lang.Object] */
    @Override // ih5.d
    public final void unlock() {
        tt5.a.h("ShareDocMemberPresenter", "unlock()...");
        DocPermSetInfo r2 = this.j;
        if (r2 != null) goto L5;
    L15:
        tt5.a.k("ShareDocMemberPresenter", "unlock()... permSetInfo == null");
        return;
    L5:
        if (r2.getType() != 44) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L15;
        com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc.a r0 = this.h;
        ?? r4 = new AnonymousClass1(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "callback");
        int r5 = r0.a;
        String r6 = r0.b;
        int r7 = li5.c.a;
        tt5.a.h("DocPermissionManager", "unlock()...");
        JSONObject r1 = new JSONObject();
        r1.put(ResourceData.KEY_TYPE, Integer.valueOf(r5));
        if (r6 != null) goto L13;
        r6 = "";
    L13:
        r1.put(ResourceData.KEY_TOKEN, r6);
        NetService r8 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        NetService.f r9 = new NetService.f("/space/api/suite/permission/unlock/");
        ((NetService.e) r9).j = r1.toJSONString();
        Disposable r10 = r8.Vc(new ax4.f()).a(r9).flatMap(l.a).subscribe(new c(r4), new d(r4));
        r0.c.add(r10);
        return;
    L7:
        r3 = false;
        goto L8
    }

    public static final void d(ShareDocMemberPresenter r3, Throwable r4) {
        r3.getClass();
        tt5.a.e("ShareDocMemberPresenter", "fetchCollaborates()...failed, e=", r4, false);
        if (r3.l == false) goto L5;
        tt5.a.d("ShareDocMemberPresenter", "fetchCollaborates failed and isDetach");
        return;
    L5:
        r3.g.a();
        r3.g.c(r4);
    }

    public static final void e(ShareDocMemberPresenter r3, ShareUserInfoResult r4) {
        r3.getClass();
        tt5.a.h("ShareDocMemberPresenter", "fetchCollaborates()...succeed");
        if (r3.l == false) goto L5;
        tt5.a.d("ShareDocMemberPresenter", "fetchCollaborates succeed but isDetach");
        return;
    L5:
        r3.i = r4;
        boolean r0 = false;
        r3.g(false, 0);
        r3.g.a();
        r3.g.d(r4.getUserInfoList(), r4.getTotalNum());
        if (r3.j == null) goto L15;
        r3.g(false, 0);
        ih5.e r5 = r3.g;
        DocPermSetInfo r6 = r3.j;
        if (r6 != null) goto L10;
    L12:
        r5.setCollaborateEnable(r0);
        return;
    L10:
        if (r6.f.a.canManageCollaborator() != true) goto L12;
        r0 = true;
        goto L12
    }

    public final void g(boolean r15, int r16) {
        if (r15 == false) goto L5;
    L9:
        com.bytedance.ee.bear.contract.d r1 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        Long r4 = (Long) r1.f("analytics_open_time_tag", "t2End");
        Integer r5 = (Integer) r1.f("analytics_open_time_tag", "t1");
        Integer r6 = (Integer) r1.f("analytics_open_time_tag", "t2");
        Integer r8 = (Integer) r1.f("analytics_open_time_tag", "source");
        Boolean r9 = (Boolean) r1.f("analytics_open_time_tag", "is_minutes");
        Boolean r7 = (Boolean) r1.f("analytics_open_time_tag", "is_retry");
        if (r4 == null) goto L24;
        if (r5 == null) goto L25;
        if (r6 == null) goto L26;
        if (r8 == null) goto L27;
        if (r9 == null) goto L28;
        r1.m("analytics_open_time_tag").clear();
        long r2 = System.currentTimeMillis();
        View r12 = this.a.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L21;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r3 = ThreadMethodProxy.currentThread();
        if (r3 == com.larus.home.impl.utils.c.a) goto L21;
        com.larus.home.impl.utils.c.a(r3, "getDecorView");
    L21:
        r12.post(new b(r2, r4, r5, r6, r7, r8, r9, r15, r16));
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
        if (this.j != null) goto L7;
        return;
    L7:
        if (this.i != null) goto L9;
    }

    public ShareDocMemberPresenter(FragmentActivity r2, Fragment r3, int r4, String r5, String r6, boolean r7, ih5.e r8) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r5, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r6, "module");
        Intrinsics.checkNotNullParameter(r8, "view");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = new com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc.a(r4, r5);
    }
}
