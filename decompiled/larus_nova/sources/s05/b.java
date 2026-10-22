package s05;

import com.bytedance.ee.bear.document.doccomponent.impl.AbsDocComponentImpl;
import com.bytedance.ee.bear.route.h;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f540015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbsDocComponentImpl f540016b;

    public b(boolean r100, AbsDocComponentImpl r101) {
        this.f540015a = r100;
        this.f540016b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        h r101 = (h) r100;
        Intrinsics.checkNotNullParameter(r101, "routeService");
        if (this.f540015a == false) goto L5;
        r101.Td(this.f540016b.f219530d);
        return;
    L5:
        r101.s5(this.f540016b.f219530d);
    }
}
