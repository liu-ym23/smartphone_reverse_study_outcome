package com.bytedance.push;

import android.app.Application;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bytepoet.push.BytePoetConfig;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.push.Triple;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultKeyConfiguration implements yfc.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f266709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f266710b;

    @Override // yfc.c
    public Pair<String, String> d() {
        return null;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static void f() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class.forName("com.bytedance.bytepoet.push.BytePoetConfig");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L36;
        FastClassNotFoundHandler.a("com.bytedance.bytepoet.push.BytePoetConfig");     // Catch: Throwable -> L8
        return;
    L36:
        return;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.bytepoet.push.BytePoetConfig");
    L12:
        throw th;
    L34:
        Class.forName("com.bytedance.bytepoet.push.BytePoetConfig");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L37;
        FastClassNotFoundHandler.a("com.bytedance.bytepoet.push.BytePoetConfig");     // Catch: Throwable -> L17
        return;
    L37:
        return;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.bytepoet.push.BytePoetConfig");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == false) goto L26;
    L29:
        MiraPluginFix.forName("com.bytedance.bytepoet.push.BytePoetConfig");
        return;
    L26:
        if ((th instanceof NoClassDefFoundError) == true) goto L29;
        throw th;
    }

    @Override // yfc.c
    public final Pair<String, String> a() {
        return new Pair("2882303761520268911", "5292026847911");
    }

    @Override // yfc.c
    public final Pair<String, String> b() {
        return new Pair(e.MZ_PUSH_APP_ID, e.MZ_PUSH_APP_KEY);
    }

    @Override // yfc.c
    public final Pair<String, String> c() {
        return new Pair("2db17eefc57d4ba085ca61e69b363378", "23e85bf7205f428ebcb2179030c551a6");
    }

    @Override // yfc.c
    public final Triple<String, String, String> e() {
        return new AnonymousClass1(this);
    }

    public final void g(Application r100) {
        String r101 = r100.getPackageName();
        if (this.f266710b == false) goto L11;
        f();     // Catch: ClassNotFoundException -> L6
        boolean r102 = true;
    L7:
        if (r102 == true) goto L11;
        com.bytedance.push.utils.f.b("init", "i18n version，configuration not exist。ignore!");
        return;
    L6:
        r102 = false;
    L11:
        if (TextUtils.equals(r101, BytePoetConfig.PACKAGE_NAME) == false) goto L18;
        if (BytePoetConfig.SUPPORT_SDK_VERSION < 1) goto L16;
        return;
    L16:
        throw new IllegalArgumentException("configuration version mismatch，please go to [https://appcloud.bytedance.net/client-sdk/config] and generate new configuration again");
    L18:
        throw new IllegalArgumentException("packageName is different between configuration");
    }

    public DefaultKeyConfiguration(boolean r100, String r101) {
        this.f266710b = r100;
        this.f266709a = r101;
    }
}
