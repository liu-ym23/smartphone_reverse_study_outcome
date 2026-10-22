package ju1;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class r extends n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f500414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f500415d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<o> f500416e;

    @Override // ju1.n
    public final Object c() {
        return Integer.valueOf(this.f500414c);
    }

    public r(int r100, boolean r101, Map<String, ? extends Object> r102, List<o> r103) {
        Intrinsics.checkNotNullParameter(r102, "statusMap");
        super(Integer.valueOf(r100), r101);
        this.f500414c = r100;
        this.f500415d = r102;
        this.f500416e = r103;
    }
}
