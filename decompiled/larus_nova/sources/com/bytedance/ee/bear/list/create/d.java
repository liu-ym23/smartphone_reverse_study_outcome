package com.bytedance.ee.bear.list.create;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f227718a;

    public d(Context r100) {
        this.f227718a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Toast.showFailureText(this.f227718a, R.string.Doc_Facade_OperateFailed);
        tt5.a.e("CreateErrorDialogUtils", "executeRemindAdmin() error:", (Throwable) r100, false);
    }
}
