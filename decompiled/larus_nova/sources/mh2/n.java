package mh2;

import android.widget.TextView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f513928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f513929b;

    public n(TextView r100, String r101) {
        this.f513928a = r100;
        this.f513929b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f513928a.setText(this.f513929b);
    }
}
