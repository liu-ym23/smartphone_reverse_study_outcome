package com.ss.android.lark.watermark.userscope;

import com.ss.android.lark.log.Log;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes38.dex */
public final class j0 implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j0 f445449a = null;

    static {
        f445449a = new j0();
    }

    public j0() {
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        Log.i("watermarkV3", "fetch file watermark dispose");
        ToolsV3Kt.c("scs_watermark_network_dispose", null, 1, 14);
    }
}
