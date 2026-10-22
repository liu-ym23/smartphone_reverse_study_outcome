package org.apache.commons.lang3.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes42.dex */
public class ExceptionUtils {
    private static final String[] CAUSE_METHOD_NAMES = null;

    static {
        CAUSE_METHOD_NAMES = new String[]{"getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", "getLinkedCause", "getThrowable"};
    }

    public static String getStackTrace(Throwable r100) {
        StringWriter r101 = new StringWriter();
        r100.printStackTrace(new PrintWriter(r101, true));
        return r101.getBuffer().toString();
    }

    public static <R> R rethrow(Throwable r100) {
        return (R) typeErasure(r100);
    }

    private static <R, T extends Throwable> R typeErasure(Throwable r100) throws Throwable {
        throw r100;
    }
}
