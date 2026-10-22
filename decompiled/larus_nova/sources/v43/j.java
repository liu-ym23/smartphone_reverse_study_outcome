package v43;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class j implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, q> f553071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, ? extends Object> f553072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, ? extends Object> f553073c;

    @Override // v43.r
    public final Map<String, q> u() {
        return this.f553071a;
    }

    public j(int r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        LinkedHashMap r102 = new LinkedHashMap();
        LinkedHashMap r103 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r101, "secondaryPageEventInfo");
        Intrinsics.checkNotNullParameter(r102, "carInfo");
        Intrinsics.checkNotNullParameter(r103, "poiInfo");
        this.f553071a = r101;
        this.f553072b = r102;
        this.f553073c = r103;
    }

    @Override // v43.r
    public final void k(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f553072b = r100;
    }

    @Override // v43.r
    public final void v(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f553073c = r100;
    }
}
