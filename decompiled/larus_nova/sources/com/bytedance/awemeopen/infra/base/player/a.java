package com.bytedance.awemeopen.infra.base.player;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements r64.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AoDefaultPlayer f198734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f198735b;

    /* JADX INFO: renamed from: com.bytedance.awemeopen.infra.base.player.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C2874a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f198736a = null;

        static {
            int[] r100 = new int[PlayState.values().length];
            r100[PlayState.STATE_PAUSE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[PlayState.STATE_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f198736a = r100;
        }
    }

    @Override // r64.d
    public final void c(String r100) {
        this.f198735b.c(r100);
    }

    @Override // r64.d
    public final void h(String r100) {
        this.f198735b.h(r100);
    }

    @Override // r64.d
    public final void onPlayPrepare(String r100) {
        if (this.f198734a.f198720g.getAndSet(true) == false) goto L5;
        return;
    L5:
        AoDefaultPlayer r101 = this.f198734a;
        PlayState r102 = r101.f198715b;
        if (r101.f198719f.get() == false) goto L17;
        this.f198735b.onPlayPrepare(r100);
        if (this.f198734a.f198715b == r102) goto L10;
        return;
    L10:
        int r103 = C2874a.f198736a[r102.ordinal()];
        if (r103 != 1) goto L13;
        this.f198734a.pause();
        return;
    L13:
        if (r103 != 2) goto L21;
        this.f198734a.resume();
        return;
    L21:
        return;
    L17:
        AoDefaultPlayer r104 = this.f198734a;
        r104.f198715b = PlayState.STATE_START;
        this.f198735b.onPlayPrepare(r100);
    }

    @Override // r64.d
    public final void onPlaying(String r100) {
        g(r100, this.f198734a.f198714a.h(), "");
        this.f198735b.onPlaying(r100);
    }

    public a(AoDefaultPlayer r100, k r101) {
        this.f198734a = r100;
        this.f198735b = r101;
    }

    @Override // r64.d
    public final void a(String r100, r64.c r101) {
        Intrinsics.checkNotNullParameter(r101, "statusInfo");
        AoDefaultPlayer r102 = this.f198734a;
        if (r102.f198715b != PlayState.STATE_PAUSE) goto L5;
        r102.f198714a.pause();
    L5:
        k r103 = this.f198735b;
        int r104 = c.f198738a;
        Intrinsics.checkNotNullParameter(r101, "bdpPlayerStatusInfo");
        l r105 = new l();
        r105.f198772a = r101.f536342a;
        r103.l(r100, r105);
    }

    @Override // r64.d
    public final void d(String r100, long r101, int r102) {
        this.f198735b.d(r100, r101, r102);
    }

    @Override // r64.d
    public final void e(String r100, int r101, String r102) {
        this.f198735b.e(r100, r101, r102);
    }

    @Override // r64.d
    public final void g(String r100, boolean r101, String r102) {
        onPlayPrepare(r100);
        if (this.f198734a.f198721h.getAndSet(true) == true) goto L6;
        this.f198735b.g(r100, r101, r102);
        return;
    }

    @Override // r64.d
    public final void f(String r100, boolean r101, int r102, int r103) {
        this.f198735b.f(r100, r101, r102, r103);
    }
}
