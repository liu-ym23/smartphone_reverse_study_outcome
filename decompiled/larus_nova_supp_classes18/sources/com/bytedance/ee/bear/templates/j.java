package com.bytedance.ee.bear.templates;

import android.app.Application;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ Function0<Unit> a;

    public j(Function0<Unit> r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Result r3 = (Result) r2;
        TemplateReport.b("delete");
        Application r4 = eu5.b.a;
        Toast.showSuccessText(r4, r4.getText(2131887740));
        this.a.invoke();
    }
}
