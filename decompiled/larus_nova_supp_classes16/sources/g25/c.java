package g25;

import android.text.TextUtils;
import com.bytedance.ee.bear.document.render.core.offline.datapage.OfflineTransferModelV2;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerRunOnNotUIThread$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Executor;
import k25.e0;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements tb5.h<OfflineTransferModelV2> {
    public final String a;
    public final Executor b;

    @Override // tb5.h, tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerRunOnNotUIThread$CC.$default$authType(this);
    }

    public c(boolean r2) {
        this.a = "GetDataHandlerV2";
        if (r2 == false) goto L5;
        this.a = "GetDataHandlerV2_RN";
    L5:
        this.b = e0.r();
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final void handle(Object r17, final m r18) {
        final OfflineTransferModelV2 r11 = (OfflineTransferModelV2) r17;
        if (r11 != null) goto L5;
        o35.g.c(0, r18, this.a);
        tt5.a.k(this.a, "model is null.");
        return;
    L5:
        final long r6 = System.currentTimeMillis();
        final String r12 = r11.getObjToken();
        final String r13 = r11.getKey();
        final int r14 = r11.getPage();
        boolean r1 = TextUtils.isEmpty(r12);
        boolean r2 = TextUtils.isEmpty(r13);
        if (r1 == true) goto L9;
        if (r2 == true) goto L9;
        Flowable.just("").observeOn(Schedulers.from(this.b)).subscribe(new a(this, r13, r12, r14, r11, r6, r18), new b(this, r12, r13, r14, r11, r18));
        return;
    L9:
        o35.g.c(0, r18, this.a);
        tt5.a.k(this.a, "isTokenEmpty: " + r1 + " isResKeyEmpty: " + r2);
    }
}
