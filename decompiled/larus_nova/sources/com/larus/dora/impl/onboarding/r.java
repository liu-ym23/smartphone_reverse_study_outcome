package com.larus.dora.impl.onboarding;

import android.animation.ValueAnimator;
import android.content.Context;
import com.larus.common.apphost.AppHost;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.media.MediaScene;
import com.larus.platform.api.IVideoController;
import com.larus.utils.t0;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.DataLoaderHelper;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class r {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f337333h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f337334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f337335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f337336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ValueAnimator f337337d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ValueAnimator f337338e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f337339f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.larus.media.model.a f337340g;

    public interface a {
    }

    public static final class b {
    }

    public static final class c implements com.larus.media.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f337341a;

        public c(r r100) {
            this.f337341a = r100;
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
            r.e(this.f337341a, null, 3);
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
        return (IVideoController) this.f337334a.getValue();
    }

    public final void b() {
        if (this.f337339f == false) goto L5;
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

    public r() {
        this.f337334a = LazyKt.lazy(new h());
        this.f337335b = AppHost.f326268a.getApplication().getFilesDir().getAbsolutePath() + File.separator + "dora_onboarding_background_music.mp3";
        this.f337336c = LazyKt.lazy(new i());
        this.f337340g = new com.larus.media.model.a(null, MediaScene.DORA_ONBOARDING_BACKGROUND, false, 0, 2, false, 0, false, false, 0, false, new c(this), DataLoaderHelper.DATALOADER_KEY_STRING_PRECISE_PRELOAD_CONFIG);
    }

    public final void d(Function0<Unit> r100) {
        g49.d.a("DoraOnboardingBgMusicPlayer", "stopPlay: isPlaying=" + this.f337339f);     // Catch: Exception -> L9
        if (this.f337339f == false) goto L11;
        this.f337339f = false;     // Catch: Exception -> L9
        IVideoController r101 = a();     // Catch: Exception -> L9
        if (r101 == null) goto L11;
        r101.stop();     // Catch: Exception -> L9
    L11:
        Lazy r102 = MediaResourceManager.f358950a;
        MediaResourceManager.a(this.f337340g);
        if (r100 == null) goto L17;
        r100.invoke();
        return;
    L17:
        return;
    L9:
        e = move-exception;
        g49.d.c("DoraOnboardingBgMusicPlayer", "stopPlay: error", e);
        goto L11
    }

    public static void c(final r r100, final Context r101) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        ValueAnimator r102 = r100.f337337d;
        if (r102 == null) goto L7;
        boolean r103 = true;
        if (r102.isRunning() != true) goto L7;
    L8:
        if (r103 == false) goto L10;
        g49.d.a("DoraOnboardingBgMusicPlayer", "[playAudio] globalAnimator isRunning ");
        return;
    L10:
        ValueAnimator r104 = r100.f337337d;
        if (r104 == null) goto L13;
        r104.cancel();
    L13:
        ValueAnimator r105 = tk9.b.a(0.0f, 1.0f, 200, new l(r100, r101), new m(r100), new n(r100));
        r100.f337337d = r105;
        r105.start();
        return;
    L7:
        r103 = false;
        goto L8
    }

    public static void e(final r r100, final Function0 r101, int r102) {
        if ((r102 & 1) == 0) goto L5;
        final long r103 = 11000;
    L7:
        if ((r102 & 2) == 0) goto L9;
        r101 = null;
    L9:
        r100.getClass();
        t0.e(new o(r100, r103, r101));
        return;
    L5:
        r103 = 0;
        goto L7
    }
}
