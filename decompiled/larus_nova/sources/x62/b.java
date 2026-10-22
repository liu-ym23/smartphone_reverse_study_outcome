package x62;

import android.text.SpannableStringBuilder;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observer;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f562596a;

    public b(c r100) {
        this.f562596a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Observer<? super CharSequence> r100 = this.f562596a.f562598b;     // Catch: Throwable -> L9
        if (r100 == null) goto L12;
        CharSequence r101 = this.f562596a.f562599c.getText();     // Catch: Throwable -> L9
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        r100.onNext(new SpannableStringBuilder(r101));     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
