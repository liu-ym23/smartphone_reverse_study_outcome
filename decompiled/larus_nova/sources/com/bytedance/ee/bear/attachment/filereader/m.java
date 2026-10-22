package com.bytedance.ee.bear.attachment.filereader;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FileReaderActivity f206406a;

    public m(FileReaderActivity r100) {
        this.f206406a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        FileReaderActivity r102 = this.f206406a;
        Toast.showFailureText(r102, r102.getString(R.string.Doc_Facade_SaveFailed), 0);
        tt5.a.d("FileReaderActivity", "   save video fail");
    }
}
