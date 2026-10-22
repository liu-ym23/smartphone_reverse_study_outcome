package ep3;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Function1<String, Object>> f473430a;

    public a() {
        this.f473430a = new LinkedHashMap();
    }

    @Override // ep3.c
    public final Object a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Function1 r101 = (Function1) ((LinkedHashMap) this.f473430a).get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.invoke(r100);
    }

    public final void b(String r100, Function1<? super String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f473430a.put(r100, r101);
    }
}
