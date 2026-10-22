package com.bytedance.ee.bear.list.create;

import android.content.Context;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f227717a;

    public c(Context r100) {
        this.f227717a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        SimpleRequestResult r101 = (SimpleRequestResult) r100;
        Intrinsics.checkNotNullParameter(r101, "result");
        if (r101.code != 0) goto L5;
        Toast.showSuccessText(this.f227717a, R.string.Doc_Facade_Reminded);
        return;
    L5:
        Toast.showFailureText(this.f227717a, R.string.Doc_Facade_OperateFailed);
    }
}
