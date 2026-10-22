package km;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, a<?>> f504035b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, String> f504036c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f504037a;

    /* JADX INFO: renamed from: km.a$a, reason: collision with other inner class name */
    public static final class C6571a {
    }

    static {
        f504035b = new LinkedHashMap();
        f504036c = new LinkedHashMap();
    }

    public final String toString() {
        return "DataKey_" + hashCode() + '_' + this.f504037a;
    }

    public a(String r100, T... r101) {
        Intrinsics.checkNotNullParameter(r100, "realKey");
        Intrinsics.checkNotNullParameter(r101, "possibleValues");
        this.f504037a = r100;
    }
}
