package com.bytedance.sdk.open.douyin.settings;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.core.OpenHostSettingService;
import com.bytedance.sdk.open.aweme.core.OpenServiceManager;
import com.bytedance.sdk.open.aweme.init.DouYinSdkContext;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class OpenSettings {
    private static volatile OpenSettings INSTANCE = null;
    private static final String TAG = "OpenSettings";
    private f mCacheModel;
    private Context mContext;
    private e mSettingsDao;
    private c mSettingsUpdater;

    public class a implements c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OpenSettings f269672a;

        public a(OpenSettings r100) {
            this.f269672a = r100;
        }

        @Override // com.bytedance.sdk.open.douyin.settings.c.b
        public void a(f r100) {
            OpenSettings.access$002(this.f269672a, r100);
        }
    }

    private OpenSettings(Context r100) {
        this.mCacheModel = null;
        this.mContext = r100;
        e r101 = new e(r100);
        this.mSettingsDao = r101;
        this.mSettingsUpdater = new c(this.mContext, r101, new a(this));
    }

    public static /* synthetic */ f access$002(OpenSettings r100, f r101) {
        r100.mCacheModel = r101;
        return r101;
    }

    public static OpenSettings get() {
        if (INSTANCE != null) goto L15;
        monitor-enter(OpenSettings.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (INSTANCE != null) goto L9;
        INSTANCE = new OpenSettings(DouYinSdkContext.inst().getContext());     // Catch: Throwable -> L11
    L9:
        monitor-exit(OpenSettings.class);     // Catch: Throwable -> L11
    L15:
        return INSTANCE;
    }

    private f loadSettingsModel() {
        f r100 = this.mCacheModel;
        if (r100 != null) goto L6;
        f r101 = this.mSettingsDao.c();
        this.mCacheModel = r101;
        return r101;
    L6:
        return r100;
    }

    public String getCtxInfo() {
        return loadSettingsModel().a();
    }

    public JSONObject getHostSettings(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        OpenHostSettingService r101 = (OpenHostSettingService) OpenServiceManager.getInst().getService(OpenHostSettingService.class);
        if (r101 != null) goto L9;
        return null;
    L9:
        return r101.getSettingJson(r100);
    }

    public long getLastUpdateTime() {
        return loadSettingsModel().b();
    }

    public JSONObject getSettings() {
        f r100 = loadSettingsModel();
        updateSettings(false, "getSettings");
        return r100.c();
    }

    public JSONObject getSettings(String r100) {
        Object r101 = opt(r100);
        if ((r101 instanceof JSONObject) == true) goto L5;
        return null;
    L5:
        return (JSONObject) r101;
    }

    public JSONObject getSettingsHostFirst(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        JSONObject r101 = getHostSettings(r100);
        if (r101 == null) goto L10;
        return r101;
    L10:
        return getSettings(r100);
    }

    public long getSettingsTime() {
        return loadSettingsModel().d();
    }

    public JSONObject getVidInfo() {
        return loadSettingsModel().e();
    }

    public Object opt(String r100) {
        f r101 = loadSettingsModel();
        com.bytedance.sdk.open.tt.e.a(this.mContext).a(r100, r101.e());
        Object r102 = r101.c().opt(r100);
        updateSettings(false, "opt_" + r100);
        return r102;
    }

    public void updateSettings(boolean r100, String r101) {
        this.mSettingsUpdater.a(null, r100, r101);
    }
}
