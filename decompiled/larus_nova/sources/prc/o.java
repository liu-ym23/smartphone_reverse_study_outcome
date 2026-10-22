package prc;

import io.github.alexzhirkevich.compottie.internal.animation.k2;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, ouc.i> f530406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, k2<?>> f530407b;

    /* JADX WARN: Multi-variable type inference failed */
    public o(Map<String, ? extends ouc.i> r100) {
        Intrinsics.checkNotNullParameter(r100, "slots");
        this.f530406a = r100;
        this.f530407b = new LinkedHashMap();
    }

    public final <T extends k2<?>> T a(String r100, juc.c<? extends T> r101) {
        ouc.i r102 = this.f530406a.get(r100);
        if (r102 != null) goto L6;
        return null;
    L6:
        T r103 = (T) ((LinkedHashMap) this.f530407b).get(r100);
        if (r103 == null) goto L9;
        return r103;
    L9:
        T r104 = (T) ((ouc.a) n.f530405a.getValue()).b(r101, r102);
        this.f530407b.put(r100, r104);
        return r104;
    }
}
