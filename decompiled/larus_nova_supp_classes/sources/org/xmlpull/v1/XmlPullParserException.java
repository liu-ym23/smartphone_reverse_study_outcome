package org.xmlpull.v1;

import java.io.PrintStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
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
        PrintStream r0 = System.err;
        monitor-enter(r0);
        PrintStream r1 = System.err;     // Catch: Throwable -> L10
        StringBuffer r2 = new StringBuffer();     // Catch: Throwable -> L10
        r2.append(super.getMessage());     // Catch: Throwable -> L10
        r2.append("; nested exception is:");     // Catch: Throwable -> L10
        r1.println(r2.toString());     // Catch: Throwable -> L10
        this.detail.printStackTrace();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
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

    public XmlPullParserException(String r1) {
        super(r1);
        this.row = -1;
        this.column = -1;
    }

    public XmlPullParserException(String r4, XmlPullParser r5, Throwable r6) {
        StringBuffer r0 = new StringBuffer();
        String r1 = XmlPullParser.NO_NAMESPACE;
        if (r4 != null) goto L5;
        String r7 = XmlPullParser.NO_NAMESPACE;
    L6:
        r0.append(r7);
        if (r5 != null) goto L9;
        String r8 = XmlPullParser.NO_NAMESPACE;
    L10:
        r0.append(r8);
        if (r6 == null) goto L14;
        StringBuffer r9 = new StringBuffer("caused by: ");
        r9.append(r6);
        r1 = r9.toString();
    L14:
        r0.append(r1);
        super(r0.toString());
        this.row = -1;
        this.column = -1;
        if (r5 == null) goto L17;
        this.row = r5.getLineNumber();
        this.column = r5.getColumnNumber();
    L17:
        this.detail = r6;
        return;
    L9:
        StringBuffer r10 = new StringBuffer("(position:");
        r10.append(r5.getPositionDescription());
        r10.append(") ");
        r8 = r10.toString();
        goto L10
    L5:
        r7 = r4.concat(" ");
        goto L6
    }
}
