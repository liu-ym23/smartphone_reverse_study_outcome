package com.bytedance.caijing.sdk.biz.outerpay.api;

import android.app.Activity;
import android.content.Intent;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.android.ttcjpaysdk.base.service.CJOuterPayCallback;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.caijing.sdk.biz.outerpay.OuterPayLifecycleEvent;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J \u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\bH&J\u001a\u0010\u0014\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\nH&J2\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH&J4\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH&¨\u0006\u001d"}, d2 = {"Lcom/bytedance/caijing/sdk/biz/outerpay/api/CJOuterPayApiService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "getIsDisableBack", "", "activity", "Landroid/app/Activity;", "isCurrentOuterPayColdStart", "notifyLifecycleEvent", "", "sessionId", "", "event", "Lcom/bytedance/caijing/sdk/biz/outerpay/OuterPayLifecycleEvent;", "notifyRooterBackPressed", "outerDyPayDestroy", "outerDyPayNewIntent", "Landroidx/appcompat/app/AppCompatActivity;", "intent", "Landroid/content/Intent;", "preLoadOptConfigFromAB", "preload", "triggerFrom", "startOuterDyPay", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "isReCreate", "callback", "Lcom/android/ttcjpaysdk/base/service/CJOuterPayCallback;", "startOuterPayNew", "cjpay-outer-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CJOuterPayApiService extends ICJService {
    boolean getIsDisableBack(Activity r100);

    boolean isCurrentOuterPayColdStart();

    void notifyLifecycleEvent(String r100, OuterPayLifecycleEvent r101);

    void notifyRooterBackPressed(Activity r100);

    void outerDyPayDestroy(String r100);

    void outerDyPayNewIntent(AppCompatActivity r100, String r101, Intent r102);

    void preLoadOptConfigFromAB();

    void preload(Intent r100, String r101);

    String startOuterDyPay(AppCompatActivity r100, Intent r101, ViewGroup r102, boolean r103, CJOuterPayCallback r104);

    void startOuterPayNew(AppCompatActivity r100, Intent r101, ViewGroup r102, boolean r103, CJOuterPayCallback r104);
}
