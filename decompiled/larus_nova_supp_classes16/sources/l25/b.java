package l25;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public static final Pattern a = null;

    static {
        a = PatternProtector.compile("(/eesz.*)");
    }

    @JvmStatic
    public static final String a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "urlPath");
        Matcher r0 = a.matcher(r3);     // Catch: Exception -> L7
        if (r0.find() == false) goto L9;
        return r0.group(1);
    L9:
        return r3;
    L7:
        e = move-exception;
        tt5.a.i("UrlPath2LocalPathUtils", "getPathFromUrl...", e);
        goto L9
    }
}
