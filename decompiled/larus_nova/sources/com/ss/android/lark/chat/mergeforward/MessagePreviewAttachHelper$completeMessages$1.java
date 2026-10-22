package com.ss.android.lark.chat.mergeforward;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.parser.internal.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import w4b.f;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/chat/entity/message/Message;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.mergeforward.MessagePreviewAttachHelper$completeMessages$1", f = "MessagePreviewAttachHelper.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
final class MessagePreviewAttachHelper$completeMessages$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Message>>, Object> {
    final /* synthetic */ boolean $isCompleteInnerMergeForwardMsg;
    final /* synthetic */ List<Message> $messages;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public MessagePreviewAttachHelper$completeMessages$1(List<? extends Message> r100, boolean r101, Continuation<? super MessagePreviewAttachHelper$completeMessages$1> r102) {
        this.$messages = r100;
        this.$isCompleteInnerMergeForwardMsg = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MessagePreviewAttachHelper$completeMessages$1(this.$messages, this.$isCompleteInnerMergeForwardMsg, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super List<? extends Message>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super List<? extends Message>> r101) {
        return ((MessagePreviewAttachHelper$completeMessages$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r110);
    L44:
        Map r111 = (Map) r110;
        int r102 = c.f415443a;
        List<Message> r103 = this.$messages;
        boolean r104 = this.$isCompleteInnerMergeForwardMsg;
        if (r103 == null) goto L94;
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r103.iterator();
    L48:
        if (r106.hasNext() == false) goto L61;
        Object r107 = r106.next();
        Message r108 = (Message) r107;
        if (r108.getType() != Message.Type.TEXT) goto L52;
    L58:
        boolean r109 = true;
    L59:
        if (r109 == false) goto L48;
        r105.add(r107);
        goto L48
    L52:
        if (r108.getType() == Message.Type.POST) goto L58;
        if (r108.getType() != Message.Type.MERGE_FORWARD) goto L57;
        if (r104 == true) goto L58;
    L57:
        r109 = false;
        goto L59
    L61:
        Iterator r112 = r105.iterator();
    L63:
        if (r112.hasNext() == false) goto L94;
        Message r113 = (Message) r112.next();
        if (r113.getType() == Message.Type.TEXT) goto L66;
        if (r113.getType() == Message.Type.POST) goto L75;
        if (r113.getType() != Message.Type.MERGE_FORWARD) goto L63;
        MergeForwardContent r114 = (MergeForwardContent) r113.getContent();
        List<Message> r115 = r114.getMessages();
        if (r115 == null) goto L87;
        Message r116 = (Message) ListProtector.get(r115, 0);
    L89:
        if (r114.getThread() == null) goto L92;
        if (r116 == null) goto L92;
        c.a(CollectionsKt.mutableListOf(new Message[]{r116}), true);
    L92:
        c.a(r114.getMessages(), false);
        goto L63
    L87:
        r116 = null;
        goto L89
    L75:
        PostContent r117 = (PostContent) r113.getContent();
        Iterator<Map.Entry<String, PreviewHangPoint>> r118 = r117.getPreviewHangPoints().entrySet().iterator();
    L77:
        if (r118.hasNext() == false) goto L81;
        PreviewHangPoint r119 = r118.next().getValue();
        String r120 = r119.getPreviewId();
        if (r120 == null) goto L77;
        r119.setUrlCardPreviewEntity((UrlCardPreviewEntity) r111.get(r120));
        goto L77
    L81:
        r.x(r117.getRichText(), r117.getPreviewHangPoints());
        goto L63
    L66:
        TextContent r121 = (TextContent) r113.getContent();
        Iterator<Map.Entry<String, PreviewHangPoint>> r122 = r121.getPreviewHangPoints().entrySet().iterator();
    L68:
        if (r122.hasNext() == false) goto L72;
        PreviewHangPoint r123 = r122.next().getValue();
        String r124 = r123.getPreviewId();
        if (r124 == null) goto L68;
        r123.setUrlCardPreviewEntity((UrlCardPreviewEntity) r111.get(r124));
        goto L68
    L72:
        r.x(r121.getRichText(), r121.getPreviewHangPoints());
    L94:
        return this.$messages;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        ArrayList r125 = new ArrayList();
        List<Message> r126 = this.$messages;
        if (r126 == null) goto L41;
        ArrayList r127 = new ArrayList();
        Iterator<T> r128 = r126.iterator();
    L12:
        if (r128.hasNext() == false) goto L22;
        Object r129 = r128.next();
        Message r130 = (Message) r129;
        if (r130.getType() != Message.Type.TEXT) goto L16;
    L19:
        boolean r131 = true;
    L20:
        if (r131 == false) goto L12;
        r127.add(r129);
        goto L12
    L16:
        if (r130.getType() == Message.Type.POST) goto L19;
        r131 = false;
        goto L20
    L22:
        Iterator r132 = r127.iterator();
    L24:
        if (r132.hasNext() == false) goto L41;
        Message r133 = (Message) r132.next();
        if (r133.getType() == Message.Type.TEXT) goto L27;
        if (r133.getType() != Message.Type.POST) goto L24;
        Iterator<Map.Entry<String, PreviewHangPoint>> r134 = ((PostContent) r133.getContent()).getPreviewHangPoints().entrySet().iterator();
    L37:
        if (r134.hasNext() == false) goto L24;
        com.bytedance.lark.pb.basic.v1.PreviewHangPoint r135 = r134.next().getValue().parseToPB();
        if (r135 == null) goto L37;
        r125.add(r135);
        goto L37
    L27:
        Iterator<Map.Entry<String, PreviewHangPoint>> r136 = ((TextContent) r133.getContent()).getPreviewHangPoints().entrySet().iterator();
    L29:
        if (r136.hasNext() == false) goto L24;
        com.bytedance.lark.pb.basic.v1.PreviewHangPoint r137 = r136.next().getValue().parseToPB();
        if (r137 == null) goto L29;
        r125.add(r137);
    L41:
        f r138 = ChatCoreModule.a().getUrlPreviewDependency();
        this.label = 1;
        r110 = r138.a(r125, this);
        if (r110 != r100) goto L44;
        return r100;
    }
}
