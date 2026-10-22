package com.larus.reach.api;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/reach/api/ReachButtonType;", "", "<init>", "(Ljava/lang/String;I)V", EffectConstants.NORMAL, "CLOSE", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReachButtonType extends Enum<ReachButtonType> {
    public static final ReachButtonType CLOSE = null;
    public static final ReachButtonType NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReachButtonType[] f367119a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f367120b = null;

    public static EnumEntries<ReachButtonType> getEntries() {
        return f367120b;
    }

    static {
        ReachButtonType r100 = new ReachButtonType(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        ReachButtonType r101 = new ReachButtonType("CLOSE", 1);
        CLOSE = r101;
        ReachButtonType[] r102 = {r100, r101};
        f367119a = r102;
        f367120b = EnumEntriesKt.enumEntries(r102);
    }

    public static ReachButtonType[] values() {
        return (ReachButtonType[]) f367119a.clone();
    }

    public static ReachButtonType valueOf(String r100) {
        return (ReachButtonType) a.a(ReachButtonType.class, r100);
    }

    public ReachButtonType(String r100, int r101) {
        super(r100, r101);
    }
}
