package com.larus.call_plugins_doubao_common.manager;

import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class j0 implements com.larus.media.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n0 f321418a;

    public j0(n0 r100) {
        this.f321418a = r100;
    }

    @Override // com.larus.media.v
    public final boolean b(lk9.g r100) {
        Intrinsics.checkNotNullParameter(r100, "applicant");
        return true;
    }

    @Override // com.larus.media.v
    public final void e(lk9.g r100) {
        com.larus.media.v.a.d(r100);
    }

    @Override // com.larus.media.v
    public final void f(MediaResourceManager.a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
    }

    @Override // com.larus.media.v
    public final void a(final lk9.g r100, final float r101) {
        Intrinsics.checkNotNullParameter(r100, "applicant");
        com.larus.media.v.a.f(r100, r101);
        final n0 r102 = this.f321418a;
        r102.f321440m.post(new h0(r102, r100, r101));
    }

    @Override // com.larus.media.v
    public final void d(lk9.g r100, lk9.g r101) {
        com.larus.media.v.a.c(r100, r101);
    }

    @Override // com.larus.media.v
    public final void g(lk9.g r100, float r101) {
        com.larus.media.v.a.g(r100, r101);
    }

    @Override // com.larus.media.v
    public final void i(lk9.g r100, lk9.g r101) {
        com.larus.media.v.a.e(r100, r101);
    }

    @Override // com.larus.media.v
    public final MediaOccupyStrategy c(lk9.g r100, lk9.g r101, int r102) {
        return com.larus.media.v.a.a(this, r100, r101, r102);
    }

    @Override // com.larus.media.v
    public final MediaOccupyStrategy h(final lk9.g r100, final lk9.g r101, final int r102) {
        Intrinsics.checkNotNullParameter(r100, "current");
        Intrinsics.checkNotNullParameter(r101, "applicant");
        if (this.f321418a.i(r102) == false) goto L6;
        FLogger.f375446a.i(this.f321418a.h(), "temporary loss focus, not pause by recordApplicant");
        return MediaOccupyStrategy.REJECT;
    L6:
        final n0 r103 = this.f321418a;
        r103.f321440m.post(new i0(r103, r100, r101, r102));
        return MediaOccupyStrategy.PAUSE;
    }
}
