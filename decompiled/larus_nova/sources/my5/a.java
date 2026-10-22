package my5;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.gamecenter.base.order.g;
import com.bytedance.gamecenter.base.order.h;
import com.bytedance.gamecenter.base.order.preres.GResourceDownloadFinishInfo;
import com.bytedance.gamecenter.base.order.preres.GResourceDownloadInfo;
import com.bytedance.gamecenter.base.p;
import com.bytedance.gamecenter.base.q;
import com.bytedance.gamecenter.base.r;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener2;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.TTDownloader;
import com.ss.android.downloadlib.constants.DownloadSettingKeys;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile a f516375h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AdDownloadEventConfig f516376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f516377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, AdDownloadModel> f516378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, GResourceDownloadFinishInfo> f516379d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Integer, p> f516380e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<Integer, p> f516381f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C6873a f516382g;

    /* JADX INFO: renamed from: my5.a$a, reason: collision with other inner class name */
    public class C6873a implements DownloadStatusChangeListener2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f516383a;

        @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
        public final void onInstalled(DownloadShortInfo r100) {
        }

        @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
        public final void onIdle() {
            boolean r100 = r.f245056a;
            Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
            Iterator r101 = ((ConcurrentHashMap) this.f516383a.f516380e).entrySet().iterator();
        L4:
            if (r101.hasNext() == false) goto L8;
            p r102 = (p) ((Map.Entry) r101.next()).getValue();
            if (r102 == null) goto L4;
            r102.onIdle();
            goto L4
        }

        public C6873a(a r100) {
            this.f516383a = r100;
        }

        @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
        public final void onDownloadFailed(DownloadShortInfo r110) {
            boolean r100 = r.f245056a;
            Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
            Object r101 = null;
            if (r110 != null) goto L6;
            Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
            this.f516383a.j(null, -1);
            return;
        L6:
            JSONObject r102 = r110.extra;
            if (r102 != null) goto L10;
            Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
            this.f516383a.j(r110, -1);
            return;
        L10:
            Objects.toString(r102);
            Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
            String r103 = r110.extra.optString("md5");
            if (this.f516383a.g(r110.extra) != (-1)) goto L36;
            int r104 = g.f245040a;
            boolean r105 = false;
            SharedPreferences r106 = h.a().getSharedPreferences("sp_game_res_download_failed_flag", 0);
            if (r103 != null) goto L15;
        L18:
            boolean r107 = true;
        L19:
            if (r107 == false) goto L39;
        L35:
            if (r105 == false) goto L36;
        L37:
            a r108 = this.f516383a;
            int r109 = r110.failStatus;
            r108.getClass();
            r108.m(r109, a.i(r110));
            this.f516383a.r(r103, -1, r110);
            return;
        L39:
            Iterator<Map.Entry<String, ?>> r111 = r106.getAll().entrySet().iterator();     // Catch: Throwable -> L34
        L23:
            if (r111.hasNext() == false) goto L35;
            Map.Entry<String, ?> r112 = r111.next();     // Catch: Throwable -> L34
            String r113 = r112.getKey();     // Catch: Throwable -> L34
            Object r114 = r112.getValue();     // Catch: Throwable -> L34
            if (Intrinsics.areEqual(r113, r103) == false) goto L23;
            if ((r114 instanceof Boolean) == false) goto L30;
            r101 = r114;
        L30:
            Boolean r115 = (Boolean) r101;     // Catch: Throwable -> L34
            if (r115 == null) goto L35;
            r105 = r115.booleanValue();     // Catch: Throwable -> L34
        L34:
            boolean r116 = r.f245056a;
            Intrinsics.checkNotNullParameter("GameRecordSpUtils", "tag");
            goto L35
        L15:
            if (r103.length() == 0) goto L18;
            r107 = false;
        L36:
            int r117 = c.f516387a;
            c.a("pre_download_failed", r110.extra.toString(), r110.failStatus);
            int r118 = g.f245040a;
            g.c(r110.extra, true);
            goto L37
        }

        @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
        public final void onDownloadFinished(DownloadShortInfo r100) {
            boolean r101 = r.f245056a;
            Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
            if (r100 != null) goto L6;
            Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
            this.f516383a.j(null, -3);
            return;
        L6:
            JSONObject r102 = r100.extra;
            if (r102 != null) goto L10;
            Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
            this.f516383a.j(r100, -3);
            return;
        L10:
            Objects.toString(r102);
            Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
            a.a(this.f516383a, r100);
        }

        @Override // com.ss.android.download.api.download.DownloadStatusChangeListener2
        public final void onWaitingDownloadCompleteHandler(DownloadInfo r100) {
            boolean r101 = r.f245056a;
            Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
            if (r100 != null) goto L6;
            Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
            this.f516383a.j(null, -3);
            return;
        L6:
            r100.toDetailString();
            Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
            a r102 = this.f516383a;     // Catch: Throwable -> L9
            int r103 = r100.getDownloadProcess();     // Catch: Throwable -> L9
            String r104 = r100.getTargetFilePath();     // Catch: Throwable -> L9
            r102.getClass();     // Catch: Throwable -> L9
            DownloadShortInfo r105 = new DownloadShortInfo();     // Catch: Throwable -> L9
            r105.fileName = r104;     // Catch: Throwable -> L9
            r105.realPercent = r103;     // Catch: Throwable -> L9
            r105.failStatus = 0;     // Catch: Throwable -> L9
            JSONObject r106 = new JSONObject();     // Catch: Throwable -> L9
            r106.putOpt(EventConstants.ExtraJson.GAME_NAME, r100.getTitle());     // Catch: Throwable -> L9
            r106.putOpt("file_name", r100.getName());     // Catch: Throwable -> L9
            r105.extra = r106;     // Catch: Throwable -> L9
            a.a(this.f516383a, r105);     // Catch: Throwable -> L9
            return;
        L9:
            Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
        }

        @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
        public final void onDownloadActive(DownloadShortInfo r100, int r101) {
            boolean r102 = r.f245056a;
            Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
            if (r100 != null) goto L6;
            Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
            this.f516383a.j(null, 4);
            return;
        L6:
            JSONObject r103 = r100.extra;
            if (r103 != null) goto L10;
            Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
            this.f516383a.j(r100, 4);
            return;
        L10:
            Objects.toString(r103);
            Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
            this.f516383a.j(r100, 4);
            this.f516383a.r(r100.extra.optString("md5"), 4, r100);
        }

        @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
        public final void onDownloadPaused(DownloadShortInfo r100, int r101) {
            boolean r102 = r.f245056a;
            Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
            if (r100 != null) goto L6;
            Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
            this.f516383a.j(null, -2);
            return;
        L6:
            JSONObject r103 = r100.extra;
            if (r103 != null) goto L10;
            Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
            this.f516383a.j(r100, -2);
            return;
        L10:
            int r104 = this.f516383a.g(r103);
            Objects.toString(r100.extra);
            Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
            if (r104 != (-3)) goto L14;
            Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
            this.f516383a.j(r100, -3);
            return;
        L14:
            this.f516383a.j(r100, -2);
            if (r104 == (-2)) goto L17;
            int r105 = c.f516387a;
            c.a("pre_click_pause", r100.extra.toString(), 0);
        L17:
            this.f516383a.r(r100.extra.optString("md5"), -2, r100);
        }

        @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
        public final void onDownloadStart(DownloadModel r210, DownloadController r211) {
            Objects.toString(r210);
            boolean r100 = r.f245056a;
            Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
            Iterator r101 = ((ConcurrentHashMap) this.f516383a.f516380e).entrySet().iterator();
        L4:
            if (r101.hasNext() == false) goto L8;
            p r102 = (p) ((Map.Entry) r101.next()).getValue();
            if (r102 == null) goto L4;
            r102.onDownloadStart(new AdDownloadModel.Builder().build(), null);
            goto L4
        L8:
            int r103 = c.f516387a;
            c.a("pre_click_start_res", r210.getExtra().toString(), 0);
            JSONObject r104 = r210.getExtra();
            if (r104 == null) goto L17;
            a r105 = this.f516383a;
            String r106 = r104.optString("download_url");
            String r110 = r104.optString("md5");
            long r107 = r104.optLong("size");
            String r108 = r104.optString("pkg");
            String r111 = r104.optString("save_path");
            String r112 = r104.optString("game_id");
            String r113 = r104.optString("user_id");
            int r114 = r104.optInt("type");
            String r115 = r104.optString("package_name");
            String r212 = r104.optString(EventConstants.ExtraJson.GAME_NAME);
            boolean r213 = r104.optBoolean("only_wifi");
            int r214 = r104.optInt("token");
            String r116 = r104.optString(AdDownloadModel.JsonKey.START_TOAST);
            r105.getClass();
            GResourceDownloadFinishInfo r109 = new GResourceDownloadFinishInfo(r114, r111, r112, 0, new GResourceDownloadInfo(r110, Long.valueOf(r107), r108, r106, null, r116), r115, r212, r213, r214, r113);
            ((ConcurrentHashMap) r105.f516379d).put(r110, r109);
            g.d(r110, a.d(r109));
            h.a().getSharedPreferences("sp_game_res_md5", 0).edit().putString(r106, r110).apply();
            h.a().getSharedPreferences("sp_game_res_download", 0).edit().putBoolean("game_" + r112 + "_" + r113, true).apply();
            return;
        }
    }

    public static a h() {
        if (f516375h != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f516375h != null) goto L9;
        f516375h = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f516375h;
    }

    public final void l() {
        if (this.f516376a != null) goto L5;
        this.f516376a = new AdDownloadEventConfig.Builder().setClickButtonTag("game_res").setClickItemTag("game_res").setIsEnableV3Event(true).setIsEnableClickEvent(false).build();
    L5:
        Map<String, ?> r100 = h.a().getSharedPreferences("sp_game_res_download_info", 0).getAll();
        if (r100 != null) goto L8;
    L26:
        boolean r101 = r.f245056a;
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
        return;
    L8:
        if (r100.size() == 0) goto L26;
        Iterator<Map.Entry<String, ?>> r102 = r100.entrySet().iterator();     // Catch: Throwable -> L24
    L11:
        if (r102.hasNext() == false) goto L38;
        JSONObject r103 = new JSONObject(String.valueOf(r102.next().getValue()));     // Catch: Throwable -> L24
        GResourceDownloadFinishInfo r104 = n(r103);     // Catch: Throwable -> L24
        if (r104.getDownloadInfo() == null) goto L11;
        String r105 = r104.getDownloadInfo().getDownloadUrl();     // Catch: Throwable -> L24
        int r106 = r104.getToken();     // Catch: Throwable -> L24
        int r107 = r104.getDownloadStatus();     // Catch: Throwable -> L24
        boolean r108 = r.f245056a;     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");     // Catch: Throwable -> L24
        if (r107 != 4) goto L11;
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");     // Catch: Throwable -> L24
        TTDownloader.inst(h.a()).bind(r106, this.f516382g, c(r103));     // Catch: Throwable -> L24
        TTDownloader r109 = TTDownloader.inst(h.a());     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(r105) == false) goto L21;
        long r110 = 0;
    L22:
        r109.action(r105, r110, 2, this.f516376a, new AdDownloadController.Builder().build());     // Catch: Throwable -> L24
        goto L11
    L21:
        r110 = Math.abs(r105.hashCode());     // Catch: Throwable -> L24
        goto L22
    L38:
        return;
    L24:
        boolean r111 = r.f245056a;
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
    }

    public a() {
        this.f516377b = new Handler(Looper.getMainLooper());
        this.f516378c = new ConcurrentHashMap();
        this.f516379d = new ConcurrentHashMap();
        this.f516380e = new ConcurrentHashMap();
        this.f516381f = new ConcurrentHashMap();
        this.f516382g = new C6873a(this);
    }

    public static AdDownloadModel c(JSONObject r110) {
        Objects.toString(r110);
        boolean r100 = r.f245056a;
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
        r110.optInt("type");
        r110.optString("md5");
        String r101 = r110.optString("pkg");
        String r102 = r110.optString("pkg_name");
        String r103 = r110.optString("save_path");
        String r104 = r110.optString(EventConstants.ExtraJson.GAME_NAME);
        boolean r105 = r110.optBoolean("only_wifi");
        String r106 = r110.optString("download_url");
        String r107 = r110.optString(AdDownloadModel.JsonKey.START_TOAST);
        JSONObject r108 = q.l().h();
        r110.putOpt("product_type", BaseConstants.GAME_INFO_LIVE_UNION);     // Catch: JSONException -> L13
        r108.putOpt(DownloadSettingKeys.CANCEL_PAUSE_OPTIMISE_DISABLE_GAME_LIVE, 1);     // Catch: JSONException -> L13
        r108.putOpt(DownloadSettingKeys.PAUSE_OPTIMISE_SWITCH, 0);     // Catch: JSONException -> L13
        boolean r109 = !TextUtils.isEmpty(r107);
        AdDownloadModel.Builder r111 = new AdDownloadModel.Builder().setIsAd(false).setMd5("").setFilePath(r103);
        if (TextUtils.isEmpty(r106) == false) goto L7;
        long r112 = 0;
    L8:
        AdDownloadModel.Builder r113 = r111.setId(r112).setDownloadUrl(r106).setPackageName(r102).setAppName(r104).setFileName(r101).setVersionCode(90).setMimeType("application/vnd.android.package-archive").setExtra(r110).setDownloadSettings(r108).setModelType(2).setSdkMonitorScene("game_center").setCallScene(8).setAutoInstall(false).setNeedWifi(r105).setIsShowToast(r109).setIsShowNotification(false).setDownloadStartDate(System.currentTimeMillis());
        if (r109 == false) goto L12;
        r113.setStartToast(r107);
    L12:
        return r113.build();
    L7:
        r112 = Math.abs(r106.hashCode());
    L13:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static JSONObject d(GResourceDownloadFinishInfo r100) {
        JSONObject r101 = new JSONObject();
        GResourceDownloadInfo r102 = r100.getDownloadInfo();     // Catch: Throwable -> L7
        if (r102 == null) goto L11;
        r101.put("md5", r102.getMd5());     // Catch: Throwable -> L7
        r101.put("game_id", r100.getGameId());     // Catch: Throwable -> L7
        r101.put("size", r102.getSize());     // Catch: Throwable -> L7
        r101.put("save_path", r100.getPath());     // Catch: Throwable -> L7
        r101.put("pkg", r102.getPkgFileName());     // Catch: Throwable -> L7
        r101.put("download_url", r102.getDownloadUrl());     // Catch: Throwable -> L7
        r101.put("download_status", r100.getDownloadStatus());     // Catch: Throwable -> L7
        r101.put("type", r100.getDownloadFromType());     // Catch: Throwable -> L7
        r101.put("package_name", r100.getGamePackageName());     // Catch: Throwable -> L7
        r101.put(EventConstants.ExtraJson.GAME_NAME, r100.getGameName());     // Catch: Throwable -> L7
        r101.put("only_wifi", r100.getOnlyWifi());     // Catch: Throwable -> L7
        r101.put("token", r100.getToken());     // Catch: Throwable -> L7
        r101.put(AdDownloadModel.JsonKey.START_TOAST, r102.getStartToastMsg());     // Catch: Throwable -> L7
        r101.put("user_id", r100.getUserId());     // Catch: Throwable -> L7
        return r101;
    L11:
        return r101;
    L7:
        th = move-exception;
        if (r.f245056a == false) goto L11;
        Log.getStackTraceString(th);
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
        goto L11
    }

    public static int i(DownloadShortInfo r100) {
        long r101 = r100.totalBytes;     // Catch: Exception -> L7
        if (r101 <= 0) goto L9;
        int r102 = (int) ((r100.realCurrentBytes * 100) / r101);
    L10:
        if (r102 >= 0) goto L13;
        return 0;
    L13:
        return r102;
    L9:
        r102 = 0;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public static GResourceDownloadFinishInfo n(JSONObject r110) {
        long r100 = r110.optLong("size");
        String r101 = r110.optString("md5");
        String r102 = r110.optString("game_id");
        String r111 = r110.optString("save_path");
        String r103 = r110.optString("pkg");
        String r104 = r110.optString("download_url");
        int r112 = r110.optInt("download_status", 0);
        int r113 = r110.optInt("type");
        String r114 = r110.optString("package_name");
        String r115 = r110.optString(EventConstants.ExtraJson.GAME_NAME);
        boolean r116 = r110.optBoolean("only_wifi");
        int r117 = r110.optInt("token");
        String r118 = r110.optString(AdDownloadModel.JsonKey.START_TOAST);
        String r105 = r110.optString("user_id");
        return new GResourceDownloadFinishInfo(r113, r111, r102, r112, new GResourceDownloadInfo(r101, Long.valueOf(r100), r103, r104, null, r118), r114, r115, r116, r117, r105);
    }

    public static boolean o(GResourceDownloadFinishInfo r100) {
        boolean r101 = false;
        if (r100.getDownloadInfo() == null) goto L12;
        String r102 = r100.getDownloadInfo().getDownloadUrl();
        if (TextUtils.isEmpty(r102) == false) goto L8;
        return false;
    L8:
        TTDownloader.inst(h.a()).cancel(r102, true);
        PolarisFileWrapper r103 = new PolarisFileWrapper(r100.getPath() + HTTP.URL_DEFAULT + r100.getDownloadInfo().getPkgFileName());
        if (r103.exists() == false) goto L11;
        r101 = r103.delete();
    L11:
        r103.getAbsolutePath();
        boolean r104 = r.f245056a;
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
    L12:
        return r101;
    }

    public static void p(GResourceDownloadFinishInfo r100) {
        if (r100.getDownloadInfo() != null) goto L5;
        return;
    L5:
        String r101 = r100.getDownloadInfo().getPkgFileName();
        String r102 = r100.getDownloadInfo().getDownloadUrl();
        HashMap r103 = new HashMap();
        if (TextUtils.isEmpty(r102) == true) goto L9;
        r103.put("download_url", r102);
    L9:
        if (TextUtils.isEmpty(r101) == true) goto L11;
        r103.put("file_name", r101);
    L11:
        String r104 = r100.getDownloadInfo().getMd5();
        if (TextUtils.isEmpty(r104) == true) goto L15;
        r103.put("md5", r104);
    L15:
        if (TextUtils.isEmpty(r100.getGameId()) == true) goto L17;
        r103.put("game_id", r100.getGameId());
    L17:
        r103.put("expired_type", "game_delete");
        c.b(r103);
    }

    public final GResourceDownloadFinishInfo e(String r100) {
        boolean r101 = r.f245056a;
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
        if (TextUtils.isEmpty(r100) == false) goto L7;
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
        return null;
    L7:
        if (((ConcurrentHashMap) this.f516379d).size() <= 0) goto L16;
        Iterator r102 = ((ConcurrentHashMap) this.f516379d).keySet().iterator();
    L10:
        if (r102.hasNext() == false) goto L16;
        String r103 = (String) r102.next();
        GResourceDownloadFinishInfo r104 = (GResourceDownloadFinishInfo) ((ConcurrentHashMap) this.f516379d).get(r103);
        if (r103.equals(r100) == false) goto L10;
        if (r104 == null) goto L10;
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
        return r104;
    L16:
        Map<String, ?> r105 = h.a().getSharedPreferences("sp_game_res_download_info", 0).getAll();
        if (r105 != null) goto L19;
    L37:
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
        return null;
    L19:
        if (r105.size() == 0) goto L37;
        Iterator<Map.Entry<String, ?>> r106 = r105.entrySet().iterator();     // Catch: Throwable -> L35
    L23:
        if (r106.hasNext() == false) goto L36;
        GResourceDownloadFinishInfo r107 = n(new JSONObject(String.valueOf(r106.next().getValue())));     // Catch: Throwable -> L35
        String r108 = "";
        if (r107.getDownloadInfo() == null) goto L30;
        if (TextUtils.isEmpty(r107.getDownloadInfo().getMd5()) == true) goto L30;
        r108 = r107.getDownloadInfo().getMd5();     // Catch: Throwable -> L35
    L30:
        if (TextUtils.isEmpty(r108) == true) goto L23;
        ((ConcurrentHashMap) this.f516379d).put(r108, r107);     // Catch: Throwable -> L35
        if (r100.equals(r108) == false) goto L23;
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");     // Catch: Throwable -> L35
        return r107;
    L36:
        return null;
    L35:
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
        goto L36
    }

    public final GResourceDownloadFinishInfo f(String r100) {
        boolean r101 = r.f245056a;
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        Map<String, ?> r102 = h.a().getSharedPreferences("sp_game_res_download_info", 0).getAll();
        if (r102 != null) goto L8;
    L30:
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
        return null;
    L8:
        if (r102.size() == 0) goto L30;
        Iterator<Map.Entry<String, ?>> r103 = r102.entrySet().iterator();     // Catch: Throwable -> L28
    L12:
        if (r103.hasNext() == false) goto L29;
        GResourceDownloadFinishInfo r104 = n(new JSONObject(String.valueOf(r103.next().getValue())));     // Catch: Throwable -> L28
        String r105 = "";
        if (r104.getDownloadInfo() == null) goto L17;
        String r106 = r104.getDownloadInfo().getMd5();     // Catch: Throwable -> L28
    L19:
        if (r104.getDownloadInfo() == null) goto L22;
        r105 = r104.getDownloadInfo().getPkgFileName();     // Catch: Throwable -> L28
    L22:
        if (TextUtils.isEmpty(r106) == true) goto L25;
        ((ConcurrentHashMap) this.f516379d).put(r106, r104);     // Catch: Throwable -> L28
    L25:
        if (r100.equals(r105) == false) goto L12;
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");     // Catch: Throwable -> L28
        return r104;
    L17:
        r106 = "";
    L29:
        return null;
    L28:
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
        goto L29
    }

    public final int g(JSONObject r100) {
        int r101 = 0;
        if (r100 != null) goto L6;
        boolean r102 = r.f245056a;
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
        return 0;
    L6:
        GResourceDownloadFinishInfo r103 = e(r100.optString("md5"));
        if (r103 == null) goto L9;
        r101 = r103.getDownloadStatus();
    L9:
        boolean r104 = r.f245056a;
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
        return r101;
    }

    public static void a(a r100, DownloadShortInfo r101) {
        r100.getClass();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.extra != null) goto L31;
        return;
    L31:
        r100.j(r101, -3);     // Catch: Throwable -> L29
        String r102 = r101.extra.optString("md5");     // Catch: Throwable -> L29
        if (TextUtils.isEmpty(r102) == false) goto L16;
        GResourceDownloadFinishInfo r103 = r100.f(r101.extra.optString("file_name"));     // Catch: Throwable -> L29
        if (r103 != null) goto L13;
    L15:
        int r104 = 0;
    L17:
        if (r104 == (-3)) goto L27;
        JSONObject r105 = r101.extra;     // Catch: Throwable -> L29
        if (r105 == null) goto L21;
        String r106 = r105.optString(EventConstants.ExtraJson.GAME_NAME);     // Catch: Throwable -> L29
    L23:
        if (Looper.getMainLooper() == Looper.myLooper()) goto L25;
        r100.f516377b.post(new b(r100, r106));     // Catch: Throwable -> L29
    L26:
        int r107 = c.f516387a;     // Catch: Throwable -> L29
        c.a("pre_download_finish", r101.extra.toString(), 0);     // Catch: Throwable -> L29
        goto L27
    L25:
        q(r106, -3);     // Catch: Throwable -> L29
        goto L26
    L21:
        r106 = "";
    L27:
        r100.r(r102, -3, r101);     // Catch: Throwable -> L29
        int r108 = g.f245040a;     // Catch: Throwable -> L29
        g.b(r101.extra, true);     // Catch: Throwable -> L29
        return;
    L13:
        if (r103.getDownloadInfo() == null) goto L15;
        r102 = r103.getDownloadInfo().getMd5();     // Catch: Throwable -> L29
        r101.extra = d(r103);     // Catch: Throwable -> L29
        r104 = r103.getDownloadStatus();     // Catch: Throwable -> L29
        goto L17
    L16:
        r104 = r100.g(r101.extra);     // Catch: Throwable -> L29
    L29:
        boolean r109 = r.f245056a;
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
    }

    public static boolean k(List r100, String r101) {
        ArrayList r102 = (ArrayList) r100;
        if (r102.size() != 0) goto L5;
    L15:
        boolean r103 = r.f245056a;
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L15;
        Iterator r104 = r102.iterator();
    L9:
        if (r104.hasNext() == false) goto L14;
        if (new PolarisFileWrapper(((String) r104.next()) + r101).exists() == false) goto L9;
        boolean r105 = r.f245056a;
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
        return true;
    L14:
        return false;
    }

    public static void q(String r100, int r101) {
        if (r101 == (-3)) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L7;
        r100 = "《" + r100 + "》";
    L7:
        Toast.makeText(h.a(), r100 + "资源已下载完成，上线后更快畅玩", 1).show();
    }

    public final void j(DownloadShortInfo r100, int r101) {
        Iterator r102 = ((ConcurrentHashMap) this.f516380e).entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L20;
        p r103 = (p) ((Map.Entry) r102.next()).getValue();
        if (r103 == null) goto L4;
        if (r101 != (-3)) goto L10;
        r103.onDownloadFinished(r100);
        goto L4
    L10:
        if (r101 != (-2)) goto L12;
        r103.onDownloadPaused(r100, i(r100));
        goto L4
    L12:
        if (r101 != (-1)) goto L14;
        r103.onDownloadFailed(r100);
        goto L4
    L14:
        if (r101 != 4) goto L4;
        r103.onDownloadActive(r100, i(r100));
        goto L4
    }

    public final void m(int r100, int r101) {
        DownloadShortInfo r102 = new DownloadShortInfo();
        r102.fileName = "";
        r102.realPercent = r101;
        r102.failStatus = r100;
        j(r102, -1);
        Iterator r103 = ((ConcurrentHashMap) this.f516381f).entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        p r104 = (p) ((Map.Entry) r103.next()).getValue();
        if (r104 == null) goto L4;
        r104.onDownloadFailed(r102);
        goto L4
    }

    public final boolean b(JSONObject r110, p r111, int r210) {
        int r100 = r110.optInt("token");
        String r101 = r110.optString("md5");
        String r102 = r110.optString("game_id");
        String r103 = r110.optString("user_id");
        String r104 = r110.optString("pkg");
        String r112 = r110.optString("download_url");
        ArrayList r113 = new ArrayList();
        JSONArray r114 = r110.optJSONArray("other_path");
        boolean r115 = false;
        int r116 = 0;
    L4:
        if (r116 >= r114.length()) goto L10;
        r113.add(JSONArrayProtectorUtils.getString(r114, r116));     // Catch: Exception -> L7
    L9:
        r116 = r116 + 1;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    L10:
        int r105 = g.f245040a;
        Iterator<Map.Entry<String, ?>> r106 = h.a().getSharedPreferences("sp_game_res_md5", 0).getAll().entrySet().iterator();
    L11:
        int r117 = 1;
        if (r106.hasNext() == false) goto L18;
        Map.Entry<String, ?> r118 = r106.next();
        String r119 = r118.getKey();
        Object r120 = r118.getValue();
        if (Intrinsics.areEqual(r119, r112) == false) goto L11;
        if ((!Intrinsics.areEqual(r120, r101)) == false) goto L11;
        boolean r107 = true;
    L19:
        if (r107 == true) goto L104;
        int r108 = g.f245040a;
        String r109 = "game_" + r102 + "_" + r103;
        SharedPreferences r121 = h.a().getSharedPreferences("sp_game_res_download", 0);
        List r122 = g.a(r109);
        int r123 = 2;
        if (r122 == null) goto L62;
        String r124 = (String) ListProtector.get(r122, 1);
        String r125 = (String) ListProtector.get(r122, 2);
        Iterator<Map.Entry<String, ?>> r126 = r121.getAll().entrySet().iterator();
    L25:
        if (r126.hasNext() == false) goto L60;
        String r127 = r126.next().getKey();
        if (r127 != null) goto L29;
    L32:
        boolean r128 = true;
    L33:
        if (r128 == true) goto L59;
        if ((!Intrinsics.areEqual(r127, r109)) == false) goto L59;
        List r129 = g.a(r127);
        if (r129 == null) goto L59;
        String r130 = (String) ListProtector.get(r129, r117);
        String r131 = (String) ListProtector.get(r129, r123);
        boolean r132 = r.f245056a;
        Intrinsics.checkNotNullParameter("GameRecordSpUtils", "tag");
        if (r125 != null) goto L42;
    L45:
        boolean r133 = true;
    L46:
        if (r133 == true) goto L59;
        if (r131 != null) goto L49;
    L52:
        boolean r134 = true;
    L53:
        if (r134 == true) goto L59;
        if ((!Intrinsics.areEqual(r125, r131)) == false) goto L59;
        if (Intrinsics.areEqual(r124, r130) == false) goto L59;
        r115 = true;
        goto L62
    L49:
        if (r131.length() == 0) goto L52;
        r134 = false;
        goto L53
    L42:
        if (r125.length() == 0) goto L45;
        r133 = false;
    L59:
        r123 = 2;
        r117 = 1;
        goto L25
    L29:
        if (r127.length() == 0) goto L32;
        r128 = false;
        goto L33
    L60:
        r115 = false;
    L62:
        if (r115 == false) goto L96;
        if (TextUtils.isEmpty(r112) == false) goto L66;
        boolean r135 = r.f245056a;
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
    L86:
        boolean r136 = false;
    L87:
        if (r136 == false) goto L96;
        if (r111 == null) goto L90;
        ((ConcurrentHashMap) this.f516381f).put(Integer.valueOf(r100), r111);
    L90:
        boolean r137 = r.f245056a;
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
        if (r210 != 2) goto L93;
        m(1, 0);
        int r138 = c.f516387a;
        c.a("pre_fail_start", r110.toString(), 1);
        return false;
    L93:
        return false;
    L66:
        Map<String, ?> r139 = h.a().getSharedPreferences("sp_game_res_download_info", 0).getAll();
        if (r139 != null) goto L69;
    L85:
        boolean r140 = r.f245056a;
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
        goto L86
    L69:
        if (r139.size() == 0) goto L85;
        Iterator<Map.Entry<String, ?>> r141 = r139.entrySet().iterator();     // Catch: Throwable -> L84
    L73:
        if (r141.hasNext() == false) goto L86;
        GResourceDownloadFinishInfo r142 = n(new JSONObject(String.valueOf(r141.next().getValue())));     // Catch: Throwable -> L84
        if (r142.getDownloadInfo() == null) goto L73;
        String r143 = r142.getPath();     // Catch: Throwable -> L84
        String r144 = r142.getDownloadInfo().getDownloadUrl();     // Catch: Throwable -> L84
        String r145 = r142.getDownloadInfo().getPkgFileName();     // Catch: Throwable -> L84
        int r146 = r142.getDownloadStatus();     // Catch: Throwable -> L84
        if (r112.equals(r144) == false) goto L73;
        ArrayList r147 = new ArrayList();     // Catch: Throwable -> L84
        r147.add(r143);     // Catch: Throwable -> L84
        if (r146 != (-3)) goto L83;
        if (k(r147, r145) == false) goto L86;
    L83:
        r136 = true;
    L84:
        boolean r148 = r.f245056a;
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
    L96:
        if (k(r113, r104) == false) goto L137;
        if (r111 == null) goto L100;
        ((ConcurrentHashMap) this.f516381f).put(Integer.valueOf(r100), r111);
    L100:
        if (r210 != 2) goto L102;
        m(2, 0);
        int r149 = c.f516387a;
        c.a("pre_fail_start", r110.toString(), 2);
        return false;
    L102:
        return false;
    L137:
        return true;
    L104:
        return true;
    L18:
        r107 = false;
        goto L19
    }

    public final void r(String r100, int r101, DownloadShortInfo r110) {
        boolean r102 = r.f245056a;
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        if (((ConcurrentHashMap) this.f516379d).size() != 0) goto L28;
        Map<String, ?> r103 = h.a().getSharedPreferences("sp_game_res_download_info", 0).getAll();
        if (r103 != null) goto L10;
    L26:
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
        return;
    L10:
        if (r103.size() == 0) goto L26;
        Iterator<Map.Entry<String, ?>> r104 = r103.entrySet().iterator();     // Catch: Throwable -> L22
    L13:
        if (r104.hasNext() == false) goto L28;
        GResourceDownloadFinishInfo r105 = n(new JSONObject(String.valueOf(r104.next().getValue())));     // Catch: Throwable -> L22
        String r106 = "";
        if (r105.getDownloadInfo() == null) goto L19;
        r106 = r105.getDownloadInfo().getMd5();     // Catch: Throwable -> L22
    L19:
        if (TextUtils.isEmpty(r106) == true) goto L13;
        ((ConcurrentHashMap) this.f516379d).put(r106, r105);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        if (r.f245056a == false) goto L28;
        Log.getStackTraceString(th);
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
    L28:
        Iterator r107 = ((ConcurrentHashMap) this.f516379d).keySet().iterator();
    L30:
        if (r107.hasNext() == false) goto L48;
        String r108 = (String) r107.next();
        GResourceDownloadFinishInfo r109 = (GResourceDownloadFinishInfo) ((ConcurrentHashMap) this.f516379d).get(r108);
        if (r108.equals(r100) == false) goto L30;
        if (r109 == null) goto L30;
        if (r101 == r109.getDownloadStatus()) goto L30;
        int r111 = r109.getDownloadStatus();
        if (r110 == null) goto L46;
        JSONObject r112 = r110.extra;
        if (r112 == null) goto L46;
        if (r111 == (-2)) goto L44;
    L47:
        r109.setDownloadStatus(r101);
        ((ConcurrentHashMap) this.f516379d).put(r100, r109);
        g.d(r100, d(r109));
        goto L30
    L44:
        if (r101 != 4) goto L47;
        int r113 = c.f516387a;
        c.a("pre_click_continue", r112.toString(), r110.failStatus);
    L46:
        boolean r114 = r.f245056a;
        Intrinsics.checkNotNullParameter("GFileDownloader", "tag");
        goto L47
    }
}
