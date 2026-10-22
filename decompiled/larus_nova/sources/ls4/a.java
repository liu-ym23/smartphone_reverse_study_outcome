package ls4;

import com.lynx.react.bridge.JavaOnlyMap;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import ks4.i;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f510532f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f510533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f510534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f510535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f510536d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f510537e;

    /* JADX INFO: renamed from: ls4.a$a, reason: collision with other inner class name */
    public static final class C6732a {
        public static a a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "apiName");
            return new a(r100, com.bytedance.android.ec.core.event.a.VALUE_CLICK_TYPE);
        }

        public static a b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "apiName");
            Intrinsics.checkNotNullParameter(r101, "data");
            a r102 = new a(r100, com.bytedance.android.ec.core.event.a.VALUE_CLICK_TYPE);
            Intrinsics.checkNotNullParameter(r101, "data");
            r102.f510536d = r101;
            return r102;
        }

        public static a c(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "apiName");
            Intrinsics.checkNotNullParameter(r101, "info");
            String r102 = "param error ".concat(r101);
            Intrinsics.checkNotNullParameter(r100, "apiName");
            Intrinsics.checkNotNullParameter(r102, "errMsg");
            a r103 = new a(r100, "fail");
            Intrinsics.checkNotNullParameter(r102, "errMsg");
            r103.f510535c = r102;
            r103.f510537e = 1;
            return r103;
        }
    }

    static {
    }

    public final JavaOnlyMap a() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("apiName", this.f510533a);     // Catch: Exception -> L27
        r100.put("result", this.f510534b);     // Catch: Exception -> L27
        String r101 = this.f510535c;     // Catch: Exception -> L27
        if (r101 != null) goto L6;
    L12:
        boolean r102 = false;
    L14:
        if (r102 == false) goto L20;
        String r103 = this.f510535c;     // Catch: Exception -> L27
        if (r103 == null) goto L19;
        r100.put("errMsg", r103);     // Catch: Exception -> L27
        goto L20
    L19:
        throw new IllegalArgumentException("Required value was null.".toString());     // Catch: Exception -> L27
    L20:
        int r104 = this.f510537e;     // Catch: Exception -> L27
        if (r104 == 0) goto L23;
        r100.put("errCode", Integer.valueOf(r104));     // Catch: Exception -> L27
    L23:
        String r105 = this.f510536d;     // Catch: Exception -> L27
        if (r105 == null) goto L30;
        r100.put("data", r105);     // Catch: Exception -> L27
    L30:
        return i.b(r100);
    L6:
        r102 = true;
        if (r101.length() <= 0) goto L9;
        boolean r106 = true;
    L10:
        if (r106 != true) goto L12;
    L9:
        r106 = false;
    L27:
        e = move-exception;
        tt5.a.e("ChartLynxApiResult", "build", e, false);
        goto L30
    }

    public final String toString() {
        return a().toString();
    }

    public a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "apiName");
        Intrinsics.checkNotNullParameter(r101, "result");
        this.f510533a = r100;
        this.f510534b = r101;
    }
}
