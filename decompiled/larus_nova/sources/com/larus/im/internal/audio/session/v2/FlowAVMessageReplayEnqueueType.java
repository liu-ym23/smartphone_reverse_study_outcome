package com.larus.im.internal.audio.session.v2;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/im/internal/audio/session/v2/FlowAVMessageReplayEnqueueType;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "EXCLUDE", "DEDUPLICATE", "OVERRIDE", "OApp.flowSDK.baseSDK.common.avsdk-flow-impl"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowAVMessageReplayEnqueueType extends Enum<FlowAVMessageReplayEnqueueType> {
    public static final FlowAVMessageReplayEnqueueType DEDUPLICATE = null;
    public static final FlowAVMessageReplayEnqueueType EXCLUDE = null;
    public static final FlowAVMessageReplayEnqueueType OVERRIDE = null;
    public static final FlowAVMessageReplayEnqueueType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowAVMessageReplayEnqueueType[] f347411a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f347412b = null;

    public static EnumEntries<FlowAVMessageReplayEnqueueType> getEntries() {
        return f347412b;
    }

    static {
        FlowAVMessageReplayEnqueueType r100 = new FlowAVMessageReplayEnqueueType("UNKNOWN", 0);
        UNKNOWN = r100;
        FlowAVMessageReplayEnqueueType r101 = new FlowAVMessageReplayEnqueueType("EXCLUDE", 1);
        EXCLUDE = r101;
        FlowAVMessageReplayEnqueueType r102 = new FlowAVMessageReplayEnqueueType("DEDUPLICATE", 2);
        DEDUPLICATE = r102;
        FlowAVMessageReplayEnqueueType r103 = new FlowAVMessageReplayEnqueueType("OVERRIDE", 3);
        OVERRIDE = r103;
        FlowAVMessageReplayEnqueueType[] r104 = {r100, r101, r102, r103};
        f347411a = r104;
        f347412b = EnumEntriesKt.enumEntries(r104);
    }

    public static FlowAVMessageReplayEnqueueType[] values() {
        return (FlowAVMessageReplayEnqueueType[]) f347411a.clone();
    }

    public static FlowAVMessageReplayEnqueueType valueOf(String r100) {
        return (FlowAVMessageReplayEnqueueType) r27.a.a(FlowAVMessageReplayEnqueueType.class, r100);
    }

    public FlowAVMessageReplayEnqueueType(String r100, int r101) {
        super(r100, r101);
    }
}
