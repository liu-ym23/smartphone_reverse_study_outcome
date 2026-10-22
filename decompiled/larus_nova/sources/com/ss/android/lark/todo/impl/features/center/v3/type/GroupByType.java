package com.ss.android.lark.todo.impl.features.center.v3.type;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/type/GroupByType;", "", "<init>", "(Ljava/lang/String;I)V", "CREATOR_GROUP_BY", "DUE_TIME_GROUP_BY", "SOURCE_GROUP_BY", "DEFINED_GROUP_BY", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GroupByType extends Enum<GroupByType> {
    public static final GroupByType CREATOR_GROUP_BY = null;
    public static final GroupByType DEFINED_GROUP_BY = null;
    public static final GroupByType DUE_TIME_GROUP_BY = null;
    public static final GroupByType SOURCE_GROUP_BY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GroupByType[] f441764a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f441765b = null;

    public static EnumEntries<GroupByType> getEntries() {
        return f441765b;
    }

    static {
        GroupByType r100 = new GroupByType("CREATOR_GROUP_BY", 0);
        CREATOR_GROUP_BY = r100;
        GroupByType r101 = new GroupByType("DUE_TIME_GROUP_BY", 1);
        DUE_TIME_GROUP_BY = r101;
        GroupByType r102 = new GroupByType("SOURCE_GROUP_BY", 2);
        SOURCE_GROUP_BY = r102;
        GroupByType r103 = new GroupByType("DEFINED_GROUP_BY", 3);
        DEFINED_GROUP_BY = r103;
        GroupByType[] r104 = {r100, r101, r102, r103};
        f441764a = r104;
        f441765b = EnumEntriesKt.enumEntries(r104);
    }

    public static GroupByType[] values() {
        return (GroupByType[]) f441764a.clone();
    }

    public static GroupByType valueOf(String r100) {
        return (GroupByType) a.a(GroupByType.class, r100);
    }

    public GroupByType(String r100, int r101) {
        super(r100, r101);
    }
}
