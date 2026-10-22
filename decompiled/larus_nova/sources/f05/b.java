package f05;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.larksuite.framework.utils.n0;
import com.ss.android.lark.log.Log;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes16.dex */
public final class b {
    public static final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Pattern r101 = n0.f286044a;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        boolean r102 = false;
    L7:
        if (r102 == true) goto L18;
        return null;
    L18:
        URL r103 = new URL(r100);     // Catch: MalformedURLException -> L15
        String r104 = r103.getHost();     // Catch: MalformedURLException -> L15
        int r105 = StringsKt.indexOf$default(r103.getPath(), HTTP.URL_DEFAULT, 0, false, 6, null);     // Catch: MalformedURLException -> L15
        if (r105 != (-1)) goto L14;
        return r104 + '/' + r105;
    L14:
        return r104 + '/' + r103.getPath().substring(0, r105);
    L15:
        e = move-exception;
        Log.e("UrlUtil", e.getMessage(), e);
        return null;
    L5:
        r102 = n0.f286044a.matcher(r100).matches();
        goto L7
    }
}
