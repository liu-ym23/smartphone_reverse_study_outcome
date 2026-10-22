package com.suite.lark.emm.impl.clipboard.userscope.user;

import android.content.ClipData;
import android.content.ClipboardManager;
import c0c.b;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.suite.lark.emm.impl.clipboard.SCClipboardScene;
import doc.e;
import e0c.k;
import f0c.g;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class a extends b implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f460456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f460457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<e> f460458d;

    @Override // doc.b
    public final boolean E6() {
        return this.f460456b.E6();
    }

    @Override // doc.b
    public final void L3() {
        this.f460456b.L3();
    }

    @Override // doc.b
    public final ClipData Ma() {
        return this.f460456b.Ma();
    }

    @Override // doc.e
    public final void Ob(SCClipboardScene r100) {
        this.f460456b.Ob(r100);
    }

    @Override // doc.e
    public final boolean Q7() {
        return this.f460456b.Q7();
    }

    @Override // doc.b
    public final void Sd() {
        this.f460456b.Sd();
    }

    @Override // doc.b
    public final int Ua() {
        return this.f460456b.Ua();
    }

    @Override // doc.b
    public final void Ze(ClipData r100) {
        Intrinsics.checkNotNullParameter(r100, "clipData");
        this.f460456b.Ze(r100);
    }

    @Override // doc.e
    public final void d(ClipboardManager.OnPrimaryClipChangedListener r100) {
        this.f460456b.d(r100);
    }

    @Override // doc.e
    public final void e(ClipboardManager.OnPrimaryClipChangedListener r100) {
        this.f460456b.e(r100);
    }

    @Override // doc.e
    public final int o3(int r100) {
        return this.f460456b.o3(r100);
    }

    @Override // doc.b
    public final void wa() {
        this.f460456b.wa();
    }

    @Override // doc.b
    public final int xb(ClipData r100) {
        return this.f460456b.xb(r100);
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        v r102 = this.f460457c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        e r104 = (e) k.b(r102.c(r103), e.class);
        this.f460458d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }

    @Inject
    public a(j r100, v r101, com.ss.android.lark.passportc.convention.b<e> r102) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r102, "proxy");
        super(r100);
        this.f460456b = r102.b();
        this.f460457c = r101;
        this.f460458d = r102;
    }
}
