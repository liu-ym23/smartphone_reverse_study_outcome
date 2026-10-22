package com.ss.android.rust.lark_fg;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003¨\u0006\u0005"}, d2 = {"getImmutableFeatureGating", "", "userid", "", "key", "lark-fg_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class Lark_fgKt {
    public static final boolean getImmutableFeatureGating(String r100, String r101) throws RuntimeException {
        Intrinsics.checkNotNullParameter(r100, "userid");
        Intrinsics.checkNotNullParameter(r101, "key");
        return LarkFg.Companion.getImmutableFeatureGating(r100, r101);
    }
}
