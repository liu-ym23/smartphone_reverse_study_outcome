package hh5;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.GetUserGroupResult;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class k implements ax4.e<GetUserGroupResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.g f485188a;

    public k(com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.g r100) {
        this.f485188a = r100;
    }

    @Override // ax4.e
    public final void onFailed(Throwable r100) {
        Context r101 = this.f485188a.f233674c;
        Toast.showFailureText(r101, r101.getString(R.string.Doc_Facade_OperateFailed));
        this.f485188a.f233673b.hideLoading();
    }

    @Override // ax4.e
    public final void onSuccess(GetUserGroupResult r100) {
        GetUserGroupResult r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "result");
        com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.g r102 = this.f485188a;
        r102.f233673b.hideLoading();
        if (hu5.a.f(r101.getVisibleGroups()) == false) goto L6;
        r102.f233673b.Y2(r101);
        return;
    }
}
