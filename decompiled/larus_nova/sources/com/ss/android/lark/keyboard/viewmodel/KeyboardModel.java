package com.ss.android.lark.keyboard.viewmodel;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.contact.v2.PullDoubaoChatterRequest;
import com.bytedance.lark.pb.contact.v2.PullDoubaoChatterResponse;
import com.bytedance.lark.pb.im.v1.TransformMarkdownToRichTextRequest;
import com.bytedance.lark.pb.im.v1.TransformMarkdownToRichTextResponse;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.rucket.job.RucketJob;
import com.larksuite.rucket.job.base.b;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.parser.internal.g0;
import com.ss.android.lark.parser.internal.j;
import com.ss.android.lark.widget.richtext.RichText;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import lec.c;

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
        RucketJob<PullDoubaoChatterResponse> r108 = ((com.ss.android.lark.keyboard.viewmodel.a) b38.b.f17382a.create(com.ss.android.lark.keyboard.viewmodel.a.class)).getDoubaoChatter(new PullDoubaoChatterRequest.Builder().sync_data_strategy(r100).build());
        r102.label = 1;
        r104 = r108.awaitGet(r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new KeyboardModel$getDoubaoChatter$1(this, r101);
        goto L8
    }

    public final Object b(Context r100, String r101, Continuation<? super RichText> r102) {
        if ((r102 instanceof KeyboardModel$markdownToRichText$1) == false) goto L7;
        KeyboardModel$markdownToRichText$1 r103 = (KeyboardModel$markdownToRichText$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r100 = (Context) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L24:
        Object r108 = ((Result) r105).m9458unboximpl();
        if (Result.m9455isFailureimpl(r108) == false) goto L29;
        Log.e("KeyboardModel", "markdownToRichText failed", Result.m9452exceptionOrNullimpl(r108));
        return null;
    L29:
        if (Result.m9455isFailureimpl(r108) == false) goto L31;
        r108 = null;
    L31:
        b r109 = (b) r108;
        if (r109 != null) goto L34;
    L41:
        StringBuilder r110 = new StringBuilder("markdownToRichText response failed, ");
        if (r109 == null) goto L44;
        ErrorResult r111 = r109.a();
    L45:
        r110.append(r111);
        Log.e("KeyboardModel", r110.toString());
        return null;
    L44:
        r111 = null;
        goto L45
    L34:
        if ((r109 instanceof b.C3939b) == true) goto L41;
        com.bytedance.lark.pb.basic.v1.RichText r112 = ((TransformMarkdownToRichTextResponse) r109.b()).rich_text;
        if (r112 != null) goto L39;
        return null;
    L39:
        RichText r113 = g0.e(r112, null);
        c.c(r100, r113, new lec.b(new lec.b.a()));
        return r113;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        if (r101.length() != 0) goto L17;
        boolean r114 = true;
    L18:
        if (r114 == true) goto L20;
        TransformMarkdownToRichTextRequest r115 = new TransformMarkdownToRichTextRequest.Builder().markdown(r101).build();
        CoroutineDispatcher r116 = Dispatchers.getIO();
        KeyboardModel$markdownToRichText$result$1 r117 = new KeyboardModel$markdownToRichText$result$1(this, r115, null);
        r103.L$0 = r100;
        r103.label = 1;
        r105 = BuildersKt.withContext(r116, r117, r103);
        if (r105 != r106) goto L24;
        return r106;
    L20:
        return com.ss.android.lark.widget.richtext.c.a();
    L17:
        r114 = false;
    L7:
        r103 = new KeyboardModel$markdownToRichText$1(this, r102);
        goto L8
    }
}
