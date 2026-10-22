package s07;

import com.larus.utils.logger.FLogger;
import com.lynx.tasm.base.TraceEvent;
import i8a.l;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f540023a = null;

    static {
        f540023a = new a();
    }

    @JvmStatic
    public static void f() {
        Intrinsics.checkNotNullParameter("lynxservice", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> lynxservice");
        com.bytedance.librarian.a.c("lynxservice");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> lynxservice");
    }

    @Override // i8a.l
    public final boolean doInitialize() {
        TraceEvent.beginSection("LynxServiceSoLoader.doInitialize");
        f();     // Catch: Throwable -> L5 Throwable -> L8
        TraceEvent.endSection("LynxServiceSoLoader.doInitialize");
        return true;
    L8:
        TraceEvent.endSection("LynxServiceSoLoader.doInitialize");
        return false;
    L5:
        th = move-exception;
        TraceEvent.endSection("LynxServiceSoLoader.doInitialize");
        throw th;
    }

    public a() {
    }
}
