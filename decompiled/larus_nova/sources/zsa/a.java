package zsa;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.bridge.model.BridgeResult;
import com.bytedance.sdk.bridge.model.IBridgeContext;
import com.ss.android.bytedcert.callback.NfcEventCallback;
import com.ss.android.bytedcert.callback.NfcStatusCallback;
import com.ss.android.bytedcert.config.INfcService;
import com.ss.android.bytedcert.manager.BytedCertManager;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.ErrorConstant;
import com.ss.android.cert.manager.utils.CertLog;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class a extends ysa.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final INfcService f573501a;

    public a() {
        this.f573501a = BytedCertManager.getInstance().getNfcService();
    }

    public static void b(IBridgeContext r100, Pair r101, String r102) {
        JSONObject r103 = new JSONObject();
        if (r101 == null) goto L6;
        r103.put("status_code", r101.first);     // Catch: Exception -> L12
        r103.put("description", r101.second);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    L6:
        if (TextUtils.isEmpty(r102) == true) goto L8;
        r103.put("result", r102);     // Catch: Exception -> L12
    L8:
        if (r100 == null) goto L10;
        r100.callback(BridgeResult.Companion.createSuccessResult(r103));     // Catch: Exception -> L12
        return;
    L10:
        CertLog.d("NFCMangerJSB", "brigeContext is null");     // Catch: Exception -> L12
    }

    @Override // ysa.a
    public final void a(Context r100, IBridgeContext r110, Object... r111) {
        if (r100 == null) goto L44;
        byte r101 = 0;
        String r102 = (String) r111[0];
        if (TextUtils.isEmpty(r102) == true) goto L46;
        r102.getClass();
        int r103 = r102.hashCode();
        if (r103 == (-40919893)) goto L22;
        if (r103 == 1742559963) goto L18;
        if (r103 == 2081930135) goto L14;
    L23:
        r101 = -1;
    L24:
        if (r101 == 0) goto L38;
        if (r101 == 1) goto L35;
        if (r101 == 2) goto L29;
        return;
    L29:
        if (TextUtils.isEmpty((String) r111[1]) == true) goto L47;
        Object r104 = r111[2];
        if ((r104 instanceof NfcEventCallback) == false) goto L48;
        Activity r105 = (Activity) r100;
        String r112 = (String) r111[1];
        NfcEventCallback r106 = (NfcEventCallback) r104;
        INfcService r107 = this.f573501a;
        if (r107 == null) goto L49;
        r107.initNFC(r105);
        this.f573501a.startNFC(r105, r112, r106);
        b(r110, null, "");
        return;
    L49:
        return;
    L48:
        return;
    L47:
        return;
    L35:
        Activity r108 = (Activity) r100;
        INfcService r113 = this.f573501a;
        if (r113 == null) goto L51;
        r113.stopNFC(r108);
        b(null, null, "");
        return;
    L51:
        return;
    L38:
        Object r114 = r111[1];
        if ((r114 instanceof NfcStatusCallback) == false) goto L53;
        Activity r109 = (Activity) r100;
        NfcStatusCallback r115 = (NfcStatusCallback) r114;
        INfcService r116 = this.f573501a;
        if (r116 == null) goto L54;
        b(r110, null, String.valueOf(r116.caniuseNFC(r109, r115)));
        return;
    L54:
        return;
    L53:
        return;
    L14:
        if (r102.equals(BytedCertConstant.JsbKey.METHOD_START_NFC) == false) goto L23;
        r101 = 2;
        goto L24
    L18:
        if (r102.equals(BytedCertConstant.JsbKey.METHOD_STOP_NFC) == false) goto L23;
        r101 = 1;
        goto L24
    L22:
        if (r102.equals(BytedCertConstant.JsbKey.METHOD_CAN_I_USE_NFC) == true) goto L24;
    L46:
        return;
    L44:
        b(null, ErrorConstant.Client.ERROR_UNKNOWN, "");
    }
}
