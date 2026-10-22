package vx4;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class q implements ValueCallback<String> {
    public final /* synthetic */ r a;

    public q(r r1) {
        this.a = r1;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(String r12) {
        String r13 = r12;
        if (r13 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r13) == true) goto L28;
        tt5.a.d("WebResourceDebugInfo", "onReceiveValue:".concat(r13));
        JSONObject r5 = new JSONObject(r13);     // Catch: JSONException -> L22
        String r14 = r5.optString("branch");     // Catch: JSONException -> L22
        String r7 = r5.optString("type");     // Catch: JSONException -> L22
        String r8 = r5.optString("version");     // Catch: JSONException -> L22
        String r6 = r5.optString("isSlimBundle", "null");     // Catch: JSONException -> L22
        StringBuilder r9 = new StringBuilder("version:\t");     // Catch: JSONException -> L22
        if (TextUtils.isEmpty(r8) == false) goto L12;
        r8 = "";
    L12:
        r9.append(r8);     // Catch: JSONException -> L22
        r9.append("\nslimBundle:\t");     // Catch: JSONException -> L22
        r9.append(r6);     // Catch: JSONException -> L22
        r9.append("\nbranch:\t");     // Catch: JSONException -> L22
        if (TextUtils.isEmpty(r14) == false) goto L16;
        r14 = "";
    L16:
        r9.append(r14);     // Catch: JSONException -> L22
        r9.append("\ntype:\t");     // Catch: JSONException -> L22
        if (TextUtils.isEmpty(r7) == false) goto L20;
        r7 = "";
    L20:
        r9.append(r7);     // Catch: JSONException -> L22
        this.a.K.setSummary(r9.toString());     // Catch: JSONException -> L22
        return;
    L22:
        e = move-exception;
        tt5.a.f("WebResourceDebugInfo", e, false);
        this.a.K.setSummary("");
        return;
    }
}
