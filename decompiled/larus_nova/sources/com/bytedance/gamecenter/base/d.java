package com.bytedance.gamecenter.base;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.gamecenter.base.order.OrderDownloadRealTriggerImpl;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.download.DownloadStatusChangeListener2;
import com.ss.android.download.api.download.DownloadStatusChangeListenerForInstall;
import com.ss.android.download.api.download.extend.DownloadCompletedListener;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.downloadlib.DownloadComponentManager;
import com.ss.android.downloadlib.TTDownloader;
import com.ss.android.downloadlib.addownload.model.ModelManager;
import com.ss.android.downloadlib.constants.DownloadTaskKeyConstants;
import com.ss.android.downloadlib.utils.ToolUtils;
import com.ss.android.socialbase.appdownloader.AppDownloader;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements DownloadCompletedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, AdDownloadModel> f244952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Map<Integer, DownloadStatusChangeListener>> f244953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, JSONObject> f244954c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TTDownloader f244955d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f244956e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f244957f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f244958g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f244959h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f244960i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Handler f244961j;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f244962a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f244963b;

        /* JADX INFO: renamed from: com.bytedance.gamecenter.base.d$a$a, reason: collision with other inner class name */
        public class RunnableC3506a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f244964a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ DownloadShortInfo f244965b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f244966c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ a f244967d;

            public final void a() {
                b r100 = this.f244964a;
                DownloadShortInfo r101 = this.f244965b;
                String r102 = this.f244967d.f244962a.getUrl();
                String r103 = this.f244966c;
                boolean r104 = true;
                r100.f244972e = true;
                boolean r105 = r.f245056a;
                Intrinsics.checkNotNullParameter("GAppDownloadController", "tag");
                OrderDownloadRealTriggerImpl.f245016c.getClass();
                if (r103 != null) goto L5;
            L8:
                if (r104 == false) goto L10;
                boolean r106 = false;
            L11:
                if (r106 == false) goto L16;
                Intrinsics.checkNotNullParameter("GAppDownloadController", "tag");
                Intrinsics.checkNotNullParameter("OrderDownloadRealTriggerImpl", "tag");
                if (r103 == null) goto L58;
                OrderDownloadRealTriggerImpl.f245015b.put(r103, Boolean.FALSE);
                return;
            L58:
                return;
            L16:
                if (TextUtils.isEmpty(r102) == false) goto L18;
            L42:
                p r107 = r100.f244970c;
                if (r107 == null) goto L60;
                r107.b(r101);
                r100.onIdle();
                return;
            L60:
                return;
            L18:
                if (r100.f244974g.f244957f == null) goto L42;
                SharedPreferences r108 = com.bytedance.gamecenter.base.order.h.a().getSharedPreferences("sp_download_task_info", 0);
                SharedPreferences r109 = com.bytedance.gamecenter.base.order.h.a().getSharedPreferences("sp_task_info_key_url", 0);
                SharedPreferences r110 = com.bytedance.gamecenter.base.order.h.a().getSharedPreferences("sp_task_group_info", 0);
                SharedPreferences r111 = com.bytedance.gamecenter.base.order.h.a().getSharedPreferences("sp_latest_download_time", 0);
                SharedPreferences r112 = com.bytedance.gamecenter.base.order.h.a().getSharedPreferences("sp_latest_finish_time", 0);
                SharedPreferences r113 = com.bytedance.gamecenter.base.order.h.a().getSharedPreferences("sp_task_use_new_downloader", 0);
                Map<String, ?> r114 = r108.getAll();
                if (r114 == null) goto L42;
                if (r114.isEmpty() == true) goto L42;
                SharedPreferences.Editor r115 = r108.edit();
                SharedPreferences.Editor r116 = r109.edit();
                SharedPreferences.Editor r117 = r110.edit();
                SharedPreferences.Editor r118 = r111.edit();
                SharedPreferences.Editor r119 = r112.edit();
                SharedPreferences.Editor r120 = r113.edit();
                Iterator<Map.Entry<String, ?>> r121 = r114.entrySet().iterator();
            L25:
                if (r121.hasNext() == false) goto L41;
                Map.Entry<String, ?> r122 = r121.next();
                if (r122 == null) goto L25;
                Object r123 = r122.getValue();
                if (r123 == null) goto L25;
                JSONObject r124 = new JSONObject(r123.toString()).optJSONObject(EventConstant.Key.RAW_DATA);     // Catch: JSONException -> L39
                if (TextUtils.equals(r103, r124.optString(DownloadTaskKeyConstants.TaskKeyObjectAttr.TASK_GROUP, "")) == false) goto L25;
                String r125 = r124.optString("download_url", "");     // Catch: JSONException -> L39
                r115.remove(r125);     // Catch: JSONException -> L39
                r115.remove(t.a(r125));     // Catch: JSONException -> L39
                if (r108.getAll() == null) goto L37;
                r108.getAll().size();     // Catch: JSONException -> L39
            L37:
                r116.remove(t.a(r125));     // Catch: JSONException -> L39
                r117.remove(r125);     // Catch: JSONException -> L39
                r120.remove(r125);     // Catch: JSONException -> L39
                String r126 = r125 + "#" + r100.f244971d.optString("biz_type", "");     // Catch: JSONException -> L39
                r118.remove(r126);     // Catch: JSONException -> L39
                r119.remove(r126);     // Catch: JSONException -> L39
            L39:
                e = move-exception;
                e.printStackTrace();
                goto L25
            L41:
                r115.apply();
                r116.apply();
                r117.apply();
                r118.apply();
                r119.apply();
                r120.apply();
                goto L42
            L10:
                r106 = Intrinsics.areEqual(OrderDownloadRealTriggerImpl.f245015b.get(r103), Boolean.TRUE);
                goto L11
            L5:
                if (r103.length() == 0) goto L8;
                r104 = false;
                goto L8
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC3506a(a r100, b r101, DownloadShortInfo r102, String r103) {
                this.f244967d = r100;
                this.f244964a = r101;
                this.f244965b = r102;
                this.f244966c = r103;
            }
        }

        public final void a() {
            String r100 = com.bytedance.gamecenter.base.order.h.a().getSharedPreferences("sp_task_group_info", 0).getString(this.f244962a.getUrl(), "");
            Map<String, Map<Integer, DownloadStatusChangeListener>> r101 = this.f244963b.f244953b;
            ConcurrentHashMap r102 = (ConcurrentHashMap) r101;
            Map r103 = (Map) r102.get(this.f244962a.getUrl());
            DownloadShortInfo r104 = new DownloadShortInfo();
            r104.updateFromNewDownloadInfo(this.f244962a);
            NativeDownloadModel r105 = ModelManager.getInstance().getNativeModelByInfo(this.f244962a);
            if (r105 == null) goto L5;
            r104.updateFromNativeDownloadModel(r105);
        L5:
            if (r103 == null) goto L12;
            Iterator r106 = r103.values().iterator();
        L8:
            if (r106.hasNext() == false) goto L12;
            DownloadStatusChangeListener r107 = (DownloadStatusChangeListener) r106.next();
            if ((r107 instanceof b) == false) goto L8;
            this.f244963b.f244961j.post(new RunnableC3506a(this, (b) r107, r104, r100));
        L12:
            Map<String, Object> r108 = q.l().f245052e;
            if (r108 != null) goto L26;
        L22:
            boolean r109 = false;
        L23:
            if (r109 == false) goto L33;
            d.a(this.f244963b, r100, this.f244962a.getUrl(), false);
            return;
        L33:
            return;
        L26:
            Object r110 = r108.get("live_gamecp_global_cancel_download_open_resubscribe");     // Catch: Exception -> L20
            Objects.toString(r110);     // Catch: Exception -> L20
            boolean r111 = r.f245056a;     // Catch: Exception -> L20
            Intrinsics.checkNotNullParameter("GPreDownloadRes", "tag");     // Catch: Exception -> L20
            if (r110 == null) goto L22;
            r109 = true;
            if (((Integer) r110).intValue() != 1) goto L22;
        L20:
            e = move-exception;
            e.toString();
            boolean r112 = r.f245056a;
            Intrinsics.checkNotNullParameter("GPreDownloadRes", "tag");
            goto L22
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(d r100, DownloadInfo r101) {
            this.f244963b = r100;
            this.f244962a = r101;
        }
    }

    public class b implements DownloadStatusChangeListener2, DownloadStatusChangeListenerForInstall, DownloadStatusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AdDownloadModel f244968a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public DownloadInfo f244969b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final p f244970c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final JSONObject f244971d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f244972e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f244973f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ d f244974g;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ DownloadModel f244975a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f244976b;

            public final void a() {
                if (TextUtils.isEmpty(this.f244975a.getDownloadUrl()) == false) goto L5;
                return;
            L5:
                if (this.f244976b.f244974g.f244957f == null) goto L19;
                SharedPreferences r100 = com.bytedance.gamecenter.base.order.h.a().getSharedPreferences("sp_download_task_info", 0);     // Catch: JSONException -> L15
                JSONObject r101 = new JSONObject();     // Catch: JSONException -> L15
                r101.putOpt(EventConstant.Key.RAW_DATA, this.f244976b.f244971d);     // Catch: JSONException -> L15
                r101.putOpt("time_stamp", Long.valueOf(System.currentTimeMillis()));     // Catch: JSONException -> L15
                r100.edit().putString(t.a(this.f244975a.getDownloadUrl()), r101.toString()).apply();     // Catch: JSONException -> L15
                if (r100.getAll() == null) goto L9;
                r100.getAll().size();     // Catch: JSONException -> L15
            L9:
                com.bytedance.gamecenter.base.order.h.a().getSharedPreferences("sp_task_info_key_url", 0).edit().putString(t.a(this.f244975a.getDownloadUrl()), this.f244975a.getDownloadUrl()).apply();     // Catch: JSONException -> L15
                SharedPreferences r102 = com.bytedance.gamecenter.base.order.h.a().getSharedPreferences("sp_task_group_info", 0);     // Catch: JSONException -> L15
                String r103 = this.f244976b.f244971d.optString(DownloadTaskKeyConstants.TaskKeyObjectAttr.TASK_GROUP, "");     // Catch: JSONException -> L15
                r102.edit().putString(this.f244975a.getDownloadUrl(), r103).apply();     // Catch: JSONException -> L15
                com.bytedance.gamecenter.base.order.h.a().getSharedPreferences("sp_task_use_new_downloader", 0).edit().putInt(this.f244975a.getDownloadUrl(), 0).apply();     // Catch: JSONException -> L15
                this.f244976b.g(this.f244975a.getDownloadUrl());     // Catch: JSONException -> L15
                if (this.f244975a.getDownloadSettings() != null) goto L12;
            L13:
                d.a(this.f244976b.f244974g, r103, this.f244975a.getDownloadUrl(), true);     // Catch: JSONException -> L15
                return;
            L12:
                if (this.f244975a.getDownloadSettings().optInt("download_start_not_resubscribe", 0) == 0) goto L13;
                return;
            L19:
                return;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(b r100, DownloadModel r101) {
                this.f244976b = r100;
                this.f244975a = r101;
            }
        }

        @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
        public final void onIdle() {
            boolean r100 = false;
            if (q.l().k().optInt("version_update", 0) == 0) goto L15;
            int r101 = this.f244968a.getVersionCode();
            if (r101 <= 0) goto L15;
            PackageInfo r102 = this.f244974g.f244957f.getPackageManager().getPackageInfo(this.f244968a.getPackageName(), 0);     // Catch: Exception -> L13
            if (r102 == null) goto L15;
            if (r101 <= r102.versionCode) goto L15;
            r100 = true;
        L13:
            e = move-exception;
            e.printStackTrace();
        L15:
            if (r100 == false) goto L19;
            p r103 = this.f244970c;
            if (r103 == null) goto L25;
            r103.onUpdate();
            return;
        L25:
            return;
        L19:
            p r104 = this.f244970c;
            if (r104 == null) goto L27;
            r104.onIdle();
            return;
        }

        public final boolean f(DownloadShortInfo r100) {
            d r101 = this.f244974g;
            if (r101.f244959h == true) goto L6;
            return true;
        L6:
            if (this.f244969b != null) goto L16;
            if (r100 == null) goto L16;
            int r102 = (int) r100.f408261id;
            if (r102 == 0) goto L16;
            DownloadInfo r103 = Downloader.getInstance(r101.f244957f).getDownloadInfo(r102);
            if (r103 == null) goto L16;
            if (TextUtils.equals(r103.getUrl(), this.f244968a.getDownloadUrl()) == false) goto L16;
            this.f244969b = r103;
            return true;
        L16:
            DownloadInfo r104 = this.f244969b;
            if (r104 != null) goto L19;
            return false;
        L19:
            if (r100 != null) goto L21;
        L23:
            return true;
        L21:
            if (r104.getId() == r100.f408261id) goto L23;
            return false;
        }

        public final void g(String r100) {
            SharedPreferences r101 = com.bytedance.gamecenter.base.order.h.a().getSharedPreferences("sp_latest_download_time", 0);
            r101.edit().putLong(r100 + "#" + this.f244971d.optString("biz_type", ""), System.currentTimeMillis()).apply();
        }

        @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
        public final void onDownloadFailed(DownloadShortInfo r100) {
            Objects.toString(r100);
            if (DownloadStatus.isDownloading(r100.status) == false) goto L5;
            return;
        L5:
            p r101 = this.f244970c;
            if (r101 == null) goto L9;
            r101.onDownloadFailed(r100);
            return;
        }

        @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
        public final void onDownloadFinished(DownloadShortInfo r100) {
            if (f(r100) == true) goto L5;
            return;
        L5:
            SharedPreferences r101 = com.bytedance.gamecenter.base.order.h.a().getSharedPreferences("sp_latest_finish_time", 0);
            r101.edit().putLong(this.f244968a.getDownloadUrl() + "#" + this.f244971d.optString("biz_type", ""), System.currentTimeMillis()).apply();
            p r102 = this.f244970c;
            if (r102 == null) goto L9;
            r102.onDownloadFinished(r100);
            return;
        }

        @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
        public final void onInstalled(DownloadShortInfo r100) {
            p r101 = this.f244970c;
            if (r101 == null) goto L6;
            r101.onInstalled(r100);
            return;
        }

        @Override // com.ss.android.download.api.download.DownloadStatusChangeListener2
        public final void onWaitingDownloadCompleteHandler(DownloadInfo r100) {
            boolean r101 = true;
            if (this.f244974g.f244959h == true) goto L6;
        L22:
            if (r101 == true) goto L25;
            return;
        L25:
            if (this.f244974g.f244958g == false) goto L29;
            p r102 = this.f244970c;
            if (r102 == null) goto L33;
            r102.a(r100);
            return;
        L33:
            return;
        L29:
            p r103 = this.f244970c;
            if (r103 == null) goto L35;
            r103.onWaitingDownloadCompleteHandler(r100);
            return;
        L35:
            return;
        L6:
            if (this.f244969b != null) goto L15;
            if (r100 == null) goto L15;
            int r104 = r100.getId();
            if (r104 == 0) goto L15;
            DownloadInfo r105 = Downloader.getInstance(this.f244974g.f244957f).getDownloadInfo(r104);
            if (r105 == null) goto L15;
            if (TextUtils.equals(r105.getUrl(), this.f244968a.getDownloadUrl()) == false) goto L15;
            this.f244969b = r105;
        L15:
            DownloadInfo r106 = this.f244969b;
            if (r106 != null) goto L18;
        L17:
            r101 = false;
            goto L22
        L18:
            if (r100 == null) goto L22;
            if (r106.getId() == r100.getId()) goto L22;
            goto L22
        }

        @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
        public final void onDownloadActive(DownloadShortInfo r100, int r101) {
            if (f(r100) == true) goto L6;
            return;
        L6:
            if (this.f244973f == false) goto L8;
            g(this.f244968a.getDownloadUrl());
            this.f244973f = false;
        L8:
            p r102 = this.f244970c;
            if (r102 == null) goto L12;
            r102.onDownloadActive(r100, r101);
            return;
        }

        @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
        public final void onDownloadPaused(DownloadShortInfo r100, int r101) {
            if (f(r100) == true) goto L5;
            return;
        L5:
            this.f244973f = true;
            if (this.f244972e == false) goto L8;
            return;
        L8:
            p r102 = this.f244970c;
            if (r102 == null) goto L12;
            r102.onDownloadPaused(r100, r101);
            return;
        }

        @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
        public final void onDownloadStart(DownloadModel r100, DownloadController r101) {
            this.f244972e = false;
            this.f244973f = false;
            DownloadComponentManager.getInstance().submitCPUTask(new a(this, r100));
            p r102 = this.f244970c;
            if (r102 == null) goto L6;
            r102.onDownloadStart(r100, r101);
            return;
        }

        @Override // com.ss.android.download.api.download.DownloadStatusChangeListenerForInstall
        public final void onInstallFailed(DownloadShortInfo r100, int r101) {
            p r102 = this.f244970c;
            if (r102 == null) goto L6;
            r102.onInstallFailed(r100, r101);
            return;
        }

        @Override // com.ss.android.download.api.download.DownloadStatusChangeListenerForInstall
        public final void onJumpInstall(DownloadShortInfo r100, int r101) {
            p r102 = this.f244970c;
            if (r102 == null) goto L6;
            r102.onJumpInstall(r100, r101);
            return;
        }

        public b(d r100, AdDownloadModel r101, p r102, JSONObject r103, boolean r104) {
            this.f244974g = r100;
            this.f244973f = false;
            this.f244968a = r101;
            DownloadInfo r105 = AppDownloader.getInstance().getAppDownloadInfo(r100.f244957f, r101.getDownloadUrl());
            if (r105 == null) goto L5;
            r101.setNeedWifi(r105.isOnlyWifi());
        L5:
            this.f244970c = r102;
            this.f244971d = r103;
            this.f244972e = r104;
        }
    }

    @Override // com.ss.android.download.api.download.extend.DownloadCompletedListener
    public final void onDownloadFailed(DownloadInfo r100, BaseException r101, String r102) {
    }

    @Override // com.ss.android.download.api.download.extend.DownloadCompletedListener
    public final void onDownloadFinished(DownloadInfo r100, String r101) {
    }

    @Override // com.ss.android.download.api.download.extend.DownloadCompletedListener
    public final void onDownloadStart(DownloadModel r100, DownloadController r101, DownloadEventConfig r102) {
    }

    public d(Context r100) {
        Context r101 = r100.getApplicationContext();
        this.f244957f = r101;
        this.f244952a = new HashMap();
        this.f244953b = new ConcurrentHashMap();
        this.f244954c = new HashMap();
        this.f244956e = hashCode();
        boolean r102 = false;
        if (q.l().k().optInt("need_independent_process", 0) != 1) goto L5;
        boolean r103 = true;
    L6:
        this.f244959h = r103;
        if (q.l().k().optInt("patch_apply_show_progress", 0) != 1) goto L9;
        r102 = true;
    L9:
        this.f244958g = r102;
        this.f244955d = TTDownloader.inst(r101);
        this.f244955d.addDownloadCompletedListener(this);
        this.f244960i = true;
        this.f244961j = new Handler(Looper.getMainLooper());
        return;
    L5:
        r103 = false;
        goto L6
    }

    private static Activity getActivity(Context r100) {
    L3:
        if (r100 == null) goto L11;
        if ((r100 instanceof Activity) == true) goto L7;
        if ((r100 instanceof ContextWrapper) == false) goto L11;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L3
    L7:
        return (Activity) r100;
    L11:
        return null;
    }

    @Override // com.ss.android.download.api.download.extend.DownloadCompletedListener
    public final void onCanceled(DownloadInfo r100) {
        Map<String, AdDownloadModel> r101 = this.f244952a;
        HashMap r102 = (HashMap) r101;
        if (r102.containsKey(r100.getUrl()) == true) goto L5;
        return;
    L5:
        DownloadComponentManager.getInstance().submitCPUTask(new a(this, r100));
    }

    public final void c(String r210, o r211) {
        JSONObject r100 = new JSONObject();     // Catch: Throwable -> L38
        SharedPreferences r101 = com.bytedance.gamecenter.base.order.h.a().getSharedPreferences("sp_latest_download_time", 0);     // Catch: Throwable -> L38
        Map<String, ?> r102 = r101.getAll();     // Catch: Throwable -> L38
        if (r102 != null) goto L7;
    L36:
        r100.putOpt("downloadList", new JSONArray());     // Catch: Throwable -> L38
        r100.putOpt("biz_type", r210);     // Catch: Throwable -> L38
        f(r100, r211);     // Catch: Throwable -> L38
        return;
    L7:
        if (r102.isEmpty() == true) goto L36;
        Iterator<String> r103 = r102.keySet().iterator();     // Catch: Throwable -> L38
        String r110 = "";
        long r111 = 0;
    L12:
        if (r103.hasNext() == false) goto L29;
        String r112 = r103.next();     // Catch: Throwable -> L38
        if (TextUtils.isEmpty(r112) == true) goto L12;
        int r104 = r112.lastIndexOf("#");     // Catch: Throwable -> L38
        if (r104 == (-1)) goto L12;
        if (TextUtils.equals(r112.substring(r104 + 1), r210) == false) goto L12;
        long r113 = r101.getLong(r112, 0);     // Catch: Throwable -> L38
        if (r113 == 0) goto L12;
        if (r113 <= r111) goto L12;
        r110 = r112.substring(0, r104);     // Catch: Throwable -> L38
        r111 = r113;
        goto L12
    L29:
        if (TextUtils.isEmpty(r110) == false) goto L32;
        r100.putOpt("downloadList", new JSONArray());     // Catch: Throwable -> L38
        r100.putOpt("biz_type", r210);     // Catch: Throwable -> L38
        f(r100, r211);     // Catch: Throwable -> L38
        return;
    L32:
        SharedPreferences r105 = com.bytedance.gamecenter.base.order.h.a().getSharedPreferences("sp_download_task_info", 0);     // Catch: Throwable -> L38
        String r106 = r105.getString(t.a(r110), "");     // Catch: Throwable -> L38
        if (TextUtils.isEmpty(r106) == false) goto L35;
        r106 = r105.getString(r110, "");     // Catch: Throwable -> L38
    L35:
        JSONObject r107 = new JSONObject(r106).optJSONObject(EventConstant.Key.RAW_DATA);     // Catch: Throwable -> L38
        JSONArray r108 = new JSONArray();     // Catch: Throwable -> L38
        JSONObject r109 = new JSONObject();     // Catch: Throwable -> L38
        r109.putOpt("status", "latest_download");     // Catch: Throwable -> L38
        r109.putOpt("appad", r107);     // Catch: Throwable -> L38
        r108.put(r109);     // Catch: Throwable -> L38
        r100.putOpt("downloadList", r108);     // Catch: Throwable -> L38
        r100.putOpt("biz_type", r210);     // Catch: Throwable -> L38
        f(r100, r211);     // Catch: Throwable -> L38
        return;
    L38:
        th = move-exception;
        th.printStackTrace();
    }

    public final String e(DownloadInfo r100, NativeDownloadModel r101) {
        int r102 = r100.getStatus();
        if (r102 == (-3)) goto L35;
        if (r102 != (-2)) goto L7;
        return "download_paused";
    L7:
        if (r102 != (-1)) goto L9;
        return "download_failed";
    L9:
        if (r102 != 1) goto L11;
        return "download_active";
    L11:
        if (r102 != 2) goto L13;
        return "download_active";
    L13:
        if (r102 != 3) goto L15;
        return "download_active";
    L15:
        if (r102 != 4) goto L17;
        return "download_active";
    L17:
        if (r102 != 5) goto L19;
        return "download_active";
    L19:
        if (r102 != 7) goto L21;
        return "download_active";
    L21:
        if (r102 == 8) goto L51;
        String r103 = "";
        if (r102 != 11) goto L52;
        Map<String, Map<Integer, DownloadStatusChangeListener>> r104 = this.f244953b;
        ConcurrentHashMap r105 = (ConcurrentHashMap) r104;
        Iterator r106 = ((Map) r105.get(r100.getUrl())).values().iterator();
    L27:
        if (r106.hasNext() == false) goto L52;
        if ((((DownloadStatusChangeListener) r106.next()) instanceof DownloadStatusChangeListener2) == true) goto L30;
        r103 = "download_active";
        goto L27
    L30:
        r103 = "waiting_patch_apply";
    L52:
        return r103;
    L51:
        return "download_active";
    L35:
        if (ToolUtils.isInstalledApp(r101) == false) goto L37;
        return "installed";
    L37:
        return "download_finished";
    }

    public final void f(JSONObject r100, o r101) {
        this.f244961j.post(new c(this, r100, r101));
    }

    @Override // com.ss.android.download.api.download.extend.DownloadCompletedListener
    public final void onInstalled(DownloadInfo r100, String r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        JSONObject r102 = q.l().f245049b;
        if (r102 != null) goto L9;
        r102 = new JSONObject();
    L9:
        if (r102.optInt("clear_task_group", 1) != 1) goto L11;
        boolean r103 = true;
    L12:
        Map<String, AdDownloadModel> r104 = this.f244952a;
        HashMap r105 = (HashMap) r104;
        AdDownloadModel r106 = (AdDownloadModel) r105.get(r100.getUrl());
        if (r106 != null) goto L15;
    L19:
        if (r103 == true) goto L36;
        return;
    L36:
        SharedPreferences r107 = com.bytedance.gamecenter.base.order.h.a().getSharedPreferences("sp_download_task_info", 0);     // Catch: Throwable -> L33
        String r108 = r107.getString(t.a(r100.getUrl()), "");     // Catch: Throwable -> L33
        if (TextUtils.isEmpty(r108) == false) goto L25;
        r108 = r107.getString(r100.getUrl(), "");     // Catch: Throwable -> L33
    L25:
        if (TextUtils.isEmpty(r108) == true) goto L31;
        JSONObject r109 = new JSONObject(r108);     // Catch: Throwable -> L33
        JSONObject r110 = r109.optJSONObject(EventConstant.Key.RAW_DATA);     // Catch: Throwable -> L33
        if (TextUtils.isEmpty(r110.optString(DownloadTaskKeyConstants.TaskKeyObjectAttr.TASK_GROUP, "")) == true) goto L31;
        r110.put(DownloadTaskKeyConstants.TaskKeyObjectAttr.TASK_GROUP, "");     // Catch: Throwable -> L33
        r107.edit().putString(t.a(r100.getUrl()), r109.toString()).apply();     // Catch: Throwable -> L33
        if (r107.getAll() == null) goto L31;
        r107.getAll().size();     // Catch: Throwable -> L33
    L31:
        com.bytedance.gamecenter.base.order.h.a().getSharedPreferences("sp_task_group_info", 0).edit().remove(r100.getUrl()).apply();     // Catch: Throwable -> L33
        com.bytedance.gamecenter.base.order.h.a().getSharedPreferences("sp_task_use_new_downloader", 0).edit().remove(r100.getUrl()).apply();     // Catch: Throwable -> L33
        return;
    L33:
        th = move-exception;
        th.printStackTrace();
        return;
    L15:
        if (r106.getDownloadSettings() == null) goto L19;
        if (r106.getDownloadSettings().optInt("download_finish_clear_task_group", 1) != 0) goto L19;
        r103 = false;
        goto L19
    L11:
        r103 = false;
        goto L12
    }

    public static void a(d r100, String r101, String r110, boolean r111) {
        r100.getClass();
        if (TextUtils.isEmpty(r101) == true) goto L31;
        Iterator r102 = ((ConcurrentHashMap) r100.f244953b).keySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L48;
        String r103 = (String) r102.next();
        if (r111 == false) goto L12;
        if (TextUtils.equals(r110, r103) == true) goto L6;
    L12:
        Map r104 = (Map) ((ConcurrentHashMap) r100.f244953b).get(r103);
        if (r104 == null) goto L6;
        Iterator r105 = new ArrayList(r104.values()).iterator();
    L16:
        if (r105.hasNext() == false) goto L6;
        DownloadStatusChangeListener r106 = (DownloadStatusChangeListener) r105.next();
        if ((r106 instanceof b) == false) goto L16;
        b r107 = (b) r106;
        JSONObject r108 = r107.f244971d;
        if (r108 == null) goto L16;
        if (TextUtils.equals(r108.optString(DownloadTaskKeyConstants.TaskKeyObjectAttr.TASK_GROUP, ""), r101) == false) goto L16;
        q r109 = q.l();
        Context r112 = r100.f244957f;
        f r113 = r109.f245053f;
        if (r113 == null) goto L27;
        r113.c(r112, r108);
    L27:
        p r114 = r107.f244970c;
        boolean r115 = r107.f244972e;
        q r116 = q.l();
        Context r117 = r100.f244957f;
        if (r116.f245053f != null) goto L30;
        r116.f245053f = new f(r117);
    L30:
        r116.f245053f.b(r117, r108, r114, r115);
        goto L16
    L48:
        return;
    }

    public static void g(Context r100, ky5.a r101, AdDownloadModel r102, AdDownloadModel r103) {
        int r104 = r101.f506657v;
        if (r104 == (-1)) goto L16;
        if (r104 == 0) goto L13;
        if (r104 != 1) goto L30;
        r102.setNeedWifi(true);
        if (r103 == null) goto L11;
        r103.setNeedWifi(true);
    L11:
        if (DownloadUtils.isWifi(r100) == true) goto L23;
        r102.setIsShowToast(false);
        return;
    L23:
        return;
    L30:
        return;
    L13:
        r102.setNeedWifi(false);
        if (r103 == null) goto L25;
        r103.setNeedWifi(false);
        return;
    L25:
        return;
    L16:
        if (r103 != null) goto L18;
        return;
    L18:
        if (r103.isNeedWifi() == false) goto L28;
        r102.setNeedWifi(true);
        if (DownloadUtils.isWifi(r100) == true) goto L29;
        r102.setIsShowToast(false);
        return;
    L29:
        return;
    }

    public final void d(Context r210, String r211, JSONObject r212, o r213) {
        JSONObject r100 = new JSONObject();     // Catch: Throwable -> L49
        SharedPreferences r101 = com.bytedance.gamecenter.base.order.h.a().getSharedPreferences("sp_latest_finish_time", 0);     // Catch: Throwable -> L49
        SharedPreferences.Editor r102 = r101.edit();     // Catch: Throwable -> L49
        Map<String, ?> r103 = r101.getAll();     // Catch: Throwable -> L49
        if (r103 != null) goto L7;
    L47:
        r100.putOpt("downloadList", new JSONArray());     // Catch: Throwable -> L49
        r100.putOpt("biz_type", r211);     // Catch: Throwable -> L49
        f(r100, r213);     // Catch: Throwable -> L49
        return;
    L7:
        if (r103.isEmpty() == true) goto L47;
        Iterator<String> r104 = r103.keySet().iterator();     // Catch: Throwable -> L49
        String r110 = "";
        String r111 = "";
        long r112 = 0;
    L12:
        if (r104.hasNext() == false) goto L39;
        String r113 = r104.next();     // Catch: Throwable -> L49
        if (TextUtils.isEmpty(r113) == true) goto L25;
        int r114 = r113.lastIndexOf("#");     // Catch: Throwable -> L49
        if (r114 == (-1)) goto L25;
        if (TextUtils.equals(r113.substring(r114 + 1), r211) == false) goto L25;
        String r115 = r113.substring(0, r114);     // Catch: Throwable -> L49
        DownloadInfo r105 = TTDownloader.inst(r210).getDownloadInfo(r115);     // Catch: Throwable -> L49
        if (r105 != null) goto L27;
        r102.remove(r115);     // Catch: Throwable -> L49
        goto L25
    L27:
        Iterator<String> r116 = r104;
        String r214 = r110;
        if (com.bytedance.gamecenter.base.a.a(r210, r212, r105) == false) goto L31;
        r102.remove(r115);     // Catch: Throwable -> L49
    L38:
        r104 = r116;
        r110 = r214;
        goto L12
    L31:
        if (DownloadFileUtils.existsAndNotEmpty(new DownloadFile(r105.getSavePath(), r105.getName())) == true) goto L33;
        r102.remove(r115);     // Catch: Throwable -> L49
        goto L38
    L33:
        long r117 = r101.getLong(r113, 0);     // Catch: Throwable -> L49
        if (r117 == 0) goto L38;
        if (r117 <= r112) goto L38;
        r111 = r115;
        r112 = r117;
    L25:
        r116 = r104;
        r214 = r110;
        goto L38
    L39:
        String r215 = r110;
        r102.apply();     // Catch: Throwable -> L49
        if (TextUtils.isEmpty(r111) == false) goto L43;
        r100.putOpt("downloadList", new JSONArray());     // Catch: Throwable -> L49
        r100.putOpt("biz_type", r211);     // Catch: Throwable -> L49
        f(r100, r213);     // Catch: Throwable -> L49
        return;
    L43:
        SharedPreferences r106 = com.bytedance.gamecenter.base.order.h.a().getSharedPreferences("sp_download_task_info", 0);     // Catch: Throwable -> L49
        String r107 = r106.getString(t.a(r111), r215);     // Catch: Throwable -> L49
        if (TextUtils.isEmpty(r107) == false) goto L46;
        r107 = r106.getString(r111, r215);     // Catch: Throwable -> L49
    L46:
        JSONObject r108 = new JSONObject(r107).optJSONObject(EventConstant.Key.RAW_DATA);     // Catch: Throwable -> L49
        JSONArray r109 = new JSONArray();     // Catch: Throwable -> L49
        JSONObject r118 = new JSONObject();     // Catch: Throwable -> L49
        r118.putOpt("status", "latest_finish");     // Catch: Throwable -> L49
        r118.putOpt("appad", r108);     // Catch: Throwable -> L49
        r109.put(r118);     // Catch: Throwable -> L49
        r100.putOpt("downloadList", r109);     // Catch: Throwable -> L49
        r100.putOpt("biz_type", r211);     // Catch: Throwable -> L49
        f(r100, r213);     // Catch: Throwable -> L49
        return;
    L49:
        th = move-exception;
        th.printStackTrace();
    }

    public final void b(Context r110, ky5.a r111, AdDownloadModel r112, AdDownloadEventConfig r113, AdDownloadController r210, JSONObject r211) {
        if (r110 == null) goto L13;
        Map<String, AdDownloadModel> r100 = this.f244952a;
        HashMap r101 = (HashMap) r100;
        AdDownloadModel r102 = (AdDownloadModel) r101.get(r112.getDownloadUrl());
        if (r102 != null) goto L11;
        Map<String, AdDownloadModel> r103 = this.f244952a;
        HashMap r104 = (HashMap) r103;
        r104.put(r112.getDownloadUrl(), r112);
        if (this.f244960i == false) goto L9;
        b r105 = new b(this, r112, null, r211, false);
    L10:
        this.f244955d.bind(getActivity(r110), this.f244956e, r105, r112);
        goto L11
    L9:
        r105 = new b(this, r112, new s(r211, r112), r211, false);
    L11:
        g(r110, r111, r112, r102);
        this.f244955d.action(r112.getDownloadUrl(), r112.getId(), 2, r113, r210, r112);
        return;
    }

    public final void h(Context r100, ky5.a r101, AdDownloadModel r102, JSONObject r110, p r111, boolean r112) {
        if (r100 == null) goto L23;
        if (r102 == null) goto L24;
        Map<String, AdDownloadModel> r103 = this.f244952a;
        HashMap r104 = (HashMap) r103;
        AdDownloadModel r105 = (AdDownloadModel) r104.get(r102.getDownloadUrl());
        if (r105 != null) goto L8;
        Map<String, AdDownloadModel> r106 = this.f244952a;
        HashMap r107 = (HashMap) r106;
        r107.put(r102.getDownloadUrl(), r102);
    L8:
        g(r100, r101, r102, r105);
        if (this.f244960i == false) goto L11;
        b r108 = new b(this, r102, r111, r110, r112);
    L13:
        if (this.f244958g == false) goto L15;
        q.l().getClass();
    L15:
        int r113 = r110.optInt("token", this.f244956e);
        if (r113 != 0) goto L18;
        r113 = this.f244956e;
    L18:
        this.f244955d.bind(getActivity(r100), r113, r108, r102);
        r102.getDownloadUrl();
        Map<String, Map<Integer, DownloadStatusChangeListener>> r109 = this.f244953b;
        ConcurrentHashMap r114 = (ConcurrentHashMap) r109;
        Map r115 = (Map) r114.get(r102.getDownloadUrl());
        if (r115 != null) goto L21;
        r115 = new ConcurrentHashMap();
    L21:
        r115.put(Integer.valueOf(r113), r108);
        Map<String, Map<Integer, DownloadStatusChangeListener>> r116 = this.f244953b;
        ConcurrentHashMap r117 = (ConcurrentHashMap) r116;
        r117.put(r102.getDownloadUrl(), r115);
        return;
    L11:
        r108 = new b(this, r102, new s(r110, r102), r110, r112);
        goto L13
    L24:
        return;
    }
}
