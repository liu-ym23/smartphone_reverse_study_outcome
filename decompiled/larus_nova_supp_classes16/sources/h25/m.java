package h25;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import k25.e0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class m implements tb5.i<OfflineDoc> {
    public final String a;
    public n b;
    public boolean c;

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public m(String r3) {
        this.a = "Offline#Sync#";
        this.c = false;
        String r4 = "Offline#Sync#" + r3 + Integer.toHexString(hashCode());
        this.a = r4;
        tt5.a.h(r4, "construct");
    }

    private void update(OfflineDoc r2) {
        ((nw4.b) LarkContext.spiByDwarf(nw4.b.class)).e();
        ((rc5.a) org.koin.java.a.a(rc5.a.class)).handleSyncedDoc(r2);
        n r0 = this.b;
        if (r0 == null) goto L5;
        r0.handleSyncedDoc(r2);
        return;
    L5:
        tt5.a.h(this.a, "OfflineSyncDocHandler handle: mListener is null");
    }

    public final void c(final OfflineDoc r3) {
        if (idb.f.a().isEnable("ccm.mobile.db_error_optimization") == false) goto L6;
        Flowable.just("").observeOn(Schedulers.from(e0.r())).map(new j(r3)).subscribe(new k(this), new l(this));
        return;
    }

    public static Integer a(m r6, OfflineDoc r7) {
        r6.getClass();
        String r0 = r7.getFakeToken();
        if (TextUtils.isEmpty(r0) == false) goto L5;
        tt5.a.k(r6.a, "The fake token is null.");
    L5:
        e0 r1 = e0.m();
        r1.getClass();
        List<Integer> r2 = r1.q().e().h(r0);     // Catch: Exception -> L8
    L11:
        if (hu5.a.d(r2) == false) goto L15;
        tt5.a.k(r6.a, "empty resource data and the fake token is " + du5.b.g(r0));
        tt5.a.h(r6.a, "mHasRetry: " + r6.c);
        if (r6.c == true) goto L15;
        r6.c = true;
        return -200;
    L15:
        e0 r3 = e0.m();
        String r4 = r7.getObj_token();
        String r5 = r7.getToken();
        r3.getClass();
        int r8 = r3.q().e().q(r4, r5, r2);     // Catch: Exception -> L18
    L20:
        tt5.a.h(r6.a, "accept: ret=" + r8 + "--idList size=" + r2.size());
        if (r8 <= 0) goto L23;
        r6.update(r7);
    L24:
        r6.c(r7);
        return Integer.valueOf(r8);
    L23:
        iu5.d.a(r6.a, new Throwable("Failed to update fake token: " + r0 + "--objToken: " + du5.b.g(r7.getObj_token()) + "--token: " + du5.b.g(r7.getToken())));
    L18:
        e = move-exception;
        iu5.d.c(e);
        r8 = -1;
    L8:
        e = move-exception;
        iu5.d.c(e);
        r2 = new ArrayList();
        goto L11
    }

    public final void d(final OfflineDoc r4, final tb5.m r5) {
        Flowable.just("").observeOn(Schedulers.from(e0.r())).map(new f(this, r4)).observeOn(fo5.d.d()).subscribe(new g(this, r5, r4), new h(this, r4, r5));
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r4, tb5.m r5) {
        OfflineDoc r6 = (OfflineDoc) r4;
        tt5.a.h(this.a, "handle:" + r6);
        if (r6 == null) goto L7;
        d(r6, r5);
        return;
    }
}
