package com.ss.android.lark.coremd.impl.parse;

import android.content.Context;
import com.ss.android.lark.coremd.base.parse.p;
import com.ss.android.lark.coremd.base.parse.r;
import com.ss.android.lark.coremd.base.parse.u;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class k implements r<s>, com.ss.android.lark.coremd.base.parse.i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.coremd.base.parse.i f419901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s f419902d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MarkdownSpanSetterImpl f419903e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final u f419904f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.ss.android.lark.coremd.base.parse.s f419905g;

    @Override // com.ss.android.lark.coremd.base.parse.b
    public final com.ss.android.lark.coremd.base.parse.b b(com.ss.android.lark.coremd.base.parse.b r100) {
        Intrinsics.checkNotNullParameter(r100, "that");
        return this.f419901c.b(r100);
    }

    @Override // com.ss.android.lark.coremd.base.parse.b
    public final com.ss.android.lark.coremd.base.parse.b clone() {
        return this.f419901c.clone();
    }

    @Override // com.ss.android.lark.coremd.base.parse.i
    public final com.ss.android.lark.coremd.base.parse.m d() {
        return this.f419901c.d();
    }

    @Override // com.ss.android.lark.coremd.base.parse.i
    public final p f() {
        return this.f419901c.f();
    }

    @Override // com.ss.android.lark.coremd.base.parse.i
    public final com.ss.android.lark.coremd.base.parse.n g() {
        return this.f419901c.g();
    }

    @Override // com.ss.android.lark.coremd.base.parse.r, com.ss.android.lark.coremd.base.parse.o, com.ss.android.lark.coremd.base.parse.i
    public Context getContext() {
        return this.f419901c.getContext();
    }

    @Override // com.ss.android.lark.coremd.base.parse.i
    public final com.ss.android.lark.coremd.base.parse.j getTheme() {
        return this.f419901c.getTheme();
    }

    @Override // com.ss.android.lark.coremd.ext.j
    public final Map<Object, Object> getValues() {
        return this.f419901c.getValues();
    }

    @Override // com.ss.android.lark.coremd.base.parse.r
    public final MarkdownSpanSetterImpl a() {
        return this.f419903e;
    }

    @Override // com.ss.android.lark.coremd.base.parse.r
    public final com.ss.android.lark.coremd.base.parse.s getEditable() {
        return this.f419905g;
    }

    @Override // com.ss.android.lark.coremd.base.parse.o
    public final s getNode() {
        return this.f419902d;
    }

    public k(d r100, s r101, MarkdownSpanSetterImpl r102, u r103, n r104) {
        Intrinsics.checkNotNullParameter(r100, "parseContext");
        Intrinsics.checkNotNullParameter(r101, "node");
        Intrinsics.checkNotNullParameter(r102, "spanSetter");
        Intrinsics.checkNotNullParameter(r103, "visitor");
        Intrinsics.checkNotNullParameter(r104, "editable");
        this.f419901c = r100;
        this.f419902d = r101;
        this.f419903e = r102;
        this.f419904f = r103;
        this.f419905g = r104;
    }
}
