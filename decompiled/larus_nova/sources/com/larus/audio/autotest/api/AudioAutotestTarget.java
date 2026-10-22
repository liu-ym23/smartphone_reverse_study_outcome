package com.larus.audio.autotest.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/audio/autotest/api/AudioAutotestTarget;", "", "<init>", "(Ljava/lang/String;I)V", "Android", "Ohos", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AudioAutotestTarget extends Enum<AudioAutotestTarget> {
    public static final AudioAutotestTarget Android = null;
    public static final AudioAutotestTarget Ohos = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioAutotestTarget[] f288706a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f288707b = null;

    public static EnumEntries<AudioAutotestTarget> getEntries() {
        return f288707b;
    }

    static {
        AudioAutotestTarget r100 = new AudioAutotestTarget("Android", 0);
        Android = r100;
        AudioAutotestTarget r101 = new AudioAutotestTarget("Ohos", 1);
        Ohos = r101;
        AudioAutotestTarget[] r102 = {r100, r101};
        f288706a = r102;
        f288707b = EnumEntriesKt.enumEntries(r102);
    }

    public static AudioAutotestTarget[] values() {
        return (AudioAutotestTarget[]) f288706a.clone();
    }

    public static AudioAutotestTarget valueOf(String r100) {
        return (AudioAutotestTarget) a.a(AudioAutotestTarget.class, r100);
    }

    public AudioAutotestTarget(String r100, int r101) {
        super(r100, r101);
    }
}
