package com.larus.im.internal.trace.manager.definition;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/im/internal/trace/manager/definition/AVTraceModalType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "AUDIO", "VIDEO", "SCREEN_SHARE", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AVTraceModalType extends Enum<AVTraceModalType> {
    public static final AVTraceModalType AUDIO = null;
    public static final AVTraceModalType SCREEN_SHARE = null;
    public static final AVTraceModalType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AVTraceModalType[] f350153a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350154b = null;
    private final int value;

    public static EnumEntries<AVTraceModalType> getEntries() {
        return f350154b;
    }

    static {
        AVTraceModalType r100 = new AVTraceModalType("AUDIO", 0, 0);
        AUDIO = r100;
        AVTraceModalType r101 = new AVTraceModalType("VIDEO", 1, 1);
        VIDEO = r101;
        AVTraceModalType r102 = new AVTraceModalType("SCREEN_SHARE", 2, 2);
        SCREEN_SHARE = r102;
        AVTraceModalType[] r103 = {r100, r101, r102};
        f350153a = r103;
        f350154b = EnumEntriesKt.enumEntries(r103);
    }

    public static AVTraceModalType[] values() {
        return (AVTraceModalType[]) f350153a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static AVTraceModalType valueOf(String r100) {
        return (AVTraceModalType) a.a(AVTraceModalType.class, r100);
    }

    public AVTraceModalType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
