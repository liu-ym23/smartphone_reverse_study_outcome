package com.bytedance.ee.bear.middleground.permission.escape;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.escape.request.CreateInstanceResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ FragmentActivity a;
    public final /* synthetic */ g.a b;

    public a(FragmentActivity r1, com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.l r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        tt5.a.h("AdjustmentApiImpl", "create instance result: " + ((CreateInstanceResult) r3));
        Toast.cancelLoading();
        FragmentActivity r4 = this.a;
        Toast.showSuccessText(r4, r4.getString(2131888199));
        g.a r5 = this.b;
        if (r5 == null) goto L6;
        r5.onSuccess();
        return;
    }
}
