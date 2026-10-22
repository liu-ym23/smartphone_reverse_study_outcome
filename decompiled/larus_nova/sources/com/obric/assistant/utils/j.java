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
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f393879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f393880b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f393881c;

    static {
        f393880b = LazyKt.lazy(new g());
        f393881c = "";
    }

    @JvmStatic
    public static final String b(Context r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (Build.VERSION.SDK_INT < 30) goto L43;
        RoleManager r101 = (RoleManager) r100.getSystemService("role");
        if (r101 == null) goto L44;
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
        return f393881c;
    L26:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        if (r101.isRoleAvailable("android.app.role.ASSISTANT") == true) goto L14;
        return null;
    L14:
        if (r101.isRoleHeld("android.app.role.ASSISTANT") == false) goto L17;
        String r102 = r100.getPackageName();     // Catch: Exception -> L26 RuntimeException -> L28 SecurityException -> L34
        f393881c = r102;     // Catch: Exception -> L26 RuntimeException -> L28 SecurityException -> L34
    L39:
        return r102;
    L17:
        Method r103 = RoleManager.class.getMethod("getRoleHolders", new Class[]{String.class});     // Catch: Exception -> L26 RuntimeException -> L28 SecurityException -> L34
        r103.setAccessible(true);     // Catch: Exception -> L26 RuntimeException -> L28 SecurityException -> L34
        Object r104 = r103.invoke(r101, new Object[]{"android.app.role.ASSISTANT"});     // Catch: Exception -> L26 RuntimeException -> L28 SecurityException -> L34
        if ((r104 instanceof List) == false) goto L20;
        List r105 = (List) r104;     // Catch: Exception -> L26 RuntimeException -> L28 SecurityException -> L34
    L21:
        if (r105 == null) goto L23;
        r102 = (String) CollectionsKt.getOrNull(r105, 0);     // Catch: Exception -> L26 RuntimeException -> L28 SecurityException -> L34
    L24:
        f393881c = r102;     // Catch: Exception -> L26 RuntimeException -> L28 SecurityException -> L34
        goto L39
    L23:
        r102 = null;
        goto L24
    L20:
        r105 = null;
        goto L21
    L44:
        return null;
    L43:
        return null;
    }

    @JvmStatic
    public static final boolean c(Context r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return Intrinsics.areEqual(b(r100), r100.getPackageName());
    }

    @JvmStatic
    public static final String d(String r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length() > 4) goto L7;
        return r100;
    L7:
        return StringsKt.repeat("*", r100.length() - 4) + StringsKt.takeLast(r100, 4);
    }

    @JvmStatic
    public static final void a(Context r110, final Function1<? super Boolean, Unit> r111) {
        Intrinsics.checkNotNullParameter(r111, "callback");
        if (r110 != null) goto L6;
        FLogger.f375446a.e("ObricKtUtils", "addRoleHolder failed, context is null");
        r111.invoke(Boolean.FALSE);
        return;
    L6:
        int r100 = Build.VERSION.SDK_INT;
        if (r100 >= 30) goto L27;
        FLogger.f375446a.e("ObricKtUtils", "addRoleHolder failed, sdkVersion=" + r100);
        r111.invoke(Boolean.FALSE);
        return;
    L27:
        Object r101 = r110.getSystemService("role");     // Catch: Exception -> L24
        if ((r101 instanceof RoleManager) == false) goto L14;
        RoleManager r102 = (RoleManager) r101;     // Catch: Exception -> L24
    L15:
        if (r102 != null) goto L19;
        FLogger.f375446a.e("ObricKtUtils", "addRoleHolder failed, roleManager is null");     // Catch: Exception -> L24
        r111.invoke(Boolean.FALSE);     // Catch: Exception -> L24
        return;
    L19:
        if (r102.isRoleAvailable("android.app.role.ASSISTANT") == true) goto L22;
        FLogger.f375446a.e("ObricKtUtils", "addRoleHolder failed, ROLE_ASSISTANT is unavailable");     // Catch: Exception -> L24
        r111.invoke(Boolean.FALSE);     // Catch: Exception -> L24
        return;
    L22:
        final Handler r103 = new Handler(Looper.getMainLooper());     // Catch: Exception -> L24
        Executor r104 = new h(r103);     // Catch: Exception -> L24
        final String r112 = r110.getPackageName();     // Catch: Exception -> L24
        final UserHandle r105 = Process.myUserHandle();     // Catch: Exception -> L24
        Consumer r106 = new i(r112, r105, r111);     // Catch: Exception -> L24
        FLogger.f375446a.i("ObricKtUtils", "addRoleHolderAsUser invoke, packageName=" + r112 + ", userHandle=" + r105);     // Catch: Exception -> L24
        f393879a = true;     // Catch: Exception -> L24
        ((Method) f393880b.getValue()).invoke(r102, new Object[]{"android.app.role.ASSISTANT", r112, 0, r105, r104, r106});     // Catch: Exception -> L24
        return;
    L14:
        r102 = null;
    L24:
        e = move-exception;
        FLogger.f375446a.e("ObricKtUtils", "addRoleHolder failed", e);
        f393879a = false;
        r111.invoke(Boolean.FALSE);
    }
}
