package com.ss.android.lark.mention.base.impl.atselector.doubaoview.viewmodel;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.contact.v2.PullDoubaoChatterRequest;
import com.bytedance.lark.pb.contact.v2.PullDoubaoChatterResponse;
import com.larksuite.rucket.job.RucketJob;
import com.larksuite.rucket.job.base.b;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.parser.internal.j;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class KeyboardModel {

    public static final class a {
    }

    static {
    }

    public KeyboardModel() {
    }

    public final Object a(SyncDataStrategy r100, Continuation<? super Chatter> r101) {
        if ((r101 instanceof KeyboardModel$getDoubaoChatter$1) == false) goto L7;
        KeyboardModel$getDoubaoChatter$1 r102 = (KeyboardModel$getDoubaoChatter$1) r101;
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
    L17:
        b r107 = (b) r104;
        r107.getClass();
        if ((r107 instanceof b.C3939b) == false) goto L22;
        Log.e("KeyboardModel", "getDoubaoChatter failed, " + r107.a());
        return null;
    L22:
        return j.a(((PullDoubaoChatterResponse) r107.b()).doubao);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        RucketJob<PullDoubaoChatterResponse> r108 = ((com.ss.android.lark.mention.base.impl.atselector.doubaoview.viewmodel.a) b38.b.f17382a.create(com.ss.android.lark.mention.base.impl.atselector.doubaoview.viewmodel.a.class)).getDoubaoChatter(new PullDoubaoChatterRequest.Builder().sync_data_strategy(r100).build());
        r102.label = 1;
        r104 = r108.awaitGet(r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new KeyboardModel$getDoubaoChatter$1(this, r101);
        goto L8
    }
}
