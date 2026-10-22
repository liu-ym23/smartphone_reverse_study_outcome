package xy3;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class b<T> implements d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<T> f565403a;

    public b() {
        this.f565403a = new MutableLiveData();
    }

    @Override // xy3.d
    public final void p(LifecycleOwner r100, Observer<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r101, "observer");
        this.f565403a.observe(r100, r101);
    }
}
