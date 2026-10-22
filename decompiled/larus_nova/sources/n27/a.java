package n27;

import com.bytedance.framwork.core.monitor.MonitorUtils;
import com.bytedance.mira.Mira;
import com.bytedance.mira.helper.ProcessHelper;
import com.lynx.tasm.LynxError;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.tencent.connect.common.Constants;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public a() {
    }

    public final void b(String r100, int r101, long r102, long r103, int r104, String r110, List r111) {
        JSONObject r105 = new JSONObject();
        r105.putOpt("timestamp", Long.valueOf(r103));     // Catch: JSONException -> L9
        r105.putOpt("plugin_name", r100);     // Catch: JSONException -> L9
        r105.putOpt("version_code", Integer.valueOf(r101));     // Catch: JSONException -> L9
        r105.putOpt("status", Integer.valueOf(Constants.REQUEST_AVATER));     // Catch: JSONException -> L9
        r105.putOpt("process", ProcessHelper.getCurrentProcessName(Mira.getAppContext()));     // Catch: JSONException -> L9
        r105.putOpt("duration", Long.valueOf(r102));     // Catch: JSONException -> L9
        r105.putOpt("is_hit", Integer.valueOf(r104));     // Catch: JSONException -> L9
        r105.putOpt("main_url", r110);     // Catch: JSONException -> L9
        if (r111 == null) goto L6;
        String r106 = r111.toString();     // Catch: JSONException -> L9
    L7:
        r105.putOpt(MonitorConstants.EXTRA_DOWNLOAD_BACKUP_URL, r106);     // Catch: JSONException -> L9
    L11:
        MonitorUtils.monitorCommonLog("mira_plugin_monitor", r105);
        return;
    L6:
        r106 = null;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public final void a(int r100, String r101, int r102, long r103, int r104, Throwable r105, long r110, int r111, String r112, List<String> r113) {
        JSONObject r106 = new JSONObject();
        r106.putOpt("timestamp", Long.valueOf(r110));     // Catch: JSONException -> L37
        r106.putOpt("plugin_name", r101);     // Catch: JSONException -> L37
        r106.putOpt("version_code", Integer.valueOf(r102));     // Catch: JSONException -> L37
        r106.putOpt("status", Integer.valueOf(r100));     // Catch: JSONException -> L37
        r106.putOpt("process", ProcessHelper.getCurrentProcessName(Mira.getAppContext()));     // Catch: JSONException -> L37
        if (r100 == 11000) goto L8;
        if (r100 == 21000) goto L8;
        if (r100 == 31000) goto L8;
    L12:
        if (r100 < 11000) goto L16;
        if (r100 >= 12999) goto L16;
        r106.putOpt("net_type", Integer.valueOf(r104));     // Catch: JSONException -> L37
    L16:
        if (r100 < 12000) goto L19;
        if (r100 >= 12999) goto L19;
    L27:
        if (r105 != null) goto L29;
        String r107 = "";
    L30:
        r106.putOpt(LynxError.LYNX_THROWABLE, r107);     // Catch: JSONException -> L37
    L31:
        r106.putOpt("is_hit", Integer.valueOf(r111));     // Catch: JSONException -> L37
        r106.putOpt("main_url", r112);     // Catch: JSONException -> L37
        if (r113 == null) goto L34;
        String r108 = r113.toString();     // Catch: JSONException -> L37
    L35:
        r106.putOpt(MonitorConstants.EXTRA_DOWNLOAD_BACKUP_URL, r108);     // Catch: JSONException -> L37
    L39:
        MonitorUtils.monitorCommonLog("mira_plugin_monitor", r106);
        return;
    L34:
        r108 = null;
        goto L35
    L29:
        StringWriter r109 = new StringWriter();     // Catch: JSONException -> L37
        r105.printStackTrace(new PrintWriter(r109));     // Catch: JSONException -> L37
        r107 = r109.toString();     // Catch: JSONException -> L37
    L19:
        if (r100 < 22000) goto L23;
        if (r100 < 22999) goto L27;
    L23:
        if (r100 < 32000) goto L31;
        if (r100 >= 32999) goto L31;
    L8:
        r106.putOpt("duration", Long.valueOf(r103));     // Catch: JSONException -> L37
        if (r100 != 21000) goto L12;
        r106.put("last_report_list_time", d.a().f516748a);     // Catch: JSONException -> L37
    L37:
        e = move-exception;
        e.printStackTrace();
        goto L39
    }
}
