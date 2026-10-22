package zl5;

import android.net.Uri;
import ay4.d;
import com.bytedance.ee.docsdk.impl.utils.AESUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public final Uri a;
    public final Integer b;
    public boolean c;

    public a(Uri r4) {
        String r0 = r4.toString();
        if (r0.startsWith("file:///") == true) goto L5;
    L7:
        this.a = r4;
        this.b = null;
        this.c = true;
        return;
    L5:
        if (d.a().i(r0.substring(7)).exists() == true) goto L7;
        r4 = UriProtector.parse(URLDecoder.decode(r0, AESUtils.CHARSET));     // Catch: UnsupportedEncodingException -> L9
        goto L7
    }

    public static a a(String r2) {
        if (r2 == null) goto L12;
        if (r2.contains("://") == true) goto L10;
        if (r2.startsWith("/") == false) goto L8;
        r2 = r2.substring(1);
    L8:
        r2 = "file:///" + r2;
    L10:
        return new a(UriProtector.parse(r2));
    L12:
        throw new NullPointerException("Uri must not be null");
    }

    public a(int r2) {
        this.a = null;
        this.b = Integer.valueOf(r2);
        this.c = true;
    }
}
