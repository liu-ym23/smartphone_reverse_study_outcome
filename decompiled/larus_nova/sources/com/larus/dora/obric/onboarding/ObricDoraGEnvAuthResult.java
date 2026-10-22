package com.larus.dora.obric.onboarding;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/obric/onboarding/ObricDoraGEnvAuthResult;", "", "<init>", "(Ljava/lang/String;I)V", "AUTHORIZED", "CANCELED", "FAILED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricDoraGEnvAuthResult extends Enum<ObricDoraGEnvAuthResult> {
    public static final ObricDoraGEnvAuthResult AUTHORIZED = null;
    public static final ObricDoraGEnvAuthResult CANCELED = null;
    public static final ObricDoraGEnvAuthResult FAILED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ObricDoraGEnvAuthResult[] f340715a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f340716b = null;

    public static EnumEntries<ObricDoraGEnvAuthResult> getEntries() {
        return f340716b;
    }

    static {
        ObricDoraGEnvAuthResult r100 = new ObricDoraGEnvAuthResult("AUTHORIZED", 0);
        AUTHORIZED = r100;
        ObricDoraGEnvAuthResult r101 = new ObricDoraGEnvAuthResult("CANCELED", 1);
        CANCELED = r101;
        ObricDoraGEnvAuthResult r102 = new ObricDoraGEnvAuthResult("FAILED", 2);
        FAILED = r102;
        ObricDoraGEnvAuthResult[] r103 = {r100, r101, r102};
        f340715a = r103;
        f340716b = EnumEntriesKt.enumEntries(r103);
    }

    public static ObricDoraGEnvAuthResult[] values() {
        return (ObricDoraGEnvAuthResult[]) f340715a.clone();
    }

    public static ObricDoraGEnvAuthResult valueOf(String r100) {
        return (ObricDoraGEnvAuthResult) r27.a.a(ObricDoraGEnvAuthResult.class, r100);
    }

    public ObricDoraGEnvAuthResult(String r100, int r101) {
        super(r100, r101);
    }
}
