package com.bytedance.mira.pm.packageinfo;

import java.io.PrintStream;

/* JADX INFO: loaded from: classes21.dex */
public class XmlPullParserException extends Exception {
    protected int column;
    protected Throwable detail;
    protected int row;

    @Override // java.lang.Throwable
    public void printStackTrace() {
        if (this.detail != null) goto L5;
        super.printStackTrace();
        return;
    L5:
        PrintStream r100 = System.err;
        monitor-enter(r100);
        System.err.println(super.getMessage() + "; nested exception is:");     // Catch: Throwable -> L10
        this.detail.printStackTrace();     // Catch: Throwable -> L10
        monitor-exit(r100);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public XmlPullParserException(String r100) {
        super(r100);
        this.row = -1;
        this.column = -1;
    }

    public XmlPullParserException(String r100, XmlPullParser r101, Throwable r102) {
        StringBuilder r103 = new StringBuilder();
        String r104 = "";
        if (r100 != null) goto L5;
        String r105 = "";
    L6:
        r103.append(r105);
        if (r101 != null) goto L9;
        String r106 = "";
    L10:
        r103.append(r106);
        if (r102 == null) goto L14;
        r104 = "caused by: " + r102;
    L14:
        r103.append(r104);
        super(r103.toString());
        this.row = -1;
        this.column = -1;
        if (r101 == null) goto L17;
        this.row = r101.getLineNumber();
        this.column = r101.getColumnNumber();
    L17:
        this.detail = r102;
        return;
    L9:
        r106 = "(position:" + r101.getPositionDescription() + ") ";
        goto L10
    L5:
        r105 = r100.concat(" ");
        goto L6
    }
}
