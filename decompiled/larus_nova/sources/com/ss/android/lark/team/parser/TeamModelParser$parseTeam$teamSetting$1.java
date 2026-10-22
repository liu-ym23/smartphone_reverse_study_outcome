package com.ss.android.lark.team.parser;

import com.bytedance.lark.pb.basic.v1.TeamSetting;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class TeamModelParser$parseTeam$teamSetting$1 extends FunctionReferenceImpl implements Function1<TeamSetting, com.ss.android.lark.team.entity.TeamSetting> {
    public TeamModelParser$parseTeam$teamSetting$1(Object r100) {
        super(1, r100, TeamModelParser.class, "parseTeamSetting", "parseTeamSetting(Lcom/bytedance/lark/pb/basic/v1/TeamSetting;)Lcom/ss/android/lark/team/entity/TeamSetting;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final com.ss.android.lark.team.entity.TeamSetting invoke2(TeamSetting r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        TeamModelParser r101 = TeamModelParser.f441191a;
        Intrinsics.checkNotNullParameter(r100, "setting");
        TeamSetting.AddMemberPermission.Type r102 = r100.add_member_permission;
        if (r102 == null) goto L11;
        com.ss.android.lark.team.entity.TeamSetting.AddMemberPermission.a r103 = com.ss.android.lark.team.entity.TeamSetting.AddMemberPermission.Companion;
        int r104 = r102.getValue();
        r103.getClass();
        if (r104 == 1) goto L9;
        if (r104 == 2) goto L8;
        com.ss.android.lark.team.entity.TeamSetting.AddMemberPermission r105 = com.ss.android.lark.team.entity.TeamSetting.AddMemberPermission.UNKNOWN;
    L10:
        if (r105 == null) goto L11;
    L12:
        TeamSetting.AddTeamChatPermission.Type r106 = r100.add_team_chat_permission;
        if (r106 == null) goto L21;
        com.ss.android.lark.team.entity.TeamSetting.AddTeamChatPermission.a r107 = com.ss.android.lark.team.entity.TeamSetting.AddTeamChatPermission.Companion;
        int r108 = r106.getValue();
        r107.getClass();
        if (r108 == 1) goto L19;
        if (r108 == 2) goto L18;
        com.ss.android.lark.team.entity.TeamSetting.AddTeamChatPermission r109 = com.ss.android.lark.team.entity.TeamSetting.AddTeamChatPermission.UNKNOWN;
    L20:
        if (r109 == null) goto L21;
    L22:
        TeamSetting.AddPrivateTeamChatPermission.Type r110 = r100.add_private_team_chat_permission;
        if (r110 == null) goto L31;
        com.ss.android.lark.team.entity.TeamSetting.AddPrivateTeamChatPermission.a r111 = com.ss.android.lark.team.entity.TeamSetting.AddPrivateTeamChatPermission.Companion;
        int r112 = r110.getValue();
        r111.getClass();
        if (r112 == 1) goto L29;
        if (r112 == 2) goto L28;
        com.ss.android.lark.team.entity.TeamSetting.AddPrivateTeamChatPermission r113 = com.ss.android.lark.team.entity.TeamSetting.AddPrivateTeamChatPermission.UNKNOWN;
    L30:
        if (r113 == null) goto L31;
    L33:
        return new com.ss.android.lark.team.entity.TeamSetting(r105, r109, r113);
    L28:
        r113 = com.ss.android.lark.team.entity.TeamSetting.AddPrivateTeamChatPermission.ONLY_MANAGER;
        goto L30
    L29:
        r113 = com.ss.android.lark.team.entity.TeamSetting.AddPrivateTeamChatPermission.ALL_MEMBERS;
    L31:
        r113 = com.ss.android.lark.team.entity.TeamSetting.AddPrivateTeamChatPermission.UNKNOWN;
        goto L33
    L18:
        r109 = com.ss.android.lark.team.entity.TeamSetting.AddTeamChatPermission.ONLY_MANAGER;
        goto L20
    L19:
        r109 = com.ss.android.lark.team.entity.TeamSetting.AddTeamChatPermission.ALL_MEMBERS;
    L21:
        r109 = com.ss.android.lark.team.entity.TeamSetting.AddTeamChatPermission.UNKNOWN;
        goto L22
    L8:
        r105 = com.ss.android.lark.team.entity.TeamSetting.AddMemberPermission.ONLY_OWNER;
        goto L10
    L9:
        r105 = com.ss.android.lark.team.entity.TeamSetting.AddMemberPermission.ALL_MEMBERS;
    L11:
        r105 = com.ss.android.lark.team.entity.TeamSetting.AddMemberPermission.UNKNOWN;
        goto L12
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ com.ss.android.lark.team.entity.TeamSetting invoke(TeamSetting r100) {
        return invoke2(r100);
    }
}
