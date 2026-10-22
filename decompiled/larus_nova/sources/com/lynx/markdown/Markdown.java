package com.lynx.markdown;

import com.larus.utils.logger.FLogger;
import com.lynx.textra.TTText;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public class Markdown {
    private static final long TIMEOUT = 5;
    private static volatile boolean mInitializeStarted;
    private static volatile boolean mInitialized;
    private static final CountDownLatch mInitializedLatch = null;

    public Markdown() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    private static native void initialClassCache();

    static {
        mInitializedLatch = new CountDownLatch(1);
    }

    public static void ensureInitialized() {
        if (mInitialized == false) goto L13;
        return;
    L13:
        init(null);     // Catch: InterruptedException -> L10
        if (mInitializedLatch.await(5, TimeUnit.SECONDS) == false) goto L9;
        return;
    L9:
        throw new RuntimeException("Markdown initialization timed out.");     // Catch: InterruptedException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    @JvmStatic
    public static void INVOKESTATIC_com_lynx_markdown_Markdown_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static void init(d r100) {
        if (mInitializeStarted == false) goto L6;
        return;
    L6:
        monitor-enter(Markdown.class);
    L26:
        th = move-exception;
        throw th;
    L8:
        if (mInitializeStarted == false) goto L11;
        monitor-exit(Markdown.class);     // Catch: Throwable -> L26
        return;
    L11:
        mInitializeStarted = true;     // Catch: Throwable -> L26
        monitor-exit(Markdown.class);     // Catch: Throwable -> L26
        if (r100 == null) goto L15;
        r100.a();     // Catch: Throwable -> L18 Exception -> L20
    L16:
        TTText.Initial();     // Catch: Throwable -> L18 Exception -> L20
        initialClassCache();     // Catch: Throwable -> L18 Exception -> L20
    L22:
        mInitialized = true;
        mInitializedLatch.countDown();
        return;
    L15:
        INVOKESTATIC_com_lynx_markdown_Markdown_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("serval_markdown");     // Catch: Throwable -> L18 Exception -> L20
    L18:
        th = move-exception;
        mInitialized = true;
        mInitializedLatch.countDown();
        throw th;
    L20:
        e = move-exception;
        e.toString();     // Catch: Throwable -> L18
        goto L22
    }
}
