package com.bytedance.android.livesdk.ktvimpl.mv.opus;

import android.content.Context;
import com.bytedance.android.livesdk.ktvapi.model.mv.m;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements m {
    public HashMap<Integer, Integer> a;

    public d() {
    }

    public final d a(HashMap r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        this.a = r2;
        return this;
    }

    public final OpusServiceImpl build(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        OpusServiceImpl r0 = new OpusServiceImpl(null, r4, this.a, null);
        r0.j = null;
        r0.k = null;
        return r0;
    }
}
