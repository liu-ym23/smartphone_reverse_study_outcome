package com.larus.bmhome.social.userchat.start.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/larus/bmhome/social/userchat/start/core/StartTaskExecTime;", "", "<init>", "(Ljava/lang/String;I)V", "BEFORE_MAIN_ACTIVITY_SUPER_ON_CREATED", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum StartTaskExecTime extends Enum<StartTaskExecTime> {
    public static final StartTaskExecTime BEFORE_MAIN_ACTIVITY_SUPER_ON_CREATED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StartTaskExecTime[] f314184a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f314185b = null;

    public static EnumEntries<StartTaskExecTime> getEntries() {
        return f314185b;
    }

    static {
        StartTaskExecTime r100 = new StartTaskExecTime();
        BEFORE_MAIN_ACTIVITY_SUPER_ON_CREATED = r100;
        StartTaskExecTime[] r101 = {r100};
        f314184a = r101;
        f314185b = EnumEntriesKt.enumEntries(r101);
    }

    public StartTaskExecTime() {
        super("BEFORE_MAIN_ACTIVITY_SUPER_ON_CREATED", 0);
    }

    public static StartTaskExecTime[] values() {
        return (StartTaskExecTime[]) f314184a.clone();
    }

    public static StartTaskExecTime valueOf(String r100) {
        return (StartTaskExecTime) a.a(StartTaskExecTime.class, r100);
    }
}
