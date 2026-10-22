package com.ss.android.lark.keyboard.plugin.tool.voice.advance;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "chatChatter", "Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class AdvanceVoiceInputComponent$startRecord$2 extends Lambda implements Function1<ChatChatter, String> {
    final /* synthetic */ b this$0;

    public AdvanceVoiceInputComponent$startRecord$2(b r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(ChatChatter r100) {
        Intrinsics.checkNotNullParameter(r100, "chatChatter");
        this.this$0.getClass();
        throw null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(ChatChatter r100) {
        return invoke2(r100);
    }
}
