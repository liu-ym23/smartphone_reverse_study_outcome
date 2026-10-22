package ch5;

import com.bytedance.ee.bear.middleground.permission.collaborator.invite.existmember.ExistMemberResult;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.existmember.Member;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.department.Department;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a<T, R> implements Function {
    public final /* synthetic */ Department a;

    public a(Department r1) {
        this.a = r1;
    }

    public final Object apply(Object r3) {
        ExistMemberResult r4 = (ExistMemberResult) r3;
        Intrinsics.checkNotNullParameter(r4, "existMemberResult");
        tt5.a.h("DepartmentModel", "getExistMember(): " + r4.getExistMembers());
        ArrayList<Member> r0 = new ArrayList();
        r0.addAll(r4.getExistMembers());
        this.a.setExistsMembers(r0);
        return this.a;
    }
}
