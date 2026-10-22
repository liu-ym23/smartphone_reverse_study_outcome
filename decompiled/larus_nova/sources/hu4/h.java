package hu4;

import com.bytedance.ee.bear.bitable.preload.util.BitablePreloadBridgeUtil;
import io.reactivex.functions.Consumer;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f487252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f487253b;

    public h(m r100, i r101) {
        this.f487252a = r100;
        this.f487253b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        BitablePreloadBridgeUtil.b(String.valueOf(r101), "", this.f487252a);
        tt5.a.e(this.f487253b.f487255b, "handle: ", r101, false);
    }
}
