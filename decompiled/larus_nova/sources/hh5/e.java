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

/* JADX INFO: loaded from: classes18.dex */
public final class e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final dh5.b f485179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<UserInfo> f485180b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InviteMemberParams f485181c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f485182d;

    public static final class a {
    }

    static {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
    }

    @Override // hh5.c
    public final ArrayList<UserGroup> I5() {
        ArrayList<UserGroup> r100 = new ArrayList();
        Iterator<T> r101 = this.f485179a.getSelected().iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        UserInfo r102 = (UserInfo) r101.next();
        if (r102.getOwnerType() == 22) goto L9;
        if (r102.getOwnerType() != 30) goto L4;
    L9:
        r100.add(A0(r102));
        goto L4
    L10:
        return r100;
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        Disposable r100 = this.f485182d;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L13;
        Disposable r102 = this.f485182d;
        if (r102 == null) goto L14;
        r102.dispose();
        return;
    L14:
        return;
    L13:
        return;
    L5:
        if (r100.isDisposed() == true) goto L7;
        r101 = true;
        goto L8
    }

    @Override // hh5.c
    public final ArrayList<UserInfo> m0() {
        return this.f485180b;
    }

    @Override // hh5.c
    public final UserGroup A0(UserInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "userInfo");
        String r101 = r100.getId();
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        String r103 = r100.getName(((i0) org.koin.java.a.c(i0.class, null, null, 6)).a());
        if (r103 == null) goto L10;
        r102 = r103;
    L10:
        return new UserGroup(r101, r102);
    }

    @Override // hh5.c
    public final void i(UserInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "userInfo");
        this.f485179a.removeUser(r100);
    }

    @Override // hh5.c
    public final void l(UserInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "userInfo");
        this.f485179a.addUser(r100);
    }

    @Override // hh5.c
    public final void o5(k r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        NetService.f r101 = new NetService.f("/space/api/suite/platform/visible_group/");
        r101.b("scene_type", "1");
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.permission.web.user_group") == false) goto L5;
        r101.b("group_type", "0");
    L5:
        r101.f216906c = 2;
        this.f485182d = ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new hh5.a()).a(r101).flatMap(new h(this)).subscribe(new i(r100), new j(r100));
    }

    @Override // hh5.c
    public final void registerChangeListener(dh5.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f485179a.registerChangeListener(r100);
    }

    @Override // hh5.c
    public final UserInfo t2(UserGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "userGroup");
        UserInfo r101 = new UserInfo();
        r101.setId(r100.f233642a);
        r101.setName(r100.f233643b);
        if (r100.f233644c != 1) goto L5;
        int r102 = 30;
    L6:
        r101.setOwnerType(r102);
        r101.setCan_modify_perm(true);
        return r101;
    L5:
        r102 = 22;
        goto L6
    }

    @Override // hh5.c
    public final void unregisterChangeListener(dh5.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f485179a.unregisterChangeListener(r100);
    }

    public e(dh5.b r100, ArrayList<UserInfo> r101, InviteMemberParams r102) {
        Intrinsics.checkNotNullParameter(r100, "selectedUserModel");
        Intrinsics.checkNotNullParameter(r101, "originUsers");
        Intrinsics.checkNotNullParameter(r102, "params");
        this.f485179a = r100;
        this.f485180b = r101;
        this.f485181c = r102;
    }
}
