package hob;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f486304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, String> f486305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f486306c;

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "href");
        this.f486304a = r100;
        this.f486306c = new HashMap(0);
    }
}
