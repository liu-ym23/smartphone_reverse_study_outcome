package us4;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class o<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f551506a;

    public o(l r100) {
        this.f551506a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("BitableBoostViewContainer", "createBitableByTemplate failed", (Throwable) r100, false);
        Toast.showFailureText(this.f551506a.getContext(), R.string.Doc_Facade_CreateFailed);
        this.f551506a.d();
    }
}
