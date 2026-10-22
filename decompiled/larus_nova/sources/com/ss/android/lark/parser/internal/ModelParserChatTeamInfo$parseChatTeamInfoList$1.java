package com.ss.android.lark.parser.internal;

import com.bytedance.lark.pb.basic.v1.ChatTeamInfo;
import com.ss.android.lark.chat.entity.chat.TeamChatType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ModelParserChatTeamInfo$parseChatTeamInfoList$1 extends FunctionReferenceImpl implements Function1<ChatTeamInfo, com.ss.android.lark.chat.entity.chat.ChatTeamInfo> {
    public ModelParserChatTeamInfo$parseChatTeamInfoList$1(Object r100) {
        super(1, r100, ModelParserChatTeamInfo.class, "parseChatTeamInfo", "parseChatTeamInfo(Lcom/bytedance/lark/pb/basic/v1/ChatTeamInfo;)Lcom/ss/android/lark/chat/entity/chat/ChatTeamInfo;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final com.ss.android.lark.chat.entity.chat.ChatTeamInfo invoke2(ChatTeamInfo r100) {
        ModelParserChatTeamInfo r101 = ModelParserChatTeamInfo.f437609a;
        if (r100 == null) goto L5;
        Long r102 = r100.team_id;
    L6:
        if (r102 == null) goto L10;
        long r103 = r100.team_id.longValue();
        TeamChatType.a r104 = TeamChatType.Companion;
        int r105 = r100.team_chat_type.getValue();
        r104.getClass();
        return new com.ss.android.lark.chat.entity.chat.ChatTeamInfo(r103, TeamChatType.a.a(r105), r100.discoverable.booleanValue());
    L10:
        return null;
    L5:
        r102 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ com.ss.android.lark.chat.entity.chat.ChatTeamInfo invoke(ChatTeamInfo r100) {
        return invoke2(r100);
    }
}
