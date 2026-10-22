package com.larus.bmhome.chat.quickreply;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/quickreply/MoaGrantingDecision;", "", "<init>", "(Ljava/lang/String;I)V", "ALLOW", "REFUSE", "UNSUPPORTED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MoaGrantingDecision extends Enum<MoaGrantingDecision> {
    public static final MoaGrantingDecision ALLOW = null;
    public static final MoaGrantingDecision REFUSE = null;
    public static final MoaGrantingDecision UNSUPPORTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MoaGrantingDecision[] f308484a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f308485b = null;

    public static EnumEntries<MoaGrantingDecision> getEntries() {
        return f308485b;
    }

    static {
        MoaGrantingDecision r100 = new MoaGrantingDecision("ALLOW", 0);
        ALLOW = r100;
        MoaGrantingDecision r101 = new MoaGrantingDecision("REFUSE", 1);
        REFUSE = r101;
        MoaGrantingDecision r102 = new MoaGrantingDecision("UNSUPPORTED", 2);
        UNSUPPORTED = r102;
        MoaGrantingDecision[] r103 = {r100, r101, r102};
        f308484a = r103;
        f308485b = EnumEntriesKt.enumEntries(r103);
    }

    public static MoaGrantingDecision[] values() {
        return (MoaGrantingDecision[]) f308484a.clone();
    }

    public static MoaGrantingDecision valueOf(String r100) {
        return (MoaGrantingDecision) a.a(MoaGrantingDecision.class, r100);
    }

    public MoaGrantingDecision(String r100, int r101) {
        super(r100, r101);
    }
}
