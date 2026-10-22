package hj7;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.bridge.annotation.BridgeContext;
import com.bytedance.sdk.bridge.annotation.BridgeMethod;
import com.bytedance.sdk.bridge.annotation.BridgeParam;
import com.bytedance.sdk.bridge.model.IBridgeContext;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class h {

    public static final class a {
    }

    static {
    }

    public h() {
    }

    @BridgeMethod("luckycatCheckFunctionSwitch")
    public final void checkFunctionSwitch(@BridgeContext IBridgeContext r100, @BridgeParam("function_list") JSONArray r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101.length() > 0) goto L17;
        r100.callback(hj7.a.a(0, null, "fail"));
        return;
    L17:
        ArrayList r102 = new ArrayList();     // Catch: JSONException -> L13
        int r103 = r101.length();     // Catch: JSONException -> L13
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L11;
        String r105 = r101.optString(r104);     // Catch: JSONException -> L13
        if (r105 == null) goto L10;
        r102.add(r105);     // Catch: JSONException -> L13
    L10:
        r104 = r104 + 1;     // Catch: JSONException -> L13
        goto L6
    L11:
        List<com.bytedance.ug.sdk.luckycat.impl.utils.g.a> r106 = com.bytedance.ug.sdk.luckycat.impl.utils.g.a(r100.getActivity(), r102);     // Catch: JSONException -> L13
        String r107 = GsonProtectorUtils.toJson(new Gson(), r106);     // Catch: JSONException -> L13
        JSONObject r108 = new JSONObject();     // Catch: JSONException -> L13
        r108.put("function_switch", new JSONArray(r107));     // Catch: JSONException -> L13
        r100.callback(hj7.a.a(1, r108, "success"));     // Catch: JSONException -> L13
        return;
    L13:
        e = move-exception;
        r100.callback(hj7.a.a(0, null, "fail"));
        e.getLocalizedMessage();
    }

    @BridgeMethod("luckycatOpenFunctionSwitch")
    public final void openFunctionSwitch(@BridgeContext IBridgeContext r100, @BridgeParam("function_name") String r101) {
        if (r100 == null) goto L87;
        Activity r102 = r100.getActivity();
        if (TextUtils.isEmpty(r101) == true) goto L77;
        if (r102 == null) goto L77;
        String r103 = r101.toLowerCase();
        r103.getClass();
        int r104 = r103.hashCode();
        if (r104 == 102570) goto L23;
        if (r104 == 3649301) goto L19;
        if (r104 == 1968882350) goto L15;
    L24:
        byte r105 = -1;
    L27:
        if (r105 == 0) goto L63;
        if (r105 == 1) goto L49;
        if (r105 != 2) goto L77;
        BluetoothAdapter r106 = BluetoothAdapter.getDefaultAdapter();     // Catch: Throwable -> L36
        if (r106 == null) goto L38;
        boolean r107 = r106.isEnabled();     // Catch: Throwable -> L36
    L39:
        if (r107 == false) goto L83;
    L76:
        boolean r108 = true;
    L79:
        if (r108 == false) goto L81;
        r100.callback(hj7.a.a(1, null, "success"));
        return;
    L81:
        r100.callback(hj7.a.a(0, null, "fail"));
        return;
    L83:
    L46:
        th = move-exception;
        th.getLocalizedMessage();
        goto L77
    L42:
        if (BluetoothAdapter.getDefaultAdapter().isEnabled() == true) goto L76;
        r108 = BluetoothAdapter.getDefaultAdapter().enable();     // Catch: Throwable -> L46
    L38:
        r107 = false;
    L36:
        th = move-exception;
        th.getLocalizedMessage();
        goto L38
    L49:
        if (com.bytedance.ug.sdk.luckycat.impl.utils.g.c(r102) == true) goto L76;
        Intent r109 = new Intent("android.settings.WIFI_SETTINGS").setFlags(268435456);
        if (r109 == null) goto L59;
        List<ResolveInfo> r110 = r102.getPackageManager().queryIntentActivities(r109, 65536);
        if (r110 == null) goto L59;
        if (r110.size() <= 0) goto L59;
        boolean r111 = true;
    L60:
        if (r111 == false) goto L77;
        r102.startActivity(r109);
    L59:
        r111 = false;
        goto L60
    L63:
        if (com.bytedance.ug.sdk.luckycat.impl.utils.g.b(r102) == true) goto L76;
        Intent r112 = new Intent("android.settings.LOCATION_SOURCE_SETTINGS").setFlags(268435456);
        if (r112 == null) goto L73;
        List<ResolveInfo> r113 = r102.getPackageManager().queryIntentActivities(r112, 65536);
        if (r113 == null) goto L73;
        if (r113.size() <= 0) goto L73;
        boolean r114 = true;
    L74:
        if (r114 == false) goto L77;
        r102.startActivity(r112);
    L73:
        r114 = false;
        goto L74
    L15:
        if (r103.equals("bluetooth") == false) goto L24;
        r105 = 2;
        goto L27
    L19:
        if (r103.equals("wifi") == false) goto L24;
        r105 = 1;
        goto L27
    L23:
        if (r103.equals(GeocodeSearch.GPS) == false) goto L24;
        r105 = 0;
    L77:
        r108 = false;
        goto L79
    }
}
