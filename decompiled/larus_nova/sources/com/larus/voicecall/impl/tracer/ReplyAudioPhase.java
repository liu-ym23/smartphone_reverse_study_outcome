package com.larus.voicecall.impl.tracer;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/voicecall/impl/tracer/ReplyAudioPhase;", "", "<init>", "(Ljava/lang/String;I)V", "BEGIN", GXAnimation.STATE_END, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReplyAudioPhase extends Enum<ReplyAudioPhase> {
    public static final ReplyAudioPhase BEGIN = null;
    public static final ReplyAudioPhase END = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReplyAudioPhase[] f379092a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f379093b = null;

    public static EnumEntries<ReplyAudioPhase> getEntries() {
        return f379093b;
    }

    static {
        ReplyAudioPhase r100 = new ReplyAudioPhase("BEGIN", 0);
        BEGIN = r100;
        ReplyAudioPhase r101 = new ReplyAudioPhase(GXAnimation.STATE_END, 1);
        END = r101;
        ReplyAudioPhase[] r102 = {r100, r101};
        f379092a = r102;
        f379093b = EnumEntriesKt.enumEntries(r102);
    }

    public static ReplyAudioPhase[] values() {
        return (ReplyAudioPhase[]) f379092a.clone();
    }

    public static ReplyAudioPhase valueOf(String r100) {
        return (ReplyAudioPhase) r27.a.a(ReplyAudioPhase.class, r100);
    }

    public ReplyAudioPhase(String r100, int r101) {
        super(r100, r101);
    }
}
