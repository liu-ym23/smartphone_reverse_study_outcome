package com.bytedance.lark.rustclient.api;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.sdk.StreamDataSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class z<Resp, Req> extends com.bytedance.lark.rustclient.api.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f253938i = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final we6.d<Req> f253939g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final we6.c<Resp> f253940h;

    public static final class a {
    }

    static {
    }

    public z(we6.d<Req> r100, we6.c<Resp> r101, Command r110, String r111, StreamDataSource r112, com.ss.android.lark.sdk.h r113, com.ss.android.lark.pb.improto.Command r114, Boolean r115) {
        Intrinsics.checkNotNullParameter(r100, "requestBuilder");
        Intrinsics.checkNotNullParameter(r101, "responseAdapter");
        Intrinsics.checkNotNullParameter(r110, "command");
        Intrinsics.checkNotNullParameter(r111, "contextId");
        super(r110, r111, r112, r113, r114, r115);
        this.f253939g = r100;
        this.f253940h = r101;
    }
}
