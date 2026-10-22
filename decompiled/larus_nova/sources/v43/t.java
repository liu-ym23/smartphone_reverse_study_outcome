package v43;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<u> f553081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<u> f553082b;

    public t(int r100) {
        List<u> r101 = CollectionsKt.emptyList();
        List<u> r102 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r101, "globalTrigger");
        Intrinsics.checkNotNullParameter(r102, "moduleTrigger");
        this.f553081a = r101;
        this.f553082b = r102;
    }
}
