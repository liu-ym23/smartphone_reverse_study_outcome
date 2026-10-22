package com.larus.voicecall.impl.tracer;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/larus/voicecall/impl/tracer/ReplyAudioEventType;", "", "kind", "Lcom/larus/voicecall/impl/tracer/VoiceCallTraceReplyType;", "phase", "Lcom/larus/voicecall/impl/tracer/ReplyAudioPhase;", "eventType", "", "what", "<init>", "(Ljava/lang/String;ILcom/larus/voicecall/impl/tracer/VoiceCallTraceReplyType;Lcom/larus/voicecall/impl/tracer/ReplyAudioPhase;Ljava/lang/String;Ljava/lang/String;)V", "getKind", "()Lcom/larus/voicecall/impl/tracer/VoiceCallTraceReplyType;", "getPhase", "()Lcom/larus/voicecall/impl/tracer/ReplyAudioPhase;", "getEventType", "()Ljava/lang/String;", "getWhat", "REPLY_BEGIN", "REPLY_END", "CHIME_IN_START", "CHIME_IN_END", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReplyAudioEventType extends Enum<ReplyAudioEventType> {
    public static final ReplyAudioEventType CHIME_IN_END = null;
    public static final ReplyAudioEventType CHIME_IN_START = null;
    public static final ReplyAudioEventType REPLY_BEGIN = null;
    public static final ReplyAudioEventType REPLY_END = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReplyAudioEventType[] f379090a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f379091b = null;
    private final String eventType;
    private final VoiceCallTraceReplyType kind;
    private final ReplyAudioPhase phase;
    private final String what;

    public static EnumEntries<ReplyAudioEventType> getEntries() {
        return f379091b;
    }

    static {
        VoiceCallTraceReplyType r110 = VoiceCallTraceReplyType.REPLY;
        ReplyAudioPhase r111 = ReplyAudioPhase.BEGIN;
        ReplyAudioEventType r100 = new ReplyAudioEventType("REPLY_BEGIN", 0, r110, r111, "replyBegin", "reply.audio.begin");
        REPLY_BEGIN = r100;
        ReplyAudioPhase r210 = ReplyAudioPhase.END;
        ReplyAudioEventType r101 = new ReplyAudioEventType("REPLY_END", 1, r110, r210, "replyEnd", "reply.audio.end");
        REPLY_END = r101;
        VoiceCallTraceReplyType r211 = VoiceCallTraceReplyType.CHIME_IN;
        ReplyAudioEventType r102 = new ReplyAudioEventType("CHIME_IN_START", 2, r211, r111, "chimeInStart", "reply.audio.begin");
        CHIME_IN_START = r102;
        ReplyAudioEventType r103 = new ReplyAudioEventType("CHIME_IN_END", 3, r211, r210, "chimeInEnd", "reply.audio.end");
        CHIME_IN_END = r103;
        ReplyAudioEventType[] r104 = {r100, r101, r102, r103};
        f379090a = r104;
        f379091b = EnumEntriesKt.enumEntries(r104);
    }

    public static ReplyAudioEventType[] values() {
        return (ReplyAudioEventType[]) f379090a.clone();
    }

    public final String getEventType() {
        return this.eventType;
    }

    public final VoiceCallTraceReplyType getKind() {
        return this.kind;
    }

    public final ReplyAudioPhase getPhase() {
        return this.phase;
    }

    public final String getWhat() {
        return this.what;
    }

    public static ReplyAudioEventType valueOf(String r100) {
        return (ReplyAudioEventType) r27.a.a(ReplyAudioEventType.class, r100);
    }

    public ReplyAudioEventType(String r100, int r101, VoiceCallTraceReplyType r102, ReplyAudioPhase r103, String r104, String r105) {
        super(r100, r101);
        this.kind = r102;
        this.phase = r103;
        this.eventType = r104;
        this.what = r105;
    }
}
