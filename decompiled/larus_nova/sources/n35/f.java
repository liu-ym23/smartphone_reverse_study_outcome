package n35;

import com.bytedance.ee.bear.document.offline.base.OfflineTransferModel;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import k25.m0;

/* JADX INFO: loaded from: classes16.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f516935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OfflineTransferModel f516936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList<String> f516937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ tb5.m f516938d;

    public f(e r100, OfflineTransferModel r101, ArrayList<String> r102, tb5.m r103) {
        this.f516935a = r100;
        this.f516936b = r101;
        this.f516937c = r102;
        this.f516938d = r103;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        e r102 = this.f516935a;
        this.f516936b.getKey();
        e.c(r102, this.f516936b.getObjToken(), this.f516936b.getCategory(), this.f516937c);
        int r103 = s.f516973a;
        m0 r104 = s.a(this.f516936b.getObjToken());
        StringBuilder r105 = new StringBuilder("keyMapResourceData ");
        if (r104 == null) goto L5;
        String r106 = r104.f501542c;
    L6:
        r105.append(du5.b.g(r106));
        tt5.a.d("CollectDataHandlerV2", r105.toString());
        if (r104 == null) goto L9;
        e r107 = this.f516935a;
        this.f516936b.getKey();
        e.c(r107, r104.f501542c, this.f516936b.getCategory(), this.f516937c);
    L9:
        e.a(this.f516935a, this.f516936b, this.f516937c, this.f516938d);
        return;
    L5:
        r106 = null;
        goto L6
    }
}
