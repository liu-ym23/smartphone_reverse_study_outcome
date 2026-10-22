package k66;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends i66.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f501965c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f501966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f501967b;

    public static final class a {
        @JvmStatic
        public static Map a(b r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            Integer r101 = r100.f501966a;
            if (r101 == null) goto L9;
            r101.intValue();
            if (r100.f501967b != null) goto L7;
            return null;
        L7:
            LinkedHashMap r102 = new LinkedHashMap();
            Integer r103 = r100.f501966a;
            Intrinsics.checkNotNull(r103);
            r102.put("httpCode", r103);
            Object r104 = r100.f501967b;
            Intrinsics.checkNotNull(r104);
            r102.put("response", r104);
            return r102;
        L9:
            return null;
        }
    }

    static {
    }

    public b() {
    }
}
