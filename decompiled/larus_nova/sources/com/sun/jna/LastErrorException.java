package com.sun.jna;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;

/* JADX INFO: loaded from: classes40.dex */
public class LastErrorException extends RuntimeException {
    private static final long serialVersionUID = 1;
    private int errorCode;

    public int getErrorCode() {
        return this.errorCode;
    }

    public LastErrorException(String r100) {
        super(parseMessage(r100.trim()));
    L8:
        this.errorCode = -1;
        return;
    L4:
        if (r100.startsWith("[") == false) goto L6;
        r100 = r100.substring(1, r100.indexOf("]"));     // Catch: NumberFormatException -> L8
    L6:
        this.errorCode = CastIntegerProtector.parseInt(r100);     // Catch: NumberFormatException -> L8
    }

    private static String formatMessage(int r100) {
        if (Platform.isWindows() == false) goto L5;
        StringBuilder r101 = new StringBuilder("GetLastError() returned ");
    L6:
        r101.append(r100);
        return r101.toString();
    L5:
        r101 = new StringBuilder("errno was ");
        goto L6
    }

    private static String parseMessage(String r100) {
        return formatMessage(CastIntegerProtector.parseInt(r100));
    L7:
        return r100;
    }

    public LastErrorException(int r100) {
        this(r100, formatMessage(r100));
    }

    public LastErrorException(int r100, String r101) {
        super(r101);
        this.errorCode = r100;
    }
}
