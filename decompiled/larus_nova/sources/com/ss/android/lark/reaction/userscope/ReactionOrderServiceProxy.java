package com.ss.android.lark.reaction.userscope;

import com.ss.android.lark.newemoji.emoji_panel.DefaultEmojiPanelData;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import java.util.List;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class ReactionOrderServiceProxy extends c0c.b implements m2c.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m2c.a f439187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f439188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<m2c.a> f439189d;

    @Override // m2c.a
    @Deprecated(message = "Deprecated in Java")
    public final void I2() {
        this.f439187b.I2();
    }

    @Override // m2c.a
    public final List<String> N(boolean r100) {
        return this.f439187b.N(r100);
    }

    @Override // m2c.a
    public final List<String> U2() {
        return this.f439187b.U2();
    }

    @Override // m2c.a
    public final void Wc(String r100, String r101) {
        this.f439187b.Wc(r100, r101);
    }

    @Override // m2c.a
    public final DefaultEmojiPanelData a() {
        return this.f439187b.a();
    }

    @Override // m2c.a
    @Deprecated(message = "Deprecated in Java")
    public final List<String> f() {
        return this.f439187b.f();
    }

    @Override // m2c.a
    public final void fetchData() {
        this.f439187b.fetchData();
    }

    @Override // m2c.a
    public final List<String> h() {
        return this.f439187b.h();
    }

    @Override // m2c.a
    public final boolean j5(String r100) {
        return this.f439187b.j5(r100);
    }

    @Override // m2c.a
    public final void md(boolean r100) {
        this.f439187b.md(true);
    }

    @Override // m2c.a
    @Deprecated(message = "Deprecated in Java")
    public final List<String> o() {
        return this.f439187b.o();
    }

    @Override // m2c.a
    public final void q8(m2c.c r100) {
        if (r100 == null) goto L5;
        this.f439189d.d(new com.ss.android.lark.passportc.convention.b.C5239b(m2c.c.class, r100));
        return;
    }

    @Override // m2c.a
    public final void v2(final m2c.c r100) {
        if (r100 == null) goto L5;
        this.f439189d.a(new com.ss.android.lark.passportc.convention.b.C5239b(m2c.c.class, r100), new com.ss.android.lark.passportc.convention.b.c(new ReactionOrderServiceProxy$addOnEmojiPanelUpdateListener$1$1(r100), new ReactionOrderServiceProxy$addOnEmojiPanelUpdateListener$1$2(r100)));
        return;
    }

    public ReactionOrderServiceProxy(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<m2c.a> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), m2c.a.class), m2c.a.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f439187b = r103.b();
        this.f439188c = r101;
        this.f439189d = r103;
    }

    @Override // c0c.b
    public final void pf(g r100, f0c.b r101) {
        Intrinsics.checkNotNullParameter(r101, "toState");
        v r102 = this.f439188c;
        g r103 = r101.a();
        if (r103 == null) goto L6;
        UserSession r104 = r103.f475034b;
        if (r104 == null) goto L6;
    L7:
        m2c.a r105 = (m2c.a) k.b(r102.c(r104), m2c.a.class);
        this.f439189d.e(r105);
        return;
    L6:
        r104 = ContainerConstsKt.a();
        goto L7
    }
}
