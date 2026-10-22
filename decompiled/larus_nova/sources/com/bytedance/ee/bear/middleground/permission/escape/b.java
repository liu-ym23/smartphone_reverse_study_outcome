package com.bytedance.ee.bear.middleground.permission.escape;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f233855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g.a f233856b;

    public b(FragmentActivity r100, com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.l r101) {
        this.f233855a = r100;
        this.f233856b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        tt5.a.e("AdjustmentApiImpl", "create instance error!", r101, false);
        Toast.cancelLoading();
        FragmentActivity r102 = this.f233855a;
        Toast.showFailureText(r102, r102.getString(R.string.Doc_Share_AddCollaboratorFailed));
        g.a r103 = this.f233856b;
        if (r103 == null) goto L6;
        Intrinsics.checkNotNull(r101);
        r103.onFailed(r101);
        return;
    }
}
