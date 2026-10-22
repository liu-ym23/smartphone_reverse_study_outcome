package xj7;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.byted.cast.common.source.ISendResultListener;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Callback;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.bytedance.ug.sdk.luckycat.impl.manager.LuckyCatSettingsManger;
import com.bytedance.ug.sdk.luckycat.impl.model.d;
import com.bytedance.ug.sdk.luckycat.impl.score.DeviceScoreApi;
import com.bytedance.ug.sdk.luckycat.impl.utils.u;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile a f564103c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f564104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f564105b;

    /* JADX INFO: renamed from: xj7.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes22.dex */
    public class C8245a implements Callback<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f564106a;

        @Override // com.bytedance.retrofit2.Callback
        public final void onFailure(Call<String> r100, Throwable r101) {
        }

        public C8245a(a r100) {
            this.f564106a = r100;
        }

        @Override // com.bytedance.retrofit2.Callback
        public final void onResponse(Call<String> r100, SsResponse<String> r101) {
            com.bytedance.ug.sdk.luckycat.impl.utils.a.a("DeviceScoreManager", "phone score onResponse");
            if (r101 != null) goto L7;
            com.bytedance.ug.sdk.luckycat.impl.utils.a.b("DeviceScoreManager", ISendResultListener.ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_RESPONSE_IS_NULL);
            return;
        L7:
            if (r101.isSuccessful() == true) goto L10;
            com.bytedance.ug.sdk.luckycat.impl.utils.a.b("DeviceScoreManager", "request failed");
            return;
        L10:
            String r102 = r101.body();
            if (r102 != null) goto L48;
            com.bytedance.ug.sdk.luckycat.impl.utils.a.b("DeviceScoreManager", "device score bean is null");
            return;
        L48:
            JSONObject r103 = new JSONObject(r102).optJSONObject("data");     // Catch: JSONException -> L22 NumberFormatException -> L24
            String r104 = "";
            if (r103 == null) goto L19;
            r104 = r103.optString("overall_score");     // Catch: JSONException -> L22 NumberFormatException -> L24
        L19:
            if (TextUtils.isEmpty(r104) == true) goto L26;
            float r105 = CastFloatProtector.parseFloat(r104);     // Catch: JSONException -> L22 NumberFormatException -> L24
        L27:
            com.bytedance.ug.sdk.luckycat.impl.utils.a.c("DeviceScoreManager", "score : " + r105);
            if (r105 <= 0.0f) goto L50;
            a r106 = this.f564106a;
            r106.getClass();
            LuckyCatSettingsManger r107 = LuckyCatSettingsManger.b.f271283a;
            r107.getClass();
            Object r108 = r107.c(new String[]{"common", "device_score_config"});
            if ((r108 instanceof JSONObject) == false) goto L32;
            JSONObject r109 = (JSONObject) r108;
        L34:
            if (r109 != null) goto L36;
            int r110 = -1;
        L37:
            if (r110 == (-1)) goto L51;
            r106.f564105b = r105;
            u r111 = u.a();
            r111.e("device_score_version");
            int r112 = r111.f271527a.getInt("device_score_version", -1);
            u.a().f("device_score_version", r110);
            u r113 = u.a();
            r113.e("key_device_score");
            SharedPreferences.Editor r114 = r113.f271527a.edit();
            r114.putFloat("key_device_score", r105);
            r114.apply();
            JSONObject r115 = new JSONObject();
            r115.put("pre_device_score", r112);     // Catch: JSONException -> L42
            r115.put("cur_device_score", r110);     // Catch: JSONException -> L42
        L44:
            d.a("ug_sdk_luckycat_device_score_updated", r115, true);
            return;
        L42:
            e = move-exception;
            e.getMessage();
            goto L44
        L51:
            return;
        L36:
            r110 = r109.optInt("device_score_version", -1);
            goto L37
        L32:
            r109 = null;
            goto L34
        L50:
            return;
        L26:
            r105 = -1.0f;
        L24:
            e = move-exception;
            e.getMessage();
        L22:
            e = move-exception;
            e.getMessage();
            goto L26
        }
    }

    public static a a() {
        if (f564103c != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f564103c != null) goto L9;
        f564103c = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f564103c;
    }

    public final void b() {
        LuckyCatSettingsManger r100 = LuckyCatSettingsManger.b.f271283a;
        r100.getClass();
        Object r101 = r100.c(new String[]{"common", "device_score_config"});
        if ((r101 instanceof JSONObject) == false) goto L5;
        JSONObject r102 = (JSONObject) r101;
    L6:
        boolean r103 = false;
        if (r102 != null) goto L10;
    L19:
        if (r103 == true) goto L22;
        return;
    L22:
        if (this.f564104a == false) goto L24;
        return;
    L24:
        this.f564104a = true;
        HashMap r104 = new HashMap();
        r104.put("device_type", Build.MODEL);
        ((DeviceScoreApi) RetrofitUtils.createSsService("https://api.toutiaoapi.com/", DeviceScoreApi.class)).getDeviceScore(r104).enqueue(new C8245a(this));
        return;
    L10:
        if (r102.optBoolean("enable_device_score", false) == false) goto L19;
        int r105 = r102.optInt("device_score_version", -1);
        if (r105 == (-1)) goto L19;
        if (r105 < 0) goto L19;
        u r106 = u.a();
        r106.e("device_score_version");
        if (r105 <= r106.f271527a.getInt("device_score_version", -1)) goto L19;
        r103 = true;
        goto L19
    L5:
        r102 = null;
        goto L6
    }

    public a() {
        this.f564105b = -1.0f;
        u r100 = u.a();
        r100.e("key_device_score");
        this.f564105b = r100.f271527a.getFloat("key_device_score", -1.0f);
    }
}
