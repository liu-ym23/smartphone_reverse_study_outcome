package com.larus.im.internal.network.sse;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/im/internal/network/sse/SseStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "STATUS_DONE", "STATUS_INTERRUPTER", "STATUS_FAILED", "STATUS_CANCEL", "STATUS_CHUNK_REQ_TIMEOUT", "STATUS_CHUNK_INTERVAL_TIMEOUT", "flow-im-plugin_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SseStatus extends Enum<SseStatus> {
    public static final SseStatus STATUS_CANCEL = null;
    public static final SseStatus STATUS_CHUNK_INTERVAL_TIMEOUT = null;
    public static final SseStatus STATUS_CHUNK_REQ_TIMEOUT = null;
    public static final SseStatus STATUS_DONE = null;
    public static final SseStatus STATUS_FAILED = null;
    public static final SseStatus STATUS_INTERRUPTER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SseStatus[] f349518a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f349519b = null;
    private final int value;

    public static EnumEntries<SseStatus> getEntries() {
        return f349519b;
    }

    static {
        SseStatus r100 = new SseStatus("STATUS_DONE", 0, 0);
        STATUS_DONE = r100;
        SseStatus r101 = new SseStatus("STATUS_INTERRUPTER", 1, 1);
        STATUS_INTERRUPTER = r101;
        SseStatus r102 = new SseStatus("STATUS_FAILED", 2, 2);
        STATUS_FAILED = r102;
        SseStatus r103 = new SseStatus("STATUS_CANCEL", 3, 3);
        STATUS_CANCEL = r103;
        SseStatus r104 = new SseStatus("STATUS_CHUNK_REQ_TIMEOUT", 4, 4);
        STATUS_CHUNK_REQ_TIMEOUT = r104;
        SseStatus r105 = new SseStatus("STATUS_CHUNK_INTERVAL_TIMEOUT", 5, 5);
        STATUS_CHUNK_INTERVAL_TIMEOUT = r105;
        SseStatus[] r110 = {r100, r101, r102, r103, r104, r105};
        f349518a = r110;
        f349519b = EnumEntriesKt.enumEntries(r110);
    }

    public static SseStatus[] values() {
        return (SseStatus[]) f349518a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SseStatus valueOf(String r100) {
        return (SseStatus) r27.a.a(SseStatus.class, r100);
    }

    public SseStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
