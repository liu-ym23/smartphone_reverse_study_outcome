package com.sun.jna.win32;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public interface W32APIOptions extends StdCallLibrary {
    public static final Map<String, Object> ASCII_OPTIONS = null;
    public static final Map<String, Object> DEFAULT_OPTIONS = null;
    public static final Map<String, Object> UNICODE_OPTIONS = null;

    static {
        Map<String, Object> r100 = Collections.unmodifiableMap(new AnonymousClass1());
        UNICODE_OPTIONS = r100;
        Map<String, Object> r101 = Collections.unmodifiableMap(new AnonymousClass2());
        ASCII_OPTIONS = r101;
        if (Boolean.getBoolean("w32.ascii") == false) goto L5;
        r100 = r101;
    L5:
        DEFAULT_OPTIONS = r100;
    }
}
