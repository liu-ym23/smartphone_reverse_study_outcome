package dx;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f470410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f470411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f470412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f470413d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f470414e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f470415f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Object> f470416g;

    public c() {
        throw null;
    }

    public final String toString() {
        return "LatchResult(statusCode=" + this.f470410a + ", transferType='" + this.f470412c + "', cached=" + this.f470411b + ", errMsg='" + this.f470413d + "', timeout=" + this.f470414e + ", engineType=" + this.f470415f + ", extras=" + this.f470416g + ')';
    }

    public c(int r100, int r101, String r102, String r103, int r104, String r105) {
        LinkedHashMap r106 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r102, "transferType");
        Intrinsics.checkNotNullParameter(r103, "errMsg");
        Intrinsics.checkNotNullParameter(r105, "engineType");
        Intrinsics.checkNotNullParameter(r106, "extras");
        this.f470410a = r100;
        this.f470411b = r101;
        this.f470412c = r102;
        this.f470413d = r103;
        this.f470414e = r104;
        this.f470415f = r105;
        this.f470416g = r106;
    }
}
