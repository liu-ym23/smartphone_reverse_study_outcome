package com.ss.android.lark.location_ui.picklocation;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.supervisor.token.Token;
import com.google.android.material.appbar.AppBarLayout;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.location.dto.LarkLocation;
import com.ss.android.lark.location.dto.POIConfig;
import com.ss.android.lark.location.dto.POIInfo;
import com.ss.android.lark.location.dto.Scene;
import com.ss.android.lark.location.service.IPickLocationMap;
import com.ss.android.lark.location_ui.widget.LoadingView;
import com.ss.android.lark.location_ui.widget.SearchBar;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.ui.CommonTitleBarConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public class LocationView extends com.ss.android.lark.location_ui.picklocation.a implements com.ss.android.lark.location_ui.picklocation.c {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String[] f431220y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Token f431221z = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Activity f431222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f431223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Token f431224d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Scene f431225e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f431226f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final POIConfig f431227g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f431228h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f431229i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f431230j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.ss.android.lark.location_ui.picklocation.c.a f431231k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public iqb.a f431232l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public iqb.a f431233m;

    @BindView(AVMDLDataLoader.KeyIsSetGlobalSpeedSampleInterval)
    AppBarLayout mAppBarLayout;

    @BindView(7700)
    LinearLayout mContainerLayout;

    @BindView(7537)
    RelativeLayout mContentLayout;

    @BindView(7676)
    ImageView mIvLocatePosition;

    @BindView(7603)
    ImageView mIvLocationIcon;

    @BindView(7674)
    FrameLayout mMapContainerLayout;

    @BindView(7691)
    ListView mNearByListView;

    @BindView(7680)
    LoadingView mNearbyLoading;

    @BindView(7678)
    LinearLayout mRecommendEmptyView;

    @BindView(7675)
    FrameLayout mRecommendLayout;

    @BindView(7677)
    View mRecommendLineView;

    @BindView(7692)
    ListView mRecommendListView;

    @BindView(7682)
    LoadingView mRecommendLoading;

    @BindView(7874)
    NestedScrollView mScrollNear;

    @BindView(7877)
    SearchBar mSearchBar;

    @BindView(7683)
    CommonTitleBar mTitleBar;

    @BindView(8015)
    TextView mTvRequestPermission;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public IPickLocationMap f431234n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList<POIInfo> f431235o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f431236p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f431237q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Double f431238r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Double f431239s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final a f431240t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final b f431241u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final c f431242v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final d f431243w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ValueAnimator f431244x;

    public class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LocationView f431245a;

        public a(LocationView r100) {
            this.f431245a = r100;
        }
    }

    public class b implements IPickLocationMap.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LocationView f431246a;

        public final void a() {
            this.f431246a.mNearbyLoading.a();
            this.f431246a.T();
        }

        public b(LocationView r100) {
            this.f431246a = r100;
        }
    }

    public class c implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LocationView f431247a;

        public class a implements h {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Editable f431248a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ c f431249b;

            @Override // com.ss.android.lark.location_ui.picklocation.LocationView.h
            public final void a(com.ss.android.lark.location.service.k r110) {
                this.f431249b.f431247a.mRecommendListView.setVisibility(0);
                this.f431249b.f431247a.mRecommendLoading.setVisibility(8);
                LocationView r100 = this.f431249b.f431247a;
                List<POIInfo> r101 = r100.f431231k.v5(!r100.f431227g.isSelfDefine());
                if (TextUtils.isEmpty(this.f431248a) == false) goto L5;
            L7:
                if (r101 != null) goto L9;
            L11:
                iqb.b.a(this.f431249b.f431247a.f431222b, r110);
                return;
            L9:
                if (r101.size() < 0) goto L11;
                this.f431249b.f431247a.f431233m.b(r101);
                goto L11
            L5:
                if (this.f431249b.f431247a.f431227g.isSelfDefine() == false) goto L7;
                ListProtector.add(r101, 0, new POIInfo(this.f431248a.toString(), this.f431249b.f431247a.f431222b.getString(R.string.Lark_Chat_MapsSearchCustomLocation), 360.0d, 360.0d, LarkLocation.CoordinateSystem.DEFAULT, false, true));
                goto L7
            }

            @Override // com.ss.android.lark.location_ui.picklocation.LocationView.h
            public final void b(List<POIInfo> r110) {
                this.f431249b.f431247a.mRecommendListView.setVisibility(0);
                this.f431249b.f431247a.mRecommendLoading.setVisibility(8);
                if (r110 == null) goto L11;
                if (r110.size() <= 0) goto L11;
                if (this.f431249b.f431247a.f431227g.isSelfDefine() == false) goto L9;
                ListProtector.add(r110, 0, new POIInfo(this.f431248a.toString(), this.f431249b.f431247a.f431222b.getString(R.string.Lark_Chat_MapsSearchCustomLocation), 360.0d, 360.0d, LarkLocation.CoordinateSystem.DEFAULT, false, true));
            L9:
                this.f431249b.f431247a.f431233m.b(r110);
                return;
            L11:
                if (this.f431249b.f431247a.f431227g.isSelfDefine() == false) goto L13;
                ArrayList r111 = new ArrayList();
                ListProtector.add(r111, 0, new POIInfo(this.f431248a.toString(), this.f431249b.f431247a.f431222b.getString(R.string.Lark_Chat_MapsSearchCustomLocation), 360.0d, 360.0d, LarkLocation.CoordinateSystem.DEFAULT, false, true));
                this.f431249b.f431247a.f431233m.b(r111);
                return;
            L13:
                this.f431249b.f431247a.f431233m.b(Collections.emptyList());
            }

            public a(c r100, Editable r101) {
                this.f431249b = r100;
                this.f431248a = r101;
            }
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public c(LocationView r100) {
            this.f431247a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r110) {
            this.f431247a.mRecommendLayout.setVisibility(0);
            this.f431247a.mRecommendLineView.setVisibility(0);
            this.f431247a.mContentLayout.setVisibility(8);
            if (TextUtils.isEmpty(r110) == false) goto L7;
            LocationView r111 = this.f431247a;
            this.f431247a.f431233m.b(r111.f431231k.v5(!r111.f431227g.isSelfDefine()));
            return;
        L7:
            if (this.f431247a.f431227g.isSelfDefine() == false) goto L16;
            iqb.a r100 = this.f431247a.f431233m;
            String r101 = r110.toString();
            if (r100.f495408b != null) goto L11;
            r100.f495408b = new ArrayList();
        L11:
            POIInfo r112 = new POIInfo(r101, r100.f495407a.getString(R.string.Lark_Chat_MapsSearchCustomLocation), 360.0d, 360.0d, LarkLocation.CoordinateSystem.DEFAULT, false, true);
            if (r100.f495408b.size() <= 0) goto L14;
            ListProtector.set(r100.f495408b, 0, r112);
        L15:
            r100.notifyDataSetChanged();
            goto L16
        L14:
            r100.f495408b.add(r112);
        L16:
            this.f431247a.mRecommendListView.setVisibility(8);
            this.f431247a.mRecommendLoading.b();
            LocationView r102 = this.f431247a;
            r102.f431231k.i6(r102.f431222b, r110.toString(), this.f431247a.f431225e, new a(this, r110));
        }
    }

    public class d implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LocationView f431250a;

        public d(LocationView r100) {
            this.f431250a = r100;
        }
    }

    public class e extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LocationView f431251a;

        public e(LocationView r100) {
            this.f431251a = r100;
        }

        @Override // com.ss.android.lark.location_ui.picklocation.LocationView.i, com.ss.android.lark.location_ui.picklocation.LocationView.h
        public final void a(com.ss.android.lark.location.service.k r100) {
            Log.i("LocationView", "queryLocation onSearchResultError called. errorCode:" + r100);
            this.f431251a.mNearbyLoading.a();
            LocationView r101 = this.f431251a;
            r101.f431237q = true;
            r101.T();
            LocationView.o(this.f431251a);
            if (this.f431251a.f431231k.isAdminGpsEnabled() == false) goto L8;
            LocationView r102 = this.f431251a;
            if (r102.s(r102.f431222b) == false) goto L9;
            iqb.b.a(this.f431251a.f431222b, r100);
            return;
        L9:
            return;
        }

        @Override // com.ss.android.lark.location_ui.picklocation.LocationView.h
        public final void b(List<POIInfo> r100) {
            Log.i("LocationView", "queryLocation onSearchResultSuccess called.");
            kqb.e.b("default");
            if (r100 != null) goto L5;
        L7:
            this.f431251a.mNearbyLoading.a();
            Activity r101 = this.f431251a.f431222b;
            int r102 = iqb.b.f495412a;
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            UDToast.show(r101, R.string.Lark_Core_MapServicesErrorMessage_NoLocationsFound, R.drawable.ud_icon_warning_outlined);
        L8:
            LocationView.o(this.f431251a);
            return;
        L5:
            if (((ArrayList) r100).size() <= 0) goto L7;
            this.f431251a.mNearByListView.setVisibility(0);
            this.f431251a.mNearbyLoading.setVisibility(8);
            this.f431251a.f431235o.clear();
            this.f431251a.f431235o.addAll(r100);
            POIInfo r103 = (POIInfo) ListProtector.get(r100, 0);
            LocationView.k(this.f431251a, r103, false);
            LocationView r104 = this.f431251a;
            r104.f431232l.b(r104.f431235o);
            kqb.c.a(this.f431251a.mNearByListView);
            this.f431251a.mNearByListView.setSelection(0);
            this.f431251a.T();
            this.f431251a.f431236p = 2;
            goto L8
        }
    }

    public interface f {
    }

    public interface g {
    }

    public interface h {
        void a(com.ss.android.lark.location.service.k r100);

        void b(List<POIInfo> r100);
    }

    public static abstract class i implements h {
        public i() {
        }

        @Override // com.ss.android.lark.location_ui.picklocation.LocationView.h
        public abstract void a(com.ss.android.lark.location.service.k r100);
    }

    public interface j {
    }

    static {
        f431220y = new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
        f431221z = new Token("LARK-PSDA-message_location_view_check_location_permission");
    }

    public final void C() {
        if (this.f431238r != null) goto L5;
        return;
    L5:
        if (this.f431239s == null) goto L9;
        this.mIvLocatePosition.setImageDrawable(AppCompatResources.getDrawable(this.f431222b, R.drawable.location_ic_locate_position_clicked));
        this.f431234n.a(this.f431238r.doubleValue(), this.f431239s.doubleValue());
        D(this.f431238r.doubleValue(), this.f431239s.doubleValue());
        this.mTitleBar.setRightVisible(true);
        this.mTitleBar.setLeftTextOnly(CommonTitleBarConstants.TEXT_CANCEL);
        return;
    }

    public final void T() {
        List<POIInfo> r100 = this.f431232l.f495408b;
        if (r100 != null) goto L5;
    L4:
        boolean r101 = false;
    L11:
        if (r101 == false) goto L14;
        this.mTitleBar.setRightText(0, this.f431230j, ContextCompat.getColor(this.f431222b, R.color.primary_fill_default));
        this.mTitleBar.getRightText().setClickable(true);
        return;
    L14:
        this.mTitleBar.setRightText(0, this.f431230j, ContextCompat.getColor(this.f431222b, R.color.location_position_send_disable_color));
        this.mTitleBar.getRightText().setClickable(false);
        return;
    L5:
        Iterator<POIInfo> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L4;
        if (r102.next().getIsCurrent() == false) goto L7;
        r101 = true;
        goto L11
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        IPickLocationMap r100 = this.f431234n;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.onDestroy();
    }

    @Override // com.ss.android.lark.location_ui.picklocation.c
    public final boolean i5() {
        if (this.f431222b != null) goto L7;
        return false;
    L7:
        return w();
    }

    @Override // com.ss.android.lark.location_ui.picklocation.c
    public final boolean onBackPressed() {
        if (this.f431222b != null) goto L7;
        return false;
    L7:
        if (w() == false) goto L9;
        return true;
    L9:
        LocationFragment r100 = ((LocationFragment.a) this.f431253a).f431219a;
        int r101 = LocationFragment.f431211k;
        Bundle r102 = r100.getArguments();
        if (r102 == null) goto L15;
        gqb.a r103 = hqb.a.a(r102.getString("location_unique_key")).f486834a;
        if (r103 == null) goto L15;
        r103.b();
    L15:
        if (this.f431228h == false) goto L19;
        Activity r104 = this.f431222b;
        if (r104 == null) goto L24;
        r104.onBackPressed();
    L24:
        return true;
    L19:
        Activity r105 = this.f431222b;
        if (r105 == null) goto L24;
        if (r105.isFinishing() == true) goto L24;
        this.f431222b.finish();
        goto L24
    }

    public final boolean w() {
        KeyboardUtils.hideKeyboard(this.f431222b);
        if (this.f431226f == false) goto L6;
        this.mSearchBar.clearFocus();
        this.mTitleBar.setRightVisible(true);
        this.mTitleBar.setLeftTextOnly(CommonTitleBarConstants.TEXT_CANCEL);
        this.mRecommendListView.setVisibility(8);
        this.mContentLayout.setVisibility(0);
        this.f431226f = false;
        return true;
    L6:
        return false;
    }

    public final void L() {
        T();
        this.mNearByListView.setVisibility(8);
        this.mNearbyLoading.b();
        iqb.a r100 = this.f431232l;
        if (CollectionUtils.isEmpty(r100.f495408b) == true) goto L6;
        r100.f495408b.clear();
        r100.notifyDataSetChanged();
    L6:
        this.f431231k.E2(this.f431234n.e(), this.f431234n.p());
        this.f431237q = false;
        this.f431231k.w6(this.f431222b, this.f431225e, new e(this), 0);
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        IPickLocationMap r100 = com.ss.android.lark.location.service.f.a().getPickLocationMap();
        this.f431234n = r100;
        if (r100 == null) goto L5;
        ButterKnife.bind(this, ((LocationFragment.a) this.f431253a).f431219a.f431212d);
        String r101 = this.f431227g.getActionText();
        this.f431230j = r101;
        if (TextUtils.isEmpty(r101) == false) goto L18;
        this.f431230j = this.f431222b.getString(R.string.Lark_Legacy_Send);
    L18:
        this.mTitleBar.setLeftTextOnly(CommonTitleBarConstants.TEXT_CANCEL);
        this.mTitleBar.addAction(new p(this, this.f431230j));
        int r102 = 0;
        this.mTitleBar.getRightText().setClickable(false);
        this.mTitleBar.setDividerVisible(false);
        this.mTitleBar.setLeftClickListener(new iqb.m(this));
        this.mTitleBar.setImmersive(true);
        this.mSearchBar.setStyle(R.style.LocationMsgAppendViewEditText);
        this.mSearchBar.setHint(R.string.Lark_Chat_MapsSearchInputLocation);
        this.mSearchBar.setEditTextImeOptions(6);
        this.mSearchBar.setEditTextEnabled(false);
        ImageView r103 = this.mIvLocationIcon;
        if (kqb.d.a() == true) goto L22;
        r102 = 8;
    L22:
        r103.setVisibility(r102);
        LinearLayout.LayoutParams r104 = new LinearLayout.LayoutParams(-1, -1);
        this.f431234n.j(IPickLocationMap.DarkMode.AUTO);
        View r105 = this.f431234n.h(this.f431222b);
        if (r105 == null) goto L25;
        this.mContainerLayout.addView(r105, r104);
    L25:
        SearchBar r106 = this.mSearchBar;
        c r107 = this.f431242v;
        r106.f431284b.addTextChangedListener(r107);
        this.mSearchBar.setOnFocusChangeListener(new s(this));
        this.mNearByListView.setOnItemClickListener(new t(this));
        this.mRecommendListView.setOnItemClickListener(new k(this));
        this.mIvLocatePosition.setOnClickListener(new iqb.e(this));
        this.mTvRequestPermission.setOnClickListener(new com.ss.android.lark.location_ui.picklocation.j(this));
        this.f431234n.b();
        this.f431234n.o(new l(this));
        this.f431234n.m(new m(this));
        if (kqb.d.a() == false) goto L28;
        CoordinatorLayout.LayoutParams r108 = (CoordinatorLayout.LayoutParams) this.mAppBarLayout.getLayoutParams();
        AppBarLayout.Behavior r109 = new AppBarLayout.Behavior();
        r109.setDragCallback(new iqb.l());
        r108.setBehavior(r109);
    L28:
        View r110 = this.f431222b.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L33;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r111 = ThreadMethodProxy.currentThread();
        if (r111 == com.larus.home.impl.utils.c.f346341a) goto L33;
        com.larus.home.impl.utils.c.a(r111, "getDecorView");
    L33:
        r110.post(new iqb.c(this));
        iqb.a r112 = new iqb.a(this.f431222b, new ArrayList());
        this.f431232l = r112;
        this.mNearByListView.setAdapter(r112);
        this.f431233m = new iqb.a(this.f431222b, new ArrayList());
        this.mRecommendListView.setEmptyView(this.mRecommendEmptyView);
        this.mRecommendListView.setAdapter(this.f431233m);
        this.mScrollNear.setOnScrollChangeListener(new iqb.o(this));
        return;
    L5:
        if (this.f431228h == false) goto L9;
        Activity r113 = this.f431222b;
        if (r113 == null) goto L35;
        r113.onBackPressed();
        return;
    L35:
        return;
    L9:
        Activity r114 = this.f431222b;
        if (r114 != null) goto L12;
        return;
    L12:
        if (r114.isFinishing() == true) goto L38;
        this.f431222b.finish();
        return;
    }

    public static void o(LocationView r100) {
        if (39.908823d == r100.f431234n.e()) goto L5;
    L7:
        r100.T();
        r100.mNearByListView.setVisibility(8);
        r100.mNearbyLoading.b();
        r100.f431231k.s5(r100.f431222b, r100.f431234n.e(), r100.f431234n.p(), r100.f431225e, r100.f431240t);
        return;
    L5:
        if (116.39747d != r100.f431234n.p()) goto L7;
        Log.i("LocationView", "getFromLocation called. default latLng.");
        r100.mSearchBar.setEditTextEnabled(true);
    }

    public final void P(String r100) {
        SearchBar r101 = this.mSearchBar;
        c r102 = this.f431242v;
        r101.f431284b.removeTextChangedListener(r102);
        this.mSearchBar.setText(r100);
        this.mSearchBar.setSelection(r100.length());
        SearchBar r103 = this.mSearchBar;
        c r104 = this.f431242v;
        r103.f431284b.addTextChangedListener(r104);
    }

    public final void p(final ValueCallback<Boolean> r110) {
        if (s(this.f431222b) == false) goto L7;
        r110.onReceiveValue(Boolean.TRUE);
        return;
    L7:
        if (this.f431229i == false) goto L10;
        com.ss.android.lark.utils.h.e(this.f431222b, new iqb.g(r110), com.ss.android.lark.utils.m.a(R.string.Lark_Chat_MessageLocationPermissionBanTitle, R.string.Lark_Chat_MessageLocationPermissionBanContentAndroid), f431221z, true, 2, 0, new com.ss.android.lark.utils.e(), new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"});
        return;
    L10:
        new o0c.c(this.f431222b).e(f431221z, f431220y).any(new iqb.h()).subscribe(new iqb.i(this, r110));
    }

    public final boolean s(Context r100) {
        if (ContextCompat.checkSelfPermission(r100, "android.permission.ACCESS_FINE_LOCATION") != 0) goto L5;
    L8:
        return true;
    L5:
        if (ContextCompat.checkSelfPermission(r100, "android.permission.ACCESS_COARSE_LOCATION") == 0) goto L8;
        return false;
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f431231k = (com.ss.android.lark.location_ui.picklocation.c.a) r100;
    }

    public static void h(LocationView r100, int r101) {
        Iterator<POIInfo> r102 = r100.f431232l.f495408b.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().setIsCurrent(false);
        goto L4
    L6:
        r100.f431232l.a(r101).setIsCurrent(true);
        r100.mNearByListView.setSelection(r101);
        r100.f431232l.notifyDataSetChanged();
        kqb.c.a(r100.mNearByListView);
        r100.T();
    }

    public final void D(double r100, double r110) {
        this.f431231k.E2(r100, r110);
        this.f431234n.f(r100, r110, this.f431241u);
    }

    public static void k(LocationView r100, POIInfo r101, boolean r102) {
        r100.f431231k.E2(r101.getLatitude(), r101.getLongitude());
        r100.f431223c = false;
        if (r102 == false) goto L5;
        r100.f431234n.f(r101.getLatitude(), r101.getLongitude(), null);
    L5:
        r100.f431231k.U4(r100.f431222b, r101, !r100.f431227g.isSelfDefine());
        r100.mSearchBar.clearFocus();
    }

    public LocationView(FragmentActivity r100, LocationFragment.a r101, POIConfig r102, boolean r103, Token r104, Scene r105, boolean r106) {
        this.f431223c = false;
        this.f431226f = false;
        this.f431235o = new ArrayList();
        this.f431236p = 2;
        this.f431237q = true;
        this.f431238r = null;
        this.f431239s = null;
        this.f431240t = new a(this);
        this.f431241u = new b(this);
        this.f431242v = new c(this);
        this.f431243w = new d(this);
        this.f431222b = r100;
        this.f431253a = r101;
        this.f431227g = r102;
        this.f431228h = r103;
        this.f431224d = r104;
        this.f431225e = r105;
        this.f431229i = r106;
    }
}
