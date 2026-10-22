package com.huawei.hms.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes23.dex */
public abstract class ResourceLoaderUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f277910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f277911b;

    public ResourceLoaderUtil() {
    }

    public static Context getmContext() {
        return f277910a;
    }

    public static int getAnimId(String r100) {
        Context r101 = f277910a;
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.getResources().getIdentifier(r100, "anim", f277911b);
    }

    public static int getColorId(String r100) {
        Context r101 = f277910a;
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.getResources().getIdentifier(r100, "color", f277911b);
    }

    public static int getDimenId(String r100) {
        Context r101 = f277910a;
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.getResources().getIdentifier(r100, "dimen", f277911b);
    }

    public static Drawable getDrawable(String r100) {
        Context r101 = f277910a;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getResources().getDrawable(getDrawableId(r100));
    }

    public static int getDrawableId(String r100) {
        Context r101 = f277910a;
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.getResources().getIdentifier(r100, "drawable", f277911b);
    }

    public static int getIdId(String r100) {
        Context r101 = f277910a;
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.getResources().getIdentifier(r100, "id", f277911b);
    }

    public static int getLayoutId(String r100) {
        Context r101 = f277910a;
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.getResources().getIdentifier(r100, "layout", f277911b);
    }

    public static String getString(String r100) {
        Context r101 = f277910a;
        if (r101 != null) goto L7;
        return "";
    L7:
        return r101.getResources().getString(getStringId(r100));
    }

    public static int getStringId(String r100) {
        Context r101 = f277910a;
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.getResources().getIdentifier(r100, "string", f277911b);
    }

    public static int getStyleId(String r100) {
        Context r101 = f277910a;
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.getResources().getIdentifier(r100, "style", f277911b);
    }

    public static void setmContext(Context r100) {
        f277910a = r100;
        if (r100 == null) goto L5;
        f277911b = r100.getPackageName();
        return;
    L5:
        f277911b = null;
        HMSLog.e("ResourceLoaderUtil", "context is null");
    }

    public static String getString(String r100, Object... r101) {
        Context r102 = f277910a;
        if (r102 != null) goto L7;
        return "";
    L7:
        return r102.getResources().getString(getStringId(r100), r101);
    }
}
