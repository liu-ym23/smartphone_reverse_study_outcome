package com.bytedance.lynx.webview.adblock;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public class TTWebViewAdblockWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f265052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f265053b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f265054a;

        @Override // java.lang.Runnable
        public final void run() {
            TTWebViewAdblockWrapper.a(this.f265054a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(long r100) {
            this.f265054a = r100;
        }
    }

    private static final native boolean nativeDeserialize(long r100);

    private static final native void nativeDestroy(long r100);

    private static final native void nativeEnableLog(long r100, boolean r101);

    private static final native int nativeGetEngineVersion();

    private static final native long nativeInit(String r100);

    private static final native long nativeInitV2(String r100, String r101);

    private static final native boolean nativeParseRulesFiles(long r100, String r101, String r102);

    private static final native boolean nativeParseRulesString(long r100, String r101);

    private static final native boolean nativeSerialize(long r100);

    private static final native boolean nativeShouldBlockUrlRequest(long r100, String r101, String r102, int r103, boolean r104);

    private static final native String nativeShouldHidingElement(long r100, String r101);

    static {
    }

    public static void a(long r100) {
        nativeDestroy(r100);     // Catch: UnsatisfiedLinkError -> L4
        return;
    }

    public final boolean c(String r100) {
        return nativeParseRulesString(this.f265052a, r100);
    L4:
        return false;
    }

    public final String e(String r100) {
        return nativeShouldHidingElement(this.f265052a, r100);
    L4:
        return "";
    }

    public TTWebViewAdblockWrapper(String r100, String r101) {
        int r102 = nativeGetEngineVersion();     // Catch: UnsatisfiedLinkError -> L5
    L15:
        if (r102 < 4) goto L9;
        this.f265052a = nativeInitV2(r100, r101);     // Catch: UnsatisfiedLinkError -> L12
    L10:
        this.f265053b = new e(this, new a(this.f265052a));     // Catch: UnsatisfiedLinkError -> L12
        return;
    L9:
        this.f265052a = nativeInit(r100);     // Catch: UnsatisfiedLinkError -> L12
    L17:
        return;
    L5:
        r102 = -1;
        goto L15
    }

    public final boolean b(String r100, String r101) {
        return nativeParseRulesFiles(this.f265052a, r100, r101);
    L4:
        return false;
    }

    public final boolean d(String r100, String r101, int r102) {
        return nativeShouldBlockUrlRequest(this.f265052a, r100, r101, r102, false);
    L5:
        return false;
    }
}
