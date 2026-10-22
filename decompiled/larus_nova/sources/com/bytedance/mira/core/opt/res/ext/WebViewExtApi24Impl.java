package com.bytedance.mira.core.opt.res.ext;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import com.bytedance.mira.util.ReflectUtils;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes21.dex */
public class WebViewExtApi24Impl extends WebViewExtImpl {
    private static final Field sPackageInfoField = null;

    static {
        Field r100 = ReflectUtils.findDeclaredField(Class.forName("android.webkit.WebViewFactory"), "sPackageInfo");     // Catch: Throwable -> L4
    L5:
        sPackageInfoField = r100;
        return;
    L4:
        r100 = null;
        goto L5
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
        if (r102 != null) goto L12;
        return null;
    L12:
        return new String[]{r102.sourceDir};
    }

    public WebViewExtApi24Impl() {
    }
}
