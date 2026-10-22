package com.lynx.canvas;

import android.content.res.AssetManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes32.dex */
public class CanvasFontRegistry {
    private static final String TAG = "CanvasFontRegistry";
    private static volatile CanvasFontRegistry mInstance;
    private final ArrayList<FontInfo> mFontInfoCache;
    private final HashSet<KryptonFontLazyProvider> mFontLazyProviders;
    private boolean mNativeReady;

    /* JADX INFO: renamed from: com.lynx.canvas.CanvasFontRegistry$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class FontInfo {
        public String familyName;
        public String localUrl;
        public int style;
        public int weight;

        private FontInfo() {
        }

        public /* synthetic */ FontInfo(AnonymousClass1 r100) {
            this();
        }
    }

    private native void nativeOnRegisterFontLazyProvider();

    private native boolean nativeRegisterFont(String r100, String r101, int r102, int r103);

    private void syncFontCacheOnNativeReady() {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.mNativeReady == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L7:
        this.mNativeReady = true;     // Catch: Throwable -> L16
        Iterator<FontInfo> r100 = this.mFontInfoCache.iterator();     // Catch: Throwable -> L16
    L9:
        if (r100.hasNext() == false) goto L11;
        FontInfo r101 = r100.next();     // Catch: Throwable -> L16
        nativeRegisterFont(r101.familyName, r101.localUrl, r101.weight, r101.style);     // Catch: Throwable -> L16
        goto L9
    L11:
        this.mFontInfoCache.clear();     // Catch: Throwable -> L16
        if (this.mFontLazyProviders.size() <= 0) goto L14;
        nativeOnRegisterFontLazyProvider();     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);     // Catch: Throwable -> L16
    }

    public HashSet<KryptonFontLazyProvider> copyLazyProviders() {
        monitor-enter(this);
        HashSet<KryptonFontLazyProvider> r100 = new HashSet(this.mFontLazyProviders);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public static CanvasFontRegistry GetInstance() {
        if (mInstance != null) goto L15;
        monitor-enter(CanvasFontRegistry.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new CanvasFontRegistry();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CanvasFontRegistry.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public CanvasFontRegistry() {
        this.mFontInfoCache = new ArrayList();
        this.mNativeReady = false;
        this.mFontLazyProviders = new HashSet();
    }

    private static AssetManager getAssetManager() {
        Krypton r100 = Krypton.inst();
    L7:
        th = move-exception;
        KryptonLLog.i(TAG, "getAssetManager error " + th.toString());
        return null;
    L4:
        if (r100.hasInitialized() == false) goto L13;
        return r100.getContext().getAssets();
    L13:
        return null;
    }

    public static void onNativeFirstUseComplexLayout() {
        Krypton.inst().loadLibrary("kryptoni18n", true);
    }

    public static void onNativeReady() {
        GetInstance().syncFontCacheOnNativeReady();
    }

    public void registerFontLazyProvider(KryptonFontLazyProvider r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        monitor-enter(this);
        this.mFontLazyProviders.add(r100);     // Catch: Throwable -> L10
        KryptonLLog.i(TAG, "register font lazy provider");     // Catch: Throwable -> L10
        if (this.mNativeReady == false) goto L8;
        nativeOnRegisterFontLazyProvider();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static String getLocalFontUrlFromPlatformProvider(String r100, int r101, int r102) {
        Iterator<KryptonFontLazyProvider> r103 = GetInstance().copyLazyProviders().iterator();
    L4:
        if (r103.hasNext() == false) goto L11;
        String r104 = r103.next().getLocalFontUrlByFamilyName(r100, r101, r102);
        if (r104 == null) goto L4;
        if (r104.length() <= 0) goto L4;
        KryptonLLog.i(TAG, "getLocalFontUrlByFamilyName " + r100 + " success " + r104);
        return r104;
    L11:
        KryptonLLog.i(TAG, "getLocalFontUrlByFamilyName " + r100 + " not found ");
        return "";
    }

    public boolean registerFont(String r100, String r101, int r102, int r103) {
        if (r100 != null) goto L4;
    L25:
        KryptonLLog.e(TAG, "registerFont " + r100 + " param error");
        return false;
    L4:
        if (r100.length() == 0) goto L25;
        if (r101 == null) goto L25;
        if (r101.length() == 0) goto L25;
        if (r102 < 0) goto L25;
        if (r103 < 0) goto L25;
        KryptonLLog.i(TAG, "registerFont ".concat(r100));
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L14:
        if (this.mNativeReady == false) goto L18;
        boolean r104 = nativeRegisterFont(r100, r101, r102, r103);     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        return r104;
    L18:
        FontInfo r105 = new FontInfo(null);     // Catch: Throwable -> L22
        r105.familyName = r100;     // Catch: Throwable -> L22
        r105.localUrl = r101;     // Catch: Throwable -> L22
        r105.weight = r102;     // Catch: Throwable -> L22
        r105.style = r103;     // Catch: Throwable -> L22
        this.mFontInfoCache.add(r105);     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        return true;
    }
}
