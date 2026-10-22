package com.ss.android.lark.flow.threadwindow;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Channel;
import com.bytedance.lark.pb.im.v1.GetChannelThreadsRequest;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.chat.api.service.impl.p1;
import com.ss.android.lark.chat.api.service.impl.q1;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.core.model.ChannelDataFetcherStrategy;
import com.ss.android.lark.chat.core.model.MessageFetchScene;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowThreadWindowRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChatBundle f424225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f424226b;

    public static final class a {
    }

    static {
    }

    public FlowThreadWindowRepository(ChatBundle r100, v r101) {
        Intrinsics.checkNotNullParameter(r100, "chatBundle");
        Intrinsics.checkNotNullParameter(r101, "chatAppContainer");
        this.f424225a = r100;
        this.f424226b = r101;
    }

    public final Object b(String r100, Continuation<? super Result<? extends List<? extends n5b.a>>> r101) {
        if ((r101 instanceof FlowThreadWindowRepository$loadFirstPage$1) == false) goto L7;
        FlowThreadWindowRepository$loadFirstPage$1 r102 = (FlowThreadWindowRepository$loadFirstPage$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L18:
        return ((Result) r104).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        CoroutineDispatcher r107 = Dispatchers.getIO();
        FlowThreadWindowRepository$loadFirstPage$2 r108 = new FlowThreadWindowRepository$loadFirstPage$2(this, r100, null);
        r102.label = 1;
        r104 = BuildersKt.withContext(r107, r108, r102);
        if (r104 != r105) goto L18;
        return r105;
    L7:
        r102 = new FlowThreadWindowRepository$loadFirstPage$1(this, r101);
        goto L8
    }

    public final Object c(String r100, int r101, Continuation<? super Result<? extends List<? extends n5b.a>>> r102) {
        if ((r102 instanceof FlowThreadWindowRepository$loadNextPage$1) == false) goto L7;
        FlowThreadWindowRepository$loadNextPage$1 r103 = (FlowThreadWindowRepository$loadNextPage$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L18:
        return ((Result) r105).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        CoroutineDispatcher r108 = Dispatchers.getIO();
        FlowThreadWindowRepository$loadNextPage$2 r109 = new FlowThreadWindowRepository$loadNextPage$2(this, r100, r101, null);
        r103.label = 1;
        r105 = BuildersKt.withContext(r108, r109, r103);
        if (r105 != r106) goto L18;
        return r106;
    L7:
        r103 = new FlowThreadWindowRepository$loadNextPage$1(this, r102);
        goto L8
    }

    public final Object d(String r100, int r101, Continuation<? super Result<? extends List<? extends n5b.a>>> r102) {
        if ((r102 instanceof FlowThreadWindowRepository$loadPrePage$1) == false) goto L7;
        FlowThreadWindowRepository$loadPrePage$1 r103 = (FlowThreadWindowRepository$loadPrePage$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L18:
        return ((Result) r105).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        CoroutineDispatcher r108 = Dispatchers.getIO();
        FlowThreadWindowRepository$loadPrePage$2 r109 = new FlowThreadWindowRepository$loadPrePage$2(this, r100, r101, null);
        r103.label = 1;
        r105 = BuildersKt.withContext(r108, r109, r103);
        if (r105 != r106) goto L18;
        return r106;
    L7:
        r103 = new FlowThreadWindowRepository$loadPrePage$1(this, r102);
        goto L8
    }

    public final Object e(String r100, int r101, Continuation<? super Result<? extends List<? extends n5b.a>>> r102) {
        if ((r102 instanceof FlowThreadWindowRepository$loadSpecificPage$1) == false) goto L7;
        FlowThreadWindowRepository$loadSpecificPage$1 r103 = (FlowThreadWindowRepository$loadSpecificPage$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L18:
        return ((Result) r105).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        CoroutineDispatcher r108 = Dispatchers.getIO();
        FlowThreadWindowRepository$loadSpecificPage$2 r109 = new FlowThreadWindowRepository$loadSpecificPage$2(r101, this, r100, null);
        r103.label = 1;
        r105 = BuildersKt.withContext(r108, r109, r103);
        if (r105 != r106) goto L18;
        return r106;
    L7:
        r103 = new FlowThreadWindowRepository$loadSpecificPage$1(this, r102);
        goto L8
    }

    public static final l5b.b a(FlowThreadWindowRepository r100, String r101, MessageFetchScene r102, int r103) {
        r100.getClass();
        if (r102 != MessageFetchScene.FIRST_SCREEN) goto L5;
    L8:
        boolean r104 = true;
    L9:
        q1 r105 = q1.d.f411637a;
        ChannelDataFetcherStrategy r106 = ChannelDataFetcherStrategy.SYNC_SERVER_DATA;
        int r107 = com.ss.android.lark.chat.core.model.a.f414766b;
        if (TextUtils.isEmpty(r101) == true) goto L15;
        if (r103 < 0) goto L15;
        p1 r108 = new p1(System.currentTimeMillis(), r101);
        GetChannelThreadsRequest.Builder r109 = new GetChannelThreadsRequest.Builder();
        r109.channel(new Channel.Builder().id(r101).type(Channel.Type.CHAT).build()).scene(q1.b(r102)).count(15).redundancy_count(5).position(Integer.valueOf(r103)).strategy(q1.c(r106)).preload_count(Integer.valueOf(r107)).need_response(Boolean.TRUE).need_reply_prompt(Boolean.valueOf(r104));
        return r105.f411629a.b(r109, r108);
    L15:
        return new l5b.b();
    L5:
        if (r102 == MessageFetchScene.SPECIFIED_POSITION) goto L8;
        r104 = false;
        goto L9
    }
}
