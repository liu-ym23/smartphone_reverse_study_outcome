package com.bytedance.android.livesdk.ktvimpl.realtimechorus.video;

import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.ktvapi.model.KtvSeiModel;
import com.bytedance.android.livesdk.ktvimpl.crossplatform.KtvJsbDataContext;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import fd2.n;
import fd2.u;
import fd2.w;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import tf0.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/video/VideoChorusFeedWidget;", "Lfd2/g;", "Lfd2/w;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Lfd2/u;", "<init>", "()V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VideoChorusFeedWidget implements fd2.g, w, LifecycleOwnerCompat, u {
    public static final /* synthetic */ int h = 0;
    public KtvSeiModel a;
    public fd2.b b;
    public com.bytedance.android.livesdk.ktvimpl.realtimechorus.concert.c c;
    public g d;
    public final CompositeDisposable e;
    public final LifecycleRegistry f;
    public VideoChorusPlayerProxy g;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ ViewGroup b;

        public b(ViewGroup r1, ViewGroup r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ViewGroup.LayoutParams r1 = new ConstraintLayout.LayoutParams(Math.min((int) ((this.a.getHeight() * 9.0f) / 16.0f), this.a.getWidth()), -2);     // Catch: Throwable -> L4
            ((ConstraintLayout.LayoutParams) r1).startToStart = 0;     // Catch: Throwable -> L4
            ((ConstraintLayout.LayoutParams) r1).endToEnd = 0;     // Catch: Throwable -> L4
            ((ConstraintLayout.LayoutParams) r1).topToTop = 0;     // Catch: Throwable -> L4
            ((ConstraintLayout.LayoutParams) r1).bottomToBottom = 0;     // Catch: Throwable -> L4
            ((ConstraintLayout.LayoutParams) r1).horizontalBias = 0.5f;     // Catch: Throwable -> L4
            this.b.setLayoutParams(r1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ VideoChorusFeedWidget a;

        public c(VideoChorusFeedWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            jd2.c r6 = (jd2.c) r5;
            VideoChorusFeedWidget r0 = this.a;
            if (VideoChorusFeedWidget.e(r0.a, r6) == false) goto L5;
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.b.b("VideoChorusFeedWidget", "handleSingStateChange shouldReturnBasedOnSeiState, currentSeiModel: " + r0.a + ", ktvSingStateData: " + r6);
            return;
        L5:
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.b.b("VideoChorusFeedWidget", "VideoChorusFeedWidget ;; handleSingStateData, ktvSingStateData: " + r6);
            r0.f(r6);
            if (r6 == null) goto L8;
            Integer r1 = Integer.valueOf(r6.a);
        L9:
            if (r1 != null) goto L12;
        L16:
            if (r1 != null) goto L19;
        L26:
            if (r1 != null) goto L29;
            return;
        L29:
            if (r1.intValue() != 3) goto L39;
            g r7 = r0.d;
            if (r7 == null) goto L40;
            r7.c();
            return;
        L40:
            return;
        L39:
            return;
        L19:
            if (r1.intValue() != 2) goto L26;
            g r2 = r0.d;
            if (r2 == null) goto L23;
            r2.d();
        L23:
            g r3 = r0.d;
            if (r3 == null) goto L37;
            r3.e(r6.b);
            return;
        L37:
            return;
        L12:
            if (r1.intValue() != 0) goto L16;
            g r8 = r0.d;
            if (r8 == null) goto L35;
            r8.g();
            return;
        L35:
            return;
        L8:
            r1 = null;
            goto L9
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ VideoChorusFeedWidget a;

        public d(VideoChorusFeedWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            jd2.c r6 = (jd2.c) r5;
            VideoChorusFeedWidget r0 = this.a;
            if (r6 != null) goto L6;
            int r7 = VideoChorusFeedWidget.h;
            r0.getClass();
            return;
        L6:
            if (VideoChorusFeedWidget.e(r0.a, r6) == false) goto L8;
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.b.b("VideoChorusFeedWidget", "handleSingProgressChange shouldReturnBasedOnSeiState, currentSeiModel: " + r0.a + ", ktvSingStateData: " + r6);
            return;
        L8:
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.b.b("VideoChorusFeedWidget", "handleSingProgressChange ktvSingStateData: " + r6);
            r0.f(r6);
            if (r6.a != 2) goto L16;
            g r1 = r0.d;
            if (r1 == null) goto L17;
            r1.e(r6.b);
            return;
        L17:
            return;
        }
    }

    static {
    }

    public final /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    public final n m1() {
        return null;
    }

    public final void b() {
        this.f.setCurrentState(Lifecycle.State.STARTED);
        fd2.b r0 = this.b;
        if (r0 == null) goto L8;
        ViewGroup r1 = r0.g;
        if (r1 == null) goto L9;
        r1.setVisibility(8);
        return;
    L9:
        return;
    }

    public final void onSelect() {
        this.f.setCurrentState(Lifecycle.State.RESUMED);
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.concert.c r0 = this.c;
        if (r0 == null) goto L15;
        fd2.b r1 = this.b;
        String r2 = null;
        if (r1 == null) goto L7;
        String r3 = r1.b;
    L8:
        if (r1 == null) goto L10;
        r2 = r1.c;
    L10:
        if (r1 == null) goto L13;
        String r4 = r1.f;
        if (r4 == null) goto L13;
    L14:
        r0.c(r3, r2, true, r4);
    L13:
        r4 = "";
        goto L14
    L7:
        r3 = null;
    L15:
        fd2.b r5 = this.b;
        if (r5 == null) goto L21;
        ViewGroup r6 = r5.g;
        if (r6 == null) goto L22;
        r6.setVisibility(0);
        return;
    L22:
        return;
    }

    public final void unload() {
        this.f.setCurrentState(Lifecycle.State.DESTROYED);
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.concert.c r0 = this.c;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        this.e.clear();
        g r1 = this.d;
        if (r1 == null) goto L9;
        r1.b();
        return;
    }

    public VideoChorusFeedWidget() {
        this.e = new CompositeDisposable();
        this.f = new LifecycleRegistry(this);
    }

    public final void a() {
        if (FoldScreenUtils.e() == false) goto L5;
    L6:
        fd2.b r0 = this.b;
        ViewParent r1 = null;
        if (r0 == null) goto L11;
        ViewGroup r2 = r0.g;
        if (r2 == null) goto L11;
        ViewParent r3 = r2.getParent();
    L13:
        if ((r3 instanceof ViewGroup) == false) goto L16;
        r1 = r3;
    L16:
        ViewGroup r4 = (ViewGroup) r1;
        if (r4 != null) goto L19;
        return;
    L19:
        fd2.b r5 = this.b;
        if (r5 == null) goto L27;
        ViewGroup r6 = r5.g;
        if (r6 == null) goto L28;
        r4.post(new b(r4, r6));
        return;
    L28:
        return;
    L27:
        return;
    L11:
        r3 = null;
        goto L13
    L5:
        if (PadConfigUtils.c() == true) goto L6;
    }

    public final Lifecycle getLifecycleCompat() {
        return this.f;
    }

    public final void c(fd2.b r10) {
        Intrinsics.checkNotNullParameter(r10, "params");
        if (PadConfigUtils.c() == false) goto L9;
        ViewGroup r0 = r10.i;
        if (r0 == null) goto L9;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L9;
        r1.height = s1.j(2131168847);
        r0.setLayoutParams(r1);
    L9:
        this.f.setCurrentState(Lifecycle.State.STARTED);
        Pair r2 = com.bytedance.live.datacontext.d.a(VideoChorusFeedWidget$initChorusDataContext$1.INSTANCE);
        VideoChorusDataContext r3 = (VideoChorusDataContext) r2.component1();
        Disposable r4 = (Disposable) r2.component2();
        com.bytedance.live.datacontext.i<Boolean> r5 = r3.isFeed();
        Boolean r6 = Boolean.TRUE;
        r5.d(r6);
        r3.getService().d(this);
        com.bytedance.live.datacontext.b.a(r3, VideoChorusDataContext.TAG_FOR_FEED);
        this.e.add(r4);
        VideoChorusPlayerProxy r7 = new VideoChorusPlayerProxy(r10.b, null);
        this.g = r7;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.jsb.b r8 = new com.bytedance.android.livesdk.ktvimpl.crossplatform.jsb.b(r7, null);
        Pair r9 = com.bytedance.live.datacontext.d.a(VideoChorusFeedWidget$initKtvJsbDataContext$pair$1.INSTANCE);
        KtvJsbDataContext r11 = (KtvJsbDataContext) r9.getFirst();
        r11.isFeed().d(r6);
        r11.getService().d(r8);
        com.bytedance.live.datacontext.b.a(r11, KtvJsbDataContext.TAG_FOR_FEED);
        this.e.add((Disposable) r9.getSecond());
        VideoChorusDataContext.a r12 = VideoChorusDataContext.Companion;
        VideoChorusDataContext r13 = r12.getContext();
        if (r13 == null) goto L14;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c> r14 = r13.getMusicPlayerProxy();
        if (r14 == null) goto L14;
        r14.d(this.g);
    L14:
        this.b = r10;
        g r15 = new g(null, r10.h, this, null, null);
        r15.a(this);
        Unit r16 = Unit.INSTANCE;
        this.d = r15;
        this.c = new com.bytedance.android.livesdk.ktvimpl.realtimechorus.concert.c();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.concert.c r17 = this.c;
        if (r17 == null) goto L17;
        r17.a(r10);
    L17:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.concert.c r18 = this.c;
        if (r18 == null) goto L23;
        String r19 = r10.b;
        String r20 = r10.c;
        String r110 = r10.f;
        if (r110 != null) goto L22;
        r110 = "";
    L22:
        r18.c(r19, r20, true, r110);
    L23:
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r111 = r12.a();
        if (r111 == null) goto L26;
        r111.l(this, new c(this));
    L26:
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r112 = r12.a();
        if (r112 == null) goto L29;
        r112.e(this, new d(this));
    L29:
        a();
    }

    public final void f(jd2.c r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (ArraysKt.contains(new Integer[]{3, 1, 2}, Integer.valueOf(r10.a)) == false) goto L10;
        g r0 = this.d;
        if (r0 == null) goto L11;
        String r2 = r10.c;
        long r3 = r10.b;
        jd2.c.b r11 = r10.d;
        r0.f(new com.bytedance.android.livesdk.ktvimpl.base.a(r2, r3, r11.a, r11.d, r11.e));
        return;
    L11:
        return;
    }

    public static boolean e(KtvSeiModel r7, jd2.c r8) {
        if (((Boolean) KtvSettingHelper.Y0.getValue()).booleanValue() == true) goto L5;
        return false;
    L5:
        if (r7 != null) goto L8;
        return false;
    L8:
        if (r7.getIdStr().length() != 0) goto L10;
        boolean r0 = true;
    L11:
        if (r0 == false) goto L13;
        return false;
    L13:
        if (r8 == null) goto L15;
        String r1 = r8.c;
    L16:
        if (r8 == null) goto L18;
        long r3 = r8.b;
    L19:
        boolean r2 = !Intrinsics.areEqual(r1, r7.getIdStr());
        if (r7.getDuration() == 0.0f) goto L27;
        if (r8 == null) goto L25;
        if (r8.a == 0) goto L27;
    L25:
        if ((r7.getDuration() * 1000) >= r3) goto L27;
        boolean r9 = true;
    L28:
        if (r2 == true) goto L30;
        if (r9 == true) goto L30;
        return false;
    L30:
        return true;
    L27:
        r9 = false;
        goto L28
    L18:
        r3 = 0;
        goto L19
    L15:
        r1 = null;
        goto L16
    L10:
        r0 = false;
        goto L11
    }

    public final void onSei(final String r1, ye1.a r2) {
        if (r1 != null) goto L4;
    L7:
        boolean r3 = true;
    L8:
        if (r3 == false) goto L10;
        return;
    L10:
        UtilityKotlinExtentionsKt.b(this, new AnonymousClass1(this, r1));
        return;
    L4:
        if (r1.length() == 0) goto L7;
        r3 = false;
        goto L8
    }

    public final void K2(boolean r1, boolean r2, q r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r3, "callback");
    }
}
