package com.bytedance.android.livesdk.ktvimpl.concert_stage.biz;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h<T> implements Consumer {
    public static final h a = null;

    static {
        a = new h();
    }

    public h() {
    }

    public final void accept(Object r3) {
        w.b("ConcertStageComponent", "leaveChorus failed, msg: " + ((Throwable) r3).getMessage());
    }
}
