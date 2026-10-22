package com.bytedance.lark.rustclient.api;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.sdk.StreamDataSource;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class f<Resp, Req> extends com.bytedance.lark.rustclient.api.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f253911i = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final we6.b<Req> f253912g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final we6.a<Resp> f253913h;

    public static final class a {
    }

    static {
    }

    public final d<Resp> b() {
        we6.b<Req> r100 = this.f253912g;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.squareup.wire.Message.Builder<*, *>");
        Message.Builder r101 = (Message.Builder) r100;
        we6.a<Resp> r102 = this.f253913h;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<Resp of com.bytedance.lark.rustclient.api.GlobalRustRequest>");
        return new d(r101, (ProtoAdapter) r102, this.f253892a, this.f253893b, this.f253894c, this.f253895d, this.f253896e, this.f253897f);
    }

    public /* synthetic */ f(we6.b r110, we6.a r111, Command r112, com.ss.android.lark.sdk.h r113, int r114) {
        if ((r114 & 8) == 0) goto L5;
        String r100 = com.ss.android.lark.sdk.a.a();
    L7:
        if ((r114 & 32) == 0) goto L9;
        com.ss.android.lark.sdk.h r101 = null;
    L10:
        this(r110, r111, r112, r100, null, r101, null, null);
        return;
    L9:
        r101 = r113;
        goto L10
    L5:
        r100 = null;
        goto L7
    }

    public f(we6.b<Req> r100, we6.a<Resp> r101, Command r110, String r111, StreamDataSource r112, com.ss.android.lark.sdk.h r113, com.ss.android.lark.pb.improto.Command r114, Boolean r115) {
        Intrinsics.checkNotNullParameter(r100, "requestBuilder");
        Intrinsics.checkNotNullParameter(r101, "responseAdapter");
        Intrinsics.checkNotNullParameter(r110, "command");
        Intrinsics.checkNotNullParameter(r111, "contextId");
        super(r110, r111, r112, r113, r114, r115);
        this.f253912g = r100;
        this.f253913h = r101;
    }
}
