package com.ss.android.ugc.effectmanager.common.logger;

import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import tb2.c;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0007J\u0018\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0007J\u001a\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0007J$\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fH\u0002J\u0018\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0007J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0004H\u0007J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\nH\u0007J\u0018\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0007R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/ss/android/ugc/effectmanager/common/logger/EPLog;", "", "()V", "sEnableLog", "", "getSEnableLog", "()Z", "setSEnableLog", "(Z)V", "sLogger", "Lcom/ss/android/ugc/effectmanager/common/logger/ILogger;", "sdkTag", "", "addSDKTagString", "", "tagStr", "d", "tag", "msg", "e", "t", "", "getSDKTag", RXScreenCaptureService.KEY_INDEX, "setEnableLog", "enable", "setLogger", "logger", "w", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class EPLog {
    public static final EPLog INSTANCE = null;
    private static boolean sEnableLog;
    private static ILogger sLogger;
    private static String sdkTag;

    private EPLog() {
    }

    static {
        INSTANCE = new EPLog();
        sLogger = DefaultLogger.INSTANCE;
        sEnableLog = true;
        sdkTag = EPLogKt.LOG_TAG;
    }

    public final boolean getSEnableLog() {
        return sEnableLog;
    }

    @JvmStatic
    public static final void addSDKTagString(String r100) {
        sdkTag = sdkTag + '-' + r100;
    }

    private final String getSDKTag(String r100) {
        return "[" + sdkTag + '#' + r100 + "]:";
    }

    @JvmStatic
    public static final void setEnableLog(boolean r100) {
        sEnableLog = r100;
    }

    @JvmStatic
    public static final void setLogger(ILogger r100) {
        sLogger = r100;
    }

    public final void setSEnableLog(boolean r100) {
        sEnableLog = r100;
    }

    @JvmStatic
    public static final void d(String r100, String r101) {
        sLogger.d(INSTANCE.getSDKTag(r100) + c.DEFAULT_TEXT + r101);
    }

    @JvmStatic
    public static final void e(String r100, String r101) {
        sLogger.e(INSTANCE.getSDKTag(r100) + c.DEFAULT_TEXT + r101, null);
    }

    @JvmStatic
    public static final void i(String r100, String r101) {
        sLogger.i(INSTANCE.getSDKTag(r100) + c.DEFAULT_TEXT + r101);
    }

    @JvmStatic
    public static final void w(String r100, String r101) {
        sLogger.w(INSTANCE.getSDKTag(r100) + c.DEFAULT_TEXT + r101);
    }

    @JvmStatic
    public static final void e(String r100, String r101, Throwable r102) {
        sLogger.e(INSTANCE.getSDKTag(r100) + c.DEFAULT_TEXT + r101, r102);
    }
}
