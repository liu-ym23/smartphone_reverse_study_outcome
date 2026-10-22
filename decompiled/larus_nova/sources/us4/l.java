package us4;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.databinding.BitablePreviewNativeViewLayoutBinding;
import com.bytedance.ee.bear.bitable.homepage.preview.BoostCreateInfo;
import com.bytedance.ee.bear.bitable.homepage.preview.BoostViewData;
import com.bytedance.ee.bear.bitable.homepage.preview.HomePageBoostData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.BitableNativeViewContainer;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BitableNativeViewData;
import com.bytedance.ee.bear.bitable.uikit.Action;
import com.bytedance.ee.bear.facade.common.widget.RoundFrameLayout;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.utils.y0;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.UStringsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class l extends RoundFrameLayout implements gv4.b<BoostViewData> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData<BoostViewData> f551491g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LifecycleOwner f551492h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BitablePreviewNativeViewLayoutBinding f551493i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f551494j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f551495k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f551496l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f551497m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.bytedance.lark.lark_bitable_android.c f551498n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f551499o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public gv4.a f551500p;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f551501a;

        public a(l r100) {
            this.f551501a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            boolean r101 = !this.f551501a.getCollapsed();
            this.f551501a.g(r101);
            HashMap r102 = new HashMap();
            r102.put("click", "base_mobile_intro");
            if (r101 == false) goto L5;
            String r103 = "collapse";
        L6:
            r102.put("mobile_intro_type", r103);
            Integer r104 = null;
            ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).n("ccm_base_homepage_landing_click", r102);
            boolean r105 = !r101;
            BoostViewData r106 = this.f551501a.getLiveData().getValue();
            if (r106 == null) goto L11;
            HomePageBoostData r107 = r106.getBoostData();
            if (r107 == null) goto L11;
            String r108 = r107.getBaseToken();
        L12:
            BoostViewData r109 = this.f551501a.getLiveData().getValue();
            if (r109 == null) goto L17;
            HomePageBoostData r110 = r109.getBoostData();
            if (r110 == null) goto L17;
            r104 = r110.getStayDays();
        L17:
            k.b(true, r105, r108, r104);
            return;
        L11:
            r108 = null;
            goto L12
        L5:
            r103 = BitableAnalytic.LinkSceneClickType.EXPAND;
            goto L6
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f551502a;

        public b(l r100) {
            this.f551502a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            l.b(this.f551502a);
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f551503a;

        public c(l r100) {
            this.f551503a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            l r101 = this.f551503a;
            r101.f((BoostViewData) r100);
        }
    }

    public static final class d {
    }

    public static final class e implements gv4.a {
        public e() {
        }

        @Override // gv4.a
        public final void a(Action r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
        }
    }

    static {
    }

    private final com.bytedance.lark.lark_bitable_android.c getBitableAppContainer() {
        com.bytedance.lark.lark_bitable_android.c r100 = this.f551498n;
        if (r100 == null) goto L16;
        return r100;
    L16:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        Object r102 = Result.m9449constructorimpl(ULong.m9617boximpl(UStringsKt.toULong(com.bytedance.ee.bear.contract.a.a().docDynamicConfig().f216922f.f216928a)));     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r102) == false) goto L12;
        r102 = null;
    L12:
        ULong r103 = (ULong) r102;
        if (r103 == null) goto L18;
        com.bytedance.lark.lark_bitable_android.c r104 = new com.bytedance.lark.lark_bitable_android.c(r103.m9675unboximpl());
        this.f551498n = r104;
        return r104;
    L18:
        return null;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final void d() {
        BoostViewData r100 = this.f551491g.getValue();
        if (r100 == null) goto L10;
        HomePageBoostData r101 = r100.getBoostData();
        if (r101 == null) goto L11;
        String r102 = r101.getUrl();
        if (r102 == null) goto L12;
        e(r102);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final float getInitRotation() {
        if (this.f551496l == false) goto L5;
        return 0.0f;
    L5:
        return 180.0f;
    }

    public final int getTargetHeight() {
        if (this.f551496l == false) goto L6;
        return this.f551495k;
    L6:
        return this.f551494j;
    }

    public final float getTargetRotation() {
        if (this.f551496l == false) goto L5;
        return 180.0f;
    L5:
        return 360.0f;
    }

    public final void h() {
        BoostViewData r100 = this.f551491g.getValue();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getFromCache() == false) goto L7;
        return;
    L7:
        if (r100.isValid() == false) goto L12;
        j.b(r100.getCacheObject(this.f551496l));
        return;
    }

    public final void c() {
        if (getVisibility() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        com.bytedance.ee.bear.bitable.m.z(this, true);
        com.bytedance.ee.bear.bitable.m.p(this.f551493i.f211016f, getTargetHeight(), false);
        this.f551493i.f211013c.setRotation(getTargetRotation());
        return;
    L5:
        r100 = false;
        goto L6
    }

    public final BitablePreviewNativeViewLayoutBinding getBinding() {
        return this.f551493i;
    }

    public final boolean getCollapsed() {
        return this.f551496l;
    }

    public final int getCollapsedHeight() {
        return this.f551495k;
    }

    public final int getFinalHeight() {
        return this.f551494j;
    }

    @Override // android.view.View
    public final gv4.a getHandler() {
        return this.f551500p;
    }

    public final String getHasShowToken() {
        return this.f551497m;
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this.f551492h;
    }

    public final MutableLiveData<BoostViewData> getLiveData() {
        return this.f551491g;
    }

    public static final void b(l r110) {
        r110.getClass();
        int r100 = com.bytedance.ee.bear.bitable.c.f207079a;
        int r101 = com.bytedance.ee.bear.bitable.n.f214744a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.homepageboost_mobile.create_enable") == false) goto L48;
        BoostViewData r102 = r110.f551491g.getValue();
        if (r102 == null) goto L9;
        HomePageBoostData r103 = r102.getBoostData();
        if (r103 == null) goto L9;
        BoostCreateInfo r104 = r103.getBoostCreateInfo();
    L10:
        if (r104 != null) goto L12;
        r110.d();
        return;
    L12:
        int r105 = r104.getType();
        boolean r106 = false;
        if (r105 == 0) goto L39;
        if (r105 == 1) goto L39;
        if (r105 == 2) goto L19;
        r110.d();
        return;
    L19:
        if (TextUtils.isEmpty(r104.getSkuID()) == false) goto L22;
        tt5.a.h("BitableBoostViewContainer", "handleBoostAction invalid skuID");
        r110.d();
        return;
    L22:
        if (r110.f551499o == false) goto L24;
        tt5.a.h("BitableBoostViewContainer", "tryStartBoostCreate ignored duplicate click");
        boolean r107 = false;
    L25:
        if (r107 == false) goto L60;
        com.bytedance.lark.lark_bitable_android.c r108 = r110.getBitableAppContainer();
        if (r108 != null) goto L30;
        r110.f551499o = false;
        tt5.a.d("BitableBoostViewContainer", "createMarketplaceBitable get app container failed");
        Toast.showFailureText(r110.getContext(), R.string.Doc_Facade_CreateFailed);
        return;
    L30:
        Map r109 = MapsKt.mapOf(new Pair[]{TuplesKt.to("skuID", r104.getSkuID()), TuplesKt.to("mountPoint", ""), TuplesKt.to("workspace_title", r104.getName()), TuplesKt.to("createSource", "147")});
        Toast.showLoading(r110.getContext(), r110.getContext().getString(R.string.Doc_List_TemplateCreateLoading));
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L33
        r108.d(r109, new p(r110));     // Catch: Throwable -> L33
        Object r112 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L33
    L35:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L56;
        r110.f551499o = false;
        Toast.cancelLoading();
        tt5.a.e("BitableBoostViewContainer", "createMarketplaceBitable invoke installMarketplace failed", r113, false);
        Toast.showFailureText(r110.getContext(), R.string.Doc_Facade_CreateFailed);
        return;
    L56:
        return;
    L33:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L35
    L60:
        return;
    L24:
        r110.f551499o = true;
        r107 = true;
    L39:
        if (TextUtils.isEmpty(r104.getToken()) == false) goto L42;
        tt5.a.h("BitableBoostViewContainer", "handleBoostAction invalid token");
        r110.d();
        return;
    L42:
        if (r110.f551499o == false) goto L44;
        tt5.a.h("BitableBoostViewContainer", "tryStartBoostCreate ignored duplicate click");
    L45:
        if (r106 == false) goto L61;
        Toast.showLoading(r110.getContext(), r110.getContext().getString(R.string.Doc_List_TemplateCreateLoading));
        ((er5.b) org.koin.java.a.c(er5.b.class, null, null, 6)).k(new er5.a(null, true, r104.getToken(), null, r104.getName(), 147, 25)).observeOn(AndroidSchedulers.mainThread()).doFinally(new m(r110)).subscribe(new n(r110), new o(r110));
        return;
    L61:
        return;
    L44:
        r110.f551499o = true;
        r106 = true;
    L9:
        r104 = null;
        goto L10
    L48:
        r110.d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        int r101 = r100.getAction();
        boolean r102 = false;
        if (r101 == 0) goto L11;
        if (r101 != 1) goto L6;
    L8:
        ViewParent r103 = getParent();
        if (r103 == null) goto L30;
        r103.requestDisallowInterceptTouchEvent(false);
    L30:
        return super.dispatchTouchEvent(r100);
    L6:
        if (r101 == 3) goto L8;
    L11:
        MutableLiveData<BoostViewData> r104 = this.f551491g;
        if (r104 == null) goto L22;
        BoostViewData r105 = r104.getValue();
        if (r105 == null) goto L22;
        BitableNativeViewData r106 = r105.getNativeViewData();
        if (r106 == null) goto L22;
        BaseViewData<?, ?> r107 = r106.getData();
        if (r107 == null) goto L22;
        HashMap<String, T> r108 = r107.getRecordDataMap();
        if (r108 == 0) goto L22;
        int r109 = r108.size();
    L23:
        if (r109 <= 1) goto L25;
        r102 = true;
    L25:
        if (r102 == false) goto L30;
        ViewParent r110 = getParent();
        if (r110 == null) goto L30;
        r110.requestDisallowInterceptTouchEvent(true);
    L22:
        r109 = 0;
        goto L23
    }

    public final void e(String r100) {
        ((com.bytedance.ee.bear.route.h) e0c.k.a(LarkContext.getApplication(), com.bytedance.ee.bear.route.h.class)).u5(r100);
        HashMap r101 = new HashMap();
        r101.put("click", "base_mobile_intro_full");
        r101.put(PickerReporterConstants.KEY.TARGET, "ccm_base_homepage_mobile_intro_view");
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).n("ccm_base_homepage_landing_click", r101);
    }

    public final void f(BoostViewData r110) {
        Integer r100 = null;
        if (r110 == null) goto L27;
        if (y0.d(this.f551497m) == false) goto L7;
    L9:
        boolean r101 = false;
    L10:
        this.f551497m = r110.getBoostData().getBaseToken();
        this.f551493i.f211017g.setText(r110.getBoostData().getTitle());
        BitableNativeViewData r102 = r110.getNativeViewData();
        Object r103 = this.f551492h;
        if ((r103 instanceof Activity) == false) goto L13;
        Activity r104 = (Activity) r103;
    L14:
        this.f551493i.f211015e.j(r104, r102, this.f551500p, null, true);
        if (r110.getFromCache() == false) goto L21;
        Boolean r105 = r110.getCollapsed();
        if (r105 == null) goto L19;
        boolean r106 = r105.booleanValue();
    L20:
        this.f551496l = r106;
        c();
    L29:
        if (r110 != null) goto L31;
    L33:
        boolean r111 = false;
    L34:
        if (r111 == false) goto L54;
        BoostViewData r112 = this.f551491g.getValue();
        if (r112 == null) goto L40;
        HomePageBoostData r113 = r112.getBoostData();
        if (r113 == null) goto L40;
        String r114 = r113.getBaseToken();
    L41:
        k.a(r114);
        boolean r115 = !this.f551496l;
        BoostViewData r107 = this.f551491g.getValue();
        if (r107 == null) goto L46;
        HomePageBoostData r108 = r107.getBoostData();
        if (r108 == null) goto L46;
        String r109 = r108.getBaseToken();
    L47:
        BoostViewData r116 = this.f551491g.getValue();
        if (r116 == null) goto L52;
        HomePageBoostData r117 = r116.getBoostData();
        if (r117 == null) goto L52;
        r100 = r117.getStayDays();
    L52:
        k.b(true, r115, r109, r100);
        return;
    L46:
        r109 = null;
    L40:
        r114 = null;
        goto L41
    L54:
        if (TextUtils.isEmpty(this.f551497m) == true) goto L61;
        k.a(this.f551497m);
        boolean r118 = !this.f551496l;
        String r119 = this.f551497m;
        BoostViewData r120 = this.f551491g.getValue();
        if (r120 == null) goto L60;
        HomePageBoostData r121 = r120.getBoostData();
        if (r121 == null) goto L60;
        r100 = r121.getStayDays();
    L60:
        k.b(true, r118, r119, r100);
        return;
    L61:
        k.b(false, true, "", 0);
        return;
    L31:
        if (r110.getFromCache() == true) goto L33;
        r111 = true;
        goto L34
    L19:
        r106 = false;
        goto L20
    L21:
        if (r101 == true) goto L23;
    L25:
        c();
        h();
        goto L29
    L23:
        if (this.f551496l == false) goto L25;
        c();
        g(false);
        goto L29
    L13:
        r104 = null;
        goto L14
    L7:
        if (y0.a(this.f551497m, r110.getBoostData().getBaseToken()) == true) goto L9;
        r101 = true;
        goto L10
    L27:
        if (this.f551497m != null) goto L29;
        com.bytedance.ee.bear.bitable.m.z(this, false);
        com.bytedance.ee.bear.bitable.m.p(this.f551493i.f211016f, 0, false);
        goto L29
    }

    public final void g(boolean r100) {
        this.f551496l = r100;
        com.bytedance.ee.bear.bitable.m.b(this.f551493i.f211016f, getTargetHeight());
        AppCompatImageView r101 = this.f551493i.f211013c;
        float r102 = getTargetRotation();
        Float r103 = Float.valueOf(getInitRotation());
        Intrinsics.checkNotNullParameter(r101, "<this>");
        if (r103 == null) goto L5;
        r101.setRotation(r103.floatValue());
    L5:
        r101.animate().rotation(r102).setDuration(300).start();
        h();
    }

    public final void setBinding(BitablePreviewNativeViewLayoutBinding r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f551493i = r100;
    }

    public final void setCollapsed(boolean r100) {
        this.f551496l = r100;
    }

    public final void setCollapsedHeight(int r100) {
        this.f551495k = r100;
    }

    public final void setFinalHeight(int r100) {
        this.f551494j = r100;
    }

    public final void setHandler(gv4.a r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f551500p = r100;
    }

    public final void setHasShowToken(String r100) {
        this.f551497m = r100;
    }

    public l(Context r110, MutableLiveData<BoostViewData> r111, LifecycleOwner r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "liveData");
        Intrinsics.checkNotNullParameter(r112, "lifecycleOwner");
        super(r110, null);
        this.f551491g = r111;
        this.f551492h = r112;
        this.f551494j = com.bytedance.ee.util.ui.n.d(315);
        this.f551495k = com.bytedance.ee.util.ui.n.d(56);
        this.f551500p = new e();
        View r113 = LayoutInflater.from(r110).inflate(R.layout.bitable_preview_native_view_layout, this, false);
        addView(r113);
        int r100 = R.id.click_layout;
        View r101 = ViewBindings.findChildViewById(r113, R.id.click_layout);
        if (r101 == null) goto L20;
        r100 = R.id.icon;
        AppCompatImageView r102 = (AppCompatImageView) ViewBindings.findChildViewById(r113, R.id.icon);
        if (r102 == null) goto L20;
        r100 = R.id.icon_container;
        FrameLayout r114 = (FrameLayout) ViewBindings.findChildViewById(r113, R.id.icon_container);
        if (r114 == null) goto L20;
        r100 = R.id.native_view_container;
        BitableNativeViewContainer r103 = (BitableNativeViewContainer) ViewBindings.findChildViewById(r113, R.id.native_view_container);
        if (r103 == null) goto L20;
        LinearLayout r104 = (LinearLayout) r113;
        r100 = R.id.title_container;
        if (((LinearLayout) ViewBindings.findChildViewById(r113, R.id.title_container)) == null) goto L20;
        r100 = R.id.title_tv;
        TextView r115 = (TextView) ViewBindings.findChildViewById(r113, R.id.title_tv);
        if (r115 == null) goto L20;
        this.f551493i = new BitablePreviewNativeViewLayoutBinding(r104, r101, r102, r114, r103, r104, r115);
        r114.setOnClickListener(new a(this));
        this.f551493i.f211012b.setOnClickListener(new b(this));
        com.bytedance.ee.bear.bitable.m.z(this, false);
        if (r111.getValue() != null) goto L17;
        f(null);
    L17:
        r111.observe(r112, new c(this));
        return;
    L20:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r100)));
    }
}
