package hh5;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.GetUserGroupResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k implements ax4.e<GetUserGroupResult> {
    public final /* synthetic */ com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.g a;

    public k(com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.g r1) {
        this.a = r1;
    }

    public final void onFailed(Throwable r2) {
        Context r3 = this.a.c;
        Toast.showFailureText(r3, r3.getString(2131887802));
        this.a.b.hideLoading();
    }

    public final void onSuccess(Object r3) {
        GetUserGroupResult r4 = (GetUserGroupResult) r3;
        Intrinsics.checkNotNullParameter(r4, "result");
        com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.g r0 = this.a;
        r0.b.hideLoading();
        if (hu5.a.f(r4.getVisibleGroups()) == false) goto L6;
        r0.b.Y2(r4);
        return;
    }
}
