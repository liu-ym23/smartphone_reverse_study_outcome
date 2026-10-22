package jd6;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f498630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f498631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, String> f498632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f498633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f498634e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.kmp.network.d f498635f;

    public final c a() {
        return new c(this.f498630a, this.f498631b, this.f498632c, this.f498633d, this.f498634e, this.f498635f);
    }

    public e(c r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        this.f498630a = "";
        this.f498631b = "";
        this.f498632c = MapsKt.emptyMap();
        this.f498634e = new f();
        this.f498635f = new com.bytedance.kmp.network.d();
        this.f498630a = r100.f498624a;
        this.f498631b = r100.f498625b;
        this.f498632c = r100.f498626c;
        this.f498633d = r100.f498627d;
        this.f498634e = r100.f498628e;
        this.f498635f = r100.f498629f;
    }
}
