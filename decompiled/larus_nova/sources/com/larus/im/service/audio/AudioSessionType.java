package com.larus.im.service.audio;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/im/service/audio/AudioSessionType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "SAMI", "QUIC", "RTC", "MMT", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AudioSessionType extends Enum<AudioSessionType> {
    public static final AudioSessionType MMT = null;
    public static final AudioSessionType QUIC = null;
    public static final AudioSessionType RTC = null;
    public static final AudioSessionType SAMI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioSessionType[] f350627a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350628b = null;
    private final int type;

    public static EnumEntries<AudioSessionType> getEntries() {
        return f350628b;
    }

    static {
        AudioSessionType r100 = new AudioSessionType("SAMI", 0, -1);
        SAMI = r100;
        AudioSessionType r101 = new AudioSessionType("QUIC", 1, 0);
        QUIC = r101;
        AudioSessionType r102 = new AudioSessionType("RTC", 2, 1);
        RTC = r102;
        AudioSessionType r103 = new AudioSessionType("MMT", 3, 2);
        MMT = r103;
        AudioSessionType[] r104 = {r100, r101, r102, r103};
        f350627a = r104;
        f350628b = EnumEntriesKt.enumEntries(r104);
    }

    public static AudioSessionType[] values() {
        return (AudioSessionType[]) f350627a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static AudioSessionType valueOf(String r100) {
        return (AudioSessionType) r27.a.a(AudioSessionType.class, r100);
    }

    public AudioSessionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
