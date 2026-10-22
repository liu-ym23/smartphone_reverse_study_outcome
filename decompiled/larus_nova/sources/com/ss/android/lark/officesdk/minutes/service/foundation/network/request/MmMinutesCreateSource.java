package com.ss.android.lark.officesdk.minutes.service.foundation.network.request;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/request/MmMinutesCreateSource;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Default", "SoundCoreHardware", "SoundCoreRecordWithSync", "DoubaoRecorder", "DoubaoWearableGlass", "DoubaoWearableHear", "LibertyHeadset", "Simultaneous", "LibertyHeadsetCase", "KnowledgeAi", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmMinutesCreateSource extends Enum<MmMinutesCreateSource> {
    public static final MmMinutesCreateSource Default = null;
    public static final MmMinutesCreateSource DoubaoRecorder = null;
    public static final MmMinutesCreateSource DoubaoWearableGlass = null;
    public static final MmMinutesCreateSource DoubaoWearableHear = null;
    public static final MmMinutesCreateSource KnowledgeAi = null;
    public static final MmMinutesCreateSource LibertyHeadset = null;
    public static final MmMinutesCreateSource LibertyHeadsetCase = null;
    public static final MmMinutesCreateSource Simultaneous = null;
    public static final MmMinutesCreateSource SoundCoreHardware = null;
    public static final MmMinutesCreateSource SoundCoreRecordWithSync = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmMinutesCreateSource[] f433967a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433968b = null;
    private final int value;

    public static EnumEntries<MmMinutesCreateSource> getEntries() {
        return f433968b;
    }

    static {
        MmMinutesCreateSource r100 = new MmMinutesCreateSource("Default", 0, 0);
        Default = r100;
        MmMinutesCreateSource r101 = new MmMinutesCreateSource("SoundCoreHardware", 1, 1);
        SoundCoreHardware = r101;
        MmMinutesCreateSource r102 = new MmMinutesCreateSource("SoundCoreRecordWithSync", 2, 2);
        SoundCoreRecordWithSync = r102;
        MmMinutesCreateSource r103 = new MmMinutesCreateSource("DoubaoRecorder", 3, 3);
        DoubaoRecorder = r103;
        MmMinutesCreateSource r104 = new MmMinutesCreateSource("DoubaoWearableGlass", 4, 4);
        DoubaoWearableGlass = r104;
        MmMinutesCreateSource r105 = new MmMinutesCreateSource("DoubaoWearableHear", 5, 5);
        DoubaoWearableHear = r105;
        MmMinutesCreateSource r110 = new MmMinutesCreateSource("LibertyHeadset", 6, 6);
        LibertyHeadset = r110;
        MmMinutesCreateSource r111 = new MmMinutesCreateSource("Simultaneous", 7, 7);
        Simultaneous = r111;
        MmMinutesCreateSource r112 = new MmMinutesCreateSource("LibertyHeadsetCase", 8, 9);
        LibertyHeadsetCase = r112;
        MmMinutesCreateSource r113 = new MmMinutesCreateSource("KnowledgeAi", 9, 1001);
        KnowledgeAi = r113;
        MmMinutesCreateSource[] r106 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        f433967a = r106;
        f433968b = EnumEntriesKt.enumEntries(r106);
    }

    public static MmMinutesCreateSource[] values() {
        return (MmMinutesCreateSource[]) f433967a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MmMinutesCreateSource valueOf(String r100) {
        return (MmMinutesCreateSource) a.a(MmMinutesCreateSource.class, r100);
    }

    public MmMinutesCreateSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
