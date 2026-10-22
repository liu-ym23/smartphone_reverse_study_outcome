package tl5;

import com.bytedance.ee.bear.contract.n;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import io.reactivex.Flowable;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: classes18.dex */
public final class h implements tb5.i<String> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f546630b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<n.d> f546631a;

    public static final class a {
    }

    static {
    }

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public h() {
        this.f546631a = new CopyOnWriteArrayList();
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r100, m r101) {
        String r102 = (String) r100;
        Intrinsics.checkNotNullParameter(r101, "callback");
        StringBuilder r103 = new StringBuilder("handle()... data nul is ");
        if (r102 != null) goto L5;
        boolean r104 = true;
    L6:
        r103.append(r104);
        tt5.a.b("SendDataToNativeHandler", r103.toString());
        if (r102 == null) goto L10;
        Flowable.just("").observeOn(fo5.d.a()).subscribe(new i(this, r102), j.f546634a);
        return;
    L10:
        return;
    L5:
        r104 = false;
        goto L6
    }
}
