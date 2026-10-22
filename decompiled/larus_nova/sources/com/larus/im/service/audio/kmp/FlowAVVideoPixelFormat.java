package com.larus.im.service.audio.kmp;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/im/service/audio/kmp/FlowAVVideoPixelFormat;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", "I420", "Texture2D", "TextureOes", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowAVVideoPixelFormat extends Enum<FlowAVVideoPixelFormat> {
    public static final FlowAVVideoPixelFormat I420 = null;
    public static final FlowAVVideoPixelFormat Texture2D = null;
    public static final FlowAVVideoPixelFormat TextureOes = null;
    public static final FlowAVVideoPixelFormat Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowAVVideoPixelFormat[] f350770a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350771b = null;
    private final int value;

    public static EnumEntries<FlowAVVideoPixelFormat> getEntries() {
        return f350771b;
    }

    static {
        FlowAVVideoPixelFormat r100 = new FlowAVVideoPixelFormat("Unknown", 0, 0);
        Unknown = r100;
        FlowAVVideoPixelFormat r101 = new FlowAVVideoPixelFormat("I420", 1, 1);
        I420 = r101;
        FlowAVVideoPixelFormat r102 = new FlowAVVideoPixelFormat("Texture2D", 2, 10);
        Texture2D = r102;
        FlowAVVideoPixelFormat r103 = new FlowAVVideoPixelFormat("TextureOes", 3, 11);
        TextureOes = r103;
        FlowAVVideoPixelFormat[] r104 = {r100, r101, r102, r103};
        f350770a = r104;
        f350771b = EnumEntriesKt.enumEntries(r104);
    }

    public static FlowAVVideoPixelFormat[] values() {
        return (FlowAVVideoPixelFormat[]) f350770a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static FlowAVVideoPixelFormat valueOf(String r100) {
        return (FlowAVVideoPixelFormat) a.a(FlowAVVideoPixelFormat.class, r100);
    }

    public FlowAVVideoPixelFormat(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
