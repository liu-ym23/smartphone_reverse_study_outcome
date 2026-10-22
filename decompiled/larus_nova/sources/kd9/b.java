package kd9;

import android.view.View;
import com.larus.audio.call.plugins.CommonVideoAutoTestPlugin;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class b implements com.larus.im.service.audio.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ff9.v f502858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f502859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Long, Unit> f502860c;

    @Override // com.larus.im.service.audio.z
    public final void s() {
    }

    @Override // com.larus.im.service.audio.z
    public final void u() {
    }

    @Override // com.larus.im.service.audio.z
    public final void g() {
        this.f502858a.g();
    }

    @Override // com.larus.im.service.audio.z
    public final boolean isCameraTorchSupported() {
        return this.f502858a.isCameraTorchSupported();
    }

    @Override // com.larus.im.service.audio.z
    public final void k() {
        this.f502858a.k();
    }

    @Override // com.larus.im.service.audio.z
    public final void l() {
        this.f502858a.l();
    }

    @Override // com.larus.im.service.audio.z
    public final void o() {
        this.f502858a.o();
    }

    @Override // com.larus.im.service.audio.z
    public final void p() {
        this.f502858a.p();
    }

    @Override // com.larus.im.service.audio.z
    public final void v() {
        this.f502858a.d();
    }

    @Override // com.larus.im.service.audio.z
    public final boolean b(boolean r100) {
        return this.f502858a.b(r100);
    }

    @Override // com.larus.im.service.audio.z
    public final boolean c(boolean r100) {
        return this.f502858a.c(r100);
    }

    @Override // com.larus.im.service.audio.z
    public final void h(tf9.b r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        this.f502858a.h(r100);
    }

    @Override // com.larus.im.service.audio.z
    public final void q(CommonVideoAutoTestPlugin.a r100) {
        this.f502858a.q(r100);
    }

    @Override // com.larus.im.service.audio.z
    public final int r(tf9.a r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        return this.f502858a.j(r100);
    }

    @Override // com.larus.im.service.audio.z
    public final void t(boolean r100) {
        this.f502858a.e(r100, this.f502859b, this.f502860c);
    }

    @Override // com.larus.im.service.audio.z
    public final void f(float r100, float r101) {
        this.f502858a.f(r100, r101);
    }

    @Override // com.larus.im.service.audio.z
    public final void w(View r100, boolean r101) {
        this.f502858a.i(r100, r101);
    }

    public b(ff9.v r100, com.larus.im.internal.audio.session.v2.j r101, com.larus.im.internal.audio.session.v2.k r102) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        Intrinsics.checkNotNullParameter(r101, "onKeyFrameRequested");
        Intrinsics.checkNotNullParameter(r102, "onTargetBitrateUpdated");
        this.f502858a = r100;
        this.f502859b = r101;
        this.f502860c = r102;
    }
}
