package com.huawei.hms.ui;

import android.os.Bundle;
import com.huawei.hms.base.ui.LogUtil;

/* JADX INFO: loaded from: classes23.dex */
public class SafeBundle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bundle f277828a;

    public SafeBundle() {
        this(new Bundle());
    }

    public boolean isEmpty() {
        return this.f277828a.isEmpty();
    L4:
        LogUtil.e("SafeBundle", "isEmpty exception");
        return true;
    }

    public int size() {
        return this.f277828a.size();
    L4:
        LogUtil.e("SafeBundle", "size exception");
        return 0;
    }

    public String toString() {
        return this.f277828a.toString();
    }

    public Bundle getBundle() {
        return this.f277828a;
    }

    public SafeBundle(Bundle r100) {
        if (r100 != null) goto L6;
        r100 = new Bundle();
    L6:
        this.f277828a = r100;
    }

    public boolean containsKey(String r100) {
        return this.f277828a.containsKey(r100);
    L4:
        LogUtil.e("SafeBundle", "containsKey exception. key:");
        return false;
    }

    public Object get(String r100) {
        return this.f277828a.get(r100);
    L4:
        e = move-exception;
        LogUtil.e("SafeBundle", "get exception: " + e.getMessage(), true);
        return null;
    }

    public int getInt(String r100) {
        return getInt(r100, 0);
    }

    public String getString(String r100) {
        return this.f277828a.getString(r100);
    L4:
        th = move-exception;
        LogUtil.e("SafeBundle", "getString exception: " + th.getMessage(), true);
        return "";
    }

    public int getInt(String r100, int r101) {
        return this.f277828a.getInt(r100, r101);
    L4:
        th = move-exception;
        LogUtil.e("SafeBundle", "getInt exception: " + th.getMessage(), true);
        return r101;
    }

    public String getString(String r100, String r101) {
        return this.f277828a.getString(r100, r101);
    L4:
        e = move-exception;
        LogUtil.e("SafeBundle", "getString exception: " + e.getMessage(), true);
        return r101;
    }
}
