package qc4;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f532472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f532473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f532474c;

    public final String toString() {
        return "CheckResult(code=" + this.f532473b + ", msg='" + this.f532474c + "', needAbnormalHandler=false, intercept=false, extraMap=" + this.f532472a + ')';
    }

    public d() {
        this.f532473b = 0;
        this.f532474c = "";
        this.f532472a = new LinkedHashMap();
    }
}
