package com.larus.e_commerce.impl.order;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.router.SmartRouter;
import com.larus.account.saas.security.api.IAccountSecurityService;
import com.larus.account.saas.security.model.AccountSecurityEventType;
import com.larus.applog.api.IApplog;
import com.larus.bmhome.a0;
import com.larus.bmhome.c0;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.btm.api.IBTMService;
import com.larus.common.apphost.AppHost;
import com.larus.e_commerce.api.IECommerceService;
import com.larus.login.api.CommonDouYinLoginKV;
import com.larus.login.api.DouYinBindStatus;
import com.larus.login.api.b0;
import com.larus.network.http.AsyncLiveData;
import com.larus.network.http.y;
import com.larus.nova.R;
import com.larus.platform.service.AccountService;
import com.larus.settings.value.e10;
import com.larus.settings.value.ro;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.e1;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import org.json.JSONObject;
import t19.s;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 <2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0001<B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0017H\u0002J\b\u0010 \u001a\u00020\u001dH\u0016J\b\u0010!\u001a\u00020\u001dH\u0016J\b\u0010\"\u001a\u00020\u001dH\u0016J\b\u0010#\u001a\u00020\u001dH\u0016J\b\u0010$\u001a\u00020\u001dH\u0002J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u0011H\u0016J\u0010\u0010'\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u0011H\u0016J\u0010\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u001dH\u0016J\u0018\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0017H\u0002J9\u00101\u001a\u00020\u001d2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u001d032!\u00104\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020\u001d05H\u0002JA\u00109\u001a\u00020\u001d2\u0006\u0010:\u001a\u00020\u00172\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u001d032!\u00104\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020\u001d05H\u0002J\b\u0010;\u001a\u00020\u001dH\u0002R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/larus/e_commerce/impl/order/OrderSettingsComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ui/arch/component/external/Component;", "Lcom/larus/bmhome/ISideBarLayoutListener;", "<init>", "()V", "eCommerceAuthConfig", "Lcom/larus/platform/model/ecommerce/ECommerceAuthConfig;", "getECommerceAuthConfig", "()Lcom/larus/platform/model/ecommerce/ECommerceAuthConfig;", "eCommerceAuthConfig$delegate", "Lkotlin/Lazy;", "binding", "Lcom/larus/bmhome/setting/ICommonSettingBinding;", "getBinding", "()Lcom/larus/bmhome/setting/ICommonSettingBinding;", "isResumed", "", "bindJob", "Lkotlinx/coroutines/Job;", "observer", "Landroidx/lifecycle/Observer;", "Lcom/larus/network/http/Async;", "", "getObserver", "()Landroidx/lifecycle/Observer;", "bindDouyinCallback", "Lcom/larus/login/api/DouYinBoundCallback;", "jumpToOrderPage", "", "navigateToOrderPage", "schema", WidgetCostModule.TYPE_ON_CREATE, LiveCommonConstants.REASON_ON_DEDTROY, "onResume", "onPause", "cancelBindDouYin", "onSideBarOpen", "isClick", "onSideBarClose", "onSideBarStateChanged", "newState", "", "onParentViewCreated", "generateLearnMoreSpan", "Landroid/text/SpannableStringBuilder;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "checkDescText", "readyToECommercePlugin", "success", "Lkotlin/Function0;", "fail", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "reason", "loadInEcommercePlugin", "initSource", "reportViewOrder", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OrderSettingsComponent extends ComponentFeature implements c0 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f342427m = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f342428h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f342429i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Job f342430j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final OrderSettingsComponent$observer$1 f342431k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f342432l;

    public static final class a {
    }

    public static final class b implements b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OrderSettingsComponent f342433a;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f342434a = null;

            static {
                int[] r100 = new int[DouYinBindStatus.values().length];
                r100[DouYinBindStatus.ALREADY_BOUND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
            L19:
                r100[DouYinBindStatus.SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
            L27:
                r100[DouYinBindStatus.FAILURE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
            L21:
                r100[DouYinBindStatus.CANCEL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
            L23:
                r100[DouYinBindStatus.GO_MARKET.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
            L17:
                r100[DouYinBindStatus.GO_ACCOUNT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
            L9:
                f342434a = r100;
            }
        }

        public b(OrderSettingsComponent r100) {
            this.f342433a = r100;
        }

        @Override // com.larus.login.api.b0
        public final void a(DouYinBindStatus r100, int r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "status");
            OrderSettingsComponent r103 = this.f342433a;
            int r104 = OrderSettingsComponent.f342427m;
            com.larus.bmhome.setting.c r105 = r103.N2();
            if (r105 == null) goto L8;
            ItemTextArrow r106 = r105.A0();
            if (r106 == null) goto L8;
            r106.V5();
        L8:
            if (this.f342433a.f342429i == true) goto L11;
            return;
        L11:
            switch(a.f342434a[r100.ordinal()]) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L18;
                case 5: goto L18;
                case 6: goto L18;
                default: goto L13;
            };
        L14:
            s r107 = s.f544207a;
            FragmentActivity r108 = s1a.a.getActivity(this.f342433a);
            String r109 = AppHost.f326268a.getApplication().getString(R.string.larus_facemem_auth_fail_cn);
            r107.getClass();
            s.c(r108, r109);
            return;
        L15:
            Lazy r110 = CommonDouYinLoginKV.f356938a;
            CommonDouYinLoginKV.d();
            OrderSettingsComponent.F2(this.f342433a);
            return;
        L16:
            Lazy r111 = CommonDouYinLoginKV.f356938a;
            CommonDouYinLoginKV.d();
            OrderSettingsComponent.F2(this.f342433a);
            return;
        L18:
            return;
        L13:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class c extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f342435a;

        public c(Context r100) {
            this.f342435a = r100;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, "widget");
            com.bytedance.router.i r101 = SmartRouter.buildRoute(this.f342435a, "//flow/webview");
            Bundle r102 = new Bundle();
            r102.putString("link_url", "https://lf9-cdn-tos.draftstatic.com/obj/ies-hotsoon-draft/grace_legal/Shopping-Payment-FAQ.html");
            r101.f267554c.putExtras(r102);
            r101.d();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            Intrinsics.checkNotNullParameter(r100, "ds");
            r100.setUnderlineText(false);
            Context r101 = this.f342435a;
            r100.setColor(ContextCompat.getColor(r101, v19.c.b(R.attr.larus_neutral_100, r101, R.color.larus_neutral_100)));
        }
    }

    static {
    }

    @Override // com.larus.bmhome.c0
    public final void H0(int r100) {
    }

    @Override // com.larus.bmhome.c0
    public final void n0(boolean r100) {
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onPause() {
        this.f342429i = false;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onResume() {
        boolean r100 = true;
        this.f342429i = true;
        Job r101 = this.f342430j;
        if (r101 != null) goto L5;
    L7:
        r100 = false;
    L8:
        if (r100 == true) goto L15;
        com.larus.bmhome.setting.c r102 = N2();
        if (r102 == null) goto L16;
        ItemTextArrow r103 = r102.A0();
        if (r103 == null) goto L17;
        r103.V5();
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    L5:
        if (r101.isActive() != true) goto L7;
        goto L7
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void B2() {
        AccountService r100 = AccountService.f365697a;
        if (r100.isLogin().booleanValue() == true) goto L5;
    L41:
        com.larus.bmhome.setting.c r101 = N2();
        if (r101 == null) goto L48;
        ItemTextArrow r102 = r101.A0();
        if (r102 == null) goto L49;
        r102.setVisibility(8);
        return;
    L49:
        return;
    L48:
        return;
    L5:
        if (r100.a() == true) goto L41;
        e10 r103 = e10.f368561a;
        int r104 = l0.f375430a;
        new pv9.b();
        if (((pv9.a) l0.a(pv9.b.a(), new ro())).a() == false) goto L41;
        AsyncLiveData<String> r105 = OrderSchemaService.f342424a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        OrderSchemaService.a(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this)));
        final JSONObject r106 = new JSONObject();
        r106.put("current_page", "setting");
        IApplog r107 = (IApplog) ServiceManager.get().getService(IApplog.class);
        if (r107 == null) goto L12;
        r107.reportEvent("order_manage_show", r106);
    L12:
        com.larus.bmhome.setting.c r108 = N2();
        if (r108 == null) goto L17;
        ItemGroup r109 = r108.r0();
        if (r109 == null) goto L17;
        e1.x(r109);
    L17:
        com.larus.bmhome.setting.c r110 = N2();
        if (r110 == null) goto L22;
        ItemTextArrow r111 = r110.A0();
        if (r111 == null) goto L22;
        r111.setVisibility(0);
    L22:
        com.larus.bmhome.setting.c r112 = N2();
        if (r112 == null) goto L25;
        ItemTextArrow r113 = r112.A0();
    L27:
        if ((r113 instanceof ItemTextArrow) == true) goto L30;
        r113 = null;
    L30:
        if (r113 == null) goto L32;
        int r114 = ItemTextArrow.f316958k;
        r113.Z5("", null);
    L32:
        com.larus.bmhome.setting.c r115 = N2();
        if (r115 == null) goto L37;
        ItemTextArrow r116 = r115.A0();
        if (r116 == null) goto L37;
        e1.d(r116, new com.larus.e_commerce.impl.order.c(this, r106));
    L37:
        Intrinsics.checkNotNullParameter(this, "<this>");
        a0 r117 = com.larus.bmhome.b0.a(com.larus.ui.arch.component.internal.attach.a.b(this, this));
        if (r117 == null) goto L47;
        r117.If(this);
        return;
    L47:
        return;
    L25:
        r113 = null;
        goto L27
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onCreate() {
        IBTMService r100 = (IBTMService) ServiceManager.get().getService(IBTMService.class);
        if (r100 == null) goto L6;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r100.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), "a35794.b85487");
        return;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.e_commerce.impl.order.OrderSettingsComponent$observer$1] */
    public OrderSettingsComponent() {
        this.f342428h = LazyKt.lazy(new d());
        this.f342431k = new OrderSettingsComponent$observer$1(this);
        this.f342432l = new b(this);
    }

    public final com.larus.bmhome.setting.c N2() {
        return (com.larus.bmhome.setting.c) s1a.d.a(this).a(com.larus.bmhome.setting.c.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void F2(OrderSettingsComponent r100) {
        r100.getClass();
        AsyncLiveData r101 = OrderSchemaService.f342425b;
        com.larus.network.http.a r102 = r101.getValue();
        if ((r102 instanceof y) == false) goto L9;
        String r103 = (String) ((y) r102).f360135b;
        if (r103 == null) goto L9;
        if (OrderSchemaService.b() == true) goto L9;
        r100.P2(r103);
        return;
    L9:
        FLogger.f375446a.i("OrderSettingsComponent", "Schema expired or not available, fetching new one");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r101.observe(com.larus.ui.arch.component.internal.attach.a.b(r100, r100), r100.f342431k);
        Intrinsics.checkNotNullParameter(r100, "<this>");
        OrderSchemaService.a(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(r100, r100)));
    }

    @Override // com.larus.bmhome.c0
    public final void G(boolean r100) {
        com.larus.bmhome.setting.c r101 = N2();
        if (r101 == null) goto L14;
        ItemTextArrow r102 = r101.A0();
        if (r102 == null) goto L15;
        r102.V5();
        Object r103 = r102.getTag();
        if ((r103 instanceof Job) == false) goto L9;
        Job r104 = (Job) r103;
    L10:
        if (r104 == null) goto L12;
        Job.DefaultImpls.cancel$default(r104, null, 1, null);
    L12:
        r102.setTag(null);
        return;
    L9:
        r104 = null;
        goto L10
    L15:
        return;
    }

    public final void P2(String r100) {
        IECommerceService r101 = (IECommerceService) ServiceManager.get().getService(IECommerceService.class);
        if (r101 != null) goto L5;
        return;
    L5:
        FragmentActivity r102 = s1a.a.getActivity(this);
        if (r102 != null) goto L8;
        return;
    L8:
        IBTMService r103 = (IBTMService) ServiceManager.get().getService(IBTMService.class);
        Uri r104 = null;
        if (r103 == null) goto L12;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r104 = r103.j(r100, "a35794.b85487.c93478.d38388", null, com.larus.ui.arch.component.internal.attach.a.b(this, this));
    L12:
        if (r101.i() == true) goto L14;
        return;
    L14:
        if (r101.c(r102, r104) == false) goto L18;
        IAccountSecurityService.f286489a.h(new e48.d(AccountSecurityEventType.VIEW_ORDER, AccountService.f365697a.getSecUserId(), System.currentTimeMillis(), MapsKt.emptyMap(), "OrderSettingsComponent"));
        return;
    }

    public final SpannableStringBuilder L2(Context r100, String r101) {
        String r102 = ContextCompat.getString(r100, R.string.larus_learn_more);
        SpannableString r103 = new SpannableString(r102);
        r103.setSpan(new c(r100), 0, r102.length(), 33);
        r103.setSpan(new StyleSpan(1), 0, r102.length(), 33);
        r103.setSpan(new vj9.a(), 0, r102.length(), 33);
        SpannableStringBuilder r104 = new SpannableStringBuilder();
        r104.append(r101);
        r104.append(r103);
        return r104;
    }
}
