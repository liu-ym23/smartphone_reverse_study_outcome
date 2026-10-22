package com.ss.android.lark.chat.service.impl;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.dto.draft.Draft;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class s extends c0c.b implements m6b.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m6b.g f416569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.passportc.internal.v f416570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<m6b.g> f416571d;

    public static final class a {
    }

    static {
    }

    @Override // m6b.g
    public final Draft Ea(String r100) {
        return this.f416569b.Ea(r100);
    }

    @Override // m6b.g
    public final void M8(String r100, int r101) {
        this.f416569b.M8(r100, r101);
    }

    @Override // m6b.g
    public final void Mb(String r100, String r101) {
        this.f416569b.Mb(r100, "");
    }

    @Override // m6b.g
    public final Draft Na(String r100) {
        return this.f416569b.Na(r100);
    }

    @Override // m6b.g
    public final Draft Pc(String r100) {
        return this.f416569b.Pc(r100);
    }

    @Override // m6b.g
    public final void a8(String r100) {
        this.f416569b.a8(r100);
    }

    @Override // m6b.g
    public final Draft b6(String r100) {
        return this.f416569b.b6(r100);
    }

    @Override // m6b.g
    public final Draft b8(String r100) {
        return this.f416569b.b8(r100);
    }

    @Override // m6b.g
    public final Executor getExecutor() {
        return this.f416569b.getExecutor();
    }

    @Override // m6b.g
    public final void o5(b2.a r100, String r101, String r102, r.a r103) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f416569b.o5(r100, r101, r102, r103);
    }

    @Override // m6b.g
    public final Map<String, Draft> se(List<String> r100) {
        return this.f416569b.se(r100);
    }

    @Override // m6b.g
    public final void tc(String r100, Draft r101, boolean r102, String r103) {
        this.f416569b.tc(r100, r101, r102, r103);
    }

    @Override // m6b.g
    public final String x8(Chat r100, Draft r101, boolean r102) {
        return this.f416569b.x8(r100, r101, r102);
    }

    public s(com.ss.android.lark.passportc.api.j r100, com.ss.android.lark.passportc.internal.v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<m6b.g> r103 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r101.c(r102), m6b.g.class), m6b.g.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f416569b = r103.b();
        this.f416570c = r101;
        this.f416571d = r103;
    }

    @Override // c0c.b
    public final void qf(f0c.g r100, f0c.g r101) {
        Log.i("DraftServiceProxy", "preparing IDraftService");
        com.ss.android.lark.passportc.internal.v r102 = this.f416570c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        m6b.g r104 = (m6b.g) e0c.k.b(r102.c(r103), m6b.g.class);
        this.f416571d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
