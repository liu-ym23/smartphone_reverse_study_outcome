package com.ss.android.lark.coremd.impl.parse;

import android.content.Context;
import com.ss.android.lark.coremd.base.parse.p;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements com.ss.android.lark.coremd.base.parse.i, com.ss.android.lark.coremd.base.parse.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.coremd.base.parse.b f419876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f419877d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p f419878e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g f419879f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.ss.android.lark.coremd.base.parse.j f419880g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<com.ss.android.lark.coremd.base.parse.f> f419881h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e f419882i;

    @Override // com.ss.android.lark.coremd.base.parse.b
    public final com.ss.android.lark.coremd.base.parse.b b(com.ss.android.lark.coremd.base.parse.b r100) {
        Intrinsics.checkNotNullParameter(r100, "that");
        return this.f419876c.b(r100);
    }

    @Override // com.ss.android.lark.coremd.base.parse.b
    public final com.ss.android.lark.coremd.base.parse.b clone() {
        return this.f419876c.clone();
    }

    @Override // com.ss.android.lark.coremd.ext.j
    public final Map<Object, Object> getValues() {
        return this.f419876c.getValues();
    }

    @Override // com.ss.android.lark.coremd.base.parse.i
    public final com.ss.android.lark.coremd.base.parse.m d() {
        return this.f419882i;
    }

    @Override // com.ss.android.lark.coremd.base.parse.i
    public final p f() {
        return this.f419878e;
    }

    @Override // com.ss.android.lark.coremd.base.parse.i
    public final com.ss.android.lark.coremd.base.parse.n g() {
        return this.f419879f;
    }

    @Override // com.ss.android.lark.coremd.base.parse.i
    public Context getContext() {
        return this.f419877d;
    }

    @Override // com.ss.android.lark.coremd.base.parse.i
    public final com.ss.android.lark.coremd.base.parse.j getTheme() {
        return this.f419880g;
    }

    public d(com.ss.android.lark.coremd.base.parse.b r100, Context r101, j r102, g r103, com.ss.android.lark.coremd.base.parse.j r104, List r105) {
        Intrinsics.checkNotNullParameter(r100, "markdownContext");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "spanFactory");
        Intrinsics.checkNotNullParameter(r103, "clickRegistry");
        Intrinsics.checkNotNullParameter(r104, "theme");
        Intrinsics.checkNotNullParameter(r105, "parseListeners");
        this.f419876c = r100;
        this.f419877d = r101;
        this.f419878e = r102;
        this.f419879f = r103;
        this.f419880g = r104;
        this.f419881h = r105;
        this.f419882i = new e();
    }
}
