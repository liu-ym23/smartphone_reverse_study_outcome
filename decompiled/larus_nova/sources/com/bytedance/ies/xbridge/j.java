package com.bytedance.ies.xbridge;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class j implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator<String> f249503a;

    @Override // com.bytedance.ies.xbridge.u
    public final boolean hasNextKey() {
        return this.f249503a.hasNext();
    }

    @Override // com.bytedance.ies.xbridge.u
    public final String nextKey() {
        return this.f249503a.next();
    }

    public j(Iterator<String> r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.f249503a = r100;
    }
}
