package qi4;

import com.baidu.platform.comapi.map.MapController;
import java.util.List;
import java.util.Map;
import ki4.a0;
import ki4.m;
import ki4.r;
import ki4.z;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements ki4.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ki4.d f533137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<a0, Class<? extends m>> f533138b;

    @Override // ki4.d
    public final List<z> c() {
        return this.f533137a.c();
    }

    @Override // ki4.k
    public final List<a0> e(r r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return this.f533137a.e(r100);
    }

    @Override // ki4.d
    public final Function1<a0, Class<? extends m>> d() {
        return new a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(ki4.d r100, Map<a0, ? extends Class<? extends m>> r101) {
        Intrinsics.checkNotNullParameter(r100, "categoryStrategy");
        Intrinsics.checkNotNullParameter(r101, "groupStrategies");
        this.f533137a = r100;
        this.f533138b = r101;
    }
}
