package ju4;

import com.bytedance.ee.bear.bitable.pro.applypro.BitableApplyProFragment;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableApplyProFragment f500490a;

    public h(BitableApplyProFragment r100) {
        this.f500490a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        BitableApplyProFragment.V90(this.f500490a, true);
        tt5.a.e("BitableApplyProFragment", "get permission code err  ", (Throwable) r100, false);
    }
}
