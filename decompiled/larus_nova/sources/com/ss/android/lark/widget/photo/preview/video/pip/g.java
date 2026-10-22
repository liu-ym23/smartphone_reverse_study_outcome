package com.ss.android.lark.widget.photo.preview.video.pip;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.widget.photo.preview.video.online.j0;
import e0c.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class g extends c0c.b implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f447424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f447425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<b> f447426d;

    @Override // com.ss.android.lark.widget.photo.preview.video.pip.b
    public final void H4(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f447424b.H4(r100);
    }

    @Override // com.ss.android.lark.widget.photo.preview.video.pip.b
    public final void K7(j0 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f447424b.K7(r100);
    }

    @Override // com.ss.android.lark.widget.photo.preview.video.pip.b
    public final void ne(FragmentActivity r100, boolean r101) {
        this.f447424b.ne(r100, r101);
    }

    @Override // com.ss.android.lark.widget.photo.preview.video.pip.b
    public final void zc() {
        this.f447424b.zc();
    }

    public g(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<b> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), b.class), b.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f447424b = r103.b();
        this.f447425c = r101;
        this.f447426d = r103;
    }

    @Override // c0c.b
    public final void qf(f0c.g r100, f0c.g r101) {
        if (r101 == null) goto L5;
        UserSession r102 = r101.f475034b;
        if (r102 == null) goto L5;
    L6:
        b r103 = (b) k.b(this.f447425c.c(r102), b.class);
        this.f447426d.e(r103);
        return;
    L5:
        r102 = ContainerConstsKt.a();
        goto L6
    }
}
