package com.mammon.speechaudiosdk.kmp.type;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/mammon/speechaudiosdk/kmp/type/SpeechAudioNetConnectionStateType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ConnectionStateConnectUnknown", "ConnectionStateConnecting", "ConnectionStateDisconnecting", "ConnectionStateConnectFailed", "ConnectionStateConnectClosed", "ConnectionStateConnected", "Companion", "speech_audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SpeechAudioNetConnectionStateType extends Enum<SpeechAudioNetConnectionStateType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SpeechAudioNetConnectionStateType[] $VALUES = null;
    public static final Companion Companion = null;
    public static final SpeechAudioNetConnectionStateType ConnectionStateConnectClosed = null;
    public static final SpeechAudioNetConnectionStateType ConnectionStateConnectFailed = null;
    public static final SpeechAudioNetConnectionStateType ConnectionStateConnectUnknown = null;
    public static final SpeechAudioNetConnectionStateType ConnectionStateConnected = null;
    public static final SpeechAudioNetConnectionStateType ConnectionStateConnecting = null;
    public static final SpeechAudioNetConnectionStateType ConnectionStateDisconnecting = null;
    private static final Map<Integer, SpeechAudioNetConnectionStateType> map = null;
    private final int value;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/mammon/speechaudiosdk/kmp/type/SpeechAudioNetConnectionStateType$Companion;", "", "<init>", "()V", "map", "", "", "Lcom/mammon/speechaudiosdk/kmp/type/SpeechAudioNetConnectionStateType;", "fromInt", "value", "speech_audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final SpeechAudioNetConnectionStateType fromInt(int r100) {
            SpeechAudioNetConnectionStateType r101 = (SpeechAudioNetConnectionStateType) SpeechAudioNetConnectionStateType.access$getMap$cp().get(Integer.valueOf(r100));
            if (r101 == null) goto L5;
            return r101;
        L5:
            return SpeechAudioNetConnectionStateType.ConnectionStateConnectUnknown;
        }
    }

    private static final /* synthetic */ SpeechAudioNetConnectionStateType[] $values() {
        return new SpeechAudioNetConnectionStateType[]{ConnectionStateConnectUnknown, ConnectionStateConnecting, ConnectionStateDisconnecting, ConnectionStateConnectFailed, ConnectionStateConnectClosed, ConnectionStateConnected};
    }

    public static EnumEntries<SpeechAudioNetConnectionStateType> getEntries() {
        return $ENTRIES;
    }

    static {
        int r100 = 0;
        ConnectionStateConnectUnknown = new SpeechAudioNetConnectionStateType("ConnectionStateConnectUnknown", 0, -1);
        ConnectionStateConnecting = new SpeechAudioNetConnectionStateType("ConnectionStateConnecting", 1, 0);
        ConnectionStateDisconnecting = new SpeechAudioNetConnectionStateType("ConnectionStateDisconnecting", 2, 1);
        ConnectionStateConnectFailed = new SpeechAudioNetConnectionStateType("ConnectionStateConnectFailed", 3, 2);
        ConnectionStateConnectClosed = new SpeechAudioNetConnectionStateType("ConnectionStateConnectClosed", 4, 3);
        ConnectionStateConnected = new SpeechAudioNetConnectionStateType("ConnectionStateConnected", 5, 4);
        SpeechAudioNetConnectionStateType[] r101 = $values();
        $VALUES = r101;
        $ENTRIES = EnumEntriesKt.enumEntries(r101);
        Companion = new Companion(null);
        SpeechAudioNetConnectionStateType[] r102 = values();
        LinkedHashMap r103 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r102.length), 16));
        int r104 = r102.length;
    L3:
        if (r100 >= r104) goto L5;
        SpeechAudioNetConnectionStateType r105 = r102[r100];
        r103.put(Integer.valueOf(r105.value), r105);
        r100 = r100 + 1;
        goto L3
    L5:
        map = r103;
    }

    public static SpeechAudioNetConnectionStateType[] values() {
        return (SpeechAudioNetConnectionStateType[]) $VALUES.clone();
    }

    public static final /* synthetic */ Map access$getMap$cp() {
        return map;
    }

    public final int getValue() {
        return this.value;
    }

    public static SpeechAudioNetConnectionStateType valueOf(String r100) {
        return (SpeechAudioNetConnectionStateType) a.a(SpeechAudioNetConnectionStateType.class, r100);
    }

    private SpeechAudioNetConnectionStateType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
