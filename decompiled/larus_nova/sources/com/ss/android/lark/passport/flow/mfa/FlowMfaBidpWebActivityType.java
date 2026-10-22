package com.ss.android.lark.passport.flow.mfa;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/passport/flow/mfa/FlowMfaBidpWebActivityType;", "", "<init>", "(Ljava/lang/String;I)V", "INTERNAL_AUTH", "EXTERNAL_BROWSER_LOADING", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowMfaBidpWebActivityType extends Enum<FlowMfaBidpWebActivityType> {
    public static final FlowMfaBidpWebActivityType EXTERNAL_BROWSER_LOADING = null;
    public static final FlowMfaBidpWebActivityType INTERNAL_AUTH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowMfaBidpWebActivityType[] f437818a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f437819b = null;

    public static EnumEntries<FlowMfaBidpWebActivityType> getEntries() {
        return f437819b;
    }

    static {
        FlowMfaBidpWebActivityType r100 = new FlowMfaBidpWebActivityType("INTERNAL_AUTH", 0);
        INTERNAL_AUTH = r100;
        FlowMfaBidpWebActivityType r101 = new FlowMfaBidpWebActivityType("EXTERNAL_BROWSER_LOADING", 1);
        EXTERNAL_BROWSER_LOADING = r101;
        FlowMfaBidpWebActivityType[] r102 = {r100, r101};
        f437818a = r102;
        f437819b = EnumEntriesKt.enumEntries(r102);
    }

    public static FlowMfaBidpWebActivityType[] values() {
        return (FlowMfaBidpWebActivityType[]) f437818a.clone();
    }

    public static FlowMfaBidpWebActivityType valueOf(String r100) {
        return (FlowMfaBidpWebActivityType) r27.a.a(FlowMfaBidpWebActivityType.class, r100);
    }

    public FlowMfaBidpWebActivityType(String r100, int r101) {
        super(r100, r101);
    }
}
