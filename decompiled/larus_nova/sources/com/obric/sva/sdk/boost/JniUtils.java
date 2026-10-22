package com.obric.sva.sdk.boost;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0086 J\t\u0010\u0006\u001a\u00020\u0005H\u0086 ¨\u0006\u0007"}, d2 = {"Lcom/obric/sva/sdk/boost/JniUtils;", "", "<init>", "()V", "getThreadTid", "", "memoryPurge", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JniUtils {
    public static final JniUtils INSTANCE = null;

    private JniUtils() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public final native int getThreadTid();

    public final native int memoryPurge();

    static {
        INSTANCE = new JniUtils();
        INVOKESTATIC_com_obric_sva_sdk_boost_JniUtils_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("thread-jni-lib");
    }

    @JvmStatic
    public static void INVOKESTATIC_com_obric_sva_sdk_boost_JniUtils_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }
}
