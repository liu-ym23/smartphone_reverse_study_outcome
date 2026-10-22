package com.bytedance.locallife.groupon.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/locallife/groupon/model/LeaveType;", "", "CHANGE_CITY", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum LeaveType extends Enum<LeaveType> {
    public static final LeaveType CHANGE_CITY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LeaveType[] f258805a = null;

    public static LeaveType valueOf(String r100) {
        return (LeaveType) a.a(LeaveType.class, r100);
    }

    public static LeaveType[] values() {
        return (LeaveType[]) f258805a.clone();
    }

    static {
        LeaveType r100 = new LeaveType();
        CHANGE_CITY = r100;
        f258805a = new LeaveType[]{r100};
    }

    public LeaveType() {
        super("CHANGE_CITY", 0);
    }
}
