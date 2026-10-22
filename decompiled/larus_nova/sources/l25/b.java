package l25;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f507119a = null;

    static {
        f507119a = PatternProtector.compile("(/eesz.*)");
    }

    @JvmStatic
    public static final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "urlPath");
        Matcher r101 = f507119a.matcher(r100);     // Catch: Exception -> L7
        if (r101.find() == false) goto L9;
        return r101.group(1);
    L9:
        return r100;
    L7:
        e = move-exception;
        tt5.a.i("UrlPath2LocalPathUtils", "getPathFromUrl...", e);
        goto L9
    }
}
