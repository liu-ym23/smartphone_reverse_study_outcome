package hh5;

import com.bytedance.ee.bear.middleground.permission.collaborator.invite.existmember.ExistMemberResult;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.GetUserGroupResult;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f<T, R> implements Function {
    public final /* synthetic */ GetUserGroupResult a;

    public f(GetUserGroupResult r1) {
        this.a = r1;
    }

    public final Object apply(Object r3) {
        ExistMemberResult r4 = (ExistMemberResult) r3;
        Intrinsics.checkNotNullParameter(r4, "existMemberResult");
        tt5.a.h("UserGroupModel", "getExistMember(): " + r4.getExistMembers());
        this.a.setExistsMembers(r4.getExistMembers());
        return this.a;
    }
}
