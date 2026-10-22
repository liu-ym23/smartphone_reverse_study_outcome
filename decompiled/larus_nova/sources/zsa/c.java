package zsa;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.bridge.model.BridgeResult;
import com.bytedance.sdk.bridge.model.IBridgeContext;
import com.ss.android.bytedcert.config.ICnNetIdService;
import com.ss.android.bytedcert.manager.BytedCertManager;
import com.ss.android.cert.manager.BytedCertSdkInitParam;
import com.ss.android.cert.manager.BytedCertSdkManager;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class c extends ysa.a {

    public class a implements ICnNetIdService.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f573507a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IBridgeContext f573508b;

        public a(int r100, IBridgeContext r101) {
            this.f573507a = r100;
            this.f573508b = r101;
        }

        @Override // com.ss.android.bytedcert.config.ICnNetIdService.Callback
        public final void onResult(boolean r110, Bundle r111) {
            JSONObject r100 = new JSONObject();
            int r101 = 2;
            if (r111 != null) goto L15;
        L11:
            r100.put("appJumpStatus", r101);     // Catch: Exception -> L14
        L12:
            this.f573508b.callback(BridgeResult.Companion.createSuccessResult(r100));
            return;
        L15:
            String r102 = r111.getString("resultCode");     // Catch: Exception -> L14
            String r103 = r111.getString("resultDesc");     // Catch: Exception -> L14
            if (r110 == false) goto L8;
            String r112 = r111.getString(ICnNetIdService.Key.ID_CARD_AUTH_DATA);     // Catch: Exception -> L14
            String r104 = r111.getString(ICnNetIdService.Key.CERT_PWD_DATA);     // Catch: Exception -> L14
            String r113 = r111.getString(ICnNetIdService.Key.EXTRAS);     // Catch: Exception -> L14
            String r114 = r111.getString(ICnNetIdService.Key.BIZ_SEQ);     // Catch: Exception -> L14
            r100.put(ICnNetIdService.Key.ID_CARD_AUTH_DATA, r112);     // Catch: Exception -> L14
            r100.put(ICnNetIdService.Key.CERT_PWD_DATA, r104);     // Catch: Exception -> L14
            r100.put(ICnNetIdService.Key.EXTRAS, r113);     // Catch: Exception -> L14
            r100.put(ICnNetIdService.Key.BIZ_SEQ, r114);     // Catch: Exception -> L14
            r100.put("authType", this.f573507a);     // Catch: Exception -> L14
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

    public c() {
    }

    @Override // ysa.a
    public final void a(Context r100, IBridgeContext r110, Object... r111) {
        if (r110 != null) goto L5;
        return;
    L5:
        BytedCertSdkInitParam.CnNetAuthParams r101 = BytedCertSdkManager.getInstance().getCnNetAuthParams();
        ICnNetIdService r102 = BytedCertManager.getInstance().getCnNetIdService();
        if (r101 == null) goto L17;
        if (r102 == null) goto L17;
        if (r111.length <= 0) goto L14;
        Object r103 = r111[0];
        if ((r103 instanceof Integer) == false) goto L14;
        int r104 = ((Integer) r103).intValue();
    L15:
        r102.startAuth(r110.getActivity(), r101.getOrgID(), r101.getAppId(), r104, new a(r104, r110));
        return;
    L14:
        r104 = 0;
    L17:
        JSONObject r112 = new JSONObject();
        r112.put("resultCode", "-1");     // Catch: JSONException -> L21
        r112.put("resultDesc", "un support");     // Catch: JSONException -> L21
        r112.put("appJumpStatus", 2);     // Catch: JSONException -> L21
    L19:
        r110.callback(BridgeResult.Companion.createErrorResult("un support", r112));
    }
}
