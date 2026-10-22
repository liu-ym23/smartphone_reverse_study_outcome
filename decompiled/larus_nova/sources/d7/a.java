package d7;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scheme");
        Intrinsics.checkNotNullParameter(r100, "scheme");
        Object r101 = null;
        if (StringsKt.startsWith$default(r100, "http", false, 2, null) == true) goto L20;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        Object r103 = Result.m9449constructorimpl(UriProtector.getQueryParameter(UriProtector.parse(r100), "url"));     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r103) == true) goto L13;
        r101 = r103;
    L13:
        String r104 = (String) r101;
        if (r104 != null) goto L19;
        return "";
    L19:
        return r104;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    L20:
        return r100;
    }

    @JvmStatic
    public static final String a(String r110, Map<String, String> r111) {
        Intrinsics.checkNotNullParameter(r110, "url");
        Intrinsics.checkNotNullParameter(r111, "params");
        if (StringsKt.isBlank(r110) == false) goto L5;
        return r110;
    L5:
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L52
        Uri r102 = UriProtector.parse(b(r110));     // Catch: Throwable -> L52
        Uri.Builder r103 = r102.buildUpon().clearQuery();     // Catch: Throwable -> L52
        String r104 = UriProtector.getQueryParameter(UriProtector.parse(r110), "fallback_url");     // Catch: Throwable -> L52
        if (r104 == null) goto L21;
        String r105 = b(r104);     // Catch: Throwable -> L52
        if (StringsKt.isBlank(r105) == false) goto L11;
        boolean r106 = true;
    L13:
        if ((!r106) == true) goto L16;
        r105 = null;
    L16:
        if (r105 == null) goto L21;
        Uri r107 = UriProtector.parse(r105);     // Catch: Throwable -> L52
        if (r107 == null) goto L20;
        Uri.Builder r108 = r107.buildUpon();     // Catch: Throwable -> L52
    L22:
        Set<String> r109 = UriProtector.getQueryParameterNames(r102);     // Catch: Throwable -> L52
        ArrayList r112 = new ArrayList();     // Catch: Throwable -> L52
        Iterator<T> r113 = r109.iterator();     // Catch: Throwable -> L52
    L24:
        if (r113.hasNext() == false) goto L28;
        Object r114 = r113.next();     // Catch: Throwable -> L52
        if ((!Intrinsics.areEqual((String) r114, "fallback_url")) == false) goto L24;
        r112.add(r114);     // Catch: Throwable -> L52
        goto L24
    L28:
        Iterator r115 = r112.iterator();     // Catch: Throwable -> L52
    L30:
        if (r115.hasNext() == false) goto L32;
        String r116 = (String) r115.next();     // Catch: Throwable -> L52
        r103.appendQueryParameter(r116, UriProtector.getQueryParameter(r102, r116));     // Catch: Throwable -> L52
        goto L30
    L32:
        Iterator<T> r117 = r111.entrySet().iterator();     // Catch: Throwable -> L52
    L34:
        if (r117.hasNext() == false) goto L44;
        Map.Entry r118 = (Map.Entry) r117.next();     // Catch: Throwable -> L52
        if (UriProtector.getQueryParameter(r102, (String) r118.getKey()) != null) goto L38;
        r103.appendQueryParameter((String) r118.getKey(), (String) r118.getValue());     // Catch: Throwable -> L52
    L38:
        if (r107 == null) goto L40;
        String r119 = UriProtector.getQueryParameter(r107, (String) r118.getKey());     // Catch: Throwable -> L52
    L41:
        if (r119 != null) goto L34;
        if (r108 == null) goto L34;
        r108.appendQueryParameter((String) r118.getKey(), (String) r118.getValue());     // Catch: Throwable -> L52
        goto L34
    L40:
        r119 = null;
        goto L41
    L44:
        if (r108 == null) goto L49;
        Uri r120 = r108.build();     // Catch: Throwable -> L52
        if (r120 == null) goto L49;
        String r121 = r120.toString();     // Catch: Throwable -> L52
        if (r121 == null) goto L49;
    L50:
        r103.appendQueryParameter("fallback_url", r121);     // Catch: Throwable -> L52
        Object r122 = Result.m9449constructorimpl(r103.build().toString());     // Catch: Throwable -> L52
    L55:
        if (Result.m9455isFailureimpl(r122) == true) goto L58;
        r100 = r122;
    L58:
        String r123 = (String) r100;
        if (r123 != null) goto L62;
        return r110;
    L62:
        return r123;
    L49:
        r121 = "";
        goto L50
    L20:
        r108 = null;
        goto L22
    L11:
        r106 = false;
    L21:
        r107 = null;
        r108 = null;
    L52:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L55
    }
}
