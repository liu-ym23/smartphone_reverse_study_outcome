package com.ss.lark.android.encryption.userscope;

import android.content.Context;
import android.net.Uri;
import android.util.Pair;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import jkc.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class b extends c0c.b implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f456814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f456815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<c> f456816d;

    @Override // jkc.c
    public final InputStream D5(File r100) {
        Intrinsics.checkNotNullParameter(r100, "file");
        return this.f456814b.D5(r100);
    }

    @Override // jkc.c
    public final Pair<Integer, String> Ec(String r100) {
        Intrinsics.checkNotNullParameter(r100, "decryptedPath");
        return this.f456814b.Ec(r100);
    }

    @Override // jkc.c
    public final Pair<Integer, String> Gd(Context r100, Uri r101) {
        Intrinsics.checkNotNullParameter(r101, "uri");
        return this.f456814b.Gd(r100, r101);
    }

    @Override // jkc.c
    public final int Q9(File r100) {
        Intrinsics.checkNotNullParameter(r100, "file");
        return this.f456814b.Q9(r100);
    }

    @Override // jkc.c
    public final void f5(String r100, long r101, String r102) {
        this.f456814b.f5(r100, r101, r102);
    }

    @Override // jkc.c
    public final Pair<Integer, String> m3(File r100) {
        Intrinsics.checkNotNullParameter(r100, "file");
        return this.f456814b.m3(r100);
    }

    @Override // jkc.c
    public final int o1() {
        return this.f456814b.o1();
    }

    @Override // jkc.c
    public final OutputStream p3(File r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "file");
        return this.f456814b.p3(r100, r101);
    }

    public b(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<c> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), c.class), c.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f456814b = r103.b();
        this.f456815c = r101;
        this.f456816d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        v r102 = this.f456815c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        c r104 = (c) k.b(r102.c(r103), c.class);
        this.f456816d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
