package com.bytedance.ee.bear.templates;

import android.app.Application;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes18.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f239120a;

    public j(Function0<Unit> r100) {
        this.f239120a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Result r101 = (Result) r100;
        TemplateReport.b("delete");
        Application r102 = eu5.b.f474075a;
        Toast.showSuccessText(r102, r102.getText(R.string.Doc_Facade_DeleteSuccess));
        this.f239120a.invoke();
    }
}
