package com.larus.dora.impl.onboarding.g.v2.viewmodel;

import android.animation.ValueAnimator;
import android.content.Context;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.media.MediaScene;
import com.larus.platform.api.IVideoController;
import com.larus.utils.t0;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.DataLoaderHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class l {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f336813g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f336814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f336815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f336816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ValueAnimator f336817d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f336818e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.larus.media.model.a f336819f;

    public interface a {
    }

    public static final class b {
    }

    public static final class c implements com.larus.media.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f336820a;

        public c(l r100) {
            this.f336820a = r100;
        }

        @Override // com.larus.media.v
        public final boolean b(lk9.g r100) {
            Intrinsics.checkNotNullParameter(r100, "applicant");
            return true;
        }

        @Override // com.larus.media.v
        public final void e(lk9.g r100) {
            Intrinsics.checkNotNullParameter(r100, "applicant");
            com.larus.media.v.a.d(r100);
            l r101 = this.f336820a;
            r101.getClass();
            long r102 = 11000;
            t0.e(new g(r101, r102, null));
        }

        @Override // com.larus.media.v
        public final void f(MediaResourceManager.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
        }

        @Override // com.larus.media.v
        public final void a(lk9.g r100, float r101) {
            com.larus.media.v.a.f(r100, r101);
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
        public final MediaOccupyStrategy h(lk9.g r100, lk9.g r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "current");
            Intrinsics.checkNotNullParameter(r101, "applicant");
            return MediaOccupyStrategy.INTERRUPT;
        }
    }

    static {
    }

    public final IVideoController a() {
        return (IVideoController) this.f336814a.getValue();
    }

    public final void b() {
        if (this.f336818e == false) goto L5;
        d(null);
    L5:
        IVideoController r100 = a();
        if (r100 == null) goto L8;
        r100.t();
    L8:
        IVideoController r101 = a();
        if (r101 == null) goto L12;
        r101.release();
        return;
    }

    public l() {
        this.f336814a = LazyKt.lazy(new h());
        this.f336815b = LazyKt.lazy(new i());
        this.f336819f = new com.larus.media.model.a(null, MediaScene.DORA_ONBOARDING_BACKGROUND, false, 0, 2, false, 0, false, false, 0, false, new c(this), DataLoaderHelper.DATALOADER_KEY_STRING_PRECISE_PRELOAD_CONFIG);
    }

    public final void d(Function0<Unit> r100) {
        g49.d.a("DoraOnboardingBgMusicPlayerV2", "stopPlay: isPlaying=" + this.f336818e);     // Catch: Exception -> L9
        if (this.f336818e == false) goto L11;
        this.f336818e = false;     // Catch: Exception -> L9
        IVideoController r101 = a();     // Catch: Exception -> L9
        if (r101 == null) goto L11;
        r101.stop();     // Catch: Exception -> L9
    L11:
        Lazy r102 = MediaResourceManager.f358950a;
        MediaResourceManager.a(this.f336819f);
        if (r100 == null) goto L17;
        r100.invoke();
        return;
    L17:
        return;
    L9:
        e = move-exception;
        g49.d.c("DoraOnboardingBgMusicPlayerV2", "stopPlay: error", e);
        goto L11
    }

    public static void c(final l r100, final Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("dora_onboarding_background_music.mp3", "path");
        ValueAnimator r101 = r100.f336816c;
        final boolean r102 = true;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L15;
        ValueAnimator r104 = r100.f336816c;
        if (r104 == null) goto L13;
        r104.cancel();
    L13:
        ValueAnimator r111 = tk9.b.a(0.0f, 1.0f, 200, new d(r100, r110, r102), new e(r100), new f(r100));
        r100.f336816c = r111;
        r111.start();
        return;
    L15:
        return;
    L5:
        if (r101.isRunning() != true) goto L7;
        r103 = true;
        goto L8
    }
}
