package com.bytedance.locallife.groupon.struct.performance;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/performance/GrouponDevicePerfLevel;", "", "Low", "Medium", "High", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum GrouponDevicePerfLevel extends Enum<GrouponDevicePerfLevel> {
    public static final GrouponDevicePerfLevel High = null;
    public static final GrouponDevicePerfLevel Low = null;
    public static final GrouponDevicePerfLevel Medium = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GrouponDevicePerfLevel[] f258845a = null;

    public static GrouponDevicePerfLevel valueOf(String r100) {
        return (GrouponDevicePerfLevel) a.a(GrouponDevicePerfLevel.class, r100);
    }

    public static GrouponDevicePerfLevel[] values() {
        return (GrouponDevicePerfLevel[]) f258845a.clone();
    }

    static {
        GrouponDevicePerfLevel r100 = new GrouponDevicePerfLevel("Low", 0);
        Low = r100;
        GrouponDevicePerfLevel r101 = new GrouponDevicePerfLevel("Medium", 1);
        Medium = r101;
        GrouponDevicePerfLevel r102 = new GrouponDevicePerfLevel("High", 2);
        High = r102;
        f258845a = new GrouponDevicePerfLevel[]{r100, r101, r102};
    }

    public GrouponDevicePerfLevel(String r100, int r101) {
        super(r100, r101);
    }
}
