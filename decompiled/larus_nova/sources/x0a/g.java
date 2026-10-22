package x0a;

import com.larus.ugc.feed.impl.quickmenu.DismissReason;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class g implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<DismissReason, Unit> f562064a;

    public g(com.larus.ugc.feed.impl.quickmenu.doSame.d r100) {
        this.f562064a = r100;
    }

    @Override // x0a.b
    public final void a(DismissReason r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        this.f562064a.invoke(r100);
    }
}
