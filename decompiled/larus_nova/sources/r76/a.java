package r76;

import com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.ErrorCode;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.LoadingState;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.PlaybackState;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.SeekState;
import com.bytedance.ies.xelement.defaultimpl.player.engine.impl.player.AudioPlayerController;
import com.bytedance.ies.xelement.defaultimpl.player.engine.impl.player.MusicPlayerImpl;
import kotlin.jvm.internal.Intrinsics;
import n76.b;
import o76.c;
import o76.e;
import o76.i;
import o76.k;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements e, i, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AudioPlayerController f536463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f536464b;

    @Override // o76.e
    public final boolean a(b r100) {
        return false;
    }

    @Override // o76.e
    public final boolean d(b r100) {
        return false;
    }

    @Override // o76.e
    public final boolean f() {
        return false;
    }

    @Override // o76.e
    public final boolean g(b r100) {
        return false;
    }

    @Override // o76.c
    public final void i(long r100) {
    }

    @Override // o76.i
    public final b j() {
        throw null;
    }

    @Override // o76.e
    public final k l(k r100) {
        return r100;
    }

    @Override // o76.c
    public final void onCompletion() {
    }

    @Override // o76.c
    public final void onPrepare() {
    }

    @Override // o76.c
    public final void onPrepared() {
    }

    @Override // o76.c
    public final void onRenderStart() {
    }

    @Override // o76.c
    public final void s(long r100) {
    }

    @Override // o76.c
    public final void t(k r100) {
    }

    @Override // o76.c
    public final void u(float r100) {
    }

    public a(AudioPlayerController r100) {
        Intrinsics.checkNotNullParameter(r100, "mMusicPlayerController");
        this.f536463a = r100;
    }

    @Override // o76.e
    public final boolean b(b r100) {
        this.f536464b = r100;
        return false;
    }

    @Override // o76.c
    public final void e(LoadingState r100) {
        Intrinsics.checkNotNullParameter(r100, "loadingState");
    }

    @Override // o76.c
    public final void h(ErrorCode r100) {
        Intrinsics.checkNotNullParameter(r100, "errorCode");
    }

    @Override // o76.c
    public final void p(PlaybackState r100) {
        Intrinsics.checkNotNullParameter(r100, "currentState");
        Intrinsics.checkNotNullParameter(r100, "currentState");
        if (r100 != PlaybackState.PLAYBACK_STATE_STOPPED) goto L11;
        MusicPlayerImpl r101 = this.f536463a.p();
        if (r101.f249893f != null) goto L7;
        boolean r102 = false;
    L8:
        if (r102 == false) goto L12;
        Intrinsics.checkNotNullParameter("STOP_FROM_PLAY_COMPLETION", "from");
        return;
    L12:
        return;
    L7:
        r102 = r101.b().e();
        goto L8
    }

    @Override // o76.c
    public final void q(SeekState r100) {
        Intrinsics.checkNotNullParameter(r100, "seekState");
    }
}
