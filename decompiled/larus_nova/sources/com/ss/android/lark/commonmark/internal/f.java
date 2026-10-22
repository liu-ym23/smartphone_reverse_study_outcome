package com.ss.android.lark.commonmark.internal;

import java.util.List;
import v7b.b0;

/* JADX INFO: loaded from: classes35.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b0> f417195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char f417196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f417197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f417198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f417199e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f f417200f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f f417201g;

    public final int c() {
        return this.f417195a.size();
    }

    public final Iterable<b0> a(int r100) {
        if (r100 < 1) goto L9;
        if (r100 > c()) goto L9;
        return this.f417195a.subList(0, r100);
    L9:
        throw new IllegalArgumentException("length must be between 1 and " + c() + ", was " + r100);
    }

    public final Iterable<b0> b(int r100) {
        if (r100 < 1) goto L9;
        if (r100 > c()) goto L9;
        List<b0> r101 = this.f417195a;
        return r101.subList(r101.size() - r100, this.f417195a.size());
    L9:
        throw new IllegalArgumentException("length must be between 1 and " + c() + ", was " + r100);
    }

    public f(List<b0> r100, char r101, boolean r102, boolean r103, f r104) {
        this.f417195a = r100;
        this.f417196b = r101;
        this.f417198d = r102;
        this.f417199e = r103;
        this.f417200f = r104;
        this.f417197c = r100.size();
    }
}
