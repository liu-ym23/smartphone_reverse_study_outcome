package com.obric.assistant.utils;

import android.app.role.RoleManager;
import android.content.Context;
import android.os.Build;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.UserHandle;
import com.larus.utils.logger.FLogger;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class j {
    public static volatile boolean a;
    public static final Lazy b = null;
    public static String c;

    static {
        b = LazyKt.lazy(new g());
        c = XmlPullParser.NO_NAMESPACE;
    }

    @JvmStatic
    public static final String b(Context r8) {
        if (r8 != null) goto L6;
        return null;
    L6:
        if (Build.VERSION.SDK_INT < 30) goto L43;
        RoleManager r2 = (RoleManager) r8.getSystemService("role");
        if (r2 == null) goto L44;
    L34:
        e = move-exception;
        e.printStackTrace();
        return null;
    L28:
        e = move-exception;
        e.printStackTrace();
        if ((e.getCause() instanceof DeadObjectException) == true) goto L42;
        if (Intrinsics.areEqual(e.getClass().getName(), "android.os.DeadSystemRuntimeException") == true) goto L42;
        return null;
    L42:
        return c;
    L26:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        if (r2.isRoleAvailable("android.app.role.ASSISTANT") == true) goto L14;
        return null;
    L14:
        if (r2.isRoleHeld("android.app.role.ASSISTANT") == false) goto L17;
        String r9 = r8.getPackageName();     // Catch: Exception -> L26 RuntimeException -> L28 SecurityException -> L34
        c = r9;     // Catch: Exception -> L26 RuntimeException -> L28 SecurityException -> L34
    L39:
        return r9;
    L17:
        Method r10 = RoleManager.class.getMethod("getRoleHolders", new Class[]{String.class});     // Catch: Exception -> L26 RuntimeException -> L28 SecurityException -> L34
        r10.setAccessible(true);     // Catch: Exception -> L26 RuntimeException -> L28 SecurityException -> L34
        Object r11 = r10.invoke(r2, new Object[]{"android.app.role.ASSISTANT"});     // Catch: Exception -> L26 RuntimeException -> L28 SecurityException -> L34
        if ((r11 instanceof List) == false) goto L20;
        List r12 = (List) r11;     // Catch: Exception -> L26 RuntimeException -> L28 SecurityException -> L34
    L21:
        if (r12 == null) goto L23;
        r9 = (String) CollectionsKt.getOrNull(r12, 0);     // Catch: Exception -> L26 RuntimeException -> L28 SecurityException -> L34
    L24:
        c = r9;     // Catch: Exception -> L26 RuntimeException -> L28 SecurityException -> L34
        goto L39
    L23:
        r9 = null;
        goto L24
    L20:
        r12 = null;
        goto L21
    L44:
        return null;
    L43:
        return null;
    }

    @JvmStatic
    public static final boolean c(Context r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return Intrinsics.areEqual(b(r1), r1.getPackageName());
    }

    @JvmStatic
    public static final String d(String r4) {
        if (r4 != null) goto L4;
        return null;
    L4:
        if (r4.length() > 4) goto L7;
        return r4;
    L7:
        return StringsKt.repeat("*", r4.length() - 4) + StringsKt.takeLast(r4, 4);
    }

    @JvmStatic
    public static final void a(Context r10, Function1<? super Boolean, Unit> r11) {
        Intrinsics.checkNotNullParameter(r11, "callback");
        if (r10 != null) goto L6;
        FLogger.a.e("ObricKtUtils", "addRoleHolder failed, context is null");
        r11.invoke(Boolean.FALSE);
        return;
    L6:
        int r3 = Build.VERSION.SDK_INT;
        if (r3 >= 30) goto L27;
        FLogger.a.e("ObricKtUtils", "addRoleHolder failed, sdkVersion=" + r3);
        r11.invoke(Boolean.FALSE);
        return;
    L27:
        Object r4 = r10.getSystemService("role");     // Catch: Exception -> L24
        if ((r4 instanceof RoleManager) == false) goto L14;
        RoleManager r5 = (RoleManager) r4;     // Catch: Exception -> L24
    L15:
        if (r5 != null) goto L19;
        FLogger.a.e("ObricKtUtils", "addRoleHolder failed, roleManager is null");     // Catch: Exception -> L24
        r11.invoke(Boolean.FALSE);     // Catch: Exception -> L24
        return;
    L19:
        if (r5.isRoleAvailable("android.app.role.ASSISTANT") == true) goto L22;
        FLogger.a.e("ObricKtUtils", "addRoleHolder failed, ROLE_ASSISTANT is unavailable");     // Catch: Exception -> L24
        r11.invoke(Boolean.FALSE);     // Catch: Exception -> L24
        return;
    L22:
        h r6 = new h(new Handler(Looper.getMainLooper()));     // Catch: Exception -> L24
        String r12 = r10.getPackageName();     // Catch: Exception -> L24
        UserHandle r7 = Process.myUserHandle();     // Catch: Exception -> L24
        i r8 = new i(r12, r7, r11);     // Catch: Exception -> L24
        FLogger.a.i("ObricKtUtils", "addRoleHolderAsUser invoke, packageName=" + r12 + ", userHandle=" + r7);     // Catch: Exception -> L24
        a = true;     // Catch: Exception -> L24
        ((Method) b.getValue()).invoke(r5, new Object[]{"android.app.role.ASSISTANT", r12, 0, r7, r6, r8});     // Catch: Exception -> L24
        return;
    L14:
        r5 = null;
    L24:
        e = move-exception;
        FLogger.a.e("ObricKtUtils", "addRoleHolder failed", e);
        a = false;
        r11.invoke(Boolean.FALSE);
    }
}
