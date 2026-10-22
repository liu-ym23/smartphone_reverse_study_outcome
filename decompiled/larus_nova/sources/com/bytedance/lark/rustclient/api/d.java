package com.bytedance.lark.rustclient.api;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.sdk.StreamDataSource;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class d<Resp> extends a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Message.Builder<?, ?> f253908g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ProtoAdapter<Resp> f253909h;

    public /* synthetic */ d(Message.Builder r110, ProtoAdapter r111, Command r112, String r113, com.ss.android.lark.sdk.h r114, com.ss.android.lark.pb.improto.Command r115, Boolean r116, int r117) {
        if ((r117 & 8) == 0) goto L5;
        String r100 = qqb.a.c();
    L7:
        if ((r117 & 32) == 0) goto L9;
        com.ss.android.lark.sdk.h r101 = null;
    L11:
        if ((r117 & 64) == 0) goto L13;
        com.ss.android.lark.pb.improto.Command r102 = null;
    L15:
        if ((r117 & 128) == 0) goto L17;
        Boolean r118 = null;
    L18:
        this(r110, r111, r112, r100, null, r101, r102, r118);
        return;
    L17:
        r118 = r116;
        goto L18
    L13:
        r102 = r115;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }

    public d(Message.Builder<?, ?> r100, ProtoAdapter<Resp> r101, Command r110, String r111, StreamDataSource r112, com.ss.android.lark.sdk.h r113, com.ss.android.lark.pb.improto.Command r114, Boolean r115) {
        Intrinsics.checkNotNullParameter(r100, "requestMessageBuilder");
        Intrinsics.checkNotNullParameter(r101, "responseProtoAdapter");
        Intrinsics.checkNotNullParameter(r110, "command");
        Intrinsics.checkNotNullParameter(r111, "contextId");
        super(r110, r111, r112, r113, r114, r115);
        this.f253908g = r100;
        this.f253909h = r101;
    }
}
