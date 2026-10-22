package py4;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public static final /* synthetic */ int d = 0;
    public final LinkedHashMap<String, ry4.a> a;
    public final LinkedHashMap<String, k<? extends NonProguard>> b;
    public final LinkedHashMap<String, f> c;

    public static final class a {
        @JvmStatic
        public static String a(String r5, String r6, String r7) {
            Intrinsics.checkNotNullParameter(r7, "eventType");
            StringCompanionObject r0 = StringCompanionObject.INSTANCE;
            Locale r1 = Locale.US;
            Object[] r2 = new Object[3];
            if (r5 != null) goto L5;
            r5 = "";
        L5:
            r2[0] = r5;
            if (r6 != null) goto L8;
            r6 = "";
        L8:
            r2[1] = r6;
            r2[2] = r7;
            return String.format(r1, "%s:%s:%s", Arrays.copyOf(r2, 3));
        }
    }

    static {
    }

    public e() {
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
    }

    public final ry4.a a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "registerKey");
        return this.a.get(r2);
    }

    public final f b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "callbackId");
        return this.c.remove(r2);
    }
}
