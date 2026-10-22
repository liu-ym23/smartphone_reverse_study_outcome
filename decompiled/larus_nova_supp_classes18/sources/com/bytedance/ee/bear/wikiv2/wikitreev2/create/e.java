package com.bytedance.ee.bear.wikiv2.wikitreev2.create;

import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ Function0<Unit> a;
    public final /* synthetic */ WikiCreateToFragment b;

    public e(Function0<Unit> r1, WikiCreateToFragment r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        if (((WikNodePerm) r2).can_create == false) goto L5;
        this.a.invoke();
        return;
    L5:
        Toast.showFailureText(this.b.getContext(), 2131888937);
    }
}
