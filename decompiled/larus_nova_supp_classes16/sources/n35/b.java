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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements tb5.h<OfflineTransferModel> {
    public final Executor a;

    public static final class a {
    }

    static {
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerRunOnNotUIThread$CC.$default$authType(this);
    }

    public b() {
        this.a = e0.r();
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final void handle(Object r5, tb5.m r6) {
        OfflineTransferModel r7 = (OfflineTransferModel) r5;
        StringBuilder r0 = new StringBuilder("CollectDataHandler ");
        if (r7 == null) goto L5;
        String r1 = r7.getKey();
    L6:
        r0.append(du5.b.g(r1));
        r0.append(' ');
        tt5.a.d("CollectDataHandler", r0.toString());
        ArrayList r2 = new ArrayList();
        if (r7 == null) goto L25;
        String r3 = r7.getKey();
        boolean r4 = true;
        if (r3 != null) goto L11;
    L14:
        boolean r8 = true;
    L15:
        if (r8 == true) goto L26;
        String r9 = r7.getObjToken();
        if (r9 != null) goto L19;
    L22:
        if (r4 == true) goto L27;
        Flowable.just("").observeOn(Schedulers.from(this.a)).subscribe(new c(this, r7, r2, r6), new d(this, r7, r2, r6));
        return;
    L27:
        return;
    L19:
        if (r9.length() == 0) goto L22;
        r4 = false;
        goto L22
    L26:
        return;
    L11:
        if (r3.length() == 0) goto L14;
        r8 = false;
        goto L15
    L25:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static final void a(b r2, OfflineTransferModel r3, ArrayList r4, tb5.m r5) {
        r2.getClass();
        StringBuilder r6 = new StringBuilder("onResult ");
        String r0 = null;
        if (r3 == null) goto L5;
        String r1 = r3.getKey();
    L6:
        r6.append(du5.b.g(r1));
        r6.append("  ");
        if (r3 == null) goto L9;
        r0 = r3.getObjToken();
    L9:
        r6.append(du5.b.g(r0));
        r6.append(' ');
        r6.append(r4.size());
        tt5.a.d("CollectDataHandler", r6.toString());
        CollectResultModel r7 = new CollectResultModel(0, "success", r4);
        if (r5 == null) goto L13;
        r5.onCallBack(r7.toString());
        return;
    L13:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static final void c(b r4, String r5, String r6, ArrayList r7) {
        r4.getClass();
        m0 r8 = e0.m().A(r5, r6, 0);
        if (r8 == null) goto L9;
        StringBuilder r2 = new StringBuilder("selectDbAndFile it.resvalue1: ");
        String r3 = r8.c;
        if (r3 == null) goto L7;
        Integer r9 = Integer.valueOf(r3.length());
    L8:
        r2.append(r9);
        tt5.a.d("CollectDataHandler", r2.toString());
        r7.add(r8.c);
        goto L9
    L7:
        r9 = null;
    L9:
        e1 r10 = e0.m().b;
        r10.getClass();
        StringBuilder r11 = new StringBuilder();
        r11.append(du5.d.a(r5 + r6 + 0));
        r11.append(r10.a);
        String r12 = r10.e(ay4.d.a().u(r10.b, r11.toString()).getRealPath());
        if (r12 == null) goto L13;
        tt5.a.d("CollectDataHandler", "selectDbAndFile it.resvalue2: " + r12.length());
        r7.add(r12);
        return;
    }
}
