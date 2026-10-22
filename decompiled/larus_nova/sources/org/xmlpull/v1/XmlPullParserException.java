package org.xmlpull.v1;

import java.io.PrintStream;

/* JADX INFO: loaded from: classes.dex */
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
        PrintStream r101 = System.err;     // Catch: Throwable -> L10
        StringBuffer r102 = new StringBuffer();     // Catch: Throwable -> L10
        r102.append(super.getMessage());     // Catch: Throwable -> L10
        r102.append("; nested exception is:");     // Catch: Throwable -> L10
        r101.println(r102.toString());     // Catch: Throwable -> L10
        this.detail.printStackTrace();     // Catch: Throwable -> L10
        monitor-exit(r100);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public int getColumnNumber() {
        return this.column;
    }

    public Throwable getDetail() {
        return this.detail;
    }

    public int getLineNumber() {
        return this.row;
    }

    public XmlPullParserException(String r100) {
        super(r100);
        this.row = -1;
        this.column = -1;
    }

    public XmlPullParserException(String r100, XmlPullParser r101, Throwable r102) {
        StringBuffer r103 = new StringBuffer();
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
        StringBuffer r107 = new StringBuffer("caused by: ");
        r107.append(r102);
        r104 = r107.toString();
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
        StringBuffer r108 = new StringBuffer("(position:");
        r108.append(r101.getPositionDescription());
        r108.append(") ");
        r106 = r108.toString();
        goto L10
    L5:
        r105 = r100.concat(" ");
        goto L6
    }
}
