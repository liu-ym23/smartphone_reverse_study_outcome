package com.obric.aiagent.assistant.idl.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/ObricStateConst$AudioPlayType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "PLAY_STATE_STOPPED", "PLAY_STATE_PREPARE", "PLAY_STATE_PAUSED", "PLAY_STATE_PLAYING", "PLAY_STATE_FAIL", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricStateConst$AudioPlayType extends Enum<ObricStateConst$AudioPlayType> {
    public static final ObricStateConst$AudioPlayType PLAY_STATE_FAIL = null;
    public static final ObricStateConst$AudioPlayType PLAY_STATE_PAUSED = null;
    public static final ObricStateConst$AudioPlayType PLAY_STATE_PLAYING = null;
    public static final ObricStateConst$AudioPlayType PLAY_STATE_PREPARE = null;
    public static final ObricStateConst$AudioPlayType PLAY_STATE_STOPPED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ObricStateConst$AudioPlayType[] f384507a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f384508b = null;
    private final int value;

    public static EnumEntries<ObricStateConst$AudioPlayType> getEntries() {
        return f384508b;
    }

    static {
        ObricStateConst$AudioPlayType r100 = new ObricStateConst$AudioPlayType("PLAY_STATE_STOPPED", 0, 1);
        PLAY_STATE_STOPPED = r100;
        ObricStateConst$AudioPlayType r101 = new ObricStateConst$AudioPlayType("PLAY_STATE_PREPARE", 1, 2);
        PLAY_STATE_PREPARE = r101;
        ObricStateConst$AudioPlayType r102 = new ObricStateConst$AudioPlayType("PLAY_STATE_PAUSED", 2, 3);
        PLAY_STATE_PAUSED = r102;
        ObricStateConst$AudioPlayType r103 = new ObricStateConst$AudioPlayType("PLAY_STATE_PLAYING", 3, 4);
        PLAY_STATE_PLAYING = r103;
        ObricStateConst$AudioPlayType r104 = new ObricStateConst$AudioPlayType("PLAY_STATE_FAIL", 4, 5);
        PLAY_STATE_FAIL = r104;
        ObricStateConst$AudioPlayType[] r110 = {r100, r101, r102, r103, r104};
        f384507a = r110;
        f384508b = EnumEntriesKt.enumEntries(r110);
    }

    public static ObricStateConst$AudioPlayType[] values() {
        return (ObricStateConst$AudioPlayType[]) f384507a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ObricStateConst$AudioPlayType valueOf(String r100) {
        return (ObricStateConst$AudioPlayType) a.a(ObricStateConst$AudioPlayType.class, r100);
    }

    public ObricStateConst$AudioPlayType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
