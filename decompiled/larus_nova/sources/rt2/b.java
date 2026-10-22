package rt2;

import com.bytedance.android.livesdkapi.ws.LiveWsBridge;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import zg1.k1;

/* JADX INFO: loaded from: classes11.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f539173a;

    public b(a r100) {
        this.f539173a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((k1) r100).f571866a == false) goto L16;
        h r101 = this.f539173a.f539171e;
        if ((r101 instanceof h) == true) goto L7;
        r101 = null;
    L7:
        if (r101 == null) goto L17;
        Intrinsics.checkNotNullParameter("login status changed", "reason");
        f.a("ws diconnect due to login status changed");
        LiveWsBridge r102 = r101.f539176a;
        if (r102 == null) goto L11;
        r102.unregisterChannel();
    L11:
        com.ss.ugc.live.sdk.msg.unify.network.d r103 = r101.f539177b;
        if (r103 == null) goto L14;
        r103.b("login status changed");
    L14:
        r101.f539177b = null;
        return;
    L17:
        return;
    }
}
