package com.bytedance.ies.xelement.defaultimpl.player.engine.impl.plugin;

import android.content.Context;
import android.media.AudioManager;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.ErrorCode;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.PlaybackState;
import com.bytedance.ies.xelement.w;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import l76.d;
import o76.e;
import o76.f;
import o76.k;

/* JADX INFO: loaded from: classes19.dex */
public final class AudioFocusControllerPlugin extends p76.a implements e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f249942g = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f249943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f249944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f249945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f249946e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f249947f;

    public static final class a {
    }

    public static final class b implements AudioManager.OnAudioFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<AudioFocusControllerPlugin> f249948a;

        public b(WeakReference<AudioFocusControllerPlugin> r100) {
            Intrinsics.checkNotNullParameter(r100, "weakRef");
            this.f249948a = r100;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(int r100) {
            AudioFocusControllerPlugin r101 = this.f249948a.get();
            if (r101 != null) goto L5;
            return;
        L5:
            boolean r102 = true;
            if (r100 == (-2)) goto L30;
            if (r100 == (-1)) goto L30;
            if (r100 != 1) goto L39;
            d.f507797a.b(AudioFocusControllerPlugin.f249942g, "AUDIOFOCUS_GAIN, and resume the play");
            p76.b r103 = r101.f528030a;
            if (r103 == null) goto L28;
            o76.b r104 = r103.f528035e;
            if (r104 != null) goto L17;
            return;
        L17:
            if (r104.c() == PlaybackState.PLAYBACK_STATE_PAUSED) goto L20;
            r102 = false;
        L20:
            n76.b r105 = r104.j();
            if (r105 == null) goto L23;
            String r106 = r105.f518205a;
        L24:
            boolean r107 = Intrinsics.areEqual(r106, "PAUSE_FROM_LOSS_FOCUS");
            if (r102 == false) goto L35;
            if (r107 == false) goto L36;
            r104.a(null);
            return;
        L36:
            return;
        L35:
            return;
        L23:
            r106 = null;
            goto L24
        L28:
            return;
        L39:
            return;
        L30:
            if (System.currentTimeMillis() <= r101.f249947f) goto L32;
            ((AudioFocusControllerPlugin$mHandler$2.a) r101.f249944c.getValue()).sendEmptyMessageDelayed(1, 1000);
            return;
        L32:
            d r108 = d.f507797a;
            String r109 = AudioFocusControllerPlugin.f249942g;
            v76.a.C7969a r110 = w.f250621a;
            r101.w();
        }
    }

    @Override // o76.e
    public final boolean f() {
        return false;
    }

    @Override // o76.e
    public final k l(k r100) {
        return r100;
    }

    static {
        f249942g = AudioFocusControllerPlugin.class.getSimpleName();
    }

    public final void v() {
        b r100 = this.f249946e;     // Catch: Throwable -> L6
        if (r100 == null) goto L11;
        ((AudioManager) this.f249945d.getValue()).abandonAudioFocus(r100);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        d.f507797a.a(f249942g, th.getMessage());
    }

    public final boolean w() {
        b r100 = this.f249946e;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (((AudioManager) this.f249945d.getValue()).requestAudioFocus(r100, 3, 1) != 1) goto L7;
        return true;
    }

    @Override // p76.c
    public final void onDetach() {
        v();
        p76.b r100 = this.f528030a;
        if (r100 == null) goto L7;
        f r101 = r100.f528034d;
        if (r101 == null) goto L7;
        r101.h(this);
    L7:
        this.f249946e = null;
    }

    public AudioFocusControllerPlugin(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f249943b = r100.getApplicationContext();
        this.f249944c = LazyKt.lazy(new AudioFocusControllerPlugin$mHandler$2(this));
        this.f249945d = LazyKt.lazy(new AudioFocusControllerPlugin$mAudioManager$2(this));
        this.f249946e = new b(new WeakReference(this));
    }

    @Override // o76.e
    public final boolean a(n76.b r100) {
        if (w() == false) goto L5;
        return false;
    L5:
        d.f507797a.b(f249942g, "Request audio focus failed, we intercept this resume operation.");
        return true;
    }

    @Override // o76.e
    public final boolean b(n76.b r100) {
        if (r100 == null) goto L4;
        String r101 = r100.f518205a;
    L6:
        if (Intrinsics.areEqual(r101, "PAUSE_FROM_LOSS_FOCUS") == false) goto L8;
        d.f507797a.b(f249942g, "Pause reason is loss focus, we needn't release audio focus for help us can retrieve focus again.");
        return false;
    L8:
        v();
        return false;
    L4:
        r101 = null;
        goto L6
    }

    @Override // o76.e
    public final boolean d(n76.b r100) {
        if (w() == false) goto L5;
        return false;
    L5:
        d.f507797a.c(f249942g, "Request audio focus failed, we intercept this play operation.");
        return true;
    }

    @Override // o76.e
    public final boolean g(n76.b r100) {
        if (((AudioFocusControllerPlugin$mHandler$2.a) this.f249944c.getValue()).hasMessages(1) == false) goto L5;
        ((AudioFocusControllerPlugin$mHandler$2.a) this.f249944c.getValue()).removeMessages(1);
        d.f507797a.b(f249942g, "Found pending execute pause task when stop invoked, remove this task immediate.");
    L5:
        this.f249947f = System.currentTimeMillis() + 1000;
        v();
        return false;
    }

    @Override // p76.a, o76.c
    public final void h(ErrorCode r100) {
        Intrinsics.checkNotNullParameter(r100, "errorCode");
        Intrinsics.checkNotNullParameter(r100, "errorCode");
        Intrinsics.checkNotNullParameter(r100, "errorCode");
        v();
        d.f507797a.a(f249942g, "abandon focus because of onError: " + r100);
    }

    @Override // p76.a, p76.c
    public final void n(p76.b r100) {
        Intrinsics.checkNotNullParameter(r100, "attachInfo");
        super.n(r100);
        p76.b r101 = this.f528030a;
        if (r101 == null) goto L8;
        f r102 = r101.f528034d;
        if (r102 == null) goto L9;
        r102.m(this);
        return;
    L9:
        return;
    }

    @Override // p76.a, o76.c
    public final void p(PlaybackState r100) {
        Intrinsics.checkNotNullParameter(r100, "currentState");
        Intrinsics.checkNotNullParameter(r100, "currentState");
        Intrinsics.checkNotNullParameter(r100, "currentState");
        if (r100 != PlaybackState.PLAYBACK_STATE_ERROR) goto L5;
    L6:
        v();
        d.f507797a.b(f249942g, "abandon focus because of: " + r100);
        return;
    L5:
        if (r100 == PlaybackState.PLAYBACK_STATE_STOPPED) goto L6;
    }
}
