package com.larus.avlink.dora;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/avlink/dora/DoraMode;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DORA_CALL", "DORA_RADIO_SINGLE_TURN", "DORA_RADIO_MULTI_TURN", "dora_avlink_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraMode extends Enum<DoraMode> {
    public static final DoraMode DORA_CALL = null;
    public static final DoraMode DORA_RADIO_MULTI_TURN = null;
    public static final DoraMode DORA_RADIO_SINGLE_TURN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraMode[] f291754a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f291755b = null;
    private final String value;

    public static EnumEntries<DoraMode> getEntries() {
        return f291755b;
    }

    static {
        DoraMode r100 = new DoraMode("DORA_CALL", 0, "dora_call");
        DORA_CALL = r100;
        DoraMode r101 = new DoraMode("DORA_RADIO_SINGLE_TURN", 1, "radio_single_turn_conversation");
        DORA_RADIO_SINGLE_TURN = r101;
        DoraMode r102 = new DoraMode("DORA_RADIO_MULTI_TURN", 2, "radio_multi_turn_conversation");
        DORA_RADIO_MULTI_TURN = r102;
        DoraMode[] r103 = {r100, r101, r102};
        f291754a = r103;
        f291755b = EnumEntriesKt.enumEntries(r103);
    }

    public static DoraMode[] values() {
        return (DoraMode[]) f291754a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static DoraMode valueOf(String r100) {
        return (DoraMode) a.a(DoraMode.class, r100);
    }

    public DoraMode(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
