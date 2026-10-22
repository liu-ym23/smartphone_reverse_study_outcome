package com.bytedance.caijing.sdk.infra.base.api.plugin.container;

import android.graphics.Bitmap;
import com.alipay.sdk.m.p.e;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import ee4.b;
import ee4.c;
import ge4.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&Jh\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\t2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006H&JN\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\t2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u0018\u001a\u00020\u0017H&J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H&J\b\u0010\u001d\u001a\u00020\u001cH&J5\u0010#\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062#\u0010\u001a\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00020\u001eH&J\u0012\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010$\u001a\u00020\u0006H&¨\u0006'"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/plugin/container/PlugInContainerService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "", "preloadJSBHelperClass", "Lee4/c;", "getJSBHelper", "", e.f25671s, "url", "", "isH5", "", "", "param", "", "code", "msg", "", "duration", "merchantId", "cjAppId", "reportJSBResult", "reportJSBInvoke", "Lee4/b;", "getH5ActivityStackHelper", "Lee4/a;", "callback", "registerCJPayFinishAllH5Event", "Lge4/a;", "getElementHelper", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "Lkotlin/ParameterName;", "name", SimplayerImageStrategy.RESULT_BITMAP, "loadImage", "source", "Lorg/json/JSONObject;", "getFinanceRiskInfo", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface PlugInContainerService extends ICJService {
    a getElementHelper();

    JSONObject getFinanceRiskInfo(String r100);

    b getH5ActivityStackHelper();

    c getJSBHelper();

    void loadImage(String r100, Function1<? super Bitmap, Unit> r101);

    void preloadJSBHelperClass();

    void registerCJPayFinishAllH5Event(ee4.a r100);

    void reportJSBInvoke(String r100, String r101, boolean r102, Map<String, String> r103, String r104, String r105);

    void reportJSBResult(String r100, String r101, boolean r102, Map<String, ? extends Object> r103, int r104, String r105, long r106, String r107, String r110);
}
