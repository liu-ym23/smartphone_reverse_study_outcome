package os6;

import android.os.Bundle;
import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.bytedance.sdk.account.platform.base.OnekeyLoginErrorResponse;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class g implements AuthorizeCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f526511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f526512b;

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public final void onError(AuthorizeErrorResponse r100) {
        if ((r100 instanceof OnekeyLoginErrorResponse) == false) goto L11;
        this.f526511a.put("code", 0);     // Catch: Exception -> L6
        this.f526511a.put("from", ((OnekeyLoginErrorResponse) r100).netType);     // Catch: Exception -> L6
        this.f526511a.put("maskErrorCode", ((OnekeyLoginErrorResponse) r100).platformErrorCode);     // Catch: Exception -> L6
        this.f526512b.onResult(this.f526511a);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public final void onSuccess(Bundle r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getString(IOnekeyLoginService.ResponseConstants.SECURITY_PHONE);
    L6:
        if (r100 == null) goto L13;
        r101 = r100.getString("net_type");
    L13:
        this.f526511a.put("code", 1);     // Catch: Exception -> L10
        this.f526511a.put("phoneMask", r102);     // Catch: Exception -> L10
        this.f526511a.put("from", r101);     // Catch: Exception -> L10
        this.f526511a.put("maskErrorCode", 0);     // Catch: Exception -> L10
        this.f526512b.onResult(this.f526511a);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        r102 = null;
        goto L6
    }

    public g(JSONObject r100, c.C7106c r101) {
        this.f526511a = r100;
        this.f526512b = r101;
    }
}
