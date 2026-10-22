package lc5;

import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b<T> f508435a = null;

    static {
        f508435a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        SimpleRequestResult r101 = (SimpleRequestResult) r100;
        tt5.a.h("ListAnalysis", "reportFolderOpenClick success");
    }
}
