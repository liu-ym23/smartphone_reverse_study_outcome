package com.larus.im.service.audio.kmp;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/im/service/audio/kmp/FlowAVVideoBufferType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", "RawMemory", "GlTexture", "HardwareBuffer", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowAVVideoBufferType extends Enum<FlowAVVideoBufferType> {
    public static final FlowAVVideoBufferType GlTexture = null;
    public static final FlowAVVideoBufferType HardwareBuffer = null;
    public static final FlowAVVideoBufferType RawMemory = null;
    public static final FlowAVVideoBufferType Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowAVVideoBufferType[] f350768a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350769b = null;
    private final int value;

    public static EnumEntries<FlowAVVideoBufferType> getEntries() {
        return f350769b;
    }

    static {
        FlowAVVideoBufferType r100 = new FlowAVVideoBufferType("Unknown", 0, 0);
        Unknown = r100;
        FlowAVVideoBufferType r101 = new FlowAVVideoBufferType("RawMemory", 1, 1);
        RawMemory = r101;
        FlowAVVideoBufferType r102 = new FlowAVVideoBufferType("GlTexture", 2, 2);
        GlTexture = r102;
        FlowAVVideoBufferType r103 = new FlowAVVideoBufferType("HardwareBuffer", 3, 3);
        HardwareBuffer = r103;
        FlowAVVideoBufferType[] r104 = {r100, r101, r102, r103};
        f350768a = r104;
        f350769b = EnumEntriesKt.enumEntries(r104);
    }

    public static FlowAVVideoBufferType[] values() {
        return (FlowAVVideoBufferType[]) f350768a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static FlowAVVideoBufferType valueOf(String r100) {
        return (FlowAVVideoBufferType) a.a(FlowAVVideoBufferType.class, r100);
    }

    public FlowAVVideoBufferType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
