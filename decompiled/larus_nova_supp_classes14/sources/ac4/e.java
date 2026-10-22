package ac4;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import org.json.JSONException;
import org.json.JSONObject;
import qb4.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class e implements a {
    public final Activity a;

    public void c(c r1) {
        throw null;
    }

    public void d(int r1, String r2) {
        throw null;
    }

    public void e() {
    }

    public e(Activity r1) {
        this.a = r1;
    }

    @Override // ac4.a
    public final void a(c r7) {
        String r0 = r7.a;     // Catch: JSONException -> L67
        if (r0 != null) goto L6;
        return;
    L6:
        switch(r0.hashCode()) {
            case -440027648: goto L36;
            case -433891794: goto L33;
            case -431325456: goto L30;
            case -418116003: goto L27;
            case -294538015: goto L24;
            case -268991152: goto L21;
            case 103102532: goto L18;
            case 239578933: goto L15;
            case 428780843: goto L12;
            case 1807041893: goto L9;
            default: goto L38;
        };     // Catch: JSONException -> L67
    L38:
        byte r1 = -1;
    L39:
        JSONObject r5 = null;
        switch(r1) {
            case 0: goto L71;
            case 1: goto L63;
            case 2: goto L61;
            case 3: goto L57;
            case 4: goto L52;
            case 5: goto L51;
            case 6: goto L48;
            case 7: goto L44;
            case 8: goto L43;
            case 9: goto L42;
            default: goto L87;
        };
    L42:
        e();     // Catch: JSONException -> L67
        return;
    L43:
        c(r7);     // Catch: JSONException -> L67
        return;
    L44:
        BdTuringConfig r2 = qb4.b.c.a.a;     // Catch: JSONException -> L67
        if (r2 == null) goto L47;
        r5 = r2.getTheme(4);     // Catch: JSONException -> L67
    L47:
        r7.d(1, r5);     // Catch: JSONException -> L67
        return;
    L48:
        JSONObject r3 = new JSONObject(r7.b);     // Catch: JSONException -> L67
        String r8 = r3.optString("phone_number");     // Catch: JSONException -> L67
        String r4 = r3.optString("sms_content");     // Catch: JSONException -> L67
        if (this.a == null) goto L77;
        Intent r6 = new Intent("android.intent.action.SENDTO", UriProtector.parse("smsto:" + r8));     // Catch: JSONException -> L67
        r6.putExtra("sms_body", r4);     // Catch: JSONException -> L67
        this.a.startActivity(r6);     // Catch: JSONException -> L67
        return;
    L77:
        return;
    L51:
        r7.d(1, null);     // Catch: JSONException -> L67
        return;
    L52:
        new JSONObject(r7.b).optString("text");     // Catch: JSONException -> L67
        if (this.a != null) goto L55;
        return;
    L55:
        if (com.bytedance.bdturing.twiceverify.a.a().a == null) goto L81;
        com.bytedance.bdturing.twiceverify.a.a().a.showLoading();     // Catch: JSONException -> L67
        return;
    L81:
        return;
    L57:
        String r9 = new JSONObject(r7.b).optString("text");     // Catch: JSONException -> L67
        Activity r10 = this.a;     // Catch: JSONException -> L67
        if (r10 == null) goto L83;
        Toast.makeText(r10, r9, 0).show();     // Catch: JSONException -> L67
        return;
    L83:
        return;
    L63:
        JSONObject r11 = new JSONObject(r7.b);     // Catch: JSONException -> L67
        d(r11.optInt("status_code"), r11.optString("message"));     // Catch: JSONException -> L67
        return;
    L71:
        c0.a.a.a(new d(this, new JSONObject(r7.b), r7));     // Catch: Exception -> L70
        return;
    L90:
        return;
    L87:
        return;
    L61:
        if (com.bytedance.bdturing.twiceverify.a.a().a == null) goto L85;
        com.bytedance.bdturing.twiceverify.a.a().a.dismissLoading();     // Catch: JSONException -> L67
        return;
    L85:
        return;
    L9:
        if (r0.equals("second_verify.openSms") == false) goto L38;
        r1 = 6;
        goto L39
    L12:
        if (r0.equals("bytedcert.getSettings") == false) goto L38;
        r1 = 7;
        goto L39
    L15:
        if (r0.equals("second_verify.showLoading") == false) goto L38;
        r1 = 4;
        goto L39
    L18:
        if (r0.equals("second_verify.isSmsAvailable") == false) goto L38;
        r1 = 5;
        goto L39
    L21:
        if (r0.equals("second_verify.hideLoading") == false) goto L38;
        r1 = 2;
        goto L39
    L24:
        if (r0.equals("second_verify.h5_available") == false) goto L38;
        r1 = 9;
        goto L39
    L27:
        if (r0.equals("second_verify.toast") == false) goto L38;
        r1 = 3;
        goto L39
    L30:
        if (r0.equals("second_verify.fetch") == false) goto L38;
        r1 = 0;
        goto L39
    L33:
        if (r0.equals("second_verify.close") == false) goto L38;
        r1 = 1;
        goto L39
    L36:
        if (r0.equals("bytedcert.getSdkInfo") == false) goto L38;
        r1 = 8;
    L67:
        e = move-exception;
        e.printStackTrace();
    }

    public static void b(e r2, JSONObject r3, BdTuringConfig r4) throws JSONException {
        r2.getClass();
        if (r4 == null) goto L55;
        if (r3.has("app_name") == true) goto L8;
        r3.put("app_name", r4.getAppName());
    L8:
        if (r3.has("app_version") == true) goto L11;
        r3.put("app_version", r4.getAppVersion());
    L11:
        if (r3.has("version_code") == true) goto L14;
        r3.put("version_code", r4.getAppVersionCode());
    L14:
        if (r3.has("version_name") == true) goto L17;
        r3.put("version_name", r4.getAppVersion());
    L17:
        if (r3.has("aid") == true) goto L20;
        r3.put("aid", r4.getAppId());
    L20:
        if (r3.has("iid") == true) goto L23;
        r3.put("iid", r4.getInstallId());
    L23:
        if (r3.has("device_id") == true) goto L26;
        r3.put("device_id", r4.getDeviceId());
    L26:
        if (r3.has("device_model") == true) goto L29;
        r3.put("device_model", r4.getDeviceModel());
    L29:
        if (r3.has("device_brand") == true) goto L32;
        r3.put("device_brand", r4.getDeviceBrand());
    L32:
        if (r3.has("os_type") == true) goto L35;
        r3.put("os_type", r4.getOsType());
    L35:
        if (r3.has("os_version") == true) goto L38;
        r3.put("os_version", r4.getOsVersion());
    L38:
        if (r3.has("channel") == true) goto L41;
        r3.put("channel", r4.getChannel());
    L41:
        if (r3.has("region") == true) goto L46;
        if (r4.getRegionType() == null) goto L46;
        r3.put("region", r4.getRegionType().getName());
    L46:
        if (r3.has("sdk_version") == true) goto L49;
        r3.put("sdk_version", r4.getSdkVersion());
    L49:
        if (r3.has("language") == true) goto L52;
        r3.put("language", r4.getLanguage());
    L52:
        if (r3.has("locale") == true) goto L55;
        r3.put("locale", r4.getLocale());
    L55:
        if (r3.has("time") == true) goto L58;
        r3.put("time", System.currentTimeMillis());
    L58:
        if (r3.has("device_platform") == true) goto L61;
        r3.put("device_platform", "android");
    L61:
        if (r3.has("resolution") == true) goto L64;
        r3.put("resolution", hc4.f.i());
        return;
    }
}
