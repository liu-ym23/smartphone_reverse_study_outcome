package com.bytedance.locallife.groupon.api.undertake.msgreacheffect;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/groupon/api/undertake/msgreacheffect/GrouponToolBadgeType;", "", "", "style", "Ljava/lang/String;", "getStyle", "()Ljava/lang/String;", "NORMAL_DOT", "TEXT_DOT", "NUMBER_DOT", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum GrouponToolBadgeType extends Enum<GrouponToolBadgeType> {
    public static final GrouponToolBadgeType NORMAL_DOT = null;
    public static final GrouponToolBadgeType NUMBER_DOT = null;
    public static final GrouponToolBadgeType TEXT_DOT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GrouponToolBadgeType[] f258789a = null;
    private final String style;

    public static GrouponToolBadgeType valueOf(String r100) {
        return (GrouponToolBadgeType) a.a(GrouponToolBadgeType.class, r100);
    }

    public static GrouponToolBadgeType[] values() {
        return (GrouponToolBadgeType[]) f258789a.clone();
    }

    static {
        GrouponToolBadgeType r100 = new GrouponToolBadgeType("NORMAL_DOT", 0, "normal_dot");
        NORMAL_DOT = r100;
        GrouponToolBadgeType r101 = new GrouponToolBadgeType("TEXT_DOT", 1, "text_dot");
        TEXT_DOT = r101;
        GrouponToolBadgeType r102 = new GrouponToolBadgeType("NUMBER_DOT", 2, "num_dot");
        NUMBER_DOT = r102;
        f258789a = new GrouponToolBadgeType[]{r100, r101, r102};
    }

    public final String getStyle() {
        return this.style;
    }

    public GrouponToolBadgeType(String r100, int r101, String r102) {
        super(r100, r101);
        this.style = r102;
    }
}
