package com.ss.android.downloadlib.addownload.model;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public class AppInfoX {
    public String appDesc;
    public String appIcon;
    public String appName;
    public long cid;
    public long convertId;
    public String developer;
    public String packageName;
    public final List<Pair<String, String>> permissions;
    public String privacyPolicyUrl;
    public int versionCode;
    public String versionName;

    public static long getId(long r100, long r101) {
        if (r100 <= 0) goto L6;
        return r100;
    L6:
        return r101;
    }

    public long getId() {
        return getId(this.convertId, this.cid);
    }

    public AppInfoX() {
        this.permissions = new ArrayList();
    }
}
