package ju1;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class g extends n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f500408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f500409d;

    public g(int r100, boolean r101, Map<String, ? extends Object> r102, List<String> r103) {
        Intrinsics.checkNotNullParameter(r102, "statusMap");
        Intrinsics.checkNotNullParameter(r103, "relatedFactors");
        super(Integer.valueOf(r100), r101);
        this.f500408c = r102;
        this.f500409d = r103;
    }
}
