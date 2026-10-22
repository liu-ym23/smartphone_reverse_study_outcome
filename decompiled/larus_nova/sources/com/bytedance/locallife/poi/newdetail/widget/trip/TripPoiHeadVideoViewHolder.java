package com.bytedance.locallife.poi.newdetail.widget.trip;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.dux.image.DuxImageView;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.lighten.core.ScaleType;
import com.bytedance.lighten.loader.SmartImageView;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.poi.newdetail.widget.seekbar.PoiSeekBar;
import com.bytedance.locallife.poi.newdetail.widget.seekbar.PoiSeekbarConfigHolder;
import com.bytedance.locallife.poi.utils.PoiSaaSUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.poi.model.AlbumTabListModel;
import com.ss.android.ugc.aweme.poi.model.PhotoHighlight;
import com.ss.android.ugc.aweme.poi.model.PoiPhoto;
import com.ss.android.ugc.aweme.video.PoiAbstractVideoView;
import df6.u;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/widget/trip/TripPoiHeadVideoViewHolder;", "Lcom/bytedance/locallife/poi/newdetail/widget/trip/PoiHeadViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class TripPoiHeadVideoViewHolder extends PoiHeadViewHolder {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ int f263617z = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f263618c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f263619d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f263620e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f263621f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f263622g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final s f263623h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f263624i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final n f263625j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f263626k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f263627l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f263628m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f263629n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f263630o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f263631p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final PoiAbstractVideoView f263632q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final FrameLayout f263633r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final SmartImageView f263634s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final DuxImageView f263635t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final LinearLayout f263636u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final DuxTextView f263637v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final DuxTextView f263638w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final DuxImageView f263639x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final o f263640y;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f263641a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TripPoiHeadVideoViewHolder f263642b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.locallife.poi.newdetail.widget.contentplayer.i f263643c;

        public b(DuxTextView r100, TripPoiHeadVideoViewHolder r101, com.bytedance.locallife.poi.newdetail.widget.contentplayer.i r102) {
            this.f263641a = r100;
            this.f263642b = r101;
            this.f263643c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (com.bytedance.locallife.common.utils.g.a(this.f263641a) == false) goto L5;
            return;
        L5:
            com.bytedance.locallife.poi.newdetail.widget.contentplayer.c r101 = this.f263642b.f263524b;
            if (r101 == null) goto L9;
            r101.b(this.f263643c);
            return;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f263644a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TripPoiHeadVideoViewHolder f263645b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.locallife.poi.newdetail.widget.contentplayer.i f263646c;

        public c(View r100, TripPoiHeadVideoViewHolder r101, com.bytedance.locallife.poi.newdetail.widget.contentplayer.i r102) {
            this.f263644a = r100;
            this.f263645b = r101;
            this.f263646c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (com.bytedance.locallife.common.utils.g.a(this.f263644a) == false) goto L5;
            return;
        L5:
            com.bytedance.locallife.poi.newdetail.widget.contentplayer.c r101 = this.f263645b.f263524b;
            if (r101 == null) goto L9;
            r101.b(this.f263646c);
            return;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TripPoiHeadVideoViewHolder f263647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PoiPhoto f263648b;

        public d(TripPoiHeadVideoViewHolder r100, PoiPhoto r101) {
            this.f263647a = r100;
            this.f263648b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TripPoiHeadVideoViewHolder r100 = this.f263647a;     // Catch: Throwable -> L8
            PoiPhoto r101 = this.f263648b;     // Catch: Throwable -> L8
            int r102 = r101.videoWidth;     // Catch: Throwable -> L8
            int r103 = r101.videoHeight;     // Catch: Throwable -> L8
            int r104 = r100.f263633r.getWidth();     // Catch: Throwable -> L8
            if (r102 <= 0) goto L11;
            if (r103 <= 0) goto L15;
            if (r104 <= 0) goto L16;
            float r105 = r104 * (r103 / r102);     // Catch: Throwable -> L8
            ViewGroup.LayoutParams r106 = r100.f263633r.getLayoutParams();     // Catch: Throwable -> L8
            r106.height = (int) r105;     // Catch: Throwable -> L8
            r100.f263633r.setLayoutParams(r106);     // Catch: Throwable -> L8
            return;
        L16:
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.locallife.poi.newdetail.widget.trip.PoiHeadViewHolder
    public final void b4() {
        this.f263626k = false;
        if (this.f263523a != 0) goto L8;
        if (Intrinsics.areEqual(this.f263632q.d(), Boolean.TRUE) == false) goto L8;
        this.f263632q.f();
    L8:
        if (this.f263618c == false) goto L11;
        this.f263632q.setSurfaceVisibility(4);
        return;
    }

    @Override // com.bytedance.locallife.poi.newdetail.widget.trip.PoiHeadViewHolder
    public final void c4() {
        this.f263626k = true;
        e4();
        if (this.f263618c == false) goto L6;
        this.f263632q.setSurfaceVisibility(0);
        return;
    }

    @Override // com.bytedance.locallife.poi.newdetail.widget.trip.PoiHeadViewHolder
    public final boolean V3() {
        Boolean r100 = this.f263632q.d();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.booleanValue();
    }

    @Override // com.bytedance.locallife.poi.newdetail.widget.trip.PoiHeadViewHolder
    public final void X3() {
        if (Intrinsics.areEqual(this.f263632q.d(), Boolean.TRUE) == false) goto L6;
        this.f263632q.f();
        return;
    }

    @Override // com.bytedance.locallife.poi.newdetail.widget.trip.PoiHeadViewHolder
    public final void Y3() {
        if (this.f263523a == 0) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.f263632q.d(), Boolean.TRUE) == false) goto L9;
        this.f263632q.f();
        return;
    }

    @Override // com.bytedance.locallife.poi.newdetail.widget.trip.PoiHeadViewHolder
    public final void Z3() {
        this.f263632q.g();
        boolean r100 = HostServiceUtilsKt.i0().g("poi_repo", "poi_head_video_play_mute_status", true);
        this.f263624i = r100;
        this.f263632q.setMute(r100);
        e4();
    }

    public final void e4() {
        if (this.f263523a == 0) goto L5;
        return;
    L5:
        if (this.f263626k == false) goto L16;
        this.f263632q.e();
        if (Intrinsics.areEqual(this.f263632q.c(), Boolean.TRUE) == true) goto L10;
        return;
    L10:
        if (this.f263621f == false) goto L15;
        this.f263634s.setVisibility(4);
        this.f263632q.l();
        return;
    L15:
        return;
    }

    public final void g4() {
        if (this.f263523a == 0) goto L5;
        return;
    L5:
        if (this.f263626k == true) goto L7;
        return;
    L7:
        if (this.f263621f == false) goto L12;
        this.f263634s.setVisibility(4);
        this.f263635t.setVisibility(4);
        this.f263632q.l();
        return;
    }

    @Override // com.bytedance.locallife.poi.newdetail.widget.trip.PoiHeadViewHolder
    public final void onDestroy() {
        this.itemView.removeCallbacks(this.f263625j);
        this.f263632q.j(this.f263640y);
        this.f263632q.h();
        this.f263632q.i();
    }

    @Override // com.bytedance.locallife.poi.newdetail.widget.trip.PoiHeadViewHolder
    public final void W3() {
        e4();
    }

    @Override // com.bytedance.locallife.poi.newdetail.widget.trip.PoiHeadViewHolder
    public final void d4(int r100) {
        this.f263619d = r100;
    }

    @Override // com.bytedance.locallife.poi.newdetail.widget.trip.PoiHeadViewHolder
    public final void a4(int r100, int r101) {
        if (this.f263631p == 2) goto L5;
        return;
    L5:
        if (this.f263629n == false) goto L7;
        this.itemView.setTranslationY(((this.f263619d - this.f263620e) / 2) - (r100 / 2));
    L7:
        this.f263636u.setTranslationY(((this.f263619d - this.f263620e) / 2) - (r100 / 2));
    }

    @Override // com.bytedance.locallife.poi.newdetail.widget.trip.PoiHeadViewHolder
    public final void U3(PoiPhoto r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "poiPhoto");
        this.f263631p = r101;
        this.f263633r.post(new d(this, r100));
        String r103 = r100.videoId;
        if (r103 != null) goto L5;
        return;
    L5:
        String r104 = r100.videoUrl;
        if (r104 != null) goto L8;
        return;
    L8:
        Float r105 = r100.videoDuration;
        if (r105 != null) goto L11;
        r105 = Float.valueOf(0.0f);
    L11:
        r105.floatValue();
        PoiAbstractVideoView r106 = this.f263632q;
        String r107 = this.f263622g;
        if (r107 != null) goto L14;
        r107 = "";
    L14:
        r106.b(r107.concat(r103), r103, r104);
        this.f263632q.j(this.f263640y);
        this.f263632q.a(this.f263640y);
        this.f263632q.g();
        this.f263632q.setMute(this.f263624i);
        u r108 = df6.q.d(r100.videoCoverUrl);
        r108.f468288n = ScaleType.CENTER_CROP;
        r108.f468277c = this.itemView.getContext();
        r108.f468294t = this.f263634s;
        r108.c();
        if (this.f263626k == true) goto L17;
        this.f263632q.setSurfaceVisibility(4);
    L17:
        PhotoHighlight r109 = r100.highlight;
        if (r109 == null) goto L39;
        String r110 = r109.getTitle();
        if (r110 == null) goto L27;
        boolean r111 = true;
        if (r110.length() <= 0) goto L24;
        boolean r112 = true;
    L25:
        if (r112 != true) goto L27;
    L29:
        if (r111 == false) goto L37;
        int r113 = com.bytedance.locallife.poi.newdetail.h.f263265d;
        if (r113 != 0) goto L34;
        r113 = com.bytedance.locallife.biz.common.utils.e.b();
    L34:
        int r114 = RangesKt.coerceAtLeast(r113, 0) - RangesKt.coerceAtLeast((int) xo6.b.a(138), 20);
        this.f263637v.setMaxWidth(r114);
        this.f263638w.setMaxWidth(r114);
        this.f263636u.setVisibility(0);
        f4(this.f263637v, r109.getTitle(), r109.getTitleColor());
        f4(this.f263638w, r109.getSubtitle(), r109.getSubtitleColor());
        if (this.f263629n == true) goto L40;
        this.f263639x.setVisibility(8);
        return;
    L40:
        return;
    L37:
        this.f263636u.setVisibility(8);
        return;
    L24:
        r112 = false;
    L27:
        r111 = false;
        goto L29
    }

    public final void f4(DuxTextView r100, String r101, String r102) {
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.setText(r101);
        int r103 = com.bytedance.locallife.poi.dito.util.a.f262546a;
        if (r102 != null) goto L8;
        r102 = CustomHeaderConfig.COLOR_LIGHT;
    L8:
        r100.setTextColor(com.bytedance.locallife.poi.dito.util.a.a(r102));
        r100.setSingleLine();
        r100.setEllipsize(TextUtils.TruncateAt.END);
    }

    @Override // com.bytedance.locallife.poi.newdetail.widget.trip.PoiHeadViewHolder
    public final void T3(com.bytedance.locallife.poi.newdetail.widget.contentplayer.i r100, int r101, int r102, List<AlbumTabListModel> r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "itemData");
        Intrinsics.checkNotNullParameter(r103, "subTabItemList");
        this.f263629n = true;
        int r106 = (r104 - this.f263620e) / 2;
        this.f263630o = r106;
        this.itemView.setTranslationY(r106);
        this.f263636u.setTranslationY(this.f263630o);
        com.bytedance.locallife.poi.newdetail.widget.contentplayer.a r107 = r100.b();
        if (r107 == null) goto L42;
        List<PoiPhoto> r108 = r107.d();
        if (r108 == null) goto L42;
        PoiPhoto r109 = (PoiPhoto) ListProtector.get(r108, 0);
        if (r109 == null) goto L42;
        PhotoHighlight r110 = r109.highlight;
        String r111 = null;
        if (r110 == null) goto L11;
        String r112 = r110.getTitle();
    L12:
        if (r112 == null) goto L41;
        PhotoHighlight r113 = r109.highlight;
        if (r113 == null) goto L16;
        r111 = r113.getTitle();
    L16:
        String r114 = "";
        if (Intrinsics.areEqual(r111, "") == true) goto L41;
        this.f263636u.setVisibility(0);
        DuxTextView r115 = this.f263637v;
        PhotoHighlight r116 = r109.highlight;
        if (r116 == null) goto L23;
        String r117 = r116.getTitle();
        if (r117 == null) goto L23;
    L24:
        r115.setText(r117);
        DuxTextView r118 = this.f263638w;
        PhotoHighlight r119 = r109.highlight;
        if (r119 == null) goto L29;
        String r120 = r119.getSubtitle();
        if (r120 == null) goto L29;
        r114 = r120;
    L29:
        r118.setText(r114);
        DuxTextView r121 = this.f263637v;
        int r122 = com.bytedance.locallife.poi.dito.util.a.f262546a;
        PhotoHighlight r123 = r109.highlight;
        String r124 = CustomHeaderConfig.COLOR_LIGHT;
        if (r123 == null) goto L33;
        String r125 = r123.getTitleColor();
        if (r125 == null) goto L33;
    L34:
        r121.setTextColor(com.bytedance.locallife.poi.dito.util.a.a(r125));
        DuxTextView r126 = this.f263638w;
        PhotoHighlight r127 = r109.highlight;
        if (r127 == null) goto L40;
        String r128 = r127.getSubtitleColor();
        if (r128 == null) goto L40;
        r124 = r128;
    L40:
        r126.setTextColor(com.bytedance.locallife.poi.dito.util.a.a(r124));
    L33:
        r125 = CustomHeaderConfig.COLOR_LIGHT;
    L23:
        r117 = "";
    L41:
        this.f263636u.setVisibility(8);
        goto L42
    L11:
        r112 = null;
    L42:
        DuxTextView r129 = this.f263637v;
        r129.setOnClickListener(new b(r129, this, r100));
        View r130 = this.itemView;
        r130.setOnClickListener(new c(r130, this, r100));
        com.bytedance.locallife.poi.newdetail.widget.contentplayer.a r131 = r100.b();
        if (r131 == null) goto L50;
        List<PoiPhoto> r132 = r131.d();
        if (r132 == null) goto L51;
        PoiPhoto r133 = (PoiPhoto) ListProtector.get(r132, 0);
        if (r133 == null) goto L52;
        U3(r133, r101, r102);
        return;
    L52:
        return;
    L51:
        return;
    }

    public TripPoiHeadVideoViewHolder(View r100, boolean r101, int r102, int r103, boolean r104, String r105, s r106) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f263618c = r101;
        this.f263619d = r102;
        this.f263620e = r103;
        this.f263621f = r104;
        this.f263622g = r105;
        this.f263623h = r106;
        this.f263624i = HostServiceUtilsKt.i0().g("poi_repo", "poi_head_video_play_mute_status", true);
        this.f263625j = new n(this);
        this.f263626k = !r101;
        NetworkUtils.isWifi(r100.getContext());
        an6.c r107 = HostServiceUtilsKt.s0().k0(r100.getContext());
        this.f263632q = r107;
        FrameLayout r108 = (FrameLayout) r100.findViewById(R.id.item_trip_head_video_container);
        this.f263633r = r108;
        PoiSeekBar r109 = (PoiSeekBar) r100.findViewById(R.id.item_trip_head_video_seek_bar);
        this.f263634s = (SmartImageView) r100.findViewById(R.id.item_trip_head_video_cover);
        DuxImageView r110 = (DuxImageView) r100.findViewById(R.id.item_trip_head_video_play);
        this.f263635t = r110;
        this.f263636u = (LinearLayout) r100.findViewById(R.id.title_container);
        this.f263637v = (DuxTextView) r100.findViewById(R.id.title_text);
        this.f263638w = (DuxTextView) r100.findViewById(R.id.subtitle_text);
        this.f263639x = (DuxImageView) r100.findViewById(R.id.title_text_arrow);
        this.f263640y = new o();
        r109.setMax(100);
        Lazy r111 = PoiSeekbarConfigHolder.f263472a;
        r109.setDefaultStyleConfig(new com.bytedance.locallife.poi.newdetail.widget.seekbar.h().a());
        r109.setActiveStyleConfig(PoiSeekbarConfigHolder.b());
        r109.setDragStyleConfig(PoiSeekbarConfigHolder.c());
        com.bytedance.locallife.poi.newdetail.widget.seekbar.j r112 = new com.bytedance.locallife.poi.newdetail.widget.seekbar.j();
        r112.f263513a = r109.getDefaultStyleConfig();
        r112.f263514b = r109.getActiveStyleConfig();
        r112.f263515c = r109.getDragStyleConfig();
        r109.f263444e = r112;
        if (r112.f263513a != null) goto L5;
        r112.f263513a = new com.bytedance.locallife.poi.newdetail.widget.seekbar.h();
    L5:
        r109.f263440a = r112.f263513a;
        if (r112.f263514b != null) goto L8;
        r112.f263514b = PoiSeekbarConfigHolder.b();
    L8:
        r109.f263441b = r112.f263514b;
        if (r112.f263515c != null) goto L11;
        r112.f263515c = PoiSeekbarConfigHolder.c();
    L11:
        r109.f263442c = r112.f263515c;
        r109.f263443d = null;
        r109.f263451l = true;
        r109.setEnabled(true);
        r109.f263448i = true;
        r109.D = true;
        r109.f263449j = 2000;
        r109.f263453n = true;
        r109.b(r109.getDefaultStyleConfig());
        r109.a(new l(this));
        r108.addView(r107, 0, new FrameLayout.LayoutParams(-1, -1));
        if (r104 == false) goto L17;
        if (PoiSaaSUtils.a() == true) goto L17;
        r110.setOnClickListener(new m(r110, this, r100));
    L17:
        if (PoiSaaSUtils.a() == false) goto L20;
        r110.setVisibility(8);
        r109.setVisibility(8);
        return;
    }
}
