package com.obric.aiagent.sharedstate.log;

import android.text.TextUtils;
import kaa.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nJ\u0016\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002J\u0016\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002J\u0016\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002J\"\u0010\u0016\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\"\u0010\u0017\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014R\u0014\u0010\u0018\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u001aR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0011\u0010\u001d\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/obric/aiagent/sharedstate/log/SharedStateLogger;", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "message", "prefixTraceInfo", "getTraceInfo", "Lkaa/a;", "logger", XmlPullParser.NO_NAMESPACE, "setLogger", XmlPullParser.NO_NAMESPACE, "debug", "setDebug", "enable", "setEnableTrace", "tag", "msg", "v", "d", "i", XmlPullParser.NO_NAMESPACE, "t", "w", "e", "TAG", "Ljava/lang/String;", "Lkaa/a;", "Z", "enableTrace", "isDebug", "()Z", "<init>", "()V", "shared-state-sdk_release"}, k = 1, mv = {1, 7, 0})
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
        StackTraceElement[] r0 = new Throwable().getStackTrace();     // Catch: Exception -> L12
        int r1 = r0.length;     // Catch: Exception -> L12
        int r2 = 1;
    L3:
        if (r2 >= r1) goto L8;
        if (TextUtils.equals(r0[r2].getClassName(), "com.obric.aiagent.sharedstate.log.SharedStateLogger") == false) goto L6;
        r2 = r2 + 1;     // Catch: Exception -> L12
        goto L3
    L6:
        StackTraceElement r3 = r0[r2];     // Catch: Exception -> L12
    L9:
        if (r3 == null) goto L14;
        return "\t\t[" + r3 + ']';
    L14:
        return "\t\t[No Trace Info]";
    L8:
        r3 = null;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    public final boolean isDebug() {
        return debug;
    }

    private final String prefixTraceInfo(String r2) {
        if (enableTrace == true) goto L5;
        return r2;
    L5:
        return r2 + getTraceInfo();
    }

    public final void setDebug(boolean r1) {
        debug = r1;
    }

    public final void setEnableTrace(boolean r1) {
        enableTrace = r1;
    }

    public final void setLogger(a r2) {
        Intrinsics.checkNotNullParameter(r2, "logger");
        logger = r2;
    }

    public final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        String r4 = prefixTraceInfo(r3);
        if (debug == true) goto L10;
        a r0 = logger;
        if (r0 == null) goto L9;
        r0.d(r2, r4);
        return;
    L9:
        return;
    }

    public final void i(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        String r4 = prefixTraceInfo(r3);
        if (debug == true) goto L10;
        a r0 = logger;
        if (r0 == null) goto L9;
        r0.i(r2, r4);
        return;
    L9:
        return;
    }

    public final void v(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        String r4 = prefixTraceInfo(r3);
        if (debug == true) goto L10;
        a r0 = logger;
        if (r0 == null) goto L9;
        r0.v(r2, r4);
        return;
    L9:
        return;
    }

    public final void e(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        String r5 = prefixTraceInfo(r3);
        if (debug == true) goto L10;
        a r0 = logger;
        if (r0 == null) goto L9;
        r0.e(r2, r5, r4);
        return;
    L9:
        return;
    }

    public final void w(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        String r5 = prefixTraceInfo(r3);
        if (debug == true) goto L10;
        a r0 = logger;
        if (r0 == null) goto L9;
        r0.w(r2, r5, r4);
        return;
    L9:
        return;
    }

    public static /* synthetic */ void e$default(SharedStateLogger r0, String r1, String r2, Throwable r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.e(r1, r2, r3);
    }

    public static /* synthetic */ void w$default(SharedStateLogger r0, String r1, String r2, Throwable r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.w(r1, r2, r3);
    }
}
