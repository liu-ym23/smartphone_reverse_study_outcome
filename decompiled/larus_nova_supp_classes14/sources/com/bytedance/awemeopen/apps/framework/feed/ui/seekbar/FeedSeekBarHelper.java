package com.bytedance.awemeopen.apps.framework.feed.ui.seekbar;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.awemeopen.apps.framework.base.view.RoundImageView;
import com.bytedance.awemeopen.apps.framework.base.view.seekbar.CustomizedUISeekBar;
import com.bytedance.awemeopen.apps.framework.base.view.seekbar.NoAnchorSeekBar;
import com.bytedance.awemeopen.apps.framework.base.view.seekbar.SeekBarState;
import com.bytedance.awemeopen.apps.framework.base.view.seekbar.j;
import com.bytedance.awemeopen.apps.framework.player.FeedPlayerHelper;
import com.bytedance.awemeopen.apps.framework.utils.j0;
import com.bytedance.awemeopen.apps.framework.utils.r0;
import com.bytedance.awemeopen.bizmodels.feed.Video;
import com.bytedance.awemeopen.infra.base.player.k;
import com.bytedance.awemeopen.infra.base.player.l;
import com.bytedance.awemeopen.infra.base.player.m;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0003\u0006\r\u000eR*\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/ui/seekbar/FeedSeekBarHelper;", "Lcom/bytedance/awemeopen/apps/framework/feed/ui/seekbar/d;", "Lcom/bytedance/awemeopen/apps/framework/utils/r0$a;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "a", "Ljava/lang/ref/WeakReference;", "getContext", "()Ljava/lang/ref/WeakReference;", "setContext", "(Ljava/lang/ref/WeakReference;)V", "context", "b", "c", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class FeedSeekBarHelper implements com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d, r0.a, ViewPager.OnPageChangeListener {
    public static final /* synthetic */ int O = 0;
    public int A;
    public int B;
    public final Lazy C;
    public b D;
    public final e E;
    public final boolean F;
    public final f G;
    public final ArrayList<com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a> H;
    public final ArrayList<c> I;
    public com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.e J;
    public boolean K;
    public String L;
    public final Handler M;
    public final com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.a N;
    public final WeakReference<Context> a;
    public final FeedPlayerHelper b;
    public final long c;
    public final View d;
    public final ViewGroup e;
    public final RoundImageView f;
    public final CustomizedUISeekBar g;
    public final LinearLayout h;
    public final TextView i;
    public final ImageView j;
    public final TextView k;
    public boolean l;
    public boolean m;
    public r14.c n;
    public final r0 o;
    public final int p;
    public final int q;
    public final int r;
    public final long s;
    public long t;
    public final long u;
    public final com.bytedance.awemeopen.infra.base.player.g v;
    public int w;
    public m x;
    public boolean y;
    public boolean z;

    public static final class a {
    }

    public interface b {
        void a();

        void b();
    }

    public interface c {
        void a(float r1);
    }

    public static final class d extends NoAnchorSeekBar.a {
        public final /* synthetic */ FeedSeekBarHelper a;

        public d(FeedSeekBarHelper r1) {
            this.a = r1;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar r2) {
            Iterator<com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a> r3 = this.a.H.iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            r3.next().a();
            goto L4
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.seekbar.NoAnchorSeekBar.a
        public final void a(SeekBar r3, boolean r4) {
            Iterator<T> r0 = this.a.H.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a) r0.next()).b(r3, r4);
            goto L4
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar r1, int r2, boolean r3) {
            Iterator<com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a> r4 = this.a.H.iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            r4.next().onProgressChanged(r2);
            goto L4
        }
    }

    public static final class e implements com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a {
        public final /* synthetic */ FeedSeekBarHelper a;

        @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a
        public final void a() {
            FeedSeekBarHelper r0 = this.a;
            r0.y = true;
            r0.e(r0.p);
            if (r0.l == false) goto L5;
        L7:
            b r1 = r0.D;
            if (r1 == null) goto L10;
            r1.a();
        L10:
            r0.k(SeekBarState.Action.DRAG);
            r0.e(r0.q);
            LinearLayout r2 = r0.h;
            r2.setAlpha(0.0f);
            r2.setTranslationX(0.0f);
            x54.b.d(r2);
            r2.animate().alpha(1.0f).setDuration(400).setInterpolator((com.bytedance.awemeopen.apps.framework.base.view.seekbar.h) r0.C.getValue());
            r2.animate().start();
            if (r0.z == false) goto L16;
            m r3 = r0.x;
            if (r3 == null) goto L17;
            com.bytedance.awemeopen.infra.base.player.g r4 = r0.v;
            Intrinsics.checkNotNull(r3);
            r4.f(r3);
            return;
        L17:
            return;
        L16:
            return;
        L5:
            if (r0.m == false) goto L7;
            r0.g.h();
            goto L7
        }

        public e(FeedSeekBarHelper r1) {
            this.a = r1;
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a
        public final void onProgressChanged(int r8) {
            FeedSeekBarHelper r0 = this.a;
            float r9 = r8;
            r0.g.setProgress(r9 / 100.0f);
            TextView r1 = r0.i;
            int r2 = j0.a;
            r1.setText(j0.a.b((int) ((r9 / 10000.0f) * r0.w)));
            if (r0.z == true) goto L5;
            return;
        L5:
            if (r0.y == false) goto L11;
            long r3 = System.currentTimeMillis();
            if ((r3 - r0.t) <= r0.u) goto L12;
            r0.t = r3;
            r0.o.sendEmptyMessage(r0.r);
            return;
        L12:
            return;
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a
        public final void b(SeekBar r4, boolean r5) {
            FeedSeekBarHelper r6 = this.a;
            r6.y = false;
            b r7 = r6.D;
            if (r7 == null) goto L5;
            r7.b();
        L5:
            r6.k(SeekBarState.Action.RELEASE);
            Float r8 = r6.g.getPlayerProgress();
            Intrinsics.checkNotNull(r8);
            r6.v.seekTo((long) ((r8.floatValue() / 100.0f) * r6.v.getDuration()));
            r6.o.sendEmptyMessageDelayed(r6.q, r6.s);
            if (r6.l == false) goto L9;
        L11:
            long r0 = 3000;
        L12:
            r6.e(r6.p);
            r6.o.sendEmptyMessageDelayed(r6.p, r0);
            x54.b.a(r6.h);
            x54.b.a(r6.f);
            if (r6.b.a() == false) goto L16;
            r6.b.playPlayer();
            return;
        L16:
            return;
        L9:
            if (r6.m == false) goto L11;
            r0 = r6.c;
            goto L12
        }
    }

    public static final class f implements k {
        public final /* synthetic */ FeedSeekBarHelper a;

        public final void c(String r1) {
        }

        public final void d(String r1, long r2, int r4) {
        }

        public final void e(String r1, int r2, String r3) {
        }

        public f(FeedSeekBarHelper r1) {
            this.a = r1;
        }

        public final void h(String r2) {
            FeedSeekBarHelper r3 = this.a;
            if (r3.F == true) goto L5;
            return;
        L5:
            if (r3.l == false) goto L9;
            r3.e(r3.p);
            FeedSeekBarHelper r4 = this.a;
            SeekBarState.Action r0 = SeekBarState.Action.PAUSE;
            r4.g.d(r0);
            return;
        }

        public final void onPlayPrepare(String r4) {
            FeedSeekBarHelper r5 = this.a;
            int r0 = FeedSeekBarHelper.O;
            if (r5.h() == true) goto L7;
            r5.l();
            r5.L = "start_delay_loading_play_prepare";
            r5.K = true;
            r5.M.postDelayed(r5.N, 1500);
            return;
        }

        public final void onPlaying(String r2) {
            FeedSeekBarHelper r3 = this.a;
            if (r3.F == true) goto L5;
            return;
        L5:
            if (r3.l == false) goto L9;
            SeekBarState.Action r0 = SeekBarState.Action.TIMEOUT;
            r3.g.d(r0);
            return;
        }

        public final void l(String r1, l r2) {
            Intrinsics.checkNotNullParameter(r2, "playerStatusInfo");
        }

        public final void g(String r6, boolean r7, String r8) {
            FeedSeekBarHelper r9 = this.a;
            int r10 = FeedSeekBarHelper.O;
            r9.getClass();
            d14.a r11 = b14.a.a;
            boolean r12 = true;
            if (b14.a.a(x24.a.class).W(r9.n) == true) goto L5;
        L7:
            boolean r13 = false;
        L8:
            r9.l = r13;
            r9.m = com.bytedance.awemeopen.apps.framework.feed.ui.information.a.r;
            int r14 = RangesKt.coerceAtLeast((int) ((r9.v.getDuration() * 1.0f) / ECDraweeView.SQUARE), 1);
            r9.w = r14;
            TextView r1 = r9.k;
            int r2 = j0.a;
            r1.setText(j0.a.b(r14));
            if (r9.l == false) goto L12;
            r9.g.setEnableAutoHide(false);
            x54.b.d(r9.g);
            r9.k(SeekBarState.Action.VIDEO_CHANGE);
        L15:
            r9.o.sendEmptyMessageDelayed(r9.q, r9.s);
            this.a.l();
            FeedSeekBarHelper r15 = this.a;
            com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.e r16 = r15.J;
            if (r16 != null) goto L18;
        L20:
            r12 = false;
        L21:
            if (r12 == false) goto L24;
            r15.n("render_first_frame");
            return;
        L24:
            return;
        L18:
            if (r16.b != true) goto L20;
        L12:
            if (r9.m == false) goto L14;
            x54.b.d(r9.g);
            r9.g.setEnableAutoHide(true);
            r9.k(SeekBarState.Action.VIDEO_CHANGE);
            r9.g.f();
            goto L15
        L14:
            r9.g.setEnableAutoHide(false);
            x54.b.b(r9.g);
            r9.k(SeekBarState.Action.FREEZE);
            goto L15
        L5:
            if (r9.v.getDuration() < 30000) goto L7;
            r13 = true;
            goto L8
        }

        public final void f(String r1, boolean r2, int r3, int r4) {
            if (r2 == false) goto L4;
            FeedSeekBarHelper r5 = this.a;
            int r6 = FeedSeekBarHelper.O;
            r5.m("buffer_start");
            return;
        L4:
            FeedSeekBarHelper r7 = this.a;
            int r8 = FeedSeekBarHelper.O;
            r7.n("buffer_end");
        }
    }

    static {
    }

    public final void g() {
        this.y = false;
        this.l = false;
        removeSeekBarChangeListener(this.E);
        this.H.clear();
        this.o.removeCallbacksAndMessages(null);
        this.b.g(this.G);
        ViewGroup r0 = (ViewGroup) this.d.getParent();
        if (r0 == null) goto L6;
        r0.removeView(this.d);
        return;
    }

    public final void onPageScrolled(int r1, float r2, int r3) {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d
    public final void a() {
        this.g.setVisibility(0);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d
    public final void b() {
        this.g.setVisibility(4);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d
    public final boolean c() {
        if (this.g.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void f() {
        this.b.c(this.G);
        addSeekBarChangeListener(this.E);
        this.g.setOnSeekBarChangeListener(new d(this));
    }

    public final boolean h() {
        r14.c r0 = this.n;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        return true;
    L10:
        int r2 = com.bytedance.awemeopen.bizmodels.user.d.a;
        if (com.bytedance.awemeopen.bizmodels.user.d.b(this.n) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r0.a0() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final void l() {
        if (this.K == true) goto L5;
        return;
    L5:
        this.K = false;
        this.M.removeCallbacks(this.N);
    }

    public final WeakReference<Context> getContext() {
        return this.a;
    }

    public static DisplayMetrics d(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d
    public final void addSeekBarChangeListener(com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.H.add(r2);
    }

    public final void e(int r2) {
        this.o.removeMessages(r2);
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.r0.a
    public final void handleMsg(Message r5) {
        if (r5 == null) goto L4;
        Integer r6 = Integer.valueOf(r5.what);
    L5:
        int r0 = this.p;
        if (r6 != null) goto L9;
    L11:
        int r1 = this.q;
        if (r6 != null) goto L15;
    L28:
        int r2 = this.r;
        if (r6 != null) goto L32;
        return;
    L32:
        if (r6.intValue() != r2) goto L38;
        AoPool.a(new AnonymousClass1(this));
        return;
    L38:
        return;
    L15:
        if (r6.intValue() != r1) goto L28;
        long r3 = this.v.getCurrentPosition();
        float r7 = ((r3 * 1.0f) / this.v.getDuration()) * 100.0f;
        if (Float.isNaN(r7) == false) goto L19;
    L27:
        this.o.sendEmptyMessageDelayed(this.q, this.s);
        return;
    L19:
        if (Float.isInfinite(r7) == true) goto L27;
        this.g.setProgress(r7);
        ArrayList<c> r4 = this.I;
        if (r4 == null) goto L27;
        Iterator<c> r8 = r4.iterator();
    L25:
        if (r8.hasNext() == false) goto L27;
        r8.next().a(r7);
        goto L25
    L9:
        if (r6.intValue() != r0) goto L11;
        this.g.d(SeekBarState.Action.TIMEOUT);
        return;
    L4:
        r6 = null;
        goto L5
    }

    public final void j(r14.c r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        this.n = r8;
        boolean r0 = false;
        this.l = false;
        this.m = true;
        this.o.removeCallbacksAndMessages(null);
        this.g.setProgress(0.0f);
        x54.b.b(this.g);
        k(SeekBarState.Action.FREEZE);
        Video r2 = r8.P();
        if (r2 == null) goto L39;
        List r3 = r2.getVideoThumbs();
        if (r3 == null) goto L39;
        if (r3.isEmpty() == true) goto L39;
        d14.a r4 = b14.a.a;
        m r9 = b14.a.a(e34.a.class).D0(r8);
        this.x = r9;
        if (r9 == null) goto L39;
        String r10 = r9.b;
        if (r10 != null) goto L18;
    L21:
        boolean r11 = true;
    L22:
        if (r11 == true) goto L39;
        m r12 = this.x;
        if (r12 == null) goto L28;
        Integer r13 = r12.d;
        if (r13 == null) goto L28;
        int r14 = r13.intValue();
    L29:
        this.A = r14;
        m r15 = this.x;
        if (r15 == null) goto L34;
        Integer r16 = r15.c;
        if (r16 == null) goto L34;
        int r17 = r16.intValue();
    L35:
        this.B = r17;
        if (this.A <= 0) goto L39;
        if (r17 <= 0) goto L39;
        r0 = true;
    L34:
        r17 = 0;
    L28:
        r14 = 0;
        goto L29
    L18:
        if (r10.length() == 0) goto L21;
        r11 = false;
    L39:
        this.z = r0;
        if (r0 == false) goto L48;
        AppCompatImageView r18 = this.f;
        float r1 = this.B / this.A;
        if (r1 <= 0.75f) goto L44;
        float r5 = 88;
        int r6 = MathKt.roundToInt(TypedValue.applyDimension(1, r5, d(Resources.getSystem())));
        int r7 = RangesKt.coerceAtMost((int) (MathKt.roundToInt(TypedValue.applyDimension(1, r5, d(Resources.getSystem()))) * r1), MathKt.roundToInt(TypedValue.applyDimension(1, 140, d(Resources.getSystem()))));
        ImageView.ScaleType r19 = ImageView.ScaleType.CENTER_CROP;
    L45:
        r18.getLayoutParams().width = (r6 + r18.getPaddingLeft()) + r18.getPaddingRight();
        r18.getLayoutParams().height = (r7 + r18.getPaddingTop()) + r18.getPaddingBottom();
        r18.setScaleType(r19);
        r18.setImageDrawable(null);
        this.i.setTextSize(1, 16.0f);
        this.k.setTextSize(1, 16.0f);
        ViewGroup.LayoutParams r20 = this.j.getLayoutParams();
        if (r20 == null) goto L52;
        r20.width = MathKt.roundToInt(TypedValue.applyDimension(1, 3, d(Resources.getSystem())));
        r20.height = MathKt.roundToInt(TypedValue.applyDimension(1, 11, d(Resources.getSystem())));
        return;
    L52:
        return;
    L44:
        r6 = MathKt.roundToInt(TypedValue.applyDimension(1, 141, d(Resources.getSystem())));
        r7 = RangesKt.coerceAtLeast((int) (MathKt.roundToInt(TypedValue.applyDimension(1, 140, d(Resources.getSystem()))) * r1), MathKt.roundToInt(TypedValue.applyDimension(1, 78, d(Resources.getSystem()))));
        r19 = ImageView.ScaleType.FIT_CENTER;
        goto L45
    L48:
        this.i.setTextSize(1, 24.0f);
        this.k.setTextSize(1, 24.0f);
        ViewGroup.LayoutParams r21 = this.j.getLayoutParams();
        if (r21 == null) goto L54;
        r21.width = MathKt.roundToInt(TypedValue.applyDimension(1, 5, d(Resources.getSystem())));
        r21.height = MathKt.roundToInt(TypedValue.applyDimension(1, 17, d(Resources.getSystem())));
        return;
    }

    public final void k(SeekBarState.Action r2) {
        this.g.d(r2);
    }

    public final void m(String r3) {
        r14.c r4 = this.n;
        if (r4 != null) goto L5;
        return;
    L5:
        if (h() == true) goto L24;
        l();
        com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.e r0 = this.J;
        if (r0 == null) goto L10;
        String r1 = r0.a;
    L12:
        if (Intrinsics.areEqual(r1, r4.c()) == false) goto L21;
        com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.e r2 = this.J;
        if (r2 != null) goto L16;
    L18:
        boolean r5 = false;
    L19:
        if (r5 == false) goto L21;
        return;
    L16:
        if (r2.b != true) goto L18;
        r5 = true;
    L21:
        com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.e r6 = new com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.e();
        r6.a = r4.c();
        r6.b = true;
        this.J = r6;
        this.g.setBufferLoading(true);
        return;
    L10:
        r1 = null;
        goto L12
    }

    public final void n(String r3) {
        l();
        r14.c r4 = this.n;
        if (r4 == null) goto L5;
        com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.e r1 = new com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.e();
        r1.a = r4.c();
        r1.b = false;
        this.J = r1;
    L5:
        this.g.setBufferLoading(false);
    }

    public final void onPageScrollStateChanged(int r2) {
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L18;
        e(this.p);
        x54.b.b(this.g);
        return;
    L18:
        return;
    L8:
        if (this.l == false) goto L11;
        x54.b.d(this.g);
        return;
    L11:
        if (this.m == false) goto L13;
        this.g.f();
        return;
    L13:
        x54.b.b(this.g);
    }

    public final void onPageSelected(int r1) {
        n("page_selected");
        e(this.p);
        this.y = false;
        k(SeekBarState.Action.RELEASE);
        x54.b.a(this.h);
        x54.b.a(this.f);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d
    public final void removeSeekBarChangeListener(com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.H.remove(r2);
    }

    /* JADX WARN: Type inference failed for: r4v13, types: [com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.a] */
    public FeedSeekBarHelper(WeakReference<Context> r4, FeedPlayerHelper r5) {
        Intrinsics.checkNotNullParameter(r5, "feedPlayerHelper");
        this.a = r4;
        this.b = r5;
        this.c = 2000;
        View r6 = LayoutInflater.from(r4.get()).inflate(2131558637, null, false);
        this.d = r6;
        this.e = (ViewGroup) r6.findViewById(2131387740);
        this.f = (RoundImageView) r6.findViewById(2131392397);
        this.g = (CustomizedUISeekBar) r6.findViewById(2131392373);
        this.h = (LinearLayout) r6.findViewById(2131392374);
        this.i = (TextView) r6.findViewById(2131368349);
        this.j = (ImageView) r6.findViewById(2131385756);
        this.k = (TextView) r6.findViewById(2131389269);
        this.m = true;
        this.o = new r0(this);
        this.p = 1;
        this.q = 2;
        this.r = 3;
        this.s = 250;
        this.u = 100;
        this.v = r5.e();
        this.w = 1;
        this.A = -1;
        this.B = -1;
        this.C = LazyKt.lazy(FeedSeekBarHelper$interpolator$2.INSTANCE);
        this.E = new e(this);
        this.F = true;
        this.G = new f(this);
        this.H = new ArrayList();
        this.I = new ArrayList();
        this.L = "";
        this.M = new Handler(Looper.getMainLooper());
        this.N = new com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.a(this);
    }

    public final void i(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r4, "parent");
        if (this.d.getParent() != null) goto L7;
        r4.addView(this.d, new ViewGroup.LayoutParams(-1, -1));
        ViewGroup.LayoutParams r6 = this.g.getLayoutParams();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) r6).bottomMargin = r5;
        ViewGroup.LayoutParams r7 = this.f.getLayoutParams();
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        int r1 = this.d.getResources().getDimensionPixelOffset(2131165330) + r5;
        ((FrameLayout.LayoutParams) r7).bottomMargin = r1;
        ViewGroup.LayoutParams r8 = this.h.getLayoutParams();
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        int r0 = this.d.getResources().getDimensionPixelOffset(2131165329) + r5;
        ((FrameLayout.LayoutParams) r8).bottomMargin = r0;
        this.d.requestLayout();
        int r9 = j.a;
        j.a(new com.bytedance.awemeopen.apps.framework.base.view.seekbar.g(this.g), r5, null);
        return;
    }
}
