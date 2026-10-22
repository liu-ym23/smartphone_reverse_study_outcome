package com.bytedance.ee.bear.middleground.permission.collaborator.search.department;

import android.content.Context;
import android.os.Parcelable;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteMemberParams;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.existmember.ExistMemberResult;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.existmember.Member;
import com.bytedance.ee.bear.share.export.UserInfo;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements ch5.e {
    public final dh5.b a;
    public final ArrayList<UserInfo> b;
    public final InviteMemberParams c;
    public VisibleDepartment d;
    public int e;
    public Disposable f;
    public final HashMap<String, Department> g;

    public static final class a {
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        public final Object apply(Object r7) {
            Department r8 = (Department) r7;
            Intrinsics.checkNotNullParameter(r8, "department");
            c r0 = this.a;
            if (r0.c.j == true) goto L23;
            if (r8.getVisibleDepartments().size() == 0) goto L7;
        L9:
            ArrayList r1 = new ArrayList();
            Iterator<T> r2 = r8.getVisibleDepartments().iterator();
        L11:
            if (r2.hasNext() == false) goto L13;
            r1.add(new Member(18, ((VisibleDepartment) r2.next()).a));
            goto L11
        L13:
            Iterator<T> r3 = r8.getVisibleTopUserInDep().iterator();
        L15:
            if (r3.hasNext() == false) goto L18;
            r1.add(new Member(0, ((VisibleTopUserInDep) r3.next()).a));
            goto L15
        L18:
            if (r0.c.getType() != sbb.e.f.b) goto L20;
            InviteMemberParams r4 = r0.c;
            Flowable<ExistMemberResult> r5 = sg5.c.b(r4.a, r4.j, r1);
        L26:
            return r5.map(new ch5.a(r8)).onErrorReturn(new ch5.b(r8));
        L20:
            InviteMemberParams r6 = r0.c;
            r5 = sg5.c.a(r6.a, r6.getType(), r0.c.k, r1);
            goto L26
        L7:
            if (r8.getVisibleTopUserInDep().size() != 0) goto L9;
        L23:
            return Flowable.just(r8);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.permission.collaborator.search.department.c$c, reason: collision with other inner class name */
    public static final class C0096c<T> implements Consumer {
        public final /* synthetic */ ax4.e<Department> a;
        public final /* synthetic */ c b;

        public C0096c(ax4.e<Department> r1, c r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Department r4 = (Department) r3;
            tt5.a.h("DepartmentModel", "loadFromNet()...Succeed");
            this.a.onSuccess(r4);
            c r0 = this.b;
            if (r0.e != 0) goto L6;
            r0.g.put(r0.d.a, r4);
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ ax4.e<Department> a;

        public d(ax4.e<Department> r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            tt5.a.d("DepartmentModel", "loadFromNet()...Failed: " + r4);
            this.a.onFailed(r4);
        }
    }

    static {
    }

    public final void create() {
    }

    @Override // ch5.e
    public final ArrayList<VisibleTopUserInDep> O1() {
        ArrayList<VisibleTopUserInDep> r0 = new ArrayList();
        Iterator<T> r1 = this.a.getSelected().iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        UserInfo r2 = (UserInfo) r1.next();
        if (r2.getOwnerType() == 1) goto L9;
        if (r2.getOwnerType() != 0) goto L4;
    L9:
        r0.add(u2(r2));
        goto L4
    L10:
        return r0;
    }

    public final void destroy() {
        Disposable r0 = this.f;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L13;
        Disposable r2 = this.f;
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

    @Override // ch5.e
    public final ArrayList<VisibleDepartment> r6() {
        ArrayList<VisibleDepartment> r0 = new ArrayList();
        Iterator<T> r1 = this.a.getSelected().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        UserInfo r2 = (UserInfo) r1.next();
        if (r2.getOwnerType() != 18) goto L4;
        r0.add(M2(r2));
        goto L4
    L8:
        return r0;
    }

    @Override // ch5.e
    public final ArrayList<UserInfo> m0() {
        return this.b;
    }

    @Override // ch5.e
    public final UserInfo K6(VisibleDepartment r3) {
        Intrinsics.checkNotNullParameter(r3, "visibleDepartment");
        UserInfo r0 = new UserInfo();
        r0.setId(r3.a);
        r0.setAvatarUrl(r3.c);
        r0.setName(r3.b);
        r0.setOwnerType(18);
        r0.setCan_modify_perm(true);
        return r0;
    }

    @Override // ch5.e
    public final VisibleDepartment M2(UserInfo r6) {
        Intrinsics.checkNotNullParameter(r6, "userInfo");
        String r0 = r6.getId();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r2 = r6.getName(((i0) org.koin.java.a.c(i0.class, null, null, 6)).a());
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        String r7 = r6.getAvatarUrl();
        if (r7 == null) goto L13;
        r1 = r7;
    L13:
        return new VisibleDepartment(r0, r2, r1);
    }

    @Override // ch5.e
    public final UserInfo Y6(VisibleTopUserInDep r3) {
        Intrinsics.checkNotNullParameter(r3, "visibleTopUserInDep");
        UserInfo r0 = new UserInfo();
        r0.setId(r3.a);
        r0.setAvatarUrl(r3.c);
        r0.setName(r3.b);
        r0.setOwnerType(0);
        r0.setCan_modify_perm(true);
        return r0;
    }

    public final void h(ax4.e<Department> r5) {
        NetService.f r0 = new NetService.f("/space/api/suite/visible_department/");
        r0.b("department_id", this.d.a);
        r0.b("visible_type", "3");
        r0.b("offset", String.valueOf(this.e));
        r0.b("count", "50");
        r0.b("need_paging", "true");
        ((NetService.e) r0).c = 2;
        this.f = ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new ch5.c()).a(r0).flatMap(new b(this)).subscribe(new C0096c(r5, this), new d(r5));
    }

    @Override // ch5.e
    public final void i(UserInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "userInfo");
        this.a.removeUser(r2);
    }

    @Override // ch5.e
    public final void l(UserInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "userInfo");
        this.a.addUser(r2);
    }

    @Override // ch5.e
    public final void q6(ch5.d r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        tt5.a.h("DepartmentModel", "loadMore()...");
        this.e += 50;
        h(r3);
    }

    @Override // ch5.e
    public final void registerChangeListener(dh5.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a.registerChangeListener(r2);
    }

    @Override // ch5.e
    public final VisibleTopUserInDep u2(UserInfo r6) {
        Intrinsics.checkNotNullParameter(r6, "userInfo");
        String r0 = r6.getId();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r2 = r6.getName(((i0) org.koin.java.a.c(i0.class, null, null, 6)).a());
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        String r7 = r6.getAvatarUrl();
        if (r7 == null) goto L13;
        r1 = r7;
    L13:
        return new VisibleTopUserInDep(r0, r2, r1);
    }

    @Override // ch5.e
    public final void unregisterChangeListener(dh5.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a.unregisterChangeListener(r2);
    }

    @Override // ch5.e
    public final void V7(VisibleDepartment r4, com.bytedance.ee.bear.middleground.permission.collaborator.search.department.d.c r5) {
        Intrinsics.checkNotNullParameter(r4, "visibleDepartment");
        Intrinsics.checkNotNullParameter(r5, "callback");
        tt5.a.h("DepartmentModel", "loadData()...");
        Disposable r1 = this.f;
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L12;
        Disposable r3 = this.f;
        if (r3 == null) goto L12;
        r3.dispose();
    L12:
        this.d = r4;
        this.e = 0;
        Department r6 = this.g.get(r4.a);
        if (r6 == null) goto L15;
        tt5.a.h("DepartmentModel", "loadFromCache()...");
        r5.onSuccess(r6);
        return;
    L15:
        h(r5);
        return;
    L5:
        if (r1.isDisposed() == true) goto L7;
        r2 = true;
        goto L8
    }

    public c(Context r2, dh5.b r3, ArrayList<UserInfo> r4, InviteMemberParams r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "selectedUserModel");
        Intrinsics.checkNotNullParameter(r4, "originUsers");
        Intrinsics.checkNotNullParameter(r5, "params");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        Parcelable.Creator<VisibleDepartment> r6 = VisibleDepartment.CREATOR;
        this.d = VisibleDepartment.a.a(r2);
        this.g = new HashMap();
    }
}
