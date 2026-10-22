package zl5;

import android.net.Uri;
import ay4.d;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f572786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f572787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f572788c;

    public a(Uri r100) {
        String r101 = r100.toString();
        if (r101.startsWith("file:///") == true) goto L5;
    L7:
        this.f572786a = r100;
        this.f572787b = null;
        this.f572788c = true;
        return;
    L5:
        if (d.a().i(r101.substring(7)).exists() == true) goto L7;
        r100 = UriProtector.parse(URLDecoder.decode(r101, "UTF-8"));     // Catch: UnsupportedEncodingException -> L9
        goto L7
    }

    public static a a(String r100) {
        if (r100 == null) goto L12;
        if (r100.contains("://") == true) goto L10;
        if (r100.startsWith(HTTP.URL_DEFAULT) == false) goto L8;
        r100 = r100.substring(1);
    L8:
        r100 = "file:///" + r100;
    L10:
        return new a(UriProtector.parse(r100));
    L12:
        throw new NullPointerException("Uri must not be null");
    }

    public a(int r100) {
        this.f572786a = null;
        this.f572787b = Integer.valueOf(r100);
        this.f572788c = true;
    }
}
