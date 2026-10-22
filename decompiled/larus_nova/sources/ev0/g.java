package ev0;

import android.net.Uri;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profit.taskcenter.k;
import com.bytedance.android.live.profit.taskcenter.panel.model.PanelInfo;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes47.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f474204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PanelInfo f474205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f474206c;

    public g(c r100, PanelInfo r101, Map r102) {
        this.f474204a = r100;
        this.f474205b = r101;
        this.f474206c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        PanelInfo.State r101 = (PanelInfo.State) r100;
        if (r101 == null) goto L10;
        int r102 = d.f474201a[r101.ordinal()];
        Uri r103 = null;
        if (r102 != 1) goto L8;
        this.f474204a.getClass();
        c.a("observePanelState subscribe State.READY");
        RxUtilKt.c(RxUtilKt.h(Observable.timer(((Number) k.f89035e.getValue(null, k.f89031a[3])).longValue(), TimeUnit.SECONDS)).takeUntil(this.f474205b.f89043b.filter(e.f474202a)).subscribe(new f(this)), this.f474204a.f474196a);
        return;
    L8:
        if (r102 == 2) goto L12;
        if (r102 != 3) goto L10;
        this.f474204a.getClass();
        c.a("observePanelState subscribe State.DISMISSED");
        this.f474204a.f474197b.remove(this.f474205b);
        this.f474204a.e();
        return;
    L12:
        int r104 = hv0.a.f487275a;
        PanelInfo r105 = this.f474204a.f474197b.peek();
        if (r105 == null) goto L15;
        r103 = r105.f89045d;
    L15:
        hv0.a.b(1, c.c(r103), this.f474204a.f474197b.size());
        c r106 = this.f474204a;
        fv0.a r107 = this.f474205b.f89048g;
        r106.getClass();
        c.a("updateFrequency");
        Iterator r108 = ((ArrayList) r106.f474199d).iterator();
    L17:
        if (r108.hasNext() == false) goto L24;
        ((a) r108.next()).a(r107);
        goto L17
    L24:
        return;
    L10:
        this.f474204a.getClass();
        c.a("observePanelState subscribe " + r101);
    }
}
