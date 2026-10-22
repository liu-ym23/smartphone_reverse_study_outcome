package xk5;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.ss.android.lark.vfs.VFSPath;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public final VFSPath a;
    public final VFSPath b;

    public c(Context r4) {
        Biz r5 = Biz.DOCS;
        int r0 = ay4.c.a;
        this.a = ay4.c.a.c(r5, "onboardingimages", true, 8);
        this.b = ay4.c.a(r5, "onboardingimages");
    }

    public static String a(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return "";
    L5:
        int r0 = r4.lastIndexOf("/");
        int r2 = r4.lastIndexOf(".");
        if (r0 >= 0) goto L8;
        int r1 = 0;
    L10:
        if (r2 != (-1)) goto L12;
        r2 = r4.length();
    L12:
        if (r1 <= r2) goto L16;
        tt5.a.d("OnBoardingImageDownloader", "Parsing image originalUrl error, startIndex[" + r1 + "] < endIndex[" + r2 + "]");
        return "";
    L16:
        return r4.substring(r1, r2);
    L8:
        r1 = r0 + 1;
        goto L10
    }

    public static boolean b(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return false;
    L5:
        int r0 = r3.lastIndexOf(".");
        if (r0 != (-1)) goto L8;
        int r1 = 0;
    L10:
        if (r1 < r3.length()) goto L13;
        return false;
    L13:
        return "zip".equals(r3.substring(r1).toLowerCase());
    L8:
        r1 = r0 + 1;
        goto L10
    }
}
