package com.ss.android.vesdk;

import com.ss.android.ttvecamera.BuildConfig;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes40.dex */
public class VEVersionUtil {
    public VEVersionUtil() {
    }

    public static String getVESDKVersion() {
        return BuildConfig.AAR_VERSION_NAME + "-lark";
    }

    public static String[] getAllVersionInfos() {
        String r100 = getVESDKVersion();
        ArrayList r101 = new ArrayList();
        r101.add("VESDK-VERSION");
        r101.add(r100);
        Field[] r102 = mic.a.class.getDeclaredFields();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L16;
        Field r105 = r102[r104];
        if (r105.getName().contains("VERSION") == false) goto L14;
        Object r106 = r105.get(mic.a.class);     // Catch: IllegalAccessException -> L12
        if (r106 == null) goto L14;
        if (r106.getClass() != String.class) goto L14;
        r101.add(r105.getName());     // Catch: IllegalAccessException -> L12
        r101.add((String) r106);     // Catch: IllegalAccessException -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    L14:
        r104 = r104 + 1;
        goto L3
    L16:
        return (String[]) r101.toArray(new String[r101.size()]);
    }
}
