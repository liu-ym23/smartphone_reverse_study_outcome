package com.ss.android.lark.commonmark.internal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes35.dex */
public final class s implements z7b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char f417270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f417271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedList<z7b.a> f417272c;

    @Override // z7b.a
    public final int a() {
        return this.f417271b;
    }

    @Override // z7b.a
    public final char b() {
        return this.f417270a;
    }

    @Override // z7b.a
    public final char c() {
        return this.f417270a;
    }

    public s(char r100) {
        this.f417271b = 0;
        this.f417272c = new LinkedList();
        this.f417270a = r100;
    }

    public final void e(z7b.a r100) {
        int r101 = r100.a();
        ListIterator<z7b.a> r102 = this.f417272c.listIterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        z7b.a r103 = r102.next();
        int r104 = r103.a();
        if (r101 > r104) goto L7;
        if (r101 != r104) goto L4;
        throw new IllegalArgumentException("Cannot add two delimiter processors for char '" + this.f417270a + "' and minimum length " + r101 + "; conflicting processors: " + r103 + ", " + r100);
    L7:
        r102.previous();
        r102.add(r100);
        boolean r105 = true;
    L13:
        if (r105 == true) goto L20;
        this.f417272c.add(r100);
        this.f417271b = r101;
        return;
    L20:
        return;
    L12:
        r105 = false;
        goto L13
    }

    @Override // z7b.a
    public final int d(f r100, f r101) {
        int r102 = r100.c();
        Iterator<z7b.a> r103 = this.f417272c.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        z7b.a r104 = r103.next();
        if (r104.a() > r102) goto L4;
    L10:
        return r104.d(r100, r101);
    L8:
        r104 = this.f417272c.getFirst();
        goto L10
    }
}
