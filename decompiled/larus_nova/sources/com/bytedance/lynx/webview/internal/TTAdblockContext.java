package com.bytedance.lynx.webview.internal;

import com.bytedance.lynx.webview.adblock.TTAdblockClient;
import com.bytedance.lynx.webview.glue.ISdkToGlue;
import com.bytedance.lynx.webview.glue.TTWebProviderWrapper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes21.dex */
public final class TTAdblockContext {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f265196b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f265197c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f265198a;

    public static final enum AdblockMode extends Enum<AdblockMode> {
        public static final AdblockMode SDK_ADBLOCK_MODE = null;
        public static final AdblockMode SMART_MODE = null;
        public static final AdblockMode TTWEBVIEW_ADBLOCK_MODE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AdblockMode[] f265199a = null;
        private final int code;

        static {
            AdblockMode r100 = new AdblockMode("SMART_MODE", 0, 0);
            SMART_MODE = r100;
            AdblockMode r101 = new AdblockMode("SDK_ADBLOCK_MODE", 1, 1);
            SDK_ADBLOCK_MODE = r101;
            AdblockMode r102 = new AdblockMode("TTWEBVIEW_ADBLOCK_MODE", 2, 2);
            TTWEBVIEW_ADBLOCK_MODE = r102;
            f265199a = new AdblockMode[]{r100, r101, r102};
        }

        public static AdblockMode[] values() {
            return (AdblockMode[]) f265199a.clone();
        }

        public int getCode() {
            return this.code;
        }

        public static AdblockMode getModeFromInt(int r100) {
            AdblockMode r101 = SMART_MODE;
            if (r100 != r101.code) goto L5;
            return r101;
        L5:
            AdblockMode r102 = SDK_ADBLOCK_MODE;
            if (r100 != r102.code) goto L8;
            return r102;
        L8:
            AdblockMode r103 = TTWEBVIEW_ADBLOCK_MODE;
            if (r100 != r103.code) goto L11;
            return r103;
        L11:
            return r101;
        }

        public static AdblockMode valueOf(String r100) {
            return (AdblockMode) r27.a.a(AdblockMode.class, r100);
        }

        public AdblockMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.code = r102;
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f265200a = null;

        static {
            int[] r100 = new int[AdblockMode.values().length];
            f265200a = r100;
            r100[AdblockMode.SMART_MODE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f265200a[AdblockMode.SDK_ADBLOCK_MODE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f265200a[AdblockMode.TTWEBVIEW_ADBLOCK_MODE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        f265196b = new AtomicBoolean(false);
        f265197c = new AtomicBoolean(false);
    }

    public static boolean d() {
        AtomicBoolean r100 = f265196b;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (r100.compareAndSet(false, true) == false) goto L8;
        f265197c.set(a());     // Catch: Throwable -> L11
    L8:
        boolean r101 = f265197c.get();     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        return r101;
    }

    public TTAdblockContext() {
        this.f265198a = new AtomicBoolean(false);
    }

    public static boolean a() {
        b();
        AdblockMode r100 = AdblockMode.getModeFromInt(Setting.c().d("sdk_adblock_mode", AdblockMode.SMART_MODE.getCode()));
        int r101 = a.f265200a[r100.ordinal()];
        if (r101 != 1) goto L5;
        TTWebContext.h().getClass();
        if (TTWebContext.l(false).matches(Setting.c().g("sdk_adblock_whitelist")) == false) goto L14;
        return false;
    L14:
        if (TTWebContext.r() == false) goto L21;
        ISdkToGlue r102 = a1.a();
        if (r102 == null) goto L18;
        boolean r103 = ((i17.b) r102).isTTwebviewAdblockAvailable();
    L19:
        if (r103 == false) goto L21;
        return true;
    L18:
        r103 = false;
    L21:
        return false;
    L5:
        if (r101 == 2) goto L7;
        return true;
    L7:
        return false;
    }

    public static void b() {
        TTWebProviderWrapper r100 = TTWebContext.h().f265216b.m();
        if (r100 == null) goto L6;
        r100.ensureFactoryProviderCreated(false);
        return;
    }

    public static boolean c() {
        if (d() == false) goto L8;
        ISdkToGlue r100 = a1.a();
        if (r100 != null) goto L7;
        return false;
    L7:
        return ((i17.b) r100).isAdblockEffective();
    L8:
        TTAdblockClient r101 = TTAdblockClient.b.f265047a;
        if (r101.e() == true) goto L11;
        return false;
    L11:
        if (r101.f265039e.f265058a == null) goto L13;
        boolean r102 = true;
    L14:
        if (r102 == false) goto L19;
        return true;
    L19:
        return false;
    L13:
        r102 = false;
        goto L14
    }
}
