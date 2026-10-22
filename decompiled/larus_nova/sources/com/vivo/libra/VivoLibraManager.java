package com.vivo.libra;

import android.os.Bundle;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public final class VivoLibraManager {
    private static VivoLibraManager sInstance;
    private ILibraSdk mILibraSdk;
    private boolean mWaitPermission;

    public static VivoLibraManager getInstance() {
        if (sInstance != null) goto L6;
        sInstance = new VivoLibraManager();
    L6:
        return sInstance;
    }

    public int getBatteryLevelUi() {
        if (this.mWaitPermission == false) goto L7;
        return -1;
    L7:
        return this.mILibraSdk.getIntResult("getBatteryLevelUi");
    }

    public int getPowerMode() {
        if (this.mWaitPermission == false) goto L7;
        return -1;
    L7:
        return this.mILibraSdk.getIntRetOne("getPowerMode");
    }

    public int getShellTemp() {
        if (this.mWaitPermission == false) goto L7;
        return -2740;
    L7:
        return this.mILibraSdk.getIntResult("getShellTemp");
    }

    public int getSleepMode() {
        if (this.mWaitPermission == false) goto L7;
        return -1;
    L7:
        return this.mILibraSdk.getIntRetOne("getSleepMode");
    }

    public VivoLibraManager() {
        this.mWaitPermission = true;
    }

    public boolean checkPermission(String r100) {
        if (this.mWaitPermission == true) goto L5;
        return true;
    L5:
        if (this.mILibraSdk != null) goto L7;
        this.mILibraSdk = ILibraSdk.Proxy.asInterfaces();
    L7:
        ILibraSdk r101 = this.mILibraSdk;
        if (r101 != null) goto L11;
        return false;
    L11:
        boolean r102 = r101.checkPermission(r100);
        this.mWaitPermission = !r102;
        return r102;
    }

    public boolean eventSupportCheck(String r100) {
        if (this.mWaitPermission == false) goto L7;
        return false;
    L7:
        return this.mILibraSdk.hasEvent(r100);
    }

    public boolean funSupportCheck(String r100) {
        if (this.mWaitPermission == false) goto L7;
        return false;
    L7:
        return this.mILibraSdk.hasFun(r100);
    }

    public void note(Bundle r100) {
        if (this.mWaitPermission == false) goto L5;
        return;
    L5:
        this.mILibraSdk.note("note", r100);
    }

    public Bundle exec(String r100, Bundle r101) {
        if (this.mWaitPermission == false) goto L7;
        return null;
    L7:
        return this.mILibraSdk.exec(r100, r101);
    }

    public List<String> registerCallBack(List<String> r100, CallBack r101) {
        if (this.mWaitPermission == false) goto L7;
        return null;
    L7:
        return this.mILibraSdk.registerCallBack(r100, r101);
    }

    public int unregisterCallBack(List<String> r100, CallBack r101) {
        if (this.mWaitPermission == false) goto L7;
        return -1;
    L7:
        return this.mILibraSdk.unregisterCallBack(r100, r101);
    }
}
