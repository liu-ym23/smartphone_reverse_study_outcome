package rx7;

import android.content.Context;
import com.bytedance.geckox.GeckoGlobalConfig;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f539827a = null;

        static {
            int[] r100 = new int[GeckoGlobalConfig.ENVType.values().length];
            r100[GeckoGlobalConfig.ENVType.BOE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[GeckoGlobalConfig.ENVType.DEV.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f539827a = r100;
        }
    }

    public f() {
    }

    public abstract String b();

    public abstract String d();

    public abstract String e();

    public abstract String g();

    public static Map c() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("business_version", new rx7.a());
        r100.put("channel", new b());
        r100.put("isOversea", new c());
        r100.put("device_platform", new d());
        r100.put("updateVersionCode", new e());
        return r100;
    }

    public final String a(GeckoGlobalConfig.ENVType r100) {
        Intrinsics.checkNotNullParameter(r100, "env");
        int r101 = a.f539827a[r100.ordinal()];
        if (r101 == 1) goto L9;
        if (r101 == 2) goto L11;
        return e();
    L11:
        return g();
    L9:
        return b();
    }

    public final String f(Context r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        return r100.getFilesDir().getAbsolutePath() + File.separator + d();
    }
}
