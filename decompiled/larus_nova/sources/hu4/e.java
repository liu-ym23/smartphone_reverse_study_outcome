package hu4;

import com.bytedance.ee.bear.bitable.preload.bean.BitableOfflineTransferModel;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class e<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f487248a;

    public e(i r100) {
        this.f487248a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        BitableOfflineTransferModel r101 = (BitableOfflineTransferModel) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        i r102 = this.f487248a;
        r102.getClass();
        if (r101 == null) goto L12;
        String r103 = r101.getResValue();
        if (r103 == null) goto L10;
        if (r103.length() <= r102.f487256c) goto L10;
        iu5.d.a(r102.f487255b, new Throwable("data length: " + Integer.valueOf(r103.length()) + ',' + du5.b.g(r101.getBitableToken()) + ',' + r101.getResKey()));
    L10:
        return r101.parseResourceData(r102.f487254a);
    L12:
        throw new Throwable("BitableSetDataHandler.handle: data is null");
    }
}
