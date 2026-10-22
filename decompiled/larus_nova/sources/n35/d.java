package n35;

import com.bytedance.ee.bear.document.offline.base.OfflineTransferModel;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes16.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f516930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OfflineTransferModel f516931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList<String> f516932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ tb5.m f516933d;

    public d(b r100, OfflineTransferModel r101, ArrayList<String> r102, tb5.m r103) {
        this.f516930a = r100;
        this.f516931b = r101;
        this.f516932c = r102;
        this.f516933d = r103;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        b.a(this.f516930a, this.f516931b, this.f516932c, this.f516933d);
    }
}
