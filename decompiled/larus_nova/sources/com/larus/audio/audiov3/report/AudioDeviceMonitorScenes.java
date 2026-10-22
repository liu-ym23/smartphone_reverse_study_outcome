package com.larus.audio.audiov3.report;

import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/audio/audiov3/report/AudioDeviceMonitorScenes;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ASR", "TTS", "ENTER_CALL", OpenNetMethod.CONNECT, "SWITCH", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AudioDeviceMonitorScenes extends Enum<AudioDeviceMonitorScenes> {
    public static final AudioDeviceMonitorScenes ASR = null;
    public static final AudioDeviceMonitorScenes CONNECT = null;
    public static final AudioDeviceMonitorScenes ENTER_CALL = null;
    public static final AudioDeviceMonitorScenes SWITCH = null;
    public static final AudioDeviceMonitorScenes TTS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioDeviceMonitorScenes[] f288518a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f288519b = null;
    private final String value;

    public static EnumEntries<AudioDeviceMonitorScenes> getEntries() {
        return f288519b;
    }

    static {
        AudioDeviceMonitorScenes r100 = new AudioDeviceMonitorScenes("ASR", 0, "asr");
        ASR = r100;
        AudioDeviceMonitorScenes r101 = new AudioDeviceMonitorScenes("TTS", 1, "tts");
        TTS = r101;
        AudioDeviceMonitorScenes r102 = new AudioDeviceMonitorScenes("ENTER_CALL", 2, "enter_call");
        ENTER_CALL = r102;
        AudioDeviceMonitorScenes r103 = new AudioDeviceMonitorScenes(OpenNetMethod.CONNECT, 3, "connect");
        CONNECT = r103;
        AudioDeviceMonitorScenes r104 = new AudioDeviceMonitorScenes("SWITCH", 4, "switch");
        SWITCH = r104;
        AudioDeviceMonitorScenes[] r105 = {r100, r101, r102, r103, r104};
        f288518a = r105;
        f288519b = EnumEntriesKt.enumEntries(r105);
    }

    public static AudioDeviceMonitorScenes[] values() {
        return (AudioDeviceMonitorScenes[]) f288518a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static AudioDeviceMonitorScenes valueOf(String r100) {
        return (AudioDeviceMonitorScenes) a.a(AudioDeviceMonitorScenes.class, r100);
    }

    public AudioDeviceMonitorScenes(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
