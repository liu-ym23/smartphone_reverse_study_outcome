package re6;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f537432a;

    public c(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f537432a = r100;
    }

    public final Object a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f537432a.get(r100);
    }

    public final boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f537432a.containsKey(r100);
    }
}
