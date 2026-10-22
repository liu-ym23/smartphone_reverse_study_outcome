package s05;

import com.bytedance.ee.bear.document.doccomponent.impl.AbsDocComponentImpl;
import com.bytedance.ee.bear.route.h;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ AbsDocComponentImpl b;

    public b(boolean r1, AbsDocComponentImpl r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        h r3 = (h) r2;
        Intrinsics.checkNotNullParameter(r3, "routeService");
        if (this.a == false) goto L5;
        r3.Td(this.b.d);
        return;
    L5:
        r3.s5(this.b.d);
    }
}
