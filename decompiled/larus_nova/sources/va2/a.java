package va2;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, Integer> f553926a;

    public a() {
        this.f553926a = new HashMap();
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Integer r101 = this.f553926a.get(r100);
        if (r101 != null) goto L5;
        r101 = 0;
    L5:
        int r102 = r101.intValue();
        this.f553926a.put(r100, Integer.valueOf(r102 + 1));
    }
}
