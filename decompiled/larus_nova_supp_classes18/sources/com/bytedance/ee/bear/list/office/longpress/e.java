package com.bytedance.ee.bear.list.office.longpress;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ com.bytedance.ee.bear.more.office.c a;
    public final /* synthetic */ Context b;

    public e(com.bytedance.ee.bear.more.office.c r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        tt5.a.e("OfficeAddShortcutAction", "fetch wiki shortcut permission failed. actionId=" + this.a.a, (Throwable) r4, false);
        Toast.cancelLoading();
        Toast.showFailureText(this.b, 2131887802);
        b r5 = b.a;
        CompositeDisposable r6 = b.c.remove(this.a.a);
        if (r6 == null) goto L6;
        r6.clear();
        return;
    }
}
