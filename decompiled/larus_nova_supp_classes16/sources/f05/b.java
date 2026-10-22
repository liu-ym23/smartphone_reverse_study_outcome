package f05;

import android.text.TextUtils;
import com.larksuite.framework.utils.n0;
import com.ss.android.lark.log.Log;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public static final String a(String r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Pattern r0 = n0.a;
        if (TextUtils.isEmpty(r9) == false) goto L5;
        boolean r1 = false;
    L7:
        if (r1 == true) goto L18;
        return null;
    L18:
        URL r2 = new URL(r9);     // Catch: MalformedURLException -> L15
        String r10 = r2.getHost();     // Catch: MalformedURLException -> L15
        int r3 = StringsKt.indexOf$default(r2.getPath(), "/", 0, false, 6, null);     // Catch: MalformedURLException -> L15
        if (r3 != (-1)) goto L14;
        return r10 + '/' + r3;
    L14:
        return r10 + '/' + r2.getPath().substring(0, r3);
    L15:
        e = move-exception;
        Log.e("UrlUtil", e.getMessage(), e);
        return null;
    L5:
        r1 = n0.a.matcher(r9).matches();
        goto L7
    }
}
