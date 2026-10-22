package com.ss.android.lark.passport.flow.mfa;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/passport/flow/mfa/ExternalBidpCallbackPhase;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "WAITING_CALLBACK", "RESUMED_WAITING_CALLBACK", "DISPATCHING", "TIMED_OUT", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum ExternalBidpCallbackPhase extends Enum<ExternalBidpCallbackPhase> {
    public static final ExternalBidpCallbackPhase DISPATCHING = null;
    public static final ExternalBidpCallbackPhase IDLE = null;
    public static final ExternalBidpCallbackPhase RESUMED_WAITING_CALLBACK = null;
    public static final ExternalBidpCallbackPhase TIMED_OUT = null;
    public static final ExternalBidpCallbackPhase WAITING_CALLBACK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExternalBidpCallbackPhase[] f437816a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f437817b = null;

    public static EnumEntries<ExternalBidpCallbackPhase> getEntries() {
        return f437817b;
    }

    static {
        ExternalBidpCallbackPhase r100 = new ExternalBidpCallbackPhase("IDLE", 0);
        IDLE = r100;
        ExternalBidpCallbackPhase r101 = new ExternalBidpCallbackPhase("WAITING_CALLBACK", 1);
        WAITING_CALLBACK = r101;
        ExternalBidpCallbackPhase r102 = new ExternalBidpCallbackPhase("RESUMED_WAITING_CALLBACK", 2);
        RESUMED_WAITING_CALLBACK = r102;
        ExternalBidpCallbackPhase r103 = new ExternalBidpCallbackPhase("DISPATCHING", 3);
        DISPATCHING = r103;
        ExternalBidpCallbackPhase r104 = new ExternalBidpCallbackPhase("TIMED_OUT", 4);
        TIMED_OUT = r104;
        ExternalBidpCallbackPhase[] r105 = {r100, r101, r102, r103, r104};
        f437816a = r105;
        f437817b = EnumEntriesKt.enumEntries(r105);
    }

    public static ExternalBidpCallbackPhase[] values() {
        return (ExternalBidpCallbackPhase[]) f437816a.clone();
    }

    public static ExternalBidpCallbackPhase valueOf(String r100) {
        return (ExternalBidpCallbackPhase) r27.a.a(ExternalBidpCallbackPhase.class, r100);
    }

    public ExternalBidpCallbackPhase(String r100, int r101) {
        super(r100, r101);
    }
}
