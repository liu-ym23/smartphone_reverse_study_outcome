package com.bytedance.ee.bear.middleground.permission.escape;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ FragmentActivity a;
    public final /* synthetic */ g.a b;

    public b(FragmentActivity r1, com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.l r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        tt5.a.e("AdjustmentApiImpl", "create instance error!", r5, false);
        Toast.cancelLoading();
        FragmentActivity r0 = this.a;
        Toast.showFailureText(r0, r0.getString(2131888198));
        g.a r1 = this.b;
        if (r1 == null) goto L6;
        Intrinsics.checkNotNull(r5);
        r1.onFailed(r5);
        return;
    }
}
