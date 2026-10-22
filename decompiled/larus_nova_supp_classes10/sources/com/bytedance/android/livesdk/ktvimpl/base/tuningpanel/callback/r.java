package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class r<T> implements Consumer {
    public final /* synthetic */ KSongViceSingerTuningButtonOuterCallback a;

    public r(KSongViceSingerTuningButtonOuterCallback r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        cb0.b r2 = (cb0.b) r1;
        this.a.h();
    }
}
