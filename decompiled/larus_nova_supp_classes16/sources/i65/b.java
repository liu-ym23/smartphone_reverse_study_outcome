package i65;

import androidx.lifecycle.MutableLiveData;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public final String a;
    public a b;
    public final CompositeDisposable c;
    public final MutableLiveData<String> d;

    public b(String r1) {
        this.a = r1;
        this.c = new CompositeDisposable();
        this.d = new MutableLiveData();
    }
}
