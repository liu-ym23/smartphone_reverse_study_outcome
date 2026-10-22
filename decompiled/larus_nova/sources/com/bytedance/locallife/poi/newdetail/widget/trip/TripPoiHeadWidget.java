package com.bytedance.locallife.poi.newdetail.widget.trip;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.lighten.loader.SmartImageView;
import com.bytedance.locallife.ability.model.AbilityEnum;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.dito.baseview.RoundRelativeLayout;
import com.bytedance.locallife.poi.experiment.PoiBigFontExperiment;
import com.bytedance.locallife.poi.newdetail.widget.PoiHeartbeatBadgeView;
import com.bytedance.locallife.poi.utils.PoiSaaSUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.dito.poi.player.ui.HorizontalOverScrollLayout;
import com.ss.android.ugc.aweme.poi.model.HeadVideoStrict;
import com.ss.android.ugc.aweme.poi.model.PoiBundle;
import com.ss.android.ugc.aweme.poi.model.PoiPhoto;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import df6.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001dB\u0011\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017B\u0019\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u0016\u0010\u001aB!\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u001cJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/widget/trip/TripPoiHeadWidget;", "Lcom/bytedance/locallife/poi/newdetail/widget/trip/NestedScrollFrameLayout;", "", "getPageTopOffset", "", "enterId", "", "setPoiEnterId", "", "h", "Z", "getHeadImageTagOpt", "()Z", "setHeadImageTagOpt", "(Z)V", "headImageTagOpt", RXScreenCaptureService.KEY_INDEX, "getShowAlbumText", "setShowAlbumText", "showAlbumText", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class TripPoiHeadWidget extends NestedScrollFrameLayout {
    public static final /* synthetic */ int V0 = 0;
    public final RelativeLayout A;
    public final FrameLayout B;
    public final DuxTextView C;
    public final ImageView D;
    public final View E;
    public Integer F;
    public HeadVideoStrict G;
    public final LinearLayout H;
    public final List<Integer> H0;
    public final PoiHeartbeatBadgeView I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public com.bytedance.locallife.poi.newdetail.widget.contentplayer.b f263649J;
    public com.bytedance.locallife.poi.newdetail.widget.trip.f K;
    public com.bytedance.locallife.poi.newdetail.widget.trip.d L;
    public int L0;
    public String M;
    public final List<Integer> N;
    public final Paint O;
    public int P;
    public final b P0;
    public boolean Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public boolean U;
    public final List<PoiPhoto> V;
    public final Set<Integer> W;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f263650h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f263651i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f263652j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f263653k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final List<String> f263654k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f263655l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f263656m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f263657n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public PoiBundle f263658o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f263659p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final List<Integer> f263660p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f263661q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final HorizontalOverScrollLayout f263662r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ViewPager2 f263663s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TripPoiHeadAdapter f263664t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final SmartImageView f263665u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f263666v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public TripPoiHeadTagsWidget f263667w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final TripPoiHeadTagsWidget f263668x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final TripPoiHeadTagsWidget f263669y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ConstraintLayout f263670z;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TripPoiHeadWidget f263671a;

        public final void a() {
            TripPoiHeadWidget r100 = this.f263671a;
            if (r100.L0 >= r100.H0.size()) goto L13;
            TripPoiHeadWidget r101 = this.f263671a;
            List<Integer> r102 = r101.H0;
            int r103 = r101.L0;
            r101.L0 = r103 + 1;
            int r104 = ((Number) ListProtector.get(r102, r103)).intValue();
            ViewPager2 r105 = this.f263671a.f263663s;
            if (r105 == null) goto L7;
            r105.setCurrentItem(r104, false);
        L7:
            TripPoiHeadWidget r106 = this.f263671a;
            if (r106.L0 >= r106.H0.size()) goto L14;
            ViewPager2 r107 = this.f263671a.f263663s;
            if (r107 == null) goto L15;
            r107.postDelayed(this, 3000);
            return;
        L15:
            return;
        L14:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(TripPoiHeadWidget r100) {
            this.f263671a = r100;
        }
    }

    public static final class c implements com.bytedance.locallife.poi.newdetail.widget.trip.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TripPoiHeadWidget f263672a;

        @Override // com.bytedance.locallife.poi.newdetail.widget.trip.d
        public final void c(List<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "tabs");
        }

        @Override // com.bytedance.locallife.poi.newdetail.widget.trip.d
        public final void a() {
            this.f263672a.b();
            com.bytedance.locallife.poi.newdetail.widget.trip.d r100 = this.f263672a.L;
            if (r100 == null) goto L6;
            r100.a();
            return;
        }

        @Override // com.bytedance.locallife.poi.newdetail.widget.trip.d
        public final void b() {
            this.f263672a.b();
            com.bytedance.locallife.poi.newdetail.widget.trip.d r100 = this.f263672a.L;
            if (r100 == null) goto L6;
            r100.b();
            return;
        }

        public c(TripPoiHeadWidget r100) {
            this.f263672a = r100;
        }

        @Override // com.bytedance.locallife.poi.newdetail.widget.trip.d
        public final void d(boolean r100, boolean r101) {
            TripPoiHeadAdapter r102 = this.f263672a.f263664t;
            if (r102 == null) goto L13;
            Iterator<Map.Entry<Integer, WeakReference<PoiHeadViewHolder>>> r103 = r102.f263535k.entrySet().iterator();
        L6:
            if (r103.hasNext() == false) goto L13;
            PoiHeadViewHolder r104 = r103.next().getValue().get();
            if ((r104 instanceof TripPoiHeadVideoViewHolder) == false) goto L10;
            TripPoiHeadVideoViewHolder r105 = (TripPoiHeadVideoViewHolder) r104;
        L11:
            if (r105 == null) goto L6;
            r105.f263624i = r100;
            r105.f263632q.setMute(r100);
            goto L6
        L10:
            r105 = null;
        L13:
            com.bytedance.locallife.poi.newdetail.widget.trip.d r106 = this.f263672a.L;
            if (r106 == null) goto L22;
            r106.d(r100, r101);
            return;
        }

        @Override // com.bytedance.locallife.poi.newdetail.widget.trip.d
        public final void e(List<com.bytedance.locallife.poi.newdetail.widget.contentplayer.i> r100, int r101, int r102) {
            this.f263672a.b();
            if (r102 >= 0) goto L5;
            return;
        L5:
            if (r102 >= ((ArrayList) this.f263672a.f263654k0).size()) goto L16;
            List<Integer> r103 = this.f263672a.f263660p0;
            ArrayList r104 = (ArrayList) r103;
            int r105 = r104.indexOf(Integer.valueOf(r102));
            if (r105 < 0) goto L11;
            ViewPager2 r106 = this.f263672a.f263663s;
            if (r106 == null) goto L11;
            r106.setCurrentItem(r105, false);
        L11:
            com.bytedance.locallife.poi.newdetail.widget.trip.d r107 = this.f263672a.L;
            if (r107 == null) goto L17;
            r107.e(r100, r101, r102);
            return;
        L17:
            return;
        }
    }

    public static final class d implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TripPoiHeadWidget f263673a;

        @Override // com.bytedance.locallife.poi.newdetail.widget.trip.s
        public final void a() {
            TripPoiHeadWidget r100 = this.f263673a;
            if (r100.Q == true) goto L8;
            r100.Q = true;
            com.bytedance.locallife.poi.newdetail.widget.trip.f r101 = r100.K;
            if (r101 == null) goto L9;
            r101.b();
            return;
        L9:
            return;
        }

        @Override // com.bytedance.locallife.poi.newdetail.widget.trip.s
        public final void b() {
            this.f263673a.b();
        }

        @Override // com.bytedance.locallife.poi.newdetail.widget.trip.s
        public final void c() {
            this.f263673a.b();
        }

        public d(TripPoiHeadWidget r100) {
            this.f263673a = r100;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TripPoiHeadWidget f263674a;

        public e(TripPoiHeadWidget r100) {
            this.f263674a = r100;
        }

        public final void a() {
            TripPoiHeadWidget r100 = this.f263674a;
            int r101 = r100.f263657n;
            r100.getClass();
            if (HostServiceUtilsKt.i0().g("poi_repo", "first_enter_head_image", false) == true) goto L12;
            HostServiceUtilsKt.i0().d("poi_repo", "first_enter_head_image", true);
            TripPoiHeadGuideWidget r102 = new TripPoiHeadGuideWidget(r100.getContext(), r101);
            r102.setOnGuideEndListener(new r(r100));
            FrameLayout r103 = r100.B;
            if (r103 == null) goto L7;
            r103.addView(r102);
        L7:
            FrameLayout r104 = r100.B;
            if (r104 == null) goto L13;
            r104.setVisibility(0);
            return;
        L13:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.locallife.poi.newdetail.widget.trip.f f263675a;

        public f(com.bytedance.locallife.poi.newdetail.widget.trip.f r100) {
            this.f263675a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f263675a.e();
        }
    }

    static {
    }

    public final void b() {
        this.S = false;
        ViewPager2 r100 = this.f263663s;
        if (r100 == null) goto L6;
        r100.removeCallbacks(this.P0);
        return;
    }

    public final void d() {
        TripPoiHeadAdapter r100 = this.f263664t;
        if (r100 == null) goto L10;
        Iterator<Map.Entry<Integer, WeakReference<PoiHeadViewHolder>>> r101 = r100.f263535k.entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        PoiHeadViewHolder r102 = r101.next().getValue().get();
        if (r102 == null) goto L6;
        r102.Y3();
    L10:
        TripPoiHeadTagsWidget r103 = this.f263667w;
        if (r103 == null) goto L19;
        r103.c();
        return;
    }

    public final void e() {
        TripPoiHeadAdapter r100 = this.f263664t;
        if (r100 == null) goto L10;
        Iterator<Map.Entry<Integer, WeakReference<PoiHeadViewHolder>>> r101 = r100.f263535k.entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        PoiHeadViewHolder r102 = r101.next().getValue().get();
        if (r102 == null) goto L6;
        r102.Z3();
    L10:
        TripPoiHeadTagsWidget r103 = this.f263667w;
        if (r103 == null) goto L19;
        boolean r104 = HostServiceUtilsKt.i0().g("poi_repo", "poi_head_video_play_mute_status", true);
        r103.f263610x = r104;
        r103.setVideoMuteRes(r104);
        return;
    }

    public final void f() {
        TripPoiHeadAdapter r100 = this.f263664t;
        if (r100 == null) goto L10;
        Iterator<Map.Entry<Integer, WeakReference<PoiHeadViewHolder>>> r101 = r100.f263535k.entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L16;
        PoiHeadViewHolder r102 = r101.next().getValue().get();
        if (r102 == null) goto L6;
        r102.b4();
        goto L6
    L16:
        return;
    }

    public final void g() {
        TripPoiHeadAdapter r100 = this.f263664t;
        if (r100 == null) goto L11;
        Iterator<Map.Entry<Integer, WeakReference<PoiHeadViewHolder>>> r101 = r100.f263535k.entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L11;
        PoiHeadViewHolder r102 = r101.next().getValue().get();
        if (r102 == null) goto L6;
        r102.c4();
    L11:
        if (this.R == false) goto L13;
        return;
    L13:
        boolean r103 = true;
        this.R = true;
        if (this.f263652j == false) goto L41;
        com.bytedance.locallife.poi.newdetail.widget.trip.d r104 = this.L;
        if (r104 == null) goto L19;
        r104.c(this.f263654k0);
    L19:
        if (((ArrayList) this.V).size() <= 0) goto L23;
        this.W.add(0);
        com.bytedance.locallife.poi.newdetail.widget.trip.f r105 = this.K;
        if (r105 == null) goto L23;
        r105.f(0, (PoiPhoto) ListProtector.get(this.V, 0));
    L23:
        i();
        Integer r106 = this.F;
        if (r106 != null) goto L27;
        return;
    L27:
        if (r106.intValue() != 1) goto L52;
        HeadVideoStrict r107 = this.G;
        if (r107 == null) goto L35;
        String r108 = r107.getEntryDesc();
        if (r108 == null) goto L35;
        if (com.bytedance.locallife.common.utils.j.a(r108) != true) goto L35;
    L36:
        if (r103 == false) goto L53;
        com.bytedance.locallife.poi.newdetail.widget.trip.f r109 = this.K;
        if (r109 == null) goto L54;
        r109.c();
        return;
    L54:
        return;
    L53:
        return;
    L35:
        r103 = false;
        goto L36
    L52:
        return;
    L41:
        if (this.f263653k == 2) goto L43;
        return;
    L43:
        if (HostServiceUtilsKt.i0().g("poi_repo", "first_enter_head_image", false) == false) goto L45;
        i();
        return;
    L45:
        post(new e(this));
    }

    public final void i() {
        if ((!this.V.isEmpty()) == true) goto L5;
        return;
    L5:
        if (this.U == false) goto L7;
        return;
    L7:
        if (((PoiPhoto) ListProtector.get(this.V, 0)).mediaType == 0) goto L11;
        if (NetworkUtils.isWifi(getContext()) == false) goto L11;
        return;
    L11:
        if (this.S == false) goto L19;
        this.S = false;
        ViewPager2 r100 = this.f263663s;
        if (r100 == null) goto L20;
        r100.postDelayed(this.P0, 3000);
        return;
    L20:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        TripPoiHeadAdapter r100 = this.f263664t;
        if (r100 == null) goto L10;
        Iterator<Map.Entry<Integer, WeakReference<PoiHeadViewHolder>>> r101 = r100.f263535k.entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        PoiHeadViewHolder r102 = r101.next().getValue().get();
        if (r102 == null) goto L6;
        r102.onDestroy();
    L10:
        b();
    }

    public final boolean getHeadImageTagOpt() {
        return this.f263650h;
    }

    public final int getPageTopOffset() {
        return this.f263657n;
    }

    public final boolean getShowAlbumText() {
        return this.f263651i;
    }

    public TripPoiHeadWidget(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.N = new ArrayList();
        this.O = new Paint();
        this.S = true;
        this.V = new ArrayList();
        this.W = new LinkedHashSet();
        this.f263654k0 = new ArrayList();
        this.f263660p0 = new ArrayList();
        this.H0 = new ArrayList();
        this.P0 = new b(this);
        LayoutInflater.from(getContext()).inflate(R.layout.saas_poi_trip_head_image_layout, this);
        HorizontalOverScrollLayout r101 = (HorizontalOverScrollLayout) findViewById(R.id.trip_head_image_container);
        this.f263662r = r101;
        this.f263665u = (SmartImageView) findViewById(R.id.trip_head_image_view_more);
        ViewPager2 r102 = (ViewPager2) findViewById(R.id.trip_head_image_swiper);
        this.f263663s = r102;
        this.B = (FrameLayout) findViewById(R.id.trip_guide_container);
        if (r102 == null) goto L5;
        View r103 = r102.getChildAt(0);
    L7:
        if ((r103 instanceof RecyclerView) == false) goto L9;
        RecyclerView r104 = (RecyclerView) r103;
    L9:
        if (r102 == null) goto L12;
        r102.setOffscreenPageLimit(2);
    L12:
        this.f263668x = (TripPoiHeadTagsWidget) findViewById(R.id.trip_head_image_tags);
        this.f263669y = (TripPoiHeadTagsWidget) findViewById(R.id.trip_head_image_tags_video);
        this.A = (RelativeLayout) findViewById(R.id.video_check_left_container);
        this.E = findViewById(R.id.video_check_white_back_view);
        this.H = (LinearLayout) findViewById(R.id.avatar_linear);
        this.f263670z = (ConstraintLayout) findViewById(R.id.constri_video_down_container);
        DuxTextView r105 = (DuxTextView) findViewById(R.id.text_trip_video_check_in);
        this.C = r105;
        com.bytedance.locallife.poi.poidetail.container.mob.h.a(r105, 12.0f);
        this.D = (ImageView) findViewById(R.id.iv_trip_video_check_in);
        this.I = (PoiHeartbeatBadgeView) findViewById(R.id.trip_head_image_heart);
        if (r101 == null) goto L16;
        r101.setMaxOverScrollDistance(150);
        return;
    L16:
        return;
    L5:
        r103 = null;
        goto L7
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
    }

    public final void setHeadImageTagOpt(boolean r100) {
        this.f263650h = r100;
    }

    public final void setPoiEnterId(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        this.M = r100;
        return;
    }

    public final void setShowAlbumText(boolean r100) {
        this.f263651i = r100;
    }

    public TripPoiHeadWidget(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        this.N = new ArrayList();
        this.O = new Paint();
        this.S = true;
        this.V = new ArrayList();
        this.W = new LinkedHashSet();
        this.f263654k0 = new ArrayList();
        this.f263660p0 = new ArrayList();
        this.H0 = new ArrayList();
        this.P0 = new b(this);
        LayoutInflater.from(getContext()).inflate(R.layout.saas_poi_trip_head_image_layout, this);
        HorizontalOverScrollLayout r102 = (HorizontalOverScrollLayout) findViewById(R.id.trip_head_image_container);
        this.f263662r = r102;
        this.f263665u = (SmartImageView) findViewById(R.id.trip_head_image_view_more);
        ViewPager2 r103 = (ViewPager2) findViewById(R.id.trip_head_image_swiper);
        this.f263663s = r103;
        this.B = (FrameLayout) findViewById(R.id.trip_guide_container);
        if (r103 == null) goto L5;
        View r104 = r103.getChildAt(0);
    L7:
        if ((r104 instanceof RecyclerView) == false) goto L9;
        RecyclerView r105 = (RecyclerView) r104;
    L9:
        if (r103 == null) goto L12;
        r103.setOffscreenPageLimit(2);
    L12:
        this.f263668x = (TripPoiHeadTagsWidget) findViewById(R.id.trip_head_image_tags);
        this.f263669y = (TripPoiHeadTagsWidget) findViewById(R.id.trip_head_image_tags_video);
        this.A = (RelativeLayout) findViewById(R.id.video_check_left_container);
        this.E = findViewById(R.id.video_check_white_back_view);
        this.H = (LinearLayout) findViewById(R.id.avatar_linear);
        this.f263670z = (ConstraintLayout) findViewById(R.id.constri_video_down_container);
        DuxTextView r106 = (DuxTextView) findViewById(R.id.text_trip_video_check_in);
        this.C = r106;
        com.bytedance.locallife.poi.poidetail.container.mob.h.a(r106, 12.0f);
        this.D = (ImageView) findViewById(R.id.iv_trip_video_check_in);
        this.I = (PoiHeartbeatBadgeView) findViewById(R.id.trip_head_image_heart);
        if (r102 == null) goto L16;
        r102.setMaxOverScrollDistance(150);
        return;
    L16:
        return;
    L5:
        r104 = null;
        goto L7
    }

    public TripPoiHeadWidget(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        this.N = new ArrayList();
        this.O = new Paint();
        this.S = true;
        this.V = new ArrayList();
        this.W = new LinkedHashSet();
        this.f263654k0 = new ArrayList();
        this.f263660p0 = new ArrayList();
        this.H0 = new ArrayList();
        this.P0 = new b(this);
        LayoutInflater.from(getContext()).inflate(R.layout.saas_poi_trip_head_image_layout, this);
        HorizontalOverScrollLayout r103 = (HorizontalOverScrollLayout) findViewById(R.id.trip_head_image_container);
        this.f263662r = r103;
        this.f263665u = (SmartImageView) findViewById(R.id.trip_head_image_view_more);
        ViewPager2 r104 = (ViewPager2) findViewById(R.id.trip_head_image_swiper);
        this.f263663s = r104;
        this.B = (FrameLayout) findViewById(R.id.trip_guide_container);
        if (r104 == null) goto L5;
        View r105 = r104.getChildAt(0);
    L7:
        if ((r105 instanceof RecyclerView) == false) goto L9;
        RecyclerView r106 = (RecyclerView) r105;
    L9:
        if (r104 == null) goto L12;
        r104.setOffscreenPageLimit(2);
    L12:
        this.f263668x = (TripPoiHeadTagsWidget) findViewById(R.id.trip_head_image_tags);
        this.f263669y = (TripPoiHeadTagsWidget) findViewById(R.id.trip_head_image_tags_video);
        this.A = (RelativeLayout) findViewById(R.id.video_check_left_container);
        this.E = findViewById(R.id.video_check_white_back_view);
        this.H = (LinearLayout) findViewById(R.id.avatar_linear);
        this.f263670z = (ConstraintLayout) findViewById(R.id.constri_video_down_container);
        DuxTextView r107 = (DuxTextView) findViewById(R.id.text_trip_video_check_in);
        this.C = r107;
        com.bytedance.locallife.poi.poidetail.container.mob.h.a(r107, 12.0f);
        this.D = (ImageView) findViewById(R.id.iv_trip_video_check_in);
        this.I = (PoiHeartbeatBadgeView) findViewById(R.id.trip_head_image_heart);
        if (r103 == null) goto L16;
        r103.setMaxOverScrollDistance(150);
        return;
    L16:
        return;
    L5:
        r105 = null;
        goto L7
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void c(int r110, int r111, List<? extends PoiPhoto> r112, Integer r113, String r114) {
        if (r112 == null) goto L57;
        if (r113 == null) goto L57;
        if (TextUtils.isEmpty(((PoiPhoto) ListProtector.get(r112, 0)).tabId) == false) goto L10;
        int r100 = Math.min(4, r112.size());
        int r101 = 1;
    L8:
        if (r101 >= r100) goto L10;
        ((ArrayList) this.H0).add(Integer.valueOf(r101));
        r101 = r101 + 1;
    L10:
        int r102 = r112.size();
        int r103 = 0;
    L11:
        if (r103 >= r102) goto L26;
        ((ArrayList) this.V).add(ListProtector.get(r112, r103));
        ((ArrayList) this.N).add(0);
        if (r103 <= 0) goto L15;
        String r104 = ((PoiPhoto) ListProtector.get(r112, r103 - 1)).tabId;
    L17:
        if (TextUtils.isEmpty(((PoiPhoto) ListProtector.get(r112, r103)).tabName) == true) goto L25;
        if (TextUtils.equals(r104, ((PoiPhoto) ListProtector.get(r112, r103)).tabId) == true) goto L25;
        List<String> r105 = this.f263654k0;
        String r106 = ((PoiPhoto) ListProtector.get(r112, r103)).tabName;
        Intrinsics.checkNotNull(r106);
        ((ArrayList) r105).add(r106);
        if (r103 <= 0) goto L25;
        if (((ArrayList) this.H0).size() >= 3) goto L25;
        ((ArrayList) this.H0).add(Integer.valueOf(r103));
    L25:
        ((ArrayList) this.f263660p0).add(Integer.valueOf(((ArrayList) this.f263654k0).size() - 1));
        r103 = r103 + 1;
        goto L11
    L15:
        r104 = null;
        goto L17
    L26:
        ((ArrayList) this.H0).add(0);
        if (this.f263652j == true) goto L31;
        com.bytedance.locallife.poi.newdetail.widget.trip.d r107 = this.L;
        if (r107 == null) goto L31;
        r107.c(this.f263654k0);
    L31:
        TripPoiHeadTagsWidget r108 = this.f263667w;
        if (r108 == null) goto L35;
        r108.setShowAlbumText(this.f263651i);
    L35:
        TripPoiHeadTagsWidget r109 = this.f263667w;
        if (r109 == null) goto L39;
        r109.setHeadImageTagOpt(this.f263650h);
    L39:
        TripPoiHeadTagsWidget r115 = this.f263667w;
        if (r115 == null) goto L46;
        List<String> r116 = this.f263654k0;
        int r117 = r113.intValue();
        boolean r118 = this.U;
        c r119 = new c(this);
        Intrinsics.checkNotNullParameter(r116, PromotionProductPrivilegesStruct.TAGS);
        Intrinsics.checkNotNullParameter(r119, "listener");
        ArrayList r120 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r116, 10));
        Iterator r121 = ((ArrayList) r116).iterator();
    L43:
        if (r121.hasNext() == false) goto L45;
        r120.add(new com.bytedance.locallife.poi.newdetail.widget.contentplayer.i((String) r121.next()));
        goto L43
    L45:
        r115.f263589c = r118;
        r115.e(r120, r117, r114, r119, false, r118);
    L46:
        int r122 = aq6.h.f15905a;
        if (aq6.h.a(getContext()) < 2) goto L49;
        boolean r123 = true;
    L50:
        boolean r124 = this.f263652j;
        int r125 = this.f263653k;
        String r126 = this.M;
        if (r126 != null) goto L53;
        r126 = "";
    L53:
        TripPoiHeadAdapter r127 = new TripPoiHeadAdapter(r124, r125, r123, r110, r111, r126, this.K, new d(this));
        this.f263664t = r127;
        List<PoiPhoto> r128 = this.V;
        List<Integer> r129 = this.N;
        Intrinsics.checkNotNullParameter(r128, "itemList");
        Intrinsics.checkNotNullParameter(r129, "showTypeList");
        r127.f263533i = r128;
        r127.f263534j = r129;
        ViewPager2 r130 = this.f263663s;
        if (r130 == null) goto L57;
        r130.setAdapter(this.f263664t);
        goto L57
    L49:
        r123 = false;
    L57:
        ViewPager2 r131 = this.f263663s;
        if (r131 == null) goto L69;
        r131.registerOnPageChangeCallback(new TripPoiHeadWidget$initDataAndWidgets$3(this));
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        Integer r105 = this.F;
        boolean r106 = true;
        int r107 = 0;
        FrameLayout.LayoutParams r108 = null;
        if (r105 != null) goto L6;
    L100:
        ConstraintLayout r109 = this.f263670z;
        if (r109 == null) goto L104;
        r109.setVisibility(8);
    L104:
        TripPoiHeadTagsWidget r110 = this.f263668x;
        this.f263667w = r110;
        if (r110 == null) goto L108;
        r110.setVisibility(0);
    L108:
        TripPoiHeadTagsWidget r111 = this.f263667w;
        if (r111 == null) goto L111;
        ViewGroup.LayoutParams r112 = r111.getLayoutParams();
    L113:
        if ((r112 instanceof FrameLayout.LayoutParams) == false) goto L115;
        FrameLayout.LayoutParams r113 = (FrameLayout.LayoutParams) r112;
    L117:
        if (PoiBigFontExperiment.a() == false) goto L121;
        if (r113 == null) goto L124;
        float r114 = 20 * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f);
        Resources r115 = Resources.getSystem();
        r113.height = MathKt.roundToInt(TypedValue.applyDimension(1, r114, WindowDisplayMetricsOverride.apply(r115, r115.getDisplayMetrics())));
    L124:
        if (r113 == null) goto L127;
        r113.topMargin = this.f263661q;
    L127:
        TripPoiHeadTagsWidget r116 = this.f263667w;
        if (r116 == null) goto L132;
        r116.setLayoutParams(r113);
    L132:
        if (this.U == false) goto L144;
        PoiHeartbeatBadgeView r117 = this.I;
        if (r117 == null) goto L136;
        ViewGroup.LayoutParams r118 = r117.getLayoutParams();
    L138:
        if ((r118 instanceof FrameLayout.LayoutParams) == false) goto L140;
        r108 = (FrameLayout.LayoutParams) r118;
    L140:
        if (r108 == null) goto L145;
        r108.topMargin = ((this.f263661q + ((int) (UIUtils.dip2Px(getContext(), 32.0f) + 0.5f))) + ((int) xo6.b.a(12))) - r108.height;
        return;
    L145:
        return;
    L136:
        r118 = null;
        goto L138
    L144:
        return;
    L121:
        if (r113 == null) goto L124;
        r113.height = (int) xo6.b.a(20);
        goto L124
    L115:
        r113 = null;
        goto L117
    L111:
        r112 = null;
        goto L113
    L6:
        if (r105.intValue() != 1) goto L100;
        HeadVideoStrict r119 = this.G;
        if (r119 == null) goto L14;
        String r120 = r119.getEntryDesc();
        if (r120 == null) goto L14;
        if (com.bytedance.locallife.common.utils.j.a(r120) != true) goto L14;
        boolean r121 = true;
    L15:
        if (r121 == false) goto L100;
        this.f263667w = this.f263669y;
        ConstraintLayout r122 = this.f263670z;
        if (r122 == null) goto L20;
        r122.setVisibility(0);
    L20:
        TripPoiHeadTagsWidget r123 = this.f263667w;
        if (r123 == null) goto L23;
        ViewGroup.LayoutParams r124 = r123.getLayoutParams();
    L25:
        if ((r124 instanceof ConstraintLayout.LayoutParams) == false) goto L27;
        ConstraintLayout.LayoutParams r125 = (ConstraintLayout.LayoutParams) r124;
    L29:
        if (PoiBigFontExperiment.a() == false) goto L33;
        if (r125 == null) goto L36;
        float r126 = 48 * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f);
        Resources r127 = Resources.getSystem();
        ((ViewGroup.MarginLayoutParams) r125).height = MathKt.roundToInt(TypedValue.applyDimension(1, r126, WindowDisplayMetricsOverride.apply(r127, r127.getDisplayMetrics())));
    L36:
        TripPoiHeadTagsWidget r128 = this.f263667w;
        if (r128 == null) goto L40;
        r128.setLayoutParams(r125);
    L40:
        ConstraintLayout r129 = this.f263670z;
        if (r129 == null) goto L43;
        ViewGroup.LayoutParams r130 = r129.getLayoutParams();
    L45:
        if ((r130 instanceof FrameLayout.LayoutParams) == false) goto L47;
        FrameLayout.LayoutParams r131 = (FrameLayout.LayoutParams) r130;
    L49:
        if (r131 == null) goto L52;
        r131.topMargin = this.f263661q - ((int) xo6.b.a(28));
    L52:
        ConstraintLayout r132 = this.f263670z;
        if (r132 == null) goto L56;
        r132.setLayoutParams(r131);
    L56:
        float r133 = xo6.b.a(118);
        HeadVideoStrict r134 = this.G;
        if (r134 == null) goto L59;
        String r135 = r134.getEntryDesc();
    L60:
        if (r135 != null) goto L62;
    L65:
        if (r106 == true) goto L67;
        this.O.setTextSize(UIUtils.sp2px(getContext(), 12) + 0.5f);
        r107 = (int) this.O.measureText(r135);
    L67:
        float r136 = r133 + r107;
        RelativeLayout r137 = this.A;
        if (r137 == null) goto L70;
        ViewGroup.LayoutParams r138 = r137.getLayoutParams();
    L72:
        if ((r138 instanceof ConstraintLayout.LayoutParams) == false) goto L74;
        ConstraintLayout.LayoutParams r139 = (ConstraintLayout.LayoutParams) r138;
    L75:
        if (r139 == null) goto L78;
        ((ViewGroup.MarginLayoutParams) r139).width = (int) r136;
    L78:
        if (r139 == null) goto L81;
        ((ViewGroup.MarginLayoutParams) r139).topMargin = (int) xo6.b.a(28);
    L81:
        RelativeLayout r140 = this.A;
        if (r140 == null) goto L85;
        r140.setLayoutParams(r139);
    L85:
        View r141 = this.E;
        if (r141 == null) goto L88;
        ViewGroup.LayoutParams r142 = r141.getLayoutParams();
    L90:
        if ((r142 instanceof LinearLayout.LayoutParams) == false) goto L92;
        LinearLayout.LayoutParams r143 = (LinearLayout.LayoutParams) r142;
    L93:
        if (r143 == null) goto L96;
        r143.width = (int) (r136 - xo6.b.a(56));
    L96:
        View r144 = this.E;
        if (r144 == null) goto L132;
        r144.setLayoutParams(r143);
        goto L132
    L92:
        r143 = null;
        goto L93
    L88:
        r142 = null;
        goto L90
    L74:
        r139 = null;
        goto L75
    L70:
        r138 = null;
        goto L72
    L62:
        if (r135.length() == 0) goto L65;
        r106 = false;
        goto L65
    L59:
        r135 = null;
        goto L60
    L47:
        r131 = null;
        goto L49
    L43:
        r130 = null;
        goto L45
    L33:
        if (r125 == null) goto L36;
        ((ViewGroup.MarginLayoutParams) r125).height = (int) xo6.b.a(48);
        goto L36
    L27:
        r125 = null;
        goto L29
    L23:
        r124 = null;
    L14:
        r121 = false;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0, types: [android.widget.FrameLayout, com.bytedance.locallife.poi.newdetail.widget.trip.TripPoiHeadWidget] */
    /* JADX WARN: Type inference failed for: r25v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v3 */
    public final void h(boolean r110, int r111, int r112, List<? extends PoiPhoto> r210, Integer r211, HeadVideoStrict r212, Integer r213, com.bytedance.locallife.poi.newdetail.widget.contentplayer.b r214, com.bytedance.locallife.poi.newdetail.widget.trip.f r215, com.bytedance.locallife.poi.newdetail.widget.trip.d r216, PoiBundle r217) {
        Intrinsics.checkNotNullParameter(r215, "headCallback");
        Intrinsics.checkNotNullParameter(r216, "tagsCallback");
        this.f263658o = r217;
        AttributeSet r100 = null;
        boolean r113 = true;
        if (HostServiceUtilsKt.h().b(AbilityEnum.VIDEO_PLAY_SERVICE) == false) goto L5;
        ?? r101 = r210;
    L16:
        this.f263657n = r111;
        this.K = r215;
        this.L = r216;
        this.F = r213;
        this.G = r212;
        this.f263649J = r214;
        if (r214 == null) goto L22;
        if (r214.d() == null) goto L22;
        this.U = true;
    L22:
        if (r110 == false) goto L24;
        this.f263653k = 0;
        this.f263652j = true;
    L27:
        int r102 = (int) UIUtils.dip2Px(getContext(), 12.0f);
        if (this.f263653k != 2) goto L30;
        int r103 = r112 + r102;
    L31:
        ViewGroup.LayoutParams r114 = getLayoutParams();
        if (r114 == null) goto L34;
        r114.height = r103;
        setLayoutParams(r114);
    L34:
        int r104 = this.f263653k;
        if (r104 != 1) goto L37;
        this.f263653k = 1;
        this.f263655l = r102 + r111;
    L42:
        HorizontalOverScrollLayout r105 = this.f263662r;
        if (r105 == null) goto L46;
        r105.setListener(new p(this));
    L46:
        int r106 = r111 - ((int) UIUtils.dip2Px(getContext(), 32.0f));
        this.f263659p = r106;
        this.f263661q = r106;
        if (r213 != null) goto L50;
    L139:
        ConstraintLayout r107 = this.f263670z;
        if (r107 == null) goto L143;
        r107.setVisibility(8);
    L143:
        TripPoiHeadTagsWidget r108 = this.f263668x;
        this.f263667w = r108;
        if (r108 == null) goto L147;
        r108.setVisibility(0);
    L147:
        c(r111, r112, r101, r211, null);
    L148:
        u r109 = df6.q.e("https://lf3-static.bytednsdoc.com/obj/eden-cn/fvyeh7pflpxbvg/ic_bounce_goto.png");
        r109.f468294t = this.f263665u;
        r109.c();
        this.f263666v = com.bytedance.locallife.biz.common.utils.e.b() + ((int) UIUtils.dip2Px(getContext(), 8.0f));
        if (this.U == false) goto L220;
        com.bytedance.locallife.poi.newdetail.widget.contentplayer.b r115 = this.f263649J;
        if (r115 != null) goto L153;
    L204:
        Unit r116 = null;
    L205:
        if (r116 != null) goto L221;
        PoiHeartbeatBadgeView r117 = this.I;
        if (r117 == null) goto L222;
        r117.setVisibility(8);
        return;
    L222:
        return;
    L221:
        return;
    L153:
        if (r115.d() != null) goto L155;
    L157:
        r113 = false;
    L158:
        if (r113 == true) goto L161;
        r115 = null;
    L161:
        if (r115 == null) goto L204;
        PoiHeartbeatBadgeView r118 = this.I;
        if (r118 == null) goto L165;
        String r119 = r115.d();
        Intrinsics.checkNotNull(r119);
        String r120 = r115.c();
        Intrinsics.checkNotNull(r120);
        r118.a(r119, r120);
        r118.setVisibility(0);
    L165:
        int r121 = com.bytedance.locallife.poi.utils.c.f264233a;
        PoiBundle r122 = this.f263658o;
        com.bytedance.locallife.poi.newdetail.widget.contentplayer.b r123 = this.f263649J;
        if (r123 == null) goto L168;
        Map<String, String> r124 = r123.a();
    L169:
        int r125 = com.bytedance.locallife.biz.mob.a.f256703c;
        mq6.c r126 = new mq6.c();
        if (r122 == null) goto L172;
        String r127 = r122.poiId;
    L173:
        mq6.a r128 = mq6.c.a.f514894a;
        r126.g("poi_id", r127);
        if (r122 == null) goto L176;
        String r129 = r122.enterId;
    L177:
        r126.g("poi_enter_id", r129);
        if (r122 == null) goto L180;
        String r130 = r122.from;
    L181:
        r126.g("poi_enter_page", r130);
        if (r122 == null) goto L184;
        String r131 = r122.enterMethod;
    L185:
        r126.g(BdpAppEventConstant.PARAMS_POI_ENTER_METHOD, r131);
        if (r122 == null) goto L188;
        String r132 = r122.backendType;
    L189:
        r126.g("poi_backend_type", r132);
        if (r122 == null) goto L192;
        Boolean r133 = r122.poiDeviceSameCity;
    L193:
        r126.c("poi_device_samecity", r133);
        com.bytedance.locallife.poi.utils.c.a(r122, r126);
        if (r124 == null) goto L196;
        r126.f(r124);
    L196:
        Unit r134 = Unit.INSTANCE;
        com.bytedance.locallife.biz.mob.a.C3646a.c("life_poi_leaderboard_award_show", r126.f514893a);
        if (Intrinsics.areEqual(r115.b(), Boolean.FALSE) == false) goto L201;
        PoiHeartbeatBadgeView r135 = this.I;
        if (r135 == null) goto L201;
        r135.f263313d.setVisibility(8);
    L201:
        PoiHeartbeatBadgeView r136 = this.I;
        if (r136 == null) goto L204;
        r136.setOnClickListener(new q(r136, r115, this));
        r116 = Unit.INSTANCE;
        goto L205
    L192:
        r133 = null;
        goto L193
    L188:
        r132 = null;
        goto L189
    L184:
        r131 = null;
        goto L185
    L180:
        r130 = null;
        goto L181
    L176:
        r129 = null;
        goto L177
    L172:
        r127 = null;
        goto L173
    L168:
        r124 = null;
        goto L169
    L155:
        if (r115.c() == null) goto L157;
    L220:
        return;
    L50:
        if (r213.intValue() != 1) goto L139;
        if (r212 == null) goto L57;
        String r137 = r212.getEntryDesc();
        if (r137 == null) goto L57;
        if (com.bytedance.locallife.common.utils.j.a(r137) != true) goto L57;
        boolean r138 = true;
    L58:
        if (r138 == false) goto L139;
        this.f263667w = this.f263669y;
        ConstraintLayout r139 = this.f263670z;
        if (r139 == null) goto L63;
        r139.setVisibility(0);
    L63:
        if (r212 == null) goto L65;
        String r140 = r212.getEntryDesc();
    L66:
        c(r111, r112, r101, r211, r140);
        if (r212 == null) goto L133;
        if (r212.getAvatarList() == null) goto L133;
        RoundingParams r141 = RoundingParams.fromCornersRadius(5.0f);
        r141.setRoundAsCircle(true);
        List<String> r142 = r212.getAvatarList();
        if (r142 == null) goto L74;
        int r143 = r142.size();
    L75:
        int r144 = 3;
        if (r143 >= 3) goto L81;
        List<String> r145 = r212.getAvatarList();
        if (r145 == null) goto L82;
        r144 = r145.size();
        goto L81
    L82:
        int r146 = 0;
        r144 = 0;
    L83:
        if (r146 >= r144) goto L118;
        List<String> r147 = r212.getAvatarList();
        if (r147 == null) goto L87;
        ?? r148 = (String) ListProtector.get(r147, (r144 - r146) - 1);
    L88:
        SmartImageView r149 = new SmartImageView(getContext());
        RoundRelativeLayout r150 = new RoundRelativeLayout(getContext(), r100, 6, 0);
        r150.setRadius((int) xo6.b.a(24));
        r150.setBackgroundColor(-1);
        ((GenericDraweeHierarchy) r149.getHierarchy()).setRoundingParams(r141);
        rp6.a.b(r149, r148, (int) xo6.b.a(20), (int) xo6.b.a(20));
        r150.addView(r149);
        LinearLayout r151 = this.H;
        if (r151 == null) goto L91;
        r151.addView(r150);
    L91:
        ViewGroup.LayoutParams r152 = r150.getLayoutParams();
        if ((r152 instanceof LinearLayout.LayoutParams) == false) goto L94;
        LinearLayout.LayoutParams r153 = (LinearLayout.LayoutParams) r152;
    L95:
        if (r153 == null) goto L98;
        r153.width = (int) xo6.b.a(24);
    L98:
        if (r153 == null) goto L101;
        r153.height = (int) xo6.b.a(24);
    L101:
        if (r146 == 0) goto L105;
        if (r153 == null) goto L105;
        r153.setMarginStart((int) xo6.b.a(-10));
    L105:
        r150.setLayoutParams(r153);
        ViewGroup.LayoutParams r154 = r149.getLayoutParams();
        if ((r154 instanceof RelativeLayout.LayoutParams) == false) goto L108;
        RelativeLayout.LayoutParams r155 = (RelativeLayout.LayoutParams) r154;
    L109:
        if (r155 == null) goto L111;
        r155.addRule(13);
    L111:
        if (r155 == null) goto L114;
        r155.width = (int) xo6.b.a(20);
    L114:
        if (r155 == null) goto L117;
        r155.height = (int) xo6.b.a(20);
    L117:
        r149.setLayoutParams(r155);
        r146 = r146 + 1;
        r100 = null;
        goto L83
    L108:
        r155 = null;
        goto L109
    L94:
        r153 = null;
        goto L95
    L87:
        r148 = r100;
        goto L88
    L118:
        DuxTextView r156 = this.C;
        if (r156 == null) goto L127;
        String r157 = r212.getEntryDesc();
        if (r157 != null) goto L125;
        r157 = "";
    L125:
        r156.setText(r157);
    L127:
        if (PoiSaaSUtils.a() == false) goto L133;
        ImageView r158 = this.D;
        if (r158 == null) goto L133;
        r158.setVisibility(8);
    L81:
        r146 = 0;
        goto L83
    L74:
        r143 = 0;
    L133:
        if (PoiSaaSUtils.a() == true) goto L137;
        RelativeLayout r159 = this.A;
        if (r159 == null) goto L137;
        r159.setOnClickListener(new f(r215));
    L137:
        if (r110 == true) goto L148;
        r215.c();
        goto L148
    L65:
        r140 = null;
    L57:
        r138 = false;
        goto L58
    L37:
        if (r104 != 2) goto L42;
        this.f263653k = 2;
        int r160 = (r111 - r112) / 2;
        this.f263656m = r160;
        HorizontalOverScrollLayout r161 = this.f263662r;
        if (r161 == null) goto L42;
        r161.setTranslationY(r160);
        goto L42
    L30:
        r103 = r111 + r102;
        goto L31
    L24:
        if (r112 <= 0) goto L26;
        this.f263653k = 2;
        goto L27
    L26:
        this.f263653k = 1;
        goto L27
    L5:
        if (r210 == null) goto L15;
        r101 = new ArrayList();
        Iterator r162 = r210.iterator();
    L8:
        if (r162.hasNext() == false) goto L16;
        Object r163 = r162.next();
        if (((PoiPhoto) r163).mediaType == 1) goto L12;
        boolean r164 = true;
    L13:
        if (r164 == false) goto L8;
        r101.add(r163);
        goto L8
    L12:
        r164 = false;
        goto L13
    L15:
        r101 = 0;
        goto L16
    }
}
