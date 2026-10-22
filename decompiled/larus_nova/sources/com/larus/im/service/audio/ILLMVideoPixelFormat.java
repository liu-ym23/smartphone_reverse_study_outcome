package com.larus.im.service.audio;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/im/service/audio/ILLMVideoPixelFormat;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "I420", "Companion", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ILLMVideoPixelFormat extends Enum<ILLMVideoPixelFormat> {
    public static final a Companion = null;
    public static final ILLMVideoPixelFormat I420 = null;
    public static final ILLMVideoPixelFormat UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ILLMVideoPixelFormat[] f350639a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350640b = null;
    private final int value;

    public static EnumEntries<ILLMVideoPixelFormat> getEntries() {
        return f350640b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.im.service.audio.ILLMVideoPixelFormat$a] */
    static {
        ILLMVideoPixelFormat r100 = new ILLMVideoPixelFormat("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        ILLMVideoPixelFormat r101 = new ILLMVideoPixelFormat("I420", 1, 1);
        I420 = r101;
        ILLMVideoPixelFormat[] r102 = {r100, r101};
        f350639a = r102;
        f350640b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static ILLMVideoPixelFormat[] values() {
        return (ILLMVideoPixelFormat[]) f350639a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ILLMVideoPixelFormat valueOf(String r100) {
        return (ILLMVideoPixelFormat) r27.a.a(ILLMVideoPixelFormat.class, r100);
    }

    public ILLMVideoPixelFormat(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
