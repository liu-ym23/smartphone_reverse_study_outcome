package na3;

import com.bytedance.android.shopping.buynow.cache.UltimateBuyCacheQueryHelper;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import java.util.concurrent.Callable;
import ma3.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e<V> implements Callable {
    public final /* synthetic */ q a;
    public final /* synthetic */ UltimateBuyCacheQueryHelper b;
    public final /* synthetic */ com.bytedance.android.shopping.buynow.starter.e c;

    public e(q r1, UltimateBuyCacheQueryHelper r2, com.bytedance.android.shopping.buynow.starter.e r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.util.concurrent.Callable
    public final ObservableSource<? extends la3.b> call() {
        q r0 = this.a;
        if (r0 == null) goto L21;
        UltimateBuyCacheQueryHelper r1 = this.b;
        if (r1 == null) goto L13;
        com.bytedance.android.shopping.buynow.starter.c r2 = this.c.d;
        if (r2 == null) goto L9;
        String r3 = r2.a;
    L10:
        if (r3 != null) goto L12;
        r3 = "";
    L12:
        r1.d = new com.bytedance.android.shopping.buynow.starter.d(r3, r0.b, r0.a, true, null, null, r0.d, true, r0.e, 16);
        goto L13
    L9:
        r3 = null;
    L13:
        ma3.b r4 = r0.a;
        String r5 = r0.b;
        int r6 = r0.d;
        if (r0.e == false) goto L16;
        int r7 = 1;
    L17:
        Observable r8 = Observable.just(new la3.b(r4, r5, r6, r7));
        if (r8 == null) goto L21;
        return r8;
    L16:
        r7 = 2;
    L21:
        return Observable.empty();
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
