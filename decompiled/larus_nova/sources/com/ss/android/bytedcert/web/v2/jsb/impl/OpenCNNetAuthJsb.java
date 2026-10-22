package com.ss.android.bytedcert.web.v2.jsb.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.ss.android.bytedcert.config.ICnNetIdService;
import com.ss.android.bytedcert.manager.BytedCertManager;
import com.ss.android.bytedcert.web.v2.jsb.AbsJsBridge;
import com.ss.android.cert.manager.BytedCertSdkInitParam;
import com.ss.android.cert.manager.BytedCertSdkManager;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.web.jsb.IBridgeContext;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class OpenCNNetAuthJsb extends AbsJsBridge {
    private static final long serialVersionUID = 6565621099414609093L;

    public class a implements ICnNetIdService.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBridgeContext f407921a;

        public a(IBridgeContext r100) {
            this.f407921a = r100;
        }

        @Override // com.ss.android.bytedcert.config.ICnNetIdService.Callback
        public final void onResult(boolean r110, Bundle r111) {
            JSONObject r100 = new JSONObject();
            int r101 = 2;
            if (r111 != null) goto L15;
        L11:
            r100.put("appJumpStatus", r101);     // Catch: Exception -> L14
        L12:
            this.f407921a.onSuccess(r100);
            return;
        L15:
            String r102 = r111.getString("resultCode");     // Catch: Exception -> L14
            String r103 = r111.getString("resultDesc");     // Catch: Exception -> L14
            if (r110 == false) goto L8;
            String r112 = r111.getString(ICnNetIdService.Key.ID_CARD_AUTH_DATA);     // Catch: Exception -> L14
            String r104 = r111.getString(ICnNetIdService.Key.CERT_PWD_DATA);     // Catch: Exception -> L14
            String r113 = r111.getString(ICnNetIdService.Key.EXTRAS);     // Catch: Exception -> L14
            r100.put(ICnNetIdService.Key.ID_CARD_AUTH_DATA, r112);     // Catch: Exception -> L14
            r100.put(ICnNetIdService.Key.CERT_PWD_DATA, r104);     // Catch: Exception -> L14
            r100.put(ICnNetIdService.Key.EXTRAS, r113);     // Catch: Exception -> L14
            r101 = 1;
        L10:
            r100.put("resultCode", r102);     // Catch: Exception -> L14
            r100.put("resultDesc", r103);     // Catch: Exception -> L14
            goto L11
        L8:
            if (TextUtils.equals(ICnNetIdService.ResultCode.UNINSTALL, r102) == false) goto L10;
            r101 = 0;
            goto L10
        }
    }

    public OpenCNNetAuthJsb() {
    }

    @Override // com.ss.android.cert.manager.web.jsb.IJsBridge
    public void invoke(IBridgeContext r110, Object... r111) {
        if (r110 != null) goto L6;
        return;
    L6:
        if (BytedCertConstant.JsbKey.METHOD_OPEN_CN_NET_AUTH.equals((String) r111[0]) == false) goto L19;
        BytedCertSdkInitParam.CnNetAuthParams r100 = BytedCertSdkManager.getInstance().getCnNetAuthParams();
        ICnNetIdService r101 = BytedCertManager.getInstance().getCnNetIdService();
        if (r100 == null) goto L12;
        if (r101 == null) goto L12;
        int r102 = ((Integer) r111[1]).intValue();
        r101.startAuth(r110.getActivity(), r100.getOrgID(), r100.getAppId(), r102, new a(r110));
        return;
    L12:
        JSONObject r112 = new JSONObject();
        r112.put("resultCode", "-1");     // Catch: JSONException -> L16
        r112.put("resultDesc", "un support");     // Catch: JSONException -> L16
        r112.put("appJumpStatus", 2);     // Catch: JSONException -> L16
    L14:
        r110.onError("un support", r112);
        return;
    }
}
