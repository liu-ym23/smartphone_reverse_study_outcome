package com.bytedance.awemeopen.apps.framework.feed.pinch.presenter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.awemeopen.apps.framework.feed.pinch.ui.PinchPlayPauseView;
import com.bytedance.awemeopen.apps.framework.feed.pinch.vm.FeedSpeedControlViewModel;
import com.bytedance.awemeopen.apps.framework.utils.r0;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class PinchVideoScaleRestorePresenter extends b {
    public final ViewGroup h;
    public final View i;
    public View j;
    public FeedSpeedControlViewModel k;
    public PinchPlayPauseView l;
    public final a m;

    public static final class a implements com.bytedance.awemeopen.infra.base.player.k {
        public final /* synthetic */ PinchVideoScaleRestorePresenter a;

        public final void c(String r1) {
        }

        public final void d(String r1, long r2, int r4) {
        }

        public final void e(String r1, int r2, String r3) {
        }

        public final void f(String r1, boolean r2, int r3, int r4) {
        }

        public final void g(String r1, boolean r2, String r3) {
        }

        public final void onPlayPrepare(String r1) {
        }

        public a(PinchVideoScaleRestorePresenter r1) {
            this.a = r1;
        }

        public final void h(String r2) {
            r14.c r0 = this.a.f;
            if (r0 == null) goto L5;
            String r1 = r0.c();
        L7:
            if (Intrinsics.areEqual(r2, r1) == false) goto L10;
            this.a.g(false);
            return;
        L10:
            return;
        L5:
            r1 = null;
            goto L7
        }

        public final void onPlaying(String r2) {
            r14.c r0 = this.a.f;
            if (r0 == null) goto L5;
            String r1 = r0.c();
        L7:
            if (Intrinsics.areEqual(r2, r1) == false) goto L10;
            this.a.g(true);
            return;
        L10:
            return;
        L5:
            r1 = null;
            goto L7
        }

        public final void l(String r1, com.bytedance.awemeopen.infra.base.player.l r2) {
            Intrinsics.checkNotNullParameter(r2, "playerStatusInfo");
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public final void d() {
        sz3.c r0 = this.b;
        if (r0 == null) goto L11;
        LifecycleOwner r1 = r0.b;
        if (r1 == null) goto L11;
        FeedSpeedControlViewModel r2 = this.k;
        if (r2 == null) goto L11;
        MutableLiveData<Pair<String, Boolean>> r3 = r2.getFastSpeedModeEvent();
        if (r3 == null) goto L11;
        final Function1<Pair<? extends String, ? extends Boolean>, Unit> r4 = new PinchVideoScaleRestorePresenter$initObserverOnce$1$1(this);
        r3.observe(r1, new c0(r4));
    L11:
        sz3.c r5 = this.b;
        if (r5 == null) goto L20;
        qz3.b r6 = r5.i;
        if (r6 == null) goto L21;
        if (r5 == null) goto L17;
        LifecycleOwner r7 = r5.b;
    L18:
        r6.u(r7, new d0(this));
        return;
    L17:
        r7 = null;
        goto L18
    L21:
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public final void e() {
        FeedSpeedControlViewModel.a r0 = FeedSpeedControlViewModel.Companion;
        sz3.c r1 = this.b;
        LifecycleOwner r2 = null;
        if (r1 == null) goto L5;
        Activity r3 = r1.getActivity();
    L7:
        if ((r3 instanceof LifecycleOwner) == false) goto L9;
        LifecycleOwner r4 = (LifecycleOwner) r3;
    L10:
        if (r4 != null) goto L14;
        sz3.c r5 = this.b;
        if (r5 == null) goto L15;
        r2 = r5.b;
    L15:
        r0.getClass();
        this.k = FeedSpeedControlViewModel.a.a(r2, "");
        if (this.i != null) goto L18;
        return;
    L18:
        Context r6 = getContext();
        if (r6 != null) goto L21;
        return;
    L21:
        ImageView r7 = (ImageView) this.i.findViewById(2131382327);
        TextView r8 = (TextView) this.i.findViewById(2131382326);
        this.j = this.i.findViewById(2131382328);
        this.l = (PinchPlayPauseView) this.i.findViewById(2131382455);
        View r9 = this.j;
        if (r9 == null) goto L24;
        r9.setOnClickListener(new b0(this));
    L24:
        sz3.c r10 = this.b;
        if (r10 == null) goto L31;
        r0 r11 = r10.d;
        if (r11 == null) goto L31;
        PinchPlayPauseView r12 = this.l;
        if (r12 == null) goto L31;
        PinchPlayPauseView.j(r12, r11);
    L31:
        if (r7 == null) goto L44;
        if (r8 == null) goto L44;
        r8.setText(2131896997);
        r7.setImageDrawable(ContextCompat.getDrawable(r6, 2131247271));
        sz3.c r13 = this.b;
        if (r13 == null) goto L42;
        com.bytedance.awemeopen.infra.base.player.g r14 = r13.l;
        if (r14 == null) goto L42;
        boolean r15 = true;
        if (r14.isPlaying() != true) goto L42;
    L43:
        g(r15);
    L42:
        r15 = false;
    L44:
        this.i.setOnTouchListener(new n());
        return;
    L14:
        r2 = r4;
        goto L15
    L9:
        r4 = null;
        goto L10
    L5:
        r3 = null;
        goto L7
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public final void f() {
        sz3.c r0 = this.b;
        if (r0 == null) goto L8;
        com.bytedance.awemeopen.apps.framework.framework.viewpager.o r1 = r0.c;
        if (r1 == null) goto L9;
        r1.removePlayStateListener(this.m);
        return;
    L9:
        return;
    }

    public final void g(boolean r2) {
        if (r2 == false) goto L10;
        PinchPlayPauseView r3 = this.l;
        if (r3 == null) goto L6;
        r3.setImageResource(r3.b);
    L6:
        AppCompatImageView r4 = this.l;
        if (r4 == null) goto L19;
        r4.setVisibility(8);
        return;
    L19:
        return;
    L10:
        PinchPlayPauseView r5 = this.l;
        if (r5 == null) goto L13;
        r5.l(2131106712);
    L13:
        AppCompatImageView r6 = this.l;
        if (r6 == null) goto L20;
        r6.setVisibility(0);
        return;
    }

    public PinchVideoScaleRestorePresenter(View r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "parentView");
        super(r2);
        this.h = r3;
        this.i = LayoutInflater.from(getContext()).inflate(2131564218, r3);
        this.m = new a(this);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public final void b(sz3.c r4, com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r5) {
        super.b(r4, r5);
        if (r5 == null) goto L29;
        qz3.b r6 = r4.i;
        boolean r1 = true;
        if (r6 != null) goto L7;
    L9:
        boolean r7 = false;
    L10:
        if (r7 == false) goto L22;
        qz3.b r8 = r4.i;
        if (r8 != null) goto L14;
    L16:
        r1 = false;
    L17:
        if (r1 == false) goto L22;
        View r9 = this.i;
        if (r9 == null) goto L26;
        r9.setVisibility(0);
    L26:
        com.bytedance.awemeopen.apps.framework.framework.viewpager.o r10 = r4.c;
        if (r10 == null) goto L34;
        r10.addPlayStateListener(this.m);
        return;
    L34:
        return;
    L14:
        if (r8.A() != true) goto L16;
    L22:
        View r11 = this.i;
        if (r11 == null) goto L26;
        r11.setVisibility(8);
        goto L26
    L7:
        if (r6.B() != true) goto L9;
        r7 = true;
        goto L10
    L29:
        View r12 = this.i;
        if (r12 == null) goto L36;
        r12.setVisibility(8);
        return;
    }
}
