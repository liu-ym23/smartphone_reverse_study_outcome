package com.ss.android.lark.mention.base.impl.atselector.doubaoview;

import com.ss.android.lark.pb.graph.PullClosestChattersRequest;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;

/* JADX INFO: loaded from: classes36.dex */
public final class g {
    public static final Object a(Continuation r100) {
        if ((r100 instanceof DoubaoMentionRecommendDataLoaderKt$requestClosestChatters$1) == false) goto L7;
        DoubaoMentionRecommendDataLoaderKt$requestClosestChatters$1 r101 = (DoubaoMentionRecommendDataLoaderKt$requestClosestChatters$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L20:
        return ((Result) r103).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        r101.label = 1;
        final kotlinx.coroutines.j r106 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r101), 1);
        r106.C();
        PullClosestChattersRequest.Builder r107 = new PullClosestChattersRequest.Builder().begin(Boxing.boxInt(0)).end(Boxing.boxInt(10)).is_need_department(Boxing.boxBoolean(true)).is_need_extended_fields(Boxing.boxBoolean(true));
        SdkSender.sendPassThroughRequest(Command.PULL_CLOSEST_CHATTERS, r107, new DoubaoMentionRecommendDataLoaderKt$requestClosestChatters$2$1(r106), f.f431761a);
        r103 = r106.B();
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L17:
        if (r103 != r104) goto L20;
        return r104;
    L7:
        r101 = new DoubaoMentionRecommendDataLoaderKt$requestClosestChatters$1(r100);
        goto L8
    }
}
