package com.larus.media;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/media/AudioInputRoutePolicy;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "PREFER_BLUETOOTH_WHEN_AVAILABLE", "OApp.flowSDK.baseSDK.common.avsdk-media"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AudioInputRoutePolicy extends Enum<AudioInputRoutePolicy> {
    public static final AudioInputRoutePolicy DEFAULT = null;
    public static final AudioInputRoutePolicy PREFER_BLUETOOTH_WHEN_AVAILABLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioInputRoutePolicy[] f358887a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f358888b = null;

    public static EnumEntries<AudioInputRoutePolicy> getEntries() {
        return f358888b;
    }

    static {
        AudioInputRoutePolicy r100 = new AudioInputRoutePolicy("DEFAULT", 0);
        DEFAULT = r100;
        AudioInputRoutePolicy r101 = new AudioInputRoutePolicy("PREFER_BLUETOOTH_WHEN_AVAILABLE", 1);
        PREFER_BLUETOOTH_WHEN_AVAILABLE = r101;
        AudioInputRoutePolicy[] r102 = {r100, r101};
        f358887a = r102;
        f358888b = EnumEntriesKt.enumEntries(r102);
    }

    public static AudioInputRoutePolicy[] values() {
        return (AudioInputRoutePolicy[]) f358887a.clone();
    }

    public static AudioInputRoutePolicy valueOf(String r100) {
        return (AudioInputRoutePolicy) r27.a.a(AudioInputRoutePolicy.class, r100);
    }

    public AudioInputRoutePolicy(String r100, int r101) {
        super(r100, r101);
    }
}
