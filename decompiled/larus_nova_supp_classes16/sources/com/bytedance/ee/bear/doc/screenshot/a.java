package com.bytedance.ee.bear.doc.screenshot;

import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements DocShotPresenter.b {
    public final /* synthetic */ DocShotPresenter a;

    public a(DocShotPresenter r1) {
        this.a = r1;
    }

    public final void a(boolean r4) {
        if (r4 == false) goto L9;
        Toast.showSuccessText(this.a.c(), this.a.c().getString(2131887687), 0);
        this.a.getClass();
        HashMap r5 = new HashMap();     // Catch: Exception -> L7
        r5.put(JSEventListener.ACTION, "download");     // Catch: Exception -> L7
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).v("click_long_image_share", r5);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        tt5.a.f("DocShotPresenter", e, false);
        return;
    L9:
        Toast.showSuccessText(this.a.c(), this.a.c().getString(2131887819), 0);
    }
}
