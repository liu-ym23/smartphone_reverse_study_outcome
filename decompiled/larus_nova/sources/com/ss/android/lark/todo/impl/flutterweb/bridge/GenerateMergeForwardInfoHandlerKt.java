package com.ss.android.lark.todo.impl.flutterweb.bridge;

import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.todo.v1.TodoReferResource;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.todo.impl.rustadapter.service.TodoRustCRUD;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: classes38.dex */
public final class GenerateMergeForwardInfoHandlerKt {
    public static final Object a(String r100, Continuation<? super MergeForwardInfo> r101) {
        if ((r101 instanceof GenerateMergeForwardInfoHandlerKt$getMergeForwardInfo$1) == false) goto L7;
        GenerateMergeForwardInfoHandlerKt$getMergeForwardInfo$1 r102 = (GenerateMergeForwardInfoHandlerKt$getMergeForwardInfo$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        int r107 = 0;
        if (r106 == 0) goto L18;
        if (r106 != 1) goto L17;
        r100 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L14
    L31:
        TodoReferResource r108 = (TodoReferResource) r104;     // Catch: Throwable -> L14
        if (r108 != null) goto L34;
        Log.i("TodoWeb", "getReferResources null");     // Catch: Throwable -> L14
    L60:
        return null;
    L34:
        if (r108.type == TodoReferResource.ResourceType.MESSAGE) goto L37;
        Log.i("TodoWeb", "resourceType is not MESSAGE");     // Catch: Throwable -> L14
        return null;
    L37:
        g7c.f r109 = TodoDependencyHolder.a().chatModuleDependency();     // Catch: Throwable -> L14
        TodoReferResource.MessageResource r110 = r108.msg;     // Catch: Throwable -> L14
        if (r110 == null) goto L40;
        Entity r111 = r110.entity;     // Catch: Throwable -> L14
    L41:
        if (r110 == null) goto L43;
        String r112 = r110.msg_id;     // Catch: Throwable -> L14
    L44:
        Message r113 = r109.c(r111, r112);     // Catch: Throwable -> L14
        if (r113 == null) goto L47;
        Message.Type r114 = r113.getType();     // Catch: Throwable -> L14
    L49:
        if (r114 == Message.Type.MERGE_FORWARD) goto L52;
        Log.i("TodoWeb", "message type is not MERGE_FORWARD");     // Catch: Throwable -> L14
        return null;
    L52:
        MergeForwardContent r115 = (MergeForwardContent) r113.getContent();     // Catch: Throwable -> L14
        r115.setMessageId(r113.getId());     // Catch: Throwable -> L14
        Pair<String, CharSequence> r116 = TodoDependencyHolder.a().chatModuleDependency().generateMergeForwardInfo(r115);     // Catch: Throwable -> L14
        String r117 = String.valueOf(r116.getFirst());     // Catch: Throwable -> L14
        String r118 = String.valueOf(r116.getSecond());     // Catch: Throwable -> L14
        byte[] r119 = TodoReferResource.ADAPTER.encode(r108);     // Catch: Throwable -> L14
        ArrayList r120 = new ArrayList(r119.length);     // Catch: Throwable -> L14
        int r121 = r119.length;     // Catch: Throwable -> L14
    L53:
        if (r107 >= r121) goto L56;
        r120.add(Boxing.boxInt(r119[r107]));     // Catch: Throwable -> L14
        r107 = r107 + 1;     // Catch: Throwable -> L14
        goto L53
    L56:
        return new MergeForwardInfo(r117, r118, r100, CollectionsKt.toList(r120));
    L47:
        r114 = null;
        goto L49
    L43:
        r112 = null;
        goto L44
    L40:
        r111 = null;
        goto L41
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r104);
        if (r100 != null) goto L21;
    L24:
        boolean r122 = true;
    L25:
        if (r122 == false) goto L28;
        Log.i("TodoWeb", "referResourceId is null or empty");
        return null;
    L28:
        TodoRustCRUD r123 = TodoRustCRUD.f444248a;     // Catch: Throwable -> L14
        r102.L$0 = r100;     // Catch: Throwable -> L14
        r102.label = 1;     // Catch: Throwable -> L14
        r104 = r123.f(r100, r102);     // Catch: Throwable -> L14
        if (r104 != r105) goto L31;
        return r105;
    L21:
        if (r100.length() == 0) goto L24;
        r122 = false;
    L14:
        th = move-exception;
        Log.e("TodoWeb", "getMergeForwardInfo error", th);
    L7:
        r102 = new GenerateMergeForwardInfoHandlerKt$getMergeForwardInfo$1(r101);
        goto L8
    }
}
