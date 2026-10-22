package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b0<T> implements Consumer {
    public final /* synthetic */ Context a;
    public final /* synthetic */ t b;

    public b0(Context r1, t r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        tt5.a.d("WikiFolderBlockMoreViewDelegate", "moveToSpace()...failed, error = " + r4);
        Toast.cancelLoading();
        if (tp5.b.b(r4, 920003005) == false) goto L6;
        Toast.showFailureText(this.a, this.b.d.getString(2131887487));
        return;
    L6:
        if (tp5.b.b(r4, 920004117) == false) goto L9;
        Toast.showFailureText(this.a, this.b.d.getString(2131887483));
        return;
    L9:
        if (tp5.b.b(r4, 920004118) == false) goto L12;
        Toast.showFailureText(this.a, this.b.d.getString(2131887485));
        return;
    L12:
        if (tp5.b.b(r4, 920004119) == false) goto L15;
        Toast.showFailureText(this.a, this.b.d.getString(2131887486));
        return;
    L15:
        if ((r4 instanceof TimeoutException) == false) goto L17;
        Toast.showFailureText(this.a, this.b.d.getString(2131887484));
        return;
    L17:
        Toast.showFailureText(this.a, this.b.d.getString(2131887932));
    }
}
