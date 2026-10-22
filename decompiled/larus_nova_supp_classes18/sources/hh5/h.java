package hh5;

import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteMemberParams;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.existmember.ExistMemberResult;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.existmember.Member;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.GetUserGroupResult;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.UserGroup;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h<T, R> implements Function {
    public final /* synthetic */ e a;

    public h(e r1) {
        this.a = r1;
    }

    public final Object apply(Object r8) {
        GetUserGroupResult r9 = (GetUserGroupResult) r8;
        Intrinsics.checkNotNullParameter(r9, "result");
        e r0 = this.a;
        if (r0.c.j == true) goto L21;
        if (hu5.a.d(r9.getVisibleGroups()) == true) goto L21;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r9.getVisibleGroups().iterator();
    L9:
        if (r2.hasNext() == false) goto L16;
        UserGroup r3 = (UserGroup) r2.next();
        if (r3.c != 1) goto L13;
        int r5 = 30;
    L14:
        r1.add(new Member(r5, r3.a));
        goto L9
    L13:
        r5 = 22;
        goto L14
    L16:
        if (r0.c.getType() != sbb.e.f.b) goto L18;
        InviteMemberParams r4 = r0.c;
        Flowable<ExistMemberResult> r6 = sg5.c.b(r4.a, r4.j, r1);
    L25:
        return r6.map(new f(r9)).onErrorReturn(new g(r9));
    L18:
        InviteMemberParams r7 = r0.c;
        r6 = sg5.c.a(r7.a, r7.getType(), r0.c.k, r1);
    L21:
        return Flowable.just(r9);
    }
}
