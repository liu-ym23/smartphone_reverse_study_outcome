package com.bytedance.debugrouter.net;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import com.lynx.debugrouter.base.NativeMessageTransceiver;
import com.lynx.debugrouter.base.net.IDebugRouterWebSocketService;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public class DebugRouterWebSocketServiceImpl implements IDebugRouterWebSocketService {
    private static final String TAG = "DebugRouterWebSocketServiceImpl";

    public DebugRouterWebSocketServiceImpl() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_debugrouter_net_DebugRouterWebSocketServiceImpl_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    @Override // com.lynx.debugrouter.base.net.IDebugRouterWebSocketService
    public NativeMessageTransceiver init(long r100) {
        INVOKESTATIC_com_bytedance_debugrouter_net_DebugRouterWebSocketServiceImpl_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("sscronet-wrapper-helper");     // Catch: Throwable -> L4
    L6:
        WebSocketNativeClient r101 = new WebSocketNativeClient(r100);
        if (r101.init() == true) goto L10;
        return null;
    L10:
        return r101;
    L4:
        th = move-exception;
        th.toString();
        goto L6
    }
}
