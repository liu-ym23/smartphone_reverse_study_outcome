package com.bytedance.forest.model;

import android.system.Os;
import android.system.OsConstants;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f244329a = 0;

    static {
        f244329a = (int) Os.sysconf(OsConstants._SC_PAGE_SIZE);
    }
}
