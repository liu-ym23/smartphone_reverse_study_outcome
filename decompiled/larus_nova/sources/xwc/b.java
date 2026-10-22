package xwc;

import org.slf4j.event.Level;
import org.slf4j.helpers.CheckReturnValue;

/* JADX INFO: loaded from: classes42.dex */
public final /* synthetic */ class b {
    @CheckReturnValue
    public static ywc.b a(c r100) {
        if (r100.isDebugEnabled() == false) goto L7;
        return r100.makeLoggingEventBuilder(Level.DEBUG);
    L7:
        return ywc.d.f569374a;
    }

    @CheckReturnValue
    public static ywc.b b(c r100) {
        if (r100.isErrorEnabled() == false) goto L7;
        return r100.makeLoggingEventBuilder(Level.ERROR);
    L7:
        return ywc.d.f569374a;
    }

    @CheckReturnValue
    public static ywc.b c(c r100) {
        if (r100.isInfoEnabled() == false) goto L7;
        return r100.makeLoggingEventBuilder(Level.INFO);
    L7:
        return ywc.d.f569374a;
    }

    @CheckReturnValue
    public static ywc.b e(c r100) {
        if (r100.isTraceEnabled() == false) goto L7;
        return r100.makeLoggingEventBuilder(Level.TRACE);
    L7:
        return ywc.d.f569374a;
    }

    @CheckReturnValue
    public static ywc.b f(c r100) {
        if (r100.isWarnEnabled() == false) goto L7;
        return r100.makeLoggingEventBuilder(Level.WARN);
    L7:
        return ywc.d.f569374a;
    }

    @CheckReturnValue
    public static ywc.b d(c r100, Level r101) {
        if (r100.isEnabledForLevel(r101) == false) goto L7;
        return r100.makeLoggingEventBuilder(r101);
    L7:
        return ywc.d.f569374a;
    }

    public static boolean g(c r100, Level r101) {
        int r102 = r101.toInt();
        if (r102 == 0) goto L23;
        if (r102 == 10) goto L21;
        if (r102 == 20) goto L19;
        if (r102 == 30) goto L17;
        if (r102 != 40) goto L15;
        return r100.isErrorEnabled();
    L15:
        throw new IllegalArgumentException("Level [" + r101 + "] not recognized.");
    L17:
        return r100.isWarnEnabled();
    L19:
        return r100.isInfoEnabled();
    L21:
        return r100.isDebugEnabled();
    L23:
        return r100.isTraceEnabled();
    }
}
