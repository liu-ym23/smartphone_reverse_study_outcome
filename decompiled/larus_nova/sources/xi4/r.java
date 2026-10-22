package xi4;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class r implements Function1<Long, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.creativex.mediaimport.view.internal.scroller.b f563942a;

    public r(com.bytedance.creativex.mediaimport.view.internal.scroller.b r100) {
        this.f563942a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Long r100) {
        Long r101 = r100;
        Intrinsics.checkNotNull(r101);
        r101.longValue();
        this.f563942a.f204070c.a();
        return Unit.INSTANCE;
    }
}
