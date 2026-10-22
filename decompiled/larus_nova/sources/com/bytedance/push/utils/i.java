package com.bytedance.push.utils;

import android.os.SystemProperties;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile i f267070i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f267071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f267072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f267073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile Object f267074d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f267075e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f267076f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f267077g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f267078h;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.os.SystemProperties");
    }

    public static i c() {
        if (f267070i != null) goto L15;
        monitor-enter(i.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f267070i != null) goto L9;
        f267070i = new i();     // Catch: Throwable -> L11
    L9:
        monitor-exit(i.class);     // Catch: Throwable -> L11
    L15:
        return f267070i;
    }

    public final int d() {
        if (j() == true) goto L18;
        return -1;
    L18:
        if (TextUtils.isEmpty(this.f267075e) == true) goto L16;
        if (this.f267075e.length() < 2) goto L16;
        String r100 = this.f267075e.substring(1);     // Catch: Throwable -> L17
        if (r100.indexOf(".") <= 0) goto L12;
        r100 = r100.substring(0, r100.indexOf("."));     // Catch: Throwable -> L17
    L12:
        int r101 = CastIntegerProtector.parseInt(r100);     // Catch: Throwable -> L17
        if (r101 < 100) goto L20;
        return r101 / 10;
    L20:
        return r101;
    L16:
        return -1;
    }

    public final Object e() {
        if (this.f267074d != null) goto L18;
        monitor-enter(i.class);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (this.f267074d == null) goto L19;
    L12:
        monitor-exit(i.class);     // Catch: Throwable -> L14
        goto L18
    L19:
        this.f267074d = a().newInstance();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
    L18:
        return this.f267074d;
    }

    public final boolean f() {
        if (TextUtils.isEmpty(this.f267078h) == false) goto L6;
        this.f267078h = b(com.alipay.sdk.m.c.a.f25238a);
    L6:
        return !TextUtils.isEmpty(this.f267078h);
    }

    public final boolean g() {
        if (TextUtils.isEmpty(this.f267077g) == false) goto L6;
        this.f267077g = b("ro.vivo.os.build.display.id");
    L6:
        return !TextUtils.isEmpty(this.f267077g);
    }

    public final boolean h() {
        if (f() == true) goto L20;
        return false;
    L20:
        if (this.f267071a == (-1.0d)) goto L8;
    L14:
        if (this.f267071a < 10.0d) goto L22;
        return true;
    L22:
        return false;
    L8:
        if (TextUtils.isEmpty(this.f267078h) == false) goto L10;
        return false;
    L10:
        String r100 = this.f267078h;     // Catch: Throwable -> L19
        String r101 = r100.substring(r100.indexOf("_") + 1);     // Catch: Throwable -> L19
        if (r101.indexOf(".") <= 0) goto L13;
        r101 = r101.substring(0, r101.indexOf("."));     // Catch: Throwable -> L19
    L13:
        this.f267071a = CastDoubleProtector.parseDouble(r101);     // Catch: Throwable -> L19
    L23:
        return false;
    }

    public final boolean i() {
        if (g() == true) goto L21;
        return false;
    L21:
        if (this.f267073c == (-1.0d)) goto L8;
    L15:
        if (this.f267073c > 4.0d) goto L23;
        return true;
    L23:
        return false;
    L8:
        if (TextUtils.isEmpty(this.f267077g) == true) goto L15;
        if (this.f267077g.length() < 2) goto L15;
        String r100 = this.f267077g;     // Catch: Throwable -> L20
        String r101 = r100.substring(r100.indexOf("_") + 1);     // Catch: Throwable -> L20
        if (r101.indexOf(".") <= 0) goto L14;
        r101 = r101.substring(0, r101.indexOf("."));     // Catch: Throwable -> L20
    L14:
        this.f267073c = CastDoubleProtector.parseDouble(r101);     // Catch: Throwable -> L20
    L24:
        return false;
    }

    public final boolean j() {
        if (TextUtils.isEmpty(this.f267075e) == false) goto L6;
        this.f267075e = SystemProperties.get("ro.miui.ui.version.name", "");
    L6:
        return !TextUtils.isEmpty(this.f267075e);
    }

    public i() {
        this.f267071a = -1.0d;
        this.f267072b = -1.0d;
        this.f267073c = -1.0d;
    }

    public final String b(String r100) throws IllegalArgumentException {
        return SystemProperties.get(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        Object r101 = e();     // Catch: Throwable -> L8 IllegalArgumentException -> L10
    L16:
        return (String) r101.getClass().getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r101, new Object[]{r100});
    L10:
        e = move-exception;
        throw e;
    L8:
        return "";
    }
}
