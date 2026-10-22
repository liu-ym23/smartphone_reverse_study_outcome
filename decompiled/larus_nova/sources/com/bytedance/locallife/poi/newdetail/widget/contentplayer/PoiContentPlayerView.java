package com.bytedance.locallife.poi.newdetail.widget.contentplayer;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.lighten.loader.SmartImageView;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.dito.core.BaseDitoView;
import com.bytedance.locallife.dito.core.DitoFragment;
import com.bytedance.locallife.dito.core.viewmodel.DitoDataCenter;
import com.bytedance.locallife.dito.core.viewmodel.DitoViewModel;
import com.bytedance.locallife.dito.interact.AbstractInteractBehavior;
import com.bytedance.locallife.dito.interact.BounceExpandBehavior;
import com.bytedance.locallife.dito.interact.CustomBottomBehavior;
import com.bytedance.locallife.dito.interact.HeadUnfoldState;
import com.bytedance.locallife.poi.experiment.PoiBigFontExperiment;
import com.bytedance.locallife.poi.newdetail.widget.PoiHeartbeatBadgeView;
import com.bytedance.locallife.poi.newdetail.widget.trip.NestedScrollFrameLayout;
import com.bytedance.locallife.poi.newdetail.widget.trip.PoiHeadViewHolder;
import com.bytedance.locallife.poi.newdetail.widget.trip.TripPoiHeadTagsWidget;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.dito.poi.player.ui.HorizontalOverScrollLayout;
import com.ss.android.ugc.aweme.poi.model.PoiPhoto;
import df6.q;
import df6.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB\u0019\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\t\u0010\rB!\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u0006\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/widget/contentplayer/PoiContentPlayerView;", "Lcom/bytedance/locallife/poi/newdetail/widget/trip/NestedScrollFrameLayout;", "", "getCurrentWindowWidth", "Lcom/bytedance/locallife/poi/newdetail/widget/contentplayer/c;", "getContentClickCallback", "getPageTopOffset", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiContentPlayerView extends NestedScrollFrameLayout {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public String E;
    public boolean F;
    public final List<Integer> G;
    public final PoiHeartbeatBadgeView H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public com.bytedance.locallife.poi.newdetail.widget.contentplayer.b f263389J;
    public final b K;
    public final c L;
    public final d M;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f263390h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BaseDitoView<?> f263391i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f263392j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f263393k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<i> f263394l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f263395m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final TripPoiHeadTagsWidget f263396n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ViewPager2 f263397o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public PoiContentPlayerAdapter f263398p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ConstraintLayout f263399q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final SmartImageView f263400r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final HorizontalOverScrollLayout f263401s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final RelativeLayout f263402t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f263403u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f263404v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f263405w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f263406x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public com.bytedance.locallife.poi.newdetail.widget.contentplayer.d f263407y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Set<Integer> f263408z;

    public static final class a implements com.bytedance.locallife.poi.newdetail.widget.contentplayer.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiContentPlayerView f263409a;

        public a(PoiContentPlayerView r100) {
            this.f263409a = r100;
        }

        @Override // com.bytedance.locallife.poi.newdetail.widget.contentplayer.c
        public final void b(i r100) {
            Intrinsics.checkNotNullParameter(r100, "itemData");
            com.bytedance.locallife.poi.newdetail.widget.contentplayer.d r101 = this.f263409a.f263407y;
            if (r101 == null) goto L6;
            r101.b(r100);
            return;
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiContentPlayerView f263410a;

        public b(PoiContentPlayerView r100) {
            this.f263410a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            JSONObject r101 = (JSONObject) r100;
            String r102 = r101.optString("tab_id");
            int r103 = r101.optInt("inner_index");
            if (Intrinsics.areEqual(r101.optString("action"), "slide") == false) goto L12;
            PoiContentPlayerView r104 = this.f263410a;
            if (r104.C == true) goto L12;
            List<i> r105 = r104.f263394l;
            if (r105 == null) goto L11;
            com.bytedance.locallife.poi.newdetail.widget.contentplayer.d r106 = r104.f263407y;
            if (r106 == null) goto L11;
            r106.g(r104.f263405w, r105);
        L11:
            this.f263410a.C = true;
        L12:
            List<i> r107 = this.f263410a.f263394l;
            BounceExpandBehavior r108 = null;
            if (r107 == null) goto L22;
            Iterator<T> r109 = r107.iterator();
        L16:
            if (r109.hasNext() == false) goto L20;
            T r110 = r109.next();
            if (Intrinsics.areEqual(((i) r110).c(), r102) == false) goto L16;
        L21:
            i r111 = r110;
        L23:
            if (r111 == null) goto L25;
            r111.f263427b = r103 + 1;
        L25:
            this.f263410a.i(false);
            BaseDitoView<?> r112 = this.f263410a.f263391i;
            if (r112 == null) goto L32;
            DitoViewModel r113 = r112.getDitoViewModel();
            if (r113 == null) goto L32;
            DitoFragment r114 = r113.f258035a;
            if (r114 == null) goto L32;
            AbstractInteractBehavior<? extends View> r115 = r114.Da0();
        L34:
            if ((r115 instanceof CustomBottomBehavior) == false) goto L36;
            CustomBottomBehavior r116 = (CustomBottomBehavior) r115;
        L37:
            if (r116 == null) goto L60;
            PoiContentPlayerView r117 = this.f263410a;
            HeadUnfoldState r118 = r116.B;
            HeadUnfoldState r119 = HeadUnfoldState.STATE_HEAD_UNFOLD;
            if (r118 == r119) goto L60;
            r117.F = true;
            BaseDitoView<?> r120 = r117.f263391i;
            if (r120 == null) goto L48;
            DitoViewModel r121 = r120.getDitoViewModel();
            if (r121 == null) goto L48;
            DitoFragment r122 = r121.f258035a;
            if (r122 == null) goto L48;
            AbstractInteractBehavior<? extends View> r123 = r122.Da0();
        L50:
            if ((r123 instanceof CustomBottomBehavior) == false) goto L52;
            CustomBottomBehavior r124 = (CustomBottomBehavior) r123;
        L53:
            if (r124 == null) goto L55;
            HeadUnfoldState r125 = r124.B;
        L56:
            if (r125 != r119) goto L58;
            int r126 = 9;
        L59:
            r117.b(Integer.valueOf(r126));
            r116.k();
            goto L60
        L58:
            r126 = 6;
            goto L59
        L55:
            r125 = null;
            goto L56
        L52:
            r124 = null;
        L48:
            r123 = null;
        L60:
            BaseDitoView<?> r127 = this.f263410a.f263391i;
            if (r127 == null) goto L67;
            DitoViewModel r128 = r127.getDitoViewModel();
            if (r128 == null) goto L67;
            DitoFragment r129 = r128.f258035a;
            if (r129 == null) goto L67;
            AbstractInteractBehavior<? extends View> r130 = r129.Da0();
        L69:
            if ((r130 instanceof BounceExpandBehavior) == false) goto L71;
            r108 = (BounceExpandBehavior) r130;
        L71:
            if (r108 == null) goto L73;
            r108.k();
        L73:
            PoiContentPlayerView r131 = this.f263410a;
            if (r131.D == false) goto L76;
            return;
        L76:
            if (Intrinsics.areEqual(r131.E, "click") == true) goto L78;
            this.f263410a.E = "slide";
        L78:
            PoiContentPlayerView r132 = this.f263410a;
            List<i> r133 = r132.f263394l;
            if (r133 == null) goto L83;
            com.bytedance.locallife.poi.newdetail.widget.contentplayer.d r134 = r132.f263407y;
            if (r134 == null) goto L83;
            r134.h(r132.E, (i) ListProtector.get(r133, r132.f263406x));
        L83:
            this.f263410a.D = true;
            return;
        L67:
            r130 = null;
            goto L69
        L36:
            r116 = null;
        L32:
            r115 = null;
            goto L34
        L20:
            r110 = (T) null;
            goto L21
        L22:
            r111 = null;
            goto L23
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiContentPlayerView f263411a;

        public c(PoiContentPlayerView r100) {
            this.f263411a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            String r101 = ((JSONObject) r100).optString("muted", "0");
            PoiContentPlayerAdapter r102 = this.f263411a.f263398p;
            if (r102 == null) goto L5;
            r102.y2(Intrinsics.areEqual(r101, "1"));
        L5:
            this.f263411a.f263396n.setVideoMuteRes(Intrinsics.areEqual(r101, "1"));
            HostServiceUtilsKt.i0().d("poi_repo", "poi_head_video_play_mute_status", Intrinsics.areEqual(r101, "1"));
        }
    }

    public static final class d implements com.bytedance.locallife.poi.newdetail.widget.trip.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiContentPlayerView f263412a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ PoiContentPlayerView f263413a;

            public a(PoiContentPlayerView r100) {
                this.f263413a = r100;
            }

            public final void a() {
                BaseDitoView<?> r100 = this.f263413a.f263391i;
                HeadUnfoldState r101 = null;
                if (r100 == null) goto L9;
                DitoViewModel r102 = r100.getDitoViewModel();
                if (r102 == null) goto L9;
                DitoFragment r103 = r102.f258035a;
                if (r103 == null) goto L9;
                AbstractInteractBehavior<? extends View> r104 = r103.Da0();
            L11:
                if ((r104 instanceof BounceExpandBehavior) == false) goto L13;
                BounceExpandBehavior r105 = (BounceExpandBehavior) r104;
            L14:
                if (r105 == null) goto L16;
                r105.k();
            L16:
                BaseDitoView<?> r106 = this.f263413a.f263391i;
                if (r106 == null) goto L23;
                DitoViewModel r107 = r106.getDitoViewModel();
                if (r107 == null) goto L23;
                DitoFragment r108 = r107.f258035a;
                if (r108 == null) goto L23;
                AbstractInteractBehavior<? extends View> r109 = r108.Da0();
            L25:
                if ((r109 instanceof CustomBottomBehavior) == false) goto L27;
                CustomBottomBehavior r110 = (CustomBottomBehavior) r109;
            L28:
                if (r110 == null) goto L51;
                PoiContentPlayerView r111 = this.f263413a;
                HeadUnfoldState r112 = r110.B;
                HeadUnfoldState r113 = HeadUnfoldState.STATE_HEAD_UNFOLD;
                if (r112 == r113) goto L52;
                r111.F = true;
                BaseDitoView<?> r114 = r111.f263391i;
                if (r114 == null) goto L39;
                DitoViewModel r115 = r114.getDitoViewModel();
                if (r115 == null) goto L39;
                DitoFragment r116 = r115.f258035a;
                if (r116 == null) goto L39;
                AbstractInteractBehavior<? extends View> r117 = r116.Da0();
            L41:
                if ((r117 instanceof CustomBottomBehavior) == false) goto L43;
                CustomBottomBehavior r118 = (CustomBottomBehavior) r117;
            L44:
                if (r118 == null) goto L46;
                r101 = r118.B;
            L46:
                if (r101 != r113) goto L48;
                int r119 = 9;
            L49:
                r111.b(Integer.valueOf(r119));
                r110.k();
                return;
            L48:
                r119 = 6;
                goto L49
            L43:
                r118 = null;
            L39:
                r117 = null;
                goto L41
            L52:
                return;
            L51:
                return;
            L27:
                r110 = null;
            L23:
                r109 = null;
                goto L25
            L13:
                r105 = null;
            L9:
                r104 = null;
                goto L11
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

        @Override // com.bytedance.locallife.poi.newdetail.widget.trip.d
        public final void c(List<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "tabs");
        }

        @Override // com.bytedance.locallife.poi.newdetail.widget.trip.d
        public final void a() {
            PoiContentPlayerView r100 = this.f263412a;
            List<i> r101 = r100.f263394l;
            if (r101 == null) goto L8;
            com.bytedance.locallife.poi.newdetail.widget.contentplayer.d r102 = r100.f263407y;
            if (r102 == null) goto L9;
            r102.j(r100.f263405w, r101);
            return;
        L9:
            return;
        }

        @Override // com.bytedance.locallife.poi.newdetail.widget.trip.d
        public final void b() {
            PoiContentPlayerView r100 = this.f263412a;
            if (r100.B == false) goto L5;
            return;
        L5:
            r100.B = true;
            List<i> r101 = r100.f263394l;
            if (r101 == null) goto L11;
            com.bytedance.locallife.poi.newdetail.widget.contentplayer.d r102 = r100.f263407y;
            if (r102 == null) goto L12;
            r102.i(r100.f263405w, r101);
            return;
        L12:
            return;
        }

        public d(PoiContentPlayerView r100) {
            this.f263412a = r100;
        }

        @Override // com.bytedance.locallife.poi.newdetail.widget.trip.d
        public final void d(boolean r100, boolean r101) {
            PoiContentPlayerAdapter r102 = this.f263412a.f263398p;
            if (r102 == null) goto L5;
            r102.y2(r100);
        L5:
            PoiContentPlayerView r103 = this.f263412a;
            List<i> r104 = r103.f263394l;
            if (r104 == null) goto L11;
            com.bytedance.locallife.poi.newdetail.widget.contentplayer.d r105 = r103.f263407y;
            if (r105 == null) goto L12;
            r105.f(r103.f263405w, r104, r100, r101);
            return;
        L12:
            return;
        }

        @Override // com.bytedance.locallife.poi.newdetail.widget.trip.d
        public final void e(List<i> r100, int r101, int r102) {
            PoiContentPlayerView r103 = this.f263412a;
            r103.E = "click";
            r103.f263397o.setCurrentItem(r102, false);
            PoiContentPlayerView r104 = this.f263412a;
            List<i> r105 = r104.f263394l;
            if (r105 == null) goto L7;
            com.bytedance.locallife.poi.newdetail.widget.contentplayer.d r106 = r104.f263407y;
            if (r106 == null) goto L7;
            r106.d(r102, r105);
        L7:
            PoiContentPlayerView r107 = this.f263412a;
            if (r107.f263406x == r102) goto L11;
            r107.f263406x = r102;
            r107.post(new a(r107));
            return;
        }
    }

    private final com.bytedance.locallife.poi.newdetail.widget.contentplayer.c getContentClickCallback() {
        return new a(this);
    }

    private final int getCurrentWindowWidth() {
        int r100 = com.bytedance.locallife.poi.newdetail.h.f263265d;
        if (r100 == 0) goto L6;
        return r100;
    L6:
        return com.bytedance.locallife.biz.common.utils.e.b();
    }

    public final void c() {
        PoiContentPlayerAdapter r100 = this.f263398p;
        if (r100 == null) goto L10;
        Iterator<Map.Entry<Integer, WeakReference<PoiHeadViewHolder>>> r101 = r100.f263361r.entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        PoiHeadViewHolder r102 = r101.next().getValue().get();
        if (r102 == null) goto L6;
        r102.Y3();
    L10:
        this.f263396n.c();
    }

    public final void d() {
        PoiContentPlayerAdapter r100 = this.f263398p;
        if (r100 == null) goto L10;
        Iterator<Map.Entry<Integer, WeakReference<PoiHeadViewHolder>>> r101 = r100.f263361r.entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        PoiHeadViewHolder r102 = r101.next().getValue().get();
        if (r102 == null) goto L6;
        r102.Z3();
    L10:
        TripPoiHeadTagsWidget r103 = this.f263396n;
        r103.getClass();
        boolean r104 = HostServiceUtilsKt.i0().g("poi_repo", "poi_head_video_play_mute_status", true);
        r103.f263610x = r104;
        r103.setVideoMuteRes(r104);
    }

    public final void f() {
        PoiContentPlayerAdapter r100 = this.f263398p;
        if (r100 == null) goto L10;
        Iterator<Map.Entry<Integer, WeakReference<PoiHeadViewHolder>>> r101 = r100.f263361r.entrySet().iterator();
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
        PoiContentPlayerAdapter r100 = this.f263398p;
        if (r100 == null) goto L10;
        Iterator<Map.Entry<Integer, WeakReference<PoiHeadViewHolder>>> r101 = r100.f263361r.entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        PoiHeadViewHolder r102 = r101.next().getValue().get();
        if (r102 == null) goto L6;
        r102.c4();
    L10:
        List<i> r103 = this.f263394l;
        if (r103 != null) goto L13;
        return;
    L13:
        if (this.A == true) goto L25;
        com.bytedance.locallife.poi.newdetail.widget.contentplayer.d r104 = this.f263407y;
        if (r104 == null) goto L17;
        r104.c(r103);
    L17:
        this.A = true;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        PoiContentPlayerAdapter r100 = this.f263398p;
        if (r100 == null) goto L10;
        Iterator<Map.Entry<Integer, WeakReference<PoiHeadViewHolder>>> r101 = r100.f263361r.entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L16;
        PoiHeadViewHolder r102 = r101.next().getValue().get();
        if (r102 == null) goto L6;
        r102.onDestroy();
        goto L6
    L16:
        return;
    }

    public final int getPageTopOffset() {
        return this.f263392j;
    }

    public PoiContentPlayerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f263395m = 2;
        this.f263405w = -1;
        this.f263408z = new LinkedHashSet();
        this.E = "pull_down";
        this.G = new ArrayList();
        LayoutInflater.from(getContext()).inflate(R.layout.saas_poi_layout_content_player, this);
        this.f263396n = (TripPoiHeadTagsWidget) findViewById(R.id.poi_content_player_tags);
        this.f263397o = (ViewPager2) findViewById(R.id.content_view_pager);
        this.f263399q = (ConstraintLayout) findViewById(R.id.content_tags_container);
        this.f263400r = (SmartImageView) findViewById(R.id.content_view_more);
        this.f263402t = (RelativeLayout) findViewById(R.id.content_view_more_container);
        HorizontalOverScrollLayout r101 = (HorizontalOverScrollLayout) findViewById(R.id.content_swiper_container);
        this.f263401s = r101;
        if (r101 == null) goto L5;
        r101.setMaxOverScrollDistance(150);
    L5:
        this.H = (PoiHeartbeatBadgeView) findViewById(R.id.head_image_heart);
        this.K = new b(this);
        this.L = new c(this);
        this.M = new d(this);
    }

    public final void b(Integer r100) {
        PoiContentPlayerAdapter r101 = this.f263398p;
        if (r101 == null) goto L16;
        if (r100 != null) goto L7;
    L9:
        int r102 = 1;
    L10:
        r101.f263360q = r102;
        Iterator<Map.Entry<Integer, WeakReference<PoiHeadViewHolder>>> r103 = r101.f263361r.entrySet().iterator();
    L12:
        if (r103.hasNext() == false) goto L16;
        PoiHeadViewHolder r104 = r103.next().getValue().get();
        if (r104 == null) goto L12;
        r104.a4(r101.f263356m, r101.f263360q);
        goto L12
    L7:
        if (r100.intValue() != 9) goto L9;
        r102 = 2;
    L16:
        if (r100 == null) goto L21;
        PoiHeartbeatBadgeView r105 = this.H;
        if (r105 == null) goto L21;
        r105.b(r100.intValue());
    L21:
        if (this.D == true) goto L38;
        if (r100 != null) goto L25;
        return;
    L25:
        if (r100.intValue() != 9) goto L39;
        List<i> r106 = this.f263394l;
        if (r106 == null) goto L31;
        com.bytedance.locallife.poi.newdetail.widget.contentplayer.d r107 = this.f263407y;
        if (r107 == null) goto L31;
        r107.h(this.E, (i) ListProtector.get(r106, this.f263406x));
    L31:
        this.D = true;
        return;
    L39:
        return;
    }

    public final void e(int r100) {
        boolean r101 = this.f263390h;
        if (r101 == true) goto L5;
    L8:
        if (r101 == true) goto L10;
    L11:
        if (r101 == true) goto L16;
    L12:
        if (r100 <= 0) goto L14;
        return;
    L14:
        if (this.f263395m != 0) goto L16;
        return;
    L16:
        ConstraintLayout r102 = this.f263399q;
        ViewGroup.LayoutParams r103 = null;
        if (r102 == null) goto L26;
        this.f263404v = this.f263403u - r100;
        ViewGroup.LayoutParams r104 = r102.getLayoutParams();
        if ((r104 instanceof FrameLayout.LayoutParams) == false) goto L21;
        FrameLayout.LayoutParams r105 = (FrameLayout.LayoutParams) r104;
    L22:
        if (r105 == null) goto L25;
        r105.topMargin = this.f263404v;
    L25:
        r102.setLayoutParams(r105);
        goto L26
    L21:
        r105 = null;
    L26:
        PoiContentPlayerAdapter r106 = this.f263398p;
        if (r106 == null) goto L35;
        Iterator<Map.Entry<Integer, WeakReference<PoiHeadViewHolder>>> r107 = r106.f263361r.entrySet().iterator();
    L30:
        if (r107.hasNext() == false) goto L34;
        PoiHeadViewHolder r108 = r107.next().getValue().get();
        if (r108 == null) goto L30;
        r108.a4(r100, r106.f263360q);
        goto L30
    L34:
        int r109 = r106.f263348e - r100;
        r106.f263355l = r109;
        r106.f263356m = r100;
        HashMap<String, Object> r110 = r106.f263363t;
        r110.put("height", Integer.valueOf(com.bytedance.locallife.dito.utils.e.d(Integer.valueOf(r109)) + 12));
        r110.put("style_mode", Integer.valueOf(r106.f263360q));
        r110.put("session_id", r106.f263351h);
        r110.put("tab_id", r106.f263359p);
        r110.put("should_reset", 0);
        yn6.c r111 = yn6.a.f568561a;
        yn6.a.f(r106.f263351h, r106.f263363t, "poi_header");
    L35:
        RelativeLayout r112 = this.f263402t;
        if (r112 == null) goto L38;
        r103 = r112.getLayoutParams();
    L38:
        if (r103 == null) goto L41;
        r103.height = (int) (this.f263404v + xo6.b.a(47));
    L41:
        RelativeLayout r113 = this.f263402t;
        if (r113 == null) goto L52;
        r113.setLayoutParams(r103);
        return;
    L52:
        return;
    L10:
        if (this.F == false) goto L12;
    L5:
        if (this.F == false) goto L8;
        if (r100 != 0) goto L8;
        this.F = false;
        goto L8
    }

    public final void i(boolean r100) {
        List<i> r101 = this.f263394l;
        if (r101 == null) goto L46;
        if (r100 == false) goto L44;
        float r102 = (float) (((double) getCurrentWindowWidth()) * 0.9d);
        List<i> r103 = this.f263394l;
        boolean r104 = true;
        if (r103 == null) goto L17;
        i r105 = (i) ListProtector.get(r103, 0);
        if (r105 == null) goto L17;
        com.bytedance.locallife.poi.newdetail.widget.contentplayer.a r106 = r105.b();
        if (r106 == null) goto L17;
        Integer r107 = r106.b();
        if (r107 == null) goto L17;
        if (r107.intValue() != 0) goto L17;
        boolean r108 = true;
    L18:
        if (r108 == true) goto L20;
    L39:
        this.f263396n.setMaxWidthForContentPlayer(r102);
        TripPoiHeadTagsWidget r109 = this.f263396n;
        List<i> r110 = this.f263394l;
        if (r110 == null) goto L42;
        int r111 = r110.size();
    L43:
        r109.e(r101, r111, "", this.M, true, this.I);
        return;
    L42:
        r111 = 0;
        goto L43
    L20:
        if (this.I == false) goto L39;
        List<i> r112 = this.f263394l;
        if (r112 == null) goto L34;
        i r113 = (i) ListProtector.get(r112, 0);
        if (r113 == null) goto L34;
        com.bytedance.locallife.poi.newdetail.widget.contentplayer.a r114 = r113.b();
        if (r114 == null) goto L34;
        List<PoiPhoto> r115 = r114.d();
        if (r115 == null) goto L34;
        PoiPhoto r116 = (PoiPhoto) ListProtector.get(r115, 0);
        if (r116 == null) goto L34;
        if (r116.mediaType != 1) goto L34;
    L35:
        if (r104 == true) goto L37;
        float r117 = getCurrentWindowWidth();
        float r118 = xo6.b.a(90);
    L38:
        r102 = r117 - r118;
        goto L39
    L37:
        r117 = getCurrentWindowWidth();
        r118 = xo6.b.a(102);
    L34:
        r104 = false;
    L17:
        r108 = false;
        goto L18
    L44:
        this.f263396n.f(r101, r101.size(), this.M);
        return;
    }

    public PoiContentPlayerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        this.f263395m = 2;
        this.f263405w = -1;
        this.f263408z = new LinkedHashSet();
        this.E = "pull_down";
        this.G = new ArrayList();
        LayoutInflater.from(getContext()).inflate(R.layout.saas_poi_layout_content_player, this);
        this.f263396n = (TripPoiHeadTagsWidget) findViewById(R.id.poi_content_player_tags);
        this.f263397o = (ViewPager2) findViewById(R.id.content_view_pager);
        this.f263399q = (ConstraintLayout) findViewById(R.id.content_tags_container);
        this.f263400r = (SmartImageView) findViewById(R.id.content_view_more);
        this.f263402t = (RelativeLayout) findViewById(R.id.content_view_more_container);
        HorizontalOverScrollLayout r102 = (HorizontalOverScrollLayout) findViewById(R.id.content_swiper_container);
        this.f263401s = r102;
        if (r102 == null) goto L5;
        r102.setMaxOverScrollDistance(150);
    L5:
        this.H = (PoiHeartbeatBadgeView) findViewById(R.id.head_image_heart);
        this.K = new b(this);
        this.L = new c(this);
        this.M = new d(this);
    }

    public PoiContentPlayerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        this.f263395m = 2;
        this.f263405w = -1;
        this.f263408z = new LinkedHashSet();
        this.E = "pull_down";
        this.G = new ArrayList();
        LayoutInflater.from(getContext()).inflate(R.layout.saas_poi_layout_content_player, this);
        this.f263396n = (TripPoiHeadTagsWidget) findViewById(R.id.poi_content_player_tags);
        this.f263397o = (ViewPager2) findViewById(R.id.content_view_pager);
        this.f263399q = (ConstraintLayout) findViewById(R.id.content_tags_container);
        this.f263400r = (SmartImageView) findViewById(R.id.content_view_more);
        this.f263402t = (RelativeLayout) findViewById(R.id.content_view_more_container);
        HorizontalOverScrollLayout r103 = (HorizontalOverScrollLayout) findViewById(R.id.content_swiper_container);
        this.f263401s = r103;
        if (r103 == null) goto L5;
        r103.setMaxOverScrollDistance(150);
    L5:
        this.H = (PoiHeartbeatBadgeView) findViewById(R.id.head_image_heart);
        this.K = new b(this);
        this.L = new c(this);
        this.M = new d(this);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void h(final BaseDitoView r210, boolean r211, int r212, int r213, final List r214, List r215, String r216, String r217, com.bytedance.locallife.poi.newdetail.widget.contentplayer.b r218, final com.bytedance.locallife.poi.newdetail.widget.contentplayer.d r310) {
        Intrinsics.checkNotNullParameter(r210, "ditoView");
        Intrinsics.checkNotNullParameter(r214, "tabList");
        Intrinsics.checkNotNullParameter(r215, "subTabList");
        Intrinsics.checkNotNullParameter(r217, "sessionId");
        this.f263407y = r310;
        this.f263394l = r214;
        this.f263392j = r212;
        this.f263391i = r210;
        this.f263390h = r211;
        this.f263389J = r218;
        if (r218 == null) goto L5;
        String r100 = r218.d();
    L7:
        if (r100 == null) goto L9;
        this.I = true;
    L9:
        int r101 = (int) UIUtils.dip2Px(getContext(), 12.0f);
        if (this.f263395m != 2) goto L12;
        int r102 = r213 + r101;
    L13:
        ViewGroup.LayoutParams r103 = getLayoutParams();
        if (r103 == null) goto L17;
        r103.height = r102;
        setLayoutParams(r103);
    L17:
        if (this.f263398p != null) goto L23;
        int r104 = this.f263395m;
        if (r216 != null) goto L21;
        String r110 = "";
    L22:
        ?? r111 = 1;
        this.f263398p = new PoiContentPlayerAdapter(r210, r211, r104, r212, r213, r110, r217, this.I, r215, getContentClickCallback());
    L24:
        int r105 = r214.size();
        int r106 = 0;
    L25:
        if (r106 >= r105) goto L27;
        ((ArrayList) this.G).add(0);
        r106 = r106 + 1;
        goto L25
    L27:
        PoiContentPlayerAdapter r107 = this.f263398p;
        if (r107 == null) goto L30;
        List<Integer> r108 = this.G;
        Intrinsics.checkNotNullParameter(r214, "itemList");
        Intrinsics.checkNotNullParameter(r108, "showTypeList");
        r107.f263357n = r214;
        r107.f263362s = r108;
    L30:
        this.f263397o.setAdapter(this.f263398p);
        this.f263397o.setNestedScrollingEnabled(r111);
        ViewPager2 r109 = this.f263397o;
        int r112 = r109.getChildCount();
        int r113 = 0;
    L31:
        if (r113 >= r112) goto L37;
        View r114 = r109.getChildAt(r113);
        if ((r114 instanceof RecyclerView) == false) goto L36;
        ((RecyclerView) r114).setItemAnimator(null);
    L36:
        r113 = r113 + 1;
        goto L31
    L37:
        this.f263397o.registerOnPageChangeCallback(new PoiContentPlayerView$setInteractAndData$2(r214, this, r310, r210));
        u r115 = q.e("https://lf3-static.bytednsdoc.com/obj/eden-cn/fvyeh7pflpxbvg/ic_bounce_goto.png");
        r115.f468294t = this.f263400r;
        r115.c();
        this.f263393k = com.bytedance.locallife.biz.common.utils.e.b() + ((int) UIUtils.dip2Px(getContext(), 8.0f));
        HorizontalOverScrollLayout r116 = this.f263401s;
        if (r116 == null) goto L41;
        r116.setListener(new f(this, r310));
    L41:
        this.f263396n.setVisibility(0);
        this.f263396n.setShowAlbumText(r111);
        ConstraintLayout r117 = this.f263399q;
        if (r117 == null) goto L45;
        r117.setVisibility(0);
    L45:
        ViewGroup.LayoutParams r118 = this.f263396n.getLayoutParams();
        if ((r118 instanceof ConstraintLayout.LayoutParams) == false) goto L48;
        ConstraintLayout.LayoutParams r119 = (ConstraintLayout.LayoutParams) r118;
    L50:
        if (PoiBigFontExperiment.a() == false) goto L54;
        if (r119 == null) goto L57;
        float r120 = 48 * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f);
        Resources r121 = Resources.getSystem();
        ((ViewGroup.MarginLayoutParams) r119).height = MathKt.roundToInt(TypedValue.applyDimension(r111, r120, WindowDisplayMetricsOverride.apply(r121, r121.getDisplayMetrics())));
    L57:
        ConstraintLayout r122 = this.f263399q;
        if (r122 == null) goto L60;
        ViewGroup.LayoutParams r123 = r122.getLayoutParams();
    L62:
        if ((r123 instanceof FrameLayout.LayoutParams) == false) goto L64;
        FrameLayout.LayoutParams r124 = (FrameLayout.LayoutParams) r123;
    L65:
        if (r124 == null) goto L68;
        r124.topMargin = this.f263404v;
    L68:
        ConstraintLayout r125 = this.f263399q;
        if (r125 == null) goto L72;
        r125.setLayoutParams(r124);
    L72:
        this.f263396n.setContainerBackground(R.drawable.poi_bg_tags_widget_bg);
        i(r111);
        RelativeLayout r126 = this.f263402t;
        if (r126 == null) goto L75;
        ViewGroup.LayoutParams r127 = r126.getLayoutParams();
    L76:
        if (r127 == null) goto L79;
        r127.height = (int) (this.f263404v + xo6.b.a(47));
    L79:
        RelativeLayout r128 = this.f263402t;
        if (r128 == null) goto L83;
        r128.setLayoutParams(r127);
    L83:
        boolean r129 = true;
        int r130 = (r212 - ((int) UIUtils.dip2Px(getContext(), 75 + 47.0f))) + r101;
        this.f263403u = r130;
        this.f263404v = r130;
        if (r211 == false) goto L86;
    L90:
        AbstractInteractBehavior<? extends View> r131 = r210.getDitoViewModel().f258035a.Da0();
        if ((r131 instanceof CustomBottomBehavior) == false) goto L93;
        CustomBottomBehavior r132 = (CustomBottomBehavior) r131;
    L94:
        if (r132 == null) goto L96;
        g r133 = new g(this);
        Intrinsics.checkNotNullParameter(r133, "listener");
        r132.X = r133;
    L96:
        DitoDataCenter r134 = r210.getDitoViewModel().f258041g;
        int r135 = DitoDataCenter.f258004d;
        r134.a0("poi_header_content_change", 1).observe(r210, this.K);
        r134.a0("poi_header_content_muted_change", 1).observe(r210, this.L);
        r134.a0("poi_detail_fmp_complete", 1).observe(r210, new h(this, r214));
        if (this.I == false) goto L132;
        com.bytedance.locallife.poi.newdetail.widget.contentplayer.b r136 = this.f263389J;
        if (r136 != null) goto L101;
    L121:
        Unit r137 = null;
    L122:
        if (r137 != null) goto L133;
        PoiHeartbeatBadgeView r138 = this.H;
        if (r138 == null) goto L134;
        r138.setVisibility(8);
        return;
    L134:
        return;
    L133:
        return;
    L101:
        if (r136.d() != null) goto L103;
    L105:
        r129 = false;
    L106:
        if (r129 == true) goto L109;
        r136 = null;
    L109:
        if (r136 == null) goto L121;
        PoiHeartbeatBadgeView r139 = this.H;
        if (r139 == null) goto L114;
        String r140 = r136.d();
        Intrinsics.checkNotNull(r140);
        String r141 = r136.c();
        Intrinsics.checkNotNull(r141);
        r139.a(r140, r141);
        r139.setVisibility(0);
    L114:
        if (Intrinsics.areEqual(r136.b(), Boolean.FALSE) == false) goto L118;
        PoiHeartbeatBadgeView r142 = this.H;
        if (r142 == null) goto L118;
        r142.f263313d.setVisibility(8);
    L118:
        PoiHeartbeatBadgeView r143 = this.H;
        if (r143 == null) goto L121;
        r143.setOnClickListener(new e(r143, r136, this));
        r137 = Unit.INSTANCE;
        goto L122
    L103:
        if (r136.c() == null) goto L105;
    L132:
        return;
    L93:
        r132 = null;
        goto L94
    L86:
        if (this.A == true) goto L90;
        if (r310 == null) goto L89;
        r310.c(r214);
    L89:
        this.A = true;
        goto L90
    L75:
        r127 = null;
        goto L76
    L64:
        r124 = null;
        goto L65
    L60:
        r123 = null;
        goto L62
    L54:
        if (r119 == null) goto L57;
        ((ViewGroup.MarginLayoutParams) r119).height = (int) xo6.b.a(48);
        goto L57
    L48:
        r119 = null;
        goto L50
    L21:
        r110 = r216;
        goto L22
    L23:
        r111 = 1;
        goto L24
    L12:
        r102 = r212 + r101;
        goto L13
    L5:
        r100 = null;
        goto L7
    }
}
