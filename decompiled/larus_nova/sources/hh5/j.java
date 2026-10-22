package hh5;

import com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.GetUserGroupResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ax4.e<GetUserGroupResult> f485187a;

    public j(k r100) {
        this.f485187a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        tt5.a.d("UserGroupModel", "loadFromNet()...Failed: " + r101);
        this.f485187a.onFailed(r101);
    }
}
