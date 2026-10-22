package ve0;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdk.config.vb0;
import com.bytedance.android.livesdkapi.model.ParseSeiData;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f554321a = 0;

    static {
    }

    public static JSONObject a(String r100) {
        LiveSeiUtil.f71508i.getClass();
        if (LiveSeiUtil.b(r100) == false) goto L35;
    L27:
        e = move-exception;
        ALogger.e("MultiLinkSeiParseUtil", "error message: " + e);
        return null;
    L5:
        if (((Boolean) LiveSeiUtil.f71502c.getValue()).booleanValue() == true) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == true) goto L12;
    L14:
        JSONObject r102 = new JSONObject(r100);     // Catch: JSONException -> L27
    L16:
        if (r102.has("info") == true) goto L18;
        return r102;
    L18:
        if (r102.has("source") == true) goto L20;
        return r102;
    L20:
        if (TextUtils.equals(r102.optString("source"), "zego") == false) goto L33;
        Object r103 = r102.get("info");     // Catch: JSONException -> L27
        if (r103 == null) goto L25;
        return (JSONObject) r103;
    L25:
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");     // Catch: JSONException -> L27
    L33:
        return r102;
    L12:
        if (vb0.f121435a.getValue().booleanValue() == false) goto L14;
        r102 = LiveSeiUtil.c(r100);     // Catch: JSONException -> L27
        goto L16
    L7:
        if (((Boolean) LiveSeiUtil.f71504e.getValue()).booleanValue() == false) goto L9;
        r101 = true;
        goto L10
    L35:
        return null;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x007b -> B:19:0x008e). Please report as a decompilation issue!!! */
    public static ParseSeiData b(String r110) {
        Intrinsics.checkNotNullParameter(r110, "sei");
        JSONObject r100 = a(r110);     // Catch: JSONException -> L17
        if (r100 != null) goto L6;
    L19:
        ParseSeiData r101 = null;
    L21:
        return r101;
    L6:
        if (r100.has("app_data") == false) goto L19;
        String r102 = new Regex("\\\\").replace(JSONObjectProtectorUtils.getString(r100, "app_data"), "");     // Catch: JSONException -> L17
        if (Intrinsics.areEqual(r102, "") == true) goto L19;
        if (Intrinsics.areEqual(r102, " ") == true) goto L19;
        JSONObject r103 = new JSONObject(r102);     // Catch: JSONException -> L17
        JSONObject r104 = r103.optJSONObject("canvas");     // Catch: JSONException -> L17
        int r105 = r103.optInt("ver");     // Catch: JSONException -> L17
        int r111 = r103.optInt("ui_layout");     // Catch: JSONException -> L17
        int r106 = r103.optInt(BdpAppEventConstant.PARAMS_SUB_SCENE);     // Catch: JSONException -> L17
        if (r104 != null) goto L15;
        r101 = new ParseSeiData(r105, r106, r111, null, 0, false, null, 0, 248, null);     // Catch: JSONException -> L17
        goto L21
    L15:
        r101 = new ParseSeiData(r105, r106, r111, r104, 0, false, null, 0, 240, null);     // Catch: JSONException -> L17
    L17:
        e = move-exception;
        ALogger.e("MultiLinkSeiParseUtil", "error message: " + e);
        goto L19
    }
}
