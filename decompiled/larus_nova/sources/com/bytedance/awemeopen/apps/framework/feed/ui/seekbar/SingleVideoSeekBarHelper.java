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
import com.google.gson.JsonElement;
import com.larus.nova.R;
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

/* JADX INFO: loaded from: classes14.dex */
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

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final ArrayList<FeedSeekBarHelper.c> f196749J;
    public e K;
    public boolean L;
    public String M;
    public final Handler N;
    public final f O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Context> f196750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FeedPlayerHelper f196751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f196752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f196753d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f196754e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewGroup f196755f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RoundImageView f196756g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CustomizedUISeekBar f196757h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinearLayout f196758i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinearLayout f196759j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextView f196760k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TextView f196761l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ImageView f196762m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final TextView f196763n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final TextView f196764o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public r14.c f196765p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final r0 f196766q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f196767r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f196768s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f196769t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final long f196770u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f196771v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f196772w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final com.bytedance.awemeopen.infra.base.player.g f196773x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f196774y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public m f196775z;

    public static final class a {
    }

    public interface b {
        void a();

        void b();
    }

    public static final class c extends NoAnchorSeekBar.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SingleVideoSeekBarHelper f196776a;

        public c(SingleVideoSeekBarHelper r100) {
            this.f196776a = r100;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar r100) {
            Iterator<d.a> r101 = this.f196776a.I.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            r101.next().a();
            goto L4
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.seekbar.NoAnchorSeekBar.a
        public final void a(SeekBar r100, boolean r101) {
            Iterator<T> r102 = this.f196776a.I.iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            ((d.a) r102.next()).b(r100, r101);
            goto L4
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
            Iterator<d.a> r103 = this.f196776a.I.iterator();
        L4:
            if (r103.hasNext() == false) goto L6;
            r103.next().onProgressChanged(r101);
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
        this.f196757h.setVisibility(0);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d
    public final void b() {
        this.f196757h.setVisibility(4);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d
    public final boolean c() {
        if (this.f196757h.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void e() {
        this.f196751b.c(this.H);
        FeedPlayerHelper r100 = this.f196751b;
        if (r100.f197242a == null) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
    L9:
        j();
    L10:
        addSeekBarChangeListener(this.G);
        this.f196757h.setOnSeekBarChangeListener(new c(this));
        return;
    L8:
        if (r100.e().b() == false) goto L10;
    L5:
        r101 = false;
        goto L6
    }

    public final float f() {
        Float r100 = this.f196757h.getPlayerProgress();
        if (r100 == null) goto L5;
        float r101 = r100.floatValue();
    L7:
        return (r101 / 100.0f) * this.f196773x.getDuration();
    L5:
        r101 = 0.0f;
        goto L7
    }

    public final boolean g() {
        r14.c r100 = this.f196765p;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L10;
        return true;
    L10:
        int r102 = com.bytedance.awemeopen.bizmodels.user.d.f198220a;
        if (com.bytedance.awemeopen.bizmodels.user.d.b(this.f196765p) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r100.a0() != true) goto L7;
        r101 = true;
        goto L8
    }

    public final void j() {
        x54.b.d(this.f196757h);
        int r100 = RangesKt.coerceAtLeast((int) ((this.f196773x.getDuration() * 1.0f) / 1000), 1);
        this.f196774y = r100;
        TextView r101 = this.f196763n;
        int r102 = j0.f197718a;
        r101.setText(j0.a.b(r100));
        TextView r103 = this.f196764o;
        if (r103 == null) goto L6;
        r103.setText(this.f196763n.getText());
    L6:
        this.f196757h.d(SeekBarState.Action.VIDEO_CHANGE);
        this.f196766q.sendEmptyMessageDelayed(this.f196768s, this.f196770u);
    }

    public final void k() {
        if (this.L == true) goto L5;
        return;
    L5:
        this.L = false;
        this.N.removeCallbacks(this.O);
    }

    public final WeakReference<Context> getContext() {
        return this.f196750a;
    }

    public static DisplayMetrics d(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d
    public final void addSeekBarChangeListener(d.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.I.add(r100);
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.r0.a
    public final void handleMsg(Message r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.what);
    L5:
        int r102 = this.f196767r;
        if (r101 != null) goto L9;
    L11:
        int r103 = this.f196768s;
        if (r101 != null) goto L15;
    L26:
        int r104 = this.f196769t;
        if (r101 != null) goto L30;
        return;
    L30:
        if (r101.intValue() != r104) goto L36;
        AoPool.a(new AnonymousClass1(this));
        return;
    L36:
        return;
    L15:
        if (r101.intValue() != r103) goto L26;
        long r105 = this.f196773x.getCurrentPosition();
        float r106 = ((r105 * 1.0f) / this.f196773x.getDuration()) * 100.0f;
        if (Float.isNaN(r106) == false) goto L19;
    L25:
        this.f196766q.sendEmptyMessageDelayed(this.f196768s, this.f196770u);
        return;
    L19:
        if (Float.isInfinite(r106) == true) goto L25;
        this.f196757h.setProgress(r106);
        Iterator<FeedSeekBarHelper.c> r107 = this.f196749J.iterator();
    L23:
        if (r107.hasNext() == false) goto L25;
        r107.next().a(r106);
        goto L23
    L9:
        if (r101.intValue() != r102) goto L11;
        this.f196757h.d(SeekBarState.Action.TIMEOUT);
        return;
    L4:
        r101 = null;
        goto L5
    }

    public final void i(r14.c r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f196765p = r100;
        m("feed_update");
        this.f196766q.removeCallbacksAndMessages(null);
        this.f196757h.setProgress(0.0f);
        x54.b.b(this.f196757h);
        this.f196757h.d(SeekBarState.Action.FREEZE);
        Video r101 = r100.P();
        boolean r102 = false;
        if (r101 == null) goto L39;
        List<JsonElement> r103 = r101.getVideoThumbs();
        if (r103 == null) goto L39;
        if (r103.isEmpty() == true) goto L39;
        d14.a r104 = b14.a.f16924a;
        m r105 = ((e34.a) b14.a.a(e34.a.class)).D0(r100);
        this.f196775z = r105;
        if (r105 == null) goto L39;
        String r106 = r105.f198774b;
        if (r106 != null) goto L18;
    L21:
        boolean r107 = true;
    L22:
        if (r107 == true) goto L39;
        m r108 = this.f196775z;
        if (r108 == null) goto L28;
        Integer r109 = r108.f198776d;
        if (r109 == null) goto L28;
        int r110 = r109.intValue();
    L29:
        this.C = r110;
        m r111 = this.f196775z;
        if (r111 == null) goto L34;
        Integer r112 = r111.f198775c;
        if (r112 == null) goto L34;
        int r113 = r112.intValue();
    L35:
        this.D = r113;
        if (this.C <= 0) goto L39;
        if (r113 <= 0) goto L39;
        r102 = true;
    L34:
        r113 = 0;
    L28:
        r110 = 0;
        goto L29
    L18:
        if (r106.length() == 0) goto L21;
        r107 = false;
    L39:
        this.B = r102;
        if (r102 == false) goto L48;
        RoundImageView r114 = this.f196756g;
        float r115 = this.D / this.C;
        if (r115 <= 0.75f) goto L44;
        float r116 = 88;
        int r117 = MathKt.roundToInt(TypedValue.applyDimension(1, r116, d(Resources.getSystem())));
        int r118 = RangesKt.coerceAtMost((int) (MathKt.roundToInt(TypedValue.applyDimension(1, r116, d(Resources.getSystem()))) * r115), MathKt.roundToInt(TypedValue.applyDimension(1, 140, d(Resources.getSystem()))));
        ImageView.ScaleType r119 = ImageView.ScaleType.CENTER_CROP;
    L45:
        r114.getLayoutParams().width = (r117 + r114.getPaddingLeft()) + r114.getPaddingRight();
        r114.getLayoutParams().height = (r118 + r114.getPaddingTop()) + r114.getPaddingBottom();
        r114.setScaleType(r119);
        r114.setImageDrawable(null);
        this.f196760k.setTextSize(1, 16.0f);
        this.f196763n.setTextSize(1, 16.0f);
        ViewGroup.LayoutParams r120 = this.f196762m.getLayoutParams();
        if (r120 == null) goto L52;
        r120.width = MathKt.roundToInt(TypedValue.applyDimension(1, 3, d(Resources.getSystem())));
        r120.height = MathKt.roundToInt(TypedValue.applyDimension(1, 11, d(Resources.getSystem())));
        return;
    L52:
        return;
    L44:
        r117 = MathKt.roundToInt(TypedValue.applyDimension(1, 141, d(Resources.getSystem())));
        r118 = RangesKt.coerceAtLeast((int) (MathKt.roundToInt(TypedValue.applyDimension(1, 140, d(Resources.getSystem()))) * r115), MathKt.roundToInt(TypedValue.applyDimension(1, 78, d(Resources.getSystem()))));
        r119 = ImageView.ScaleType.FIT_CENTER;
        goto L45
    L48:
        this.f196760k.setTextSize(1, 24.0f);
        this.f196763n.setTextSize(1, 24.0f);
        ViewGroup.LayoutParams r121 = this.f196762m.getLayoutParams();
        if (r121 == null) goto L54;
        r121.width = MathKt.roundToInt(TypedValue.applyDimension(1, 5, d(Resources.getSystem())));
        r121.height = MathKt.roundToInt(TypedValue.applyDimension(1, 17, d(Resources.getSystem())));
        return;
    }

    public final void l(String r100) {
        r14.c r101 = this.f196765p;
        if (r101 != null) goto L5;
        return;
    L5:
        if (g() == true) goto L25;
        k();
        e r102 = this.K;
        if (r102 == null) goto L10;
        String r103 = r102.f196780a;
    L12:
        if (Intrinsics.areEqual(r103, r101.c()) == false) goto L21;
        e r104 = this.K;
        if (r104 != null) goto L16;
    L18:
        boolean r105 = false;
    L19:
        if (r105 == false) goto L21;
        x54.b.d(this.f196757h);
        this.f196757h.setAlpha(1.0f);
        return;
    L16:
        if (r104.f196781b != true) goto L18;
        r105 = true;
    L21:
        e r106 = new e();
        r106.f196780a = r101.c();
        r106.f196781b = true;
        this.K = r106;
        x54.b.d(this.f196757h);
        this.f196757h.setAlpha(1.0f);
        this.f196757h.setBufferLoading(true);
        return;
    L10:
        r103 = null;
        goto L12
    }

    public final void m(String r100) {
        k();
        r14.c r101 = this.f196765p;
        if (r101 == null) goto L5;
        e r102 = new e();
        r102.f196780a = r101.c();
        r102.f196781b = false;
        this.K = r102;
    L5:
        this.f196757h.setBufferLoading(false);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d
    public final void removeSeekBarChangeListener(d.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.I.remove(r100);
    }

    public final void h(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (this.f196754e.getParent() != null) goto L14;
        boolean r102 = this.f196752c;
        if (r102 == false) goto L11;
        if (r102 == false) goto L10;
        r100.addView(this.f196754e, new ViewGroup.LayoutParams(-1, -1));
        return;
    L10:
        throw new IllegalStateException();
    L11:
        r100.addView(this.f196754e, new ViewGroup.LayoutParams(-1, -1));
        ViewGroup.LayoutParams r103 = this.f196757h.getLayoutParams();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) r103).bottomMargin = r101;
        ViewGroup.LayoutParams r104 = this.f196756g.getLayoutParams();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        int r105 = this.f196754e.getResources().getDimensionPixelOffset(R.dimen.aos_feed_bar_thumb_2_bar_distance) + r101;
        ((FrameLayout.LayoutParams) r104).bottomMargin = r105;
        ViewGroup.LayoutParams r106 = this.f196758i.getLayoutParams();
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        int r107 = this.f196754e.getResources().getDimensionPixelOffset(R.dimen.aos_feed_bar_duration_2_bar_distance) + r101;
        ((FrameLayout.LayoutParams) r106).bottomMargin = r107;
        this.f196754e.requestLayout();
        int r108 = j.f193663a;
        j.a(new com.bytedance.awemeopen.apps.framework.base.view.seekbar.g(this.f196757h), r101, this.f196753d);
        return;
    }

    /* JADX WARN: Type inference failed for: r5v20, types: [com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.f] */
    public SingleVideoSeekBarHelper(WeakReference r100, FeedPlayerHelper r101, boolean r102, int r103) {
        if ((r103 & 4) == 0) goto L6;
        r102 = false;
    L6:
        if ((r103 & 8) == 0) goto L8;
        Integer r104 = Integer.valueOf(MathKt.roundToInt(TypedValue.applyDimension(1, 10, d(Resources.getSystem()))));
    L9:
        Intrinsics.checkNotNullParameter(r101, "feedPlayerHelper");
        this.f196750a = r100;
        this.f196751b = r101;
        this.f196752c = r102;
        this.f196753d = r104;
        LayoutInflater r105 = LayoutInflater.from((Context) r100.get());
        if (r102 == false) goto L12;
        int r106 = R.layout.aos_landscape_seek_bar;
    L13:
        View r107 = r105.inflate(r106, null, false);
        this.f196754e = r107;
        this.f196755f = (ViewGroup) r107.findViewById(R.id.supportSeekBarFL);
        this.f196756g = (RoundImageView) r107.findViewById(R.id.video_thumb);
        this.f196757h = (CustomizedUISeekBar) r107.findViewById(R.id.video_seek_bar);
        this.f196758i = (LinearLayout) r107.findViewById(R.id.video_seek_duration);
        this.f196759j = (LinearLayout) r107.findViewById(R.id.video_duration_pinned);
        this.f196760k = (TextView) r107.findViewById(R.id.current_seek_video_time);
        this.f196761l = (TextView) r107.findViewById(R.id.current_video_time_pinned);
        this.f196762m = (ImageView) r107.findViewById(R.id.seek_bar_time_diagonal);
        this.f196763n = (TextView) r107.findViewById(R.id.total_video_time);
        this.f196764o = (TextView) r107.findViewById(R.id.total_video_time_pinned);
        this.f196766q = new r0(this);
        this.f196767r = 1;
        this.f196768s = 2;
        this.f196769t = 3;
        this.f196770u = 250;
        this.f196772w = 100;
        this.f196773x = r101.e();
        this.f196774y = 1;
        this.C = -1;
        this.D = -1;
        this.E = LazyKt.lazy(SingleVideoSeekBarHelper$interpolator$2.INSTANCE);
        this.G = new h(this);
        this.H = new i(this);
        this.I = new ArrayList();
        this.f196749J = new ArrayList();
        this.M = "";
        this.N = new Handler(Looper.getMainLooper());
        this.O = new f(this);
        return;
    L12:
        r106 = R.layout.aos_feed_seek_bar;
        goto L13
    L8:
        r104 = null;
        goto L9
    }
}
