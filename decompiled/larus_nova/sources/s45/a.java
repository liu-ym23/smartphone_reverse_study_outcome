package s45;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ee.util.info.AppInfoUtils;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: s45.a$a, reason: collision with other inner class name */
    public static final class C7566a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f540546a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f540547b;

        public String getType() {
            return this.f540546a;
        }

        public C7566a(String r100, String r101) {
            this.f540546a = r100;
            this.f540547b = r101;
        }
    }

    public static boolean c() {
        return Boolean.TRUE.equals(AppInfoUtils.f());
    L4:
        return false;
    }

    public static boolean b(String r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (TextUtils.isEmpty(r100) == true) goto L7;
        return false;
    }

    public static boolean d(String r100) {
        if (c() == true) goto L12;
        if (b(r100) == false) goto L7;
    L9:
        return false;
    L7:
        if (r100.startsWith("/record/") == false) goto L9;
        return true;
    L12:
        return !b(a(r100, "/share/base/record/"));
    }

    public static C7566a e(String r100) {
        if (c() == true) goto L5;
        return null;
    L5:
        String r101 = a(r100, "/share/base/record/");
        if (b(r101) == false) goto L8;
        String r102 = a(r100, "/share/base/add/");
        if (b(r102) == false) goto L12;
        return null;
    L12:
        return new C7566a(sbb.e.f541299j.getType(), r102);
    L8:
        return new C7566a(sbb.e.f541298i.getType(), r101);
    }

    public static String a(String r100, String r101) {
        if (b(r100) == false) goto L5;
    L16:
        return null;
    L5:
        if (r100.startsWith(r101) == false) goto L16;
        String r102 = r100.substring(r101.length());
        if (r102.length() == 0) goto L16;
        if (r102.endsWith(HTTP.URL_DEFAULT) == true) goto L16;
        if (b(r102) == true) goto L16;
        if (r102.contains(HTTP.URL_DEFAULT) == true) goto L16;
        return r102;
    }
}
