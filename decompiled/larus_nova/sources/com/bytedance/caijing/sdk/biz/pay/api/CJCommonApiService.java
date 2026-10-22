package com.bytedance.caijing.sdk.biz.pay.api;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.caijing.sdk.biz.common.api.a;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.qqmusic.third.api.contract.CommonCmd;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH&J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH&J0\u0010\u0017\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&J6\u0010\u001d\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0015H&J\u0018\u0010!\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH&J\b\u0010\"\u001a\u00020\u0019H&J&\u0010&\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010#\u001a\u0004\u0018\u00010\u001e2\b\u0010%\u001a\u0004\u0018\u00010$H&J\u0018\u0010(\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\bH&J\u0012\u0010+\u001a\u00020\n2\b\u0010*\u001a\u0004\u0018\u00010)H&¨\u0006,"}, d2 = {"Lcom/bytedance/caijing/sdk/biz/pay/api/CJCommonApiService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "getAppVersionCode", "Landroid/graphics/Typeface;", "getNumberNoiseReductionFontTypeface", "Landroid/widget/TextView;", "textView", "", "fakeBold", "Landroid/graphics/Paint;", "textPaint", "", "strokeWidth", "Landroid/view/View;", "view", "targetHeight", "Lcom/bytedance/caijing/sdk/biz/common/api/a;", "callback", "", "duration", "heightChangeAnimation", PickerReporterConstants.KEY.TARGET, "", "isFadeIn", "Landroid/app/Activity;", "activity", "fadeInOrOutAnimation", "", "key", "value", "cacheDataMap", "isJailBroken", "url", "Landroid/widget/ImageView;", "imageView", "loadImage", CommonCmd.AIDL_PLATFORM_TYPE_TV, "setNumberNoiseReductionFontTypeface", "Lorg/json/JSONObject;", "data", "onReceiveSettingsPushEvent", "cj-common-api_release"}, k = 1, mv = {1, 6, 0})
public interface CJCommonApiService extends ICJService {
    void cacheDataMap(String r100, String r101);

    void fadeInOrOutAnimation(View r100, boolean r101, Activity r102, a r103, long r104);

    void fakeBold(Paint r100, float r101);

    void fakeBold(TextView r100);

    int getAppVersionCode(Context r100);

    Typeface getNumberNoiseReductionFontTypeface(Context r100);

    void heightChangeAnimation(View r100, int r101, a r102, long r103);

    boolean isJailBroken();

    void loadImage(Activity r100, String r101, ImageView r102);

    void onReceiveSettingsPushEvent(JSONObject r100);

    void setNumberNoiseReductionFontTypeface(Context r100, TextView r101);
}
