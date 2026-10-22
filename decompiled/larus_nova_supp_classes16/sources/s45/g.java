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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g {
    public static h a;

    public static final class a {
        @JvmStatic
        public static String b(String r8, String r9, Map r10) {
            Intrinsics.checkNotNullParameter(r8, "feishuArticleId");
            Intrinsics.checkNotNullParameter(r9, "larkArticleId");
            if (g.a != null) goto L22;
            return "";
        L22:
            Locale r4 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).c();     // Catch: Throwable -> L19
            Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L19
            if (((com.bytedance.ee.bear.lark.dependency.b) org.koin.java.a.c(com.bytedance.ee.bear.lark.dependency.b.class, null, null, 6)).isFeishuBrand() == true) goto L10;
            r8 = r9;
        L10:
            String r11 = ou5.b.a(r4.getCountry(), r4.getLanguage());     // Catch: Throwable -> L19
            tt5.a.b("HelpCenterUrlHelper", "getHelperCenterUrlWithArticleId " + r11);     // Catch: Throwable -> L19
            StringCompanionObject r1 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L19
            String r12 = String.format("hc/%s/articles/%s", Arrays.copyOf(new Object[]{r11, r8}, 2));     // Catch: Throwable -> L19
            Uri.Builder r13 = new Uri.Builder().scheme("https");     // Catch: Throwable -> L19
            String r2 = jcb.b.c().a("help_center");     // Catch: Throwable -> L19
            Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L19
            Uri.Builder r14 = r13.authority(r2).appendEncodedPath(r12);     // Catch: Throwable -> L19
            if (hu5.a.e(r10) == true) goto L17;
            if (r10 == null) goto L17;
            Iterator r16 = r10.entrySet().iterator();     // Catch: Throwable -> L19
        L15:
            if (r16.hasNext() == false) goto L17;
            Map.Entry r17 = (Map.Entry) r16.next();     // Catch: Throwable -> L19
            r14.appendQueryParameter((String) r17.getKey(), (String) r17.getValue());     // Catch: Throwable -> L19
        L17:
            return r14.build().toString();
        L19:
            th = move-exception;
            tt5.a.f("HelpCenterUrlHelper", th, false);
            return "";
        }

        @JvmStatic
        public static String a(String r3, String r4, String r5, Map r6) {
            Intrinsics.checkNotNullParameter(r3, "pointKey");
            Intrinsics.checkNotNullParameter(r4, "feishuArticleId");
            Intrinsics.checkNotNullParameter(r5, "larkArticleId");
            if (g.a != null) goto L13;
            return "";
        L13:
            Locale r0 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).c();     // Catch: Throwable -> L10
            Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L10
            String r7 = en4.a.i(r3, r0.getLanguage());     // Catch: Throwable -> L10
            if (r7 != null) goto L15;
            return b(r4, r5, r6);
        L15:
            return r7;
        L10:
            th = move-exception;
            tt5.a.f("HelpCenterUrlHelper", th, false);
            return b(r4, r5, r6);
        }
    }

    static {
    }
}
