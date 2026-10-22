package fo;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, a<?>> f478062b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, String> f478063c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f478064a;

    /* JADX INFO: renamed from: fo.a$a, reason: collision with other inner class name */
    public static final class C5934a {
    }

    static {
        f478062b = new LinkedHashMap();
        f478063c = new LinkedHashMap();
    }

    public final String toString() {
        return "DataKey_" + hashCode() + '_' + this.f478064a;
    }

    public a(String r100, T... r101) {
        Intrinsics.checkNotNullParameter(r100, "realKey");
        Intrinsics.checkNotNullParameter(r101, "possibleValues");
        this.f478064a = r100;
    }
}
