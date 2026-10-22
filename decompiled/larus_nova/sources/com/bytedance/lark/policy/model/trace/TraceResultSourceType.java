package com.bytedance.lark.policy.model.trace;

import com.obric.miniapp.alarm.AccountType;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/lark/policy/model/trace/TraceResultSourceType;", "", "code", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "FAST_PASS", AccountType.LOCAL, "REMOTE", "DOWNGRADE", "policy-engine_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TraceResultSourceType extends Enum<TraceResultSourceType> {
    public static final TraceResultSourceType DOWNGRADE = null;
    public static final TraceResultSourceType FAST_PASS = null;
    public static final TraceResultSourceType LOCAL = null;
    public static final TraceResultSourceType REMOTE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TraceResultSourceType[] f253866a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f253867b = null;
    private final String code;

    public static EnumEntries<TraceResultSourceType> getEntries() {
        return f253867b;
    }

    static {
        TraceResultSourceType r100 = new TraceResultSourceType("FAST_PASS", 0, "fast_pass");
        FAST_PASS = r100;
        TraceResultSourceType r101 = new TraceResultSourceType(AccountType.LOCAL, 1, "local");
        LOCAL = r101;
        TraceResultSourceType r102 = new TraceResultSourceType("REMOTE", 2, "remote");
        REMOTE = r102;
        TraceResultSourceType r103 = new TraceResultSourceType("DOWNGRADE", 3, GearStrategyConsts.EV_DOWNGRADE_TYPE);
        DOWNGRADE = r103;
        TraceResultSourceType[] r104 = {r100, r101, r102, r103};
        f253866a = r104;
        f253867b = EnumEntriesKt.enumEntries(r104);
    }

    public static TraceResultSourceType[] values() {
        return (TraceResultSourceType[]) f253866a.clone();
    }

    public final String getCode() {
        return this.code;
    }

    public static TraceResultSourceType valueOf(String r100) {
        return (TraceResultSourceType) a.a(TraceResultSourceType.class, r100);
    }

    public TraceResultSourceType(String r100, int r101, String r102) {
        super(r100, r101);
        this.code = r102;
    }
}
