package com.larus.audio.audiov3.config;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/audio/audiov3/config/BusinessTypeEnum;", "", "<init>", "(Ljava/lang/String;I)V", "ASR", "TTS_BY_MSG_ID", "TTS_BY_TEXT", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BusinessTypeEnum extends Enum<BusinessTypeEnum> {
    public static final BusinessTypeEnum ASR = null;
    public static final BusinessTypeEnum TTS_BY_MSG_ID = null;
    public static final BusinessTypeEnum TTS_BY_TEXT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BusinessTypeEnum[] f288508a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f288509b = null;

    public static EnumEntries<BusinessTypeEnum> getEntries() {
        return f288509b;
    }

    static {
        BusinessTypeEnum r100 = new BusinessTypeEnum("ASR", 0);
        ASR = r100;
        BusinessTypeEnum r101 = new BusinessTypeEnum("TTS_BY_MSG_ID", 1);
        TTS_BY_MSG_ID = r101;
        BusinessTypeEnum r102 = new BusinessTypeEnum("TTS_BY_TEXT", 2);
        TTS_BY_TEXT = r102;
        BusinessTypeEnum[] r103 = {r100, r101, r102};
        f288508a = r103;
        f288509b = EnumEntriesKt.enumEntries(r103);
    }

    public static BusinessTypeEnum[] values() {
        return (BusinessTypeEnum[]) f288508a.clone();
    }

    public static BusinessTypeEnum valueOf(String r100) {
        return (BusinessTypeEnum) a.a(BusinessTypeEnum.class, r100);
    }

    public BusinessTypeEnum(String r100, int r101) {
        super(r100, r101);
    }
}
