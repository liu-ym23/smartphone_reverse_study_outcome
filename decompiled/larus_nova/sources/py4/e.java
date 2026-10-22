package py4;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes16.dex */
public final class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f531029d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<String, ry4.a> f531030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap<String, k<? extends NonProguard>> f531031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap<String, f> f531032c;

    public static final class a {
        @JvmStatic
        public static String a(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r102, "eventType");
            StringCompanionObject r103 = StringCompanionObject.INSTANCE;
            Locale r104 = Locale.US;
            Object[] r105 = new Object[3];
            if (r100 != null) goto L5;
            r100 = "";
        L5:
            r105[0] = r100;
            if (r101 != null) goto L8;
            r101 = "";
        L8:
            r105[1] = r101;
            r105[2] = r102;
            return String.format(r104, "%s:%s:%s", Arrays.copyOf(r105, 3));
        }
    }

    static {
    }

    public e() {
        this.f531030a = new LinkedHashMap();
        this.f531031b = new LinkedHashMap();
        this.f531032c = new LinkedHashMap();
    }

    public final ry4.a a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "registerKey");
        return this.f531030a.get(r100);
    }

    public final f b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "callbackId");
        return this.f531032c.remove(r100);
    }
}
