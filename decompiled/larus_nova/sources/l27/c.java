package l27;

import android.text.TextUtils;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.mira.core.MetaManager;
import com.bytedance.mira.helper.PluginDirHelper;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.plugin.Plugin;
import com.bytedance.mira.plugin.PluginManager;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import k27.g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class c {
    public static JSONArray c() {
        List<Plugin> r100 = PluginManager.getInstance().listPlugins();
        g.a().getClass();
        HashMap r101 = new HashMap();
        ArrayList r102 = new ArrayList();
        File[] r103 = new PolarisFileWrapper(p27.b.b()).listFiles();
        if (r103 == null) goto L9;
        int r104 = r103.length;
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L9;
        r102.add(new g.b(r103[r105].getName()));
        r105 = r105 + 1;
    L9:
        if (r102.isEmpty() == true) goto L15;
        Iterator r106 = r102.iterator();
    L13:
        if (r106.hasNext() == false) goto L15;
        g.b r107 = (g.b) r106.next();
        r101.put(r107.f501617a, r107);
    L15:
        if (r100 != null) goto L17;
        return null;
    L17:
        if (r100.isEmpty() == true) goto L39;
        JSONArray r108 = new JSONArray();
        Iterator<Plugin> r109 = r100.iterator();
    L20:
        if (r109.hasNext() == false) goto L27;
        Plugin r110 = r109.next();
        if (r110 == null) goto L20;
        r108.put(b(r110, (g.b) r101.get(r110.mPackageName)));     // Catch: JSONException -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
        goto L20
    L27:
        return r108;
    L39:
        return null;
    }

    public static String a(JSONArray r100) throws JSONException {
        JSONObject r101 = new JSONObject();
        if (r100 != null) goto L5;
        r100 = new JSONArray();
    L5:
        r101.put(CloudControlInf.PLUGIN, r100);
        r101.put("auto_request", true);
        return r101.toString();
    }

    public static String e(String r100) {
        URI r101 = new URI(r100);     // Catch: URISyntaxException -> L5
        return new URI(r101.getScheme(), r101.getUserInfo(), null, r101.getPort(), r101.getPath(), r101.getQuery(), r101.getFragment()).toString();
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String f(String r110) {
        String r100 = MetaManager.getInst().getBackupPluginMd5Extend(r110);
        if (TextUtils.isEmpty(r100) == true) goto L8;
        String r101 = PluginDirHelper.getBackupFile(r110);
        if (new PolarisFileWrapper(r101).exists() == true) goto L9;
        MetaManager.getInst().setBackupPluginMd5(r110, "");
        String r102 = String.format("check backup dir, but there is no file!!! name = %s , path = %s", new Object[]{r110, r101});
        MiraLogger.e("DiffPatchInfo", r102);
        RuntimeException r103 = new RuntimeException(r102);
        n27.d.a().getClass();
        n27.d.f516747c.a(12221, r110, -1, -1, -1, r103, System.currentTimeMillis(), -1, null, null);
        return "";
    L9:
        return r100;
    L8:
        return r100;
    }

    public static JSONObject b(Plugin r100, g.b r101) throws JSONException {
        int r102 = r100.getInstalledMaxVersion();     // Catch: Exception -> L19
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L19
        String r104 = r100.mPackageName;     // Catch: Exception -> L19
        r103.putOpt("packagename", r104);     // Catch: Exception -> L19
        r103.putOpt("versioncode", Integer.valueOf(r102));     // Catch: Exception -> L19
        r103.putOpt("maxversion", Integer.valueOf(r100.mMaxVersionCode));     // Catch: Exception -> L19
        r103.putOpt("minversion", Integer.valueOf(r100.mMinVersionCode));     // Catch: Exception -> L19
        if (r102 < 0) goto L9;
        String r105 = MetaManager.getInst().getInstalledPluginMd5Extend(r104, r102);     // Catch: Exception -> L19
        MiraLogger.e("PluginDownloadInfoHelper", "getInstalledPluginMd5Extend,md5=" + r105);     // Catch: Exception -> L19
        if (TextUtils.isEmpty(r105) == false) goto L11;
        r105 = r100.getInstalledMaxVersionMd5();     // Catch: Exception -> L19
        MiraLogger.e("PluginDownloadInfoHelper", "getInstalledMaxVersionMd5,md5=" + r105);     // Catch: Exception -> L19
    L11:
        if (TextUtils.isEmpty(r105) == true) goto L13;
        r105 = r105.toLowerCase();     // Catch: Exception -> L19
    L13:
        r103.putOpt("md5", r105);     // Catch: Exception -> L19
        h27.a.f483619b.c();     // Catch: Exception -> L19
        r103.putOpt("alg", 2);     // Catch: Exception -> L19
        if (r101 == null) goto L17;
        r103.put("pre_download_versioncode", r101.f501618b);     // Catch: Exception -> L19
    L18:
        return r103;
    L17:
        r103.put("pre_download_versioncode", -1);     // Catch: Exception -> L19
        goto L18
    L9:
        String r106 = f(r104);     // Catch: Exception -> L19
        MiraLogger.e("PluginDownloadInfoHelper", "getBackupPluginMd5Extend,md5=" + r106);     // Catch: Exception -> L19
        r105 = r106;
    L19:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static b d(JSONObject r100, boolean r101) throws JSONException {
        b r102 = new b();
        r102.f507128a = r100.optString("packagename");
        r102.f507129b = r100.optInt("versioncode");
        r102.f507130c = r100.optString("url");
        r102.f507132e = r100.optString("md5");
        r102.f507133f = r100.optString("sha256");
        r102.f507134g = r100.optInt("Order");
        r102.f507135h = r100.optBoolean(OperationName.OPERATION_OFFLINE_AVAILABLE);
        r102.f507136i = r100.optBoolean("revert");
        boolean r103 = true;
        r102.f507137j = r100.optBoolean("wifionly", true);
        int r104 = 0;
        if (r101 == true) goto L5;
        r102.f507138k = r100.optInt("clientversion_min", 0);
        r102.f507139l = r100.optInt("clientversion_max", Integer.MAX_VALUE);
    L6:
        if (r101 == true) goto L8;
        int r105 = r100.optInt("download_type", 0);
    L10:
        if (r105 != 2) goto L12;
        r105 = 1;
    L12:
        r102.f507140m = r105;
        if (r102.f507139l != 0) goto L15;
        r102.f507139l = Integer.MAX_VALUE;
    L15:
        r102.f507131d = new ArrayList();
        JSONArray r106 = r100.optJSONArray(AdDownloadModel.JsonKey.BACKUP_URLS);
        if (r106 == null) goto L24;
        if (r106.length() <= 0) goto L24;
        int r107 = 0;
    L21:
        if (r107 >= r106.length()) goto L24;
        List<String> r108 = r102.f507131d;
        ArrayList r109 = (ArrayList) r108;
        r109.add(JSONArrayProtectorUtils.getString(r106, r107));
        r107 = r107 + 1;
    L24:
        if (r100.has("diff_package_info") == false) goto L26;
        r102.f507141n = new k27.a(r102, JSONObjectProtectorUtils.getJSONObject(r100, "diff_package_info"));
    L26:
        r102.f507143p = r100.optInt("is_hit_libra", 0);
        h27.a.f483619b.getClass();
        h27.a.f483619b.getClass();
        if (r102.f507143p == 1) goto L29;
    L31:
        boolean r110 = false;
    L33:
        if (r102.f507143p == 2) goto L35;
    L37:
        r103 = false;
    L38:
        if (r110 == true) goto L41;
        if (r103 == true) goto L41;
    L50:
        h27.a.f483619b.e(r102);
        return r102;
    L41:
        String r111 = e(r102.f507130c);
        if (r111 == null) goto L45;
        r102.f507130c = r111;
    L45:
        if (r104 >= ((ArrayList) r102.f507131d).size()) goto L50;
        String r112 = e((String) ListProtector.get(r102.f507131d, r104));
        if (r112 == null) goto L49;
        ListProtector.set(r102.f507131d, r104, r112);
    L49:
        r104 = r104 + 1;
        goto L45
    L35:
        if (TextUtils.isEmpty(null) == true) goto L37;
    L29:
        if (TextUtils.isEmpty(null) == true) goto L31;
        r110 = true;
        goto L33
    L8:
        r105 = 3;
        goto L10
    L5:
        r102.f507138k = r100.optInt("pre_download_clientversion_min", 0);
        r102.f507139l = r100.optInt("pre_download_clientversion_max", Integer.MAX_VALUE);
        goto L6
    }
}
