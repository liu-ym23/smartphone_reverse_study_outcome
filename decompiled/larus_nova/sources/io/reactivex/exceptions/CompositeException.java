package io.reactivex.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public final class CompositeException extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;
    private Throwable cause;
    private final List<Throwable> exceptions;
    private final String message;

    public static final class CompositeExceptionCausalChain extends RuntimeException {
        static final String MESSAGE = "Chain of Causes for CompositeException In Order Received =>";
        private static final long serialVersionUID = 3875212506787802066L;

        @Override // java.lang.Throwable
        public String getMessage() {
            return MESSAGE;
        }

        public CompositeExceptionCausalChain() {
        }
    }

    public static abstract class a {
        public a() {
        }

        public abstract void a(Object r100);
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PrintStream f492832a;

        public b(PrintStream r100) {
            this.f492832a = r100;
        }

        @Override // io.reactivex.exceptions.CompositeException.a
        public final void a(Object r100) {
            this.f492832a.println(r100);
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PrintWriter f492833a;

        public c(PrintWriter r100) {
            this.f492833a = r100;
        }

        @Override // io.reactivex.exceptions.CompositeException.a
        public final void a(Object r100) {
            this.f492833a.println(r100);
        }
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L4:
        if (this.cause != null) goto L22;
        CompositeExceptionCausalChain r100 = new CompositeExceptionCausalChain();     // Catch: Throwable -> L25
        HashSet r101 = new HashSet();     // Catch: Throwable -> L25
        Iterator<Throwable> r102 = this.exceptions.iterator();     // Catch: Throwable -> L25
        Throwable r103 = r100;
    L7:
        if (r102.hasNext() == false) goto L21;
        Throwable r104 = r102.next();     // Catch: Throwable -> L25
        if (r101.contains(r104) == true) goto L7;
        r101.add(r104);     // Catch: Throwable -> L25
        Iterator<Throwable> r105 = getListOfCauses(r104).iterator();     // Catch: Throwable -> L25
    L13:
        if (r105.hasNext() == false) goto L31;
        Throwable r106 = r105.next();     // Catch: Throwable -> L25
        if (r101.contains(r106) == true) goto L16;
        r101.add(r106);     // Catch: Throwable -> L25
        goto L13
    L16:
        r104 = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");     // Catch: Throwable -> L25
        goto L13
    L31:
        r103.initCause(r104);     // Catch: Throwable -> L28
    L20:
        r103 = getRootCause(r103);     // Catch: Throwable -> L25
        goto L7
    L21:
        this.cause = r100;     // Catch: Throwable -> L25
    L22:
        Throwable r107 = this.cause;     // Catch: Throwable -> L25
        monitor-exit(this);
        return r107;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public int size() {
        return this.exceptions.size();
    }

    public List<Throwable> getExceptions() {
        return this.exceptions;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public CompositeException(Iterable<? extends Throwable> r100) {
        LinkedHashSet r101 = new LinkedHashSet();
        ArrayList r102 = new ArrayList();
        if (r100 == null) goto L13;
        Iterator<? extends Throwable> r103 = r100.iterator();
    L6:
        if (r103.hasNext() == false) goto L15;
        Throwable r104 = r103.next();
        if ((r104 instanceof CompositeException) == true) goto L9;
        if (r104 != null) goto L11;
        r101.add(new NullPointerException("Throwable was null!"));
        goto L6
    L11:
        r101.add(r104);
        goto L6
    L9:
        r101.addAll(((CompositeException) r104).getExceptions());
    L15:
        if (r101.isEmpty() == true) goto L19;
        r102.addAll(r101);
        List<Throwable> r105 = Collections.unmodifiableList(r102);
        this.exceptions = r105;
        this.message = r105.size() + " exceptions occurred. ";
        return;
    L19:
        throw new IllegalArgumentException("errors is empty");
    L13:
        r101.add(new NullPointerException("errors was null"));
        goto L15
    }

    private List<Throwable> getListOfCauses(Throwable r100) {
        ArrayList r101 = new ArrayList();
        Throwable r102 = r100.getCause();
        if (r102 == null) goto L11;
        if (r102 == r100) goto L11;
    L6:
        r101.add(r102);
        Throwable r103 = r102.getCause();
        if (r103 == null) goto L11;
        if (r103 == r102) goto L11;
        r102 = r103;
    L11:
        return r101;
    }

    private void printStackTrace(a r100) {
        StringBuilder r101 = new StringBuilder(128);
        r101.append(this);
        r101.append('\n');
        StackTraceElement[] r102 = getStackTrace();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        StackTraceElement r105 = r102[r104];
        r101.append("\tat ");
        r101.append(r105);
        r101.append('\n');
        r104 = r104 + 1;
        goto L3
    L5:
        Iterator<Throwable> r106 = this.exceptions.iterator();
        int r107 = 1;
    L7:
        if (r106.hasNext() == false) goto L9;
        Throwable r108 = r106.next();
        r101.append("  ComposedException ");
        r101.append(r107);
        r101.append(" :\n");
        appendStackTrace(r101, r108, "\t");
        r107 = r107 + 1;
        goto L7
    L9:
        r100.a(r101.toString());
    }

    public Throwable getRootCause(Throwable r100) {
        Throwable r101 = r100.getCause();
        if (r101 == null) goto L12;
        if (r100 == r101) goto L12;
    L6:
        Throwable r102 = r101.getCause();
        if (r102 == null) goto L11;
        if (r102 == r101) goto L11;
        r101 = r102;
    L11:
        return r101;
    L12:
        return r100;
    }

    public CompositeException(Throwable... r100) {
        if (r100 != null) goto L4;
        List r101 = Collections.singletonList(new NullPointerException("exceptions was null"));
    L5:
        this(r101);
        return;
    L4:
        r101 = Arrays.asList(r100);
        goto L5
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream r100) {
        printStackTrace(new b(r100));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter r100) {
        printStackTrace(new c(r100));
    }

    private void appendStackTrace(StringBuilder r100, Throwable r101, String r102) {
        r100.append(r102);
        r100.append(r101);
        r100.append('\n');
        StackTraceElement[] r103 = r101.getStackTrace();
        int r104 = r103.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L6;
        StackTraceElement r106 = r103[r105];
        r100.append("\t\tat ");
        r100.append(r106);
        r100.append('\n');
        r105 = r105 + 1;
        goto L3
    L6:
        if (r101.getCause() == null) goto L10;
        r100.append("\tCaused by: ");
        appendStackTrace(r100, r101.getCause(), "");
        return;
    }
}
