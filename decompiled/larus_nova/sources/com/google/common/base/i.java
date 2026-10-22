package com.google.common.base;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f274717a;

    public i(String r100) {
        r100.getClass();
        this.f274717a = r100;
    }

    public final String b(Iterable<? extends Object> r100) {
        Iterator<? extends Object> r101 = r100.iterator();
        StringBuilder r102 = new StringBuilder();
        a(r102, r101);
        return r102.toString();
    }

    public CharSequence c(@CheckForNull Object r100) {
        Objects.requireNonNull(r100);
        if ((r100 instanceof CharSequence) == false) goto L6;
        return (CharSequence) r100;
    L6:
        return r100.toString();
    }

    public i(i r100) {
        this.f274717a = r100.f274717a;
    }

    public final void a(StringBuilder r100, Iterator r101) {
    L10:
        e = move-exception;
        throw new AssertionError(e);
    L3:
        if (r101.hasNext() == false) goto L9;
        r100.append(c(r101.next()));     // Catch: IOException -> L10
    L6:
        if (r101.hasNext() == false) goto L17;
        r100.append(this.f274717a);     // Catch: IOException -> L10
        r100.append(c(r101.next()));     // Catch: IOException -> L10
        goto L6
    L17:
        return;
    }
}
