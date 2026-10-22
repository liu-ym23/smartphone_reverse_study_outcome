package com.ss.android.lark.photoeditor.impl.ui;

import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes37.dex */
public final class f implements Consumer<Throwable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.InterfaceC5241a f438577a;

    public f(m.a r100) {
        this.f438577a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable r100) throws Exception {
        Log.e("PhotoEditorModel", UIHelper.getString(R.string.Lark_Legacy_SaveFail) + " : " + r100.toString());
        a.InterfaceC5241a r101 = this.f438577a;
        String r102 = UIHelper.getString(R.string.Lark_Legacy_SaveFail);
        m.a r103 = (m.a) r101;
        r103.f438593c.f438590a.getView().K3();
        r103.f438593c.f438590a.getView().showToast(r102);
    }
}
