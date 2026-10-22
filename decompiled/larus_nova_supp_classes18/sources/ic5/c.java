package ic5;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class c implements Observer {
    public final /* synthetic */ MediatorLiveData a;

    public /* synthetic */ c(MediatorLiveData r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        this.a.postValue((List) r2);
    }
}
