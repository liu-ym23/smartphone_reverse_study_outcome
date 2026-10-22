package com.larus.trace;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/trace/RealTimeNavErrorType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", FeatureConfigInfo.PUSH_FEATURE_TYPE_ID, "TTS", "trace_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RealTimeNavErrorType extends Enum<RealTimeNavErrorType> {
    public static final RealTimeNavErrorType PUSH = null;
    public static final RealTimeNavErrorType TTS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RealTimeNavErrorType[] f370147a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f370148b = null;
    private final String value;

    public static EnumEntries<RealTimeNavErrorType> getEntries() {
        return f370148b;
    }

    static {
        RealTimeNavErrorType r100 = new RealTimeNavErrorType(FeatureConfigInfo.PUSH_FEATURE_TYPE_ID, 0, "push");
        PUSH = r100;
        RealTimeNavErrorType r101 = new RealTimeNavErrorType("TTS", 1, "tts");
        TTS = r101;
        RealTimeNavErrorType[] r102 = {r100, r101};
        f370147a = r102;
        f370148b = EnumEntriesKt.enumEntries(r102);
    }

    public static RealTimeNavErrorType[] values() {
        return (RealTimeNavErrorType[]) f370147a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static RealTimeNavErrorType valueOf(String r100) {
        return (RealTimeNavErrorType) a.a(RealTimeNavErrorType.class, r100);
    }

    public RealTimeNavErrorType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
