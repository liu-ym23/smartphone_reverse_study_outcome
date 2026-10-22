package com.bytedance.push.third;

import com.bytedance.common.utility.StringUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.push.utils.k;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends k<c> implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f267042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f267043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f267044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f267045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IPushAdapter f267046e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f267047f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j87.b f267048g;

    @Override // com.bytedance.push.third.c
    public final boolean isSupport() {
        com.bytedance.push.utils.f.g("PushChannel", "[isSupport]channelId:" + this.f267042a + " mInited:" + this.f267045d + " mIsSupport:" + this.f267044c);
        if (this.f267045d == true) goto L6;
        this.f267044c = this.f267048g.a(this.f267046e, this.f267042a);
        com.bytedance.push.utils.f.g("PushChannel", "[isSupport]channelId:" + this.f267042a + " mBaseChannelSupportHelper:" + this.f267048g + " mIPushAdapter:" + this.f267046e + " invoke isSupportChannel result:" + this.f267044c);
        this.f267045d = true;
    L6:
        return this.f267044c;
    }

    @Override // com.bytedance.push.third.c
    public final String a() {
        return this.f267047f;
    }

    @Override // com.bytedance.push.third.c
    public final IPushAdapter b() {
        return this.f267046e;
    }

    @Override // com.bytedance.push.third.c
    public final String c() {
        return this.f267043b;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class d(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
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
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
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

    @Override // com.bytedance.push.utils.k
    public final c create(Object[] r100) {
        if (StringUtils.isEmpty(this.f267043b) == false) goto L13;
    L12:
        return this;
    L13:
        Object r101 = d(this.f267043b).newInstance();     // Catch: Throwable -> L10
        if ((r101 instanceof IPushAdapter) == false) goto L8;
        this.f267046e = (IPushAdapter) r101;     // Catch: Throwable -> L10
    L8:
        com.bytedance.push.utils.f.g("PushManager", "load PushManagerImpl success: " + this.f267043b);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        com.bytedance.push.utils.f.e("PushManager", "load PushManagerImpl exception: " + this.f267043b + " exception is:" + th);
        goto L12
    }

    public e(int r100, String r101, String r102, j87.b r103) {
        this.f267044c = false;
        this.f267045d = false;
        this.f267042a = r100;
        this.f267043b = r101;
        this.f267047f = r102;
        this.f267048g = r103;
    }
}
