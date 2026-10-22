package com.ss.ugc.live.sdk.msg.unify.business;

import com.ss.ugc.live.sdk.msg.data.SdkResponse;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWEventData;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UMGWEventData f458352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<tlc.d> f458353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.ugc.live.sdk.msg.data.c f458354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SdkResponse f458355d;

    /* JADX WARN: Multi-variable type inference failed */
    public d(UMGWEventData r100, List<? extends tlc.d> r101, com.ss.ugc.live.sdk.msg.data.c r102, SdkResponse r103) {
        Intrinsics.checkNotNullParameter(r100, "eventData");
        Intrinsics.checkNotNullParameter(r101, "decodeMessage");
        Intrinsics.checkNotNullParameter(r102, "sdkStat");
        Intrinsics.checkNotNullParameter(r103, "response");
        this.f458352a = r100;
        this.f458353b = r101;
        this.f458354c = r102;
        this.f458355d = r103;
    }
}
