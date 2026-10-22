package lg5;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.BatchAuthorizeActivity;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements Observer<Boolean> {
    public final /* synthetic */ BatchAuthorizeActivity a;

    public i(BatchAuthorizeActivity r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Boolean r4 = (Boolean) r3;
        BatchAuthorizeActivity r5 = this.a;
        r5.i.cancelBatchAuthorize((ArrayList) r5.h.getData(), Boolean.TRUE);
    }
}
