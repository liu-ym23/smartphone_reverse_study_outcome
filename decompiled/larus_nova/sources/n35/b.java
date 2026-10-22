package n35;

import com.bytedance.ee.bear.document.offline.base.OfflineTransferModel;
import com.bytedance.ee.bear.document.render.core.offline.CollectResultModel;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerRunOnNotUIThread$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import k25.e0;
import k25.e1;
import k25.m0;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements tb5.h<OfflineTransferModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f516925a;

    public static final class a {
    }

    static {
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerRunOnNotUIThread$CC.$default$authType(this);
    }

    public b() {
        this.f516925a = e0.r();
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final void handle(Object r100, tb5.m r101) {
        OfflineTransferModel r102 = (OfflineTransferModel) r100;
        StringBuilder r103 = new StringBuilder("CollectDataHandler ");
        if (r102 == null) goto L5;
        String r104 = r102.getKey();
    L6:
        r103.append(du5.b.g(r104));
        r103.append(' ');
        tt5.a.d("CollectDataHandler", r103.toString());
        ArrayList r105 = new ArrayList();
        if (r102 == null) goto L25;
        String r106 = r102.getKey();
        boolean r107 = true;
        if (r106 != null) goto L11;
    L14:
        boolean r108 = true;
    L15:
        if (r108 == true) goto L26;
        String r109 = r102.getObjToken();
        if (r109 != null) goto L19;
    L22:
        if (r107 == true) goto L27;
        Flowable.just("").observeOn(Schedulers.from(this.f516925a)).subscribe(new c(this, r102, r105, r101), new d(this, r102, r105, r101));
        return;
    L27:
        return;
    L19:
        if (r109.length() == 0) goto L22;
        r107 = false;
        goto L22
    L26:
        return;
    L11:
        if (r106.length() == 0) goto L14;
        r108 = false;
        goto L15
    L25:
        return;
    L5:
        r104 = null;
        goto L6
    }

    public static final void a(b r100, OfflineTransferModel r101, ArrayList r102, tb5.m r103) {
        r100.getClass();
        StringBuilder r104 = new StringBuilder("onResult ");
        String r105 = null;
        if (r101 == null) goto L5;
        String r106 = r101.getKey();
    L6:
        r104.append(du5.b.g(r106));
        r104.append(tb2.c.DEFAULT_TEXT);
        if (r101 == null) goto L9;
        r105 = r101.getObjToken();
    L9:
        r104.append(du5.b.g(r105));
        r104.append(' ');
        r104.append(r102.size());
        tt5.a.d("CollectDataHandler", r104.toString());
        CollectResultModel r107 = new CollectResultModel(0, "success", r102);
        if (r103 == null) goto L13;
        r103.onCallBack(r107.toString());
        return;
    L13:
        return;
    L5:
        r106 = null;
        goto L6
    }

    public static final void c(b r100, String r101, String r102, ArrayList r103) {
        r100.getClass();
        m0 r104 = e0.m().A(r101, r102, 0);
        if (r104 == null) goto L9;
        StringBuilder r105 = new StringBuilder("selectDbAndFile it.resvalue1: ");
        String r106 = r104.f501542c;
        if (r106 == null) goto L7;
        Integer r107 = Integer.valueOf(r106.length());
    L8:
        r105.append(r107);
        tt5.a.d("CollectDataHandler", r105.toString());
        r103.add(r104.f501542c);
        goto L9
    L7:
        r107 = null;
    L9:
        e1 r108 = e0.m().f501512b;
        r108.getClass();
        StringBuilder r109 = new StringBuilder();
        r109.append(du5.d.a(r101 + r102 + 0));
        r109.append(r108.f501518a);
        String r110 = r108.e(ay4.d.a().u(r108.f501519b, r109.toString()).getRealPath());
        if (r110 == null) goto L13;
        tt5.a.d("CollectDataHandler", "selectDbAndFile it.resvalue2: " + r110.length());
        r103.add(r110);
        return;
    }
}
