package com.ss.android.lark.diskmanage.smalldisk.settings;

import android.os.Environment;
import com.alibaba.fastjson.JSON;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.lark.diskmanage.NonProguard;
import com.ss.android.lark.framework.assembly.diskmange.DiskManageModuleDependencyInitor;
import com.ss.android.lark.log.Log;
import dbb.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public class DiskStrategyConfig implements NonProguard {
    private float cleanThresholdFactor;
    private float diskCacheFactor;
    private long diskThreshold;
    private boolean strategySwitch;
    private float timeoutFactor;

    public String toString() {
        return "DiskStrategyConfig{strategySwitch=" + this.strategySwitch + ", diskThreshold=" + this.diskThreshold + ", cleanThresholdFactor=" + this.cleanThresholdFactor + ", diskCacheFactor=" + this.diskCacheFactor + ", timeoutFactor=" + this.timeoutFactor + '}';
    }

    public DiskStrategyConfig() {
        this.strategySwitch = false;
        this.diskThreshold = 0;
        this.cleanThresholdFactor = 0.7f;
        this.diskCacheFactor = 0.7f;
        this.timeoutFactor = 0.5f;
    }

    public float getCleanThresholdFactor() {
        return this.cleanThresholdFactor;
    }

    public float getDiskCacheFactor() {
        return this.diskCacheFactor;
    }

    public long getDiskThreshold() {
        return this.diskThreshold;
    }

    public boolean getStrategySwitch() {
        return this.strategySwitch;
    }

    public float getTimeoutFactor() {
        return this.timeoutFactor;
    }

    public static DiskStrategyConfig parse(String r110) {
        a.InterfaceC5651a r100 = a.b();
        DiskStrategyConfig r111 = (DiskStrategyConfig) JSON.parseObject(JSONObjectProtectorUtils.getString(new JSONObject(r110), "DiskStrategyConfig"), DiskStrategyConfig.class);     // Catch: Exception -> L11
        if (r111.strategySwitch == true) goto L6;
    L8:
        boolean r101 = false;
    L9:
        ((DiskManageModuleDependencyInitor.a) r100).getClass();     // Catch: Exception -> L11
        eac.a.a().putBoolean("small_disk_on", r101);     // Catch: Exception -> L11
        eac.a.a().putFloat("disk_factor", r111.diskCacheFactor);     // Catch: Exception -> L11
        eac.a.a().putFloat("disk_clean_factor", r111.cleanThresholdFactor);     // Catch: Exception -> L11
        eac.a.a().putFloat("disk_timeout_factor", r111.timeoutFactor);     // Catch: Exception -> L11
        Log.i("DiskStrategyConfig", "inSmallDiskMode =" + r101 + ", diskCacheFactor = " + r111.diskCacheFactor + ", cleanThresholdFactor = " + r111.cleanThresholdFactor + ", timeoutFactor = " + r111.timeoutFactor);     // Catch: Exception -> L11
        return r111;
    L6:
        if (Environment.getDataDirectory().getFreeSpace() >= r111.diskThreshold) goto L8;
        r101 = true;
    L11:
        e = move-exception;
        Log.e("DiskStrategyConfig", "parse fail. ", e);
        if (r100 == null) goto L16;
        eac.a.a().putBoolean("small_disk_on", false);
    L16:
        return new DiskStrategyConfig();
    }

    public void setCleanThresholdFactor(float r100) {
        this.cleanThresholdFactor = r100;
    }

    public void setDiskCacheFactor(float r100) {
        this.diskCacheFactor = r100;
    }

    public void setDiskThreshold(long r100) {
        this.diskThreshold = r100;
    }

    public void setStrategySwitch(boolean r100) {
        this.strategySwitch = r100;
    }

    public void setTimeoutFactor(float r100) {
        this.timeoutFactor = r100;
    }
}
