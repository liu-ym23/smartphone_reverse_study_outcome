package com.bytedance.ee.bear.middleground.permission.escape;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.escape.request.CreateInstanceResult;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f233853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g.a f233854b;

    public a(FragmentActivity r100, com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.l r101) {
        this.f233853a = r100;
        this.f233854b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.h("AdjustmentApiImpl", "create instance result: " + ((CreateInstanceResult) r100));
        Toast.cancelLoading();
        FragmentActivity r101 = this.f233853a;
        Toast.showSuccessText(r101, r101.getString(R.string.Doc_Share_AddCollaboratorSuccessfully));
        g.a r102 = this.f233854b;
        if (r102 == null) goto L6;
        r102.onSuccess();
        return;
    }
}
