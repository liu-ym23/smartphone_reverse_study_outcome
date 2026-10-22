package com.bytedance.mira.core.opt.res.ext;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import com.bytedance.mira.util.ReflectUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public class WebViewExtApi29Impl extends WebViewExtImpl {
    private static final Method sGetAllApkPathMethod = null;
    private static final Field sPackageInfoField = null;

    static {
        sGetAllApkPathMethod = ReflectUtils.findDeclaredMethod(ApplicationInfo.class, "getAllApkPaths", new Class[0]);
        Field r100 = ReflectUtils.findDeclaredField(Class.forName("android.webkit.WebViewFactory"), "sPackageInfo");     // Catch: Throwable -> L5
    L6:
        sPackageInfoField = r100;
        return;
    L5:
        r100 = null;
        goto L6
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IWebViewExt
    public String[] getWebViewPath() {
        Field r100 = sPackageInfoField;
        if (r100 != null) goto L5;
        return null;
    L5:
        PackageInfo r101 = (PackageInfo) ReflectUtils.readDeclaredField(r100, null);
        if (r101 != null) goto L8;
        return null;
    L8:
        ApplicationInfo r102 = r101.applicationInfo;
        if (r102 != null) goto L11;
        return null;
    L11:
        Method r103 = sGetAllApkPathMethod;
        if (r103 != null) goto L18;
        return null;
    L18:
        return (String[]) r103.invoke(r102, new Object[0]);
    L17:
        return null;
    }

    public WebViewExtApi29Impl() {
    }
}
