package com.bytedance.ee.bear.list.office.longpress;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i0<T> implements Consumer {
    public final /* synthetic */ String a;
    public final /* synthetic */ FragmentActivity b;
    public final /* synthetic */ Fragment c;

    public i0(String r1, FragmentActivity r2, Fragment r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r4) {
        tt5.a.e("OfficeSecretSettingActionExecutor", "fetch doc meta info failed.", (Throwable) r4, false);
        if (g0.a(g0.a, this.a, this.b, this.c) == false) goto L5;
        g0.k(this.a);
        Toast.showFailureText(this.b, 2131887384);
    L5:
        g0.p(this.a);
    }
}
