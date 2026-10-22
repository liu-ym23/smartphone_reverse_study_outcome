package com.larus.im.internal.tracking.network;

import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f350332a = null;

    static {
        f350332a = new a();
    }

    public a() {
    }

    @Override // com.larus.im.internal.tracking.network.q
    public final void a(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        com.larus.im.internal.delegate.a.f348188b.e("NetworkTrackCenter", "network tracking failed: " + r100);
    }
}
