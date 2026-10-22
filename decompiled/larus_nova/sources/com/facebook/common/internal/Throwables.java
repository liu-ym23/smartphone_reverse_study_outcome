package com.facebook.common.internal;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes22.dex */
public final class Throwables {
    private Throwables() {
    }

    public static List<Throwable> getCausalChain(Throwable r100) {
        Preconditions.checkNotNull(r100);
        ArrayList r101 = new ArrayList(4);
    L3:
        if (r100 == null) goto L6;
        r101.add(r100);
        r100 = r100.getCause();
        goto L3
    L6:
        return Collections.unmodifiableList(r101);
    }

    public static Throwable getRootCause(Throwable r100) {
    L2:
        Throwable r101 = r100.getCause();
        if (r101 == null) goto L5;
        r100 = r101;
        goto L2
    L5:
        return r100;
    }

    public static String getStackTraceAsString(Throwable r100) {
        StringWriter r101 = new StringWriter();
        r100.printStackTrace(new PrintWriter(r101));
        return r101.toString();
    }

    public static RuntimeException propagate(Throwable r100) {
        propagateIfPossible((Throwable) Preconditions.checkNotNull(r100));
        throw new RuntimeException(r100);
    }

    public static void propagateIfPossible(@Nullable Throwable r100) {
        propagateIfInstanceOf(r100, Error.class);
        propagateIfInstanceOf(r100, RuntimeException.class);
    }

    public static <X extends Throwable> void propagateIfInstanceOf(@Nullable Throwable r100, Class<X> r101) throws Throwable {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101.isInstance(r100) == true) goto L7;
        return;
    L7:
        throw r101.cast(r100);
    }

    public static <X extends Throwable> void propagateIfPossible(@Nullable Throwable r100, Class<X> r101) throws Throwable {
        propagateIfInstanceOf(r100, r101);
        propagateIfPossible(r100);
    }

    public static <X1 extends Throwable, X2 extends Throwable> void propagateIfPossible(@Nullable Throwable r100, Class<X1> r101, Class<X2> r102) throws Throwable, Throwable {
        Preconditions.checkNotNull(r102);
        propagateIfInstanceOf(r100, r101);
        propagateIfPossible(r100, r102);
    }
}
