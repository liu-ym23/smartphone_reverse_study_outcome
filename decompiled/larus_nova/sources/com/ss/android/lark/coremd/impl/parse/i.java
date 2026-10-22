package com.ss.android.lark.coremd.impl.parse;

import android.content.Context;
import com.ss.android.lark.coremd.base.parse.o;
import com.ss.android.lark.coremd.base.parse.p;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class i<T extends s> implements o<T>, com.ss.android.lark.coremd.base.parse.i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.coremd.base.parse.i f419897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final T f419898d;

    @Override // com.ss.android.lark.coremd.base.parse.b
    public final com.ss.android.lark.coremd.base.parse.b b(com.ss.android.lark.coremd.base.parse.b r100) {
        Intrinsics.checkNotNullParameter(r100, "that");
        return this.f419897c.b(r100);
    }

    @Override // com.ss.android.lark.coremd.base.parse.b
    public final com.ss.android.lark.coremd.base.parse.b clone() {
        return this.f419897c.clone();
    }

    @Override // com.ss.android.lark.coremd.base.parse.i
    public final com.ss.android.lark.coremd.base.parse.m d() {
        return this.f419897c.d();
    }

    @Override // com.ss.android.lark.coremd.base.parse.i
    public final p f() {
        return this.f419897c.f();
    }

    @Override // com.ss.android.lark.coremd.base.parse.i
    public final com.ss.android.lark.coremd.base.parse.n g() {
        return this.f419897c.g();
    }

    @Override // com.ss.android.lark.coremd.base.parse.o, com.ss.android.lark.coremd.base.parse.i
    public Context getContext() {
        return this.f419897c.getContext();
    }

    @Override // com.ss.android.lark.coremd.base.parse.i
    public final com.ss.android.lark.coremd.base.parse.j getTheme() {
        return this.f419897c.getTheme();
    }

    @Override // com.ss.android.lark.coremd.ext.j
    public final Map<Object, Object> getValues() {
        return this.f419897c.getValues();
    }

    public final m c() {
        int r100 = m.f419912b;
        return m.a.a(this, this.f419898d);
    }

    @Override // com.ss.android.lark.coremd.base.parse.o
    public final T getNode() {
        return this.f419898d;
    }

    public i(com.ss.android.lark.coremd.base.parse.i r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "parseContext");
        Intrinsics.checkNotNullParameter(r101, "node");
        this.f419897c = r100;
        this.f419898d = r101;
    }
}
