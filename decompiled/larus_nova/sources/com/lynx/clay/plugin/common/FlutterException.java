package com.lynx.clay.plugin.common;

import c5a.a;
import c5a.c;

/* JADX INFO: loaded from: classes32.dex */
public class FlutterException extends RuntimeException {
    public final String code;
    public final Object details;

    public FlutterException(String r100, String r101, Object r102) {
        super(r101);
        if (a.f22523a.booleanValue() == false) goto L6;
        if (r100 != null) goto L6;
        c.d(6, "FlutterException#", "Parameter code must not be null.");
    L6:
        this.code = r100;
        this.details = r102;
    }
}
