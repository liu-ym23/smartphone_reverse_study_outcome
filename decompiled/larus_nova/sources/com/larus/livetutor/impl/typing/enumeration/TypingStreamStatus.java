package com.larus.livetutor.impl.typing.enumeration;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/livetutor/impl/typing/enumeration/TypingStreamStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Initial", "Streaming", "Pause", "Stop", "Finish", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TypingStreamStatus extends Enum<TypingStreamStatus> {
    public static final TypingStreamStatus Finish = null;
    public static final TypingStreamStatus Initial = null;
    public static final TypingStreamStatus Pause = null;
    public static final TypingStreamStatus Stop = null;
    public static final TypingStreamStatus Streaming = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TypingStreamStatus[] f356603a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f356604b = null;

    public static EnumEntries<TypingStreamStatus> getEntries() {
        return f356604b;
    }

    static {
        TypingStreamStatus r100 = new TypingStreamStatus("Initial", 0);
        Initial = r100;
        TypingStreamStatus r101 = new TypingStreamStatus("Streaming", 1);
        Streaming = r101;
        TypingStreamStatus r102 = new TypingStreamStatus("Pause", 2);
        Pause = r102;
        TypingStreamStatus r103 = new TypingStreamStatus("Stop", 3);
        Stop = r103;
        TypingStreamStatus r104 = new TypingStreamStatus("Finish", 4);
        Finish = r104;
        TypingStreamStatus[] r105 = {r100, r101, r102, r103, r104};
        f356603a = r105;
        f356604b = EnumEntriesKt.enumEntries(r105);
    }

    public static TypingStreamStatus[] values() {
        return (TypingStreamStatus[]) f356603a.clone();
    }

    public static TypingStreamStatus valueOf(String r100) {
        return (TypingStreamStatus) a.a(TypingStreamStatus.class, r100);
    }

    public TypingStreamStatus(String r100, int r101) {
        super(r100, r101);
    }
}
