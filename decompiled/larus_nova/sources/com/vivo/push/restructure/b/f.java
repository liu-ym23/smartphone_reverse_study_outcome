package com.vivo.push.restructure.b;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.vivo.push.util.t;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public final class f implements b {
    public f() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_vivo_push_restructure_b_f_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    @Override // com.vivo.push.util.n
    public final List<String> a(Context r100) {
        if (t.b() == true) goto L5;
    L7:
        List<ResolveInfo> r101 = null;
        if (com.vivo.push.restructure.a.a().e().m().isAgreePrivacyStatement() == true) goto L11;
        t.d("PushSystemRelyImpl", " findAllCorePush  isAgreePrivacyStatement() is false ");
        return null;
    L11:
        ArrayList r102 = new ArrayList();
        Intent r103 = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
        r101 = r100.getPackageManager().queryIntentServices(r103, 576);     // Catch: Exception -> L14
    L15:
        if (r101 == null) goto L27;
        if (r101.size() <= 0) goto L27;
        int r104 = r101.size();
        int r105 = 0;
    L19:
        if (r105 >= r104) goto L27;
        ResolveInfo r106 = (ResolveInfo) ListProtector.get(r101, r105);
        if (r106 == null) goto L25;
        String r107 = r106.serviceInfo.packageName;
        if (TextUtils.isEmpty(r107) == true) goto L25;
        r102.add(r107);
    L25:
        r105 = r105 + 1;
    L27:
        if (r102.size() > 0) goto L29;
        t.d("PushSystemRelyImpl", "get all push packages is null");
    L29:
        return r102;
    L5:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L7;
        new Throwable();
        goto L7
    }

    @Override // com.vivo.push.util.n
    public final boolean b(Context r110) {
        if (r110 != null) goto L16;
        return true;
    L16:
    L13:
        e = move-exception;
        t.a("PushSystemRelyImpl", "isNotifySwitchOpen error", e);
        return true;
    L6:
        if (Build.VERSION.SDK_INT >= 24) goto L8;
        AppOpsManager r100 = (AppOpsManager) r110.getSystemService("appops");     // Catch: Exception -> L13
        ApplicationInfo r101 = r110.getApplicationInfo();     // Catch: Exception -> L13
        String r111 = r110.getApplicationContext().getPackageName();     // Catch: Exception -> L13
        int r102 = r101.uid;     // Catch: Exception -> L13
        Class r103 = INVOKESTATIC_com_vivo_push_restructure_b_f_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(AppOpsManager.class.getName());     // Catch: Exception -> L13
        Class<?> r104 = Integer.TYPE;     // Catch: Exception -> L13
        if (((Integer) r103.getMethod("checkOpNoThrow", new Class[]{r104, r104, String.class}).invoke(r100, new Object[]{Integer.valueOf(((Integer) r103.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(r102), r111})).intValue() != 0) goto L12;
        return true;
    L12:
        return false;
    L8:
        return ((NotificationManager) r110.getSystemService("notification")).areNotificationsEnabled();
    }
}
