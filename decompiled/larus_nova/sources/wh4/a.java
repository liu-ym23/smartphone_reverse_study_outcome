package wh4;

import android.text.TextUtils;
import com.bytedance.crash.util.p;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f559648a = "https://mon.zijieapi.com";

    public static void a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        p.d("setDomainName:" + r100);
        if (r100.startsWith("http") == true) goto L8;
        f559648a = "https://".concat(r100);
    L9:
        p.d("setDomainName:" + f559648a);
        return;
    L8:
        f559648a = r100;
        goto L9
    }
}
