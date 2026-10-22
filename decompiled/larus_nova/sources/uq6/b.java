package uq6;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f551319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f551320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f551321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, a> f551322d;

    public final String getType() {
        return this.f551319a;
    }

    public b(com.bytedance.locallife.dito.provider.a r100) {
        Intrinsics.checkNotNullParameter(r100, "ditoAction");
        String r101 = r100.getType();
        this.f551322d = new LinkedHashMap();
        this.f551319a = r101;
    }

    public final a a(fq6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "ditoActionHandler");
        Map<String, a> r101 = this.f551322d;
        String r102 = r100.getName();
        LinkedHashMap r103 = (LinkedHashMap) r101;
        Object r104 = r103.get(r102);
        if (r104 != null) goto L6;
        r104 = new a(r100.getName());
        r103.put(r102, r104);
    L6:
        return (a) r104;
    }
}
