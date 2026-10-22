package com.ss.android.lark.watermark.userscope;

import com.ss.android.lark.log.Log;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes38.dex */
public final class z implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f445519a = null;

    static {
        f445519a = new z();
    }

    public z() {
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        Log.i("watermarkV3", "fetch fallback watermark dispose");
        ToolsV3Kt.c("scs_watermark_network_dispose", null, 1, 14);
    }
}
