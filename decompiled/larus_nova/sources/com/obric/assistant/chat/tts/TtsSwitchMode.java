package com.obric.assistant.chat.tts;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/chat/tts/TtsSwitchMode;", "", "index", "", "<init>", "(Ljava/lang/String;II)V", "getIndex", "()I", "InitMode", "BuildInMicMode", "BluetoothMicMode", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TtsSwitchMode extends Enum<TtsSwitchMode> {
    public static final TtsSwitchMode BluetoothMicMode = null;
    public static final TtsSwitchMode BuildInMicMode = null;
    public static final TtsSwitchMode InitMode = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TtsSwitchMode[] f386982a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f386983b = null;
    private final int index;

    public static EnumEntries<TtsSwitchMode> getEntries() {
        return f386983b;
    }

    static {
        TtsSwitchMode r100 = new TtsSwitchMode("InitMode", 0, 0);
        InitMode = r100;
        TtsSwitchMode r101 = new TtsSwitchMode("BuildInMicMode", 1, 1);
        BuildInMicMode = r101;
        TtsSwitchMode r102 = new TtsSwitchMode("BluetoothMicMode", 2, 2);
        BluetoothMicMode = r102;
        TtsSwitchMode[] r103 = {r100, r101, r102};
        f386982a = r103;
        f386983b = EnumEntriesKt.enumEntries(r103);
    }

    public static TtsSwitchMode[] values() {
        return (TtsSwitchMode[]) f386982a.clone();
    }

    public final int getIndex() {
        return this.index;
    }

    public static TtsSwitchMode valueOf(String r100) {
        return (TtsSwitchMode) a.a(TtsSwitchMode.class, r100);
    }

    public TtsSwitchMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.index = r102;
    }
}
