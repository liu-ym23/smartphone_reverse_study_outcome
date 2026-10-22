package lc5;

import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b<T> implements Consumer {
    public static final b<T> a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final void accept(Object r2) {
        SimpleRequestResult r3 = (SimpleRequestResult) r2;
        tt5.a.h("ListAnalysis", "reportFolderOpenClick success");
    }
}
