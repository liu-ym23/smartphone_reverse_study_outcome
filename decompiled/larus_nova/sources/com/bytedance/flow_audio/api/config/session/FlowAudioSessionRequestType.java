package com.bytedance.flow_audio.api.config.session;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/flow_audio/api/config/session/FlowAudioSessionRequestType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", "ToModify", "MessageASR", "MessageTTS", "BidirectionalTTS", "Companion", "flow_audio_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowAudioSessionRequestType extends Enum<FlowAudioSessionRequestType> {
    public static final FlowAudioSessionRequestType BidirectionalTTS = null;
    public static final a Companion = null;
    public static final FlowAudioSessionRequestType MessageASR = null;
    public static final FlowAudioSessionRequestType MessageTTS = null;
    public static final FlowAudioSessionRequestType ToModify = null;
    public static final FlowAudioSessionRequestType Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, FlowAudioSessionRequestType> f243698a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ FlowAudioSessionRequestType[] f243699b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f243700c = null;
    private final int value;

    public static EnumEntries<FlowAudioSessionRequestType> getEntries() {
        return f243700c;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.flow_audio.api.config.session.FlowAudioSessionRequestType$a] */
    static {
        int r100 = 0;
        FlowAudioSessionRequestType r101 = new FlowAudioSessionRequestType("Unknown", 0, -1);
        Unknown = r101;
        FlowAudioSessionRequestType r102 = new FlowAudioSessionRequestType("ToModify", 1, 0);
        ToModify = r102;
        FlowAudioSessionRequestType r103 = new FlowAudioSessionRequestType("MessageASR", 2, 3);
        MessageASR = r103;
        FlowAudioSessionRequestType r104 = new FlowAudioSessionRequestType("MessageTTS", 3, 4);
        MessageTTS = r104;
        FlowAudioSessionRequestType r105 = new FlowAudioSessionRequestType("BidirectionalTTS", 4, 5);
        BidirectionalTTS = r105;
        FlowAudioSessionRequestType[] r110 = {r101, r102, r103, r104, r105};
        f243699b = r110;
        f243700c = EnumEntriesKt.enumEntries(r110);
        Companion = new a();
        FlowAudioSessionRequestType[] r106 = values();
        LinkedHashMap r107 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r106.length), 16));
        int r108 = r106.length;
    L3:
        if (r100 >= r108) goto L5;
        FlowAudioSessionRequestType r109 = r106[r100];
        r107.put(Integer.valueOf(r109.value), r109);
        r100 = r100 + 1;
        goto L3
    L5:
        f243698a = r107;
    }

    public static FlowAudioSessionRequestType[] values() {
        return (FlowAudioSessionRequestType[]) f243699b.clone();
    }

    public static final /* synthetic */ Map access$getMap$cp() {
        return f243698a;
    }

    public final int getValue() {
        return this.value;
    }

    public static FlowAudioSessionRequestType valueOf(String r100) {
        return (FlowAudioSessionRequestType) r27.a.a(FlowAudioSessionRequestType.class, r100);
    }

    public FlowAudioSessionRequestType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
