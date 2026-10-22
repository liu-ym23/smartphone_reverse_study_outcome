package com.bytedance.android.shopping.deepfeed.weights;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.shopping.api.video.ECVideoPlayerView;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends FrameLayout {
    public final ViewGroup a;
    public ECVideoPlayerView b;
    public final SimpleDraweeView c;
    public final SimpleDraweeView d;
    public final ImageView e;
    public Function3<? super Long, ? super Long, ? super Long, Unit> f;
    public Function0<Unit> g;
    public Function1<? super Boolean, Unit> h;
    public int i;
    public int j;
    public int k;
    public int l;
    public final com.bytedance.android.ec.core.imagex.r m;
    public final Integer n;

    public static final class a {
    }

    static {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ECVideoPlayerView r0 = this.b;
        if (r0 == null) goto L5;
        r0.x();
    L5:
        this.e.setVisibility(8);
    }

    public final SimpleDraweeView getBlurView() {
        return this.c;
    }

    public final Integer getCardIndex() {
        return this.n;
    }

    public final SimpleDraweeView getCoverView() {
        return this.d;
    }

    public final com.bytedance.android.ec.core.imagex.r getImageCallerContext() {
        return this.m;
    }

    public final ViewGroup getVideoContainer() {
        return this.a;
    }

    public final ImageView getVideoPauseIcon() {
        return this.e;
    }

    public final ECVideoPlayerView getVideoPlayerView() {
        return this.b;
    }

    public final void a(int r4) {
        ViewGroup.LayoutParams r0 = this.d.getLayoutParams();
        ViewGroup.LayoutParams r2 = null;
        if ((r0 instanceof FrameLayout.LayoutParams) == true) goto L5;
        r0 = null;
    L5:
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
        if (r1 == null) goto L8;
        r1.topMargin = r4;
        this.d.setLayoutParams(r1);
    L8:
        ViewGroup.LayoutParams r3 = this.a.getLayoutParams();
        if ((r3 instanceof FrameLayout.LayoutParams) == false) goto L12;
        r2 = r3;
    L12:
        FrameLayout.LayoutParams r5 = (FrameLayout.LayoutParams) r2;
        if (r5 == null) goto L16;
        r5.topMargin = r4;
        this.a.setLayoutParams(r5);
        return;
    }

    public final void setCloseTop(boolean r1) {
        if (r1 == false) goto L4;
        a(-com.bytedance.android.shopping.extensions.b.b(8));
        return;
    L4:
        a(com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(this.l)));
    }

    public final void setPlayCompleteListener(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.g = r2;
    }

    public final void setPlayListener(Function1<? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.h = r2;
    }

    public final void setPlayProgressListener(Function3<? super Long, ? super Long, ? super Long, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.f = r2;
    }

    public final void setVideoPlayerView(ECVideoPlayerView r1) {
        this.b = r1;
    }

    public c(Context r3, com.bytedance.android.ec.core.imagex.r r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, null, 0);
        this.m = r4;
        this.n = r5;
        this.l = 150;
        FrameLayout.inflate(r3, 2131564644, this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.c = findViewById(2131364314);
        this.d = findViewById(2131367831);
        this.a = (ViewGroup) findViewById(2131392283);
        ImageView r6 = new ImageView(r3);
        FrameLayout.LayoutParams r7 = new FrameLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.b(80), com.bytedance.android.shopping.extensions.b.b(80));
        r7.gravity = 17;
        Unit r8 = Unit.INSTANCE;
        r6.setLayoutParams(r7);
        r6.setVisibility(8);
        r6.setImageResource(2131247989);
        this.e = r6;
    }
}
