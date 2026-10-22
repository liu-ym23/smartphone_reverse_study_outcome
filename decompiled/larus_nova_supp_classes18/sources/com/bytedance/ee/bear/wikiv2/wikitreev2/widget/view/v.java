package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v<T> implements Consumer {
    public final /* synthetic */ Context a;
    public final /* synthetic */ t b;
    public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j c;

    public v(Context r1, t r2, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        tt5.a.d("WikiFolderBlockMoreViewDelegate", "getMoveNodeAuthorizedUserInfo()...failed, error = " + r5);
        Toast.cancelLoading();
        if (tp5.b.b(r5, 920004109) == false) goto L6;
        Toast.showFailureText(this.a, this.b.d.getString(2131887492));
        return;
    L6:
        if (tp5.b.b(r5, 920004112) == false) goto L8;
        Context r6 = this.a;
        Toast.showFailureText(r6, xo5.a.c(r6, 2131887495, ResourceData.KEY_PAGE, this.c.e));
        return;
    L8:
        Toast.showFailureText(this.a, this.b.d.getString(2131887672));
    }
}
