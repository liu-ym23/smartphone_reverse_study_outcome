package com.volcengine.zeus;

import android.os.Build;
import android.util.Log;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.util.FieldUtils;
import com.volcengine.zeus.util.MethodUtils;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import mqc.m;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static PathClassLoader a(String r110, String r111, File r112, String r113, ClassLoader r210) {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 > 23) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L14;
        PathClassLoader r102 = new PathClassLoader("", r113, r210);     // Catch: Exception -> L10
        Object r103 = FieldUtils.getField(BaseDexClassLoader.class, "pathList").get(r102);     // Catch: Exception -> L10
        Method r104 = MethodUtils.getAccessibleMethod(r103.getClass(), "makeDexElements", new Class[]{ArrayList.class, File.class, ArrayList.class});     // Catch: Exception -> L10
        ArrayList r114 = new ArrayList();     // Catch: Exception -> L10
        r114.add(new PolarisFileWrapper(r111));     // Catch: Exception -> L10
        FieldUtils.getField(r103.getClass(), "dexElements").set(r103, (Object[]) r104.invoke(r103, new Object[]{r114, r112, new ArrayList()}));     // Catch: Exception -> L10
        ZeusLogger.i(ZeusLogger.TAG_LOAD, r110.concat(" buildInnerClassLoader isAndroidLM, create PathClassLoader by makeDexElements success~"));     // Catch: Exception -> L10
        return r102;
    L10:
        e = move-exception;
        ZeusLogger.i(ZeusLogger.TAG_LOAD, r110 + " buildInnerClassLoader isAndroidLM, create PathClassLoader by makeDexElements fail! >>> " + Log.getStackTraceString(e));
        return new PathClassLoader(r111, r113, r210);
    L14:
        if (r100 >= 24) goto L16;
    L18:
        boolean r105 = false;
    L20:
        if (r105 == false) goto L22;
    L33:
        PathClassLoader r106 = new PathClassLoader("", r113, null);     // Catch: Exception -> L28
        Object r107 = FieldUtils.getField(BaseDexClassLoader.class, "pathList").get(r106);     // Catch: Exception -> L28
        MethodUtils.getAccessibleMethod(r107.getClass(), "addDexPath", new Class[]{String.class, File.class}).invoke(r107, new Object[]{r111, r112});     // Catch: Exception -> L28
        ZeusLogger.i(ZeusLogger.TAG_LOAD, r110.concat(" buildInnerClassLoader isAndroidN or isAndroidS, create PathClassLoader by addDexPath success~"));     // Catch: Exception -> L28
        return r106;
    L28:
        e = move-exception;
        ZeusLogger.i(ZeusLogger.TAG_LOAD, r110 + " buildInnerClassLoader isAndroidN or isAndroidS, create PathClassLoader by addDexPath fail! >>> " + Log.getStackTraceString(e));
        return new PathClassLoader(r111, r113, null);
    L22:
        if (m.b() == true) goto L33;
        ZeusLogger.i(ZeusLogger.TAG_LOAD, r110.concat(" buildInnerClassLoader isNotAndroidN, create PathClassLoader by new success~"));
        return new PathClassLoader(r111, r113, null);
    L16:
        if (r100 > 25) goto L18;
        r105 = true;
        goto L20
    L5:
        r101 = false;
        goto L7
    }
}
