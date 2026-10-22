package com.ss.android.lark.locationmessage.ui.navigation;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.mvp.IView;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.biz.im.api.LocationInfo;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.location.dto.POIInfo;
import com.ss.android.lark.location.dto.Scene;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes36.dex */
public class NavigateView implements IView {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String[] f431337p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Token f431338q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f431339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Activity f431340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f431341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f431342d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Token f431343e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Scene f431344f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f431345g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Message f431346h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LocationInfo f431347i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f431348j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Double f431349k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Double f431350l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f431351m;

    @BindView(9432)
    View mBottomLayout;

    @BindView(9430)
    LinearLayout mContainerLayout;

    @BindView(9492)
    ImageView mIvBack;

    @BindView(9426)
    ImageView mIvGoToNavigate;

    @BindView(9427)
    ImageView mIvLocatePosition;

    @BindView(9493)
    ImageView mIvMore;

    @BindView(9439)
    TextView mTvNavigateDesc;

    @BindView(9440)
    TextView mTvNavigateTitle;

    @BindView(9992)
    TextView mTvRequestPermission;

    @BindView(9494)
    View mViewTitleBar;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String[] f431352n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.ss.android.lark.location.service.d f431353o;

    public interface a {
    }

    public interface b {
    }

    static {
        f431337p = new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
        f431338q = new Token("LARK-PSDA-message_location_navigate_view_check_location");
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        if (this.f431341c != null) goto L10;
        Activity r100 = this.f431340b;
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.isFinishing() == true) goto L58;
        this.f431340b.finish();
        return;
    L58:
        return;
    L10:
        LocationInfo r101 = this.f431347i;
        if (r101 != null) goto L13;
        boolean r102 = false;
    L21:
        if (r102 == true) goto L28;
        Activity r103 = this.f431340b;
        if (r103 != null) goto L25;
        return;
    L25:
        if (r103.isFinishing() == true) goto L60;
        this.f431340b.finish();
        return;
    L60:
        return;
    L28:
        com.ss.android.lark.location.service.d r104 = com.ss.android.lark.location.service.f.a().getLocationMessageMap();
        this.f431353o = r104;
        if (r104 != null) goto L36;
        Activity r105 = this.f431340b;
        if (r105 != null) goto L33;
        return;
    L33:
        if (r105.isFinishing() == true) goto L62;
        this.f431340b.finish();
        return;
    L62:
        return;
    L36:
        ButterKnife.bind(this, ((NavigateFragment.a) this.f431341c).f431336a.f431330d);
        this.mIvGoToNavigate.setVisibility(0);
        Context r106 = lqb.b.f510384a.getContext();
        POIInfo r107 = new POIInfo(oqb.c.a(this.f431347i.getLatitude()), oqb.c.a(this.f431347i.getLongitude()), this.f431347i.getCoordinateSystem());
        r107.setLocationName(this.f431347i.getName());
        r107.setLocationAddress(this.f431347i.getDesc());
        r107.setZoomLevel(this.f431347i.getZoomLevel());
        View r108 = this.f431353o.q(r106, null, r107);
        LinearLayout.LayoutParams r109 = new LinearLayout.LayoutParams(-1, -1);
        this.mContainerLayout.addView(r108, r109);
        if (TextUtils.isEmpty(this.f431347i.getName()) == false) goto L39;
        String r110 = "";
    L40:
        this.mTvNavigateTitle.setText(r110);
        String r111 = this.f431347i.getDesc();
        if (TextUtils.isEmpty(r111) == false) goto L43;
        this.mTvNavigateDesc.setVisibility(8);
    L44:
        this.mIvBack.setOnClickListener(new p(this));
        if (this.f431347i.isHideTitleBar() == false) goto L47;
    L49:
        this.mIvMore.setVisibility(8);
    L50:
        this.mIvLocatePosition.setOnClickListener(new s(this));
        this.mTvRequestPermission.setOnClickListener(new k(this));
        this.mIvGoToNavigate.setOnClickListener(new t(this));
        this.f431353o.b();
        View r112 = this.f431340b.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L55;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r113 = ThreadMethodProxy.currentThread();
        if (r113 == com.larus.home.impl.utils.c.f346341a) goto L55;
        com.larus.home.impl.utils.c.a(r113, "getDecorView");
    L55:
        r112.post(new i(this));
        return;
    L47:
        if (this.f431347i.isSecretChat() == true) goto L49;
        this.mIvMore.setVisibility(0);
        this.mIvMore.setOnClickListener(new q(this));
        goto L50
    L43:
        this.mTvNavigateDesc.setVisibility(0);
        this.mTvNavigateDesc.setText(r111);
        goto L44
    L39:
        r110 = this.f431347i.getName();
        goto L40
    L13:
        this.f431346h = r101.getMessage();
        this.f431348j = ((NavigateFragment.a) this.f431341c).f431336a.f431333g;
        this.f431352n[0] = this.f431340b.getString(R.string.Lark_Legacy_Forward);
        r102 = true;
        if (this.f431351m == false) goto L20;
        String[] r114 = this.f431352n;
        if (this.f431348j != null) goto L18;
        String r115 = this.f431340b.getString(R.string.Lark_Legacy_SaveToFavorite);
    L19:
        r114[1] = r115;
        this.f431352n[2] = this.f431340b.getString(R.string.Lark_Legacy_Cancel);
        goto L21
    L18:
        r115 = this.f431340b.getString(R.string.Lark_Legacy_Remove);
        goto L19
    L20:
        this.f431352n[1] = this.f431340b.getString(R.string.Lark_Legacy_Cancel);
        goto L21
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        com.ss.android.lark.location.service.d r100 = this.f431353o;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.onDestroy();
    }

    public final void h(final ValueCallback<Boolean> r100) {
        Activity r101 = this.f431340b;
        if (ContextCompat.checkSelfPermission(r101, "android.permission.ACCESS_FINE_LOCATION") != 0) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        r100.onReceiveValue(Boolean.TRUE);
        return;
    L12:
        new o0c.c(this.f431340b).e(f431338q, f431337p).any(new l()).subscribe(new m(this, r100));
        return;
    L5:
        if (ContextCompat.checkSelfPermission(r101, "android.permission.ACCESS_COARSE_LOCATION") == 0) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f431342d = (c) r100;
    }

    public NavigateView(FragmentActivity r100, View r101, Token r102, Scene r103, NavigateFragment.a r104, LocationInfo r105, String r106) {
        this.f431340b = r100;
        this.f431339a = (ViewGroup) r101;
        this.f431341c = r104;
        this.f431347i = r105;
        this.f431343e = r102;
        this.f431344f = r103;
        this.f431345g = r106;
        boolean r107 = !LarkAppContext.inst().buildConfig().isOfficeSDK();
        this.f431351m = r107;
        if (r107 == false) goto L5;
        int r108 = 3;
    L6:
        this.f431352n = new String[r108];
        return;
    L5:
        r108 = 2;
        goto L6
    }
}
