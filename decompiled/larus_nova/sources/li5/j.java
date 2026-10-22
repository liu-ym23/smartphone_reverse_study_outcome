package li5;

import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j<T> f509367a = null;

    static {
        f509367a = new j();
    }

    public j() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        SimpleRequestResult r101 = (SimpleRequestResult) r100;
        tt5.a.h("DocPermissionManager", "sendNotifyRequest()...Success");
    }
}
