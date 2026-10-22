package com.bytedance.common.profilesdk.core;

import android.os.Build;
import android.os.SystemClock;
import com.bytedance.common.profilesdk.util.Logger;
import com.bytedance.common.profilesdk.util.VersionUtils;
import com.bytedance.services.apm.api.EnsureManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public class Dex2oat {
    List<String> options;
    File redirectOutput;

    public static class Builder {
        List<String> mOptions;
        File redirectOutput;

        public Dex2oat build() {
            Dex2oat r100 = new Dex2oat();
            r100.options = this.mOptions;
            r100.redirectOutput = this.redirectOutput;
            return r100;
        }

        public Builder() {
            this.mOptions = new ArrayList();
        }

        public Builder addOptions(List<String> r100) {
            this.mOptions.addAll(r100);
            return this;
        }
    }

    public Dex2oat() {
    }

    public int run() {
        if (VersionUtils.isNOP() == false) goto L29;
        ArrayList r100 = new ArrayList();
        r100.add("dex2oat");
        r100.addAll(this.options);
        int r101 = -1;
        long r102 = SystemClock.uptimeMillis();     // Catch: Exception -> L26
        ProcessBuilder r103 = new ProcessBuilder(r100);     // Catch: Exception -> L26
        if (VersionUtils.isQ() == false) goto L10;
        r103.environment().put("LD_LIBRARY_PATH", "/apex/com.android.runtime/lib");     // Catch: Exception -> L26
    L10:
        if (VersionUtils.isR() == false) goto L12;
        r103.environment().put("LD_LIBRARY_PATH", "/apex/com.android.art/lib");     // Catch: Exception -> L26
    L12:
        File r104 = this.redirectOutput;     // Catch: Exception -> L26
        if (r104 != null) goto L15;
    L17:
        r101 = r103.start().waitFor();     // Catch: Exception -> L26
        long r105 = SystemClock.uptimeMillis() - r102;     // Catch: Exception -> L26
        StringBuilder r106 = new StringBuilder();     // Catch: Exception -> L26
        Iterator r107 = r100.iterator();     // Catch: Exception -> L26
    L19:
        if (r107.hasNext() == false) goto L21;
        r106.append((String) r107.next());     // Catch: Exception -> L26
        r106.append(" ");     // Catch: Exception -> L26
        goto L19
    L21:
        if (r101 != 0) goto L23;
        boolean r108 = true;
    L24:
        EnsureManager.ensureTrue(r108, "dex2oat return " + r101);     // Catch: Exception -> L26
        Logger.d("dex2oat took " + r105 + "ms, ret=" + r101 + ", cmd=" + r106.toString());     // Catch: Exception -> L26
    L28:
        return r101;
    L23:
        r108 = false;
        goto L24
    L15:
        if (Build.VERSION.SDK_INT < 26) goto L17;
        r103.redirectOutput(r104);     // Catch: Exception -> L26
    L26:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        Logger.d(e.toString());
        goto L28
    L29:
        return -100;
    }
}
