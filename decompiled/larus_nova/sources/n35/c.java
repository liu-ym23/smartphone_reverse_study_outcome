package n35;

import com.bytedance.ee.bear.document.offline.base.OfflineTransferModel;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import k25.m0;

/* JADX INFO: loaded from: classes16.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f516926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OfflineTransferModel f516927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList<String> f516928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ tb5.m f516929d;

    public c(b r100, OfflineTransferModel r101, ArrayList<String> r102, tb5.m r103) {
        this.f516926a = r100;
        this.f516927b = r101;
        this.f516928c = r102;
        this.f516929d = r103;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        b.c(this.f516926a, this.f516927b.getKey(), this.f516927b.getObjToken(), this.f516928c);
        int r102 = s.f516973a;
        m0 r103 = s.a(this.f516927b.getObjToken());
        StringBuilder r104 = new StringBuilder("keyMapResourceData ");
        if (r103 == null) goto L5;
        String r105 = r103.f501542c;
    L6:
        r104.append(du5.b.g(r105));
        tt5.a.d("CollectDataHandler", r104.toString());
        if (r103 == null) goto L9;
        b.c(this.f516926a, this.f516927b.getKey(), r103.f501542c, this.f516928c);
    L9:
        b.a(this.f516926a, this.f516927b, this.f516928c, this.f516929d);
        return;
    L5:
        r105 = null;
        goto L6
    }
}
