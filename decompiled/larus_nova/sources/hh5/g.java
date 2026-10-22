package hh5;

import com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.GetUserGroupResult;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GetUserGroupResult f485184a;

    public g(GetUserGroupResult r100) {
        this.f485184a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        tt5.a.d("UserGroupModel", "getExistMember error: " + r101);
        return this.f485184a;
    }
}
