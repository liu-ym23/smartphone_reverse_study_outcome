package p76;

import com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.ErrorCode;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.LoadingState;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.PlaybackState;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.SeekState;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.PlayMode;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.f;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.h;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;
import o76.k;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f528030a;

    public a() {
    }

    @Override // o76.c
    public void i(long r100) {
    }

    public void m(f r100) {
    }

    @Override // o76.c
    public void onCompletion() {
    }

    @Override // o76.c
    public final void onPrepare() {
    }

    @Override // o76.c
    public void onPrepared() {
    }

    @Override // o76.c
    public final void onRenderStart() {
    }

    @Override // com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.c
    public final void r(h r100) {
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

    @Override // com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.c
    public final void c(PlayMode r100) {
        Intrinsics.checkNotNullParameter(r100, Keys.API_EVENT_KEY_PLAY_MODE);
        Intrinsics.checkNotNullParameter(r100, Keys.API_EVENT_KEY_PLAY_MODE);
    }

    @Override // o76.c
    public final void e(LoadingState r100) {
        Intrinsics.checkNotNullParameter(r100, "loadingState");
        Intrinsics.checkNotNullParameter(r100, "loadingState");
    }

    @Override // o76.c
    public void h(ErrorCode r100) {
        Intrinsics.checkNotNullParameter(r100, "errorCode");
        Intrinsics.checkNotNullParameter(r100, "errorCode");
    }

    @Override // p76.c
    public void n(b r100) {
        Intrinsics.checkNotNullParameter(r100, "attachInfo");
        this.f528030a = r100;
    }

    @Override // o76.c
    public void p(PlaybackState r100) {
        Intrinsics.checkNotNullParameter(r100, "currentState");
        Intrinsics.checkNotNullParameter(r100, "currentState");
    }

    @Override // o76.c
    public void q(SeekState r100) {
        Intrinsics.checkNotNullParameter(r100, "seekState");
        Intrinsics.checkNotNullParameter(r100, "seekState");
    }
}
