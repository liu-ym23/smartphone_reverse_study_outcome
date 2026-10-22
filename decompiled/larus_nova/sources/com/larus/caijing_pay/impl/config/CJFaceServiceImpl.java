package com.larus.caijing_pay.impl.config;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import bx8.b;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayDoFaceLive;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.larus.utils.logger.FLogger;
import com.ss.android.bytedcert.manager.BytedCertManager;
import com.ss.android.bytedcert.net.BDResponse;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import we4.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/larus/caijing_pay/impl/config/CJFaceServiceImpl;", "Lcom/bytedance/caijing/sdk/infra/base/api/face/FaceService;", "<init>", "()V", "TAG", "", "invokeFace", "", "ctx", "Landroid/content/Context;", "initMap", "", "callback", "Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayDoFaceLive$TTCJPayFaceLiveCallback;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJFaceServiceImpl implements FaceService {
    private final String TAG;

    public static /* synthetic */ void E2(TTCJPayDoFaceLive.TTCJPayFaceLiveCallback r100, CJFaceServiceImpl r101, BDResponse r102) {
        invokeFace$lambda$1(r100, r101, r102);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.face.FaceService
    public Activity[] getHostActivityStack() {
        return null;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.face.FaceService
    public boolean isPluginAlready(boolean r100) {
        return false;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.face.FaceService
    public boolean isUserAgreePrivacyPolicy() {
        return true;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.face.FaceService
    public boolean makeShowSystemToast(Context r100, String r101) {
        return false;
    }

    public CJFaceServiceImpl() {
        this.TAG = "CJFaceServiceImpl";
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.face.FaceService
    public boolean isExternalTargetSecure(Intent r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        return true;
    }

    private static final void invokeFace$lambda$1(TTCJPayDoFaceLive.TTCJPayFaceLiveCallback r100, CJFaceServiceImpl r101, BDResponse r102) {
        JSONObject r103 = new JSONObject();
        r100.dismissLoading();     // Catch: JSONException -> L5
        r103.put("jsonData", r102.jsonData);     // Catch: JSONException -> L5
        r103.put("success", r102.success);     // Catch: JSONException -> L5
        r103.put("ticket", r102.ticket);     // Catch: JSONException -> L5
        r103.put("errorMsg", r102.errorMsg);     // Catch: JSONException -> L5
        r103.put("detailErrorMsg", r102.detailErrorMsg);     // Catch: JSONException -> L5
        r103.put("errorCode", r102.errorCode);     // Catch: JSONException -> L5
        r100.onResult(r103);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e(r101.TAG, "invokeFace JSONException", e);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.face.FaceService
    public boolean invokeFace(Context r100, Map<String, String> r101, final TTCJPayDoFaceLive.TTCJPayFaceLiveCallback r102) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Intrinsics.checkNotNullParameter(r101, "initMap");
        Intrinsics.checkNotNullParameter(r102, "callback");
        if ((r100 instanceof Activity) == true) goto L6;
        return false;
    L6:
        HashMap<String, String> r103 = new HashMap();
        r103.putAll(r101);
        if (r101.containsKey("use_new_api") == true) goto L9;
        r103.put("use_new_api", "true");
    L9:
        BytedCertManager.getInstance().doFaceLive(r100, r103, new b(r102, this));
        return true;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.face.FaceService
    public void ensureAliYunPluginReady(Context r100, a<td4.a> r101, String r102, boolean r103, boolean r104, String r105, FaceService.c r106) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Intrinsics.checkNotNullParameter(r102, "riskSource");
        if (r101 == null) goto L6;
        FaceService.Companion.getClass();
        Pair<Integer, String> r107 = FaceService.a.f202223c;
        r101.onResult(new we4.b(((Number) r107.first).intValue(), (String) r107.second, null));
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.face.FaceService
    public void ensurePluginReady(Context r100, a<td4.a> r101, String r102, boolean r103, boolean r104, String r105, FaceService.c r106) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Intrinsics.checkNotNullParameter(r102, "riskSource");
        if (r101 == null) goto L6;
        FaceService.Companion.getClass();
        Pair<Integer, String> r107 = FaceService.a.f202223c;
        r101.onResult(new we4.b(((Number) r107.first).intValue(), (String) r107.second, null));
        return;
    }
}
