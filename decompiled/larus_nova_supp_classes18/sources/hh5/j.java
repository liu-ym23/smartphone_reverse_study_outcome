package hh5;

import com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.GetUserGroupResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ ax4.e<GetUserGroupResult> a;

    public j(k r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        tt5.a.d("UserGroupModel", "loadFromNet()...Failed: " + r4);
        this.a.onFailed(r4);
    }
}
