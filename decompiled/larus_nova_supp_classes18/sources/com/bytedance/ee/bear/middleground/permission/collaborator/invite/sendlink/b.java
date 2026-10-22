package com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink;

import android.net.Uri;
import android.util.Pair;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.DocPermSetInfo;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements yg5.a {
    public final dh5.b a;
    public final DocPermSetInfo b;

    public static final class a {
    }

    static {
    }

    public final void create() {
        tt5.a.h("InviteMemberSendLinkModel", "create()...");
    }

    public final void destroy() {
        tt5.a.h("InviteMemberSendLinkModel", "destroy()...");
    }

    @Override // yg5.a
    public final ArrayList<UserInfo> getUsers() {
        return this.a.getSelected();
    }

    @Override // yg5.a
    public final void H6(dh5.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a.unregisterChangeListener(r2);
    }

    @Override // yg5.a
    public final Flowable<SimpleRequestResult> P4(String r11) {
        Intrinsics.checkNotNullParameter(r11, "notes");
        tt5.a.h("InviteMemberSendLinkModel", "sendLink()...");
        ArrayList<UserInfo> r1 = this.a.getSelected();
        if (hu5.a.d(r1) == false) goto L6;
        tt5.a.h("InviteMemberSendLinkModel", "users is empty");
        return Flowable.error(new Throwable("users is empty"));
    L6:
        HashMap r3 = null;
        NetService r2 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        NetService.f r4 = new NetService.f("/space/api/suite/permission/members/share/");
        ((NetService.e) r4).c = 1;
        SendLinkParams r5 = new SendLinkParams();
        r5.setToken(this.b.c);
        r5.setType(Integer.valueOf(this.b.getType()));
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r1.iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        UserInfo r8 = (UserInfo) r7.next();
        SendLinkParams.MembersBean r9 = new SendLinkParams.MembersBean();
        r9.setOwner_id(r8.getId());
        r9.setOwner_type(Integer.valueOf(r8.getOwnerType()));
        r6.add(r9);
        goto L8
    L10:
        r5.setMembers(r6);
        r5.setRemark(r11);
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.android.sheet_share_url_extra_params_enabled") == false) goto L32;
        String r12 = this.b.a;
        Uri r10 = UriProtector.parse(r12);     // Catch: Exception -> L15
        tt5.a.h("InviteMemberSendLinkModel", "sendLinkFlow, url: " + du5.b.l(r12));     // Catch: Exception -> L15
    L17:
        if (r10 == null) goto L30;
        Set r13 = UriProtector.getQueryParameterNames(r10);
        if (r13 == null) goto L24;
        Set r14 = r13;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r15 = r14.iterator();
    L22:
        if (r15.hasNext() == false) goto L25;
        String r16 = (String) r15.next();
        r0.add(new Pair(r16, UriProtector.getQueryParameter(r10, r16)));
    L25:
        if (r0 == null) goto L30;
        r3 = new HashMap();
        Iterator r17 = r0.iterator();
    L28:
        if (r17.hasNext() == false) goto L30;
        Pair r18 = (Pair) r17.next();
        r3.put(r18.first, r18.second);
        goto L28
    L24:
        r0 = null;
    L30:
        if (r3 == null) goto L32;
        r5.setLinkParams(r3);
    L15:
        e = move-exception;
        tt5.a.e("InviteMemberSendLinkModel", "sendLinkFlow, failed to parse url: " + du5.b.l(r12) + ", ", e, false);
        r10 = null;
    L32:
        ((NetService.e) r4).j = JSON.toJSONString(r5);
        return r2.Vc(new ax4.f()).a(r4);
    }

    @Override // yg5.a
    public final void V(UserInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "userInfo");
        this.a.removeUser(r2);
    }

    @Override // yg5.a
    public final void r5(dh5.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a.registerChangeListener(r2);
    }

    public b(dh5.b r2, DocPermSetInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "selectedUserModel");
        Intrinsics.checkNotNullParameter(r3, "permSetInfo");
        this.a = r2;
        this.b = r3;
    }
}
