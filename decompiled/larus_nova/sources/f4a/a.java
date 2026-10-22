package f4a;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class a extends fx7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f475573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f475574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f475575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f475576d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f475577e;

    /* JADX INFO: renamed from: f4a.a$a, reason: collision with other inner class name */
    public static final class C5858a {
        @JvmStatic
        public static Map a(a r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            LinkedHashMap r101 = new LinkedHashMap();
            r101.put("platform", r100.f475573a);
            r101.put("platform_app_id", r100.f475574b);
            String r102 = r100.f475573a;
            int r103 = r102.hashCode();
            if (r103 == (-1325936172)) goto L16;
            if (r103 == (-1240244679)) goto L13;
            if (r103 == (-791575966)) goto L10;
        L17:
            r101.put("access_token", r100.f475577e);
        L19:
            return r101;
        L10:
            if (r102.equals("weixin") == false) goto L17;
        L18:
            r101.put("code", r100.f475576d);
            goto L19
        L13:
            if (r102.equals("google") == false) goto L17;
            r101.put("access_token_secret", r100.f475575c);
            goto L19
        L16:
            if (r102.equals("douyin") == true) goto L18;
            goto L17
        }
    }

    static {
    }

    public a() {
        this.f475573a = "";
        this.f475574b = "";
        this.f475575c = "";
        this.f475576d = "";
        this.f475577e = "";
    }
}
