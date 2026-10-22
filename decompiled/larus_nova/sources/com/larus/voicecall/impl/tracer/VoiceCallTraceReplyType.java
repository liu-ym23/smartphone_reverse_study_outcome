package com.larus.voicecall.impl.tracer;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/voicecall/impl/tracer/VoiceCallTraceReplyType;", "", "<init>", "(Ljava/lang/String;I)V", "REPLY", "CHIME_IN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceCallTraceReplyType extends Enum<VoiceCallTraceReplyType> {
    public static final VoiceCallTraceReplyType CHIME_IN = null;
    public static final VoiceCallTraceReplyType REPLY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceCallTraceReplyType[] f379111a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f379112b = null;

    public static EnumEntries<VoiceCallTraceReplyType> getEntries() {
        return f379112b;
    }

    static {
        VoiceCallTraceReplyType r100 = new VoiceCallTraceReplyType("REPLY", 0);
        REPLY = r100;
        VoiceCallTraceReplyType r101 = new VoiceCallTraceReplyType("CHIME_IN", 1);
        CHIME_IN = r101;
        VoiceCallTraceReplyType[] r102 = {r100, r101};
        f379111a = r102;
        f379112b = EnumEntriesKt.enumEntries(r102);
    }

    public static VoiceCallTraceReplyType[] values() {
        return (VoiceCallTraceReplyType[]) f379111a.clone();
    }

    public static VoiceCallTraceReplyType valueOf(String r100) {
        return (VoiceCallTraceReplyType) r27.a.a(VoiceCallTraceReplyType.class, r100);
    }

    public VoiceCallTraceReplyType(String r100, int r101) {
        super(r100, r101);
    }
}
