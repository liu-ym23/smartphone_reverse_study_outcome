package m5;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f512058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f512059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f512060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f512061d;

    public z0() {
        this.f512059b = "init";
        this.f512060c = "";
        this.f512061d = new LinkedHashMap();
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f512059b = r100;
    }
}
