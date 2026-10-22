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
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class b {
    public static PathClassLoader a(String r16, String r17, File r18, String r19, ClassLoader r20) {
        int r6 = Build.VERSION.SDK_INT;
        if (r6 > 23) goto L5;
        boolean r7 = true;
    L7:
        if (r7 == false) goto L14;
        PathClassLoader r5 = new PathClassLoader(XmlPullParser.NO_NAMESPACE, r19, r20);     // Catch: Exception -> L10
        Object r8 = FieldUtils.getField(BaseDexClassLoader.class, "pathList").get(r5);     // Catch: Exception -> L10
        Method r9 = MethodUtils.getAccessibleMethod(r8.getClass(), "makeDexElements", new Class[]{ArrayList.class, File.class, ArrayList.class});     // Catch: Exception -> L10
        ArrayList r10 = new ArrayList();     // Catch: Exception -> L10
        r10.add(new PolarisFileWrapper(r17));     // Catch: Exception -> L10
        FieldUtils.getField(r8.getClass(), "dexElements").set(r8, (Object[]) r9.invoke(r8, new Object[]{r10, r18, new ArrayList()}));     // Catch: Exception -> L10
        ZeusLogger.i(ZeusLogger.TAG_LOAD, r16.concat(" buildInnerClassLoader isAndroidLM, create PathClassLoader by makeDexElements success~"));     // Catch: Exception -> L10
        return r5;
    L10:
        e = move-exception;
        ZeusLogger.i(ZeusLogger.TAG_LOAD, r16 + " buildInnerClassLoader isAndroidLM, create PathClassLoader by makeDexElements fail! >>> " + Log.getStackTraceString(e));
        return new PathClassLoader(r17, r19, r20);
    L14:
        if (r6 >= 24) goto L16;
    L18:
        boolean r0 = false;
    L20:
        if (r0 == false) goto L22;
    L33:
        PathClassLoader r1 = new PathClassLoader(XmlPullParser.NO_NAMESPACE, r19, null);     // Catch: Exception -> L28
        Object r11 = FieldUtils.getField(BaseDexClassLoader.class, "pathList").get(r1);     // Catch: Exception -> L28
        MethodUtils.getAccessibleMethod(r11.getClass(), "addDexPath", new Class[]{String.class, File.class}).invoke(r11, new Object[]{r17, r18});     // Catch: Exception -> L28
        ZeusLogger.i(ZeusLogger.TAG_LOAD, r16.concat(" buildInnerClassLoader isAndroidN or isAndroidS, create PathClassLoader by addDexPath success~"));     // Catch: Exception -> L28
        return r1;
    L28:
        e = move-exception;
        ZeusLogger.i(ZeusLogger.TAG_LOAD, r16 + " buildInnerClassLoader isAndroidN or isAndroidS, create PathClassLoader by addDexPath fail! >>> " + Log.getStackTraceString(e));
        return new PathClassLoader(r17, r19, null);
    L22:
        if (m.b() == true) goto L33;
        ZeusLogger.i(ZeusLogger.TAG_LOAD, r16.concat(" buildInnerClassLoader isNotAndroidN, create PathClassLoader by new success~"));
        return new PathClassLoader(r17, r19, null);
    L16:
        if (r6 > 25) goto L18;
        r0 = true;
        goto L20
    L5:
        r7 = false;
        goto L7
    }
}
