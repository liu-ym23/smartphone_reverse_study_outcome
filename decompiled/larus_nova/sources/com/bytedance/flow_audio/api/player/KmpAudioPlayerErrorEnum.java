package com.bytedance.flow_audio.api.player;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/flow_audio/api/player/KmpAudioPlayerErrorEnum;", "", "code", "", "massage", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getMassage", "()Ljava/lang/String;", "START_ERROR", "RELEASE_ERROR", "CONFIG_ERROR", "WRITE_ERROR", "INIT_ERROR", "UNKNOWN_ERROR", "flow_audio_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum KmpAudioPlayerErrorEnum extends Enum<KmpAudioPlayerErrorEnum> {
    public static final KmpAudioPlayerErrorEnum CONFIG_ERROR = null;
    public static final KmpAudioPlayerErrorEnum INIT_ERROR = null;
    public static final KmpAudioPlayerErrorEnum RELEASE_ERROR = null;
    public static final KmpAudioPlayerErrorEnum START_ERROR = null;
    public static final KmpAudioPlayerErrorEnum UNKNOWN_ERROR = null;
    public static final KmpAudioPlayerErrorEnum WRITE_ERROR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KmpAudioPlayerErrorEnum[] f243720a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f243721b = null;
    private final int code;
    private final String massage;

    public static EnumEntries<KmpAudioPlayerErrorEnum> getEntries() {
        return f243721b;
    }

    static {
        KmpAudioPlayerErrorEnum r100 = new KmpAudioPlayerErrorEnum("START_ERROR", 0, 501, "audio player start error");
        START_ERROR = r100;
        KmpAudioPlayerErrorEnum r101 = new KmpAudioPlayerErrorEnum("RELEASE_ERROR", 1, 502, "audio player release error");
        RELEASE_ERROR = r101;
        KmpAudioPlayerErrorEnum r102 = new KmpAudioPlayerErrorEnum("CONFIG_ERROR", 2, 503, "audio player config error");
        CONFIG_ERROR = r102;
        KmpAudioPlayerErrorEnum r103 = new KmpAudioPlayerErrorEnum("WRITE_ERROR", 3, 504, "audio player write error");
        WRITE_ERROR = r103;
        KmpAudioPlayerErrorEnum r104 = new KmpAudioPlayerErrorEnum("INIT_ERROR", 4, 505, "audio player init error");
        INIT_ERROR = r104;
        KmpAudioPlayerErrorEnum r105 = new KmpAudioPlayerErrorEnum("UNKNOWN_ERROR", 5, 10000, "audio player unknown error");
        UNKNOWN_ERROR = r105;
        KmpAudioPlayerErrorEnum[] r106 = {r100, r101, r102, r103, r104, r105};
        f243720a = r106;
        f243721b = EnumEntriesKt.enumEntries(r106);
    }

    public static KmpAudioPlayerErrorEnum[] values() {
        return (KmpAudioPlayerErrorEnum[]) f243720a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMassage() {
        return this.massage;
    }

    public static KmpAudioPlayerErrorEnum valueOf(String r100) {
        return (KmpAudioPlayerErrorEnum) a.a(KmpAudioPlayerErrorEnum.class, r100);
    }

    public KmpAudioPlayerErrorEnum(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.massage = r103;
    }
}
