package osa;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.ss.android.bytedcert.net.BDResponse;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f526564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f526565b;

    public a(BDResponse r100) {
        if (r100 == null) goto L24;
    L19:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        if (r100.success == false) goto L25;
        JSONObject r101 = r100.jsonData;     // Catch: Exception -> L19
        if (r101 == null) goto L26;
        JSONObject r102 = r101.optJSONObject(SlcCommonAction.KEY_ACTIONS);     // Catch: Exception -> L19
        if (r102 == null) goto L27;
        boolean r103 = false;
        r102.optInt("ocr", 0);     // Catch: Exception -> L19
        r102.optInt("live_detect", 0);     // Catch: Exception -> L19
        r102.optInt("veri_two_element", 0);     // Catch: Exception -> L19
        r102.optInt("veri_three_element_mobile", 0);     // Catch: Exception -> L19
        if (r102.optInt("veri_face_compare", 0) == 0) goto L13;
        boolean r104 = true;
    L14:
        this.f526564a = r104;     // Catch: Exception -> L19
        r102.optInt("veri_manual_check", 0);     // Catch: Exception -> L19
        r102.optInt("auth_two_element", 0);     // Catch: Exception -> L19
        r102.optInt("auth_three_element_mobile", 0);     // Catch: Exception -> L19
        if (r102.optInt("auth_face_compare", 0) == 0) goto L17;
        r103 = true;
    L17:
        this.f526565b = r103;     // Catch: Exception -> L19
        return;
    L13:
        r104 = false;
        goto L14
    L27:
        return;
    L26:
        return;
    L25:
        return;
    }
}
