package com.bytedance.android.shopping.deepfeed.slice.view.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.widget.roundcorner.SlcRoundFrameLayout;
import com.bytedance.android.shopping.api.video.ECVideoPlayerView;
import com.bytedance.android.shopping.api.video.g;
import com.bytedance.android.shopping.api.video.j;
import com.bytedance.android.shopping.deepfeed.slice.service.e;
import com.bytedance.android.shopping.deepfeed.slice.view.f;
import com.facebook.drawee.view.SimpleDraweeView;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class DeepFeedSliceVideoView extends SlcRoundFrameLayout {
    public static final Set<String> o = null;
    public static final Map<String, a.C0058a> p = null;
    public static final a q = null;
    public final ViewGroup c;
    public ECVideoPlayerView d;
    public final SimpleDraweeView e;
    public final SimpleDraweeView f;
    public int g;
    public f h;
    public int i;
    public SlcTemplateContext j;
    public int k;
    public int l;
    public int m;
    public final b n;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.shopping.deepfeed.slice.view.video.DeepFeedSliceVideoView$a$a, reason: collision with other inner class name */
        public static final class C0058a {
            public final boolean equals(Object r2) {
                if (this != r2) goto L4;
                return true;
            L4:
                if ((r2 instanceof C0058a) == false) goto L6;
                ((C0058a) r2).getClass();
                return true;
            L6:
                return false;
            }

            public final int hashCode() {
                int r1 = (int) 0;
                return (((r1 * 31) + r1) * 31) + 0;
            }

            public final String toString() {
                return "VideoProgressCache(progress=0, duration=0, hasPlayCompleted=false)";
            }
        }

        public a() {
        }
    }

    public static final class b implements com.bytedance.android.shopping.deepfeed.slice.service.a {
        public final /* synthetic */ DeepFeedSliceVideoView a;

        @Override // com.bytedance.android.shopping.deepfeed.slice.service.a
        public final void onDestroy() {
        }

        @Override // com.bytedance.android.shopping.deepfeed.slice.service.a
        public final void onStop() {
        }

        @Override // com.bytedance.android.shopping.deepfeed.slice.service.a
        public final void onPause() {
            this.a.f();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [android.widget.FrameLayout, com.bytedance.android.shopping.deepfeed.slice.view.video.DeepFeedSliceVideoView] */
        @Override // com.bytedance.android.shopping.deepfeed.slice.service.a
        public final void onResume() {
            ?? r0 = this.a;
            if (r0.h.i == true) goto L5;
            return;
        L5:
            if (r0.isAttachedToWindow() == false) goto L9;
            this.a.g();
            return;
        }

        public b(DeepFeedSliceVideoView r1) {
            this.a = r1;
        }
    }

    static {
        q = new a();
        o = new LinkedHashSet();
        p = new LinkedHashMap();
    }

    private final e getIndicatorService() {
        SlcTemplateContext r0 = this.j;
        Object r1 = null;
        if (r0 == null) goto L10;
        Object r2 = r0.o(e.class);
        if ((r2 instanceof e) == false) goto L9;
        r1 = r2;
    L9:
        return (e) r1;
    L10:
        return null;
    }

    public final com.bytedance.android.shopping.deepfeed.slice.service.b b() {
        SlcTemplateContext r0 = this.j;
        Object r1 = null;
        if (r0 == null) goto L10;
        Object r2 = r0.o(com.bytedance.android.shopping.deepfeed.slice.service.b.class);
        if ((r2 instanceof com.bytedance.android.shopping.deepfeed.slice.service.b) == false) goto L9;
        r1 = r2;
    L9:
        return (com.bytedance.android.shopping.deepfeed.slice.service.b) r1;
    L10:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f() {
        ECVideoPlayerView r0 = this.d;
        if (r0 == null) goto L10;
        if (r0.h() != true) goto L10;
        ECVideoPlayerView r1 = this.d;
        if (r1 == null) goto L10;
        r1.m();
    L10:
        if (isAttachedToWindow() == false) goto L15;
        com.bytedance.android.shopping.deepfeed.slice.service.b r2 = b();
        if (r2 == null) goto L16;
        r2.M(MapsKt.mapOf(TuplesKt.to("is_playing", Boolean.FALSE)));
        return;
    L16:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g() {
        ECVideoPlayerView r0 = this.d;
        if (r0 == null) goto L12;
        if (r0.h() == true) goto L12;
        if (this.h.i == false) goto L12;
        ECVideoPlayerView r1 = this.d;
        if (r1 == null) goto L12;
        r1.u();
    L12:
        if (isAttachedToWindow() == false) goto L17;
        com.bytedance.android.shopping.deepfeed.slice.service.b r2 = b();
        if (r2 == null) goto L18;
        r2.M(MapsKt.mapOf(TuplesKt.to("is_playing", Boolean.valueOf(this.h.i))));
        return;
    L18:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.widget.FrameLayout*/.onAttachedToWindow();
        if (this.h.i == false) goto L8;
        ECVideoPlayerView r0 = this.d;
        if (r0 == null) goto L9;
        r0.n();
        return;
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.FrameLayout*/.onDetachedFromWindow();
        ECVideoPlayerView r0 = this.d;
        if (r0 == null) goto L6;
        r0.x();
        return;
    }

    public final SimpleDraweeView getBlurView() {
        return this.e;
    }

    public final SimpleDraweeView getCoverView() {
        return this.f;
    }

    public final int getCurrentTopMargin() {
        return this.k;
    }

    public final int getCurrentTopMax() {
        return this.m;
    }

    public final ViewGroup getVideoContainer() {
        return this.c;
    }

    public final ECVideoPlayerView getVideoPlayerView() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DeepFeedSliceVideoView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        ViewGroup.LayoutParams r0 = null;
        super(r5, null, 6, 0);
        this.h = new f(0);
        FrameLayout.inflate(r5, 2131564644, this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.e = findViewById(2131364314);
        SimpleDraweeView r6 = findViewById(2131367831);
        this.f = r6;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r7 = null;
    L5:
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
        if (r8 == null) goto L8;
        r8.topMargin = 0;
        r8.height = -1;
    L8:
        ViewGroup r9 = (ViewGroup) findViewById(2131392283);
        this.c = r9;
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L12;
        r0 = r10;
    L12:
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        if (r1 == null) goto L15;
        r1.topMargin = 0;
        r1.height = -1;
    L15:
        this.n = new b(this);
    }

    public final void d(c r4) {
        ECVideoPlayerView r0 = this.d;
        if (r0 == null) goto L20;
        ConcurrentHashMap<String, DeepFeedSliceVideoEarlyWarmCenter.a> r1 = DeepFeedSliceVideoEarlyWarmCenter.a;
        if (r4 == null) goto L18;
        String r5 = r4.a;
        if (r5 == null) goto L18;
        ConcurrentHashMap<String, DeepFeedSliceVideoEarlyWarmCenter.a> r2 = DeepFeedSliceVideoEarlyWarmCenter.a;
        DeepFeedSliceVideoEarlyWarmCenter.a r3 = r2.get(r5);
        if (r3 == null) goto L18;
        WeakReference<ECVideoPlayerView> r6 = r3.b;
        if (r6 == null) goto L15;
        ECVideoPlayerView r7 = r6.get();
    L16:
        if (r7 != r0) goto L18;
        r2.remove(r5);
        goto L18
    L15:
        r7 = null;
    L18:
        r0.x();
        r0.s();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(int r3) {
        int r0 = this.k;
        if (r0 != r3) goto L6;
        return;
    L6:
        if (r0 == this.m) goto L8;
    L10:
        this.k = r3;
        setTranslationY(r3);
        return;
    L8:
        if (this.i != 2) goto L10;
    }

    public final void setMaxMargin(double r1) {
        this.m = com.bytedance.android.shopping.extensions.b.b(Double.valueOf(r1));
    }

    public final void setStartMargin(double r1) {
        this.l = com.bytedance.android.shopping.extensions.b.b(Double.valueOf(r1));
    }

    public final void setVideoPlayerView(ECVideoPlayerView r1) {
        this.d = r1;
    }

    public final void c(final String r3, final Function1<? super String, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "filePathPrefix");
        Intrinsics.checkNotNullParameter(r4, "callback");
        ECVideoPlayerView r0 = this.d;
        if (r0 != null) goto L5;
    L13:
        r4.invoke(null);
        return;
    L5:
        if (r0.getWidth() <= 0) goto L13;
        if (r0.getHeight() <= 0) goto L13;
        Function1<Bitmap, Unit> r1 = new DeepFeedSliceVideoView$currentFrameToPhotoSearch$1(this, r4, r3);
        Intrinsics.checkNotNullParameter(r1, "cb");
        Intrinsics.checkNotNullParameter(new g(r1), "listener");
        j r5 = r0.getVideoViewHelper();
        if (r5 == null) goto L15;
        r5.getBitmap();
        return;
    }
}
