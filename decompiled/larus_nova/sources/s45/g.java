package s45;

import android.net.Uri;
import com.bytedance.ee.bear.contract.i0;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes16.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static h f540568a;

    public static final class a {
        @JvmStatic
        public static String b(String r100, String r101, Map r110) {
            Intrinsics.checkNotNullParameter(r100, "feishuArticleId");
            Intrinsics.checkNotNullParameter(r101, "larkArticleId");
            if (g.f540568a != null) goto L22;
            return "";
        L22:
            Locale r102 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).c();     // Catch: Throwable -> L19
            Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L19
            if (((com.bytedance.ee.bear.lark.dependency.b) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.b.class, null, null, 6)).isFeishuBrand() == true) goto L10;
            r100 = r101;
        L10:
            String r103 = ou5.b.a(r102.getCountry(), r102.getLanguage());     // Catch: Throwable -> L19
            tt5.a.b("HelpCenterUrlHelper", "getHelperCenterUrlWithArticleId " + r103);     // Catch: Throwable -> L19
            StringCompanionObject r104 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L19
            String r105 = String.format("hc/%s/articles/%s", Arrays.copyOf(new Object[]{r103, r100}, 2));     // Catch: Throwable -> L19
            Uri.Builder r106 = new Uri.Builder().scheme("https");     // Catch: Throwable -> L19
            String r107 = jcb.b.c().a("help_center");     // Catch: Throwable -> L19
            Intrinsics.checkNotNull(r107);     // Catch: Throwable -> L19
            Uri.Builder r108 = r106.authority(r107).appendEncodedPath(r105);     // Catch: Throwable -> L19
            if (hu5.a.e(r110) == true) goto L17;
            if (r110 == null) goto L17;
            Iterator r109 = r110.entrySet().iterator();     // Catch: Throwable -> L19
        L15:
            if (r109.hasNext() == false) goto L17;
            Map.Entry r111 = (Map.Entry) r109.next();     // Catch: Throwable -> L19
            r108.appendQueryParameter((String) r111.getKey(), (String) r111.getValue());     // Catch: Throwable -> L19
        L17:
            return r108.build().toString();
        L19:
            th = move-exception;
            tt5.a.f("HelpCenterUrlHelper", th, false);
            return "";
        }

        @JvmStatic
        public static String a(String r100, String r101, String r102, Map r103) {
            Intrinsics.checkNotNullParameter(r100, "pointKey");
            Intrinsics.checkNotNullParameter(r101, "feishuArticleId");
            Intrinsics.checkNotNullParameter(r102, "larkArticleId");
            if (g.f540568a != null) goto L13;
            return "";
        L13:
            Locale r104 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).c();     // Catch: Throwable -> L10
            Intrinsics.checkNotNull(r104);     // Catch: Throwable -> L10
            String r105 = en4.a.i(r100, r104.getLanguage());     // Catch: Throwable -> L10
            if (r105 != null) goto L15;
            return b(r101, r102, r103);
        L15:
            return r105;
        L10:
            th = move-exception;
            tt5.a.f("HelpCenterUrlHelper", th, false);
            return b(r101, r102, r103);
        }
    }

    static {
    }
}
