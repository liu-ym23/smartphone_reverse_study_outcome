package com.bytedance.android.livesdk.ktvimpl.base.lyrics;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ KtvRoomLyricHolder a;

    public c(KtvRoomLyricHolder r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Boolean r5 = (Boolean) r4;
        String r1 = bb0.b.b().concat("-lyric");
        ALogger.i(r1, ("currentUserIsSinger:" + r5) + ", invoke class :KtvRoomLyricHolder");
        this.a.e = Intrinsics.areEqual(r5, Boolean.TRUE);
        KtvRoomLyricHolder r6 = this.a;
        if (r6.f == true) goto L6;
        r6.a();
        return;
    }
}
