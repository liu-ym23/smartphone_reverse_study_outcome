package hf7;

import android.os.Build;
import com.alipay.sdk.m.u.i;
import com.tencent.connect.common.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f484925a = null;

    static {
        JSONObject r100 = new JSONObject();
        r100.put(Constants.PARAM_PLATFORM_ID, "android");     // Catch: JSONException -> L13
        r100.put("osv", Build.VERSION.RELEASE + i.f25853b + Build.VERSION.SDK_INT);     // Catch: JSONException -> L13
        r100.put("bd", Build.BRAND);     // Catch: JSONException -> L13
        r100.put("mf", Build.MANUFACTURER);     // Catch: JSONException -> L13
        r100.put("md", Build.MODEL);     // Catch: JSONException -> L13
        f484925a = r100.toString();     // Catch: JSONException -> L13
        return;
    L13:
        f484925a = "{\"pf\":\"android\",\"osv\":\"" + Build.VERSION.RELEASE + i.f25853b + Build.VERSION.SDK_INT + "\",\"bd\":\"" + Build.BRAND + "\",\"mf\":\"" + Build.MANUFACTURER + "\",\"md\":\"" + Build.MODEL + "\"}";
    }
}
