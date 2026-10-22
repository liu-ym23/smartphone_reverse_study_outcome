package com.larus.reach.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/larus/reach/api/ReachPresentationCapability;", "", "<init>", "(Ljava/lang/String;I)V", "APPLICATION_OVERLAY", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReachPresentationCapability extends Enum<ReachPresentationCapability> {
    public static final ReachPresentationCapability APPLICATION_OVERLAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReachPresentationCapability[] f367131a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f367132b = null;

    public static EnumEntries<ReachPresentationCapability> getEntries() {
        return f367132b;
    }

    static {
        ReachPresentationCapability r100 = new ReachPresentationCapability();
        APPLICATION_OVERLAY = r100;
        ReachPresentationCapability[] r101 = {r100};
        f367131a = r101;
        f367132b = EnumEntriesKt.enumEntries(r101);
    }

    public ReachPresentationCapability() {
        super("APPLICATION_OVERLAY", 0);
    }

    public static ReachPresentationCapability[] values() {
        return (ReachPresentationCapability[]) f367131a.clone();
    }

    public static ReachPresentationCapability valueOf(String r100) {
        return (ReachPresentationCapability) a.a(ReachPresentationCapability.class, r100);
    }
}
