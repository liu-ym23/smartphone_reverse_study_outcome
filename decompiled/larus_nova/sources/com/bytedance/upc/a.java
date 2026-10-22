package com.bytedance.upc;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.timon.upc.upc_adapter_impl.UpcLifecycleServiceImpl;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f272400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f272401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f272402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f272403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m f272404e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k f272405f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g f272406g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f f272407h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public UpcLifecycleServiceImpl.a f272408i;

    /* JADX INFO: renamed from: com.bytedance.upc.a$a, reason: collision with other inner class name */
    public static class C3812a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f272409a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e f272410b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b f272411c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public m f272412d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public k f272413e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public g f272414f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public f f272415g;

        public C3812a() {
        }

        public final a b() {
            if (this.f272409a != null) goto L6;
            this.f272409a = (c) a("com.bytedance.upc.web.InnerWebViewService").newInstance();     // Catch: Throwable -> L37
        L6:
            if (this.f272411c != null) goto L11;
            this.f272411c = (b) a("com.bytedance.upc.bridge.UpcBridgeService").newInstance();     // Catch: Throwable -> L9
        L11:
            if (this.f272410b != null) goto L16;
            this.f272410b = (e) a("com.bytedance.upc.privacy.UpcPrivacyService").newInstance();     // Catch: Throwable -> L14
        L16:
            if (this.f272415g != null) goto L23;
            if (this.f272414f != null) goto L23;
            this.f272415g = (f) a("com.bytedance.upc.third.authorize.UpcThirdAuthorizeService").newInstance();     // Catch: Throwable -> L21
        L23:
            if (this.f272414f != null) goto L28;
            this.f272414f = (g) a("com.bytedance.upc.third.authorize.UpcThirdAuthorizeService").newInstance();     // Catch: Throwable -> L26
        L28:
            if (this.f272413e != null) goto L33;
            this.f272413e = (k) a("com.bytedance.upc.dialog.UpcDialogService").newInstance();     // Catch: Throwable -> L31
        L33:
            if (this.f272412d != null) goto L36;
            this.f272412d = (m) a("com.bytedance.upc.teen.UpcTeenService").newInstance();     // Catch: Throwable -> L38
        L36:
            return new a(this);
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class a(String r100) throws ClassNotFoundException {
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
    }

    public a() {
    }

    public a(C3812a r100) {
        r100.getClass();
        this.f272401b = r100.f272409a;
        this.f272402c = r100.f272410b;
        this.f272403d = r100.f272411c;
        this.f272404e = r100.f272412d;
        this.f272405f = r100.f272413e;
        this.f272406g = r100.f272414f;
        this.f272407h = r100.f272415g;
    }
}
