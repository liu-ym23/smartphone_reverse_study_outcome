package o29;

import com.larus.community.impl.quickmenu.DismissReason;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class g implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<DismissReason, Unit> f521803a;

    public g(com.larus.community.impl.quickmenu.doSame.d r100) {
        this.f521803a = r100;
    }

    @Override // o29.b
    public final void a(DismissReason r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        this.f521803a.invoke(r100);
    }
}
