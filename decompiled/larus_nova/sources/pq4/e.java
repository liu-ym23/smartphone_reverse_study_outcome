package pq4;

import com.bytedance.ee.bear.share.IShareMeta;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e<T> f530282a = null;

    static {
        f530282a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        IShareMeta r101 = (IShareMeta) r100;
        tt5.a.h("ShareMetaFetcher", "fetchShareRecordToken done");
    }
}
