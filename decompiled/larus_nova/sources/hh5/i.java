package hh5;

import com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.GetUserGroupResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ax4.e<GetUserGroupResult> f485186a;

    public i(k r100) {
        this.f485186a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.h("UserGroupModel", "loadFromNet()...Succeed");
        ax4.e<GetUserGroupResult> r101 = this.f485186a;
        r101.onSuccess((GetUserGroupResult) r100);
    }
}
