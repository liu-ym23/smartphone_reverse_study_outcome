package xy3;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class b<T> implements d<T> {
    public final MutableLiveData<T> a;

    public b() {
        this.a = new MutableLiveData();
    }

    @Override // xy3.d
    public final void p(LifecycleOwner r2, Observer<T> r3) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.a.observe(r2, r3);
    }
}
