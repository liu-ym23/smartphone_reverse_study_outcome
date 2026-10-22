package p30;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f527545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f527546b;

    public final String getType() {
        return this.f527545a;
    }

    public q(String r100, Map<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.f527545a = "";
        this.f527545a = r100;
        this.f527546b = r101;
    }
}
