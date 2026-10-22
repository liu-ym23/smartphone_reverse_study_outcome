package com.larus.e_commerce.api;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u001a\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\bH&J\b\u0010\u0012\u001a\u00020\u0003H&J(\u0010\u0013\u001a\u00020\u00052\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\bH&J\u001c\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\bH&J\u001c\u0010\u001a\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH&J\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u0003H&J\b\u0010 \u001a\u00020!H&J\u000e\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010#H&J\"\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010%2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\bH&J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\bH&J?\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020\u00032#\u0010,\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00050-H\u0016J\u001a\u00100\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020\u00052\u0006\u00101\u001a\u000202H\u0016Ju\u00104\u001a\u00020\u00052\u0006\u00105\u001a\u0002062O\b\u0002\u00107\u001aI\u0012\u0013\u0012\u00110\b¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(9\u0012\u0013\u0012\u00110\b¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(:\u0012\u0013\u0012\u00110;¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u0005\u0018\u0001082\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020\u00050-H&J\u0018\u0010>\u001a\u00020?2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010@\u001a\u00020\bH&J\u001a\u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\b2\b\u00105\u001a\u0004\u0018\u00010CH&J3\u0010D\u001a\u00020\u00052\u0006\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010!2\b\u0010H\u001a\u0004\u0018\u00010\b2\b\u0010:\u001a\u0004\u0018\u00010\bH&¢\u0006\u0002\u0010IJ\b\u0010J\u001a\u00020\u0005H&J\b\u0010K\u001a\u00020\u0005H&J\u0010\u0010L\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010%H&J&\u0010N\u001a\u00020\u00052\b\u0010:\u001a\u0004\u0018\u00010\b2\b\u00109\u001a\u0004\u0018\u00010\b2\b\u0010O\u001a\u0004\u0018\u00010\bH&J\u001c\u0010P\u001a\u00020\u00052\b\u0010:\u001a\u0004\u0018\u00010\b2\b\u00109\u001a\u0004\u0018\u00010\bH&¨\u0006Q"}, d2 = {"Lcom/larus/e_commerce/api/IECommerceService;", "", "isECInit", "", "init", "", "isAsync", "initSource", "", "callBack", "Lcom/larus/e_commerce/api/IInitCallBack;", "handleECSchema", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "preloadPdpFull", "schema", Keys.API_RETURN_KEY_IS_LOGIN, "appendAppletGlobalProps", "data", "", "url", "appendQueryLiveBrowser", "bundle", "Landroid/os/Bundle;", "routeToECPhotoSearch", "routeIntent", "Landroid/content/Intent;", "tryHandleRedirectSchema", "matchECSchema", "isDeepLink", "getVersion", "", "getECLynxBehaviorList", "", "ecBehaviorAdd", "", "preloadMarketingGeckoRes", "scene", "getOrderListSchemaAsync", "scope", "Lkotlinx/coroutines/CoroutineScope;", "forceRefresh", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "addHalfPageStateListener", "listener", "Lcom/larus/e_commerce/api/ECommerceHalfPageStateListener;", "removeHalfPageStateListener", "tryToBindDouYinForPurchase", "params", "Lcom/larus/e_commerce/api/ECBindDouYinParams;", "onDialogShow", "Lkotlin/Function3;", "page", "source", "Lcom/larus/e_commerce/api/ECNotifyBinderDialogType;", "dialogType", "Lcom/larus/e_commerce/api/ECBindDouYinResult;", "generateLearnMoreSpan", "Landroid/text/SpannableStringBuilder;", "checkDescText", "appendBtmEventParams", "eventName", "Lorg/json/JSONObject;", "onPageInfo", "activity", "Landroidx/fragment/app/FragmentActivity;", "pageAction", "currentPage", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "fetchTextConfigMap", "registerCheckEcomNotify", "getTTNetInterceptor", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "refreshResultPage", "clientEngineExtra", "collapseAiChat", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IECommerceService {
    void a(String r100, String r101, String r102);

    void b(String r100, String r101);

    boolean c(Context r100, Uri r101);

    void d(FragmentActivity r100, Integer r101, String r102, String r103);

    List<Object> ecBehaviorAdd(Context r100, String r101);

    SpannableStringBuilder g(Context r100, String r101);

    List<?> getECLynxBehaviorList();

    int getVersion();

    boolean h(Context r100, String r101);

    boolean i();

    void j();

    String k(Bundle r100, String r101);

    List<Interceptor> l();

    void m(CoroutineScope r100, boolean r101, Function1<? super String, Unit> r102);

    boolean n(Context r100, Uri r101);

    void o(d r100);

    void p();

    void q();

    void r(b r100, Function3<? super String, ? super String, ? super ECNotifyBinderDialogType, Unit> r101, Function1<? super c, Unit> r102);

    String s(String r100, d r101);

    void t(String r100, JSONObject r101);

    void u(Map<String, ? extends Object> r100, String r101);

    void v(Context r100, Intent r101);

    boolean w(Uri r100);

    void x(String r100, h r101);
}
