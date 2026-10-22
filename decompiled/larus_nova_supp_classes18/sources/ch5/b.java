package ch5;

import com.bytedance.ee.bear.middleground.permission.collaborator.search.department.Department;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b<T, R> implements Function {
    public final /* synthetic */ Department a;

    public b(Department r1) {
        this.a = r1;
    }

    public final Object apply(Object r3) {
        Throwable r4 = (Throwable) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        tt5.a.d("DepartmentModel", "getExistMember error: " + r4);
        return this.a;
    }
}
