package com.ss.android.lark.team.parser;

import com.bytedance.lark.pb.basic.v1.TeamRole;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class TeamModelParser$parseTeamUserEntity$userRoles$1 extends FunctionReferenceImpl implements Function1<TeamRole, com.ss.android.lark.team.entity.TeamRole> {
    public TeamModelParser$parseTeamUserEntity$userRoles$1(Object r100) {
        super(1, r100, TeamModelParser.class, "parseTeamRole", "parseTeamRole(Lcom/bytedance/lark/pb/basic/v1/TeamRole;)Lcom/ss/android/lark/team/entity/TeamRole;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final com.ss.android.lark.team.entity.TeamRole invoke2(TeamRole r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        return TeamModelParser.b(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ com.ss.android.lark.team.entity.TeamRole invoke(TeamRole r100) {
        return invoke2(r100);
    }
}
