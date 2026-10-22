package us4;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.bitable.homepage.preview.BoostViewData;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f551485a;

    public d(a r100) {
        this.f551485a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        int r101 = a.f551480c;
        tt5.a.h("BitableBoostDataSource", "loadBoostData>> success");
        MutableLiveData<BoostViewData> r102 = this.f551485a.f551481a;
        r102.postValue((BoostViewData) r100);
    }
}
