package com.bytedance.android.shopping.commentv3.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/data/GroupType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "TAB", "CONTENT", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GroupType extends Enum<GroupType> {
    public static final GroupType CONTENT = null;
    public static final GroupType TAB = null;
    public static final /* synthetic */ GroupType[] a = null;
    private final String type;

    static {
        GroupType r1 = new GroupType("TAB", 0, "commentTabGroup");
        TAB = r1;
        GroupType r2 = new GroupType("CONTENT", 1, "commentContentGroup");
        CONTENT = r2;
        a = new GroupType[]{r1, r2};
    }

    public static GroupType valueOf(String r1) {
        return (GroupType) r27.a.a(GroupType.class, r1);
    }

    public static GroupType[] values() {
        return (GroupType[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public GroupType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
