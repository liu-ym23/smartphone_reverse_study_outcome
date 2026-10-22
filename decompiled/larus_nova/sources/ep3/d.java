package ep3;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f473432a;

    public d(Map<String, ? extends Object> r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        this.f473432a = r101;
        r101.putAll(r100);
    }

    @Override // ep3.c
    public final Object a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return ((LinkedHashMap) this.f473432a).get(r100);
    }
}
