package com.bytedance.ee.bear.templates;

import android.app.Application;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k<T> implements Consumer {
    public static final k<T> a = null;

    static {
        a = new k();
    }

    public k() {
    }

    public final void accept(Object r3) {
        tt5.a.f("TemplateUtils", (Throwable) r3, false);
        Application r4 = eu5.b.a;
        Toast.showFailureText(r4, r4.getText(2131887739));
    }
}
