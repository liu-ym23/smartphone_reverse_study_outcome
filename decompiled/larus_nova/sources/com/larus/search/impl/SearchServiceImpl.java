package com.larus.search.impl;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ai.applet.app.AppletAppActivity;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.bmhome.IChatAzerothService;
import com.larus.bmhome.chat.setting.UserSettingDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.nova.R;
import com.larus.platform.service.AccountService;
import com.larus.search.api.IBrowserService;
import com.larus.search.api.event.HybridEventParams;
import com.larus.search.api.model.SugUrlText;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J$\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J$\u0010\t\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0012\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0013\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J \u0010\u0014\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\rH\u0016J\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\"\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0016H\u0016J\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001d\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u001eJ\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J$\u0010#\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u001c\u0010$\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0016H\u0002¨\u0006&"}, d2 = {"Lcom/larus/search/impl/SearchServiceImpl;", "Lcom/larus/search/api/IBrowserService;", "<init>", "()V", MiPushClient.COMMAND_REGISTER, "", "searchModel", "Lcom/larus/search/api/model/SearchModel;", "getSearchModel", "navigateWeb", "view", "Landroid/view/View;", "args", "Landroid/os/Bundle;", "hybridEventParams", "Lcom/larus/search/api/event/HybridEventParams;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "navigateHalfWeb", "navigateNineInchWeb", "navigateFeedback", "source", "", "extras", "extra", "createWebFragment", "Lcom/larus/platform/model/webview/AbsWebFragment;", "webClassName", "queryUrl", "text", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isWebActivity", "", "activity", "Landroid/app/Activity;", "navigateToWebView", "getFeedBackFullUrl", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchServiceImpl implements IBrowserService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ts9.a f367426a;

    public static final class a {
    }

    public SearchServiceImpl() {
    }

    static {
        f367426a = new ts9.a(0);
    }

    @Override // com.larus.search.api.IBrowserService
    public final WebFragment c() {
        return new WebFragment();
    }

    @Override // com.larus.search.api.IBrowserService
    public final String h() {
        return WebActivity.class.getName();
    }

    @Override // com.larus.search.api.IBrowserService
    public final ts9.a f() {
        return f367426a;
    }

    @Override // com.larus.search.api.IBrowserService
    public final void b(ts9.a r100) {
        Intrinsics.checkNotNullParameter(r100, "searchModel");
        f367426a = r100;
    }

    @Override // com.larus.search.api.IBrowserService
    public final boolean g(Activity r100) {
        return r100 instanceof WebActivity;
    }

    public static String l(String r100, String r101) {
        com.larus.platform.service.y0 r102 = com.larus.platform.service.y0.f365861a;
        String r103 = "1";
        Uri.Builder r104 = UriProtector.parse(r102.i().f486556a).buildUpon().appendQueryParameter("hide_title_bar", "1").appendQueryParameter(CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL, com.larus.utils.b0.d()).appendQueryParameter("source", r100);
        AccountService r105 = AccountService.f365697a;
        if (r105.isLogin().booleanValue() == true) goto L6;
        r103 = "0";
    L6:
        Uri.Builder r106 = r104.appendQueryParameter("is_login", r103);
        if (r105.isLogin().booleanValue() == false) goto L12;
        if (AppHost.f326268a.isOversea() == true) goto L12;
        r106.appendQueryParameter("app_id", "10001").appendQueryParameter("channel", "307").appendQueryParameter(SoloKtvContext.SOLO_PAGE_ENTRANCE, "IM482431-2829").appendQueryParameter("account_type", "420");
    L12:
        if (Intrinsics.areEqual(r100, r102.i().f486559d) == false) goto L14;
        r106.appendQueryParameter("from_type", "Payment");
    L14:
        IChatAzerothService r107 = com.larus.bmhome.x.a();
        if (r107 == null) goto L17;
        String r108 = r107.b();
    L19:
        if (com.larus.utils.o0.d(r108) == false) goto L21;
        r106.appendQueryParameter("uid_token", URLEncoder.encode(r108, "UTF-8"));
    L21:
        if (r101 == null) goto L24;
        r106.appendQueryParameter("extra_params_json", r101);
    L24:
        return r106.toString();
    L17:
        r108 = null;
        goto L19
    }

    @Override // com.larus.search.api.IBrowserService
    public final void a(AppletAppActivity r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("feedback_doubao_apps", "source");
        m(r100, com.larus.utils.f.c(new Pair[]{TuplesKt.to("link_url", l("feedback_doubao_apps", r101))}), null);
    }

    @Override // com.larus.search.api.IBrowserService
    public final void d(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Context r102 = r100.getContext();
        if ((r102 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r103 = (FragmentActivity) r102;
    L6:
        if (r103 == null) goto L16;
        HalfWebFragment r104 = new HalfWebFragment();
        r104.setArguments(r101);
        FragmentManager r105 = r103.getSupportFragmentManager();
        LandscapeRestrictionOperation r106 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r104, "half_web", r106);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r105, r104, r106) == true) goto L17;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L11:
        r104.show(r105, "half_web");
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.larus.search.api.IBrowserService
    public final void j(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "source");
        m(r100, com.larus.utils.f.c(new Pair[]{TuplesKt.to("link_url", l(r101, null))}), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.search.api.IBrowserService
    public final Object o(String r110, Continuation<? super String> r111) {
        if ((r111 instanceof SearchServiceImpl$queryUrl$1) == false) goto L7;
        SearchServiceImpl$queryUrl$1 r100 = (SearchServiceImpl$queryUrl$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        SearchServiceImpl$queryUrl$1 r112 = r100;
        Object r113 = r112.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r112.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        r110 = (String) r112.L$0;
        ResultKt.throwOnFailure(r113);
    L17:
        com.larus.network.http.a r114 = (com.larus.network.http.a) r113;
        if ((r114 instanceof com.larus.network.http.y) == false) goto L23;
        FLogger.f375446a.i("SearchServiceImpl", "queryUrl Success " + r110);
        SugUrlText r115 = (SugUrlText) ((com.larus.network.http.y) r114).f360135b;
        if (r115 != null) goto L28;
    L26:
        return null;
    L28:
        return r115.getUrl();
    L23:
        if ((r114 instanceof com.larus.network.http.f) == false) goto L25;
        FLogger.f375446a.w("SearchServiceImpl", "queryUrl Fail " + r110);
        goto L26
    L25:
        FLogger.f375446a.w("SearchServiceImpl", "queryUrl Null " + r110);
        goto L26
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        JSONObject r104 = new JSONObject();
        r104.put("query_text", r110);
        r104.put("source", UserSettingDelegate.f308901b.f());
        Unit r105 = Unit.INSTANCE;
        r112.L$0 = r110;
        r112.label = 1;
        r113 = HttpExtKt.k(ServiceType.IM, SugUrlText.class, "/alice/query", r104, null, null, false, null, null, null, r112, 1008);
        if (r113 != r102) goto L17;
        return r102;
    L7:
        r100 = new SearchServiceImpl$queryUrl$1(this, r111);
        goto L8
    }

    public static void m(Context r100, Bundle r101, HybridEventParams r102) {
        com.bytedance.router.i r103 = SmartRouter.buildRoute(r100, "//flow/webview");
        if (r101 == null) goto L7;
        if (r102 != null) goto L6;
        r102 = new HybridEventParams(null, null, null, null, 127);
    L6:
        r101.putParcelable("hybrid_event_param", r102);
    L8:
        r103.f267554c.putExtras(r101);
        r103.f267555d = R.anim.larus_router_slide_in_right;
        r103.f267556e = R.anim.larus_router_no_anim;
        r103.d();
        return;
    L7:
        r101 = null;
        goto L8
    }

    @Override // com.larus.search.api.IBrowserService
    public final void e(Context r100, Bundle r101, HybridEventParams r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        m(r100, r101, r102);
    }

    @Override // com.larus.search.api.IBrowserService
    public final void i(View r100, Bundle r101, HybridEventParams r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        m(r100.getContext(), r101, r102);
    }

    @Override // com.larus.search.api.IBrowserService
    public final void k(View r100, String r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter(r102, "extras");
        FLogger.f375446a.uploadAllLog("feedback", null);
        String r103 = r102.getString("feedback_extra_params_json");
        Bundle r104 = new Bundle(r102);
        r104.remove("feedback_extra_params_json");
        r104.putString("link_url", l(r101, r103));
        Unit r105 = Unit.INSTANCE;
        i(r100, r104, null);
    }
}
