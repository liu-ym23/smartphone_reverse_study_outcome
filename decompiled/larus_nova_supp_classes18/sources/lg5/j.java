package lg5;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.BatchAuthorizeActivity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements Observer<Boolean> {
    public final /* synthetic */ BatchAuthorizeActivity a;

    public j(BatchAuthorizeActivity r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Boolean r4 = (Boolean) r3;
        tt5.a.b("BatchAuthorizeActivity", "getHasPages onchanges " + r4);
        this.a.m.b(0, false);
        this.a.m.g(r4.booleanValue());
    }
}
