package com.bytedance.ee.bear.list.create;

import android.content.Context;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ Context a;

    public c(Context r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        SimpleRequestResult r3 = (SimpleRequestResult) r2;
        Intrinsics.checkNotNullParameter(r3, "result");
        if (((Result) r3).code != 0) goto L5;
        Toast.showSuccessText(this.a, 2131887808);
        return;
    L5:
        Toast.showFailureText(this.a, 2131887802);
    }
}
