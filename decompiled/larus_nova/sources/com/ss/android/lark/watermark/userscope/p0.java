package com.ss.android.lark.watermark.userscope;

import com.ss.android.lark.log.Log;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes38.dex */
public final class p0 implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p0 f445487a = null;

    static {
        f445487a = new p0();
    }

    public p0() {
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        Log.i("watermarkV3", "push file data complete");
    }
}
