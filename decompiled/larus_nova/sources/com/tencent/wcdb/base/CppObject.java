package com.tencent.wcdb.base;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public class CppObject implements CppObjectConvertible {
    protected long cppObj;

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public static native void releaseCPPObject(long r100);

    @Override // com.tencent.wcdb.base.CppObjectConvertible
    public CppObject asCppObject() {
        return this;
    }

    public void finalize() throws Throwable {
        long r100 = this.cppObj;
        this.cppObj = 0;
        if (r100 <= 0) goto L5;
        releaseCPPObject(r100);
    L5:
        super.finalize();
    }

    static {
        INVOKESTATIC_com_tencent_wcdb_base_CppObject_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("wcdb2");
    }

    public CppObject() {
        this.cppObj = 0;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_tencent_wcdb_base_CppObject_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static long get(CppObjectConvertible r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.asCppObject().cppObj;
    }

    public static long get(CppObject r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.cppObj;
    }
}
