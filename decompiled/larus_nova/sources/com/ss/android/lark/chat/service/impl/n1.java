package com.ss.android.lark.chat.service.impl;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v1.GetRepliesRequest;
import com.bytedance.lark.pb.im.v1.GetRepliesResponse;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class n1 implements m6b.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.lark.rustclient.api.l f416548a;

    @Inject
    public n1(com.bytedance.lark.rustclient.api.l r100) {
        Intrinsics.checkNotNullParameter(r100, "userClient");
        this.f416548a = r100;
    }

    @Override // m6b.l
    public final void a(GetRepliesRequest.Builder r110, t1 r111, IGetDataCallback r112) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        Intrinsics.checkNotNullParameter(r111, "respMap");
        com.bytedance.lark.rustclient.api.d r100 = new com.bytedance.lark.rustclient.api.d(r110, GetRepliesResponse.ADAPTER, Command.GET_REPLIES, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.a(com.bytedance.lark.rustclient.api.t.b(this.f416548a.h(r100).a()).map(new m1(r111)), r112);
    }
}
