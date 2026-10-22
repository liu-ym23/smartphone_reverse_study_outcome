package com.bytedance.locallife.poi.media.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.lighten.loader.SmartImageView;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.dito.common.data.UrlModel;
import com.bytedance.locallife.poi.media.PoiPlayer;
import com.bytedance.locallife.poi.media.entity.PoiMediaStyle;
import com.bytedance.locallife.poi.media.entity.PoiPlayActionType;
import com.bytedance.locallife.poi.media.impl.PlayerLayerFactoryServiceImpl;
import com.bytedance.locallife.poi.media.list.AbsInnerViewHolder;
import com.bytedance.locallife.poi.media.list.PoiPlayerAdapter;
import com.bytedance.locallife.poi.media.list.PoiPlayerViewHolder;
import com.bytedance.locallife.poi.media.ui.indicator.PoiVerticalPagerIndicator;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import df6.q;
import df6.u;
import iy6.g;
import iy6.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/locallife/poi/media/ui/PoiMediaFragment;", "Landroidx/fragment/app/Fragment;", "Ljy6/a;", "event", "", "onPoiFeedSyncDataEvent", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiMediaFragment extends Fragment {
    public static final /* synthetic */ int D = 0;
    public View A;
    public boolean B;
    public final PoiMediaFragment$mViewPagerCallback$1 C;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f262809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f262810e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public iy6.b f262811f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RelativeLayout f262812g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SmartImageView f262813h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public VerticalOverScrollLayout f262814i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f262815j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ViewPager2 f262816k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PoiVerticalPagerIndicator f262817l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public FrameLayout f262818m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public RecyclerView f262819n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public PoiPlayerAdapter f262820o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f262821p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public hy6.a f262822q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public hy6.d f262823r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public hy6.d f262824s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public hy6.d f262825t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f262826u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Map<String, String> f262827v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f262828w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ViewStub f262829x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public View f262830y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ViewStub f262831z;

    public static final class a {
    }

    public static final class b implements com.bytedance.locallife.poi.media.ui.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiMediaFragment f262832a;

        public b(PoiMediaFragment r100) {
            this.f262832a = r100;
        }

        @Override // com.bytedance.locallife.poi.media.ui.a
        public final void b(int r100) {
            if (r100 != 0) goto L7;
            TextView r101 = this.f262832a.f262815j;
            if (r101 == null) goto L18;
            r101.setVisibility(4);
        L18:
            PoiMediaFragment r102 = this.f262832a;
            int r103 = r102.f262821p - r100;
            r102.f262821p = r100;
            TextView r104 = r102.f262815j;
            if (r104 == null) goto L22;
            r104.offsetTopAndBottom(r103);
            return;
        L22:
            return;
        L7:
            TextView r105 = this.f262832a.f262815j;
            if (r105 != null) goto L10;
        L12:
            boolean r106 = false;
        L13:
            if (r106 == true) goto L18;
            TextView r107 = this.f262832a.f262815j;
            if (r107 == null) goto L18;
            r107.setVisibility(0);
            goto L18
        L10:
            if (r105.getVisibility() != 0) goto L12;
            r106 = true;
            goto L13
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiMediaFragment f262833a;

        public c(PoiMediaFragment r100) {
            this.f262833a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PoiMediaFragment r100 = this.f262833a;     // Catch: Throwable -> L4
            r100.W90(r100.f262810e, PoiPlayActionType.AUTO_PLAY);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void U90() {
        if (this.f262826u == false) goto L5;
        return;
    L5:
        this.f262826u = true;
        iy6.b r100 = this.f262811f;
        if (r100 == null) goto L11;
        JsonObject r101 = r100.h();
        if (r101 == null) goto L12;
        com.bytedance.locallife.poi.media.a r102 = com.bytedance.locallife.poi.media.a.f262661a;
        Map<String, String> r103 = this.f262827v;
        r102.getClass();
        com.bytedance.locallife.poi.media.a.a(r101, r103, null);
        return;
    L12:
        return;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.locallife.poi.media.ui.PoiMediaFragment$mViewPagerCallback$1] */
    public PoiMediaFragment() {
        this.f262827v = new LinkedHashMap();
        this.B = true;
        this.C = new PoiMediaFragment$mViewPagerCallback$1(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        vn6.b.c(this);
        PoiPlayerAdapter r100 = this.f262820o;
        if (r100 == null) goto L9;
        Iterator r101 = ((ArrayList) r100.f262684c).iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        ((AbsInnerViewHolder) r101.next()).U3();
        goto L6
    L8:
        ((ArrayList) r100.f262684c).clear();
    L9:
        hy6.d r102 = this.f262825t;
        if (r102 == null) goto L12;
        r102.release();
    L12:
        hy6.d r103 = this.f262824s;
        if (r103 == null) goto L15;
        r103.release();
    L15:
        ViewPager2 r104 = this.f262816k;
        if (r104 == null) goto L20;
        r104.unregisterOnPageChangeCallback(this.C);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        V90(-1);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        W90(this.f262810e, PoiPlayActionType.MANUAL_PLAY);
    }

    public final String T90(int r100) {
        iy6.b r101 = this.f262811f;
        if (r101 == null) goto L22;
        h r102 = r101.d();
        if (r102 == null) goto L23;
        List<iy6.c> r103 = r102.d();
        if (r103 == null) goto L24;
        iy6.c r104 = (iy6.c) CollectionsKt.getOrNull(r103, r100);
        if (r104 == null) goto L25;
        g r105 = r104.d();
        if (r105 == null) goto L26;
        int r106 = r105.e();
        com.bytedance.locallife.poi.media.a.f262661a.getClass();
        if (r106 != PoiMediaStyle.POI_MEDIA_STYLE_VIDEO.getStyle()) goto L17;
        String r107 = "video";
    L27:
        return r107;
    L17:
        if (r106 != PoiMediaStyle.POI_MEDIA_STYLE_PHOTOS.getStyle()) goto L20;
        r107 = "pic";
        goto L27
    L20:
        if (r106 != PoiMediaStyle.POI_MEDIA_VR_MODEL.getStyle()) goto L28;
        r107 = DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL;
        goto L27
    L28:
        return "other";
    L26:
        return "other";
    L25:
        return "other";
    L24:
        return "other";
    L23:
        return "other";
    L22:
        return "other";
    }

    public final void V90(int r100) {
        RecyclerView r101 = this.f262819n;
        if (r101 != null) goto L5;
        return;
    L5:
        RecyclerView.LayoutManager r102 = r101.getLayoutManager();
        if (r102 != null) goto L8;
        return;
    L8:
        int r103 = r102.getChildCount();
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L27;
        View r105 = r102.getChildAt(r104);
        if (r105 == null) goto L26;
        RecyclerView.ViewHolder r106 = r101.getChildViewHolder(r105);
        if ((r106 instanceof PoiPlayerViewHolder) == false) goto L16;
        PoiPlayerViewHolder r107 = (PoiPlayerViewHolder) r106;
    L17:
        if (r107 != null) goto L19;
    L21:
        boolean r108 = false;
    L22:
        if (r108 == true) goto L26;
        if (r107 == null) goto L26;
        r107.getAdapterPosition();
        PoiPlayer r109 = r107.f262688d;
        r109.u();
        r109.x();
        r107.f262688d.s();
        goto L26
    L19:
        if (r107.getAdapterPosition() != r100) goto L21;
        r108 = true;
        goto L22
    L16:
        r107 = null;
    L26:
        r104 = r104 + 1;
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        int r101 = com.bytedance.locallife.biz.btm.b.f256555a;
        com.bytedance.locallife.biz.btm.b.C3644b.e(this, "a2552.b0966");
        vn6.b.b(this);
    }

    @Subscribe
    public final void onPoiFeedSyncDataEvent(jy6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        String r101 = r100.f500948a;
        this.f262828w = r101;
        hy6.d r102 = this.f262825t;
        if (r102 == null) goto L5;
        r102.m(r101);
    L5:
        hy6.d r103 = this.f262824s;
        if (r103 == null) goto L8;
        r103.m(this.f262828w);
    L8:
        PoiPlayerAdapter r104 = this.f262820o;
        if (r104 == null) goto L16;
        r104.f262685d = this.f262828w;
        Iterator r105 = ((ArrayList) r104.f262684c).iterator();
    L12:
        if (r105.hasNext() == false) goto L22;
        AbsInnerViewHolder r106 = (AbsInnerViewHolder) r105.next();
        String r107 = r104.f262685d;
        hy6.d r108 = r106.f262678a;
        if (r108 == null) goto L12;
        r108.m(r107);
        goto L12
    L22:
        return;
    }

    public static final void S90(PoiMediaFragment r100, View r101) {
        r100.getClass();
        LottieAnimationView r102 = (LottieAnimationView) r101.findViewById(R.id.life_poi_media_lottie_guide_view);
        r102.setImageAssetsFolder("lottie_swipe_up/");
        r102.setImageAssetDelegate(new com.bytedance.locallife.poi.media.ui.b(r100));
        r102.setAnimation("life_poi_media_lottie_guide_swipe_up.json");
        r102.setRepeatCount(-1);
        r102.playAnimation();
    }

    public final void W90(int r100, PoiPlayActionType r101) {
        RecyclerView r102 = this.f262819n;
        if (r102 != null) goto L5;
        return;
    L5:
        RecyclerView.ViewHolder r103 = r102.findViewHolderForAdapterPosition(r100);
        if ((r103 instanceof PoiPlayerViewHolder) == false) goto L8;
        PoiPlayerViewHolder r104 = (PoiPlayerViewHolder) r103;
    L9:
        if (r104 != null) goto L11;
    L18:
        if (r104 == null) goto L21;
        Intrinsics.checkNotNullParameter(r101, ReportConstant.COMMON_ACTION_TYPE);
        r104.getAdapterPosition();
        r104.f262688d.v(r101);
        return;
    L21:
        return;
    L11:
        if (r104.f262688d == null) goto L18;
        hy6.d r105 = this.f262825t;
        if (r105 == null) goto L15;
        r105.a();
    L15:
        hy6.d r106 = this.f262824s;
        if (r106 == null) goto L18;
        r106.a();
        goto L18
    L8:
        r104 = null;
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r110);
        ViewPager2 r101 = this.f262816k;
        boolean r111 = true;
        if (r101 == null) goto L6;
        r101.setNestedScrollingEnabled(true);
    L6:
        VerticalOverScrollLayout r102 = this.f262814i;
        if (r102 == null) goto L10;
        r102.setNestedScrollingEnabled(true);
    L10:
        VerticalOverScrollLayout r103 = this.f262814i;
        if (r103 == null) goto L13;
        r103.setBottomOverScroll(true);
    L13:
        VerticalOverScrollLayout r104 = this.f262814i;
        if (r104 == null) goto L17;
        r104.setListener(new b(this));
    L17:
        iy6.b r105 = this.f262811f;
        if (r105 == null) goto L165;
        FragmentActivity r106 = getActivity();
        if (r106 == null) goto L23;
        this.f262822q = new PlayerLayerFactoryServiceImpl().getPlayerLayerCreator(r106, r105.e(), r105.i());
    L23:
        hy6.a r107 = this.f262822q;
        UrlModel r108 = null;
        if (r107 == null) goto L26;
        com.bytedance.locallife.poi.media.layer.d r109 = r107.b();
    L27:
        this.f262825t = r109;
        if (r109 == null) goto L44;
        RelativeLayout r112 = this.f262812g;
        if (r112 == null) goto L32;
        r112.addView(r109.c(r112));
    L32:
        iy6.b r113 = this.f262811f;
        if (r113 == null) goto L35;
        r113.d();
    L35:
        iy6.b r114 = this.f262811f;
        if (r114 == null) goto L38;
        JsonObject r115 = r114.h();
    L39:
        r109.i(r115);
        iy6.b r116 = this.f262811f;
        if (r116 == null) goto L42;
        JsonObject r117 = r116.a();
    L43:
        r109.k(r117);
        goto L44
    L42:
        r117 = null;
        goto L43
    L38:
        r115 = null;
    L44:
        iy6.b r118 = this.f262811f;
        if (r118 == null) goto L49;
        h r119 = r118.d();
        if (r119 == null) goto L49;
        iy6.d r120 = r119.b();
    L51:
        if (r120 == null) goto L77;
        hy6.a r121 = this.f262822q;
        if (r121 == null) goto L55;
        com.bytedance.locallife.poi.media.layer.a r122 = r121.a();
    L56:
        this.f262824s = r122;
        if (r122 == null) goto L81;
        FrameLayout r123 = this.f262818m;
        if (r123 == null) goto L62;
        r123.setVisibility(0);
    L62:
        FrameLayout r124 = this.f262818m;
        if (r124 == null) goto L65;
        r124.addView(r122.c(r124));
    L65:
        iy6.b r125 = this.f262811f;
        if (r125 == null) goto L68;
        r125.d();
    L68:
        iy6.b r126 = this.f262811f;
        if (r126 == null) goto L71;
        JsonObject r127 = r126.h();
    L72:
        r122.i(r127);
        iy6.b r128 = this.f262811f;
        if (r128 == null) goto L75;
        JsonObject r129 = r128.a();
    L76:
        r122.k(r129);
        goto L81
    L75:
        r129 = null;
        goto L76
    L71:
        r127 = null;
    L81:
        hy6.a r130 = this.f262822q;
        if (r130 == null) goto L84;
        com.bytedance.locallife.poi.media.layer.c r131 = r130.c();
    L85:
        this.f262823r = r131;
        RelativeLayout r132 = this.f262812g;
        if (r132 == null) goto L91;
        if (r131 == null) goto L91;
        View r133 = r131.c(r132);
        r133.setFitsSystemWindows(true);
        r132.addView(r133);
        iy6.b r134 = this.f262811f;
        if (r134 == null) goto L91;
        r134.d();
    L91:
        this.f262820o = new PoiPlayerAdapter(r105, this.f262822q);
        ViewPager2 r135 = this.f262816k;
        if (r135 == null) goto L95;
        r135.setOrientation(1);
    L95:
        ViewPager2 r136 = this.f262816k;
        if (r136 == null) goto L99;
        r136.setAdapter(this.f262820o);
    L99:
        ViewPager2 r137 = this.f262816k;
        if (r137 == null) goto L102;
        r137.registerOnPageChangeCallback(this.C);
    L102:
        iy6.b r138 = this.f262811f;
        if (r138 == null) goto L128;
        this.f262810e = r138.b();
        String r139 = r138.c();
        h r140 = r138.d();
        if (r140 == null) goto L107;
        List<iy6.c> r141 = r140.d();
    L109:
        if (TextUtils.isEmpty(r139) == true) goto L121;
        if (r141 == null) goto L121;
        int r142 = r141.size();
        int r143 = 0;
    L112:
        if (r143 >= r142) goto L121;
        g r144 = ((iy6.c) ListProtector.get(r141, r143)).d();
        if (r144 == null) goto L116;
        String r145 = r144.d();
    L118:
        if (TextUtils.equals(r139, r145) == true) goto L119;
        r143 = r143 + 1;
        goto L112
    L119:
        this.f262810e = r143;
        goto L121
    L116:
        r145 = null;
    L121:
        FragmentActivity r146 = getActivity();
        if ((r146 instanceof PoiMediaActivity) == false) goto L124;
        PoiMediaActivity r147 = (PoiMediaActivity) r146;
    L125:
        if (r147 == null) goto L128;
        r147.f262806m = this.f262810e;
        goto L128
    L124:
        r147 = null;
        goto L125
    L107:
        r141 = null;
    L128:
        ViewPager2 r148 = this.f262816k;
        if (r148 == null) goto L132;
        r148.setCurrentItem(this.f262810e, false);
    L132:
        if (this.f262810e == 0) goto L137;
        ViewPager2 r149 = this.f262816k;
        if (r149 == null) goto L137;
        r149.post(new c(this));
    L137:
        if (r105.f() == false) goto L145;
        PoiVerticalPagerIndicator r150 = this.f262817l;
        if (r150 == null) goto L142;
        r150.setVisibility(0);
    L142:
        PoiVerticalPagerIndicator r151 = this.f262817l;
        if (r151 == null) goto L149;
        ViewPager2 r152 = this.f262816k;
        Intrinsics.checkNotNull(r152);
        r151.a(r152);
    L149:
        iy6.b r153 = this.f262811f;
        if (r153 == null) goto L163;
        JsonObject r154 = r153.a();
        if (r154 == null) goto L163;
        com.bytedance.locallife.poi.media.a.f262661a.getClass();
        Intrinsics.checkNotNullParameter(r154, "<this>");
        Result.Companion r155 = Result.Companion;     // Catch: Throwable -> L156
        iy6.f r156 = (iy6.f) com.bytedance.locallife.common.utils.d.a(r154.get("poi_skin_style").getAsString(), iy6.f.class);     // Catch: Throwable -> L156
    L161:
        if (r156 == null) goto L163;
        r108 = r156.a();
    L156:
        th = move-exception;
        Result.Companion r157 = Result.Companion;
        Throwable r158 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r158 == null) goto L160;
        com.bytedance.locallife.poi.media.a.f262661a.getClass();
        com.bytedance.locallife.poi.media.a.d(r158);
    L160:
        r156 = null;
    L163:
        if (r108 == null) goto L165;
        int r159 = ly6.a.f511316a;
        Intrinsics.checkNotNullParameter(r108, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        u r160 = q.c(new ef6.a(r108.getUrlList()));
        r160.f468277c = getContext();
        r160.f468294t = this.f262813h;
        r160.c();
        goto L165
    L145:
        PoiVerticalPagerIndicator r161 = this.f262817l;
        if (r161 == null) goto L149;
        r161.setVisibility(8);
        goto L149
    L84:
        r131 = null;
        goto L85
    L55:
        r122 = null;
        goto L56
    L77:
        FrameLayout r162 = this.f262818m;
        if (r162 == null) goto L81;
        r162.setVisibility(8);
    L49:
        r120 = null;
        goto L51
    L26:
        r109 = null;
    L165:
        if (r105 != null) goto L167;
    L169:
        boolean r163 = false;
    L170:
        if (r163 == false) goto L217;
        h r164 = r105.d();
        if (r164 == null) goto L175;
        List<iy6.c> r165 = r164.d();
        if (r165 == null) goto L175;
    L176:
        List<iy6.c> r166 = r165;
        if (r166 != null) goto L179;
    L182:
        boolean r167 = true;
    L183:
        if (r167 == false) goto L185;
    L194:
        boolean r168 = false;
    L196:
        if (r168 == false) goto L208;
        if (this.A != null) goto L217;
        int r169 = com.bytedance.locallife.poi.utils.b.f264219a;
        if ((!HostServiceUtilsKt.i0().g("poi_repo", "keva_key_poi_vr_model_guide", false)) == false) goto L217;
        ViewStub r170 = this.f262831z;
        if (r170 == null) goto L204;
        r170.setOnInflateListener(new com.bytedance.locallife.poi.media.ui.c(this));
    L204:
        ViewStub r171 = this.f262831z;
        if (r171 == null) goto L217;
        r171.inflate();
        goto L217
    L208:
        if (this.f262830y != null) goto L217;
        int r172 = com.bytedance.locallife.poi.utils.b.f264219a;
        if ((!HostServiceUtilsKt.i0().g("poi_repo", "keva_key_poi_player_guide", false)) == false) goto L217;
        ViewStub r173 = this.f262829x;
        if (r173 == null) goto L214;
        r173.setOnInflateListener(new d(this));
    L214:
        ViewStub r174 = this.f262829x;
        if (r174 == null) goto L217;
        r174.inflate();
        goto L217
    L185:
        if (r165.size() <= r105.b()) goto L194;
        g r175 = ((iy6.c) ListProtector.get(r165, r105.b())).d();
        if (r175 != null) goto L189;
    L191:
        boolean r176 = false;
    L192:
        if (r176 == false) goto L194;
        r168 = true;
        goto L196
    L189:
        if (r175.e() != PoiMediaStyle.POI_MEDIA_VR_MODEL.getStyle()) goto L191;
        r176 = true;
        goto L192
    L179:
        if (r166.isEmpty() == true) goto L182;
        r167 = false;
    L175:
        r165 = CollectionsKt.emptyList();
    L217:
        if (r105 != null) goto L219;
    L221:
        r111 = false;
    L222:
        if (r111 == false) goto L231;
        VerticalOverScrollLayout r177 = this.f262814i;
        if (r177 == null) goto L232;
        r177.setBottomOverScroll(false);
        return;
    L232:
        return;
    L231:
        return;
    L219:
        if (r105.g() == true) goto L221;
    L167:
        if (r105.g() != true) goto L169;
        r163 = true;
        goto L170
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = LayoutInflater.from(getContext()).inflate(R.layout.life_poi_media_fragment, r101, false);
        this.f262812g = (RelativeLayout) r103.findViewById(R.id.poi_player_root_container);
        this.f262813h = (SmartImageView) r103.findViewById(R.id.poi_player_background_image);
        this.f262818m = (FrameLayout) r103.findViewById(R.id.poi_player_sticky_footer_container);
        this.f262814i = (VerticalOverScrollLayout) r103.findViewById(R.id.poi_player_over_scroll_layout);
        this.f262815j = (TextView) r103.findViewById(R.id.poi_player_bottom_text);
        this.f262816k = (ViewPager2) r103.findViewById(R.id.poi_detail_player_view_pager);
        this.f262817l = (PoiVerticalPagerIndicator) r103.findViewById(R.id.poi_player_pager_indicator);
        ViewPager2 r104 = this.f262816k;
        RecyclerView r105 = null;
        if (r104 == null) goto L5;
        View r106 = r104.getChildAt(0);
    L7:
        if ((r106 instanceof RecyclerView) == false) goto L9;
        r105 = (RecyclerView) r106;
    L9:
        this.f262819n = r105;
        this.f262829x = (ViewStub) r103.findViewById(R.id.poi_player_guide_stub);
        this.f262831z = (ViewStub) r103.findViewById(R.id.poi_vr_model_guide_stub);
        return r103;
    L5:
        r106 = null;
        goto L7
    }
}
