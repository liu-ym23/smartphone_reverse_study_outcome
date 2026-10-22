package xi4;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class q implements Function1<Long, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.creativex.mediaimport.view.internal.scroller.b f563941a;

    public q(com.bytedance.creativex.mediaimport.view.internal.scroller.b r100) {
        this.f563941a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Long r100) {
        Long r101 = r100;
        Intrinsics.checkNotNull(r101);
        r101.longValue();
        ti4.e r102 = this.f563941a.f204077j;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("scrollHandleView");
        r102 = null;
    L6:
        r102.setVisible(false);
        return Unit.INSTANCE;
    }
}
