package com.bytedance.mira.core;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mira.Mira;
import com.bytedance.mira.log.MiraLogger;

/* JADX INFO: loaded from: classes3.dex */
public class KVManager {
    private static final String KEY_HOST_ABI = "HOST_ABI_";
    private static final String KEY_ROM_UPDATE = "ROM_LAST_";
    private static final String KEY_UPDATE_VER = "UPDATE_VERSION_CODE_";
    private static volatile KVManager sInstance;
    private android.content.SharedPreferences mPreferences;

    public static KVManager getInst() {
        if (sInstance != null) goto L15;
        monitor-enter(MetaManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new KVManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(MetaManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private KVManager() {
        this.mPreferences = Mira.getAppContext().getSharedPreferences("plugin_meta_data_kv", 0);
    }

    public String getHostIdentity(String r100) {
        String r101 = this.mPreferences.getString("KEY_HOST_IDENTITY" + r100, "");
        MiraLogger.i(MiraLogger.TAG_INIT, "getHostIdentity pluginPKg = " + r100 + ", hostIdentity = " + r101);
        return r101;
    }

    public boolean hasHostAbiUpdate(String r100) {
        return !TextUtils.isEmpty(this.mPreferences.getString(KEY_HOST_ABI + r100, ""));
    }

    public boolean hasHostUpdateFlag(String r100) {
        if (this.mPreferences.getInt(KEY_UPDATE_VER + r100, -1) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasRomUpdateFlag(String r100) {
        return !TextUtils.isEmpty(this.mPreferences.getString(KEY_ROM_UPDATE + r100, ""));
    }

    public boolean isHostAbiUpdate(String r100) {
        boolean r101 = !TextUtils.equals(this.mPreferences.getString(KEY_HOST_ABI + r100, ""), Mira.getHostAbi());
        StringBuilder r102 = new StringBuilder("MetaManager isHostAbiUpdate HOST_ABI=");
        r102.append(this.mPreferences.getString(KEY_HOST_ABI + r100, ""));
        r102.append(", ");
        r102.append(Mira.getHostAbi());
        r102.append(", result=");
        r102.append(r101);
        MiraLogger.i(MiraLogger.TAG_INIT, r102.toString());
        return r101;
    }

    public boolean isRomUpdate(String r100) {
        String r101 = this.mPreferences.getString(KEY_ROM_UPDATE + r100, "");
        String r102 = Build.VERSION.INCREMENTAL;
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r102) == false) goto L8;
        return false;
    L8:
        return !TextUtils.equals(r101, r102);
    }

    public void setHostAbiUpdated(String r100) {
        String r101 = this.mPreferences.getString(KEY_HOST_ABI + r100, "");
        android.content.SharedPreferences.Editor r102 = this.mPreferences.edit();
        r102.putString(KEY_HOST_ABI + r100, Mira.getHostAbi());
        r102.apply();
        MiraLogger.i(MiraLogger.TAG_INIT, "MetaManager setHostAbiUpdated HOST_ABI=" + r101 + " --> " + Mira.getHostAbi());
    }

    public void setRomUpdate(String r100) {
        android.content.SharedPreferences.Editor r101 = this.mPreferences.edit();
        r101.putString(KEY_ROM_UPDATE + r100, Build.VERSION.INCREMENTAL);
        r101.apply();
    }

    public boolean isHostDowngrade(String r100, int r101) {
        if (r101 >= this.mPreferences.getInt(KEY_UPDATE_VER + r100, -1)) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isHostUpdate(String r100, int r101) {
        if (r101 <= this.mPreferences.getInt(KEY_UPDATE_VER + r100, -1)) goto L5;
        return true;
    L5:
        return false;
    }

    public void setHostIdentity(String r100, String r101) {
        String r102 = getHostIdentity(r100);
        if (TextUtils.equals(r102, r101) == true) goto L5;
        android.content.SharedPreferences.Editor r103 = this.mPreferences.edit();
        r103.putString("KEY_HOST_IDENTITY" + r100, r101);
        r103.apply();
    L5:
        MiraLogger.i(MiraLogger.TAG_INIT, "setHostIdentity(" + r100 + ") " + r102 + " --> " + r101);
    }

    public void setHostUpdated(String r100, int r101) {
        android.content.SharedPreferences.Editor r102 = this.mPreferences.edit();
        r102.putInt(KEY_UPDATE_VER + r100, r101);
        r102.apply();
    }
}
