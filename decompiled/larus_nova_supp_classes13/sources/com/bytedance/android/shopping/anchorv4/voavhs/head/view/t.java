package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class t<T> implements Predicate {
    public final /* synthetic */ AnchorV4VideoView a;

    public t(AnchorV4VideoView r1) {
        this.a = r1;
    }

    public final boolean test(Object r2) {
        Intrinsics.checkNotNullParameter((Long) r2, "it");
        PlayerBlock r3 = this.a.d;
        if (r3 != null) goto L5;
    L9:
        return false;
    L5:
        if (r3.isPlaying() != true) goto L9;
        if (this.a.n == true) goto L9;
        return true;
    }
}
