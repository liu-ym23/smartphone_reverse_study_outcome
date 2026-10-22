package com.larus.im.internal.network.link.impl.rtc.smartnetwork;

import android.system.Os;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0082 J\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/im/internal/network/link/impl/rtc/smartnetwork/SocketDscpSet;", "", "<init>", "()V", "SET_OPT_SUCCESS", "", "SET_OPT_FAILED", "SET_OPT_TCP_SOCKET_TYPE", "PROC_FD_DIR", "", "DSCP_VALUE", "nativeSetSockOpt", "fd", "tos", "setAllSocketsDscp", "", "Companion", "OApp.flowSDK.baseSDK.common.avsdk-flow-impl"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SocketDscpSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f349345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f349346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f349347c;

    public static final class a {
    }

    private final native int nativeSetSockOpt(int r100, int r101);

    static {
        a();     // Catch: UnsatisfiedLinkError -> L5
        return;
    L5:
        e = move-exception;
        fe9.a.f476620a.c("SmartNetwork", "load smartnetwork so failed", e);
    }

    @JvmStatic
    public static void a() {
        Intrinsics.checkNotNullParameter("smartnetwork", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> smartnetwork");
        com.bytedance.librarian.a.c("smartnetwork");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> smartnetwork");
    }

    public final void b() {
        fe9.a.f476620a.e("SmartNetwork", "call setAllSocketsDscp");
        File[] r100 = new PolarisFileWrapper(this.f349346b).listFiles();
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = r100.length;
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L27;
        File r103 = r100[r102];
    L24:
        e = move-exception;
        fe9.a.f476620a.c("SmartNetwork", "Error readlink " + r103, e);
    L26:
        r102 = r102 + 1;
        goto L6
    L9:
        if (r103.exists() == true) goto L11;
        fe9.a.f476620a.e("SmartNetwork", "File descriptor " + r103.getAbsolutePath() + " does not exist");     // Catch: Exception -> L24
        goto L26
    L11:
        String r104 = Os.readlink(r103.getAbsolutePath());     // Catch: Exception -> L24
        Intrinsics.checkNotNull(r104);     // Catch: Exception -> L24
        if (StringsKt.startsWith$default(r104, "socket:[", false, 2, null) == false) goto L26;
        int r105 = nativeSetSockOpt(CastIntegerProtector.parseInt(r103.getName()), this.f349347c << 2);     // Catch: UnsatisfiedLinkError -> L21 Exception -> L24
        if (r105 != 0) goto L18;
        fe9.a.f476620a.e("SmartNetwork", "Set DSCP success on fd:" + r103.getName());     // Catch: UnsatisfiedLinkError -> L21 Exception -> L24
        goto L26
    L18:
        if (r105 != this.f349345a) goto L26;
        fe9.a.f476620a.b("SmartNetwork", "Set DSCP failed on fd:" + r103.getName());     // Catch: UnsatisfiedLinkError -> L21 Exception -> L24
        goto L26
    L21:
        e = move-exception;
        fe9.a.f476620a.c("SmartNetwork", "call nativeSetSockOpt failed on fd:" + r103.getName(), e);     // Catch: Exception -> L24
        return;
    }

    public SocketDscpSet() {
        this.f349345a = -1;
        this.f349346b = "/proc/self/fd";
        this.f349347c = 46;
    }
}
