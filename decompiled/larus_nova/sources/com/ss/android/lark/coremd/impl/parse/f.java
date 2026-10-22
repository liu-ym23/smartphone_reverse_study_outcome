package com.ss.android.lark.coremd.impl.parse;

import android.content.Context;
import android.text.Layout;
import android.view.View;
import com.ss.android.lark.coremd.base.parse.p;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class f implements com.ss.android.lark.coremd.base.parse.n.a<s>, com.ss.android.lark.coremd.base.parse.i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.coremd.base.parse.i f419885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s f419886d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f419887e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f419888f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f419889g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f419890h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Layout f419891i;

    @Override // com.ss.android.lark.coremd.base.parse.b
    public final com.ss.android.lark.coremd.base.parse.b b(com.ss.android.lark.coremd.base.parse.b r100) {
        Intrinsics.checkNotNullParameter(r100, "that");
        return this.f419885c.b(r100);
    }

    @Override // com.ss.android.lark.coremd.base.parse.b
    public final com.ss.android.lark.coremd.base.parse.b clone() {
        return this.f419885c.clone();
    }

    @Override // com.ss.android.lark.coremd.base.parse.i
    public final com.ss.android.lark.coremd.base.parse.m d() {
        return this.f419885c.d();
    }

    @Override // com.ss.android.lark.coremd.base.parse.i
    public final p f() {
        return this.f419885c.f();
    }

    @Override // com.ss.android.lark.coremd.base.parse.i
    public final com.ss.android.lark.coremd.base.parse.n g() {
        return this.f419885c.g();
    }

    @Override // com.ss.android.lark.coremd.base.parse.i
    public final com.ss.android.lark.coremd.base.parse.j getTheme() {
        return this.f419885c.getTheme();
    }

    @Override // com.ss.android.lark.coremd.ext.j
    public final Map<Object, Object> getValues() {
        return this.f419885c.getValues();
    }

    @Override // com.ss.android.lark.coremd.base.parse.n.a, com.ss.android.lark.coremd.base.parse.i
    public Context getContext() {
        return this.f419887e;
    }

    @Override // com.ss.android.lark.coremd.base.parse.n.a
    public final int getEnd() {
        return this.f419889g;
    }

    @Override // com.ss.android.lark.coremd.base.parse.n.a
    public final Layout getLayout() {
        return this.f419891i;
    }

    @Override // com.ss.android.lark.coremd.base.parse.n.a
    public final s getNode() {
        return this.f419886d;
    }

    @Override // com.ss.android.lark.coremd.base.parse.n.a
    public final int getStart() {
        return this.f419888f;
    }

    @Override // com.ss.android.lark.coremd.base.parse.n.a
    public final View getView() {
        return this.f419890h;
    }

    public f(com.ss.android.lark.coremd.base.parse.i r100, s r101, Context r102, int r103, int r104, View r105, Layout r106) {
        Intrinsics.checkNotNullParameter(r100, "parseContext");
        Intrinsics.checkNotNullParameter(r101, "node");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r105, "view");
        Intrinsics.checkNotNullParameter(r106, "layout");
        this.f419885c = r100;
        this.f419886d = r101;
        this.f419887e = r102;
        this.f419888f = r103;
        this.f419889g = r104;
        this.f419890h = r105;
        this.f419891i = r106;
    }
}
