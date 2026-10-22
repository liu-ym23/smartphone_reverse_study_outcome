package com.bytedance.crash.runtime;

import android.text.TextUtils;
import com.bytedance.crash.monitor.a;
import com.bytedance.crash.monitor.j;
import com.bytedance.crash.p;
import com.bytedance.crash.util.b;
import fh4.d;
import zg4.g;
import zg4.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class ConfigManager {
    private boolean mEnsureEnable;

    public String getAlogUploadUrl() {
        return g.l.i;
    }

    public String getNativeCrashUploadUrl() {
        return g.l.h;
    }

    public boolean isEnsureEnable() {
        if (i.f == true) goto L5;
        return false;
    L5:
        a r0 = j.a;
        if (r0 == null) goto L16;
        d r1 = r0.e().a;
        if (r1 != null) goto L11;
        return false;
    L11:
        if (r1.d == false) goto L13;
    L14:
        return true;
    L13:
        if (r1.b == true) goto L14;
        return false;
    L16:
        return false;
    }

    public ConfigManager() {
        this.mEnsureEnable = true;
    }

    public long getDefaultAnrCheckInterval() {
        return i.b;
    }

    public boolean isDebugMode() {
        return i.c;
    }

    public boolean isReportErrorEnable() {
        return i.e;
    }

    public void setAlogUploadUrl(String r3) {
        g r0 = g.l;
        r0.getClass();
        if (TextUtils.isEmpty(r3) == true) goto L7;
        r0.i = r3;
        return;
    }

    public void setConfigGetUrl(String r3) {
        g r0 = g.l;
        r0.getClass();
        if (TextUtils.isEmpty(r3) == true) goto L7;
        r0.j = r3;
        return;
    }

    public void setCurrentProcessName(String r1) {
        b.a = r1;
    }

    public void setDebugMode(boolean r1) {
        i.c = r1;
    }

    public void setDefaultAnrCheckInterval(long r1) {
        i.b = r1;
    }

    public void setEncryptImpl(p r1) {
        if (r1 == null) goto L5;
        i.d = r1;
        return;
    }

    public void setEnsureEnable(boolean r1) {
        i.f = r1;
    }

    public void setJavaCrashUploadUrl(String r3) {
        g r0 = g.l;
        r0.getClass();
        if (TextUtils.isEmpty(r3) == true) goto L7;
        r0.b = r3;
        return;
    }

    public void setLaunchCrashInterval(long r1) {
        i.a = r1;
    }

    public void setLaunchCrashUrl(String r9) {
        g r0 = g.l;
        r0.getClass();
        if (TextUtils.isEmpty(r9) == true) goto L11;
        r0.d = r9;
        int r1 = r9.indexOf("//");
        if (r1 != (-1)) goto L8;
        r0.c = r9.substring(0, r9.indexOf("/") + 1) + "monitor/collect/c/exception/dump_collection";
        r0.f = r9.substring(0, r9.indexOf("/") + 1) + "monitor/collect/c/custom_exception/zip";
        return;
    L8:
        StringBuilder r2 = new StringBuilder();
        int r3 = r1 + 2;
        r2.append(r9.substring(0, r9.indexOf("/", r3) + 1));
        r2.append("monitor/collect/c/exception/dump_collection");
        r0.c = r2.toString();
        r0.f = r9.substring(0, r9.indexOf("/", r3) + 1) + "monitor/collect/c/custom_exception/zip";
        return;
    }

    public void setNativeCrashUrl(String r3) {
        g r0 = g.l;
        r0.getClass();
        if (TextUtils.isEmpty(r3) == true) goto L7;
        r0.h = r3;
        return;
    }

    public void setReportErrorEnable(boolean r1) {
        i.e = r1;
    }
}
