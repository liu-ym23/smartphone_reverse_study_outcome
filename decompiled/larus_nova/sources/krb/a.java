package krb;

import android.net.Uri;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import com.larksuite.component.card.settings.LynxCardCommonConfig;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.statistics.Statistics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import jrb.e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class a {
    public static JSONArray c(String r100) {
        String r101 = "";
        if (TextUtils.isEmpty(r100) == true) goto L9;
        Uri r102 = UriProtector.parse(r100);
        if (TextUtils.isEmpty(r102.getEncodedPath()) == true) goto L9;
        r101 = r102.getEncodedPath();
    L9:
        if (TextUtils.isEmpty(r101) == true) goto L11;
        String[] r103 = r101.split(HTTP.URL_DEFAULT);
        ArrayList r104 = new ArrayList();
        int r105 = 0;
    L14:
        if (r105 >= r103.length) goto L20;
        String r106 = r103[r105];
        if (TextUtils.isEmpty(r106) == true) goto L18;
        r104.add(e.b(r106));
    L18:
        r105 = r105 + 1;
        goto L14
    L20:
        return new JSONArray(r104);
    L11:
        return new JSONArray();
    }

    public static String d(String r100, LynxCardCommonConfig r110) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return "";
    L5:
        Uri r101 = UriProtector.parse(r100);
        Set<String> r102 = UriProtector.getQueryParameterNames(r101);
        if (CollectionUtils.isEmpty(r102) == false) goto L8;
        return "";
    L8:
        StringBuilder r103 = new StringBuilder();
        Iterator<String> r104 = r102.iterator();
    L9:
        boolean r105 = true;
        if (r104.hasNext() == false) goto L31;
        String r106 = r104.next();
        if (TextUtils.isEmpty(r106) == true) goto L9;
        JSONArray r107 = r110.blackMonitorQueryKey;
        if (r107 == null) goto L24;
        int r108 = 0;
    L17:
        if (r108 >= r107.length()) goto L24;
        if (TextUtils.equals(JSONArrayProtectorUtils.getString(r107, r108), r106) == false) goto L23;
    L25:
        if (r105 == true) goto L9;
        r103.append(e.b(r106));
        r103.append(ContainerUtils.KEY_VALUE_DELIMITER);
        String r109 = UriProtector.getQueryParameter(r101, r106);
        if (TextUtils.isEmpty(r109) == true) goto L29;
        r103.append(e.b(r109));
    L29:
        r103.append("&");
    L23:
        r108 = r108 + 1;
    L21:
        e = move-exception;
        Log.w("CardStatisticsUtil", e);
    L24:
        r105 = false;
        goto L25
    L31:
        if (r103.length() <= 1) goto L34;
        r103.deleteCharAt(r103.length() - 1);
    L34:
        return r103.toString();
    }

    public static void a(String r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        r103.put("click", "message_card");     // Catch: JSONException -> L5
        r103.put("msg_id", r100);     // Catch: JSONException -> L5
        r103.put(PickerReporterConstants.KEY.TARGET, "none");     // Catch: JSONException -> L5
        r103.put("click_element", r102);     // Catch: JSONException -> L5
        r103.put("action_type", r101);     // Catch: JSONException -> L5
    L7:
        Statistics.sendEvent("openplatform_im_message_card_click", r103);
        return;
    L5:
        e = move-exception;
        Log.e("CardStatisticsUtil", "card action click statistics args fail", e);
        goto L7
    }

    public static void b(String r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        r103.put("click", "message_card");     // Catch: Exception -> L28
        r103.put("msg_id", r100);     // Catch: Exception -> L28
        r103.put(PickerReporterConstants.KEY.TARGET, "none");     // Catch: Exception -> L28
        r103.put("click_element", r101);     // Catch: Exception -> L28
        r103.put("action_type", "open_link");     // Catch: Exception -> L28
        String r104 = "";
        if (TextUtils.isEmpty(r102) == true) goto L10;
        Uri r105 = UriProtector.parse(r102);     // Catch: Exception -> L28
        if (TextUtils.isEmpty(r105.getAuthority()) == true) goto L10;
        r104 = r105.getAuthority();     // Catch: Exception -> L28
    L10:
        if (TextUtils.isEmpty(r104) == false) goto L13;
        Log.w("CardStatisticsUtil", "open url host is null");     // Catch: Exception -> L28
        return;
    L13:
        LynxCardCommonConfig r106 = (LynxCardCommonConfig) SettingManager.getInstance().get(LynxCardCommonConfig.class);     // Catch: Exception -> L28
        JSONArray r107 = r106.trackDomains;     // Catch: Exception -> L28
        int r108 = 0;
        boolean r109 = false;
    L15:
        if (r108 >= r107.length()) goto L20;
        if (r104.endsWith(JSONArrayProtectorUtils.getString(r107, r108)) == false) goto L19;
        r109 = true;
    L19:
        r108 = r108 + 1;     // Catch: Exception -> L28
        goto L15
    L20:
        if (r109 == false) goto L30;
        r103.put("url_domain", r104);     // Catch: Exception -> L28
        JSONArray r110 = c(r102);     // Catch: Exception -> L28
        if (r110.length() == 0) goto L24;
        r103.put("url_path", r110);     // Catch: Exception -> L28
    L24:
        String r111 = d(r102, r106);     // Catch: Exception -> L28
        if (TextUtils.isEmpty(r111) == true) goto L30;
        r103.put("url_query", r111);     // Catch: Exception -> L28
    L30:
        Statistics.sendEvent("openplatform_im_message_card_click", r103);
        return;
    L28:
        e = move-exception;
        Log.e("CardStatisticsUtil", "card action click statistics args fail", e);
        goto L30
    }
}
