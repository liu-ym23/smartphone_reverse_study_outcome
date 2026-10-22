package i65;

import androidx.lifecycle.MutableLiveData;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f488432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f488433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f488434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<String> f488435d;

    public b(String r100) {
        this.f488432a = r100;
        this.f488434c = new CompositeDisposable();
        this.f488435d = new MutableLiveData();
    }
}
