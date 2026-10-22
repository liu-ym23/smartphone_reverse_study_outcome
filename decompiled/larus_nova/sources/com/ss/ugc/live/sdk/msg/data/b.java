package com.ss.ugc.live.sdk.msg.data;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tlc.d;
import vlc.i;

/* JADX INFO: loaded from: classes36.dex */
public final class b extends a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i f458235g;

    public b(SdkResponse r100, List<? extends d> r101, i r102) {
        Intrinsics.checkNotNullParameter(r100, "response");
        Intrinsics.checkNotNullParameter(r101, "decodeMessages");
        Intrinsics.checkNotNullParameter(r102, "listener");
        super(r100, r101);
        this.f458235g = r102;
    }
}
