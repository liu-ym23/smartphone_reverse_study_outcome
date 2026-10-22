package com.larus.avlink.e.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/avlink/e/model/VisionIntentionSource;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "KWS", "ASR", "LLM", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VisionIntentionSource extends Enum<VisionIntentionSource> {
    public static final VisionIntentionSource ASR = null;
    public static final VisionIntentionSource KWS = null;
    public static final VisionIntentionSource LLM = null;
    public static final VisionIntentionSource UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VisionIntentionSource[] f291826a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f291827b = null;
    private final int value;

    public static EnumEntries<VisionIntentionSource> getEntries() {
        return f291827b;
    }

    static {
        VisionIntentionSource r100 = new VisionIntentionSource("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        VisionIntentionSource r101 = new VisionIntentionSource("KWS", 1, 1);
        KWS = r101;
        VisionIntentionSource r102 = new VisionIntentionSource("ASR", 2, 2);
        ASR = r102;
        VisionIntentionSource r103 = new VisionIntentionSource("LLM", 3, 3);
        LLM = r103;
        VisionIntentionSource[] r104 = {r100, r101, r102, r103};
        f291826a = r104;
        f291827b = EnumEntriesKt.enumEntries(r104);
    }

    public static VisionIntentionSource[] values() {
        return (VisionIntentionSource[]) f291826a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static VisionIntentionSource valueOf(String r100) {
        return (VisionIntentionSource) a.a(VisionIntentionSource.class, r100);
    }

    public VisionIntentionSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
