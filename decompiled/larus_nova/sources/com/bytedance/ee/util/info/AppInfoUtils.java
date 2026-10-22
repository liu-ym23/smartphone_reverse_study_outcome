package com.bytedance.ee.util.info;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.larksuite.framework.utils.ApkUtil;
import com.larus.nova.R;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import tt5.a;

/* JADX INFO: loaded from: classes19.dex */
public final class AppInfoUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static PackageInfo f243137a;

    @Retention(RetentionPolicy.SOURCE)
    public @interface VERSION_TYPE {
        public static final String VERSION_ALPHA = "alpha";
        public static final String VERSION_BETA = "beta";
        public static final String VERSION_RELEASE = "release";
    }

    public static String a() {
        return Build.BRAND + " " + Build.MODEL;
    }

    public static Boolean e() {
        return Boolean.valueOf(LarkAppContext.inst().buildConfig().isMempopeApp());
    }

    public static Boolean f() {
        return Boolean.valueOf(LarkAppContext.inst().buildConfig().isOfficeSDK());
    }

    public static String b(Context r100) {
        if (f243137a == null) goto L13;
    L8:
        PackageInfo r101 = f243137a;
        if (r101 != null) goto L12;
        return "";
    L12:
        return r101.packageName;
    L13:
        f243137a = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 0);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        a.l("InfoProviderUtils", "init: error", th);
        goto L8
    }

    public static String c(Context r100) {
        StringBuilder r101 = new StringBuilder();
        String r102 = ApkUtil.getAppVersionName(r100);
        if (TextUtils.isEmpty(r100.getString(R.string.ua_sdk_name)) == true) goto L6;
        r101.append(r100.getString(R.string.ua_sdk_name));
        r101.append("/7.75.0-alpha1 ");
    L6:
        if (TextUtils.isEmpty(r100.getString(R.string.ua_app_name)) == true) goto L11;
        if (TextUtils.isEmpty(r102) == true) goto L11;
        r101.append(r100.getString(R.string.ua_app_name));
        r101.append(HTTP.URL_DEFAULT);
        r101.append(r102);
        r101.append(" ");
    L11:
        if (e().booleanValue() == false) goto L13;
        r101.append(r100.getString(R.string.ua_app_name_mempope));
        r101.append(HTTP.URL_DEFAULT);
        r101.append(r102);
        r101.append(" ");
    L13:
        r101.append("platform/android okhttp/3.2 Mobile");
        return r101.toString();
    }

    public static String d(Context r100) {
        String r101 = ApkUtil.getAppVersionName(r100);
        if (r101.toLowerCase().contains("alpha") == false) goto L6;
        return "alpha";
    L6:
        if (r101.toLowerCase().contains("beta") == true) goto L11;
        return "release";
    L11:
        return "beta";
    }
}
