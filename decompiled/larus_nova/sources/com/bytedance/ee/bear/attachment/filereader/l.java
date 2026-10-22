package com.bytedance.ee.bear.attachment.filereader;

import android.net.Uri;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.supervisor.token.Token;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FileReaderActivity f206404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Uri f206405b;

    public l(FileReaderActivity r100, Uri r101) {
        this.f206404a = r100;
        this.f206405b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((Boolean) r100).booleanValue() == false) goto L5;
        FileReaderActivity r101 = this.f206404a;
        Toast.showSuccessText(r101, r101.getString(R.string.Doc_Attachment_SaveSuccessfully), 0);
        com.larksuite.framework.utils.i.i(this.f206404a.getApplicationContext(), this.f206405b, new Token("LARK-PSDA-ccm_android_file_reader_save_video_notify_system"));
        return;
    L5:
        FileReaderActivity r102 = this.f206404a;
        Toast.showFailureText(r102, r102.getString(R.string.Doc_Facade_SaveFailed), 0);
        tt5.a.d("FileReaderActivity", "   save video fail");
    }
}
