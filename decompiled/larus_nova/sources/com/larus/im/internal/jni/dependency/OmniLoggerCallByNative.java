package com.larus.im.internal.jni.dependency;

import com.larus.im.internal.delegate.d1;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 \u00132\u00020\u0001:\u0002\u0013\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J \u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J \u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0002¨\u0006\u0015"}, d2 = {"Lcom/larus/im/internal/jni/dependency/OmniLoggerCallByNative;", "", "<init>", "()V", BaseSwitches.V, "", "tag", "", "message", "d", RXScreenCaptureService.KEY_INDEX, "w", "e", "printLog", "logLevel", "Lcom/larus/im/internal/jni/dependency/OmniLoggerCallByNative$LogLevel;", "logByLevel", "level", "msg", "Companion", "LogLevel", "omnisdk-foundation_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniLoggerCallByNative {
    public static final Companion Companion = null;
    private static final int MAX_LOG_LENGTH = 3333;
    private static final String TAG = "OmniSDK";

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/larus/im/internal/jni/dependency/OmniLoggerCallByNative$Companion;", "", "<init>", "()V", "TAG", "", "MAX_LOG_LENGTH", "", "omnisdk-foundation_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/im/internal/jni/dependency/OmniLoggerCallByNative$LogLevel;", "", "<init>", "(Ljava/lang/String;I)V", "VERBOSE", "DEBUG", "INFO", "WARN", "ERROR", "omnisdk-foundation_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LogLevel extends Enum<LogLevel> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ LogLevel[] $VALUES = null;
        public static final LogLevel DEBUG = null;
        public static final LogLevel ERROR = null;
        public static final LogLevel INFO = null;
        public static final LogLevel VERBOSE = null;
        public static final LogLevel WARN = null;

        private static final /* synthetic */ LogLevel[] $values() {
            return new LogLevel[]{VERBOSE, DEBUG, INFO, WARN, ERROR};
        }

        public static EnumEntries<LogLevel> getEntries() {
            return $ENTRIES;
        }

        static {
            VERBOSE = new LogLevel("VERBOSE", 0);
            DEBUG = new LogLevel("DEBUG", 1);
            INFO = new LogLevel("INFO", 2);
            WARN = new LogLevel("WARN", 3);
            ERROR = new LogLevel("ERROR", 4);
            LogLevel[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static LogLevel[] values() {
            return (LogLevel[]) $VALUES.clone();
        }

        public static LogLevel valueOf(String r100) {
            return (LogLevel) r27.a.a(LogLevel.class, r100);
        }

        private LogLevel(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[LogLevel.values().length];
            r100[LogLevel.VERBOSE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[LogLevel.DEBUG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[LogLevel.INFO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[LogLevel.WARN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[LogLevel.ERROR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            $EnumSwitchMapping$0 = r100;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OmniLoggerCallByNative() {
    }

    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        printLog(LogLevel.DEBUG, r100, r101);
    }

    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        printLog(LogLevel.ERROR, r100, r101);
    }

    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        printLog(LogLevel.INFO, r100, r101);
    }

    public final void v(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        printLog(LogLevel.VERBOSE, r100, r101);
    }

    public final void w(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        printLog(LogLevel.WARN, r100, r101);
    }

    private final void logByLevel(LogLevel r100, String r101, String r102) {
        int r103 = WhenMappings.$EnumSwitchMapping$0[r100.ordinal()];
        if (r103 != 1) goto L5;
        com.larus.im.internal.delegate.a.f348188b.v(r101, r102);
        return;
    L5:
        if (r103 != 2) goto L7;
        com.larus.im.internal.delegate.a.f348188b.d(r101, r102);
        return;
    L7:
        if (r103 != 3) goto L9;
        com.larus.im.internal.delegate.a.f348188b.i(r101, r102);
        return;
    L9:
        if (r103 != 4) goto L11;
        com.larus.im.internal.delegate.a.f348188b.w(r101, r102);
        return;
    L11:
        if (r103 != 5) goto L14;
        com.larus.im.internal.delegate.a.f348188b.e(r101, r102);
        return;
    L14:
        throw new NoWhenBranchMatchedException();
    }

    private final void printLog(LogLevel r100, String r101, String r110) {
        String r102 = "OmniSDK_" + r101;
        int r103 = r110.length();
        if (r103 > MAX_LOG_LENGTH) goto L7;
        logByLevel(r100, r102, r110);
        return;
    L7:
        if (r103 > 9999) goto L9;
    L11:
        int r104 = ((r103 + MAX_LOG_LENGTH) - 1) / MAX_LOG_LENGTH;
        int r105 = 0;
    L12:
        if (r105 >= r104) goto L14;
        int r106 = r105 * MAX_LOG_LENGTH;
        int r107 = Math.min(r106 + MAX_LOG_LENGTH, r103);
        StringBuilder r108 = new StringBuilder("[");
        r105 = r105 + 1;
        r108.append(r105);
        r108.append('/');
        r108.append(r104);
        r108.append("] ");
        r108.append(r110.substring(r106, r107));
        logByLevel(r100, r102, r108.toString());
        goto L12
    L14:
        return;
    L9:
        if (com.larus.im.internal.delegate.c.f348197a.isDebug() == false) goto L11;
        d1.f348206b.b("OMNI_LONG_LOG_" + r102, r110);
        goto L11
    }
}
