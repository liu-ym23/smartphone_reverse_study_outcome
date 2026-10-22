package ic5;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final /* synthetic */ class c implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f489170a;

    public /* synthetic */ c(MediatorLiveData r100) {
        this.f489170a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        this.f489170a.postValue((List) r100);
    }
}
