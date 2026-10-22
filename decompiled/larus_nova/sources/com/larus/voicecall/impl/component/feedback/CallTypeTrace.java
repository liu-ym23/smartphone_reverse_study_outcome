package com.larus.voicecall.impl.component.feedback;

import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/voicecall/impl/component/feedback/CallTypeTrace;", "", "callType", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getCallType", "()Ljava/lang/String;", "Video", ServiceType.AUDIO, "Screen", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CallTypeTrace extends Enum<CallTypeTrace> {
    public static final CallTypeTrace Audio = null;
    public static final CallTypeTrace Screen = null;
    public static final CallTypeTrace Video = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CallTypeTrace[] f377422a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f377423b = null;
    private final String callType;

    public static EnumEntries<CallTypeTrace> getEntries() {
        return f377423b;
    }

    static {
        CallTypeTrace r100 = new CallTypeTrace("Video", 0, "video");
        Video = r100;
        CallTypeTrace r101 = new CallTypeTrace(ServiceType.AUDIO, 1, "audio");
        Audio = r101;
        CallTypeTrace r102 = new CallTypeTrace("Screen", 2, "screen");
        Screen = r102;
        CallTypeTrace[] r103 = {r100, r101, r102};
        f377422a = r103;
        f377423b = EnumEntriesKt.enumEntries(r103);
    }

    public static CallTypeTrace[] values() {
        return (CallTypeTrace[]) f377422a.clone();
    }

    public final String getCallType() {
        return this.callType;
    }

    public static CallTypeTrace valueOf(String r100) {
        return (CallTypeTrace) r27.a.a(CallTypeTrace.class, r100);
    }

    public CallTypeTrace(String r100, int r101, String r102) {
        super(r100, r101);
        this.callType = r102;
    }
}
