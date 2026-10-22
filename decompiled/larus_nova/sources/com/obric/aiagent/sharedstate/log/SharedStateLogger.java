package com.obric.aiagent.sharedstate.log;

import android.text.TextUtils;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kaa.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nJ\u0016\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002J\u0016\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002J\u0016\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002J\"\u0010\u0016\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\"\u0010\u0017\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014R\u0014\u0010\u0018\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u001aR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0011\u0010\u001d\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/obric/aiagent/sharedstate/log/SharedStateLogger;", "", "", "message", "prefixTraceInfo", "getTraceInfo", "Lkaa/a;", "logger", "", "setLogger", "", "debug", "setDebug", "enable", "setEnableTrace", "tag", "msg", BaseSwitches.V, "d", RXScreenCaptureService.KEY_INDEX, "", "t", "w", "e", "TAG", "Ljava/lang/String;", "Lkaa/a;", "Z", "enableTrace", "isDebug", "()Z", "<init>", "()V", "shared-state-sdk_release"}, k = 1, mv = {1, 7, 0})
public final class SharedStateLogger {
    public static final SharedStateLogger INSTANCE = null;
    public static final String TAG = "SharedState";
    private static boolean debug;
    private static boolean enableTrace;
    private static a logger;

    static {
        INSTANCE = new SharedStateLogger();
    }

    private SharedStateLogger() {
    }

    private final String getTraceInfo() {
        StackTraceElement[] r100 = new Throwable().getStackTrace();     // Catch: Exception -> L12
        int r101 = r100.length;     // Catch: Exception -> L12
        int r102 = 1;
    L3:
        if (r102 >= r101) goto L8;
        if (TextUtils.equals(r100[r102].getClassName(), "com.obric.aiagent.sharedstate.log.SharedStateLogger") == false) goto L6;
        r102 = r102 + 1;     // Catch: Exception -> L12
        goto L3
    L6:
        StackTraceElement r103 = r100[r102];     // Catch: Exception -> L12
    L9:
        if (r103 == null) goto L14;
        return "\t\t[" + r103 + ']';
    L14:
        return "\t\t[No Trace Info]";
    L8:
        r103 = null;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    public final boolean isDebug() {
        return debug;
    }

    private final String prefixTraceInfo(String r100) {
        if (enableTrace == true) goto L5;
        return r100;
    L5:
        return r100 + getTraceInfo();
    }

    public final void setDebug(boolean r100) {
        debug = r100;
    }

    public final void setEnableTrace(boolean r100) {
        enableTrace = r100;
    }

    public final void setLogger(a r100) {
        Intrinsics.checkNotNullParameter(r100, "logger");
        logger = r100;
    }

    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        String r102 = prefixTraceInfo(r101);
        if (debug == true) goto L10;
        a r103 = logger;
        if (r103 == null) goto L9;
        r103.d(r100, r102);
        return;
    L9:
        return;
    }

    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        String r102 = prefixTraceInfo(r101);
        if (debug == true) goto L10;
        a r103 = logger;
        if (r103 == null) goto L9;
        r103.i(r100, r102);
        return;
    L9:
        return;
    }

    public final void v(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        String r102 = prefixTraceInfo(r101);
        if (debug == true) goto L10;
        a r103 = logger;
        if (r103 == null) goto L9;
        r103.v(r100, r102);
        return;
    L9:
        return;
    }

    public final void e(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        String r103 = prefixTraceInfo(r101);
        if (debug == true) goto L10;
        a r104 = logger;
        if (r104 == null) goto L9;
        r104.e(r100, r103, r102);
        return;
    L9:
        return;
    }

    public final void w(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        String r103 = prefixTraceInfo(r101);
        if (debug == true) goto L10;
        a r104 = logger;
        if (r104 == null) goto L9;
        r104.w(r100, r103, r102);
        return;
    L9:
        return;
    }

    public static /* synthetic */ void e$default(SharedStateLogger r100, String r101, String r102, Throwable r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = null;
    L5:
        r100.e(r101, r102, r103);
    }

    public static /* synthetic */ void w$default(SharedStateLogger r100, String r101, String r102, Throwable r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = null;
    L5:
        r100.w(r101, r102, r103);
    }
}
