package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v1.GetChannelThreadsRequest;
import com.bytedance.lark.pb.im.v1.GetChannelThreadsResponse;
import com.bytedance.lark.pb.im.v1.GetThreadMessagesByPositionsRequest;
import com.bytedance.lark.pb.im.v1.GetThreadMessagesByPositionsResponse;
import com.bytedance.lark.pb.im.v1.GetThreadMessagesV2Request;
import com.bytedance.lark.pb.im.v1.GetThreadMessagesV2Response;
import com.bytedance.lark.pb.im.v1.UpdateThreadRequest;
import com.bytedance.lark.pb.im.v1.UpdateThreadResponse;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class l1 implements a2b.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.lark.rustclient.api.l f411612a;

    @Inject
    public l1(com.bytedance.lark.rustclient.api.l r100) {
        Intrinsics.checkNotNullParameter(r100, "userClient");
        this.f411612a = r100;
    }

    @Override // a2b.m
    public final l5b.a a(GetThreadMessagesByPositionsRequest.Builder r110, final s1 r111) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        Intrinsics.checkNotNullParameter(r111, "respMap");
        com.bytedance.lark.rustclient.api.d r100 = new com.bytedance.lark.rustclient.api.d(r110, GetThreadMessagesByPositionsResponse.ADAPTER, Command.GET_THREAD_MESSAGES_BY_POSITIONS, null, null, null, null, 248);
        return (l5b.a) com.bytedance.lark.rustclient.api.t.c(com.bytedance.lark.rustclient.api.t.e(this.f411612a.h(r100).execute(), new ThreadRepositoryV2$getThreadMessageByPositions$1(r111)), null);
    }

    @Override // a2b.m
    public final l5b.b b(GetChannelThreadsRequest.Builder r110, final p1 r111) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        Intrinsics.checkNotNullParameter(r111, "respMap");
        com.bytedance.lark.rustclient.api.d r100 = new com.bytedance.lark.rustclient.api.d(r110, GetChannelThreadsResponse.ADAPTER, Command.GET_CHANNEL_THREADS, null, null, null, null, 248);
        return (l5b.b) com.bytedance.lark.rustclient.api.t.c(com.bytedance.lark.rustclient.api.t.e(this.f411612a.h(r100).execute(), new ThreadRepositoryV2$getChannelThreads$1(r111)), null);
    }

    @Override // a2b.m
    public final void c(UpdateThreadRequest.Builder r110, IGetDataCallback<Void> r111) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        com.bytedance.lark.rustclient.api.d r100 = new com.bytedance.lark.rustclient.api.d(r110, UpdateThreadResponse.ADAPTER, Command.UPDATE_THREAD, null, null, null, null, 248);
        Observable r112 = com.bytedance.lark.rustclient.api.t.b(this.f411612a.h(r100).a());
        Intrinsics.checkNotNullParameter(r112, "<this>");
        r112.subscribe(new com.ss.android.lark.im.sdk.utils.c(r111), new com.ss.android.lark.im.sdk.utils.d(r111));
    }

    @Override // a2b.m
    public final l5b.a d(GetThreadMessagesV2Request.Builder r110, final q1.a r111) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        Intrinsics.checkNotNullParameter(r111, "respMap");
        com.bytedance.lark.rustclient.api.d r100 = new com.bytedance.lark.rustclient.api.d(r110, GetThreadMessagesV2Response.ADAPTER, Command.GET_THREAD_MESSAGES_V2, null, null, null, null, 248);
        return (l5b.a) com.bytedance.lark.rustclient.api.t.c(com.bytedance.lark.rustclient.api.t.e(this.f411612a.h(r100).execute(), new ThreadRepositoryV2$getThreadMessageV2$1(r111)), null);
    }
}
