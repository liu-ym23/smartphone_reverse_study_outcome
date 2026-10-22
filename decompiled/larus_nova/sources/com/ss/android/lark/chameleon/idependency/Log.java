package com.ss.android.lark.chameleon.idependency;

import com.lynx.tasm.LynxError;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0007J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0007J \u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0007J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0007J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0007R(\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/chameleon/idependency/Log;", "", "()V", "value", "Lcom/ss/android/lark/chameleon/idependency/ILog;", "iLog", "getILog", "()Lcom/ss/android/lark/chameleon/idependency/ILog;", "setILog", "(Lcom/ss/android/lark/chameleon/idependency/ILog;)V", "d", "", "tag", "", "msg", "e", LynxError.LYNX_THROWABLE, "", RXScreenCaptureService.KEY_INDEX, BaseSwitches.V, "w", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Log {
    public static final Log INSTANCE = null;
    private static ILog iLog;

    static {
        INSTANCE = new Log();
    }

    private Log() {
    }

    public final ILog getILog() {
        return iLog;
    }

    public final void setILog(ILog r100) {
        iLog = r100;
    }

    @JvmStatic
    public static final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        ILog r102 = iLog;
        if (r102 == null) goto L6;
        r102.d(r100, r101);
        return;
    }

    @JvmStatic
    public static final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        ILog r102 = iLog;
        if (r102 == null) goto L6;
        r102.e(r100, r101);
        return;
    }

    @JvmStatic
    public static final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        ILog r102 = iLog;
        if (r102 == null) goto L6;
        r102.i(r100, r101);
        return;
    }

    @JvmStatic
    public static final void v(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        ILog r102 = iLog;
        if (r102 == null) goto L6;
        r102.v(r100, r101);
        return;
    }

    @JvmStatic
    public static final void w(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        ILog r102 = iLog;
        if (r102 == null) goto L6;
        r102.w(r100, r101);
        return;
    }

    @JvmStatic
    public static final void e(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, LynxError.LYNX_THROWABLE);
        ILog r103 = iLog;
        if (r103 == null) goto L6;
        r103.e(r100, r101, r102);
        return;
    }
}
