package qb8;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class g implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f532417a;

    public /* synthetic */ g(Ref.IntRef r100) {
        this.f532417a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        Ref.IntRef r101 = this.f532417a;
        en8.a r102 = (en8.a) r100;
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        int r103 = r101.element;
        r101.element = r103 + 1;
        r102.getClass();
        r102.f473209j = RangesKt.coerceAtLeast(r103, 1);
        return Unit.INSTANCE;
    }
}
