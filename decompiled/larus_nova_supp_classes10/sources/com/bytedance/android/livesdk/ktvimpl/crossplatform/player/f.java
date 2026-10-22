package com.bytedance.android.livesdk.ktvimpl.crossplatform.player;

import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ KtvMusicPlayer a;

    public f(KtvMusicPlayer r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        KtvMusicPlayer r0 = this.a;
        r0.b((Map) r2);
    }
}
