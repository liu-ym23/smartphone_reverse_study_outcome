package um7;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class f {
    public static String a(String r100) {
        if (rm7.c.a.f538587a.f538579d == true) goto L12;
        return r100;
    L12:
        if (TextUtils.isEmpty(r100) == false) goto L9;
        return null;
    L9:
        Uri r101 = UriProtector.parse(r100.trim());     // Catch: Throwable -> L11
        Uri.Builder r102 = new Uri.Builder();     // Catch: Throwable -> L11
        r102.scheme("http");     // Catch: Throwable -> L11
        r102.encodedPath(r101.getPath());     // Catch: Throwable -> L11
        r102.encodedAuthority("boe.i.snssdk.com");     // Catch: Throwable -> L11
        r102.encodedQuery(r101.getEncodedQuery());     // Catch: Throwable -> L11
        return r102.build().toString();
    L14:
        return r100;
    }
}
