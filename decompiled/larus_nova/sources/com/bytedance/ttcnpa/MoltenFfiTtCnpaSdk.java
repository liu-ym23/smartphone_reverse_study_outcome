package com.bytedance.ttcnpa;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ttcnpa/MoltenFfiTtCnpaSdk;", "", "<init>", "()V", "Companion", "ttcnpa_release"}, k = 1, mv = {1, 7, 1})
public final class MoltenFfiTtCnpaSdk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f271033a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ttcnpa/MoltenFfiTtCnpaSdk$Companion;", "", "<init>", "()V", "ttcnpa_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    private MoltenFfiTtCnpaSdk() {
    }

    @JvmStatic
    public static final native ByteBuffer MoltenFfiNativeCreateTtcnpaManagerX6049856645594224295(ByteBuffer r100) throws Exception;

    @JvmStatic
    public static final native String MoltenFfiNativeTtcnpaSetTempDirX8224852908850537143(String r100) throws Exception;

    @JvmStatic
    public static final native void freeNativeMemory(ByteBuffer r100) throws Exception;

    static {
        f271033a = new Companion(0);
        monitor-enter(Tt_cnpa_sdkKt.class);
        String r100 = System.getProperty("molten_ffi.tt_cnpa_sdk.lib_name");     // Catch: Throwable -> L12
        if (r100 == null) goto L8;
        monitor-exit(Tt_cnpa_sdkKt.class);
    L10:
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> ".concat(r100));
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> ".concat(r100));
        return;
    L8:
        r100 = "tt_cnpa_sdk";
        monitor-exit(Tt_cnpa_sdkKt.class);
    L12:
        th = move-exception;
        throw th;
    }
}
