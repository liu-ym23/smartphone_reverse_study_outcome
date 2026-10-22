package ky5;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.gamecenter.base.q;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    public String A;
    public String B;
    public long C;
    public JSONObject D;
    public int E;
    public String F;
    public String G;
    public int H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f506636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f506637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f506638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f506639d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f506640e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f506641f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f506642g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f506643h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f506644i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f506645j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f506646k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f506647l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<String> f506648m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<String> f506649n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List<String> f506650o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public List<String> f506651p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f506652q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f506653r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public JSONObject f506654s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f506655t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f506656u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f506657v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f506658w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f506659x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f506660y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f506661z;

    public a() {
        this.E = 1;
        this.F = "";
        this.G = "";
        this.H = -1;
    }

    public final void a(JSONObject r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        this.f506636a = r110.optString("id");
        this.f506638c = r110.optLong("file_length", 0);
        this.f506639d = r110.optString("source");
        this.f506640e = r110.optString(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE);
        r110.optString(BdpAppEventConstant.PARAMS_GAME_TYPE);
        r110.optString(AppConstants.BUNDLE_MEDIA_ID);
        r110.optString("item_id");
        this.f506641f = r110.optString("pkg_name");
        this.f506642g = r110.optInt("version_code", 0);
        this.f506643h = r110.optString("name");
        this.f506644i = r110.optString("download_url");
        r110.optString("download_url");
        this.B = r110.optString("file_name");
        this.f506661z = r110.optString("mime_type", "application/vnd.android.package-archive");
        r110.optDouble(EventConstants.ExtraJson.PACKAGE_SIZE, AudioStats.AUDIO_AMPLITUDE_NONE);
        this.F = r110.optString("open_url", "");
        JSONObject r100 = q.l().k();
        if (r100.optInt("enable_backup_urls", 0) == 1) goto L68;
    L64:
        b.a(this, r110);     // Catch: Exception -> L30
    L33:
        if (r100.optInt(DownloadSettingKeys.DOWNLOAD_FINISH_CHECK_TTMD5, 0) <= 0) goto L36;
        this.f506637b = r110.optString("ttmd5", null);
    L36:
        if (r100.optInt("enable_notification_jump_url", 0) != 1) goto L38;
        this.f506652q = r110.optString("notification_jump_url", null);
    L38:
        this.f506653r = r110.optString("icon", null);
        if (r110.optInt("event_v3", 1) != 1) goto L41;
        boolean r101 = true;
    L42:
        this.f506660y = r101;
        r110.optString("from_page", null);
        this.f506655t = r110.optString("log_extra", null);
        this.f506656u = r110.optString("event_tag", null);
        JSONObject r102 = r110.optJSONObject("extra");
        if (r102 == null) goto L62;
    L49:
        String r103 = r100.optString(DownloadSettingKeys.SETTING_TAG);
        if (TextUtils.isEmpty(r103) == true) goto L56;
        if (r102 != null) goto L66;
        r102 = new JSONObject();
    L66:
        r102.put(DownloadSettingKeys.SETTING_TAG, r103);     // Catch: JSONException -> L55
    L56:
        this.f506654s = r102;
        int r104 = r110.optInt("support_multiple", 0);
        this.f506659x = r104;
        if (r104 < 1) goto L59;
        boolean r105 = true;
    L60:
        this.f506658w = r105;
        this.f506657v = r110.optInt(AdDownloadModel.JsonKey.NEED_WIFI, 0);
        this.A = r110.optString(AdDownloadModel.JsonKey.START_TOAST);
        this.C = r110.optLong(MonitorConstants.THROTTLE_SPEED);
        this.D = r110.optJSONObject(AdDownloadModel.JsonKey.DOWNLOAD_SETTINGS);
        this.E = r110.optInt("auto_install", 1);
        return;
    L59:
        r105 = false;
        goto L60
    L62:
        String r106 = r110.optString("extra");     // Catch: Exception -> L48
        if (r106 == null) goto L49;
        r102 = new JSONObject(r106);     // Catch: Exception -> L48
        goto L49
    L41:
        r101 = false;
    L30:
        e = move-exception;
        e.printStackTrace();
        goto L33
    L68:
        JSONArray r107 = r110.optJSONArray(AdDownloadModel.JsonKey.BACKUP_URLS);     // Catch: Exception -> L26
        if (r107 == null) goto L64;
        int r108 = r107.length();     // Catch: Exception -> L26
        if (r108 <= 0) goto L64;
        ArrayList r109 = new ArrayList(r108);     // Catch: Exception -> L26
        int r111 = 0;
    L11:
        if (r111 >= r108) goto L16;
        String r112 = r107.optString(r111);     // Catch: Exception -> L26
        if (TextUtils.isEmpty(r112) == true) goto L15;
        r109.add(r112);     // Catch: Exception -> L26
    L15:
        r111 = r111 + 1;     // Catch: Exception -> L26
        goto L11
    L16:
        this.f506648m = r109;     // Catch: Exception -> L26
        int r113 = r100.optInt("backup_url_strategy", -1);     // Catch: Exception -> L26
        if (r113 < 0) goto L64;
        if (r113 >= r109.size()) goto L64;
        String r114 = (String) ListProtector.get(r109, r113);     // Catch: Exception -> L26
        if (TextUtils.isEmpty(r114) == true) goto L64;
        if (TextUtils.isEmpty(this.f506644i) == true) goto L64;
        ListProtector.remove(r109, r113);     // Catch: Exception -> L26
        ListProtector.add(r109, 0, this.f506644i);     // Catch: Exception -> L26
        this.f506644i = r114;     // Catch: Exception -> L26
    L26:
        e = move-exception;
        e.printStackTrace();
        goto L64
    }
}
