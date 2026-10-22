package hh5;

import com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.GetUserGroupResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ ax4.e<GetUserGroupResult> a;

    public i(k r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        tt5.a.h("UserGroupModel", "loadFromNet()...Succeed");
        ax4.e<GetUserGroupResult> r0 = this.a;
        r0.onSuccess((GetUserGroupResult) r3);
    }
}
