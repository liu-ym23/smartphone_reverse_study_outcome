package com.bytedance.ee.bear.list.create;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ Context a;

    public d(Context r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Toast.showFailureText(this.a, 2131887802);
        tt5.a.e("CreateErrorDialogUtils", "executeRemindAdmin() error:", (Throwable) r4, false);
    }
}
