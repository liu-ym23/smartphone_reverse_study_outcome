package com.larus.im.internal.core.message.converter;

import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.message.converter.MessageEntityConverterKt", f = "MessageEntityConverter.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {73, 74}, m = "toMessage", n = {"$this$toMessage", RemoteMessageConst.MessageBody.MSG_CONTENT, "msgContentBlock", "msgBrief", "extMap", "$this$toMessage", RemoteMessageConst.MessageBody.MSG_CONTENT, "msgContentBlock", "msgBrief", "extMap"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
public final class MessageEntityConverterKt$toMessage$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int I$4;
    long J$0;
    long J$1;
    long J$2;
    long J$3;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
    Object L$13;
    Object L$14;
    Object L$15;
    Object L$16;
    Object L$17;
    Object L$18;
    Object L$19;
    Object L$2;
    Object L$20;
    Object L$21;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    boolean Z$0;
    boolean Z$1;
    boolean Z$2;
    int label;
    /* synthetic */ Object result;

    public MessageEntityConverterKt$toMessage$1(Continuation<? super MessageEntityConverterKt$toMessage$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return MessageEntityConverterKt.a(null, this);
    }
}
