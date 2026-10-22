package com.larus.audio.call.utils;

import com.larus.media.MediaScene;
import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/audio/call/utils/AvBizType;", "", "bizId", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getBizId", "()Ljava/lang/String;", "VOICE_CALL", ServiceType.DORA, "INTERPRETER", "OBRIC_CONTINUOUS_TALK", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AvBizType extends Enum<AvBizType> {
    public static final AvBizType DORA = null;
    public static final AvBizType INTERPRETER = null;
    public static final AvBizType OBRIC_CONTINUOUS_TALK = null;
    public static final AvBizType VOICE_CALL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AvBizType[] f289654a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f289655b = null;
    private final String bizId;

    public static EnumEntries<AvBizType> getEntries() {
        return f289655b;
    }

    static {
        AvBizType r100 = new AvBizType("VOICE_CALL", 0, "voice_call");
        VOICE_CALL = r100;
        AvBizType r101 = new AvBizType(ServiceType.DORA, 1, MediaScene.DORA);
        DORA = r101;
        AvBizType r102 = new AvBizType("INTERPRETER", 2, "interpret");
        INTERPRETER = r102;
        AvBizType r103 = new AvBizType("OBRIC_CONTINUOUS_TALK", 3, "obric_continuous_talk");
        OBRIC_CONTINUOUS_TALK = r103;
        AvBizType[] r104 = {r100, r101, r102, r103};
        f289654a = r104;
        f289655b = EnumEntriesKt.enumEntries(r104);
    }

    public static AvBizType[] values() {
        return (AvBizType[]) f289654a.clone();
    }

    public final String getBizId() {
        return this.bizId;
    }

    public static AvBizType valueOf(String r100) {
        return (AvBizType) a.a(AvBizType.class, r100);
    }

    public AvBizType(String r100, int r101, String r102) {
        super(r100, r101);
        this.bizId = r102;
    }
}
