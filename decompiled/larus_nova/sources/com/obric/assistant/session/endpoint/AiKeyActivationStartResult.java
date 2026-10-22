package com.obric.assistant.session.endpoint;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/session/endpoint/AiKeyActivationStartResult;", "", "<init>", "(Ljava/lang/String;I)V", "STARTED", "DEFERRED", "FAILED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AiKeyActivationStartResult extends Enum<AiKeyActivationStartResult> {
    public static final AiKeyActivationStartResult DEFERRED = null;
    public static final AiKeyActivationStartResult FAILED = null;
    public static final AiKeyActivationStartResult STARTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AiKeyActivationStartResult[] f391497a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f391498b = null;

    public static EnumEntries<AiKeyActivationStartResult> getEntries() {
        return f391498b;
    }

    static {
        AiKeyActivationStartResult r100 = new AiKeyActivationStartResult("STARTED", 0);
        STARTED = r100;
        AiKeyActivationStartResult r101 = new AiKeyActivationStartResult("DEFERRED", 1);
        DEFERRED = r101;
        AiKeyActivationStartResult r102 = new AiKeyActivationStartResult("FAILED", 2);
        FAILED = r102;
        AiKeyActivationStartResult[] r103 = {r100, r101, r102};
        f391497a = r103;
        f391498b = EnumEntriesKt.enumEntries(r103);
    }

    public static AiKeyActivationStartResult[] values() {
        return (AiKeyActivationStartResult[]) f391497a.clone();
    }

    public static AiKeyActivationStartResult valueOf(String r100) {
        return (AiKeyActivationStartResult) r27.a.a(AiKeyActivationStartResult.class, r100);
    }

    public AiKeyActivationStartResult(String r100, int r101) {
        super(r100, r101);
    }
}
