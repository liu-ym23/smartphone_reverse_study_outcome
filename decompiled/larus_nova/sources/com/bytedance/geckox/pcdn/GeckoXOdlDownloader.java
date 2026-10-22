package com.bytedance.geckox.pcdn;

import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import me.ele.lancet.base.annotations.Skip;
import rr0.b;
import wy5.c;

/* JADX INFO: loaded from: classes19.dex */
public final class GeckoXOdlDownloader {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicInteger f245091e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile b f245092f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile File f245093g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f245094h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f245095i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f245096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f245097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PrepareMeta f245098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final py5.b f245099d;

    public static final class a {
        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class a() throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r102 = Class.forName("com.bytedance.android.live.pcdn.impl.PCDNDownloader");     // Catch: Throwable -> L8
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a("com.bytedance.android.live.pcdn.impl.PCDNDownloader");     // Catch: Throwable -> L8
        L7:
            return r102;
        L8:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b("com.bytedance.android.live.pcdn.impl.PCDNDownloader");
        L12:
            throw th;
        L34:
            Class<?> r103 = Class.forName("com.bytedance.android.live.pcdn.impl.PCDNDownloader");     // Catch: Throwable -> L17
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a("com.bytedance.android.live.pcdn.impl.PCDNDownloader");     // Catch: Throwable -> L17
        L16:
            return r103;
        L17:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b("com.bytedance.android.live.pcdn.impl.PCDNDownloader");
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName("com.bytedance.android.live.pcdn.impl.PCDNDownloader");
        }

        public a() {
        }
    }

    static {
        f245095i = new a();
        f245091e = new AtomicInteger(0);
        f245094h = LazyKt.lazy(GeckoXOdlDownloader$Companion$odlListenerImpl$2.INSTANCE);
    }

    public final void a() {
        if (this.f245096a == null) goto L10;
        this.f245098c.getPackage().getMd5();
        this.f245098c.getAccessKey();
        this.f245098c.getChannel();
        this.f245098c.getVersion();
        new Ref.ObjectRef().element = null;
        py5.b r100 = this.f245099d;
        String r101 = this.f245097b;
        String r102 = UriProtector.parse(r101).getHost();
        if (r102 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        r100.f531036b = new c(r101, r102, this.f245098c.getPackage().getLength());
        System.currentTimeMillis();
        this.f245096a.a();
        throw new IllegalStateException("Create odl task failed, receive null");
    L10:
        throw new IllegalStateException("Odl downloader still be null, do you invoke initIfNeed?");
    }

    public GeckoXOdlDownloader(String r100, String r101, PrepareMeta r102, py5.b r103) {
        this.f245097b = r100;
        this.f245098c = r102;
        this.f245099d = r103;
        f245091e.incrementAndGet();
        this.f245096a = f245092f;
    }
}
