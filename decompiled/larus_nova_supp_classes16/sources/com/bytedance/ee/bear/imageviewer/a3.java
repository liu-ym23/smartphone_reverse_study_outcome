package com.bytedance.ee.bear.imageviewer;

import android.net.Uri;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.supervisor.token.Token;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a3 implements c3.f {
    public final /* synthetic */ c3 a;

    public a3(c3 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.imageviewer.c3.f
    public final void onFailed(Throwable r4) {
        Toast.showFailureText(this.a.getContext(), this.a.b.getString(2131887819), 0);
        tt5.a.e("ImageViewer", "downloadDiagram failed, [image export]", r4, false);
    }

    @Override // com.bytedance.ee.bear.imageviewer.c3.f
    public final void onSuccess(Uri r4) {
        ((com.bytedance.ee.bear.attachment.filereader.a) org.koin.java.a.a(com.bytedance.ee.bear.attachment.filereader.a.class)).a();
        if (r4 == null) goto L6;
        com.larksuite.framework.utils.i.i(this.a.getContext(), r4, new Token("LARK-PSDA-ccm_android_imageviewer_save_diagram_notify_system"));
        return;
    }
}
