package com.ss.android.lark.team.parser;

import com.bytedance.lark.pb.basic.v1.TeamRole;
import com.bytedance.lark.pb.basic.v1.TeamUserEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class TeamModelParser$parseTeam$userEntity$1 extends FunctionReferenceImpl implements Function1<TeamUserEntity, com.ss.android.lark.team.entity.TeamUserEntity> {
    public TeamModelParser$parseTeam$userEntity$1(Object r100) {
        super(1, r100, TeamModelParser.class, "parseTeamUserEntity", "parseTeamUserEntity(Lcom/bytedance/lark/pb/basic/v1/TeamUserEntity;)Lcom/ss/android/lark/team/entity/TeamUserEntity;", 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.util.ArrayList] */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final com.ss.android.lark.team.entity.TeamUserEntity invoke2(TeamUserEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        TeamModelParser r101 = TeamModelParser.f441191a;
        Intrinsics.checkNotNullParameter(r100, "entity");
        List<TeamRole> r102 = r100.user_roles;
        if (r102 == null) goto L8;
        List<TeamRole> r103 = r102;
        TeamModelParser$parseTeamUserEntity$userRoles$1 r104 = new TeamModelParser$parseTeamUserEntity$userRoles$1(TeamModelParser.f441191a);
        List r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r106 = r103.iterator();
    L6:
        if (r106.hasNext() == false) goto L9;
        r105.add(r104.invoke(r106.next()));
    L9:
        if (r105 != 0) goto L12;
        r105 = CollectionsKt.emptyList();
    L12:
        return new com.ss.android.lark.team.entity.TeamUserEntity(r105, r100.version);
    L8:
        r105 = 0;
        goto L9
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ com.ss.android.lark.team.entity.TeamUserEntity invoke(TeamUserEntity r100) {
        return invoke2(r100);
    }
}
