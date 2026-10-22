package k27;

import com.bytedance.mira.Mira;
import com.bytedance.mira.helper.PluginDirHelper;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.plugin.Plugin;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.ttmd5.TTMd5;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile boolean f501572g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object f501573h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l27.b f501574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f501575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f501576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f501577d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f501578e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f501579f;

    static {
        f501573h = new Object();
    }

    public static boolean b(Plugin r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(PluginDirHelper.getNativeLibraryDir(r100.mPackageName, r100.mVersionCode));     // Catch: Exception -> L16
        if (r101.exists() == true) goto L6;
    L15:
        return true;
    L6:
        if (r101.list() == null) goto L15;
        if (r101.list().length <= 0) goto L15;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100.getInstalledMaxVersionFile());     // Catch: Exception -> L16
        if (r102.exists() == false) goto L21;
        if (new PolarisZipFileWrapper(r102).getEntry(String.format("lib/%s/", new Object[]{Mira.getHostAbi()})) != null) goto L22;
        return true;
    L22:
        return false;
    L21:
        return false;
    L16:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public a(l27.b r100, JSONObject r101) throws JSONException {
        this.f501574a = r100;
        this.f501575b = r101.optString("url");
        this.f501576c = new LinkedList();
        JSONArray r102 = r101.optJSONArray(AdDownloadModel.JsonKey.BACKUP_URLS);
        if (r102 != null) goto L5;
    L10:
        this.f501577d = r101.optString("md5");
        this.f501578e = r101.optString("sha256");
        this.f501579f = r101.optInt("alg");
        return;
    L5:
        if (r102.length() <= 0) goto L10;
        int r103 = 0;
    L8:
        if (r103 >= r102.length()) goto L10;
        List<String> r104 = this.f501576c;
        LinkedList r105 = (LinkedList) r104;
        r105.add(JSONArrayProtectorUtils.getString(r102, r103));
        r103 = r103 + 1;
        goto L8
    }

    public static String a(PolarisFileWrapper r100, String r101) {
        Method r102 = TTMd5.class.getDeclaredMethod("parserTTMd5Args", new Class[]{String.class});     // Catch: Exception -> L9
        r102.setAccessible(true);     // Catch: Exception -> L9
        Object r103 = r102.invoke(null, new Object[]{r101});     // Catch: Exception -> L9
        if (r103 == null) goto L6;
        Field r104 = r103.getClass().getDeclaredField("sampleCount");     // Catch: Exception -> L9
        r104.setAccessible(true);     // Catch: Exception -> L9
        int r105 = ((Integer) r104.get(r103)).intValue();     // Catch: Exception -> L9
        Field r106 = r103.getClass().getDeclaredField("sampleSize");     // Catch: Exception -> L9
        r106.setAccessible(true);     // Catch: Exception -> L9
        long r107 = ((Long) r106.get(r103)).longValue();     // Catch: Exception -> L9
    L7:
        MiraLogger.e("DiffPatchInfo", "sampleCount =" + r105 + " sampleSize =" + r107);     // Catch: Exception -> L9
        return TTMd5.ttmd5(r100, r105, r107);
    L6:
        r105 = -1;
        r107 = -1;
    L9:
        e = move-exception;
        e.printStackTrace();
        MiraLogger.e("DiffPatchInfo", "ERROR: " + e);
        return "";
    }
}
