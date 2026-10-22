package com.ss.android.lark.im.sdk.service;

import com.bytedance.lark.pb.im.v1.CreateLocalMentionBotsNotInChatMessageResponse;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/im/sdk/service/MentionBotLocalMessageCreateResult;", "it", "Lcom/bytedance/lark/pb/im/v1/CreateLocalMentionBotsNotInChatMessageResponse;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ImSdkMessageServiceImplV2$createLocalMentionBotsNotInChatMessage$1 extends Lambda implements Function1<CreateLocalMentionBotsNotInChatMessageResponse, MentionBotLocalMessageCreateResult> {
    public static final ImSdkMessageServiceImplV2$createLocalMentionBotsNotInChatMessage$1 INSTANCE = null;

    static {
        INSTANCE = new ImSdkMessageServiceImplV2$createLocalMentionBotsNotInChatMessage$1();
    }

    public ImSdkMessageServiceImplV2$createLocalMentionBotsNotInChatMessage$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ MentionBotLocalMessageCreateResult invoke(CreateLocalMentionBotsNotInChatMessageResponse r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final MentionBotLocalMessageCreateResult invoke2(CreateLocalMentionBotsNotInChatMessageResponse r100) {
        return MentionBotLocalMessageCreateResult.a.f426058a;
    }
}
