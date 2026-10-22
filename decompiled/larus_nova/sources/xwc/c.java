package xwc;

import org.slf4j.event.Level;

/* JADX INFO: loaded from: classes42.dex */
public interface c {
    void debug(String r100, Throwable r101);

    String getName();

    boolean isDebugEnabled();

    boolean isEnabledForLevel(Level r100);

    boolean isErrorEnabled();

    boolean isInfoEnabled();

    boolean isTraceEnabled();

    boolean isWarnEnabled();

    ywc.b makeLoggingEventBuilder(Level r100);

    void trace(String r100);

    void warn(String r100);
}
