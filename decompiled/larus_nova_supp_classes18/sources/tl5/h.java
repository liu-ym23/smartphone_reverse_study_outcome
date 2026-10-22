package tl5;

import com.bytedance.ee.bear.contract.n;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import io.reactivex.Flowable;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h implements tb5.i<String> {
    public static final /* synthetic */ int b = 0;
    public final CopyOnWriteArrayList<n.d> a;

    public static final class a {
    }

    static {
    }

    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2.-CC.$default$authType(this);
    }

    public h() {
        this.a = new CopyOnWriteArrayList();
    }

    public final void handle(Object r2, m r3) {
        String r4 = (String) r2;
        Intrinsics.checkNotNullParameter(r3, "callback");
        StringBuilder r5 = new StringBuilder("handle()... data nul is ");
        if (r4 != null) goto L5;
        boolean r0 = true;
    L6:
        r5.append(r0);
        tt5.a.b("SendDataToNativeHandler", r5.toString());
        if (r4 == null) goto L10;
        Flowable.just("").observeOn(fo5.d.a()).subscribe(new i(this, r4), j.a);
        return;
    L10:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
