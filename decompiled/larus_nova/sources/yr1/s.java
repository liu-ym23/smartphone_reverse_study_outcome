package yr1;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.NextLiveData;

/* JADX INFO: loaded from: classes8.dex */
public interface s {
    void a(DataCenter r100, Observer<KVData> r101);

    boolean c(DataCenter r100);

    NextLiveData<Boolean> d();

    MutableLiveData<Boolean> f();

    void g(DataCenter r100, Observer<KVData> r101);

    void h(DataCenter r100, int r101);
}
