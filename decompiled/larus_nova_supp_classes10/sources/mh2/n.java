package mh2;

import android.widget.TextView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ TextView a;
    public final /* synthetic */ String b;

    public n(TextView r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        this.a.setText(this.b);
    }
}
