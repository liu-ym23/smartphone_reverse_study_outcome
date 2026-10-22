package com.bytedance.caijing.sdk.infra.base.api.btm;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J&\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH&J&\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J&\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH&J!\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\u0017J!\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\u0017J\b\u0010\u0019\u001a\u00020\u0003H&J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000bH&J$\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000bH&J\"\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000bH&J\"\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020!2\u0006\u0010 \u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000bH&J\u001a\u0010\"\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u000bH&J&\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u000f2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\nH&J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u001fH&J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0010\u0010)\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H&¨\u0006*"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/btm/CJBtmService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "btmViewHide", "", "view", "Landroid/view/View;", "forward", "", "btmViewShow", "createFullyReportParams", "", "", "", "btm", "pageFinder", "Lcom/bytedance/caijing/sdk/infra/base/api/btm/CJPageFinder;", "createJumpSourceBtmToken", "bcm", "Lorg/json/JSONObject;", "createReportParams", "dismissBtmDialog", "dialog", "Landroid/app/Dialog;", "(Landroid/app/Dialog;Ljava/lang/Boolean;)V", "hideBtmDialog", "initBtmSdk", "registerBtmDialog", "registerBtmPage", "sourceBtmToken", "registerBtmPageOnCreate", "page", "Landroid/app/Activity;", "pageBtm", "Landroidx/fragment/app/Fragment;", "registerBtmView", "setBcmPageEventParams", "finder", "params", "setInitInActivity", "activity", "showBtmDialog", "unregisterBtmDialog", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CJBtmService extends ICJService {
    void btmViewHide(View r100);

    void btmViewHide(View r100, boolean r101);

    void btmViewShow(View r100);

    Map<String, Object> createFullyReportParams(String r100, CJPageFinder r101);

    String createJumpSourceBtmToken(String r100, CJPageFinder r101, JSONObject r102);

    Map<String, Object> createReportParams(String r100, CJPageFinder r101);

    void dismissBtmDialog(Dialog r100, Boolean r101);

    void hideBtmDialog(Dialog r100, Boolean r101);

    void initBtmSdk();

    void registerBtmDialog(Dialog r100, String r101);

    boolean registerBtmPage(View r100, String r101, String r102);

    void registerBtmPageOnCreate(Activity r100, String r101, String r102);

    void registerBtmPageOnCreate(Fragment r100, String r101, String r102);

    void registerBtmView(View r100, String r101);

    void setBcmPageEventParams(CJPageFinder r100, Map<String, ? extends Object> r101);

    void setInitInActivity(Activity r100);

    void showBtmDialog(Dialog r100);

    void unregisterBtmDialog(Dialog r100);
}
