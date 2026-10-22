package com.larus.media;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/media/AudioDeviceMode;", "", "<init>", "(Ljava/lang/String;I)V", "MEDIA", "COMMUNICATION", "OApp.flowSDK.baseSDK.common.avsdk-media"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AudioDeviceMode extends Enum<AudioDeviceMode> {
    public static final AudioDeviceMode COMMUNICATION = null;
    public static final AudioDeviceMode MEDIA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioDeviceMode[] f358884a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f358885b = null;

    public static EnumEntries<AudioDeviceMode> getEntries() {
        return f358885b;
    }

    static {
        AudioDeviceMode r100 = new AudioDeviceMode("MEDIA", 0);
        MEDIA = r100;
        AudioDeviceMode r101 = new AudioDeviceMode("COMMUNICATION", 1);
        COMMUNICATION = r101;
        AudioDeviceMode[] r102 = {r100, r101};
        f358884a = r102;
        f358885b = EnumEntriesKt.enumEntries(r102);
    }

    public static AudioDeviceMode[] values() {
        return (AudioDeviceMode[]) f358884a.clone();
    }

    public static AudioDeviceMode valueOf(String r100) {
        return (AudioDeviceMode) r27.a.a(AudioDeviceMode.class, r100);
    }

    public AudioDeviceMode(String r100, int r101) {
        super(r100, r101);
    }
}
