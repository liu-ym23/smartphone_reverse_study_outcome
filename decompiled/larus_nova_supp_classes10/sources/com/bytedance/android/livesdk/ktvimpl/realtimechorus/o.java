package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o implements Action {
    public static final o a = null;

    static {
        a = new o();
    }

    public o() {
    }

    public final void run() {
        ALogger.i("RTChorusRoomDressResource", "onComplete");
    }
}
