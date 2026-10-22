package hh5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteMemberParams;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.UserGroup;
import com.bytedance.ee.bear.share.export.UserInfo;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements c {
    public final dh5.b a;
    public final ArrayList<UserInfo> b;
    public final InviteMemberParams c;
    public Disposable d;

    public static final class a {
    }

    static {
    }

    public final void create() {
    }

    @Override // hh5.c
    public final ArrayList<UserGroup> I5() {
        ArrayList<UserGroup> r0 = new ArrayList();
        Iterator<T> r1 = this.a.getSelected().iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        UserInfo r2 = (UserInfo) r1.next();
        if (r2.getOwnerType() == 22) goto L9;
        if (r2.getOwnerType() != 30) goto L4;
    L9:
        r0.add(A0(r2));
        goto L4
    L10:
        return r0;
    }

    public final void destroy() {
        Disposable r0 = this.d;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L13;
        Disposable r2 = this.d;
        if (r2 == null) goto L14;
        r2.dispose();
        return;
    L14:
        return;
    L13:
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        r1 = true;
        goto L8
    }

    @Override // hh5.c
    public final ArrayList<UserInfo> m0() {
        return this.b;
    }

    @Override // hh5.c
    public final UserGroup A0(UserInfo r6) {
        Intrinsics.checkNotNullParameter(r6, "userInfo");
        String r0 = r6.getId();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r7 = r6.getName(((i0) org.koin.java.a.c(i0.class, null, null, 6)).a());
        if (r7 == null) goto L10;
        r1 = r7;
    L10:
        return new UserGroup(r0, r1);
    }

    @Override // hh5.c
    public final void i(UserInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "userInfo");
        this.a.removeUser(r2);
    }

    @Override // hh5.c
    public final void l(UserInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "userInfo");
        this.a.addUser(r2);
    }

    @Override // hh5.c
    public final void o5(k r5) {
        Intrinsics.checkNotNullParameter(r5, "callback");
        NetService.f r0 = new NetService.f("/space/api/suite/platform/visible_group/");
        r0.b("scene_type", "1");
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.permission.web.user_group") == false) goto L5;
        r0.b("group_type", "0");
    L5:
        ((NetService.e) r0).c = 2;
        this.d = ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new hh5.a()).a(r0).flatMap(new h(this)).subscribe(new i(r5), new j(r5));
    }

    @Override // hh5.c
    public final void registerChangeListener(dh5.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a.registerChangeListener(r2);
    }

    @Override // hh5.c
    public final UserInfo t2(UserGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "userGroup");
        UserInfo r0 = new UserInfo();
        r0.setId(r3.a);
        r0.setName(r3.b);
        if (r3.c != 1) goto L5;
        int r4 = 30;
    L6:
        r0.setOwnerType(r4);
        r0.setCan_modify_perm(true);
        return r0;
    L5:
        r4 = 22;
        goto L6
    }

    @Override // hh5.c
    public final void unregisterChangeListener(dh5.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a.unregisterChangeListener(r2);
    }

    public e(dh5.b r2, ArrayList<UserInfo> r3, InviteMemberParams r4) {
        Intrinsics.checkNotNullParameter(r2, "selectedUserModel");
        Intrinsics.checkNotNullParameter(r3, "originUsers");
        Intrinsics.checkNotNullParameter(r4, "params");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
