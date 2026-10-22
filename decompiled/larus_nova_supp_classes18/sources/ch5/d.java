package ch5;

import com.bytedance.ee.bear.middleground.permission.collaborator.search.department.Department;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements ax4.e<Department> {
    public final /* synthetic */ com.bytedance.ee.bear.middleground.permission.collaborator.search.department.d a;

    public d(com.bytedance.ee.bear.middleground.permission.collaborator.search.department.d r1) {
        this.a = r1;
    }

    public final void onFailed(Throwable r1) {
        this.a.c.t7();
    }

    public final void onSuccess(Object r2) {
        Department r3 = (Department) r2;
        Intrinsics.checkNotNullParameter(r3, "result");
        this.a.c.X0(r3);
        this.a.c.d0(r3.getHasMore());
    }
}
