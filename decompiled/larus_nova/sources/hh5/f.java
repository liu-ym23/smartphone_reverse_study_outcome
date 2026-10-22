package hh5;

import com.bytedance.ee.bear.middleground.permission.collaborator.invite.existmember.ExistMemberResult;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.GetUserGroupResult;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GetUserGroupResult f485183a;

    public f(GetUserGroupResult r100) {
        this.f485183a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        ExistMemberResult r101 = (ExistMemberResult) r100;
        Intrinsics.checkNotNullParameter(r101, "existMemberResult");
        tt5.a.h("UserGroupModel", "getExistMember(): " + r101.getExistMembers());
        this.f485183a.setExistsMembers(r101.getExistMembers());
        return this.f485183a;
    }
}
