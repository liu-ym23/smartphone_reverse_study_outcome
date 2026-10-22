package ti5;

import com.bytedance.ee.bear.middleground.permission.transfer.TransferApplyFragment;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ TransferApplyFragment a;

    public g(TransferApplyFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Boolean r3 = (Boolean) r2;
        TransferApplyFragment r0 = this.a;
        Intrinsics.checkNotNull(r3);
        r0.k = r3.booleanValue();
    }
}
