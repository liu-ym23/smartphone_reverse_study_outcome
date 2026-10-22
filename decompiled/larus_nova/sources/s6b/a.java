package s6b;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<b<?, ?>>, b<?, ?>> f540879a;

    /* JADX INFO: renamed from: s6b.a$a, reason: collision with other inner class name */
    public static final class C7577a {
    }

    static {
    }

    public a() {
        this.f540879a = new LinkedHashMap();
    }

    public final void a(b<?, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "spec");
        if (this.f540879a.containsKey(r100.getClass()) == true) goto L6;
        Map<Class<b<?, ?>>, b<?, ?>> r101 = this.f540879a;
        Class<?> r102 = r100.getClass();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type java.lang.Class<com.ss.android.lark.chat.spec.IFeatureSpec<*, *>>");
        r101.put((Class<b<?, ?>>) r102, r100);
        return;
    }

    public final <Patch extends Spec, Spec extends b<Spec, Patch>> Spec b(Class<Spec> r100) {
        Intrinsics.checkNotNullParameter(r100, "clz");
        Object r101 = ((LinkedHashMap) this.f540879a).get(r100);
        if ((r101 instanceof b) == true) goto L7;
        return null;
    L7:
        return (Spec) r101;
    }
}
