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
import com.bytedance.awemeopen.infra.base.player.m;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class SingleVideoSeekBarHelper implements d, r0.a {
    public boolean A;
    public boolean B;
    public int C;
    public int D;
    public final Lazy E;
    public b F;
    public final h G;
    public final i H;
    public final ArrayList<d.a> I;
    public final ArrayList<FeedSeekBarHelper.c> J;
    public e K;
    public boolean L;
    public String M;
    public final Handler N;
    public final f O;
    public final WeakReference<Context> a;
    public final FeedPlayerHelper b;
    public final boolean c;
    public final Integer d;
    public final View e;
    public final ViewGroup f;
    public final RoundImageView g;
    public final CustomizedUISeekBar h;
    public final LinearLayout i;
    public final LinearLayout j;
    public final TextView k;
    public final TextView l;
    public final ImageView m;
    public final TextView n;
    public final TextView o;
    public r14.c p;
    public final r0 q;
    public final int r;
    public final int s;
    public final int t;
    public final long u;
    public long v;
    public final long w;
    public final com.bytedance.awemeopen.infra.base.player.g x;
    public int y;
    public m z;

    public static final class a {
    }

    public interface b {
        void a();

        void b();
    }

    public static final class c extends NoAnchorSeekBar.a {
        public final /* synthetic */ SingleVideoSeekBarHelper a;

        public c(SingleVideoSeekBarHelper r1) {
            this.a = r1;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar r2) {
            Iterator<d.a> r3 = this.a.I.iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            r3.next().a();
            goto L4
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.seekbar.NoAnchorSeekBar.a
        public final void a(SeekBar r3, boolean r4) {
            Iterator<T> r0 = this.a.I.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((d.a) r0.next()).b(r3, r4);
            goto L4
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar r1, int r2, boolean r3) {
            Iterator<d.a> r4 = this.a.I.iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            r4.next().onProgressChanged(r2);
            goto L4
        }
    }

    static {
    }

    public SingleVideoSeekBarHelper() {
        throw null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d
    public final void a() {
        this.h.setVisibility(0);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d
    public final void b() {
        this.h.setVisibility(4);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d
    public final boolean c() {
        if (this.h.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void e() {
        this.b.c(this.H);
        FeedPlayerHelper r0 = this.b;
        if (r0.a == null) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
    L9:
        j();
    L10:
        addSeekBarChangeListener(this.G);
        this.h.setOnSeekBarChangeListener(new c(this));
        return;
    L8:
        if (r0.e().b() == false) goto L10;
    L5:
        r1 = false;
        goto L6
    }

    public final float f() {
        Float r0 = this.h.getPlayerProgress();
        if (r0 == null) goto L5;
        float r1 = r0.floatValue();
    L7:
        return (r1 / 100.0f) * this.x.getDuration();
    L5:
        r1 = 0.0f;
        goto L7
    }

    public final boolean g() {
        r14.c r0 = this.p;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        return true;
    L10:
        int r2 = com.bytedance.awemeopen.bizmodels.user.d.a;
        if (com.bytedance.awemeopen.bizmodels.user.d.b(this.p) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r0.a0() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final void j() {
        x54.b.d(this.h);
        int r0 = RangesKt.coerceAtLeast((int) ((this.x.getDuration() * 1.0f) / ECDraweeView.SQUARE), 1);
        this.y = r0;
        TextView r1 = this.n;
        int r2 = j0.a;
        r1.setText(j0.a.b(r0));
        TextView r3 = this.o;
        if (r3 == null) goto L6;
        r3.setText(this.n.getText());
    L6:
        this.h.d(SeekBarState.Action.VIDEO_CHANGE);
        this.q.sendEmptyMessageDelayed(this.s, this.u);
    }

    public final void k() {
        if (this.L == true) goto L5;
        return;
    L5:
        this.L = false;
        this.N.removeCallbacks(this.O);
    }

    public final WeakReference<Context> getContext() {
        return this.a;
    }

    public static DisplayMetrics d(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d
    public final void addSeekBarChangeListener(d.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.I.add(r2);
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.r0.a
    public final void handleMsg(Message r5) {
        if (r5 == null) goto L4;
        Integer r6 = Integer.valueOf(r5.what);
    L5:
        int r0 = this.r;
        if (r6 != null) goto L9;
    L11:
        int r1 = this.s;
        if (r6 != null) goto L15;
    L26:
        int r2 = this.t;
        if (r6 != null) goto L30;
        return;
    L30:
        if (r6.intValue() != r2) goto L36;
        AoPool.a(new AnonymousClass1(this));
        return;
    L36:
        return;
    L15:
        if (r6.intValue() != r1) goto L26;
        long r3 = this.x.getCurrentPosition();
        float r7 = ((r3 * 1.0f) / this.x.getDuration()) * 100.0f;
        if (Float.isNaN(r7) == false) goto L19;
    L25:
        this.q.sendEmptyMessageDelayed(this.s, this.u);
        return;
    L19:
        if (Float.isInfinite(r7) == true) goto L25;
        this.h.setProgress(r7);
        Iterator<FeedSeekBarHelper.c> r4 = this.J.iterator();
    L23:
        if (r4.hasNext() == false) goto L25;
        r4.next().a(r7);
        goto L23
    L9:
        if (r6.intValue() != r0) goto L11;
        this.h.d(SeekBarState.Action.TIMEOUT);
        return;
    L4:
        r6 = null;
        goto L5
    }

    public final void i(r14.c r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        this.p = r8;
        m("feed_update");
        this.q.removeCallbacksAndMessages(null);
        this.h.setProgress(0.0f);
        x54.b.b(this.h);
        this.h.d(SeekBarState.Action.FREEZE);
        Video r0 = r8.P();
        boolean r3 = false;
        if (r0 == null) goto L39;
        List r1 = r0.getVideoThumbs();
        if (r1 == null) goto L39;
        if (r1.isEmpty() == true) goto L39;
        d14.a r2 = b14.a.a;
        m r9 = b14.a.a(e34.a.class).D0(r8);
        this.z = r9;
        if (r9 == null) goto L39;
        String r10 = r9.b;
        if (r10 != null) goto L18;
    L21:
        boolean r11 = true;
    L22:
        if (r11 == true) goto L39;
        m r12 = this.z;
        if (r12 == null) goto L28;
        Integer r13 = r12.d;
        if (r13 == null) goto L28;
        int r14 = r13.intValue();
    L29:
        this.C = r14;
        m r15 = this.z;
        if (r15 == null) goto L34;
        Integer r16 = r15.c;
        if (r16 == null) goto L34;
        int r17 = r16.intValue();
    L35:
        this.D = r17;
        if (this.C <= 0) goto L39;
        if (r17 <= 0) goto L39;
        r3 = true;
    L34:
        r17 = 0;
    L28:
        r14 = 0;
        goto L29
    L18:
        if (r10.length() == 0) goto L21;
        r11 = false;
    L39:
        this.B = r3;
        if (r3 == false) goto L48;
        AppCompatImageView r18 = this.g;
        float r4 = this.D / this.C;
        if (r4 <= 0.75f) goto L44;
        float r5 = 88;
        int r6 = MathKt.roundToInt(TypedValue.applyDimension(1, r5, d(Resources.getSystem())));
        int r7 = RangesKt.coerceAtMost((int) (MathKt.roundToInt(TypedValue.applyDimension(1, r5, d(Resources.getSystem()))) * r4), MathKt.roundToInt(TypedValue.applyDimension(1, 140, d(Resources.getSystem()))));
        ImageView.ScaleType r19 = ImageView.ScaleType.CENTER_CROP;
    L45:
        r18.getLayoutParams().width = (r6 + r18.getPaddingLeft()) + r18.getPaddingRight();
        r18.getLayoutParams().height = (r7 + r18.getPaddingTop()) + r18.getPaddingBottom();
        r18.setScaleType(r19);
        r18.setImageDrawable(null);
        this.k.setTextSize(1, 16.0f);
        this.n.setTextSize(1, 16.0f);
        ViewGroup.LayoutParams r20 = this.m.getLayoutParams();
        if (r20 == null) goto L52;
        r20.width = MathKt.roundToInt(TypedValue.applyDimension(1, 3, d(Resources.getSystem())));
        r20.height = MathKt.roundToInt(TypedValue.applyDimension(1, 11, d(Resources.getSystem())));
        return;
    L52:
        return;
    L44:
        r6 = MathKt.roundToInt(TypedValue.applyDimension(1, 141, d(Resources.getSystem())));
        r7 = RangesKt.coerceAtLeast((int) (MathKt.roundToInt(TypedValue.applyDimension(1, 140, d(Resources.getSystem()))) * r4), MathKt.roundToInt(TypedValue.applyDimension(1, 78, d(Resources.getSystem()))));
        r19 = ImageView.ScaleType.FIT_CENTER;
        goto L45
    L48:
        this.k.setTextSize(1, 24.0f);
        this.n.setTextSize(1, 24.0f);
        ViewGroup.LayoutParams r21 = this.m.getLayoutParams();
        if (r21 == null) goto L54;
        r21.width = MathKt.roundToInt(TypedValue.applyDimension(1, 5, d(Resources.getSystem())));
        r21.height = MathKt.roundToInt(TypedValue.applyDimension(1, 17, d(Resources.getSystem())));
        return;
    }

    public final void l(String r4) {
        r14.c r5 = this.p;
        if (r5 != null) goto L5;
        return;
    L5:
        if (g() == true) goto L25;
        k();
        e r0 = this.K;
        if (r0 == null) goto L10;
        String r1 = r0.a;
    L12:
        if (Intrinsics.areEqual(r1, r5.c()) == false) goto L21;
        e r2 = this.K;
        if (r2 != null) goto L16;
    L18:
        boolean r3 = false;
    L19:
        if (r3 == false) goto L21;
        x54.b.d(this.h);
        this.h.setAlpha(1.0f);
        return;
    L16:
        if (r2.b != true) goto L18;
        r3 = true;
    L21:
        e r6 = new e();
        r6.a = r5.c();
        r6.b = true;
        this.K = r6;
        x54.b.d(this.h);
        this.h.setAlpha(1.0f);
        this.h.setBufferLoading(true);
        return;
    L10:
        r1 = null;
        goto L12
    }

    public final void m(String r3) {
        k();
        r14.c r4 = this.p;
        if (r4 == null) goto L5;
        e r1 = new e();
        r1.a = r4.c();
        r1.b = false;
        this.K = r1;
    L5:
        this.h.setBufferLoading(false);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d
    public final void removeSeekBarChangeListener(d.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.I.remove(r2);
    }

    public final void h(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r4, "parent");
        if (this.e.getParent() != null) goto L14;
        boolean r0 = this.c;
        if (r0 == false) goto L11;
        if (r0 == false) goto L10;
        r4.addView(this.e, new ViewGroup.LayoutParams(-1, -1));
        return;
    L10:
        throw new IllegalStateException();
    L11:
        r4.addView(this.e, new ViewGroup.LayoutParams(-1, -1));
        ViewGroup.LayoutParams r6 = this.h.getLayoutParams();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) r6).bottomMargin = r5;
        ViewGroup.LayoutParams r7 = this.g.getLayoutParams();
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        int r1 = this.e.getResources().getDimensionPixelOffset(2131165330) + r5;
        ((FrameLayout.LayoutParams) r7).bottomMargin = r1;
        ViewGroup.LayoutParams r8 = this.i.getLayoutParams();
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        int r2 = this.e.getResources().getDimensionPixelOffset(2131165329) + r5;
        ((FrameLayout.LayoutParams) r8).bottomMargin = r2;
        this.e.requestLayout();
        int r9 = j.a;
        j.a(new com.bytedance.awemeopen.apps.framework.base.view.seekbar.g(this.h), r5, this.d);
        return;
    }

    /* JADX WARN: Type inference failed for: r5v20, types: [com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.f] */
    public SingleVideoSeekBarHelper(WeakReference r5, FeedPlayerHelper r6, boolean r7, int r8) {
        if ((r8 & 4) == 0) goto L6;
        r7 = false;
    L6:
        if ((r8 & 8) == 0) goto L8;
        Integer r9 = Integer.valueOf(MathKt.roundToInt(TypedValue.applyDimension(1, 10, d(Resources.getSystem()))));
    L9:
        Intrinsics.checkNotNullParameter(r6, "feedPlayerHelper");
        this.a = r5;
        this.b = r6;
        this.c = r7;
        this.d = r9;
        LayoutInflater r10 = LayoutInflater.from((Context) r5.get());
        if (r7 == false) goto L12;
        int r11 = 2131558666;
    L13:
        View r12 = r10.inflate(r11, null, false);
        this.e = r12;
        this.f = (ViewGroup) r12.findViewById(2131387740);
        this.g = (RoundImageView) r12.findViewById(2131392397);
        this.h = (CustomizedUISeekBar) r12.findViewById(2131392373);
        this.i = (LinearLayout) r12.findViewById(2131392374);
        this.j = (LinearLayout) r12.findViewById(2131392298);
        this.k = (TextView) r12.findViewById(2131368349);
        this.l = (TextView) r12.findViewById(2131368356);
        this.m = (ImageView) r12.findViewById(2131385756);
        this.n = (TextView) r12.findViewById(2131389269);
        this.o = (TextView) r12.findViewById(2131389270);
        this.q = new r0(this);
        this.r = 1;
        this.s = 2;
        this.t = 3;
        this.u = 250;
        this.w = 100;
        this.x = r6.e();
        this.y = 1;
        this.C = -1;
        this.D = -1;
        this.E = LazyKt.lazy(SingleVideoSeekBarHelper$interpolator$2.INSTANCE);
        this.G = new h(this);
        this.H = new i(this);
        this.I = new ArrayList();
        this.J = new ArrayList();
        this.M = "";
        this.N = new Handler(Looper.getMainLooper());
        this.O = new f(this);
        return;
    L12:
        r11 = 2131558637;
        goto L13
    L8:
        r9 = null;
        goto L9
    }
}
