package com.larus.tts;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/tts/TtsInterceptResult;", "", "<init>", "(Ljava/lang/String;I)V", "Pass", "Deny", "ForcePlay", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TtsInterceptResult extends Enum<TtsInterceptResult> {
    public static final TtsInterceptResult Deny = null;
    public static final TtsInterceptResult ForcePlay = null;
    public static final TtsInterceptResult Pass = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TtsInterceptResult[] f370174a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f370175b = null;

    public static EnumEntries<TtsInterceptResult> getEntries() {
        return f370175b;
    }

    static {
        TtsInterceptResult r100 = new TtsInterceptResult("Pass", 0);
        Pass = r100;
        TtsInterceptResult r101 = new TtsInterceptResult("Deny", 1);
        Deny = r101;
        TtsInterceptResult r102 = new TtsInterceptResult("ForcePlay", 2);
        ForcePlay = r102;
        TtsInterceptResult[] r103 = {r100, r101, r102};
        f370174a = r103;
        f370175b = EnumEntriesKt.enumEntries(r103);
    }

    public static TtsInterceptResult[] values() {
        return (TtsInterceptResult[]) f370174a.clone();
    }

    public static TtsInterceptResult valueOf(String r100) {
        return (TtsInterceptResult) a.a(TtsInterceptResult.class, r100);
    }

    public TtsInterceptResult(String r100, int r101) {
        super(r100, r101);
    }
}
