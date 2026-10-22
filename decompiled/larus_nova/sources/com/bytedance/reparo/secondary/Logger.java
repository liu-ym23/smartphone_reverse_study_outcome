package com.bytedance.reparo.secondary;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public final class Logger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f267463a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashSet<String> f267464b = null;

    /* JADX INFO: loaded from: classes21.dex */
    public static class CollideMethodException extends RuntimeException {
        private String mCollideMethod;

        public CollideMethodException refillStack() {
            int r100 = this.mCollideMethod.indexOf(40);     // Catch: Throwable -> L5
            String r101 = this.mCollideMethod;     // Catch: Throwable -> L5
            String r102 = r101.substring(r101.indexOf(32) + 1, this.mCollideMethod.lastIndexOf(".", r100));     // Catch: Throwable -> L5
            String r103 = this.mCollideMethod;     // Catch: Throwable -> L5
            setStackTrace(new StackTraceElement[]{new StackTraceElement(r102, r103.substring(r103.lastIndexOf(".", r100) + 1, r100), "SourceFile", 1)});     // Catch: Throwable -> L5
        L4:
            return this;
        }

        public CollideMethodException(String r100, String r101) {
            super("on " + r100 + " " + r101);
            this.mCollideMethod = r101;
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public static class SymbolNotFoundException extends RuntimeException {
        public SymbolNotFoundException(String r100) {
            super("NotFoundSymbol " + r100);
            setStackTrace(new StackTraceElement[]{new StackTraceElement("SymbolNotFoundException", r100, "SourceFile", 1)});
        }
    }

    public static class a implements com.bytedance.reparo.core.k.b {
        public a() {
        }

        @Override // com.bytedance.reparo.core.k.b
        public final void a() {
        }

        @Override // com.bytedance.reparo.core.k.b
        public final void b() {
        }

        @Override // com.bytedance.reparo.core.k.b
        public final void d() {
        }

        @Override // com.bytedance.reparo.core.k.b
        public final void i() {
        }

        @Override // com.bytedance.reparo.core.k.b
        public final void d(String r100) {
            i.a("symbol", new SymbolNotFoundException(r100));
        }

        @Override // com.bytedance.reparo.core.k.b
        public final void e(String r100) {
            RuntimeException r101 = new RuntimeException("\"" + r100 + "\"");
            Logger.a(r101);
            i.a("errorlog", r101);
        }

        @Override // com.bytedance.reparo.core.k.b
        public final void c(String r100, String r101) {
            i.a("collide", new CollideMethodException(r100, r101).refillStack());
        }

        @Override // com.bytedance.reparo.core.k.b
        public final void e(String r100, Throwable r101) {
            if (r101 == null) goto L4;
            w87.e.a(r101);
        L4:
            a r102 = Logger.f267463a;
            boolean r103 = false;
            Throwable r104 = r101;
            int r105 = 0;
        L6:
            if (r105 >= 10) goto L15;
            if (r104 == null) goto L15;
            if ((r104 instanceof IOException) == true) goto L10;
            if (r104.getCause() == r104) goto L15;
            r104 = r101.getCause();
            r105 = r105 + 1;
            goto L6
        L10:
            r103 = true;
        L15:
            if (r103 == false) goto L17;
            String r106 = "ignored";
        L18:
            RuntimeException r107 = new RuntimeException("\"" + r100 + "\"", r101);
            Logger.a(r107);
            i.a(r106, r107);
            return;
        L17:
            r106 = "catched";
            goto L18
        }
    }

    public Logger() {
    }

    static {
        f267463a = new a();
        f267464b = new HashSet();
    }

    public static void c() {
        f267463a.getClass();
    }

    public static void a(Throwable r100) {
        StackTraceElement[] r101 = r100.getStackTrace();
        int r102 = 0;
        int r103 = 0;
    L3:
        HashSet<String> r104 = f267464b;
        if (r102 >= r104.size()) goto L11;
        if (r102 >= r101.length) goto L11;
        if (r104.contains(r101[r102].getClassName()) == true) goto L10;
        r103 = r102;
    L10:
        r102 = r102 + 1;
    L11:
        r100.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(r101, r103, r101.length));
    }

    public static void b(String r100, String r101, Throwable r102) {
        f267463a.e(r101, r102);     // Catch: Throwable -> L4
        return;
    }
}
