package com.bytedance.android.livesdk.livecommerce.playback.video;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.g;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.model.playback.ECReplayVideo;
import com.bytedance.android.ec.model.playback.ExplainPlaybackVideoInfo;
import com.bytedance.android.ec.model.playback.LogExtraData;
import com.bytedance.android.ec.model.playback.PlaybackEventExtraData;
import com.bytedance.android.ec.model.playback.ReplayCards;
import com.bytedance.android.ec.model.video.UrlModel;
import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackFragment;
import com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackViewModel;
import com.bytedance.android.livesdk.livecommerce.playback.model.ExplainPlaybackFinalParams;
import com.bytedance.android.livesdk.livecommerce.playback.utils.ExplainPlaybackUtils;
import com.bytedance.android.shopping.api.playback.IVideoPlaybackService;
import com.bytedance.android.shopping.widget.ecvideoplayer.h;
import com.bytedance.common.utility.UIUtils;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import dj2.k;
import hh2.f;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\b\u0010\u0006\u001a\u00020\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/video/ExplainPlaybackVideoPresenter;", "Lcom/ss/android/ugc/aweme/kiwi/presenter/QFragmentPresenter;", "Lda3/d;", "Landroidx/lifecycle/LifecycleObserver;", "Lda3/c;", "", "onPause", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExplainPlaybackVideoPresenter extends QFragmentPresenter implements da3.d, LifecycleObserver, da3.c {
    public e f;
    public ExplainPlaybackViewModel g;
    public ExplainPlaybackVideoViewModel h;
    public boolean i;
    public boolean j;
    public View k;
    public boolean l;

    public final void onRelease() {
    }

    public final void onVideoSizeChanged(int r1, int r2) {
    }

    public final void E() {
        bj2.a.b("ExplainPlaybackVideoPresenter", "onPreparing");
        j0(true);
    }

    public final void c0() {
        bj2.a.b("ExplainPlaybackVideoPresenter", "onUnBind");
        ECQuickUtilKt.a(Y()).getLifecycle().removeObserver(this);
        d.b(null);
        e r1 = this.f;
        if (r1 == null) goto L5;
        r1.c(false);
    L5:
        e r2 = this.f;
        if (r2 == null) goto L8;
        r2.e(null);
    L8:
        View r3 = this.k;
        if (r3 == null) goto L11;
        ((FrameLayout) Z().b(2131367506).f()).removeView(r3);
    L11:
        this.f = null;
        this.i = false;
        ExplainPlaybackViewModel r0 = this.g;
        if (r0 == null) goto L15;
        r0.onUnBind();
        return;
    }

    public final void e0() {
        e r0 = this.f;
        if (r0 == null) goto L5;
        int r1 = r0.e.getWatchedDuration();
        int r2 = bj2.a.a;
        bj2.a.b("VideoPlayBackPlayController", "getWatchedDuration:" + r1);
    L6:
        ExplainPlaybackVideoViewModel r3 = this.h;
        if (r3 == null) goto L9;
        r3.setPlayDuration(r1);
    L9:
        ExplainPlaybackViewModel r4 = this.g;
        if (r4 != null) goto L12;
    L20:
        cj2.c r5 = cj2.a.a;
        HashMap r6 = new HashMap();
        r6.put("duration", String.valueOf(r1));
        r6.put("ecom_entrance_form", "replay_popup_card");
        cj2.c r7 = cj2.a.a;
        if (r7 == null) goto L23;
        r6.put("start_volume_pct", String.valueOf(Double.valueOf(r7.c).doubleValue()));
    L23:
        cj2.c r8 = cj2.a.a;
        if (r8 == null) goto L26;
        r6.put("system_volume_pct", String.valueOf(Double.valueOf(r8.b).doubleValue()));
    L26:
        r6.put("end_volume_pct", String.valueOf(g.a()));
        cj2.a.a("livesdk_explain_replay_duration", r6, null, null);
        return;
    L12:
        if (r4.getClosePageByUser() != true) goto L20;
        cj2.c r9 = cj2.a.a;
        HashMap r10 = new HashMap();
        r10.put("duration", String.valueOf(r1));
        r10.put("ecom_entrance_form", "replay_popup_card");
        cj2.c r11 = cj2.a.a;
        if (r11 == null) goto L16;
        r10.put("start_volume_pct", String.valueOf(Double.valueOf(r11.c).doubleValue()));
    L16:
        cj2.c r12 = cj2.a.a;
        if (r12 == null) goto L19;
        r10.put("system_volume_pct", String.valueOf(Double.valueOf(r12.b).doubleValue()));
    L19:
        r10.put("end_volume_pct", String.valueOf(g.a()));
        cj2.a.a("livesdk_explain_replay_return_play_duration", r10, null, null);
        goto L20
    L5:
        r1 = 0;
        goto L6
    }

    public final void g() {
        bj2.a.b("ExplainPlaybackVideoPresenter", "onPlayCompleted");
        if (ExplainPlaybackUtils.d() == true) goto L22;
        ExplainPlaybackViewModel r1 = this.g;
        if (r1 == null) goto L11;
        com.bytedance.android.livesdk.livecommerce.playback.main.b r2 = r1.getExplainPlaybackOriginParams();
        if (r2 == null) goto L11;
        LogExtraData r3 = r2.d;
        if (r3 == null) goto L11;
        String r4 = r3.getEnterScene();
    L13:
        if (ExplainPlaybackUtils.e(r4) == true) goto L22;
        e r0 = this.f;
        if (r0 == null) goto L18;
        bj2.a.b("VideoPlayBackPlayController", "seek:0.0");
        r0.e.seek(0.0f);
    L18:
        ExplainPlaybackVideoViewModel r5 = this.h;
        if (r5 == null) goto L21;
        com.bytedance.android.ec.core.arch.event.c.d(r5, a.e.a);
    L21:
        cj2.c r6 = cj2.a.a;
        HashMap r7 = new HashMap();
        r7.put("ecom_entrance_form", "replay_popup_card");
        cj2.a.a("livesdk_explain_replay_finish", r7, null, null);
        return;
    L11:
        r4 = null;
    L22:
        i0(true);
        e r8 = this.f;
        if (r8 == null) goto L25;
        r8.d();
    L25:
        e r9 = this.f;
        if (r9 == null) goto L28;
        r9.b();
    L28:
        cj2.c r10 = cj2.a.a;
        HashMap r11 = new HashMap();
        r11.put("ecom_entrance_form", "replay_popup_card");
        cj2.a.a("livesdk_explain_replay_finish", r11, null, null);
        ExplainPlaybackVideoViewModel r12 = this.h;
        if (r12 == null) goto L41;
        b r13 = (b) r12.getState();
        if (r13 == null) goto L42;
        Integer r14 = r13.b;
        if (r14 != null) goto L35;
        return;
    L35:
        if (r14.intValue() < 30000) goto L44;
        bj2.a.b("ExplainPlaybackVideoPresenter", "sendEvent ShowOrHideSmallProductCardEvent");
        ExplainPlaybackViewModel r15 = this.g;
        if (r15 == null) goto L45;
        com.bytedance.android.ec.core.arch.event.c.d(r15, new com.bytedance.android.livesdk.livecommerce.playback.main.a.l());
        return;
    L45:
        return;
    L44:
        return;
    L42:
        return;
    }

    public final void h0() {
        WeakReference<e> r0 = d.a;
        d.b(this.f);
        e r1 = this.f;
        if (r1 != null) goto L5;
    L34:
        e r2 = this.f;
        if (r2 == null) goto L37;
        bj2.a.b("VideoPlayBackPlayController", "playVideo");
        r2.e.a();
    L37:
        String r3 = cj2.b.a;
        com.bytedance.android.ec.monitor.duration.d r4 = i.a.get(cj2.b.a);
        if (r4 == null) goto L40;
        r4.a("video_load_start");
    L40:
        bj2.a.b("ExplainPlaybackVideoPresenter", "playVideo");
        return;
    L5:
        if (r1.a() == true) goto L34;
        ExplainPlaybackViewModel r5 = this.g;
        if (r5 == null) goto L9;
        ExplainPlaybackFinalParams r6 = r5.getExplainPlaybackFinalFinalParams();
    L10:
        cj2.c r7 = cj2.a.a;
        if (r6 == null) goto L13;
        Long r8 = r6.getReplayViewNum();
    L14:
        if (r6 == null) goto L18;
        ReplayCards r9 = r6.getReplayCards();
        if (r9 == null) goto L18;
        int r10 = r9.getProductReplayCnt();
    L19:
        cj2.c r11 = cj2.a.a;
        if (r11 == null) goto L22;
        r11.c = g.a();
    L22:
        HashMap r12 = new HashMap();
        r12.put("ecom_entrance_form", "replay_popup_card");
        if (r8 == null) goto L26;
        String r13 = (String) r12.put("explain_replay_play_num", String.valueOf(r8.longValue()));
    L26:
        if (r10 != 1) goto L28;
        String r14 = "product";
    L31:
        if (r14 == null) goto L33;
        r12.put("replay_type", r14);
    L33:
        cj2.a.a("livesdk_explain_replay_play", r12, null, null);
        goto L34
    L28:
        if (r10 <= 1) goto L30;
        r14 = "scroll";
        goto L31
    L30:
        r14 = null;
    L18:
        r10 = 0;
        goto L19
    L13:
        r8 = null;
        goto L14
    L9:
        r6 = null;
        goto L10
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        e r0 = this.f;
        if (r0 == null) goto L5;
        bj2.a.b("ExplainPlaybackVideoPresenter", "pauseVideo");
        r0.b();
        e0();
    L5:
        ExplainPlaybackVideoViewModel r2 = this.h;
        if (r2 == null) goto L12;
        b r3 = (b) r2.getState();
        if (r3 == null) goto L12;
        Integer r4 = r3.a;
        if (r4 == null) goto L12;
        float r5 = r4.intValue();
    L13:
        s0.a(new ij.a(r5));
        e r1 = this.f;
        if (r1 == null) goto L16;
        r1.e.f();
    L16:
        bj2.a.b("ExplainPlaybackVideoPresenter", "consume fragment onPause");
        return;
    L12:
        r5 = 0.0f;
        goto L13
    }

    public final void onPaused() {
        bj2.a.b("ExplainPlaybackVideoPresenter", "onPaused");
        i0(true);
    }

    public final void onPlaying() {
        if (this.l == false) goto L10;
        this.l = false;
        i r0 = i.a;
        ExplainPlaybackFragment.j.getClass();
        com.bytedance.android.ec.monitor.duration.d r2 = r0.get(ExplainPlaybackFragment.i);
        if (r2 == null) goto L7;
        r2.a("render_end");
    L7:
        com.bytedance.android.ec.monitor.duration.d r1 = r0.get(ExplainPlaybackFragment.i);
        if (r1 == null) goto L10;
        r1.report();
    L10:
        bj2.a.b("ExplainPlaybackVideoPresenter", "onPlaying");
        i0(false);
        ExplainPlaybackViewModel r3 = this.g;
        if (r3 == null) goto L14;
        com.bytedance.android.ec.core.arch.event.c.d(r3, com.bytedance.android.livesdk.livecommerce.playback.main.a.d.a);
        return;
    }

    public final void onRenderStart() {
        bj2.a.b("ExplainPlaybackVideoPresenter", "onRenderStart");
        boolean r0 = false;
        j0(false);
        ExplainPlaybackViewModel r1 = this.g;
        if (r1 == null) goto L5;
        com.bytedance.android.ec.core.arch.event.c.d(r1, com.bytedance.android.livesdk.livecommerce.playback.main.a.d.a);
    L5:
        ExplainPlaybackViewModel r2 = this.g;
        if (r2 == null) goto L8;
        com.bytedance.android.ec.core.arch.event.c.d(r2, new com.bytedance.android.livesdk.livecommerce.playback.main.a.f());
    L8:
        ExplainPlaybackVideoInfo r3 = null;
        if (ECSettingKeys.I0() == false) goto L30;
        String r4 = cj2.b.a;
        e r5 = this.f;
        if (r5 == null) goto L13;
        ECReplayVideo r6 = r5.b;
    L14:
        if (r6 == null) goto L16;
        boolean r7 = true;
    L17:
        cj2.b.a("has_mbr_data", Boolean.valueOf(r7));
        e r8 = this.f;
        if (r8 == null) goto L28;
        ECReplayVideo r9 = r8.b;
        if (r9 == null) goto L28;
        UrlModel r10 = r9.getH265PlayAddr();
        if (r10 == null) goto L28;
        List r11 = r10.getUrlList();
        if (r11 == null) goto L28;
        if ((!r11.isEmpty()) != true) goto L28;
        boolean r12 = true;
    L29:
        cj2.b.a("has_h265_info", Boolean.valueOf(r12));
    L28:
        r12 = false;
        goto L29
    L16:
        r7 = false;
        goto L17
    L13:
        r6 = null;
    L30:
        String r13 = cj2.b.a;
        ExplainPlaybackViewModel r14 = this.g;
        if (r14 == null) goto L38;
        e r15 = this.f;
        if (r15 == null) goto L36;
        r3 = r15.a;
    L36:
        if (r14.isVideoPreload(r3) != true) goto L38;
        r0 = true;
    L38:
        i r16 = i.a;
        com.bytedance.android.ec.monitor.duration.d r17 = r16.get(cj2.b.a);
        if (r17 == null) goto L42;
        r17.a("video_load_end");
    L42:
        if (cj2.b.b <= 0) goto L46;
        com.bytedance.android.ec.monitor.duration.d r18 = r16.get(cj2.b.a);
        if (r18 == null) goto L46;
        r18.b("init_to_video_load_duration", Long.valueOf(SystemClock.elapsedRealtime() - cj2.b.b));
    L46:
        cj2.b.d = true;
        if (r0 == false) goto L50;
        cj2.b.f("1");
    L50:
        if (cj2.b.c == true) goto L52;
        return;
    L52:
        if (cj2.b.e == true) goto L56;
        cj2.b.c();
        cj2.b.e(true);
        return;
    }

    public final void w() {
        bj2.a.b("ExplainPlaybackVideoPresenter", "onBuffering");
        j0(false);
    }

    public ExplainPlaybackVideoPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.l = true;
    }

    public final void b0(QModel r5) {
        Z().b(2131367493).c();
        ECQuickUtilKt.a(Y()).getLifecycle().addObserver(this);
        this.g = Y().g(ExplainPlaybackViewModel.class);
        this.h = Y().g(ExplainPlaybackVideoViewModel.class);
        final FrameLayout r6 = (FrameLayout) Z().b(2131367506).f();
        ExplainPlaybackViewModel r0 = this.g;
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.livecommerce.playback.main.b r1 = r0.getExplainPlaybackOriginParams();
        if (r1 == null) goto L9;
        LogExtraData r2 = r1.d;
        if (r2 == null) goto L9;
        String r3 = r2.getEnterScene();
    L11:
        if (ExplainPlaybackUtils.d() == false) goto L13;
    L18:
        ExplainPlaybackViewModel r4 = this.g;
        if (r4 == null) goto L21;
        com.bytedance.android.ec.core.arch.state.c.a(r4, com.bytedance.android.ec.core.arch.lifecycle.g.a(Y()), ExplainPlaybackVideoPresenter$onBind$1.INSTANCE, new ExplainPlaybackVideoPresenter$onBind$2(this, r6));
    L21:
        ExplainPlaybackVideoViewModel r7 = this.h;
        if (r7 == null) goto L24;
        com.bytedance.android.ec.core.arch.state.c.a(r7, com.bytedance.android.ec.core.arch.lifecycle.g.a(Y()), ExplainPlaybackVideoPresenter$onBind$5.INSTANCE, new ExplainPlaybackVideoPresenter$onBind$6(this));
    L24:
        ExplainPlaybackVideoViewModel r8 = this.h;
        if (r8 == null) goto L27;
        com.bytedance.android.ec.core.arch.event.c.c(r8, com.bytedance.android.ec.core.arch.lifecycle.g.a(Y()), Reflection.getOrCreateKotlinClass(a.f.class), new ExplainPlaybackVideoPresenter$onBind$7(this));
    L27:
        ExplainPlaybackVideoViewModel r9 = this.h;
        if (r9 == null) goto L30;
        com.bytedance.android.ec.core.arch.event.c.c(r9, com.bytedance.android.ec.core.arch.lifecycle.g.a(Y()), Reflection.getOrCreateKotlinClass(a.e.class), new ExplainPlaybackVideoPresenter$onBind$8(this));
    L30:
        ExplainPlaybackVideoViewModel r10 = this.h;
        if (r10 == null) goto L33;
        com.bytedance.android.ec.core.arch.event.c.c(r10, com.bytedance.android.ec.core.arch.lifecycle.g.a(Y()), Reflection.getOrCreateKotlinClass(a.c.class), new ExplainPlaybackVideoPresenter$onBind$9(this));
    L33:
        ExplainPlaybackVideoViewModel r11 = this.h;
        if (r11 == null) goto L36;
        com.bytedance.android.ec.core.arch.event.c.c(r11, com.bytedance.android.ec.core.arch.lifecycle.g.a(Y()), Reflection.getOrCreateKotlinClass(a.b.class), new ExplainPlaybackVideoPresenter$onBind$10(this));
    L36:
        ExplainPlaybackViewModel r12 = this.g;
        if (r12 == null) goto L39;
        com.bytedance.android.ec.core.arch.event.c.c(r12, Y().e(), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.playback.main.a.g.class), new ExplainPlaybackVideoPresenter$onBind$11(this));
    L39:
        ExplainPlaybackViewModel r13 = this.g;
        if (r13 == null) goto L42;
        com.bytedance.android.ec.core.arch.event.c.c(r13, Y().e(), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.playback.main.a.j.class), new ExplainPlaybackVideoPresenter$onBind$12(this));
    L42:
        ExplainPlaybackViewModel r14 = this.g;
        if (r14 == null) goto L45;
        com.bytedance.android.ec.core.arch.event.c.c(r14, Y().e(), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.playback.main.a.i.class), new ExplainPlaybackVideoPresenter$onBind$13(this));
    L45:
        ExplainPlaybackViewModel r15 = this.g;
        if (r15 == null) goto L48;
        com.bytedance.android.ec.core.arch.event.c.c(r15, Y().e(), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.playback.main.a.e.class), new ExplainPlaybackVideoPresenter$onBind$14(this));
    L48:
        ExplainPlaybackViewModel r16 = this.g;
        if (r16 == null) goto L52;
        com.bytedance.android.ec.core.arch.event.c.c(r16, Y().e(), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.playback.main.a.h.class), new ExplainPlaybackVideoPresenter$onBind$15(this));
        return;
    L52:
        return;
    L13:
        if (ExplainPlaybackUtils.e(r3) == true) goto L18;
        ExplainPlaybackViewModel r17 = this.g;
        if (r17 == null) goto L21;
        com.bytedance.android.ec.core.arch.state.c.a(r17, com.bytedance.android.ec.core.arch.lifecycle.g.a(Y()), ExplainPlaybackVideoPresenter$onBind$3.INSTANCE, new ExplainPlaybackVideoPresenter$onBind$4(this, r6));
    L9:
        r3 = null;
        goto L11
    }

    public final void i0(boolean r2) {
        if (r2 == false) goto L5;
        Z().b(2131367493).g(0);
        return;
    L5:
        Z().b(2131367493).c();
    }

    public final void j0(boolean r3) {
        ExplainPlaybackViewModel r0 = this.g;
        if (r0 == null) goto L6;
        com.bytedance.android.ec.core.arch.event.c.d(r0, new com.bytedance.android.livesdk.livecommerce.playback.main.a.n(r3));
        return;
    }

    public final void h(int r3, int r4) {
        ExplainPlaybackVideoViewModel r0 = this.h;
        if (r0 == null) goto L6;
        com.bytedance.android.ec.core.arch.event.c.d(r0, new a.d(r3, r4));
        return;
    }

    public final void onError(Integer r4, String r5) {
        ExplainPlaybackViewModel r0 = this.g;
        if (r0 == null) goto L20;
        e r1 = this.f;
        String r2 = null;
        if (r1 == null) goto L7;
        ExplainPlaybackVideoInfo r3 = r1.a;
    L9:
        if (r0.isVideoPreload(r3) != true) goto L20;
        WeakReference<e> r6 = d.a;
        e r7 = this.f;
        if (r7 == null) goto L15;
        ExplainPlaybackVideoInfo r8 = r7.a;
        if (r8 == null) goto L15;
        r2 = r8.getVideoId();
    L15:
        d.a(r2);
        ExplainPlaybackViewModel r9 = this.g;
        if (r9 == null) goto L18;
        r9.reloadVideo();
    L18:
        cj2.b.b("play_error", r4, r5);
        return;
    L7:
        r3 = null;
    L20:
        int r10 = bj2.a.a;
        if (r5 != null) goto L23;
        r5 = "";
    L23:
        bj2.a.b("ExplainPlaybackVideoPresenter", "onError:".concat(r5));
        j0(false);
        ExplainPlaybackViewModel r11 = this.g;
        if (r11 == null) goto L27;
        com.bytedance.android.ec.core.arch.event.c.d(r11, new com.bytedance.android.livesdk.livecommerce.playback.main.a.C0082a(th.a.g(Y().c(), 2131896461)));
        return;
    }

    public static final void d0(final ExplainPlaybackVideoPresenter r8, k r9, final FrameLayout r10) {
        r8.getClass();
        if (r9 == null) goto L144;
        int r2 = 0;
        if (r9.a != null) goto L7;
    L9:
        boolean r0 = false;
    L10:
        ViewGroup.LayoutParams r3 = null;
        if (r0 == true) goto L14;
        r9 = null;
    L14:
        if (r9 == null) goto L145;
        bj2.a.b("ExplainPlaybackVideoPresenter", "videoInfoEntity");
        r8.i = true;
        hh2.g r1 = f.a.a;
        if (r1 == null) goto L20;
        Boolean r4 = r1.k();
        if (r4 == null) goto L20;
        boolean r5 = r4.booleanValue();
    L21:
        if (r5 == false) goto L23;
        h r6 = new h();
    L52:
        bj2.a.b("ExplainPlaybackVideoPresenter", "iECPlaybackVideoView:" + r6.getClass());
        View r7 = r8.k;
        if (r7 == null) goto L55;
        ViewParent r11 = r7.getParent();
    L57:
        if ((r11 instanceof ViewGroup) == true) goto L59;
        r11 = null;
    L59:
        ViewGroup r12 = (ViewGroup) r11;
        if (r12 == null) goto L62;
        r12.removeView(r8.k);
    L62:
        r8.k = r6.initialize(r8.Y().c());
        e r13 = new e(r8.Y().c(), r6);
        r8.f = r13;
        r13.e(r8);
        com.bytedance.android.ec.core.widget.f.c(r10, 500L, null, new ExplainPlaybackVideoPresenter$playVideo$$inlined$also$lambda$1(r8, r10), 2);
        r10.addView(r8.k, 0);
        ExplainPlaybackVideoInfo r14 = r9.a;
        if (ECSettingKeys.I0() == false) goto L82;
        ECReplayVideo r15 = r9.b;
        if (r15 == null) goto L82;
        UrlModel r16 = r15.getPlayAddr();
        if (r16 == null) goto L69;
        String r17 = r16.getUri();
    L70:
        if (r17 != null) goto L72;
    L75:
        boolean r18 = true;
    L76:
        if (r18 == false) goto L82;
        if (r14 == null) goto L82;
        ECReplayVideo r19 = r9.b;
        UrlModel r20 = new UrlModel();
        r20.setUrlKey(r14.getVideoId());
        r20.setUri(r14.getVideoId());
        r20.setWidth((int) r14.getWidth());
        r20.setHeight((int) r14.getHeight());
        String[] r21 = new String[1];
        String r110 = r14.getPlayUrl();
        if (r110 != null) goto L81;
        r110 = "";
    L81:
        r21[0] = r110;
        r20.setUrlList(CollectionsKt.mutableListOf(r21));
        Unit r111 = Unit.INSTANCE;
        r19.setPlayAddr(r20);
        goto L82
    L72:
        if (r17.length() == 0) goto L75;
        r18 = false;
        goto L76
    L69:
        r17 = null;
    L82:
        e r112 = r8.f;
        if (r112 == null) goto L88;
        ExplainPlaybackVideoInfo r22 = r9.a;
        ECReplayVideo r23 = r9.b;
        int r24 = r9.c * 1000;
        if (r22 == null) goto L88;
        r112.a = r22;
        r112.b = r23;
        r112.e.d(r22, r24);
        bj2.a.b("VideoPlayBackPlayController", "setVideoInfo");
    L88:
        e r25 = r8.f;
        if (r25 == null) goto L141;
        if (r25.c == false) goto L95;
        ECReplayVideo r113 = r25.b;
        if (r113 == null) goto L95;
        int r114 = r113.getWidth();
    L98:
        Integer r115 = Integer.valueOf(r114);
    L101:
        if (r25.c == false) goto L105;
        ECReplayVideo r26 = r25.b;
        if (r26 == null) goto L105;
        Integer r27 = Integer.valueOf(r26.getHeight());
    L109:
        if (r115 == null) goto L141;
        r115.intValue();
        if (r27 == null) goto L141;
        r27.intValue();
        View r28 = r25.e.getView();
        if (r28 == null) goto L115;
        ViewGroup.LayoutParams r29 = r28.getLayoutParams();
    L117:
        if ((r29 instanceof ViewGroup.MarginLayoutParams) == false) goto L120;
        r3 = r29;
    L120:
        ViewGroup.MarginLayoutParams r30 = (ViewGroup.MarginLayoutParams) r3;
        if (r115.intValue() < r27.intValue()) goto L123;
        int r31 = th.a.f(r25.d).getDimensionPixelOffset(2131166399);
        int r32 = UIUtils.getScreenWidth(r25.d);
        if (r115.intValue() == 0) goto L131;
        r2 = (int) (((r27.intValue() * 1.0f) / r115.intValue()) * r32);
    L131:
        if (r30 == null) goto L133;
        r30.width = r32;
    L133:
        if (r30 == null) goto L135;
        r30.height = r2;
    L135:
        if (r30 == null) goto L137;
        r30.topMargin = r31;
    L137:
        View r33 = r25.e.getView();
        if (r33 == null) goto L141;
        r33.setLayoutParams(r30);
        goto L141
    L123:
        if (r30 == null) goto L125;
        r30.width = -1;
    L125:
        if (r30 == null) goto L137;
        r30.height = -1;
        goto L137
    L115:
        r29 = null;
    L105:
        ExplainPlaybackVideoInfo r34 = r25.a;
        if (r34 == null) goto L108;
        r27 = Integer.valueOf((int) r34.getHeight());
        goto L109
    L108:
        r27 = null;
    L95:
        ExplainPlaybackVideoInfo r116 = r25.a;
        if (r116 == null) goto L99;
        r114 = (int) r116.getWidth();
        goto L98
    L99:
        r115 = null;
    L141:
        if (r8.j == false) goto L146;
        r8.h0();
        return;
    L146:
        return;
    L55:
        r11 = null;
        goto L57
    L23:
        int r35 = ECSdk.a;
        s83.g r36 = (s83.g) ECSdk.a(s83.g.class);
        if (r36 == null) goto L51;
        IVideoPlaybackService r37 = r36.n();
        if (r37 == null) goto L51;
        ExplainPlaybackViewModel r38 = r8.g;
        if (r38 != null) goto L30;
    L32:
        boolean r39 = false;
    L33:
        ExplainPlaybackViewModel r40 = r8.g;
        if (r40 == null) goto L40;
        com.bytedance.android.livesdk.livecommerce.playback.main.b r41 = r40.getExplainPlaybackOriginParams();
        if (r41 == null) goto L40;
        PlaybackEventExtraData r42 = r41.e;
        if (r42 == null) goto L40;
        String r43 = r42.getShareSearchPlayerId();
    L41:
        ExplainPlaybackViewModel r44 = r8.g;
        if (r44 == null) goto L48;
        com.bytedance.android.livesdk.livecommerce.playback.main.b r45 = r44.getExplainPlaybackOriginParams();
        if (r45 == null) goto L48;
        PlaybackEventExtraData r46 = r45.e;
        if (r46 == null) goto L48;
        String r47 = r46.getAwemeId();
    L49:
        r6 = r37.getPlaybackAwemeVideoView(r39, r43, r47);
        if (r6 != null) goto L52;
    L48:
        r47 = null;
    L40:
        r43 = null;
        goto L41
    L30:
        if (r38.isFromSearch() != true) goto L32;
        r39 = true;
    L51:
        r6 = new h();
    L20:
        r5 = false;
        goto L21
    L145:
        return;
    L7:
        if (r8.i == true) goto L9;
        r0 = true;
        goto L10
    }
}
