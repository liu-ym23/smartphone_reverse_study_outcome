package li5;

import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j<T> implements Consumer {
    public static final j<T> a = null;

    static {
        a = new j();
    }

    public j() {
    }

    public final void accept(Object r2) {
        SimpleRequestResult r3 = (SimpleRequestResult) r2;
        tt5.a.h("DocPermissionManager", "sendNotifyRequest()...Success");
    }
}
