package s33;

import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.android.shopping.abscontainer.arch.core.lifecycle.LifecycleEnum;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import w33.g;

/* JADX INFO: loaded from: classes12.dex */
public final class a<STATE extends g, PROPS extends u33.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<LifecycleEnum, c> f540455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b<STATE, PROPS>> f540456b;

    public /* synthetic */ a() {
        this(MapsKt.emptyMap(), CollectionsKt.emptyList());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Map<LifecycleEnum, c> r100, List<? extends b<STATE, PROPS>> r101) {
        Intrinsics.checkNotNullParameter(r100, "priorityConfig");
        Intrinsics.checkNotNullParameter(r101, IPerformanceManager.Params.modules);
        this.f540455a = r100;
        this.f540456b = r101;
    }
}
