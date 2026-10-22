package com.ss.android.lark.keyboard.plugin.tool.voice.advance;

import ccb.d;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/dto/chat/MentionChatChatterResponse;", "chatId", "", "searchKey", "requestId", "isFromServer", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class AdvanceVoiceInputComponent$startRecord$3 extends Lambda implements Function4<String, String, String, Boolean, d> {
    final /* synthetic */ b this$0;

    public AdvanceVoiceInputComponent$startRecord$3(b r100) {
        this.this$0 = r100;
        super(4);
    }

    public final d invoke(String r100, String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        Intrinsics.checkNotNullParameter(r101, "searchKey");
        Intrinsics.checkNotNullParameter(r102, "requestId");
        this.this$0.getClass();
        throw null;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ d invoke(String r100, String r101, String r102, Boolean r103) {
        return invoke(r100, r101, r102, r103.booleanValue());
    }
}
