package n35;

import com.bytedance.ee.bear.document.offline.base.OfflineTransferModel;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes16.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f516939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OfflineTransferModel f516940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList<String> f516941c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ tb5.m f516942d;

    public g(e r100, OfflineTransferModel r101, ArrayList<String> r102, tb5.m r103) {
        this.f516939a = r100;
        this.f516940b = r101;
        this.f516941c = r102;
        this.f516942d = r103;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        e.a(this.f516939a, this.f516940b, this.f516941c, this.f516942d);
    }
}
