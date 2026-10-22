package com.larus.media;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/media/AudioOutputRoutePolicy;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "PREFER_SPEAKER_WHEN_NO_EXTERNAL_DEVICE", "OApp.flowSDK.baseSDK.common.avsdk-media"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AudioOutputRoutePolicy extends Enum<AudioOutputRoutePolicy> {
    public static final AudioOutputRoutePolicy DEFAULT = null;
    public static final AudioOutputRoutePolicy PREFER_SPEAKER_WHEN_NO_EXTERNAL_DEVICE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioOutputRoutePolicy[] f358889a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f358890b = null;

    public static EnumEntries<AudioOutputRoutePolicy> getEntries() {
        return f358890b;
    }

    static {
        AudioOutputRoutePolicy r100 = new AudioOutputRoutePolicy("DEFAULT", 0);
        DEFAULT = r100;
        AudioOutputRoutePolicy r101 = new AudioOutputRoutePolicy("PREFER_SPEAKER_WHEN_NO_EXTERNAL_DEVICE", 1);
        PREFER_SPEAKER_WHEN_NO_EXTERNAL_DEVICE = r101;
        AudioOutputRoutePolicy[] r102 = {r100, r101};
        f358889a = r102;
        f358890b = EnumEntriesKt.enumEntries(r102);
    }

    public static AudioOutputRoutePolicy[] values() {
        return (AudioOutputRoutePolicy[]) f358889a.clone();
    }

    public static AudioOutputRoutePolicy valueOf(String r100) {
        return (AudioOutputRoutePolicy) r27.a.a(AudioOutputRoutePolicy.class, r100);
    }

    public AudioOutputRoutePolicy(String r100, int r101) {
        super(r100, r101);
    }
}
