package hd5;

import ax4.d;
import com.bytedance.ee.bear.contract.d0;
import io.reactivex.functions.Consumer;
import lc5.f;
import lc5.o;

/* JADX INFO: loaded from: classes18.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f484598a;

    public b(d0 r100) {
        this.f484598a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (d.b((Throwable) r100, 4007) == false) goto L5;
        String r101 = "failed_cross_unit";
    L6:
        String r102 = r101;
        f.a r103 = f.f508440a;
        com.bytedance.ee.bear.contract.d r104 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        d0 r105 = this.f484598a;
        String r106 = r105.f216963h;
        if (r106 != null) goto L9;
        r106 = "";
    L9:
        String r107 = r105.f216962g;
        if (r107 != null) goto L12;
        r107 = "";
    L12:
        int r108 = r105.getType();
        String r109 = this.f484598a.f216957b;
        if (r109 != null) goto L15;
        String r110 = "";
    L16:
        f.a.H(new o(r104, r106, r107, r102, r108, r110));
        return;
    L15:
        r110 = r109;
        goto L16
    L5:
        r101 = "failed";
        goto L6
    }
}
