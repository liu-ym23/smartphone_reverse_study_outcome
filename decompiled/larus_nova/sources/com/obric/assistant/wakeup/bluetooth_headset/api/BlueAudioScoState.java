package com.obric.assistant.wakeup.bluetooth_headset.api;

import com.byted.cast.common.bean.State;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/assistant/wakeup/bluetooth_headset/api/BlueAudioScoState;", "", "<init>", "(Ljava/lang/String;I)V", "NA", "ERROR", "CONNECTED", "CONNECTING", State.DISCONNECTED, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BlueAudioScoState extends Enum<BlueAudioScoState> {
    public static final BlueAudioScoState CONNECTED = null;
    public static final BlueAudioScoState CONNECTING = null;
    public static final BlueAudioScoState DISCONNECTED = null;
    public static final BlueAudioScoState ERROR = null;
    public static final BlueAudioScoState NA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BlueAudioScoState[] f394388a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f394389b = null;

    public static EnumEntries<BlueAudioScoState> getEntries() {
        return f394389b;
    }

    static {
        BlueAudioScoState r100 = new BlueAudioScoState("NA", 0);
        NA = r100;
        BlueAudioScoState r101 = new BlueAudioScoState("ERROR", 1);
        ERROR = r101;
        BlueAudioScoState r102 = new BlueAudioScoState("CONNECTED", 2);
        CONNECTED = r102;
        BlueAudioScoState r103 = new BlueAudioScoState("CONNECTING", 3);
        CONNECTING = r103;
        BlueAudioScoState r104 = new BlueAudioScoState(State.DISCONNECTED, 4);
        DISCONNECTED = r104;
        BlueAudioScoState[] r105 = {r100, r101, r102, r103, r104};
        f394388a = r105;
        f394389b = EnumEntriesKt.enumEntries(r105);
    }

    public static BlueAudioScoState[] values() {
        return (BlueAudioScoState[]) f394388a.clone();
    }

    public static BlueAudioScoState valueOf(String r100) {
        return (BlueAudioScoState) a.a(BlueAudioScoState.class, r100);
    }

    public BlueAudioScoState(String r100, int r101) {
        super(r100, r101);
    }
}
