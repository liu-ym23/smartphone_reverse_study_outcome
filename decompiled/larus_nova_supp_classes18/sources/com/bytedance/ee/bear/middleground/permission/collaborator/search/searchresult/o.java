package com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult;

import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteMemberParams;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.existmember.ExistMemberResult;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.existmember.Member;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.SearchUserResult;
import com.bytedance.ee.bear.share.export.UserInfo;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o<T, R> implements Function {
    public final /* synthetic */ m a;

    public o(m r1) {
        this.a = r1;
    }

    public final Object apply(Object r7) {
        SearchUserResult r8 = (SearchUserResult) r7;
        Intrinsics.checkNotNullParameter(r8, "userResult");
        m r0 = this.a;
        List<UserInfo> r1 = r0.c.w;
        if (r1 == null) goto L10;
        List<UserInfo> r2 = r1;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        UserInfo r5 = (UserInfo) r4.next();
        r3.add(new Member(r5.getOwnerType(), r5.getId()));
        goto L6
    L8:
        r8.existMembers = r3;
        return Flowable.just(r8);
    L10:
        if (r8.list.size() == 0) goto L24;
        if (r0.c.j == true) goto L24;
        ArrayList<UserInfo> r6 = r8.list;
        ArrayList r9 = new ArrayList();
        Iterator<UserInfo> r10 = r6.iterator();
    L16:
        if (r10.hasNext() == false) goto L19;
        UserInfo r11 = r10.next();
        r9.add(new Member(r11.getOwnerType(), r11.getId()));
        goto L16
    L19:
        if (r0.c.getType() != sbb.e.f.b) goto L21;
        InviteMemberParams r12 = r0.c;
        Flowable<ExistMemberResult> r13 = sg5.c.b(r12.a, r12.j, r9);
    L28:
        return r13.map(new q(r8)).onErrorReturn(new r(r8));
    L21:
        InviteMemberParams r14 = r0.c;
        r13 = sg5.c.a(r14.a, r14.getType(), r0.c.k, r9);
    L24:
        return Flowable.just(r8);
    }
}
