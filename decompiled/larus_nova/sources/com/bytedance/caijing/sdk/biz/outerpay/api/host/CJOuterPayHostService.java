package com.bytedance.caijing.sdk.biz.outerpay.api.host;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import com.android.ttcjpaysdk.network.ITTCJPayCallback;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001:\u0002+,J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0017\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH&¢\u0006\u0004\b\u000f\u0010\u000eJ\n\u0010\u0010\u001a\u0004\u0018\u00010\fH&J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H&J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0015H&J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0015H&J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0004H&J\b\u0010\u001a\u001a\u00020\u0004H&J\u0018\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH&J\b\u0010 \u001a\u00020\u0004H&J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u001bH&J\b\u0010$\u001a\u00020#H&J\b\u0010%\u001a\u00020\u0004H&J\n\u0010'\u001a\u0004\u0018\u00010&H&J\b\u0010(\u001a\u00020\bH&J\b\u0010)\u001a\u00020\bH&J\b\u0010*\u001a\u00020\u0004H&¨\u0006-"}, d2 = {"Lcom/bytedance/caijing/sdk/biz/outerpay/api/host/CJOuterPayHostService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "Landroid/graphics/drawable/Drawable;", "getHostLoadingDrawable", "", "isUserAgreePrivacyPolicy", "Lcom/bytedance/caijing/sdk/biz/outerpay/api/host/CJOuterPayHostService$a;", "listener", "", "addHostBootTypeChangeListener", "removeHostBootTypeChangeListener", "", "Landroid/app/Activity;", "getHostStartedActivities", "()[Landroid/app/Activity;", "getHostActivityStack", "getHostPreviousActivity", "activity", "Landroid/content/DialogInterface$OnDismissListener;", "dismissListener", "hostShowPrivacyPolicyDialog", "Lcom/bytedance/caijing/sdk/biz/outerpay/api/host/CJOuterPayHostService$b;", "addHostTeenTimeLockListener", "removeHostTeenTimeLockListener", "isBlock", "setBlockTimeLockPageShow", "isExemptionPayTimeLock", "", "cacheKey", "Lcom/android/ttcjpaysdk/network/ITTCJPayCallback;", "callback", "getOuterPayCacheData", "isPrefetching", "from", "clearPreloadCacheData", "Luc4/a;", "getSignPreloadAbility", "isOuterBdPayNormal", "Lorg/json/JSONObject;", "getCacheExtra", "addSplashADListener", "removeSplashADListener", "isAppBackGround", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "cjpay-outer-api_release"}, k = 1, mv = {1, 6, 0})
public interface CJOuterPayHostService extends ICJService {

    public interface a {
    }

    public interface b {
    }

    void addHostBootTypeChangeListener(a r100);

    void addHostTeenTimeLockListener(b r100);

    void addSplashADListener();

    void clearPreloadCacheData(String r100);

    JSONObject getCacheExtra();

    Activity[] getHostActivityStack();

    Drawable getHostLoadingDrawable();

    Activity getHostPreviousActivity();

    Activity[] getHostStartedActivities();

    boolean getOuterPayCacheData(String r100, ITTCJPayCallback r101);

    uc4.a getSignPreloadAbility();

    void hostShowPrivacyPolicyDialog(Activity r100, DialogInterface.OnDismissListener r101);

    boolean isAppBackGround();

    boolean isExemptionPayTimeLock();

    boolean isOuterBdPayNormal();

    boolean isPrefetching();

    boolean isUserAgreePrivacyPolicy();

    void removeHostBootTypeChangeListener(a r100);

    void removeHostTeenTimeLockListener(b r100);

    void removeSplashADListener();

    void setBlockTimeLockPageShow(boolean r100);
}
