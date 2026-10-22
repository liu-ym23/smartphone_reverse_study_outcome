package com.larus.btm.api;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import java.util.Map;
import kotlin.Metadata;
import lv8.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H&J\u001a\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u001a\u0010\u0007\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u000bH&J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH&J.\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\b\u001a\u0004\u0018\u00010\tH&J.\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\f\u001a\u0004\u0018\u00010\u0015H&J6\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&J6\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00172\b\u0010\f\u001a\u0004\u0018\u00010\rH&J(\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&J\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\u001d\u001a\u00020\u0003H&J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000bH&J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000bH&J\"\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000bH&J\u0018\u0010 \u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u000bH&J&\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020#H&J(\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&J&\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020#H&J$\u0010%\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020#2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J&\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020#2\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017H&J\u0010\u0010)\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0018\u0010*\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u0006H&J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0018\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020/2\u0006\u0010\u0012\u001a\u00020\u000bH&J\u0010\u00100\u001a\u00020\u00032\u0006\u0010.\u001a\u00020/H&J\u0010\u00101\u001a\u00020\u00032\u0006\u0010.\u001a\u00020/H&J\u001f\u00102\u001a\u00020\u00032\u0006\u0010.\u001a\u00020/2\b\u0010+\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u00103J\u001f\u00104\u001a\u00020\u00032\u0006\u0010.\u001a\u00020/2\b\u0010+\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u00103J \u00105\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0006H&¨\u00069"}, d2 = {"Lcom/larus/btm/api/IBTMService;", "", "minimizeInit", "", "init", "hostBtmInited", "", "registerBtmPageOnCreate", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "btmPage", "", "activity", "Landroid/app/Activity;", "unregisterBtmPageOnDestroy", "appendJumpSourceBtmToken", "Landroid/net/Uri;", "url", "btm", "bcm", "Lorg/json/JSONObject;", "Landroidx/fragment/app/FragmentActivity;", "createSourceBtmToken", "", "view", "Landroid/view/View;", "createSourceBtmTokenFromJsb", "getBtmShowIdByBtmToken", "btmToken", "initBtmSdk", "sourceBtmToken", "registerBtmPage", "registerBtmView", "createReportParams", "pageFinder", "Lcom/larus/btm/api/BtmPageFinder;", "createFullyReportParams", "createJumpSourceBtmToken", "setBcmPageEventParams", "finder", "params", "setInitInActivity", "btmViewHide", "forward", "btmViewShow", "registerBtmDialog", "dialog", "Landroid/app/Dialog;", "unregisterBtmDialog", "showBtmDialog", "hideBtmDialog", "(Landroid/app/Dialog;Ljava/lang/Boolean;)V", "dismissBtmDialog", "setBcmPageParams", "intent", "Landroid/content/Intent;", "clearOldValue", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IBTMService {
    void a(Fragment r100, String r101);

    Map<String, Object> b(String r100, a r101);

    void btmViewHide(View r100);

    void btmViewHide(View r100, boolean r101);

    void btmViewShow(View r100);

    String c(String r100);

    String d(String r100, Map<String, ? extends Object> r101, View r102);

    void dismissBtmDialog(Dialog r100, Boolean r101);

    String e(String r100, a r101, JSONObject r102);

    void f(Fragment r100);

    Map<String, Object> g(String r100, a r101);

    Map h(Activity r100);

    void hideBtmDialog(Dialog r100, Boolean r101);

    void i(Activity r100, Intent r101);

    void init();

    void initBtmSdk();

    Uri j(String r100, String r101, JSONObject r102, Fragment r103);

    void k(FragmentActivity r100);

    void l(a r100, Map<String, ? extends Object> r101);

    String m(String r100, Map<String, ? extends Object> r101, Activity r102);

    String n(String r100, JSONObject r101, View r102);

    void o();

    Uri p(String r100, String r101, JSONObject r102, FragmentActivity r103);

    void q(Activity r100);

    void registerBtmDialog(Dialog r100, String r101);

    boolean registerBtmPage(View r100, String r101, String r102);

    void registerBtmPageOnCreate(Activity r100, String r101, String r102);

    void registerBtmPageOnCreate(Fragment r100, String r101, String r102);

    void registerBtmView(View r100, String r101);

    void setInitInActivity(Activity r100);

    void showBtmDialog(Dialog r100);

    void unregisterBtmDialog(Dialog r100);
}
