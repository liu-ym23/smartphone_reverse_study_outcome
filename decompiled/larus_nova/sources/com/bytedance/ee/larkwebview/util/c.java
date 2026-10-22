package com.bytedance.ee.larkwebview.util;

import android.content.Context;
import android.content.res.Configuration;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f242967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f242968b;

    public Context getContext() {
        return this.f242967a;
    }

    public c(Context r100) {
        this.f242967a = r100;
        Configuration r101 = r100.getResources().getConfiguration();
        this.f242968b = r101.uiMode;
        Log.i("DarkModeContextExtension", "origin config=" + r101);
    }
}
