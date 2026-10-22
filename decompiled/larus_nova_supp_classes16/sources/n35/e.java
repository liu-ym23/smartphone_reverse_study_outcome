package n35;

import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.document.offline.base.OfflineTransferModel;
import com.bytedance.ee.bear.document.render.core.offline.CollectResultModel;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerRunOnNotUIThread$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.ss.android.lark.vfs.VFSFile;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import k25.e0;
import k25.e1;
import k25.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements tb5.h<OfflineTransferModel> {
    public final Executor a;

    public static final class a {
    }

    static {
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerRunOnNotUIThread$CC.$default$authType(this);
    }

    public e() {
        this.a = e0.r();
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final void handle(Object r5, tb5.m r6) {
        OfflineTransferModel r7 = (OfflineTransferModel) r5;
        StringBuilder r0 = new StringBuilder("CollectDataHandlerV2 objToken: ");
        String r1 = null;
        if (r7 == null) goto L5;
        String r2 = r7.getObjToken();
    L6:
        r0.append(du5.b.g(r2));
        r0.append(" , category : ");
        if (r7 == null) goto L9;
        r1 = r7.getCategory();
    L9:
        r0.append(r1);
        tt5.a.d("CollectDataHandlerV2", r0.toString());
        ArrayList r3 = new ArrayList();
        if (r7 == null) goto L28;
        String r4 = r7.getCategory();
        boolean r8 = true;
        if (r4 != null) goto L14;
    L17:
        boolean r9 = true;
    L18:
        if (r9 == true) goto L29;
        String r10 = r7.getObjToken();
        if (r10 != null) goto L22;
    L25:
        if (r8 == true) goto L30;
        Flowable.just("").observeOn(Schedulers.from(this.a)).subscribe(new f(this, r7, r3, r6), new g(this, r7, r3, r6));
        return;
    L30:
        return;
    L22:
        if (r10.length() == 0) goto L25;
        r8 = false;
        goto L25
    L29:
        return;
    L14:
        if (r4.length() == 0) goto L17;
        r9 = false;
        goto L18
    L28:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public static final void a(e r2, OfflineTransferModel r3, ArrayList r4, tb5.m r5) {
        r2.getClass();
        StringBuilder r6 = new StringBuilder("onResult ");
        String r0 = null;
        if (r3 == null) goto L5;
        String r1 = r3.getCategory();
    L6:
        r6.append(du5.b.g(r1));
        r6.append("  ");
        if (r3 == null) goto L9;
        r0 = r3.getObjToken();
    L9:
        r6.append(du5.b.g(r0));
        r6.append(' ');
        r6.append(r4.size());
        tt5.a.d("CollectDataHandlerV2", r6.toString());
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

    public static final void c(e r6, String r7, String r8, ArrayList r9) {
        r6.getClass();
        e0 r10 = e0.m();
        r10.getClass();
        m0 r11 = r10.q().e().j(r8, r7);     // Catch: Exception -> L5
    L8:
        if (r11 == null) goto L16;
        StringBuilder r1 = new StringBuilder("selectDbAndFile it.resvalue1: ");
        String r2 = r11.c;
        if (r2 == null) goto L12;
        Integer r3 = Integer.valueOf(r2.length());
    L13:
        r1.append(r3);
        tt5.a.d("CollectDataHandlerV2", r1.toString());
        String r12 = r11.c;
        if (r12 == null) goto L16;
        r9.add(r12);
        goto L16
    L12:
        r3 = null;
    L16:
        e1 r13 = e0.m().b;
        r13.getClass();
        ArrayList r4 = new ArrayList();
        VFSFile r5 = ay4.d.a().i(r13.b);
        if (r5.isDirectory() == false) goto L28;
        File[] r14 = r5.listFiles();
        if (r14 == null) goto L28;
        StringBuilder r16 = new StringBuilder();
        StringBuilder r17 = new StringBuilder();
        r17.append(r8);
        r17.append(r7);
        int r18 = 0;
        r17.append(0);
        r16.append(du5.d.a(r17.toString()));
        r16.append(OfflineDoc.DASH_DELIMITER);
        String r19 = r16.toString();
        int r20 = r14.length;
    L23:
        if (r18 >= r20) goto L28;
        File r21 = r14[r18];
        if (r21.getName().startsWith(r19) == false) goto L27;
        r4.add(r13.e(r21.getVfsPath().getRealPath()));
    L27:
        r18 = r18 + 1;
    L28:
        tt5.a.d("CollectDataHandlerV2", "selectDbAndFile it.resvalue2: " + r4.size());
        if (r4.size() <= 0) goto L37;
        r9.addAll(r4);
        return;
    L37:
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
        r11 = new m0();
        goto L8
    }
}
