package com.ss.android.lark.photoeditor.impl.ui;

import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import io.reactivex.functions.Consumer;
import java.io.File;

/* JADX INFO: loaded from: classes37.dex */
public final class e implements Consumer<File> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.InterfaceC5241a f438576a;

    public e(m.a r100) {
        this.f438576a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(File r100) throws Exception {
        File r101 = r100;
        Log.i("PhotoEditorModel", UIHelper.getString(R.string.Lark_Legacy_SuccessfulSaved) + " : " + r101.getAbsolutePath());
        m.a r102 = (m.a) this.f438576a;
        r102.f438593c.f438590a.getView().K3();
        r102.f438593c.f438590a.getModel().g5(r101, new l(r102, r101));
    }
}
