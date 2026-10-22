package com.xiaomi.push;

import java.io.PrintStream;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes41.dex */
public class fh extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private fq f463546a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private fr f572a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Throwable f573a;

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        String r101 = super.getMessage();
        if (r101 == null) goto L5;
        r100.append(r101);
        r100.append(": ");
    L5:
        fr r102 = this.f572a;
        if (r102 == null) goto L8;
        r100.append(r102);
    L8:
        fq r103 = this.f463546a;
        if (r103 == null) goto L12;
        r100.append(r103);
    L12:
        if (this.f573a == null) goto L15;
        r100.append("\n  -- caused by: ");
        r100.append(this.f573a);
    L15:
        return r100.toString();
    }

    public fh() {
        this.f463546a = null;
        this.f572a = null;
        this.f573a = null;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String r100 = super.getMessage();
        if (r100 != null) goto L8;
        fr r101 = this.f572a;
        if (r101 == null) goto L8;
        return r101.toString();
    L8:
        if (r100 != null) goto L13;
        fq r102 = this.f463546a;
        if (r102 != null) goto L12;
        return r100;
    L12:
        return r102.toString();
    L13:
        return r100;
    }

    public Throwable a() {
        return this.f573a;
    }

    public fh(fq r100) {
        this.f572a = null;
        this.f573a = null;
        this.f463546a = r100;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream r100) {
        super.printStackTrace(r100);
        if (this.f573a == null) goto L6;
        r100.println("Nested Exception: ");
        this.f573a.printStackTrace(r100);
        return;
    }

    public fh(String r100) {
        super(r100);
        this.f463546a = null;
        this.f572a = null;
        this.f573a = null;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter r100) {
        super.printStackTrace(r100);
        if (this.f573a == null) goto L6;
        r100.println("Nested Exception: ");
        this.f573a.printStackTrace(r100);
        return;
    }

    public fh(Throwable r100) {
        this.f463546a = null;
        this.f572a = null;
        this.f573a = r100;
    }

    public fh(String r100, Throwable r101) {
        super(r100);
        this.f463546a = null;
        this.f572a = null;
        this.f573a = r101;
    }
}
