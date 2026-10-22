package com.ss.android.lark.watermark.userscope;

import com.ss.android.lark.log.Log;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes38.dex */
public final class v implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f445512a = null;

    static {
        f445512a = new v();
    }

    public v() {
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        Log.i("watermarkV3", "fetch bright watermark dispose");
        ToolsV3Kt.c("scs_watermark_network_dispose", null, 1, 14);
    }
}
