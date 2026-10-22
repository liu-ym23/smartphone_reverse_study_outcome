package ju4;

import com.bytedance.ee.bear.bitable.pro.applypro.BitableApplyProFragment;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ BitableApplyProFragment a;

    public h(BitableApplyProFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        BitableApplyProFragment.V90(this.a, true);
        tt5.a.e("BitableApplyProFragment", "get permission code err  ", (Throwable) r4, false);
    }
}
