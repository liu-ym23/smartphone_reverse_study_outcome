package com.bytedance.mira.core;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mira.Mira;
import com.bytedance.mira.event.PluginEventManager;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.plugin.PluginManager;

/* JADX INFO: loaded from: classes3.dex */
public class MetaManager {
    private static volatile MetaManager sInstance;
    private android.content.SharedPreferences preferences;

    public static MetaManager getInst() {
        if (sInstance != null) goto L15;
        monitor-enter(MetaManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new MetaManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(MetaManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public boolean isHostAbiUpdate() {
        boolean r100 = !TextUtils.equals(this.preferences.getString("HOST_ABI", ""), Mira.getHostAbi());
        MiraLogger.i(MiraLogger.TAG_INIT, "MetaManager isHostAbiUpdate HOST_ABI=" + this.preferences.getString("HOST_ABI", "") + ", " + Mira.getHostAbi() + ", result=" + r100);
        return r100;
    }

    public boolean isRomUpdate() {
        String r100 = this.preferences.getString("ROM_LAST", "");
        String r101 = Build.VERSION.INCREMENTAL;
        android.content.SharedPreferences.Editor r102 = this.preferences.edit();
        r102.putString("ROM_LAST", r101);
        r102.apply();
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return false;
    L8:
        return !r100.equals(r101);
    }

    public void setHostAbiUpdated() {
        String r100 = this.preferences.getString("HOST_ABI", "");
        android.content.SharedPreferences.Editor r101 = this.preferences.edit();
        r101.putString("HOST_ABI", Mira.getHostAbi());
        r101.apply();
        MiraLogger.i(MiraLogger.TAG_INIT, "MetaManager setHostAbiUpdated HOST_ABI=" + r100 + " --> " + Mira.getHostAbi());
    }

    private MetaManager() {
        this.preferences = Mira.getAppContext().getSharedPreferences("plugin_meta_data", 0);
    }

    public void clearDeletedFlag(String r100) {
        android.content.SharedPreferences.Editor r101 = this.preferences.edit();
        r101.remove("DELETED_" + r100);
        r101.apply();
    }

    public void clearOfflineFlag(String r100) {
        if (PluginManager.getInstance().isInternalPlugin(r100) == true) goto L5;
        return;
    L5:
        android.content.SharedPreferences.Editor r101 = this.preferences.edit();
        r101.remove("OFFLINE_" + PluginManager.getInstance().getHostUpdateVerCode() + "_" + r100);
        r101.remove("OFFLINE_VERSION_" + PluginManager.getInstance().getHostUpdateVerCode() + "_" + r100);
        r101.apply();
        PluginEventManager.getInstance().notifyPluginEvent(42000, r100, -1, System.currentTimeMillis());
    }

    public String getBackupPluginMd5Extend(String r100) {
        return this.preferences.getString("Backup_MD5_" + r100, "");
    }

    public int getDeleteReason(String r100) {
        return this.preferences.getInt("DELETE_REASON_" + r100, PluginEventManager.OtherStatusCode.UPDATE_UNKNOWN);
    }

    public String getInstalledPluginMd5(String r100) {
        return this.preferences.getString("MD5_" + r100, "");
    }

    public String getInstalledPluginSha256(String r100) {
        return this.preferences.getString("SHA256_" + r100, "");
    }

    public int getInternalPluginVersion(String r100) {
        return this.preferences.getInt("INTERNAL_VERSION_" + r100, 0);
    }

    public boolean hasDeletedFlag(String r100) {
        return this.preferences.getBoolean("DELETED_" + r100, false);
    }

    public boolean hasInternalOfflineFlag(String r100) {
        String r101 = "OFFLINE_" + PluginManager.getInstance().getHostUpdateVerCode() + "_" + r100;
        String r102 = "OFFLINE_VERSION_" + PluginManager.getInstance().getHostUpdateVerCode() + "_" + r100;
        boolean r103 = this.preferences.getBoolean(r101, false);
        if (r103 == true) goto L5;
    L7:
        return r103;
    L5:
        if (getInternalPluginVersion(r100) == this.preferences.getInt(r102, 0)) goto L7;
        return false;
    }

    public boolean hasOfflineFlag(String r100) {
        if (PluginManager.getInstance().isInternalPlugin(r100) == true) goto L7;
        return false;
    L7:
        return hasOfflineFlagWithoutVersion(r100);
    }

    public boolean hasOfflineFlagWithoutVersion(String r100) {
        return this.preferences.getBoolean("OFFLINE_" + PluginManager.getInstance().getHostUpdateVerCode() + "_" + r100, false);
    }

    public boolean isHostDowngrade(int r100) {
        if (r100 >= this.preferences.getInt("__UPDATE_VERSION_CODE__", -1)) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isHostUpdate(int r100) {
        if (r100 <= this.preferences.getInt("__UPDATE_VERSION_CODE__", -1)) goto L5;
        return true;
    L5:
        return false;
    }

    public void markDeletedFlag(String r100) {
        android.content.SharedPreferences.Editor r101 = this.preferences.edit();
        r101.putBoolean("DELETED_" + r100, true);
        r101.apply();
    }

    public void markOfflineFlag(String r100) {
        if (PluginManager.getInstance().isInternalPlugin(r100) == true) goto L5;
        return;
    L5:
        android.content.SharedPreferences.Editor r101 = this.preferences.edit();
        r101.putBoolean("OFFLINE_" + PluginManager.getInstance().getHostUpdateVerCode() + "_" + r100, true);
        r101.apply();
    }

    public void setHostUpdated(int r100) {
        android.content.SharedPreferences.Editor r101 = this.preferences.edit();
        r101.putInt("__UPDATE_VERSION_CODE__", r100);
        r101.apply();
    }

    public int getHostCompatibleMaxVersion(String r100, int r101) {
        int r102 = this.preferences.getInt("HOST_MAX_" + r100 + "_" + r101, Integer.MAX_VALUE);
        if (r102 != 0) goto L6;
        return Integer.MAX_VALUE;
    L6:
        return r102;
    }

    public int getHostCompatibleMinVersion(String r100, int r101) {
        return this.preferences.getInt("HOST_MIN_" + r100 + "_" + r101, 0);
    }

    public String getInstalledPluginMd5Extend(String r100, int r101) {
        return this.preferences.getString("MD5_" + r100 + "_" + r101, "");
    }

    public boolean isPluginInstalled(String r100, int r101) {
        return this.preferences.getBoolean(String.format("%s-%d", new Object[]{r100, Integer.valueOf(r101)}), false);
    }

    public void markOfflineFlag(String r100, int r101) {
        if (PluginManager.getInstance().isInternalPlugin(r100) == true) goto L5;
        return;
    L5:
        android.content.SharedPreferences.Editor r102 = this.preferences.edit();
        r102.putBoolean("OFFLINE_" + PluginManager.getInstance().getHostUpdateVerCode() + "_" + r100, true);
        r102.putInt("OFFLINE_VERSION_" + PluginManager.getInstance().getHostUpdateVerCode() + "_" + r100, r101);
        r102.apply();
    }

    public void setBackupPluginMd5(String r100, String r101) {
        android.content.SharedPreferences.Editor r102 = this.preferences.edit();
        r102.putString("Backup_MD5_" + r100, r101);
        r102.apply();
    }

    public void setInstalledPluginMd5(String r100, String r101) {
        android.content.SharedPreferences.Editor r102 = this.preferences.edit();
        r102.putString("MD5_" + r100, r101);
        r102.apply();
    }

    public void setInstalledPluginSha256(String r100, String r101) {
        android.content.SharedPreferences.Editor r102 = this.preferences.edit();
        r102.putString("SHA256_" + r100, r101);
        r102.apply();
    }

    public void setupDeleteReason(String r100, int r101) {
        android.content.SharedPreferences.Editor r102 = this.preferences.edit();
        r102.putInt("DELETE_REASON_" + r100, r101);
        r102.apply();
    }

    public void setupInternalPluginVersion(String r100, int r101) {
        android.content.SharedPreferences.Editor r102 = this.preferences.edit();
        r102.putInt("INTERNAL_VERSION_" + r100, r101);
        r102.apply();
    }

    public void markPluginInstalled(String r100, int r101, boolean r102) {
        android.content.SharedPreferences.Editor r103 = this.preferences.edit();
        String r104 = r100 + "-" + r101;
        if (r102 == false) goto L5;
        r103.putBoolean(r104, true);
    L6:
        r103.apply();
        return;
    L5:
        r103.remove(r104);
        goto L6
    }

    public void setInstalledPluginMd5Extend(String r100, int r101, String r102) {
        android.content.SharedPreferences.Editor r103 = this.preferences.edit();
        String r104 = "MD5_" + r100 + "_" + r101;
        if (TextUtils.isEmpty(r102) == true) goto L5;
        r103.putString(r104, r102);
    L6:
        r103.apply();
        return;
    L5:
        r103.remove(r104);
        goto L6
    }

    public void setHostCompatibleVersion(String r100, int r101, int r102, int r103) {
        android.content.SharedPreferences.Editor r104 = this.preferences.edit();
        r104.putInt("HOST_MIN_" + r100 + "_" + r101, r102);
        r104.putInt("HOST_MAX_" + r100 + "_" + r101, r103);
        r104.apply();
    }
}
