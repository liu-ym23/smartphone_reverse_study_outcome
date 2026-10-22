package ti5;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.transfer.TransferApplyFragment;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ TransferApplyFragment a;

    public e(TransferApplyFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Boolean r2 = (Boolean) r1;
        Toast.cancelLoading();
        TransferApplyFragment.aa0(this.a);
    }
}
