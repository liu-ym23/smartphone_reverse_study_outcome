package vx4;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class q implements ValueCallback<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f557484a;

    public q(r r100) {
        this.f557484a = r100;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(String r110) {
        String r111 = r110;
        if (r111 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r111) == true) goto L28;
        tt5.a.d("WebResourceDebugInfo", "onReceiveValue:".concat(r111));
        JSONObject r100 = new JSONObject(r111);     // Catch: JSONException -> L22
        String r112 = r100.optString("branch");     // Catch: JSONException -> L22
        String r101 = r100.optString("type");     // Catch: JSONException -> L22
        String r102 = r100.optString("version");     // Catch: JSONException -> L22
        String r103 = r100.optString("isSlimBundle", "null");     // Catch: JSONException -> L22
        StringBuilder r104 = new StringBuilder("version:\t");     // Catch: JSONException -> L22
        if (TextUtils.isEmpty(r102) == false) goto L12;
        r102 = "";
    L12:
        r104.append(r102);     // Catch: JSONException -> L22
        r104.append("\nslimBundle:\t");     // Catch: JSONException -> L22
        r104.append(r103);     // Catch: JSONException -> L22
        r104.append("\nbranch:\t");     // Catch: JSONException -> L22
        if (TextUtils.isEmpty(r112) == false) goto L16;
        r112 = "";
    L16:
        r104.append(r112);     // Catch: JSONException -> L22
        r104.append("\ntype:\t");     // Catch: JSONException -> L22
        if (TextUtils.isEmpty(r101) == false) goto L20;
        r101 = "";
    L20:
        r104.append(r101);     // Catch: JSONException -> L22
        this.f557484a.K.setSummary(r104.toString());     // Catch: JSONException -> L22
        return;
    L22:
        e = move-exception;
        tt5.a.f("WebResourceDebugInfo", e, false);
        this.f557484a.K.setSummary("");
        return;
    }
}
