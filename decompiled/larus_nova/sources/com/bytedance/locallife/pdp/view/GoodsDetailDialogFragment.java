package com.bytedance.locallife.pdp.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.biz.utils.ToastUtils;
import com.bytedance.locallife.cube.api.model.PublishEvent;
import com.bytedance.locallife.cube.api.model.PublishEventKt;
import com.bytedance.locallife.dito.core.DitoFragment;
import com.bytedance.locallife.dito.core.DitoInteractDialogFragment;
import com.bytedance.locallife.dito.core.viewmodel.DitoDataCenter;
import com.bytedance.locallife.dito.core.viewmodel.DitoViewModelManager;
import com.bytedance.locallife.dito.interact.CustomBottomBehavior;
import com.bytedance.locallife.live.model.LiveLocalLifeRoomInfo;
import com.bytedance.locallife.pdp.GoodsDetailContainerViewModel;
import com.bytedance.locallife.pdp.container.GoodsDetailBizContainerFragment;
import com.bytedance.locallife.pdp.container.GoodsDetailPage;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.passport.signinsdk_api.base.log.UniContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.poi.event.GoodsDetailHalfContainerStateEvent;
import com.ss.android.ugc.aweme.poi.event.GoodsDialogState;
import com.ss.android.ugc.aweme.poi.event.PoiCloseLiveAdLandingPageEvent;
import com.ss.android.ugc.aweme.poi.listener.IPoiTradeGoodsDialogCloseListener;
import com.ss.android.ugc.aweme.poi.listener.OnLifePanelShowHeightChangeListener;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import com.ss.android.ugc.aweme.trade.goods.MainFeedUnderGoodsPageStatusStorage;
import com.ss.android.ugc.aweme.trade.goods.entity.PoiTradeSettingEntity;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001\rB\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\tH\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/locallife/pdp/view/GoodsDetailDialogFragment;", "Lcom/bytedance/locallife/dito/core/DitoInteractDialogFragment;", "Lcom/bytedance/locallife/pdp/c;", "Landroid/view/View;", "Lcom/bytedance/locallife/pdp/a;", "Lcom/ss/android/ugc/aweme/poi/event/PoiCloseLiveAdLandingPageEvent;", "event", "", "onReceiveCloseLiveAdLandingPageEvent", "Lcom/bytedance/locallife/cube/api/model/PublishEvent;", "onPublishEvent", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public class GoodsDetailDialogFragment extends DitoInteractDialogFragment implements com.bytedance.locallife.pdp.c<View>, com.bytedance.locallife.pdp.a {
    public static final /* synthetic */ int E = 0;
    public int A;
    public int B;
    public int C;
    public CustomBottomBehavior<View> D;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f261755d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f261756e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f261757f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f261758g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f261759h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f261760i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f261761j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Uri f261762k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f261763l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Map<String, String> f261764m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f261765n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f261766o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Handler f261767p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f261768q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f261769r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f261770s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f261771t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f261772u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public IPoiTradeGoodsDialogCloseListener f261773v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public OnLifePanelShowHeightChangeListener f261774w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public GoodsDetailPage f261775x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f261776y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f261777z;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GoodsDetailDialogFragment f261778a;

        public b(GoodsDetailDialogFragment r100) {
            this.f261778a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            CustomBottomBehavior<View> r102 = this.f261778a.D;
            if (r102 == null) goto L6;
            r102.setState(5);
            return;
        }
    }

    public static final class c implements com.bytedance.locallife.dito.core.f0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GoodsDetailDialogFragment f261779a;

        public c(GoodsDetailDialogFragment r100) {
            this.f261779a = r100;
        }

        @Override // com.bytedance.locallife.dito.core.f0
        public final void C2(boolean r100) {
            this.f261779a.getClass();
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GoodsDetailDialogFragment f261780a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f261781b;

        public d(GoodsDetailDialogFragment r100, FrameLayout r101) {
            this.f261780a = r100;
            this.f261781b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            HostServiceUtilsKt.u0().a(this.f261780a, this.f261781b, new HashMap());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GoodsDetailDialogFragment f261782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f261783b;

        public e(GoodsDetailDialogFragment r100, FrameLayout r101) {
            this.f261782a = r100;
            this.f261783b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            it6.i r100 = HostServiceUtilsKt.u0();     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.f(this.f261782a, this.f261783b);     // Catch: Throwable -> L6
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

    @Override // com.bytedance.locallife.pdp.c
    public final void He() {
        this.D = null;
    }

    @Override // com.bytedance.locallife.pdp.c
    public final void IV() {
    }

    private final void X90() {
        Map<String, String> r100 = this.f261764m;
        FrameLayout r101 = null;
        if (r100 == null) goto L5;
        String r102 = (String) ((LinkedHashMap) r100).get("enter_from");
    L7:
        if (Intrinsics.areEqual(r102, "livebroadcasting") == true) goto L9;
        return;
    L9:
        if (this.f261771t == true) goto L11;
        return;
    L11:
        if (this.f261760i == true) goto L26;
        View r103 = getView();
        if (r103 == null) goto L16;
        View r104 = r103.getRootView();
    L18:
        if ((r104 instanceof FrameLayout) == false) goto L20;
        r101 = (FrameLayout) r104;
    L20:
        if (r101 == null) goto L22;
        this.f261767p.post(new e(this, r101));
    L22:
        this.f261771t = false;
        return;
    L16:
        r104 = null;
        goto L18
    L26:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.locallife.pdp.c
    public final CustomBottomBehavior Qt() {
        CustomBottomBehavior<View> r100 = this.D;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Context r101 = getContext();
        if (r101 != null) goto L9;
        return null;
    L9:
        if (this.f261759h == false) goto L15;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (0.0f < 0) goto L14;
        CustomBottomBehavior<View> r102 = new CustomBottomBehavior(r101, null);
        r102.D = true;
        r102.G = false;
        r102.I = false;
        r102.f258390J = true;
        r102.M = true;
        r102.O = 0.5f;
        r102.f258322g = 0.0f;
        r102.T = false;
        r102.S = false;
    L18:
        r102.Z = true;
        this.D = r102;
        r102.m(0);
        r102.f258392k = 0;
        U90(r102.f258318c);
        r102.setState(4);
        V90();
        r102.a(new com.bytedance.locallife.pdp.view.c(this, r101));
        com.bytedance.locallife.pdp.view.d r103 = new com.bytedance.locallife.pdp.view.d(this);
        Intrinsics.checkNotNullParameter(r103, "l");
        r102.f258321f = r103;
        return r102;
    L14:
        throw new IllegalArgumentException("flingHideFriction不能小于0");
    L15:
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r104 = this.f261769r;
        if (0.0f < 0) goto L21;
        CustomBottomBehavior<View> r105 = new CustomBottomBehavior(r101, null);
        r105.D = r104;
        r105.G = true;
        r105.I = true;
        r105.f258390J = true;
        r105.M = false;
        r105.O = 0.5f;
        r105.f258322g = 0.0f;
        r105.T = false;
        r105.S = false;
        r102 = r105;
        goto L18
    L21:
        throw new IllegalArgumentException("flingHideFriction不能小于0");
    }

    public final void W90() {
        Map<String, String> r100 = this.f261764m;
        FrameLayout r101 = null;
        if (r100 == null) goto L5;
        String r102 = (String) ((LinkedHashMap) r100).get("enter_from");
    L7:
        if (Intrinsics.areEqual(r102, "livebroadcasting") == true) goto L9;
        return;
    L9:
        if (this.f261771t == false) goto L11;
        return;
    L11:
        if (this.f261760i == true) goto L26;
        View r103 = getView();
        if (r103 == null) goto L16;
        View r104 = r103.getRootView();
    L18:
        if ((r104 instanceof FrameLayout) == false) goto L20;
        r101 = (FrameLayout) r104;
    L20:
        if (r101 == null) goto L22;
        this.f261767p.post(new d(this, r101));
    L22:
        this.f261771t = true;
        return;
    L16:
        r104 = null;
        goto L18
    L26:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.locallife.pdp.a
    public final void fw() {
        CustomBottomBehavior<View> r100 = this.D;
        if (r100 == null) goto L6;
        r100.setState(5);
        return;
    }

    public GoodsDetailDialogFragment() {
        this.f261766o = this.f261765n;
        this.f261767p = new Handler(Looper.getMainLooper());
        this.f261769r = true;
        this.f261770s = "";
        this.f261776y = LazyKt.lazy(new GoodsDetailDialogFragment$mGoodsDetailVM$2(this));
        this.f261777z = LazyKt.lazy(new GoodsDetailDialogFragment$dynamicViewManager$2(this));
        this.A = -1;
    }

    private final int T90() {
        int r100 = getResources().getConfiguration().orientation;
        int r101 = com.bytedance.locallife.biz.common.utils.e.a();
        int r102 = com.bytedance.locallife.biz.common.utils.e.b();
        if (r100 != 2) goto L6;
        return Math.min(r101, r102);
    L6:
        return Math.max(r101, r102);
    }

    public final void V90() {
        this.C = (T90() * this.f261756e) / 100;
        GoodsDetailContainerViewModel r100 = (GoodsDetailContainerViewModel) this.f261776y.getValue();
        if (this.f261760i == false) goto L5;
        int r101 = 0;
    L6:
        r100.setMaskingHeight(r101);
        ((GoodsDetailContainerViewModel) this.f261776y.getValue()).setPopupHeight(this.C);
        CustomBottomBehavior<View> r102 = this.D;
        if (r102 == null) goto L10;
        r102.setPeekHeight(this.C, false);
        return;
    L10:
        return;
    L5:
        r101 = T90() - this.C;
        goto L6
    }

    @Override // com.bytedance.locallife.dito.core.DitoInteractDialogFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        Map<String, String> r100 = this.f261764m;
        if (r100 == null) goto L5;
        String r101 = (String) ((LinkedHashMap) r100).get("enter_from_flag");
    L7:
        if (TextUtils.equals(r101, "trade_anchor") == false) goto L11;
        IPoiTradeGoodsDialogCloseListener r102 = this.f261773v;
        if (r102 == null) goto L11;
        r102.onClose();
    L11:
        vn6.b.c(this);
        if (this.f261766o != 4) goto L16;
        it6.i r103 = HostServiceUtilsKt.u0();
        if (r103 == null) goto L20;
        r103.c(4);
    L20:
        if (this.f261761j == false) goto L22;
        HostServiceUtilsKt.R().s();
    L22:
        FragmentActivity r104 = getActivity();
        String r105 = "";
        if (r104 == null) goto L26;
        String r106 = r104.getLocalClassName();
        if (r106 == null) goto L26;
    L27:
        GoodsDialogState r107 = GoodsDialogState.CLOSE;
        Bundle r108 = getArguments();
        if (r108 == null) goto L30;
        r108.getString("extra_json_str", "");
    L30:
        vn6.b.a(new GoodsDetailHalfContainerStateEvent(r106, r107));
        Event r109 = new Event("event_live_maybe_exit_to_preview", System.currentTimeMillis(), null, 4, null);
        LinkedHashMap r110 = new LinkedHashMap();
        r110.put("source", "open_goods_detail");
        FragmentActivity r111 = getActivity();
        if (r111 == null) goto L36;
        String r112 = r111.getLocalClassName();
        if (r112 == null) goto L36;
        r105 = r112;
    L36:
        r110.put("special_params", r105);
        r109.setMapParams(r110);
        EventCenter.enqueueEvent(r109);
        return;
    L26:
        r106 = "";
        goto L27
    L16:
        it6.i r113 = HostServiceUtilsKt.u0();
        if (r113 == null) goto L20;
        r113.c(5);
        goto L20
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.bytedance.locallife.dito.core.DitoInteractDialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        MainFeedUnderGoodsPageStatusStorage.f454346a.getClass();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        Boolean r100 = HostServiceUtilsKt.u0().l();
        if (Intrinsics.areEqual(Boolean.TRUE, r100) == true) goto L5;
        return;
    L5:
        if (this.f261771t == false) goto L7;
        this.f261772u = true;
    L7:
        X90();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.f261772u == false) goto L5;
        this.f261772u = false;
        W90();
    L5:
        Map<String, String> r100 = this.f261764m;
        if (r100 == null) goto L8;
        String r101 = (String) ((LinkedHashMap) r100).get("enter_from_flag");
    L10:
        if (TextUtils.equals(r101, "trade_anchor") == false) goto L13;
        MainFeedUnderGoodsPageStatusStorage.f454346a.getClass();
        return;
    L13:
        return;
    L8:
        r101 = null;
        goto L10
    }

    @Override // com.bytedance.locallife.dito.core.DitoInteractDialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        it6.i r100 = HostServiceUtilsKt.u0();
        FragmentActivity r101 = getActivity();
        com.bytedance.locallife.dito.core.f r102 = getMDialog();
        if (r102 == null) goto L5;
        Window r103 = r102.getWindow();
    L6:
        r100.i(r101, r103);
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.locallife.dito.core.DitoInteractDialogFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        it6.i r100 = HostServiceUtilsKt.u0();
        FragmentActivity r101 = getActivity();
        com.bytedance.locallife.dito.core.f r102 = getMDialog();
        if (r102 == null) goto L5;
        Window r103 = r102.getWindow();
    L6:
        r100.g(r101, r103);
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.locallife.pdp.c
    public final CustomBottomBehavior Am() {
        return this.D;
    }

    public static final /* synthetic */ void S90(GoodsDetailDialogFragment r100) {
        r100.X90();
    }

    public final void U90(int r100) {
        DitoViewModelManager r101 = (DitoViewModelManager) this.f261777z.getValue();
        GoodsDetailPage r102 = this.f261775x;
        MutableLiveData<JSONObject> r103 = null;
        if (r102 == null) goto L5;
        DitoFragment r104 = r102.getFragment();
    L6:
        DitoDataCenter r105 = r101.getDataCenter(r104);
        if (r105 == null) goto L9;
        int r106 = DitoDataCenter.f258004d;
        r103 = r105.a0("dialog_state_event", 1);
    L9:
        if (r103 == null) goto L12;
        JSONObject r107 = new JSONObject();
        r107.put("state", r100);
        r103.setValue(r107);
        return;
    L12:
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.bytedance.locallife.dito.core.DitoInteractDialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r110) {
        super.onActivityCreated(r110);
        com.bytedance.locallife.dito.view.e r111 = (DitoFragment) getChildFragmentManager().findFragmentByTag("com.bytedance.locallife.pdp.GoodsDetailPage");
        if ((r111 instanceof GoodsDetailPage) == false) goto L6;
        this.f261775x = (GoodsDetailPage) r111;
    L6:
        if (this.f261775x != null) goto L12;
        int r112 = com.bytedance.locallife.pdp.container.f0.f261147a;
        GoodsDetailBizContainerFragment r113 = com.bytedance.locallife.pdp.container.f0.a.a(new com.bytedance.locallife.pdp.container.y(this.f261755d, false, this.f261760i, this.f261762k, this, this, this, this.f261763l, 256));
        this.f261775x = r113;
        FragmentTransaction r100 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r100, r113, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "com.bytedance.locallife.pdp.GoodsDetailPage", R.id.poi_dito_dialog_fragment_layout) == true) goto L11;
        r100 = r100.add(R.id.poi_dito_dialog_fragment_layout, r113, "com.bytedance.locallife.pdp.GoodsDetailPage");
    L11:
        r100.commitAllowingStateLoss();
    L12:
        ((GoodsDetailContainerViewModel) this.f261776y.getValue()).getBackEvent().observe(this, new b(this));
        ((GoodsDetailContainerViewModel) this.f261776y.getValue()).setRouterUri(this.f261762k);
        ((GoodsDetailContainerViewModel) this.f261776y.getValue()).getTitleBarFloat().observe(this, new com.bytedance.locallife.pdp.view.e(this));
    }

    @Override // com.bytedance.locallife.dito.core.DitoInteractDialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r110) {
        super.onCreate(r110);
        Bundle r111 = getArguments();
        Integer r100 = null;
        if (r111 == null) goto L5;
        Uri r112 = UriProtector.parse(r111.getString("router_uri"));
    L6:
        ww6.c r101 = ww6.c.f561630a;
        int r102 = com.bytedance.locallife.pdp.container.g0.f261152a;
        if (r101.a(com.bytedance.locallife.pdp.container.g0.a.b(r112)).U60().a(getContext(), r112) == false) goto L10;
        dismissAllowingStateLoss();
        return;
    L10:
        final Ref.BooleanRef r103 = new Ref.BooleanRef();
        com.bytedance.locallife.host.poi_debug.a r104 = HostServiceUtilsKt.Y();
        if (r104 == null) goto L14;
        com.bytedance.locallife.pdp.container.g0.a.b(r112);
        r104.l(new AnonymousClass1(r103));
    L14:
        if (r103.element == false) goto L20;
        Context r113 = getContext();
        if (r113 == null) goto L18;
        Lazy r105 = ToastUtils.f256981a;
        ToastUtils.a(r113, "跳转商详的schema中biz_code不合法, 请联系张孝宗处理该问题", 1);
    L18:
        dismissAllowingStateLoss();
        return;
    L20:
        PoiTradeSettingEntity r106 = com.bytedance.locallife.pdp.settings.l0.f261737a;
        if (r106 == null) goto L23;
        boolean r107 = Intrinsics.areEqual(r106.i(), Boolean.TRUE);
    L24:
        String r108 = "unknown";
        if (r107 == false) goto L34;
        int r114 = com.bytedance.locallife.biz.btm.b.f256555a;
        com.bytedance.locallife.biz.btm.b.C3644b.e(this, "a2552.b9338");
        Bundle r115 = getArguments();
        if (r115 == null) goto L32;
        String r116 = r115.getString(UniContext.KEY_OF_BIZ_CODE);
        if (r116 == null) goto L32;
        r108 = r116;
    L32:
        com.bytedance.locallife.biz.btm.b.C3644b.f(this, r108);
    L83:
        HostServiceUtilsKt.q0().getDensity();
        Bundle r117 = getArguments();
        if (r117 == null) goto L152;
        this.f261762k = UriProtector.parse(r117.getString("router_uri"));
        this.f261763l = r117.getString("dito_trace_session_id");
        this.f261764m = com.bytedance.locallife.pdp.container.g0.a.a(this.f261762k, null);
        Uri r109 = this.f261762k;
        if (r109 == null) goto L89;
        String r118 = UriProtector.getQueryParameter(r109, "hide_nav_bar");
        if (r118 == null) goto L89;
    L90:
        TextUtils.equals(r118, "1");
        Uri r119 = this.f261762k;
        String r120 = "0";
        if (r119 == null) goto L94;
        String r121 = UriProtector.getQueryParameter(r119, "pdp_dialog_transparent_bg");
        if (r121 == null) goto L94;
    L95:
        this.f261768q = TextUtils.equals(r121, "1");
        Uri r122 = this.f261762k;
        if (r122 == null) goto L99;
        String r123 = UriProtector.getQueryParameter(r122, "pdp_dialog_hide_able");
        if (r123 == null) goto L99;
    L100:
        this.f261769r = TextUtils.equals(r123, "1");
        Uri r124 = this.f261762k;
        if (r124 == null) goto L103;
        String r125 = UriProtector.getQueryParameter(r124, "life_mall_subpage_open_id");
    L104:
        if (r125 != null) goto L106;
        r125 = "";
    L106:
        this.f261770s = r125;
        System.currentTimeMillis();
        Uri r126 = this.f261762k;
        if (r126 == null) goto L112;
        String r127 = UriProtector.getQueryParameter(r126, "need_pause_nearby_video");
        if (r127 == null) goto L112;
        r120 = r127;
    L112:
        this.f261761j = TextUtils.equals(r120, "1");
        this.f261755d = r117.getLong("launch_timestamps");
        Uri r128 = this.f261762k;
        if (r128 == null) goto L115;
        String r129 = UriProtector.getQueryParameter(r128, "fix_height");
    L116:
        boolean r130 = Intrinsics.areEqual(r129, "1");
        this.f261759h = r130;
        if (r130 == false) goto L129;
        Uri r131 = this.f261762k;
        if (r131 == null) goto L121;
        String r132 = UriProtector.getQueryParameter(r131, "enable_full_page_as_popup");
    L123:
        if (Intrinsics.areEqual(r132, "1") == false) goto L129;
        if (r106 == null) goto L126;
        boolean r133 = Intrinsics.areEqual(Boolean.TRUE, r106.g());
    L127:
        if (r133 == true) goto L129;
        boolean r134 = true;
    L130:
        this.f261760i = r134;
        Uri r135 = this.f261762k;
        if (r135 == null) goto L133;
        String r136 = UriProtector.getQueryParameter(r135, ECFindSimilarConfig.HEIGHT_PERCENT);
    L171:
        Result.Companion r137 = Result.Companion;     // Catch: Throwable -> L146
        if (r136 == null) goto L138;
        r100 = Integer.valueOf(CastIntegerProtector.parseInt(r136));     // Catch: Throwable -> L146
    L138:
        if (r100 != null) goto L140;
    L143:
        int r138 = 75;
    L144:
        Object r139 = Result.m9449constructorimpl(Integer.valueOf(r138));     // Catch: Throwable -> L146
    L149:
        if (Result.m9455isFailureimpl(r139) == false) goto L151;
        r139 = 75;
    L151:
        this.f261756e = ((Number) r139).intValue();
        goto L152
    L140:
        if (r100.intValue() == 84) goto L143;
        r138 = r100.intValue();     // Catch: Throwable -> L146
    L146:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        r139 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L149
    L133:
        r136 = null;
        goto L171
    L126:
        r133 = false;
        goto L127
    L121:
        r132 = null;
    L129:
        r134 = false;
        goto L130
    L115:
        r129 = null;
        goto L116
    L103:
        r125 = null;
    L99:
        r123 = "1";
    L94:
        r121 = "0";
    L89:
        r118 = "1";
    L152:
        setStyle(0, R.style.poi_detail_dialog_style);
        vn6.b.b(this);
        if (this.f261757f == false) goto L155;
        com.bytedance.locallife.host.feeds.m r141 = HostServiceUtilsKt.d();
        getActivity();
        r141.l();
    L155:
        setMListener(new c(this));
        it6.i r142 = HostServiceUtilsKt.u0();
        if (r142 == null) goto L159;
        r142.c(1);
    L159:
        if (this.f261761j == false) goto L161;
        HostServiceUtilsKt.R().s();
    L161:
        FragmentActivity r143 = getActivity();
        if (r143 == null) goto L165;
        String r144 = r143.getLocalClassName();
        if (r144 == null) goto L165;
    L166:
        GoodsDialogState r145 = GoodsDialogState.OPEN;
        Bundle r146 = getArguments();
        if (r146 == null) goto L169;
        r146.getString("extra_json_str", "");
    L169:
        vn6.b.a(new GoodsDetailHalfContainerStateEvent(r144, r145));
        return;
    L165:
        r144 = "";
        goto L166
    L34:
        if (r112 == null) goto L36;
        String r147 = UriProtector.getQueryParameter(r112, PhotoEnterModel.SOURCE_BTM_TOKEN);
    L37:
        Bundle r148 = getArguments();
        if (r148 == null) goto L40;
        String r149 = r148.getString(PhotoEnterModel.SOURCE_BTM_TOKEN);
    L41:
        if (r147 != null) goto L43;
    L46:
        boolean r150 = true;
    L47:
        if (r150 == false) goto L49;
        r147 = r149;
    L49:
        LinkedHashMap r151 = new LinkedHashMap();
        String r152 = com.bytedance.locallife.pdp.container.g0.a.b(r112);
        Bundle r153 = getArguments();
        if (r153 == null) goto L52;
        String r154 = r153.getString(UniContext.KEY_OF_BIZ_CODE);
    L53:
        if (r152 != null) goto L55;
    L58:
        boolean r155 = true;
    L59:
        if (r155 == false) goto L61;
        r152 = r154;
    L61:
        if (r152 != null) goto L63;
        r152 = "unknown";
    L63:
        r151.put(UniContext.KEY_OF_BIZ_CODE, r152);
        if (r112 == null) goto L66;
        String r156 = UriProtector.getQueryParameter(r112, "activity_id");
    L67:
        Bundle r157 = getArguments();
        if (r157 == null) goto L70;
        String r158 = r157.getString("activity_id");
    L71:
        if (r156 != null) goto L73;
    L76:
        boolean r159 = true;
    L77:
        if (r159 == false) goto L79;
        r156 = r158;
    L79:
        if (r156 == null) goto L82;
        r108 = r156;
    L82:
        r151.put("life_product_id", r108);
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter("a2552.b9338", "btmAb");
        com.bytedance.locallife.biz.btm.c.i(this, "a2552.b9338", r147, r151);
        goto L83
    L73:
        if (StringsKt.isBlank(r156) == true) goto L76;
        r159 = false;
        goto L77
    L70:
        r158 = null;
        goto L71
    L66:
        r156 = null;
        goto L67
    L55:
        if (StringsKt.isBlank(r152) == true) goto L58;
        r155 = false;
        goto L59
    L52:
        r154 = null;
        goto L53
    L43:
        if (StringsKt.isBlank(r147) == true) goto L46;
        r150 = false;
        goto L47
    L40:
        r149 = null;
        goto L41
    L36:
        r147 = null;
        goto L37
    L23:
        r107 = false;
        goto L24
    L5:
        r112 = null;
        goto L6
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onPublishEvent(PublishEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Map<String, Object> r101 = r100.params();
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = PublishEventKt.getString(r101, LiveLocalLifeRoomInfo.TRACE_SESSION_ID);
    L6:
        Map<String, Object> r104 = r100.params();
        if (r104 == null) goto L9;
        String r105 = PublishEventKt.getString(r104, "check_schema_session");
    L10:
        boolean r106 = Intrinsics.areEqual(r105, "1");
        GoodsDetailPage r107 = this.f261775x;
        if (r107 == null) goto L13;
        String r108 = r107.getTraceSessionId();
    L46:
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L20
        Uri r110 = this.f261762k;     // Catch: Throwable -> L20
        if (r110 == null) goto L17;
        String r111 = UriProtector.getQueryParameter(r110, LiveLocalLifeRoomInfo.TRACE_SESSION_ID);     // Catch: Throwable -> L20
    L18:
        Object r112 = Result.m9449constructorimpl(r111);     // Catch: Throwable -> L20
    L23:
        if (Result.m9455isFailureimpl(r112) == false) goto L25;
        r112 = null;
    L25:
        String r113 = (String) r112;
        if (r113 != null) goto L30;
        Map<String, String> r114 = this.f261764m;
        if (r114 == null) goto L32;
        r102 = (String) ((LinkedHashMap) r114).get(LiveLocalLifeRoomInfo.TRACE_SESSION_ID);
    L32:
        if (Intrinsics.areEqual(r103, r108) == true) goto L38;
        if (r106 == true) goto L35;
    L37:
        boolean r115 = false;
    L40:
        if (Intrinsics.areEqual(r100.name(), "expand_goods_detail") == false) goto L48;
        if (r115 == false) goto L49;
        CustomBottomBehavior<View> r116 = this.D;
        if (r116 == null) goto L50;
        r116.setState(6);
        return;
    L50:
        return;
    L49:
        return;
    L48:
        return;
    L35:
        if (Intrinsics.areEqual(r103, r102) == false) goto L37;
    L38:
        r115 = true;
        goto L40
    L30:
        r102 = r113;
        goto L32
    L17:
        r111 = null;
    L20:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    L13:
        r108 = null;
        goto L46
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onReceiveCloseLiveAdLandingPageEvent(PoiCloseLiveAdLandingPageEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        CustomBottomBehavior<View> r101 = this.D;
        if (r101 == null) goto L6;
        r101.setState(5);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.saas_poi_dynamic_dialog_fragment_layout, r101, false);
        if (r103 != null) goto L5;
        return null;
    L5:
        if (this.f261768q == true) goto L9;
        r103.setBackgroundColor(ColorProtector.parseColor("#66000000"));
        return r103;
    L9:
        return r103;
    }
}
