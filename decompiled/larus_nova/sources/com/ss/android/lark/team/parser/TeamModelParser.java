package com.ss.android.lark.team.parser;

import com.ss.android.lark.chat.entity.Item;
import com.ss.android.lark.team.entity.TeamRole;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class TeamModelParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TeamModelParser f441191a = null;

    static {
        f441191a = new TeamModelParser();
    }

    public TeamModelParser() {
    }

    @JvmStatic
    public static final List<Item> a(List<com.bytedance.lark.pb.basic.v1.Item> r100) {
        if (r100 == null) goto L7;
        List<com.bytedance.lark.pb.basic.v1.Item> r101 = r100;
        TeamModelParser$parseItems$1 r102 = new TeamModelParser$parseItems$1(f441191a);
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r104 = r101.iterator();
    L5:
        if (r104.hasNext() == false) goto L10;
        r103.add(r102.invoke(r104.next()));
        goto L5
    L10:
        return r103;
    L7:
        return null;
    }

    @JvmStatic
    public static final TeamRole b(com.bytedance.lark.pb.basic.v1.TeamRole r100) {
        Intrinsics.checkNotNullParameter(r100, "teamRole");
        com.bytedance.lark.pb.basic.v1.TeamRole.RoleType r101 = r100.role_type;
        if (r101 == null) goto L13;
        TeamRole.a r102 = TeamRole.Companion;
        int r103 = r101.getValue();
        r102.getClass();
        TeamRole r104 = TeamRole.OWNER;
        if (r103 == r104.getValue()) goto L11;
        r104 = TeamRole.ADMIN;
        if (r103 == r104.getValue()) goto L11;
        r104 = TeamRole.UNKNOWN;
    L11:
        if (r104 == null) goto L13;
        return r104;
    L13:
        return TeamRole.UNKNOWN;
    }
}
