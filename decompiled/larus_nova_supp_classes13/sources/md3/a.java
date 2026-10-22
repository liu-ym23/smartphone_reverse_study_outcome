package md3;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r1, String r2) {
        if (r1 != null) goto L5;
        return null;
    L5:
        if (r2 != null) goto L7;
        return r1;
    L7:
        Uri.Builder r3 = UriProtector.parse(r1).buildUpon();
        r3.appendQueryParameter("source_btm_token", r2);
        return r3.toString();
    }
}
