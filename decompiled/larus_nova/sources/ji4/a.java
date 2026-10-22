package ji4;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.creativex.mediaimport.view.internal.viewmodel.v;
import ki4.r;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends v<r> implements fi4.c<r> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<Boolean> f499193b;

    public a() {
        this.f499193b = new MutableLiveData();
        new MutableLiveData();
    }

    @Override // fi4.c
    public final MutableLiveData va() {
        return this.f499193b;
    }

    @Override // fi4.c
    public final void ua(boolean r100) {
        if (Intrinsics.areEqual(this.f499193b.getValue(), Boolean.valueOf(r100)) == true) goto L6;
        this.f499193b.setValue(Boolean.valueOf(r100));
        return;
    }
}
