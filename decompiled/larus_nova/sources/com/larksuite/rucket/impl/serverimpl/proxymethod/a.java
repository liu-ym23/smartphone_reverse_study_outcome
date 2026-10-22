package com.larksuite.rucket.impl.serverimpl.proxymethod;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.rustclient.api.d;
import com.bytedance.lark.rustclient.api.l;
import com.larksuite.rucket.impl.serverimpl.annotation.ServerCall;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a extends com.larksuite.rucket.impl.base.request.a<ServerCall> {
    @Override // com.larksuite.rucket.core.proxymethod.BaseProxyMethod
    public final Class<ServerCall> b() {
        return ServerCall.class;
    }

    @Override // com.larksuite.rucket.impl.base.request.a
    public final d<Message<?, ?>> f(Object[] r110) {
        Intrinsics.checkNotNullParameter(r110, "args");
        ArrayList r100 = new ArrayList();
        int r101 = r110.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        Object r103 = r110[r102];
        if ((r103 instanceof Message) == false) goto L7;
        r100.add(r103);
    L7:
        r102 = r102 + 1;
        goto L3
    L8:
        Message r111 = (Message) CollectionsKt.first(r100);
        Command r104 = Command.POST_GATEWAY;
        return new d(r111.newBuilder(), ProtoAdapter.get(e()), r104, null, null, com.ss.android.lark.pb.improto.Command.fromValue(((ServerCall) c()).value()), null, 184);
    }

    public a(l r100, Method r101) {
        Intrinsics.checkNotNullParameter(r100, "client");
        Intrinsics.checkNotNullParameter(r101, PlayerResolution.SDKKEY.ORIGIN);
        super(r100, r101);
    }
}
