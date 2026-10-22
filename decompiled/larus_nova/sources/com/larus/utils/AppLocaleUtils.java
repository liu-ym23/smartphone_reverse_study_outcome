package com.larus.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.telephony.TelephonyManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.common.apphost.AppHost;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\bJ\b\u0010\u0011\u001a\u00020\fH\u0002J\u001c\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\u0006\u0010\u001a\u001a\u00020\u0018J\b\u0010\u001b\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/utils/AppLocaleUtils;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "isMIUIBuild", "", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/larus/utils/RegionChangeListener;", "carrierRegion", "", "startListenRegionChange", "", "stopListenRegionChange", "addListener", "listener", "removeListener", "notifyChange", "onReceive", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "getSysLocale", "Ljava/util/Locale;", "getLocaleFromMIUIIBuild", "getAppLocale", "getCarrierRegion", "getTimeZone", "Ljava/util/TimeZone;", "utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppLocaleUtils extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppLocaleUtils f375332a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f375333b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CopyOnWriteArrayList<g0> f375334c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile String f375335d;

    static {
        f375332a = new AppLocaleUtils();
        f375333b = StringsKt.equals(Build.BRAND, "Xiaomi", true);
        f375334c = new CopyOnWriteArrayList();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == false) goto L34;
        Class<?> r102 = Class.forName("miui.os.Build");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("miui.os.Build");     // Catch: Throwable -> L17
    L16:
        return r102;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("miui.os.Build");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("miui.os.Build");
    L34:
        Class<?> r103 = Class.forName("miui.os.Build");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("miui.os.Build");     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("miui.os.Build");
    L12:
        throw th;
    }

    public static String b() {
        if (f375335d != null) goto L5;
        String r100 = null;
        Object r101 = AppHost.f326268a.getApplication().getSystemService("phone");     // Catch: Throwable -> L18
        if ((r101 instanceof TelephonyManager) == false) goto L10;
        TelephonyManager r102 = (TelephonyManager) r101;     // Catch: Throwable -> L18
    L11:
        if (r102 == null) goto L20;
        String r103 = r102.getSimCountryIso();     // Catch: Throwable -> L18
        if (r103 == null) goto L20;
        if ((!StringsKt.isBlank(r103)) == false) goto L20;
        r100 = r103;
    L20:
        f375335d = r100;
        return f375335d;
    L10:
        r102 = null;
    L18:
        th = move-exception;
        th.printStackTrace();
        goto L20
    L5:
        return f375335d;
    }

    public static Locale c() {
        if (f375333b == false) goto L9;
        Object r100 = a().getDeclaredMethod("getRegion", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L6
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L6
        String r101 = (String) r100;     // Catch: Exception -> L6
    L19:
        return new Locale(Locale.getDefault().getLanguage(), r101);
    L6:
        r101 = Locale.getDefault().getCountry();
        goto L19
    L9:
        if (Build.VERSION.SDK_INT < 24) goto L15;
        LocaleList r102 = Resources.getSystem().getConfiguration().getLocales();
        if (r102.isEmpty() == false) goto L13;
        Locale r103 = Locale.getDefault();
    L14:
        Locale r104 = r103;
        Intrinsics.checkNotNull(r104);
        return r104;
    L13:
        r103 = r102.get(0);
        goto L14
    L15:
        Locale r105 = Resources.getSystem().getConfiguration().locale;
        Intrinsics.checkNotNull(r105);
        return r105;
    }

    private AppLocaleUtils() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r101.getAction(), "android.intent.action.LOCALE_CHANGED") == false) goto L8;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new AppLocaleUtils$notifyChange$1(null), 2, null);
        return;
    }
}
