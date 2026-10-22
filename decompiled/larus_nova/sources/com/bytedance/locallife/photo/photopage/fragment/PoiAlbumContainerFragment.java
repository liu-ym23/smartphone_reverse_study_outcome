package com.bytedance.locallife.photo.photopage.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.dmt.ui.widget.ButtonStyle;
import com.bytedance.ies.dmt.ui.widget.DmtStatusView;
import com.bytedance.locallife.model.album.PoiAlbumParams;
import com.bytedance.locallife.model.album.TabInfo;
import com.bytedance.locallife.photo.album.model.AlbumPageStatus;
import com.bytedance.locallife.photo.album.model.AlbumViewModel;
import com.bytedance.locallife.photo.album.model.RequestStatus;
import com.bytedance.locallife.photo.layout.FlowLayout;
import com.bytedance.locallife.photo.photopage.view.PoiAlbumHorizontalTag;
import com.bytedance.locallife.photo.photopage.view.PoiAlbumTagLayout;
import com.bytedance.locallife.photo.photopage.view.ScrollFlexViewPager;
import com.gyf.barlibrary.ImmersionBar;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.poi.model.AlbumTabListModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/locallife/photo/photopage/fragment/PoiAlbumContainerFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-photo-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiAlbumContainerFragment extends Fragment {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f262162o = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AlbumViewModel f262163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PoiAlbumTagLayout f262164e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ScrollFlexViewPager f262165f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DmtStatusView f262166g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LinearLayout f262167h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f262168i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FrameLayout f262169j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PoiAlbumContainerFragment$onPageChangeListener$1 f262170k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f262171l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f262172m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f262173n;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiAlbumContainerFragment f262174a;

        public b(PoiAlbumContainerFragment r100) {
            this.f262174a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PoiAlbumTagLayout r100 = this.f262174a.f262164e;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.c(true);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    public final boolean S90() {
        AlbumViewModel r100 = this.f262163d;
        if (r100 == null) goto L9;
        PoiAlbumParams r101 = r100.getAlbumParams();
        if (r101 == null) goto L9;
        List<AlbumTabListModel> r102 = r101.getPhotoPageTabList();
        if (r102 == null) goto L9;
        int r103 = r102.size();
    L11:
        if (r103 > 1) goto L19;
        AlbumViewModel r104 = this.f262163d;
        if (r104 == null) goto L17;
        PoiAlbumParams r105 = r104.getAlbumParams();
        if (r105 == null) goto L17;
        boolean r106 = r105.getShowSingleLineFilterOnly();
    L18:
        if (r106 == true) goto L19;
        return false;
    L17:
        r106 = false;
    L19:
        return true;
    L9:
        r103 = 0;
        goto L11
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.locallife.photo.photopage.fragment.PoiAlbumContainerFragment$onPageChangeListener$1] */
    public PoiAlbumContainerFragment() {
        this.f262170k = new PoiAlbumContainerFragment$onPageChangeListener$1(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onHiddenChanged(boolean r100) {
        super.onHiddenChanged(r100);
        if (r100 == true) goto L10;
        PoiAlbumTagLayout r101 = this.f262164e;
        if (r101 == null) goto L11;
        PoiAlbumHorizontalTag r102 = r101.f262294e;
        if (r102 == null) goto L12;
        r102.a();
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void setUserVisibleHint(boolean r100) {
        super.setUserVisibleHint(r100);
        if (r100 == false) goto L24;
        AlbumViewModel r101 = this.f262163d;
        if (r101 == null) goto L11;
        MutableLiveData<List<TabInfo>> r102 = r101.getTabInfo();
        if (r102 == null) goto L11;
        List<TabInfo> r103 = r102.getValue();
        if (r103 == null) goto L11;
        int r104 = r103.size();
    L12:
        if (r104 <= 0) goto L18;
        PoiAlbumTagLayout r105 = this.f262164e;
        if (r105 == null) goto L18;
        FlowLayout r106 = r105.getFlowTagContainer();
        if (r106 == null) goto L18;
        r106.postDelayed(new b(this), 3000);
    L18:
        PoiAlbumTagLayout r107 = this.f262164e;
        if (r107 == null) goto L25;
        PoiAlbumHorizontalTag r108 = r107.f262294e;
        if (r108 == null) goto L26;
        r108.a();
        return;
    L26:
        return;
    L25:
        return;
    L11:
        r104 = 0;
        goto L12
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        this.f262163d = (AlbumViewModel) com.bytedance.locallife.common.utils.m.a(getActivity(), AlbumViewModel.class);
        MutableLiveData<RequestStatus> r102 = null;
        if (NetworkUtils.isNetworkAvailable(getContext()) == true) goto L10;
        AlbumViewModel r103 = this.f262163d;
        if (r103 == null) goto L7;
        r102 = r103.getTabRequestStatus();
    L7:
        if (r102 == null) goto L19;
        r102.setValue(RequestStatus.FAIL);
    L19:
        AlbumViewModel r104 = this.f262163d;
        if (r104 == null) goto L24;
        MutableLiveData<List<TabInfo>> r105 = r104.getTabInfo();
        if (r105 == null) goto L24;
        r105.observe(this, new h(this));
    L24:
        AlbumViewModel r106 = this.f262163d;
        if (r106 == null) goto L29;
        MutableLiveData<Boolean> r107 = r106.getHideAlbumUploadButton();
        if (r107 == null) goto L29;
        r107.observe(this, new i(this));
    L29:
        AlbumViewModel r108 = this.f262163d;
        if (r108 == null) goto L34;
        MutableLiveData<AlbumPageStatus> r109 = r108.getAlbumPageStatus();
        if (r109 == null) goto L34;
        r109.observe(this, new com.bytedance.locallife.photo.photopage.fragment.a(this));
    L34:
        AlbumViewModel r110 = this.f262163d;
        if (r110 == null) goto L39;
        MutableLiveData<Boolean> r111 = r110.getTabInfoReady();
        if (r111 == null) goto L39;
        r111.observe(this, new com.bytedance.locallife.photo.photopage.fragment.b(this));
    L39:
        AlbumViewModel r112 = this.f262163d;
        if (r112 == null) goto L44;
        MutableLiveData<RequestStatus> r113 = r112.getTabRequestStatus();
        if (r113 == null) goto L44;
        r113.observe(this, new c(this));
    L44:
        AlbumViewModel r114 = this.f262163d;
        if (r114 == null) goto L49;
        MutableLiveData<tv6.b> r115 = r114.getBottomLynxInfoTrip();
        if (r115 == null) goto L49;
        r115.observe(this, new d(this));
    L49:
        FragmentActivity r116 = getActivity();
        com.bytedance.ies.dmt.ui.widget.b r117 = new com.bytedance.ies.dmt.ui.widget.b();
        Context r118 = r116.getApplicationContext();
        r117.f248443a = R.drawable.img_s_s_network_error;
        r117.f248444b = r118.getResources().getDrawable(R.drawable.img_s_s_network_error);
        r117.f248451i = true;
        String r119 = r118.getString(R.string.uikit_network_error);
        r117.f248445c = r119;
        if (TextUtils.isEmpty(r119) == true) goto L65;
        r117.f248452j = true;
        r117.f248446d = r118.getString(R.string.uikit_check_and_retry);
        r117.f248453k = true;
        ButtonStyle r120 = ButtonStyle.BORDER;
        f r121 = new f(this);
        r117.f248447e = r120;
        r117.f248448f = r118.getString(R.string.uikit_retry);
        r117.f248449g = r121;
        r117.f248454l = true;
        FragmentActivity r122 = getActivity();
        com.bytedance.ies.dmt.ui.widget.b r123 = new com.bytedance.ies.dmt.ui.widget.b();
        Context r124 = r122.getApplicationContext();
        String r125 = r124.getString(R.string.poi_empty);
        r123.f248445c = r125;
        if (TextUtils.isEmpty(r125) == true) goto L63;
        r123.f248452j = true;
        r123.f248446d = r124.getString(R.string.poi_later);
        r123.f248453k = true;
        e r126 = new e(this);
        r123.f248447e = r120;
        r123.f248448f = r124.getString(R.string.uikit_retry);
        r123.f248449g = r126;
        r123.f248454l = true;
        DmtStatusView r127 = this.f262166g;
        if (r127 == null) goto L56;
        DmtStatusView.a r128 = DmtStatusView.a.a(getActivity());
        r128.e(r117);
        r128.c(r123);
        r127.setBuilder(r128);
    L56:
        DmtStatusView r129 = this.f262166g;
        if (r129 == null) goto L60;
        r129.setForceLightTheme(Boolean.TRUE);
    L60:
        ImmersionBar.with(this).statusBarColor(R.color.Transparent).statusBarDarkFont(true).init();
        return;
    L63:
        throw new IllegalArgumentException("title should not be empty string!");
    L65:
        throw new IllegalArgumentException("title should not be empty string!");
    L10:
        AlbumViewModel r130 = this.f262163d;
        if (r130 == null) goto L13;
        r102 = r130.getTabRequestStatus();
    L13:
        if (r102 == null) goto L16;
        r102.setValue(RequestStatus.LOADING);
    L16:
        AlbumViewModel r131 = this.f262163d;
        if (r131 == null) goto L19;
        r131.requestTabInfo();
        goto L19
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        int r103 = 0;
        View r104 = r100.inflate(R.layout.poi_fragment_poi_album_container, r101, false);
        View r105 = r104.findViewById(R.id.placeholder_view);
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        int r107 = zx6.c.f573889a;
        Resources r108 = Resources.getSystem();
        int r109 = r108.getIdentifier("status_bar_height", "dimen", "android");
        if (r109 <= 0) goto L5;
        r103 = r108.getDimensionPixelSize(r109);
    L5:
        r106.height = r103 + ((int) UIUtils.dip2Px(r104.getContext(), 44.0f));
        r105.setLayoutParams(r106);
        this.f262164e = (PoiAlbumTagLayout) r104.findViewById(R.id.album_tag_container);
        this.f262165f = (ScrollFlexViewPager) r104.findViewById(R.id.album_view_pager);
        this.f262166g = (DmtStatusView) r104.findViewById(R.id.status_view);
        LinearLayout r110 = (LinearLayout) r104.findViewById(R.id.upload_photos_button);
        this.f262167h = r110;
        if (r110 == null) goto L8;
        r110.setVisibility(8);
    L8:
        this.f262168i = (LinearLayout) r104.findViewById(R.id.float_container);
        FrameLayout r111 = (FrameLayout) r104.findViewById(R.id.bottom_lynx_container);
        this.f262169j = r111;
        if (r111 == null) goto L12;
        r111.setVisibility(8);
    L12:
        return r104;
    }
}
