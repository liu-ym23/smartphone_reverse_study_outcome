package com.ss.android.lark.search.doubao.env;

import b4c.d;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.t;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.pb.improto.Command;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@UserScope
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f440109a;

    @Inject
    public b(l r100) {
        Intrinsics.checkNotNullParameter(r100, "rustClient");
        this.f440109a = r100;
    }

    @Override // b4c.d
    public final void j2(Command r110, Message.Builder r111, final UIGetDataCallback r112, ProtoAdapter r113) {
        Intrinsics.checkNotNullParameter(r110, "serverCommand");
        Intrinsics.checkNotNullParameter(r111, "builder");
        Intrinsics.checkNotNullParameter(r113, "adapter");
        t.a(this.f440109a.h(new com.bytedance.lark.rustclient.api.d(r111, r113, com.bytedance.lark.pb.basic.v1.Command.POST_GATEWAY, null, null, r110, null, 152)).a(), new ASLRustImpl$sendPassThroughRequest$call$1(r112), new ASLRustImpl$sendPassThroughRequest$call$2(r112), ASLRustImpl$sendPassThroughRequest$call$3.INSTANCE);
    }
}
