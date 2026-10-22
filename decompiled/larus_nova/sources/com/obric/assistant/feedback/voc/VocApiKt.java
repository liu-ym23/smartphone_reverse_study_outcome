package com.obric.assistant.feedback.voc;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.network.FlowHttpConnection;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.f;
import com.larus.network.http.y;
import java.util.LinkedHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class VocApiKt {
    public static final Object a(String r100, String r101, int r102, String r103, String r110, Continuation<? super com.larus.network.http.a<? extends Object>> r111) {
        if ((r111 instanceof VocApiKt$submitVocRequest$1) == false) goto L7;
        VocApiKt$submitVocRequest$1 r104 = (VocApiKt$submitVocRequest$1) r111;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r112 = r104.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r104.label;
        if (r107 == 0) goto L15;
        if (r107 != 1) goto L14;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L33
    L19:
        String r113 = (String) r112;     // Catch: Throwable -> L33
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L22
        Object r109 = Result.m9449constructorimpl(new JSONObject(r113));     // Catch: Throwable -> L22
    L25:
        if (Result.m9455isFailureimpl(r109) == false) goto L27;
        r109 = null;
    L27:
        JSONObject r114 = (JSONObject) r109;     // Catch: Throwable -> L33
        if (r114 != null) goto L30;
        Object r115 = r113;
    L31:
        return new y(r115, null, 14);
    L30:
        r115 = r114;
    L22:
        th = move-exception;
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L33
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L33
        goto L25
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r112);
        FlowHttpConnection r117 = FlowHttpConnection.f359975a;     // Catch: Throwable -> L33
        VocApiOrigin r118 = (VocApiOrigin) RetrofitUtils.createSsRetrofit(FlowHttpConnection.a(), CollectionsKt.emptyList(), rx5.a.a()).create(VocApiOrigin.class);     // Catch: Throwable -> L33
        LinkedHashMap r119 = new LinkedHashMap();     // Catch: Throwable -> L33
        r119.put("content", r100);     // Catch: Throwable -> L33
        r119.put("image_list", r101);     // Catch: Throwable -> L33
        r119.put("multi_image", String.valueOf(r102));     // Catch: Throwable -> L33
        r119.put("extra_params", r103);     // Catch: Throwable -> L33
        r119.put("extra_persistent_params", r110);     // Catch: Throwable -> L33
        AppHost.Companion r120 = AppHost.f326268a;     // Catch: Throwable -> L33
        r119.put("channel", r120.getBuildChannel());     // Catch: Throwable -> L33
        IApplog.Companion r121 = IApplog.f287053a;     // Catch: Throwable -> L33
        r119.put(WsConstants.KEY_INSTALL_ID, r121.getInstallId());     // Catch: Throwable -> L33
        r119.put("appkey", "doubao_android");     // Catch: Throwable -> L33
        r119.put("appName", "doubao_app");     // Catch: Throwable -> L33
        r119.put("device_id", r121.getDeviceId());     // Catch: Throwable -> L33
        r119.put("aid", String.valueOf(r120.getAppId()));     // Catch: Throwable -> L33
        r119.put("report_type", "android_native");     // Catch: Throwable -> L33
        r104.label = 1;     // Catch: Throwable -> L33
        r112 = r118.postMessage(r119, r104);     // Catch: Throwable -> L33
        if (r112 != r106) goto L19;
        return r106;
    L33:
        AsyncThrowable.Companion.getClass();
        return new f(AsyncThrowable.access$getDEFAULT$cp(), null);
    L7:
        r104 = new VocApiKt$submitVocRequest$1(r111);
        goto L8
    }
}
