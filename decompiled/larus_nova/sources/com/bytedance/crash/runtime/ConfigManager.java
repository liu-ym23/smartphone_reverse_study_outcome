package com.bytedance.crash.runtime;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.crash.monitor.a;
import com.bytedance.crash.monitor.j;
import com.bytedance.crash.p;
import com.bytedance.crash.util.b;
import fh4.d;
import zg4.g;
import zg4.i;

/* JADX INFO: loaded from: classes.dex */
public class ConfigManager {
    private boolean mEnsureEnable;

    public String getAlogUploadUrl() {
        return g.f572072l.f572081i;
    }

    public String getNativeCrashUploadUrl() {
        return g.f572072l.f572080h;
    }

    public boolean isEnsureEnable() {
        if (i.f572090f == true) goto L5;
        return false;
    L5:
        a r100 = j.f203315a;
        if (r100 == null) goto L16;
        d r101 = r100.e().f477017a;
        if (r101 != null) goto L11;
        return false;
    L11:
        if (r101.f477009d == false) goto L13;
    L14:
        return true;
    L13:
        if (r101.f477007b == true) goto L14;
        return false;
    L16:
        return false;
    }

    public ConfigManager() {
        this.mEnsureEnable = true;
    }

    public long getDefaultAnrCheckInterval() {
        return i.f572086b;
    }

    public boolean isDebugMode() {
        return i.f572087c;
    }

    public boolean isReportErrorEnable() {
        return i.f572089e;
    }

    public void setAlogUploadUrl(String r100) {
        g r101 = g.f572072l;
        r101.getClass();
        if (TextUtils.isEmpty(r100) == true) goto L7;
        r101.f572081i = r100;
        return;
    }

    public void setConfigGetUrl(String r100) {
        g r101 = g.f572072l;
        r101.getClass();
        if (TextUtils.isEmpty(r100) == true) goto L7;
        r101.f572082j = r100;
        return;
    }

    public void setCurrentProcessName(String r100) {
        b.f203406a = r100;
    }

    public void setDebugMode(boolean r100) {
        i.f572087c = r100;
    }

    public void setDefaultAnrCheckInterval(long r100) {
        i.f572086b = r100;
    }

    public void setEncryptImpl(p r100) {
        if (r100 == null) goto L5;
        i.f572088d = r100;
        return;
    }

    public void setEnsureEnable(boolean r100) {
        i.f572090f = r100;
    }

    public void setJavaCrashUploadUrl(String r100) {
        g r101 = g.f572072l;
        r101.getClass();
        if (TextUtils.isEmpty(r100) == true) goto L7;
        r101.f572074b = r100;
        return;
    }

    public void setLaunchCrashInterval(long r100) {
        i.f572085a = r100;
    }

    public void setLaunchCrashUrl(String r100) {
        g r101 = g.f572072l;
        r101.getClass();
        if (TextUtils.isEmpty(r100) == true) goto L11;
        r101.f572076d = r100;
        int r102 = r100.indexOf("//");
        if (r102 != (-1)) goto L8;
        r101.f572075c = r100.substring(0, r100.indexOf(HTTP.URL_DEFAULT) + 1) + "monitor/collect/c/exception/dump_collection";
        r101.f572078f = r100.substring(0, r100.indexOf(HTTP.URL_DEFAULT) + 1) + "monitor/collect/c/custom_exception/zip";
        return;
    L8:
        StringBuilder r103 = new StringBuilder();
        int r104 = r102 + 2;
        r103.append(r100.substring(0, r100.indexOf(HTTP.URL_DEFAULT, r104) + 1));
        r103.append("monitor/collect/c/exception/dump_collection");
        r101.f572075c = r103.toString();
        r101.f572078f = r100.substring(0, r100.indexOf(HTTP.URL_DEFAULT, r104) + 1) + "monitor/collect/c/custom_exception/zip";
        return;
    }

    public void setNativeCrashUrl(String r100) {
        g r101 = g.f572072l;
        r101.getClass();
        if (TextUtils.isEmpty(r100) == true) goto L7;
        r101.f572080h = r100;
        return;
    }

    public void setReportErrorEnable(boolean r100) {
        i.f572089e = r100;
    }
}
