package w48;

import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import v48.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class g implements e {
    public final /* synthetic */ Function2<String, String, Unit> a;

    /* JADX WARN: Multi-variable type inference failed */
    public g(Function2<? super String, ? super String, Unit> r1) {
        this.a = r1;
    }

    @Override // v48.e
    public final void onGetId(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "did");
        Intrinsics.checkNotNullParameter(r3, "iid");
        Intrinsics.checkNotNullParameter(r4, "ssid");
        com.larus.applog.impl.a.f(r2, r3, "onGetId");
        this.a.invoke(r2, r3);
        Intrinsics.checkNotNullParameter(this, "listener");
        ((CopyOnWriteArrayList) com.larus.applog.impl.a.b).remove(this);
    }
}
