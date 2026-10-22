package com.bytedance.ee.bear.templates;

import android.app.Application;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k<T> f239121a = null;

    static {
        f239121a = new k();
    }

    public k() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.f("TemplateUtils", (Throwable) r100, false);
        Application r101 = eu5.b.f474075a;
        Toast.showFailureText(r101, r101.getText(R.string.Doc_Facade_DeleteFailedNoNet));
    }
}
