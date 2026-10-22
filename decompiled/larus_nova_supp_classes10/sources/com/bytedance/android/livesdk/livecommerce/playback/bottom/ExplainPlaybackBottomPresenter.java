package com.bytedance.android.livesdk.livecommerce.playback.bottom;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.arch.lifecycle.g;
import com.bytedance.android.ec.core.arch.state.c;
import com.bytedance.android.ec.core.widget.f;
import com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackViewModel;
import com.bytedance.android.livesdk.livecommerce.playback.utils.ExplainPlaybackUtils;
import com.bytedance.android.livesdk.livecommerce.playback.video.ExplainPlaybackVideoViewModel;
import com.bytedance.android.livesdk.livecommerce.playback.widget.VideoPlaybackSeekBar;
import com.bytedance.android.ui.base.widget.button.CornersButton;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import ej2.b;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ExplainPlaybackBottomPresenter extends QFragmentPresenter implements SeekBar.OnSeekBarChangeListener {
    public ExplainPlaybackVideoViewModel f;
    public boolean g;
    public final Lazy h;
    public View i;

    public static final class a implements Runnable {
        public final /* synthetic */ VideoPlaybackSeekBar a;

        public a(VideoPlaybackSeekBar r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.SeekBar, com.bytedance.android.livesdk.livecommerce.playback.widget.VideoPlaybackSeekBar] */
        @Override // java.lang.Runnable
        public final void run() {
            ?? r0 = this.a;     // Catch: Throwable -> L9
            Object r1 = r0.getParent();     // Catch: Throwable -> L9
            if ((r1 instanceof View) == true) goto L5;
            r1 = null;
        L5:
            View r2 = (View) r1;     // Catch: Throwable -> L9
            if (r2 == null) goto L12;
            r2.setOnTouchListener(new b(r0));     // Catch: Throwable -> L9
            return;
        L12:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public ExplainPlaybackBottomPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.h = LazyKt.lazy(new ExplainPlaybackBottomPresenter$viewModel$2(this));
    }

    /* JADX WARN: Type inference failed for: r5v7, types: [android.widget.SeekBar, com.bytedance.android.livesdk.livecommerce.playback.widget.VideoPlaybackSeekBar] */
    public final void b0(QModel r5) {
        this.f = Y().g(ExplainPlaybackVideoViewModel.class);
        final ?? r6 = (VideoPlaybackSeekBar) Z().b(2131367504).f();
        ExplainPlaybackVideoViewModel r0 = this.f;
        if (r0 == null) goto L5;
        c.a(r0, g.a(Y()), ExplainPlaybackBottomPresenter$onBind$1.INSTANCE, new ExplainPlaybackBottomPresenter$onBind$2(this, r6));
    L5:
        ExplainPlaybackVideoViewModel r1 = this.f;
        if (r1 == null) goto L8;
        c.a(r1, g.a(Y()), ExplainPlaybackBottomPresenter$onBind$3.INSTANCE, new ExplainPlaybackBottomPresenter$onBind$4(this, r6));
    L8:
        r6.setOnSeekBarChangeListener(this);
        r6.post(new a(r6));
        final CornersButton r7 = Z().b(2131391496).f();
        f.c(r7, 500L, null, new ExplainPlaybackBottomPresenter$bindSpeedView$1(this), 2);
        ExplainPlaybackVideoViewModel r2 = this.f;
        if (r2 != null) goto L11;
    L13:
        r7.setVisibility(8);
    L14:
        ExplainPlaybackVideoViewModel r3 = this.f;
        if (r3 == null) goto L17;
        c.a(r3, g.a(Y()), ExplainPlaybackBottomPresenter$bindSpeedView$2.INSTANCE, new ExplainPlaybackBottomPresenter$bindSpeedView$3(this, r7));
    L17:
        c.a((ExplainPlaybackViewModel) this.h.getValue(), g.a(Y()), ExplainPlaybackBottomPresenter$bindBottomEnterLiveView$1.INSTANCE, new ExplainPlaybackBottomPresenter$bindBottomEnterLiveView$2(this));
        return;
    L11:
        if (r2.isSpeedEnableAB() != true) goto L13;
        r7.setVisibility(0);
        goto L14
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r1) {
        this.g = true;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar r3) {
        ExplainPlaybackVideoViewModel r0 = this.f;
        if (r0 == null) goto L5;
        com.bytedance.android.ec.core.arch.event.c.d(r0, com.bytedance.android.livesdk.livecommerce.playback.video.a.e.a);
    L5:
        ExplainPlaybackVideoViewModel r1 = this.f;
        if (r1 != null) goto L8;
    L12:
        cj2.c r4 = cj2.a.a;
        HashMap r5 = new HashMap();
        r5.put("ecom_entrance_form", "replay_popup_card");
        cj2.a.a("livesdk_explain_replay_schedule_use", r5, null, null);
        this.g = false;
        return;
    L8:
        if (r3 == null) goto L10;
        float r6 = r3.getProgress();
    L11:
        com.bytedance.android.ec.core.arch.event.c.d(r1, new com.bytedance.android.livesdk.livecommerce.playback.video.a.f(r6));
        goto L12
    L10:
        r6 = 0.0f;
        goto L11
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r3, int r4, boolean r5) {
        if (r5 == false) goto L11;
        ExplainPlaybackVideoViewModel r6 = this.f;
        if (r6 == null) goto L12;
        com.bytedance.android.livesdk.livecommerce.playback.video.b r7 = (com.bytedance.android.livesdk.livecommerce.playback.video.b) r6.getState();
        if (r7 == null) goto L13;
        Integer r8 = r7.b;
        if (r8 == null) goto L14;
        r8.intValue();
        TextView r9 = (TextView) Z().b(2131367501).f();
        int r10 = ExplainPlaybackUtils.a;
        r9.setText(ExplainPlaybackUtils.c(Y().c(), r4));
        ((VideoPlaybackSeekBar) Z().b(2131367504).f()).setProgress(r4);
        return;
    L14:
        return;
    L13:
        return;
    L12:
        return;
    }
}
