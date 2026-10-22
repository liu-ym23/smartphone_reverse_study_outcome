package xk5;

import android.content.Context;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.ss.android.lark.vfs.VFSPath;

/* JADX INFO: loaded from: classes18.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VFSPath f564215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VFSPath f564216b;

    public c(Context r100) {
        Biz r101 = Biz.DOCS;
        int r102 = ay4.c.f16749a;
        this.f564215a = ay4.c.a.c(r101, "onboardingimages", true, 8);
        this.f564216b = ay4.c.a(r101, "onboardingimages");
    }

    public static String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return "";
    L5:
        int r101 = r100.lastIndexOf(HTTP.URL_DEFAULT);
        int r102 = r100.lastIndexOf(".");
        if (r101 >= 0) goto L8;
        int r103 = 0;
    L10:
        if (r102 != (-1)) goto L12;
        r102 = r100.length();
    L12:
        if (r103 <= r102) goto L16;
        tt5.a.d("OnBoardingImageDownloader", "Parsing image originalUrl error, startIndex[" + r103 + "] < endIndex[" + r102 + "]");
        return "";
    L16:
        return r100.substring(r103, r102);
    L8:
        r103 = r101 + 1;
        goto L10
    }

    public static boolean b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        int r101 = r100.lastIndexOf(".");
        if (r101 != (-1)) goto L8;
        int r102 = 0;
    L10:
        if (r102 < r100.length()) goto L13;
        return false;
    L13:
        return "zip".equals(r100.substring(r102).toLowerCase());
    L8:
        r102 = r101 + 1;
        goto L10
    }
}
